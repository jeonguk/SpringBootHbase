package com.smmc.vyrl.domain;


import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;

import java.util.*;

/**
 * thrift
 */
public class Post implements org.apache.thrift.TBase<Post, Post._Fields>, java.io.Serializable, Cloneable {

    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Post");

    private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.STRING, (short)1);
    private static final org.apache.thrift.protocol.TField WRITER_FIELD_DESC = new org.apache.thrift.protocol.TField("writer", org.apache.thrift.protocol.TType.STRING, (short)2);
    private static final org.apache.thrift.protocol.TField TITLE_FIELD_DESC = new org.apache.thrift.protocol.TField("title", org.apache.thrift.protocol.TType.STRING, (short)3);
    private static final org.apache.thrift.protocol.TField CONTENT_FIELD_DESC = new org.apache.thrift.protocol.TField("content", org.apache.thrift.protocol.TType.STRING, (short)4);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
        schemes.put(StandardScheme.class, new PostStandardSchemeFactory());
        schemes.put(TupleScheme.class, new PostTupleSchemeFactory());
    }

    private String id;      // optional
    private String writer;  // optional
    private String title;   // optional
    private String content; // optional

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
        ID((short)1, "id"),
        WRITER((short)2, "writer"),
        TITLE((short)3, "title"),
        CONTENT((short)4, "content");

        private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

        static {
            for (_Fields field : EnumSet.allOf(_Fields.class)) {
                byName.put(field.getFieldName(), field);
            }
        }

        /**
         * Find the _Fields constant that matches fieldId, or null if its not found.
         */
        public static _Fields findByThriftId(int fieldId) {
            switch(fieldId) {
                case 1: // ID
                    return ID;
                case 2: // WRITER
                    return WRITER;
                case 3: // TITLE
                    return TITLE;
                case 4: // CONTENT
                    return CONTENT;
                default:
                    return null;
            }
        }

        /**
         * Find the _Fields constant that matches fieldId, throwing an exception
         * if it is not found.
         */
        public static _Fields findByThriftIdOrThrow(int fieldId) {
            _Fields fields = findByThriftId(fieldId);
            if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
            return fields;
        }

        /**
         * Find the _Fields constant that matches name, or null if its not found.
         */
        public static _Fields findByWriter(String writer) {
            return byName.get(writer);
        }

        private final short _thriftId;
        private final String _fieldName;

        _Fields(short thriftId, String fieldName) {
            _thriftId = thriftId;
            _fieldName = fieldName;
        }

        public short getThriftFieldId() {
            return _thriftId;
        }

        public String getFieldName() {
            return _fieldName;
        }
    }

    // isset id assignments
    private _Fields optionals[] = {_Fields.ID,_Fields.WRITER,_Fields.TITLE,_Fields.CONTENT};
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
        Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
        tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("firstName", org.apache.thrift.TFieldRequirementType.OPTIONAL,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
        tmpMap.put(_Fields.WRITER, new org.apache.thrift.meta_data.FieldMetaData("lastName", org.apache.thrift.TFieldRequirementType.OPTIONAL,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
        tmpMap.put(_Fields.TITLE, new org.apache.thrift.meta_data.FieldMetaData("email", org.apache.thrift.TFieldRequirementType.OPTIONAL,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
        tmpMap.put(_Fields.CONTENT, new org.apache.thrift.meta_data.FieldMetaData("address", org.apache.thrift.TFieldRequirementType.OPTIONAL,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
        metaDataMap = Collections.unmodifiableMap(tmpMap);
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Post.class, metaDataMap);
    }

    public Post() {
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public Post(Post other) {
        if (other.isSetId()) {
            this.id = other.id;
        }
        if (other.isSetWriter()) {
            this.writer = other.writer;
        }
        if (other.isSetTitle()) {
            this.title = other.title;
        }
        if (other.isSetContent()) {
            this.content = other.content;
        }
    }

    public Post deepCopy() {
        return new Post(this);
    }

    @Override
    public void clear() {
        this.id = null;
        this.writer = null;
        this.title = null;
        this.content = null;
    }

    public String getId() {
        return this.id;
    }

    public Post setId(String id) {
        this.id = id;
        return this;
    }

    public void unsetId() {
        this.id = null;
    }

    /** Returns true if field firstName is set (has been assigned a value) and false otherwise */
    public boolean isSetId() {
        return this.id != null;
    }

    public void setIdIsSet(boolean value) {
        if (!value) {
            this.id = null;
        }
    }

    public String getWriter() {
        return this.writer;
    }

    public Post setWriter(String writer) {
        this.writer = writer;
        return this;
    }

    public void unsetWriter() {
        this.writer = null;
    }

    /** Returns true if field lastName is set (has been assigned a value) and false otherwise */
    public boolean isSetWriter() {
        return this.writer != null;
    }

    public void setWriterIsSet(boolean value) {
        if (!value) {
            this.writer = null;
        }
    }

    public String getTitle() {
        return this.title;
    }

    public Post setTitle(String title) {
        this.title = title;
        return this;
    }

    public void unsetTitle() {
        this.title = null;
    }

    /** Returns true if field email is set (has been assigned a value) and false otherwise */
    public boolean isSetTitle() {
        return this.title != null;
    }

    public void setTitleIsSet(boolean value) {
        if (!value) {
            this.title = null;
        }
    }

    public String getContent() {
        return this.content;
    }

    public Post setContent(String content) {
        this.content = content;
        return this;
    }

    public void unsetContent() {
        this.content = null;
    }

    /** Returns true if field address is set (has been assigned a value) and false otherwise */
    public boolean isSetContent() {
        return this.content != null;
    }

    public void setContentIsSet(boolean value) {
        if (!value) {
            this.content = null;
        }
    }

    public void setFieldValue(_Fields field, Object value) {
        switch (field) {
            case ID:
                if (value == null) {
                    unsetId();
                } else {
                    setId((String)value);
                }
                break;

            case WRITER:
                if (value == null) {
                    unsetWriter();
                } else {
                    setWriter((String)value);
                }
                break;

            case TITLE:
                if (value == null) {
                    unsetTitle();
                } else {
                    setTitle((String)value);
                }
                break;

            case CONTENT:
                if (value == null) {
                    unsetContent();
                } else {
                    setContent((String)value);
                }
                break;

        }
    }

    public Object getFieldValue(_Fields field) {
        switch (field) {
            case ID:
                return getId();

            case WRITER:
                return getWriter();

            case TITLE:
                return getTitle();

            case CONTENT:
                return getContent();

        }
        throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
        if (field == null) {
            throw new IllegalArgumentException();
        }

        switch (field) {
            case ID:
                return isSetId();
            case WRITER:
                return isSetWriter();
            case TITLE:
                return isSetTitle();
            case CONTENT:
                return isSetContent();
        }
        throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
        if (that == null)
            return false;
        if (that instanceof Post)
            return this.equals((Post)that);
        return false;
    }

    public boolean equals(Post that) {
        if (that == null)
            return false;

        boolean this_present_id = true && this.isSetId();
        boolean that_present_id = true && that.isSetId();
        if (this_present_id || that_present_id) {
            if (!(this_present_id && that_present_id))
                return false;
            if (!this.id.equals(that.id))
                return false;
        }

        boolean this_present_writer = true && this.isSetWriter();
        boolean that_present_writer = true && that.isSetWriter();
        if (this_present_writer || that_present_writer) {
            if (!(this_present_writer && that_present_writer))
                return false;
            if (!this.writer.equals(that.writer))
                return false;
        }

        boolean this_present_title = true && this.isSetTitle();
        boolean that_present_title = true && that.isSetTitle();
        if (this_present_title || that_present_title) {
            if (!(this_present_title && that_present_title))
                return false;
            if (!this.title.equals(that.title))
                return false;
        }

        boolean this_present_content= true && this.isSetContent();
        boolean that_present_content = true && that.isSetContent();
        if (this_present_content || that_present_content) {
            if (!(this_present_content && that_present_content))
                return false;
            if (!this.content.equals(that.content))
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public int compareTo(Post other) {
        if (!getClass().equals(other.getClass())) {
            return getClass().getName().compareTo(other.getClass().getName());
        }

        int lastComparison = 0;
        Post typedOther = (Post)other;

        lastComparison = Boolean.valueOf(isSetId()).compareTo(typedOther.isSetId());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetId()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, typedOther.id);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(isSetWriter()).compareTo(typedOther.isSetWriter());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetWriter()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.writer, typedOther.writer);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(isSetTitle()).compareTo(typedOther.isSetTitle());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetTitle()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.title, typedOther.title);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(isSetContent()).compareTo(typedOther.isSetContent());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetContent()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.content, typedOther.content);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        return 0;
    }

    public _Fields fieldForId(int fieldId) {
        return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
        schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Post(");
        boolean first = true;

        if (isSetId()) {
            sb.append("id:");
            if (this.id == null) {
                sb.append("null");
            } else {
                sb.append(this.id);
            }
            first = false;
        }
        if (isSetWriter()) {
            if (!first) sb.append(", ");
            sb.append("writer:");
            if (this.writer == null) {
                sb.append("null");
            } else {
                sb.append(this.writer);
            }
            first = false;
        }
        if (isSetTitle()) {
            if (!first) sb.append(", ");
            sb.append("title:");
            if (this.title == null) {
                sb.append("null");
            } else {
                sb.append(this.title);
            }
            first = false;
        }
        if (isSetContent()) {
            if (!first) sb.append(", ");
            sb.append("content:");
            if (this.content == null) {
                sb.append("null");
            } else {
                sb.append(this.content);
            }
            first = false;
        }
        sb.append(")");
        return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
        // check for required fields
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        try {
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
        } catch (org.apache.thrift.TException te) {
            throw new java.io.IOException(te);
        }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
        try {
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
        } catch (org.apache.thrift.TException te) {
            throw new java.io.IOException(te);
        }
    }

    private static class PostStandardSchemeFactory implements SchemeFactory {
        public PostStandardScheme getScheme() {
            return new PostStandardScheme();
        }
    }

    private static class PostStandardScheme extends StandardScheme<Post> {

        public void read(org.apache.thrift.protocol.TProtocol iprot, Post struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TField schemeField;
            iprot.readStructBegin();
            while (true)
            {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                    break;
                }
                switch (schemeField.id) {
                    case 1: // ID
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            struct.id = iprot.readString();
                            struct.setIdIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 2: // WRITER
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            struct.writer = iprot.readString();
                            struct.setWriterIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 3: // TITLE
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            struct.title = iprot.readString();
                            struct.setTitleIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 4: // CONTENT
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            struct.content = iprot.readString();
                            struct.setContentIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    default:
                        org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                }
                iprot.readFieldEnd();
            }
            iprot.readStructEnd();

            // check for required fields of primitive type, which can't be checked in the validate method
            struct.validate();
        }

        public void write(org.apache.thrift.protocol.TProtocol oprot, Post struct) throws org.apache.thrift.TException {
            struct.validate();

            oprot.writeStructBegin(STRUCT_DESC);
            if (struct.id != null) {
                if (struct.isSetId()) {
                    oprot.writeFieldBegin(ID_FIELD_DESC);
                    oprot.writeString(struct.id);
                    oprot.writeFieldEnd();
                }
            }
            if (struct.writer != null) {
                if (struct.isSetWriter()) {
                    oprot.writeFieldBegin(WRITER_FIELD_DESC);
                    oprot.writeString(struct.writer);
                    oprot.writeFieldEnd();
                }
            }
            if (struct.title != null) {
                if (struct.isSetTitle()) {
                    oprot.writeFieldBegin(TITLE_FIELD_DESC);
                    oprot.writeString(struct.title);
                    oprot.writeFieldEnd();
                }
            }
            if (struct.content != null) {
                if (struct.isSetContent()) {
                    oprot.writeFieldBegin(CONTENT_FIELD_DESC);
                    oprot.writeString(struct.content);
                    oprot.writeFieldEnd();
                }
            }
            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }

    }

    private static class PostTupleSchemeFactory implements SchemeFactory {
        public PostTupleScheme getScheme() {
            return new PostTupleScheme();
        }
    }

    private static class PostTupleScheme extends TupleScheme<Post> {

        @Override
        public void write(org.apache.thrift.protocol.TProtocol prot, Post struct) throws org.apache.thrift.TException {
            TTupleProtocol oprot = (TTupleProtocol) prot;
            BitSet optionals = new BitSet();
            if (struct.isSetId()) {
                optionals.set(0);
            }
            if (struct.isSetWriter()) {
                optionals.set(1);
            }
            if (struct.isSetTitle()) {
                optionals.set(2);
            }
            if (struct.isSetContent()) {
                optionals.set(3);
            }
            oprot.writeBitSet(optionals, 4);
            if (struct.isSetId()) {
                oprot.writeString(struct.id);
            }
            if (struct.isSetWriter()) {
                oprot.writeString(struct.writer);
            }
            if (struct.isSetTitle()) {
                oprot.writeString(struct.title);
            }
            if (struct.isSetContent()) {
                oprot.writeString(struct.content);
            }
        }

        @Override
        public void read(org.apache.thrift.protocol.TProtocol prot, Post struct) throws org.apache.thrift.TException {
            TTupleProtocol iprot = (TTupleProtocol) prot;
            BitSet incoming = iprot.readBitSet(4);
            if (incoming.get(0)) {
                struct.id = iprot.readString();
                struct.setIdIsSet(true);
            }
            if (incoming.get(1)) {
                struct.writer = iprot.readString();
                struct.setWriterIsSet(true);
            }
            if (incoming.get(2)) {
                struct.title = iprot.readString();
                struct.setTitleIsSet(true);
            }
            if (incoming.get(3)) {
                struct.content = iprot.readString();
                struct.setContentIsSet(true);
            }
        }
    }
}
