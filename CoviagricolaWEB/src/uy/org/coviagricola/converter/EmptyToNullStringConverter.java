package uy.org.coviagricola.converter;

import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
@FacesConverter("emptyToNullStringConverter")
public class EmptyToNullStringConverter implements Converter {


    public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            if (component instanceof EditableValueHolder) {
                ((EditableValueHolder) component).setSubmittedValue(null);
            }

            return null;
        }

        return submittedValue;
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object modelValue) {
        return (modelValue == null) || ((Integer)modelValue == 0) ? "" : modelValue.toString();
    }

}
