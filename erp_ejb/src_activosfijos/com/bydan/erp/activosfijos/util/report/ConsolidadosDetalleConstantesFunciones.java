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


import com.bydan.erp.activosfijos.util.report.ConsolidadosDetalleConstantesFunciones;
import com.bydan.erp.activosfijos.util.report.ConsolidadosDetalleParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.ConsolidadosDetalleParameterGeneral;

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
final public class ConsolidadosDetalleConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ConsolidadosDetalle";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ConsolidadosDetalle"+ConsolidadosDetalleConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ConsolidadosDetalleHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ConsolidadosDetalleHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ConsolidadosDetalleConstantesFunciones.SCHEMA+"_"+ConsolidadosDetalleConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ConsolidadosDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ConsolidadosDetalleConstantesFunciones.SCHEMA+"_"+ConsolidadosDetalleConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ConsolidadosDetalleConstantesFunciones.SCHEMA+"_"+ConsolidadosDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ConsolidadosDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ConsolidadosDetalleConstantesFunciones.SCHEMA+"_"+ConsolidadosDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsolidadosDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConsolidadosDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsolidadosDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsolidadosDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConsolidadosDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsolidadosDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ConsolidadosDetalleConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ConsolidadosDetalleConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ConsolidadosDetalleConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ConsolidadosDetalleConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Consolidados Detalles";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Consolidados Detalle";
	public static final String SCLASSWEBTITULO_LOWER="Consolidados Detalle";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ConsolidadosDetalle";
	public static final String OBJECTNAME="consolidadosdetalle";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="consolidados_detalle";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select consolidadosdetalle from "+ConsolidadosDetalleConstantesFunciones.SPERSISTENCENAME+" consolidadosdetalle";
	public static String QUERYSELECTNATIVE="select "+ConsolidadosDetalleConstantesFunciones.SCHEMA+"."+ConsolidadosDetalleConstantesFunciones.TABLENAME+".id,"+ConsolidadosDetalleConstantesFunciones.SCHEMA+"."+ConsolidadosDetalleConstantesFunciones.TABLENAME+".version_row,"+ConsolidadosDetalleConstantesFunciones.SCHEMA+"."+ConsolidadosDetalleConstantesFunciones.TABLENAME+".id_empresa,"+ConsolidadosDetalleConstantesFunciones.SCHEMA+"."+ConsolidadosDetalleConstantesFunciones.TABLENAME+".nombre_empresa,"+ConsolidadosDetalleConstantesFunciones.SCHEMA+"."+ConsolidadosDetalleConstantesFunciones.TABLENAME+".nombre_sucursal,"+ConsolidadosDetalleConstantesFunciones.SCHEMA+"."+ConsolidadosDetalleConstantesFunciones.TABLENAME+".codigo_sub_grupo,"+ConsolidadosDetalleConstantesFunciones.SCHEMA+"."+ConsolidadosDetalleConstantesFunciones.TABLENAME+".nombre_sub_grupo,"+ConsolidadosDetalleConstantesFunciones.SCHEMA+"."+ConsolidadosDetalleConstantesFunciones.TABLENAME+".codigo_detalle_grupo,"+ConsolidadosDetalleConstantesFunciones.SCHEMA+"."+ConsolidadosDetalleConstantesFunciones.TABLENAME+".nombre_detalle_grupo,"+ConsolidadosDetalleConstantesFunciones.SCHEMA+"."+ConsolidadosDetalleConstantesFunciones.TABLENAME+".clave,"+ConsolidadosDetalleConstantesFunciones.SCHEMA+"."+ConsolidadosDetalleConstantesFunciones.TABLENAME+".nombre,"+ConsolidadosDetalleConstantesFunciones.SCHEMA+"."+ConsolidadosDetalleConstantesFunciones.TABLENAME+".fecha_compra,"+ConsolidadosDetalleConstantesFunciones.SCHEMA+"."+ConsolidadosDetalleConstantesFunciones.TABLENAME+".vida_util,"+ConsolidadosDetalleConstantesFunciones.SCHEMA+"."+ConsolidadosDetalleConstantesFunciones.TABLENAME+".costo_de_compra,"+ConsolidadosDetalleConstantesFunciones.SCHEMA+"."+ConsolidadosDetalleConstantesFunciones.TABLENAME+".cantidad from "+ConsolidadosDetalleConstantesFunciones.SCHEMA+"."+ConsolidadosDetalleConstantesFunciones.TABLENAME;//+" as "+ConsolidadosDetalleConstantesFunciones.TABLENAME;
	
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
		
		
		
		
	
	public static String getConsolidadosDetalleLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ConsolidadosDetalleConstantesFunciones.IDEMPRESA)) {sLabelColumna=ConsolidadosDetalleConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ConsolidadosDetalleConstantesFunciones.NOMBREEMPRESA)) {sLabelColumna=ConsolidadosDetalleConstantesFunciones.LABEL_NOMBREEMPRESA;}
		if(sNombreColumna.equals(ConsolidadosDetalleConstantesFunciones.NOMBRESUCURSAL)) {sLabelColumna=ConsolidadosDetalleConstantesFunciones.LABEL_NOMBRESUCURSAL;}
		if(sNombreColumna.equals(ConsolidadosDetalleConstantesFunciones.CODIGOSUBGRUPO)) {sLabelColumna=ConsolidadosDetalleConstantesFunciones.LABEL_CODIGOSUBGRUPO;}
		if(sNombreColumna.equals(ConsolidadosDetalleConstantesFunciones.NOMBRESUBGRUPO)) {sLabelColumna=ConsolidadosDetalleConstantesFunciones.LABEL_NOMBRESUBGRUPO;}
		if(sNombreColumna.equals(ConsolidadosDetalleConstantesFunciones.CODIGODETALLEGRUPO)) {sLabelColumna=ConsolidadosDetalleConstantesFunciones.LABEL_CODIGODETALLEGRUPO;}
		if(sNombreColumna.equals(ConsolidadosDetalleConstantesFunciones.NOMBREDETALLEGRUPO)) {sLabelColumna=ConsolidadosDetalleConstantesFunciones.LABEL_NOMBREDETALLEGRUPO;}
		if(sNombreColumna.equals(ConsolidadosDetalleConstantesFunciones.CLAVE)) {sLabelColumna=ConsolidadosDetalleConstantesFunciones.LABEL_CLAVE;}
		if(sNombreColumna.equals(ConsolidadosDetalleConstantesFunciones.NOMBRE)) {sLabelColumna=ConsolidadosDetalleConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ConsolidadosDetalleConstantesFunciones.FECHACOMPRA)) {sLabelColumna=ConsolidadosDetalleConstantesFunciones.LABEL_FECHACOMPRA;}
		if(sNombreColumna.equals(ConsolidadosDetalleConstantesFunciones.VIDAUTIL)) {sLabelColumna=ConsolidadosDetalleConstantesFunciones.LABEL_VIDAUTIL;}
		if(sNombreColumna.equals(ConsolidadosDetalleConstantesFunciones.COSTODECOMPRA)) {sLabelColumna=ConsolidadosDetalleConstantesFunciones.LABEL_COSTODECOMPRA;}
		if(sNombreColumna.equals(ConsolidadosDetalleConstantesFunciones.CANTIDAD)) {sLabelColumna=ConsolidadosDetalleConstantesFunciones.LABEL_CANTIDAD;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getConsolidadosDetalleDescripcion(ConsolidadosDetalle consolidadosdetalle) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(consolidadosdetalle !=null/* && consolidadosdetalle.getId()!=0*/) {
			sDescripcion=consolidadosdetalle.getnombre();//consolidadosdetalleconsolidadosdetalle.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getConsolidadosDetalleDescripcionDetallado(ConsolidadosDetalle consolidadosdetalle) {
		String sDescripcion="";
			
		sDescripcion+=ConsolidadosDetalleConstantesFunciones.ID+"=";
		sDescripcion+=consolidadosdetalle.getId().toString()+",";
		sDescripcion+=ConsolidadosDetalleConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=consolidadosdetalle.getVersionRow().toString()+",";
		sDescripcion+=ConsolidadosDetalleConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=consolidadosdetalle.getid_empresa().toString()+",";
		sDescripcion+=ConsolidadosDetalleConstantesFunciones.NOMBREEMPRESA+"=";
		sDescripcion+=consolidadosdetalle.getnombre_empresa()+",";
		sDescripcion+=ConsolidadosDetalleConstantesFunciones.NOMBRESUCURSAL+"=";
		sDescripcion+=consolidadosdetalle.getnombre_sucursal()+",";
		sDescripcion+=ConsolidadosDetalleConstantesFunciones.CODIGOSUBGRUPO+"=";
		sDescripcion+=consolidadosdetalle.getcodigo_sub_grupo()+",";
		sDescripcion+=ConsolidadosDetalleConstantesFunciones.NOMBRESUBGRUPO+"=";
		sDescripcion+=consolidadosdetalle.getnombre_sub_grupo()+",";
		sDescripcion+=ConsolidadosDetalleConstantesFunciones.CODIGODETALLEGRUPO+"=";
		sDescripcion+=consolidadosdetalle.getcodigo_detalle_grupo()+",";
		sDescripcion+=ConsolidadosDetalleConstantesFunciones.NOMBREDETALLEGRUPO+"=";
		sDescripcion+=consolidadosdetalle.getnombre_detalle_grupo()+",";
		sDescripcion+=ConsolidadosDetalleConstantesFunciones.CLAVE+"=";
		sDescripcion+=consolidadosdetalle.getclave()+",";
		sDescripcion+=ConsolidadosDetalleConstantesFunciones.NOMBRE+"=";
		sDescripcion+=consolidadosdetalle.getnombre()+",";
		sDescripcion+=ConsolidadosDetalleConstantesFunciones.FECHACOMPRA+"=";
		sDescripcion+=consolidadosdetalle.getfecha_compra().toString()+",";
		sDescripcion+=ConsolidadosDetalleConstantesFunciones.VIDAUTIL+"=";
		sDescripcion+=consolidadosdetalle.getvida_util().toString()+",";
		sDescripcion+=ConsolidadosDetalleConstantesFunciones.COSTODECOMPRA+"=";
		sDescripcion+=consolidadosdetalle.getcosto_de_compra().toString()+",";
		sDescripcion+=ConsolidadosDetalleConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=consolidadosdetalle.getcantidad().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setConsolidadosDetalleDescripcion(ConsolidadosDetalle consolidadosdetalle,String sValor) throws Exception {			
		if(consolidadosdetalle !=null) {
			consolidadosdetalle.setnombre(sValor);;//consolidadosdetalleconsolidadosdetalle.getnombre().trim();
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
		} else if(sNombreIndice.equals("BusquedaConsolidadosDetalle")) {
			sNombreIndice="Tipo=  Por ";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaConsolidadosDetalle(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" ="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosConsolidadosDetalle(ConsolidadosDetalle consolidadosdetalle,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		consolidadosdetalle.setnombre_empresa(consolidadosdetalle.getnombre_empresa().trim());
		consolidadosdetalle.setnombre_sucursal(consolidadosdetalle.getnombre_sucursal().trim());
		consolidadosdetalle.setcodigo_sub_grupo(consolidadosdetalle.getcodigo_sub_grupo().trim());
		consolidadosdetalle.setnombre_sub_grupo(consolidadosdetalle.getnombre_sub_grupo().trim());
		consolidadosdetalle.setcodigo_detalle_grupo(consolidadosdetalle.getcodigo_detalle_grupo().trim());
		consolidadosdetalle.setnombre_detalle_grupo(consolidadosdetalle.getnombre_detalle_grupo().trim());
		consolidadosdetalle.setclave(consolidadosdetalle.getclave().trim());
		consolidadosdetalle.setnombre(consolidadosdetalle.getnombre().trim());
	}
	
	public static void quitarEspaciosConsolidadosDetalles(List<ConsolidadosDetalle> consolidadosdetalles,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ConsolidadosDetalle consolidadosdetalle: consolidadosdetalles) {
			consolidadosdetalle.setnombre_empresa(consolidadosdetalle.getnombre_empresa().trim());
			consolidadosdetalle.setnombre_sucursal(consolidadosdetalle.getnombre_sucursal().trim());
			consolidadosdetalle.setcodigo_sub_grupo(consolidadosdetalle.getcodigo_sub_grupo().trim());
			consolidadosdetalle.setnombre_sub_grupo(consolidadosdetalle.getnombre_sub_grupo().trim());
			consolidadosdetalle.setcodigo_detalle_grupo(consolidadosdetalle.getcodigo_detalle_grupo().trim());
			consolidadosdetalle.setnombre_detalle_grupo(consolidadosdetalle.getnombre_detalle_grupo().trim());
			consolidadosdetalle.setclave(consolidadosdetalle.getclave().trim());
			consolidadosdetalle.setnombre(consolidadosdetalle.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConsolidadosDetalle(ConsolidadosDetalle consolidadosdetalle,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && consolidadosdetalle.getConCambioAuxiliar()) {
			consolidadosdetalle.setIsDeleted(consolidadosdetalle.getIsDeletedAuxiliar());	
			consolidadosdetalle.setIsNew(consolidadosdetalle.getIsNewAuxiliar());	
			consolidadosdetalle.setIsChanged(consolidadosdetalle.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			consolidadosdetalle.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			consolidadosdetalle.setIsDeletedAuxiliar(false);	
			consolidadosdetalle.setIsNewAuxiliar(false);	
			consolidadosdetalle.setIsChangedAuxiliar(false);
			
			consolidadosdetalle.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConsolidadosDetalles(List<ConsolidadosDetalle> consolidadosdetalles,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ConsolidadosDetalle consolidadosdetalle : consolidadosdetalles) {
			if(conAsignarBase && consolidadosdetalle.getConCambioAuxiliar()) {
				consolidadosdetalle.setIsDeleted(consolidadosdetalle.getIsDeletedAuxiliar());	
				consolidadosdetalle.setIsNew(consolidadosdetalle.getIsNewAuxiliar());	
				consolidadosdetalle.setIsChanged(consolidadosdetalle.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				consolidadosdetalle.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				consolidadosdetalle.setIsDeletedAuxiliar(false);	
				consolidadosdetalle.setIsNewAuxiliar(false);	
				consolidadosdetalle.setIsChangedAuxiliar(false);
				
				consolidadosdetalle.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresConsolidadosDetalle(ConsolidadosDetalle consolidadosdetalle,Boolean conEnteros) throws Exception  {
		consolidadosdetalle.setvida_util(0.0);
		consolidadosdetalle.setcosto_de_compra(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			consolidadosdetalle.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresConsolidadosDetalles(List<ConsolidadosDetalle> consolidadosdetalles,Boolean conEnteros) throws Exception  {
		
		for(ConsolidadosDetalle consolidadosdetalle: consolidadosdetalles) {
			consolidadosdetalle.setvida_util(0.0);
			consolidadosdetalle.setcosto_de_compra(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				consolidadosdetalle.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaConsolidadosDetalle(List<ConsolidadosDetalle> consolidadosdetalles,ConsolidadosDetalle consolidadosdetalleAux) throws Exception  {
		ConsolidadosDetalleConstantesFunciones.InicializarValoresConsolidadosDetalle(consolidadosdetalleAux,true);
		
		for(ConsolidadosDetalle consolidadosdetalle: consolidadosdetalles) {
			if(consolidadosdetalle.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			consolidadosdetalleAux.setvida_util(consolidadosdetalleAux.getvida_util()+consolidadosdetalle.getvida_util());			
			consolidadosdetalleAux.setcosto_de_compra(consolidadosdetalleAux.getcosto_de_compra()+consolidadosdetalle.getcosto_de_compra());			
			consolidadosdetalleAux.setcantidad(consolidadosdetalleAux.getcantidad()+consolidadosdetalle.getcantidad());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesConsolidadosDetalle(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ConsolidadosDetalleConstantesFunciones.getArrayColumnasGlobalesConsolidadosDetalle(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesConsolidadosDetalle(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ConsolidadosDetalleConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ConsolidadosDetalleConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoConsolidadosDetalle(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ConsolidadosDetalle> consolidadosdetalles,ConsolidadosDetalle consolidadosdetalle,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ConsolidadosDetalle consolidadosdetalleAux: consolidadosdetalles) {
			if(consolidadosdetalleAux!=null && consolidadosdetalle!=null) {
				if((consolidadosdetalleAux.getId()==null && consolidadosdetalle.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(consolidadosdetalleAux.getId()!=null && consolidadosdetalle.getId()!=null){
					if(consolidadosdetalleAux.getId().equals(consolidadosdetalle.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaConsolidadosDetalle(List<ConsolidadosDetalle> consolidadosdetalles) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double vida_utilTotal=0.0;
		Double costo_de_compraTotal=0.0;
	
		for(ConsolidadosDetalle consolidadosdetalle: consolidadosdetalles) {			
			if(consolidadosdetalle.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			vida_utilTotal+=consolidadosdetalle.getvida_util();
			costo_de_compraTotal+=consolidadosdetalle.getcosto_de_compra();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsolidadosDetalleConstantesFunciones.VIDAUTIL);
		datoGeneral.setsDescripcion(ConsolidadosDetalleConstantesFunciones.LABEL_VIDAUTIL);
		datoGeneral.setdValorDouble(vida_utilTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsolidadosDetalleConstantesFunciones.COSTODECOMPRA);
		datoGeneral.setsDescripcion(ConsolidadosDetalleConstantesFunciones.LABEL_COSTODECOMPRA);
		datoGeneral.setdValorDouble(costo_de_compraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaConsolidadosDetalle() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ConsolidadosDetalleConstantesFunciones.LABEL_ID, ConsolidadosDetalleConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosDetalleConstantesFunciones.LABEL_VERSIONROW, ConsolidadosDetalleConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosDetalleConstantesFunciones.LABEL_NOMBREEMPRESA, ConsolidadosDetalleConstantesFunciones.NOMBREEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosDetalleConstantesFunciones.LABEL_NOMBRESUCURSAL, ConsolidadosDetalleConstantesFunciones.NOMBRESUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosDetalleConstantesFunciones.LABEL_CODIGOSUBGRUPO, ConsolidadosDetalleConstantesFunciones.CODIGOSUBGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosDetalleConstantesFunciones.LABEL_NOMBRESUBGRUPO, ConsolidadosDetalleConstantesFunciones.NOMBRESUBGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosDetalleConstantesFunciones.LABEL_CODIGODETALLEGRUPO, ConsolidadosDetalleConstantesFunciones.CODIGODETALLEGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosDetalleConstantesFunciones.LABEL_NOMBREDETALLEGRUPO, ConsolidadosDetalleConstantesFunciones.NOMBREDETALLEGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosDetalleConstantesFunciones.LABEL_CLAVE, ConsolidadosDetalleConstantesFunciones.CLAVE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosDetalleConstantesFunciones.LABEL_NOMBRE, ConsolidadosDetalleConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosDetalleConstantesFunciones.LABEL_FECHACOMPRA, ConsolidadosDetalleConstantesFunciones.FECHACOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosDetalleConstantesFunciones.LABEL_VIDAUTIL, ConsolidadosDetalleConstantesFunciones.VIDAUTIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosDetalleConstantesFunciones.LABEL_COSTODECOMPRA, ConsolidadosDetalleConstantesFunciones.COSTODECOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsolidadosDetalleConstantesFunciones.LABEL_CANTIDAD, ConsolidadosDetalleConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasConsolidadosDetalle() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosDetalleConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosDetalleConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosDetalleConstantesFunciones.NOMBREEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosDetalleConstantesFunciones.NOMBRESUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosDetalleConstantesFunciones.CODIGOSUBGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosDetalleConstantesFunciones.NOMBRESUBGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosDetalleConstantesFunciones.CODIGODETALLEGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosDetalleConstantesFunciones.NOMBREDETALLEGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosDetalleConstantesFunciones.CLAVE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosDetalleConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosDetalleConstantesFunciones.FECHACOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosDetalleConstantesFunciones.VIDAUTIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosDetalleConstantesFunciones.COSTODECOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsolidadosDetalleConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConsolidadosDetalle() throws Exception  {
		return ConsolidadosDetalleConstantesFunciones.getTiposSeleccionarConsolidadosDetalle(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConsolidadosDetalle(Boolean conFk) throws Exception  {
		return ConsolidadosDetalleConstantesFunciones.getTiposSeleccionarConsolidadosDetalle(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConsolidadosDetalle(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosDetalleConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ConsolidadosDetalleConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosDetalleConstantesFunciones.LABEL_NOMBREEMPRESA);
			reporte.setsDescripcion(ConsolidadosDetalleConstantesFunciones.LABEL_NOMBREEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosDetalleConstantesFunciones.LABEL_NOMBRESUCURSAL);
			reporte.setsDescripcion(ConsolidadosDetalleConstantesFunciones.LABEL_NOMBRESUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosDetalleConstantesFunciones.LABEL_CODIGOSUBGRUPO);
			reporte.setsDescripcion(ConsolidadosDetalleConstantesFunciones.LABEL_CODIGOSUBGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosDetalleConstantesFunciones.LABEL_NOMBRESUBGRUPO);
			reporte.setsDescripcion(ConsolidadosDetalleConstantesFunciones.LABEL_NOMBRESUBGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosDetalleConstantesFunciones.LABEL_CODIGODETALLEGRUPO);
			reporte.setsDescripcion(ConsolidadosDetalleConstantesFunciones.LABEL_CODIGODETALLEGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosDetalleConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);
			reporte.setsDescripcion(ConsolidadosDetalleConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosDetalleConstantesFunciones.LABEL_CLAVE);
			reporte.setsDescripcion(ConsolidadosDetalleConstantesFunciones.LABEL_CLAVE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosDetalleConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ConsolidadosDetalleConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosDetalleConstantesFunciones.LABEL_FECHACOMPRA);
			reporte.setsDescripcion(ConsolidadosDetalleConstantesFunciones.LABEL_FECHACOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosDetalleConstantesFunciones.LABEL_VIDAUTIL);
			reporte.setsDescripcion(ConsolidadosDetalleConstantesFunciones.LABEL_VIDAUTIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosDetalleConstantesFunciones.LABEL_COSTODECOMPRA);
			reporte.setsDescripcion(ConsolidadosDetalleConstantesFunciones.LABEL_COSTODECOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsolidadosDetalleConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(ConsolidadosDetalleConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesConsolidadosDetalle(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesConsolidadosDetalle(ConsolidadosDetalle consolidadosdetalleAux) throws Exception {
		
			consolidadosdetalleAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(consolidadosdetalleAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesConsolidadosDetalle(List<ConsolidadosDetalle> consolidadosdetallesTemp) throws Exception {
		for(ConsolidadosDetalle consolidadosdetalleAux:consolidadosdetallesTemp) {
			
			consolidadosdetalleAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(consolidadosdetalleAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfConsolidadosDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfConsolidadosDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfConsolidadosDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConsolidadosDetalleConstantesFunciones.getClassesRelationshipsOfConsolidadosDetalle(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConsolidadosDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConsolidadosDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConsolidadosDetalleConstantesFunciones.getClassesRelationshipsFromStringsOfConsolidadosDetalle(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConsolidadosDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ConsolidadosDetalle consolidadosdetalle,List<ConsolidadosDetalle> consolidadosdetalles,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ConsolidadosDetalle consolidadosdetalle,List<ConsolidadosDetalle> consolidadosdetalles) throws Exception {
		try	{			
			for(ConsolidadosDetalle consolidadosdetalleLocal:consolidadosdetalles) {
				if(consolidadosdetalleLocal.getId().equals(consolidadosdetalle.getId())) {
					consolidadosdetalleLocal.setIsSelected(consolidadosdetalle.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesConsolidadosDetalle(List<ConsolidadosDetalle> consolidadosdetallesAux) throws Exception {
		//this.consolidadosdetallesAux=consolidadosdetallesAux;
		
		for(ConsolidadosDetalle consolidadosdetalleAux:consolidadosdetallesAux) {
			if(consolidadosdetalleAux.getIsChanged()) {
				consolidadosdetalleAux.setIsChanged(false);
			}		
			
			if(consolidadosdetalleAux.getIsNew()) {
				consolidadosdetalleAux.setIsNew(false);
			}	
			
			if(consolidadosdetalleAux.getIsDeleted()) {
				consolidadosdetalleAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesConsolidadosDetalle(ConsolidadosDetalle consolidadosdetalleAux) throws Exception {
		//this.consolidadosdetalleAux=consolidadosdetalleAux;
		
			if(consolidadosdetalleAux.getIsChanged()) {
				consolidadosdetalleAux.setIsChanged(false);
			}		
			
			if(consolidadosdetalleAux.getIsNew()) {
				consolidadosdetalleAux.setIsNew(false);
			}	
			
			if(consolidadosdetalleAux.getIsDeleted()) {
				consolidadosdetalleAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ConsolidadosDetalle consolidadosdetalleAsignar,ConsolidadosDetalle consolidadosdetalle) throws Exception {
		consolidadosdetalleAsignar.setId(consolidadosdetalle.getId());	
		consolidadosdetalleAsignar.setVersionRow(consolidadosdetalle.getVersionRow());	
		consolidadosdetalleAsignar.setnombre_empresa(consolidadosdetalle.getnombre_empresa());	
		consolidadosdetalleAsignar.setnombre_sucursal(consolidadosdetalle.getnombre_sucursal());	
		consolidadosdetalleAsignar.setcodigo_sub_grupo(consolidadosdetalle.getcodigo_sub_grupo());	
		consolidadosdetalleAsignar.setnombre_sub_grupo(consolidadosdetalle.getnombre_sub_grupo());	
		consolidadosdetalleAsignar.setcodigo_detalle_grupo(consolidadosdetalle.getcodigo_detalle_grupo());	
		consolidadosdetalleAsignar.setnombre_detalle_grupo(consolidadosdetalle.getnombre_detalle_grupo());	
		consolidadosdetalleAsignar.setclave(consolidadosdetalle.getclave());	
		consolidadosdetalleAsignar.setnombre(consolidadosdetalle.getnombre());	
		consolidadosdetalleAsignar.setfecha_compra(consolidadosdetalle.getfecha_compra());	
		consolidadosdetalleAsignar.setvida_util(consolidadosdetalle.getvida_util());	
		consolidadosdetalleAsignar.setcosto_de_compra(consolidadosdetalle.getcosto_de_compra());	
		consolidadosdetalleAsignar.setcantidad(consolidadosdetalle.getcantidad());	
	}
	
	public static void inicializarConsolidadosDetalle(ConsolidadosDetalle consolidadosdetalle) throws Exception {
		try {
				consolidadosdetalle.setId(0L);	
					
				consolidadosdetalle.setnombre_empresa("");	
				consolidadosdetalle.setnombre_sucursal("");	
				consolidadosdetalle.setcodigo_sub_grupo("");	
				consolidadosdetalle.setnombre_sub_grupo("");	
				consolidadosdetalle.setcodigo_detalle_grupo("");	
				consolidadosdetalle.setnombre_detalle_grupo("");	
				consolidadosdetalle.setclave("");	
				consolidadosdetalle.setnombre("");	
				consolidadosdetalle.setfecha_compra(new Date());	
				consolidadosdetalle.setvida_util(0.0);	
				consolidadosdetalle.setcosto_de_compra(0.0);	
				consolidadosdetalle.setcantidad(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderConsolidadosDetalle(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosDetalleConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosDetalleConstantesFunciones.LABEL_NOMBREEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosDetalleConstantesFunciones.LABEL_NOMBRESUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosDetalleConstantesFunciones.LABEL_CODIGOSUBGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosDetalleConstantesFunciones.LABEL_NOMBRESUBGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosDetalleConstantesFunciones.LABEL_CODIGODETALLEGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosDetalleConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosDetalleConstantesFunciones.LABEL_CLAVE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosDetalleConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosDetalleConstantesFunciones.LABEL_FECHACOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosDetalleConstantesFunciones.LABEL_VIDAUTIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosDetalleConstantesFunciones.LABEL_COSTODECOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsolidadosDetalleConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataConsolidadosDetalle(String sTipo,Row row,Workbook workbook,ConsolidadosDetalle consolidadosdetalle,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosdetalle.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosdetalle.getnombre_empresa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosdetalle.getnombre_sucursal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosdetalle.getcodigo_sub_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosdetalle.getnombre_sub_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosdetalle.getcodigo_detalle_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosdetalle.getnombre_detalle_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosdetalle.getclave());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosdetalle.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosdetalle.getfecha_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosdetalle.getvida_util());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosdetalle.getcosto_de_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consolidadosdetalle.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryConsolidadosDetalle="";
	
	public String getsFinalQueryConsolidadosDetalle() {
		return this.sFinalQueryConsolidadosDetalle;
	}
	
	public void setsFinalQueryConsolidadosDetalle(String sFinalQueryConsolidadosDetalle) {
		this.sFinalQueryConsolidadosDetalle= sFinalQueryConsolidadosDetalle;
	}
	
	public Border resaltarSeleccionarConsolidadosDetalle=null;
	
	public Border setResaltarSeleccionarConsolidadosDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosDetalleBeanSwingJInternalFrame consolidadosdetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//consolidadosdetalleBeanSwingJInternalFrame.jTtoolBarConsolidadosDetalle.setBorder(borderResaltar);
		
		this.resaltarSeleccionarConsolidadosDetalle= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarConsolidadosDetalle() {
		return this.resaltarSeleccionarConsolidadosDetalle;
	}
	
	public void setResaltarSeleccionarConsolidadosDetalle(Border borderResaltarSeleccionarConsolidadosDetalle) {
		this.resaltarSeleccionarConsolidadosDetalle= borderResaltarSeleccionarConsolidadosDetalle;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridConsolidadosDetalle=null;
	public Boolean mostraridConsolidadosDetalle=true;
	public Boolean activaridConsolidadosDetalle=true;

	public Border resaltarid_empresaConsolidadosDetalle=null;
	public Boolean mostrarid_empresaConsolidadosDetalle=true;
	public Boolean activarid_empresaConsolidadosDetalle=true;
	public Boolean cargarid_empresaConsolidadosDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaConsolidadosDetalle=false;//ConEventDepend=true

	public Border resaltarnombre_empresaConsolidadosDetalle=null;
	public Boolean mostrarnombre_empresaConsolidadosDetalle=true;
	public Boolean activarnombre_empresaConsolidadosDetalle=true;

	public Border resaltarnombre_sucursalConsolidadosDetalle=null;
	public Boolean mostrarnombre_sucursalConsolidadosDetalle=true;
	public Boolean activarnombre_sucursalConsolidadosDetalle=true;

	public Border resaltarcodigo_sub_grupoConsolidadosDetalle=null;
	public Boolean mostrarcodigo_sub_grupoConsolidadosDetalle=true;
	public Boolean activarcodigo_sub_grupoConsolidadosDetalle=true;

	public Border resaltarnombre_sub_grupoConsolidadosDetalle=null;
	public Boolean mostrarnombre_sub_grupoConsolidadosDetalle=true;
	public Boolean activarnombre_sub_grupoConsolidadosDetalle=true;

	public Border resaltarcodigo_detalle_grupoConsolidadosDetalle=null;
	public Boolean mostrarcodigo_detalle_grupoConsolidadosDetalle=true;
	public Boolean activarcodigo_detalle_grupoConsolidadosDetalle=true;

	public Border resaltarnombre_detalle_grupoConsolidadosDetalle=null;
	public Boolean mostrarnombre_detalle_grupoConsolidadosDetalle=true;
	public Boolean activarnombre_detalle_grupoConsolidadosDetalle=true;

	public Border resaltarclaveConsolidadosDetalle=null;
	public Boolean mostrarclaveConsolidadosDetalle=true;
	public Boolean activarclaveConsolidadosDetalle=true;

	public Border resaltarnombreConsolidadosDetalle=null;
	public Boolean mostrarnombreConsolidadosDetalle=true;
	public Boolean activarnombreConsolidadosDetalle=true;

	public Border resaltarfecha_compraConsolidadosDetalle=null;
	public Boolean mostrarfecha_compraConsolidadosDetalle=true;
	public Boolean activarfecha_compraConsolidadosDetalle=true;

	public Border resaltarvida_utilConsolidadosDetalle=null;
	public Boolean mostrarvida_utilConsolidadosDetalle=true;
	public Boolean activarvida_utilConsolidadosDetalle=true;

	public Border resaltarcosto_de_compraConsolidadosDetalle=null;
	public Boolean mostrarcosto_de_compraConsolidadosDetalle=true;
	public Boolean activarcosto_de_compraConsolidadosDetalle=true;

	public Border resaltarcantidadConsolidadosDetalle=null;
	public Boolean mostrarcantidadConsolidadosDetalle=true;
	public Boolean activarcantidadConsolidadosDetalle=true;

	
	

	public Border setResaltaridConsolidadosDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosDetalleBeanSwingJInternalFrame consolidadosdetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosdetalleBeanSwingJInternalFrame.jTtoolBarConsolidadosDetalle.setBorder(borderResaltar);
		
		this.resaltaridConsolidadosDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridConsolidadosDetalle() {
		return this.resaltaridConsolidadosDetalle;
	}

	public void setResaltaridConsolidadosDetalle(Border borderResaltar) {
		this.resaltaridConsolidadosDetalle= borderResaltar;
	}

	public Boolean getMostraridConsolidadosDetalle() {
		return this.mostraridConsolidadosDetalle;
	}

	public void setMostraridConsolidadosDetalle(Boolean mostraridConsolidadosDetalle) {
		this.mostraridConsolidadosDetalle= mostraridConsolidadosDetalle;
	}

	public Boolean getActivaridConsolidadosDetalle() {
		return this.activaridConsolidadosDetalle;
	}

	public void setActivaridConsolidadosDetalle(Boolean activaridConsolidadosDetalle) {
		this.activaridConsolidadosDetalle= activaridConsolidadosDetalle;
	}

	public Border setResaltarid_empresaConsolidadosDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosDetalleBeanSwingJInternalFrame consolidadosdetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosdetalleBeanSwingJInternalFrame.jTtoolBarConsolidadosDetalle.setBorder(borderResaltar);
		
		this.resaltarid_empresaConsolidadosDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaConsolidadosDetalle() {
		return this.resaltarid_empresaConsolidadosDetalle;
	}

	public void setResaltarid_empresaConsolidadosDetalle(Border borderResaltar) {
		this.resaltarid_empresaConsolidadosDetalle= borderResaltar;
	}

	public Boolean getMostrarid_empresaConsolidadosDetalle() {
		return this.mostrarid_empresaConsolidadosDetalle;
	}

	public void setMostrarid_empresaConsolidadosDetalle(Boolean mostrarid_empresaConsolidadosDetalle) {
		this.mostrarid_empresaConsolidadosDetalle= mostrarid_empresaConsolidadosDetalle;
	}

	public Boolean getActivarid_empresaConsolidadosDetalle() {
		return this.activarid_empresaConsolidadosDetalle;
	}

	public void setActivarid_empresaConsolidadosDetalle(Boolean activarid_empresaConsolidadosDetalle) {
		this.activarid_empresaConsolidadosDetalle= activarid_empresaConsolidadosDetalle;
	}

	public Boolean getCargarid_empresaConsolidadosDetalle() {
		return this.cargarid_empresaConsolidadosDetalle;
	}

	public void setCargarid_empresaConsolidadosDetalle(Boolean cargarid_empresaConsolidadosDetalle) {
		this.cargarid_empresaConsolidadosDetalle= cargarid_empresaConsolidadosDetalle;
	}

	public Border setResaltarnombre_empresaConsolidadosDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosDetalleBeanSwingJInternalFrame consolidadosdetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosdetalleBeanSwingJInternalFrame.jTtoolBarConsolidadosDetalle.setBorder(borderResaltar);
		
		this.resaltarnombre_empresaConsolidadosDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_empresaConsolidadosDetalle() {
		return this.resaltarnombre_empresaConsolidadosDetalle;
	}

	public void setResaltarnombre_empresaConsolidadosDetalle(Border borderResaltar) {
		this.resaltarnombre_empresaConsolidadosDetalle= borderResaltar;
	}

	public Boolean getMostrarnombre_empresaConsolidadosDetalle() {
		return this.mostrarnombre_empresaConsolidadosDetalle;
	}

	public void setMostrarnombre_empresaConsolidadosDetalle(Boolean mostrarnombre_empresaConsolidadosDetalle) {
		this.mostrarnombre_empresaConsolidadosDetalle= mostrarnombre_empresaConsolidadosDetalle;
	}

	public Boolean getActivarnombre_empresaConsolidadosDetalle() {
		return this.activarnombre_empresaConsolidadosDetalle;
	}

	public void setActivarnombre_empresaConsolidadosDetalle(Boolean activarnombre_empresaConsolidadosDetalle) {
		this.activarnombre_empresaConsolidadosDetalle= activarnombre_empresaConsolidadosDetalle;
	}

	public Border setResaltarnombre_sucursalConsolidadosDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosDetalleBeanSwingJInternalFrame consolidadosdetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosdetalleBeanSwingJInternalFrame.jTtoolBarConsolidadosDetalle.setBorder(borderResaltar);
		
		this.resaltarnombre_sucursalConsolidadosDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sucursalConsolidadosDetalle() {
		return this.resaltarnombre_sucursalConsolidadosDetalle;
	}

	public void setResaltarnombre_sucursalConsolidadosDetalle(Border borderResaltar) {
		this.resaltarnombre_sucursalConsolidadosDetalle= borderResaltar;
	}

	public Boolean getMostrarnombre_sucursalConsolidadosDetalle() {
		return this.mostrarnombre_sucursalConsolidadosDetalle;
	}

	public void setMostrarnombre_sucursalConsolidadosDetalle(Boolean mostrarnombre_sucursalConsolidadosDetalle) {
		this.mostrarnombre_sucursalConsolidadosDetalle= mostrarnombre_sucursalConsolidadosDetalle;
	}

	public Boolean getActivarnombre_sucursalConsolidadosDetalle() {
		return this.activarnombre_sucursalConsolidadosDetalle;
	}

	public void setActivarnombre_sucursalConsolidadosDetalle(Boolean activarnombre_sucursalConsolidadosDetalle) {
		this.activarnombre_sucursalConsolidadosDetalle= activarnombre_sucursalConsolidadosDetalle;
	}

	public Border setResaltarcodigo_sub_grupoConsolidadosDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosDetalleBeanSwingJInternalFrame consolidadosdetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosdetalleBeanSwingJInternalFrame.jTtoolBarConsolidadosDetalle.setBorder(borderResaltar);
		
		this.resaltarcodigo_sub_grupoConsolidadosDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_sub_grupoConsolidadosDetalle() {
		return this.resaltarcodigo_sub_grupoConsolidadosDetalle;
	}

	public void setResaltarcodigo_sub_grupoConsolidadosDetalle(Border borderResaltar) {
		this.resaltarcodigo_sub_grupoConsolidadosDetalle= borderResaltar;
	}

	public Boolean getMostrarcodigo_sub_grupoConsolidadosDetalle() {
		return this.mostrarcodigo_sub_grupoConsolidadosDetalle;
	}

	public void setMostrarcodigo_sub_grupoConsolidadosDetalle(Boolean mostrarcodigo_sub_grupoConsolidadosDetalle) {
		this.mostrarcodigo_sub_grupoConsolidadosDetalle= mostrarcodigo_sub_grupoConsolidadosDetalle;
	}

	public Boolean getActivarcodigo_sub_grupoConsolidadosDetalle() {
		return this.activarcodigo_sub_grupoConsolidadosDetalle;
	}

	public void setActivarcodigo_sub_grupoConsolidadosDetalle(Boolean activarcodigo_sub_grupoConsolidadosDetalle) {
		this.activarcodigo_sub_grupoConsolidadosDetalle= activarcodigo_sub_grupoConsolidadosDetalle;
	}

	public Border setResaltarnombre_sub_grupoConsolidadosDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosDetalleBeanSwingJInternalFrame consolidadosdetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosdetalleBeanSwingJInternalFrame.jTtoolBarConsolidadosDetalle.setBorder(borderResaltar);
		
		this.resaltarnombre_sub_grupoConsolidadosDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sub_grupoConsolidadosDetalle() {
		return this.resaltarnombre_sub_grupoConsolidadosDetalle;
	}

	public void setResaltarnombre_sub_grupoConsolidadosDetalle(Border borderResaltar) {
		this.resaltarnombre_sub_grupoConsolidadosDetalle= borderResaltar;
	}

	public Boolean getMostrarnombre_sub_grupoConsolidadosDetalle() {
		return this.mostrarnombre_sub_grupoConsolidadosDetalle;
	}

	public void setMostrarnombre_sub_grupoConsolidadosDetalle(Boolean mostrarnombre_sub_grupoConsolidadosDetalle) {
		this.mostrarnombre_sub_grupoConsolidadosDetalle= mostrarnombre_sub_grupoConsolidadosDetalle;
	}

	public Boolean getActivarnombre_sub_grupoConsolidadosDetalle() {
		return this.activarnombre_sub_grupoConsolidadosDetalle;
	}

	public void setActivarnombre_sub_grupoConsolidadosDetalle(Boolean activarnombre_sub_grupoConsolidadosDetalle) {
		this.activarnombre_sub_grupoConsolidadosDetalle= activarnombre_sub_grupoConsolidadosDetalle;
	}

	public Border setResaltarcodigo_detalle_grupoConsolidadosDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosDetalleBeanSwingJInternalFrame consolidadosdetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosdetalleBeanSwingJInternalFrame.jTtoolBarConsolidadosDetalle.setBorder(borderResaltar);
		
		this.resaltarcodigo_detalle_grupoConsolidadosDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_detalle_grupoConsolidadosDetalle() {
		return this.resaltarcodigo_detalle_grupoConsolidadosDetalle;
	}

	public void setResaltarcodigo_detalle_grupoConsolidadosDetalle(Border borderResaltar) {
		this.resaltarcodigo_detalle_grupoConsolidadosDetalle= borderResaltar;
	}

	public Boolean getMostrarcodigo_detalle_grupoConsolidadosDetalle() {
		return this.mostrarcodigo_detalle_grupoConsolidadosDetalle;
	}

	public void setMostrarcodigo_detalle_grupoConsolidadosDetalle(Boolean mostrarcodigo_detalle_grupoConsolidadosDetalle) {
		this.mostrarcodigo_detalle_grupoConsolidadosDetalle= mostrarcodigo_detalle_grupoConsolidadosDetalle;
	}

	public Boolean getActivarcodigo_detalle_grupoConsolidadosDetalle() {
		return this.activarcodigo_detalle_grupoConsolidadosDetalle;
	}

	public void setActivarcodigo_detalle_grupoConsolidadosDetalle(Boolean activarcodigo_detalle_grupoConsolidadosDetalle) {
		this.activarcodigo_detalle_grupoConsolidadosDetalle= activarcodigo_detalle_grupoConsolidadosDetalle;
	}

	public Border setResaltarnombre_detalle_grupoConsolidadosDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosDetalleBeanSwingJInternalFrame consolidadosdetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosdetalleBeanSwingJInternalFrame.jTtoolBarConsolidadosDetalle.setBorder(borderResaltar);
		
		this.resaltarnombre_detalle_grupoConsolidadosDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_detalle_grupoConsolidadosDetalle() {
		return this.resaltarnombre_detalle_grupoConsolidadosDetalle;
	}

	public void setResaltarnombre_detalle_grupoConsolidadosDetalle(Border borderResaltar) {
		this.resaltarnombre_detalle_grupoConsolidadosDetalle= borderResaltar;
	}

	public Boolean getMostrarnombre_detalle_grupoConsolidadosDetalle() {
		return this.mostrarnombre_detalle_grupoConsolidadosDetalle;
	}

	public void setMostrarnombre_detalle_grupoConsolidadosDetalle(Boolean mostrarnombre_detalle_grupoConsolidadosDetalle) {
		this.mostrarnombre_detalle_grupoConsolidadosDetalle= mostrarnombre_detalle_grupoConsolidadosDetalle;
	}

	public Boolean getActivarnombre_detalle_grupoConsolidadosDetalle() {
		return this.activarnombre_detalle_grupoConsolidadosDetalle;
	}

	public void setActivarnombre_detalle_grupoConsolidadosDetalle(Boolean activarnombre_detalle_grupoConsolidadosDetalle) {
		this.activarnombre_detalle_grupoConsolidadosDetalle= activarnombre_detalle_grupoConsolidadosDetalle;
	}

	public Border setResaltarclaveConsolidadosDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosDetalleBeanSwingJInternalFrame consolidadosdetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosdetalleBeanSwingJInternalFrame.jTtoolBarConsolidadosDetalle.setBorder(borderResaltar);
		
		this.resaltarclaveConsolidadosDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarclaveConsolidadosDetalle() {
		return this.resaltarclaveConsolidadosDetalle;
	}

	public void setResaltarclaveConsolidadosDetalle(Border borderResaltar) {
		this.resaltarclaveConsolidadosDetalle= borderResaltar;
	}

	public Boolean getMostrarclaveConsolidadosDetalle() {
		return this.mostrarclaveConsolidadosDetalle;
	}

	public void setMostrarclaveConsolidadosDetalle(Boolean mostrarclaveConsolidadosDetalle) {
		this.mostrarclaveConsolidadosDetalle= mostrarclaveConsolidadosDetalle;
	}

	public Boolean getActivarclaveConsolidadosDetalle() {
		return this.activarclaveConsolidadosDetalle;
	}

	public void setActivarclaveConsolidadosDetalle(Boolean activarclaveConsolidadosDetalle) {
		this.activarclaveConsolidadosDetalle= activarclaveConsolidadosDetalle;
	}

	public Border setResaltarnombreConsolidadosDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosDetalleBeanSwingJInternalFrame consolidadosdetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosdetalleBeanSwingJInternalFrame.jTtoolBarConsolidadosDetalle.setBorder(borderResaltar);
		
		this.resaltarnombreConsolidadosDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreConsolidadosDetalle() {
		return this.resaltarnombreConsolidadosDetalle;
	}

	public void setResaltarnombreConsolidadosDetalle(Border borderResaltar) {
		this.resaltarnombreConsolidadosDetalle= borderResaltar;
	}

	public Boolean getMostrarnombreConsolidadosDetalle() {
		return this.mostrarnombreConsolidadosDetalle;
	}

	public void setMostrarnombreConsolidadosDetalle(Boolean mostrarnombreConsolidadosDetalle) {
		this.mostrarnombreConsolidadosDetalle= mostrarnombreConsolidadosDetalle;
	}

	public Boolean getActivarnombreConsolidadosDetalle() {
		return this.activarnombreConsolidadosDetalle;
	}

	public void setActivarnombreConsolidadosDetalle(Boolean activarnombreConsolidadosDetalle) {
		this.activarnombreConsolidadosDetalle= activarnombreConsolidadosDetalle;
	}

	public Border setResaltarfecha_compraConsolidadosDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosDetalleBeanSwingJInternalFrame consolidadosdetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosdetalleBeanSwingJInternalFrame.jTtoolBarConsolidadosDetalle.setBorder(borderResaltar);
		
		this.resaltarfecha_compraConsolidadosDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_compraConsolidadosDetalle() {
		return this.resaltarfecha_compraConsolidadosDetalle;
	}

	public void setResaltarfecha_compraConsolidadosDetalle(Border borderResaltar) {
		this.resaltarfecha_compraConsolidadosDetalle= borderResaltar;
	}

	public Boolean getMostrarfecha_compraConsolidadosDetalle() {
		return this.mostrarfecha_compraConsolidadosDetalle;
	}

	public void setMostrarfecha_compraConsolidadosDetalle(Boolean mostrarfecha_compraConsolidadosDetalle) {
		this.mostrarfecha_compraConsolidadosDetalle= mostrarfecha_compraConsolidadosDetalle;
	}

	public Boolean getActivarfecha_compraConsolidadosDetalle() {
		return this.activarfecha_compraConsolidadosDetalle;
	}

	public void setActivarfecha_compraConsolidadosDetalle(Boolean activarfecha_compraConsolidadosDetalle) {
		this.activarfecha_compraConsolidadosDetalle= activarfecha_compraConsolidadosDetalle;
	}

	public Border setResaltarvida_utilConsolidadosDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosDetalleBeanSwingJInternalFrame consolidadosdetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosdetalleBeanSwingJInternalFrame.jTtoolBarConsolidadosDetalle.setBorder(borderResaltar);
		
		this.resaltarvida_utilConsolidadosDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvida_utilConsolidadosDetalle() {
		return this.resaltarvida_utilConsolidadosDetalle;
	}

	public void setResaltarvida_utilConsolidadosDetalle(Border borderResaltar) {
		this.resaltarvida_utilConsolidadosDetalle= borderResaltar;
	}

	public Boolean getMostrarvida_utilConsolidadosDetalle() {
		return this.mostrarvida_utilConsolidadosDetalle;
	}

	public void setMostrarvida_utilConsolidadosDetalle(Boolean mostrarvida_utilConsolidadosDetalle) {
		this.mostrarvida_utilConsolidadosDetalle= mostrarvida_utilConsolidadosDetalle;
	}

	public Boolean getActivarvida_utilConsolidadosDetalle() {
		return this.activarvida_utilConsolidadosDetalle;
	}

	public void setActivarvida_utilConsolidadosDetalle(Boolean activarvida_utilConsolidadosDetalle) {
		this.activarvida_utilConsolidadosDetalle= activarvida_utilConsolidadosDetalle;
	}

	public Border setResaltarcosto_de_compraConsolidadosDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosDetalleBeanSwingJInternalFrame consolidadosdetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosdetalleBeanSwingJInternalFrame.jTtoolBarConsolidadosDetalle.setBorder(borderResaltar);
		
		this.resaltarcosto_de_compraConsolidadosDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_de_compraConsolidadosDetalle() {
		return this.resaltarcosto_de_compraConsolidadosDetalle;
	}

	public void setResaltarcosto_de_compraConsolidadosDetalle(Border borderResaltar) {
		this.resaltarcosto_de_compraConsolidadosDetalle= borderResaltar;
	}

	public Boolean getMostrarcosto_de_compraConsolidadosDetalle() {
		return this.mostrarcosto_de_compraConsolidadosDetalle;
	}

	public void setMostrarcosto_de_compraConsolidadosDetalle(Boolean mostrarcosto_de_compraConsolidadosDetalle) {
		this.mostrarcosto_de_compraConsolidadosDetalle= mostrarcosto_de_compraConsolidadosDetalle;
	}

	public Boolean getActivarcosto_de_compraConsolidadosDetalle() {
		return this.activarcosto_de_compraConsolidadosDetalle;
	}

	public void setActivarcosto_de_compraConsolidadosDetalle(Boolean activarcosto_de_compraConsolidadosDetalle) {
		this.activarcosto_de_compraConsolidadosDetalle= activarcosto_de_compraConsolidadosDetalle;
	}

	public Border setResaltarcantidadConsolidadosDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosDetalleBeanSwingJInternalFrame consolidadosdetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consolidadosdetalleBeanSwingJInternalFrame.jTtoolBarConsolidadosDetalle.setBorder(borderResaltar);
		
		this.resaltarcantidadConsolidadosDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadConsolidadosDetalle() {
		return this.resaltarcantidadConsolidadosDetalle;
	}

	public void setResaltarcantidadConsolidadosDetalle(Border borderResaltar) {
		this.resaltarcantidadConsolidadosDetalle= borderResaltar;
	}

	public Boolean getMostrarcantidadConsolidadosDetalle() {
		return this.mostrarcantidadConsolidadosDetalle;
	}

	public void setMostrarcantidadConsolidadosDetalle(Boolean mostrarcantidadConsolidadosDetalle) {
		this.mostrarcantidadConsolidadosDetalle= mostrarcantidadConsolidadosDetalle;
	}

	public Boolean getActivarcantidadConsolidadosDetalle() {
		return this.activarcantidadConsolidadosDetalle;
	}

	public void setActivarcantidadConsolidadosDetalle(Boolean activarcantidadConsolidadosDetalle) {
		this.activarcantidadConsolidadosDetalle= activarcantidadConsolidadosDetalle;
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
		
		
		this.setMostraridConsolidadosDetalle(esInicial);
		this.setMostrarid_empresaConsolidadosDetalle(esInicial);
		this.setMostrarnombre_empresaConsolidadosDetalle(esInicial);
		this.setMostrarnombre_sucursalConsolidadosDetalle(esInicial);
		this.setMostrarcodigo_sub_grupoConsolidadosDetalle(esInicial);
		this.setMostrarnombre_sub_grupoConsolidadosDetalle(esInicial);
		this.setMostrarcodigo_detalle_grupoConsolidadosDetalle(esInicial);
		this.setMostrarnombre_detalle_grupoConsolidadosDetalle(esInicial);
		this.setMostrarclaveConsolidadosDetalle(esInicial);
		this.setMostrarnombreConsolidadosDetalle(esInicial);
		this.setMostrarfecha_compraConsolidadosDetalle(esInicial);
		this.setMostrarvida_utilConsolidadosDetalle(esInicial);
		this.setMostrarcosto_de_compraConsolidadosDetalle(esInicial);
		this.setMostrarcantidadConsolidadosDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.ID)) {
				this.setMostraridConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.NOMBREEMPRESA)) {
				this.setMostrarnombre_empresaConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.NOMBRESUCURSAL)) {
				this.setMostrarnombre_sucursalConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setMostrarcodigo_sub_grupoConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setMostrarnombre_sub_grupoConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setMostrarcodigo_detalle_grupoConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setMostrarnombre_detalle_grupoConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.CLAVE)) {
				this.setMostrarclaveConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.FECHACOMPRA)) {
				this.setMostrarfecha_compraConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.VIDAUTIL)) {
				this.setMostrarvida_utilConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.COSTODECOMPRA)) {
				this.setMostrarcosto_de_compraConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadConsolidadosDetalle(esAsigna);
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
		
		
		this.setActivaridConsolidadosDetalle(esInicial);
		this.setActivarid_empresaConsolidadosDetalle(esInicial);
		this.setActivarnombre_empresaConsolidadosDetalle(esInicial);
		this.setActivarnombre_sucursalConsolidadosDetalle(esInicial);
		this.setActivarcodigo_sub_grupoConsolidadosDetalle(esInicial);
		this.setActivarnombre_sub_grupoConsolidadosDetalle(esInicial);
		this.setActivarcodigo_detalle_grupoConsolidadosDetalle(esInicial);
		this.setActivarnombre_detalle_grupoConsolidadosDetalle(esInicial);
		this.setActivarclaveConsolidadosDetalle(esInicial);
		this.setActivarnombreConsolidadosDetalle(esInicial);
		this.setActivarfecha_compraConsolidadosDetalle(esInicial);
		this.setActivarvida_utilConsolidadosDetalle(esInicial);
		this.setActivarcosto_de_compraConsolidadosDetalle(esInicial);
		this.setActivarcantidadConsolidadosDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.ID)) {
				this.setActivaridConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.NOMBREEMPRESA)) {
				this.setActivarnombre_empresaConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.NOMBRESUCURSAL)) {
				this.setActivarnombre_sucursalConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setActivarcodigo_sub_grupoConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setActivarnombre_sub_grupoConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setActivarcodigo_detalle_grupoConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setActivarnombre_detalle_grupoConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.CLAVE)) {
				this.setActivarclaveConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.NOMBRE)) {
				this.setActivarnombreConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.FECHACOMPRA)) {
				this.setActivarfecha_compraConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.VIDAUTIL)) {
				this.setActivarvida_utilConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.COSTODECOMPRA)) {
				this.setActivarcosto_de_compraConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadConsolidadosDetalle(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ConsolidadosDetalleBeanSwingJInternalFrame consolidadosdetalleBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridConsolidadosDetalle(esInicial);
		this.setResaltarid_empresaConsolidadosDetalle(esInicial);
		this.setResaltarnombre_empresaConsolidadosDetalle(esInicial);
		this.setResaltarnombre_sucursalConsolidadosDetalle(esInicial);
		this.setResaltarcodigo_sub_grupoConsolidadosDetalle(esInicial);
		this.setResaltarnombre_sub_grupoConsolidadosDetalle(esInicial);
		this.setResaltarcodigo_detalle_grupoConsolidadosDetalle(esInicial);
		this.setResaltarnombre_detalle_grupoConsolidadosDetalle(esInicial);
		this.setResaltarclaveConsolidadosDetalle(esInicial);
		this.setResaltarnombreConsolidadosDetalle(esInicial);
		this.setResaltarfecha_compraConsolidadosDetalle(esInicial);
		this.setResaltarvida_utilConsolidadosDetalle(esInicial);
		this.setResaltarcosto_de_compraConsolidadosDetalle(esInicial);
		this.setResaltarcantidadConsolidadosDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.ID)) {
				this.setResaltaridConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.NOMBREEMPRESA)) {
				this.setResaltarnombre_empresaConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.NOMBRESUCURSAL)) {
				this.setResaltarnombre_sucursalConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setResaltarcodigo_sub_grupoConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setResaltarnombre_sub_grupoConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setResaltarcodigo_detalle_grupoConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setResaltarnombre_detalle_grupoConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.CLAVE)) {
				this.setResaltarclaveConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.FECHACOMPRA)) {
				this.setResaltarfecha_compraConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.VIDAUTIL)) {
				this.setResaltarvida_utilConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.COSTODECOMPRA)) {
				this.setResaltarcosto_de_compraConsolidadosDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsolidadosDetalleConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadConsolidadosDetalle(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ConsolidadosDetalleBeanSwingJInternalFrame consolidadosdetalleBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaConsolidadosDetalleConsolidadosDetalle=true;

	public Boolean getMostrarBusquedaConsolidadosDetalleConsolidadosDetalle() {
		return this.mostrarBusquedaConsolidadosDetalleConsolidadosDetalle;
	}

	public void setMostrarBusquedaConsolidadosDetalleConsolidadosDetalle(Boolean visibilidadResaltar) {
		this.mostrarBusquedaConsolidadosDetalleConsolidadosDetalle= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaConsolidadosDetalleConsolidadosDetalle=true;

	public Boolean getActivarBusquedaConsolidadosDetalleConsolidadosDetalle() {
		return this.activarBusquedaConsolidadosDetalleConsolidadosDetalle;
	}

	public void setActivarBusquedaConsolidadosDetalleConsolidadosDetalle(Boolean habilitarResaltar) {
		this.activarBusquedaConsolidadosDetalleConsolidadosDetalle= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaConsolidadosDetalleConsolidadosDetalle=null;

	public Border getResaltarBusquedaConsolidadosDetalleConsolidadosDetalle() {
		return this.resaltarBusquedaConsolidadosDetalleConsolidadosDetalle;
	}

	public void setResaltarBusquedaConsolidadosDetalleConsolidadosDetalle(Border borderResaltar) {
		this.resaltarBusquedaConsolidadosDetalleConsolidadosDetalle= borderResaltar;
	}

	public void setResaltarBusquedaConsolidadosDetalleConsolidadosDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ConsolidadosDetalleBeanSwingJInternalFrame consolidadosdetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaConsolidadosDetalleConsolidadosDetalle= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}