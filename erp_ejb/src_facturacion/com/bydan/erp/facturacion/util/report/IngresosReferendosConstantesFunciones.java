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
package com.bydan.erp.facturacion.util.report;

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


import com.bydan.erp.facturacion.util.report.IngresosReferendosConstantesFunciones;
import com.bydan.erp.facturacion.util.report.IngresosReferendosParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.IngresosReferendosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class IngresosReferendosConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="IngresosReferendos";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="IngresosReferendos"+IngresosReferendosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="IngresosReferendosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="IngresosReferendosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=IngresosReferendosConstantesFunciones.SCHEMA+"_"+IngresosReferendosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/IngresosReferendosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=IngresosReferendosConstantesFunciones.SCHEMA+"_"+IngresosReferendosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=IngresosReferendosConstantesFunciones.SCHEMA+"_"+IngresosReferendosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/IngresosReferendosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=IngresosReferendosConstantesFunciones.SCHEMA+"_"+IngresosReferendosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+IngresosReferendosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/IngresosReferendosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+IngresosReferendosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+IngresosReferendosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/IngresosReferendosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+IngresosReferendosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=IngresosReferendosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+IngresosReferendosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=IngresosReferendosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+IngresosReferendosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Ingresos Referendoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Ingresos Referendos";
	public static final String SCLASSWEBTITULO_LOWER="Ingresos Referendos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="IngresosReferendos";
	public static final String OBJECTNAME="ingresosreferendos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="ingresos_referendos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select ingresosreferendos from "+IngresosReferendosConstantesFunciones.SPERSISTENCENAME+" ingresosreferendos";
	public static String QUERYSELECTNATIVE="select "+IngresosReferendosConstantesFunciones.SCHEMA+"."+IngresosReferendosConstantesFunciones.TABLENAME+".id,"+IngresosReferendosConstantesFunciones.SCHEMA+"."+IngresosReferendosConstantesFunciones.TABLENAME+".version_row,"+IngresosReferendosConstantesFunciones.SCHEMA+"."+IngresosReferendosConstantesFunciones.TABLENAME+".fecha_emision_desde,"+IngresosReferendosConstantesFunciones.SCHEMA+"."+IngresosReferendosConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+IngresosReferendosConstantesFunciones.SCHEMA+"."+IngresosReferendosConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+IngresosReferendosConstantesFunciones.SCHEMA+"."+IngresosReferendosConstantesFunciones.TABLENAME+".numero,"+IngresosReferendosConstantesFunciones.SCHEMA+"."+IngresosReferendosConstantesFunciones.TABLENAME+".numero_autorizacion,"+IngresosReferendosConstantesFunciones.SCHEMA+"."+IngresosReferendosConstantesFunciones.TABLENAME+".numero_fue,"+IngresosReferendosConstantesFunciones.SCHEMA+"."+IngresosReferendosConstantesFunciones.TABLENAME+".numero_pre_impreso,"+IngresosReferendosConstantesFunciones.SCHEMA+"."+IngresosReferendosConstantesFunciones.TABLENAME+".numero_dau,"+IngresosReferendosConstantesFunciones.SCHEMA+"."+IngresosReferendosConstantesFunciones.TABLENAME+".numero_referendo,"+IngresosReferendosConstantesFunciones.SCHEMA+"."+IngresosReferendosConstantesFunciones.TABLENAME+".fecha_referendo,"+IngresosReferendosConstantesFunciones.SCHEMA+"."+IngresosReferendosConstantesFunciones.TABLENAME+".aforo_referendo from "+IngresosReferendosConstantesFunciones.SCHEMA+"."+IngresosReferendosConstantesFunciones.TABLENAME;//+" as "+IngresosReferendosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBRECOMPLETOCLIENTE= "nombre_completo_cliente";
    public static final String NUMERO= "numero";
    public static final String NUMEROAUTORIZACION= "numero_autorizacion";
    public static final String NUMEROFUE= "numero_fue";
    public static final String NUMEROPREIMPRESO= "numero_pre_impreso";
    public static final String NUMERODAU= "numero_dau";
    public static final String NUMEROREFERENDO= "numero_referendo";
    public static final String FECHAREFERENDO= "fecha_referendo";
    public static final String AFOROREFERENDO= "aforo_referendo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBRECOMPLETOCLIENTE= "Nombre Completo Cliente";
		public static final String LABEL_NOMBRECOMPLETOCLIENTE_LOWER= "Nombre Completo Cliente";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_NUMEROAUTORIZACION= "Numero Autorizacion";
		public static final String LABEL_NUMEROAUTORIZACION_LOWER= "Numero Autorizacion";
    	public static final String LABEL_NUMEROFUE= "Numero Fue";
		public static final String LABEL_NUMEROFUE_LOWER= "Numero Fue";
    	public static final String LABEL_NUMEROPREIMPRESO= "Numero Pre Impreso";
		public static final String LABEL_NUMEROPREIMPRESO_LOWER= "Numero Pre Impreso";
    	public static final String LABEL_NUMERODAU= "Numero Dau";
		public static final String LABEL_NUMERODAU_LOWER= "Numero Dau";
    	public static final String LABEL_NUMEROREFERENDO= "Numero Referendo";
		public static final String LABEL_NUMEROREFERENDO_LOWER= "Numero Referendo";
    	public static final String LABEL_FECHAREFERENDO= "Fecha Referendo";
		public static final String LABEL_FECHAREFERENDO_LOWER= "Fecha Referendo";
    	public static final String LABEL_AFOROREFERENDO= "Aforo Referendo";
		public static final String LABEL_AFOROREFERENDO_LOWER= "Aforo Referendo";
	
		
		
		
		
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_AUTORIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_AUTORIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_FUE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FUE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_DAU=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_DAU=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_REFERENDO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_REFERENDO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXAFORO_REFERENDO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAFORO_REFERENDO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getIngresosReferendosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(IngresosReferendosConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=IngresosReferendosConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(IngresosReferendosConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=IngresosReferendosConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(IngresosReferendosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=IngresosReferendosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(IngresosReferendosConstantesFunciones.NUMERO)) {sLabelColumna=IngresosReferendosConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(IngresosReferendosConstantesFunciones.NUMEROAUTORIZACION)) {sLabelColumna=IngresosReferendosConstantesFunciones.LABEL_NUMEROAUTORIZACION;}
		if(sNombreColumna.equals(IngresosReferendosConstantesFunciones.NUMEROFUE)) {sLabelColumna=IngresosReferendosConstantesFunciones.LABEL_NUMEROFUE;}
		if(sNombreColumna.equals(IngresosReferendosConstantesFunciones.NUMEROPREIMPRESO)) {sLabelColumna=IngresosReferendosConstantesFunciones.LABEL_NUMEROPREIMPRESO;}
		if(sNombreColumna.equals(IngresosReferendosConstantesFunciones.NUMERODAU)) {sLabelColumna=IngresosReferendosConstantesFunciones.LABEL_NUMERODAU;}
		if(sNombreColumna.equals(IngresosReferendosConstantesFunciones.NUMEROREFERENDO)) {sLabelColumna=IngresosReferendosConstantesFunciones.LABEL_NUMEROREFERENDO;}
		if(sNombreColumna.equals(IngresosReferendosConstantesFunciones.FECHAREFERENDO)) {sLabelColumna=IngresosReferendosConstantesFunciones.LABEL_FECHAREFERENDO;}
		if(sNombreColumna.equals(IngresosReferendosConstantesFunciones.AFOROREFERENDO)) {sLabelColumna=IngresosReferendosConstantesFunciones.LABEL_AFOROREFERENDO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getIngresosReferendosDescripcion(IngresosReferendos ingresosreferendos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(ingresosreferendos !=null/* && ingresosreferendos.getId()!=0*/) {
			sDescripcion=ingresosreferendos.getnombre_completo_cliente();//ingresosreferendosingresosreferendos.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getIngresosReferendosDescripcionDetallado(IngresosReferendos ingresosreferendos) {
		String sDescripcion="";
			
		sDescripcion+=IngresosReferendosConstantesFunciones.ID+"=";
		sDescripcion+=ingresosreferendos.getId().toString()+",";
		sDescripcion+=IngresosReferendosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=ingresosreferendos.getVersionRow().toString()+",";
		sDescripcion+=IngresosReferendosConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=ingresosreferendos.getfecha_emision_desde().toString()+",";
		sDescripcion+=IngresosReferendosConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=ingresosreferendos.getfecha_emision_hasta().toString()+",";
		sDescripcion+=IngresosReferendosConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=ingresosreferendos.getnombre_completo_cliente()+",";
		sDescripcion+=IngresosReferendosConstantesFunciones.NUMERO+"=";
		sDescripcion+=ingresosreferendos.getnumero()+",";
		sDescripcion+=IngresosReferendosConstantesFunciones.NUMEROAUTORIZACION+"=";
		sDescripcion+=ingresosreferendos.getnumero_autorizacion()+",";
		sDescripcion+=IngresosReferendosConstantesFunciones.NUMEROFUE+"=";
		sDescripcion+=ingresosreferendos.getnumero_fue()+",";
		sDescripcion+=IngresosReferendosConstantesFunciones.NUMEROPREIMPRESO+"=";
		sDescripcion+=ingresosreferendos.getnumero_pre_impreso()+",";
		sDescripcion+=IngresosReferendosConstantesFunciones.NUMERODAU+"=";
		sDescripcion+=ingresosreferendos.getnumero_dau()+",";
		sDescripcion+=IngresosReferendosConstantesFunciones.NUMEROREFERENDO+"=";
		sDescripcion+=ingresosreferendos.getnumero_referendo()+",";
		sDescripcion+=IngresosReferendosConstantesFunciones.FECHAREFERENDO+"=";
		sDescripcion+=ingresosreferendos.getfecha_referendo().toString()+",";
		sDescripcion+=IngresosReferendosConstantesFunciones.AFOROREFERENDO+"=";
		sDescripcion+=ingresosreferendos.getaforo_referendo()+",";
			
		return sDescripcion;
	}
	
	public static void setIngresosReferendosDescripcion(IngresosReferendos ingresosreferendos,String sValor) throws Exception {			
		if(ingresosreferendos !=null) {
			ingresosreferendos.setnombre_completo_cliente(sValor);//ingresosreferendosingresosreferendos.getId().toString();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaIngresosReferendos")) {
			sNombreIndice="Tipo=  Por Fecha Emision Desde Por Fecha Emision Hasta";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaIngresosReferendos(Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosIngresosReferendos(IngresosReferendos ingresosreferendos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ingresosreferendos.setnombre_completo_cliente(ingresosreferendos.getnombre_completo_cliente().trim());
		ingresosreferendos.setnumero(ingresosreferendos.getnumero().trim());
		ingresosreferendos.setnumero_autorizacion(ingresosreferendos.getnumero_autorizacion().trim());
		ingresosreferendos.setnumero_fue(ingresosreferendos.getnumero_fue().trim());
		ingresosreferendos.setnumero_pre_impreso(ingresosreferendos.getnumero_pre_impreso().trim());
		ingresosreferendos.setnumero_dau(ingresosreferendos.getnumero_dau().trim());
		ingresosreferendos.setnumero_referendo(ingresosreferendos.getnumero_referendo().trim());
		ingresosreferendos.setaforo_referendo(ingresosreferendos.getaforo_referendo().trim());
	}
	
	public static void quitarEspaciosIngresosReferendoss(List<IngresosReferendos> ingresosreferendoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(IngresosReferendos ingresosreferendos: ingresosreferendoss) {
			ingresosreferendos.setnombre_completo_cliente(ingresosreferendos.getnombre_completo_cliente().trim());
			ingresosreferendos.setnumero(ingresosreferendos.getnumero().trim());
			ingresosreferendos.setnumero_autorizacion(ingresosreferendos.getnumero_autorizacion().trim());
			ingresosreferendos.setnumero_fue(ingresosreferendos.getnumero_fue().trim());
			ingresosreferendos.setnumero_pre_impreso(ingresosreferendos.getnumero_pre_impreso().trim());
			ingresosreferendos.setnumero_dau(ingresosreferendos.getnumero_dau().trim());
			ingresosreferendos.setnumero_referendo(ingresosreferendos.getnumero_referendo().trim());
			ingresosreferendos.setaforo_referendo(ingresosreferendos.getaforo_referendo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresIngresosReferendos(IngresosReferendos ingresosreferendos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && ingresosreferendos.getConCambioAuxiliar()) {
			ingresosreferendos.setIsDeleted(ingresosreferendos.getIsDeletedAuxiliar());	
			ingresosreferendos.setIsNew(ingresosreferendos.getIsNewAuxiliar());	
			ingresosreferendos.setIsChanged(ingresosreferendos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			ingresosreferendos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			ingresosreferendos.setIsDeletedAuxiliar(false);	
			ingresosreferendos.setIsNewAuxiliar(false);	
			ingresosreferendos.setIsChangedAuxiliar(false);
			
			ingresosreferendos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresIngresosReferendoss(List<IngresosReferendos> ingresosreferendoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(IngresosReferendos ingresosreferendos : ingresosreferendoss) {
			if(conAsignarBase && ingresosreferendos.getConCambioAuxiliar()) {
				ingresosreferendos.setIsDeleted(ingresosreferendos.getIsDeletedAuxiliar());	
				ingresosreferendos.setIsNew(ingresosreferendos.getIsNewAuxiliar());	
				ingresosreferendos.setIsChanged(ingresosreferendos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				ingresosreferendos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				ingresosreferendos.setIsDeletedAuxiliar(false);	
				ingresosreferendos.setIsNewAuxiliar(false);	
				ingresosreferendos.setIsChangedAuxiliar(false);
				
				ingresosreferendos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresIngresosReferendos(IngresosReferendos ingresosreferendos,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresIngresosReferendoss(List<IngresosReferendos> ingresosreferendoss,Boolean conEnteros) throws Exception  {
		
		for(IngresosReferendos ingresosreferendos: ingresosreferendoss) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaIngresosReferendos(List<IngresosReferendos> ingresosreferendoss,IngresosReferendos ingresosreferendosAux) throws Exception  {
		IngresosReferendosConstantesFunciones.InicializarValoresIngresosReferendos(ingresosreferendosAux,true);
		
		for(IngresosReferendos ingresosreferendos: ingresosreferendoss) {
			if(ingresosreferendos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesIngresosReferendos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=IngresosReferendosConstantesFunciones.getArrayColumnasGlobalesIngresosReferendos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesIngresosReferendos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoIngresosReferendos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<IngresosReferendos> ingresosreferendoss,IngresosReferendos ingresosreferendos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(IngresosReferendos ingresosreferendosAux: ingresosreferendoss) {
			if(ingresosreferendosAux!=null && ingresosreferendos!=null) {
				if((ingresosreferendosAux.getId()==null && ingresosreferendos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(ingresosreferendosAux.getId()!=null && ingresosreferendos.getId()!=null){
					if(ingresosreferendosAux.getId().equals(ingresosreferendos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaIngresosReferendos(List<IngresosReferendos> ingresosreferendoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(IngresosReferendos ingresosreferendos: ingresosreferendoss) {			
			if(ingresosreferendos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaIngresosReferendos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,IngresosReferendosConstantesFunciones.LABEL_ID, IngresosReferendosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngresosReferendosConstantesFunciones.LABEL_VERSIONROW, IngresosReferendosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngresosReferendosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE, IngresosReferendosConstantesFunciones.NOMBRECOMPLETOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngresosReferendosConstantesFunciones.LABEL_NUMERO, IngresosReferendosConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngresosReferendosConstantesFunciones.LABEL_NUMEROAUTORIZACION, IngresosReferendosConstantesFunciones.NUMEROAUTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngresosReferendosConstantesFunciones.LABEL_NUMEROFUE, IngresosReferendosConstantesFunciones.NUMEROFUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngresosReferendosConstantesFunciones.LABEL_NUMEROPREIMPRESO, IngresosReferendosConstantesFunciones.NUMEROPREIMPRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngresosReferendosConstantesFunciones.LABEL_NUMERODAU, IngresosReferendosConstantesFunciones.NUMERODAU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngresosReferendosConstantesFunciones.LABEL_NUMEROREFERENDO, IngresosReferendosConstantesFunciones.NUMEROREFERENDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngresosReferendosConstantesFunciones.LABEL_FECHAREFERENDO, IngresosReferendosConstantesFunciones.FECHAREFERENDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngresosReferendosConstantesFunciones.LABEL_AFOROREFERENDO, IngresosReferendosConstantesFunciones.AFOROREFERENDO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasIngresosReferendos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=IngresosReferendosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngresosReferendosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngresosReferendosConstantesFunciones.NOMBRECOMPLETOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngresosReferendosConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngresosReferendosConstantesFunciones.NUMEROAUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngresosReferendosConstantesFunciones.NUMEROFUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngresosReferendosConstantesFunciones.NUMEROPREIMPRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngresosReferendosConstantesFunciones.NUMERODAU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngresosReferendosConstantesFunciones.NUMEROREFERENDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngresosReferendosConstantesFunciones.FECHAREFERENDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngresosReferendosConstantesFunciones.AFOROREFERENDO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarIngresosReferendos() throws Exception  {
		return IngresosReferendosConstantesFunciones.getTiposSeleccionarIngresosReferendos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarIngresosReferendos(Boolean conFk) throws Exception  {
		return IngresosReferendosConstantesFunciones.getTiposSeleccionarIngresosReferendos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarIngresosReferendos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IngresosReferendosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(IngresosReferendosConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IngresosReferendosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(IngresosReferendosConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IngresosReferendosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(IngresosReferendosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IngresosReferendosConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(IngresosReferendosConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IngresosReferendosConstantesFunciones.LABEL_NUMEROAUTORIZACION);
			reporte.setsDescripcion(IngresosReferendosConstantesFunciones.LABEL_NUMEROAUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IngresosReferendosConstantesFunciones.LABEL_NUMEROFUE);
			reporte.setsDescripcion(IngresosReferendosConstantesFunciones.LABEL_NUMEROFUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IngresosReferendosConstantesFunciones.LABEL_NUMEROPREIMPRESO);
			reporte.setsDescripcion(IngresosReferendosConstantesFunciones.LABEL_NUMEROPREIMPRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IngresosReferendosConstantesFunciones.LABEL_NUMERODAU);
			reporte.setsDescripcion(IngresosReferendosConstantesFunciones.LABEL_NUMERODAU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IngresosReferendosConstantesFunciones.LABEL_NUMEROREFERENDO);
			reporte.setsDescripcion(IngresosReferendosConstantesFunciones.LABEL_NUMEROREFERENDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IngresosReferendosConstantesFunciones.LABEL_FECHAREFERENDO);
			reporte.setsDescripcion(IngresosReferendosConstantesFunciones.LABEL_FECHAREFERENDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IngresosReferendosConstantesFunciones.LABEL_AFOROREFERENDO);
			reporte.setsDescripcion(IngresosReferendosConstantesFunciones.LABEL_AFOROREFERENDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesIngresosReferendos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesIngresosReferendos(IngresosReferendos ingresosreferendosAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesIngresosReferendos(List<IngresosReferendos> ingresosreferendossTemp) throws Exception {
		for(IngresosReferendos ingresosreferendosAux:ingresosreferendossTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfIngresosReferendos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfIngresosReferendos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfIngresosReferendos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return IngresosReferendosConstantesFunciones.getClassesRelationshipsOfIngresosReferendos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfIngresosReferendos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfIngresosReferendos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return IngresosReferendosConstantesFunciones.getClassesRelationshipsFromStringsOfIngresosReferendos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfIngresosReferendos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(IngresosReferendos ingresosreferendos,List<IngresosReferendos> ingresosreferendoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(IngresosReferendos ingresosreferendos,List<IngresosReferendos> ingresosreferendoss) throws Exception {
		try	{			
			for(IngresosReferendos ingresosreferendosLocal:ingresosreferendoss) {
				if(ingresosreferendosLocal.getId().equals(ingresosreferendos.getId())) {
					ingresosreferendosLocal.setIsSelected(ingresosreferendos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesIngresosReferendos(List<IngresosReferendos> ingresosreferendossAux) throws Exception {
		//this.ingresosreferendossAux=ingresosreferendossAux;
		
		for(IngresosReferendos ingresosreferendosAux:ingresosreferendossAux) {
			if(ingresosreferendosAux.getIsChanged()) {
				ingresosreferendosAux.setIsChanged(false);
			}		
			
			if(ingresosreferendosAux.getIsNew()) {
				ingresosreferendosAux.setIsNew(false);
			}	
			
			if(ingresosreferendosAux.getIsDeleted()) {
				ingresosreferendosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesIngresosReferendos(IngresosReferendos ingresosreferendosAux) throws Exception {
		//this.ingresosreferendosAux=ingresosreferendosAux;
		
			if(ingresosreferendosAux.getIsChanged()) {
				ingresosreferendosAux.setIsChanged(false);
			}		
			
			if(ingresosreferendosAux.getIsNew()) {
				ingresosreferendosAux.setIsNew(false);
			}	
			
			if(ingresosreferendosAux.getIsDeleted()) {
				ingresosreferendosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(IngresosReferendos ingresosreferendosAsignar,IngresosReferendos ingresosreferendos) throws Exception {
		ingresosreferendosAsignar.setId(ingresosreferendos.getId());	
		ingresosreferendosAsignar.setVersionRow(ingresosreferendos.getVersionRow());	
		ingresosreferendosAsignar.setnombre_completo_cliente(ingresosreferendos.getnombre_completo_cliente());	
		ingresosreferendosAsignar.setnumero(ingresosreferendos.getnumero());	
		ingresosreferendosAsignar.setnumero_autorizacion(ingresosreferendos.getnumero_autorizacion());	
		ingresosreferendosAsignar.setnumero_fue(ingresosreferendos.getnumero_fue());	
		ingresosreferendosAsignar.setnumero_pre_impreso(ingresosreferendos.getnumero_pre_impreso());	
		ingresosreferendosAsignar.setnumero_dau(ingresosreferendos.getnumero_dau());	
		ingresosreferendosAsignar.setnumero_referendo(ingresosreferendos.getnumero_referendo());	
		ingresosreferendosAsignar.setfecha_referendo(ingresosreferendos.getfecha_referendo());	
		ingresosreferendosAsignar.setaforo_referendo(ingresosreferendos.getaforo_referendo());	
	}
	
	public static void inicializarIngresosReferendos(IngresosReferendos ingresosreferendos) throws Exception {
		try {
				ingresosreferendos.setId(0L);	
					
				ingresosreferendos.setnombre_completo_cliente("");	
				ingresosreferendos.setnumero("");	
				ingresosreferendos.setnumero_autorizacion("");	
				ingresosreferendos.setnumero_fue("");	
				ingresosreferendos.setnumero_pre_impreso("");	
				ingresosreferendos.setnumero_dau("");	
				ingresosreferendos.setnumero_referendo("");	
				ingresosreferendos.setfecha_referendo(new Date());	
				ingresosreferendos.setaforo_referendo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderIngresosReferendos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(IngresosReferendosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngresosReferendosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngresosReferendosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngresosReferendosConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngresosReferendosConstantesFunciones.LABEL_NUMEROAUTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngresosReferendosConstantesFunciones.LABEL_NUMEROFUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngresosReferendosConstantesFunciones.LABEL_NUMEROPREIMPRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngresosReferendosConstantesFunciones.LABEL_NUMERODAU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngresosReferendosConstantesFunciones.LABEL_NUMEROREFERENDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngresosReferendosConstantesFunciones.LABEL_FECHAREFERENDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngresosReferendosConstantesFunciones.LABEL_AFOROREFERENDO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataIngresosReferendos(String sTipo,Row row,Workbook workbook,IngresosReferendos ingresosreferendos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(ingresosreferendos.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingresosreferendos.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingresosreferendos.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingresosreferendos.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingresosreferendos.getnumero_autorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingresosreferendos.getnumero_fue());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingresosreferendos.getnumero_pre_impreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingresosreferendos.getnumero_dau());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingresosreferendos.getnumero_referendo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingresosreferendos.getfecha_referendo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingresosreferendos.getaforo_referendo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryIngresosReferendos="";
	
	public String getsFinalQueryIngresosReferendos() {
		return this.sFinalQueryIngresosReferendos;
	}
	
	public void setsFinalQueryIngresosReferendos(String sFinalQueryIngresosReferendos) {
		this.sFinalQueryIngresosReferendos= sFinalQueryIngresosReferendos;
	}
	
	public Border resaltarSeleccionarIngresosReferendos=null;
	
	public Border setResaltarSeleccionarIngresosReferendos(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosReferendosBeanSwingJInternalFrame ingresosreferendosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//ingresosreferendosBeanSwingJInternalFrame.jTtoolBarIngresosReferendos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarIngresosReferendos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarIngresosReferendos() {
		return this.resaltarSeleccionarIngresosReferendos;
	}
	
	public void setResaltarSeleccionarIngresosReferendos(Border borderResaltarSeleccionarIngresosReferendos) {
		this.resaltarSeleccionarIngresosReferendos= borderResaltarSeleccionarIngresosReferendos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridIngresosReferendos=null;
	public Boolean mostraridIngresosReferendos=true;
	public Boolean activaridIngresosReferendos=true;

	public Border resaltarfecha_emision_desdeIngresosReferendos=null;
	public Boolean mostrarfecha_emision_desdeIngresosReferendos=true;
	public Boolean activarfecha_emision_desdeIngresosReferendos=true;

	public Border resaltarfecha_emision_hastaIngresosReferendos=null;
	public Boolean mostrarfecha_emision_hastaIngresosReferendos=true;
	public Boolean activarfecha_emision_hastaIngresosReferendos=true;

	public Border resaltarnombre_completo_clienteIngresosReferendos=null;
	public Boolean mostrarnombre_completo_clienteIngresosReferendos=true;
	public Boolean activarnombre_completo_clienteIngresosReferendos=true;

	public Border resaltarnumeroIngresosReferendos=null;
	public Boolean mostrarnumeroIngresosReferendos=true;
	public Boolean activarnumeroIngresosReferendos=true;

	public Border resaltarnumero_autorizacionIngresosReferendos=null;
	public Boolean mostrarnumero_autorizacionIngresosReferendos=true;
	public Boolean activarnumero_autorizacionIngresosReferendos=true;

	public Border resaltarnumero_fueIngresosReferendos=null;
	public Boolean mostrarnumero_fueIngresosReferendos=true;
	public Boolean activarnumero_fueIngresosReferendos=true;

	public Border resaltarnumero_pre_impresoIngresosReferendos=null;
	public Boolean mostrarnumero_pre_impresoIngresosReferendos=true;
	public Boolean activarnumero_pre_impresoIngresosReferendos=true;

	public Border resaltarnumero_dauIngresosReferendos=null;
	public Boolean mostrarnumero_dauIngresosReferendos=true;
	public Boolean activarnumero_dauIngresosReferendos=true;

	public Border resaltarnumero_referendoIngresosReferendos=null;
	public Boolean mostrarnumero_referendoIngresosReferendos=true;
	public Boolean activarnumero_referendoIngresosReferendos=true;

	public Border resaltarfecha_referendoIngresosReferendos=null;
	public Boolean mostrarfecha_referendoIngresosReferendos=true;
	public Boolean activarfecha_referendoIngresosReferendos=true;

	public Border resaltaraforo_referendoIngresosReferendos=null;
	public Boolean mostraraforo_referendoIngresosReferendos=true;
	public Boolean activaraforo_referendoIngresosReferendos=true;

	
	

	public Border setResaltaridIngresosReferendos(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosReferendosBeanSwingJInternalFrame ingresosreferendosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresosreferendosBeanSwingJInternalFrame.jTtoolBarIngresosReferendos.setBorder(borderResaltar);
		
		this.resaltaridIngresosReferendos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridIngresosReferendos() {
		return this.resaltaridIngresosReferendos;
	}

	public void setResaltaridIngresosReferendos(Border borderResaltar) {
		this.resaltaridIngresosReferendos= borderResaltar;
	}

	public Boolean getMostraridIngresosReferendos() {
		return this.mostraridIngresosReferendos;
	}

	public void setMostraridIngresosReferendos(Boolean mostraridIngresosReferendos) {
		this.mostraridIngresosReferendos= mostraridIngresosReferendos;
	}

	public Boolean getActivaridIngresosReferendos() {
		return this.activaridIngresosReferendos;
	}

	public void setActivaridIngresosReferendos(Boolean activaridIngresosReferendos) {
		this.activaridIngresosReferendos= activaridIngresosReferendos;
	}

	public Border setResaltarfecha_emision_desdeIngresosReferendos(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosReferendosBeanSwingJInternalFrame ingresosreferendosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresosreferendosBeanSwingJInternalFrame.jTtoolBarIngresosReferendos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeIngresosReferendos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeIngresosReferendos() {
		return this.resaltarfecha_emision_desdeIngresosReferendos;
	}

	public void setResaltarfecha_emision_desdeIngresosReferendos(Border borderResaltar) {
		this.resaltarfecha_emision_desdeIngresosReferendos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeIngresosReferendos() {
		return this.mostrarfecha_emision_desdeIngresosReferendos;
	}

	public void setMostrarfecha_emision_desdeIngresosReferendos(Boolean mostrarfecha_emision_desdeIngresosReferendos) {
		this.mostrarfecha_emision_desdeIngresosReferendos= mostrarfecha_emision_desdeIngresosReferendos;
	}

	public Boolean getActivarfecha_emision_desdeIngresosReferendos() {
		return this.activarfecha_emision_desdeIngresosReferendos;
	}

	public void setActivarfecha_emision_desdeIngresosReferendos(Boolean activarfecha_emision_desdeIngresosReferendos) {
		this.activarfecha_emision_desdeIngresosReferendos= activarfecha_emision_desdeIngresosReferendos;
	}

	public Border setResaltarfecha_emision_hastaIngresosReferendos(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosReferendosBeanSwingJInternalFrame ingresosreferendosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresosreferendosBeanSwingJInternalFrame.jTtoolBarIngresosReferendos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaIngresosReferendos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaIngresosReferendos() {
		return this.resaltarfecha_emision_hastaIngresosReferendos;
	}

	public void setResaltarfecha_emision_hastaIngresosReferendos(Border borderResaltar) {
		this.resaltarfecha_emision_hastaIngresosReferendos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaIngresosReferendos() {
		return this.mostrarfecha_emision_hastaIngresosReferendos;
	}

	public void setMostrarfecha_emision_hastaIngresosReferendos(Boolean mostrarfecha_emision_hastaIngresosReferendos) {
		this.mostrarfecha_emision_hastaIngresosReferendos= mostrarfecha_emision_hastaIngresosReferendos;
	}

	public Boolean getActivarfecha_emision_hastaIngresosReferendos() {
		return this.activarfecha_emision_hastaIngresosReferendos;
	}

	public void setActivarfecha_emision_hastaIngresosReferendos(Boolean activarfecha_emision_hastaIngresosReferendos) {
		this.activarfecha_emision_hastaIngresosReferendos= activarfecha_emision_hastaIngresosReferendos;
	}

	public Border setResaltarnombre_completo_clienteIngresosReferendos(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosReferendosBeanSwingJInternalFrame ingresosreferendosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresosreferendosBeanSwingJInternalFrame.jTtoolBarIngresosReferendos.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clienteIngresosReferendos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clienteIngresosReferendos() {
		return this.resaltarnombre_completo_clienteIngresosReferendos;
	}

	public void setResaltarnombre_completo_clienteIngresosReferendos(Border borderResaltar) {
		this.resaltarnombre_completo_clienteIngresosReferendos= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clienteIngresosReferendos() {
		return this.mostrarnombre_completo_clienteIngresosReferendos;
	}

	public void setMostrarnombre_completo_clienteIngresosReferendos(Boolean mostrarnombre_completo_clienteIngresosReferendos) {
		this.mostrarnombre_completo_clienteIngresosReferendos= mostrarnombre_completo_clienteIngresosReferendos;
	}

	public Boolean getActivarnombre_completo_clienteIngresosReferendos() {
		return this.activarnombre_completo_clienteIngresosReferendos;
	}

	public void setActivarnombre_completo_clienteIngresosReferendos(Boolean activarnombre_completo_clienteIngresosReferendos) {
		this.activarnombre_completo_clienteIngresosReferendos= activarnombre_completo_clienteIngresosReferendos;
	}

	public Border setResaltarnumeroIngresosReferendos(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosReferendosBeanSwingJInternalFrame ingresosreferendosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresosreferendosBeanSwingJInternalFrame.jTtoolBarIngresosReferendos.setBorder(borderResaltar);
		
		this.resaltarnumeroIngresosReferendos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroIngresosReferendos() {
		return this.resaltarnumeroIngresosReferendos;
	}

	public void setResaltarnumeroIngresosReferendos(Border borderResaltar) {
		this.resaltarnumeroIngresosReferendos= borderResaltar;
	}

	public Boolean getMostrarnumeroIngresosReferendos() {
		return this.mostrarnumeroIngresosReferendos;
	}

	public void setMostrarnumeroIngresosReferendos(Boolean mostrarnumeroIngresosReferendos) {
		this.mostrarnumeroIngresosReferendos= mostrarnumeroIngresosReferendos;
	}

	public Boolean getActivarnumeroIngresosReferendos() {
		return this.activarnumeroIngresosReferendos;
	}

	public void setActivarnumeroIngresosReferendos(Boolean activarnumeroIngresosReferendos) {
		this.activarnumeroIngresosReferendos= activarnumeroIngresosReferendos;
	}

	public Border setResaltarnumero_autorizacionIngresosReferendos(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosReferendosBeanSwingJInternalFrame ingresosreferendosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresosreferendosBeanSwingJInternalFrame.jTtoolBarIngresosReferendos.setBorder(borderResaltar);
		
		this.resaltarnumero_autorizacionIngresosReferendos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_autorizacionIngresosReferendos() {
		return this.resaltarnumero_autorizacionIngresosReferendos;
	}

	public void setResaltarnumero_autorizacionIngresosReferendos(Border borderResaltar) {
		this.resaltarnumero_autorizacionIngresosReferendos= borderResaltar;
	}

	public Boolean getMostrarnumero_autorizacionIngresosReferendos() {
		return this.mostrarnumero_autorizacionIngresosReferendos;
	}

	public void setMostrarnumero_autorizacionIngresosReferendos(Boolean mostrarnumero_autorizacionIngresosReferendos) {
		this.mostrarnumero_autorizacionIngresosReferendos= mostrarnumero_autorizacionIngresosReferendos;
	}

	public Boolean getActivarnumero_autorizacionIngresosReferendos() {
		return this.activarnumero_autorizacionIngresosReferendos;
	}

	public void setActivarnumero_autorizacionIngresosReferendos(Boolean activarnumero_autorizacionIngresosReferendos) {
		this.activarnumero_autorizacionIngresosReferendos= activarnumero_autorizacionIngresosReferendos;
	}

	public Border setResaltarnumero_fueIngresosReferendos(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosReferendosBeanSwingJInternalFrame ingresosreferendosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresosreferendosBeanSwingJInternalFrame.jTtoolBarIngresosReferendos.setBorder(borderResaltar);
		
		this.resaltarnumero_fueIngresosReferendos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_fueIngresosReferendos() {
		return this.resaltarnumero_fueIngresosReferendos;
	}

	public void setResaltarnumero_fueIngresosReferendos(Border borderResaltar) {
		this.resaltarnumero_fueIngresosReferendos= borderResaltar;
	}

	public Boolean getMostrarnumero_fueIngresosReferendos() {
		return this.mostrarnumero_fueIngresosReferendos;
	}

	public void setMostrarnumero_fueIngresosReferendos(Boolean mostrarnumero_fueIngresosReferendos) {
		this.mostrarnumero_fueIngresosReferendos= mostrarnumero_fueIngresosReferendos;
	}

	public Boolean getActivarnumero_fueIngresosReferendos() {
		return this.activarnumero_fueIngresosReferendos;
	}

	public void setActivarnumero_fueIngresosReferendos(Boolean activarnumero_fueIngresosReferendos) {
		this.activarnumero_fueIngresosReferendos= activarnumero_fueIngresosReferendos;
	}

	public Border setResaltarnumero_pre_impresoIngresosReferendos(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosReferendosBeanSwingJInternalFrame ingresosreferendosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresosreferendosBeanSwingJInternalFrame.jTtoolBarIngresosReferendos.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impresoIngresosReferendos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impresoIngresosReferendos() {
		return this.resaltarnumero_pre_impresoIngresosReferendos;
	}

	public void setResaltarnumero_pre_impresoIngresosReferendos(Border borderResaltar) {
		this.resaltarnumero_pre_impresoIngresosReferendos= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impresoIngresosReferendos() {
		return this.mostrarnumero_pre_impresoIngresosReferendos;
	}

	public void setMostrarnumero_pre_impresoIngresosReferendos(Boolean mostrarnumero_pre_impresoIngresosReferendos) {
		this.mostrarnumero_pre_impresoIngresosReferendos= mostrarnumero_pre_impresoIngresosReferendos;
	}

	public Boolean getActivarnumero_pre_impresoIngresosReferendos() {
		return this.activarnumero_pre_impresoIngresosReferendos;
	}

	public void setActivarnumero_pre_impresoIngresosReferendos(Boolean activarnumero_pre_impresoIngresosReferendos) {
		this.activarnumero_pre_impresoIngresosReferendos= activarnumero_pre_impresoIngresosReferendos;
	}

	public Border setResaltarnumero_dauIngresosReferendos(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosReferendosBeanSwingJInternalFrame ingresosreferendosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresosreferendosBeanSwingJInternalFrame.jTtoolBarIngresosReferendos.setBorder(borderResaltar);
		
		this.resaltarnumero_dauIngresosReferendos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_dauIngresosReferendos() {
		return this.resaltarnumero_dauIngresosReferendos;
	}

	public void setResaltarnumero_dauIngresosReferendos(Border borderResaltar) {
		this.resaltarnumero_dauIngresosReferendos= borderResaltar;
	}

	public Boolean getMostrarnumero_dauIngresosReferendos() {
		return this.mostrarnumero_dauIngresosReferendos;
	}

	public void setMostrarnumero_dauIngresosReferendos(Boolean mostrarnumero_dauIngresosReferendos) {
		this.mostrarnumero_dauIngresosReferendos= mostrarnumero_dauIngresosReferendos;
	}

	public Boolean getActivarnumero_dauIngresosReferendos() {
		return this.activarnumero_dauIngresosReferendos;
	}

	public void setActivarnumero_dauIngresosReferendos(Boolean activarnumero_dauIngresosReferendos) {
		this.activarnumero_dauIngresosReferendos= activarnumero_dauIngresosReferendos;
	}

	public Border setResaltarnumero_referendoIngresosReferendos(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosReferendosBeanSwingJInternalFrame ingresosreferendosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresosreferendosBeanSwingJInternalFrame.jTtoolBarIngresosReferendos.setBorder(borderResaltar);
		
		this.resaltarnumero_referendoIngresosReferendos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_referendoIngresosReferendos() {
		return this.resaltarnumero_referendoIngresosReferendos;
	}

	public void setResaltarnumero_referendoIngresosReferendos(Border borderResaltar) {
		this.resaltarnumero_referendoIngresosReferendos= borderResaltar;
	}

	public Boolean getMostrarnumero_referendoIngresosReferendos() {
		return this.mostrarnumero_referendoIngresosReferendos;
	}

	public void setMostrarnumero_referendoIngresosReferendos(Boolean mostrarnumero_referendoIngresosReferendos) {
		this.mostrarnumero_referendoIngresosReferendos= mostrarnumero_referendoIngresosReferendos;
	}

	public Boolean getActivarnumero_referendoIngresosReferendos() {
		return this.activarnumero_referendoIngresosReferendos;
	}

	public void setActivarnumero_referendoIngresosReferendos(Boolean activarnumero_referendoIngresosReferendos) {
		this.activarnumero_referendoIngresosReferendos= activarnumero_referendoIngresosReferendos;
	}

	public Border setResaltarfecha_referendoIngresosReferendos(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosReferendosBeanSwingJInternalFrame ingresosreferendosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresosreferendosBeanSwingJInternalFrame.jTtoolBarIngresosReferendos.setBorder(borderResaltar);
		
		this.resaltarfecha_referendoIngresosReferendos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_referendoIngresosReferendos() {
		return this.resaltarfecha_referendoIngresosReferendos;
	}

	public void setResaltarfecha_referendoIngresosReferendos(Border borderResaltar) {
		this.resaltarfecha_referendoIngresosReferendos= borderResaltar;
	}

	public Boolean getMostrarfecha_referendoIngresosReferendos() {
		return this.mostrarfecha_referendoIngresosReferendos;
	}

	public void setMostrarfecha_referendoIngresosReferendos(Boolean mostrarfecha_referendoIngresosReferendos) {
		this.mostrarfecha_referendoIngresosReferendos= mostrarfecha_referendoIngresosReferendos;
	}

	public Boolean getActivarfecha_referendoIngresosReferendos() {
		return this.activarfecha_referendoIngresosReferendos;
	}

	public void setActivarfecha_referendoIngresosReferendos(Boolean activarfecha_referendoIngresosReferendos) {
		this.activarfecha_referendoIngresosReferendos= activarfecha_referendoIngresosReferendos;
	}

	public Border setResaltaraforo_referendoIngresosReferendos(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosReferendosBeanSwingJInternalFrame ingresosreferendosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingresosreferendosBeanSwingJInternalFrame.jTtoolBarIngresosReferendos.setBorder(borderResaltar);
		
		this.resaltaraforo_referendoIngresosReferendos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaraforo_referendoIngresosReferendos() {
		return this.resaltaraforo_referendoIngresosReferendos;
	}

	public void setResaltaraforo_referendoIngresosReferendos(Border borderResaltar) {
		this.resaltaraforo_referendoIngresosReferendos= borderResaltar;
	}

	public Boolean getMostraraforo_referendoIngresosReferendos() {
		return this.mostraraforo_referendoIngresosReferendos;
	}

	public void setMostraraforo_referendoIngresosReferendos(Boolean mostraraforo_referendoIngresosReferendos) {
		this.mostraraforo_referendoIngresosReferendos= mostraraforo_referendoIngresosReferendos;
	}

	public Boolean getActivaraforo_referendoIngresosReferendos() {
		return this.activaraforo_referendoIngresosReferendos;
	}

	public void setActivaraforo_referendoIngresosReferendos(Boolean activaraforo_referendoIngresosReferendos) {
		this.activaraforo_referendoIngresosReferendos= activaraforo_referendoIngresosReferendos;
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
		
		
		this.setMostraridIngresosReferendos(esInicial);
		this.setMostrarfecha_emision_desdeIngresosReferendos(esInicial);
		this.setMostrarfecha_emision_hastaIngresosReferendos(esInicial);
		this.setMostrarnombre_completo_clienteIngresosReferendos(esInicial);
		this.setMostrarnumeroIngresosReferendos(esInicial);
		this.setMostrarnumero_autorizacionIngresosReferendos(esInicial);
		this.setMostrarnumero_fueIngresosReferendos(esInicial);
		this.setMostrarnumero_pre_impresoIngresosReferendos(esInicial);
		this.setMostrarnumero_dauIngresosReferendos(esInicial);
		this.setMostrarnumero_referendoIngresosReferendos(esInicial);
		this.setMostrarfecha_referendoIngresosReferendos(esInicial);
		this.setMostraraforo_referendoIngresosReferendos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.ID)) {
				this.setMostraridIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clienteIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setMostrarnumero_autorizacionIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.NUMEROFUE)) {
				this.setMostrarnumero_fueIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setMostrarnumero_pre_impresoIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.NUMERODAU)) {
				this.setMostrarnumero_dauIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.NUMEROREFERENDO)) {
				this.setMostrarnumero_referendoIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.FECHAREFERENDO)) {
				this.setMostrarfecha_referendoIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.AFOROREFERENDO)) {
				this.setMostraraforo_referendoIngresosReferendos(esAsigna);
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
		
		
		this.setActivaridIngresosReferendos(esInicial);
		this.setActivarfecha_emision_desdeIngresosReferendos(esInicial);
		this.setActivarfecha_emision_hastaIngresosReferendos(esInicial);
		this.setActivarnombre_completo_clienteIngresosReferendos(esInicial);
		this.setActivarnumeroIngresosReferendos(esInicial);
		this.setActivarnumero_autorizacionIngresosReferendos(esInicial);
		this.setActivarnumero_fueIngresosReferendos(esInicial);
		this.setActivarnumero_pre_impresoIngresosReferendos(esInicial);
		this.setActivarnumero_dauIngresosReferendos(esInicial);
		this.setActivarnumero_referendoIngresosReferendos(esInicial);
		this.setActivarfecha_referendoIngresosReferendos(esInicial);
		this.setActivaraforo_referendoIngresosReferendos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.ID)) {
				this.setActivaridIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clienteIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.NUMERO)) {
				this.setActivarnumeroIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setActivarnumero_autorizacionIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.NUMEROFUE)) {
				this.setActivarnumero_fueIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setActivarnumero_pre_impresoIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.NUMERODAU)) {
				this.setActivarnumero_dauIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.NUMEROREFERENDO)) {
				this.setActivarnumero_referendoIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.FECHAREFERENDO)) {
				this.setActivarfecha_referendoIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.AFOROREFERENDO)) {
				this.setActivaraforo_referendoIngresosReferendos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,IngresosReferendosBeanSwingJInternalFrame ingresosreferendosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridIngresosReferendos(esInicial);
		this.setResaltarfecha_emision_desdeIngresosReferendos(esInicial);
		this.setResaltarfecha_emision_hastaIngresosReferendos(esInicial);
		this.setResaltarnombre_completo_clienteIngresosReferendos(esInicial);
		this.setResaltarnumeroIngresosReferendos(esInicial);
		this.setResaltarnumero_autorizacionIngresosReferendos(esInicial);
		this.setResaltarnumero_fueIngresosReferendos(esInicial);
		this.setResaltarnumero_pre_impresoIngresosReferendos(esInicial);
		this.setResaltarnumero_dauIngresosReferendos(esInicial);
		this.setResaltarnumero_referendoIngresosReferendos(esInicial);
		this.setResaltarfecha_referendoIngresosReferendos(esInicial);
		this.setResaltaraforo_referendoIngresosReferendos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.ID)) {
				this.setResaltaridIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clienteIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setResaltarnumero_autorizacionIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.NUMEROFUE)) {
				this.setResaltarnumero_fueIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setResaltarnumero_pre_impresoIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.NUMERODAU)) {
				this.setResaltarnumero_dauIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.NUMEROREFERENDO)) {
				this.setResaltarnumero_referendoIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.FECHAREFERENDO)) {
				this.setResaltarfecha_referendoIngresosReferendos(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngresosReferendosConstantesFunciones.AFOROREFERENDO)) {
				this.setResaltaraforo_referendoIngresosReferendos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,IngresosReferendosBeanSwingJInternalFrame ingresosreferendosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaIngresosReferendosIngresosReferendos=true;

	public Boolean getMostrarBusquedaIngresosReferendosIngresosReferendos() {
		return this.mostrarBusquedaIngresosReferendosIngresosReferendos;
	}

	public void setMostrarBusquedaIngresosReferendosIngresosReferendos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaIngresosReferendosIngresosReferendos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaIngresosReferendosIngresosReferendos=true;

	public Boolean getActivarBusquedaIngresosReferendosIngresosReferendos() {
		return this.activarBusquedaIngresosReferendosIngresosReferendos;
	}

	public void setActivarBusquedaIngresosReferendosIngresosReferendos(Boolean habilitarResaltar) {
		this.activarBusquedaIngresosReferendosIngresosReferendos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaIngresosReferendosIngresosReferendos=null;

	public Border getResaltarBusquedaIngresosReferendosIngresosReferendos() {
		return this.resaltarBusquedaIngresosReferendosIngresosReferendos;
	}

	public void setResaltarBusquedaIngresosReferendosIngresosReferendos(Border borderResaltar) {
		this.resaltarBusquedaIngresosReferendosIngresosReferendos= borderResaltar;
	}

	public void setResaltarBusquedaIngresosReferendosIngresosReferendos(ParametroGeneralUsuario parametroGeneralUsuario/*IngresosReferendosBeanSwingJInternalFrame ingresosreferendosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaIngresosReferendosIngresosReferendos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}