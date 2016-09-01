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


import com.bydan.erp.tesoreria.util.TablaRetencionConstantesFunciones;
import com.bydan.erp.tesoreria.util.TablaRetencionParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TablaRetencionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TablaRetencionConstantesFunciones extends TablaRetencionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TablaRetencion";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TablaRetencion"+TablaRetencionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TablaRetencionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TablaRetencionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TablaRetencionConstantesFunciones.SCHEMA+"_"+TablaRetencionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TablaRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TablaRetencionConstantesFunciones.SCHEMA+"_"+TablaRetencionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TablaRetencionConstantesFunciones.SCHEMA+"_"+TablaRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TablaRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TablaRetencionConstantesFunciones.SCHEMA+"_"+TablaRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TablaRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TablaRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TablaRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TablaRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TablaRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TablaRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TablaRetencionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TablaRetencionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TablaRetencionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TablaRetencionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tabla Retencions";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tabla Retencion";
	public static final String SCLASSWEBTITULO_LOWER="Tabla Retencion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TablaRetencion";
	public static final String OBJECTNAME="tablaretencion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="tabla_retencion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tablaretencion from "+TablaRetencionConstantesFunciones.SPERSISTENCENAME+" tablaretencion";
	public static String QUERYSELECTNATIVE="select "+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".id,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".version_row,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".id_empresa,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".codigo,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".nombre,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".porcentaje,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".monto_minimo,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".id_tipo_retencion,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".id_cuenta_contable_debito,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".es_debito,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".es_retencion_fuente,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".con_secuencial,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".con_sub_total_factura,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".con_iva_factura from "+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME;//+" as "+TablaRetencionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TablaRetencionConstantesFuncionesAdditional tablaretencionConstantesFuncionesAdditional=null;
	
	public TablaRetencionConstantesFuncionesAdditional getTablaRetencionConstantesFuncionesAdditional() {
		return this.tablaretencionConstantesFuncionesAdditional;
	}
	
	public void setTablaRetencionConstantesFuncionesAdditional(TablaRetencionConstantesFuncionesAdditional tablaretencionConstantesFuncionesAdditional) {
		try {
			this.tablaretencionConstantesFuncionesAdditional=tablaretencionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String PORCENTAJE= "porcentaje";
    public static final String MONTOMINIMO= "monto_minimo";
    public static final String IDTIPORETENCION= "id_tipo_retencion";
    public static final String IDCUENTACONTABLEDEBITO= "id_cuenta_contable_debito";
    public static final String IDCUENTACONTABLECREDITO= "id_cuenta_contable_credito";
    public static final String ESDEBITO= "es_debito";
    public static final String ESRETENCIONFUENTE= "es_retencion_fuente";
    public static final String CONSECUENCIAL= "con_secuencial";
    public static final String CONSUBTOTALFACTURA= "con_sub_total_factura";
    public static final String CONIVAFACTURA= "con_iva_factura";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_MONTOMINIMO= "Monto Minimo";
		public static final String LABEL_MONTOMINIMO_LOWER= "Monto Minimo";
    	public static final String LABEL_IDTIPORETENCION= "Tipo Retencion";
		public static final String LABEL_IDTIPORETENCION_LOWER= "Tipo Retencion";
    	public static final String LABEL_IDCUENTACONTABLEDEBITO= "Cuenta Contable Debito";
		public static final String LABEL_IDCUENTACONTABLEDEBITO_LOWER= "Cuenta Contable Debito";
    	public static final String LABEL_IDCUENTACONTABLECREDITO= "Cuenta Contable Credito";
		public static final String LABEL_IDCUENTACONTABLECREDITO_LOWER= "Cuenta Contable Credito";
    	public static final String LABEL_ESDEBITO= "Es Debito";
		public static final String LABEL_ESDEBITO_LOWER= "Es Debito";
    	public static final String LABEL_ESRETENCIONFUENTE= "Es Retencion Fuente";
		public static final String LABEL_ESRETENCIONFUENTE_LOWER= "Es Retencion Fuente";
    	public static final String LABEL_CONSECUENCIAL= "Con Secuencial";
		public static final String LABEL_CONSECUENCIAL_LOWER= "Con Secuencial";
    	public static final String LABEL_CONSUBTOTALFACTURA= "Con Sub Total Factura";
		public static final String LABEL_CONSUBTOTALFACTURA_LOWER= "Con Sub Total Factura";
    	public static final String LABEL_CONIVAFACTURA= "Con Iva Factura";
		public static final String LABEL_CONIVAFACTURA_LOWER= "Con Iva Factura";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
	
	public static String getTablaRetencionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TablaRetencionConstantesFunciones.IDEMPRESA)) {sLabelColumna=TablaRetencionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TablaRetencionConstantesFunciones.CODIGO)) {sLabelColumna=TablaRetencionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TablaRetencionConstantesFunciones.NOMBRE)) {sLabelColumna=TablaRetencionConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TablaRetencionConstantesFunciones.PORCENTAJE)) {sLabelColumna=TablaRetencionConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(TablaRetencionConstantesFunciones.MONTOMINIMO)) {sLabelColumna=TablaRetencionConstantesFunciones.LABEL_MONTOMINIMO;}
		if(sNombreColumna.equals(TablaRetencionConstantesFunciones.IDTIPORETENCION)) {sLabelColumna=TablaRetencionConstantesFunciones.LABEL_IDTIPORETENCION;}
		if(sNombreColumna.equals(TablaRetencionConstantesFunciones.IDCUENTACONTABLEDEBITO)) {sLabelColumna=TablaRetencionConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO;}
		if(sNombreColumna.equals(TablaRetencionConstantesFunciones.IDCUENTACONTABLECREDITO)) {sLabelColumna=TablaRetencionConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO;}
		if(sNombreColumna.equals(TablaRetencionConstantesFunciones.ESDEBITO)) {sLabelColumna=TablaRetencionConstantesFunciones.LABEL_ESDEBITO;}
		if(sNombreColumna.equals(TablaRetencionConstantesFunciones.ESRETENCIONFUENTE)) {sLabelColumna=TablaRetencionConstantesFunciones.LABEL_ESRETENCIONFUENTE;}
		if(sNombreColumna.equals(TablaRetencionConstantesFunciones.CONSECUENCIAL)) {sLabelColumna=TablaRetencionConstantesFunciones.LABEL_CONSECUENCIAL;}
		if(sNombreColumna.equals(TablaRetencionConstantesFunciones.CONSUBTOTALFACTURA)) {sLabelColumna=TablaRetencionConstantesFunciones.LABEL_CONSUBTOTALFACTURA;}
		if(sNombreColumna.equals(TablaRetencionConstantesFunciones.CONIVAFACTURA)) {sLabelColumna=TablaRetencionConstantesFunciones.LABEL_CONIVAFACTURA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_debitoDescripcion(TablaRetencion tablaretencion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tablaretencion.getes_debito()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_debitoHtmlDescripcion(TablaRetencion tablaretencion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tablaretencion.getId(),tablaretencion.getes_debito());

		return sDescripcion;
	}	
		
	public static String getes_retencion_fuenteDescripcion(TablaRetencion tablaretencion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tablaretencion.getes_retencion_fuente()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_retencion_fuenteHtmlDescripcion(TablaRetencion tablaretencion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tablaretencion.getId(),tablaretencion.getes_retencion_fuente());

		return sDescripcion;
	}	
		
	public static String getcon_secuencialDescripcion(TablaRetencion tablaretencion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tablaretencion.getcon_secuencial()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_secuencialHtmlDescripcion(TablaRetencion tablaretencion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tablaretencion.getId(),tablaretencion.getcon_secuencial());

		return sDescripcion;
	}	
		
	public static String getcon_sub_total_facturaDescripcion(TablaRetencion tablaretencion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tablaretencion.getcon_sub_total_factura()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_sub_total_facturaHtmlDescripcion(TablaRetencion tablaretencion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tablaretencion.getId(),tablaretencion.getcon_sub_total_factura());

		return sDescripcion;
	}	
		
	public static String getcon_iva_facturaDescripcion(TablaRetencion tablaretencion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tablaretencion.getcon_iva_factura()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_iva_facturaHtmlDescripcion(TablaRetencion tablaretencion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tablaretencion.getId(),tablaretencion.getcon_iva_factura());

		return sDescripcion;
	}	
	
	public static String getTablaRetencionDescripcion(TablaRetencion tablaretencion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tablaretencion !=null/* && tablaretencion.getId()!=0*/) {
			sDescripcion=tablaretencion.getcodigo();//tablaretenciontablaretencion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTablaRetencionDescripcionDetallado(TablaRetencion tablaretencion) {
		String sDescripcion="";
			
		sDescripcion+=TablaRetencionConstantesFunciones.ID+"=";
		sDescripcion+=tablaretencion.getId().toString()+",";
		sDescripcion+=TablaRetencionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tablaretencion.getVersionRow().toString()+",";
		sDescripcion+=TablaRetencionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tablaretencion.getid_empresa().toString()+",";
		sDescripcion+=TablaRetencionConstantesFunciones.CODIGO+"=";
		sDescripcion+=tablaretencion.getcodigo()+",";
		sDescripcion+=TablaRetencionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tablaretencion.getnombre()+",";
		sDescripcion+=TablaRetencionConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=tablaretencion.getporcentaje().toString()+",";
		sDescripcion+=TablaRetencionConstantesFunciones.MONTOMINIMO+"=";
		sDescripcion+=tablaretencion.getmonto_minimo().toString()+",";
		sDescripcion+=TablaRetencionConstantesFunciones.IDTIPORETENCION+"=";
		sDescripcion+=tablaretencion.getid_tipo_retencion().toString()+",";
		sDescripcion+=TablaRetencionConstantesFunciones.IDCUENTACONTABLEDEBITO+"=";
		sDescripcion+=tablaretencion.getid_cuenta_contable_debito().toString()+",";
		sDescripcion+=TablaRetencionConstantesFunciones.IDCUENTACONTABLECREDITO+"=";
		sDescripcion+=tablaretencion.getid_cuenta_contable_credito().toString()+",";
		sDescripcion+=TablaRetencionConstantesFunciones.ESDEBITO+"=";
		sDescripcion+=tablaretencion.getes_debito().toString()+",";
		sDescripcion+=TablaRetencionConstantesFunciones.ESRETENCIONFUENTE+"=";
		sDescripcion+=tablaretencion.getes_retencion_fuente().toString()+",";
		sDescripcion+=TablaRetencionConstantesFunciones.CONSECUENCIAL+"=";
		sDescripcion+=tablaretencion.getcon_secuencial().toString()+",";
		sDescripcion+=TablaRetencionConstantesFunciones.CONSUBTOTALFACTURA+"=";
		sDescripcion+=tablaretencion.getcon_sub_total_factura().toString()+",";
		sDescripcion+=TablaRetencionConstantesFunciones.CONIVAFACTURA+"=";
		sDescripcion+=tablaretencion.getcon_iva_factura().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTablaRetencionDescripcion(TablaRetencion tablaretencion,String sValor) throws Exception {			
		if(tablaretencion !=null) {
			tablaretencion.setcodigo(sValor);;//tablaretenciontablaretencion.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionDescripcion(TipoRetencion tiporetencion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencion!=null/*&&tiporetencion.getId()>0*/) {
			sDescripcion=TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tiporetencion);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDebitoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCreditoDescripcion(CuentaContable cuentacontable) {
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
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCredito")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Credito";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDebito")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Debito";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoRetencion")) {
			sNombreIndice="Tipo=  Por Tipo Retencion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCredito(Long id_cuenta_contable_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_credito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Credito="+id_cuenta_contable_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableDebito(Long id_cuenta_contable_debito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_debito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Debito="+id_cuenta_contable_debito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencion(Long id_tipo_retencion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Retencion="+id_tipo_retencion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTablaRetencion(TablaRetencion tablaretencion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tablaretencion.setcodigo(tablaretencion.getcodigo().trim());
		tablaretencion.setnombre(tablaretencion.getnombre().trim());
	}
	
	public static void quitarEspaciosTablaRetencions(List<TablaRetencion> tablaretencions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TablaRetencion tablaretencion: tablaretencions) {
			tablaretencion.setcodigo(tablaretencion.getcodigo().trim());
			tablaretencion.setnombre(tablaretencion.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTablaRetencion(TablaRetencion tablaretencion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tablaretencion.getConCambioAuxiliar()) {
			tablaretencion.setIsDeleted(tablaretencion.getIsDeletedAuxiliar());	
			tablaretencion.setIsNew(tablaretencion.getIsNewAuxiliar());	
			tablaretencion.setIsChanged(tablaretencion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tablaretencion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tablaretencion.setIsDeletedAuxiliar(false);	
			tablaretencion.setIsNewAuxiliar(false);	
			tablaretencion.setIsChangedAuxiliar(false);
			
			tablaretencion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTablaRetencions(List<TablaRetencion> tablaretencions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TablaRetencion tablaretencion : tablaretencions) {
			if(conAsignarBase && tablaretencion.getConCambioAuxiliar()) {
				tablaretencion.setIsDeleted(tablaretencion.getIsDeletedAuxiliar());	
				tablaretencion.setIsNew(tablaretencion.getIsNewAuxiliar());	
				tablaretencion.setIsChanged(tablaretencion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tablaretencion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tablaretencion.setIsDeletedAuxiliar(false);	
				tablaretencion.setIsNewAuxiliar(false);	
				tablaretencion.setIsChangedAuxiliar(false);
				
				tablaretencion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTablaRetencion(TablaRetencion tablaretencion,Boolean conEnteros) throws Exception  {
		tablaretencion.setporcentaje(0.0);
		tablaretencion.setmonto_minimo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTablaRetencions(List<TablaRetencion> tablaretencions,Boolean conEnteros) throws Exception  {
		
		for(TablaRetencion tablaretencion: tablaretencions) {
			tablaretencion.setporcentaje(0.0);
			tablaretencion.setmonto_minimo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTablaRetencion(List<TablaRetencion> tablaretencions,TablaRetencion tablaretencionAux) throws Exception  {
		TablaRetencionConstantesFunciones.InicializarValoresTablaRetencion(tablaretencionAux,true);
		
		for(TablaRetencion tablaretencion: tablaretencions) {
			if(tablaretencion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			tablaretencionAux.setporcentaje(tablaretencionAux.getporcentaje()+tablaretencion.getporcentaje());			
			tablaretencionAux.setmonto_minimo(tablaretencionAux.getmonto_minimo()+tablaretencion.getmonto_minimo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTablaRetencion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TablaRetencionConstantesFunciones.getArrayColumnasGlobalesTablaRetencion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTablaRetencion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TablaRetencionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TablaRetencionConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTablaRetencion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TablaRetencion> tablaretencions,TablaRetencion tablaretencion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TablaRetencion tablaretencionAux: tablaretencions) {
			if(tablaretencionAux!=null && tablaretencion!=null) {
				if((tablaretencionAux.getId()==null && tablaretencion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tablaretencionAux.getId()!=null && tablaretencion.getId()!=null){
					if(tablaretencionAux.getId().equals(tablaretencion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTablaRetencion(List<TablaRetencion> tablaretencions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double monto_minimoTotal=0.0;
	
		for(TablaRetencion tablaretencion: tablaretencions) {			
			if(tablaretencion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=tablaretencion.getporcentaje();
			monto_minimoTotal+=tablaretencion.getmonto_minimo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TablaRetencionConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(TablaRetencionConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TablaRetencionConstantesFunciones.MONTOMINIMO);
		datoGeneral.setsDescripcion(TablaRetencionConstantesFunciones.LABEL_MONTOMINIMO);
		datoGeneral.setdValorDouble(monto_minimoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTablaRetencion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TablaRetencionConstantesFunciones.LABEL_ID, TablaRetencionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaRetencionConstantesFunciones.LABEL_VERSIONROW, TablaRetencionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaRetencionConstantesFunciones.LABEL_IDEMPRESA, TablaRetencionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaRetencionConstantesFunciones.LABEL_CODIGO, TablaRetencionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaRetencionConstantesFunciones.LABEL_NOMBRE, TablaRetencionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaRetencionConstantesFunciones.LABEL_PORCENTAJE, TablaRetencionConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaRetencionConstantesFunciones.LABEL_MONTOMINIMO, TablaRetencionConstantesFunciones.MONTOMINIMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaRetencionConstantesFunciones.LABEL_IDTIPORETENCION, TablaRetencionConstantesFunciones.IDTIPORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaRetencionConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO, TablaRetencionConstantesFunciones.IDCUENTACONTABLEDEBITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaRetencionConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO, TablaRetencionConstantesFunciones.IDCUENTACONTABLECREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaRetencionConstantesFunciones.LABEL_ESDEBITO, TablaRetencionConstantesFunciones.ESDEBITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaRetencionConstantesFunciones.LABEL_ESRETENCIONFUENTE, TablaRetencionConstantesFunciones.ESRETENCIONFUENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaRetencionConstantesFunciones.LABEL_CONSECUENCIAL, TablaRetencionConstantesFunciones.CONSECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaRetencionConstantesFunciones.LABEL_CONSUBTOTALFACTURA, TablaRetencionConstantesFunciones.CONSUBTOTALFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaRetencionConstantesFunciones.LABEL_CONIVAFACTURA, TablaRetencionConstantesFunciones.CONIVAFACTURA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTablaRetencion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TablaRetencionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaRetencionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaRetencionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaRetencionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaRetencionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaRetencionConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaRetencionConstantesFunciones.MONTOMINIMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaRetencionConstantesFunciones.IDTIPORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaRetencionConstantesFunciones.IDCUENTACONTABLEDEBITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaRetencionConstantesFunciones.IDCUENTACONTABLECREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaRetencionConstantesFunciones.ESDEBITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaRetencionConstantesFunciones.ESRETENCIONFUENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaRetencionConstantesFunciones.CONSECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaRetencionConstantesFunciones.CONSUBTOTALFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaRetencionConstantesFunciones.CONIVAFACTURA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTablaRetencion() throws Exception  {
		return TablaRetencionConstantesFunciones.getTiposSeleccionarTablaRetencion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTablaRetencion(Boolean conFk) throws Exception  {
		return TablaRetencionConstantesFunciones.getTiposSeleccionarTablaRetencion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTablaRetencion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaRetencionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TablaRetencionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaRetencionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TablaRetencionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaRetencionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TablaRetencionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaRetencionConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(TablaRetencionConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaRetencionConstantesFunciones.LABEL_MONTOMINIMO);
			reporte.setsDescripcion(TablaRetencionConstantesFunciones.LABEL_MONTOMINIMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaRetencionConstantesFunciones.LABEL_IDTIPORETENCION);
			reporte.setsDescripcion(TablaRetencionConstantesFunciones.LABEL_IDTIPORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaRetencionConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);
			reporte.setsDescripcion(TablaRetencionConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaRetencionConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
			reporte.setsDescripcion(TablaRetencionConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaRetencionConstantesFunciones.LABEL_ESDEBITO);
			reporte.setsDescripcion(TablaRetencionConstantesFunciones.LABEL_ESDEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaRetencionConstantesFunciones.LABEL_ESRETENCIONFUENTE);
			reporte.setsDescripcion(TablaRetencionConstantesFunciones.LABEL_ESRETENCIONFUENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaRetencionConstantesFunciones.LABEL_CONSECUENCIAL);
			reporte.setsDescripcion(TablaRetencionConstantesFunciones.LABEL_CONSECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaRetencionConstantesFunciones.LABEL_CONSUBTOTALFACTURA);
			reporte.setsDescripcion(TablaRetencionConstantesFunciones.LABEL_CONSUBTOTALFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaRetencionConstantesFunciones.LABEL_CONIVAFACTURA);
			reporte.setsDescripcion(TablaRetencionConstantesFunciones.LABEL_CONIVAFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTablaRetencion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTablaRetencion(TablaRetencion tablaretencionAux) throws Exception {
		
			tablaretencionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tablaretencionAux.getEmpresa()));
			tablaretencionAux.settiporetencion_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tablaretencionAux.getTipoRetencion()));
			tablaretencionAux.setcuentacontabledebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tablaretencionAux.getCuentaContableDebito()));
			tablaretencionAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tablaretencionAux.getCuentaContableCredito()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTablaRetencion(List<TablaRetencion> tablaretencionsTemp) throws Exception {
		for(TablaRetencion tablaretencionAux:tablaretencionsTemp) {
			
			tablaretencionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tablaretencionAux.getEmpresa()));
			tablaretencionAux.settiporetencion_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tablaretencionAux.getTipoRetencion()));
			tablaretencionAux.setcuentacontabledebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tablaretencionAux.getCuentaContableDebito()));
			tablaretencionAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tablaretencionAux.getCuentaContableCredito()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTablaRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoRetencion.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencion.class)) {
						classes.add(new Classe(TipoRetencion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTablaRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
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

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTablaRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TablaRetencionConstantesFunciones.getClassesRelationshipsOfTablaRetencion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTablaRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTablaRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TablaRetencionConstantesFunciones.getClassesRelationshipsFromStringsOfTablaRetencion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTablaRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TablaRetencion tablaretencion,List<TablaRetencion> tablaretencions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TablaRetencion tablaretencionEncontrado=null;
			
			for(TablaRetencion tablaretencionLocal:tablaretencions) {
				if(tablaretencionLocal.getId().equals(tablaretencion.getId())) {
					tablaretencionEncontrado=tablaretencionLocal;
					
					tablaretencionLocal.setIsChanged(tablaretencion.getIsChanged());
					tablaretencionLocal.setIsNew(tablaretencion.getIsNew());
					tablaretencionLocal.setIsDeleted(tablaretencion.getIsDeleted());
					
					tablaretencionLocal.setGeneralEntityOriginal(tablaretencion.getGeneralEntityOriginal());
					
					tablaretencionLocal.setId(tablaretencion.getId());	
					tablaretencionLocal.setVersionRow(tablaretencion.getVersionRow());	
					tablaretencionLocal.setid_empresa(tablaretencion.getid_empresa());	
					tablaretencionLocal.setcodigo(tablaretencion.getcodigo());	
					tablaretencionLocal.setnombre(tablaretencion.getnombre());	
					tablaretencionLocal.setporcentaje(tablaretencion.getporcentaje());	
					tablaretencionLocal.setmonto_minimo(tablaretencion.getmonto_minimo());	
					tablaretencionLocal.setid_tipo_retencion(tablaretencion.getid_tipo_retencion());	
					tablaretencionLocal.setid_cuenta_contable_debito(tablaretencion.getid_cuenta_contable_debito());	
					tablaretencionLocal.setid_cuenta_contable_credito(tablaretencion.getid_cuenta_contable_credito());	
					tablaretencionLocal.setes_debito(tablaretencion.getes_debito());	
					tablaretencionLocal.setes_retencion_fuente(tablaretencion.getes_retencion_fuente());	
					tablaretencionLocal.setcon_secuencial(tablaretencion.getcon_secuencial());	
					tablaretencionLocal.setcon_sub_total_factura(tablaretencion.getcon_sub_total_factura());	
					tablaretencionLocal.setcon_iva_factura(tablaretencion.getcon_iva_factura());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tablaretencion.getIsDeleted()) {
				if(!existe) {
					tablaretencions.add(tablaretencion);
				}
			} else {
				if(tablaretencionEncontrado!=null && permiteQuitar)  {
					tablaretencions.remove(tablaretencionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TablaRetencion tablaretencion,List<TablaRetencion> tablaretencions) throws Exception {
		try	{			
			for(TablaRetencion tablaretencionLocal:tablaretencions) {
				if(tablaretencionLocal.getId().equals(tablaretencion.getId())) {
					tablaretencionLocal.setIsSelected(tablaretencion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTablaRetencion(List<TablaRetencion> tablaretencionsAux) throws Exception {
		//this.tablaretencionsAux=tablaretencionsAux;
		
		for(TablaRetencion tablaretencionAux:tablaretencionsAux) {
			if(tablaretencionAux.getIsChanged()) {
				tablaretencionAux.setIsChanged(false);
			}		
			
			if(tablaretencionAux.getIsNew()) {
				tablaretencionAux.setIsNew(false);
			}	
			
			if(tablaretencionAux.getIsDeleted()) {
				tablaretencionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTablaRetencion(TablaRetencion tablaretencionAux) throws Exception {
		//this.tablaretencionAux=tablaretencionAux;
		
			if(tablaretencionAux.getIsChanged()) {
				tablaretencionAux.setIsChanged(false);
			}		
			
			if(tablaretencionAux.getIsNew()) {
				tablaretencionAux.setIsNew(false);
			}	
			
			if(tablaretencionAux.getIsDeleted()) {
				tablaretencionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TablaRetencion tablaretencionAsignar,TablaRetencion tablaretencion) throws Exception {
		tablaretencionAsignar.setId(tablaretencion.getId());	
		tablaretencionAsignar.setVersionRow(tablaretencion.getVersionRow());	
		tablaretencionAsignar.setid_empresa(tablaretencion.getid_empresa());
		tablaretencionAsignar.setempresa_descripcion(tablaretencion.getempresa_descripcion());	
		tablaretencionAsignar.setcodigo(tablaretencion.getcodigo());	
		tablaretencionAsignar.setnombre(tablaretencion.getnombre());	
		tablaretencionAsignar.setporcentaje(tablaretencion.getporcentaje());	
		tablaretencionAsignar.setmonto_minimo(tablaretencion.getmonto_minimo());	
		tablaretencionAsignar.setid_tipo_retencion(tablaretencion.getid_tipo_retencion());
		tablaretencionAsignar.settiporetencion_descripcion(tablaretencion.gettiporetencion_descripcion());	
		tablaretencionAsignar.setid_cuenta_contable_debito(tablaretencion.getid_cuenta_contable_debito());
		tablaretencionAsignar.setcuentacontabledebito_descripcion(tablaretencion.getcuentacontabledebito_descripcion());	
		tablaretencionAsignar.setid_cuenta_contable_credito(tablaretencion.getid_cuenta_contable_credito());
		tablaretencionAsignar.setcuentacontablecredito_descripcion(tablaretencion.getcuentacontablecredito_descripcion());	
		tablaretencionAsignar.setes_debito(tablaretencion.getes_debito());	
		tablaretencionAsignar.setes_retencion_fuente(tablaretencion.getes_retencion_fuente());	
		tablaretencionAsignar.setcon_secuencial(tablaretencion.getcon_secuencial());	
		tablaretencionAsignar.setcon_sub_total_factura(tablaretencion.getcon_sub_total_factura());	
		tablaretencionAsignar.setcon_iva_factura(tablaretencion.getcon_iva_factura());	
	}
	
	public static void inicializarTablaRetencion(TablaRetencion tablaretencion) throws Exception {
		try {
				tablaretencion.setId(0L);	
					
				tablaretencion.setid_empresa(-1L);	
				tablaretencion.setcodigo("");	
				tablaretencion.setnombre("");	
				tablaretencion.setporcentaje(0.0);	
				tablaretencion.setmonto_minimo(0.0);	
				tablaretencion.setid_tipo_retencion(-1L);	
				tablaretencion.setid_cuenta_contable_debito(-1L);	
				tablaretencion.setid_cuenta_contable_credito(null);	
				tablaretencion.setes_debito(false);	
				tablaretencion.setes_retencion_fuente(false);	
				tablaretencion.setcon_secuencial(false);	
				tablaretencion.setcon_sub_total_factura(false);	
				tablaretencion.setcon_iva_factura(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTablaRetencion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaRetencionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaRetencionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaRetencionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaRetencionConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaRetencionConstantesFunciones.LABEL_MONTOMINIMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaRetencionConstantesFunciones.LABEL_IDTIPORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaRetencionConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaRetencionConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaRetencionConstantesFunciones.LABEL_ESDEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaRetencionConstantesFunciones.LABEL_ESRETENCIONFUENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaRetencionConstantesFunciones.LABEL_CONSECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaRetencionConstantesFunciones.LABEL_CONSUBTOTALFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaRetencionConstantesFunciones.LABEL_CONIVAFACTURA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTablaRetencion(String sTipo,Row row,Workbook workbook,TablaRetencion tablaretencion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaretencion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaretencion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaretencion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaretencion.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaretencion.getmonto_minimo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaretencion.gettiporetencion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaretencion.getcuentacontabledebito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaretencion.getcuentacontablecredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tablaretencion.getes_debito()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tablaretencion.getes_retencion_fuente()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tablaretencion.getcon_secuencial()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tablaretencion.getcon_sub_total_factura()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tablaretencion.getcon_iva_factura()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTablaRetencion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTablaRetencion() {
		return this.sFinalQueryTablaRetencion;
	}
	
	public void setsFinalQueryTablaRetencion(String sFinalQueryTablaRetencion) {
		this.sFinalQueryTablaRetencion= sFinalQueryTablaRetencion;
	}
	
	public Border resaltarSeleccionarTablaRetencion=null;
	
	public Border setResaltarSeleccionarTablaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tablaretencionBeanSwingJInternalFrame.jTtoolBarTablaRetencion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTablaRetencion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTablaRetencion() {
		return this.resaltarSeleccionarTablaRetencion;
	}
	
	public void setResaltarSeleccionarTablaRetencion(Border borderResaltarSeleccionarTablaRetencion) {
		this.resaltarSeleccionarTablaRetencion= borderResaltarSeleccionarTablaRetencion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTablaRetencion=null;
	public Boolean mostraridTablaRetencion=true;
	public Boolean activaridTablaRetencion=true;

	public Border resaltarid_empresaTablaRetencion=null;
	public Boolean mostrarid_empresaTablaRetencion=true;
	public Boolean activarid_empresaTablaRetencion=true;
	public Boolean cargarid_empresaTablaRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTablaRetencion=false;//ConEventDepend=true

	public Border resaltarcodigoTablaRetencion=null;
	public Boolean mostrarcodigoTablaRetencion=true;
	public Boolean activarcodigoTablaRetencion=true;

	public Border resaltarnombreTablaRetencion=null;
	public Boolean mostrarnombreTablaRetencion=true;
	public Boolean activarnombreTablaRetencion=true;

	public Border resaltarporcentajeTablaRetencion=null;
	public Boolean mostrarporcentajeTablaRetencion=true;
	public Boolean activarporcentajeTablaRetencion=true;

	public Border resaltarmonto_minimoTablaRetencion=null;
	public Boolean mostrarmonto_minimoTablaRetencion=true;
	public Boolean activarmonto_minimoTablaRetencion=true;

	public Border resaltarid_tipo_retencionTablaRetencion=null;
	public Boolean mostrarid_tipo_retencionTablaRetencion=true;
	public Boolean activarid_tipo_retencionTablaRetencion=true;
	public Boolean cargarid_tipo_retencionTablaRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencionTablaRetencion=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_debitoTablaRetencion=null;
	public Boolean mostrarid_cuenta_contable_debitoTablaRetencion=true;
	public Boolean activarid_cuenta_contable_debitoTablaRetencion=true;
	public Boolean cargarid_cuenta_contable_debitoTablaRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_debitoTablaRetencion=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_creditoTablaRetencion=null;
	public Boolean mostrarid_cuenta_contable_creditoTablaRetencion=true;
	public Boolean activarid_cuenta_contable_creditoTablaRetencion=true;
	public Boolean cargarid_cuenta_contable_creditoTablaRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_creditoTablaRetencion=false;//ConEventDepend=true

	public Border resaltares_debitoTablaRetencion=null;
	public Boolean mostrares_debitoTablaRetencion=true;
	public Boolean activares_debitoTablaRetencion=true;

	public Border resaltares_retencion_fuenteTablaRetencion=null;
	public Boolean mostrares_retencion_fuenteTablaRetencion=true;
	public Boolean activares_retencion_fuenteTablaRetencion=true;

	public Border resaltarcon_secuencialTablaRetencion=null;
	public Boolean mostrarcon_secuencialTablaRetencion=true;
	public Boolean activarcon_secuencialTablaRetencion=true;

	public Border resaltarcon_sub_total_facturaTablaRetencion=null;
	public Boolean mostrarcon_sub_total_facturaTablaRetencion=true;
	public Boolean activarcon_sub_total_facturaTablaRetencion=true;

	public Border resaltarcon_iva_facturaTablaRetencion=null;
	public Boolean mostrarcon_iva_facturaTablaRetencion=true;
	public Boolean activarcon_iva_facturaTablaRetencion=true;

	
	

	public Border setResaltaridTablaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaretencionBeanSwingJInternalFrame.jTtoolBarTablaRetencion.setBorder(borderResaltar);
		
		this.resaltaridTablaRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTablaRetencion() {
		return this.resaltaridTablaRetencion;
	}

	public void setResaltaridTablaRetencion(Border borderResaltar) {
		this.resaltaridTablaRetencion= borderResaltar;
	}

	public Boolean getMostraridTablaRetencion() {
		return this.mostraridTablaRetencion;
	}

	public void setMostraridTablaRetencion(Boolean mostraridTablaRetencion) {
		this.mostraridTablaRetencion= mostraridTablaRetencion;
	}

	public Boolean getActivaridTablaRetencion() {
		return this.activaridTablaRetencion;
	}

	public void setActivaridTablaRetencion(Boolean activaridTablaRetencion) {
		this.activaridTablaRetencion= activaridTablaRetencion;
	}

	public Border setResaltarid_empresaTablaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaretencionBeanSwingJInternalFrame.jTtoolBarTablaRetencion.setBorder(borderResaltar);
		
		this.resaltarid_empresaTablaRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTablaRetencion() {
		return this.resaltarid_empresaTablaRetencion;
	}

	public void setResaltarid_empresaTablaRetencion(Border borderResaltar) {
		this.resaltarid_empresaTablaRetencion= borderResaltar;
	}

	public Boolean getMostrarid_empresaTablaRetencion() {
		return this.mostrarid_empresaTablaRetencion;
	}

	public void setMostrarid_empresaTablaRetencion(Boolean mostrarid_empresaTablaRetencion) {
		this.mostrarid_empresaTablaRetencion= mostrarid_empresaTablaRetencion;
	}

	public Boolean getActivarid_empresaTablaRetencion() {
		return this.activarid_empresaTablaRetencion;
	}

	public void setActivarid_empresaTablaRetencion(Boolean activarid_empresaTablaRetencion) {
		this.activarid_empresaTablaRetencion= activarid_empresaTablaRetencion;
	}

	public Boolean getCargarid_empresaTablaRetencion() {
		return this.cargarid_empresaTablaRetencion;
	}

	public void setCargarid_empresaTablaRetencion(Boolean cargarid_empresaTablaRetencion) {
		this.cargarid_empresaTablaRetencion= cargarid_empresaTablaRetencion;
	}

	public Border setResaltarcodigoTablaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaretencionBeanSwingJInternalFrame.jTtoolBarTablaRetencion.setBorder(borderResaltar);
		
		this.resaltarcodigoTablaRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTablaRetencion() {
		return this.resaltarcodigoTablaRetencion;
	}

	public void setResaltarcodigoTablaRetencion(Border borderResaltar) {
		this.resaltarcodigoTablaRetencion= borderResaltar;
	}

	public Boolean getMostrarcodigoTablaRetencion() {
		return this.mostrarcodigoTablaRetencion;
	}

	public void setMostrarcodigoTablaRetencion(Boolean mostrarcodigoTablaRetencion) {
		this.mostrarcodigoTablaRetencion= mostrarcodigoTablaRetencion;
	}

	public Boolean getActivarcodigoTablaRetencion() {
		return this.activarcodigoTablaRetencion;
	}

	public void setActivarcodigoTablaRetencion(Boolean activarcodigoTablaRetencion) {
		this.activarcodigoTablaRetencion= activarcodigoTablaRetencion;
	}

	public Border setResaltarnombreTablaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaretencionBeanSwingJInternalFrame.jTtoolBarTablaRetencion.setBorder(borderResaltar);
		
		this.resaltarnombreTablaRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTablaRetencion() {
		return this.resaltarnombreTablaRetencion;
	}

	public void setResaltarnombreTablaRetencion(Border borderResaltar) {
		this.resaltarnombreTablaRetencion= borderResaltar;
	}

	public Boolean getMostrarnombreTablaRetencion() {
		return this.mostrarnombreTablaRetencion;
	}

	public void setMostrarnombreTablaRetencion(Boolean mostrarnombreTablaRetencion) {
		this.mostrarnombreTablaRetencion= mostrarnombreTablaRetencion;
	}

	public Boolean getActivarnombreTablaRetencion() {
		return this.activarnombreTablaRetencion;
	}

	public void setActivarnombreTablaRetencion(Boolean activarnombreTablaRetencion) {
		this.activarnombreTablaRetencion= activarnombreTablaRetencion;
	}

	public Border setResaltarporcentajeTablaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaretencionBeanSwingJInternalFrame.jTtoolBarTablaRetencion.setBorder(borderResaltar);
		
		this.resaltarporcentajeTablaRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeTablaRetencion() {
		return this.resaltarporcentajeTablaRetencion;
	}

	public void setResaltarporcentajeTablaRetencion(Border borderResaltar) {
		this.resaltarporcentajeTablaRetencion= borderResaltar;
	}

	public Boolean getMostrarporcentajeTablaRetencion() {
		return this.mostrarporcentajeTablaRetencion;
	}

	public void setMostrarporcentajeTablaRetencion(Boolean mostrarporcentajeTablaRetencion) {
		this.mostrarporcentajeTablaRetencion= mostrarporcentajeTablaRetencion;
	}

	public Boolean getActivarporcentajeTablaRetencion() {
		return this.activarporcentajeTablaRetencion;
	}

	public void setActivarporcentajeTablaRetencion(Boolean activarporcentajeTablaRetencion) {
		this.activarporcentajeTablaRetencion= activarporcentajeTablaRetencion;
	}

	public Border setResaltarmonto_minimoTablaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaretencionBeanSwingJInternalFrame.jTtoolBarTablaRetencion.setBorder(borderResaltar);
		
		this.resaltarmonto_minimoTablaRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_minimoTablaRetencion() {
		return this.resaltarmonto_minimoTablaRetencion;
	}

	public void setResaltarmonto_minimoTablaRetencion(Border borderResaltar) {
		this.resaltarmonto_minimoTablaRetencion= borderResaltar;
	}

	public Boolean getMostrarmonto_minimoTablaRetencion() {
		return this.mostrarmonto_minimoTablaRetencion;
	}

	public void setMostrarmonto_minimoTablaRetencion(Boolean mostrarmonto_minimoTablaRetencion) {
		this.mostrarmonto_minimoTablaRetencion= mostrarmonto_minimoTablaRetencion;
	}

	public Boolean getActivarmonto_minimoTablaRetencion() {
		return this.activarmonto_minimoTablaRetencion;
	}

	public void setActivarmonto_minimoTablaRetencion(Boolean activarmonto_minimoTablaRetencion) {
		this.activarmonto_minimoTablaRetencion= activarmonto_minimoTablaRetencion;
	}

	public Border setResaltarid_tipo_retencionTablaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaretencionBeanSwingJInternalFrame.jTtoolBarTablaRetencion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencionTablaRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencionTablaRetencion() {
		return this.resaltarid_tipo_retencionTablaRetencion;
	}

	public void setResaltarid_tipo_retencionTablaRetencion(Border borderResaltar) {
		this.resaltarid_tipo_retencionTablaRetencion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencionTablaRetencion() {
		return this.mostrarid_tipo_retencionTablaRetencion;
	}

	public void setMostrarid_tipo_retencionTablaRetencion(Boolean mostrarid_tipo_retencionTablaRetencion) {
		this.mostrarid_tipo_retencionTablaRetencion= mostrarid_tipo_retencionTablaRetencion;
	}

	public Boolean getActivarid_tipo_retencionTablaRetencion() {
		return this.activarid_tipo_retencionTablaRetencion;
	}

	public void setActivarid_tipo_retencionTablaRetencion(Boolean activarid_tipo_retencionTablaRetencion) {
		this.activarid_tipo_retencionTablaRetencion= activarid_tipo_retencionTablaRetencion;
	}

	public Boolean getCargarid_tipo_retencionTablaRetencion() {
		return this.cargarid_tipo_retencionTablaRetencion;
	}

	public void setCargarid_tipo_retencionTablaRetencion(Boolean cargarid_tipo_retencionTablaRetencion) {
		this.cargarid_tipo_retencionTablaRetencion= cargarid_tipo_retencionTablaRetencion;
	}

	public Border setResaltarid_cuenta_contable_debitoTablaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaretencionBeanSwingJInternalFrame.jTtoolBarTablaRetencion.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_debitoTablaRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_debitoTablaRetencion() {
		return this.resaltarid_cuenta_contable_debitoTablaRetencion;
	}

	public void setResaltarid_cuenta_contable_debitoTablaRetencion(Border borderResaltar) {
		this.resaltarid_cuenta_contable_debitoTablaRetencion= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_debitoTablaRetencion() {
		return this.mostrarid_cuenta_contable_debitoTablaRetencion;
	}

	public void setMostrarid_cuenta_contable_debitoTablaRetencion(Boolean mostrarid_cuenta_contable_debitoTablaRetencion) {
		this.mostrarid_cuenta_contable_debitoTablaRetencion= mostrarid_cuenta_contable_debitoTablaRetencion;
	}

	public Boolean getActivarid_cuenta_contable_debitoTablaRetencion() {
		return this.activarid_cuenta_contable_debitoTablaRetencion;
	}

	public void setActivarid_cuenta_contable_debitoTablaRetencion(Boolean activarid_cuenta_contable_debitoTablaRetencion) {
		this.activarid_cuenta_contable_debitoTablaRetencion= activarid_cuenta_contable_debitoTablaRetencion;
	}

	public Boolean getCargarid_cuenta_contable_debitoTablaRetencion() {
		return this.cargarid_cuenta_contable_debitoTablaRetencion;
	}

	public void setCargarid_cuenta_contable_debitoTablaRetencion(Boolean cargarid_cuenta_contable_debitoTablaRetencion) {
		this.cargarid_cuenta_contable_debitoTablaRetencion= cargarid_cuenta_contable_debitoTablaRetencion;
	}

	public Border setResaltarid_cuenta_contable_creditoTablaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaretencionBeanSwingJInternalFrame.jTtoolBarTablaRetencion.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_creditoTablaRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_creditoTablaRetencion() {
		return this.resaltarid_cuenta_contable_creditoTablaRetencion;
	}

	public void setResaltarid_cuenta_contable_creditoTablaRetencion(Border borderResaltar) {
		this.resaltarid_cuenta_contable_creditoTablaRetencion= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_creditoTablaRetencion() {
		return this.mostrarid_cuenta_contable_creditoTablaRetencion;
	}

	public void setMostrarid_cuenta_contable_creditoTablaRetencion(Boolean mostrarid_cuenta_contable_creditoTablaRetencion) {
		this.mostrarid_cuenta_contable_creditoTablaRetencion= mostrarid_cuenta_contable_creditoTablaRetencion;
	}

	public Boolean getActivarid_cuenta_contable_creditoTablaRetencion() {
		return this.activarid_cuenta_contable_creditoTablaRetencion;
	}

	public void setActivarid_cuenta_contable_creditoTablaRetencion(Boolean activarid_cuenta_contable_creditoTablaRetencion) {
		this.activarid_cuenta_contable_creditoTablaRetencion= activarid_cuenta_contable_creditoTablaRetencion;
	}

	public Boolean getCargarid_cuenta_contable_creditoTablaRetencion() {
		return this.cargarid_cuenta_contable_creditoTablaRetencion;
	}

	public void setCargarid_cuenta_contable_creditoTablaRetencion(Boolean cargarid_cuenta_contable_creditoTablaRetencion) {
		this.cargarid_cuenta_contable_creditoTablaRetencion= cargarid_cuenta_contable_creditoTablaRetencion;
	}

	public Border setResaltares_debitoTablaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaretencionBeanSwingJInternalFrame.jTtoolBarTablaRetencion.setBorder(borderResaltar);
		
		this.resaltares_debitoTablaRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_debitoTablaRetencion() {
		return this.resaltares_debitoTablaRetencion;
	}

	public void setResaltares_debitoTablaRetencion(Border borderResaltar) {
		this.resaltares_debitoTablaRetencion= borderResaltar;
	}

	public Boolean getMostrares_debitoTablaRetencion() {
		return this.mostrares_debitoTablaRetencion;
	}

	public void setMostrares_debitoTablaRetencion(Boolean mostrares_debitoTablaRetencion) {
		this.mostrares_debitoTablaRetencion= mostrares_debitoTablaRetencion;
	}

	public Boolean getActivares_debitoTablaRetencion() {
		return this.activares_debitoTablaRetencion;
	}

	public void setActivares_debitoTablaRetencion(Boolean activares_debitoTablaRetencion) {
		this.activares_debitoTablaRetencion= activares_debitoTablaRetencion;
	}

	public Border setResaltares_retencion_fuenteTablaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaretencionBeanSwingJInternalFrame.jTtoolBarTablaRetencion.setBorder(borderResaltar);
		
		this.resaltares_retencion_fuenteTablaRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_retencion_fuenteTablaRetencion() {
		return this.resaltares_retencion_fuenteTablaRetencion;
	}

	public void setResaltares_retencion_fuenteTablaRetencion(Border borderResaltar) {
		this.resaltares_retencion_fuenteTablaRetencion= borderResaltar;
	}

	public Boolean getMostrares_retencion_fuenteTablaRetencion() {
		return this.mostrares_retencion_fuenteTablaRetencion;
	}

	public void setMostrares_retencion_fuenteTablaRetencion(Boolean mostrares_retencion_fuenteTablaRetencion) {
		this.mostrares_retencion_fuenteTablaRetencion= mostrares_retencion_fuenteTablaRetencion;
	}

	public Boolean getActivares_retencion_fuenteTablaRetencion() {
		return this.activares_retencion_fuenteTablaRetencion;
	}

	public void setActivares_retencion_fuenteTablaRetencion(Boolean activares_retencion_fuenteTablaRetencion) {
		this.activares_retencion_fuenteTablaRetencion= activares_retencion_fuenteTablaRetencion;
	}

	public Border setResaltarcon_secuencialTablaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaretencionBeanSwingJInternalFrame.jTtoolBarTablaRetencion.setBorder(borderResaltar);
		
		this.resaltarcon_secuencialTablaRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_secuencialTablaRetencion() {
		return this.resaltarcon_secuencialTablaRetencion;
	}

	public void setResaltarcon_secuencialTablaRetencion(Border borderResaltar) {
		this.resaltarcon_secuencialTablaRetencion= borderResaltar;
	}

	public Boolean getMostrarcon_secuencialTablaRetencion() {
		return this.mostrarcon_secuencialTablaRetencion;
	}

	public void setMostrarcon_secuencialTablaRetencion(Boolean mostrarcon_secuencialTablaRetencion) {
		this.mostrarcon_secuencialTablaRetencion= mostrarcon_secuencialTablaRetencion;
	}

	public Boolean getActivarcon_secuencialTablaRetencion() {
		return this.activarcon_secuencialTablaRetencion;
	}

	public void setActivarcon_secuencialTablaRetencion(Boolean activarcon_secuencialTablaRetencion) {
		this.activarcon_secuencialTablaRetencion= activarcon_secuencialTablaRetencion;
	}

	public Border setResaltarcon_sub_total_facturaTablaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaretencionBeanSwingJInternalFrame.jTtoolBarTablaRetencion.setBorder(borderResaltar);
		
		this.resaltarcon_sub_total_facturaTablaRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_sub_total_facturaTablaRetencion() {
		return this.resaltarcon_sub_total_facturaTablaRetencion;
	}

	public void setResaltarcon_sub_total_facturaTablaRetencion(Border borderResaltar) {
		this.resaltarcon_sub_total_facturaTablaRetencion= borderResaltar;
	}

	public Boolean getMostrarcon_sub_total_facturaTablaRetencion() {
		return this.mostrarcon_sub_total_facturaTablaRetencion;
	}

	public void setMostrarcon_sub_total_facturaTablaRetencion(Boolean mostrarcon_sub_total_facturaTablaRetencion) {
		this.mostrarcon_sub_total_facturaTablaRetencion= mostrarcon_sub_total_facturaTablaRetencion;
	}

	public Boolean getActivarcon_sub_total_facturaTablaRetencion() {
		return this.activarcon_sub_total_facturaTablaRetencion;
	}

	public void setActivarcon_sub_total_facturaTablaRetencion(Boolean activarcon_sub_total_facturaTablaRetencion) {
		this.activarcon_sub_total_facturaTablaRetencion= activarcon_sub_total_facturaTablaRetencion;
	}

	public Border setResaltarcon_iva_facturaTablaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaretencionBeanSwingJInternalFrame.jTtoolBarTablaRetencion.setBorder(borderResaltar);
		
		this.resaltarcon_iva_facturaTablaRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_iva_facturaTablaRetencion() {
		return this.resaltarcon_iva_facturaTablaRetencion;
	}

	public void setResaltarcon_iva_facturaTablaRetencion(Border borderResaltar) {
		this.resaltarcon_iva_facturaTablaRetencion= borderResaltar;
	}

	public Boolean getMostrarcon_iva_facturaTablaRetencion() {
		return this.mostrarcon_iva_facturaTablaRetencion;
	}

	public void setMostrarcon_iva_facturaTablaRetencion(Boolean mostrarcon_iva_facturaTablaRetencion) {
		this.mostrarcon_iva_facturaTablaRetencion= mostrarcon_iva_facturaTablaRetencion;
	}

	public Boolean getActivarcon_iva_facturaTablaRetencion() {
		return this.activarcon_iva_facturaTablaRetencion;
	}

	public void setActivarcon_iva_facturaTablaRetencion(Boolean activarcon_iva_facturaTablaRetencion) {
		this.activarcon_iva_facturaTablaRetencion= activarcon_iva_facturaTablaRetencion;
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
		
		
		this.setMostraridTablaRetencion(esInicial);
		this.setMostrarid_empresaTablaRetencion(esInicial);
		this.setMostrarcodigoTablaRetencion(esInicial);
		this.setMostrarnombreTablaRetencion(esInicial);
		this.setMostrarporcentajeTablaRetencion(esInicial);
		this.setMostrarmonto_minimoTablaRetencion(esInicial);
		this.setMostrarid_tipo_retencionTablaRetencion(esInicial);
		this.setMostrarid_cuenta_contable_debitoTablaRetencion(esInicial);
		this.setMostrarid_cuenta_contable_creditoTablaRetencion(esInicial);
		this.setMostrares_debitoTablaRetencion(esInicial);
		this.setMostrares_retencion_fuenteTablaRetencion(esInicial);
		this.setMostrarcon_secuencialTablaRetencion(esInicial);
		this.setMostrarcon_sub_total_facturaTablaRetencion(esInicial);
		this.setMostrarcon_iva_facturaTablaRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TablaRetencionConstantesFunciones.ID)) {
				this.setMostraridTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.MONTOMINIMO)) {
				this.setMostrarmonto_minimoTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.IDTIPORETENCION)) {
				this.setMostrarid_tipo_retencionTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setMostrarid_cuenta_contable_debitoTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setMostrarid_cuenta_contable_creditoTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.ESDEBITO)) {
				this.setMostrares_debitoTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.ESRETENCIONFUENTE)) {
				this.setMostrares_retencion_fuenteTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.CONSECUENCIAL)) {
				this.setMostrarcon_secuencialTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.CONSUBTOTALFACTURA)) {
				this.setMostrarcon_sub_total_facturaTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.CONIVAFACTURA)) {
				this.setMostrarcon_iva_facturaTablaRetencion(esAsigna);
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
		
		
		this.setActivaridTablaRetencion(esInicial);
		this.setActivarid_empresaTablaRetencion(esInicial);
		this.setActivarcodigoTablaRetencion(esInicial);
		this.setActivarnombreTablaRetencion(esInicial);
		this.setActivarporcentajeTablaRetencion(esInicial);
		this.setActivarmonto_minimoTablaRetencion(esInicial);
		this.setActivarid_tipo_retencionTablaRetencion(esInicial);
		this.setActivarid_cuenta_contable_debitoTablaRetencion(esInicial);
		this.setActivarid_cuenta_contable_creditoTablaRetencion(esInicial);
		this.setActivares_debitoTablaRetencion(esInicial);
		this.setActivares_retencion_fuenteTablaRetencion(esInicial);
		this.setActivarcon_secuencialTablaRetencion(esInicial);
		this.setActivarcon_sub_total_facturaTablaRetencion(esInicial);
		this.setActivarcon_iva_facturaTablaRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TablaRetencionConstantesFunciones.ID)) {
				this.setActivaridTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.MONTOMINIMO)) {
				this.setActivarmonto_minimoTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.IDTIPORETENCION)) {
				this.setActivarid_tipo_retencionTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setActivarid_cuenta_contable_debitoTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setActivarid_cuenta_contable_creditoTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.ESDEBITO)) {
				this.setActivares_debitoTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.ESRETENCIONFUENTE)) {
				this.setActivares_retencion_fuenteTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.CONSECUENCIAL)) {
				this.setActivarcon_secuencialTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.CONSUBTOTALFACTURA)) {
				this.setActivarcon_sub_total_facturaTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.CONIVAFACTURA)) {
				this.setActivarcon_iva_facturaTablaRetencion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTablaRetencion(esInicial);
		this.setResaltarid_empresaTablaRetencion(esInicial);
		this.setResaltarcodigoTablaRetencion(esInicial);
		this.setResaltarnombreTablaRetencion(esInicial);
		this.setResaltarporcentajeTablaRetencion(esInicial);
		this.setResaltarmonto_minimoTablaRetencion(esInicial);
		this.setResaltarid_tipo_retencionTablaRetencion(esInicial);
		this.setResaltarid_cuenta_contable_debitoTablaRetencion(esInicial);
		this.setResaltarid_cuenta_contable_creditoTablaRetencion(esInicial);
		this.setResaltares_debitoTablaRetencion(esInicial);
		this.setResaltares_retencion_fuenteTablaRetencion(esInicial);
		this.setResaltarcon_secuencialTablaRetencion(esInicial);
		this.setResaltarcon_sub_total_facturaTablaRetencion(esInicial);
		this.setResaltarcon_iva_facturaTablaRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TablaRetencionConstantesFunciones.ID)) {
				this.setResaltaridTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.MONTOMINIMO)) {
				this.setResaltarmonto_minimoTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.IDTIPORETENCION)) {
				this.setResaltarid_tipo_retencionTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setResaltarid_cuenta_contable_debitoTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setResaltarid_cuenta_contable_creditoTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.ESDEBITO)) {
				this.setResaltares_debitoTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.ESRETENCIONFUENTE)) {
				this.setResaltares_retencion_fuenteTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.CONSECUENCIAL)) {
				this.setResaltarcon_secuencialTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.CONSUBTOTALFACTURA)) {
				this.setResaltarcon_sub_total_facturaTablaRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaRetencionConstantesFunciones.CONIVAFACTURA)) {
				this.setResaltarcon_iva_facturaTablaRetencion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoTablaRetencion=true;

	public Boolean getMostrarBusquedaPorCodigoTablaRetencion() {
		return this.mostrarBusquedaPorCodigoTablaRetencion;
	}

	public void setMostrarBusquedaPorCodigoTablaRetencion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTablaRetencion= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTablaRetencion=true;

	public Boolean getMostrarBusquedaPorNombreTablaRetencion() {
		return this.mostrarBusquedaPorNombreTablaRetencion;
	}

	public void setMostrarBusquedaPorNombreTablaRetencion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTablaRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCreditoTablaRetencion=true;

	public Boolean getMostrarFK_IdCuentaContableCreditoTablaRetencion() {
		return this.mostrarFK_IdCuentaContableCreditoTablaRetencion;
	}

	public void setMostrarFK_IdCuentaContableCreditoTablaRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCreditoTablaRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableDebitoTablaRetencion=true;

	public Boolean getMostrarFK_IdCuentaContableDebitoTablaRetencion() {
		return this.mostrarFK_IdCuentaContableDebitoTablaRetencion;
	}

	public void setMostrarFK_IdCuentaContableDebitoTablaRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableDebitoTablaRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTablaRetencion=true;

	public Boolean getMostrarFK_IdEmpresaTablaRetencion() {
		return this.mostrarFK_IdEmpresaTablaRetencion;
	}

	public void setMostrarFK_IdEmpresaTablaRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTablaRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionTablaRetencion=true;

	public Boolean getMostrarFK_IdTipoRetencionTablaRetencion() {
		return this.mostrarFK_IdTipoRetencionTablaRetencion;
	}

	public void setMostrarFK_IdTipoRetencionTablaRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionTablaRetencion= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTablaRetencion=true;

	public Boolean getActivarBusquedaPorCodigoTablaRetencion() {
		return this.activarBusquedaPorCodigoTablaRetencion;
	}

	public void setActivarBusquedaPorCodigoTablaRetencion(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTablaRetencion= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTablaRetencion=true;

	public Boolean getActivarBusquedaPorNombreTablaRetencion() {
		return this.activarBusquedaPorNombreTablaRetencion;
	}

	public void setActivarBusquedaPorNombreTablaRetencion(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTablaRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCreditoTablaRetencion=true;

	public Boolean getActivarFK_IdCuentaContableCreditoTablaRetencion() {
		return this.activarFK_IdCuentaContableCreditoTablaRetencion;
	}

	public void setActivarFK_IdCuentaContableCreditoTablaRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCreditoTablaRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableDebitoTablaRetencion=true;

	public Boolean getActivarFK_IdCuentaContableDebitoTablaRetencion() {
		return this.activarFK_IdCuentaContableDebitoTablaRetencion;
	}

	public void setActivarFK_IdCuentaContableDebitoTablaRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableDebitoTablaRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTablaRetencion=true;

	public Boolean getActivarFK_IdEmpresaTablaRetencion() {
		return this.activarFK_IdEmpresaTablaRetencion;
	}

	public void setActivarFK_IdEmpresaTablaRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTablaRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionTablaRetencion=true;

	public Boolean getActivarFK_IdTipoRetencionTablaRetencion() {
		return this.activarFK_IdTipoRetencionTablaRetencion;
	}

	public void setActivarFK_IdTipoRetencionTablaRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionTablaRetencion= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTablaRetencion=null;

	public Border getResaltarBusquedaPorCodigoTablaRetencion() {
		return this.resaltarBusquedaPorCodigoTablaRetencion;
	}

	public void setResaltarBusquedaPorCodigoTablaRetencion(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTablaRetencion= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTablaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTablaRetencion= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTablaRetencion=null;

	public Border getResaltarBusquedaPorNombreTablaRetencion() {
		return this.resaltarBusquedaPorNombreTablaRetencion;
	}

	public void setResaltarBusquedaPorNombreTablaRetencion(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTablaRetencion= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTablaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTablaRetencion= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCreditoTablaRetencion=null;

	public Border getResaltarFK_IdCuentaContableCreditoTablaRetencion() {
		return this.resaltarFK_IdCuentaContableCreditoTablaRetencion;
	}

	public void setResaltarFK_IdCuentaContableCreditoTablaRetencion(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCreditoTablaRetencion= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCreditoTablaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCreditoTablaRetencion= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableDebitoTablaRetencion=null;

	public Border getResaltarFK_IdCuentaContableDebitoTablaRetencion() {
		return this.resaltarFK_IdCuentaContableDebitoTablaRetencion;
	}

	public void setResaltarFK_IdCuentaContableDebitoTablaRetencion(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableDebitoTablaRetencion= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableDebitoTablaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableDebitoTablaRetencion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTablaRetencion=null;

	public Border getResaltarFK_IdEmpresaTablaRetencion() {
		return this.resaltarFK_IdEmpresaTablaRetencion;
	}

	public void setResaltarFK_IdEmpresaTablaRetencion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTablaRetencion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTablaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTablaRetencion= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionTablaRetencion=null;

	public Border getResaltarFK_IdTipoRetencionTablaRetencion() {
		return this.resaltarFK_IdTipoRetencionTablaRetencion;
	}

	public void setResaltarFK_IdTipoRetencionTablaRetencion(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionTablaRetencion= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionTablaRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TablaRetencionBeanSwingJInternalFrame tablaretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionTablaRetencion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}