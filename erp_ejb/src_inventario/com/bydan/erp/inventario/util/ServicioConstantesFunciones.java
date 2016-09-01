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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.ServicioConstantesFunciones;
import com.bydan.erp.inventario.util.ServicioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ServicioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ServicioConstantesFunciones extends ServicioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Servicio";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Servicio"+ServicioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ServicioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ServicioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ServicioConstantesFunciones.SCHEMA+"_"+ServicioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ServicioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ServicioConstantesFunciones.SCHEMA+"_"+ServicioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ServicioConstantesFunciones.SCHEMA+"_"+ServicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ServicioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ServicioConstantesFunciones.SCHEMA+"_"+ServicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ServicioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ServicioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ServicioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ServicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ServicioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ServicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ServicioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ServicioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ServicioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ServicioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Servicioes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Servicio";
	public static final String SCLASSWEBTITULO_LOWER="Servicio";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Servicio";
	public static final String OBJECTNAME="servicio";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="servicio";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select servicio from "+ServicioConstantesFunciones.SPERSISTENCENAME+" servicio";
	public static String QUERYSELECTNATIVE="select "+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".version_row,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id_empresa,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id_tipo_servicio,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".codigo,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".nombre,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".iva,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".ice,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".es_bien,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id_estado_servicio,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".descripcion,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id_cuenta_contable_gasto,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id_cuenta_contable_fiscal,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id_cuenta_contable_fiscal2,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id_cuenta_contable_retencion,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id_cuenta_contable_retencion2,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id_cuenta_contable_iva,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id_cuenta_contable_iva2,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id_cuenta_contable_credito from "+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME;//+" as "+ServicioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ServicioConstantesFuncionesAdditional servicioConstantesFuncionesAdditional=null;
	
	public ServicioConstantesFuncionesAdditional getServicioConstantesFuncionesAdditional() {
		return this.servicioConstantesFuncionesAdditional;
	}
	
	public void setServicioConstantesFuncionesAdditional(ServicioConstantesFuncionesAdditional servicioConstantesFuncionesAdditional) {
		try {
			this.servicioConstantesFuncionesAdditional=servicioConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTIPOSERVICIO= "id_tipo_servicio";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String IVA= "iva";
    public static final String ICE= "ice";
    public static final String ESBIEN= "es_bien";
    public static final String IDESTADOSERVICIO= "id_estado_servicio";
    public static final String DESCRIPCION= "descripcion";
    public static final String IDCUENTACONTABLEGASTO= "id_cuenta_contable_gasto";
    public static final String IDCUENTACONTABLEFISCAL= "id_cuenta_contable_fiscal";
    public static final String IDCUENTACONTABLEFISCAL2= "id_cuenta_contable_fiscal2";
    public static final String IDCUENTACONTABLERETENCION= "id_cuenta_contable_retencion";
    public static final String IDCUENTACONTABLERETENCION2= "id_cuenta_contable_retencion2";
    public static final String IDCUENTACONTABLEIVA= "id_cuenta_contable_iva";
    public static final String IDCUENTACONTABLEIVA2= "id_cuenta_contable_iva2";
    public static final String IDCUENTACONTABLECREDITO= "id_cuenta_contable_credito";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTIPOSERVICIO= "Tipo Servicio";
		public static final String LABEL_IDTIPOSERVICIO_LOWER= "Tipo Servicio";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_ESBIEN= "Es Bien";
		public static final String LABEL_ESBIEN_LOWER= "Es Bien";
    	public static final String LABEL_IDESTADOSERVICIO= "Estado Servicio";
		public static final String LABEL_IDESTADOSERVICIO_LOWER= "Estado Servicio";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_IDCUENTACONTABLEGASTO= "Cuenta C. Gasto";
		public static final String LABEL_IDCUENTACONTABLEGASTO_LOWER= "Cuenta Contable Gasto";
    	public static final String LABEL_IDCUENTACONTABLEFISCAL= "Cuenta C. Fiscal";
		public static final String LABEL_IDCUENTACONTABLEFISCAL_LOWER= "Cuenta Contable Fiscal";
    	public static final String LABEL_IDCUENTACONTABLEFISCAL2= "Cuenta C. Fiscal 2";
		public static final String LABEL_IDCUENTACONTABLEFISCAL2_LOWER= "Cuenta Contable Fiscal2";
    	public static final String LABEL_IDCUENTACONTABLERETENCION= "Cuenta C. Retencion";
		public static final String LABEL_IDCUENTACONTABLERETENCION_LOWER= "Cuenta Contable Retencion";
    	public static final String LABEL_IDCUENTACONTABLERETENCION2= "Cuenta C. Retencion 2";
		public static final String LABEL_IDCUENTACONTABLERETENCION2_LOWER= "Cuenta Contable Retencion2";
    	public static final String LABEL_IDCUENTACONTABLEIVA= "Cuenta C. Iva";
		public static final String LABEL_IDCUENTACONTABLEIVA_LOWER= "Cuenta Contable Iva";
    	public static final String LABEL_IDCUENTACONTABLEIVA2= "Cuenta C. Iva 2";
		public static final String LABEL_IDCUENTACONTABLEIVA2_LOWER= "Cuenta Contable Iva2";
    	public static final String LABEL_IDCUENTACONTABLECREDITO= "Cuenta C. Credito";
		public static final String LABEL_IDCUENTACONTABLECREDITO_LOWER= "Cuenta Contable Credito";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
	
	public static String getServicioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ServicioConstantesFunciones.IDEMPRESA)) {sLabelColumna=ServicioConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ServicioConstantesFunciones.IDTIPOSERVICIO)) {sLabelColumna=ServicioConstantesFunciones.LABEL_IDTIPOSERVICIO;}
		if(sNombreColumna.equals(ServicioConstantesFunciones.CODIGO)) {sLabelColumna=ServicioConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ServicioConstantesFunciones.NOMBRE)) {sLabelColumna=ServicioConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ServicioConstantesFunciones.IVA)) {sLabelColumna=ServicioConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(ServicioConstantesFunciones.ICE)) {sLabelColumna=ServicioConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(ServicioConstantesFunciones.ESBIEN)) {sLabelColumna=ServicioConstantesFunciones.LABEL_ESBIEN;}
		if(sNombreColumna.equals(ServicioConstantesFunciones.IDESTADOSERVICIO)) {sLabelColumna=ServicioConstantesFunciones.LABEL_IDESTADOSERVICIO;}
		if(sNombreColumna.equals(ServicioConstantesFunciones.DESCRIPCION)) {sLabelColumna=ServicioConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(ServicioConstantesFunciones.IDCUENTACONTABLEGASTO)) {sLabelColumna=ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO;}
		if(sNombreColumna.equals(ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL)) {sLabelColumna=ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEFISCAL;}
		if(sNombreColumna.equals(ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL2)) {sLabelColumna=ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEFISCAL2;}
		if(sNombreColumna.equals(ServicioConstantesFunciones.IDCUENTACONTABLERETENCION)) {sLabelColumna=ServicioConstantesFunciones.LABEL_IDCUENTACONTABLERETENCION;}
		if(sNombreColumna.equals(ServicioConstantesFunciones.IDCUENTACONTABLERETENCION2)) {sLabelColumna=ServicioConstantesFunciones.LABEL_IDCUENTACONTABLERETENCION2;}
		if(sNombreColumna.equals(ServicioConstantesFunciones.IDCUENTACONTABLEIVA)) {sLabelColumna=ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEIVA;}
		if(sNombreColumna.equals(ServicioConstantesFunciones.IDCUENTACONTABLEIVA2)) {sLabelColumna=ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEIVA2;}
		if(sNombreColumna.equals(ServicioConstantesFunciones.IDCUENTACONTABLECREDITO)) {sLabelColumna=ServicioConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
		
	public static String getes_bienDescripcion(Servicio servicio) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!servicio.getes_bien()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_bienHtmlDescripcion(Servicio servicio) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(servicio.getId(),servicio.getes_bien());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
	
	public static String getServicioDescripcion(Servicio servicio) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(servicio !=null/* && servicio.getId()!=0*/) {
			sDescripcion=servicio.getcodigo();//servicioservicio.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getServicioDescripcionDetallado(Servicio servicio) {
		String sDescripcion="";
			
		sDescripcion+=ServicioConstantesFunciones.ID+"=";
		sDescripcion+=servicio.getId().toString()+",";
		sDescripcion+=ServicioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=servicio.getVersionRow().toString()+",";
		sDescripcion+=ServicioConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=servicio.getid_empresa().toString()+",";
		sDescripcion+=ServicioConstantesFunciones.IDTIPOSERVICIO+"=";
		sDescripcion+=servicio.getid_tipo_servicio().toString()+",";
		sDescripcion+=ServicioConstantesFunciones.CODIGO+"=";
		sDescripcion+=servicio.getcodigo()+",";
		sDescripcion+=ServicioConstantesFunciones.NOMBRE+"=";
		sDescripcion+=servicio.getnombre()+",";
		sDescripcion+=ServicioConstantesFunciones.IVA+"=";
		sDescripcion+=servicio.getiva().toString()+",";
		sDescripcion+=ServicioConstantesFunciones.ICE+"=";
		sDescripcion+=servicio.getice().toString()+",";
		sDescripcion+=ServicioConstantesFunciones.ESBIEN+"=";
		sDescripcion+=servicio.getes_bien().toString()+",";
		sDescripcion+=ServicioConstantesFunciones.IDESTADOSERVICIO+"=";
		sDescripcion+=servicio.getid_estado_servicio().toString()+",";
		sDescripcion+=ServicioConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=servicio.getdescripcion()+",";
		sDescripcion+=ServicioConstantesFunciones.IDCUENTACONTABLEGASTO+"=";
		sDescripcion+=servicio.getid_cuenta_contable_gasto().toString()+",";
		sDescripcion+=ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL+"=";
		sDescripcion+=servicio.getid_cuenta_contable_fiscal().toString()+",";
		sDescripcion+=ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL2+"=";
		sDescripcion+=servicio.getid_cuenta_contable_fiscal2().toString()+",";
		sDescripcion+=ServicioConstantesFunciones.IDCUENTACONTABLERETENCION+"=";
		sDescripcion+=servicio.getid_cuenta_contable_retencion().toString()+",";
		sDescripcion+=ServicioConstantesFunciones.IDCUENTACONTABLERETENCION2+"=";
		sDescripcion+=servicio.getid_cuenta_contable_retencion2().toString()+",";
		sDescripcion+=ServicioConstantesFunciones.IDCUENTACONTABLEIVA+"=";
		sDescripcion+=servicio.getid_cuenta_contable_iva().toString()+",";
		sDescripcion+=ServicioConstantesFunciones.IDCUENTACONTABLEIVA2+"=";
		sDescripcion+=servicio.getid_cuenta_contable_iva2().toString()+",";
		sDescripcion+=ServicioConstantesFunciones.IDCUENTACONTABLECREDITO+"=";
		sDescripcion+=servicio.getid_cuenta_contable_credito().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setServicioDescripcion(Servicio servicio,String sValor) throws Exception {			
		if(servicio !=null) {
			servicio.setcodigo(sValor);;//servicioservicio.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoServicioDescripcion(TipoServicio tiposervicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiposervicio!=null/*&&tiposervicio.getId()>0*/) {
			sDescripcion=TipoServicioConstantesFunciones.getTipoServicioDescripcion(tiposervicio);
		}

		return sDescripcion;
	}

	public static String getEstadoServicioDescripcion(EstadoServicio estadoservicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadoservicio!=null/*&&estadoservicio.getId()>0*/) {
			sDescripcion=EstadoServicioConstantesFunciones.getEstadoServicioDescripcion(estadoservicio);
		}

		return sDescripcion;
	}

	public static String getCuentaContableGastoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableFiscalDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableFiscal2Descripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableRetencionDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableRetencion2Descripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableIvaDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableIva2Descripcion(CuentaContable cuentacontable) {
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
			sNombreIndice="Tipo=  Por Cuenta C. Credito";
		} else if(sNombreIndice.equals("FK_IdCuentaContableFiscal")) {
			sNombreIndice="Tipo=  Por Cuenta C. Fiscal";
		} else if(sNombreIndice.equals("FK_IdCuentaContableFiscal2")) {
			sNombreIndice="Tipo=  Por Cuenta C. Fiscal 2";
		} else if(sNombreIndice.equals("FK_IdCuentaContableGasto")) {
			sNombreIndice="Tipo=  Por Cuenta C. Gasto";
		} else if(sNombreIndice.equals("FK_IdCuentaContableIva")) {
			sNombreIndice="Tipo=  Por Cuenta C. Iva";
		} else if(sNombreIndice.equals("FK_IdCuentaContableIva2")) {
			sNombreIndice="Tipo=  Por Cuenta C. Iva 2";
		} else if(sNombreIndice.equals("FK_IdCuentaContableRetencion")) {
			sNombreIndice="Tipo=  Por Cuenta C. Retencion";
		} else if(sNombreIndice.equals("FK_IdCuentaContableRetencion2")) {
			sNombreIndice="Tipo=  Por Cuenta C. Retencion 2";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoServicio")) {
			sNombreIndice="Tipo=  Por Estado Servicio";
		} else if(sNombreIndice.equals("FK_IdTipoServicio")) {
			sNombreIndice="Tipo=  Por Tipo Servicio";
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
		if(id_cuenta_contable_credito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Credito="+id_cuenta_contable_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableFiscal(Long id_cuenta_contable_fiscal) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_fiscal!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Fiscal="+id_cuenta_contable_fiscal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableFiscal2(Long id_cuenta_contable_fiscal2) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_fiscal2!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Fiscal 2="+id_cuenta_contable_fiscal2.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableGasto(Long id_cuenta_contable_gasto) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_gasto!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Gasto="+id_cuenta_contable_gasto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableIva(Long id_cuenta_contable_iva) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_iva!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Iva="+id_cuenta_contable_iva.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableIva2(Long id_cuenta_contable_iva2) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_iva2!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Iva 2="+id_cuenta_contable_iva2.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableRetencion(Long id_cuenta_contable_retencion) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_retencion!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Retencion="+id_cuenta_contable_retencion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableRetencion2(Long id_cuenta_contable_retencion2) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_retencion2!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Retencion 2="+id_cuenta_contable_retencion2.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoServicio(Long id_estado_servicio) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_servicio!=null) {sDetalleIndice+=" Codigo Unico De Estado Servicio="+id_estado_servicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoServicio(Long id_tipo_servicio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_servicio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Servicio="+id_tipo_servicio.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosServicio(Servicio servicio,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		servicio.setcodigo(servicio.getcodigo().trim());
		servicio.setnombre(servicio.getnombre().trim());
		servicio.setdescripcion(servicio.getdescripcion().trim());
	}
	
	public static void quitarEspaciosServicios(List<Servicio> servicios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Servicio servicio: servicios) {
			servicio.setcodigo(servicio.getcodigo().trim());
			servicio.setnombre(servicio.getnombre().trim());
			servicio.setdescripcion(servicio.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresServicio(Servicio servicio,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && servicio.getConCambioAuxiliar()) {
			servicio.setIsDeleted(servicio.getIsDeletedAuxiliar());	
			servicio.setIsNew(servicio.getIsNewAuxiliar());	
			servicio.setIsChanged(servicio.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			servicio.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			servicio.setIsDeletedAuxiliar(false);	
			servicio.setIsNewAuxiliar(false);	
			servicio.setIsChangedAuxiliar(false);
			
			servicio.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresServicios(List<Servicio> servicios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Servicio servicio : servicios) {
			if(conAsignarBase && servicio.getConCambioAuxiliar()) {
				servicio.setIsDeleted(servicio.getIsDeletedAuxiliar());	
				servicio.setIsNew(servicio.getIsNewAuxiliar());	
				servicio.setIsChanged(servicio.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				servicio.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				servicio.setIsDeletedAuxiliar(false);	
				servicio.setIsNewAuxiliar(false);	
				servicio.setIsChangedAuxiliar(false);
				
				servicio.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresServicio(Servicio servicio,Boolean conEnteros) throws Exception  {
		servicio.setiva(0.0);
		servicio.setice(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresServicios(List<Servicio> servicios,Boolean conEnteros) throws Exception  {
		
		for(Servicio servicio: servicios) {
			servicio.setiva(0.0);
			servicio.setice(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaServicio(List<Servicio> servicios,Servicio servicioAux) throws Exception  {
		ServicioConstantesFunciones.InicializarValoresServicio(servicioAux,true);
		
		for(Servicio servicio: servicios) {
			if(servicio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			servicioAux.setiva(servicioAux.getiva()+servicio.getiva());			
			servicioAux.setice(servicioAux.getice()+servicio.getice());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesServicio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ServicioConstantesFunciones.getArrayColumnasGlobalesServicio(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesServicio(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ServicioConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ServicioConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoServicio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Servicio> servicios,Servicio servicio,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Servicio servicioAux: servicios) {
			if(servicioAux!=null && servicio!=null) {
				if((servicioAux.getId()==null && servicio.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(servicioAux.getId()!=null && servicio.getId()!=null){
					if(servicioAux.getId().equals(servicio.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaServicio(List<Servicio> servicios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double ivaTotal=0.0;
		Double iceTotal=0.0;
	
		for(Servicio servicio: servicios) {			
			if(servicio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ivaTotal+=servicio.getiva();
			iceTotal+=servicio.getice();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ServicioConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(ServicioConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ServicioConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(ServicioConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaServicio() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ServicioConstantesFunciones.LABEL_ID, ServicioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioConstantesFunciones.LABEL_VERSIONROW, ServicioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioConstantesFunciones.LABEL_IDEMPRESA, ServicioConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioConstantesFunciones.LABEL_IDTIPOSERVICIO, ServicioConstantesFunciones.IDTIPOSERVICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioConstantesFunciones.LABEL_CODIGO, ServicioConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioConstantesFunciones.LABEL_NOMBRE, ServicioConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioConstantesFunciones.LABEL_IVA, ServicioConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioConstantesFunciones.LABEL_ICE, ServicioConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioConstantesFunciones.LABEL_ESBIEN, ServicioConstantesFunciones.ESBIEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioConstantesFunciones.LABEL_IDESTADOSERVICIO, ServicioConstantesFunciones.IDESTADOSERVICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioConstantesFunciones.LABEL_DESCRIPCION, ServicioConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO, ServicioConstantesFunciones.IDCUENTACONTABLEGASTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEFISCAL, ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEFISCAL2, ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioConstantesFunciones.LABEL_IDCUENTACONTABLERETENCION, ServicioConstantesFunciones.IDCUENTACONTABLERETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioConstantesFunciones.LABEL_IDCUENTACONTABLERETENCION2, ServicioConstantesFunciones.IDCUENTACONTABLERETENCION2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEIVA, ServicioConstantesFunciones.IDCUENTACONTABLEIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEIVA2, ServicioConstantesFunciones.IDCUENTACONTABLEIVA2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO, ServicioConstantesFunciones.IDCUENTACONTABLECREDITO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasServicio() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ServicioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioConstantesFunciones.IDTIPOSERVICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioConstantesFunciones.ESBIEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioConstantesFunciones.IDESTADOSERVICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioConstantesFunciones.IDCUENTACONTABLEGASTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioConstantesFunciones.IDCUENTACONTABLERETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioConstantesFunciones.IDCUENTACONTABLERETENCION2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioConstantesFunciones.IDCUENTACONTABLEIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioConstantesFunciones.IDCUENTACONTABLEIVA2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioConstantesFunciones.IDCUENTACONTABLECREDITO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarServicio() throws Exception  {
		return ServicioConstantesFunciones.getTiposSeleccionarServicio(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarServicio(Boolean conFk) throws Exception  {
		return ServicioConstantesFunciones.getTiposSeleccionarServicio(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarServicio(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ServicioConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioConstantesFunciones.LABEL_IDTIPOSERVICIO);
			reporte.setsDescripcion(ServicioConstantesFunciones.LABEL_IDTIPOSERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ServicioConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ServicioConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(ServicioConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(ServicioConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioConstantesFunciones.LABEL_ESBIEN);
			reporte.setsDescripcion(ServicioConstantesFunciones.LABEL_ESBIEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioConstantesFunciones.LABEL_IDESTADOSERVICIO);
			reporte.setsDescripcion(ServicioConstantesFunciones.LABEL_IDESTADOSERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ServicioConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO);
			reporte.setsDescripcion(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEFISCAL);
			reporte.setsDescripcion(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEFISCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEFISCAL2);
			reporte.setsDescripcion(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEFISCAL2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLERETENCION);
			reporte.setsDescripcion(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLERETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLERETENCION2);
			reporte.setsDescripcion(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLERETENCION2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEIVA);
			reporte.setsDescripcion(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEIVA2);
			reporte.setsDescripcion(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEIVA2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
			reporte.setsDescripcion(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesServicio(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesServicio(Servicio servicioAux) throws Exception {
		
			servicioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(servicioAux.getEmpresa()));
			servicioAux.settiposervicio_descripcion(TipoServicioConstantesFunciones.getTipoServicioDescripcion(servicioAux.getTipoServicio()));
			servicioAux.setestadoservicio_descripcion(EstadoServicioConstantesFunciones.getEstadoServicioDescripcion(servicioAux.getEstadoServicio()));
			servicioAux.setcuentacontablegasto_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(servicioAux.getCuentaContableGasto()));
			servicioAux.setcuentacontablefiscal_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(servicioAux.getCuentaContableFiscal()));
			servicioAux.setcuentacontablefiscal2_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(servicioAux.getCuentaContableFiscal2()));
			servicioAux.setcuentacontableretencion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(servicioAux.getCuentaContableRetencion()));
			servicioAux.setcuentacontableretencion2_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(servicioAux.getCuentaContableRetencion2()));
			servicioAux.setcuentacontableiva_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(servicioAux.getCuentaContableIva()));
			servicioAux.setcuentacontableiva2_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(servicioAux.getCuentaContableIva2()));
			servicioAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(servicioAux.getCuentaContableCredito()));		
	}
	
	public static void refrescarForeignKeysDescripcionesServicio(List<Servicio> serviciosTemp) throws Exception {
		for(Servicio servicioAux:serviciosTemp) {
			
			servicioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(servicioAux.getEmpresa()));
			servicioAux.settiposervicio_descripcion(TipoServicioConstantesFunciones.getTipoServicioDescripcion(servicioAux.getTipoServicio()));
			servicioAux.setestadoservicio_descripcion(EstadoServicioConstantesFunciones.getEstadoServicioDescripcion(servicioAux.getEstadoServicio()));
			servicioAux.setcuentacontablegasto_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(servicioAux.getCuentaContableGasto()));
			servicioAux.setcuentacontablefiscal_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(servicioAux.getCuentaContableFiscal()));
			servicioAux.setcuentacontablefiscal2_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(servicioAux.getCuentaContableFiscal2()));
			servicioAux.setcuentacontableretencion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(servicioAux.getCuentaContableRetencion()));
			servicioAux.setcuentacontableretencion2_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(servicioAux.getCuentaContableRetencion2()));
			servicioAux.setcuentacontableiva_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(servicioAux.getCuentaContableIva()));
			servicioAux.setcuentacontableiva2_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(servicioAux.getCuentaContableIva2()));
			servicioAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(servicioAux.getCuentaContableCredito()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfServicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoServicio.class));
				classes.add(new Classe(EstadoServicio.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoServicio.class)) {
						classes.add(new Classe(TipoServicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoServicio.class)) {
						classes.add(new Classe(EstadoServicio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfServicio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoServicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoServicio.class)); continue;
					}

					if(EstadoServicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoServicio.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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

					if(TipoServicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoServicio.class)); continue;
					}

					if(EstadoServicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoServicio.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfServicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ServicioConstantesFunciones.getClassesRelationshipsOfServicio(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfServicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ParametroGenerico.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroGenerico.class)) {
						classes.add(new Classe(ParametroGenerico.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfServicio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ServicioConstantesFunciones.getClassesRelationshipsFromStringsOfServicio(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfServicio(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroGenerico.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroGenerico.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroGenerico.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroGenerico.class)); continue;
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
	public static void actualizarLista(Servicio servicio,List<Servicio> servicios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Servicio servicioEncontrado=null;
			
			for(Servicio servicioLocal:servicios) {
				if(servicioLocal.getId().equals(servicio.getId())) {
					servicioEncontrado=servicioLocal;
					
					servicioLocal.setIsChanged(servicio.getIsChanged());
					servicioLocal.setIsNew(servicio.getIsNew());
					servicioLocal.setIsDeleted(servicio.getIsDeleted());
					
					servicioLocal.setGeneralEntityOriginal(servicio.getGeneralEntityOriginal());
					
					servicioLocal.setId(servicio.getId());	
					servicioLocal.setVersionRow(servicio.getVersionRow());	
					servicioLocal.setid_empresa(servicio.getid_empresa());	
					servicioLocal.setid_tipo_servicio(servicio.getid_tipo_servicio());	
					servicioLocal.setcodigo(servicio.getcodigo());	
					servicioLocal.setnombre(servicio.getnombre());	
					servicioLocal.setiva(servicio.getiva());	
					servicioLocal.setice(servicio.getice());	
					servicioLocal.setes_bien(servicio.getes_bien());	
					servicioLocal.setid_estado_servicio(servicio.getid_estado_servicio());	
					servicioLocal.setdescripcion(servicio.getdescripcion());	
					servicioLocal.setid_cuenta_contable_gasto(servicio.getid_cuenta_contable_gasto());	
					servicioLocal.setid_cuenta_contable_fiscal(servicio.getid_cuenta_contable_fiscal());	
					servicioLocal.setid_cuenta_contable_fiscal2(servicio.getid_cuenta_contable_fiscal2());	
					servicioLocal.setid_cuenta_contable_retencion(servicio.getid_cuenta_contable_retencion());	
					servicioLocal.setid_cuenta_contable_retencion2(servicio.getid_cuenta_contable_retencion2());	
					servicioLocal.setid_cuenta_contable_iva(servicio.getid_cuenta_contable_iva());	
					servicioLocal.setid_cuenta_contable_iva2(servicio.getid_cuenta_contable_iva2());	
					servicioLocal.setid_cuenta_contable_credito(servicio.getid_cuenta_contable_credito());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!servicio.getIsDeleted()) {
				if(!existe) {
					servicios.add(servicio);
				}
			} else {
				if(servicioEncontrado!=null && permiteQuitar)  {
					servicios.remove(servicioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Servicio servicio,List<Servicio> servicios) throws Exception {
		try	{			
			for(Servicio servicioLocal:servicios) {
				if(servicioLocal.getId().equals(servicio.getId())) {
					servicioLocal.setIsSelected(servicio.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesServicio(List<Servicio> serviciosAux) throws Exception {
		//this.serviciosAux=serviciosAux;
		
		for(Servicio servicioAux:serviciosAux) {
			if(servicioAux.getIsChanged()) {
				servicioAux.setIsChanged(false);
			}		
			
			if(servicioAux.getIsNew()) {
				servicioAux.setIsNew(false);
			}	
			
			if(servicioAux.getIsDeleted()) {
				servicioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesServicio(Servicio servicioAux) throws Exception {
		//this.servicioAux=servicioAux;
		
			if(servicioAux.getIsChanged()) {
				servicioAux.setIsChanged(false);
			}		
			
			if(servicioAux.getIsNew()) {
				servicioAux.setIsNew(false);
			}	
			
			if(servicioAux.getIsDeleted()) {
				servicioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Servicio servicioAsignar,Servicio servicio) throws Exception {
		servicioAsignar.setId(servicio.getId());	
		servicioAsignar.setVersionRow(servicio.getVersionRow());	
		servicioAsignar.setid_empresa(servicio.getid_empresa());
		servicioAsignar.setempresa_descripcion(servicio.getempresa_descripcion());	
		servicioAsignar.setid_tipo_servicio(servicio.getid_tipo_servicio());
		servicioAsignar.settiposervicio_descripcion(servicio.gettiposervicio_descripcion());	
		servicioAsignar.setcodigo(servicio.getcodigo());	
		servicioAsignar.setnombre(servicio.getnombre());	
		servicioAsignar.setiva(servicio.getiva());	
		servicioAsignar.setice(servicio.getice());	
		servicioAsignar.setes_bien(servicio.getes_bien());	
		servicioAsignar.setid_estado_servicio(servicio.getid_estado_servicio());
		servicioAsignar.setestadoservicio_descripcion(servicio.getestadoservicio_descripcion());	
		servicioAsignar.setdescripcion(servicio.getdescripcion());	
		servicioAsignar.setid_cuenta_contable_gasto(servicio.getid_cuenta_contable_gasto());
		servicioAsignar.setcuentacontablegasto_descripcion(servicio.getcuentacontablegasto_descripcion());	
		servicioAsignar.setid_cuenta_contable_fiscal(servicio.getid_cuenta_contable_fiscal());
		servicioAsignar.setcuentacontablefiscal_descripcion(servicio.getcuentacontablefiscal_descripcion());	
		servicioAsignar.setid_cuenta_contable_fiscal2(servicio.getid_cuenta_contable_fiscal2());
		servicioAsignar.setcuentacontablefiscal2_descripcion(servicio.getcuentacontablefiscal2_descripcion());	
		servicioAsignar.setid_cuenta_contable_retencion(servicio.getid_cuenta_contable_retencion());
		servicioAsignar.setcuentacontableretencion_descripcion(servicio.getcuentacontableretencion_descripcion());	
		servicioAsignar.setid_cuenta_contable_retencion2(servicio.getid_cuenta_contable_retencion2());
		servicioAsignar.setcuentacontableretencion2_descripcion(servicio.getcuentacontableretencion2_descripcion());	
		servicioAsignar.setid_cuenta_contable_iva(servicio.getid_cuenta_contable_iva());
		servicioAsignar.setcuentacontableiva_descripcion(servicio.getcuentacontableiva_descripcion());	
		servicioAsignar.setid_cuenta_contable_iva2(servicio.getid_cuenta_contable_iva2());
		servicioAsignar.setcuentacontableiva2_descripcion(servicio.getcuentacontableiva2_descripcion());	
		servicioAsignar.setid_cuenta_contable_credito(servicio.getid_cuenta_contable_credito());
		servicioAsignar.setcuentacontablecredito_descripcion(servicio.getcuentacontablecredito_descripcion());	
	}
	
	public static void inicializarServicio(Servicio servicio) throws Exception {
		try {
				servicio.setId(0L);	
					
				servicio.setid_empresa(-1L);	
				servicio.setid_tipo_servicio(-1L);	
				servicio.setcodigo("");	
				servicio.setnombre("");	
				servicio.setiva(0.0);	
				servicio.setice(0.0);	
				servicio.setes_bien(false);	
				servicio.setid_estado_servicio(-1L);	
				servicio.setdescripcion("");	
				servicio.setid_cuenta_contable_gasto(-1L);	
				servicio.setid_cuenta_contable_fiscal(-1L);	
				servicio.setid_cuenta_contable_fiscal2(null);	
				servicio.setid_cuenta_contable_retencion(-1L);	
				servicio.setid_cuenta_contable_retencion2(null);	
				servicio.setid_cuenta_contable_iva(-1L);	
				servicio.setid_cuenta_contable_iva2(null);	
				servicio.setid_cuenta_contable_credito(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderServicio(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioConstantesFunciones.LABEL_IDTIPOSERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioConstantesFunciones.LABEL_ESBIEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioConstantesFunciones.LABEL_IDESTADOSERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEFISCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEFISCAL2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLERETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLERETENCION2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLEIVA2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataServicio(String sTipo,Row row,Workbook workbook,Servicio servicio,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(servicio.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(servicio.gettiposervicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(servicio.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(servicio.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(servicio.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(servicio.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(servicio.getes_bien()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(servicio.getestadoservicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(servicio.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(servicio.getcuentacontablegasto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(servicio.getcuentacontablefiscal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(servicio.getcuentacontablefiscal2_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(servicio.getcuentacontableretencion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(servicio.getcuentacontableretencion2_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(servicio.getcuentacontableiva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(servicio.getcuentacontableiva2_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(servicio.getcuentacontablecredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryServicio=Constantes.SFINALQUERY;
	
	public String getsFinalQueryServicio() {
		return this.sFinalQueryServicio;
	}
	
	public void setsFinalQueryServicio(String sFinalQueryServicio) {
		this.sFinalQueryServicio= sFinalQueryServicio;
	}
	
	public Border resaltarSeleccionarServicio=null;
	
	public Border setResaltarSeleccionarServicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//servicioBeanSwingJInternalFrame.jTtoolBarServicio.setBorder(borderResaltar);
		
		this.resaltarSeleccionarServicio= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarServicio() {
		return this.resaltarSeleccionarServicio;
	}
	
	public void setResaltarSeleccionarServicio(Border borderResaltarSeleccionarServicio) {
		this.resaltarSeleccionarServicio= borderResaltarSeleccionarServicio;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridServicio=null;
	public Boolean mostraridServicio=true;
	public Boolean activaridServicio=true;

	public Border resaltarid_empresaServicio=null;
	public Boolean mostrarid_empresaServicio=true;
	public Boolean activarid_empresaServicio=true;
	public Boolean cargarid_empresaServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaServicio=false;//ConEventDepend=true

	public Border resaltarid_tipo_servicioServicio=null;
	public Boolean mostrarid_tipo_servicioServicio=true;
	public Boolean activarid_tipo_servicioServicio=true;
	public Boolean cargarid_tipo_servicioServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_servicioServicio=false;//ConEventDepend=true

	public Border resaltarcodigoServicio=null;
	public Boolean mostrarcodigoServicio=true;
	public Boolean activarcodigoServicio=true;

	public Border resaltarnombreServicio=null;
	public Boolean mostrarnombreServicio=true;
	public Boolean activarnombreServicio=true;

	public Border resaltarivaServicio=null;
	public Boolean mostrarivaServicio=true;
	public Boolean activarivaServicio=true;

	public Border resaltariceServicio=null;
	public Boolean mostrariceServicio=true;
	public Boolean activariceServicio=true;

	public Border resaltares_bienServicio=null;
	public Boolean mostrares_bienServicio=true;
	public Boolean activares_bienServicio=true;

	public Border resaltarid_estado_servicioServicio=null;
	public Boolean mostrarid_estado_servicioServicio=true;
	public Boolean activarid_estado_servicioServicio=true;
	public Boolean cargarid_estado_servicioServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_servicioServicio=false;//ConEventDepend=true

	public Border resaltardescripcionServicio=null;
	public Boolean mostrardescripcionServicio=true;
	public Boolean activardescripcionServicio=true;

	public Border resaltarid_cuenta_contable_gastoServicio=null;
	public Boolean mostrarid_cuenta_contable_gastoServicio=true;
	public Boolean activarid_cuenta_contable_gastoServicio=true;
	public Boolean cargarid_cuenta_contable_gastoServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_gastoServicio=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_fiscalServicio=null;
	public Boolean mostrarid_cuenta_contable_fiscalServicio=true;
	public Boolean activarid_cuenta_contable_fiscalServicio=true;
	public Boolean cargarid_cuenta_contable_fiscalServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_fiscalServicio=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_fiscal2Servicio=null;
	public Boolean mostrarid_cuenta_contable_fiscal2Servicio=true;
	public Boolean activarid_cuenta_contable_fiscal2Servicio=true;
	public Boolean cargarid_cuenta_contable_fiscal2Servicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_fiscal2Servicio=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_retencionServicio=null;
	public Boolean mostrarid_cuenta_contable_retencionServicio=true;
	public Boolean activarid_cuenta_contable_retencionServicio=true;
	public Boolean cargarid_cuenta_contable_retencionServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_retencionServicio=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_retencion2Servicio=null;
	public Boolean mostrarid_cuenta_contable_retencion2Servicio=true;
	public Boolean activarid_cuenta_contable_retencion2Servicio=true;
	public Boolean cargarid_cuenta_contable_retencion2Servicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_retencion2Servicio=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_ivaServicio=null;
	public Boolean mostrarid_cuenta_contable_ivaServicio=true;
	public Boolean activarid_cuenta_contable_ivaServicio=true;
	public Boolean cargarid_cuenta_contable_ivaServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_ivaServicio=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_iva2Servicio=null;
	public Boolean mostrarid_cuenta_contable_iva2Servicio=true;
	public Boolean activarid_cuenta_contable_iva2Servicio=true;
	public Boolean cargarid_cuenta_contable_iva2Servicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_iva2Servicio=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_creditoServicio=null;
	public Boolean mostrarid_cuenta_contable_creditoServicio=true;
	public Boolean activarid_cuenta_contable_creditoServicio=true;
	public Boolean cargarid_cuenta_contable_creditoServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_creditoServicio=false;//ConEventDepend=true

	
	

	public Border setResaltaridServicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioBeanSwingJInternalFrame.jTtoolBarServicio.setBorder(borderResaltar);
		
		this.resaltaridServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridServicio() {
		return this.resaltaridServicio;
	}

	public void setResaltaridServicio(Border borderResaltar) {
		this.resaltaridServicio= borderResaltar;
	}

	public Boolean getMostraridServicio() {
		return this.mostraridServicio;
	}

	public void setMostraridServicio(Boolean mostraridServicio) {
		this.mostraridServicio= mostraridServicio;
	}

	public Boolean getActivaridServicio() {
		return this.activaridServicio;
	}

	public void setActivaridServicio(Boolean activaridServicio) {
		this.activaridServicio= activaridServicio;
	}

	public Border setResaltarid_empresaServicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioBeanSwingJInternalFrame.jTtoolBarServicio.setBorder(borderResaltar);
		
		this.resaltarid_empresaServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaServicio() {
		return this.resaltarid_empresaServicio;
	}

	public void setResaltarid_empresaServicio(Border borderResaltar) {
		this.resaltarid_empresaServicio= borderResaltar;
	}

	public Boolean getMostrarid_empresaServicio() {
		return this.mostrarid_empresaServicio;
	}

	public void setMostrarid_empresaServicio(Boolean mostrarid_empresaServicio) {
		this.mostrarid_empresaServicio= mostrarid_empresaServicio;
	}

	public Boolean getActivarid_empresaServicio() {
		return this.activarid_empresaServicio;
	}

	public void setActivarid_empresaServicio(Boolean activarid_empresaServicio) {
		this.activarid_empresaServicio= activarid_empresaServicio;
	}

	public Boolean getCargarid_empresaServicio() {
		return this.cargarid_empresaServicio;
	}

	public void setCargarid_empresaServicio(Boolean cargarid_empresaServicio) {
		this.cargarid_empresaServicio= cargarid_empresaServicio;
	}

	public Border setResaltarid_tipo_servicioServicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioBeanSwingJInternalFrame.jTtoolBarServicio.setBorder(borderResaltar);
		
		this.resaltarid_tipo_servicioServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_servicioServicio() {
		return this.resaltarid_tipo_servicioServicio;
	}

	public void setResaltarid_tipo_servicioServicio(Border borderResaltar) {
		this.resaltarid_tipo_servicioServicio= borderResaltar;
	}

	public Boolean getMostrarid_tipo_servicioServicio() {
		return this.mostrarid_tipo_servicioServicio;
	}

	public void setMostrarid_tipo_servicioServicio(Boolean mostrarid_tipo_servicioServicio) {
		this.mostrarid_tipo_servicioServicio= mostrarid_tipo_servicioServicio;
	}

	public Boolean getActivarid_tipo_servicioServicio() {
		return this.activarid_tipo_servicioServicio;
	}

	public void setActivarid_tipo_servicioServicio(Boolean activarid_tipo_servicioServicio) {
		this.activarid_tipo_servicioServicio= activarid_tipo_servicioServicio;
	}

	public Boolean getCargarid_tipo_servicioServicio() {
		return this.cargarid_tipo_servicioServicio;
	}

	public void setCargarid_tipo_servicioServicio(Boolean cargarid_tipo_servicioServicio) {
		this.cargarid_tipo_servicioServicio= cargarid_tipo_servicioServicio;
	}

	public Border setResaltarcodigoServicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioBeanSwingJInternalFrame.jTtoolBarServicio.setBorder(borderResaltar);
		
		this.resaltarcodigoServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoServicio() {
		return this.resaltarcodigoServicio;
	}

	public void setResaltarcodigoServicio(Border borderResaltar) {
		this.resaltarcodigoServicio= borderResaltar;
	}

	public Boolean getMostrarcodigoServicio() {
		return this.mostrarcodigoServicio;
	}

	public void setMostrarcodigoServicio(Boolean mostrarcodigoServicio) {
		this.mostrarcodigoServicio= mostrarcodigoServicio;
	}

	public Boolean getActivarcodigoServicio() {
		return this.activarcodigoServicio;
	}

	public void setActivarcodigoServicio(Boolean activarcodigoServicio) {
		this.activarcodigoServicio= activarcodigoServicio;
	}

	public Border setResaltarnombreServicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioBeanSwingJInternalFrame.jTtoolBarServicio.setBorder(borderResaltar);
		
		this.resaltarnombreServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreServicio() {
		return this.resaltarnombreServicio;
	}

	public void setResaltarnombreServicio(Border borderResaltar) {
		this.resaltarnombreServicio= borderResaltar;
	}

	public Boolean getMostrarnombreServicio() {
		return this.mostrarnombreServicio;
	}

	public void setMostrarnombreServicio(Boolean mostrarnombreServicio) {
		this.mostrarnombreServicio= mostrarnombreServicio;
	}

	public Boolean getActivarnombreServicio() {
		return this.activarnombreServicio;
	}

	public void setActivarnombreServicio(Boolean activarnombreServicio) {
		this.activarnombreServicio= activarnombreServicio;
	}

	public Border setResaltarivaServicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioBeanSwingJInternalFrame.jTtoolBarServicio.setBorder(borderResaltar);
		
		this.resaltarivaServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaServicio() {
		return this.resaltarivaServicio;
	}

	public void setResaltarivaServicio(Border borderResaltar) {
		this.resaltarivaServicio= borderResaltar;
	}

	public Boolean getMostrarivaServicio() {
		return this.mostrarivaServicio;
	}

	public void setMostrarivaServicio(Boolean mostrarivaServicio) {
		this.mostrarivaServicio= mostrarivaServicio;
	}

	public Boolean getActivarivaServicio() {
		return this.activarivaServicio;
	}

	public void setActivarivaServicio(Boolean activarivaServicio) {
		this.activarivaServicio= activarivaServicio;
	}

	public Border setResaltariceServicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioBeanSwingJInternalFrame.jTtoolBarServicio.setBorder(borderResaltar);
		
		this.resaltariceServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceServicio() {
		return this.resaltariceServicio;
	}

	public void setResaltariceServicio(Border borderResaltar) {
		this.resaltariceServicio= borderResaltar;
	}

	public Boolean getMostrariceServicio() {
		return this.mostrariceServicio;
	}

	public void setMostrariceServicio(Boolean mostrariceServicio) {
		this.mostrariceServicio= mostrariceServicio;
	}

	public Boolean getActivariceServicio() {
		return this.activariceServicio;
	}

	public void setActivariceServicio(Boolean activariceServicio) {
		this.activariceServicio= activariceServicio;
	}

	public Border setResaltares_bienServicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioBeanSwingJInternalFrame.jTtoolBarServicio.setBorder(borderResaltar);
		
		this.resaltares_bienServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_bienServicio() {
		return this.resaltares_bienServicio;
	}

	public void setResaltares_bienServicio(Border borderResaltar) {
		this.resaltares_bienServicio= borderResaltar;
	}

	public Boolean getMostrares_bienServicio() {
		return this.mostrares_bienServicio;
	}

	public void setMostrares_bienServicio(Boolean mostrares_bienServicio) {
		this.mostrares_bienServicio= mostrares_bienServicio;
	}

	public Boolean getActivares_bienServicio() {
		return this.activares_bienServicio;
	}

	public void setActivares_bienServicio(Boolean activares_bienServicio) {
		this.activares_bienServicio= activares_bienServicio;
	}

	public Border setResaltarid_estado_servicioServicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioBeanSwingJInternalFrame.jTtoolBarServicio.setBorder(borderResaltar);
		
		this.resaltarid_estado_servicioServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_servicioServicio() {
		return this.resaltarid_estado_servicioServicio;
	}

	public void setResaltarid_estado_servicioServicio(Border borderResaltar) {
		this.resaltarid_estado_servicioServicio= borderResaltar;
	}

	public Boolean getMostrarid_estado_servicioServicio() {
		return this.mostrarid_estado_servicioServicio;
	}

	public void setMostrarid_estado_servicioServicio(Boolean mostrarid_estado_servicioServicio) {
		this.mostrarid_estado_servicioServicio= mostrarid_estado_servicioServicio;
	}

	public Boolean getActivarid_estado_servicioServicio() {
		return this.activarid_estado_servicioServicio;
	}

	public void setActivarid_estado_servicioServicio(Boolean activarid_estado_servicioServicio) {
		this.activarid_estado_servicioServicio= activarid_estado_servicioServicio;
	}

	public Boolean getCargarid_estado_servicioServicio() {
		return this.cargarid_estado_servicioServicio;
	}

	public void setCargarid_estado_servicioServicio(Boolean cargarid_estado_servicioServicio) {
		this.cargarid_estado_servicioServicio= cargarid_estado_servicioServicio;
	}

	public Border setResaltardescripcionServicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioBeanSwingJInternalFrame.jTtoolBarServicio.setBorder(borderResaltar);
		
		this.resaltardescripcionServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionServicio() {
		return this.resaltardescripcionServicio;
	}

	public void setResaltardescripcionServicio(Border borderResaltar) {
		this.resaltardescripcionServicio= borderResaltar;
	}

	public Boolean getMostrardescripcionServicio() {
		return this.mostrardescripcionServicio;
	}

	public void setMostrardescripcionServicio(Boolean mostrardescripcionServicio) {
		this.mostrardescripcionServicio= mostrardescripcionServicio;
	}

	public Boolean getActivardescripcionServicio() {
		return this.activardescripcionServicio;
	}

	public void setActivardescripcionServicio(Boolean activardescripcionServicio) {
		this.activardescripcionServicio= activardescripcionServicio;
	}

	public Border setResaltarid_cuenta_contable_gastoServicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioBeanSwingJInternalFrame.jTtoolBarServicio.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_gastoServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_gastoServicio() {
		return this.resaltarid_cuenta_contable_gastoServicio;
	}

	public void setResaltarid_cuenta_contable_gastoServicio(Border borderResaltar) {
		this.resaltarid_cuenta_contable_gastoServicio= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_gastoServicio() {
		return this.mostrarid_cuenta_contable_gastoServicio;
	}

	public void setMostrarid_cuenta_contable_gastoServicio(Boolean mostrarid_cuenta_contable_gastoServicio) {
		this.mostrarid_cuenta_contable_gastoServicio= mostrarid_cuenta_contable_gastoServicio;
	}

	public Boolean getActivarid_cuenta_contable_gastoServicio() {
		return this.activarid_cuenta_contable_gastoServicio;
	}

	public void setActivarid_cuenta_contable_gastoServicio(Boolean activarid_cuenta_contable_gastoServicio) {
		this.activarid_cuenta_contable_gastoServicio= activarid_cuenta_contable_gastoServicio;
	}

	public Boolean getCargarid_cuenta_contable_gastoServicio() {
		return this.cargarid_cuenta_contable_gastoServicio;
	}

	public void setCargarid_cuenta_contable_gastoServicio(Boolean cargarid_cuenta_contable_gastoServicio) {
		this.cargarid_cuenta_contable_gastoServicio= cargarid_cuenta_contable_gastoServicio;
	}

	public Border setResaltarid_cuenta_contable_fiscalServicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioBeanSwingJInternalFrame.jTtoolBarServicio.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_fiscalServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_fiscalServicio() {
		return this.resaltarid_cuenta_contable_fiscalServicio;
	}

	public void setResaltarid_cuenta_contable_fiscalServicio(Border borderResaltar) {
		this.resaltarid_cuenta_contable_fiscalServicio= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_fiscalServicio() {
		return this.mostrarid_cuenta_contable_fiscalServicio;
	}

	public void setMostrarid_cuenta_contable_fiscalServicio(Boolean mostrarid_cuenta_contable_fiscalServicio) {
		this.mostrarid_cuenta_contable_fiscalServicio= mostrarid_cuenta_contable_fiscalServicio;
	}

	public Boolean getActivarid_cuenta_contable_fiscalServicio() {
		return this.activarid_cuenta_contable_fiscalServicio;
	}

	public void setActivarid_cuenta_contable_fiscalServicio(Boolean activarid_cuenta_contable_fiscalServicio) {
		this.activarid_cuenta_contable_fiscalServicio= activarid_cuenta_contable_fiscalServicio;
	}

	public Boolean getCargarid_cuenta_contable_fiscalServicio() {
		return this.cargarid_cuenta_contable_fiscalServicio;
	}

	public void setCargarid_cuenta_contable_fiscalServicio(Boolean cargarid_cuenta_contable_fiscalServicio) {
		this.cargarid_cuenta_contable_fiscalServicio= cargarid_cuenta_contable_fiscalServicio;
	}

	public Border setResaltarid_cuenta_contable_fiscal2Servicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioBeanSwingJInternalFrame.jTtoolBarServicio.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_fiscal2Servicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_fiscal2Servicio() {
		return this.resaltarid_cuenta_contable_fiscal2Servicio;
	}

	public void setResaltarid_cuenta_contable_fiscal2Servicio(Border borderResaltar) {
		this.resaltarid_cuenta_contable_fiscal2Servicio= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_fiscal2Servicio() {
		return this.mostrarid_cuenta_contable_fiscal2Servicio;
	}

	public void setMostrarid_cuenta_contable_fiscal2Servicio(Boolean mostrarid_cuenta_contable_fiscal2Servicio) {
		this.mostrarid_cuenta_contable_fiscal2Servicio= mostrarid_cuenta_contable_fiscal2Servicio;
	}

	public Boolean getActivarid_cuenta_contable_fiscal2Servicio() {
		return this.activarid_cuenta_contable_fiscal2Servicio;
	}

	public void setActivarid_cuenta_contable_fiscal2Servicio(Boolean activarid_cuenta_contable_fiscal2Servicio) {
		this.activarid_cuenta_contable_fiscal2Servicio= activarid_cuenta_contable_fiscal2Servicio;
	}

	public Boolean getCargarid_cuenta_contable_fiscal2Servicio() {
		return this.cargarid_cuenta_contable_fiscal2Servicio;
	}

	public void setCargarid_cuenta_contable_fiscal2Servicio(Boolean cargarid_cuenta_contable_fiscal2Servicio) {
		this.cargarid_cuenta_contable_fiscal2Servicio= cargarid_cuenta_contable_fiscal2Servicio;
	}

	public Border setResaltarid_cuenta_contable_retencionServicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioBeanSwingJInternalFrame.jTtoolBarServicio.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_retencionServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_retencionServicio() {
		return this.resaltarid_cuenta_contable_retencionServicio;
	}

	public void setResaltarid_cuenta_contable_retencionServicio(Border borderResaltar) {
		this.resaltarid_cuenta_contable_retencionServicio= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_retencionServicio() {
		return this.mostrarid_cuenta_contable_retencionServicio;
	}

	public void setMostrarid_cuenta_contable_retencionServicio(Boolean mostrarid_cuenta_contable_retencionServicio) {
		this.mostrarid_cuenta_contable_retencionServicio= mostrarid_cuenta_contable_retencionServicio;
	}

	public Boolean getActivarid_cuenta_contable_retencionServicio() {
		return this.activarid_cuenta_contable_retencionServicio;
	}

	public void setActivarid_cuenta_contable_retencionServicio(Boolean activarid_cuenta_contable_retencionServicio) {
		this.activarid_cuenta_contable_retencionServicio= activarid_cuenta_contable_retencionServicio;
	}

	public Boolean getCargarid_cuenta_contable_retencionServicio() {
		return this.cargarid_cuenta_contable_retencionServicio;
	}

	public void setCargarid_cuenta_contable_retencionServicio(Boolean cargarid_cuenta_contable_retencionServicio) {
		this.cargarid_cuenta_contable_retencionServicio= cargarid_cuenta_contable_retencionServicio;
	}

	public Border setResaltarid_cuenta_contable_retencion2Servicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioBeanSwingJInternalFrame.jTtoolBarServicio.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_retencion2Servicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_retencion2Servicio() {
		return this.resaltarid_cuenta_contable_retencion2Servicio;
	}

	public void setResaltarid_cuenta_contable_retencion2Servicio(Border borderResaltar) {
		this.resaltarid_cuenta_contable_retencion2Servicio= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_retencion2Servicio() {
		return this.mostrarid_cuenta_contable_retencion2Servicio;
	}

	public void setMostrarid_cuenta_contable_retencion2Servicio(Boolean mostrarid_cuenta_contable_retencion2Servicio) {
		this.mostrarid_cuenta_contable_retencion2Servicio= mostrarid_cuenta_contable_retencion2Servicio;
	}

	public Boolean getActivarid_cuenta_contable_retencion2Servicio() {
		return this.activarid_cuenta_contable_retencion2Servicio;
	}

	public void setActivarid_cuenta_contable_retencion2Servicio(Boolean activarid_cuenta_contable_retencion2Servicio) {
		this.activarid_cuenta_contable_retencion2Servicio= activarid_cuenta_contable_retencion2Servicio;
	}

	public Boolean getCargarid_cuenta_contable_retencion2Servicio() {
		return this.cargarid_cuenta_contable_retencion2Servicio;
	}

	public void setCargarid_cuenta_contable_retencion2Servicio(Boolean cargarid_cuenta_contable_retencion2Servicio) {
		this.cargarid_cuenta_contable_retencion2Servicio= cargarid_cuenta_contable_retencion2Servicio;
	}

	public Border setResaltarid_cuenta_contable_ivaServicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioBeanSwingJInternalFrame.jTtoolBarServicio.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_ivaServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_ivaServicio() {
		return this.resaltarid_cuenta_contable_ivaServicio;
	}

	public void setResaltarid_cuenta_contable_ivaServicio(Border borderResaltar) {
		this.resaltarid_cuenta_contable_ivaServicio= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_ivaServicio() {
		return this.mostrarid_cuenta_contable_ivaServicio;
	}

	public void setMostrarid_cuenta_contable_ivaServicio(Boolean mostrarid_cuenta_contable_ivaServicio) {
		this.mostrarid_cuenta_contable_ivaServicio= mostrarid_cuenta_contable_ivaServicio;
	}

	public Boolean getActivarid_cuenta_contable_ivaServicio() {
		return this.activarid_cuenta_contable_ivaServicio;
	}

	public void setActivarid_cuenta_contable_ivaServicio(Boolean activarid_cuenta_contable_ivaServicio) {
		this.activarid_cuenta_contable_ivaServicio= activarid_cuenta_contable_ivaServicio;
	}

	public Boolean getCargarid_cuenta_contable_ivaServicio() {
		return this.cargarid_cuenta_contable_ivaServicio;
	}

	public void setCargarid_cuenta_contable_ivaServicio(Boolean cargarid_cuenta_contable_ivaServicio) {
		this.cargarid_cuenta_contable_ivaServicio= cargarid_cuenta_contable_ivaServicio;
	}

	public Border setResaltarid_cuenta_contable_iva2Servicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioBeanSwingJInternalFrame.jTtoolBarServicio.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_iva2Servicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_iva2Servicio() {
		return this.resaltarid_cuenta_contable_iva2Servicio;
	}

	public void setResaltarid_cuenta_contable_iva2Servicio(Border borderResaltar) {
		this.resaltarid_cuenta_contable_iva2Servicio= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_iva2Servicio() {
		return this.mostrarid_cuenta_contable_iva2Servicio;
	}

	public void setMostrarid_cuenta_contable_iva2Servicio(Boolean mostrarid_cuenta_contable_iva2Servicio) {
		this.mostrarid_cuenta_contable_iva2Servicio= mostrarid_cuenta_contable_iva2Servicio;
	}

	public Boolean getActivarid_cuenta_contable_iva2Servicio() {
		return this.activarid_cuenta_contable_iva2Servicio;
	}

	public void setActivarid_cuenta_contable_iva2Servicio(Boolean activarid_cuenta_contable_iva2Servicio) {
		this.activarid_cuenta_contable_iva2Servicio= activarid_cuenta_contable_iva2Servicio;
	}

	public Boolean getCargarid_cuenta_contable_iva2Servicio() {
		return this.cargarid_cuenta_contable_iva2Servicio;
	}

	public void setCargarid_cuenta_contable_iva2Servicio(Boolean cargarid_cuenta_contable_iva2Servicio) {
		this.cargarid_cuenta_contable_iva2Servicio= cargarid_cuenta_contable_iva2Servicio;
	}

	public Border setResaltarid_cuenta_contable_creditoServicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioBeanSwingJInternalFrame.jTtoolBarServicio.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_creditoServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_creditoServicio() {
		return this.resaltarid_cuenta_contable_creditoServicio;
	}

	public void setResaltarid_cuenta_contable_creditoServicio(Border borderResaltar) {
		this.resaltarid_cuenta_contable_creditoServicio= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_creditoServicio() {
		return this.mostrarid_cuenta_contable_creditoServicio;
	}

	public void setMostrarid_cuenta_contable_creditoServicio(Boolean mostrarid_cuenta_contable_creditoServicio) {
		this.mostrarid_cuenta_contable_creditoServicio= mostrarid_cuenta_contable_creditoServicio;
	}

	public Boolean getActivarid_cuenta_contable_creditoServicio() {
		return this.activarid_cuenta_contable_creditoServicio;
	}

	public void setActivarid_cuenta_contable_creditoServicio(Boolean activarid_cuenta_contable_creditoServicio) {
		this.activarid_cuenta_contable_creditoServicio= activarid_cuenta_contable_creditoServicio;
	}

	public Boolean getCargarid_cuenta_contable_creditoServicio() {
		return this.cargarid_cuenta_contable_creditoServicio;
	}

	public void setCargarid_cuenta_contable_creditoServicio(Boolean cargarid_cuenta_contable_creditoServicio) {
		this.cargarid_cuenta_contable_creditoServicio= cargarid_cuenta_contable_creditoServicio;
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
		
		
		this.setMostraridServicio(esInicial);
		this.setMostrarid_empresaServicio(esInicial);
		this.setMostrarid_tipo_servicioServicio(esInicial);
		this.setMostrarcodigoServicio(esInicial);
		this.setMostrarnombreServicio(esInicial);
		this.setMostrarivaServicio(esInicial);
		this.setMostrariceServicio(esInicial);
		this.setMostrares_bienServicio(esInicial);
		this.setMostrarid_estado_servicioServicio(esInicial);
		this.setMostrardescripcionServicio(esInicial);
		this.setMostrarid_cuenta_contable_gastoServicio(esInicial);
		this.setMostrarid_cuenta_contable_fiscalServicio(esInicial);
		this.setMostrarid_cuenta_contable_fiscal2Servicio(esInicial);
		this.setMostrarid_cuenta_contable_retencionServicio(esInicial);
		this.setMostrarid_cuenta_contable_retencion2Servicio(esInicial);
		this.setMostrarid_cuenta_contable_ivaServicio(esInicial);
		this.setMostrarid_cuenta_contable_iva2Servicio(esInicial);
		this.setMostrarid_cuenta_contable_creditoServicio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ServicioConstantesFunciones.ID)) {
				this.setMostraridServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDTIPOSERVICIO)) {
				this.setMostrarid_tipo_servicioServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IVA)) {
				this.setMostrarivaServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.ICE)) {
				this.setMostrariceServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.ESBIEN)) {
				this.setMostrares_bienServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDESTADOSERVICIO)) {
				this.setMostrarid_estado_servicioServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLEGASTO)) {
				this.setMostrarid_cuenta_contable_gastoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL)) {
				this.setMostrarid_cuenta_contable_fiscalServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL2)) {
				this.setMostrarid_cuenta_contable_fiscal2Servicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLERETENCION)) {
				this.setMostrarid_cuenta_contable_retencionServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLERETENCION2)) {
				this.setMostrarid_cuenta_contable_retencion2Servicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLEIVA)) {
				this.setMostrarid_cuenta_contable_ivaServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLEIVA2)) {
				this.setMostrarid_cuenta_contable_iva2Servicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setMostrarid_cuenta_contable_creditoServicio(esAsigna);
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
		
		
		this.setActivaridServicio(esInicial);
		this.setActivarid_empresaServicio(esInicial);
		this.setActivarid_tipo_servicioServicio(esInicial);
		this.setActivarcodigoServicio(esInicial);
		this.setActivarnombreServicio(esInicial);
		this.setActivarivaServicio(esInicial);
		this.setActivariceServicio(esInicial);
		this.setActivares_bienServicio(esInicial);
		this.setActivarid_estado_servicioServicio(esInicial);
		this.setActivardescripcionServicio(esInicial);
		this.setActivarid_cuenta_contable_gastoServicio(esInicial);
		this.setActivarid_cuenta_contable_fiscalServicio(esInicial);
		this.setActivarid_cuenta_contable_fiscal2Servicio(esInicial);
		this.setActivarid_cuenta_contable_retencionServicio(esInicial);
		this.setActivarid_cuenta_contable_retencion2Servicio(esInicial);
		this.setActivarid_cuenta_contable_ivaServicio(esInicial);
		this.setActivarid_cuenta_contable_iva2Servicio(esInicial);
		this.setActivarid_cuenta_contable_creditoServicio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ServicioConstantesFunciones.ID)) {
				this.setActivaridServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDTIPOSERVICIO)) {
				this.setActivarid_tipo_servicioServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.CODIGO)) {
				this.setActivarcodigoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.NOMBRE)) {
				this.setActivarnombreServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IVA)) {
				this.setActivarivaServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.ICE)) {
				this.setActivariceServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.ESBIEN)) {
				this.setActivares_bienServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDESTADOSERVICIO)) {
				this.setActivarid_estado_servicioServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLEGASTO)) {
				this.setActivarid_cuenta_contable_gastoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL)) {
				this.setActivarid_cuenta_contable_fiscalServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL2)) {
				this.setActivarid_cuenta_contable_fiscal2Servicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLERETENCION)) {
				this.setActivarid_cuenta_contable_retencionServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLERETENCION2)) {
				this.setActivarid_cuenta_contable_retencion2Servicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLEIVA)) {
				this.setActivarid_cuenta_contable_ivaServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLEIVA2)) {
				this.setActivarid_cuenta_contable_iva2Servicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setActivarid_cuenta_contable_creditoServicio(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridServicio(esInicial);
		this.setResaltarid_empresaServicio(esInicial);
		this.setResaltarid_tipo_servicioServicio(esInicial);
		this.setResaltarcodigoServicio(esInicial);
		this.setResaltarnombreServicio(esInicial);
		this.setResaltarivaServicio(esInicial);
		this.setResaltariceServicio(esInicial);
		this.setResaltares_bienServicio(esInicial);
		this.setResaltarid_estado_servicioServicio(esInicial);
		this.setResaltardescripcionServicio(esInicial);
		this.setResaltarid_cuenta_contable_gastoServicio(esInicial);
		this.setResaltarid_cuenta_contable_fiscalServicio(esInicial);
		this.setResaltarid_cuenta_contable_fiscal2Servicio(esInicial);
		this.setResaltarid_cuenta_contable_retencionServicio(esInicial);
		this.setResaltarid_cuenta_contable_retencion2Servicio(esInicial);
		this.setResaltarid_cuenta_contable_ivaServicio(esInicial);
		this.setResaltarid_cuenta_contable_iva2Servicio(esInicial);
		this.setResaltarid_cuenta_contable_creditoServicio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ServicioConstantesFunciones.ID)) {
				this.setResaltaridServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDTIPOSERVICIO)) {
				this.setResaltarid_tipo_servicioServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IVA)) {
				this.setResaltarivaServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.ICE)) {
				this.setResaltariceServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.ESBIEN)) {
				this.setResaltares_bienServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDESTADOSERVICIO)) {
				this.setResaltarid_estado_servicioServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLEGASTO)) {
				this.setResaltarid_cuenta_contable_gastoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL)) {
				this.setResaltarid_cuenta_contable_fiscalServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL2)) {
				this.setResaltarid_cuenta_contable_fiscal2Servicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLERETENCION)) {
				this.setResaltarid_cuenta_contable_retencionServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLERETENCION2)) {
				this.setResaltarid_cuenta_contable_retencion2Servicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLEIVA)) {
				this.setResaltarid_cuenta_contable_ivaServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLEIVA2)) {
				this.setResaltarid_cuenta_contable_iva2Servicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setResaltarid_cuenta_contable_creditoServicio(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoServicio=true;

	public Boolean getMostrarBusquedaPorCodigoServicio() {
		return this.mostrarBusquedaPorCodigoServicio;
	}

	public void setMostrarBusquedaPorCodigoServicio(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoServicio= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreServicio=true;

	public Boolean getMostrarBusquedaPorNombreServicio() {
		return this.mostrarBusquedaPorNombreServicio;
	}

	public void setMostrarBusquedaPorNombreServicio(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreServicio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableFiscal2Servicio=true;

	public Boolean getMostrarFK_IdCuentaContableFiscal2Servicio() {
		return this.mostrarFK_IdCuentaContableFiscal2Servicio;
	}

	public void setMostrarFK_IdCuentaContableFiscal2Servicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableFiscal2Servicio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableIva2Servicio=true;

	public Boolean getMostrarFK_IdCuentaContableIva2Servicio() {
		return this.mostrarFK_IdCuentaContableIva2Servicio;
	}

	public void setMostrarFK_IdCuentaContableIva2Servicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableIva2Servicio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableRetencion2Servicio=true;

	public Boolean getMostrarFK_IdCuentaContableRetencion2Servicio() {
		return this.mostrarFK_IdCuentaContableRetencion2Servicio;
	}

	public void setMostrarFK_IdCuentaContableRetencion2Servicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableRetencion2Servicio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaServicio=true;

	public Boolean getMostrarFK_IdEmpresaServicio() {
		return this.mostrarFK_IdEmpresaServicio;
	}

	public void setMostrarFK_IdEmpresaServicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaServicio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoServicioServicio=true;

	public Boolean getMostrarFK_IdEstadoServicioServicio() {
		return this.mostrarFK_IdEstadoServicioServicio;
	}

	public void setMostrarFK_IdEstadoServicioServicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoServicioServicio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoServicioServicio=true;

	public Boolean getMostrarFK_IdTipoServicioServicio() {
		return this.mostrarFK_IdTipoServicioServicio;
	}

	public void setMostrarFK_IdTipoServicioServicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoServicioServicio= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoServicio=true;

	public Boolean getActivarBusquedaPorCodigoServicio() {
		return this.activarBusquedaPorCodigoServicio;
	}

	public void setActivarBusquedaPorCodigoServicio(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoServicio= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreServicio=true;

	public Boolean getActivarBusquedaPorNombreServicio() {
		return this.activarBusquedaPorNombreServicio;
	}

	public void setActivarBusquedaPorNombreServicio(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreServicio= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableFiscal2Servicio=true;

	public Boolean getActivarFK_IdCuentaContableFiscal2Servicio() {
		return this.activarFK_IdCuentaContableFiscal2Servicio;
	}

	public void setActivarFK_IdCuentaContableFiscal2Servicio(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableFiscal2Servicio= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableIva2Servicio=true;

	public Boolean getActivarFK_IdCuentaContableIva2Servicio() {
		return this.activarFK_IdCuentaContableIva2Servicio;
	}

	public void setActivarFK_IdCuentaContableIva2Servicio(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableIva2Servicio= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableRetencion2Servicio=true;

	public Boolean getActivarFK_IdCuentaContableRetencion2Servicio() {
		return this.activarFK_IdCuentaContableRetencion2Servicio;
	}

	public void setActivarFK_IdCuentaContableRetencion2Servicio(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableRetencion2Servicio= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaServicio=true;

	public Boolean getActivarFK_IdEmpresaServicio() {
		return this.activarFK_IdEmpresaServicio;
	}

	public void setActivarFK_IdEmpresaServicio(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaServicio= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoServicioServicio=true;

	public Boolean getActivarFK_IdEstadoServicioServicio() {
		return this.activarFK_IdEstadoServicioServicio;
	}

	public void setActivarFK_IdEstadoServicioServicio(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoServicioServicio= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoServicioServicio=true;

	public Boolean getActivarFK_IdTipoServicioServicio() {
		return this.activarFK_IdTipoServicioServicio;
	}

	public void setActivarFK_IdTipoServicioServicio(Boolean habilitarResaltar) {
		this.activarFK_IdTipoServicioServicio= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoServicio=null;

	public Border getResaltarBusquedaPorCodigoServicio() {
		return this.resaltarBusquedaPorCodigoServicio;
	}

	public void setResaltarBusquedaPorCodigoServicio(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoServicio= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoServicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoServicio= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreServicio=null;

	public Border getResaltarBusquedaPorNombreServicio() {
		return this.resaltarBusquedaPorNombreServicio;
	}

	public void setResaltarBusquedaPorNombreServicio(Border borderResaltar) {
		this.resaltarBusquedaPorNombreServicio= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreServicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreServicio= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableFiscal2Servicio=null;

	public Border getResaltarFK_IdCuentaContableFiscal2Servicio() {
		return this.resaltarFK_IdCuentaContableFiscal2Servicio;
	}

	public void setResaltarFK_IdCuentaContableFiscal2Servicio(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableFiscal2Servicio= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableFiscal2Servicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableFiscal2Servicio= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableIva2Servicio=null;

	public Border getResaltarFK_IdCuentaContableIva2Servicio() {
		return this.resaltarFK_IdCuentaContableIva2Servicio;
	}

	public void setResaltarFK_IdCuentaContableIva2Servicio(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableIva2Servicio= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableIva2Servicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableIva2Servicio= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableRetencion2Servicio=null;

	public Border getResaltarFK_IdCuentaContableRetencion2Servicio() {
		return this.resaltarFK_IdCuentaContableRetencion2Servicio;
	}

	public void setResaltarFK_IdCuentaContableRetencion2Servicio(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableRetencion2Servicio= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableRetencion2Servicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableRetencion2Servicio= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaServicio=null;

	public Border getResaltarFK_IdEmpresaServicio() {
		return this.resaltarFK_IdEmpresaServicio;
	}

	public void setResaltarFK_IdEmpresaServicio(Border borderResaltar) {
		this.resaltarFK_IdEmpresaServicio= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaServicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaServicio= borderResaltar;
	}

	public Border resaltarFK_IdEstadoServicioServicio=null;

	public Border getResaltarFK_IdEstadoServicioServicio() {
		return this.resaltarFK_IdEstadoServicioServicio;
	}

	public void setResaltarFK_IdEstadoServicioServicio(Border borderResaltar) {
		this.resaltarFK_IdEstadoServicioServicio= borderResaltar;
	}

	public void setResaltarFK_IdEstadoServicioServicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoServicioServicio= borderResaltar;
	}

	public Border resaltarFK_IdTipoServicioServicio=null;

	public Border getResaltarFK_IdTipoServicioServicio() {
		return this.resaltarFK_IdTipoServicioServicio;
	}

	public void setResaltarFK_IdTipoServicioServicio(Border borderResaltar) {
		this.resaltarFK_IdTipoServicioServicio= borderResaltar;
	}

	public void setResaltarFK_IdTipoServicioServicio(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioBeanSwingJInternalFrame servicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoServicioServicio= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}