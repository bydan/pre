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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.HistorialFormaPagoConstantesFunciones;
import com.bydan.erp.facturacion.util.HistorialFormaPagoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.HistorialFormaPagoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class HistorialFormaPagoConstantesFunciones extends HistorialFormaPagoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="HistorialFormaPago";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="HistorialFormaPago"+HistorialFormaPagoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="HistorialFormaPagoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="HistorialFormaPagoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=HistorialFormaPagoConstantesFunciones.SCHEMA+"_"+HistorialFormaPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/HistorialFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=HistorialFormaPagoConstantesFunciones.SCHEMA+"_"+HistorialFormaPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=HistorialFormaPagoConstantesFunciones.SCHEMA+"_"+HistorialFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/HistorialFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=HistorialFormaPagoConstantesFunciones.SCHEMA+"_"+HistorialFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/HistorialFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/HistorialFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=HistorialFormaPagoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+HistorialFormaPagoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=HistorialFormaPagoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+HistorialFormaPagoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Historial Forma Pagos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Historial Forma Pago";
	public static final String SCLASSWEBTITULO_LOWER="Historial Forma Pago";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="HistorialFormaPago";
	public static final String OBJECTNAME="historialformapago";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="historial_forma_pago";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select historialformapago from "+HistorialFormaPagoConstantesFunciones.SPERSISTENCENAME+" historialformapago";
	public static String QUERYSELECTNATIVE="select "+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".id,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".version_row,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".id_empresa,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".id_sucursal,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".id_ejercicio,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".id_periodo,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".id_factura,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".id_tipo_forma_pago,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".id_cuenta_contable,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".numero_dias,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".valor,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".fecha,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".porcentaje,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".porcentaje_retencion,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".base_retencion,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".numero_retencion,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".nombre_retencion,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".id_anio,"+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME+".id_mes from "+HistorialFormaPagoConstantesFunciones.SCHEMA+"."+HistorialFormaPagoConstantesFunciones.TABLENAME;//+" as "+HistorialFormaPagoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected HistorialFormaPagoConstantesFuncionesAdditional historialformapagoConstantesFuncionesAdditional=null;
	
	public HistorialFormaPagoConstantesFuncionesAdditional getHistorialFormaPagoConstantesFuncionesAdditional() {
		return this.historialformapagoConstantesFuncionesAdditional;
	}
	
	public void setHistorialFormaPagoConstantesFuncionesAdditional(HistorialFormaPagoConstantesFuncionesAdditional historialformapagoConstantesFuncionesAdditional) {
		try {
			this.historialformapagoConstantesFuncionesAdditional=historialformapagoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDFACTURA= "id_factura";
    public static final String IDTIPOFORMAPAGO= "id_tipo_forma_pago";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String NUMERODIAS= "numero_dias";
    public static final String VALOR= "valor";
    public static final String FECHA= "fecha";
    public static final String PORCENTAJE= "porcentaje";
    public static final String PORCENTAJERETENCION= "porcentaje_retencion";
    public static final String BASERETENCION= "base_retencion";
    public static final String NUMERORETENCION= "numero_retencion";
    public static final String NOMBRERETENCION= "nombre_retencion";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_IDTIPOFORMAPAGO= "Tipo Forma Pago";
		public static final String LABEL_IDTIPOFORMAPAGO_LOWER= "Tipo Forma Pago";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_NUMERODIAS= "Numero Dias";
		public static final String LABEL_NUMERODIAS_LOWER= "Numero Dias";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_PORCENTAJERETENCION= "Porcentaje Retencion";
		public static final String LABEL_PORCENTAJERETENCION_LOWER= "Porcentaje Retencion";
    	public static final String LABEL_BASERETENCION= "Base Retencion";
		public static final String LABEL_BASERETENCION_LOWER= "Base Retencion";
    	public static final String LABEL_NUMERORETENCION= "Numero Retencion";
		public static final String LABEL_NUMERORETENCION_LOWER= "Numero Retencion";
    	public static final String LABEL_NOMBRERETENCION= "Nombre Retencion";
		public static final String LABEL_NOMBRERETENCION_LOWER= "Nombre Retencion";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_RETENCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_RETENCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getHistorialFormaPagoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(HistorialFormaPagoConstantesFunciones.IDEMPRESA)) {sLabelColumna=HistorialFormaPagoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(HistorialFormaPagoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=HistorialFormaPagoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(HistorialFormaPagoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=HistorialFormaPagoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(HistorialFormaPagoConstantesFunciones.IDPERIODO)) {sLabelColumna=HistorialFormaPagoConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(HistorialFormaPagoConstantesFunciones.IDFACTURA)) {sLabelColumna=HistorialFormaPagoConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(HistorialFormaPagoConstantesFunciones.IDTIPOFORMAPAGO)) {sLabelColumna=HistorialFormaPagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO;}
		if(sNombreColumna.equals(HistorialFormaPagoConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=HistorialFormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(HistorialFormaPagoConstantesFunciones.NUMERODIAS)) {sLabelColumna=HistorialFormaPagoConstantesFunciones.LABEL_NUMERODIAS;}
		if(sNombreColumna.equals(HistorialFormaPagoConstantesFunciones.VALOR)) {sLabelColumna=HistorialFormaPagoConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(HistorialFormaPagoConstantesFunciones.FECHA)) {sLabelColumna=HistorialFormaPagoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(HistorialFormaPagoConstantesFunciones.PORCENTAJE)) {sLabelColumna=HistorialFormaPagoConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(HistorialFormaPagoConstantesFunciones.PORCENTAJERETENCION)) {sLabelColumna=HistorialFormaPagoConstantesFunciones.LABEL_PORCENTAJERETENCION;}
		if(sNombreColumna.equals(HistorialFormaPagoConstantesFunciones.BASERETENCION)) {sLabelColumna=HistorialFormaPagoConstantesFunciones.LABEL_BASERETENCION;}
		if(sNombreColumna.equals(HistorialFormaPagoConstantesFunciones.NUMERORETENCION)) {sLabelColumna=HistorialFormaPagoConstantesFunciones.LABEL_NUMERORETENCION;}
		if(sNombreColumna.equals(HistorialFormaPagoConstantesFunciones.NOMBRERETENCION)) {sLabelColumna=HistorialFormaPagoConstantesFunciones.LABEL_NOMBRERETENCION;}
		if(sNombreColumna.equals(HistorialFormaPagoConstantesFunciones.IDANIO)) {sLabelColumna=HistorialFormaPagoConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(HistorialFormaPagoConstantesFunciones.IDMES)) {sLabelColumna=HistorialFormaPagoConstantesFunciones.LABEL_IDMES;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getHistorialFormaPagoDescripcion(HistorialFormaPago historialformapago) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(historialformapago !=null/* && historialformapago.getId()!=0*/) {
			if(historialformapago.getId()!=null) {
				sDescripcion=historialformapago.getId().toString();
			}//historialformapagohistorialformapago.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getHistorialFormaPagoDescripcionDetallado(HistorialFormaPago historialformapago) {
		String sDescripcion="";
			
		sDescripcion+=HistorialFormaPagoConstantesFunciones.ID+"=";
		sDescripcion+=historialformapago.getId().toString()+",";
		sDescripcion+=HistorialFormaPagoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=historialformapago.getVersionRow().toString()+",";
		sDescripcion+=HistorialFormaPagoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=historialformapago.getid_empresa().toString()+",";
		sDescripcion+=HistorialFormaPagoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=historialformapago.getid_sucursal().toString()+",";
		sDescripcion+=HistorialFormaPagoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=historialformapago.getid_ejercicio().toString()+",";
		sDescripcion+=HistorialFormaPagoConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=historialformapago.getid_periodo().toString()+",";
		sDescripcion+=HistorialFormaPagoConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=historialformapago.getid_factura().toString()+",";
		sDescripcion+=HistorialFormaPagoConstantesFunciones.IDTIPOFORMAPAGO+"=";
		sDescripcion+=historialformapago.getid_tipo_forma_pago().toString()+",";
		sDescripcion+=HistorialFormaPagoConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=historialformapago.getid_cuenta_contable().toString()+",";
		sDescripcion+=HistorialFormaPagoConstantesFunciones.NUMERODIAS+"=";
		sDescripcion+=historialformapago.getnumero_dias().toString()+",";
		sDescripcion+=HistorialFormaPagoConstantesFunciones.VALOR+"=";
		sDescripcion+=historialformapago.getvalor().toString()+",";
		sDescripcion+=HistorialFormaPagoConstantesFunciones.FECHA+"=";
		sDescripcion+=historialformapago.getfecha().toString()+",";
		sDescripcion+=HistorialFormaPagoConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=historialformapago.getporcentaje().toString()+",";
		sDescripcion+=HistorialFormaPagoConstantesFunciones.PORCENTAJERETENCION+"=";
		sDescripcion+=historialformapago.getporcentaje_retencion().toString()+",";
		sDescripcion+=HistorialFormaPagoConstantesFunciones.BASERETENCION+"=";
		sDescripcion+=historialformapago.getbase_retencion().toString()+",";
		sDescripcion+=HistorialFormaPagoConstantesFunciones.NUMERORETENCION+"=";
		sDescripcion+=historialformapago.getnumero_retencion().toString()+",";
		sDescripcion+=HistorialFormaPagoConstantesFunciones.NOMBRERETENCION+"=";
		sDescripcion+=historialformapago.getnombre_retencion()+",";
		sDescripcion+=HistorialFormaPagoConstantesFunciones.IDANIO+"=";
		sDescripcion+=historialformapago.getid_anio().toString()+",";
		sDescripcion+=HistorialFormaPagoConstantesFunciones.IDMES+"=";
		sDescripcion+=historialformapago.getid_mes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setHistorialFormaPagoDescripcion(HistorialFormaPago historialformapago,String sValor) throws Exception {			
		if(historialformapago !=null) {
			//historialformapagohistorialformapago.getId().toString();
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

	public static String getFacturaDescripcion(Factura factura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factura!=null/*&&factura.getId()>0*/) {
			sDescripcion=FacturaConstantesFunciones.getFacturaDescripcion(factura);
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

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFactura")) {
			sNombreIndice="Tipo=  Por Factura";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoFormaPago")) {
			sNombreIndice="Tipo=  Por Tipo Forma Pago";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
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

	public static String getDetalleIndiceFK_IdFactura(Long id_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_factura!=null) {sDetalleIndice+=" Codigo Unico De Factura="+id_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosHistorialFormaPago(HistorialFormaPago historialformapago,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		historialformapago.setnombre_retencion(historialformapago.getnombre_retencion().trim());
	}
	
	public static void quitarEspaciosHistorialFormaPagos(List<HistorialFormaPago> historialformapagos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(HistorialFormaPago historialformapago: historialformapagos) {
			historialformapago.setnombre_retencion(historialformapago.getnombre_retencion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresHistorialFormaPago(HistorialFormaPago historialformapago,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && historialformapago.getConCambioAuxiliar()) {
			historialformapago.setIsDeleted(historialformapago.getIsDeletedAuxiliar());	
			historialformapago.setIsNew(historialformapago.getIsNewAuxiliar());	
			historialformapago.setIsChanged(historialformapago.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			historialformapago.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			historialformapago.setIsDeletedAuxiliar(false);	
			historialformapago.setIsNewAuxiliar(false);	
			historialformapago.setIsChangedAuxiliar(false);
			
			historialformapago.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresHistorialFormaPagos(List<HistorialFormaPago> historialformapagos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(HistorialFormaPago historialformapago : historialformapagos) {
			if(conAsignarBase && historialformapago.getConCambioAuxiliar()) {
				historialformapago.setIsDeleted(historialformapago.getIsDeletedAuxiliar());	
				historialformapago.setIsNew(historialformapago.getIsNewAuxiliar());	
				historialformapago.setIsChanged(historialformapago.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				historialformapago.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				historialformapago.setIsDeletedAuxiliar(false);	
				historialformapago.setIsNewAuxiliar(false);	
				historialformapago.setIsChangedAuxiliar(false);
				
				historialformapago.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresHistorialFormaPago(HistorialFormaPago historialformapago,Boolean conEnteros) throws Exception  {
		historialformapago.setvalor(0.0);
		historialformapago.setporcentaje(0.0);
		historialformapago.setporcentaje_retencion(0.0);
		historialformapago.setbase_retencion(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			historialformapago.setnumero_dias(0);
			historialformapago.setnumero_retencion(0);
		}
	}		
	
	public static void InicializarValoresHistorialFormaPagos(List<HistorialFormaPago> historialformapagos,Boolean conEnteros) throws Exception  {
		
		for(HistorialFormaPago historialformapago: historialformapagos) {
			historialformapago.setvalor(0.0);
			historialformapago.setporcentaje(0.0);
			historialformapago.setporcentaje_retencion(0.0);
			historialformapago.setbase_retencion(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				historialformapago.setnumero_dias(0);
				historialformapago.setnumero_retencion(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaHistorialFormaPago(List<HistorialFormaPago> historialformapagos,HistorialFormaPago historialformapagoAux) throws Exception  {
		HistorialFormaPagoConstantesFunciones.InicializarValoresHistorialFormaPago(historialformapagoAux,true);
		
		for(HistorialFormaPago historialformapago: historialformapagos) {
			if(historialformapago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			historialformapagoAux.setnumero_dias(historialformapagoAux.getnumero_dias()+historialformapago.getnumero_dias());			
			historialformapagoAux.setvalor(historialformapagoAux.getvalor()+historialformapago.getvalor());			
			historialformapagoAux.setporcentaje(historialformapagoAux.getporcentaje()+historialformapago.getporcentaje());			
			historialformapagoAux.setporcentaje_retencion(historialformapagoAux.getporcentaje_retencion()+historialformapago.getporcentaje_retencion());			
			historialformapagoAux.setbase_retencion(historialformapagoAux.getbase_retencion()+historialformapago.getbase_retencion());			
			historialformapagoAux.setnumero_retencion(historialformapagoAux.getnumero_retencion()+historialformapago.getnumero_retencion());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesHistorialFormaPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=HistorialFormaPagoConstantesFunciones.getArrayColumnasGlobalesHistorialFormaPago(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesHistorialFormaPago(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(HistorialFormaPagoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(HistorialFormaPagoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(HistorialFormaPagoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(HistorialFormaPagoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(HistorialFormaPagoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(HistorialFormaPagoConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(HistorialFormaPagoConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(HistorialFormaPagoConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoHistorialFormaPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<HistorialFormaPago> historialformapagos,HistorialFormaPago historialformapago,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(HistorialFormaPago historialformapagoAux: historialformapagos) {
			if(historialformapagoAux!=null && historialformapago!=null) {
				if((historialformapagoAux.getId()==null && historialformapago.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(historialformapagoAux.getId()!=null && historialformapago.getId()!=null){
					if(historialformapagoAux.getId().equals(historialformapago.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaHistorialFormaPago(List<HistorialFormaPago> historialformapagos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
		Double porcentajeTotal=0.0;
		Double porcentaje_retencionTotal=0.0;
		Double base_retencionTotal=0.0;
	
		for(HistorialFormaPago historialformapago: historialformapagos) {			
			if(historialformapago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=historialformapago.getvalor();
			porcentajeTotal+=historialformapago.getporcentaje();
			porcentaje_retencionTotal+=historialformapago.getporcentaje_retencion();
			base_retencionTotal+=historialformapago.getbase_retencion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(HistorialFormaPagoConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(HistorialFormaPagoConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(HistorialFormaPagoConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(HistorialFormaPagoConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(HistorialFormaPagoConstantesFunciones.PORCENTAJERETENCION);
		datoGeneral.setsDescripcion(HistorialFormaPagoConstantesFunciones.LABEL_PORCENTAJERETENCION);
		datoGeneral.setdValorDouble(porcentaje_retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(HistorialFormaPagoConstantesFunciones.BASERETENCION);
		datoGeneral.setsDescripcion(HistorialFormaPagoConstantesFunciones.LABEL_BASERETENCION);
		datoGeneral.setdValorDouble(base_retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaHistorialFormaPago() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,HistorialFormaPagoConstantesFunciones.LABEL_ID, HistorialFormaPagoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialFormaPagoConstantesFunciones.LABEL_VERSIONROW, HistorialFormaPagoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialFormaPagoConstantesFunciones.LABEL_IDEMPRESA, HistorialFormaPagoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialFormaPagoConstantesFunciones.LABEL_IDSUCURSAL, HistorialFormaPagoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialFormaPagoConstantesFunciones.LABEL_IDEJERCICIO, HistorialFormaPagoConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialFormaPagoConstantesFunciones.LABEL_IDPERIODO, HistorialFormaPagoConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialFormaPagoConstantesFunciones.LABEL_IDFACTURA, HistorialFormaPagoConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialFormaPagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO, HistorialFormaPagoConstantesFunciones.IDTIPOFORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialFormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLE, HistorialFormaPagoConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialFormaPagoConstantesFunciones.LABEL_NUMERODIAS, HistorialFormaPagoConstantesFunciones.NUMERODIAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialFormaPagoConstantesFunciones.LABEL_VALOR, HistorialFormaPagoConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialFormaPagoConstantesFunciones.LABEL_FECHA, HistorialFormaPagoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialFormaPagoConstantesFunciones.LABEL_PORCENTAJE, HistorialFormaPagoConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialFormaPagoConstantesFunciones.LABEL_PORCENTAJERETENCION, HistorialFormaPagoConstantesFunciones.PORCENTAJERETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialFormaPagoConstantesFunciones.LABEL_BASERETENCION, HistorialFormaPagoConstantesFunciones.BASERETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialFormaPagoConstantesFunciones.LABEL_NUMERORETENCION, HistorialFormaPagoConstantesFunciones.NUMERORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialFormaPagoConstantesFunciones.LABEL_NOMBRERETENCION, HistorialFormaPagoConstantesFunciones.NOMBRERETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialFormaPagoConstantesFunciones.LABEL_IDANIO, HistorialFormaPagoConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialFormaPagoConstantesFunciones.LABEL_IDMES, HistorialFormaPagoConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasHistorialFormaPago() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoConstantesFunciones.IDTIPOFORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoConstantesFunciones.NUMERODIAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoConstantesFunciones.PORCENTAJERETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoConstantesFunciones.BASERETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoConstantesFunciones.NUMERORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoConstantesFunciones.NOMBRERETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHistorialFormaPago() throws Exception  {
		return HistorialFormaPagoConstantesFunciones.getTiposSeleccionarHistorialFormaPago(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHistorialFormaPago(Boolean conFk) throws Exception  {
		return HistorialFormaPagoConstantesFunciones.getTiposSeleccionarHistorialFormaPago(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHistorialFormaPago(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialFormaPagoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(HistorialFormaPagoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialFormaPagoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(HistorialFormaPagoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialFormaPagoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(HistorialFormaPagoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialFormaPagoConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(HistorialFormaPagoConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialFormaPagoConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(HistorialFormaPagoConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialFormaPagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO);
			reporte.setsDescripcion(HistorialFormaPagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialFormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(HistorialFormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialFormaPagoConstantesFunciones.LABEL_NUMERODIAS);
			reporte.setsDescripcion(HistorialFormaPagoConstantesFunciones.LABEL_NUMERODIAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialFormaPagoConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(HistorialFormaPagoConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialFormaPagoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(HistorialFormaPagoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialFormaPagoConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(HistorialFormaPagoConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialFormaPagoConstantesFunciones.LABEL_PORCENTAJERETENCION);
			reporte.setsDescripcion(HistorialFormaPagoConstantesFunciones.LABEL_PORCENTAJERETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialFormaPagoConstantesFunciones.LABEL_BASERETENCION);
			reporte.setsDescripcion(HistorialFormaPagoConstantesFunciones.LABEL_BASERETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialFormaPagoConstantesFunciones.LABEL_NUMERORETENCION);
			reporte.setsDescripcion(HistorialFormaPagoConstantesFunciones.LABEL_NUMERORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialFormaPagoConstantesFunciones.LABEL_NOMBRERETENCION);
			reporte.setsDescripcion(HistorialFormaPagoConstantesFunciones.LABEL_NOMBRERETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialFormaPagoConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(HistorialFormaPagoConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialFormaPagoConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(HistorialFormaPagoConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesHistorialFormaPago(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesHistorialFormaPago(HistorialFormaPago historialformapagoAux) throws Exception {
		
			historialformapagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(historialformapagoAux.getEmpresa()));
			historialformapagoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(historialformapagoAux.getSucursal()));
			historialformapagoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(historialformapagoAux.getEjercicio()));
			historialformapagoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(historialformapagoAux.getPeriodo()));
			historialformapagoAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(historialformapagoAux.getFactura()));
			historialformapagoAux.settipoformapago_descripcion(TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(historialformapagoAux.getTipoFormaPago()));
			historialformapagoAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(historialformapagoAux.getCuentaContable()));
			historialformapagoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(historialformapagoAux.getAnio()));
			historialformapagoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(historialformapagoAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesHistorialFormaPago(List<HistorialFormaPago> historialformapagosTemp) throws Exception {
		for(HistorialFormaPago historialformapagoAux:historialformapagosTemp) {
			
			historialformapagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(historialformapagoAux.getEmpresa()));
			historialformapagoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(historialformapagoAux.getSucursal()));
			historialformapagoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(historialformapagoAux.getEjercicio()));
			historialformapagoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(historialformapagoAux.getPeriodo()));
			historialformapagoAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(historialformapagoAux.getFactura()));
			historialformapagoAux.settipoformapago_descripcion(TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(historialformapagoAux.getTipoFormaPago()));
			historialformapagoAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(historialformapagoAux.getCuentaContable()));
			historialformapagoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(historialformapagoAux.getAnio()));
			historialformapagoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(historialformapagoAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfHistorialFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(TipoFormaPago.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
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
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFormaPago.class)) {
						classes.add(new Classe(TipoFormaPago.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfHistorialFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(TipoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormaPago.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(TipoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormaPago.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfHistorialFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return HistorialFormaPagoConstantesFunciones.getClassesRelationshipsOfHistorialFormaPago(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfHistorialFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfHistorialFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return HistorialFormaPagoConstantesFunciones.getClassesRelationshipsFromStringsOfHistorialFormaPago(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfHistorialFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
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
	public static void actualizarLista(HistorialFormaPago historialformapago,List<HistorialFormaPago> historialformapagos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			HistorialFormaPago historialformapagoEncontrado=null;
			
			for(HistorialFormaPago historialformapagoLocal:historialformapagos) {
				if(historialformapagoLocal.getId().equals(historialformapago.getId())) {
					historialformapagoEncontrado=historialformapagoLocal;
					
					historialformapagoLocal.setIsChanged(historialformapago.getIsChanged());
					historialformapagoLocal.setIsNew(historialformapago.getIsNew());
					historialformapagoLocal.setIsDeleted(historialformapago.getIsDeleted());
					
					historialformapagoLocal.setGeneralEntityOriginal(historialformapago.getGeneralEntityOriginal());
					
					historialformapagoLocal.setId(historialformapago.getId());	
					historialformapagoLocal.setVersionRow(historialformapago.getVersionRow());	
					historialformapagoLocal.setid_empresa(historialformapago.getid_empresa());	
					historialformapagoLocal.setid_sucursal(historialformapago.getid_sucursal());	
					historialformapagoLocal.setid_ejercicio(historialformapago.getid_ejercicio());	
					historialformapagoLocal.setid_periodo(historialformapago.getid_periodo());	
					historialformapagoLocal.setid_factura(historialformapago.getid_factura());	
					historialformapagoLocal.setid_tipo_forma_pago(historialformapago.getid_tipo_forma_pago());	
					historialformapagoLocal.setid_cuenta_contable(historialformapago.getid_cuenta_contable());	
					historialformapagoLocal.setnumero_dias(historialformapago.getnumero_dias());	
					historialformapagoLocal.setvalor(historialformapago.getvalor());	
					historialformapagoLocal.setfecha(historialformapago.getfecha());	
					historialformapagoLocal.setporcentaje(historialformapago.getporcentaje());	
					historialformapagoLocal.setporcentaje_retencion(historialformapago.getporcentaje_retencion());	
					historialformapagoLocal.setbase_retencion(historialformapago.getbase_retencion());	
					historialformapagoLocal.setnumero_retencion(historialformapago.getnumero_retencion());	
					historialformapagoLocal.setnombre_retencion(historialformapago.getnombre_retencion());	
					historialformapagoLocal.setid_anio(historialformapago.getid_anio());	
					historialformapagoLocal.setid_mes(historialformapago.getid_mes());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!historialformapago.getIsDeleted()) {
				if(!existe) {
					historialformapagos.add(historialformapago);
				}
			} else {
				if(historialformapagoEncontrado!=null && permiteQuitar)  {
					historialformapagos.remove(historialformapagoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(HistorialFormaPago historialformapago,List<HistorialFormaPago> historialformapagos) throws Exception {
		try	{			
			for(HistorialFormaPago historialformapagoLocal:historialformapagos) {
				if(historialformapagoLocal.getId().equals(historialformapago.getId())) {
					historialformapagoLocal.setIsSelected(historialformapago.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesHistorialFormaPago(List<HistorialFormaPago> historialformapagosAux) throws Exception {
		//this.historialformapagosAux=historialformapagosAux;
		
		for(HistorialFormaPago historialformapagoAux:historialformapagosAux) {
			if(historialformapagoAux.getIsChanged()) {
				historialformapagoAux.setIsChanged(false);
			}		
			
			if(historialformapagoAux.getIsNew()) {
				historialformapagoAux.setIsNew(false);
			}	
			
			if(historialformapagoAux.getIsDeleted()) {
				historialformapagoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesHistorialFormaPago(HistorialFormaPago historialformapagoAux) throws Exception {
		//this.historialformapagoAux=historialformapagoAux;
		
			if(historialformapagoAux.getIsChanged()) {
				historialformapagoAux.setIsChanged(false);
			}		
			
			if(historialformapagoAux.getIsNew()) {
				historialformapagoAux.setIsNew(false);
			}	
			
			if(historialformapagoAux.getIsDeleted()) {
				historialformapagoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(HistorialFormaPago historialformapagoAsignar,HistorialFormaPago historialformapago) throws Exception {
		historialformapagoAsignar.setId(historialformapago.getId());	
		historialformapagoAsignar.setVersionRow(historialformapago.getVersionRow());	
		historialformapagoAsignar.setid_empresa(historialformapago.getid_empresa());
		historialformapagoAsignar.setempresa_descripcion(historialformapago.getempresa_descripcion());	
		historialformapagoAsignar.setid_sucursal(historialformapago.getid_sucursal());
		historialformapagoAsignar.setsucursal_descripcion(historialformapago.getsucursal_descripcion());	
		historialformapagoAsignar.setid_ejercicio(historialformapago.getid_ejercicio());
		historialformapagoAsignar.setejercicio_descripcion(historialformapago.getejercicio_descripcion());	
		historialformapagoAsignar.setid_periodo(historialformapago.getid_periodo());
		historialformapagoAsignar.setperiodo_descripcion(historialformapago.getperiodo_descripcion());	
		historialformapagoAsignar.setid_factura(historialformapago.getid_factura());
		historialformapagoAsignar.setfactura_descripcion(historialformapago.getfactura_descripcion());	
		historialformapagoAsignar.setid_tipo_forma_pago(historialformapago.getid_tipo_forma_pago());
		historialformapagoAsignar.settipoformapago_descripcion(historialformapago.gettipoformapago_descripcion());	
		historialformapagoAsignar.setid_cuenta_contable(historialformapago.getid_cuenta_contable());
		historialformapagoAsignar.setcuentacontable_descripcion(historialformapago.getcuentacontable_descripcion());	
		historialformapagoAsignar.setnumero_dias(historialformapago.getnumero_dias());	
		historialformapagoAsignar.setvalor(historialformapago.getvalor());	
		historialformapagoAsignar.setfecha(historialformapago.getfecha());	
		historialformapagoAsignar.setporcentaje(historialformapago.getporcentaje());	
		historialformapagoAsignar.setporcentaje_retencion(historialformapago.getporcentaje_retencion());	
		historialformapagoAsignar.setbase_retencion(historialformapago.getbase_retencion());	
		historialformapagoAsignar.setnumero_retencion(historialformapago.getnumero_retencion());	
		historialformapagoAsignar.setnombre_retencion(historialformapago.getnombre_retencion());	
		historialformapagoAsignar.setid_anio(historialformapago.getid_anio());
		historialformapagoAsignar.setanio_descripcion(historialformapago.getanio_descripcion());	
		historialformapagoAsignar.setid_mes(historialformapago.getid_mes());
		historialformapagoAsignar.setmes_descripcion(historialformapago.getmes_descripcion());	
	}
	
	public static void inicializarHistorialFormaPago(HistorialFormaPago historialformapago) throws Exception {
		try {
				historialformapago.setId(0L);	
					
				historialformapago.setid_empresa(-1L);	
				historialformapago.setid_sucursal(-1L);	
				historialformapago.setid_ejercicio(-1L);	
				historialformapago.setid_periodo(-1L);	
				historialformapago.setid_factura(-1L);	
				historialformapago.setid_tipo_forma_pago(-1L);	
				historialformapago.setid_cuenta_contable(-1L);	
				historialformapago.setnumero_dias(0);	
				historialformapago.setvalor(0.0);	
				historialformapago.setfecha(new Date());	
				historialformapago.setporcentaje(0.0);	
				historialformapago.setporcentaje_retencion(0.0);	
				historialformapago.setbase_retencion(0.0);	
				historialformapago.setnumero_retencion(0);	
				historialformapago.setnombre_retencion("");	
				historialformapago.setid_anio(null);	
				historialformapago.setid_mes(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderHistorialFormaPago(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialFormaPagoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialFormaPagoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialFormaPagoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialFormaPagoConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialFormaPagoConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialFormaPagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialFormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialFormaPagoConstantesFunciones.LABEL_NUMERODIAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialFormaPagoConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialFormaPagoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialFormaPagoConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialFormaPagoConstantesFunciones.LABEL_PORCENTAJERETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialFormaPagoConstantesFunciones.LABEL_BASERETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialFormaPagoConstantesFunciones.LABEL_NUMERORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialFormaPagoConstantesFunciones.LABEL_NOMBRERETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialFormaPagoConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialFormaPagoConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataHistorialFormaPago(String sTipo,Row row,Workbook workbook,HistorialFormaPago historialformapago,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(historialformapago.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialformapago.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialformapago.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialformapago.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialformapago.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialformapago.gettipoformapago_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialformapago.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialformapago.getnumero_dias());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialformapago.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialformapago.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialformapago.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialformapago.getporcentaje_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialformapago.getbase_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialformapago.getnumero_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialformapago.getnombre_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialformapago.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialformapago.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryHistorialFormaPago=Constantes.SFINALQUERY;
	
	public String getsFinalQueryHistorialFormaPago() {
		return this.sFinalQueryHistorialFormaPago;
	}
	
	public void setsFinalQueryHistorialFormaPago(String sFinalQueryHistorialFormaPago) {
		this.sFinalQueryHistorialFormaPago= sFinalQueryHistorialFormaPago;
	}
	
	public Border resaltarSeleccionarHistorialFormaPago=null;
	
	public Border setResaltarSeleccionarHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//historialformapagoBeanSwingJInternalFrame.jTtoolBarHistorialFormaPago.setBorder(borderResaltar);
		
		this.resaltarSeleccionarHistorialFormaPago= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarHistorialFormaPago() {
		return this.resaltarSeleccionarHistorialFormaPago;
	}
	
	public void setResaltarSeleccionarHistorialFormaPago(Border borderResaltarSeleccionarHistorialFormaPago) {
		this.resaltarSeleccionarHistorialFormaPago= borderResaltarSeleccionarHistorialFormaPago;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridHistorialFormaPago=null;
	public Boolean mostraridHistorialFormaPago=true;
	public Boolean activaridHistorialFormaPago=true;

	public Border resaltarid_empresaHistorialFormaPago=null;
	public Boolean mostrarid_empresaHistorialFormaPago=true;
	public Boolean activarid_empresaHistorialFormaPago=true;
	public Boolean cargarid_empresaHistorialFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaHistorialFormaPago=false;//ConEventDepend=true

	public Border resaltarid_sucursalHistorialFormaPago=null;
	public Boolean mostrarid_sucursalHistorialFormaPago=true;
	public Boolean activarid_sucursalHistorialFormaPago=true;
	public Boolean cargarid_sucursalHistorialFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalHistorialFormaPago=false;//ConEventDepend=true

	public Border resaltarid_ejercicioHistorialFormaPago=null;
	public Boolean mostrarid_ejercicioHistorialFormaPago=true;
	public Boolean activarid_ejercicioHistorialFormaPago=true;
	public Boolean cargarid_ejercicioHistorialFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioHistorialFormaPago=false;//ConEventDepend=true

	public Border resaltarid_periodoHistorialFormaPago=null;
	public Boolean mostrarid_periodoHistorialFormaPago=true;
	public Boolean activarid_periodoHistorialFormaPago=true;
	public Boolean cargarid_periodoHistorialFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoHistorialFormaPago=false;//ConEventDepend=true

	public Border resaltarid_facturaHistorialFormaPago=null;
	public Boolean mostrarid_facturaHistorialFormaPago=true;
	public Boolean activarid_facturaHistorialFormaPago=true;
	public Boolean cargarid_facturaHistorialFormaPago=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaHistorialFormaPago=false;//ConEventDepend=true

	public Border resaltarid_tipo_forma_pagoHistorialFormaPago=null;
	public Boolean mostrarid_tipo_forma_pagoHistorialFormaPago=true;
	public Boolean activarid_tipo_forma_pagoHistorialFormaPago=true;
	public Boolean cargarid_tipo_forma_pagoHistorialFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_forma_pagoHistorialFormaPago=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableHistorialFormaPago=null;
	public Boolean mostrarid_cuenta_contableHistorialFormaPago=true;
	public Boolean activarid_cuenta_contableHistorialFormaPago=true;
	public Boolean cargarid_cuenta_contableHistorialFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableHistorialFormaPago=false;//ConEventDepend=true

	public Border resaltarnumero_diasHistorialFormaPago=null;
	public Boolean mostrarnumero_diasHistorialFormaPago=true;
	public Boolean activarnumero_diasHistorialFormaPago=true;

	public Border resaltarvalorHistorialFormaPago=null;
	public Boolean mostrarvalorHistorialFormaPago=true;
	public Boolean activarvalorHistorialFormaPago=true;

	public Border resaltarfechaHistorialFormaPago=null;
	public Boolean mostrarfechaHistorialFormaPago=true;
	public Boolean activarfechaHistorialFormaPago=false;

	public Border resaltarporcentajeHistorialFormaPago=null;
	public Boolean mostrarporcentajeHistorialFormaPago=true;
	public Boolean activarporcentajeHistorialFormaPago=true;

	public Border resaltarporcentaje_retencionHistorialFormaPago=null;
	public Boolean mostrarporcentaje_retencionHistorialFormaPago=true;
	public Boolean activarporcentaje_retencionHistorialFormaPago=true;

	public Border resaltarbase_retencionHistorialFormaPago=null;
	public Boolean mostrarbase_retencionHistorialFormaPago=true;
	public Boolean activarbase_retencionHistorialFormaPago=true;

	public Border resaltarnumero_retencionHistorialFormaPago=null;
	public Boolean mostrarnumero_retencionHistorialFormaPago=true;
	public Boolean activarnumero_retencionHistorialFormaPago=true;

	public Border resaltarnombre_retencionHistorialFormaPago=null;
	public Boolean mostrarnombre_retencionHistorialFormaPago=true;
	public Boolean activarnombre_retencionHistorialFormaPago=true;

	public Border resaltarid_anioHistorialFormaPago=null;
	public Boolean mostrarid_anioHistorialFormaPago=true;
	public Boolean activarid_anioHistorialFormaPago=false;
	public Boolean cargarid_anioHistorialFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioHistorialFormaPago=false;//ConEventDepend=true

	public Border resaltarid_mesHistorialFormaPago=null;
	public Boolean mostrarid_mesHistorialFormaPago=true;
	public Boolean activarid_mesHistorialFormaPago=false;
	public Boolean cargarid_mesHistorialFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesHistorialFormaPago=false;//ConEventDepend=true

	
	

	public Border setResaltaridHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialformapagoBeanSwingJInternalFrame.jTtoolBarHistorialFormaPago.setBorder(borderResaltar);
		
		this.resaltaridHistorialFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridHistorialFormaPago() {
		return this.resaltaridHistorialFormaPago;
	}

	public void setResaltaridHistorialFormaPago(Border borderResaltar) {
		this.resaltaridHistorialFormaPago= borderResaltar;
	}

	public Boolean getMostraridHistorialFormaPago() {
		return this.mostraridHistorialFormaPago;
	}

	public void setMostraridHistorialFormaPago(Boolean mostraridHistorialFormaPago) {
		this.mostraridHistorialFormaPago= mostraridHistorialFormaPago;
	}

	public Boolean getActivaridHistorialFormaPago() {
		return this.activaridHistorialFormaPago;
	}

	public void setActivaridHistorialFormaPago(Boolean activaridHistorialFormaPago) {
		this.activaridHistorialFormaPago= activaridHistorialFormaPago;
	}

	public Border setResaltarid_empresaHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialformapagoBeanSwingJInternalFrame.jTtoolBarHistorialFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_empresaHistorialFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaHistorialFormaPago() {
		return this.resaltarid_empresaHistorialFormaPago;
	}

	public void setResaltarid_empresaHistorialFormaPago(Border borderResaltar) {
		this.resaltarid_empresaHistorialFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_empresaHistorialFormaPago() {
		return this.mostrarid_empresaHistorialFormaPago;
	}

	public void setMostrarid_empresaHistorialFormaPago(Boolean mostrarid_empresaHistorialFormaPago) {
		this.mostrarid_empresaHistorialFormaPago= mostrarid_empresaHistorialFormaPago;
	}

	public Boolean getActivarid_empresaHistorialFormaPago() {
		return this.activarid_empresaHistorialFormaPago;
	}

	public void setActivarid_empresaHistorialFormaPago(Boolean activarid_empresaHistorialFormaPago) {
		this.activarid_empresaHistorialFormaPago= activarid_empresaHistorialFormaPago;
	}

	public Boolean getCargarid_empresaHistorialFormaPago() {
		return this.cargarid_empresaHistorialFormaPago;
	}

	public void setCargarid_empresaHistorialFormaPago(Boolean cargarid_empresaHistorialFormaPago) {
		this.cargarid_empresaHistorialFormaPago= cargarid_empresaHistorialFormaPago;
	}

	public Border setResaltarid_sucursalHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialformapagoBeanSwingJInternalFrame.jTtoolBarHistorialFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_sucursalHistorialFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalHistorialFormaPago() {
		return this.resaltarid_sucursalHistorialFormaPago;
	}

	public void setResaltarid_sucursalHistorialFormaPago(Border borderResaltar) {
		this.resaltarid_sucursalHistorialFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_sucursalHistorialFormaPago() {
		return this.mostrarid_sucursalHistorialFormaPago;
	}

	public void setMostrarid_sucursalHistorialFormaPago(Boolean mostrarid_sucursalHistorialFormaPago) {
		this.mostrarid_sucursalHistorialFormaPago= mostrarid_sucursalHistorialFormaPago;
	}

	public Boolean getActivarid_sucursalHistorialFormaPago() {
		return this.activarid_sucursalHistorialFormaPago;
	}

	public void setActivarid_sucursalHistorialFormaPago(Boolean activarid_sucursalHistorialFormaPago) {
		this.activarid_sucursalHistorialFormaPago= activarid_sucursalHistorialFormaPago;
	}

	public Boolean getCargarid_sucursalHistorialFormaPago() {
		return this.cargarid_sucursalHistorialFormaPago;
	}

	public void setCargarid_sucursalHistorialFormaPago(Boolean cargarid_sucursalHistorialFormaPago) {
		this.cargarid_sucursalHistorialFormaPago= cargarid_sucursalHistorialFormaPago;
	}

	public Border setResaltarid_ejercicioHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialformapagoBeanSwingJInternalFrame.jTtoolBarHistorialFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioHistorialFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioHistorialFormaPago() {
		return this.resaltarid_ejercicioHistorialFormaPago;
	}

	public void setResaltarid_ejercicioHistorialFormaPago(Border borderResaltar) {
		this.resaltarid_ejercicioHistorialFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioHistorialFormaPago() {
		return this.mostrarid_ejercicioHistorialFormaPago;
	}

	public void setMostrarid_ejercicioHistorialFormaPago(Boolean mostrarid_ejercicioHistorialFormaPago) {
		this.mostrarid_ejercicioHistorialFormaPago= mostrarid_ejercicioHistorialFormaPago;
	}

	public Boolean getActivarid_ejercicioHistorialFormaPago() {
		return this.activarid_ejercicioHistorialFormaPago;
	}

	public void setActivarid_ejercicioHistorialFormaPago(Boolean activarid_ejercicioHistorialFormaPago) {
		this.activarid_ejercicioHistorialFormaPago= activarid_ejercicioHistorialFormaPago;
	}

	public Boolean getCargarid_ejercicioHistorialFormaPago() {
		return this.cargarid_ejercicioHistorialFormaPago;
	}

	public void setCargarid_ejercicioHistorialFormaPago(Boolean cargarid_ejercicioHistorialFormaPago) {
		this.cargarid_ejercicioHistorialFormaPago= cargarid_ejercicioHistorialFormaPago;
	}

	public Border setResaltarid_periodoHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialformapagoBeanSwingJInternalFrame.jTtoolBarHistorialFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_periodoHistorialFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoHistorialFormaPago() {
		return this.resaltarid_periodoHistorialFormaPago;
	}

	public void setResaltarid_periodoHistorialFormaPago(Border borderResaltar) {
		this.resaltarid_periodoHistorialFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_periodoHistorialFormaPago() {
		return this.mostrarid_periodoHistorialFormaPago;
	}

	public void setMostrarid_periodoHistorialFormaPago(Boolean mostrarid_periodoHistorialFormaPago) {
		this.mostrarid_periodoHistorialFormaPago= mostrarid_periodoHistorialFormaPago;
	}

	public Boolean getActivarid_periodoHistorialFormaPago() {
		return this.activarid_periodoHistorialFormaPago;
	}

	public void setActivarid_periodoHistorialFormaPago(Boolean activarid_periodoHistorialFormaPago) {
		this.activarid_periodoHistorialFormaPago= activarid_periodoHistorialFormaPago;
	}

	public Boolean getCargarid_periodoHistorialFormaPago() {
		return this.cargarid_periodoHistorialFormaPago;
	}

	public void setCargarid_periodoHistorialFormaPago(Boolean cargarid_periodoHistorialFormaPago) {
		this.cargarid_periodoHistorialFormaPago= cargarid_periodoHistorialFormaPago;
	}

	public Border setResaltarid_facturaHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialformapagoBeanSwingJInternalFrame.jTtoolBarHistorialFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_facturaHistorialFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaHistorialFormaPago() {
		return this.resaltarid_facturaHistorialFormaPago;
	}

	public void setResaltarid_facturaHistorialFormaPago(Border borderResaltar) {
		this.resaltarid_facturaHistorialFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_facturaHistorialFormaPago() {
		return this.mostrarid_facturaHistorialFormaPago;
	}

	public void setMostrarid_facturaHistorialFormaPago(Boolean mostrarid_facturaHistorialFormaPago) {
		this.mostrarid_facturaHistorialFormaPago= mostrarid_facturaHistorialFormaPago;
	}

	public Boolean getActivarid_facturaHistorialFormaPago() {
		return this.activarid_facturaHistorialFormaPago;
	}

	public void setActivarid_facturaHistorialFormaPago(Boolean activarid_facturaHistorialFormaPago) {
		this.activarid_facturaHistorialFormaPago= activarid_facturaHistorialFormaPago;
	}

	public Boolean getCargarid_facturaHistorialFormaPago() {
		return this.cargarid_facturaHistorialFormaPago;
	}

	public void setCargarid_facturaHistorialFormaPago(Boolean cargarid_facturaHistorialFormaPago) {
		this.cargarid_facturaHistorialFormaPago= cargarid_facturaHistorialFormaPago;
	}

	public Border setResaltarid_tipo_forma_pagoHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialformapagoBeanSwingJInternalFrame.jTtoolBarHistorialFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_tipo_forma_pagoHistorialFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_forma_pagoHistorialFormaPago() {
		return this.resaltarid_tipo_forma_pagoHistorialFormaPago;
	}

	public void setResaltarid_tipo_forma_pagoHistorialFormaPago(Border borderResaltar) {
		this.resaltarid_tipo_forma_pagoHistorialFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_tipo_forma_pagoHistorialFormaPago() {
		return this.mostrarid_tipo_forma_pagoHistorialFormaPago;
	}

	public void setMostrarid_tipo_forma_pagoHistorialFormaPago(Boolean mostrarid_tipo_forma_pagoHistorialFormaPago) {
		this.mostrarid_tipo_forma_pagoHistorialFormaPago= mostrarid_tipo_forma_pagoHistorialFormaPago;
	}

	public Boolean getActivarid_tipo_forma_pagoHistorialFormaPago() {
		return this.activarid_tipo_forma_pagoHistorialFormaPago;
	}

	public void setActivarid_tipo_forma_pagoHistorialFormaPago(Boolean activarid_tipo_forma_pagoHistorialFormaPago) {
		this.activarid_tipo_forma_pagoHistorialFormaPago= activarid_tipo_forma_pagoHistorialFormaPago;
	}

	public Boolean getCargarid_tipo_forma_pagoHistorialFormaPago() {
		return this.cargarid_tipo_forma_pagoHistorialFormaPago;
	}

	public void setCargarid_tipo_forma_pagoHistorialFormaPago(Boolean cargarid_tipo_forma_pagoHistorialFormaPago) {
		this.cargarid_tipo_forma_pagoHistorialFormaPago= cargarid_tipo_forma_pagoHistorialFormaPago;
	}

	public Border setResaltarid_cuenta_contableHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialformapagoBeanSwingJInternalFrame.jTtoolBarHistorialFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableHistorialFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableHistorialFormaPago() {
		return this.resaltarid_cuenta_contableHistorialFormaPago;
	}

	public void setResaltarid_cuenta_contableHistorialFormaPago(Border borderResaltar) {
		this.resaltarid_cuenta_contableHistorialFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableHistorialFormaPago() {
		return this.mostrarid_cuenta_contableHistorialFormaPago;
	}

	public void setMostrarid_cuenta_contableHistorialFormaPago(Boolean mostrarid_cuenta_contableHistorialFormaPago) {
		this.mostrarid_cuenta_contableHistorialFormaPago= mostrarid_cuenta_contableHistorialFormaPago;
	}

	public Boolean getActivarid_cuenta_contableHistorialFormaPago() {
		return this.activarid_cuenta_contableHistorialFormaPago;
	}

	public void setActivarid_cuenta_contableHistorialFormaPago(Boolean activarid_cuenta_contableHistorialFormaPago) {
		this.activarid_cuenta_contableHistorialFormaPago= activarid_cuenta_contableHistorialFormaPago;
	}

	public Boolean getCargarid_cuenta_contableHistorialFormaPago() {
		return this.cargarid_cuenta_contableHistorialFormaPago;
	}

	public void setCargarid_cuenta_contableHistorialFormaPago(Boolean cargarid_cuenta_contableHistorialFormaPago) {
		this.cargarid_cuenta_contableHistorialFormaPago= cargarid_cuenta_contableHistorialFormaPago;
	}

	public Border setResaltarnumero_diasHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialformapagoBeanSwingJInternalFrame.jTtoolBarHistorialFormaPago.setBorder(borderResaltar);
		
		this.resaltarnumero_diasHistorialFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_diasHistorialFormaPago() {
		return this.resaltarnumero_diasHistorialFormaPago;
	}

	public void setResaltarnumero_diasHistorialFormaPago(Border borderResaltar) {
		this.resaltarnumero_diasHistorialFormaPago= borderResaltar;
	}

	public Boolean getMostrarnumero_diasHistorialFormaPago() {
		return this.mostrarnumero_diasHistorialFormaPago;
	}

	public void setMostrarnumero_diasHistorialFormaPago(Boolean mostrarnumero_diasHistorialFormaPago) {
		this.mostrarnumero_diasHistorialFormaPago= mostrarnumero_diasHistorialFormaPago;
	}

	public Boolean getActivarnumero_diasHistorialFormaPago() {
		return this.activarnumero_diasHistorialFormaPago;
	}

	public void setActivarnumero_diasHistorialFormaPago(Boolean activarnumero_diasHistorialFormaPago) {
		this.activarnumero_diasHistorialFormaPago= activarnumero_diasHistorialFormaPago;
	}

	public Border setResaltarvalorHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialformapagoBeanSwingJInternalFrame.jTtoolBarHistorialFormaPago.setBorder(borderResaltar);
		
		this.resaltarvalorHistorialFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorHistorialFormaPago() {
		return this.resaltarvalorHistorialFormaPago;
	}

	public void setResaltarvalorHistorialFormaPago(Border borderResaltar) {
		this.resaltarvalorHistorialFormaPago= borderResaltar;
	}

	public Boolean getMostrarvalorHistorialFormaPago() {
		return this.mostrarvalorHistorialFormaPago;
	}

	public void setMostrarvalorHistorialFormaPago(Boolean mostrarvalorHistorialFormaPago) {
		this.mostrarvalorHistorialFormaPago= mostrarvalorHistorialFormaPago;
	}

	public Boolean getActivarvalorHistorialFormaPago() {
		return this.activarvalorHistorialFormaPago;
	}

	public void setActivarvalorHistorialFormaPago(Boolean activarvalorHistorialFormaPago) {
		this.activarvalorHistorialFormaPago= activarvalorHistorialFormaPago;
	}

	public Border setResaltarfechaHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialformapagoBeanSwingJInternalFrame.jTtoolBarHistorialFormaPago.setBorder(borderResaltar);
		
		this.resaltarfechaHistorialFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaHistorialFormaPago() {
		return this.resaltarfechaHistorialFormaPago;
	}

	public void setResaltarfechaHistorialFormaPago(Border borderResaltar) {
		this.resaltarfechaHistorialFormaPago= borderResaltar;
	}

	public Boolean getMostrarfechaHistorialFormaPago() {
		return this.mostrarfechaHistorialFormaPago;
	}

	public void setMostrarfechaHistorialFormaPago(Boolean mostrarfechaHistorialFormaPago) {
		this.mostrarfechaHistorialFormaPago= mostrarfechaHistorialFormaPago;
	}

	public Boolean getActivarfechaHistorialFormaPago() {
		return this.activarfechaHistorialFormaPago;
	}

	public void setActivarfechaHistorialFormaPago(Boolean activarfechaHistorialFormaPago) {
		this.activarfechaHistorialFormaPago= activarfechaHistorialFormaPago;
	}

	public Border setResaltarporcentajeHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialformapagoBeanSwingJInternalFrame.jTtoolBarHistorialFormaPago.setBorder(borderResaltar);
		
		this.resaltarporcentajeHistorialFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeHistorialFormaPago() {
		return this.resaltarporcentajeHistorialFormaPago;
	}

	public void setResaltarporcentajeHistorialFormaPago(Border borderResaltar) {
		this.resaltarporcentajeHistorialFormaPago= borderResaltar;
	}

	public Boolean getMostrarporcentajeHistorialFormaPago() {
		return this.mostrarporcentajeHistorialFormaPago;
	}

	public void setMostrarporcentajeHistorialFormaPago(Boolean mostrarporcentajeHistorialFormaPago) {
		this.mostrarporcentajeHistorialFormaPago= mostrarporcentajeHistorialFormaPago;
	}

	public Boolean getActivarporcentajeHistorialFormaPago() {
		return this.activarporcentajeHistorialFormaPago;
	}

	public void setActivarporcentajeHistorialFormaPago(Boolean activarporcentajeHistorialFormaPago) {
		this.activarporcentajeHistorialFormaPago= activarporcentajeHistorialFormaPago;
	}

	public Border setResaltarporcentaje_retencionHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialformapagoBeanSwingJInternalFrame.jTtoolBarHistorialFormaPago.setBorder(borderResaltar);
		
		this.resaltarporcentaje_retencionHistorialFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_retencionHistorialFormaPago() {
		return this.resaltarporcentaje_retencionHistorialFormaPago;
	}

	public void setResaltarporcentaje_retencionHistorialFormaPago(Border borderResaltar) {
		this.resaltarporcentaje_retencionHistorialFormaPago= borderResaltar;
	}

	public Boolean getMostrarporcentaje_retencionHistorialFormaPago() {
		return this.mostrarporcentaje_retencionHistorialFormaPago;
	}

	public void setMostrarporcentaje_retencionHistorialFormaPago(Boolean mostrarporcentaje_retencionHistorialFormaPago) {
		this.mostrarporcentaje_retencionHistorialFormaPago= mostrarporcentaje_retencionHistorialFormaPago;
	}

	public Boolean getActivarporcentaje_retencionHistorialFormaPago() {
		return this.activarporcentaje_retencionHistorialFormaPago;
	}

	public void setActivarporcentaje_retencionHistorialFormaPago(Boolean activarporcentaje_retencionHistorialFormaPago) {
		this.activarporcentaje_retencionHistorialFormaPago= activarporcentaje_retencionHistorialFormaPago;
	}

	public Border setResaltarbase_retencionHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialformapagoBeanSwingJInternalFrame.jTtoolBarHistorialFormaPago.setBorder(borderResaltar);
		
		this.resaltarbase_retencionHistorialFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbase_retencionHistorialFormaPago() {
		return this.resaltarbase_retencionHistorialFormaPago;
	}

	public void setResaltarbase_retencionHistorialFormaPago(Border borderResaltar) {
		this.resaltarbase_retencionHistorialFormaPago= borderResaltar;
	}

	public Boolean getMostrarbase_retencionHistorialFormaPago() {
		return this.mostrarbase_retencionHistorialFormaPago;
	}

	public void setMostrarbase_retencionHistorialFormaPago(Boolean mostrarbase_retencionHistorialFormaPago) {
		this.mostrarbase_retencionHistorialFormaPago= mostrarbase_retencionHistorialFormaPago;
	}

	public Boolean getActivarbase_retencionHistorialFormaPago() {
		return this.activarbase_retencionHistorialFormaPago;
	}

	public void setActivarbase_retencionHistorialFormaPago(Boolean activarbase_retencionHistorialFormaPago) {
		this.activarbase_retencionHistorialFormaPago= activarbase_retencionHistorialFormaPago;
	}

	public Border setResaltarnumero_retencionHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialformapagoBeanSwingJInternalFrame.jTtoolBarHistorialFormaPago.setBorder(borderResaltar);
		
		this.resaltarnumero_retencionHistorialFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_retencionHistorialFormaPago() {
		return this.resaltarnumero_retencionHistorialFormaPago;
	}

	public void setResaltarnumero_retencionHistorialFormaPago(Border borderResaltar) {
		this.resaltarnumero_retencionHistorialFormaPago= borderResaltar;
	}

	public Boolean getMostrarnumero_retencionHistorialFormaPago() {
		return this.mostrarnumero_retencionHistorialFormaPago;
	}

	public void setMostrarnumero_retencionHistorialFormaPago(Boolean mostrarnumero_retencionHistorialFormaPago) {
		this.mostrarnumero_retencionHistorialFormaPago= mostrarnumero_retencionHistorialFormaPago;
	}

	public Boolean getActivarnumero_retencionHistorialFormaPago() {
		return this.activarnumero_retencionHistorialFormaPago;
	}

	public void setActivarnumero_retencionHistorialFormaPago(Boolean activarnumero_retencionHistorialFormaPago) {
		this.activarnumero_retencionHistorialFormaPago= activarnumero_retencionHistorialFormaPago;
	}

	public Border setResaltarnombre_retencionHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialformapagoBeanSwingJInternalFrame.jTtoolBarHistorialFormaPago.setBorder(borderResaltar);
		
		this.resaltarnombre_retencionHistorialFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_retencionHistorialFormaPago() {
		return this.resaltarnombre_retencionHistorialFormaPago;
	}

	public void setResaltarnombre_retencionHistorialFormaPago(Border borderResaltar) {
		this.resaltarnombre_retencionHistorialFormaPago= borderResaltar;
	}

	public Boolean getMostrarnombre_retencionHistorialFormaPago() {
		return this.mostrarnombre_retencionHistorialFormaPago;
	}

	public void setMostrarnombre_retencionHistorialFormaPago(Boolean mostrarnombre_retencionHistorialFormaPago) {
		this.mostrarnombre_retencionHistorialFormaPago= mostrarnombre_retencionHistorialFormaPago;
	}

	public Boolean getActivarnombre_retencionHistorialFormaPago() {
		return this.activarnombre_retencionHistorialFormaPago;
	}

	public void setActivarnombre_retencionHistorialFormaPago(Boolean activarnombre_retencionHistorialFormaPago) {
		this.activarnombre_retencionHistorialFormaPago= activarnombre_retencionHistorialFormaPago;
	}

	public Border setResaltarid_anioHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialformapagoBeanSwingJInternalFrame.jTtoolBarHistorialFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_anioHistorialFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioHistorialFormaPago() {
		return this.resaltarid_anioHistorialFormaPago;
	}

	public void setResaltarid_anioHistorialFormaPago(Border borderResaltar) {
		this.resaltarid_anioHistorialFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_anioHistorialFormaPago() {
		return this.mostrarid_anioHistorialFormaPago;
	}

	public void setMostrarid_anioHistorialFormaPago(Boolean mostrarid_anioHistorialFormaPago) {
		this.mostrarid_anioHistorialFormaPago= mostrarid_anioHistorialFormaPago;
	}

	public Boolean getActivarid_anioHistorialFormaPago() {
		return this.activarid_anioHistorialFormaPago;
	}

	public void setActivarid_anioHistorialFormaPago(Boolean activarid_anioHistorialFormaPago) {
		this.activarid_anioHistorialFormaPago= activarid_anioHistorialFormaPago;
	}

	public Boolean getCargarid_anioHistorialFormaPago() {
		return this.cargarid_anioHistorialFormaPago;
	}

	public void setCargarid_anioHistorialFormaPago(Boolean cargarid_anioHistorialFormaPago) {
		this.cargarid_anioHistorialFormaPago= cargarid_anioHistorialFormaPago;
	}

	public Border setResaltarid_mesHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialformapagoBeanSwingJInternalFrame.jTtoolBarHistorialFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_mesHistorialFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesHistorialFormaPago() {
		return this.resaltarid_mesHistorialFormaPago;
	}

	public void setResaltarid_mesHistorialFormaPago(Border borderResaltar) {
		this.resaltarid_mesHistorialFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_mesHistorialFormaPago() {
		return this.mostrarid_mesHistorialFormaPago;
	}

	public void setMostrarid_mesHistorialFormaPago(Boolean mostrarid_mesHistorialFormaPago) {
		this.mostrarid_mesHistorialFormaPago= mostrarid_mesHistorialFormaPago;
	}

	public Boolean getActivarid_mesHistorialFormaPago() {
		return this.activarid_mesHistorialFormaPago;
	}

	public void setActivarid_mesHistorialFormaPago(Boolean activarid_mesHistorialFormaPago) {
		this.activarid_mesHistorialFormaPago= activarid_mesHistorialFormaPago;
	}

	public Boolean getCargarid_mesHistorialFormaPago() {
		return this.cargarid_mesHistorialFormaPago;
	}

	public void setCargarid_mesHistorialFormaPago(Boolean cargarid_mesHistorialFormaPago) {
		this.cargarid_mesHistorialFormaPago= cargarid_mesHistorialFormaPago;
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
		
		
		this.setMostraridHistorialFormaPago(esInicial);
		this.setMostrarid_empresaHistorialFormaPago(esInicial);
		this.setMostrarid_sucursalHistorialFormaPago(esInicial);
		this.setMostrarid_ejercicioHistorialFormaPago(esInicial);
		this.setMostrarid_periodoHistorialFormaPago(esInicial);
		this.setMostrarid_facturaHistorialFormaPago(esInicial);
		this.setMostrarid_tipo_forma_pagoHistorialFormaPago(esInicial);
		this.setMostrarid_cuenta_contableHistorialFormaPago(esInicial);
		this.setMostrarnumero_diasHistorialFormaPago(esInicial);
		this.setMostrarvalorHistorialFormaPago(esInicial);
		this.setMostrarfechaHistorialFormaPago(esInicial);
		this.setMostrarporcentajeHistorialFormaPago(esInicial);
		this.setMostrarporcentaje_retencionHistorialFormaPago(esInicial);
		this.setMostrarbase_retencionHistorialFormaPago(esInicial);
		this.setMostrarnumero_retencionHistorialFormaPago(esInicial);
		this.setMostrarnombre_retencionHistorialFormaPago(esInicial);
		this.setMostrarid_anioHistorialFormaPago(esInicial);
		this.setMostrarid_mesHistorialFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.ID)) {
				this.setMostraridHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setMostrarid_tipo_forma_pagoHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.NUMERODIAS)) {
				this.setMostrarnumero_diasHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.VALOR)) {
				this.setMostrarvalorHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.FECHA)) {
				this.setMostrarfechaHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.PORCENTAJERETENCION)) {
				this.setMostrarporcentaje_retencionHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.BASERETENCION)) {
				this.setMostrarbase_retencionHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.NUMERORETENCION)) {
				this.setMostrarnumero_retencionHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.NOMBRERETENCION)) {
				this.setMostrarnombre_retencionHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDMES)) {
				this.setMostrarid_mesHistorialFormaPago(esAsigna);
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
		
		
		this.setActivaridHistorialFormaPago(esInicial);
		this.setActivarid_empresaHistorialFormaPago(esInicial);
		this.setActivarid_sucursalHistorialFormaPago(esInicial);
		this.setActivarid_ejercicioHistorialFormaPago(esInicial);
		this.setActivarid_periodoHistorialFormaPago(esInicial);
		this.setActivarid_facturaHistorialFormaPago(esInicial);
		this.setActivarid_tipo_forma_pagoHistorialFormaPago(esInicial);
		this.setActivarid_cuenta_contableHistorialFormaPago(esInicial);
		this.setActivarnumero_diasHistorialFormaPago(esInicial);
		this.setActivarvalorHistorialFormaPago(esInicial);
		this.setActivarfechaHistorialFormaPago(esInicial);
		this.setActivarporcentajeHistorialFormaPago(esInicial);
		this.setActivarporcentaje_retencionHistorialFormaPago(esInicial);
		this.setActivarbase_retencionHistorialFormaPago(esInicial);
		this.setActivarnumero_retencionHistorialFormaPago(esInicial);
		this.setActivarnombre_retencionHistorialFormaPago(esInicial);
		this.setActivarid_anioHistorialFormaPago(esInicial);
		this.setActivarid_mesHistorialFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.ID)) {
				this.setActivaridHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setActivarid_tipo_forma_pagoHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.NUMERODIAS)) {
				this.setActivarnumero_diasHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.VALOR)) {
				this.setActivarvalorHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.FECHA)) {
				this.setActivarfechaHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.PORCENTAJERETENCION)) {
				this.setActivarporcentaje_retencionHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.BASERETENCION)) {
				this.setActivarbase_retencionHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.NUMERORETENCION)) {
				this.setActivarnumero_retencionHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.NOMBRERETENCION)) {
				this.setActivarnombre_retencionHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDANIO)) {
				this.setActivarid_anioHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDMES)) {
				this.setActivarid_mesHistorialFormaPago(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridHistorialFormaPago(esInicial);
		this.setResaltarid_empresaHistorialFormaPago(esInicial);
		this.setResaltarid_sucursalHistorialFormaPago(esInicial);
		this.setResaltarid_ejercicioHistorialFormaPago(esInicial);
		this.setResaltarid_periodoHistorialFormaPago(esInicial);
		this.setResaltarid_facturaHistorialFormaPago(esInicial);
		this.setResaltarid_tipo_forma_pagoHistorialFormaPago(esInicial);
		this.setResaltarid_cuenta_contableHistorialFormaPago(esInicial);
		this.setResaltarnumero_diasHistorialFormaPago(esInicial);
		this.setResaltarvalorHistorialFormaPago(esInicial);
		this.setResaltarfechaHistorialFormaPago(esInicial);
		this.setResaltarporcentajeHistorialFormaPago(esInicial);
		this.setResaltarporcentaje_retencionHistorialFormaPago(esInicial);
		this.setResaltarbase_retencionHistorialFormaPago(esInicial);
		this.setResaltarnumero_retencionHistorialFormaPago(esInicial);
		this.setResaltarnombre_retencionHistorialFormaPago(esInicial);
		this.setResaltarid_anioHistorialFormaPago(esInicial);
		this.setResaltarid_mesHistorialFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.ID)) {
				this.setResaltaridHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setResaltarid_tipo_forma_pagoHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.NUMERODIAS)) {
				this.setResaltarnumero_diasHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.VALOR)) {
				this.setResaltarvalorHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.FECHA)) {
				this.setResaltarfechaHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.PORCENTAJERETENCION)) {
				this.setResaltarporcentaje_retencionHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.BASERETENCION)) {
				this.setResaltarbase_retencionHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.NUMERORETENCION)) {
				this.setResaltarnumero_retencionHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.NOMBRERETENCION)) {
				this.setResaltarnombre_retencionHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioHistorialFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoConstantesFunciones.IDMES)) {
				this.setResaltarid_mesHistorialFormaPago(esAsigna);
				continue;
			}
		}
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


		for(Classe clase:clases) {
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


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarFK_IdCuentaContableHistorialFormaPago=true;

	public Boolean getMostrarFK_IdCuentaContableHistorialFormaPago() {
		return this.mostrarFK_IdCuentaContableHistorialFormaPago;
	}

	public void setMostrarFK_IdCuentaContableHistorialFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableHistorialFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioHistorialFormaPago=true;

	public Boolean getMostrarFK_IdEjercicioHistorialFormaPago() {
		return this.mostrarFK_IdEjercicioHistorialFormaPago;
	}

	public void setMostrarFK_IdEjercicioHistorialFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioHistorialFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaHistorialFormaPago=true;

	public Boolean getMostrarFK_IdEmpresaHistorialFormaPago() {
		return this.mostrarFK_IdEmpresaHistorialFormaPago;
	}

	public void setMostrarFK_IdEmpresaHistorialFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaHistorialFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaHistorialFormaPago=true;

	public Boolean getMostrarFK_IdFacturaHistorialFormaPago() {
		return this.mostrarFK_IdFacturaHistorialFormaPago;
	}

	public void setMostrarFK_IdFacturaHistorialFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaHistorialFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoHistorialFormaPago=true;

	public Boolean getMostrarFK_IdPeriodoHistorialFormaPago() {
		return this.mostrarFK_IdPeriodoHistorialFormaPago;
	}

	public void setMostrarFK_IdPeriodoHistorialFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoHistorialFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalHistorialFormaPago=true;

	public Boolean getMostrarFK_IdSucursalHistorialFormaPago() {
		return this.mostrarFK_IdSucursalHistorialFormaPago;
	}

	public void setMostrarFK_IdSucursalHistorialFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalHistorialFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoFormaPagoHistorialFormaPago=true;

	public Boolean getMostrarFK_IdTipoFormaPagoHistorialFormaPago() {
		return this.mostrarFK_IdTipoFormaPagoHistorialFormaPago;
	}

	public void setMostrarFK_IdTipoFormaPagoHistorialFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoFormaPagoHistorialFormaPago= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContableHistorialFormaPago=true;

	public Boolean getActivarFK_IdCuentaContableHistorialFormaPago() {
		return this.activarFK_IdCuentaContableHistorialFormaPago;
	}

	public void setActivarFK_IdCuentaContableHistorialFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableHistorialFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioHistorialFormaPago=true;

	public Boolean getActivarFK_IdEjercicioHistorialFormaPago() {
		return this.activarFK_IdEjercicioHistorialFormaPago;
	}

	public void setActivarFK_IdEjercicioHistorialFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioHistorialFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaHistorialFormaPago=true;

	public Boolean getActivarFK_IdEmpresaHistorialFormaPago() {
		return this.activarFK_IdEmpresaHistorialFormaPago;
	}

	public void setActivarFK_IdEmpresaHistorialFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaHistorialFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaHistorialFormaPago=true;

	public Boolean getActivarFK_IdFacturaHistorialFormaPago() {
		return this.activarFK_IdFacturaHistorialFormaPago;
	}

	public void setActivarFK_IdFacturaHistorialFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaHistorialFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoHistorialFormaPago=true;

	public Boolean getActivarFK_IdPeriodoHistorialFormaPago() {
		return this.activarFK_IdPeriodoHistorialFormaPago;
	}

	public void setActivarFK_IdPeriodoHistorialFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoHistorialFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalHistorialFormaPago=true;

	public Boolean getActivarFK_IdSucursalHistorialFormaPago() {
		return this.activarFK_IdSucursalHistorialFormaPago;
	}

	public void setActivarFK_IdSucursalHistorialFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalHistorialFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoFormaPagoHistorialFormaPago=true;

	public Boolean getActivarFK_IdTipoFormaPagoHistorialFormaPago() {
		return this.activarFK_IdTipoFormaPagoHistorialFormaPago;
	}

	public void setActivarFK_IdTipoFormaPagoHistorialFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdTipoFormaPagoHistorialFormaPago= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContableHistorialFormaPago=null;

	public Border getResaltarFK_IdCuentaContableHistorialFormaPago() {
		return this.resaltarFK_IdCuentaContableHistorialFormaPago;
	}

	public void setResaltarFK_IdCuentaContableHistorialFormaPago(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableHistorialFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableHistorialFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioHistorialFormaPago=null;

	public Border getResaltarFK_IdEjercicioHistorialFormaPago() {
		return this.resaltarFK_IdEjercicioHistorialFormaPago;
	}

	public void setResaltarFK_IdEjercicioHistorialFormaPago(Border borderResaltar) {
		this.resaltarFK_IdEjercicioHistorialFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioHistorialFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaHistorialFormaPago=null;

	public Border getResaltarFK_IdEmpresaHistorialFormaPago() {
		return this.resaltarFK_IdEmpresaHistorialFormaPago;
	}

	public void setResaltarFK_IdEmpresaHistorialFormaPago(Border borderResaltar) {
		this.resaltarFK_IdEmpresaHistorialFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaHistorialFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdFacturaHistorialFormaPago=null;

	public Border getResaltarFK_IdFacturaHistorialFormaPago() {
		return this.resaltarFK_IdFacturaHistorialFormaPago;
	}

	public void setResaltarFK_IdFacturaHistorialFormaPago(Border borderResaltar) {
		this.resaltarFK_IdFacturaHistorialFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdFacturaHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaHistorialFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoHistorialFormaPago=null;

	public Border getResaltarFK_IdPeriodoHistorialFormaPago() {
		return this.resaltarFK_IdPeriodoHistorialFormaPago;
	}

	public void setResaltarFK_IdPeriodoHistorialFormaPago(Border borderResaltar) {
		this.resaltarFK_IdPeriodoHistorialFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoHistorialFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdSucursalHistorialFormaPago=null;

	public Border getResaltarFK_IdSucursalHistorialFormaPago() {
		return this.resaltarFK_IdSucursalHistorialFormaPago;
	}

	public void setResaltarFK_IdSucursalHistorialFormaPago(Border borderResaltar) {
		this.resaltarFK_IdSucursalHistorialFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdSucursalHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalHistorialFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdTipoFormaPagoHistorialFormaPago=null;

	public Border getResaltarFK_IdTipoFormaPagoHistorialFormaPago() {
		return this.resaltarFK_IdTipoFormaPagoHistorialFormaPago;
	}

	public void setResaltarFK_IdTipoFormaPagoHistorialFormaPago(Border borderResaltar) {
		this.resaltarFK_IdTipoFormaPagoHistorialFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdTipoFormaPagoHistorialFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoBeanSwingJInternalFrame historialformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoFormaPagoHistorialFormaPago= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}