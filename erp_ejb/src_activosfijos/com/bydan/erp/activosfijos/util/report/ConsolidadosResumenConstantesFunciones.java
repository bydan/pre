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


import com.bydan.erp.activosfijos.util.report.ConsolidadosResumenConstantesFunciones;
import com.bydan.erp.activosfijos.util.report.ConsolidadosResumenParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.ConsolidadosResumenParameterGeneral;

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
final public class ConsolidadosResumenConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ConsolidadosResumen";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ConsolidadosResumen"+ConsolidadosResumenConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ConsolidadosResumenHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ConsolidadosResumenHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ConsolidadosResumenConstantesFunciones.SCHEMA+"_"+ConsolidadosResumenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ConsolidadosResumenHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ConsolidadosResumenConstantesFunciones.SCHEMA+"_"+ConsolidadosResumenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ConsolidadosResumenConstantesFunciones.SCHEMA+"_"+ConsolidadosResumenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ConsolidadosResumenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ConsolidadosResumenConstantesFunciones.SCHEMA+"_"+ConsolidadosResumenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsolidadosResumenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConsolidadosResumenHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsolidadosResumenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsolidadosResumenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConsolidadosResumenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsolidadosResumenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ConsolidadosResumenConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ConsolidadosResumenConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ConsolidadosResumenConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ConsolidadosResumenConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Consolidados Resumenes";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Consolidados Resumen";
	public static final String SCLASSWEBTITULO_LOWER="Consolidados Resumen";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ConsolidadosResumen";
	public static final String OBJECTNAME="consolidadosresumen";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="consolidados_resumen";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select consolidadosresumen from "+ConsolidadosResumenConstantesFunciones.SPERSISTENCENAME+" consolidadosresumen";
	public static String QUERYSELECTNATIVE="select "+ConsolidadosResumenConstantesFunciones.SCHEMA+"."+ConsolidadosResumenConstantesFunciones.TABLENAME+".id,"+ConsolidadosResumenConstantesFunciones.SCHEMA+"."+ConsolidadosResumenConstantesFunciones.TABLENAME+".version_row,"+ConsolidadosResumenConstantesFunciones.SCHEMA+"."+ConsolidadosResumenConstantesFunciones.TABLENAME+".id_empresa,"+ConsolidadosResumenConstantesFunciones.SCHEMA+"."+ConsolidadosResumenConstantesFunciones.TABLENAME+".nombre_empresa,"+ConsolidadosResumenConstantesFunciones.SCHEMA+"."+ConsolidadosResumenConstantesFunciones.TABLENAME+".nombre_sucursal,"+ConsolidadosResumenConstantesFunciones.SCHEMA+"."+ConsolidadosResumenConstantesFunciones.TABLENAME+".codigo_sub_grupo,"+ConsolidadosResumenConstantesFunciones.SCHEMA+"."+ConsolidadosResumenConstantesFunciones.TABLENAME+".nombre_sub_grupo,"+ConsolidadosResumenConstantesFunciones.SCHEMA+"."+ConsolidadosResumenConstantesFunciones.TABLENAME+".codigo_detalle_grupo,"+ConsolidadosResumenConstantesFunciones.SCHEMA+"."+ConsolidadosResumenConstantesFunciones.TABLENAME+".nombre_detalle_grupo,"+ConsolidadosResumenConstantesFunciones.SCHEMA+"."+ConsolidadosResumenConstantesFunciones.TABLENAME+".clave,"+ConsolidadosResumenConstantesFunciones.SCHEMA+"."+ConsolidadosResumenConstantesFunciones.TABLENAME+".nombre,"+ConsolidadosResumenConstantesFunciones.SCHEMA+"."+ConsolidadosResumenConstantesFunciones.TABLENAME+".fecha_compra,"+ConsolidadosResumenConstantesFunciones.SCHEMA+"."+ConsolidadosResumenConstantesFunciones.TABLENAME+".vida_util,"+ConsolidadosResumenConstantesFunciones.SCHEMA+"."+ConsolidadosResumenConstantesFunciones.TABLENAME+".costo_de_compra,"+ConsolidadosResumenConstantesFunciones.SCHEMA+"."+ConsolidadosResumenConstantesFunciones.TABLENAME+".cantidad from "+ConsolidadosResumenConstantesFunciones.SCHEMA+"."+ConsolidadosResumenConstantesFunciones.TABLENAME;//+" as "+ConsolidadosResumenConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBREEMPRESA= "nombre_empresa";
    public static final String NOMBRESUCURSAL= "nombre_sucursal";
    public static final String CODIGOSUBGRUPO= "codigo_sub_grupo";
    public static final String NOMBRESUBGRUPO= "nombre_sub_grupo";
    public static final String CODIGODETALLEGRUPO= "codigo_detalle_grupo";
    public static final String NOMBREDETALLEGRUPO= "nombre_detalle_grupo";
    public static final String CLAVE= "clave";
    public static final String NOMBRE= "nombre";
    public static final String FECHACOMPRA= "fecha_compra";
    public static final String VIDAUTIL= "vida_util";
    public static final String COSTODECOMPRA= "costo_de_compra";
    public static final String CANTIDAD= "cantidad";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBREEMPRESA= "Nombre Empresa";
		public static final String LABEL_NOMBREEMPRESA_LOWER= "Nombre Empresa";
    	public static final String LABEL_NOMBRESUCURSAL= "Nombre Sucursal";
		public static final String LABEL_NOMBRESUCURSAL_LOWER= "Nombre Sucursal";
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
    	public static final String LABEL_CANTIDAD= "Cantad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
	
		
		
		
	public static final String SREGEXNOMBRE_EMPRESA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_EMPRESA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_SUCURSAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_SUCURSAL=ConstantesValidacion.SVALIDACIONCADENA;	
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
		
		
		
		
	
	public static String getConsolidadosResumenLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ConsolidadosResumenConstantesFunciones.IDEMPRESA)) {sLabelColumna=ConsolidadosResumenConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ConsolidadosResumenConstantesFunciones.NOMBREEMPRESA)) {sLabelColumna=ConsolidadosResumenConstantesFunciones.LABEL_NOMBREEMPRESA;}
		if(sNombreColumna.equals(ConsolidadosResumenConstantesFunciones.NOMBRESUCURSAL)) {sLabelColumna=ConsolidadosResumenConstantesFunciones.LABEL_NOMBRESUCURSAL;}
		if(sNombreColumna.equals(ConsolidadosResumenConstantesFunciones.CODIGOSUBGRUPO)) {sLabelColumna=ConsolidadosResumenConstantesFunciones.LABEL_CODIGOSUBGRUPO;}
		if(sNombreColumna.equals(ConsolidadosResumenConstantesFunciones.NOMBRESUBGRUPO)) {sLabelColumna=ConsolidadosResumenConstantesFunciones.LABEL_NOMBRESUBGRUPO;}
		if(sNombreColumna.equals(ConsolidadosResumenConstantesFunciones.CODIGODETALLEGRUPO)) {sLabelColumna=ConsolidadosResumenConstantesFunciones.LABEL_CODIGODETALLEGRUPO;}
		if(sNombreColumna.equals(ConsolidadosResumenConstantesFunciones.NOMBREDETALLEGRUPO)) {sLabelColumna=ConsolidadosResumenConstantesFunciones.LABEL_NOMBREDETALLEGRUPO;}
		if(sNombreColumna.equals(ConsolidadosResumenConstantesFunciones.CLAVE)) {sLabelColumna=ConsolidadosResumenConstantesFunciones.LABEL_CLAVE;}
		if(sNombreColumna.equals(ConsolidadosResumenConstantesFunciones.NOMBRE)) {sLabelColumna=ConsolidadosResumenConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ConsolidadosResumenConstantesFunciones.FECHACOMPRA)) {sLabelColumna=ConsolidadosResumenConstantesFunciones.LABEL_FECHACOMPRA;}
		if(sNombreColumna.equals(ConsolidadosResumenConstantesFunciones.VIDAUTIL)) {sLabelColumna=ConsolidadosResumenConstantesFunciones.LABEL_VIDAUTIL;}
		if(sNombreColumna.equals(ConsolidadosResumenConstantesFunciones.COSTODECOMPRA)) {sLabelColumna=ConsolidadosResumenConstantesFunciones.LABEL_COSTODECOMPRA;}
		if(sNombreColumna.equals(ConsolidadosResumenConstantesFunciones.CANTIDAD)) {sLabelColumna=ConsolidadosResumenConstantesFunciones.LABEL_CANTIDAD;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getConsolidadosResumenDescripcion(ConsolidadosResumen consolidadosresumen) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(consolidadosresumen !=null/* && consolidadosresumen.getId()!=0*/) {
			sDescripcion=consolidadosresumen.getnombre();//consolidadosresumenconsolidadosresumen.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getConsolidadosResumenDescripcionDetallado(ConsolidadosResumen consolidadosresumen) {
		String sDescripcion="";
			
		sDescripcion+=ConsolidadosResumenConstantesFunciones.ID+"=";
		sDescripcion+=consolidadosresumen.getId().toString()+",";
		sDescripcion+=ConsolidadosResumenConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=consolidadosresumen.getVersionRow().toString()+",";
		sDescripcion+=ConsolidadosResumenConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=consolidadosresumen.getid_empresa().toString()+",";
		sDescripcion+=ConsolidadosResumenConstantesFunciones.NOMBREEMPRESA+"=";
		sDescripcion+=consolidadosresumen.getnombre_empresa()+",";
		sDescripcion+=ConsolidadosResumenConstantesFunciones.NOMBRESUCURSAL+"=";
		sDescripcion+=consolidadosresumen.getnombre_sucursal()+",";
		sDescripcion+=ConsolidadosResumenConstantesFunciones.CODIGOSUBGRUPO+"=";
		sDescripcion+=consolidadosresumen.getcodigo_sub_grupo()+",";
		sDescripcion+=ConsolidadosResumenConstantesFunciones.NOMBRESUBGRUPO+"=";
		sDescripcion+=consolidadosresumen.getnombre_sub_grupo()+",";
		sDescripcion+=ConsolidadosResumenConstantesFunciones.CODIGODETALLEGRUPO+"=";
		sDescripcion+=consolidadosresumen.getcodigo_detalle_grupo()+",";
		sDescripcion+=ConsolidadosResumenConstantesFunciones.NOMBREDETALLEGRUPO+"=";
		sDescripcion+=consolidadosresumen.getnombre_detalle_grupo()+",";
		sDescripcion+=ConsolidadosResumenConstantesFunciones.CLAVE+"=";
		sDescripcion+=consolidadosresumen.getclave()+",";
		sDescripcion+=ConsolidadosResumenConstantesFunciones.NOMBRE+"=";
		sDescripcion+=consolidadosresumen.getnombre()+",";
		sDescripcion+=ConsolidadosResumenConstantesFunciones.FECHACOMPRA+"=";
		sDescripcion+=consolidadosresumen.getfecha_compra().toString()+",";
		sDescripcion+=ConsolidadosResumenConstantesFunciones.VIDAUTIL+"=";
		sDescripcion+=consolidadosresumen.getvida_util().toString()+",";
		sDescripcion+=ConsolidadosResumenConstantesFunciones.COSTODECOMPRA+"=";
		sDescripcion+=consolidadosresumen.getcosto_de_compra().toString()+",";
		sDescripcion+=ConsolidadosResumenConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=consolidadosresumen.getcantidad().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setConsolidadosResumenDescripcion(ConsolidadosResumen consolidadosresumen,String sValor) throws Exception {			
		if(consolidadosresumen !=null) {
			consolidadosresumen.setnombre(sValor);;//consolidadosresumenconsolidadosresumen.getnombre().trim();
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
		} else if(sNombreIndice.equals("BusquedaConsolidadosResumen")) {
			sNombreIndice="Tipo=  Por ";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaConsolidadosResumen(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" ="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosConsolidadosResumen(ConsolidadosResumen consolidadosresumen,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		consolidadosresumen.setnombre_empresa(consolidadosresumen.getnombre_empresa().trim());
		consolidadosresumen.setnombre_sucursal(consolidadosresumen.getnombre_sucursal().trim());
		consolidadosresumen.setcodigo_sub_grupo(consolidadosresumen.getcodigo_sub_grupo().trim());
		consolidadosresumen.setnombre_sub_grupo(consolidadosresumen.getnombre_sub_grupo().trim());
		consolidadosresumen.setcodigo_detalle_grupo(consolidadosresumen.getcodigo_detalle_grupo().trim());
		consolidadosresumen.setnombre_detalle_grupo(consolidadosresumen.getnombre_detalle_grupo().trim());
		consolidadosresumen.setclave(consolidadosresumen.getclave().trim());
		consolidadosresumen.setnombre(consolidadosresumen.getnombre().trim());
	}
	
	public static void quitarEspaciosConsolidadosResumens(List<ConsolidadosResumen> consolidadosresumens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ConsolidadosResumen consolidadosresumen: consolidadosresumens) {
			consolidadosresumen.setnombre_empresa(consolidadosresumen.getnombre_empresa().trim());
			consolidadosresumen.setnombre_sucursal(consolidadosresumen.getnombre_sucursal().trim());
			consolidadosresumen.setcodigo_sub_grupo(consolidadosresumen.getcodigo_sub_grupo().trim());
			consolidadosresumen.setnombre_sub_grupo(consolidadosresumen.getnombre_sub_grupo().trim());
			consolidadosresumen.setcodigo_detalle_grupo(consolidadosresumen.getcodigo_detalle_grupo().trim());
			consolidadosresumen.setnombre_detalle_grupo(consolidadosresumen.getnombre_detalle_grupo().trim());
			consolidadosresumen.setclave(consolidadosresumen.getclave().trim());
			consolidadosresumen.setnombre(consolidadosresumen.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConsolidadosResumen(ConsolidadosResumen consolidadosresumen,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && consolidadosresumen.getConCambioAuxiliar()) {
			consolidadosresumen.setIsDeleted(consolidadosresumen.getIsDeletedAuxiliar());	
			consolidadosresumen.setIsNew(consolidadosresumen.getIsNewAuxiliar());	
			consolidadosresumen.setIsChanged(consolidadosresumen.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			consolidadosresumen.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			consolidadosresumen.setIsDeletedAuxiliar(false);	
			consolidadosresumen.setIsNewAuxiliar(false);	
			consolidadosresumen.setIsChangedAuxiliar(false);
			
			consolidadosresumen.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConsolidadosResumens(List<ConsolidadosResumen> consolidadosresumens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ConsolidadosResumen consolidadosresumen : consolidadosresumens) {
			if(conAsignarBase && consolidadosresumen.getConCambioAuxiliar()) {
				consolidadosresumen.setIsDeleted(consolidadosresumen.getIsDeletedAuxiliar());	
				consolidadosresumen.setIsNew(consolidadosresumen.getIsNewAuxiliar());	
				consolidadosresumen.setIsChanged(consolidadosresumen.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				consolidadosresumen.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				consolidadosresumen.setIsDeletedAuxiliar(false);	
				consolidadosresumen.setIsNewAuxiliar(false);	
				consolidadosresumen.setIsChangedAuxiliar(false);
				
				consolidadosresumen.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresConsolidadosResumen(ConsolidadosResumen consolidadosresumen,Boolean conEnteros) throws Exception  {
		consolidadosresumen.setvida_util(0.0);
		consolidadosresumen.setcosto_de_compra(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			consolidadosresumen.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresConsolidadosResumens(List<ConsolidadosResumen> consolidadosresumens,Boolean conEnteros) throws Exception  {
		
		for(ConsolidadosResumen consolidadosresumen: consolidadosresumens) {
			consolidadosresumen.setvida_util(0.0);
			consolidadosresumen.setcosto_de_compra(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				consolidadosresumen.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaConsolidadosResumen(List<ConsolidadosResumen> consolidadosresumens,ConsolidadosResumen consolidadosresumenAux) throws Exception  {
		ConsolidadosResumenConstantesFunciones.InicializarValoresConsolidadosResumen(consolidadosresumenAux,true);
		
		for(ConsolidadosResumen consolidadosresumen: consolidadosresumens) {
			if(consolidadosresumen.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			consolidadosresumenAux.setvida_util(consolidadosresumenAux.getvida_util()+consolidadosresumen.getvida_util());			
			consolidadosresumenAux.setcosto_de_compra(consolidadosresumenAux.getcosto_de_compra()+consolidadosresumen.getcosto_de_compra());			
			consolidadosresumenAux.setcantidad(consolidadosresumenAux.getcantidad()+consolidadosresumen.getcantidad());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesConsolidadosResumen(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ConsolidadosResumenConstantesFunciones.getArrayColumnasGlobalesConsolidadosResumen(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesConsolidadosResumen(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ConsolidadosResumenConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ConsolidadosResumenConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoConsolidadosResumen(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ConsolidadosResumen> consolidadosresumens,ConsolidadosResumen consolidadosresumen,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ConsolidadosResumen consolidadosresumenAux: consolidadosresumens) {
			if(consolidadosresumenAux!=null && consolidadosresumen!=null) {
				if((consolidadosresumenAux.getId()==null && consolidadosresumen.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(consolidadosresumenAux.getId()!=null && consolidadosresumen.getId()!=null){
					if(consolidadosresumenAux.getId().equals(consolidadosresumen.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaConsolidadosResumen(List<ConsolidadosResumen> consolidadosresumens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double vida_utilTotal=0.0;
		Double costo_de_compraTotal=0.0;
	
		for(ConsolidadosResumen consolidadosresumen: consolidadosresumens) {			
			if(consolidadosresumen.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			vida_utilTotal+=consolidadosresumen.getvida_util();
			costo_de_compraTotal+=consolidadosresumen.getcosto_de_compra();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsolidadosResumenConstantesFunciones.VIDAUTIL);
		datoGeneral.setsDescripcion(ConsolidadosResumenConstantesFunciones.LABEL_VIDAUTIL);
		datoGeneral.setdValorDouble(vida_utilTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsolidadosResumenConstantesFunciones.COSTODECOMPRA);
		datoGeneral.setsDescripcion(ConsolidadosResumenConstantesFunciones.LABEL_COSTODECOMPRA);
		datoGeneral.setdValorDouble(costo_de_compraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaConsolidadosResumen() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ConsolidadosResumenConstantesFunciones.LABEL_ID, ConsolidadosResumenConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosResumenConstantesFunciones.LABEL_VERSIONROW, ConsolidadosResumenConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosResumenConstantesFunciones.LABEL_NOMBREEMPRESA, ConsolidadosResumenConstantesFunciones.NOMBREEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosResumenConstantesFunciones.LABEL_NOMBRESUCURSAL, ConsolidadosResumenConstantesFunciones.NOMBRESUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosResumenConstantesFunciones.LABEL_CODIGOSUBGRUPO, ConsolidadosResumenConstantesFunciones.CODIGOSUBGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosResumenConstantesFunciones.LABEL_NOMBRESUBGRUPO, ConsolidadosResumenConstantesFunciones.NOMBRESUBGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosResumenConstantesFunciones.LABEL_CODIGODETALLEGRUPO, ConsolidadosResumenConstantesFunciones.CODIGODETALLEGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosResumenConstantesFunciones.LABEL_NOMBREDETALLEGRUPO, ConsolidadosResumenConstantesFunciones.NOMBREDETALLEGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosResumenConstantesFunciones.LABEL_CLAVE, ConsolidadosResumenConstantesFunciones.CLAVE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosResumenConstantesFunciones.LABEL_NOMBRE, ConsolidadosResumenConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosResumenConstantesFunciones.LABEL_FECHACOMPRA, ConsolidadosResumenConstantesFunciones.FECHACOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosResumenConstantesFunciones.LABEL_VIDAUTIL, ConsolidadosResumenConstantesFunciones.VIDAUTIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosResumenConstantesFunciones.LABEL_COSTODECOMPRA, ConsolidadosResumenConstantesFunciones.COSTODECOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosResumenConstantesFunciones.LABEL_CANTIDAD, ConsolidadosResumenConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasConsolidadosResumen() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosResumenConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosResumenConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosResumenConstantesFunciones.NOMBREEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosResumenConstantesFunciones.NOMBRESUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosResumenConstantesFunciones.CODIGOSUBGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosResumenConstantesFunciones.NOMBRESUBGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosResumenConstantesFunciones.CODIGODETALLEGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosResumenConstantesFunciones.NOMBREDETALLEGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosResumenConstantesFunciones.CLAVE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosResumenConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosResumenConstantesFunciones.FECHACOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosResumenConstantesFunciones.VIDAUTIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosResumenConstantesFunciones.COSTODECOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosResumenConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConsolidadosResumen() throws Exception  {
		return ConsolidadosResumenConstantesFunciones.getTiposSeleccionarConsolidadosResumen(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConsolidadosResumen(Boolean conFk) throws Exception  {
		return ConsolidadosResumenConstantesFunciones.getTiposSeleccionarConsolidadosResumen(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConsolidadosResumen(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosResumenConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ConsolidadosResumenConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosResumenConstantesFunciones.LABEL_NOMBREEMPRESA);
			reporte.setsDescripcion(ConsolidadosResumenConstantesFunciones.LABEL_NOMBREEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosResumenConstantesFunciones.LABEL_NOMBRESUCURSAL);
			reporte.setsDescripcion(ConsolidadosResumenConstantesFunciones.LABEL_NOMBRESUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosResumenConstantesFunciones.LABEL_CODIGOSUBGRUPO);
			reporte.setsDescripcion(ConsolidadosResumenConstantesFunciones.LABEL_CODIGOSUBGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosResumenConstantesFunciones.LABEL_NOMBRESUBGRUPO);
			reporte.setsDescripcion(ConsolidadosResumenConstantesFunciones.LABEL_NOMBRESUBGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosResumenConstantesFunciones.LABEL_CODIGODETALLEGRUPO);
			reporte.setsDescripcion(ConsolidadosResumenConstantesFunciones.LABEL_CODIGODETALLEGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosResumenConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);
			reporte.setsDescripcion(ConsolidadosResumenConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosResumenConstantesFunciones.LABEL_CLAVE);
			reporte.setsDescripcion(ConsolidadosResumenConstantesFunciones.LABEL_CLAVE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosResumenConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ConsolidadosResumenConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosResumenConstantesFunciones.LABEL_FECHACOMPRA);
			reporte.setsDescripcion(ConsolidadosResumenConstantesFunciones.LABEL_FECHACOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosResumenConstantesFunciones.LABEL_VIDAUTIL);
			reporte.setsDescripcion(ConsolidadosResumenConstantesFunciones.LABEL_VIDAUTIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosResumenConstantesFunciones.LABEL_COSTODECOMPRA);
			reporte.setsDescripcion(ConsolidadosResumenConstantesFunciones.LABEL_COSTODECOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosResumenConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(ConsolidadosResumenConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesConsolidadosResumen(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesConsolidadosResumen(ConsolidadosResumen consolidadosresumenAux) throws Exception {
		
			consolidadosresumenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(consolidadosresumenAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesConsolidadosResumen(List<ConsolidadosResumen> consolidadosresumensTemp) throws Exception {
		for(ConsolidadosResumen consolidadosresumenAux:consolidadosresumensTemp) {
			
			consolidadosresumenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(consolidadosresumenAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfConsolidadosResumen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfConsolidadosResumen(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfConsolidadosResumen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConsolidadosResumenConstantesFunciones.getClassesRelationshipsOfConsolidadosResumen(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConsolidadosResumen(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConsolidadosResumen(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConsolidadosResumenConstantesFunciones.getClassesRelationshipsFromStringsOfConsolidadosResumen(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConsolidadosResumen(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ConsolidadosResumen consolidadosresumen,List<ConsolidadosResumen> consolidadosresumens,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ConsolidadosResumen consolidadosresumen,List<ConsolidadosResumen> consolidadosresumens) throws Exception {
		try	{			
			for(ConsolidadosResumen consolidadosresumenLocal:consolidadosresumens) {
				if(consolidadosresumenLocal.getId().equals(consolidadosresumen.getId())) {
					consolidadosresumenLocal.setIsSelected(consolidadosresumen.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesConsolidadosResumen(List<ConsolidadosResumen> consolidadosresumensAux) throws Exception {
		//this.consolidadosresumensAux=consolidadosresumensAux;
		
		for(ConsolidadosResumen consolidadosresumenAux:consolidadosresumensAux) {
			if(consolidadosresumenAux.getIsChanged()) {
				consolidadosresumenAux.setIsChanged(false);
			}		
			
			if(consolidadosresumenAux.getIsNew()) {
				consolidadosresumenAux.setIsNew(false);
			}	
			
			if(consolidadosresumenAux.getIsDeleted()) {
				consolidadosresumenAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesConsolidadosResumen(ConsolidadosResumen consolidadosresumenAux) throws Exception {
		//this.consolidadosresumenAux=consolidadosresumenAux;
		
			if(consolidadosresumenAux.getIsChanged()) {
				consolidadosresumenAux.setIsChanged(false);
			}		
			
			if(consolidadosresumenAux.getIsNew()) {
				consolidadosresumenAux.setIsNew(false);
			}	
			
			if(consolidadosresumenAux.getIsDeleted()) {
				consolidadosresumenAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ConsolidadosResumen consolidadosresumenAsignar,ConsolidadosResumen consolidadosresumen) throws Exception {
		consolidadosresumenAsignar.setId(consolidadosresumen.getId());	
		consolidadosresumenAsignar.setVersionRow(consolidadosresumen.getVersionRow());	
		consolidadosresumenAsignar.setnombre_empresa(consolidadosresumen.getnombre_empresa());	
		consolidadosresumenAsignar.setnombre_sucursal(consolidadosresumen.getnombre_sucursal());	
		consolidadosresumenAsignar.setcodigo_sub_grupo(consolidadosresumen.getcodigo_sub_grupo());	
		consolidadosresumenAsignar.setnombre_sub_grupo(consolidadosresumen.getnombre_sub_grupo());	
		consolidadosresumenAsignar.setcodigo_detalle_grupo(consolidadosresumen.getcodigo_detalle_grupo());	
		consolidadosresumenAsignar.setnombre_detalle_grupo(consolidadosresumen.getnombre_detalle_grupo());	
		consolidadosresumenAsignar.setclave(consolidadosresumen.getclave());	
		consolidadosresumenAsignar.setnombre(consolidadosresumen.getnombre());	
		consolidadosresumenAsignar.setfecha_compra(consolidadosresumen.getfecha_compra());	
		consolidadosresumenAsignar.setvida_util(consolidadosresumen.getvida_util());	
		consolidadosresumenAsignar.setcosto_de_compra(consolidadosresumen.getcosto_de_compra());	
		consolidadosresumenAsignar.setcantidad(consolidadosresumen.getcantidad());	
	}
	
	public static void inicializarConsolidadosResumen(ConsolidadosResumen consolidadosresumen) throws Exception {
		try {
				consolidadosresumen.setId(0L);	
					
				consolidadosresumen.setnombre_empresa("");	
				consolidadosresumen.setnombre_sucursal("");	
				consolidadosresumen.setcodigo_sub_grupo("");	
				consolidadosresumen.setnombre_sub_grupo("");	
				consolidadosresumen.setcodigo_detalle_grupo("");	
				consolidadosresumen.setnombre_detalle_grupo("");	
				consolidadosresumen.setclave("");	
				consolidadosresumen.setnombre("");	
				consolidadosresumen.setfecha_compra(new Date());	
				consolidadosresumen.setvida_util(0.0);	
				consolidadosresumen.setcosto_de_compra(0.0);	
				consolidadosresumen.setcantidad(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderConsolidadosResumen(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosResumenConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosResumenConstantesFunciones.LABEL_NOMBREEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosResumenConstantesFunciones.LABEL_NOMBRESUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosResumenConstantesFunciones.LABEL_CODIGOSUBGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosResumenConstantesFunciones.LABEL_NOMBRESUBGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosResumenConstantesFunciones.LABEL_CODIGODETALLEGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosResumenConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosResumenConstantesFunciones.LABEL_CLAVE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosResumenConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosResumenConstantesFunciones.LABEL_FECHACOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosResumenConstantesFunciones.LABEL_VIDAUTIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosResumenConstantesFunciones.LABEL_COSTODECOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosResumenConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataConsolidadosResumen(String sTipo,Row row,Workbook workbook,ConsolidadosResumen consolidadosresumen,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosresumen.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosresumen.getnombre_empresa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosresumen.getnombre_sucursal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosresumen.getcodigo_sub_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosresumen.getnombre_sub_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosresumen.getcodigo_detalle_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosresumen.getnombre_detalle_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosresumen.getclave());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosresumen.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosresumen.getfecha_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosresumen.getvida_util());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosresumen.getcosto_de_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosresumen.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryConsolidadosResumen="";
	
	public String getsFinalQueryConsolidadosResumen() {
		return this.sFinalQueryConsolidadosResumen;
	}
	
	public void setsFinalQueryConsolidadosResumen(String sFinalQueryConsolidadosResumen) {
		this.sFinalQueryConsolidadosResumen= sFinalQueryConsolidadosResumen;
	}
	
	public Border resaltarSeleccionarConsolidadosResumen=null;
	
	public Border setResaltarSeleccionarConsolidadosResumen(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosResumenBeanSwingJInternalFrame consolidadosresumenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//consolidadosresumenBeanSwingJInternalFrame.jTtoolBarConsolidadosResumen.setBorder(borderResaltar);
		
		this.resaltarSeleccionarConsolidadosResumen= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarConsolidadosResumen() {
		return this.resaltarSeleccionarConsolidadosResumen;
	}
	
	public void setResaltarSeleccionarConsolidadosResumen(Border borderResaltarSeleccionarConsolidadosResumen) {
		this.resaltarSeleccionarConsolidadosResumen= borderResaltarSeleccionarConsolidadosResumen;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridConsolidadosResumen=null;
	public Boolean mostraridConsolidadosResumen=true;
	public Boolean activaridConsolidadosResumen=true;

	public Border resaltarid_empresaConsolidadosResumen=null;
	public Boolean mostrarid_empresaConsolidadosResumen=true;
	public Boolean activarid_empresaConsolidadosResumen=true;
	public Boolean cargarid_empresaConsolidadosResumen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaConsolidadosResumen=false;//ConEventDepend=true

	public Border resaltarnombre_empresaConsolidadosResumen=null;
	public Boolean mostrarnombre_empresaConsolidadosResumen=true;
	public Boolean activarnombre_empresaConsolidadosResumen=true;

	public Border resaltarnombre_sucursalConsolidadosResumen=null;
	public Boolean mostrarnombre_sucursalConsolidadosResumen=true;
	public Boolean activarnombre_sucursalConsolidadosResumen=true;

	public Border resaltarcodigo_sub_grupoConsolidadosResumen=null;
	public Boolean mostrarcodigo_sub_grupoConsolidadosResumen=true;
	public Boolean activarcodigo_sub_grupoConsolidadosResumen=true;

	public Border resaltarnombre_sub_grupoConsolidadosResumen=null;
	public Boolean mostrarnombre_sub_grupoConsolidadosResumen=true;
	public Boolean activarnombre_sub_grupoConsolidadosResumen=true;

	public Border resaltarcodigo_detalle_grupoConsolidadosResumen=null;
	public Boolean mostrarcodigo_detalle_grupoConsolidadosResumen=true;
	public Boolean activarcodigo_detalle_grupoConsolidadosResumen=true;

	public Border resaltarnombre_detalle_grupoConsolidadosResumen=null;
	public Boolean mostrarnombre_detalle_grupoConsolidadosResumen=true;
	public Boolean activarnombre_detalle_grupoConsolidadosResumen=true;

	public Border resaltarclaveConsolidadosResumen=null;
	public Boolean mostrarclaveConsolidadosResumen=true;
	public Boolean activarclaveConsolidadosResumen=true;

	public Border resaltarnombreConsolidadosResumen=null;
	public Boolean mostrarnombreConsolidadosResumen=true;
	public Boolean activarnombreConsolidadosResumen=true;

	public Border resaltarfecha_compraConsolidadosResumen=null;
	public Boolean mostrarfecha_compraConsolidadosResumen=true;
	public Boolean activarfecha_compraConsolidadosResumen=true;

	public Border resaltarvida_utilConsolidadosResumen=null;
	public Boolean mostrarvida_utilConsolidadosResumen=true;
	public Boolean activarvida_utilConsolidadosResumen=true;

	public Border resaltarcosto_de_compraConsolidadosResumen=null;
	public Boolean mostrarcosto_de_compraConsolidadosResumen=true;
	public Boolean activarcosto_de_compraConsolidadosResumen=true;

	public Border resaltarcantidadConsolidadosResumen=null;
	public Boolean mostrarcantidadConsolidadosResumen=true;
	public Boolean activarcantidadConsolidadosResumen=true;

	
	

	public Border setResaltaridConsolidadosResumen(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosResumenBeanSwingJInternalFrame consolidadosresumenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosresumenBeanSwingJInternalFrame.jTtoolBarConsolidadosResumen.setBorder(borderResaltar);
		
		this.resaltaridConsolidadosResumen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridConsolidadosResumen() {
		return this.resaltaridConsolidadosResumen;
	}

	public void setResaltaridConsolidadosResumen(Border borderResaltar) {
		this.resaltaridConsolidadosResumen= borderResaltar;
	}

	public Boolean getMostraridConsolidadosResumen() {
		return this.mostraridConsolidadosResumen;
	}

	public void setMostraridConsolidadosResumen(Boolean mostraridConsolidadosResumen) {
		this.mostraridConsolidadosResumen= mostraridConsolidadosResumen;
	}

	public Boolean getActivaridConsolidadosResumen() {
		return this.activaridConsolidadosResumen;
	}

	public void setActivaridConsolidadosResumen(Boolean activaridConsolidadosResumen) {
		this.activaridConsolidadosResumen= activaridConsolidadosResumen;
	}

	public Border setResaltarid_empresaConsolidadosResumen(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosResumenBeanSwingJInternalFrame consolidadosresumenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosresumenBeanSwingJInternalFrame.jTtoolBarConsolidadosResumen.setBorder(borderResaltar);
		
		this.resaltarid_empresaConsolidadosResumen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaConsolidadosResumen() {
		return this.resaltarid_empresaConsolidadosResumen;
	}

	public void setResaltarid_empresaConsolidadosResumen(Border borderResaltar) {
		this.resaltarid_empresaConsolidadosResumen= borderResaltar;
	}

	public Boolean getMostrarid_empresaConsolidadosResumen() {
		return this.mostrarid_empresaConsolidadosResumen;
	}

	public void setMostrarid_empresaConsolidadosResumen(Boolean mostrarid_empresaConsolidadosResumen) {
		this.mostrarid_empresaConsolidadosResumen= mostrarid_empresaConsolidadosResumen;
	}

	public Boolean getActivarid_empresaConsolidadosResumen() {
		return this.activarid_empresaConsolidadosResumen;
	}

	public void setActivarid_empresaConsolidadosResumen(Boolean activarid_empresaConsolidadosResumen) {
		this.activarid_empresaConsolidadosResumen= activarid_empresaConsolidadosResumen;
	}

	public Boolean getCargarid_empresaConsolidadosResumen() {
		return this.cargarid_empresaConsolidadosResumen;
	}

	public void setCargarid_empresaConsolidadosResumen(Boolean cargarid_empresaConsolidadosResumen) {
		this.cargarid_empresaConsolidadosResumen= cargarid_empresaConsolidadosResumen;
	}

	public Border setResaltarnombre_empresaConsolidadosResumen(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosResumenBeanSwingJInternalFrame consolidadosresumenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosresumenBeanSwingJInternalFrame.jTtoolBarConsolidadosResumen.setBorder(borderResaltar);
		
		this.resaltarnombre_empresaConsolidadosResumen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_empresaConsolidadosResumen() {
		return this.resaltarnombre_empresaConsolidadosResumen;
	}

	public void setResaltarnombre_empresaConsolidadosResumen(Border borderResaltar) {
		this.resaltarnombre_empresaConsolidadosResumen= borderResaltar;
	}

	public Boolean getMostrarnombre_empresaConsolidadosResumen() {
		return this.mostrarnombre_empresaConsolidadosResumen;
	}

	public void setMostrarnombre_empresaConsolidadosResumen(Boolean mostrarnombre_empresaConsolidadosResumen) {
		this.mostrarnombre_empresaConsolidadosResumen= mostrarnombre_empresaConsolidadosResumen;
	}

	public Boolean getActivarnombre_empresaConsolidadosResumen() {
		return this.activarnombre_empresaConsolidadosResumen;
	}

	public void setActivarnombre_empresaConsolidadosResumen(Boolean activarnombre_empresaConsolidadosResumen) {
		this.activarnombre_empresaConsolidadosResumen= activarnombre_empresaConsolidadosResumen;
	}

	public Border setResaltarnombre_sucursalConsolidadosResumen(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosResumenBeanSwingJInternalFrame consolidadosresumenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosresumenBeanSwingJInternalFrame.jTtoolBarConsolidadosResumen.setBorder(borderResaltar);
		
		this.resaltarnombre_sucursalConsolidadosResumen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sucursalConsolidadosResumen() {
		return this.resaltarnombre_sucursalConsolidadosResumen;
	}

	public void setResaltarnombre_sucursalConsolidadosResumen(Border borderResaltar) {
		this.resaltarnombre_sucursalConsolidadosResumen= borderResaltar;
	}

	public Boolean getMostrarnombre_sucursalConsolidadosResumen() {
		return this.mostrarnombre_sucursalConsolidadosResumen;
	}

	public void setMostrarnombre_sucursalConsolidadosResumen(Boolean mostrarnombre_sucursalConsolidadosResumen) {
		this.mostrarnombre_sucursalConsolidadosResumen= mostrarnombre_sucursalConsolidadosResumen;
	}

	public Boolean getActivarnombre_sucursalConsolidadosResumen() {
		return this.activarnombre_sucursalConsolidadosResumen;
	}

	public void setActivarnombre_sucursalConsolidadosResumen(Boolean activarnombre_sucursalConsolidadosResumen) {
		this.activarnombre_sucursalConsolidadosResumen= activarnombre_sucursalConsolidadosResumen;
	}

	public Border setResaltarcodigo_sub_grupoConsolidadosResumen(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosResumenBeanSwingJInternalFrame consolidadosresumenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosresumenBeanSwingJInternalFrame.jTtoolBarConsolidadosResumen.setBorder(borderResaltar);
		
		this.resaltarcodigo_sub_grupoConsolidadosResumen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_sub_grupoConsolidadosResumen() {
		return this.resaltarcodigo_sub_grupoConsolidadosResumen;
	}

	public void setResaltarcodigo_sub_grupoConsolidadosResumen(Border borderResaltar) {
		this.resaltarcodigo_sub_grupoConsolidadosResumen= borderResaltar;
	}

	public Boolean getMostrarcodigo_sub_grupoConsolidadosResumen() {
		return this.mostrarcodigo_sub_grupoConsolidadosResumen;
	}

	public void setMostrarcodigo_sub_grupoConsolidadosResumen(Boolean mostrarcodigo_sub_grupoConsolidadosResumen) {
		this.mostrarcodigo_sub_grupoConsolidadosResumen= mostrarcodigo_sub_grupoConsolidadosResumen;
	}

	public Boolean getActivarcodigo_sub_grupoConsolidadosResumen() {
		return this.activarcodigo_sub_grupoConsolidadosResumen;
	}

	public void setActivarcodigo_sub_grupoConsolidadosResumen(Boolean activarcodigo_sub_grupoConsolidadosResumen) {
		this.activarcodigo_sub_grupoConsolidadosResumen= activarcodigo_sub_grupoConsolidadosResumen;
	}

	public Border setResaltarnombre_sub_grupoConsolidadosResumen(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosResumenBeanSwingJInternalFrame consolidadosresumenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosresumenBeanSwingJInternalFrame.jTtoolBarConsolidadosResumen.setBorder(borderResaltar);
		
		this.resaltarnombre_sub_grupoConsolidadosResumen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sub_grupoConsolidadosResumen() {
		return this.resaltarnombre_sub_grupoConsolidadosResumen;
	}

	public void setResaltarnombre_sub_grupoConsolidadosResumen(Border borderResaltar) {
		this.resaltarnombre_sub_grupoConsolidadosResumen= borderResaltar;
	}

	public Boolean getMostrarnombre_sub_grupoConsolidadosResumen() {
		return this.mostrarnombre_sub_grupoConsolidadosResumen;
	}

	public void setMostrarnombre_sub_grupoConsolidadosResumen(Boolean mostrarnombre_sub_grupoConsolidadosResumen) {
		this.mostrarnombre_sub_grupoConsolidadosResumen= mostrarnombre_sub_grupoConsolidadosResumen;
	}

	public Boolean getActivarnombre_sub_grupoConsolidadosResumen() {
		return this.activarnombre_sub_grupoConsolidadosResumen;
	}

	public void setActivarnombre_sub_grupoConsolidadosResumen(Boolean activarnombre_sub_grupoConsolidadosResumen) {
		this.activarnombre_sub_grupoConsolidadosResumen= activarnombre_sub_grupoConsolidadosResumen;
	}

	public Border setResaltarcodigo_detalle_grupoConsolidadosResumen(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosResumenBeanSwingJInternalFrame consolidadosresumenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosresumenBeanSwingJInternalFrame.jTtoolBarConsolidadosResumen.setBorder(borderResaltar);
		
		this.resaltarcodigo_detalle_grupoConsolidadosResumen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_detalle_grupoConsolidadosResumen() {
		return this.resaltarcodigo_detalle_grupoConsolidadosResumen;
	}

	public void setResaltarcodigo_detalle_grupoConsolidadosResumen(Border borderResaltar) {
		this.resaltarcodigo_detalle_grupoConsolidadosResumen= borderResaltar;
	}

	public Boolean getMostrarcodigo_detalle_grupoConsolidadosResumen() {
		return this.mostrarcodigo_detalle_grupoConsolidadosResumen;
	}

	public void setMostrarcodigo_detalle_grupoConsolidadosResumen(Boolean mostrarcodigo_detalle_grupoConsolidadosResumen) {
		this.mostrarcodigo_detalle_grupoConsolidadosResumen= mostrarcodigo_detalle_grupoConsolidadosResumen;
	}

	public Boolean getActivarcodigo_detalle_grupoConsolidadosResumen() {
		return this.activarcodigo_detalle_grupoConsolidadosResumen;
	}

	public void setActivarcodigo_detalle_grupoConsolidadosResumen(Boolean activarcodigo_detalle_grupoConsolidadosResumen) {
		this.activarcodigo_detalle_grupoConsolidadosResumen= activarcodigo_detalle_grupoConsolidadosResumen;
	}

	public Border setResaltarnombre_detalle_grupoConsolidadosResumen(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosResumenBeanSwingJInternalFrame consolidadosresumenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosresumenBeanSwingJInternalFrame.jTtoolBarConsolidadosResumen.setBorder(borderResaltar);
		
		this.resaltarnombre_detalle_grupoConsolidadosResumen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_detalle_grupoConsolidadosResumen() {
		return this.resaltarnombre_detalle_grupoConsolidadosResumen;
	}

	public void setResaltarnombre_detalle_grupoConsolidadosResumen(Border borderResaltar) {
		this.resaltarnombre_detalle_grupoConsolidadosResumen= borderResaltar;
	}

	public Boolean getMostrarnombre_detalle_grupoConsolidadosResumen() {
		return this.mostrarnombre_detalle_grupoConsolidadosResumen;
	}

	public void setMostrarnombre_detalle_grupoConsolidadosResumen(Boolean mostrarnombre_detalle_grupoConsolidadosResumen) {
		this.mostrarnombre_detalle_grupoConsolidadosResumen= mostrarnombre_detalle_grupoConsolidadosResumen;
	}

	public Boolean getActivarnombre_detalle_grupoConsolidadosResumen() {
		return this.activarnombre_detalle_grupoConsolidadosResumen;
	}

	public void setActivarnombre_detalle_grupoConsolidadosResumen(Boolean activarnombre_detalle_grupoConsolidadosResumen) {
		this.activarnombre_detalle_grupoConsolidadosResumen= activarnombre_detalle_grupoConsolidadosResumen;
	}

	public Border setResaltarclaveConsolidadosResumen(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosResumenBeanSwingJInternalFrame consolidadosresumenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosresumenBeanSwingJInternalFrame.jTtoolBarConsolidadosResumen.setBorder(borderResaltar);
		
		this.resaltarclaveConsolidadosResumen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarclaveConsolidadosResumen() {
		return this.resaltarclaveConsolidadosResumen;
	}

	public void setResaltarclaveConsolidadosResumen(Border borderResaltar) {
		this.resaltarclaveConsolidadosResumen= borderResaltar;
	}

	public Boolean getMostrarclaveConsolidadosResumen() {
		return this.mostrarclaveConsolidadosResumen;
	}

	public void setMostrarclaveConsolidadosResumen(Boolean mostrarclaveConsolidadosResumen) {
		this.mostrarclaveConsolidadosResumen= mostrarclaveConsolidadosResumen;
	}

	public Boolean getActivarclaveConsolidadosResumen() {
		return this.activarclaveConsolidadosResumen;
	}

	public void setActivarclaveConsolidadosResumen(Boolean activarclaveConsolidadosResumen) {
		this.activarclaveConsolidadosResumen= activarclaveConsolidadosResumen;
	}

	public Border setResaltarnombreConsolidadosResumen(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosResumenBeanSwingJInternalFrame consolidadosresumenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosresumenBeanSwingJInternalFrame.jTtoolBarConsolidadosResumen.setBorder(borderResaltar);
		
		this.resaltarnombreConsolidadosResumen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreConsolidadosResumen() {
		return this.resaltarnombreConsolidadosResumen;
	}

	public void setResaltarnombreConsolidadosResumen(Border borderResaltar) {
		this.resaltarnombreConsolidadosResumen= borderResaltar;
	}

	public Boolean getMostrarnombreConsolidadosResumen() {
		return this.mostrarnombreConsolidadosResumen;
	}

	public void setMostrarnombreConsolidadosResumen(Boolean mostrarnombreConsolidadosResumen) {
		this.mostrarnombreConsolidadosResumen= mostrarnombreConsolidadosResumen;
	}

	public Boolean getActivarnombreConsolidadosResumen() {
		return this.activarnombreConsolidadosResumen;
	}

	public void setActivarnombreConsolidadosResumen(Boolean activarnombreConsolidadosResumen) {
		this.activarnombreConsolidadosResumen= activarnombreConsolidadosResumen;
	}

	public Border setResaltarfecha_compraConsolidadosResumen(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosResumenBeanSwingJInternalFrame consolidadosresumenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosresumenBeanSwingJInternalFrame.jTtoolBarConsolidadosResumen.setBorder(borderResaltar);
		
		this.resaltarfecha_compraConsolidadosResumen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_compraConsolidadosResumen() {
		return this.resaltarfecha_compraConsolidadosResumen;
	}

	public void setResaltarfecha_compraConsolidadosResumen(Border borderResaltar) {
		this.resaltarfecha_compraConsolidadosResumen= borderResaltar;
	}

	public Boolean getMostrarfecha_compraConsolidadosResumen() {
		return this.mostrarfecha_compraConsolidadosResumen;
	}

	public void setMostrarfecha_compraConsolidadosResumen(Boolean mostrarfecha_compraConsolidadosResumen) {
		this.mostrarfecha_compraConsolidadosResumen= mostrarfecha_compraConsolidadosResumen;
	}

	public Boolean getActivarfecha_compraConsolidadosResumen() {
		return this.activarfecha_compraConsolidadosResumen;
	}

	public void setActivarfecha_compraConsolidadosResumen(Boolean activarfecha_compraConsolidadosResumen) {
		this.activarfecha_compraConsolidadosResumen= activarfecha_compraConsolidadosResumen;
	}

	public Border setResaltarvida_utilConsolidadosResumen(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosResumenBeanSwingJInternalFrame consolidadosresumenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosresumenBeanSwingJInternalFrame.jTtoolBarConsolidadosResumen.setBorder(borderResaltar);
		
		this.resaltarvida_utilConsolidadosResumen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvida_utilConsolidadosResumen() {
		return this.resaltarvida_utilConsolidadosResumen;
	}

	public void setResaltarvida_utilConsolidadosResumen(Border borderResaltar) {
		this.resaltarvida_utilConsolidadosResumen= borderResaltar;
	}

	public Boolean getMostrarvida_utilConsolidadosResumen() {
		return this.mostrarvida_utilConsolidadosResumen;
	}

	public void setMostrarvida_utilConsolidadosResumen(Boolean mostrarvida_utilConsolidadosResumen) {
		this.mostrarvida_utilConsolidadosResumen= mostrarvida_utilConsolidadosResumen;
	}

	public Boolean getActivarvida_utilConsolidadosResumen() {
		return this.activarvida_utilConsolidadosResumen;
	}

	public void setActivarvida_utilConsolidadosResumen(Boolean activarvida_utilConsolidadosResumen) {
		this.activarvida_utilConsolidadosResumen= activarvida_utilConsolidadosResumen;
	}

	public Border setResaltarcosto_de_compraConsolidadosResumen(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosResumenBeanSwingJInternalFrame consolidadosresumenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosresumenBeanSwingJInternalFrame.jTtoolBarConsolidadosResumen.setBorder(borderResaltar);
		
		this.resaltarcosto_de_compraConsolidadosResumen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_de_compraConsolidadosResumen() {
		return this.resaltarcosto_de_compraConsolidadosResumen;
	}

	public void setResaltarcosto_de_compraConsolidadosResumen(Border borderResaltar) {
		this.resaltarcosto_de_compraConsolidadosResumen= borderResaltar;
	}

	public Boolean getMostrarcosto_de_compraConsolidadosResumen() {
		return this.mostrarcosto_de_compraConsolidadosResumen;
	}

	public void setMostrarcosto_de_compraConsolidadosResumen(Boolean mostrarcosto_de_compraConsolidadosResumen) {
		this.mostrarcosto_de_compraConsolidadosResumen= mostrarcosto_de_compraConsolidadosResumen;
	}

	public Boolean getActivarcosto_de_compraConsolidadosResumen() {
		return this.activarcosto_de_compraConsolidadosResumen;
	}

	public void setActivarcosto_de_compraConsolidadosResumen(Boolean activarcosto_de_compraConsolidadosResumen) {
		this.activarcosto_de_compraConsolidadosResumen= activarcosto_de_compraConsolidadosResumen;
	}

	public Border setResaltarcantidadConsolidadosResumen(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosResumenBeanSwingJInternalFrame consolidadosresumenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosresumenBeanSwingJInternalFrame.jTtoolBarConsolidadosResumen.setBorder(borderResaltar);
		
		this.resaltarcantidadConsolidadosResumen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadConsolidadosResumen() {
		return this.resaltarcantidadConsolidadosResumen;
	}

	public void setResaltarcantidadConsolidadosResumen(Border borderResaltar) {
		this.resaltarcantidadConsolidadosResumen= borderResaltar;
	}

	public Boolean getMostrarcantidadConsolidadosResumen() {
		return this.mostrarcantidadConsolidadosResumen;
	}

	public void setMostrarcantidadConsolidadosResumen(Boolean mostrarcantidadConsolidadosResumen) {
		this.mostrarcantidadConsolidadosResumen= mostrarcantidadConsolidadosResumen;
	}

	public Boolean getActivarcantidadConsolidadosResumen() {
		return this.activarcantidadConsolidadosResumen;
	}

	public void setActivarcantidadConsolidadosResumen(Boolean activarcantidadConsolidadosResumen) {
		this.activarcantidadConsolidadosResumen= activarcantidadConsolidadosResumen;
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
		
		
		this.setMostraridConsolidadosResumen(esInicial);
		this.setMostrarid_empresaConsolidadosResumen(esInicial);
		this.setMostrarnombre_empresaConsolidadosResumen(esInicial);
		this.setMostrarnombre_sucursalConsolidadosResumen(esInicial);
		this.setMostrarcodigo_sub_grupoConsolidadosResumen(esInicial);
		this.setMostrarnombre_sub_grupoConsolidadosResumen(esInicial);
		this.setMostrarcodigo_detalle_grupoConsolidadosResumen(esInicial);
		this.setMostrarnombre_detalle_grupoConsolidadosResumen(esInicial);
		this.setMostrarclaveConsolidadosResumen(esInicial);
		this.setMostrarnombreConsolidadosResumen(esInicial);
		this.setMostrarfecha_compraConsolidadosResumen(esInicial);
		this.setMostrarvida_utilConsolidadosResumen(esInicial);
		this.setMostrarcosto_de_compraConsolidadosResumen(esInicial);
		this.setMostrarcantidadConsolidadosResumen(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.ID)) {
				this.setMostraridConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.NOMBREEMPRESA)) {
				this.setMostrarnombre_empresaConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.NOMBRESUCURSAL)) {
				this.setMostrarnombre_sucursalConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setMostrarcodigo_sub_grupoConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setMostrarnombre_sub_grupoConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setMostrarcodigo_detalle_grupoConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setMostrarnombre_detalle_grupoConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.CLAVE)) {
				this.setMostrarclaveConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.FECHACOMPRA)) {
				this.setMostrarfecha_compraConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.VIDAUTIL)) {
				this.setMostrarvida_utilConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.COSTODECOMPRA)) {
				this.setMostrarcosto_de_compraConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadConsolidadosResumen(esAsigna);
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
		
		
		this.setActivaridConsolidadosResumen(esInicial);
		this.setActivarid_empresaConsolidadosResumen(esInicial);
		this.setActivarnombre_empresaConsolidadosResumen(esInicial);
		this.setActivarnombre_sucursalConsolidadosResumen(esInicial);
		this.setActivarcodigo_sub_grupoConsolidadosResumen(esInicial);
		this.setActivarnombre_sub_grupoConsolidadosResumen(esInicial);
		this.setActivarcodigo_detalle_grupoConsolidadosResumen(esInicial);
		this.setActivarnombre_detalle_grupoConsolidadosResumen(esInicial);
		this.setActivarclaveConsolidadosResumen(esInicial);
		this.setActivarnombreConsolidadosResumen(esInicial);
		this.setActivarfecha_compraConsolidadosResumen(esInicial);
		this.setActivarvida_utilConsolidadosResumen(esInicial);
		this.setActivarcosto_de_compraConsolidadosResumen(esInicial);
		this.setActivarcantidadConsolidadosResumen(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.ID)) {
				this.setActivaridConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.NOMBREEMPRESA)) {
				this.setActivarnombre_empresaConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.NOMBRESUCURSAL)) {
				this.setActivarnombre_sucursalConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setActivarcodigo_sub_grupoConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setActivarnombre_sub_grupoConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setActivarcodigo_detalle_grupoConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setActivarnombre_detalle_grupoConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.CLAVE)) {
				this.setActivarclaveConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.NOMBRE)) {
				this.setActivarnombreConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.FECHACOMPRA)) {
				this.setActivarfecha_compraConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.VIDAUTIL)) {
				this.setActivarvida_utilConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.COSTODECOMPRA)) {
				this.setActivarcosto_de_compraConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadConsolidadosResumen(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ConsolidadosResumenBeanSwingJInternalFrame consolidadosresumenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridConsolidadosResumen(esInicial);
		this.setResaltarid_empresaConsolidadosResumen(esInicial);
		this.setResaltarnombre_empresaConsolidadosResumen(esInicial);
		this.setResaltarnombre_sucursalConsolidadosResumen(esInicial);
		this.setResaltarcodigo_sub_grupoConsolidadosResumen(esInicial);
		this.setResaltarnombre_sub_grupoConsolidadosResumen(esInicial);
		this.setResaltarcodigo_detalle_grupoConsolidadosResumen(esInicial);
		this.setResaltarnombre_detalle_grupoConsolidadosResumen(esInicial);
		this.setResaltarclaveConsolidadosResumen(esInicial);
		this.setResaltarnombreConsolidadosResumen(esInicial);
		this.setResaltarfecha_compraConsolidadosResumen(esInicial);
		this.setResaltarvida_utilConsolidadosResumen(esInicial);
		this.setResaltarcosto_de_compraConsolidadosResumen(esInicial);
		this.setResaltarcantidadConsolidadosResumen(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.ID)) {
				this.setResaltaridConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.NOMBREEMPRESA)) {
				this.setResaltarnombre_empresaConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.NOMBRESUCURSAL)) {
				this.setResaltarnombre_sucursalConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setResaltarcodigo_sub_grupoConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setResaltarnombre_sub_grupoConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setResaltarcodigo_detalle_grupoConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setResaltarnombre_detalle_grupoConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.CLAVE)) {
				this.setResaltarclaveConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.FECHACOMPRA)) {
				this.setResaltarfecha_compraConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.VIDAUTIL)) {
				this.setResaltarvida_utilConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.COSTODECOMPRA)) {
				this.setResaltarcosto_de_compraConsolidadosResumen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosResumenConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadConsolidadosResumen(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ConsolidadosResumenBeanSwingJInternalFrame consolidadosresumenBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaConsolidadosResumenConsolidadosResumen=true;

	public Boolean getMostrarBusquedaConsolidadosResumenConsolidadosResumen() {
		return this.mostrarBusquedaConsolidadosResumenConsolidadosResumen;
	}

	public void setMostrarBusquedaConsolidadosResumenConsolidadosResumen(Boolean visibilidadResaltar) {
		this.mostrarBusquedaConsolidadosResumenConsolidadosResumen= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaConsolidadosResumenConsolidadosResumen=true;

	public Boolean getActivarBusquedaConsolidadosResumenConsolidadosResumen() {
		return this.activarBusquedaConsolidadosResumenConsolidadosResumen;
	}

	public void setActivarBusquedaConsolidadosResumenConsolidadosResumen(Boolean habilitarResaltar) {
		this.activarBusquedaConsolidadosResumenConsolidadosResumen= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaConsolidadosResumenConsolidadosResumen=null;

	public Border getResaltarBusquedaConsolidadosResumenConsolidadosResumen() {
		return this.resaltarBusquedaConsolidadosResumenConsolidadosResumen;
	}

	public void setResaltarBusquedaConsolidadosResumenConsolidadosResumen(Border borderResaltar) {
		this.resaltarBusquedaConsolidadosResumenConsolidadosResumen= borderResaltar;
	}

	public void setResaltarBusquedaConsolidadosResumenConsolidadosResumen(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosResumenBeanSwingJInternalFrame consolidadosresumenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaConsolidadosResumenConsolidadosResumen= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}