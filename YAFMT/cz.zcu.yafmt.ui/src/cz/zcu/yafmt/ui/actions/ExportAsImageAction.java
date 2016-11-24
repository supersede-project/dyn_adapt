package cz.zcu.yafmt.ui.actions;

import java.io.File;

import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import cz.zcu.yafmt.ui.util.ImageExporter;

public abstract class ExportAsImageAction extends Action {

    public ExportAsImageAction() {
        setText("Export As Image");
    }

    protected abstract Control getControl();

    protected abstract IFigure getFigure();

    protected String getDefaultName() {
        return "image";
    }

    @Override
    public boolean isEnabled() {
        return (getControl() != null) && (getFigure() != null);
    }

    @Override
    public void run() {
        Control control = getControl();
        IFigure figure = getFigure();

        String defaultName = getDefaultName();
        if((defaultName == null) || defaultName.trim().isEmpty())
            defaultName = "image";

        FileDialog fileDialog = createFileDialog(control.getShell(), defaultName);
        String filePath = fileDialog.open();
        if(filePath == null)
            return;
        
        if((new File(filePath)).exists()) {
            if(!MessageDialog.openQuestion(control.getShell(), "Warning", "Override existing file?"))
                return;
        }
        
        ImageExporter.save(control, figure, filePath, getImageFormat(fileDialog, filePath));
    }

    private FileDialog createFileDialog(Shell shell, String defaultName) {
        FileDialog fileDialog = new FileDialog(shell, SWT.SAVE);
        fileDialog.setFilterExtensions(ImageExporter.FORMAT_EXTENSIONS);
        fileDialog.setFileName(defaultName);
        return fileDialog;
    }

    private int getImageFormat(FileDialog fileDialog, String filePath) {
        for(int i = 0; i < ImageExporter.FORMAT_EXTENSIONS.length; i++) {
            if(filePath.endsWith(ImageExporter.FORMAT_EXTENSIONS[i]))
                return ImageExporter.SUPPORTED_FORMATS[i];
        }

        int index = fileDialog.getFilterIndex();
        return (index > 0) ? ImageExporter.SUPPORTED_FORMATS[index] : ImageExporter.SUPPORTED_FORMATS[0];
    }

}
