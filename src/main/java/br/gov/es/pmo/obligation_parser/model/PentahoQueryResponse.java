package br.gov.es.pmo.obligation_parser.model;
import java.util.ArrayList; import java.util.List;
public class PentahoQueryResponse { private List<List<Object>> resultset=new ArrayList<>(); public List<List<Object>> getResultset(){return resultset;} public void setResultset(List<List<Object>> v){resultset=v;} }
