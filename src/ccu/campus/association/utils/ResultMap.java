package ccu.campus.association.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 
 * @author yuanliang.yang	
 * TODO
 * version 1.0.1
 * 2017-12-21
 */
public class ResultMap {

    // ����jackson����
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // ��Ӧҵ��״̬
    private Integer status;

    // ��Ӧ��Ϣ
    private String msg;

    // ��Ӧ�е�����
    private Object data;

    public static ResultMap build(Integer status, String msg, Object data) {
        return new ResultMap(status, msg, data);
    }

    public static ResultMap ok(Object data) {
        return new ResultMap(data);
    }
    public static ResultMap ok() {
        return new ResultMap(null);
    }
    public static ResultMap error(String msg) {
        return new ResultMap(250,msg,"");
    }

    public ResultMap() {

    }

    public static ResultMap build(Integer status, String msg) {
        return new ResultMap(status, msg, null);
    }

    public ResultMap(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResultMap(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

   /* *//**
     * ��json�����ת��ΪResultMap����
     * 
     * @param jsonData json����
     * @param clazz ResultMap�е�object����
     * @return
     *//*
    public static ResultMap formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, ResultMap.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    *//**
     * û��object�����ת��
     * 
     * @param json
     * @return
     *//*
    public static ResultMap format(String json) {
        try {
            return MAPPER.readValue(json, ResultMap.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    *//**
     * Object�Ǽ���ת��
     * 
     * @param jsonData json����
     * @param clazz �����е�����
     * @return
     *//*
    public static ResultMap formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }
*/
}
