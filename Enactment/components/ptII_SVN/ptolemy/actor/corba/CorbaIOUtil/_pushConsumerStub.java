package ptolemy.actor.corba.CorbaIOUtil;

/**
 * ptolemy/actor/corba/CorbaIOUtil/_pushConsumerStub.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.1"
 * from CorbaIO.idl
 * Wednesday, April 16, 2003 5:05:14 PM PDT
 */

/* A CORBA compatible interface for a push consumer.
 */
public class _pushConsumerStub extends org.omg.CORBA.portable.ObjectImpl
implements ptolemy.actor.corba.CorbaIOUtil.pushConsumer {
    /* this method is intended to be called remotely by a push publisher,
     * so that data can be delived over the network to a push consumer.
     */
    @Override
    public void push(org.omg.CORBA.Any data)
            throws ptolemy.actor.corba.CorbaIOUtil.CorbaIllegalActionException {
        org.omg.CORBA.portable.InputStream $in = null;

        try {
            org.omg.CORBA.portable.OutputStream $out = _request("push", true);
            $out.write_any(data);
            $in = _invoke($out);
        } catch (org.omg.CORBA.portable.ApplicationException $ex) {
            $in = $ex.getInputStream();

            String _id = $ex.getId();

            if (_id.equals("IDL:CorbaIOUtil/CorbaIllegalActionException:1.0")) {
                throw ptolemy.actor.corba.CorbaIOUtil.CorbaIllegalActionExceptionHelper
                .read($in);
            } else {
                throw new org.omg.CORBA.MARSHAL(_id);
            }
        } catch (org.omg.CORBA.portable.RemarshalException $rm) {
            push(data);
        } finally {
            _releaseReply($in);
        }
    } // push

    // Type-specific CORBA::Object operations
    private static String[] __ids = { "IDL:CorbaIOUtil/pushConsumer:1.0" };

    @Override
    public String[] _ids() {
        return __ids.clone();
    }

    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException {
        String str = s.readUTF();
        String[] args = null;
        java.util.Properties props = null;
        org.omg.CORBA.Object obj = org.omg.CORBA.ORB.init(args, props)
                .string_to_object(str);
        org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)
                ._get_delegate();
        _set_delegate(delegate);
    }

    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException {
        String[] args = null;
        java.util.Properties props = null;
        String str = org.omg.CORBA.ORB.init(args, props).object_to_string(this);
        s.writeUTF(str);
    }
} // class _pushConsumerStub
