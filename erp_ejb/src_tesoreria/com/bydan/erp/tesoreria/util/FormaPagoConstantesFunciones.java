/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.tesoreria.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.tesoreria.util.FormaPagoConstantesFunciones;
import com.bydan.erp.tesoreria.util.FormaPagoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.FormaPagoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class FormaPagoConstantesFunciones extends FormaPagoConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="FormaPago";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FormaPago"+FormaPagoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FormaPagoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FormaPagoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FormaPagoConstantesFunciones.SCHEMA+"_"+FormaPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FormaPagoConstantesFunciones.SCHEMA+"_"+FormaPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FormaPagoConstantesFunciones.SCHEMA+"_"+FormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FormaPagoConstantesFunciones.SCHEMA+"_"+FormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FormaPagoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FormaPagoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FormaPagoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FormaPagoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Forma Pagos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Forma Pago";
	public static final String SCLASSWEBTITULO_LOWER="Forma Pago";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FormaPago";
	public static final String OBJECTNAME="formapago";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="forma_pago";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select formapago from "+FormaPagoConstantesFunciones.SPERSISTENCENAME+" formapago";
	public static String QUERYSELECTNATIVE="select "+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".id,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".version_row,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".id_empresa,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".id_sucursal,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".id_modulo,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".id_ejercicio,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".id_periodo,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".id_anio,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".id_mes,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".id_tipo_forma_pago,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".nombre,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".siglas,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".numero_dias,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".porcentaje,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".valor,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".con_detalle,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".con_remesa,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".con_maneja_cuotas,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".fecha,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".fecha_fin,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".id_transaccion,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".id_cuenta_contable,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".id_cuenta_contable_rete,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".porcentaje_rete,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".base_retencion,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".valor_retencion,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".numero_retencion,"+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME+".nombre_retencion from "+FormaPagoConstantesFunciones.SCHEMA+"."+FormaPagoConstantesFunciones.TABLENAME;//+" as "+FormaPagoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected FormaPagoConstantesFuncionesAdditional formapagoConstantesFuncionesAdditional=null;
	
	public FormaPagoConstantesFuncionesAdditional getFormaPagoConstantesFuncionesAdditional() {
		return this.formapagoConstantesFuncionesAdditional;
	}
	
	public void setFormaPagoConstantesFuncionesAdditional(FormaPagoConstantesFuncionesAdditional formapagoConstantesFuncionesAdditional) {
		try {
			this.formapagoConstantesFuncionesAdditional=formapagoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDMODULO= "id_modulo";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDTIPOFORMAPAGO= "id_tipo_forma_pago";
    public static final String NOMBRE= "nombre";
    public static final String SIGLAS= "siglas";
    public static final String NUMERODIAS= "numero_dias";
    public static final String PORCENTAJE= "porcentaje";
    public static final String VALOR= "valor";
    public static final String CONDETALLE= "con_detalle";
    public static final String CONREMESA= "con_remesa";
    public static final String CONMANEJACUOTAS= "con_maneja_cuotas";
    public static final String FECHA= "fecha";
    public static final String FECHAFIN= "fecha_fin";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String IDTIPOTRANSACCIONMODULO= "id_tipo_transaccion_modulo";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDCUENTACONTABLERETE= "id_cuenta_contable_rete";
    public static final String PORCENTAJERETE= "porcentaje_rete";
    public static final String BASERETENCION= "base_retencion";
    public static final String VALORRETENCION= "valor_retencion";
    public static final String NUMERORETENCION= "numero_retencion";
    public static final String NOMBRERETENCION= "nombre_retencion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDTIPOFORMAPAGO= "Tipo Forma Pago";
		public static final String LABEL_IDTIPOFORMAPAGO_LOWER= "Tipo Forma Pago";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_SIGLAS= "Siglas";
		public static final String LABEL_SIGLAS_LOWER= "Siglas";
    	public static final String LABEL_NUMERODIAS= "Numero Dias";
		public static final String LABEL_NUMERODIAS_LOWER= "Numero Dias";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_CONDETALLE= "Con Detalle";
		public static final String LABEL_CONDETALLE_LOWER= "Con Detalle";
    	public static final String LABEL_CONREMESA= "Con Remesa";
		public static final String LABEL_CONREMESA_LOWER= "Con Remesa";
    	public static final String LABEL_CONMANEJACUOTAS= "Con Maneja Cuotas";
		public static final String LABEL_CONMANEJACUOTAS_LOWER= "Con Maneja Cuotas";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_IDTRANSACCION= "Transaccion";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_IDTIPOTRANSACCIONMODULO= "Tipo Transaccion Modulo";
		public static final String LABEL_IDTIPOTRANSACCIONMODULO_LOWER= "Tipo Transaccion Modulo";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDCUENTACONTABLERETE= "Cuenta Contable Retencion";
		public static final String LABEL_IDCUENTACONTABLERETE_LOWER= "Cuenta Contable Rete";
    	public static final String LABEL_PORCENTAJERETE= "Porcentaje Retencion";
		public static final String LABEL_PORCENTAJERETE_LOWER= "Porcentaje Rete";
    	public static final String LABEL_BASERETENCION= "Base Retencion";
		public static final String LABEL_BASERETENCION_LOWER= "Base Retencion";
    	public static final String LABEL_VALORRETENCION= "Valor Retencion";
		public static final String LABEL_VALORRETENCION_LOWER= "Valor Retencion";
    	public static final String LABEL_NUMERORETENCION= "Numero Retencion";
		public static final String LABEL_NUMERORETENCION_LOWER= "Numero Retencion";
    	public static final String LABEL_NOMBRERETENCION= "Nombre Retencion";
		public static final String LABEL_NOMBRERETENCION_LOWER= "Nombre Retencion";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSIGLAS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSIGLAS=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_RETENCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_RETENCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_RETENCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_RETENCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getFormaPagoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.IDEMPRESA)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.IDMODULO)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.IDPERIODO)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.IDANIO)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.IDMES)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.IDTIPOFORMAPAGO)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.NOMBRE)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.SIGLAS)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_SIGLAS;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.NUMERODIAS)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_NUMERODIAS;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.PORCENTAJE)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.VALOR)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.CONDETALLE)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_CONDETALLE;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.CONREMESA)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_CONREMESA;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.CONMANEJACUOTAS)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_CONMANEJACUOTAS;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.FECHA)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.FECHAFIN)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.IDTRANSACCION)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.IDCUENTACONTABLERETE)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLERETE;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.PORCENTAJERETE)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_PORCENTAJERETE;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.BASERETENCION)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_BASERETENCION;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.VALORRETENCION)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_VALORRETENCION;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.NUMERORETENCION)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_NUMERORETENCION;}
		if(sNombreColumna.equals(FormaPagoConstantesFunciones.NOMBRERETENCION)) {sLabelColumna=FormaPagoConstantesFunciones.LABEL_NOMBRERETENCION;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_detalleDescripcion(FormaPago formapago) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!formapago.getcon_detalle()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_detalleHtmlDescripcion(FormaPago formapago) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(formapago.getId(),formapago.getcon_detalle());

		return sDescripcion;
	}	
		
	public static String getcon_remesaDescripcion(FormaPago formapago) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!formapago.getcon_remesa()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_remesaHtmlDescripcion(FormaPago formapago) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(formapago.getId(),formapago.getcon_remesa());

		return sDescripcion;
	}	
		
	public static String getcon_maneja_cuotasDescripcion(FormaPago formapago) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!formapago.getcon_maneja_cuotas()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_maneja_cuotasHtmlDescripcion(FormaPago formapago) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(formapago.getId(),formapago.getcon_maneja_cuotas());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getFormaPagoDescripcion(FormaPago formapago) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(formapago !=null/* && formapago.getId()!=0*/) {
			sDescripcion=formapago.getnombre();//formapagoformapago.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getFormaPagoDescripcionDetallado(FormaPago formapago) {
		String sDescripcion="";
			
		sDescripcion+=FormaPagoConstantesFunciones.ID+"=";
		sDescripcion+=formapago.getId().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=formapago.getVersionRow().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=formapago.getid_empresa().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=formapago.getid_sucursal().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.IDMODULO+"=";
		sDescripcion+=formapago.getid_modulo().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=formapago.getid_ejercicio().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=formapago.getid_periodo().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.IDANIO+"=";
		sDescripcion+=formapago.getid_anio().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.IDMES+"=";
		sDescripcion+=formapago.getid_mes().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.IDTIPOFORMAPAGO+"=";
		sDescripcion+=formapago.getid_tipo_forma_pago().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=formapago.getnombre()+",";
		sDescripcion+=FormaPagoConstantesFunciones.SIGLAS+"=";
		sDescripcion+=formapago.getsiglas()+",";
		sDescripcion+=FormaPagoConstantesFunciones.NUMERODIAS+"=";
		sDescripcion+=formapago.getnumero_dias().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=formapago.getporcentaje().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.VALOR+"=";
		sDescripcion+=formapago.getvalor().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.CONDETALLE+"=";
		sDescripcion+=formapago.getcon_detalle().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.CONREMESA+"=";
		sDescripcion+=formapago.getcon_remesa().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.CONMANEJACUOTAS+"=";
		sDescripcion+=formapago.getcon_maneja_cuotas().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.FECHA+"=";
		sDescripcion+=formapago.getfecha().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=formapago.getfecha_fin().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=formapago.getid_transaccion().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.IDTIPOTRANSACCIONMODULO+"=";
		sDescripcion+=formapago.getid_tipo_transaccion_modulo().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=formapago.getid_cuenta_contable().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.IDCUENTACONTABLERETE+"=";
		sDescripcion+=formapago.getid_cuenta_contable_rete().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.PORCENTAJERETE+"=";
		sDescripcion+=formapago.getporcentaje_rete().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.BASERETENCION+"=";
		sDescripcion+=formapago.getbase_retencion().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.VALORRETENCION+"=";
		sDescripcion+=formapago.getvalor_retencion().toString()+",";
		sDescripcion+=FormaPagoConstantesFunciones.NUMERORETENCION+"=";
		sDescripcion+=formapago.getnumero_retencion()+",";
		sDescripcion+=FormaPagoConstantesFunciones.NOMBRERETENCION+"=";
		sDescripcion+=formapago.getnombre_retencion()+",";
			
		return sDescripcion;
	}
	
	public static void setFormaPagoDescripcion(FormaPago formapago,String sValor) throws Exception {			
		if(formapago !=null) {
			formapago.setnombre(sValor);;//formapagoformapago.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}

	public static String getTipoFormaPagoDescripcion(TipoFormaPago tipoformapago) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoformapago!=null/*&&tipoformapago.getId()>0*/) {
			sDescripcion=TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(tipoformapago);
		}

		return sDescripcion;
	}

	public static String getTransaccionDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTipoTransaccionModuloDescripcion(TipoTransaccionModulo tipotransaccionmodulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotransaccionmodulo!=null/*&&tipotransaccionmodulo.getId()>0*/) {
			sDescripcion=TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(tipotransaccionmodulo);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableReteDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("BusquedaPorSiglas")) {
			sNombreIndice="Tipo=  Por Siglas";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdCuentaContableRete")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Retencion";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoFormaPago")) {
			sNombreIndice="Tipo=  Por Tipo Forma Pago";
		} else if(sNombreIndice.equals("FK_IdTipoTransaccionModulo")) {
			sNombreIndice="Tipo=  Por Tipo Transaccion Modulo";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Transaccion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorSiglas(String siglas) {
		String sDetalleIndice=" Parametros->";
		if(siglas!=null) {sDetalleIndice+=" Siglas="+siglas;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableRete(Long id_cuenta_contable_rete) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_rete!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Retencion="+id_cuenta_contable_rete.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoFormaPago(Long id_tipo_forma_pago) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_forma_pago!=null) {sDetalleIndice+=" Codigo Unico De Tipo Forma Pago="+id_tipo_forma_pago.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTransaccionModulo(Long id_tipo_transaccion_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_transaccion_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Transaccion Modulo="+id_tipo_transaccion_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFormaPago(FormaPago formapago,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		formapago.setnombre(formapago.getnombre().trim());
		formapago.setsiglas(formapago.getsiglas().trim());
		formapago.setnumero_retencion(formapago.getnumero_retencion().trim());
		formapago.setnombre_retencion(formapago.getnombre_retencion().trim());
	}
	
	public static void quitarEspaciosFormaPagos(List<FormaPago> formapagos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FormaPago formapago: formapagos) {
			formapago.setnombre(formapago.getnombre().trim());
			formapago.setsiglas(formapago.getsiglas().trim());
			formapago.setnumero_retencion(formapago.getnumero_retencion().trim());
			formapago.setnombre_retencion(formapago.getnombre_retencion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormaPago(FormaPago formapago,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && formapago.getConCambioAuxiliar()) {
			formapago.setIsDeleted(formapago.getIsDeletedAuxiliar());	
			formapago.setIsNew(formapago.getIsNewAuxiliar());	
			formapago.setIsChanged(formapago.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			formapago.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			formapago.setIsDeletedAuxiliar(false);	
			formapago.setIsNewAuxiliar(false);	
			formapago.setIsChangedAuxiliar(false);
			
			formapago.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormaPagos(List<FormaPago> formapagos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FormaPago formapago : formapagos) {
			if(conAsignarBase && formapago.getConCambioAuxiliar()) {
				formapago.setIsDeleted(formapago.getIsDeletedAuxiliar());	
				formapago.setIsNew(formapago.getIsNewAuxiliar());	
				formapago.setIsChanged(formapago.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				formapago.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				formapago.setIsDeletedAuxiliar(false);	
				formapago.setIsNewAuxiliar(false);	
				formapago.setIsChangedAuxiliar(false);
				
				formapago.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFormaPago(FormaPago formapago,Boolean conEnteros) throws Exception  {
		formapago.setporcentaje(0.0);
		formapago.setvalor(0.0);
		formapago.setporcentaje_rete(0.0);
		formapago.setbase_retencion(0.0);
		formapago.setvalor_retencion(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			formapago.setnumero_dias(0);
		}
	}		
	
	public static void InicializarValoresFormaPagos(List<FormaPago> formapagos,Boolean conEnteros) throws Exception  {
		
		for(FormaPago formapago: formapagos) {
			formapago.setporcentaje(0.0);
			formapago.setvalor(0.0);
			formapago.setporcentaje_rete(0.0);
			formapago.setbase_retencion(0.0);
			formapago.setvalor_retencion(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				formapago.setnumero_dias(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaFormaPago(List<FormaPago> formapagos,FormaPago formapagoAux) throws Exception  {
		FormaPagoConstantesFunciones.InicializarValoresFormaPago(formapagoAux,true);
		
		for(FormaPago formapago: formapagos) {
			if(formapago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			formapagoAux.setnumero_dias(formapagoAux.getnumero_dias()+formapago.getnumero_dias());			
			formapagoAux.setporcentaje(formapagoAux.getporcentaje()+formapago.getporcentaje());			
			formapagoAux.setvalor(formapagoAux.getvalor()+formapago.getvalor());			
			formapagoAux.setporcentaje_rete(formapagoAux.getporcentaje_rete()+formapago.getporcentaje_rete());			
			formapagoAux.setbase_retencion(formapagoAux.getbase_retencion()+formapago.getbase_retencion());			
			formapagoAux.setvalor_retencion(formapagoAux.getvalor_retencion()+formapago.getvalor_retencion());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFormaPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FormaPagoConstantesFunciones.getArrayColumnasGlobalesFormaPago(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFormaPago(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormaPagoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormaPagoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormaPagoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormaPagoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormaPagoConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormaPagoConstantesFunciones.IDMODULO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormaPagoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormaPagoConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormaPagoConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormaPagoConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFormaPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FormaPago> formapagos,FormaPago formapago,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FormaPago formapagoAux: formapagos) {
			if(formapagoAux!=null && formapago!=null) {
				if((formapagoAux.getId()==null && formapago.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(formapagoAux.getId()!=null && formapago.getId()!=null){
					if(formapagoAux.getId().equals(formapago.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFormaPago(List<FormaPago> formapagos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double valorTotal=0.0;
		Double porcentaje_reteTotal=0.0;
		Double base_retencionTotal=0.0;
		Double valor_retencionTotal=0.0;
	
		for(FormaPago formapago: formapagos) {			
			if(formapago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=formapago.getporcentaje();
			valorTotal+=formapago.getvalor();
			porcentaje_reteTotal+=formapago.getporcentaje_rete();
			base_retencionTotal+=formapago.getbase_retencion();
			valor_retencionTotal+=formapago.getvalor_retencion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormaPagoConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(FormaPagoConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormaPagoConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(FormaPagoConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormaPagoConstantesFunciones.PORCENTAJERETE);
		datoGeneral.setsDescripcion(FormaPagoConstantesFunciones.LABEL_PORCENTAJERETE);
		datoGeneral.setdValorDouble(porcentaje_reteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormaPagoConstantesFunciones.BASERETENCION);
		datoGeneral.setsDescripcion(FormaPagoConstantesFunciones.LABEL_BASERETENCION);
		datoGeneral.setdValorDouble(base_retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormaPagoConstantesFunciones.VALORRETENCION);
		datoGeneral.setsDescripcion(FormaPagoConstantesFunciones.LABEL_VALORRETENCION);
		datoGeneral.setdValorDouble(valor_retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFormaPago() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_ID, FormaPagoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_VERSIONROW, FormaPagoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_IDEMPRESA, FormaPagoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_IDSUCURSAL, FormaPagoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_IDMODULO, FormaPagoConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_IDEJERCICIO, FormaPagoConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_IDPERIODO, FormaPagoConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_IDANIO, FormaPagoConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_IDMES, FormaPagoConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO, FormaPagoConstantesFunciones.IDTIPOFORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_NOMBRE, FormaPagoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_SIGLAS, FormaPagoConstantesFunciones.SIGLAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_NUMERODIAS, FormaPagoConstantesFunciones.NUMERODIAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_PORCENTAJE, FormaPagoConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_VALOR, FormaPagoConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_CONDETALLE, FormaPagoConstantesFunciones.CONDETALLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_CONREMESA, FormaPagoConstantesFunciones.CONREMESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_CONMANEJACUOTAS, FormaPagoConstantesFunciones.CONMANEJACUOTAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_FECHA, FormaPagoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_FECHAFIN, FormaPagoConstantesFunciones.FECHAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_IDTRANSACCION, FormaPagoConstantesFunciones.IDTRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO, FormaPagoConstantesFunciones.IDTIPOTRANSACCIONMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLE, FormaPagoConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLERETE, FormaPagoConstantesFunciones.IDCUENTACONTABLERETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_PORCENTAJERETE, FormaPagoConstantesFunciones.PORCENTAJERETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_BASERETENCION, FormaPagoConstantesFunciones.BASERETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_VALORRETENCION, FormaPagoConstantesFunciones.VALORRETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_NUMERORETENCION, FormaPagoConstantesFunciones.NUMERORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoConstantesFunciones.LABEL_NOMBRERETENCION, FormaPagoConstantesFunciones.NOMBRERETENCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFormaPago() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.IDTIPOFORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.SIGLAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.NUMERODIAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.CONDETALLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.CONREMESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.CONMANEJACUOTAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.FECHAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.IDTRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.IDTIPOTRANSACCIONMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.IDCUENTACONTABLERETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.PORCENTAJERETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.BASERETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.VALORRETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.NUMERORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoConstantesFunciones.NOMBRERETENCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormaPago() throws Exception  {
		return FormaPagoConstantesFunciones.getTiposSeleccionarFormaPago(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormaPago(Boolean conFk) throws Exception  {
		return FormaPagoConstantesFunciones.getTiposSeleccionarFormaPago(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormaPago(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_SIGLAS);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_SIGLAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_NUMERODIAS);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_NUMERODIAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_CONDETALLE);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_CONDETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_CONREMESA);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_CONREMESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_CONMANEJACUOTAS);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_CONMANEJACUOTAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLERETE);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLERETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_PORCENTAJERETE);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_PORCENTAJERETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_BASERETENCION);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_BASERETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_VALORRETENCION);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_VALORRETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_NUMERORETENCION);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_NUMERORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoConstantesFunciones.LABEL_NOMBRERETENCION);
			reporte.setsDescripcion(FormaPagoConstantesFunciones.LABEL_NOMBRERETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFormaPago(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFormaPago(FormaPago formapagoAux) throws Exception {
		
			formapagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formapagoAux.getEmpresa()));
			formapagoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(formapagoAux.getSucursal()));
			formapagoAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(formapagoAux.getModulo()));
			formapagoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(formapagoAux.getEjercicio()));
			formapagoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(formapagoAux.getPeriodo()));
			formapagoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(formapagoAux.getAnio()));
			formapagoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(formapagoAux.getMes()));
			formapagoAux.settipoformapago_descripcion(TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(formapagoAux.getTipoFormaPago()));
			formapagoAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(formapagoAux.getTransaccion()));
			formapagoAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(formapagoAux.getTipoTransaccionModulo()));
			formapagoAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(formapagoAux.getCuentaContable()));
			formapagoAux.setcuentacontablerete_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(formapagoAux.getCuentaContableRete()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFormaPago(List<FormaPago> formapagosTemp) throws Exception {
		for(FormaPago formapagoAux:formapagosTemp) {
			
			formapagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formapagoAux.getEmpresa()));
			formapagoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(formapagoAux.getSucursal()));
			formapagoAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(formapagoAux.getModulo()));
			formapagoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(formapagoAux.getEjercicio()));
			formapagoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(formapagoAux.getPeriodo()));
			formapagoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(formapagoAux.getAnio()));
			formapagoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(formapagoAux.getMes()));
			formapagoAux.settipoformapago_descripcion(TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(formapagoAux.getTipoFormaPago()));
			formapagoAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(formapagoAux.getTransaccion()));
			formapagoAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(formapagoAux.getTipoTransaccionModulo()));
			formapagoAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(formapagoAux.getCuentaContable()));
			formapagoAux.setcuentacontablerete_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(formapagoAux.getCuentaContableRete()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(TipoFormaPago.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(TipoTransaccionModulo.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFormaPago.class)) {
						classes.add(new Classe(TipoFormaPago.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTransaccionModulo.class)) {
						classes.add(new Classe(TipoTransaccionModulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(TipoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormaPago.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(TipoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormaPago.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormaPagoConstantesFunciones.getClassesRelationshipsOfFormaPago(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(FormularioRentaExtra.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(FormularioRentaExtra.class)) {
						classes.add(new Classe(FormularioRentaExtra.class)); break;
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormaPagoConstantesFunciones.getClassesRelationshipsFromStringsOfFormaPago(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(FormularioRentaExtra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormularioRentaExtra.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(FormularioRentaExtra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormularioRentaExtra.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(FormaPago formapago,List<FormaPago> formapagos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			FormaPago formapagoEncontrado=null;
			
			for(FormaPago formapagoLocal:formapagos) {
				if(formapagoLocal.getId().equals(formapago.getId())) {
					formapagoEncontrado=formapagoLocal;
					
					formapagoLocal.setIsChanged(formapago.getIsChanged());
					formapagoLocal.setIsNew(formapago.getIsNew());
					formapagoLocal.setIsDeleted(formapago.getIsDeleted());
					
					formapagoLocal.setGeneralEntityOriginal(formapago.getGeneralEntityOriginal());
					
					formapagoLocal.setId(formapago.getId());	
					formapagoLocal.setVersionRow(formapago.getVersionRow());	
					formapagoLocal.setid_empresa(formapago.getid_empresa());	
					formapagoLocal.setid_sucursal(formapago.getid_sucursal());	
					formapagoLocal.setid_modulo(formapago.getid_modulo());	
					formapagoLocal.setid_ejercicio(formapago.getid_ejercicio());	
					formapagoLocal.setid_periodo(formapago.getid_periodo());	
					formapagoLocal.setid_anio(formapago.getid_anio());	
					formapagoLocal.setid_mes(formapago.getid_mes());	
					formapagoLocal.setid_tipo_forma_pago(formapago.getid_tipo_forma_pago());	
					formapagoLocal.setnombre(formapago.getnombre());	
					formapagoLocal.setsiglas(formapago.getsiglas());	
					formapagoLocal.setnumero_dias(formapago.getnumero_dias());	
					formapagoLocal.setporcentaje(formapago.getporcentaje());	
					formapagoLocal.setvalor(formapago.getvalor());	
					formapagoLocal.setcon_detalle(formapago.getcon_detalle());	
					formapagoLocal.setcon_remesa(formapago.getcon_remesa());	
					formapagoLocal.setcon_maneja_cuotas(formapago.getcon_maneja_cuotas());	
					formapagoLocal.setfecha(formapago.getfecha());	
					formapagoLocal.setfecha_fin(formapago.getfecha_fin());	
					formapagoLocal.setid_transaccion(formapago.getid_transaccion());	
					formapagoLocal.setid_tipo_transaccion_modulo(formapago.getid_tipo_transaccion_modulo());	
					formapagoLocal.setid_cuenta_contable(formapago.getid_cuenta_contable());	
					formapagoLocal.setid_cuenta_contable_rete(formapago.getid_cuenta_contable_rete());	
					formapagoLocal.setporcentaje_rete(formapago.getporcentaje_rete());	
					formapagoLocal.setbase_retencion(formapago.getbase_retencion());	
					formapagoLocal.setvalor_retencion(formapago.getvalor_retencion());	
					formapagoLocal.setnumero_retencion(formapago.getnumero_retencion());	
					formapagoLocal.setnombre_retencion(formapago.getnombre_retencion());	
					
					
					formapagoLocal.setFormularioRentaExtras(formapago.getFormularioRentaExtras());
					
					existe=true;
					break;
				}
			}
			
			if(!formapago.getIsDeleted()) {
				if(!existe) {
					formapagos.add(formapago);
				}
			} else {
				if(formapagoEncontrado!=null && permiteQuitar)  {
					formapagos.remove(formapagoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(FormaPago formapago,List<FormaPago> formapagos) throws Exception {
		try	{			
			for(FormaPago formapagoLocal:formapagos) {
				if(formapagoLocal.getId().equals(formapago.getId())) {
					formapagoLocal.setIsSelected(formapago.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFormaPago(List<FormaPago> formapagosAux) throws Exception {
		//this.formapagosAux=formapagosAux;
		
		for(FormaPago formapagoAux:formapagosAux) {
			if(formapagoAux.getIsChanged()) {
				formapagoAux.setIsChanged(false);
			}		
			
			if(formapagoAux.getIsNew()) {
				formapagoAux.setIsNew(false);
			}	
			
			if(formapagoAux.getIsDeleted()) {
				formapagoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFormaPago(FormaPago formapagoAux) throws Exception {
		//this.formapagoAux=formapagoAux;
		
			if(formapagoAux.getIsChanged()) {
				formapagoAux.setIsChanged(false);
			}		
			
			if(formapagoAux.getIsNew()) {
				formapagoAux.setIsNew(false);
			}	
			
			if(formapagoAux.getIsDeleted()) {
				formapagoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FormaPago formapagoAsignar,FormaPago formapago) throws Exception {
		formapagoAsignar.setId(formapago.getId());	
		formapagoAsignar.setVersionRow(formapago.getVersionRow());	
		formapagoAsignar.setid_empresa(formapago.getid_empresa());
		formapagoAsignar.setempresa_descripcion(formapago.getempresa_descripcion());	
		formapagoAsignar.setid_sucursal(formapago.getid_sucursal());
		formapagoAsignar.setsucursal_descripcion(formapago.getsucursal_descripcion());	
		formapagoAsignar.setid_modulo(formapago.getid_modulo());
		formapagoAsignar.setmodulo_descripcion(formapago.getmodulo_descripcion());	
		formapagoAsignar.setid_ejercicio(formapago.getid_ejercicio());
		formapagoAsignar.setejercicio_descripcion(formapago.getejercicio_descripcion());	
		formapagoAsignar.setid_periodo(formapago.getid_periodo());
		formapagoAsignar.setperiodo_descripcion(formapago.getperiodo_descripcion());	
		formapagoAsignar.setid_anio(formapago.getid_anio());
		formapagoAsignar.setanio_descripcion(formapago.getanio_descripcion());	
		formapagoAsignar.setid_mes(formapago.getid_mes());
		formapagoAsignar.setmes_descripcion(formapago.getmes_descripcion());	
		formapagoAsignar.setid_tipo_forma_pago(formapago.getid_tipo_forma_pago());
		formapagoAsignar.settipoformapago_descripcion(formapago.gettipoformapago_descripcion());	
		formapagoAsignar.setnombre(formapago.getnombre());	
		formapagoAsignar.setsiglas(formapago.getsiglas());	
		formapagoAsignar.setnumero_dias(formapago.getnumero_dias());	
		formapagoAsignar.setporcentaje(formapago.getporcentaje());	
		formapagoAsignar.setvalor(formapago.getvalor());	
		formapagoAsignar.setcon_detalle(formapago.getcon_detalle());	
		formapagoAsignar.setcon_remesa(formapago.getcon_remesa());	
		formapagoAsignar.setcon_maneja_cuotas(formapago.getcon_maneja_cuotas());	
		formapagoAsignar.setfecha(formapago.getfecha());	
		formapagoAsignar.setfecha_fin(formapago.getfecha_fin());	
		formapagoAsignar.setid_transaccion(formapago.getid_transaccion());
		formapagoAsignar.settransaccion_descripcion(formapago.gettransaccion_descripcion());	
		formapagoAsignar.setid_tipo_transaccion_modulo(formapago.getid_tipo_transaccion_modulo());
		formapagoAsignar.settipotransaccionmodulo_descripcion(formapago.gettipotransaccionmodulo_descripcion());	
		formapagoAsignar.setid_cuenta_contable(formapago.getid_cuenta_contable());
		formapagoAsignar.setcuentacontable_descripcion(formapago.getcuentacontable_descripcion());	
		formapagoAsignar.setid_cuenta_contable_rete(formapago.getid_cuenta_contable_rete());
		formapagoAsignar.setcuentacontablerete_descripcion(formapago.getcuentacontablerete_descripcion());	
		formapagoAsignar.setporcentaje_rete(formapago.getporcentaje_rete());	
		formapagoAsignar.setbase_retencion(formapago.getbase_retencion());	
		formapagoAsignar.setvalor_retencion(formapago.getvalor_retencion());	
		formapagoAsignar.setnumero_retencion(formapago.getnumero_retencion());	
		formapagoAsignar.setnombre_retencion(formapago.getnombre_retencion());	
	}
	
	public static void inicializarFormaPago(FormaPago formapago) throws Exception {
		try {
				formapago.setId(0L);	
					
				formapago.setid_empresa(-1L);	
				formapago.setid_sucursal(-1L);	
				formapago.setid_modulo(-1L);	
				formapago.setid_ejercicio(-1L);	
				formapago.setid_periodo(-1L);	
				formapago.setid_anio(null);	
				formapago.setid_mes(null);	
				formapago.setid_tipo_forma_pago(-1L);	
				formapago.setnombre("");	
				formapago.setsiglas("");	
				formapago.setnumero_dias(0);	
				formapago.setporcentaje(0.0);	
				formapago.setvalor(0.0);	
				formapago.setcon_detalle(false);	
				formapago.setcon_remesa(false);	
				formapago.setcon_maneja_cuotas(false);	
				formapago.setfecha(new Date());	
				formapago.setfecha_fin(new Date());	
				formapago.setid_transaccion(-1L);	
				formapago.setid_tipo_transaccion_modulo(null);	
				formapago.setid_cuenta_contable(-1L);	
				formapago.setid_cuenta_contable_rete(null);	
				formapago.setporcentaje_rete(0.0);	
				formapago.setbase_retencion(0.0);	
				formapago.setvalor_retencion(0.0);	
				formapago.setnumero_retencion("");	
				formapago.setnombre_retencion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFormaPago(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_SIGLAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_NUMERODIAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_CONDETALLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_CONREMESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_CONMANEJACUOTAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLERETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_PORCENTAJERETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_BASERETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_VALORRETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_NUMERORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoConstantesFunciones.LABEL_NOMBRERETENCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFormaPago(String sTipo,Row row,Workbook workbook,FormaPago formapago,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.gettipoformapago_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.getsiglas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.getnumero_dias());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(formapago.getcon_detalle()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(formapago.getcon_remesa()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(formapago.getcon_maneja_cuotas()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.gettipotransaccionmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.getcuentacontablerete_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.getporcentaje_rete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.getbase_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.getvalor_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.getnumero_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapago.getnombre_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFormaPago=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFormaPago() {
		return this.sFinalQueryFormaPago;
	}
	
	public void setsFinalQueryFormaPago(String sFinalQueryFormaPago) {
		this.sFinalQueryFormaPago= sFinalQueryFormaPago;
	}
	
	public Border resaltarSeleccionarFormaPago=null;
	
	public Border setResaltarSeleccionarFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFormaPago= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFormaPago() {
		return this.resaltarSeleccionarFormaPago;
	}
	
	public void setResaltarSeleccionarFormaPago(Border borderResaltarSeleccionarFormaPago) {
		this.resaltarSeleccionarFormaPago= borderResaltarSeleccionarFormaPago;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFormaPago=null;
	public Boolean mostraridFormaPago=true;
	public Boolean activaridFormaPago=true;

	public Border resaltarid_empresaFormaPago=null;
	public Boolean mostrarid_empresaFormaPago=true;
	public Boolean activarid_empresaFormaPago=true;
	public Boolean cargarid_empresaFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFormaPago=false;//ConEventDepend=true

	public Border resaltarid_sucursalFormaPago=null;
	public Boolean mostrarid_sucursalFormaPago=true;
	public Boolean activarid_sucursalFormaPago=true;
	public Boolean cargarid_sucursalFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalFormaPago=false;//ConEventDepend=true

	public Border resaltarid_moduloFormaPago=null;
	public Boolean mostrarid_moduloFormaPago=true;
	public Boolean activarid_moduloFormaPago=true;
	public Boolean cargarid_moduloFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloFormaPago=false;//ConEventDepend=true

	public Border resaltarid_ejercicioFormaPago=null;
	public Boolean mostrarid_ejercicioFormaPago=true;
	public Boolean activarid_ejercicioFormaPago=true;
	public Boolean cargarid_ejercicioFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioFormaPago=false;//ConEventDepend=true

	public Border resaltarid_periodoFormaPago=null;
	public Boolean mostrarid_periodoFormaPago=true;
	public Boolean activarid_periodoFormaPago=true;
	public Boolean cargarid_periodoFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoFormaPago=false;//ConEventDepend=true

	public Border resaltarid_anioFormaPago=null;
	public Boolean mostrarid_anioFormaPago=true;
	public Boolean activarid_anioFormaPago=false;
	public Boolean cargarid_anioFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioFormaPago=false;//ConEventDepend=true

	public Border resaltarid_mesFormaPago=null;
	public Boolean mostrarid_mesFormaPago=true;
	public Boolean activarid_mesFormaPago=false;
	public Boolean cargarid_mesFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesFormaPago=false;//ConEventDepend=true

	public Border resaltarid_tipo_forma_pagoFormaPago=null;
	public Boolean mostrarid_tipo_forma_pagoFormaPago=true;
	public Boolean activarid_tipo_forma_pagoFormaPago=true;
	public Boolean cargarid_tipo_forma_pagoFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_forma_pagoFormaPago=false;//ConEventDepend=true

	public Border resaltarnombreFormaPago=null;
	public Boolean mostrarnombreFormaPago=true;
	public Boolean activarnombreFormaPago=true;

	public Border resaltarsiglasFormaPago=null;
	public Boolean mostrarsiglasFormaPago=true;
	public Boolean activarsiglasFormaPago=true;

	public Border resaltarnumero_diasFormaPago=null;
	public Boolean mostrarnumero_diasFormaPago=true;
	public Boolean activarnumero_diasFormaPago=true;

	public Border resaltarporcentajeFormaPago=null;
	public Boolean mostrarporcentajeFormaPago=true;
	public Boolean activarporcentajeFormaPago=true;

	public Border resaltarvalorFormaPago=null;
	public Boolean mostrarvalorFormaPago=true;
	public Boolean activarvalorFormaPago=true;

	public Border resaltarcon_detalleFormaPago=null;
	public Boolean mostrarcon_detalleFormaPago=true;
	public Boolean activarcon_detalleFormaPago=true;

	public Border resaltarcon_remesaFormaPago=null;
	public Boolean mostrarcon_remesaFormaPago=true;
	public Boolean activarcon_remesaFormaPago=true;

	public Border resaltarcon_maneja_cuotasFormaPago=null;
	public Boolean mostrarcon_maneja_cuotasFormaPago=true;
	public Boolean activarcon_maneja_cuotasFormaPago=true;

	public Border resaltarfechaFormaPago=null;
	public Boolean mostrarfechaFormaPago=true;
	public Boolean activarfechaFormaPago=true;

	public Border resaltarfecha_finFormaPago=null;
	public Boolean mostrarfecha_finFormaPago=true;
	public Boolean activarfecha_finFormaPago=true;

	public Border resaltarid_transaccionFormaPago=null;
	public Boolean mostrarid_transaccionFormaPago=true;
	public Boolean activarid_transaccionFormaPago=true;
	public Boolean cargarid_transaccionFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionFormaPago=false;//ConEventDepend=true

	public Border resaltarid_tipo_transaccion_moduloFormaPago=null;
	public Boolean mostrarid_tipo_transaccion_moduloFormaPago=true;
	public Boolean activarid_tipo_transaccion_moduloFormaPago=false;
	public Boolean cargarid_tipo_transaccion_moduloFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_transaccion_moduloFormaPago=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableFormaPago=null;
	public Boolean mostrarid_cuenta_contableFormaPago=true;
	public Boolean activarid_cuenta_contableFormaPago=true;
	public Boolean cargarid_cuenta_contableFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableFormaPago=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_reteFormaPago=null;
	public Boolean mostrarid_cuenta_contable_reteFormaPago=true;
	public Boolean activarid_cuenta_contable_reteFormaPago=true;
	public Boolean cargarid_cuenta_contable_reteFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_reteFormaPago=false;//ConEventDepend=true

	public Border resaltarporcentaje_reteFormaPago=null;
	public Boolean mostrarporcentaje_reteFormaPago=true;
	public Boolean activarporcentaje_reteFormaPago=true;

	public Border resaltarbase_retencionFormaPago=null;
	public Boolean mostrarbase_retencionFormaPago=true;
	public Boolean activarbase_retencionFormaPago=true;

	public Border resaltarvalor_retencionFormaPago=null;
	public Boolean mostrarvalor_retencionFormaPago=true;
	public Boolean activarvalor_retencionFormaPago=true;

	public Border resaltarnumero_retencionFormaPago=null;
	public Boolean mostrarnumero_retencionFormaPago=true;
	public Boolean activarnumero_retencionFormaPago=true;

	public Border resaltarnombre_retencionFormaPago=null;
	public Boolean mostrarnombre_retencionFormaPago=true;
	public Boolean activarnombre_retencionFormaPago=true;

	
	

	public Border setResaltaridFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltaridFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFormaPago() {
		return this.resaltaridFormaPago;
	}

	public void setResaltaridFormaPago(Border borderResaltar) {
		this.resaltaridFormaPago= borderResaltar;
	}

	public Boolean getMostraridFormaPago() {
		return this.mostraridFormaPago;
	}

	public void setMostraridFormaPago(Boolean mostraridFormaPago) {
		this.mostraridFormaPago= mostraridFormaPago;
	}

	public Boolean getActivaridFormaPago() {
		return this.activaridFormaPago;
	}

	public void setActivaridFormaPago(Boolean activaridFormaPago) {
		this.activaridFormaPago= activaridFormaPago;
	}

	public Border setResaltarid_empresaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_empresaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFormaPago() {
		return this.resaltarid_empresaFormaPago;
	}

	public void setResaltarid_empresaFormaPago(Border borderResaltar) {
		this.resaltarid_empresaFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_empresaFormaPago() {
		return this.mostrarid_empresaFormaPago;
	}

	public void setMostrarid_empresaFormaPago(Boolean mostrarid_empresaFormaPago) {
		this.mostrarid_empresaFormaPago= mostrarid_empresaFormaPago;
	}

	public Boolean getActivarid_empresaFormaPago() {
		return this.activarid_empresaFormaPago;
	}

	public void setActivarid_empresaFormaPago(Boolean activarid_empresaFormaPago) {
		this.activarid_empresaFormaPago= activarid_empresaFormaPago;
	}

	public Boolean getCargarid_empresaFormaPago() {
		return this.cargarid_empresaFormaPago;
	}

	public void setCargarid_empresaFormaPago(Boolean cargarid_empresaFormaPago) {
		this.cargarid_empresaFormaPago= cargarid_empresaFormaPago;
	}

	public Border setResaltarid_sucursalFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_sucursalFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalFormaPago() {
		return this.resaltarid_sucursalFormaPago;
	}

	public void setResaltarid_sucursalFormaPago(Border borderResaltar) {
		this.resaltarid_sucursalFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_sucursalFormaPago() {
		return this.mostrarid_sucursalFormaPago;
	}

	public void setMostrarid_sucursalFormaPago(Boolean mostrarid_sucursalFormaPago) {
		this.mostrarid_sucursalFormaPago= mostrarid_sucursalFormaPago;
	}

	public Boolean getActivarid_sucursalFormaPago() {
		return this.activarid_sucursalFormaPago;
	}

	public void setActivarid_sucursalFormaPago(Boolean activarid_sucursalFormaPago) {
		this.activarid_sucursalFormaPago= activarid_sucursalFormaPago;
	}

	public Boolean getCargarid_sucursalFormaPago() {
		return this.cargarid_sucursalFormaPago;
	}

	public void setCargarid_sucursalFormaPago(Boolean cargarid_sucursalFormaPago) {
		this.cargarid_sucursalFormaPago= cargarid_sucursalFormaPago;
	}

	public Border setResaltarid_moduloFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_moduloFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloFormaPago() {
		return this.resaltarid_moduloFormaPago;
	}

	public void setResaltarid_moduloFormaPago(Border borderResaltar) {
		this.resaltarid_moduloFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_moduloFormaPago() {
		return this.mostrarid_moduloFormaPago;
	}

	public void setMostrarid_moduloFormaPago(Boolean mostrarid_moduloFormaPago) {
		this.mostrarid_moduloFormaPago= mostrarid_moduloFormaPago;
	}

	public Boolean getActivarid_moduloFormaPago() {
		return this.activarid_moduloFormaPago;
	}

	public void setActivarid_moduloFormaPago(Boolean activarid_moduloFormaPago) {
		this.activarid_moduloFormaPago= activarid_moduloFormaPago;
	}

	public Boolean getCargarid_moduloFormaPago() {
		return this.cargarid_moduloFormaPago;
	}

	public void setCargarid_moduloFormaPago(Boolean cargarid_moduloFormaPago) {
		this.cargarid_moduloFormaPago= cargarid_moduloFormaPago;
	}

	public Border setResaltarid_ejercicioFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioFormaPago() {
		return this.resaltarid_ejercicioFormaPago;
	}

	public void setResaltarid_ejercicioFormaPago(Border borderResaltar) {
		this.resaltarid_ejercicioFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioFormaPago() {
		return this.mostrarid_ejercicioFormaPago;
	}

	public void setMostrarid_ejercicioFormaPago(Boolean mostrarid_ejercicioFormaPago) {
		this.mostrarid_ejercicioFormaPago= mostrarid_ejercicioFormaPago;
	}

	public Boolean getActivarid_ejercicioFormaPago() {
		return this.activarid_ejercicioFormaPago;
	}

	public void setActivarid_ejercicioFormaPago(Boolean activarid_ejercicioFormaPago) {
		this.activarid_ejercicioFormaPago= activarid_ejercicioFormaPago;
	}

	public Boolean getCargarid_ejercicioFormaPago() {
		return this.cargarid_ejercicioFormaPago;
	}

	public void setCargarid_ejercicioFormaPago(Boolean cargarid_ejercicioFormaPago) {
		this.cargarid_ejercicioFormaPago= cargarid_ejercicioFormaPago;
	}

	public Border setResaltarid_periodoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_periodoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoFormaPago() {
		return this.resaltarid_periodoFormaPago;
	}

	public void setResaltarid_periodoFormaPago(Border borderResaltar) {
		this.resaltarid_periodoFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_periodoFormaPago() {
		return this.mostrarid_periodoFormaPago;
	}

	public void setMostrarid_periodoFormaPago(Boolean mostrarid_periodoFormaPago) {
		this.mostrarid_periodoFormaPago= mostrarid_periodoFormaPago;
	}

	public Boolean getActivarid_periodoFormaPago() {
		return this.activarid_periodoFormaPago;
	}

	public void setActivarid_periodoFormaPago(Boolean activarid_periodoFormaPago) {
		this.activarid_periodoFormaPago= activarid_periodoFormaPago;
	}

	public Boolean getCargarid_periodoFormaPago() {
		return this.cargarid_periodoFormaPago;
	}

	public void setCargarid_periodoFormaPago(Boolean cargarid_periodoFormaPago) {
		this.cargarid_periodoFormaPago= cargarid_periodoFormaPago;
	}

	public Border setResaltarid_anioFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_anioFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioFormaPago() {
		return this.resaltarid_anioFormaPago;
	}

	public void setResaltarid_anioFormaPago(Border borderResaltar) {
		this.resaltarid_anioFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_anioFormaPago() {
		return this.mostrarid_anioFormaPago;
	}

	public void setMostrarid_anioFormaPago(Boolean mostrarid_anioFormaPago) {
		this.mostrarid_anioFormaPago= mostrarid_anioFormaPago;
	}

	public Boolean getActivarid_anioFormaPago() {
		return this.activarid_anioFormaPago;
	}

	public void setActivarid_anioFormaPago(Boolean activarid_anioFormaPago) {
		this.activarid_anioFormaPago= activarid_anioFormaPago;
	}

	public Boolean getCargarid_anioFormaPago() {
		return this.cargarid_anioFormaPago;
	}

	public void setCargarid_anioFormaPago(Boolean cargarid_anioFormaPago) {
		this.cargarid_anioFormaPago= cargarid_anioFormaPago;
	}

	public Border setResaltarid_mesFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_mesFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesFormaPago() {
		return this.resaltarid_mesFormaPago;
	}

	public void setResaltarid_mesFormaPago(Border borderResaltar) {
		this.resaltarid_mesFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_mesFormaPago() {
		return this.mostrarid_mesFormaPago;
	}

	public void setMostrarid_mesFormaPago(Boolean mostrarid_mesFormaPago) {
		this.mostrarid_mesFormaPago= mostrarid_mesFormaPago;
	}

	public Boolean getActivarid_mesFormaPago() {
		return this.activarid_mesFormaPago;
	}

	public void setActivarid_mesFormaPago(Boolean activarid_mesFormaPago) {
		this.activarid_mesFormaPago= activarid_mesFormaPago;
	}

	public Boolean getCargarid_mesFormaPago() {
		return this.cargarid_mesFormaPago;
	}

	public void setCargarid_mesFormaPago(Boolean cargarid_mesFormaPago) {
		this.cargarid_mesFormaPago= cargarid_mesFormaPago;
	}

	public Border setResaltarid_tipo_forma_pagoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_tipo_forma_pagoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_forma_pagoFormaPago() {
		return this.resaltarid_tipo_forma_pagoFormaPago;
	}

	public void setResaltarid_tipo_forma_pagoFormaPago(Border borderResaltar) {
		this.resaltarid_tipo_forma_pagoFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_tipo_forma_pagoFormaPago() {
		return this.mostrarid_tipo_forma_pagoFormaPago;
	}

	public void setMostrarid_tipo_forma_pagoFormaPago(Boolean mostrarid_tipo_forma_pagoFormaPago) {
		this.mostrarid_tipo_forma_pagoFormaPago= mostrarid_tipo_forma_pagoFormaPago;
	}

	public Boolean getActivarid_tipo_forma_pagoFormaPago() {
		return this.activarid_tipo_forma_pagoFormaPago;
	}

	public void setActivarid_tipo_forma_pagoFormaPago(Boolean activarid_tipo_forma_pagoFormaPago) {
		this.activarid_tipo_forma_pagoFormaPago= activarid_tipo_forma_pagoFormaPago;
	}

	public Boolean getCargarid_tipo_forma_pagoFormaPago() {
		return this.cargarid_tipo_forma_pagoFormaPago;
	}

	public void setCargarid_tipo_forma_pagoFormaPago(Boolean cargarid_tipo_forma_pagoFormaPago) {
		this.cargarid_tipo_forma_pagoFormaPago= cargarid_tipo_forma_pagoFormaPago;
	}

	public Border setResaltarnombreFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarnombreFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreFormaPago() {
		return this.resaltarnombreFormaPago;
	}

	public void setResaltarnombreFormaPago(Border borderResaltar) {
		this.resaltarnombreFormaPago= borderResaltar;
	}

	public Boolean getMostrarnombreFormaPago() {
		return this.mostrarnombreFormaPago;
	}

	public void setMostrarnombreFormaPago(Boolean mostrarnombreFormaPago) {
		this.mostrarnombreFormaPago= mostrarnombreFormaPago;
	}

	public Boolean getActivarnombreFormaPago() {
		return this.activarnombreFormaPago;
	}

	public void setActivarnombreFormaPago(Boolean activarnombreFormaPago) {
		this.activarnombreFormaPago= activarnombreFormaPago;
	}

	public Border setResaltarsiglasFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarsiglasFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsiglasFormaPago() {
		return this.resaltarsiglasFormaPago;
	}

	public void setResaltarsiglasFormaPago(Border borderResaltar) {
		this.resaltarsiglasFormaPago= borderResaltar;
	}

	public Boolean getMostrarsiglasFormaPago() {
		return this.mostrarsiglasFormaPago;
	}

	public void setMostrarsiglasFormaPago(Boolean mostrarsiglasFormaPago) {
		this.mostrarsiglasFormaPago= mostrarsiglasFormaPago;
	}

	public Boolean getActivarsiglasFormaPago() {
		return this.activarsiglasFormaPago;
	}

	public void setActivarsiglasFormaPago(Boolean activarsiglasFormaPago) {
		this.activarsiglasFormaPago= activarsiglasFormaPago;
	}

	public Border setResaltarnumero_diasFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarnumero_diasFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_diasFormaPago() {
		return this.resaltarnumero_diasFormaPago;
	}

	public void setResaltarnumero_diasFormaPago(Border borderResaltar) {
		this.resaltarnumero_diasFormaPago= borderResaltar;
	}

	public Boolean getMostrarnumero_diasFormaPago() {
		return this.mostrarnumero_diasFormaPago;
	}

	public void setMostrarnumero_diasFormaPago(Boolean mostrarnumero_diasFormaPago) {
		this.mostrarnumero_diasFormaPago= mostrarnumero_diasFormaPago;
	}

	public Boolean getActivarnumero_diasFormaPago() {
		return this.activarnumero_diasFormaPago;
	}

	public void setActivarnumero_diasFormaPago(Boolean activarnumero_diasFormaPago) {
		this.activarnumero_diasFormaPago= activarnumero_diasFormaPago;
	}

	public Border setResaltarporcentajeFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarporcentajeFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeFormaPago() {
		return this.resaltarporcentajeFormaPago;
	}

	public void setResaltarporcentajeFormaPago(Border borderResaltar) {
		this.resaltarporcentajeFormaPago= borderResaltar;
	}

	public Boolean getMostrarporcentajeFormaPago() {
		return this.mostrarporcentajeFormaPago;
	}

	public void setMostrarporcentajeFormaPago(Boolean mostrarporcentajeFormaPago) {
		this.mostrarporcentajeFormaPago= mostrarporcentajeFormaPago;
	}

	public Boolean getActivarporcentajeFormaPago() {
		return this.activarporcentajeFormaPago;
	}

	public void setActivarporcentajeFormaPago(Boolean activarporcentajeFormaPago) {
		this.activarporcentajeFormaPago= activarporcentajeFormaPago;
	}

	public Border setResaltarvalorFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarvalorFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorFormaPago() {
		return this.resaltarvalorFormaPago;
	}

	public void setResaltarvalorFormaPago(Border borderResaltar) {
		this.resaltarvalorFormaPago= borderResaltar;
	}

	public Boolean getMostrarvalorFormaPago() {
		return this.mostrarvalorFormaPago;
	}

	public void setMostrarvalorFormaPago(Boolean mostrarvalorFormaPago) {
		this.mostrarvalorFormaPago= mostrarvalorFormaPago;
	}

	public Boolean getActivarvalorFormaPago() {
		return this.activarvalorFormaPago;
	}

	public void setActivarvalorFormaPago(Boolean activarvalorFormaPago) {
		this.activarvalorFormaPago= activarvalorFormaPago;
	}

	public Border setResaltarcon_detalleFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarcon_detalleFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_detalleFormaPago() {
		return this.resaltarcon_detalleFormaPago;
	}

	public void setResaltarcon_detalleFormaPago(Border borderResaltar) {
		this.resaltarcon_detalleFormaPago= borderResaltar;
	}

	public Boolean getMostrarcon_detalleFormaPago() {
		return this.mostrarcon_detalleFormaPago;
	}

	public void setMostrarcon_detalleFormaPago(Boolean mostrarcon_detalleFormaPago) {
		this.mostrarcon_detalleFormaPago= mostrarcon_detalleFormaPago;
	}

	public Boolean getActivarcon_detalleFormaPago() {
		return this.activarcon_detalleFormaPago;
	}

	public void setActivarcon_detalleFormaPago(Boolean activarcon_detalleFormaPago) {
		this.activarcon_detalleFormaPago= activarcon_detalleFormaPago;
	}

	public Border setResaltarcon_remesaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarcon_remesaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_remesaFormaPago() {
		return this.resaltarcon_remesaFormaPago;
	}

	public void setResaltarcon_remesaFormaPago(Border borderResaltar) {
		this.resaltarcon_remesaFormaPago= borderResaltar;
	}

	public Boolean getMostrarcon_remesaFormaPago() {
		return this.mostrarcon_remesaFormaPago;
	}

	public void setMostrarcon_remesaFormaPago(Boolean mostrarcon_remesaFormaPago) {
		this.mostrarcon_remesaFormaPago= mostrarcon_remesaFormaPago;
	}

	public Boolean getActivarcon_remesaFormaPago() {
		return this.activarcon_remesaFormaPago;
	}

	public void setActivarcon_remesaFormaPago(Boolean activarcon_remesaFormaPago) {
		this.activarcon_remesaFormaPago= activarcon_remesaFormaPago;
	}

	public Border setResaltarcon_maneja_cuotasFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarcon_maneja_cuotasFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_maneja_cuotasFormaPago() {
		return this.resaltarcon_maneja_cuotasFormaPago;
	}

	public void setResaltarcon_maneja_cuotasFormaPago(Border borderResaltar) {
		this.resaltarcon_maneja_cuotasFormaPago= borderResaltar;
	}

	public Boolean getMostrarcon_maneja_cuotasFormaPago() {
		return this.mostrarcon_maneja_cuotasFormaPago;
	}

	public void setMostrarcon_maneja_cuotasFormaPago(Boolean mostrarcon_maneja_cuotasFormaPago) {
		this.mostrarcon_maneja_cuotasFormaPago= mostrarcon_maneja_cuotasFormaPago;
	}

	public Boolean getActivarcon_maneja_cuotasFormaPago() {
		return this.activarcon_maneja_cuotasFormaPago;
	}

	public void setActivarcon_maneja_cuotasFormaPago(Boolean activarcon_maneja_cuotasFormaPago) {
		this.activarcon_maneja_cuotasFormaPago= activarcon_maneja_cuotasFormaPago;
	}

	public Border setResaltarfechaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarfechaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaFormaPago() {
		return this.resaltarfechaFormaPago;
	}

	public void setResaltarfechaFormaPago(Border borderResaltar) {
		this.resaltarfechaFormaPago= borderResaltar;
	}

	public Boolean getMostrarfechaFormaPago() {
		return this.mostrarfechaFormaPago;
	}

	public void setMostrarfechaFormaPago(Boolean mostrarfechaFormaPago) {
		this.mostrarfechaFormaPago= mostrarfechaFormaPago;
	}

	public Boolean getActivarfechaFormaPago() {
		return this.activarfechaFormaPago;
	}

	public void setActivarfechaFormaPago(Boolean activarfechaFormaPago) {
		this.activarfechaFormaPago= activarfechaFormaPago;
	}

	public Border setResaltarfecha_finFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarfecha_finFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finFormaPago() {
		return this.resaltarfecha_finFormaPago;
	}

	public void setResaltarfecha_finFormaPago(Border borderResaltar) {
		this.resaltarfecha_finFormaPago= borderResaltar;
	}

	public Boolean getMostrarfecha_finFormaPago() {
		return this.mostrarfecha_finFormaPago;
	}

	public void setMostrarfecha_finFormaPago(Boolean mostrarfecha_finFormaPago) {
		this.mostrarfecha_finFormaPago= mostrarfecha_finFormaPago;
	}

	public Boolean getActivarfecha_finFormaPago() {
		return this.activarfecha_finFormaPago;
	}

	public void setActivarfecha_finFormaPago(Boolean activarfecha_finFormaPago) {
		this.activarfecha_finFormaPago= activarfecha_finFormaPago;
	}

	public Border setResaltarid_transaccionFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_transaccionFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionFormaPago() {
		return this.resaltarid_transaccionFormaPago;
	}

	public void setResaltarid_transaccionFormaPago(Border borderResaltar) {
		this.resaltarid_transaccionFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_transaccionFormaPago() {
		return this.mostrarid_transaccionFormaPago;
	}

	public void setMostrarid_transaccionFormaPago(Boolean mostrarid_transaccionFormaPago) {
		this.mostrarid_transaccionFormaPago= mostrarid_transaccionFormaPago;
	}

	public Boolean getActivarid_transaccionFormaPago() {
		return this.activarid_transaccionFormaPago;
	}

	public void setActivarid_transaccionFormaPago(Boolean activarid_transaccionFormaPago) {
		this.activarid_transaccionFormaPago= activarid_transaccionFormaPago;
	}

	public Boolean getCargarid_transaccionFormaPago() {
		return this.cargarid_transaccionFormaPago;
	}

	public void setCargarid_transaccionFormaPago(Boolean cargarid_transaccionFormaPago) {
		this.cargarid_transaccionFormaPago= cargarid_transaccionFormaPago;
	}

	public Border setResaltarid_tipo_transaccion_moduloFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_tipo_transaccion_moduloFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_transaccion_moduloFormaPago() {
		return this.resaltarid_tipo_transaccion_moduloFormaPago;
	}

	public void setResaltarid_tipo_transaccion_moduloFormaPago(Border borderResaltar) {
		this.resaltarid_tipo_transaccion_moduloFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_tipo_transaccion_moduloFormaPago() {
		return this.mostrarid_tipo_transaccion_moduloFormaPago;
	}

	public void setMostrarid_tipo_transaccion_moduloFormaPago(Boolean mostrarid_tipo_transaccion_moduloFormaPago) {
		this.mostrarid_tipo_transaccion_moduloFormaPago= mostrarid_tipo_transaccion_moduloFormaPago;
	}

	public Boolean getActivarid_tipo_transaccion_moduloFormaPago() {
		return this.activarid_tipo_transaccion_moduloFormaPago;
	}

	public void setActivarid_tipo_transaccion_moduloFormaPago(Boolean activarid_tipo_transaccion_moduloFormaPago) {
		this.activarid_tipo_transaccion_moduloFormaPago= activarid_tipo_transaccion_moduloFormaPago;
	}

	public Boolean getCargarid_tipo_transaccion_moduloFormaPago() {
		return this.cargarid_tipo_transaccion_moduloFormaPago;
	}

	public void setCargarid_tipo_transaccion_moduloFormaPago(Boolean cargarid_tipo_transaccion_moduloFormaPago) {
		this.cargarid_tipo_transaccion_moduloFormaPago= cargarid_tipo_transaccion_moduloFormaPago;
	}

	public Border setResaltarid_cuenta_contableFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableFormaPago() {
		return this.resaltarid_cuenta_contableFormaPago;
	}

	public void setResaltarid_cuenta_contableFormaPago(Border borderResaltar) {
		this.resaltarid_cuenta_contableFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableFormaPago() {
		return this.mostrarid_cuenta_contableFormaPago;
	}

	public void setMostrarid_cuenta_contableFormaPago(Boolean mostrarid_cuenta_contableFormaPago) {
		this.mostrarid_cuenta_contableFormaPago= mostrarid_cuenta_contableFormaPago;
	}

	public Boolean getActivarid_cuenta_contableFormaPago() {
		return this.activarid_cuenta_contableFormaPago;
	}

	public void setActivarid_cuenta_contableFormaPago(Boolean activarid_cuenta_contableFormaPago) {
		this.activarid_cuenta_contableFormaPago= activarid_cuenta_contableFormaPago;
	}

	public Boolean getCargarid_cuenta_contableFormaPago() {
		return this.cargarid_cuenta_contableFormaPago;
	}

	public void setCargarid_cuenta_contableFormaPago(Boolean cargarid_cuenta_contableFormaPago) {
		this.cargarid_cuenta_contableFormaPago= cargarid_cuenta_contableFormaPago;
	}

	public Border setResaltarid_cuenta_contable_reteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_reteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_reteFormaPago() {
		return this.resaltarid_cuenta_contable_reteFormaPago;
	}

	public void setResaltarid_cuenta_contable_reteFormaPago(Border borderResaltar) {
		this.resaltarid_cuenta_contable_reteFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_reteFormaPago() {
		return this.mostrarid_cuenta_contable_reteFormaPago;
	}

	public void setMostrarid_cuenta_contable_reteFormaPago(Boolean mostrarid_cuenta_contable_reteFormaPago) {
		this.mostrarid_cuenta_contable_reteFormaPago= mostrarid_cuenta_contable_reteFormaPago;
	}

	public Boolean getActivarid_cuenta_contable_reteFormaPago() {
		return this.activarid_cuenta_contable_reteFormaPago;
	}

	public void setActivarid_cuenta_contable_reteFormaPago(Boolean activarid_cuenta_contable_reteFormaPago) {
		this.activarid_cuenta_contable_reteFormaPago= activarid_cuenta_contable_reteFormaPago;
	}

	public Boolean getCargarid_cuenta_contable_reteFormaPago() {
		return this.cargarid_cuenta_contable_reteFormaPago;
	}

	public void setCargarid_cuenta_contable_reteFormaPago(Boolean cargarid_cuenta_contable_reteFormaPago) {
		this.cargarid_cuenta_contable_reteFormaPago= cargarid_cuenta_contable_reteFormaPago;
	}

	public Border setResaltarporcentaje_reteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarporcentaje_reteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_reteFormaPago() {
		return this.resaltarporcentaje_reteFormaPago;
	}

	public void setResaltarporcentaje_reteFormaPago(Border borderResaltar) {
		this.resaltarporcentaje_reteFormaPago= borderResaltar;
	}

	public Boolean getMostrarporcentaje_reteFormaPago() {
		return this.mostrarporcentaje_reteFormaPago;
	}

	public void setMostrarporcentaje_reteFormaPago(Boolean mostrarporcentaje_reteFormaPago) {
		this.mostrarporcentaje_reteFormaPago= mostrarporcentaje_reteFormaPago;
	}

	public Boolean getActivarporcentaje_reteFormaPago() {
		return this.activarporcentaje_reteFormaPago;
	}

	public void setActivarporcentaje_reteFormaPago(Boolean activarporcentaje_reteFormaPago) {
		this.activarporcentaje_reteFormaPago= activarporcentaje_reteFormaPago;
	}

	public Border setResaltarbase_retencionFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarbase_retencionFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbase_retencionFormaPago() {
		return this.resaltarbase_retencionFormaPago;
	}

	public void setResaltarbase_retencionFormaPago(Border borderResaltar) {
		this.resaltarbase_retencionFormaPago= borderResaltar;
	}

	public Boolean getMostrarbase_retencionFormaPago() {
		return this.mostrarbase_retencionFormaPago;
	}

	public void setMostrarbase_retencionFormaPago(Boolean mostrarbase_retencionFormaPago) {
		this.mostrarbase_retencionFormaPago= mostrarbase_retencionFormaPago;
	}

	public Boolean getActivarbase_retencionFormaPago() {
		return this.activarbase_retencionFormaPago;
	}

	public void setActivarbase_retencionFormaPago(Boolean activarbase_retencionFormaPago) {
		this.activarbase_retencionFormaPago= activarbase_retencionFormaPago;
	}

	public Border setResaltarvalor_retencionFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarvalor_retencionFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_retencionFormaPago() {
		return this.resaltarvalor_retencionFormaPago;
	}

	public void setResaltarvalor_retencionFormaPago(Border borderResaltar) {
		this.resaltarvalor_retencionFormaPago= borderResaltar;
	}

	public Boolean getMostrarvalor_retencionFormaPago() {
		return this.mostrarvalor_retencionFormaPago;
	}

	public void setMostrarvalor_retencionFormaPago(Boolean mostrarvalor_retencionFormaPago) {
		this.mostrarvalor_retencionFormaPago= mostrarvalor_retencionFormaPago;
	}

	public Boolean getActivarvalor_retencionFormaPago() {
		return this.activarvalor_retencionFormaPago;
	}

	public void setActivarvalor_retencionFormaPago(Boolean activarvalor_retencionFormaPago) {
		this.activarvalor_retencionFormaPago= activarvalor_retencionFormaPago;
	}

	public Border setResaltarnumero_retencionFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarnumero_retencionFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_retencionFormaPago() {
		return this.resaltarnumero_retencionFormaPago;
	}

	public void setResaltarnumero_retencionFormaPago(Border borderResaltar) {
		this.resaltarnumero_retencionFormaPago= borderResaltar;
	}

	public Boolean getMostrarnumero_retencionFormaPago() {
		return this.mostrarnumero_retencionFormaPago;
	}

	public void setMostrarnumero_retencionFormaPago(Boolean mostrarnumero_retencionFormaPago) {
		this.mostrarnumero_retencionFormaPago= mostrarnumero_retencionFormaPago;
	}

	public Boolean getActivarnumero_retencionFormaPago() {
		return this.activarnumero_retencionFormaPago;
	}

	public void setActivarnumero_retencionFormaPago(Boolean activarnumero_retencionFormaPago) {
		this.activarnumero_retencionFormaPago= activarnumero_retencionFormaPago;
	}

	public Border setResaltarnombre_retencionFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltar);
		
		this.resaltarnombre_retencionFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_retencionFormaPago() {
		return this.resaltarnombre_retencionFormaPago;
	}

	public void setResaltarnombre_retencionFormaPago(Border borderResaltar) {
		this.resaltarnombre_retencionFormaPago= borderResaltar;
	}

	public Boolean getMostrarnombre_retencionFormaPago() {
		return this.mostrarnombre_retencionFormaPago;
	}

	public void setMostrarnombre_retencionFormaPago(Boolean mostrarnombre_retencionFormaPago) {
		this.mostrarnombre_retencionFormaPago= mostrarnombre_retencionFormaPago;
	}

	public Boolean getActivarnombre_retencionFormaPago() {
		return this.activarnombre_retencionFormaPago;
	}

	public void setActivarnombre_retencionFormaPago(Boolean activarnombre_retencionFormaPago) {
		this.activarnombre_retencionFormaPago= activarnombre_retencionFormaPago;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridFormaPago(esInicial);
		this.setMostrarid_empresaFormaPago(esInicial);
		this.setMostrarid_sucursalFormaPago(esInicial);
		this.setMostrarid_moduloFormaPago(esInicial);
		this.setMostrarid_ejercicioFormaPago(esInicial);
		this.setMostrarid_periodoFormaPago(esInicial);
		this.setMostrarid_anioFormaPago(esInicial);
		this.setMostrarid_mesFormaPago(esInicial);
		this.setMostrarid_tipo_forma_pagoFormaPago(esInicial);
		this.setMostrarnombreFormaPago(esInicial);
		this.setMostrarsiglasFormaPago(esInicial);
		this.setMostrarnumero_diasFormaPago(esInicial);
		this.setMostrarporcentajeFormaPago(esInicial);
		this.setMostrarvalorFormaPago(esInicial);
		this.setMostrarcon_detalleFormaPago(esInicial);
		this.setMostrarcon_remesaFormaPago(esInicial);
		this.setMostrarcon_maneja_cuotasFormaPago(esInicial);
		this.setMostrarfechaFormaPago(esInicial);
		this.setMostrarfecha_finFormaPago(esInicial);
		this.setMostrarid_transaccionFormaPago(esInicial);
		this.setMostrarid_tipo_transaccion_moduloFormaPago(esInicial);
		this.setMostrarid_cuenta_contableFormaPago(esInicial);
		this.setMostrarid_cuenta_contable_reteFormaPago(esInicial);
		this.setMostrarporcentaje_reteFormaPago(esInicial);
		this.setMostrarbase_retencionFormaPago(esInicial);
		this.setMostrarvalor_retencionFormaPago(esInicial);
		this.setMostrarnumero_retencionFormaPago(esInicial);
		this.setMostrarnombre_retencionFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormaPagoConstantesFunciones.ID)) {
				this.setMostraridFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDMES)) {
				this.setMostrarid_mesFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setMostrarid_tipo_forma_pagoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.SIGLAS)) {
				this.setMostrarsiglasFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.NUMERODIAS)) {
				this.setMostrarnumero_diasFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.VALOR)) {
				this.setMostrarvalorFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.CONDETALLE)) {
				this.setMostrarcon_detalleFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.CONREMESA)) {
				this.setMostrarcon_remesaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.CONMANEJACUOTAS)) {
				this.setMostrarcon_maneja_cuotasFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.FECHA)) {
				this.setMostrarfechaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setMostrarid_tipo_transaccion_moduloFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDCUENTACONTABLERETE)) {
				this.setMostrarid_cuenta_contable_reteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.PORCENTAJERETE)) {
				this.setMostrarporcentaje_reteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.BASERETENCION)) {
				this.setMostrarbase_retencionFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.VALORRETENCION)) {
				this.setMostrarvalor_retencionFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.NUMERORETENCION)) {
				this.setMostrarnumero_retencionFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.NOMBRERETENCION)) {
				this.setMostrarnombre_retencionFormaPago(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridFormaPago(esInicial);
		this.setActivarid_empresaFormaPago(esInicial);
		this.setActivarid_sucursalFormaPago(esInicial);
		this.setActivarid_moduloFormaPago(esInicial);
		this.setActivarid_ejercicioFormaPago(esInicial);
		this.setActivarid_periodoFormaPago(esInicial);
		this.setActivarid_anioFormaPago(esInicial);
		this.setActivarid_mesFormaPago(esInicial);
		this.setActivarid_tipo_forma_pagoFormaPago(esInicial);
		this.setActivarnombreFormaPago(esInicial);
		this.setActivarsiglasFormaPago(esInicial);
		this.setActivarnumero_diasFormaPago(esInicial);
		this.setActivarporcentajeFormaPago(esInicial);
		this.setActivarvalorFormaPago(esInicial);
		this.setActivarcon_detalleFormaPago(esInicial);
		this.setActivarcon_remesaFormaPago(esInicial);
		this.setActivarcon_maneja_cuotasFormaPago(esInicial);
		this.setActivarfechaFormaPago(esInicial);
		this.setActivarfecha_finFormaPago(esInicial);
		this.setActivarid_transaccionFormaPago(esInicial);
		this.setActivarid_tipo_transaccion_moduloFormaPago(esInicial);
		this.setActivarid_cuenta_contableFormaPago(esInicial);
		this.setActivarid_cuenta_contable_reteFormaPago(esInicial);
		this.setActivarporcentaje_reteFormaPago(esInicial);
		this.setActivarbase_retencionFormaPago(esInicial);
		this.setActivarvalor_retencionFormaPago(esInicial);
		this.setActivarnumero_retencionFormaPago(esInicial);
		this.setActivarnombre_retencionFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormaPagoConstantesFunciones.ID)) {
				this.setActivaridFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDANIO)) {
				this.setActivarid_anioFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDMES)) {
				this.setActivarid_mesFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setActivarid_tipo_forma_pagoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.SIGLAS)) {
				this.setActivarsiglasFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.NUMERODIAS)) {
				this.setActivarnumero_diasFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.VALOR)) {
				this.setActivarvalorFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.CONDETALLE)) {
				this.setActivarcon_detalleFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.CONREMESA)) {
				this.setActivarcon_remesaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.CONMANEJACUOTAS)) {
				this.setActivarcon_maneja_cuotasFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.FECHA)) {
				this.setActivarfechaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setActivarid_tipo_transaccion_moduloFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDCUENTACONTABLERETE)) {
				this.setActivarid_cuenta_contable_reteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.PORCENTAJERETE)) {
				this.setActivarporcentaje_reteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.BASERETENCION)) {
				this.setActivarbase_retencionFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.VALORRETENCION)) {
				this.setActivarvalor_retencionFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.NUMERORETENCION)) {
				this.setActivarnumero_retencionFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.NOMBRERETENCION)) {
				this.setActivarnombre_retencionFormaPago(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFormaPago(esInicial);
		this.setResaltarid_empresaFormaPago(esInicial);
		this.setResaltarid_sucursalFormaPago(esInicial);
		this.setResaltarid_moduloFormaPago(esInicial);
		this.setResaltarid_ejercicioFormaPago(esInicial);
		this.setResaltarid_periodoFormaPago(esInicial);
		this.setResaltarid_anioFormaPago(esInicial);
		this.setResaltarid_mesFormaPago(esInicial);
		this.setResaltarid_tipo_forma_pagoFormaPago(esInicial);
		this.setResaltarnombreFormaPago(esInicial);
		this.setResaltarsiglasFormaPago(esInicial);
		this.setResaltarnumero_diasFormaPago(esInicial);
		this.setResaltarporcentajeFormaPago(esInicial);
		this.setResaltarvalorFormaPago(esInicial);
		this.setResaltarcon_detalleFormaPago(esInicial);
		this.setResaltarcon_remesaFormaPago(esInicial);
		this.setResaltarcon_maneja_cuotasFormaPago(esInicial);
		this.setResaltarfechaFormaPago(esInicial);
		this.setResaltarfecha_finFormaPago(esInicial);
		this.setResaltarid_transaccionFormaPago(esInicial);
		this.setResaltarid_tipo_transaccion_moduloFormaPago(esInicial);
		this.setResaltarid_cuenta_contableFormaPago(esInicial);
		this.setResaltarid_cuenta_contable_reteFormaPago(esInicial);
		this.setResaltarporcentaje_reteFormaPago(esInicial);
		this.setResaltarbase_retencionFormaPago(esInicial);
		this.setResaltarvalor_retencionFormaPago(esInicial);
		this.setResaltarnumero_retencionFormaPago(esInicial);
		this.setResaltarnombre_retencionFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormaPagoConstantesFunciones.ID)) {
				this.setResaltaridFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDMES)) {
				this.setResaltarid_mesFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setResaltarid_tipo_forma_pagoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.SIGLAS)) {
				this.setResaltarsiglasFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.NUMERODIAS)) {
				this.setResaltarnumero_diasFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.VALOR)) {
				this.setResaltarvalorFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.CONDETALLE)) {
				this.setResaltarcon_detalleFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.CONREMESA)) {
				this.setResaltarcon_remesaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.CONMANEJACUOTAS)) {
				this.setResaltarcon_maneja_cuotasFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.FECHA)) {
				this.setResaltarfechaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setResaltarid_tipo_transaccion_moduloFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.IDCUENTACONTABLERETE)) {
				this.setResaltarid_cuenta_contable_reteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.PORCENTAJERETE)) {
				this.setResaltarporcentaje_reteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.BASERETENCION)) {
				this.setResaltarbase_retencionFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.VALORRETENCION)) {
				this.setResaltarvalor_retencionFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.NUMERORETENCION)) {
				this.setResaltarnumero_retencionFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoConstantesFunciones.NOMBRERETENCION)) {
				this.setResaltarnombre_retencionFormaPago(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFormularioRentaExtraFormaPago=null;

	public Border getResaltarFormularioRentaExtraFormaPago() {
		return this.resaltarFormularioRentaExtraFormaPago;
	}

	public void setResaltarFormularioRentaExtraFormaPago(Border borderResaltarFormularioRentaExtra) {
		if(borderResaltarFormularioRentaExtra!=null) {
			this.resaltarFormularioRentaExtraFormaPago= borderResaltarFormularioRentaExtra;
		}
	}

	public Border setResaltarFormularioRentaExtraFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltarFormularioRentaExtra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//formapagoBeanSwingJInternalFrame.jTtoolBarFormaPago.setBorder(borderResaltarFormularioRentaExtra);
			
		this.resaltarFormularioRentaExtraFormaPago= borderResaltarFormularioRentaExtra;

		 return borderResaltarFormularioRentaExtra;
	}



	public Boolean mostrarFormularioRentaExtraFormaPago=true;

	public Boolean getMostrarFormularioRentaExtraFormaPago() {
		return this.mostrarFormularioRentaExtraFormaPago;
	}

	public void setMostrarFormularioRentaExtraFormaPago(Boolean visibilidadResaltarFormularioRentaExtra) {
		this.mostrarFormularioRentaExtraFormaPago= visibilidadResaltarFormularioRentaExtra;
	}



	public Boolean activarFormularioRentaExtraFormaPago=true;

	public Boolean gethabilitarResaltarFormularioRentaExtraFormaPago() {
		return this.activarFormularioRentaExtraFormaPago;
	}

	public void setActivarFormularioRentaExtraFormaPago(Boolean habilitarResaltarFormularioRentaExtra) {
		this.activarFormularioRentaExtraFormaPago= habilitarResaltarFormularioRentaExtra;
	}
		
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setMostrarFormularioRentaExtraFormaPago(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormularioRentaExtra.class)) {
				this.setMostrarFormularioRentaExtraFormaPago(esAsigna);
				continue;
			}
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setActivarFormularioRentaExtraFormaPago(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormularioRentaExtra.class)) {
				this.setActivarFormularioRentaExtraFormaPago(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFormularioRentaExtraFormaPago(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormularioRentaExtra.class)) {
				this.setResaltarFormularioRentaExtraFormaPago(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorNombreFormaPago=true;

	public Boolean getMostrarBusquedaPorNombreFormaPago() {
		return this.mostrarBusquedaPorNombreFormaPago;
	}

	public void setMostrarBusquedaPorNombreFormaPago(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorSiglasFormaPago=true;

	public Boolean getMostrarBusquedaPorSiglasFormaPago() {
		return this.mostrarBusquedaPorSiglasFormaPago;
	}

	public void setMostrarBusquedaPorSiglasFormaPago(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorSiglasFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableFormaPago=true;

	public Boolean getMostrarFK_IdCuentaContableFormaPago() {
		return this.mostrarFK_IdCuentaContableFormaPago;
	}

	public void setMostrarFK_IdCuentaContableFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableReteFormaPago=true;

	public Boolean getMostrarFK_IdCuentaContableReteFormaPago() {
		return this.mostrarFK_IdCuentaContableReteFormaPago;
	}

	public void setMostrarFK_IdCuentaContableReteFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableReteFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioFormaPago=true;

	public Boolean getMostrarFK_IdEjercicioFormaPago() {
		return this.mostrarFK_IdEjercicioFormaPago;
	}

	public void setMostrarFK_IdEjercicioFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaFormaPago=true;

	public Boolean getMostrarFK_IdEmpresaFormaPago() {
		return this.mostrarFK_IdEmpresaFormaPago;
	}

	public void setMostrarFK_IdEmpresaFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloFormaPago=true;

	public Boolean getMostrarFK_IdModuloFormaPago() {
		return this.mostrarFK_IdModuloFormaPago;
	}

	public void setMostrarFK_IdModuloFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoFormaPago=true;

	public Boolean getMostrarFK_IdPeriodoFormaPago() {
		return this.mostrarFK_IdPeriodoFormaPago;
	}

	public void setMostrarFK_IdPeriodoFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalFormaPago=true;

	public Boolean getMostrarFK_IdSucursalFormaPago() {
		return this.mostrarFK_IdSucursalFormaPago;
	}

	public void setMostrarFK_IdSucursalFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoFormaPagoFormaPago=true;

	public Boolean getMostrarFK_IdTipoFormaPagoFormaPago() {
		return this.mostrarFK_IdTipoFormaPagoFormaPago;
	}

	public void setMostrarFK_IdTipoFormaPagoFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoFormaPagoFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTransaccionModuloFormaPago=true;

	public Boolean getMostrarFK_IdTipoTransaccionModuloFormaPago() {
		return this.mostrarFK_IdTipoTransaccionModuloFormaPago;
	}

	public void setMostrarFK_IdTipoTransaccionModuloFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTransaccionModuloFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionFormaPago=true;

	public Boolean getMostrarFK_IdTransaccionFormaPago() {
		return this.mostrarFK_IdTransaccionFormaPago;
	}

	public void setMostrarFK_IdTransaccionFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionFormaPago= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreFormaPago=true;

	public Boolean getActivarBusquedaPorNombreFormaPago() {
		return this.activarBusquedaPorNombreFormaPago;
	}

	public void setActivarBusquedaPorNombreFormaPago(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreFormaPago= habilitarResaltar;
	}

	public Boolean activarBusquedaPorSiglasFormaPago=true;

	public Boolean getActivarBusquedaPorSiglasFormaPago() {
		return this.activarBusquedaPorSiglasFormaPago;
	}

	public void setActivarBusquedaPorSiglasFormaPago(Boolean habilitarResaltar) {
		this.activarBusquedaPorSiglasFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableFormaPago=true;

	public Boolean getActivarFK_IdCuentaContableFormaPago() {
		return this.activarFK_IdCuentaContableFormaPago;
	}

	public void setActivarFK_IdCuentaContableFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableReteFormaPago=true;

	public Boolean getActivarFK_IdCuentaContableReteFormaPago() {
		return this.activarFK_IdCuentaContableReteFormaPago;
	}

	public void setActivarFK_IdCuentaContableReteFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableReteFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioFormaPago=true;

	public Boolean getActivarFK_IdEjercicioFormaPago() {
		return this.activarFK_IdEjercicioFormaPago;
	}

	public void setActivarFK_IdEjercicioFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaFormaPago=true;

	public Boolean getActivarFK_IdEmpresaFormaPago() {
		return this.activarFK_IdEmpresaFormaPago;
	}

	public void setActivarFK_IdEmpresaFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloFormaPago=true;

	public Boolean getActivarFK_IdModuloFormaPago() {
		return this.activarFK_IdModuloFormaPago;
	}

	public void setActivarFK_IdModuloFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdModuloFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoFormaPago=true;

	public Boolean getActivarFK_IdPeriodoFormaPago() {
		return this.activarFK_IdPeriodoFormaPago;
	}

	public void setActivarFK_IdPeriodoFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalFormaPago=true;

	public Boolean getActivarFK_IdSucursalFormaPago() {
		return this.activarFK_IdSucursalFormaPago;
	}

	public void setActivarFK_IdSucursalFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoFormaPagoFormaPago=true;

	public Boolean getActivarFK_IdTipoFormaPagoFormaPago() {
		return this.activarFK_IdTipoFormaPagoFormaPago;
	}

	public void setActivarFK_IdTipoFormaPagoFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdTipoFormaPagoFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTransaccionModuloFormaPago=true;

	public Boolean getActivarFK_IdTipoTransaccionModuloFormaPago() {
		return this.activarFK_IdTipoTransaccionModuloFormaPago;
	}

	public void setActivarFK_IdTipoTransaccionModuloFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTransaccionModuloFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionFormaPago=true;

	public Boolean getActivarFK_IdTransaccionFormaPago() {
		return this.activarFK_IdTransaccionFormaPago;
	}

	public void setActivarFK_IdTransaccionFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionFormaPago= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreFormaPago=null;

	public Border getResaltarBusquedaPorNombreFormaPago() {
		return this.resaltarBusquedaPorNombreFormaPago;
	}

	public void setResaltarBusquedaPorNombreFormaPago(Border borderResaltar) {
		this.resaltarBusquedaPorNombreFormaPago= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreFormaPago= borderResaltar;
	}

	public Border resaltarBusquedaPorSiglasFormaPago=null;

	public Border getResaltarBusquedaPorSiglasFormaPago() {
		return this.resaltarBusquedaPorSiglasFormaPago;
	}

	public void setResaltarBusquedaPorSiglasFormaPago(Border borderResaltar) {
		this.resaltarBusquedaPorSiglasFormaPago= borderResaltar;
	}

	public void setResaltarBusquedaPorSiglasFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorSiglasFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableFormaPago=null;

	public Border getResaltarFK_IdCuentaContableFormaPago() {
		return this.resaltarFK_IdCuentaContableFormaPago;
	}

	public void setResaltarFK_IdCuentaContableFormaPago(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableReteFormaPago=null;

	public Border getResaltarFK_IdCuentaContableReteFormaPago() {
		return this.resaltarFK_IdCuentaContableReteFormaPago;
	}

	public void setResaltarFK_IdCuentaContableReteFormaPago(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableReteFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableReteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableReteFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioFormaPago=null;

	public Border getResaltarFK_IdEjercicioFormaPago() {
		return this.resaltarFK_IdEjercicioFormaPago;
	}

	public void setResaltarFK_IdEjercicioFormaPago(Border borderResaltar) {
		this.resaltarFK_IdEjercicioFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaFormaPago=null;

	public Border getResaltarFK_IdEmpresaFormaPago() {
		return this.resaltarFK_IdEmpresaFormaPago;
	}

	public void setResaltarFK_IdEmpresaFormaPago(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdModuloFormaPago=null;

	public Border getResaltarFK_IdModuloFormaPago() {
		return this.resaltarFK_IdModuloFormaPago;
	}

	public void setResaltarFK_IdModuloFormaPago(Border borderResaltar) {
		this.resaltarFK_IdModuloFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdModuloFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoFormaPago=null;

	public Border getResaltarFK_IdPeriodoFormaPago() {
		return this.resaltarFK_IdPeriodoFormaPago;
	}

	public void setResaltarFK_IdPeriodoFormaPago(Border borderResaltar) {
		this.resaltarFK_IdPeriodoFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdSucursalFormaPago=null;

	public Border getResaltarFK_IdSucursalFormaPago() {
		return this.resaltarFK_IdSucursalFormaPago;
	}

	public void setResaltarFK_IdSucursalFormaPago(Border borderResaltar) {
		this.resaltarFK_IdSucursalFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdSucursalFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdTipoFormaPagoFormaPago=null;

	public Border getResaltarFK_IdTipoFormaPagoFormaPago() {
		return this.resaltarFK_IdTipoFormaPagoFormaPago;
	}

	public void setResaltarFK_IdTipoFormaPagoFormaPago(Border borderResaltar) {
		this.resaltarFK_IdTipoFormaPagoFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdTipoFormaPagoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoFormaPagoFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdTipoTransaccionModuloFormaPago=null;

	public Border getResaltarFK_IdTipoTransaccionModuloFormaPago() {
		return this.resaltarFK_IdTipoTransaccionModuloFormaPago;
	}

	public void setResaltarFK_IdTipoTransaccionModuloFormaPago(Border borderResaltar) {
		this.resaltarFK_IdTipoTransaccionModuloFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdTipoTransaccionModuloFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTransaccionModuloFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionFormaPago=null;

	public Border getResaltarFK_IdTransaccionFormaPago() {
		return this.resaltarFK_IdTransaccionFormaPago;
	}

	public void setResaltarFK_IdTransaccionFormaPago(Border borderResaltar) {
		this.resaltarFK_IdTransaccionFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoBeanSwingJInternalFrame formapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionFormaPago= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}