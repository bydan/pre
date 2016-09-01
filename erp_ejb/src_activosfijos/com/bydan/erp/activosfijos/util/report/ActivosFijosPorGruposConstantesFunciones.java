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


import com.bydan.erp.activosfijos.util.report.ActivosFijosPorGruposConstantesFunciones;
import com.bydan.erp.activosfijos.util.report.ActivosFijosPorGruposParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.ActivosFijosPorGruposParameterGeneral;

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
final public class ActivosFijosPorGruposConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ActivosFijosPorGrupos";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ActivosFijosPorGrupos"+ActivosFijosPorGruposConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ActivosFijosPorGruposHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ActivosFijosPorGruposHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ActivosFijosPorGruposConstantesFunciones.SCHEMA+"_"+ActivosFijosPorGruposConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ActivosFijosPorGruposHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ActivosFijosPorGruposConstantesFunciones.SCHEMA+"_"+ActivosFijosPorGruposConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ActivosFijosPorGruposConstantesFunciones.SCHEMA+"_"+ActivosFijosPorGruposConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ActivosFijosPorGruposHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ActivosFijosPorGruposConstantesFunciones.SCHEMA+"_"+ActivosFijosPorGruposConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ActivosFijosPorGruposConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ActivosFijosPorGruposHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ActivosFijosPorGruposConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ActivosFijosPorGruposConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ActivosFijosPorGruposHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ActivosFijosPorGruposConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ActivosFijosPorGruposConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ActivosFijosPorGruposConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ActivosFijosPorGruposConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ActivosFijosPorGruposConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Activos Fijos Por Gruposes";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Activos Fijos Por Grupos";
	public static final String SCLASSWEBTITULO_LOWER="Activos Fijos Por Grupos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ActivosFijosPorGrupos";
	public static final String OBJECTNAME="activosfijosporgrupos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="activos_fijos_por_grupos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select activosfijosporgrupos from "+ActivosFijosPorGruposConstantesFunciones.SPERSISTENCENAME+" activosfijosporgrupos";
	public static String QUERYSELECTNATIVE="select "+ActivosFijosPorGruposConstantesFunciones.SCHEMA+"."+ActivosFijosPorGruposConstantesFunciones.TABLENAME+".id,"+ActivosFijosPorGruposConstantesFunciones.SCHEMA+"."+ActivosFijosPorGruposConstantesFunciones.TABLENAME+".version_row,"+ActivosFijosPorGruposConstantesFunciones.SCHEMA+"."+ActivosFijosPorGruposConstantesFunciones.TABLENAME+".id_empresa,"+ActivosFijosPorGruposConstantesFunciones.SCHEMA+"."+ActivosFijosPorGruposConstantesFunciones.TABLENAME+".id_sucursal,"+ActivosFijosPorGruposConstantesFunciones.SCHEMA+"."+ActivosFijosPorGruposConstantesFunciones.TABLENAME+".codigo_sub_grupo,"+ActivosFijosPorGruposConstantesFunciones.SCHEMA+"."+ActivosFijosPorGruposConstantesFunciones.TABLENAME+".nombre_sub_grupo,"+ActivosFijosPorGruposConstantesFunciones.SCHEMA+"."+ActivosFijosPorGruposConstantesFunciones.TABLENAME+".codigo_detalle_grupo,"+ActivosFijosPorGruposConstantesFunciones.SCHEMA+"."+ActivosFijosPorGruposConstantesFunciones.TABLENAME+".nombre_detalle_grupo,"+ActivosFijosPorGruposConstantesFunciones.SCHEMA+"."+ActivosFijosPorGruposConstantesFunciones.TABLENAME+".clave,"+ActivosFijosPorGruposConstantesFunciones.SCHEMA+"."+ActivosFijosPorGruposConstantesFunciones.TABLENAME+".nombre,"+ActivosFijosPorGruposConstantesFunciones.SCHEMA+"."+ActivosFijosPorGruposConstantesFunciones.TABLENAME+".fecha_compra,"+ActivosFijosPorGruposConstantesFunciones.SCHEMA+"."+ActivosFijosPorGruposConstantesFunciones.TABLENAME+".vida_util,"+ActivosFijosPorGruposConstantesFunciones.SCHEMA+"."+ActivosFijosPorGruposConstantesFunciones.TABLENAME+".costo_de_compra,"+ActivosFijosPorGruposConstantesFunciones.SCHEMA+"."+ActivosFijosPorGruposConstantesFunciones.TABLENAME+".marca,"+ActivosFijosPorGruposConstantesFunciones.SCHEMA+"."+ActivosFijosPorGruposConstantesFunciones.TABLENAME+".modelo,"+ActivosFijosPorGruposConstantesFunciones.SCHEMA+"."+ActivosFijosPorGruposConstantesFunciones.TABLENAME+".color,"+ActivosFijosPorGruposConstantesFunciones.SCHEMA+"."+ActivosFijosPorGruposConstantesFunciones.TABLENAME+".serie from "+ActivosFijosPorGruposConstantesFunciones.SCHEMA+"."+ActivosFijosPorGruposConstantesFunciones.TABLENAME;//+" as "+ActivosFijosPorGruposConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String CODIGOSUBGRUPO= "codigo_sub_grupo";
    public static final String NOMBRESUBGRUPO= "nombre_sub_grupo";
    public static final String CODIGODETALLEGRUPO= "codigo_detalle_grupo";
    public static final String NOMBREDETALLEGRUPO= "nombre_detalle_grupo";
    public static final String CLAVE= "clave";
    public static final String NOMBRE= "nombre";
    public static final String FECHACOMPRA= "fecha_compra";
    public static final String VIDAUTIL= "vida_util";
    public static final String COSTODECOMPRA= "costo_de_compra";
    public static final String MARCA= "marca";
    public static final String MODELO= "modelo";
    public static final String COLOR= "color";
    public static final String SERIE= "serie";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
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
    	public static final String LABEL_COSTODECOMPRA= "Costo De Compra";
		public static final String LABEL_COSTODECOMPRA_LOWER= "Costo De Compra";
    	public static final String LABEL_MARCA= "Marca";
		public static final String LABEL_MARCA_LOWER= "Marca";
    	public static final String LABEL_MODELO= "Modelo";
		public static final String LABEL_MODELO_LOWER= "Modelo";
    	public static final String LABEL_COLOR= "Color";
		public static final String LABEL_COLOR_LOWER= "Color";
    	public static final String LABEL_SERIE= "Serie";
		public static final String LABEL_SERIE_LOWER= "Serie";
	
		
		
		
		
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
		
		
		
	public static final String SREGEXMARCA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXMARCA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXMODELO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXMODELO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCOLOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCOLOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSERIE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSERIE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getActivosFijosPorGruposLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ActivosFijosPorGruposConstantesFunciones.IDEMPRESA)) {sLabelColumna=ActivosFijosPorGruposConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ActivosFijosPorGruposConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ActivosFijosPorGruposConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ActivosFijosPorGruposConstantesFunciones.CODIGOSUBGRUPO)) {sLabelColumna=ActivosFijosPorGruposConstantesFunciones.LABEL_CODIGOSUBGRUPO;}
		if(sNombreColumna.equals(ActivosFijosPorGruposConstantesFunciones.NOMBRESUBGRUPO)) {sLabelColumna=ActivosFijosPorGruposConstantesFunciones.LABEL_NOMBRESUBGRUPO;}
		if(sNombreColumna.equals(ActivosFijosPorGruposConstantesFunciones.CODIGODETALLEGRUPO)) {sLabelColumna=ActivosFijosPorGruposConstantesFunciones.LABEL_CODIGODETALLEGRUPO;}
		if(sNombreColumna.equals(ActivosFijosPorGruposConstantesFunciones.NOMBREDETALLEGRUPO)) {sLabelColumna=ActivosFijosPorGruposConstantesFunciones.LABEL_NOMBREDETALLEGRUPO;}
		if(sNombreColumna.equals(ActivosFijosPorGruposConstantesFunciones.CLAVE)) {sLabelColumna=ActivosFijosPorGruposConstantesFunciones.LABEL_CLAVE;}
		if(sNombreColumna.equals(ActivosFijosPorGruposConstantesFunciones.NOMBRE)) {sLabelColumna=ActivosFijosPorGruposConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ActivosFijosPorGruposConstantesFunciones.FECHACOMPRA)) {sLabelColumna=ActivosFijosPorGruposConstantesFunciones.LABEL_FECHACOMPRA;}
		if(sNombreColumna.equals(ActivosFijosPorGruposConstantesFunciones.VIDAUTIL)) {sLabelColumna=ActivosFijosPorGruposConstantesFunciones.LABEL_VIDAUTIL;}
		if(sNombreColumna.equals(ActivosFijosPorGruposConstantesFunciones.COSTODECOMPRA)) {sLabelColumna=ActivosFijosPorGruposConstantesFunciones.LABEL_COSTODECOMPRA;}
		if(sNombreColumna.equals(ActivosFijosPorGruposConstantesFunciones.MARCA)) {sLabelColumna=ActivosFijosPorGruposConstantesFunciones.LABEL_MARCA;}
		if(sNombreColumna.equals(ActivosFijosPorGruposConstantesFunciones.MODELO)) {sLabelColumna=ActivosFijosPorGruposConstantesFunciones.LABEL_MODELO;}
		if(sNombreColumna.equals(ActivosFijosPorGruposConstantesFunciones.COLOR)) {sLabelColumna=ActivosFijosPorGruposConstantesFunciones.LABEL_COLOR;}
		if(sNombreColumna.equals(ActivosFijosPorGruposConstantesFunciones.SERIE)) {sLabelColumna=ActivosFijosPorGruposConstantesFunciones.LABEL_SERIE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getActivosFijosPorGruposDescripcion(ActivosFijosPorGrupos activosfijosporgrupos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(activosfijosporgrupos !=null/* && activosfijosporgrupos.getId()!=0*/) {
			sDescripcion=activosfijosporgrupos.getnombre();//activosfijosporgruposactivosfijosporgrupos.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getActivosFijosPorGruposDescripcionDetallado(ActivosFijosPorGrupos activosfijosporgrupos) {
		String sDescripcion="";
			
		sDescripcion+=ActivosFijosPorGruposConstantesFunciones.ID+"=";
		sDescripcion+=activosfijosporgrupos.getId().toString()+",";
		sDescripcion+=ActivosFijosPorGruposConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=activosfijosporgrupos.getVersionRow().toString()+",";
		sDescripcion+=ActivosFijosPorGruposConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=activosfijosporgrupos.getid_empresa().toString()+",";
		sDescripcion+=ActivosFijosPorGruposConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=activosfijosporgrupos.getid_sucursal().toString()+",";
		sDescripcion+=ActivosFijosPorGruposConstantesFunciones.CODIGOSUBGRUPO+"=";
		sDescripcion+=activosfijosporgrupos.getcodigo_sub_grupo()+",";
		sDescripcion+=ActivosFijosPorGruposConstantesFunciones.NOMBRESUBGRUPO+"=";
		sDescripcion+=activosfijosporgrupos.getnombre_sub_grupo()+",";
		sDescripcion+=ActivosFijosPorGruposConstantesFunciones.CODIGODETALLEGRUPO+"=";
		sDescripcion+=activosfijosporgrupos.getcodigo_detalle_grupo()+",";
		sDescripcion+=ActivosFijosPorGruposConstantesFunciones.NOMBREDETALLEGRUPO+"=";
		sDescripcion+=activosfijosporgrupos.getnombre_detalle_grupo()+",";
		sDescripcion+=ActivosFijosPorGruposConstantesFunciones.CLAVE+"=";
		sDescripcion+=activosfijosporgrupos.getclave()+",";
		sDescripcion+=ActivosFijosPorGruposConstantesFunciones.NOMBRE+"=";
		sDescripcion+=activosfijosporgrupos.getnombre()+",";
		sDescripcion+=ActivosFijosPorGruposConstantesFunciones.FECHACOMPRA+"=";
		sDescripcion+=activosfijosporgrupos.getfecha_compra().toString()+",";
		sDescripcion+=ActivosFijosPorGruposConstantesFunciones.VIDAUTIL+"=";
		sDescripcion+=activosfijosporgrupos.getvida_util().toString()+",";
		sDescripcion+=ActivosFijosPorGruposConstantesFunciones.COSTODECOMPRA+"=";
		sDescripcion+=activosfijosporgrupos.getcosto_de_compra().toString()+",";
		sDescripcion+=ActivosFijosPorGruposConstantesFunciones.MARCA+"=";
		sDescripcion+=activosfijosporgrupos.getmarca()+",";
		sDescripcion+=ActivosFijosPorGruposConstantesFunciones.MODELO+"=";
		sDescripcion+=activosfijosporgrupos.getmodelo()+",";
		sDescripcion+=ActivosFijosPorGruposConstantesFunciones.COLOR+"=";
		sDescripcion+=activosfijosporgrupos.getcolor()+",";
		sDescripcion+=ActivosFijosPorGruposConstantesFunciones.SERIE+"=";
		sDescripcion+=activosfijosporgrupos.getserie()+",";
			
		return sDescripcion;
	}
	
	public static void setActivosFijosPorGruposDescripcion(ActivosFijosPorGrupos activosfijosporgrupos,String sValor) throws Exception {			
		if(activosfijosporgrupos !=null) {
			activosfijosporgrupos.setnombre(sValor);;//activosfijosporgruposactivosfijosporgrupos.getnombre().trim();
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaActivosFijosPorGrupos")) {
			sNombreIndice="Tipo=  Por ";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaActivosFijosPorGrupos(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" ="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosActivosFijosPorGrupos(ActivosFijosPorGrupos activosfijosporgrupos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		activosfijosporgrupos.setcodigo_sub_grupo(activosfijosporgrupos.getcodigo_sub_grupo().trim());
		activosfijosporgrupos.setnombre_sub_grupo(activosfijosporgrupos.getnombre_sub_grupo().trim());
		activosfijosporgrupos.setcodigo_detalle_grupo(activosfijosporgrupos.getcodigo_detalle_grupo().trim());
		activosfijosporgrupos.setnombre_detalle_grupo(activosfijosporgrupos.getnombre_detalle_grupo().trim());
		activosfijosporgrupos.setclave(activosfijosporgrupos.getclave().trim());
		activosfijosporgrupos.setnombre(activosfijosporgrupos.getnombre().trim());
		activosfijosporgrupos.setmarca(activosfijosporgrupos.getmarca().trim());
		activosfijosporgrupos.setmodelo(activosfijosporgrupos.getmodelo().trim());
		activosfijosporgrupos.setcolor(activosfijosporgrupos.getcolor().trim());
		activosfijosporgrupos.setserie(activosfijosporgrupos.getserie().trim());
	}
	
	public static void quitarEspaciosActivosFijosPorGruposs(List<ActivosFijosPorGrupos> activosfijosporgruposs,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ActivosFijosPorGrupos activosfijosporgrupos: activosfijosporgruposs) {
			activosfijosporgrupos.setcodigo_sub_grupo(activosfijosporgrupos.getcodigo_sub_grupo().trim());
			activosfijosporgrupos.setnombre_sub_grupo(activosfijosporgrupos.getnombre_sub_grupo().trim());
			activosfijosporgrupos.setcodigo_detalle_grupo(activosfijosporgrupos.getcodigo_detalle_grupo().trim());
			activosfijosporgrupos.setnombre_detalle_grupo(activosfijosporgrupos.getnombre_detalle_grupo().trim());
			activosfijosporgrupos.setclave(activosfijosporgrupos.getclave().trim());
			activosfijosporgrupos.setnombre(activosfijosporgrupos.getnombre().trim());
			activosfijosporgrupos.setmarca(activosfijosporgrupos.getmarca().trim());
			activosfijosporgrupos.setmodelo(activosfijosporgrupos.getmodelo().trim());
			activosfijosporgrupos.setcolor(activosfijosporgrupos.getcolor().trim());
			activosfijosporgrupos.setserie(activosfijosporgrupos.getserie().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresActivosFijosPorGrupos(ActivosFijosPorGrupos activosfijosporgrupos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && activosfijosporgrupos.getConCambioAuxiliar()) {
			activosfijosporgrupos.setIsDeleted(activosfijosporgrupos.getIsDeletedAuxiliar());	
			activosfijosporgrupos.setIsNew(activosfijosporgrupos.getIsNewAuxiliar());	
			activosfijosporgrupos.setIsChanged(activosfijosporgrupos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			activosfijosporgrupos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			activosfijosporgrupos.setIsDeletedAuxiliar(false);	
			activosfijosporgrupos.setIsNewAuxiliar(false);	
			activosfijosporgrupos.setIsChangedAuxiliar(false);
			
			activosfijosporgrupos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresActivosFijosPorGruposs(List<ActivosFijosPorGrupos> activosfijosporgruposs,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ActivosFijosPorGrupos activosfijosporgrupos : activosfijosporgruposs) {
			if(conAsignarBase && activosfijosporgrupos.getConCambioAuxiliar()) {
				activosfijosporgrupos.setIsDeleted(activosfijosporgrupos.getIsDeletedAuxiliar());	
				activosfijosporgrupos.setIsNew(activosfijosporgrupos.getIsNewAuxiliar());	
				activosfijosporgrupos.setIsChanged(activosfijosporgrupos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				activosfijosporgrupos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				activosfijosporgrupos.setIsDeletedAuxiliar(false);	
				activosfijosporgrupos.setIsNewAuxiliar(false);	
				activosfijosporgrupos.setIsChangedAuxiliar(false);
				
				activosfijosporgrupos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresActivosFijosPorGrupos(ActivosFijosPorGrupos activosfijosporgrupos,Boolean conEnteros) throws Exception  {
		activosfijosporgrupos.setvida_util(0.0);
		activosfijosporgrupos.setcosto_de_compra(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresActivosFijosPorGruposs(List<ActivosFijosPorGrupos> activosfijosporgruposs,Boolean conEnteros) throws Exception  {
		
		for(ActivosFijosPorGrupos activosfijosporgrupos: activosfijosporgruposs) {
			activosfijosporgrupos.setvida_util(0.0);
			activosfijosporgrupos.setcosto_de_compra(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaActivosFijosPorGrupos(List<ActivosFijosPorGrupos> activosfijosporgruposs,ActivosFijosPorGrupos activosfijosporgruposAux) throws Exception  {
		ActivosFijosPorGruposConstantesFunciones.InicializarValoresActivosFijosPorGrupos(activosfijosporgruposAux,true);
		
		for(ActivosFijosPorGrupos activosfijosporgrupos: activosfijosporgruposs) {
			if(activosfijosporgrupos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			activosfijosporgruposAux.setvida_util(activosfijosporgruposAux.getvida_util()+activosfijosporgrupos.getvida_util());			
			activosfijosporgruposAux.setcosto_de_compra(activosfijosporgruposAux.getcosto_de_compra()+activosfijosporgrupos.getcosto_de_compra());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesActivosFijosPorGrupos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ActivosFijosPorGruposConstantesFunciones.getArrayColumnasGlobalesActivosFijosPorGrupos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesActivosFijosPorGrupos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ActivosFijosPorGruposConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ActivosFijosPorGruposConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ActivosFijosPorGruposConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ActivosFijosPorGruposConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoActivosFijosPorGrupos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ActivosFijosPorGrupos> activosfijosporgruposs,ActivosFijosPorGrupos activosfijosporgrupos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ActivosFijosPorGrupos activosfijosporgruposAux: activosfijosporgruposs) {
			if(activosfijosporgruposAux!=null && activosfijosporgrupos!=null) {
				if((activosfijosporgruposAux.getId()==null && activosfijosporgrupos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(activosfijosporgruposAux.getId()!=null && activosfijosporgrupos.getId()!=null){
					if(activosfijosporgruposAux.getId().equals(activosfijosporgrupos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaActivosFijosPorGrupos(List<ActivosFijosPorGrupos> activosfijosporgruposs) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double vida_utilTotal=0.0;
		Double costo_de_compraTotal=0.0;
	
		for(ActivosFijosPorGrupos activosfijosporgrupos: activosfijosporgruposs) {			
			if(activosfijosporgrupos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			vida_utilTotal+=activosfijosporgrupos.getvida_util();
			costo_de_compraTotal+=activosfijosporgrupos.getcosto_de_compra();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ActivosFijosPorGruposConstantesFunciones.VIDAUTIL);
		datoGeneral.setsDescripcion(ActivosFijosPorGruposConstantesFunciones.LABEL_VIDAUTIL);
		datoGeneral.setdValorDouble(vida_utilTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ActivosFijosPorGruposConstantesFunciones.COSTODECOMPRA);
		datoGeneral.setsDescripcion(ActivosFijosPorGruposConstantesFunciones.LABEL_COSTODECOMPRA);
		datoGeneral.setdValorDouble(costo_de_compraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaActivosFijosPorGrupos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ActivosFijosPorGruposConstantesFunciones.LABEL_ID, ActivosFijosPorGruposConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorGruposConstantesFunciones.LABEL_VERSIONROW, ActivosFijosPorGruposConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorGruposConstantesFunciones.LABEL_CODIGOSUBGRUPO, ActivosFijosPorGruposConstantesFunciones.CODIGOSUBGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorGruposConstantesFunciones.LABEL_NOMBRESUBGRUPO, ActivosFijosPorGruposConstantesFunciones.NOMBRESUBGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorGruposConstantesFunciones.LABEL_CODIGODETALLEGRUPO, ActivosFijosPorGruposConstantesFunciones.CODIGODETALLEGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorGruposConstantesFunciones.LABEL_NOMBREDETALLEGRUPO, ActivosFijosPorGruposConstantesFunciones.NOMBREDETALLEGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorGruposConstantesFunciones.LABEL_CLAVE, ActivosFijosPorGruposConstantesFunciones.CLAVE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorGruposConstantesFunciones.LABEL_NOMBRE, ActivosFijosPorGruposConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorGruposConstantesFunciones.LABEL_FECHACOMPRA, ActivosFijosPorGruposConstantesFunciones.FECHACOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorGruposConstantesFunciones.LABEL_VIDAUTIL, ActivosFijosPorGruposConstantesFunciones.VIDAUTIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorGruposConstantesFunciones.LABEL_COSTODECOMPRA, ActivosFijosPorGruposConstantesFunciones.COSTODECOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorGruposConstantesFunciones.LABEL_MARCA, ActivosFijosPorGruposConstantesFunciones.MARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorGruposConstantesFunciones.LABEL_MODELO, ActivosFijosPorGruposConstantesFunciones.MODELO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorGruposConstantesFunciones.LABEL_COLOR, ActivosFijosPorGruposConstantesFunciones.COLOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorGruposConstantesFunciones.LABEL_SERIE, ActivosFijosPorGruposConstantesFunciones.SERIE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasActivosFijosPorGrupos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorGruposConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorGruposConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorGruposConstantesFunciones.CODIGOSUBGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorGruposConstantesFunciones.NOMBRESUBGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorGruposConstantesFunciones.CODIGODETALLEGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorGruposConstantesFunciones.NOMBREDETALLEGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorGruposConstantesFunciones.CLAVE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorGruposConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorGruposConstantesFunciones.FECHACOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorGruposConstantesFunciones.VIDAUTIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorGruposConstantesFunciones.COSTODECOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorGruposConstantesFunciones.MARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorGruposConstantesFunciones.MODELO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorGruposConstantesFunciones.COLOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorGruposConstantesFunciones.SERIE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarActivosFijosPorGrupos() throws Exception  {
		return ActivosFijosPorGruposConstantesFunciones.getTiposSeleccionarActivosFijosPorGrupos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarActivosFijosPorGrupos(Boolean conFk) throws Exception  {
		return ActivosFijosPorGruposConstantesFunciones.getTiposSeleccionarActivosFijosPorGrupos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarActivosFijosPorGrupos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorGruposConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ActivosFijosPorGruposConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorGruposConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ActivosFijosPorGruposConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorGruposConstantesFunciones.LABEL_CODIGOSUBGRUPO);
			reporte.setsDescripcion(ActivosFijosPorGruposConstantesFunciones.LABEL_CODIGOSUBGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorGruposConstantesFunciones.LABEL_NOMBRESUBGRUPO);
			reporte.setsDescripcion(ActivosFijosPorGruposConstantesFunciones.LABEL_NOMBRESUBGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorGruposConstantesFunciones.LABEL_CODIGODETALLEGRUPO);
			reporte.setsDescripcion(ActivosFijosPorGruposConstantesFunciones.LABEL_CODIGODETALLEGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorGruposConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);
			reporte.setsDescripcion(ActivosFijosPorGruposConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorGruposConstantesFunciones.LABEL_CLAVE);
			reporte.setsDescripcion(ActivosFijosPorGruposConstantesFunciones.LABEL_CLAVE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorGruposConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ActivosFijosPorGruposConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorGruposConstantesFunciones.LABEL_FECHACOMPRA);
			reporte.setsDescripcion(ActivosFijosPorGruposConstantesFunciones.LABEL_FECHACOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorGruposConstantesFunciones.LABEL_VIDAUTIL);
			reporte.setsDescripcion(ActivosFijosPorGruposConstantesFunciones.LABEL_VIDAUTIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorGruposConstantesFunciones.LABEL_COSTODECOMPRA);
			reporte.setsDescripcion(ActivosFijosPorGruposConstantesFunciones.LABEL_COSTODECOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorGruposConstantesFunciones.LABEL_MARCA);
			reporte.setsDescripcion(ActivosFijosPorGruposConstantesFunciones.LABEL_MARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorGruposConstantesFunciones.LABEL_MODELO);
			reporte.setsDescripcion(ActivosFijosPorGruposConstantesFunciones.LABEL_MODELO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorGruposConstantesFunciones.LABEL_COLOR);
			reporte.setsDescripcion(ActivosFijosPorGruposConstantesFunciones.LABEL_COLOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorGruposConstantesFunciones.LABEL_SERIE);
			reporte.setsDescripcion(ActivosFijosPorGruposConstantesFunciones.LABEL_SERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesActivosFijosPorGrupos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesActivosFijosPorGrupos(ActivosFijosPorGrupos activosfijosporgruposAux) throws Exception {
		
			activosfijosporgruposAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(activosfijosporgruposAux.getEmpresa()));
			activosfijosporgruposAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(activosfijosporgruposAux.getSucursal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesActivosFijosPorGrupos(List<ActivosFijosPorGrupos> activosfijosporgrupossTemp) throws Exception {
		for(ActivosFijosPorGrupos activosfijosporgruposAux:activosfijosporgrupossTemp) {
			
			activosfijosporgruposAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(activosfijosporgruposAux.getEmpresa()));
			activosfijosporgruposAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(activosfijosporgruposAux.getSucursal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfActivosFijosPorGrupos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfActivosFijosPorGrupos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfActivosFijosPorGrupos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ActivosFijosPorGruposConstantesFunciones.getClassesRelationshipsOfActivosFijosPorGrupos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfActivosFijosPorGrupos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfActivosFijosPorGrupos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ActivosFijosPorGruposConstantesFunciones.getClassesRelationshipsFromStringsOfActivosFijosPorGrupos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfActivosFijosPorGrupos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ActivosFijosPorGrupos activosfijosporgrupos,List<ActivosFijosPorGrupos> activosfijosporgruposs,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ActivosFijosPorGrupos activosfijosporgrupos,List<ActivosFijosPorGrupos> activosfijosporgruposs) throws Exception {
		try	{			
			for(ActivosFijosPorGrupos activosfijosporgruposLocal:activosfijosporgruposs) {
				if(activosfijosporgruposLocal.getId().equals(activosfijosporgrupos.getId())) {
					activosfijosporgruposLocal.setIsSelected(activosfijosporgrupos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesActivosFijosPorGrupos(List<ActivosFijosPorGrupos> activosfijosporgrupossAux) throws Exception {
		//this.activosfijosporgrupossAux=activosfijosporgrupossAux;
		
		for(ActivosFijosPorGrupos activosfijosporgruposAux:activosfijosporgrupossAux) {
			if(activosfijosporgruposAux.getIsChanged()) {
				activosfijosporgruposAux.setIsChanged(false);
			}		
			
			if(activosfijosporgruposAux.getIsNew()) {
				activosfijosporgruposAux.setIsNew(false);
			}	
			
			if(activosfijosporgruposAux.getIsDeleted()) {
				activosfijosporgruposAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesActivosFijosPorGrupos(ActivosFijosPorGrupos activosfijosporgruposAux) throws Exception {
		//this.activosfijosporgruposAux=activosfijosporgruposAux;
		
			if(activosfijosporgruposAux.getIsChanged()) {
				activosfijosporgruposAux.setIsChanged(false);
			}		
			
			if(activosfijosporgruposAux.getIsNew()) {
				activosfijosporgruposAux.setIsNew(false);
			}	
			
			if(activosfijosporgruposAux.getIsDeleted()) {
				activosfijosporgruposAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ActivosFijosPorGrupos activosfijosporgruposAsignar,ActivosFijosPorGrupos activosfijosporgrupos) throws Exception {
		activosfijosporgruposAsignar.setId(activosfijosporgrupos.getId());	
		activosfijosporgruposAsignar.setVersionRow(activosfijosporgrupos.getVersionRow());	
		activosfijosporgruposAsignar.setcodigo_sub_grupo(activosfijosporgrupos.getcodigo_sub_grupo());	
		activosfijosporgruposAsignar.setnombre_sub_grupo(activosfijosporgrupos.getnombre_sub_grupo());	
		activosfijosporgruposAsignar.setcodigo_detalle_grupo(activosfijosporgrupos.getcodigo_detalle_grupo());	
		activosfijosporgruposAsignar.setnombre_detalle_grupo(activosfijosporgrupos.getnombre_detalle_grupo());	
		activosfijosporgruposAsignar.setclave(activosfijosporgrupos.getclave());	
		activosfijosporgruposAsignar.setnombre(activosfijosporgrupos.getnombre());	
		activosfijosporgruposAsignar.setfecha_compra(activosfijosporgrupos.getfecha_compra());	
		activosfijosporgruposAsignar.setvida_util(activosfijosporgrupos.getvida_util());	
		activosfijosporgruposAsignar.setcosto_de_compra(activosfijosporgrupos.getcosto_de_compra());	
		activosfijosporgruposAsignar.setmarca(activosfijosporgrupos.getmarca());	
		activosfijosporgruposAsignar.setmodelo(activosfijosporgrupos.getmodelo());	
		activosfijosporgruposAsignar.setcolor(activosfijosporgrupos.getcolor());	
		activosfijosporgruposAsignar.setserie(activosfijosporgrupos.getserie());	
	}
	
	public static void inicializarActivosFijosPorGrupos(ActivosFijosPorGrupos activosfijosporgrupos) throws Exception {
		try {
				activosfijosporgrupos.setId(0L);	
					
				activosfijosporgrupos.setcodigo_sub_grupo("");	
				activosfijosporgrupos.setnombre_sub_grupo("");	
				activosfijosporgrupos.setcodigo_detalle_grupo("");	
				activosfijosporgrupos.setnombre_detalle_grupo("");	
				activosfijosporgrupos.setclave("");	
				activosfijosporgrupos.setnombre("");	
				activosfijosporgrupos.setfecha_compra(new Date());	
				activosfijosporgrupos.setvida_util(0.0);	
				activosfijosporgrupos.setcosto_de_compra(0.0);	
				activosfijosporgrupos.setmarca("");	
				activosfijosporgrupos.setmodelo("");	
				activosfijosporgrupos.setcolor("");	
				activosfijosporgrupos.setserie("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderActivosFijosPorGrupos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorGruposConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorGruposConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorGruposConstantesFunciones.LABEL_CODIGOSUBGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorGruposConstantesFunciones.LABEL_NOMBRESUBGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorGruposConstantesFunciones.LABEL_CODIGODETALLEGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorGruposConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorGruposConstantesFunciones.LABEL_CLAVE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorGruposConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorGruposConstantesFunciones.LABEL_FECHACOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorGruposConstantesFunciones.LABEL_VIDAUTIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorGruposConstantesFunciones.LABEL_COSTODECOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorGruposConstantesFunciones.LABEL_MARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorGruposConstantesFunciones.LABEL_MODELO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorGruposConstantesFunciones.LABEL_COLOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorGruposConstantesFunciones.LABEL_SERIE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataActivosFijosPorGrupos(String sTipo,Row row,Workbook workbook,ActivosFijosPorGrupos activosfijosporgrupos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporgrupos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporgrupos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporgrupos.getcodigo_sub_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporgrupos.getnombre_sub_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporgrupos.getcodigo_detalle_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporgrupos.getnombre_detalle_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporgrupos.getclave());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporgrupos.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporgrupos.getfecha_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporgrupos.getvida_util());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporgrupos.getcosto_de_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporgrupos.getmarca());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporgrupos.getmodelo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporgrupos.getcolor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporgrupos.getserie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryActivosFijosPorGrupos="";
	
	public String getsFinalQueryActivosFijosPorGrupos() {
		return this.sFinalQueryActivosFijosPorGrupos;
	}
	
	public void setsFinalQueryActivosFijosPorGrupos(String sFinalQueryActivosFijosPorGrupos) {
		this.sFinalQueryActivosFijosPorGrupos= sFinalQueryActivosFijosPorGrupos;
	}
	
	public Border resaltarSeleccionarActivosFijosPorGrupos=null;
	
	public Border setResaltarSeleccionarActivosFijosPorGrupos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorGruposBeanSwingJInternalFrame activosfijosporgruposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//activosfijosporgruposBeanSwingJInternalFrame.jTtoolBarActivosFijosPorGrupos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarActivosFijosPorGrupos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarActivosFijosPorGrupos() {
		return this.resaltarSeleccionarActivosFijosPorGrupos;
	}
	
	public void setResaltarSeleccionarActivosFijosPorGrupos(Border borderResaltarSeleccionarActivosFijosPorGrupos) {
		this.resaltarSeleccionarActivosFijosPorGrupos= borderResaltarSeleccionarActivosFijosPorGrupos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridActivosFijosPorGrupos=null;
	public Boolean mostraridActivosFijosPorGrupos=true;
	public Boolean activaridActivosFijosPorGrupos=true;

	public Border resaltarid_empresaActivosFijosPorGrupos=null;
	public Boolean mostrarid_empresaActivosFijosPorGrupos=true;
	public Boolean activarid_empresaActivosFijosPorGrupos=true;
	public Boolean cargarid_empresaActivosFijosPorGrupos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaActivosFijosPorGrupos=false;//ConEventDepend=true

	public Border resaltarid_sucursalActivosFijosPorGrupos=null;
	public Boolean mostrarid_sucursalActivosFijosPorGrupos=true;
	public Boolean activarid_sucursalActivosFijosPorGrupos=true;
	public Boolean cargarid_sucursalActivosFijosPorGrupos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalActivosFijosPorGrupos=false;//ConEventDepend=true

	public Border resaltarcodigo_sub_grupoActivosFijosPorGrupos=null;
	public Boolean mostrarcodigo_sub_grupoActivosFijosPorGrupos=true;
	public Boolean activarcodigo_sub_grupoActivosFijosPorGrupos=true;

	public Border resaltarnombre_sub_grupoActivosFijosPorGrupos=null;
	public Boolean mostrarnombre_sub_grupoActivosFijosPorGrupos=true;
	public Boolean activarnombre_sub_grupoActivosFijosPorGrupos=true;

	public Border resaltarcodigo_detalle_grupoActivosFijosPorGrupos=null;
	public Boolean mostrarcodigo_detalle_grupoActivosFijosPorGrupos=true;
	public Boolean activarcodigo_detalle_grupoActivosFijosPorGrupos=true;

	public Border resaltarnombre_detalle_grupoActivosFijosPorGrupos=null;
	public Boolean mostrarnombre_detalle_grupoActivosFijosPorGrupos=true;
	public Boolean activarnombre_detalle_grupoActivosFijosPorGrupos=true;

	public Border resaltarclaveActivosFijosPorGrupos=null;
	public Boolean mostrarclaveActivosFijosPorGrupos=true;
	public Boolean activarclaveActivosFijosPorGrupos=true;

	public Border resaltarnombreActivosFijosPorGrupos=null;
	public Boolean mostrarnombreActivosFijosPorGrupos=true;
	public Boolean activarnombreActivosFijosPorGrupos=true;

	public Border resaltarfecha_compraActivosFijosPorGrupos=null;
	public Boolean mostrarfecha_compraActivosFijosPorGrupos=true;
	public Boolean activarfecha_compraActivosFijosPorGrupos=true;

	public Border resaltarvida_utilActivosFijosPorGrupos=null;
	public Boolean mostrarvida_utilActivosFijosPorGrupos=true;
	public Boolean activarvida_utilActivosFijosPorGrupos=true;

	public Border resaltarcosto_de_compraActivosFijosPorGrupos=null;
	public Boolean mostrarcosto_de_compraActivosFijosPorGrupos=true;
	public Boolean activarcosto_de_compraActivosFijosPorGrupos=true;

	public Border resaltarmarcaActivosFijosPorGrupos=null;
	public Boolean mostrarmarcaActivosFijosPorGrupos=true;
	public Boolean activarmarcaActivosFijosPorGrupos=true;

	public Border resaltarmodeloActivosFijosPorGrupos=null;
	public Boolean mostrarmodeloActivosFijosPorGrupos=true;
	public Boolean activarmodeloActivosFijosPorGrupos=true;

	public Border resaltarcolorActivosFijosPorGrupos=null;
	public Boolean mostrarcolorActivosFijosPorGrupos=true;
	public Boolean activarcolorActivosFijosPorGrupos=true;

	public Border resaltarserieActivosFijosPorGrupos=null;
	public Boolean mostrarserieActivosFijosPorGrupos=true;
	public Boolean activarserieActivosFijosPorGrupos=true;

	
	

	public Border setResaltaridActivosFijosPorGrupos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorGruposBeanSwingJInternalFrame activosfijosporgruposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporgruposBeanSwingJInternalFrame.jTtoolBarActivosFijosPorGrupos.setBorder(borderResaltar);
		
		this.resaltaridActivosFijosPorGrupos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridActivosFijosPorGrupos() {
		return this.resaltaridActivosFijosPorGrupos;
	}

	public void setResaltaridActivosFijosPorGrupos(Border borderResaltar) {
		this.resaltaridActivosFijosPorGrupos= borderResaltar;
	}

	public Boolean getMostraridActivosFijosPorGrupos() {
		return this.mostraridActivosFijosPorGrupos;
	}

	public void setMostraridActivosFijosPorGrupos(Boolean mostraridActivosFijosPorGrupos) {
		this.mostraridActivosFijosPorGrupos= mostraridActivosFijosPorGrupos;
	}

	public Boolean getActivaridActivosFijosPorGrupos() {
		return this.activaridActivosFijosPorGrupos;
	}

	public void setActivaridActivosFijosPorGrupos(Boolean activaridActivosFijosPorGrupos) {
		this.activaridActivosFijosPorGrupos= activaridActivosFijosPorGrupos;
	}

	public Border setResaltarid_empresaActivosFijosPorGrupos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorGruposBeanSwingJInternalFrame activosfijosporgruposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporgruposBeanSwingJInternalFrame.jTtoolBarActivosFijosPorGrupos.setBorder(borderResaltar);
		
		this.resaltarid_empresaActivosFijosPorGrupos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaActivosFijosPorGrupos() {
		return this.resaltarid_empresaActivosFijosPorGrupos;
	}

	public void setResaltarid_empresaActivosFijosPorGrupos(Border borderResaltar) {
		this.resaltarid_empresaActivosFijosPorGrupos= borderResaltar;
	}

	public Boolean getMostrarid_empresaActivosFijosPorGrupos() {
		return this.mostrarid_empresaActivosFijosPorGrupos;
	}

	public void setMostrarid_empresaActivosFijosPorGrupos(Boolean mostrarid_empresaActivosFijosPorGrupos) {
		this.mostrarid_empresaActivosFijosPorGrupos= mostrarid_empresaActivosFijosPorGrupos;
	}

	public Boolean getActivarid_empresaActivosFijosPorGrupos() {
		return this.activarid_empresaActivosFijosPorGrupos;
	}

	public void setActivarid_empresaActivosFijosPorGrupos(Boolean activarid_empresaActivosFijosPorGrupos) {
		this.activarid_empresaActivosFijosPorGrupos= activarid_empresaActivosFijosPorGrupos;
	}

	public Boolean getCargarid_empresaActivosFijosPorGrupos() {
		return this.cargarid_empresaActivosFijosPorGrupos;
	}

	public void setCargarid_empresaActivosFijosPorGrupos(Boolean cargarid_empresaActivosFijosPorGrupos) {
		this.cargarid_empresaActivosFijosPorGrupos= cargarid_empresaActivosFijosPorGrupos;
	}

	public Border setResaltarid_sucursalActivosFijosPorGrupos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorGruposBeanSwingJInternalFrame activosfijosporgruposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporgruposBeanSwingJInternalFrame.jTtoolBarActivosFijosPorGrupos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalActivosFijosPorGrupos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalActivosFijosPorGrupos() {
		return this.resaltarid_sucursalActivosFijosPorGrupos;
	}

	public void setResaltarid_sucursalActivosFijosPorGrupos(Border borderResaltar) {
		this.resaltarid_sucursalActivosFijosPorGrupos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalActivosFijosPorGrupos() {
		return this.mostrarid_sucursalActivosFijosPorGrupos;
	}

	public void setMostrarid_sucursalActivosFijosPorGrupos(Boolean mostrarid_sucursalActivosFijosPorGrupos) {
		this.mostrarid_sucursalActivosFijosPorGrupos= mostrarid_sucursalActivosFijosPorGrupos;
	}

	public Boolean getActivarid_sucursalActivosFijosPorGrupos() {
		return this.activarid_sucursalActivosFijosPorGrupos;
	}

	public void setActivarid_sucursalActivosFijosPorGrupos(Boolean activarid_sucursalActivosFijosPorGrupos) {
		this.activarid_sucursalActivosFijosPorGrupos= activarid_sucursalActivosFijosPorGrupos;
	}

	public Boolean getCargarid_sucursalActivosFijosPorGrupos() {
		return this.cargarid_sucursalActivosFijosPorGrupos;
	}

	public void setCargarid_sucursalActivosFijosPorGrupos(Boolean cargarid_sucursalActivosFijosPorGrupos) {
		this.cargarid_sucursalActivosFijosPorGrupos= cargarid_sucursalActivosFijosPorGrupos;
	}

	public Border setResaltarcodigo_sub_grupoActivosFijosPorGrupos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorGruposBeanSwingJInternalFrame activosfijosporgruposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporgruposBeanSwingJInternalFrame.jTtoolBarActivosFijosPorGrupos.setBorder(borderResaltar);
		
		this.resaltarcodigo_sub_grupoActivosFijosPorGrupos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_sub_grupoActivosFijosPorGrupos() {
		return this.resaltarcodigo_sub_grupoActivosFijosPorGrupos;
	}

	public void setResaltarcodigo_sub_grupoActivosFijosPorGrupos(Border borderResaltar) {
		this.resaltarcodigo_sub_grupoActivosFijosPorGrupos= borderResaltar;
	}

	public Boolean getMostrarcodigo_sub_grupoActivosFijosPorGrupos() {
		return this.mostrarcodigo_sub_grupoActivosFijosPorGrupos;
	}

	public void setMostrarcodigo_sub_grupoActivosFijosPorGrupos(Boolean mostrarcodigo_sub_grupoActivosFijosPorGrupos) {
		this.mostrarcodigo_sub_grupoActivosFijosPorGrupos= mostrarcodigo_sub_grupoActivosFijosPorGrupos;
	}

	public Boolean getActivarcodigo_sub_grupoActivosFijosPorGrupos() {
		return this.activarcodigo_sub_grupoActivosFijosPorGrupos;
	}

	public void setActivarcodigo_sub_grupoActivosFijosPorGrupos(Boolean activarcodigo_sub_grupoActivosFijosPorGrupos) {
		this.activarcodigo_sub_grupoActivosFijosPorGrupos= activarcodigo_sub_grupoActivosFijosPorGrupos;
	}

	public Border setResaltarnombre_sub_grupoActivosFijosPorGrupos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorGruposBeanSwingJInternalFrame activosfijosporgruposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporgruposBeanSwingJInternalFrame.jTtoolBarActivosFijosPorGrupos.setBorder(borderResaltar);
		
		this.resaltarnombre_sub_grupoActivosFijosPorGrupos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sub_grupoActivosFijosPorGrupos() {
		return this.resaltarnombre_sub_grupoActivosFijosPorGrupos;
	}

	public void setResaltarnombre_sub_grupoActivosFijosPorGrupos(Border borderResaltar) {
		this.resaltarnombre_sub_grupoActivosFijosPorGrupos= borderResaltar;
	}

	public Boolean getMostrarnombre_sub_grupoActivosFijosPorGrupos() {
		return this.mostrarnombre_sub_grupoActivosFijosPorGrupos;
	}

	public void setMostrarnombre_sub_grupoActivosFijosPorGrupos(Boolean mostrarnombre_sub_grupoActivosFijosPorGrupos) {
		this.mostrarnombre_sub_grupoActivosFijosPorGrupos= mostrarnombre_sub_grupoActivosFijosPorGrupos;
	}

	public Boolean getActivarnombre_sub_grupoActivosFijosPorGrupos() {
		return this.activarnombre_sub_grupoActivosFijosPorGrupos;
	}

	public void setActivarnombre_sub_grupoActivosFijosPorGrupos(Boolean activarnombre_sub_grupoActivosFijosPorGrupos) {
		this.activarnombre_sub_grupoActivosFijosPorGrupos= activarnombre_sub_grupoActivosFijosPorGrupos;
	}

	public Border setResaltarcodigo_detalle_grupoActivosFijosPorGrupos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorGruposBeanSwingJInternalFrame activosfijosporgruposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporgruposBeanSwingJInternalFrame.jTtoolBarActivosFijosPorGrupos.setBorder(borderResaltar);
		
		this.resaltarcodigo_detalle_grupoActivosFijosPorGrupos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_detalle_grupoActivosFijosPorGrupos() {
		return this.resaltarcodigo_detalle_grupoActivosFijosPorGrupos;
	}

	public void setResaltarcodigo_detalle_grupoActivosFijosPorGrupos(Border borderResaltar) {
		this.resaltarcodigo_detalle_grupoActivosFijosPorGrupos= borderResaltar;
	}

	public Boolean getMostrarcodigo_detalle_grupoActivosFijosPorGrupos() {
		return this.mostrarcodigo_detalle_grupoActivosFijosPorGrupos;
	}

	public void setMostrarcodigo_detalle_grupoActivosFijosPorGrupos(Boolean mostrarcodigo_detalle_grupoActivosFijosPorGrupos) {
		this.mostrarcodigo_detalle_grupoActivosFijosPorGrupos= mostrarcodigo_detalle_grupoActivosFijosPorGrupos;
	}

	public Boolean getActivarcodigo_detalle_grupoActivosFijosPorGrupos() {
		return this.activarcodigo_detalle_grupoActivosFijosPorGrupos;
	}

	public void setActivarcodigo_detalle_grupoActivosFijosPorGrupos(Boolean activarcodigo_detalle_grupoActivosFijosPorGrupos) {
		this.activarcodigo_detalle_grupoActivosFijosPorGrupos= activarcodigo_detalle_grupoActivosFijosPorGrupos;
	}

	public Border setResaltarnombre_detalle_grupoActivosFijosPorGrupos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorGruposBeanSwingJInternalFrame activosfijosporgruposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporgruposBeanSwingJInternalFrame.jTtoolBarActivosFijosPorGrupos.setBorder(borderResaltar);
		
		this.resaltarnombre_detalle_grupoActivosFijosPorGrupos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_detalle_grupoActivosFijosPorGrupos() {
		return this.resaltarnombre_detalle_grupoActivosFijosPorGrupos;
	}

	public void setResaltarnombre_detalle_grupoActivosFijosPorGrupos(Border borderResaltar) {
		this.resaltarnombre_detalle_grupoActivosFijosPorGrupos= borderResaltar;
	}

	public Boolean getMostrarnombre_detalle_grupoActivosFijosPorGrupos() {
		return this.mostrarnombre_detalle_grupoActivosFijosPorGrupos;
	}

	public void setMostrarnombre_detalle_grupoActivosFijosPorGrupos(Boolean mostrarnombre_detalle_grupoActivosFijosPorGrupos) {
		this.mostrarnombre_detalle_grupoActivosFijosPorGrupos= mostrarnombre_detalle_grupoActivosFijosPorGrupos;
	}

	public Boolean getActivarnombre_detalle_grupoActivosFijosPorGrupos() {
		return this.activarnombre_detalle_grupoActivosFijosPorGrupos;
	}

	public void setActivarnombre_detalle_grupoActivosFijosPorGrupos(Boolean activarnombre_detalle_grupoActivosFijosPorGrupos) {
		this.activarnombre_detalle_grupoActivosFijosPorGrupos= activarnombre_detalle_grupoActivosFijosPorGrupos;
	}

	public Border setResaltarclaveActivosFijosPorGrupos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorGruposBeanSwingJInternalFrame activosfijosporgruposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporgruposBeanSwingJInternalFrame.jTtoolBarActivosFijosPorGrupos.setBorder(borderResaltar);
		
		this.resaltarclaveActivosFijosPorGrupos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarclaveActivosFijosPorGrupos() {
		return this.resaltarclaveActivosFijosPorGrupos;
	}

	public void setResaltarclaveActivosFijosPorGrupos(Border borderResaltar) {
		this.resaltarclaveActivosFijosPorGrupos= borderResaltar;
	}

	public Boolean getMostrarclaveActivosFijosPorGrupos() {
		return this.mostrarclaveActivosFijosPorGrupos;
	}

	public void setMostrarclaveActivosFijosPorGrupos(Boolean mostrarclaveActivosFijosPorGrupos) {
		this.mostrarclaveActivosFijosPorGrupos= mostrarclaveActivosFijosPorGrupos;
	}

	public Boolean getActivarclaveActivosFijosPorGrupos() {
		return this.activarclaveActivosFijosPorGrupos;
	}

	public void setActivarclaveActivosFijosPorGrupos(Boolean activarclaveActivosFijosPorGrupos) {
		this.activarclaveActivosFijosPorGrupos= activarclaveActivosFijosPorGrupos;
	}

	public Border setResaltarnombreActivosFijosPorGrupos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorGruposBeanSwingJInternalFrame activosfijosporgruposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporgruposBeanSwingJInternalFrame.jTtoolBarActivosFijosPorGrupos.setBorder(borderResaltar);
		
		this.resaltarnombreActivosFijosPorGrupos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreActivosFijosPorGrupos() {
		return this.resaltarnombreActivosFijosPorGrupos;
	}

	public void setResaltarnombreActivosFijosPorGrupos(Border borderResaltar) {
		this.resaltarnombreActivosFijosPorGrupos= borderResaltar;
	}

	public Boolean getMostrarnombreActivosFijosPorGrupos() {
		return this.mostrarnombreActivosFijosPorGrupos;
	}

	public void setMostrarnombreActivosFijosPorGrupos(Boolean mostrarnombreActivosFijosPorGrupos) {
		this.mostrarnombreActivosFijosPorGrupos= mostrarnombreActivosFijosPorGrupos;
	}

	public Boolean getActivarnombreActivosFijosPorGrupos() {
		return this.activarnombreActivosFijosPorGrupos;
	}

	public void setActivarnombreActivosFijosPorGrupos(Boolean activarnombreActivosFijosPorGrupos) {
		this.activarnombreActivosFijosPorGrupos= activarnombreActivosFijosPorGrupos;
	}

	public Border setResaltarfecha_compraActivosFijosPorGrupos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorGruposBeanSwingJInternalFrame activosfijosporgruposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporgruposBeanSwingJInternalFrame.jTtoolBarActivosFijosPorGrupos.setBorder(borderResaltar);
		
		this.resaltarfecha_compraActivosFijosPorGrupos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_compraActivosFijosPorGrupos() {
		return this.resaltarfecha_compraActivosFijosPorGrupos;
	}

	public void setResaltarfecha_compraActivosFijosPorGrupos(Border borderResaltar) {
		this.resaltarfecha_compraActivosFijosPorGrupos= borderResaltar;
	}

	public Boolean getMostrarfecha_compraActivosFijosPorGrupos() {
		return this.mostrarfecha_compraActivosFijosPorGrupos;
	}

	public void setMostrarfecha_compraActivosFijosPorGrupos(Boolean mostrarfecha_compraActivosFijosPorGrupos) {
		this.mostrarfecha_compraActivosFijosPorGrupos= mostrarfecha_compraActivosFijosPorGrupos;
	}

	public Boolean getActivarfecha_compraActivosFijosPorGrupos() {
		return this.activarfecha_compraActivosFijosPorGrupos;
	}

	public void setActivarfecha_compraActivosFijosPorGrupos(Boolean activarfecha_compraActivosFijosPorGrupos) {
		this.activarfecha_compraActivosFijosPorGrupos= activarfecha_compraActivosFijosPorGrupos;
	}

	public Border setResaltarvida_utilActivosFijosPorGrupos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorGruposBeanSwingJInternalFrame activosfijosporgruposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporgruposBeanSwingJInternalFrame.jTtoolBarActivosFijosPorGrupos.setBorder(borderResaltar);
		
		this.resaltarvida_utilActivosFijosPorGrupos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvida_utilActivosFijosPorGrupos() {
		return this.resaltarvida_utilActivosFijosPorGrupos;
	}

	public void setResaltarvida_utilActivosFijosPorGrupos(Border borderResaltar) {
		this.resaltarvida_utilActivosFijosPorGrupos= borderResaltar;
	}

	public Boolean getMostrarvida_utilActivosFijosPorGrupos() {
		return this.mostrarvida_utilActivosFijosPorGrupos;
	}

	public void setMostrarvida_utilActivosFijosPorGrupos(Boolean mostrarvida_utilActivosFijosPorGrupos) {
		this.mostrarvida_utilActivosFijosPorGrupos= mostrarvida_utilActivosFijosPorGrupos;
	}

	public Boolean getActivarvida_utilActivosFijosPorGrupos() {
		return this.activarvida_utilActivosFijosPorGrupos;
	}

	public void setActivarvida_utilActivosFijosPorGrupos(Boolean activarvida_utilActivosFijosPorGrupos) {
		this.activarvida_utilActivosFijosPorGrupos= activarvida_utilActivosFijosPorGrupos;
	}

	public Border setResaltarcosto_de_compraActivosFijosPorGrupos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorGruposBeanSwingJInternalFrame activosfijosporgruposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporgruposBeanSwingJInternalFrame.jTtoolBarActivosFijosPorGrupos.setBorder(borderResaltar);
		
		this.resaltarcosto_de_compraActivosFijosPorGrupos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_de_compraActivosFijosPorGrupos() {
		return this.resaltarcosto_de_compraActivosFijosPorGrupos;
	}

	public void setResaltarcosto_de_compraActivosFijosPorGrupos(Border borderResaltar) {
		this.resaltarcosto_de_compraActivosFijosPorGrupos= borderResaltar;
	}

	public Boolean getMostrarcosto_de_compraActivosFijosPorGrupos() {
		return this.mostrarcosto_de_compraActivosFijosPorGrupos;
	}

	public void setMostrarcosto_de_compraActivosFijosPorGrupos(Boolean mostrarcosto_de_compraActivosFijosPorGrupos) {
		this.mostrarcosto_de_compraActivosFijosPorGrupos= mostrarcosto_de_compraActivosFijosPorGrupos;
	}

	public Boolean getActivarcosto_de_compraActivosFijosPorGrupos() {
		return this.activarcosto_de_compraActivosFijosPorGrupos;
	}

	public void setActivarcosto_de_compraActivosFijosPorGrupos(Boolean activarcosto_de_compraActivosFijosPorGrupos) {
		this.activarcosto_de_compraActivosFijosPorGrupos= activarcosto_de_compraActivosFijosPorGrupos;
	}

	public Border setResaltarmarcaActivosFijosPorGrupos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorGruposBeanSwingJInternalFrame activosfijosporgruposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporgruposBeanSwingJInternalFrame.jTtoolBarActivosFijosPorGrupos.setBorder(borderResaltar);
		
		this.resaltarmarcaActivosFijosPorGrupos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmarcaActivosFijosPorGrupos() {
		return this.resaltarmarcaActivosFijosPorGrupos;
	}

	public void setResaltarmarcaActivosFijosPorGrupos(Border borderResaltar) {
		this.resaltarmarcaActivosFijosPorGrupos= borderResaltar;
	}

	public Boolean getMostrarmarcaActivosFijosPorGrupos() {
		return this.mostrarmarcaActivosFijosPorGrupos;
	}

	public void setMostrarmarcaActivosFijosPorGrupos(Boolean mostrarmarcaActivosFijosPorGrupos) {
		this.mostrarmarcaActivosFijosPorGrupos= mostrarmarcaActivosFijosPorGrupos;
	}

	public Boolean getActivarmarcaActivosFijosPorGrupos() {
		return this.activarmarcaActivosFijosPorGrupos;
	}

	public void setActivarmarcaActivosFijosPorGrupos(Boolean activarmarcaActivosFijosPorGrupos) {
		this.activarmarcaActivosFijosPorGrupos= activarmarcaActivosFijosPorGrupos;
	}

	public Border setResaltarmodeloActivosFijosPorGrupos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorGruposBeanSwingJInternalFrame activosfijosporgruposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporgruposBeanSwingJInternalFrame.jTtoolBarActivosFijosPorGrupos.setBorder(borderResaltar);
		
		this.resaltarmodeloActivosFijosPorGrupos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmodeloActivosFijosPorGrupos() {
		return this.resaltarmodeloActivosFijosPorGrupos;
	}

	public void setResaltarmodeloActivosFijosPorGrupos(Border borderResaltar) {
		this.resaltarmodeloActivosFijosPorGrupos= borderResaltar;
	}

	public Boolean getMostrarmodeloActivosFijosPorGrupos() {
		return this.mostrarmodeloActivosFijosPorGrupos;
	}

	public void setMostrarmodeloActivosFijosPorGrupos(Boolean mostrarmodeloActivosFijosPorGrupos) {
		this.mostrarmodeloActivosFijosPorGrupos= mostrarmodeloActivosFijosPorGrupos;
	}

	public Boolean getActivarmodeloActivosFijosPorGrupos() {
		return this.activarmodeloActivosFijosPorGrupos;
	}

	public void setActivarmodeloActivosFijosPorGrupos(Boolean activarmodeloActivosFijosPorGrupos) {
		this.activarmodeloActivosFijosPorGrupos= activarmodeloActivosFijosPorGrupos;
	}

	public Border setResaltarcolorActivosFijosPorGrupos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorGruposBeanSwingJInternalFrame activosfijosporgruposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporgruposBeanSwingJInternalFrame.jTtoolBarActivosFijosPorGrupos.setBorder(borderResaltar);
		
		this.resaltarcolorActivosFijosPorGrupos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcolorActivosFijosPorGrupos() {
		return this.resaltarcolorActivosFijosPorGrupos;
	}

	public void setResaltarcolorActivosFijosPorGrupos(Border borderResaltar) {
		this.resaltarcolorActivosFijosPorGrupos= borderResaltar;
	}

	public Boolean getMostrarcolorActivosFijosPorGrupos() {
		return this.mostrarcolorActivosFijosPorGrupos;
	}

	public void setMostrarcolorActivosFijosPorGrupos(Boolean mostrarcolorActivosFijosPorGrupos) {
		this.mostrarcolorActivosFijosPorGrupos= mostrarcolorActivosFijosPorGrupos;
	}

	public Boolean getActivarcolorActivosFijosPorGrupos() {
		return this.activarcolorActivosFijosPorGrupos;
	}

	public void setActivarcolorActivosFijosPorGrupos(Boolean activarcolorActivosFijosPorGrupos) {
		this.activarcolorActivosFijosPorGrupos= activarcolorActivosFijosPorGrupos;
	}

	public Border setResaltarserieActivosFijosPorGrupos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorGruposBeanSwingJInternalFrame activosfijosporgruposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporgruposBeanSwingJInternalFrame.jTtoolBarActivosFijosPorGrupos.setBorder(borderResaltar);
		
		this.resaltarserieActivosFijosPorGrupos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarserieActivosFijosPorGrupos() {
		return this.resaltarserieActivosFijosPorGrupos;
	}

	public void setResaltarserieActivosFijosPorGrupos(Border borderResaltar) {
		this.resaltarserieActivosFijosPorGrupos= borderResaltar;
	}

	public Boolean getMostrarserieActivosFijosPorGrupos() {
		return this.mostrarserieActivosFijosPorGrupos;
	}

	public void setMostrarserieActivosFijosPorGrupos(Boolean mostrarserieActivosFijosPorGrupos) {
		this.mostrarserieActivosFijosPorGrupos= mostrarserieActivosFijosPorGrupos;
	}

	public Boolean getActivarserieActivosFijosPorGrupos() {
		return this.activarserieActivosFijosPorGrupos;
	}

	public void setActivarserieActivosFijosPorGrupos(Boolean activarserieActivosFijosPorGrupos) {
		this.activarserieActivosFijosPorGrupos= activarserieActivosFijosPorGrupos;
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
		
		
		this.setMostraridActivosFijosPorGrupos(esInicial);
		this.setMostrarid_empresaActivosFijosPorGrupos(esInicial);
		this.setMostrarid_sucursalActivosFijosPorGrupos(esInicial);
		this.setMostrarcodigo_sub_grupoActivosFijosPorGrupos(esInicial);
		this.setMostrarnombre_sub_grupoActivosFijosPorGrupos(esInicial);
		this.setMostrarcodigo_detalle_grupoActivosFijosPorGrupos(esInicial);
		this.setMostrarnombre_detalle_grupoActivosFijosPorGrupos(esInicial);
		this.setMostrarclaveActivosFijosPorGrupos(esInicial);
		this.setMostrarnombreActivosFijosPorGrupos(esInicial);
		this.setMostrarfecha_compraActivosFijosPorGrupos(esInicial);
		this.setMostrarvida_utilActivosFijosPorGrupos(esInicial);
		this.setMostrarcosto_de_compraActivosFijosPorGrupos(esInicial);
		this.setMostrarmarcaActivosFijosPorGrupos(esInicial);
		this.setMostrarmodeloActivosFijosPorGrupos(esInicial);
		this.setMostrarcolorActivosFijosPorGrupos(esInicial);
		this.setMostrarserieActivosFijosPorGrupos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.ID)) {
				this.setMostraridActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setMostrarcodigo_sub_grupoActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setMostrarnombre_sub_grupoActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setMostrarcodigo_detalle_grupoActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setMostrarnombre_detalle_grupoActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.CLAVE)) {
				this.setMostrarclaveActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.FECHACOMPRA)) {
				this.setMostrarfecha_compraActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.VIDAUTIL)) {
				this.setMostrarvida_utilActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.COSTODECOMPRA)) {
				this.setMostrarcosto_de_compraActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.MARCA)) {
				this.setMostrarmarcaActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.MODELO)) {
				this.setMostrarmodeloActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.COLOR)) {
				this.setMostrarcolorActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.SERIE)) {
				this.setMostrarserieActivosFijosPorGrupos(esAsigna);
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
		
		
		this.setActivaridActivosFijosPorGrupos(esInicial);
		this.setActivarid_empresaActivosFijosPorGrupos(esInicial);
		this.setActivarid_sucursalActivosFijosPorGrupos(esInicial);
		this.setActivarcodigo_sub_grupoActivosFijosPorGrupos(esInicial);
		this.setActivarnombre_sub_grupoActivosFijosPorGrupos(esInicial);
		this.setActivarcodigo_detalle_grupoActivosFijosPorGrupos(esInicial);
		this.setActivarnombre_detalle_grupoActivosFijosPorGrupos(esInicial);
		this.setActivarclaveActivosFijosPorGrupos(esInicial);
		this.setActivarnombreActivosFijosPorGrupos(esInicial);
		this.setActivarfecha_compraActivosFijosPorGrupos(esInicial);
		this.setActivarvida_utilActivosFijosPorGrupos(esInicial);
		this.setActivarcosto_de_compraActivosFijosPorGrupos(esInicial);
		this.setActivarmarcaActivosFijosPorGrupos(esInicial);
		this.setActivarmodeloActivosFijosPorGrupos(esInicial);
		this.setActivarcolorActivosFijosPorGrupos(esInicial);
		this.setActivarserieActivosFijosPorGrupos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.ID)) {
				this.setActivaridActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setActivarcodigo_sub_grupoActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setActivarnombre_sub_grupoActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setActivarcodigo_detalle_grupoActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setActivarnombre_detalle_grupoActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.CLAVE)) {
				this.setActivarclaveActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.NOMBRE)) {
				this.setActivarnombreActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.FECHACOMPRA)) {
				this.setActivarfecha_compraActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.VIDAUTIL)) {
				this.setActivarvida_utilActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.COSTODECOMPRA)) {
				this.setActivarcosto_de_compraActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.MARCA)) {
				this.setActivarmarcaActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.MODELO)) {
				this.setActivarmodeloActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.COLOR)) {
				this.setActivarcolorActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.SERIE)) {
				this.setActivarserieActivosFijosPorGrupos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ActivosFijosPorGruposBeanSwingJInternalFrame activosfijosporgruposBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridActivosFijosPorGrupos(esInicial);
		this.setResaltarid_empresaActivosFijosPorGrupos(esInicial);
		this.setResaltarid_sucursalActivosFijosPorGrupos(esInicial);
		this.setResaltarcodigo_sub_grupoActivosFijosPorGrupos(esInicial);
		this.setResaltarnombre_sub_grupoActivosFijosPorGrupos(esInicial);
		this.setResaltarcodigo_detalle_grupoActivosFijosPorGrupos(esInicial);
		this.setResaltarnombre_detalle_grupoActivosFijosPorGrupos(esInicial);
		this.setResaltarclaveActivosFijosPorGrupos(esInicial);
		this.setResaltarnombreActivosFijosPorGrupos(esInicial);
		this.setResaltarfecha_compraActivosFijosPorGrupos(esInicial);
		this.setResaltarvida_utilActivosFijosPorGrupos(esInicial);
		this.setResaltarcosto_de_compraActivosFijosPorGrupos(esInicial);
		this.setResaltarmarcaActivosFijosPorGrupos(esInicial);
		this.setResaltarmodeloActivosFijosPorGrupos(esInicial);
		this.setResaltarcolorActivosFijosPorGrupos(esInicial);
		this.setResaltarserieActivosFijosPorGrupos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.ID)) {
				this.setResaltaridActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setResaltarcodigo_sub_grupoActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setResaltarnombre_sub_grupoActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setResaltarcodigo_detalle_grupoActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setResaltarnombre_detalle_grupoActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.CLAVE)) {
				this.setResaltarclaveActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.FECHACOMPRA)) {
				this.setResaltarfecha_compraActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.VIDAUTIL)) {
				this.setResaltarvida_utilActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.COSTODECOMPRA)) {
				this.setResaltarcosto_de_compraActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.MARCA)) {
				this.setResaltarmarcaActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.MODELO)) {
				this.setResaltarmodeloActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.COLOR)) {
				this.setResaltarcolorActivosFijosPorGrupos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorGruposConstantesFunciones.SERIE)) {
				this.setResaltarserieActivosFijosPorGrupos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ActivosFijosPorGruposBeanSwingJInternalFrame activosfijosporgruposBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaActivosFijosPorGruposActivosFijosPorGrupos=true;

	public Boolean getMostrarBusquedaActivosFijosPorGruposActivosFijosPorGrupos() {
		return this.mostrarBusquedaActivosFijosPorGruposActivosFijosPorGrupos;
	}

	public void setMostrarBusquedaActivosFijosPorGruposActivosFijosPorGrupos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaActivosFijosPorGruposActivosFijosPorGrupos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaActivosFijosPorGruposActivosFijosPorGrupos=true;

	public Boolean getActivarBusquedaActivosFijosPorGruposActivosFijosPorGrupos() {
		return this.activarBusquedaActivosFijosPorGruposActivosFijosPorGrupos;
	}

	public void setActivarBusquedaActivosFijosPorGruposActivosFijosPorGrupos(Boolean habilitarResaltar) {
		this.activarBusquedaActivosFijosPorGruposActivosFijosPorGrupos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaActivosFijosPorGruposActivosFijosPorGrupos=null;

	public Border getResaltarBusquedaActivosFijosPorGruposActivosFijosPorGrupos() {
		return this.resaltarBusquedaActivosFijosPorGruposActivosFijosPorGrupos;
	}

	public void setResaltarBusquedaActivosFijosPorGruposActivosFijosPorGrupos(Border borderResaltar) {
		this.resaltarBusquedaActivosFijosPorGruposActivosFijosPorGrupos= borderResaltar;
	}

	public void setResaltarBusquedaActivosFijosPorGruposActivosFijosPorGrupos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorGruposBeanSwingJInternalFrame activosfijosporgruposBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaActivosFijosPorGruposActivosFijosPorGrupos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}