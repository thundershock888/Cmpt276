package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ParticipantFrames {

    @SerializedName("1")
    private JsonMember jsonMember;

    @SerializedName("2")
    private JsonMember jsonMember2;

    @SerializedName("3")
    private JsonMember jsonMember3;

    @SerializedName("4")
    private JsonMember jsonMember4;

    @SerializedName("5")
    private JsonMember jsonMember5;

    @SerializedName("6")
    private JsonMember jsonMember6;

    @SerializedName("7")
    private JsonMember jsonMember7;

    @SerializedName("8")
    private JsonMember jsonMember8;

    @SerializedName("9")
    private JsonMember jsonMember9;

    @SerializedName("10")
    private JsonMember jsonMember10;
    public JsonMember getJsonMemberI(int i){
        if(i == 1){
            return jsonMember;
        }
        if(i == 2){
            return jsonMember2;
        }
        if(i == 3){
            return jsonMember3;
        }
        if(i == 4){
            return jsonMember4;
        }
        if(i == 5){
            return jsonMember5;
        }
        if(i == 6){
            return jsonMember6;
        }
        if(i == 7){
            return jsonMember7;
        }
        if(i == 8){
            return jsonMember8;
        }
        if(i == 9){
            return jsonMember9;
        }

        return jsonMember10;
    }

    public JsonMember getJsonMember() {
        return jsonMember;
    }

    public JsonMember getJsonMember2() {
        return jsonMember2;
    }

    public JsonMember getJsonMember3() {
        return jsonMember3;
    }

    public JsonMember getJsonMember4() {
        return jsonMember4;
    }

    public JsonMember getJsonMember5() {
        return jsonMember5;
    }

    public JsonMember getJsonMember6() {
        return jsonMember6;
    }

    public JsonMember getJsonMember7() {
        return jsonMember7;
    }

    public JsonMember getJsonMember8() {
        return jsonMember8;
    }

    public JsonMember getJsonMember9() {
        return jsonMember9;
    }

    public JsonMember getJsonMember10() {
        return jsonMember10;
    }
/*
    public List<JsonMember> getAllMemebers() {
        return List.of(
        		jsonMember,
                jsonMember2,
                jsonMember3,
                jsonMember4,
                jsonMember5,
                jsonMember6,
                jsonMember7,
                jsonMember8,
                jsonMember9,
                jsonMember10
        );
    }*/
}