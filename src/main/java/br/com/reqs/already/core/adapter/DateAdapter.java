package br.com.reqs.already.core.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Adapter para formato de data, de marshal e unmarshal. A data
 * no formata de MM/dd/yyyy.
 *  
 * @author <a href="mailto:dafediegogean@gmail.com">Diego Gean da Fé</a>
 * @version
 * @since 24 de out de 2020, 15:25:10
 */
public class DateAdapter extends XmlAdapter<String, Date> {

    private String pattern = "dd/MM/yyyy";

    /**
     * Método marshal(Date date), recebe como parâmetro java.util.Date,
     * e formata a partir da pattern dd/MM/yyyy com java.text.SimpleDateFormat, 
     * a data recebida.
     * 
     * @return new SimpleDateFormat
     */
    public String marshal(Date date) throws Exception {
        return new SimpleDateFormat(pattern).format(date);
    }
    
    /**
     * Método unmarshal(String dateString), recebe como parâmetro
     * uma data do tipo String, e formata a partir da pattern 
     * dd/MM/yyyy com java.text.SimpleDateFormat, a data recebida.
     * 
     * @return new SimpleDateFormat
     */
    public Date unmarshal(String dateString) throws Exception {
        System.out.println(dateString);
        return new SimpleDateFormat(pattern).parse(dateString);
    }

}
