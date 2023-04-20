package br.com.decolar.reembolso.responses;

import java.util.List;

public class ReembolsoResponse<T> {

    private  T data;
    private List<String> erros;

    public ReembolsoResponse(T data){
        this.data = data;
    }

    public ReembolsoResponse(List<String> erros){
        this.erros = erros;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }
}
