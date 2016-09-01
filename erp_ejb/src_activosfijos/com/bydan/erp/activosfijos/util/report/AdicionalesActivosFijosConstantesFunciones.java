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
package com.bydan.erp.activosfijos.util.report;

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


import com.bydan.erp.activosfijos.util.report.AdicionalesActivosFijosConstantesFunciones;
import com.bydan.erp.activosfijos.util.report.AdicionalesActivosFijosParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.AdicionalesActivosFijosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class AdicionalesActivosFijosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="AdicionalesActivosFijos";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="AdicionalesActivosFijos"+AdicionalesActivosFijosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AdicionalesActivosFijosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AdicionalesActivosFijosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AdicionalesActivosFijosConstantesFunciones.SCHEMA+"_"+AdicionalesActivosFijosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AdicionalesActivosFijosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AdicionalesActivosFijosConstantesFunciones.SCHEMA+"_"+AdicionalesActivosFijosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AdicionalesActivosFijosConstantesFunciones.SCHEMA+"_"+AdicionalesActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AdicionalesActivosFijosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AdicionalesActivosFijosConstantesFunciones.SCHEMA+"_"+AdicionalesActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AdicionalesActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AdicionalesActivosFijosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AdicionalesActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AdicionalesActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AdicionalesActivosFijosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AdicionalesActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AdicionalesActivosFijosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AdicionalesActivosFijosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AdicionalesActivosFijosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AdicionalesActivosFijosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Adicionales Activos Fijoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Adicionales Activos Fijos";
	public static final String SCLASSWEBTITULO_LOWER="Adicionales Activos Fijos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="AdicionalesActivosFijos";
	public static final String OBJECTNAME="adicionalesactivosfijos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="adicionales_activos_fijos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select adicionalesactivosfijos from "+AdicionalesActivosFijosConstantesFunciones.SPERSISTENCENAME+" adicionalesactivosfijos";
	public static String QUERYSELECTNATIVE="select "+AdicionalesActivosFijosConstantesFunciones.SCHEMA+"."+AdicionalesActivosFijosConstantesFunciones.TABLENAME+".id,"+AdicionalesActivosFijosConstantesFunciones.SCHEMA+"."+AdicionalesActivosFijosConstantesFunciones.TABLENAME+".version_row,"+AdicionalesActivosFijosConstantesFunciones.SCHEMA+"."+AdicionalesActivosFijosConstantesFunciones.TABLENAME+".id_empresa,"+AdicionalesActivosFijosConstantesFunciones.SCHEMA+"."+AdicionalesActivosFijosConstantesFunciones.TABLENAME+".codigo_sub_grupo,"+AdicionalesActivosFijosConstantesFunciones.SCHEMA+"."+AdicionalesActivosFijosConstantesFunciones.TABLENAME+".nombre_sub_grupo,"+AdicionalesActivosFijosConstantesFunciones.SCHEMA+"."+AdicionalesActivosFijosConstantesFunciones.TABLENAME+".codigo_detalle_grupo,"+AdicionalesActivosFijosConstantesFunciones.SCHEMA+"."+AdicionalesActivosFijosConstantesFunciones.TABLENAME+".nombre_detalle_grupo,"+AdicionalesActivosFijosConstantesFunciones.SCHEMA+"."+AdicionalesActivosFijosConstantesFunciones.TABLENAME+".clave,"+AdicionalesActivosFijosConstantesFunciones.SCHEMA+"."+AdicionalesActivosFijosConstantesFunciones.TABLENAME+".nombre,"+AdicionalesActivosFijosConstantesFunciones.SCHEMA+"."+AdicionalesActivosFijosConstantesFunciones.TABLENAME+".fecha_compra,"+AdicionalesActivosFijosConstantesFunciones.SCHEMA+"."+AdicionalesActivosFijosConstantesFunciones.TABLENAME+".vida_util,"+AdicionalesActivosFijosConstantesFunciones.SCHEMA+"."+AdicionalesActivosFijosConstantesFunciones.TABLENAME+".costo_de_compra from "+AdicionalesActivosFijosConstantesFunciones.SCHEMA+"."+AdicionalesActivosFijosConstantesFunciones.TABLENAME;//+" as "+AdicionalesActivosFijosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGOSUBGRUPO= "codigo_sub_grupo";
    public static final String NOMBRESUBGRUPO= "nombre_sub_grupo";
    public static final String CODIGODETALLEGRUPO= "codigo_detalle_grupo";
    public static final String NOMBREDETALLEGRUPO= "nombre_detalle_grupo";
    public static final String CLAVE= "clave";
    public static final String NOMBRE= "nombre";
    public static final String FECHACOMPRA= "fecha_compra";
    public static final String VIDAUTIL= "vida_util";
    public static final String COSTODECOMPRA= "costo_de_compra";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGOSUBGRUPO= "Codigo Sub Grupo";
		public static final String LABEL_CODIGOSUBGRUPO_LOWER= "Codigo Sub Grupo";
    	public static final String LABEL_NOMBRESUBGRUPO= "Nombre Sub Grupo";
		public static final String LABEL_NOMBRESUBGRUPO_LOWER= "Nombre Sub Grupo";
    	public static final String LABEL_CODIGODETALLEGRUPO= "Codigo Detalle Grupo";
		public static final String LABEL_CODIGODETALLEGRUPO_LOWER= "Codigo Detalle Grupo";
    	public static final String LABEL_NOMBREDETALLEGRUPO= "Nombre Detalle Grupo";
		public static final String LABEL_NOMBREDETALLEGRUPO_LOWER= "Nombre Detalle Grupo";
    	public static final String LABEL_CLAVE= "Clave";
		public static final String LABEL_CLAVE_LOWER= "Clave";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_FECHACOMPRA= "Fecha Compra";
		public static final String LABEL_FECHACOMPRA_LOWER= "Fecha Compra";
    	public static final String LABEL_VIDAUTIL= "Va Util";
		public static final String LABEL_VIDAUTIL_LOWER= "Vida Util";
    	public static final String LABEL_COSTODECOMPRA= "Costo Compra";
		public static final String LABEL_COSTODECOMPRA_LOWER= "Costo De Compra";
	
		
		
		
	public static final String SREGEXCODIGO_SUB_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_SUB_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_SUB_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_SUB_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_DETALLE_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_DETALLE_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_DETALLE_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_DETALLE_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCLAVE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCLAVE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getAdicionalesActivosFijosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AdicionalesActivosFijosConstantesFunciones.IDEMPRESA)) {sLabelColumna=AdicionalesActivosFijosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(AdicionalesActivosFijosConstantesFunciones.CODIGOSUBGRUPO)) {sLabelColumna=AdicionalesActivosFijosConstantesFunciones.LABEL_CODIGOSUBGRUPO;}
		if(sNombreColumna.equals(AdicionalesActivosFijosConstantesFunciones.NOMBRESUBGRUPO)) {sLabelColumna=AdicionalesActivosFijosConstantesFunciones.LABEL_NOMBRESUBGRUPO;}
		if(sNombreColumna.equals(AdicionalesActivosFijosConstantesFunciones.CODIGODETALLEGRUPO)) {sLabelColumna=AdicionalesActivosFijosConstantesFunciones.LABEL_CODIGODETALLEGRUPO;}
		if(sNombreColumna.equals(AdicionalesActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO)) {sLabelColumna=AdicionalesActivosFijosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO;}
		if(sNombreColumna.equals(AdicionalesActivosFijosConstantesFunciones.CLAVE)) {sLabelColumna=AdicionalesActivosFijosConstantesFunciones.LABEL_CLAVE;}
		if(sNombreColumna.equals(AdicionalesActivosFijosConstantesFunciones.NOMBRE)) {sLabelColumna=AdicionalesActivosFijosConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(AdicionalesActivosFijosConstantesFunciones.FECHACOMPRA)) {sLabelColumna=AdicionalesActivosFijosConstantesFunciones.LABEL_FECHACOMPRA;}
		if(sNombreColumna.equals(AdicionalesActivosFijosConstantesFunciones.VIDAUTIL)) {sLabelColumna=AdicionalesActivosFijosConstantesFunciones.LABEL_VIDAUTIL;}
		if(sNombreColumna.equals(AdicionalesActivosFijosConstantesFunciones.COSTODECOMPRA)) {sLabelColumna=AdicionalesActivosFijosConstantesFunciones.LABEL_COSTODECOMPRA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getAdicionalesActivosFijosDescripcion(AdicionalesActivosFijos adicionalesactivosfijos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(adicionalesactivosfijos !=null/* && adicionalesactivosfijos.getId()!=0*/) {
			sDescripcion=adicionalesactivosfijos.getnombre();//adicionalesactivosfijosadicionalesactivosfijos.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getAdicionalesActivosFijosDescripcionDetallado(AdicionalesActivosFijos adicionalesactivosfijos) {
		String sDescripcion="";
			
		sDescripcion+=AdicionalesActivosFijosConstantesFunciones.ID+"=";
		sDescripcion+=adicionalesactivosfijos.getId().toString()+",";
		sDescripcion+=AdicionalesActivosFijosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=adicionalesactivosfijos.getVersionRow().toString()+",";
		sDescripcion+=AdicionalesActivosFijosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=adicionalesactivosfijos.getid_empresa().toString()+",";
		sDescripcion+=AdicionalesActivosFijosConstantesFunciones.CODIGOSUBGRUPO+"=";
		sDescripcion+=adicionalesactivosfijos.getcodigo_sub_grupo()+",";
		sDescripcion+=AdicionalesActivosFijosConstantesFunciones.NOMBRESUBGRUPO+"=";
		sDescripcion+=adicionalesactivosfijos.getnombre_sub_grupo()+",";
		sDescripcion+=AdicionalesActivosFijosConstantesFunciones.CODIGODETALLEGRUPO+"=";
		sDescripcion+=adicionalesactivosfijos.getcodigo_detalle_grupo()+",";
		sDescripcion+=AdicionalesActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO+"=";
		sDescripcion+=adicionalesactivosfijos.getnombre_detalle_grupo()+",";
		sDescripcion+=AdicionalesActivosFijosConstantesFunciones.CLAVE+"=";
		sDescripcion+=adicionalesactivosfijos.getclave()+",";
		sDescripcion+=AdicionalesActivosFijosConstantesFunciones.NOMBRE+"=";
		sDescripcion+=adicionalesactivosfijos.getnombre()+",";
		sDescripcion+=AdicionalesActivosFijosConstantesFunciones.FECHACOMPRA+"=";
		sDescripcion+=adicionalesactivosfijos.getfecha_compra().toString()+",";
		sDescripcion+=AdicionalesActivosFijosConstantesFunciones.VIDAUTIL+"=";
		sDescripcion+=adicionalesactivosfijos.getvida_util().toString()+",";
		sDescripcion+=AdicionalesActivosFijosConstantesFunciones.COSTODECOMPRA+"=";
		sDescripcion+=adicionalesactivosfijos.getcosto_de_compra().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setAdicionalesActivosFijosDescripcion(AdicionalesActivosFijos adicionalesactivosfijos,String sValor) throws Exception {			
		if(adicionalesactivosfijos !=null) {
			adicionalesactivosfijos.setnombre(sValor);;//adicionalesactivosfijosadicionalesactivosfijos.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaAdicionalesActivosFijos")) {
			sNombreIndice="Tipo=  Por ";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaAdicionalesActivosFijos(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" ="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosAdicionalesActivosFijos(AdicionalesActivosFijos adicionalesactivosfijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		adicionalesactivosfijos.setcodigo_sub_grupo(adicionalesactivosfijos.getcodigo_sub_grupo().trim());
		adicionalesactivosfijos.setnombre_sub_grupo(adicionalesactivosfijos.getnombre_sub_grupo().trim());
		adicionalesactivosfijos.setcodigo_detalle_grupo(adicionalesactivosfijos.getcodigo_detalle_grupo().trim());
		adicionalesactivosfijos.setnombre_detalle_grupo(adicionalesactivosfijos.getnombre_detalle_grupo().trim());
		adicionalesactivosfijos.setclave(adicionalesactivosfijos.getclave().trim());
		adicionalesactivosfijos.setnombre(adicionalesactivosfijos.getnombre().trim());
	}
	
	public static void quitarEspaciosAdicionalesActivosFijoss(List<AdicionalesActivosFijos> adicionalesactivosfijoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(AdicionalesActivosFijos adicionalesactivosfijos: adicionalesactivosfijoss) {
			adicionalesactivosfijos.setcodigo_sub_grupo(adicionalesactivosfijos.getcodigo_sub_grupo().trim());
			adicionalesactivosfijos.setnombre_sub_grupo(adicionalesactivosfijos.getnombre_sub_grupo().trim());
			adicionalesactivosfijos.setcodigo_detalle_grupo(adicionalesactivosfijos.getcodigo_detalle_grupo().trim());
			adicionalesactivosfijos.setnombre_detalle_grupo(adicionalesactivosfijos.getnombre_detalle_grupo().trim());
			adicionalesactivosfijos.setclave(adicionalesactivosfijos.getclave().trim());
			adicionalesactivosfijos.setnombre(adicionalesactivosfijos.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAdicionalesActivosFijos(AdicionalesActivosFijos adicionalesactivosfijos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && adicionalesactivosfijos.getConCambioAuxiliar()) {
			adicionalesactivosfijos.setIsDeleted(adicionalesactivosfijos.getIsDeletedAuxiliar());	
			adicionalesactivosfijos.setIsNew(adicionalesactivosfijos.getIsNewAuxiliar());	
			adicionalesactivosfijos.setIsChanged(adicionalesactivosfijos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			adicionalesactivosfijos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			adicionalesactivosfijos.setIsDeletedAuxiliar(false);	
			adicionalesactivosfijos.setIsNewAuxiliar(false);	
			adicionalesactivosfijos.setIsChangedAuxiliar(false);
			
			adicionalesactivosfijos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAdicionalesActivosFijoss(List<AdicionalesActivosFijos> adicionalesactivosfijoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(AdicionalesActivosFijos adicionalesactivosfijos : adicionalesactivosfijoss) {
			if(conAsignarBase && adicionalesactivosfijos.getConCambioAuxiliar()) {
				adicionalesactivosfijos.setIsDeleted(adicionalesactivosfijos.getIsDeletedAuxiliar());	
				adicionalesactivosfijos.setIsNew(adicionalesactivosfijos.getIsNewAuxiliar());	
				adicionalesactivosfijos.setIsChanged(adicionalesactivosfijos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				adicionalesactivosfijos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				adicionalesactivosfijos.setIsDeletedAuxiliar(false);	
				adicionalesactivosfijos.setIsNewAuxiliar(false);	
				adicionalesactivosfijos.setIsChangedAuxiliar(false);
				
				adicionalesactivosfijos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAdicionalesActivosFijos(AdicionalesActivosFijos adicionalesactivosfijos,Boolean conEnteros) throws Exception  {
		adicionalesactivosfijos.setvida_util(0.0);
		adicionalesactivosfijos.setcosto_de_compra(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresAdicionalesActivosFijoss(List<AdicionalesActivosFijos> adicionalesactivosfijoss,Boolean conEnteros) throws Exception  {
		
		for(AdicionalesActivosFijos adicionalesactivosfijos: adicionalesactivosfijoss) {
			adicionalesactivosfijos.setvida_util(0.0);
			adicionalesactivosfijos.setcosto_de_compra(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaAdicionalesActivosFijos(List<AdicionalesActivosFijos> adicionalesactivosfijoss,AdicionalesActivosFijos adicionalesactivosfijosAux) throws Exception  {
		AdicionalesActivosFijosConstantesFunciones.InicializarValoresAdicionalesActivosFijos(adicionalesactivosfijosAux,true);
		
		for(AdicionalesActivosFijos adicionalesactivosfijos: adicionalesactivosfijoss) {
			if(adicionalesactivosfijos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			adicionalesactivosfijosAux.setvida_util(adicionalesactivosfijosAux.getvida_util()+adicionalesactivosfijos.getvida_util());			
			adicionalesactivosfijosAux.setcosto_de_compra(adicionalesactivosfijosAux.getcosto_de_compra()+adicionalesactivosfijos.getcosto_de_compra());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAdicionalesActivosFijos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AdicionalesActivosFijosConstantesFunciones.getArrayColumnasGlobalesAdicionalesActivosFijos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAdicionalesActivosFijos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AdicionalesActivosFijosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AdicionalesActivosFijosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAdicionalesActivosFijos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<AdicionalesActivosFijos> adicionalesactivosfijoss,AdicionalesActivosFijos adicionalesactivosfijos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(AdicionalesActivosFijos adicionalesactivosfijosAux: adicionalesactivosfijoss) {
			if(adicionalesactivosfijosAux!=null && adicionalesactivosfijos!=null) {
				if((adicionalesactivosfijosAux.getId()==null && adicionalesactivosfijos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(adicionalesactivosfijosAux.getId()!=null && adicionalesactivosfijos.getId()!=null){
					if(adicionalesactivosfijosAux.getId().equals(adicionalesactivosfijos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAdicionalesActivosFijos(List<AdicionalesActivosFijos> adicionalesactivosfijoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double vida_utilTotal=0.0;
		Double costo_de_compraTotal=0.0;
	
		for(AdicionalesActivosFijos adicionalesactivosfijos: adicionalesactivosfijoss) {			
			if(adicionalesactivosfijos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			vida_utilTotal+=adicionalesactivosfijos.getvida_util();
			costo_de_compraTotal+=adicionalesactivosfijos.getcosto_de_compra();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AdicionalesActivosFijosConstantesFunciones.VIDAUTIL);
		datoGeneral.setsDescripcion(AdicionalesActivosFijosConstantesFunciones.LABEL_VIDAUTIL);
		datoGeneral.setdValorDouble(vida_utilTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AdicionalesActivosFijosConstantesFunciones.COSTODECOMPRA);
		datoGeneral.setsDescripcion(AdicionalesActivosFijosConstantesFunciones.LABEL_COSTODECOMPRA);
		datoGeneral.setdValorDouble(costo_de_compraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAdicionalesActivosFijos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AdicionalesActivosFijosConstantesFunciones.LABEL_ID, AdicionalesActivosFijosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AdicionalesActivosFijosConstantesFunciones.LABEL_VERSIONROW, AdicionalesActivosFijosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AdicionalesActivosFijosConstantesFunciones.LABEL_CODIGOSUBGRUPO, AdicionalesActivosFijosConstantesFunciones.CODIGOSUBGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AdicionalesActivosFijosConstantesFunciones.LABEL_NOMBRESUBGRUPO, AdicionalesActivosFijosConstantesFunciones.NOMBRESUBGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AdicionalesActivosFijosConstantesFunciones.LABEL_CODIGODETALLEGRUPO, AdicionalesActivosFijosConstantesFunciones.CODIGODETALLEGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AdicionalesActivosFijosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO, AdicionalesActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AdicionalesActivosFijosConstantesFunciones.LABEL_CLAVE, AdicionalesActivosFijosConstantesFunciones.CLAVE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AdicionalesActivosFijosConstantesFunciones.LABEL_NOMBRE, AdicionalesActivosFijosConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AdicionalesActivosFijosConstantesFunciones.LABEL_FECHACOMPRA, AdicionalesActivosFijosConstantesFunciones.FECHACOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AdicionalesActivosFijosConstantesFunciones.LABEL_VIDAUTIL, AdicionalesActivosFijosConstantesFunciones.VIDAUTIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AdicionalesActivosFijosConstantesFunciones.LABEL_COSTODECOMPRA, AdicionalesActivosFijosConstantesFunciones.COSTODECOMPRA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAdicionalesActivosFijos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AdicionalesActivosFijosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AdicionalesActivosFijosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AdicionalesActivosFijosConstantesFunciones.CODIGOSUBGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AdicionalesActivosFijosConstantesFunciones.NOMBRESUBGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AdicionalesActivosFijosConstantesFunciones.CODIGODETALLEGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AdicionalesActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AdicionalesActivosFijosConstantesFunciones.CLAVE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AdicionalesActivosFijosConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AdicionalesActivosFijosConstantesFunciones.FECHACOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AdicionalesActivosFijosConstantesFunciones.VIDAUTIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AdicionalesActivosFijosConstantesFunciones.COSTODECOMPRA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAdicionalesActivosFijos() throws Exception  {
		return AdicionalesActivosFijosConstantesFunciones.getTiposSeleccionarAdicionalesActivosFijos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAdicionalesActivosFijos(Boolean conFk) throws Exception  {
		return AdicionalesActivosFijosConstantesFunciones.getTiposSeleccionarAdicionalesActivosFijos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAdicionalesActivosFijos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AdicionalesActivosFijosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(AdicionalesActivosFijosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AdicionalesActivosFijosConstantesFunciones.LABEL_CODIGOSUBGRUPO);
			reporte.setsDescripcion(AdicionalesActivosFijosConstantesFunciones.LABEL_CODIGOSUBGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AdicionalesActivosFijosConstantesFunciones.LABEL_NOMBRESUBGRUPO);
			reporte.setsDescripcion(AdicionalesActivosFijosConstantesFunciones.LABEL_NOMBRESUBGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AdicionalesActivosFijosConstantesFunciones.LABEL_CODIGODETALLEGRUPO);
			reporte.setsDescripcion(AdicionalesActivosFijosConstantesFunciones.LABEL_CODIGODETALLEGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AdicionalesActivosFijosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);
			reporte.setsDescripcion(AdicionalesActivosFijosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AdicionalesActivosFijosConstantesFunciones.LABEL_CLAVE);
			reporte.setsDescripcion(AdicionalesActivosFijosConstantesFunciones.LABEL_CLAVE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AdicionalesActivosFijosConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(AdicionalesActivosFijosConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AdicionalesActivosFijosConstantesFunciones.LABEL_FECHACOMPRA);
			reporte.setsDescripcion(AdicionalesActivosFijosConstantesFunciones.LABEL_FECHACOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AdicionalesActivosFijosConstantesFunciones.LABEL_VIDAUTIL);
			reporte.setsDescripcion(AdicionalesActivosFijosConstantesFunciones.LABEL_VIDAUTIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AdicionalesActivosFijosConstantesFunciones.LABEL_COSTODECOMPRA);
			reporte.setsDescripcion(AdicionalesActivosFijosConstantesFunciones.LABEL_COSTODECOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAdicionalesActivosFijos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAdicionalesActivosFijos(AdicionalesActivosFijos adicionalesactivosfijosAux) throws Exception {
		
			adicionalesactivosfijosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(adicionalesactivosfijosAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAdicionalesActivosFijos(List<AdicionalesActivosFijos> adicionalesactivosfijossTemp) throws Exception {
		for(AdicionalesActivosFijos adicionalesactivosfijosAux:adicionalesactivosfijossTemp) {
			
			adicionalesactivosfijosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(adicionalesactivosfijosAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAdicionalesActivosFijos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAdicionalesActivosFijos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfAdicionalesActivosFijos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AdicionalesActivosFijosConstantesFunciones.getClassesRelationshipsOfAdicionalesActivosFijos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAdicionalesActivosFijos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAdicionalesActivosFijos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AdicionalesActivosFijosConstantesFunciones.getClassesRelationshipsFromStringsOfAdicionalesActivosFijos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAdicionalesActivosFijos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(AdicionalesActivosFijos adicionalesactivosfijos,List<AdicionalesActivosFijos> adicionalesactivosfijoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(AdicionalesActivosFijos adicionalesactivosfijos,List<AdicionalesActivosFijos> adicionalesactivosfijoss) throws Exception {
		try	{			
			for(AdicionalesActivosFijos adicionalesactivosfijosLocal:adicionalesactivosfijoss) {
				if(adicionalesactivosfijosLocal.getId().equals(adicionalesactivosfijos.getId())) {
					adicionalesactivosfijosLocal.setIsSelected(adicionalesactivosfijos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAdicionalesActivosFijos(List<AdicionalesActivosFijos> adicionalesactivosfijossAux) throws Exception {
		//this.adicionalesactivosfijossAux=adicionalesactivosfijossAux;
		
		for(AdicionalesActivosFijos adicionalesactivosfijosAux:adicionalesactivosfijossAux) {
			if(adicionalesactivosfijosAux.getIsChanged()) {
				adicionalesactivosfijosAux.setIsChanged(false);
			}		
			
			if(adicionalesactivosfijosAux.getIsNew()) {
				adicionalesactivosfijosAux.setIsNew(false);
			}	
			
			if(adicionalesactivosfijosAux.getIsDeleted()) {
				adicionalesactivosfijosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAdicionalesActivosFijos(AdicionalesActivosFijos adicionalesactivosfijosAux) throws Exception {
		//this.adicionalesactivosfijosAux=adicionalesactivosfijosAux;
		
			if(adicionalesactivosfijosAux.getIsChanged()) {
				adicionalesactivosfijosAux.setIsChanged(false);
			}		
			
			if(adicionalesactivosfijosAux.getIsNew()) {
				adicionalesactivosfijosAux.setIsNew(false);
			}	
			
			if(adicionalesactivosfijosAux.getIsDeleted()) {
				adicionalesactivosfijosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(AdicionalesActivosFijos adicionalesactivosfijosAsignar,AdicionalesActivosFijos adicionalesactivosfijos) throws Exception {
		adicionalesactivosfijosAsignar.setId(adicionalesactivosfijos.getId());	
		adicionalesactivosfijosAsignar.setVersionRow(adicionalesactivosfijos.getVersionRow());	
		adicionalesactivosfijosAsignar.setcodigo_sub_grupo(adicionalesactivosfijos.getcodigo_sub_grupo());	
		adicionalesactivosfijosAsignar.setnombre_sub_grupo(adicionalesactivosfijos.getnombre_sub_grupo());	
		adicionalesactivosfijosAsignar.setcodigo_detalle_grupo(adicionalesactivosfijos.getcodigo_detalle_grupo());	
		adicionalesactivosfijosAsignar.setnombre_detalle_grupo(adicionalesactivosfijos.getnombre_detalle_grupo());	
		adicionalesactivosfijosAsignar.setclave(adicionalesactivosfijos.getclave());	
		adicionalesactivosfijosAsignar.setnombre(adicionalesactivosfijos.getnombre());	
		adicionalesactivosfijosAsignar.setfecha_compra(adicionalesactivosfijos.getfecha_compra());	
		adicionalesactivosfijosAsignar.setvida_util(adicionalesactivosfijos.getvida_util());	
		adicionalesactivosfijosAsignar.setcosto_de_compra(adicionalesactivosfijos.getcosto_de_compra());	
	}
	
	public static void inicializarAdicionalesActivosFijos(AdicionalesActivosFijos adicionalesactivosfijos) throws Exception {
		try {
				adicionalesactivosfijos.setId(0L);	
					
				adicionalesactivosfijos.setcodigo_sub_grupo("");	
				adicionalesactivosfijos.setnombre_sub_grupo("");	
				adicionalesactivosfijos.setcodigo_detalle_grupo("");	
				adicionalesactivosfijos.setnombre_detalle_grupo("");	
				adicionalesactivosfijos.setclave("");	
				adicionalesactivosfijos.setnombre("");	
				adicionalesactivosfijos.setfecha_compra(new Date());	
				adicionalesactivosfijos.setvida_util(0.0);	
				adicionalesactivosfijos.setcosto_de_compra(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAdicionalesActivosFijos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AdicionalesActivosFijosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AdicionalesActivosFijosConstantesFunciones.LABEL_CODIGOSUBGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AdicionalesActivosFijosConstantesFunciones.LABEL_NOMBRESUBGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AdicionalesActivosFijosConstantesFunciones.LABEL_CODIGODETALLEGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AdicionalesActivosFijosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AdicionalesActivosFijosConstantesFunciones.LABEL_CLAVE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AdicionalesActivosFijosConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AdicionalesActivosFijosConstantesFunciones.LABEL_FECHACOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AdicionalesActivosFijosConstantesFunciones.LABEL_VIDAUTIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AdicionalesActivosFijosConstantesFunciones.LABEL_COSTODECOMPRA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAdicionalesActivosFijos(String sTipo,Row row,Workbook workbook,AdicionalesActivosFijos adicionalesactivosfijos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(adicionalesactivosfijos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(adicionalesactivosfijos.getcodigo_sub_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(adicionalesactivosfijos.getnombre_sub_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(adicionalesactivosfijos.getcodigo_detalle_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(adicionalesactivosfijos.getnombre_detalle_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(adicionalesactivosfijos.getclave());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(adicionalesactivosfijos.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(adicionalesactivosfijos.getfecha_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(adicionalesactivosfijos.getvida_util());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(adicionalesactivosfijos.getcosto_de_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAdicionalesActivosFijos="";
	
	public String getsFinalQueryAdicionalesActivosFijos() {
		return this.sFinalQueryAdicionalesActivosFijos;
	}
	
	public void setsFinalQueryAdicionalesActivosFijos(String sFinalQueryAdicionalesActivosFijos) {
		this.sFinalQueryAdicionalesActivosFijos= sFinalQueryAdicionalesActivosFijos;
	}
	
	public Border resaltarSeleccionarAdicionalesActivosFijos=null;
	
	public Border setResaltarSeleccionarAdicionalesActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*AdicionalesActivosFijosBeanSwingJInternalFrame adicionalesactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//adicionalesactivosfijosBeanSwingJInternalFrame.jTtoolBarAdicionalesActivosFijos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAdicionalesActivosFijos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAdicionalesActivosFijos() {
		return this.resaltarSeleccionarAdicionalesActivosFijos;
	}
	
	public void setResaltarSeleccionarAdicionalesActivosFijos(Border borderResaltarSeleccionarAdicionalesActivosFijos) {
		this.resaltarSeleccionarAdicionalesActivosFijos= borderResaltarSeleccionarAdicionalesActivosFijos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAdicionalesActivosFijos=null;
	public Boolean mostraridAdicionalesActivosFijos=true;
	public Boolean activaridAdicionalesActivosFijos=true;

	public Border resaltarid_empresaAdicionalesActivosFijos=null;
	public Boolean mostrarid_empresaAdicionalesActivosFijos=true;
	public Boolean activarid_empresaAdicionalesActivosFijos=true;
	public Boolean cargarid_empresaAdicionalesActivosFijos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaAdicionalesActivosFijos=false;//ConEventDepend=true

	public Border resaltarcodigo_sub_grupoAdicionalesActivosFijos=null;
	public Boolean mostrarcodigo_sub_grupoAdicionalesActivosFijos=true;
	public Boolean activarcodigo_sub_grupoAdicionalesActivosFijos=true;

	public Border resaltarnombre_sub_grupoAdicionalesActivosFijos=null;
	public Boolean mostrarnombre_sub_grupoAdicionalesActivosFijos=true;
	public Boolean activarnombre_sub_grupoAdicionalesActivosFijos=true;

	public Border resaltarcodigo_detalle_grupoAdicionalesActivosFijos=null;
	public Boolean mostrarcodigo_detalle_grupoAdicionalesActivosFijos=true;
	public Boolean activarcodigo_detalle_grupoAdicionalesActivosFijos=true;

	public Border resaltarnombre_detalle_grupoAdicionalesActivosFijos=null;
	public Boolean mostrarnombre_detalle_grupoAdicionalesActivosFijos=true;
	public Boolean activarnombre_detalle_grupoAdicionalesActivosFijos=true;

	public Border resaltarclaveAdicionalesActivosFijos=null;
	public Boolean mostrarclaveAdicionalesActivosFijos=true;
	public Boolean activarclaveAdicionalesActivosFijos=true;

	public Border resaltarnombreAdicionalesActivosFijos=null;
	public Boolean mostrarnombreAdicionalesActivosFijos=true;
	public Boolean activarnombreAdicionalesActivosFijos=true;

	public Border resaltarfecha_compraAdicionalesActivosFijos=null;
	public Boolean mostrarfecha_compraAdicionalesActivosFijos=true;
	public Boolean activarfecha_compraAdicionalesActivosFijos=true;

	public Border resaltarvida_utilAdicionalesActivosFijos=null;
	public Boolean mostrarvida_utilAdicionalesActivosFijos=true;
	public Boolean activarvida_utilAdicionalesActivosFijos=true;

	public Border resaltarcosto_de_compraAdicionalesActivosFijos=null;
	public Boolean mostrarcosto_de_compraAdicionalesActivosFijos=true;
	public Boolean activarcosto_de_compraAdicionalesActivosFijos=true;

	
	

	public Border setResaltaridAdicionalesActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*AdicionalesActivosFijosBeanSwingJInternalFrame adicionalesactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//adicionalesactivosfijosBeanSwingJInternalFrame.jTtoolBarAdicionalesActivosFijos.setBorder(borderResaltar);
		
		this.resaltaridAdicionalesActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAdicionalesActivosFijos() {
		return this.resaltaridAdicionalesActivosFijos;
	}

	public void setResaltaridAdicionalesActivosFijos(Border borderResaltar) {
		this.resaltaridAdicionalesActivosFijos= borderResaltar;
	}

	public Boolean getMostraridAdicionalesActivosFijos() {
		return this.mostraridAdicionalesActivosFijos;
	}

	public void setMostraridAdicionalesActivosFijos(Boolean mostraridAdicionalesActivosFijos) {
		this.mostraridAdicionalesActivosFijos= mostraridAdicionalesActivosFijos;
	}

	public Boolean getActivaridAdicionalesActivosFijos() {
		return this.activaridAdicionalesActivosFijos;
	}

	public void setActivaridAdicionalesActivosFijos(Boolean activaridAdicionalesActivosFijos) {
		this.activaridAdicionalesActivosFijos= activaridAdicionalesActivosFijos;
	}

	public Border setResaltarid_empresaAdicionalesActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*AdicionalesActivosFijosBeanSwingJInternalFrame adicionalesactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//adicionalesactivosfijosBeanSwingJInternalFrame.jTtoolBarAdicionalesActivosFijos.setBorder(borderResaltar);
		
		this.resaltarid_empresaAdicionalesActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaAdicionalesActivosFijos() {
		return this.resaltarid_empresaAdicionalesActivosFijos;
	}

	public void setResaltarid_empresaAdicionalesActivosFijos(Border borderResaltar) {
		this.resaltarid_empresaAdicionalesActivosFijos= borderResaltar;
	}

	public Boolean getMostrarid_empresaAdicionalesActivosFijos() {
		return this.mostrarid_empresaAdicionalesActivosFijos;
	}

	public void setMostrarid_empresaAdicionalesActivosFijos(Boolean mostrarid_empresaAdicionalesActivosFijos) {
		this.mostrarid_empresaAdicionalesActivosFijos= mostrarid_empresaAdicionalesActivosFijos;
	}

	public Boolean getActivarid_empresaAdicionalesActivosFijos() {
		return this.activarid_empresaAdicionalesActivosFijos;
	}

	public void setActivarid_empresaAdicionalesActivosFijos(Boolean activarid_empresaAdicionalesActivosFijos) {
		this.activarid_empresaAdicionalesActivosFijos= activarid_empresaAdicionalesActivosFijos;
	}

	public Boolean getCargarid_empresaAdicionalesActivosFijos() {
		return this.cargarid_empresaAdicionalesActivosFijos;
	}

	public void setCargarid_empresaAdicionalesActivosFijos(Boolean cargarid_empresaAdicionalesActivosFijos) {
		this.cargarid_empresaAdicionalesActivosFijos= cargarid_empresaAdicionalesActivosFijos;
	}

	public Border setResaltarcodigo_sub_grupoAdicionalesActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*AdicionalesActivosFijosBeanSwingJInternalFrame adicionalesactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//adicionalesactivosfijosBeanSwingJInternalFrame.jTtoolBarAdicionalesActivosFijos.setBorder(borderResaltar);
		
		this.resaltarcodigo_sub_grupoAdicionalesActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_sub_grupoAdicionalesActivosFijos() {
		return this.resaltarcodigo_sub_grupoAdicionalesActivosFijos;
	}

	public void setResaltarcodigo_sub_grupoAdicionalesActivosFijos(Border borderResaltar) {
		this.resaltarcodigo_sub_grupoAdicionalesActivosFijos= borderResaltar;
	}

	public Boolean getMostrarcodigo_sub_grupoAdicionalesActivosFijos() {
		return this.mostrarcodigo_sub_grupoAdicionalesActivosFijos;
	}

	public void setMostrarcodigo_sub_grupoAdicionalesActivosFijos(Boolean mostrarcodigo_sub_grupoAdicionalesActivosFijos) {
		this.mostrarcodigo_sub_grupoAdicionalesActivosFijos= mostrarcodigo_sub_grupoAdicionalesActivosFijos;
	}

	public Boolean getActivarcodigo_sub_grupoAdicionalesActivosFijos() {
		return this.activarcodigo_sub_grupoAdicionalesActivosFijos;
	}

	public void setActivarcodigo_sub_grupoAdicionalesActivosFijos(Boolean activarcodigo_sub_grupoAdicionalesActivosFijos) {
		this.activarcodigo_sub_grupoAdicionalesActivosFijos= activarcodigo_sub_grupoAdicionalesActivosFijos;
	}

	public Border setResaltarnombre_sub_grupoAdicionalesActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*AdicionalesActivosFijosBeanSwingJInternalFrame adicionalesactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//adicionalesactivosfijosBeanSwingJInternalFrame.jTtoolBarAdicionalesActivosFijos.setBorder(borderResaltar);
		
		this.resaltarnombre_sub_grupoAdicionalesActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sub_grupoAdicionalesActivosFijos() {
		return this.resaltarnombre_sub_grupoAdicionalesActivosFijos;
	}

	public void setResaltarnombre_sub_grupoAdicionalesActivosFijos(Border borderResaltar) {
		this.resaltarnombre_sub_grupoAdicionalesActivosFijos= borderResaltar;
	}

	public Boolean getMostrarnombre_sub_grupoAdicionalesActivosFijos() {
		return this.mostrarnombre_sub_grupoAdicionalesActivosFijos;
	}

	public void setMostrarnombre_sub_grupoAdicionalesActivosFijos(Boolean mostrarnombre_sub_grupoAdicionalesActivosFijos) {
		this.mostrarnombre_sub_grupoAdicionalesActivosFijos= mostrarnombre_sub_grupoAdicionalesActivosFijos;
	}

	public Boolean getActivarnombre_sub_grupoAdicionalesActivosFijos() {
		return this.activarnombre_sub_grupoAdicionalesActivosFijos;
	}

	public void setActivarnombre_sub_grupoAdicionalesActivosFijos(Boolean activarnombre_sub_grupoAdicionalesActivosFijos) {
		this.activarnombre_sub_grupoAdicionalesActivosFijos= activarnombre_sub_grupoAdicionalesActivosFijos;
	}

	public Border setResaltarcodigo_detalle_grupoAdicionalesActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*AdicionalesActivosFijosBeanSwingJInternalFrame adicionalesactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//adicionalesactivosfijosBeanSwingJInternalFrame.jTtoolBarAdicionalesActivosFijos.setBorder(borderResaltar);
		
		this.resaltarcodigo_detalle_grupoAdicionalesActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_detalle_grupoAdicionalesActivosFijos() {
		return this.resaltarcodigo_detalle_grupoAdicionalesActivosFijos;
	}

	public void setResaltarcodigo_detalle_grupoAdicionalesActivosFijos(Border borderResaltar) {
		this.resaltarcodigo_detalle_grupoAdicionalesActivosFijos= borderResaltar;
	}

	public Boolean getMostrarcodigo_detalle_grupoAdicionalesActivosFijos() {
		return this.mostrarcodigo_detalle_grupoAdicionalesActivosFijos;
	}

	public void setMostrarcodigo_detalle_grupoAdicionalesActivosFijos(Boolean mostrarcodigo_detalle_grupoAdicionalesActivosFijos) {
		this.mostrarcodigo_detalle_grupoAdicionalesActivosFijos= mostrarcodigo_detalle_grupoAdicionalesActivosFijos;
	}

	public Boolean getActivarcodigo_detalle_grupoAdicionalesActivosFijos() {
		return this.activarcodigo_detalle_grupoAdicionalesActivosFijos;
	}

	public void setActivarcodigo_detalle_grupoAdicionalesActivosFijos(Boolean activarcodigo_detalle_grupoAdicionalesActivosFijos) {
		this.activarcodigo_detalle_grupoAdicionalesActivosFijos= activarcodigo_detalle_grupoAdicionalesActivosFijos;
	}

	public Border setResaltarnombre_detalle_grupoAdicionalesActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*AdicionalesActivosFijosBeanSwingJInternalFrame adicionalesactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//adicionalesactivosfijosBeanSwingJInternalFrame.jTtoolBarAdicionalesActivosFijos.setBorder(borderResaltar);
		
		this.resaltarnombre_detalle_grupoAdicionalesActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_detalle_grupoAdicionalesActivosFijos() {
		return this.resaltarnombre_detalle_grupoAdicionalesActivosFijos;
	}

	public void setResaltarnombre_detalle_grupoAdicionalesActivosFijos(Border borderResaltar) {
		this.resaltarnombre_detalle_grupoAdicionalesActivosFijos= borderResaltar;
	}

	public Boolean getMostrarnombre_detalle_grupoAdicionalesActivosFijos() {
		return this.mostrarnombre_detalle_grupoAdicionalesActivosFijos;
	}

	public void setMostrarnombre_detalle_grupoAdicionalesActivosFijos(Boolean mostrarnombre_detalle_grupoAdicionalesActivosFijos) {
		this.mostrarnombre_detalle_grupoAdicionalesActivosFijos= mostrarnombre_detalle_grupoAdicionalesActivosFijos;
	}

	public Boolean getActivarnombre_detalle_grupoAdicionalesActivosFijos() {
		return this.activarnombre_detalle_grupoAdicionalesActivosFijos;
	}

	public void setActivarnombre_detalle_grupoAdicionalesActivosFijos(Boolean activarnombre_detalle_grupoAdicionalesActivosFijos) {
		this.activarnombre_detalle_grupoAdicionalesActivosFijos= activarnombre_detalle_grupoAdicionalesActivosFijos;
	}

	public Border setResaltarclaveAdicionalesActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*AdicionalesActivosFijosBeanSwingJInternalFrame adicionalesactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//adicionalesactivosfijosBeanSwingJInternalFrame.jTtoolBarAdicionalesActivosFijos.setBorder(borderResaltar);
		
		this.resaltarclaveAdicionalesActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarclaveAdicionalesActivosFijos() {
		return this.resaltarclaveAdicionalesActivosFijos;
	}

	public void setResaltarclaveAdicionalesActivosFijos(Border borderResaltar) {
		this.resaltarclaveAdicionalesActivosFijos= borderResaltar;
	}

	public Boolean getMostrarclaveAdicionalesActivosFijos() {
		return this.mostrarclaveAdicionalesActivosFijos;
	}

	public void setMostrarclaveAdicionalesActivosFijos(Boolean mostrarclaveAdicionalesActivosFijos) {
		this.mostrarclaveAdicionalesActivosFijos= mostrarclaveAdicionalesActivosFijos;
	}

	public Boolean getActivarclaveAdicionalesActivosFijos() {
		return this.activarclaveAdicionalesActivosFijos;
	}

	public void setActivarclaveAdicionalesActivosFijos(Boolean activarclaveAdicionalesActivosFijos) {
		this.activarclaveAdicionalesActivosFijos= activarclaveAdicionalesActivosFijos;
	}

	public Border setResaltarnombreAdicionalesActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*AdicionalesActivosFijosBeanSwingJInternalFrame adicionalesactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//adicionalesactivosfijosBeanSwingJInternalFrame.jTtoolBarAdicionalesActivosFijos.setBorder(borderResaltar);
		
		this.resaltarnombreAdicionalesActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreAdicionalesActivosFijos() {
		return this.resaltarnombreAdicionalesActivosFijos;
	}

	public void setResaltarnombreAdicionalesActivosFijos(Border borderResaltar) {
		this.resaltarnombreAdicionalesActivosFijos= borderResaltar;
	}

	public Boolean getMostrarnombreAdicionalesActivosFijos() {
		return this.mostrarnombreAdicionalesActivosFijos;
	}

	public void setMostrarnombreAdicionalesActivosFijos(Boolean mostrarnombreAdicionalesActivosFijos) {
		this.mostrarnombreAdicionalesActivosFijos= mostrarnombreAdicionalesActivosFijos;
	}

	public Boolean getActivarnombreAdicionalesActivosFijos() {
		return this.activarnombreAdicionalesActivosFijos;
	}

	public void setActivarnombreAdicionalesActivosFijos(Boolean activarnombreAdicionalesActivosFijos) {
		this.activarnombreAdicionalesActivosFijos= activarnombreAdicionalesActivosFijos;
	}

	public Border setResaltarfecha_compraAdicionalesActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*AdicionalesActivosFijosBeanSwingJInternalFrame adicionalesactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//adicionalesactivosfijosBeanSwingJInternalFrame.jTtoolBarAdicionalesActivosFijos.setBorder(borderResaltar);
		
		this.resaltarfecha_compraAdicionalesActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_compraAdicionalesActivosFijos() {
		return this.resaltarfecha_compraAdicionalesActivosFijos;
	}

	public void setResaltarfecha_compraAdicionalesActivosFijos(Border borderResaltar) {
		this.resaltarfecha_compraAdicionalesActivosFijos= borderResaltar;
	}

	public Boolean getMostrarfecha_compraAdicionalesActivosFijos() {
		return this.mostrarfecha_compraAdicionalesActivosFijos;
	}

	public void setMostrarfecha_compraAdicionalesActivosFijos(Boolean mostrarfecha_compraAdicionalesActivosFijos) {
		this.mostrarfecha_compraAdicionalesActivosFijos= mostrarfecha_compraAdicionalesActivosFijos;
	}

	public Boolean getActivarfecha_compraAdicionalesActivosFijos() {
		return this.activarfecha_compraAdicionalesActivosFijos;
	}

	public void setActivarfecha_compraAdicionalesActivosFijos(Boolean activarfecha_compraAdicionalesActivosFijos) {
		this.activarfecha_compraAdicionalesActivosFijos= activarfecha_compraAdicionalesActivosFijos;
	}

	public Border setResaltarvida_utilAdicionalesActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*AdicionalesActivosFijosBeanSwingJInternalFrame adicionalesactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//adicionalesactivosfijosBeanSwingJInternalFrame.jTtoolBarAdicionalesActivosFijos.setBorder(borderResaltar);
		
		this.resaltarvida_utilAdicionalesActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvida_utilAdicionalesActivosFijos() {
		return this.resaltarvida_utilAdicionalesActivosFijos;
	}

	public void setResaltarvida_utilAdicionalesActivosFijos(Border borderResaltar) {
		this.resaltarvida_utilAdicionalesActivosFijos= borderResaltar;
	}

	public Boolean getMostrarvida_utilAdicionalesActivosFijos() {
		return this.mostrarvida_utilAdicionalesActivosFijos;
	}

	public void setMostrarvida_utilAdicionalesActivosFijos(Boolean mostrarvida_utilAdicionalesActivosFijos) {
		this.mostrarvida_utilAdicionalesActivosFijos= mostrarvida_utilAdicionalesActivosFijos;
	}

	public Boolean getActivarvida_utilAdicionalesActivosFijos() {
		return this.activarvida_utilAdicionalesActivosFijos;
	}

	public void setActivarvida_utilAdicionalesActivosFijos(Boolean activarvida_utilAdicionalesActivosFijos) {
		this.activarvida_utilAdicionalesActivosFijos= activarvida_utilAdicionalesActivosFijos;
	}

	public Border setResaltarcosto_de_compraAdicionalesActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*AdicionalesActivosFijosBeanSwingJInternalFrame adicionalesactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//adicionalesactivosfijosBeanSwingJInternalFrame.jTtoolBarAdicionalesActivosFijos.setBorder(borderResaltar);
		
		this.resaltarcosto_de_compraAdicionalesActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_de_compraAdicionalesActivosFijos() {
		return this.resaltarcosto_de_compraAdicionalesActivosFijos;
	}

	public void setResaltarcosto_de_compraAdicionalesActivosFijos(Border borderResaltar) {
		this.resaltarcosto_de_compraAdicionalesActivosFijos= borderResaltar;
	}

	public Boolean getMostrarcosto_de_compraAdicionalesActivosFijos() {
		return this.mostrarcosto_de_compraAdicionalesActivosFijos;
	}

	public void setMostrarcosto_de_compraAdicionalesActivosFijos(Boolean mostrarcosto_de_compraAdicionalesActivosFijos) {
		this.mostrarcosto_de_compraAdicionalesActivosFijos= mostrarcosto_de_compraAdicionalesActivosFijos;
	}

	public Boolean getActivarcosto_de_compraAdicionalesActivosFijos() {
		return this.activarcosto_de_compraAdicionalesActivosFijos;
	}

	public void setActivarcosto_de_compraAdicionalesActivosFijos(Boolean activarcosto_de_compraAdicionalesActivosFijos) {
		this.activarcosto_de_compraAdicionalesActivosFijos= activarcosto_de_compraAdicionalesActivosFijos;
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
		
		
		this.setMostraridAdicionalesActivosFijos(esInicial);
		this.setMostrarid_empresaAdicionalesActivosFijos(esInicial);
		this.setMostrarcodigo_sub_grupoAdicionalesActivosFijos(esInicial);
		this.setMostrarnombre_sub_grupoAdicionalesActivosFijos(esInicial);
		this.setMostrarcodigo_detalle_grupoAdicionalesActivosFijos(esInicial);
		this.setMostrarnombre_detalle_grupoAdicionalesActivosFijos(esInicial);
		this.setMostrarclaveAdicionalesActivosFijos(esInicial);
		this.setMostrarnombreAdicionalesActivosFijos(esInicial);
		this.setMostrarfecha_compraAdicionalesActivosFijos(esInicial);
		this.setMostrarvida_utilAdicionalesActivosFijos(esInicial);
		this.setMostrarcosto_de_compraAdicionalesActivosFijos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.ID)) {
				this.setMostraridAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setMostrarcodigo_sub_grupoAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setMostrarnombre_sub_grupoAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setMostrarcodigo_detalle_grupoAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setMostrarnombre_detalle_grupoAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.CLAVE)) {
				this.setMostrarclaveAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.FECHACOMPRA)) {
				this.setMostrarfecha_compraAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.VIDAUTIL)) {
				this.setMostrarvida_utilAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.COSTODECOMPRA)) {
				this.setMostrarcosto_de_compraAdicionalesActivosFijos(esAsigna);
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
		
		
		this.setActivaridAdicionalesActivosFijos(esInicial);
		this.setActivarid_empresaAdicionalesActivosFijos(esInicial);
		this.setActivarcodigo_sub_grupoAdicionalesActivosFijos(esInicial);
		this.setActivarnombre_sub_grupoAdicionalesActivosFijos(esInicial);
		this.setActivarcodigo_detalle_grupoAdicionalesActivosFijos(esInicial);
		this.setActivarnombre_detalle_grupoAdicionalesActivosFijos(esInicial);
		this.setActivarclaveAdicionalesActivosFijos(esInicial);
		this.setActivarnombreAdicionalesActivosFijos(esInicial);
		this.setActivarfecha_compraAdicionalesActivosFijos(esInicial);
		this.setActivarvida_utilAdicionalesActivosFijos(esInicial);
		this.setActivarcosto_de_compraAdicionalesActivosFijos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.ID)) {
				this.setActivaridAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setActivarcodigo_sub_grupoAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setActivarnombre_sub_grupoAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setActivarcodigo_detalle_grupoAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setActivarnombre_detalle_grupoAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.CLAVE)) {
				this.setActivarclaveAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.NOMBRE)) {
				this.setActivarnombreAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.FECHACOMPRA)) {
				this.setActivarfecha_compraAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.VIDAUTIL)) {
				this.setActivarvida_utilAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.COSTODECOMPRA)) {
				this.setActivarcosto_de_compraAdicionalesActivosFijos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AdicionalesActivosFijosBeanSwingJInternalFrame adicionalesactivosfijosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAdicionalesActivosFijos(esInicial);
		this.setResaltarid_empresaAdicionalesActivosFijos(esInicial);
		this.setResaltarcodigo_sub_grupoAdicionalesActivosFijos(esInicial);
		this.setResaltarnombre_sub_grupoAdicionalesActivosFijos(esInicial);
		this.setResaltarcodigo_detalle_grupoAdicionalesActivosFijos(esInicial);
		this.setResaltarnombre_detalle_grupoAdicionalesActivosFijos(esInicial);
		this.setResaltarclaveAdicionalesActivosFijos(esInicial);
		this.setResaltarnombreAdicionalesActivosFijos(esInicial);
		this.setResaltarfecha_compraAdicionalesActivosFijos(esInicial);
		this.setResaltarvida_utilAdicionalesActivosFijos(esInicial);
		this.setResaltarcosto_de_compraAdicionalesActivosFijos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.ID)) {
				this.setResaltaridAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setResaltarcodigo_sub_grupoAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setResaltarnombre_sub_grupoAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setResaltarcodigo_detalle_grupoAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setResaltarnombre_detalle_grupoAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.CLAVE)) {
				this.setResaltarclaveAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.FECHACOMPRA)) {
				this.setResaltarfecha_compraAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.VIDAUTIL)) {
				this.setResaltarvida_utilAdicionalesActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(AdicionalesActivosFijosConstantesFunciones.COSTODECOMPRA)) {
				this.setResaltarcosto_de_compraAdicionalesActivosFijos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AdicionalesActivosFijosBeanSwingJInternalFrame adicionalesactivosfijosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaAdicionalesActivosFijosAdicionalesActivosFijos=true;

	public Boolean getMostrarBusquedaAdicionalesActivosFijosAdicionalesActivosFijos() {
		return this.mostrarBusquedaAdicionalesActivosFijosAdicionalesActivosFijos;
	}

	public void setMostrarBusquedaAdicionalesActivosFijosAdicionalesActivosFijos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaAdicionalesActivosFijosAdicionalesActivosFijos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaAdicionalesActivosFijosAdicionalesActivosFijos=true;

	public Boolean getActivarBusquedaAdicionalesActivosFijosAdicionalesActivosFijos() {
		return this.activarBusquedaAdicionalesActivosFijosAdicionalesActivosFijos;
	}

	public void setActivarBusquedaAdicionalesActivosFijosAdicionalesActivosFijos(Boolean habilitarResaltar) {
		this.activarBusquedaAdicionalesActivosFijosAdicionalesActivosFijos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaAdicionalesActivosFijosAdicionalesActivosFijos=null;

	public Border getResaltarBusquedaAdicionalesActivosFijosAdicionalesActivosFijos() {
		return this.resaltarBusquedaAdicionalesActivosFijosAdicionalesActivosFijos;
	}

	public void setResaltarBusquedaAdicionalesActivosFijosAdicionalesActivosFijos(Border borderResaltar) {
		this.resaltarBusquedaAdicionalesActivosFijosAdicionalesActivosFijos= borderResaltar;
	}

	public void setResaltarBusquedaAdicionalesActivosFijosAdicionalesActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*AdicionalesActivosFijosBeanSwingJInternalFrame adicionalesactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaAdicionalesActivosFijosAdicionalesActivosFijos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}