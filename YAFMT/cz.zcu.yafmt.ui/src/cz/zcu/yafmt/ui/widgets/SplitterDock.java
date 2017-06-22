package cz.zcu.yafmt.ui.widgets;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import cz.zcu.yafmt.ui.CommonUIPlugin;

public abstract class SplitterDock extends Composite {

    private static final int HEADER_HEIGHT = 26;
    private static final int DEFAULT_WIDTH = 200;
    private static final int COLLAPSED_WIDTH = 13;

    private Splitter splitter;
    private Control control;
    private Composite controlPanel;

    private ToolBar toolbar;
    private ToolItem collapseButton;
    private Composite title;
    private Label titleImage;
    private Label titleText;
    private String openToolTipText;
    private String collapseToolTipText;

    private boolean opened = true;
    private int size = DEFAULT_WIDTH;

    public SplitterDock(Splitter splitter, int style) {
        super(splitter, style);
        this.splitter = splitter;
        this.splitter.maintainSize(this);
    }
    
    // ====================================================================
    //  Control creation
    // ====================================================================

    public void buildControl() {
        setLayout(createGridLayout(1));
        createTopControl(this);

        controlPanel = new Composite(this, SWT.NONE);
        controlPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        control = createControl(controlPanel);
        control.setMenu(createContextMenu());

        refresh();
    }
    
    protected abstract Control createControl(Composite parent);

    protected void contributeToToolbar(ToolBar toolBar) {
    }

    protected void contributeToContextMenu(IMenuManager manager) {
    }
    
    private void createTopControl(Composite parent) {
        Composite header = createHeader(parent);
        createHeaderTitle(header);
        createHeaderToolbar(header);
    }

    private Composite createHeader(Composite parent) {
        GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
        gridData.heightHint = HEADER_HEIGHT;

        Composite header = new Composite(parent, SWT.NONE);
        header.setLayoutData(gridData);
        header.setLayout(createGridLayout(3));
        header.setBackgroundImage(CommonUIPlugin.getAccess().getImage("dock-header.png"));
        return header;
    }

    private void createHeaderTitle(Composite header) {
        title = new Composite(header, SWT.NONE);
        title.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
        title.setLayout(createGridLayout(2));
        titleImage = new Label(title, SWT.NONE);
        titleImage.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
        titleText = new Label(title, SWT.NONE);
        titleText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    }

    private void createHeaderToolbar(Composite header) {
        toolbar = new ToolBar(header, SWT.FLAT);
        toolbar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
        contributeToToolbar(toolbar);

        ToolBar collapseButonBar = new ToolBar(header, SWT.FLAT);
        collapseButonBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
        collapseButton = new ToolItem(collapseButonBar, SWT.NONE);
        collapseButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                switchState();
            }
        });
    }

    private Menu createContextMenu() {
        MenuManager manager = new MenuManager();
        manager.setRemoveAllWhenShown(true);
        manager.addMenuListener(new IMenuListener() {
            @Override
            public void menuAboutToShow(IMenuManager manager) {
                contributeToContextMenu(manager);
            }
        });
        return manager.createContextMenu(control);
    }

    private Layout createGridLayout(int numColumns) {
        GridLayout layout = new GridLayout(numColumns, false);
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        return layout;
    }
    
    // ====================================================================
    //  Properties
    // ====================================================================

    public void setName(String name) {
        titleText.setText(name);
    }

    public void setImage(Image image) {
        titleImage.setImage(image);
    }

    public void setOpenToolTipText(String openToolTipText) {
        this.openToolTipText = openToolTipText;
    }

    public void setCollapseToolTipText(String collapseToolTipText) {
        this.collapseToolTipText = collapseToolTipText;
    }

    private void switchState() {
        opened = !opened;
        refresh();
    }

    private void refresh() {
        if(opened) {
            collapseButton.setImage(CommonUIPlugin.getAccess().getImage("right.png"));
            collapseButton.setToolTipText(collapseToolTipText);
            splitter.setFixedSize(size);

        }
        else {
            size = splitter.getFixedSize();
            collapseButton.setImage(CommonUIPlugin.getAccess().getImage("left.png"));
            collapseButton.setToolTipText(openToolTipText);
            splitter.setFixedSize(COLLAPSED_WIDTH);
        }

        ((GridData) title.getLayoutData()).exclude = !opened;
        ((GridData) toolbar.getLayoutData()).exclude = !opened;
        ((GridData) controlPanel.getLayoutData()).exclude = !opened;
        title.setVisible(opened);
        controlPanel.setVisible(opened);

        splitter.setResizeEnabled(opened);
        splitter.layout();
    }

}
