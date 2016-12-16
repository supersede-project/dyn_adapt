package ptolemy.actor.corba.CorbaIOUtil;

/**
 * ptolemy/actor/corba/CorbaIOUtil/pushConsumerHolder.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.1"
 * from CorbaIO.idl
 * Wednesday, April 16, 2003 5:05:14 PM PDT
 */

/* A CORBA compatible interface for a push consumer.
 */
public final class pushConsumerHolder implements
org.omg.CORBA.portable.Streamable {
    public ptolemy.actor.corba.CorbaIOUtil.pushConsumer value = null;

    public pushConsumerHolder() {
    }

    public pushConsumerHolder(
            ptolemy.actor.corba.CorbaIOUtil.pushConsumer initialValue) {
        value = initialValue;
    }

    @Override
    public void _read(org.omg.CORBA.portable.InputStream i) {
        value = ptolemy.actor.corba.CorbaIOUtil.pushConsumerHelper.read(i);
    }

    @Override
    public void _write(org.omg.CORBA.portable.OutputStream o) {
        ptolemy.actor.corba.CorbaIOUtil.pushConsumerHelper.write(o, value);
    }

    @Override
    public org.omg.CORBA.TypeCode _type() {
        return ptolemy.actor.corba.CorbaIOUtil.pushConsumerHelper.type();
    }
}
