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


import com.bydan.erp.activosfijos.util.report.DepreciacionesConstantesFunciones;
import com.bydan.erp.activosfijos.util.report.DepreciacionesParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.DepreciacionesParameterGeneral;

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
final public class DepreciacionesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="Depreciaciones";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Depreciaciones"+DepreciacionesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DepreciacionesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DepreciacionesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DepreciacionesConstantesFunciones.SCHEMA+"_"+DepreciacionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DepreciacionesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DepreciacionesConstantesFunciones.SCHEMA+"_"+DepreciacionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DepreciacionesConstantesFunciones.SCHEMA+"_"+DepreciacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DepreciacionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DepreciacionesConstantesFunciones.SCHEMA+"_"+DepreciacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DepreciacionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DepreciacionesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DepreciacionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DepreciacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DepreciacionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DepreciacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DepreciacionesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DepreciacionesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DepreciacionesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DepreciacionesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Depreciacioneses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Depreciaciones";
	public static final String SCLASSWEBTITULO_LOWER="Depreciaciones";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Depreciaciones";
	public static final String OBJECTNAME="depreciaciones";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="depreciaciones";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select depreciaciones from "+DepreciacionesConstantesFunciones.SPERSISTENCENAME+" depreciaciones";
	public static String QUERYSELECTNATIVE="select "+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME+".id,"+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME+".version_row,"+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME+".id_empresa,"+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME+".id_anio_inicio,"+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME+".id_anio_fin,"+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME+".id_mes_inicio,"+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME+".id_mes_fin,"+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME+".codigo_sub_grupo,"+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME+".nombre_sub_grupo,"+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME+".codigo_detalle_grupo,"+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME+".nombre_detalle_grupo,"+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME+".clave,"+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME+".nombre,"+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME+".fecha_compra,"+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME+".vida_util,"+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME+".costo_de_compra,"+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME+".fecha_mantenimiento,"+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME+".fecha_depreciacion,"+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME+".id_anio,"+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME+".id_mes,"+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME+".valor_acumulado,"+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME+".valor_gasto from "+DepreciacionesConstantesFunciones.SCHEMA+"."+DepreciacionesConstantesFunciones.TABLENAME;//+" as "+DepreciacionesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDANIOINICIO= "id_anio_inicio";
    public static final String IDANIOFIN= "id_anio_fin";
    public static final String IDMESINICIO= "id_mes_inicio";
    public static final String IDMESFIN= "id_mes_fin";
    public static final String CODIGOSUBGRUPO= "codigo_sub_grupo";
    public static final String NOMBRESUBGRUPO= "nombre_sub_grupo";
    public static final String CODIGODETALLEGRUPO= "codigo_detalle_grupo";
    public static final String NOMBREDETALLEGRUPO= "nombre_detalle_grupo";
    public static final String CLAVE= "clave";
    public static final String NOMBRE= "nombre";
    public static final String FECHACOMPRA= "fecha_compra";
    public static final String VIDAUTIL= "vida_util";
    public static final String COSTODECOMPRA= "costo_de_compra";
    public static final String FECHAMANTENIMIENTO= "fecha_mantenimiento";
    public static final String FECHADEPRECIACION= "fecha_depreciacion";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String VALORACUMULADO= "valor_acumulado";
    public static final String VALORGASTO= "valor_gasto";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDANIOINICIO= "Anio Inicio";
		public static final String LABEL_IDANIOINICIO_LOWER= "Anio Inicio";
    	public static final String LABEL_IDANIOFIN= "Anio Fin";
		public static final String LABEL_IDANIOFIN_LOWER= "Anio Fin";
    	public static final String LABEL_IDMESINICIO= "Mes Inicio";
		public static final String LABEL_IDMESINICIO_LOWER= "Mes Inicio";
    	public static final String LABEL_IDMESFIN= "Mes Fin";
		public static final String LABEL_IDMESFIN_LOWER= "Mes Fin";
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
    	public static final String LABEL_FECHAMANTENIMIENTO= "Fecha Mantenimiento";
		public static final String LABEL_FECHAMANTENIMIENTO_LOWER= "Fecha Mantenimiento";
    	public static final String LABEL_FECHADEPRECIACION= "Fecha Depreciacion";
		public static final String LABEL_FECHADEPRECIACION_LOWER= "Fecha Depreciacion";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_VALORACUMULADO= "Valor Acumulado";
		public static final String LABEL_VALORACUMULADO_LOWER= "Valor Acumulado";
    	public static final String LABEL_VALORGASTO= "Valor Gasto";
		public static final String LABEL_VALORGASTO_LOWER= "Valor Gasto";
	
		
		
		
		
		
		
		
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
		
		
		
		
		
		
		
		
		
	
	public static String getDepreciacionesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DepreciacionesConstantesFunciones.IDEMPRESA)) {sLabelColumna=DepreciacionesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DepreciacionesConstantesFunciones.IDANIOINICIO)) {sLabelColumna=DepreciacionesConstantesFunciones.LABEL_IDANIOINICIO;}
		if(sNombreColumna.equals(DepreciacionesConstantesFunciones.IDANIOFIN)) {sLabelColumna=DepreciacionesConstantesFunciones.LABEL_IDANIOFIN;}
		if(sNombreColumna.equals(DepreciacionesConstantesFunciones.IDMESINICIO)) {sLabelColumna=DepreciacionesConstantesFunciones.LABEL_IDMESINICIO;}
		if(sNombreColumna.equals(DepreciacionesConstantesFunciones.IDMESFIN)) {sLabelColumna=DepreciacionesConstantesFunciones.LABEL_IDMESFIN;}
		if(sNombreColumna.equals(DepreciacionesConstantesFunciones.CODIGOSUBGRUPO)) {sLabelColumna=DepreciacionesConstantesFunciones.LABEL_CODIGOSUBGRUPO;}
		if(sNombreColumna.equals(DepreciacionesConstantesFunciones.NOMBRESUBGRUPO)) {sLabelColumna=DepreciacionesConstantesFunciones.LABEL_NOMBRESUBGRUPO;}
		if(sNombreColumna.equals(DepreciacionesConstantesFunciones.CODIGODETALLEGRUPO)) {sLabelColumna=DepreciacionesConstantesFunciones.LABEL_CODIGODETALLEGRUPO;}
		if(sNombreColumna.equals(DepreciacionesConstantesFunciones.NOMBREDETALLEGRUPO)) {sLabelColumna=DepreciacionesConstantesFunciones.LABEL_NOMBREDETALLEGRUPO;}
		if(sNombreColumna.equals(DepreciacionesConstantesFunciones.CLAVE)) {sLabelColumna=DepreciacionesConstantesFunciones.LABEL_CLAVE;}
		if(sNombreColumna.equals(DepreciacionesConstantesFunciones.NOMBRE)) {sLabelColumna=DepreciacionesConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(DepreciacionesConstantesFunciones.FECHACOMPRA)) {sLabelColumna=DepreciacionesConstantesFunciones.LABEL_FECHACOMPRA;}
		if(sNombreColumna.equals(DepreciacionesConstantesFunciones.VIDAUTIL)) {sLabelColumna=DepreciacionesConstantesFunciones.LABEL_VIDAUTIL;}
		if(sNombreColumna.equals(DepreciacionesConstantesFunciones.COSTODECOMPRA)) {sLabelColumna=DepreciacionesConstantesFunciones.LABEL_COSTODECOMPRA;}
		if(sNombreColumna.equals(DepreciacionesConstantesFunciones.FECHAMANTENIMIENTO)) {sLabelColumna=DepreciacionesConstantesFunciones.LABEL_FECHAMANTENIMIENTO;}
		if(sNombreColumna.equals(DepreciacionesConstantesFunciones.FECHADEPRECIACION)) {sLabelColumna=DepreciacionesConstantesFunciones.LABEL_FECHADEPRECIACION;}
		if(sNombreColumna.equals(DepreciacionesConstantesFunciones.IDANIO)) {sLabelColumna=DepreciacionesConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DepreciacionesConstantesFunciones.IDMES)) {sLabelColumna=DepreciacionesConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DepreciacionesConstantesFunciones.VALORACUMULADO)) {sLabelColumna=DepreciacionesConstantesFunciones.LABEL_VALORACUMULADO;}
		if(sNombreColumna.equals(DepreciacionesConstantesFunciones.VALORGASTO)) {sLabelColumna=DepreciacionesConstantesFunciones.LABEL_VALORGASTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDepreciacionesDescripcion(Depreciaciones depreciaciones) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(depreciaciones !=null/* && depreciaciones.getId()!=0*/) {
			sDescripcion=depreciaciones.getnombre();//depreciacionesdepreciaciones.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getDepreciacionesDescripcionDetallado(Depreciaciones depreciaciones) {
		String sDescripcion="";
			
		sDescripcion+=DepreciacionesConstantesFunciones.ID+"=";
		sDescripcion+=depreciaciones.getId().toString()+",";
		sDescripcion+=DepreciacionesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=depreciaciones.getVersionRow().toString()+",";
		sDescripcion+=DepreciacionesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=depreciaciones.getid_empresa().toString()+",";
		sDescripcion+=DepreciacionesConstantesFunciones.IDANIOINICIO+"=";
		sDescripcion+=depreciaciones.getid_anio_inicio().toString()+",";
		sDescripcion+=DepreciacionesConstantesFunciones.IDANIOFIN+"=";
		sDescripcion+=depreciaciones.getid_anio_fin().toString()+",";
		sDescripcion+=DepreciacionesConstantesFunciones.IDMESINICIO+"=";
		sDescripcion+=depreciaciones.getid_mes_inicio().toString()+",";
		sDescripcion+=DepreciacionesConstantesFunciones.IDMESFIN+"=";
		sDescripcion+=depreciaciones.getid_mes_fin().toString()+",";
		sDescripcion+=DepreciacionesConstantesFunciones.CODIGOSUBGRUPO+"=";
		sDescripcion+=depreciaciones.getcodigo_sub_grupo()+",";
		sDescripcion+=DepreciacionesConstantesFunciones.NOMBRESUBGRUPO+"=";
		sDescripcion+=depreciaciones.getnombre_sub_grupo()+",";
		sDescripcion+=DepreciacionesConstantesFunciones.CODIGODETALLEGRUPO+"=";
		sDescripcion+=depreciaciones.getcodigo_detalle_grupo()+",";
		sDescripcion+=DepreciacionesConstantesFunciones.NOMBREDETALLEGRUPO+"=";
		sDescripcion+=depreciaciones.getnombre_detalle_grupo()+",";
		sDescripcion+=DepreciacionesConstantesFunciones.CLAVE+"=";
		sDescripcion+=depreciaciones.getclave()+",";
		sDescripcion+=DepreciacionesConstantesFunciones.NOMBRE+"=";
		sDescripcion+=depreciaciones.getnombre()+",";
		sDescripcion+=DepreciacionesConstantesFunciones.FECHACOMPRA+"=";
		sDescripcion+=depreciaciones.getfecha_compra().toString()+",";
		sDescripcion+=DepreciacionesConstantesFunciones.VIDAUTIL+"=";
		sDescripcion+=depreciaciones.getvida_util().toString()+",";
		sDescripcion+=DepreciacionesConstantesFunciones.COSTODECOMPRA+"=";
		sDescripcion+=depreciaciones.getcosto_de_compra().toString()+",";
		sDescripcion+=DepreciacionesConstantesFunciones.FECHAMANTENIMIENTO+"=";
		sDescripcion+=depreciaciones.getfecha_mantenimiento().toString()+",";
		sDescripcion+=DepreciacionesConstantesFunciones.FECHADEPRECIACION+"=";
		sDescripcion+=depreciaciones.getfecha_depreciacion().toString()+",";
		sDescripcion+=DepreciacionesConstantesFunciones.IDANIO+"=";
		sDescripcion+=depreciaciones.getid_anio().toString()+",";
		sDescripcion+=DepreciacionesConstantesFunciones.IDMES+"=";
		sDescripcion+=depreciaciones.getid_mes().toString()+",";
		sDescripcion+=DepreciacionesConstantesFunciones.VALORACUMULADO+"=";
		sDescripcion+=depreciaciones.getvalor_acumulado().toString()+",";
		sDescripcion+=DepreciacionesConstantesFunciones.VALORGASTO+"=";
		sDescripcion+=depreciaciones.getvalor_gasto().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDepreciacionesDescripcion(Depreciaciones depreciaciones,String sValor) throws Exception {			
		if(depreciaciones !=null) {
			depreciaciones.setnombre(sValor);;//depreciacionesdepreciaciones.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getAnioInicioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getAnioFinDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesInicioDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}

	public static String getMesFinDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
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
		} else if(sNombreIndice.equals("BusquedaDepreciaciones")) {
			sNombreIndice="Tipo=  Por Anio Inicio Por Anio Fin Por Mes Inicio Por Mes Fin";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdAnioFin")) {
			sNombreIndice="Tipo=  Por Anio Fin";
		} else if(sNombreIndice.equals("FK_IdAnioInicio")) {
			sNombreIndice="Tipo=  Por Anio Inicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdMesFin")) {
			sNombreIndice="Tipo=  Por Mes Fin";
		} else if(sNombreIndice.equals("FK_IdMesInicio")) {
			sNombreIndice="Tipo=  Por Mes Inicio";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaDepreciaciones(Long id_anio_inicio,Long id_anio_fin,Long id_mes_inicio,Long id_mes_fin) {
		String sDetalleIndice=" Parametros->";
		if(id_anio_inicio!=null) {sDetalleIndice+=" Codigo Unico De Anio Inicio="+id_anio_inicio.toString();}
		if(id_anio_fin!=null) {sDetalleIndice+=" Codigo Unico De Anio Fin="+id_anio_fin.toString();}
		if(id_mes_inicio!=null) {sDetalleIndice+=" Codigo Unico De Mes Inicio="+id_mes_inicio.toString();}
		if(id_mes_fin!=null) {sDetalleIndice+=" Codigo Unico De Mes Fin="+id_mes_fin.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAnioFin(Long id_anio_fin) {
		String sDetalleIndice=" Parametros->";
		if(id_anio_fin!=null) {sDetalleIndice+=" Codigo Unico De Anio Fin="+id_anio_fin.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAnioInicio(Long id_anio_inicio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio_inicio!=null) {sDetalleIndice+=" Codigo Unico De Anio Inicio="+id_anio_inicio.toString();} 

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

	public static String getDetalleIndiceFK_IdMesFin(Long id_mes_fin) {
		String sDetalleIndice=" Parametros->";
		if(id_mes_fin!=null) {sDetalleIndice+=" Codigo Unico De Mes Fin="+id_mes_fin.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMesInicio(Long id_mes_inicio) {
		String sDetalleIndice=" Parametros->";
		if(id_mes_inicio!=null) {sDetalleIndice+=" Codigo Unico De Mes Inicio="+id_mes_inicio.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDepreciaciones(Depreciaciones depreciaciones,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		depreciaciones.setcodigo_sub_grupo(depreciaciones.getcodigo_sub_grupo().trim());
		depreciaciones.setnombre_sub_grupo(depreciaciones.getnombre_sub_grupo().trim());
		depreciaciones.setcodigo_detalle_grupo(depreciaciones.getcodigo_detalle_grupo().trim());
		depreciaciones.setnombre_detalle_grupo(depreciaciones.getnombre_detalle_grupo().trim());
		depreciaciones.setclave(depreciaciones.getclave().trim());
		depreciaciones.setnombre(depreciaciones.getnombre().trim());
	}
	
	public static void quitarEspaciosDepreciacioness(List<Depreciaciones> depreciacioness,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Depreciaciones depreciaciones: depreciacioness) {
			depreciaciones.setcodigo_sub_grupo(depreciaciones.getcodigo_sub_grupo().trim());
			depreciaciones.setnombre_sub_grupo(depreciaciones.getnombre_sub_grupo().trim());
			depreciaciones.setcodigo_detalle_grupo(depreciaciones.getcodigo_detalle_grupo().trim());
			depreciaciones.setnombre_detalle_grupo(depreciaciones.getnombre_detalle_grupo().trim());
			depreciaciones.setclave(depreciaciones.getclave().trim());
			depreciaciones.setnombre(depreciaciones.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDepreciaciones(Depreciaciones depreciaciones,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && depreciaciones.getConCambioAuxiliar()) {
			depreciaciones.setIsDeleted(depreciaciones.getIsDeletedAuxiliar());	
			depreciaciones.setIsNew(depreciaciones.getIsNewAuxiliar());	
			depreciaciones.setIsChanged(depreciaciones.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			depreciaciones.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			depreciaciones.setIsDeletedAuxiliar(false);	
			depreciaciones.setIsNewAuxiliar(false);	
			depreciaciones.setIsChangedAuxiliar(false);
			
			depreciaciones.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDepreciacioness(List<Depreciaciones> depreciacioness,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Depreciaciones depreciaciones : depreciacioness) {
			if(conAsignarBase && depreciaciones.getConCambioAuxiliar()) {
				depreciaciones.setIsDeleted(depreciaciones.getIsDeletedAuxiliar());	
				depreciaciones.setIsNew(depreciaciones.getIsNewAuxiliar());	
				depreciaciones.setIsChanged(depreciaciones.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				depreciaciones.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				depreciaciones.setIsDeletedAuxiliar(false);	
				depreciaciones.setIsNewAuxiliar(false);	
				depreciaciones.setIsChangedAuxiliar(false);
				
				depreciaciones.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDepreciaciones(Depreciaciones depreciaciones,Boolean conEnteros) throws Exception  {
		depreciaciones.setvida_util(0.0);
		depreciaciones.setcosto_de_compra(0.0);
		depreciaciones.setvalor_acumulado(0.0);
		depreciaciones.setvalor_gasto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDepreciacioness(List<Depreciaciones> depreciacioness,Boolean conEnteros) throws Exception  {
		
		for(Depreciaciones depreciaciones: depreciacioness) {
			depreciaciones.setvida_util(0.0);
			depreciaciones.setcosto_de_compra(0.0);
			depreciaciones.setvalor_acumulado(0.0);
			depreciaciones.setvalor_gasto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDepreciaciones(List<Depreciaciones> depreciacioness,Depreciaciones depreciacionesAux) throws Exception  {
		DepreciacionesConstantesFunciones.InicializarValoresDepreciaciones(depreciacionesAux,true);
		
		for(Depreciaciones depreciaciones: depreciacioness) {
			if(depreciaciones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			depreciacionesAux.setvida_util(depreciacionesAux.getvida_util()+depreciaciones.getvida_util());			
			depreciacionesAux.setcosto_de_compra(depreciacionesAux.getcosto_de_compra()+depreciaciones.getcosto_de_compra());			
			depreciacionesAux.setvalor_acumulado(depreciacionesAux.getvalor_acumulado()+depreciaciones.getvalor_acumulado());			
			depreciacionesAux.setvalor_gasto(depreciacionesAux.getvalor_gasto()+depreciaciones.getvalor_gasto());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDepreciaciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DepreciacionesConstantesFunciones.getArrayColumnasGlobalesDepreciaciones(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDepreciaciones(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DepreciacionesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DepreciacionesConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDepreciaciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Depreciaciones> depreciacioness,Depreciaciones depreciaciones,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Depreciaciones depreciacionesAux: depreciacioness) {
			if(depreciacionesAux!=null && depreciaciones!=null) {
				if((depreciacionesAux.getId()==null && depreciaciones.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(depreciacionesAux.getId()!=null && depreciaciones.getId()!=null){
					if(depreciacionesAux.getId().equals(depreciaciones.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDepreciaciones(List<Depreciaciones> depreciacioness) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double vida_utilTotal=0.0;
		Double costo_de_compraTotal=0.0;
		Double valor_acumuladoTotal=0.0;
		Double valor_gastoTotal=0.0;
	
		for(Depreciaciones depreciaciones: depreciacioness) {			
			if(depreciaciones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			vida_utilTotal+=depreciaciones.getvida_util();
			costo_de_compraTotal+=depreciaciones.getcosto_de_compra();
			valor_acumuladoTotal+=depreciaciones.getvalor_acumulado();
			valor_gastoTotal+=depreciaciones.getvalor_gasto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DepreciacionesConstantesFunciones.VIDAUTIL);
		datoGeneral.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_VIDAUTIL);
		datoGeneral.setdValorDouble(vida_utilTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DepreciacionesConstantesFunciones.COSTODECOMPRA);
		datoGeneral.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_COSTODECOMPRA);
		datoGeneral.setdValorDouble(costo_de_compraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DepreciacionesConstantesFunciones.VALORACUMULADO);
		datoGeneral.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_VALORACUMULADO);
		datoGeneral.setdValorDouble(valor_acumuladoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DepreciacionesConstantesFunciones.VALORGASTO);
		datoGeneral.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_VALORGASTO);
		datoGeneral.setdValorDouble(valor_gastoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDepreciaciones() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DepreciacionesConstantesFunciones.LABEL_ID, DepreciacionesConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionesConstantesFunciones.LABEL_VERSIONROW, DepreciacionesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionesConstantesFunciones.LABEL_CODIGOSUBGRUPO, DepreciacionesConstantesFunciones.CODIGOSUBGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionesConstantesFunciones.LABEL_NOMBRESUBGRUPO, DepreciacionesConstantesFunciones.NOMBRESUBGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionesConstantesFunciones.LABEL_CODIGODETALLEGRUPO, DepreciacionesConstantesFunciones.CODIGODETALLEGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionesConstantesFunciones.LABEL_NOMBREDETALLEGRUPO, DepreciacionesConstantesFunciones.NOMBREDETALLEGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionesConstantesFunciones.LABEL_CLAVE, DepreciacionesConstantesFunciones.CLAVE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionesConstantesFunciones.LABEL_NOMBRE, DepreciacionesConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionesConstantesFunciones.LABEL_FECHACOMPRA, DepreciacionesConstantesFunciones.FECHACOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionesConstantesFunciones.LABEL_VIDAUTIL, DepreciacionesConstantesFunciones.VIDAUTIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionesConstantesFunciones.LABEL_COSTODECOMPRA, DepreciacionesConstantesFunciones.COSTODECOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionesConstantesFunciones.LABEL_FECHAMANTENIMIENTO, DepreciacionesConstantesFunciones.FECHAMANTENIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionesConstantesFunciones.LABEL_FECHADEPRECIACION, DepreciacionesConstantesFunciones.FECHADEPRECIACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionesConstantesFunciones.LABEL_IDANIO, DepreciacionesConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionesConstantesFunciones.LABEL_IDMES, DepreciacionesConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionesConstantesFunciones.LABEL_VALORACUMULADO, DepreciacionesConstantesFunciones.VALORACUMULADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionesConstantesFunciones.LABEL_VALORGASTO, DepreciacionesConstantesFunciones.VALORGASTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDepreciaciones() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DepreciacionesConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionesConstantesFunciones.CODIGOSUBGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionesConstantesFunciones.NOMBRESUBGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionesConstantesFunciones.CODIGODETALLEGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionesConstantesFunciones.NOMBREDETALLEGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionesConstantesFunciones.CLAVE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionesConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionesConstantesFunciones.FECHACOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionesConstantesFunciones.VIDAUTIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionesConstantesFunciones.COSTODECOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionesConstantesFunciones.FECHAMANTENIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionesConstantesFunciones.FECHADEPRECIACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionesConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionesConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionesConstantesFunciones.VALORACUMULADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionesConstantesFunciones.VALORGASTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDepreciaciones() throws Exception  {
		return DepreciacionesConstantesFunciones.getTiposSeleccionarDepreciaciones(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDepreciaciones(Boolean conFk) throws Exception  {
		return DepreciacionesConstantesFunciones.getTiposSeleccionarDepreciaciones(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDepreciaciones(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionesConstantesFunciones.LABEL_IDANIOINICIO);
			reporte.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_IDANIOINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionesConstantesFunciones.LABEL_IDANIOFIN);
			reporte.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_IDANIOFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionesConstantesFunciones.LABEL_IDMESINICIO);
			reporte.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_IDMESINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionesConstantesFunciones.LABEL_IDMESFIN);
			reporte.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_IDMESFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionesConstantesFunciones.LABEL_CODIGOSUBGRUPO);
			reporte.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_CODIGOSUBGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionesConstantesFunciones.LABEL_NOMBRESUBGRUPO);
			reporte.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_NOMBRESUBGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionesConstantesFunciones.LABEL_CODIGODETALLEGRUPO);
			reporte.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_CODIGODETALLEGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionesConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);
			reporte.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionesConstantesFunciones.LABEL_CLAVE);
			reporte.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_CLAVE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionesConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionesConstantesFunciones.LABEL_FECHACOMPRA);
			reporte.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_FECHACOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionesConstantesFunciones.LABEL_VIDAUTIL);
			reporte.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_VIDAUTIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionesConstantesFunciones.LABEL_COSTODECOMPRA);
			reporte.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_COSTODECOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionesConstantesFunciones.LABEL_FECHAMANTENIMIENTO);
			reporte.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_FECHAMANTENIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionesConstantesFunciones.LABEL_FECHADEPRECIACION);
			reporte.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_FECHADEPRECIACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionesConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionesConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionesConstantesFunciones.LABEL_VALORACUMULADO);
			reporte.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_VALORACUMULADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionesConstantesFunciones.LABEL_VALORGASTO);
			reporte.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_VALORGASTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDepreciaciones(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDepreciaciones(Depreciaciones depreciacionesAux) throws Exception {
		
			depreciacionesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(depreciacionesAux.getEmpresa()));
			depreciacionesAux.setanioinicio_descripcion(AnioConstantesFunciones.getAnioDescripcion(depreciacionesAux.getAnioInicio()));
			depreciacionesAux.setaniofin_descripcion(AnioConstantesFunciones.getAnioDescripcion(depreciacionesAux.getAnioFin()));
			depreciacionesAux.setmesinicio_descripcion(MesConstantesFunciones.getMesDescripcion(depreciacionesAux.getMesInicio()));
			depreciacionesAux.setmesfin_descripcion(MesConstantesFunciones.getMesDescripcion(depreciacionesAux.getMesFin()));
			depreciacionesAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(depreciacionesAux.getAnio()));
			depreciacionesAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(depreciacionesAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDepreciaciones(List<Depreciaciones> depreciacionessTemp) throws Exception {
		for(Depreciaciones depreciacionesAux:depreciacionessTemp) {
			
			depreciacionesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(depreciacionesAux.getEmpresa()));
			depreciacionesAux.setanioinicio_descripcion(AnioConstantesFunciones.getAnioDescripcion(depreciacionesAux.getAnioInicio()));
			depreciacionesAux.setaniofin_descripcion(AnioConstantesFunciones.getAnioDescripcion(depreciacionesAux.getAnioFin()));
			depreciacionesAux.setmesinicio_descripcion(MesConstantesFunciones.getMesDescripcion(depreciacionesAux.getMesInicio()));
			depreciacionesAux.setmesfin_descripcion(MesConstantesFunciones.getMesDescripcion(depreciacionesAux.getMesFin()));
			depreciacionesAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(depreciacionesAux.getAnio()));
			depreciacionesAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(depreciacionesAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDepreciaciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
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
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDepreciaciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDepreciaciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DepreciacionesConstantesFunciones.getClassesRelationshipsOfDepreciaciones(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDepreciaciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDepreciaciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DepreciacionesConstantesFunciones.getClassesRelationshipsFromStringsOfDepreciaciones(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDepreciaciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Depreciaciones depreciaciones,List<Depreciaciones> depreciacioness,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(Depreciaciones depreciaciones,List<Depreciaciones> depreciacioness) throws Exception {
		try	{			
			for(Depreciaciones depreciacionesLocal:depreciacioness) {
				if(depreciacionesLocal.getId().equals(depreciaciones.getId())) {
					depreciacionesLocal.setIsSelected(depreciaciones.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDepreciaciones(List<Depreciaciones> depreciacionessAux) throws Exception {
		//this.depreciacionessAux=depreciacionessAux;
		
		for(Depreciaciones depreciacionesAux:depreciacionessAux) {
			if(depreciacionesAux.getIsChanged()) {
				depreciacionesAux.setIsChanged(false);
			}		
			
			if(depreciacionesAux.getIsNew()) {
				depreciacionesAux.setIsNew(false);
			}	
			
			if(depreciacionesAux.getIsDeleted()) {
				depreciacionesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDepreciaciones(Depreciaciones depreciacionesAux) throws Exception {
		//this.depreciacionesAux=depreciacionesAux;
		
			if(depreciacionesAux.getIsChanged()) {
				depreciacionesAux.setIsChanged(false);
			}		
			
			if(depreciacionesAux.getIsNew()) {
				depreciacionesAux.setIsNew(false);
			}	
			
			if(depreciacionesAux.getIsDeleted()) {
				depreciacionesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Depreciaciones depreciacionesAsignar,Depreciaciones depreciaciones) throws Exception {
		depreciacionesAsignar.setId(depreciaciones.getId());	
		depreciacionesAsignar.setVersionRow(depreciaciones.getVersionRow());	
		depreciacionesAsignar.setcodigo_sub_grupo(depreciaciones.getcodigo_sub_grupo());	
		depreciacionesAsignar.setnombre_sub_grupo(depreciaciones.getnombre_sub_grupo());	
		depreciacionesAsignar.setcodigo_detalle_grupo(depreciaciones.getcodigo_detalle_grupo());	
		depreciacionesAsignar.setnombre_detalle_grupo(depreciaciones.getnombre_detalle_grupo());	
		depreciacionesAsignar.setclave(depreciaciones.getclave());	
		depreciacionesAsignar.setnombre(depreciaciones.getnombre());	
		depreciacionesAsignar.setfecha_compra(depreciaciones.getfecha_compra());	
		depreciacionesAsignar.setvida_util(depreciaciones.getvida_util());	
		depreciacionesAsignar.setcosto_de_compra(depreciaciones.getcosto_de_compra());	
		depreciacionesAsignar.setfecha_mantenimiento(depreciaciones.getfecha_mantenimiento());	
		depreciacionesAsignar.setfecha_depreciacion(depreciaciones.getfecha_depreciacion());	
		depreciacionesAsignar.setid_anio(depreciaciones.getid_anio());
		depreciacionesAsignar.setanio_descripcion(depreciaciones.getanio_descripcion());	
		depreciacionesAsignar.setid_mes(depreciaciones.getid_mes());
		depreciacionesAsignar.setmes_descripcion(depreciaciones.getmes_descripcion());	
		depreciacionesAsignar.setvalor_acumulado(depreciaciones.getvalor_acumulado());	
		depreciacionesAsignar.setvalor_gasto(depreciaciones.getvalor_gasto());	
	}
	
	public static void inicializarDepreciaciones(Depreciaciones depreciaciones) throws Exception {
		try {
				depreciaciones.setId(0L);	
					
				depreciaciones.setcodigo_sub_grupo("");	
				depreciaciones.setnombre_sub_grupo("");	
				depreciaciones.setcodigo_detalle_grupo("");	
				depreciaciones.setnombre_detalle_grupo("");	
				depreciaciones.setclave("");	
				depreciaciones.setnombre("");	
				depreciaciones.setfecha_compra(new Date());	
				depreciaciones.setvida_util(0.0);	
				depreciaciones.setcosto_de_compra(0.0);	
				depreciaciones.setfecha_mantenimiento(new Date());	
				depreciaciones.setfecha_depreciacion(new Date());	
				depreciaciones.setid_anio(null);	
				depreciaciones.setid_mes(null);	
				depreciaciones.setvalor_acumulado(0.0);	
				depreciaciones.setvalor_gasto(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDepreciaciones(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionesConstantesFunciones.LABEL_IDANIOINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionesConstantesFunciones.LABEL_IDANIOFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionesConstantesFunciones.LABEL_IDMESINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionesConstantesFunciones.LABEL_IDMESFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionesConstantesFunciones.LABEL_CODIGOSUBGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionesConstantesFunciones.LABEL_NOMBRESUBGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionesConstantesFunciones.LABEL_CODIGODETALLEGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionesConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionesConstantesFunciones.LABEL_CLAVE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionesConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionesConstantesFunciones.LABEL_FECHACOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionesConstantesFunciones.LABEL_VIDAUTIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionesConstantesFunciones.LABEL_COSTODECOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionesConstantesFunciones.LABEL_FECHAMANTENIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionesConstantesFunciones.LABEL_FECHADEPRECIACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionesConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionesConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionesConstantesFunciones.LABEL_VALORACUMULADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionesConstantesFunciones.LABEL_VALORGASTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDepreciaciones(String sTipo,Row row,Workbook workbook,Depreciaciones depreciaciones,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciaciones.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciaciones.getanioinicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciaciones.getaniofin_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciaciones.getmesinicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciaciones.getmesfin_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciaciones.getcodigo_sub_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciaciones.getnombre_sub_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciaciones.getcodigo_detalle_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciaciones.getnombre_detalle_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciaciones.getclave());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciaciones.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciaciones.getfecha_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciaciones.getvida_util());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciaciones.getcosto_de_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciaciones.getfecha_mantenimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciaciones.getfecha_depreciacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciaciones.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciaciones.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciaciones.getvalor_acumulado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciaciones.getvalor_gasto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDepreciaciones="";
	
	public String getsFinalQueryDepreciaciones() {
		return this.sFinalQueryDepreciaciones;
	}
	
	public void setsFinalQueryDepreciaciones(String sFinalQueryDepreciaciones) {
		this.sFinalQueryDepreciaciones= sFinalQueryDepreciaciones;
	}
	
	public Border resaltarSeleccionarDepreciaciones=null;
	
	public Border setResaltarSeleccionarDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//depreciacionesBeanSwingJInternalFrame.jTtoolBarDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDepreciaciones= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDepreciaciones() {
		return this.resaltarSeleccionarDepreciaciones;
	}
	
	public void setResaltarSeleccionarDepreciaciones(Border borderResaltarSeleccionarDepreciaciones) {
		this.resaltarSeleccionarDepreciaciones= borderResaltarSeleccionarDepreciaciones;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDepreciaciones=null;
	public Boolean mostraridDepreciaciones=true;
	public Boolean activaridDepreciaciones=true;

	public Border resaltarid_empresaDepreciaciones=null;
	public Boolean mostrarid_empresaDepreciaciones=true;
	public Boolean activarid_empresaDepreciaciones=true;
	public Boolean cargarid_empresaDepreciaciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDepreciaciones=false;//ConEventDepend=true

	public Border resaltarid_anio_inicioDepreciaciones=null;
	public Boolean mostrarid_anio_inicioDepreciaciones=true;
	public Boolean activarid_anio_inicioDepreciaciones=true;
	public Boolean cargarid_anio_inicioDepreciaciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anio_inicioDepreciaciones=false;//ConEventDepend=true

	public Border resaltarid_anio_finDepreciaciones=null;
	public Boolean mostrarid_anio_finDepreciaciones=true;
	public Boolean activarid_anio_finDepreciaciones=true;
	public Boolean cargarid_anio_finDepreciaciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anio_finDepreciaciones=false;//ConEventDepend=true

	public Border resaltarid_mes_inicioDepreciaciones=null;
	public Boolean mostrarid_mes_inicioDepreciaciones=true;
	public Boolean activarid_mes_inicioDepreciaciones=true;
	public Boolean cargarid_mes_inicioDepreciaciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mes_inicioDepreciaciones=false;//ConEventDepend=true

	public Border resaltarid_mes_finDepreciaciones=null;
	public Boolean mostrarid_mes_finDepreciaciones=true;
	public Boolean activarid_mes_finDepreciaciones=true;
	public Boolean cargarid_mes_finDepreciaciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mes_finDepreciaciones=false;//ConEventDepend=true

	public Border resaltarcodigo_sub_grupoDepreciaciones=null;
	public Boolean mostrarcodigo_sub_grupoDepreciaciones=true;
	public Boolean activarcodigo_sub_grupoDepreciaciones=true;

	public Border resaltarnombre_sub_grupoDepreciaciones=null;
	public Boolean mostrarnombre_sub_grupoDepreciaciones=true;
	public Boolean activarnombre_sub_grupoDepreciaciones=true;

	public Border resaltarcodigo_detalle_grupoDepreciaciones=null;
	public Boolean mostrarcodigo_detalle_grupoDepreciaciones=true;
	public Boolean activarcodigo_detalle_grupoDepreciaciones=true;

	public Border resaltarnombre_detalle_grupoDepreciaciones=null;
	public Boolean mostrarnombre_detalle_grupoDepreciaciones=true;
	public Boolean activarnombre_detalle_grupoDepreciaciones=true;

	public Border resaltarclaveDepreciaciones=null;
	public Boolean mostrarclaveDepreciaciones=true;
	public Boolean activarclaveDepreciaciones=true;

	public Border resaltarnombreDepreciaciones=null;
	public Boolean mostrarnombreDepreciaciones=true;
	public Boolean activarnombreDepreciaciones=true;

	public Border resaltarfecha_compraDepreciaciones=null;
	public Boolean mostrarfecha_compraDepreciaciones=true;
	public Boolean activarfecha_compraDepreciaciones=true;

	public Border resaltarvida_utilDepreciaciones=null;
	public Boolean mostrarvida_utilDepreciaciones=true;
	public Boolean activarvida_utilDepreciaciones=true;

	public Border resaltarcosto_de_compraDepreciaciones=null;
	public Boolean mostrarcosto_de_compraDepreciaciones=true;
	public Boolean activarcosto_de_compraDepreciaciones=true;

	public Border resaltarfecha_mantenimientoDepreciaciones=null;
	public Boolean mostrarfecha_mantenimientoDepreciaciones=true;
	public Boolean activarfecha_mantenimientoDepreciaciones=true;

	public Border resaltarfecha_depreciacionDepreciaciones=null;
	public Boolean mostrarfecha_depreciacionDepreciaciones=true;
	public Boolean activarfecha_depreciacionDepreciaciones=true;

	public Border resaltarid_anioDepreciaciones=null;
	public Boolean mostrarid_anioDepreciaciones=true;
	public Boolean activarid_anioDepreciaciones=true;
	public Boolean cargarid_anioDepreciaciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDepreciaciones=false;//ConEventDepend=true

	public Border resaltarid_mesDepreciaciones=null;
	public Boolean mostrarid_mesDepreciaciones=true;
	public Boolean activarid_mesDepreciaciones=true;
	public Boolean cargarid_mesDepreciaciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDepreciaciones=false;//ConEventDepend=true

	public Border resaltarvalor_acumuladoDepreciaciones=null;
	public Boolean mostrarvalor_acumuladoDepreciaciones=true;
	public Boolean activarvalor_acumuladoDepreciaciones=true;

	public Border resaltarvalor_gastoDepreciaciones=null;
	public Boolean mostrarvalor_gastoDepreciaciones=true;
	public Boolean activarvalor_gastoDepreciaciones=true;

	
	

	public Border setResaltaridDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionesBeanSwingJInternalFrame.jTtoolBarDepreciaciones.setBorder(borderResaltar);
		
		this.resaltaridDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDepreciaciones() {
		return this.resaltaridDepreciaciones;
	}

	public void setResaltaridDepreciaciones(Border borderResaltar) {
		this.resaltaridDepreciaciones= borderResaltar;
	}

	public Boolean getMostraridDepreciaciones() {
		return this.mostraridDepreciaciones;
	}

	public void setMostraridDepreciaciones(Boolean mostraridDepreciaciones) {
		this.mostraridDepreciaciones= mostraridDepreciaciones;
	}

	public Boolean getActivaridDepreciaciones() {
		return this.activaridDepreciaciones;
	}

	public void setActivaridDepreciaciones(Boolean activaridDepreciaciones) {
		this.activaridDepreciaciones= activaridDepreciaciones;
	}

	public Border setResaltarid_empresaDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionesBeanSwingJInternalFrame.jTtoolBarDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarid_empresaDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDepreciaciones() {
		return this.resaltarid_empresaDepreciaciones;
	}

	public void setResaltarid_empresaDepreciaciones(Border borderResaltar) {
		this.resaltarid_empresaDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarid_empresaDepreciaciones() {
		return this.mostrarid_empresaDepreciaciones;
	}

	public void setMostrarid_empresaDepreciaciones(Boolean mostrarid_empresaDepreciaciones) {
		this.mostrarid_empresaDepreciaciones= mostrarid_empresaDepreciaciones;
	}

	public Boolean getActivarid_empresaDepreciaciones() {
		return this.activarid_empresaDepreciaciones;
	}

	public void setActivarid_empresaDepreciaciones(Boolean activarid_empresaDepreciaciones) {
		this.activarid_empresaDepreciaciones= activarid_empresaDepreciaciones;
	}

	public Boolean getCargarid_empresaDepreciaciones() {
		return this.cargarid_empresaDepreciaciones;
	}

	public void setCargarid_empresaDepreciaciones(Boolean cargarid_empresaDepreciaciones) {
		this.cargarid_empresaDepreciaciones= cargarid_empresaDepreciaciones;
	}

	public Border setResaltarid_anio_inicioDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionesBeanSwingJInternalFrame.jTtoolBarDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarid_anio_inicioDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anio_inicioDepreciaciones() {
		return this.resaltarid_anio_inicioDepreciaciones;
	}

	public void setResaltarid_anio_inicioDepreciaciones(Border borderResaltar) {
		this.resaltarid_anio_inicioDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarid_anio_inicioDepreciaciones() {
		return this.mostrarid_anio_inicioDepreciaciones;
	}

	public void setMostrarid_anio_inicioDepreciaciones(Boolean mostrarid_anio_inicioDepreciaciones) {
		this.mostrarid_anio_inicioDepreciaciones= mostrarid_anio_inicioDepreciaciones;
	}

	public Boolean getActivarid_anio_inicioDepreciaciones() {
		return this.activarid_anio_inicioDepreciaciones;
	}

	public void setActivarid_anio_inicioDepreciaciones(Boolean activarid_anio_inicioDepreciaciones) {
		this.activarid_anio_inicioDepreciaciones= activarid_anio_inicioDepreciaciones;
	}

	public Boolean getCargarid_anio_inicioDepreciaciones() {
		return this.cargarid_anio_inicioDepreciaciones;
	}

	public void setCargarid_anio_inicioDepreciaciones(Boolean cargarid_anio_inicioDepreciaciones) {
		this.cargarid_anio_inicioDepreciaciones= cargarid_anio_inicioDepreciaciones;
	}

	public Border setResaltarid_anio_finDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionesBeanSwingJInternalFrame.jTtoolBarDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarid_anio_finDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anio_finDepreciaciones() {
		return this.resaltarid_anio_finDepreciaciones;
	}

	public void setResaltarid_anio_finDepreciaciones(Border borderResaltar) {
		this.resaltarid_anio_finDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarid_anio_finDepreciaciones() {
		return this.mostrarid_anio_finDepreciaciones;
	}

	public void setMostrarid_anio_finDepreciaciones(Boolean mostrarid_anio_finDepreciaciones) {
		this.mostrarid_anio_finDepreciaciones= mostrarid_anio_finDepreciaciones;
	}

	public Boolean getActivarid_anio_finDepreciaciones() {
		return this.activarid_anio_finDepreciaciones;
	}

	public void setActivarid_anio_finDepreciaciones(Boolean activarid_anio_finDepreciaciones) {
		this.activarid_anio_finDepreciaciones= activarid_anio_finDepreciaciones;
	}

	public Boolean getCargarid_anio_finDepreciaciones() {
		return this.cargarid_anio_finDepreciaciones;
	}

	public void setCargarid_anio_finDepreciaciones(Boolean cargarid_anio_finDepreciaciones) {
		this.cargarid_anio_finDepreciaciones= cargarid_anio_finDepreciaciones;
	}

	public Border setResaltarid_mes_inicioDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionesBeanSwingJInternalFrame.jTtoolBarDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarid_mes_inicioDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mes_inicioDepreciaciones() {
		return this.resaltarid_mes_inicioDepreciaciones;
	}

	public void setResaltarid_mes_inicioDepreciaciones(Border borderResaltar) {
		this.resaltarid_mes_inicioDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarid_mes_inicioDepreciaciones() {
		return this.mostrarid_mes_inicioDepreciaciones;
	}

	public void setMostrarid_mes_inicioDepreciaciones(Boolean mostrarid_mes_inicioDepreciaciones) {
		this.mostrarid_mes_inicioDepreciaciones= mostrarid_mes_inicioDepreciaciones;
	}

	public Boolean getActivarid_mes_inicioDepreciaciones() {
		return this.activarid_mes_inicioDepreciaciones;
	}

	public void setActivarid_mes_inicioDepreciaciones(Boolean activarid_mes_inicioDepreciaciones) {
		this.activarid_mes_inicioDepreciaciones= activarid_mes_inicioDepreciaciones;
	}

	public Boolean getCargarid_mes_inicioDepreciaciones() {
		return this.cargarid_mes_inicioDepreciaciones;
	}

	public void setCargarid_mes_inicioDepreciaciones(Boolean cargarid_mes_inicioDepreciaciones) {
		this.cargarid_mes_inicioDepreciaciones= cargarid_mes_inicioDepreciaciones;
	}

	public Border setResaltarid_mes_finDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionesBeanSwingJInternalFrame.jTtoolBarDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarid_mes_finDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mes_finDepreciaciones() {
		return this.resaltarid_mes_finDepreciaciones;
	}

	public void setResaltarid_mes_finDepreciaciones(Border borderResaltar) {
		this.resaltarid_mes_finDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarid_mes_finDepreciaciones() {
		return this.mostrarid_mes_finDepreciaciones;
	}

	public void setMostrarid_mes_finDepreciaciones(Boolean mostrarid_mes_finDepreciaciones) {
		this.mostrarid_mes_finDepreciaciones= mostrarid_mes_finDepreciaciones;
	}

	public Boolean getActivarid_mes_finDepreciaciones() {
		return this.activarid_mes_finDepreciaciones;
	}

	public void setActivarid_mes_finDepreciaciones(Boolean activarid_mes_finDepreciaciones) {
		this.activarid_mes_finDepreciaciones= activarid_mes_finDepreciaciones;
	}

	public Boolean getCargarid_mes_finDepreciaciones() {
		return this.cargarid_mes_finDepreciaciones;
	}

	public void setCargarid_mes_finDepreciaciones(Boolean cargarid_mes_finDepreciaciones) {
		this.cargarid_mes_finDepreciaciones= cargarid_mes_finDepreciaciones;
	}

	public Border setResaltarcodigo_sub_grupoDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionesBeanSwingJInternalFrame.jTtoolBarDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarcodigo_sub_grupoDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_sub_grupoDepreciaciones() {
		return this.resaltarcodigo_sub_grupoDepreciaciones;
	}

	public void setResaltarcodigo_sub_grupoDepreciaciones(Border borderResaltar) {
		this.resaltarcodigo_sub_grupoDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarcodigo_sub_grupoDepreciaciones() {
		return this.mostrarcodigo_sub_grupoDepreciaciones;
	}

	public void setMostrarcodigo_sub_grupoDepreciaciones(Boolean mostrarcodigo_sub_grupoDepreciaciones) {
		this.mostrarcodigo_sub_grupoDepreciaciones= mostrarcodigo_sub_grupoDepreciaciones;
	}

	public Boolean getActivarcodigo_sub_grupoDepreciaciones() {
		return this.activarcodigo_sub_grupoDepreciaciones;
	}

	public void setActivarcodigo_sub_grupoDepreciaciones(Boolean activarcodigo_sub_grupoDepreciaciones) {
		this.activarcodigo_sub_grupoDepreciaciones= activarcodigo_sub_grupoDepreciaciones;
	}

	public Border setResaltarnombre_sub_grupoDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionesBeanSwingJInternalFrame.jTtoolBarDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarnombre_sub_grupoDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sub_grupoDepreciaciones() {
		return this.resaltarnombre_sub_grupoDepreciaciones;
	}

	public void setResaltarnombre_sub_grupoDepreciaciones(Border borderResaltar) {
		this.resaltarnombre_sub_grupoDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarnombre_sub_grupoDepreciaciones() {
		return this.mostrarnombre_sub_grupoDepreciaciones;
	}

	public void setMostrarnombre_sub_grupoDepreciaciones(Boolean mostrarnombre_sub_grupoDepreciaciones) {
		this.mostrarnombre_sub_grupoDepreciaciones= mostrarnombre_sub_grupoDepreciaciones;
	}

	public Boolean getActivarnombre_sub_grupoDepreciaciones() {
		return this.activarnombre_sub_grupoDepreciaciones;
	}

	public void setActivarnombre_sub_grupoDepreciaciones(Boolean activarnombre_sub_grupoDepreciaciones) {
		this.activarnombre_sub_grupoDepreciaciones= activarnombre_sub_grupoDepreciaciones;
	}

	public Border setResaltarcodigo_detalle_grupoDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionesBeanSwingJInternalFrame.jTtoolBarDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarcodigo_detalle_grupoDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_detalle_grupoDepreciaciones() {
		return this.resaltarcodigo_detalle_grupoDepreciaciones;
	}

	public void setResaltarcodigo_detalle_grupoDepreciaciones(Border borderResaltar) {
		this.resaltarcodigo_detalle_grupoDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarcodigo_detalle_grupoDepreciaciones() {
		return this.mostrarcodigo_detalle_grupoDepreciaciones;
	}

	public void setMostrarcodigo_detalle_grupoDepreciaciones(Boolean mostrarcodigo_detalle_grupoDepreciaciones) {
		this.mostrarcodigo_detalle_grupoDepreciaciones= mostrarcodigo_detalle_grupoDepreciaciones;
	}

	public Boolean getActivarcodigo_detalle_grupoDepreciaciones() {
		return this.activarcodigo_detalle_grupoDepreciaciones;
	}

	public void setActivarcodigo_detalle_grupoDepreciaciones(Boolean activarcodigo_detalle_grupoDepreciaciones) {
		this.activarcodigo_detalle_grupoDepreciaciones= activarcodigo_detalle_grupoDepreciaciones;
	}

	public Border setResaltarnombre_detalle_grupoDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionesBeanSwingJInternalFrame.jTtoolBarDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarnombre_detalle_grupoDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_detalle_grupoDepreciaciones() {
		return this.resaltarnombre_detalle_grupoDepreciaciones;
	}

	public void setResaltarnombre_detalle_grupoDepreciaciones(Border borderResaltar) {
		this.resaltarnombre_detalle_grupoDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarnombre_detalle_grupoDepreciaciones() {
		return this.mostrarnombre_detalle_grupoDepreciaciones;
	}

	public void setMostrarnombre_detalle_grupoDepreciaciones(Boolean mostrarnombre_detalle_grupoDepreciaciones) {
		this.mostrarnombre_detalle_grupoDepreciaciones= mostrarnombre_detalle_grupoDepreciaciones;
	}

	public Boolean getActivarnombre_detalle_grupoDepreciaciones() {
		return this.activarnombre_detalle_grupoDepreciaciones;
	}

	public void setActivarnombre_detalle_grupoDepreciaciones(Boolean activarnombre_detalle_grupoDepreciaciones) {
		this.activarnombre_detalle_grupoDepreciaciones= activarnombre_detalle_grupoDepreciaciones;
	}

	public Border setResaltarclaveDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionesBeanSwingJInternalFrame.jTtoolBarDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarclaveDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarclaveDepreciaciones() {
		return this.resaltarclaveDepreciaciones;
	}

	public void setResaltarclaveDepreciaciones(Border borderResaltar) {
		this.resaltarclaveDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarclaveDepreciaciones() {
		return this.mostrarclaveDepreciaciones;
	}

	public void setMostrarclaveDepreciaciones(Boolean mostrarclaveDepreciaciones) {
		this.mostrarclaveDepreciaciones= mostrarclaveDepreciaciones;
	}

	public Boolean getActivarclaveDepreciaciones() {
		return this.activarclaveDepreciaciones;
	}

	public void setActivarclaveDepreciaciones(Boolean activarclaveDepreciaciones) {
		this.activarclaveDepreciaciones= activarclaveDepreciaciones;
	}

	public Border setResaltarnombreDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionesBeanSwingJInternalFrame.jTtoolBarDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarnombreDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreDepreciaciones() {
		return this.resaltarnombreDepreciaciones;
	}

	public void setResaltarnombreDepreciaciones(Border borderResaltar) {
		this.resaltarnombreDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarnombreDepreciaciones() {
		return this.mostrarnombreDepreciaciones;
	}

	public void setMostrarnombreDepreciaciones(Boolean mostrarnombreDepreciaciones) {
		this.mostrarnombreDepreciaciones= mostrarnombreDepreciaciones;
	}

	public Boolean getActivarnombreDepreciaciones() {
		return this.activarnombreDepreciaciones;
	}

	public void setActivarnombreDepreciaciones(Boolean activarnombreDepreciaciones) {
		this.activarnombreDepreciaciones= activarnombreDepreciaciones;
	}

	public Border setResaltarfecha_compraDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionesBeanSwingJInternalFrame.jTtoolBarDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarfecha_compraDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_compraDepreciaciones() {
		return this.resaltarfecha_compraDepreciaciones;
	}

	public void setResaltarfecha_compraDepreciaciones(Border borderResaltar) {
		this.resaltarfecha_compraDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarfecha_compraDepreciaciones() {
		return this.mostrarfecha_compraDepreciaciones;
	}

	public void setMostrarfecha_compraDepreciaciones(Boolean mostrarfecha_compraDepreciaciones) {
		this.mostrarfecha_compraDepreciaciones= mostrarfecha_compraDepreciaciones;
	}

	public Boolean getActivarfecha_compraDepreciaciones() {
		return this.activarfecha_compraDepreciaciones;
	}

	public void setActivarfecha_compraDepreciaciones(Boolean activarfecha_compraDepreciaciones) {
		this.activarfecha_compraDepreciaciones= activarfecha_compraDepreciaciones;
	}

	public Border setResaltarvida_utilDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionesBeanSwingJInternalFrame.jTtoolBarDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarvida_utilDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvida_utilDepreciaciones() {
		return this.resaltarvida_utilDepreciaciones;
	}

	public void setResaltarvida_utilDepreciaciones(Border borderResaltar) {
		this.resaltarvida_utilDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarvida_utilDepreciaciones() {
		return this.mostrarvida_utilDepreciaciones;
	}

	public void setMostrarvida_utilDepreciaciones(Boolean mostrarvida_utilDepreciaciones) {
		this.mostrarvida_utilDepreciaciones= mostrarvida_utilDepreciaciones;
	}

	public Boolean getActivarvida_utilDepreciaciones() {
		return this.activarvida_utilDepreciaciones;
	}

	public void setActivarvida_utilDepreciaciones(Boolean activarvida_utilDepreciaciones) {
		this.activarvida_utilDepreciaciones= activarvida_utilDepreciaciones;
	}

	public Border setResaltarcosto_de_compraDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionesBeanSwingJInternalFrame.jTtoolBarDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarcosto_de_compraDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_de_compraDepreciaciones() {
		return this.resaltarcosto_de_compraDepreciaciones;
	}

	public void setResaltarcosto_de_compraDepreciaciones(Border borderResaltar) {
		this.resaltarcosto_de_compraDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarcosto_de_compraDepreciaciones() {
		return this.mostrarcosto_de_compraDepreciaciones;
	}

	public void setMostrarcosto_de_compraDepreciaciones(Boolean mostrarcosto_de_compraDepreciaciones) {
		this.mostrarcosto_de_compraDepreciaciones= mostrarcosto_de_compraDepreciaciones;
	}

	public Boolean getActivarcosto_de_compraDepreciaciones() {
		return this.activarcosto_de_compraDepreciaciones;
	}

	public void setActivarcosto_de_compraDepreciaciones(Boolean activarcosto_de_compraDepreciaciones) {
		this.activarcosto_de_compraDepreciaciones= activarcosto_de_compraDepreciaciones;
	}

	public Border setResaltarfecha_mantenimientoDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionesBeanSwingJInternalFrame.jTtoolBarDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarfecha_mantenimientoDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_mantenimientoDepreciaciones() {
		return this.resaltarfecha_mantenimientoDepreciaciones;
	}

	public void setResaltarfecha_mantenimientoDepreciaciones(Border borderResaltar) {
		this.resaltarfecha_mantenimientoDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarfecha_mantenimientoDepreciaciones() {
		return this.mostrarfecha_mantenimientoDepreciaciones;
	}

	public void setMostrarfecha_mantenimientoDepreciaciones(Boolean mostrarfecha_mantenimientoDepreciaciones) {
		this.mostrarfecha_mantenimientoDepreciaciones= mostrarfecha_mantenimientoDepreciaciones;
	}

	public Boolean getActivarfecha_mantenimientoDepreciaciones() {
		return this.activarfecha_mantenimientoDepreciaciones;
	}

	public void setActivarfecha_mantenimientoDepreciaciones(Boolean activarfecha_mantenimientoDepreciaciones) {
		this.activarfecha_mantenimientoDepreciaciones= activarfecha_mantenimientoDepreciaciones;
	}

	public Border setResaltarfecha_depreciacionDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionesBeanSwingJInternalFrame.jTtoolBarDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarfecha_depreciacionDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_depreciacionDepreciaciones() {
		return this.resaltarfecha_depreciacionDepreciaciones;
	}

	public void setResaltarfecha_depreciacionDepreciaciones(Border borderResaltar) {
		this.resaltarfecha_depreciacionDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarfecha_depreciacionDepreciaciones() {
		return this.mostrarfecha_depreciacionDepreciaciones;
	}

	public void setMostrarfecha_depreciacionDepreciaciones(Boolean mostrarfecha_depreciacionDepreciaciones) {
		this.mostrarfecha_depreciacionDepreciaciones= mostrarfecha_depreciacionDepreciaciones;
	}

	public Boolean getActivarfecha_depreciacionDepreciaciones() {
		return this.activarfecha_depreciacionDepreciaciones;
	}

	public void setActivarfecha_depreciacionDepreciaciones(Boolean activarfecha_depreciacionDepreciaciones) {
		this.activarfecha_depreciacionDepreciaciones= activarfecha_depreciacionDepreciaciones;
	}

	public Border setResaltarid_anioDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionesBeanSwingJInternalFrame.jTtoolBarDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarid_anioDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDepreciaciones() {
		return this.resaltarid_anioDepreciaciones;
	}

	public void setResaltarid_anioDepreciaciones(Border borderResaltar) {
		this.resaltarid_anioDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarid_anioDepreciaciones() {
		return this.mostrarid_anioDepreciaciones;
	}

	public void setMostrarid_anioDepreciaciones(Boolean mostrarid_anioDepreciaciones) {
		this.mostrarid_anioDepreciaciones= mostrarid_anioDepreciaciones;
	}

	public Boolean getActivarid_anioDepreciaciones() {
		return this.activarid_anioDepreciaciones;
	}

	public void setActivarid_anioDepreciaciones(Boolean activarid_anioDepreciaciones) {
		this.activarid_anioDepreciaciones= activarid_anioDepreciaciones;
	}

	public Boolean getCargarid_anioDepreciaciones() {
		return this.cargarid_anioDepreciaciones;
	}

	public void setCargarid_anioDepreciaciones(Boolean cargarid_anioDepreciaciones) {
		this.cargarid_anioDepreciaciones= cargarid_anioDepreciaciones;
	}

	public Border setResaltarid_mesDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionesBeanSwingJInternalFrame.jTtoolBarDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarid_mesDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDepreciaciones() {
		return this.resaltarid_mesDepreciaciones;
	}

	public void setResaltarid_mesDepreciaciones(Border borderResaltar) {
		this.resaltarid_mesDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarid_mesDepreciaciones() {
		return this.mostrarid_mesDepreciaciones;
	}

	public void setMostrarid_mesDepreciaciones(Boolean mostrarid_mesDepreciaciones) {
		this.mostrarid_mesDepreciaciones= mostrarid_mesDepreciaciones;
	}

	public Boolean getActivarid_mesDepreciaciones() {
		return this.activarid_mesDepreciaciones;
	}

	public void setActivarid_mesDepreciaciones(Boolean activarid_mesDepreciaciones) {
		this.activarid_mesDepreciaciones= activarid_mesDepreciaciones;
	}

	public Boolean getCargarid_mesDepreciaciones() {
		return this.cargarid_mesDepreciaciones;
	}

	public void setCargarid_mesDepreciaciones(Boolean cargarid_mesDepreciaciones) {
		this.cargarid_mesDepreciaciones= cargarid_mesDepreciaciones;
	}

	public Border setResaltarvalor_acumuladoDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionesBeanSwingJInternalFrame.jTtoolBarDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarvalor_acumuladoDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_acumuladoDepreciaciones() {
		return this.resaltarvalor_acumuladoDepreciaciones;
	}

	public void setResaltarvalor_acumuladoDepreciaciones(Border borderResaltar) {
		this.resaltarvalor_acumuladoDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarvalor_acumuladoDepreciaciones() {
		return this.mostrarvalor_acumuladoDepreciaciones;
	}

	public void setMostrarvalor_acumuladoDepreciaciones(Boolean mostrarvalor_acumuladoDepreciaciones) {
		this.mostrarvalor_acumuladoDepreciaciones= mostrarvalor_acumuladoDepreciaciones;
	}

	public Boolean getActivarvalor_acumuladoDepreciaciones() {
		return this.activarvalor_acumuladoDepreciaciones;
	}

	public void setActivarvalor_acumuladoDepreciaciones(Boolean activarvalor_acumuladoDepreciaciones) {
		this.activarvalor_acumuladoDepreciaciones= activarvalor_acumuladoDepreciaciones;
	}

	public Border setResaltarvalor_gastoDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionesBeanSwingJInternalFrame.jTtoolBarDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarvalor_gastoDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_gastoDepreciaciones() {
		return this.resaltarvalor_gastoDepreciaciones;
	}

	public void setResaltarvalor_gastoDepreciaciones(Border borderResaltar) {
		this.resaltarvalor_gastoDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarvalor_gastoDepreciaciones() {
		return this.mostrarvalor_gastoDepreciaciones;
	}

	public void setMostrarvalor_gastoDepreciaciones(Boolean mostrarvalor_gastoDepreciaciones) {
		this.mostrarvalor_gastoDepreciaciones= mostrarvalor_gastoDepreciaciones;
	}

	public Boolean getActivarvalor_gastoDepreciaciones() {
		return this.activarvalor_gastoDepreciaciones;
	}

	public void setActivarvalor_gastoDepreciaciones(Boolean activarvalor_gastoDepreciaciones) {
		this.activarvalor_gastoDepreciaciones= activarvalor_gastoDepreciaciones;
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
		
		
		this.setMostraridDepreciaciones(esInicial);
		this.setMostrarid_empresaDepreciaciones(esInicial);
		this.setMostrarid_anio_inicioDepreciaciones(esInicial);
		this.setMostrarid_anio_finDepreciaciones(esInicial);
		this.setMostrarid_mes_inicioDepreciaciones(esInicial);
		this.setMostrarid_mes_finDepreciaciones(esInicial);
		this.setMostrarcodigo_sub_grupoDepreciaciones(esInicial);
		this.setMostrarnombre_sub_grupoDepreciaciones(esInicial);
		this.setMostrarcodigo_detalle_grupoDepreciaciones(esInicial);
		this.setMostrarnombre_detalle_grupoDepreciaciones(esInicial);
		this.setMostrarclaveDepreciaciones(esInicial);
		this.setMostrarnombreDepreciaciones(esInicial);
		this.setMostrarfecha_compraDepreciaciones(esInicial);
		this.setMostrarvida_utilDepreciaciones(esInicial);
		this.setMostrarcosto_de_compraDepreciaciones(esInicial);
		this.setMostrarfecha_mantenimientoDepreciaciones(esInicial);
		this.setMostrarfecha_depreciacionDepreciaciones(esInicial);
		this.setMostrarid_anioDepreciaciones(esInicial);
		this.setMostrarid_mesDepreciaciones(esInicial);
		this.setMostrarvalor_acumuladoDepreciaciones(esInicial);
		this.setMostrarvalor_gastoDepreciaciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DepreciacionesConstantesFunciones.ID)) {
				this.setMostraridDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.IDANIOINICIO)) {
				this.setMostrarid_anio_inicioDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.IDANIOFIN)) {
				this.setMostrarid_anio_finDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.IDMESINICIO)) {
				this.setMostrarid_mes_inicioDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.IDMESFIN)) {
				this.setMostrarid_mes_finDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setMostrarcodigo_sub_grupoDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setMostrarnombre_sub_grupoDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setMostrarcodigo_detalle_grupoDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setMostrarnombre_detalle_grupoDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.CLAVE)) {
				this.setMostrarclaveDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.FECHACOMPRA)) {
				this.setMostrarfecha_compraDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.VIDAUTIL)) {
				this.setMostrarvida_utilDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.COSTODECOMPRA)) {
				this.setMostrarcosto_de_compraDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.FECHAMANTENIMIENTO)) {
				this.setMostrarfecha_mantenimientoDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.FECHADEPRECIACION)) {
				this.setMostrarfecha_depreciacionDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.VALORACUMULADO)) {
				this.setMostrarvalor_acumuladoDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.VALORGASTO)) {
				this.setMostrarvalor_gastoDepreciaciones(esAsigna);
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
		
		
		this.setActivaridDepreciaciones(esInicial);
		this.setActivarid_empresaDepreciaciones(esInicial);
		this.setActivarid_anio_inicioDepreciaciones(esInicial);
		this.setActivarid_anio_finDepreciaciones(esInicial);
		this.setActivarid_mes_inicioDepreciaciones(esInicial);
		this.setActivarid_mes_finDepreciaciones(esInicial);
		this.setActivarcodigo_sub_grupoDepreciaciones(esInicial);
		this.setActivarnombre_sub_grupoDepreciaciones(esInicial);
		this.setActivarcodigo_detalle_grupoDepreciaciones(esInicial);
		this.setActivarnombre_detalle_grupoDepreciaciones(esInicial);
		this.setActivarclaveDepreciaciones(esInicial);
		this.setActivarnombreDepreciaciones(esInicial);
		this.setActivarfecha_compraDepreciaciones(esInicial);
		this.setActivarvida_utilDepreciaciones(esInicial);
		this.setActivarcosto_de_compraDepreciaciones(esInicial);
		this.setActivarfecha_mantenimientoDepreciaciones(esInicial);
		this.setActivarfecha_depreciacionDepreciaciones(esInicial);
		this.setActivarid_anioDepreciaciones(esInicial);
		this.setActivarid_mesDepreciaciones(esInicial);
		this.setActivarvalor_acumuladoDepreciaciones(esInicial);
		this.setActivarvalor_gastoDepreciaciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DepreciacionesConstantesFunciones.ID)) {
				this.setActivaridDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.IDANIOINICIO)) {
				this.setActivarid_anio_inicioDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.IDANIOFIN)) {
				this.setActivarid_anio_finDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.IDMESINICIO)) {
				this.setActivarid_mes_inicioDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.IDMESFIN)) {
				this.setActivarid_mes_finDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setActivarcodigo_sub_grupoDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setActivarnombre_sub_grupoDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setActivarcodigo_detalle_grupoDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setActivarnombre_detalle_grupoDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.CLAVE)) {
				this.setActivarclaveDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.NOMBRE)) {
				this.setActivarnombreDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.FECHACOMPRA)) {
				this.setActivarfecha_compraDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.VIDAUTIL)) {
				this.setActivarvida_utilDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.COSTODECOMPRA)) {
				this.setActivarcosto_de_compraDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.FECHAMANTENIMIENTO)) {
				this.setActivarfecha_mantenimientoDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.FECHADEPRECIACION)) {
				this.setActivarfecha_depreciacionDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.IDMES)) {
				this.setActivarid_mesDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.VALORACUMULADO)) {
				this.setActivarvalor_acumuladoDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.VALORGASTO)) {
				this.setActivarvalor_gastoDepreciaciones(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDepreciaciones(esInicial);
		this.setResaltarid_empresaDepreciaciones(esInicial);
		this.setResaltarid_anio_inicioDepreciaciones(esInicial);
		this.setResaltarid_anio_finDepreciaciones(esInicial);
		this.setResaltarid_mes_inicioDepreciaciones(esInicial);
		this.setResaltarid_mes_finDepreciaciones(esInicial);
		this.setResaltarcodigo_sub_grupoDepreciaciones(esInicial);
		this.setResaltarnombre_sub_grupoDepreciaciones(esInicial);
		this.setResaltarcodigo_detalle_grupoDepreciaciones(esInicial);
		this.setResaltarnombre_detalle_grupoDepreciaciones(esInicial);
		this.setResaltarclaveDepreciaciones(esInicial);
		this.setResaltarnombreDepreciaciones(esInicial);
		this.setResaltarfecha_compraDepreciaciones(esInicial);
		this.setResaltarvida_utilDepreciaciones(esInicial);
		this.setResaltarcosto_de_compraDepreciaciones(esInicial);
		this.setResaltarfecha_mantenimientoDepreciaciones(esInicial);
		this.setResaltarfecha_depreciacionDepreciaciones(esInicial);
		this.setResaltarid_anioDepreciaciones(esInicial);
		this.setResaltarid_mesDepreciaciones(esInicial);
		this.setResaltarvalor_acumuladoDepreciaciones(esInicial);
		this.setResaltarvalor_gastoDepreciaciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DepreciacionesConstantesFunciones.ID)) {
				this.setResaltaridDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.IDANIOINICIO)) {
				this.setResaltarid_anio_inicioDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.IDANIOFIN)) {
				this.setResaltarid_anio_finDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.IDMESINICIO)) {
				this.setResaltarid_mes_inicioDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.IDMESFIN)) {
				this.setResaltarid_mes_finDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setResaltarcodigo_sub_grupoDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setResaltarnombre_sub_grupoDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setResaltarcodigo_detalle_grupoDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setResaltarnombre_detalle_grupoDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.CLAVE)) {
				this.setResaltarclaveDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.FECHACOMPRA)) {
				this.setResaltarfecha_compraDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.VIDAUTIL)) {
				this.setResaltarvida_utilDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.COSTODECOMPRA)) {
				this.setResaltarcosto_de_compraDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.FECHAMANTENIMIENTO)) {
				this.setResaltarfecha_mantenimientoDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.FECHADEPRECIACION)) {
				this.setResaltarfecha_depreciacionDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.VALORACUMULADO)) {
				this.setResaltarvalor_acumuladoDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionesConstantesFunciones.VALORGASTO)) {
				this.setResaltarvalor_gastoDepreciaciones(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaDepreciacionesDepreciaciones=true;

	public Boolean getMostrarBusquedaDepreciacionesDepreciaciones() {
		return this.mostrarBusquedaDepreciacionesDepreciaciones;
	}

	public void setMostrarBusquedaDepreciacionesDepreciaciones(Boolean visibilidadResaltar) {
		this.mostrarBusquedaDepreciacionesDepreciaciones= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaDepreciacionesDepreciaciones=true;

	public Boolean getActivarBusquedaDepreciacionesDepreciaciones() {
		return this.activarBusquedaDepreciacionesDepreciaciones;
	}

	public void setActivarBusquedaDepreciacionesDepreciaciones(Boolean habilitarResaltar) {
		this.activarBusquedaDepreciacionesDepreciaciones= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaDepreciacionesDepreciaciones=null;

	public Border getResaltarBusquedaDepreciacionesDepreciaciones() {
		return this.resaltarBusquedaDepreciacionesDepreciaciones;
	}

	public void setResaltarBusquedaDepreciacionesDepreciaciones(Border borderResaltar) {
		this.resaltarBusquedaDepreciacionesDepreciaciones= borderResaltar;
	}

	public void setResaltarBusquedaDepreciacionesDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionesBeanSwingJInternalFrame depreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaDepreciacionesDepreciaciones= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}