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
package com.bydan.erp.inventario.util.report;

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


import com.bydan.erp.inventario.util.report.DisponiblesCostosConstantesFunciones;
import com.bydan.erp.inventario.util.report.DisponiblesCostosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.DisponiblesCostosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;



import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DisponiblesCostosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="DisponiblesCostos";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DisponiblesCostos"+DisponiblesCostosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DisponiblesCostosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DisponiblesCostosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DisponiblesCostosConstantesFunciones.SCHEMA+"_"+DisponiblesCostosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DisponiblesCostosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DisponiblesCostosConstantesFunciones.SCHEMA+"_"+DisponiblesCostosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DisponiblesCostosConstantesFunciones.SCHEMA+"_"+DisponiblesCostosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DisponiblesCostosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DisponiblesCostosConstantesFunciones.SCHEMA+"_"+DisponiblesCostosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DisponiblesCostosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DisponiblesCostosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DisponiblesCostosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DisponiblesCostosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DisponiblesCostosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DisponiblesCostosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DisponiblesCostosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DisponiblesCostosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DisponiblesCostosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DisponiblesCostosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Disponibles Costoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Disponibles Costos";
	public static final String SCLASSWEBTITULO_LOWER="Disponibles Costos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DisponiblesCostos";
	public static final String OBJECTNAME="disponiblescostos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="disponibles_costos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select disponiblescostos from "+DisponiblesCostosConstantesFunciones.SPERSISTENCENAME+" disponiblescostos";
	public static String QUERYSELECTNATIVE="select "+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".id,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".version_row,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".id_bodega,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".id_producto,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".id_empresa,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".id_sucursal,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".id_linea,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".id_linea_grupo,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".id_linea_categoria,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".id_linea_marca,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".nombre_sucursal,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".nombre_linea,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".nombre_linea_grupo,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".nombre_linea_categoria,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".nombre_linea_marca,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".codigo,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".nombre,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".nombre_bodega,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".nombre_unidad,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".ingresos,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".egresos,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".disponible_corte,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".costo,"+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME+".total from "+DisponiblesCostosConstantesFunciones.SCHEMA+"."+DisponiblesCostosConstantesFunciones.TABLENAME;//+" as "+DisponiblesCostosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBRESUCURSAL= "nombre_sucursal";
    public static final String NOMBRELINEA= "nombre_linea";
    public static final String NOMBRELINEAGRUPO= "nombre_linea_grupo";
    public static final String NOMBRELINEACATEGORIA= "nombre_linea_categoria";
    public static final String NOMBRELINEAMARCA= "nombre_linea_marca";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String NOMBREBODEGA= "nombre_bodega";
    public static final String NOMBREUNIDAD= "nombre_unidad";
    public static final String INGRESOS= "ingresos";
    public static final String EGRESOS= "egresos";
    public static final String DISPONIBLECORTE= "disponible_corte";
    public static final String COSTO= "costo";
    public static final String TOTAL= "total";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDLINEAGRUPO= "Linea Grupo";
		public static final String LABEL_IDLINEAGRUPO_LOWER= "Linea Grupo";
    	public static final String LABEL_IDLINEACATEGORIA= "Linea Categoria";
		public static final String LABEL_IDLINEACATEGORIA_LOWER= "Linea Categoria";
    	public static final String LABEL_IDLINEAMARCA= "Linea Marca";
		public static final String LABEL_IDLINEAMARCA_LOWER= "Linea Marca";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBRESUCURSAL= "Nombre Sucursal";
		public static final String LABEL_NOMBRESUCURSAL_LOWER= "Nombre Sucursal";
    	public static final String LABEL_NOMBRELINEA= "Nombre Linea";
		public static final String LABEL_NOMBRELINEA_LOWER= "Nombre Linea";
    	public static final String LABEL_NOMBRELINEAGRUPO= "Nombre Linea Grupo";
		public static final String LABEL_NOMBRELINEAGRUPO_LOWER= "Nombre Linea Grupo";
    	public static final String LABEL_NOMBRELINEACATEGORIA= "Nombre Linea Categoria";
		public static final String LABEL_NOMBRELINEACATEGORIA_LOWER= "Nombre Linea Categoria";
    	public static final String LABEL_NOMBRELINEAMARCA= "Nombre Linea Marca";
		public static final String LABEL_NOMBRELINEAMARCA_LOWER= "Nombre Linea Marca";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_NOMBREBODEGA= "Nombre Bodega";
		public static final String LABEL_NOMBREBODEGA_LOWER= "Nombre Bodega";
    	public static final String LABEL_NOMBREUNIDAD= "Nombre Unad";
		public static final String LABEL_NOMBREUNIDAD_LOWER= "Nombre Unidad";
    	public static final String LABEL_INGRESOS= "Ingresos";
		public static final String LABEL_INGRESOS_LOWER= "Ingresos";
    	public static final String LABEL_EGRESOS= "Egresos";
		public static final String LABEL_EGRESOS_LOWER= "Egresos";
    	public static final String LABEL_DISPONIBLECORTE= "Disponible Corte";
		public static final String LABEL_DISPONIBLECORTE_LOWER= "Disponible Corte";
    	public static final String LABEL_COSTO= "Costo";
		public static final String LABEL_COSTO_LOWER= "Costo";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_SUCURSAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_SUCURSAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_LINEA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LINEA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_LINEA_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LINEA_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_LINEA_CATEGORIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LINEA_CATEGORIA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_LINEA_MARCA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LINEA_MARCA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_BODEGA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BODEGA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_UNIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_UNIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getDisponiblesCostosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.IDBODEGA)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.IDEMPRESA)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.IDLINEA)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.NOMBRESUCURSAL)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_NOMBRESUCURSAL;}
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.NOMBRELINEA)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_NOMBRELINEA;}
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.NOMBRELINEAGRUPO)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_NOMBRELINEAGRUPO;}
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.NOMBRELINEACATEGORIA)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA;}
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.NOMBRELINEAMARCA)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_NOMBRELINEAMARCA;}
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.CODIGO)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.NOMBRE)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.NOMBREBODEGA)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_NOMBREBODEGA;}
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.NOMBREUNIDAD)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_NOMBREUNIDAD;}
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.INGRESOS)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_INGRESOS;}
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.EGRESOS)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_EGRESOS;}
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.DISPONIBLECORTE)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_DISPONIBLECORTE;}
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.COSTO)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(DisponiblesCostosConstantesFunciones.TOTAL)) {sLabelColumna=DisponiblesCostosConstantesFunciones.LABEL_TOTAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDisponiblesCostosDescripcion(DisponiblesCostos disponiblescostos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(disponiblescostos !=null/* && disponiblescostos.getId()!=0*/) {
			sDescripcion=disponiblescostos.getcodigo();//disponiblescostosdisponiblescostos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getDisponiblesCostosDescripcionDetallado(DisponiblesCostos disponiblescostos) {
		String sDescripcion="";
			
		sDescripcion+=DisponiblesCostosConstantesFunciones.ID+"=";
		sDescripcion+=disponiblescostos.getId().toString()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=disponiblescostos.getVersionRow().toString()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=disponiblescostos.getid_bodega().toString()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=disponiblescostos.getid_producto().toString()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=disponiblescostos.getid_empresa().toString()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=disponiblescostos.getid_sucursal().toString()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.IDLINEA+"=";
		sDescripcion+=disponiblescostos.getid_linea().toString()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=disponiblescostos.getid_linea_grupo().toString()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=disponiblescostos.getid_linea_categoria().toString()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=disponiblescostos.getid_linea_marca().toString()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=disponiblescostos.getfecha_emision_hasta().toString()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.NOMBRESUCURSAL+"=";
		sDescripcion+=disponiblescostos.getnombre_sucursal()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.NOMBRELINEA+"=";
		sDescripcion+=disponiblescostos.getnombre_linea()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.NOMBRELINEAGRUPO+"=";
		sDescripcion+=disponiblescostos.getnombre_linea_grupo()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.NOMBRELINEACATEGORIA+"=";
		sDescripcion+=disponiblescostos.getnombre_linea_categoria()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.NOMBRELINEAMARCA+"=";
		sDescripcion+=disponiblescostos.getnombre_linea_marca()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.CODIGO+"=";
		sDescripcion+=disponiblescostos.getcodigo()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.NOMBRE+"=";
		sDescripcion+=disponiblescostos.getnombre()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.NOMBREBODEGA+"=";
		sDescripcion+=disponiblescostos.getnombre_bodega()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.NOMBREUNIDAD+"=";
		sDescripcion+=disponiblescostos.getnombre_unidad()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.INGRESOS+"=";
		sDescripcion+=disponiblescostos.getingresos().toString()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.EGRESOS+"=";
		sDescripcion+=disponiblescostos.getegresos().toString()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.DISPONIBLECORTE+"=";
		sDescripcion+=disponiblescostos.getdisponible_corte().toString()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.COSTO+"=";
		sDescripcion+=disponiblescostos.getcosto().toString()+",";
		sDescripcion+=DisponiblesCostosConstantesFunciones.TOTAL+"=";
		sDescripcion+=disponiblescostos.gettotal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDisponiblesCostosDescripcion(DisponiblesCostos disponiblescostos,String sValor) throws Exception {			
		if(disponiblescostos !=null) {
			disponiblescostos.setcodigo(sValor);;//disponiblescostosdisponiblescostos.getcodigo().trim();
		}		
	}
	
		

	public static String getBodegaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}

	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
		}

		return sDescripcion;
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

	public static String getLineaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaGrupoDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaCategoriaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaMarcaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaDisponiblesCostos")) {
			sNombreIndice="Tipo=  Por Bodega Por Producto Por Linea Por Linea Grupo Por Linea Categoria Por Linea Marca Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdLinea")) {
			sNombreIndice="Tipo=  Por Linea";
		} else if(sNombreIndice.equals("FK_IdLineaCategoria")) {
			sNombreIndice="Tipo=  Por Linea Categoria";
		} else if(sNombreIndice.equals("FK_IdLineaGrupo")) {
			sNombreIndice="Tipo=  Por Linea Grupo";
		} else if(sNombreIndice.equals("FK_IdLineaMarca")) {
			sNombreIndice="Tipo=  Por Linea Marca";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaDisponiblesCostos(Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();}
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();}
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();}
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();}
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();}
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLinea(Long id_linea) {
		String sDetalleIndice=" Parametros->";
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaCategoria(Long id_linea_categoria) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaGrupo(Long id_linea_grupo) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaMarca(Long id_linea_marca) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDisponiblesCostos(DisponiblesCostos disponiblescostos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		disponiblescostos.setnombre_sucursal(disponiblescostos.getnombre_sucursal().trim());
		disponiblescostos.setnombre_linea(disponiblescostos.getnombre_linea().trim());
		disponiblescostos.setnombre_linea_grupo(disponiblescostos.getnombre_linea_grupo().trim());
		disponiblescostos.setnombre_linea_categoria(disponiblescostos.getnombre_linea_categoria().trim());
		disponiblescostos.setnombre_linea_marca(disponiblescostos.getnombre_linea_marca().trim());
		disponiblescostos.setcodigo(disponiblescostos.getcodigo().trim());
		disponiblescostos.setnombre(disponiblescostos.getnombre().trim());
		disponiblescostos.setnombre_bodega(disponiblescostos.getnombre_bodega().trim());
		disponiblescostos.setnombre_unidad(disponiblescostos.getnombre_unidad().trim());
	}
	
	public static void quitarEspaciosDisponiblesCostoss(List<DisponiblesCostos> disponiblescostoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DisponiblesCostos disponiblescostos: disponiblescostoss) {
			disponiblescostos.setnombre_sucursal(disponiblescostos.getnombre_sucursal().trim());
			disponiblescostos.setnombre_linea(disponiblescostos.getnombre_linea().trim());
			disponiblescostos.setnombre_linea_grupo(disponiblescostos.getnombre_linea_grupo().trim());
			disponiblescostos.setnombre_linea_categoria(disponiblescostos.getnombre_linea_categoria().trim());
			disponiblescostos.setnombre_linea_marca(disponiblescostos.getnombre_linea_marca().trim());
			disponiblescostos.setcodigo(disponiblescostos.getcodigo().trim());
			disponiblescostos.setnombre(disponiblescostos.getnombre().trim());
			disponiblescostos.setnombre_bodega(disponiblescostos.getnombre_bodega().trim());
			disponiblescostos.setnombre_unidad(disponiblescostos.getnombre_unidad().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDisponiblesCostos(DisponiblesCostos disponiblescostos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && disponiblescostos.getConCambioAuxiliar()) {
			disponiblescostos.setIsDeleted(disponiblescostos.getIsDeletedAuxiliar());	
			disponiblescostos.setIsNew(disponiblescostos.getIsNewAuxiliar());	
			disponiblescostos.setIsChanged(disponiblescostos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			disponiblescostos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			disponiblescostos.setIsDeletedAuxiliar(false);	
			disponiblescostos.setIsNewAuxiliar(false);	
			disponiblescostos.setIsChangedAuxiliar(false);
			
			disponiblescostos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDisponiblesCostoss(List<DisponiblesCostos> disponiblescostoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DisponiblesCostos disponiblescostos : disponiblescostoss) {
			if(conAsignarBase && disponiblescostos.getConCambioAuxiliar()) {
				disponiblescostos.setIsDeleted(disponiblescostos.getIsDeletedAuxiliar());	
				disponiblescostos.setIsNew(disponiblescostos.getIsNewAuxiliar());	
				disponiblescostos.setIsChanged(disponiblescostos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				disponiblescostos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				disponiblescostos.setIsDeletedAuxiliar(false);	
				disponiblescostos.setIsNewAuxiliar(false);	
				disponiblescostos.setIsChangedAuxiliar(false);
				
				disponiblescostos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDisponiblesCostos(DisponiblesCostos disponiblescostos,Boolean conEnteros) throws Exception  {
		disponiblescostos.setingresos(0.0);
		disponiblescostos.setegresos(0.0);
		disponiblescostos.setdisponible_corte(0.0);
		disponiblescostos.setcosto(0.0);
		disponiblescostos.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDisponiblesCostoss(List<DisponiblesCostos> disponiblescostoss,Boolean conEnteros) throws Exception  {
		
		for(DisponiblesCostos disponiblescostos: disponiblescostoss) {
			disponiblescostos.setingresos(0.0);
			disponiblescostos.setegresos(0.0);
			disponiblescostos.setdisponible_corte(0.0);
			disponiblescostos.setcosto(0.0);
			disponiblescostos.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDisponiblesCostos(List<DisponiblesCostos> disponiblescostoss,DisponiblesCostos disponiblescostosAux) throws Exception  {
		DisponiblesCostosConstantesFunciones.InicializarValoresDisponiblesCostos(disponiblescostosAux,true);
		
		for(DisponiblesCostos disponiblescostos: disponiblescostoss) {
			if(disponiblescostos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			disponiblescostosAux.setingresos(disponiblescostosAux.getingresos()+disponiblescostos.getingresos());			
			disponiblescostosAux.setegresos(disponiblescostosAux.getegresos()+disponiblescostos.getegresos());			
			disponiblescostosAux.setdisponible_corte(disponiblescostosAux.getdisponible_corte()+disponiblescostos.getdisponible_corte());			
			disponiblescostosAux.setcosto(disponiblescostosAux.getcosto()+disponiblescostos.getcosto());			
			disponiblescostosAux.settotal(disponiblescostosAux.gettotal()+disponiblescostos.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDisponiblesCostos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DisponiblesCostosConstantesFunciones.getArrayColumnasGlobalesDisponiblesCostos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDisponiblesCostos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DisponiblesCostosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DisponiblesCostosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DisponiblesCostosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DisponiblesCostosConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDisponiblesCostos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DisponiblesCostos> disponiblescostoss,DisponiblesCostos disponiblescostos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DisponiblesCostos disponiblescostosAux: disponiblescostoss) {
			if(disponiblescostosAux!=null && disponiblescostos!=null) {
				if((disponiblescostosAux.getId()==null && disponiblescostos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(disponiblescostosAux.getId()!=null && disponiblescostos.getId()!=null){
					if(disponiblescostosAux.getId().equals(disponiblescostos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDisponiblesCostos(List<DisponiblesCostos> disponiblescostoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double ingresosTotal=0.0;
		Double egresosTotal=0.0;
		Double disponible_corteTotal=0.0;
		Double costoTotal=0.0;
		Double totalTotal=0.0;
	
		for(DisponiblesCostos disponiblescostos: disponiblescostoss) {			
			if(disponiblescostos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ingresosTotal+=disponiblescostos.getingresos();
			egresosTotal+=disponiblescostos.getegresos();
			disponible_corteTotal+=disponiblescostos.getdisponible_corte();
			costoTotal+=disponiblescostos.getcosto();
			totalTotal+=disponiblescostos.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DisponiblesCostosConstantesFunciones.INGRESOS);
		datoGeneral.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_INGRESOS);
		datoGeneral.setdValorDouble(ingresosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DisponiblesCostosConstantesFunciones.EGRESOS);
		datoGeneral.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_EGRESOS);
		datoGeneral.setdValorDouble(egresosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DisponiblesCostosConstantesFunciones.DISPONIBLECORTE);
		datoGeneral.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_DISPONIBLECORTE);
		datoGeneral.setdValorDouble(disponible_corteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DisponiblesCostosConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DisponiblesCostosConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDisponiblesCostos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DisponiblesCostosConstantesFunciones.LABEL_ID, DisponiblesCostosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DisponiblesCostosConstantesFunciones.LABEL_VERSIONROW, DisponiblesCostosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DisponiblesCostosConstantesFunciones.LABEL_NOMBRESUCURSAL, DisponiblesCostosConstantesFunciones.NOMBRESUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DisponiblesCostosConstantesFunciones.LABEL_NOMBRELINEA, DisponiblesCostosConstantesFunciones.NOMBRELINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DisponiblesCostosConstantesFunciones.LABEL_NOMBRELINEAGRUPO, DisponiblesCostosConstantesFunciones.NOMBRELINEAGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DisponiblesCostosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA, DisponiblesCostosConstantesFunciones.NOMBRELINEACATEGORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DisponiblesCostosConstantesFunciones.LABEL_NOMBRELINEAMARCA, DisponiblesCostosConstantesFunciones.NOMBRELINEAMARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DisponiblesCostosConstantesFunciones.LABEL_CODIGO, DisponiblesCostosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DisponiblesCostosConstantesFunciones.LABEL_NOMBRE, DisponiblesCostosConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DisponiblesCostosConstantesFunciones.LABEL_NOMBREBODEGA, DisponiblesCostosConstantesFunciones.NOMBREBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DisponiblesCostosConstantesFunciones.LABEL_NOMBREUNIDAD, DisponiblesCostosConstantesFunciones.NOMBREUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DisponiblesCostosConstantesFunciones.LABEL_INGRESOS, DisponiblesCostosConstantesFunciones.INGRESOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DisponiblesCostosConstantesFunciones.LABEL_EGRESOS, DisponiblesCostosConstantesFunciones.EGRESOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DisponiblesCostosConstantesFunciones.LABEL_DISPONIBLECORTE, DisponiblesCostosConstantesFunciones.DISPONIBLECORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DisponiblesCostosConstantesFunciones.LABEL_COSTO, DisponiblesCostosConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DisponiblesCostosConstantesFunciones.LABEL_TOTAL, DisponiblesCostosConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDisponiblesCostos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DisponiblesCostosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DisponiblesCostosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DisponiblesCostosConstantesFunciones.NOMBRESUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DisponiblesCostosConstantesFunciones.NOMBRELINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DisponiblesCostosConstantesFunciones.NOMBRELINEAGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DisponiblesCostosConstantesFunciones.NOMBRELINEACATEGORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DisponiblesCostosConstantesFunciones.NOMBRELINEAMARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DisponiblesCostosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DisponiblesCostosConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DisponiblesCostosConstantesFunciones.NOMBREBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DisponiblesCostosConstantesFunciones.NOMBREUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DisponiblesCostosConstantesFunciones.INGRESOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DisponiblesCostosConstantesFunciones.EGRESOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DisponiblesCostosConstantesFunciones.DISPONIBLECORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DisponiblesCostosConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DisponiblesCostosConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDisponiblesCostos() throws Exception  {
		return DisponiblesCostosConstantesFunciones.getTiposSeleccionarDisponiblesCostos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDisponiblesCostos(Boolean conFk) throws Exception  {
		return DisponiblesCostosConstantesFunciones.getTiposSeleccionarDisponiblesCostos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDisponiblesCostos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_NOMBRESUCURSAL);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_NOMBRESUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_NOMBRELINEA);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_NOMBRELINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_NOMBRELINEAGRUPO);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_NOMBRELINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_NOMBRELINEAMARCA);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_NOMBRELINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_NOMBREBODEGA);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_NOMBREBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_NOMBREUNIDAD);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_NOMBREUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_INGRESOS);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_INGRESOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_EGRESOS);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_EGRESOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_DISPONIBLECORTE);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_DISPONIBLECORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DisponiblesCostosConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDisponiblesCostos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDisponiblesCostos(DisponiblesCostos disponiblescostosAux) throws Exception {
		
			disponiblescostosAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(disponiblescostosAux.getBodega()));
			disponiblescostosAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(disponiblescostosAux.getProducto()));
			disponiblescostosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(disponiblescostosAux.getEmpresa()));
			disponiblescostosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(disponiblescostosAux.getSucursal()));
			disponiblescostosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(disponiblescostosAux.getLinea()));
			disponiblescostosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(disponiblescostosAux.getLineaGrupo()));
			disponiblescostosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(disponiblescostosAux.getLineaCategoria()));
			disponiblescostosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(disponiblescostosAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDisponiblesCostos(List<DisponiblesCostos> disponiblescostossTemp) throws Exception {
		for(DisponiblesCostos disponiblescostosAux:disponiblescostossTemp) {
			
			disponiblescostosAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(disponiblescostosAux.getBodega()));
			disponiblescostosAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(disponiblescostosAux.getProducto()));
			disponiblescostosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(disponiblescostosAux.getEmpresa()));
			disponiblescostosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(disponiblescostosAux.getSucursal()));
			disponiblescostosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(disponiblescostosAux.getLinea()));
			disponiblescostosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(disponiblescostosAux.getLineaGrupo()));
			disponiblescostosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(disponiblescostosAux.getLineaCategoria()));
			disponiblescostosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(disponiblescostosAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDisponiblesCostos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
					}
				}

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
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDisponiblesCostos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDisponiblesCostos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DisponiblesCostosConstantesFunciones.getClassesRelationshipsOfDisponiblesCostos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDisponiblesCostos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDisponiblesCostos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DisponiblesCostosConstantesFunciones.getClassesRelationshipsFromStringsOfDisponiblesCostos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDisponiblesCostos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DisponiblesCostos disponiblescostos,List<DisponiblesCostos> disponiblescostoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(DisponiblesCostos disponiblescostos,List<DisponiblesCostos> disponiblescostoss) throws Exception {
		try	{			
			for(DisponiblesCostos disponiblescostosLocal:disponiblescostoss) {
				if(disponiblescostosLocal.getId().equals(disponiblescostos.getId())) {
					disponiblescostosLocal.setIsSelected(disponiblescostos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDisponiblesCostos(List<DisponiblesCostos> disponiblescostossAux) throws Exception {
		//this.disponiblescostossAux=disponiblescostossAux;
		
		for(DisponiblesCostos disponiblescostosAux:disponiblescostossAux) {
			if(disponiblescostosAux.getIsChanged()) {
				disponiblescostosAux.setIsChanged(false);
			}		
			
			if(disponiblescostosAux.getIsNew()) {
				disponiblescostosAux.setIsNew(false);
			}	
			
			if(disponiblescostosAux.getIsDeleted()) {
				disponiblescostosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDisponiblesCostos(DisponiblesCostos disponiblescostosAux) throws Exception {
		//this.disponiblescostosAux=disponiblescostosAux;
		
			if(disponiblescostosAux.getIsChanged()) {
				disponiblescostosAux.setIsChanged(false);
			}		
			
			if(disponiblescostosAux.getIsNew()) {
				disponiblescostosAux.setIsNew(false);
			}	
			
			if(disponiblescostosAux.getIsDeleted()) {
				disponiblescostosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DisponiblesCostos disponiblescostosAsignar,DisponiblesCostos disponiblescostos) throws Exception {
		disponiblescostosAsignar.setId(disponiblescostos.getId());	
		disponiblescostosAsignar.setVersionRow(disponiblescostos.getVersionRow());	
		disponiblescostosAsignar.setnombre_sucursal(disponiblescostos.getnombre_sucursal());	
		disponiblescostosAsignar.setnombre_linea(disponiblescostos.getnombre_linea());	
		disponiblescostosAsignar.setnombre_linea_grupo(disponiblescostos.getnombre_linea_grupo());	
		disponiblescostosAsignar.setnombre_linea_categoria(disponiblescostos.getnombre_linea_categoria());	
		disponiblescostosAsignar.setnombre_linea_marca(disponiblescostos.getnombre_linea_marca());	
		disponiblescostosAsignar.setcodigo(disponiblescostos.getcodigo());	
		disponiblescostosAsignar.setnombre(disponiblescostos.getnombre());	
		disponiblescostosAsignar.setnombre_bodega(disponiblescostos.getnombre_bodega());	
		disponiblescostosAsignar.setnombre_unidad(disponiblescostos.getnombre_unidad());	
		disponiblescostosAsignar.setingresos(disponiblescostos.getingresos());	
		disponiblescostosAsignar.setegresos(disponiblescostos.getegresos());	
		disponiblescostosAsignar.setdisponible_corte(disponiblescostos.getdisponible_corte());	
		disponiblescostosAsignar.setcosto(disponiblescostos.getcosto());	
		disponiblescostosAsignar.settotal(disponiblescostos.gettotal());	
	}
	
	public static void inicializarDisponiblesCostos(DisponiblesCostos disponiblescostos) throws Exception {
		try {
				disponiblescostos.setId(0L);	
					
				disponiblescostos.setnombre_sucursal("");	
				disponiblescostos.setnombre_linea("");	
				disponiblescostos.setnombre_linea_grupo("");	
				disponiblescostos.setnombre_linea_categoria("");	
				disponiblescostos.setnombre_linea_marca("");	
				disponiblescostos.setcodigo("");	
				disponiblescostos.setnombre("");	
				disponiblescostos.setnombre_bodega("");	
				disponiblescostos.setnombre_unidad("");	
				disponiblescostos.setingresos(0.0);	
				disponiblescostos.setegresos(0.0);	
				disponiblescostos.setdisponible_corte(0.0);	
				disponiblescostos.setcosto(0.0);	
				disponiblescostos.settotal(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDisponiblesCostos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_NOMBRESUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_NOMBRELINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_NOMBRELINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_NOMBRELINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_NOMBREBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_NOMBREUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_INGRESOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_EGRESOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_DISPONIBLECORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DisponiblesCostosConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDisponiblesCostos(String sTipo,Row row,Workbook workbook,DisponiblesCostos disponiblescostos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.getnombre_sucursal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.getnombre_linea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.getnombre_linea_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.getnombre_linea_categoria());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.getnombre_linea_marca());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.getnombre_bodega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.getnombre_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.getingresos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.getegresos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.getdisponible_corte());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(disponiblescostos.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDisponiblesCostos="";
	
	public String getsFinalQueryDisponiblesCostos() {
		return this.sFinalQueryDisponiblesCostos;
	}
	
	public void setsFinalQueryDisponiblesCostos(String sFinalQueryDisponiblesCostos) {
		this.sFinalQueryDisponiblesCostos= sFinalQueryDisponiblesCostos;
	}
	
	public Border resaltarSeleccionarDisponiblesCostos=null;
	
	public Border setResaltarSeleccionarDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDisponiblesCostos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDisponiblesCostos() {
		return this.resaltarSeleccionarDisponiblesCostos;
	}
	
	public void setResaltarSeleccionarDisponiblesCostos(Border borderResaltarSeleccionarDisponiblesCostos) {
		this.resaltarSeleccionarDisponiblesCostos= borderResaltarSeleccionarDisponiblesCostos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDisponiblesCostos=null;
	public Boolean mostraridDisponiblesCostos=true;
	public Boolean activaridDisponiblesCostos=true;

	public Border resaltarid_bodegaDisponiblesCostos=null;
	public Boolean mostrarid_bodegaDisponiblesCostos=true;
	public Boolean activarid_bodegaDisponiblesCostos=true;
	public Boolean cargarid_bodegaDisponiblesCostos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDisponiblesCostos=false;//ConEventDepend=true

	public Border resaltarid_productoDisponiblesCostos=null;
	public Boolean mostrarid_productoDisponiblesCostos=true;
	public Boolean activarid_productoDisponiblesCostos=true;
	public Boolean cargarid_productoDisponiblesCostos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDisponiblesCostos=false;//ConEventDepend=true

	public Border resaltarid_empresaDisponiblesCostos=null;
	public Boolean mostrarid_empresaDisponiblesCostos=true;
	public Boolean activarid_empresaDisponiblesCostos=true;
	public Boolean cargarid_empresaDisponiblesCostos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDisponiblesCostos=false;//ConEventDepend=true

	public Border resaltarid_sucursalDisponiblesCostos=null;
	public Boolean mostrarid_sucursalDisponiblesCostos=true;
	public Boolean activarid_sucursalDisponiblesCostos=true;
	public Boolean cargarid_sucursalDisponiblesCostos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDisponiblesCostos=false;//ConEventDepend=true

	public Border resaltarid_lineaDisponiblesCostos=null;
	public Boolean mostrarid_lineaDisponiblesCostos=true;
	public Boolean activarid_lineaDisponiblesCostos=true;
	public Boolean cargarid_lineaDisponiblesCostos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaDisponiblesCostos=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoDisponiblesCostos=null;
	public Boolean mostrarid_linea_grupoDisponiblesCostos=true;
	public Boolean activarid_linea_grupoDisponiblesCostos=true;
	public Boolean cargarid_linea_grupoDisponiblesCostos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoDisponiblesCostos=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaDisponiblesCostos=null;
	public Boolean mostrarid_linea_categoriaDisponiblesCostos=true;
	public Boolean activarid_linea_categoriaDisponiblesCostos=true;
	public Boolean cargarid_linea_categoriaDisponiblesCostos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaDisponiblesCostos=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaDisponiblesCostos=null;
	public Boolean mostrarid_linea_marcaDisponiblesCostos=true;
	public Boolean activarid_linea_marcaDisponiblesCostos=true;
	public Boolean cargarid_linea_marcaDisponiblesCostos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaDisponiblesCostos=false;//ConEventDepend=true

	public Border resaltarfecha_emision_hastaDisponiblesCostos=null;
	public Boolean mostrarfecha_emision_hastaDisponiblesCostos=true;
	public Boolean activarfecha_emision_hastaDisponiblesCostos=true;

	public Border resaltarnombre_sucursalDisponiblesCostos=null;
	public Boolean mostrarnombre_sucursalDisponiblesCostos=true;
	public Boolean activarnombre_sucursalDisponiblesCostos=true;

	public Border resaltarnombre_lineaDisponiblesCostos=null;
	public Boolean mostrarnombre_lineaDisponiblesCostos=true;
	public Boolean activarnombre_lineaDisponiblesCostos=true;

	public Border resaltarnombre_linea_grupoDisponiblesCostos=null;
	public Boolean mostrarnombre_linea_grupoDisponiblesCostos=true;
	public Boolean activarnombre_linea_grupoDisponiblesCostos=true;

	public Border resaltarnombre_linea_categoriaDisponiblesCostos=null;
	public Boolean mostrarnombre_linea_categoriaDisponiblesCostos=true;
	public Boolean activarnombre_linea_categoriaDisponiblesCostos=true;

	public Border resaltarnombre_linea_marcaDisponiblesCostos=null;
	public Boolean mostrarnombre_linea_marcaDisponiblesCostos=true;
	public Boolean activarnombre_linea_marcaDisponiblesCostos=true;

	public Border resaltarcodigoDisponiblesCostos=null;
	public Boolean mostrarcodigoDisponiblesCostos=true;
	public Boolean activarcodigoDisponiblesCostos=true;

	public Border resaltarnombreDisponiblesCostos=null;
	public Boolean mostrarnombreDisponiblesCostos=true;
	public Boolean activarnombreDisponiblesCostos=true;

	public Border resaltarnombre_bodegaDisponiblesCostos=null;
	public Boolean mostrarnombre_bodegaDisponiblesCostos=true;
	public Boolean activarnombre_bodegaDisponiblesCostos=true;

	public Border resaltarnombre_unidadDisponiblesCostos=null;
	public Boolean mostrarnombre_unidadDisponiblesCostos=true;
	public Boolean activarnombre_unidadDisponiblesCostos=true;

	public Border resaltaringresosDisponiblesCostos=null;
	public Boolean mostraringresosDisponiblesCostos=true;
	public Boolean activaringresosDisponiblesCostos=true;

	public Border resaltaregresosDisponiblesCostos=null;
	public Boolean mostraregresosDisponiblesCostos=true;
	public Boolean activaregresosDisponiblesCostos=true;

	public Border resaltardisponible_corteDisponiblesCostos=null;
	public Boolean mostrardisponible_corteDisponiblesCostos=true;
	public Boolean activardisponible_corteDisponiblesCostos=true;

	public Border resaltarcostoDisponiblesCostos=null;
	public Boolean mostrarcostoDisponiblesCostos=true;
	public Boolean activarcostoDisponiblesCostos=true;

	public Border resaltartotalDisponiblesCostos=null;
	public Boolean mostrartotalDisponiblesCostos=true;
	public Boolean activartotalDisponiblesCostos=true;

	
	

	public Border setResaltaridDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltaridDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDisponiblesCostos() {
		return this.resaltaridDisponiblesCostos;
	}

	public void setResaltaridDisponiblesCostos(Border borderResaltar) {
		this.resaltaridDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostraridDisponiblesCostos() {
		return this.mostraridDisponiblesCostos;
	}

	public void setMostraridDisponiblesCostos(Boolean mostraridDisponiblesCostos) {
		this.mostraridDisponiblesCostos= mostraridDisponiblesCostos;
	}

	public Boolean getActivaridDisponiblesCostos() {
		return this.activaridDisponiblesCostos;
	}

	public void setActivaridDisponiblesCostos(Boolean activaridDisponiblesCostos) {
		this.activaridDisponiblesCostos= activaridDisponiblesCostos;
	}

	public Border setResaltarid_bodegaDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDisponiblesCostos() {
		return this.resaltarid_bodegaDisponiblesCostos;
	}

	public void setResaltarid_bodegaDisponiblesCostos(Border borderResaltar) {
		this.resaltarid_bodegaDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDisponiblesCostos() {
		return this.mostrarid_bodegaDisponiblesCostos;
	}

	public void setMostrarid_bodegaDisponiblesCostos(Boolean mostrarid_bodegaDisponiblesCostos) {
		this.mostrarid_bodegaDisponiblesCostos= mostrarid_bodegaDisponiblesCostos;
	}

	public Boolean getActivarid_bodegaDisponiblesCostos() {
		return this.activarid_bodegaDisponiblesCostos;
	}

	public void setActivarid_bodegaDisponiblesCostos(Boolean activarid_bodegaDisponiblesCostos) {
		this.activarid_bodegaDisponiblesCostos= activarid_bodegaDisponiblesCostos;
	}

	public Boolean getCargarid_bodegaDisponiblesCostos() {
		return this.cargarid_bodegaDisponiblesCostos;
	}

	public void setCargarid_bodegaDisponiblesCostos(Boolean cargarid_bodegaDisponiblesCostos) {
		this.cargarid_bodegaDisponiblesCostos= cargarid_bodegaDisponiblesCostos;
	}

	public Border setResaltarid_productoDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltarid_productoDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDisponiblesCostos() {
		return this.resaltarid_productoDisponiblesCostos;
	}

	public void setResaltarid_productoDisponiblesCostos(Border borderResaltar) {
		this.resaltarid_productoDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostrarid_productoDisponiblesCostos() {
		return this.mostrarid_productoDisponiblesCostos;
	}

	public void setMostrarid_productoDisponiblesCostos(Boolean mostrarid_productoDisponiblesCostos) {
		this.mostrarid_productoDisponiblesCostos= mostrarid_productoDisponiblesCostos;
	}

	public Boolean getActivarid_productoDisponiblesCostos() {
		return this.activarid_productoDisponiblesCostos;
	}

	public void setActivarid_productoDisponiblesCostos(Boolean activarid_productoDisponiblesCostos) {
		this.activarid_productoDisponiblesCostos= activarid_productoDisponiblesCostos;
	}

	public Boolean getCargarid_productoDisponiblesCostos() {
		return this.cargarid_productoDisponiblesCostos;
	}

	public void setCargarid_productoDisponiblesCostos(Boolean cargarid_productoDisponiblesCostos) {
		this.cargarid_productoDisponiblesCostos= cargarid_productoDisponiblesCostos;
	}

	public Border setResaltarid_empresaDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltarid_empresaDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDisponiblesCostos() {
		return this.resaltarid_empresaDisponiblesCostos;
	}

	public void setResaltarid_empresaDisponiblesCostos(Border borderResaltar) {
		this.resaltarid_empresaDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostrarid_empresaDisponiblesCostos() {
		return this.mostrarid_empresaDisponiblesCostos;
	}

	public void setMostrarid_empresaDisponiblesCostos(Boolean mostrarid_empresaDisponiblesCostos) {
		this.mostrarid_empresaDisponiblesCostos= mostrarid_empresaDisponiblesCostos;
	}

	public Boolean getActivarid_empresaDisponiblesCostos() {
		return this.activarid_empresaDisponiblesCostos;
	}

	public void setActivarid_empresaDisponiblesCostos(Boolean activarid_empresaDisponiblesCostos) {
		this.activarid_empresaDisponiblesCostos= activarid_empresaDisponiblesCostos;
	}

	public Boolean getCargarid_empresaDisponiblesCostos() {
		return this.cargarid_empresaDisponiblesCostos;
	}

	public void setCargarid_empresaDisponiblesCostos(Boolean cargarid_empresaDisponiblesCostos) {
		this.cargarid_empresaDisponiblesCostos= cargarid_empresaDisponiblesCostos;
	}

	public Border setResaltarid_sucursalDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDisponiblesCostos() {
		return this.resaltarid_sucursalDisponiblesCostos;
	}

	public void setResaltarid_sucursalDisponiblesCostos(Border borderResaltar) {
		this.resaltarid_sucursalDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDisponiblesCostos() {
		return this.mostrarid_sucursalDisponiblesCostos;
	}

	public void setMostrarid_sucursalDisponiblesCostos(Boolean mostrarid_sucursalDisponiblesCostos) {
		this.mostrarid_sucursalDisponiblesCostos= mostrarid_sucursalDisponiblesCostos;
	}

	public Boolean getActivarid_sucursalDisponiblesCostos() {
		return this.activarid_sucursalDisponiblesCostos;
	}

	public void setActivarid_sucursalDisponiblesCostos(Boolean activarid_sucursalDisponiblesCostos) {
		this.activarid_sucursalDisponiblesCostos= activarid_sucursalDisponiblesCostos;
	}

	public Boolean getCargarid_sucursalDisponiblesCostos() {
		return this.cargarid_sucursalDisponiblesCostos;
	}

	public void setCargarid_sucursalDisponiblesCostos(Boolean cargarid_sucursalDisponiblesCostos) {
		this.cargarid_sucursalDisponiblesCostos= cargarid_sucursalDisponiblesCostos;
	}

	public Border setResaltarid_lineaDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltarid_lineaDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaDisponiblesCostos() {
		return this.resaltarid_lineaDisponiblesCostos;
	}

	public void setResaltarid_lineaDisponiblesCostos(Border borderResaltar) {
		this.resaltarid_lineaDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostrarid_lineaDisponiblesCostos() {
		return this.mostrarid_lineaDisponiblesCostos;
	}

	public void setMostrarid_lineaDisponiblesCostos(Boolean mostrarid_lineaDisponiblesCostos) {
		this.mostrarid_lineaDisponiblesCostos= mostrarid_lineaDisponiblesCostos;
	}

	public Boolean getActivarid_lineaDisponiblesCostos() {
		return this.activarid_lineaDisponiblesCostos;
	}

	public void setActivarid_lineaDisponiblesCostos(Boolean activarid_lineaDisponiblesCostos) {
		this.activarid_lineaDisponiblesCostos= activarid_lineaDisponiblesCostos;
	}

	public Boolean getCargarid_lineaDisponiblesCostos() {
		return this.cargarid_lineaDisponiblesCostos;
	}

	public void setCargarid_lineaDisponiblesCostos(Boolean cargarid_lineaDisponiblesCostos) {
		this.cargarid_lineaDisponiblesCostos= cargarid_lineaDisponiblesCostos;
	}

	public Border setResaltarid_linea_grupoDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoDisponiblesCostos() {
		return this.resaltarid_linea_grupoDisponiblesCostos;
	}

	public void setResaltarid_linea_grupoDisponiblesCostos(Border borderResaltar) {
		this.resaltarid_linea_grupoDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoDisponiblesCostos() {
		return this.mostrarid_linea_grupoDisponiblesCostos;
	}

	public void setMostrarid_linea_grupoDisponiblesCostos(Boolean mostrarid_linea_grupoDisponiblesCostos) {
		this.mostrarid_linea_grupoDisponiblesCostos= mostrarid_linea_grupoDisponiblesCostos;
	}

	public Boolean getActivarid_linea_grupoDisponiblesCostos() {
		return this.activarid_linea_grupoDisponiblesCostos;
	}

	public void setActivarid_linea_grupoDisponiblesCostos(Boolean activarid_linea_grupoDisponiblesCostos) {
		this.activarid_linea_grupoDisponiblesCostos= activarid_linea_grupoDisponiblesCostos;
	}

	public Boolean getCargarid_linea_grupoDisponiblesCostos() {
		return this.cargarid_linea_grupoDisponiblesCostos;
	}

	public void setCargarid_linea_grupoDisponiblesCostos(Boolean cargarid_linea_grupoDisponiblesCostos) {
		this.cargarid_linea_grupoDisponiblesCostos= cargarid_linea_grupoDisponiblesCostos;
	}

	public Border setResaltarid_linea_categoriaDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaDisponiblesCostos() {
		return this.resaltarid_linea_categoriaDisponiblesCostos;
	}

	public void setResaltarid_linea_categoriaDisponiblesCostos(Border borderResaltar) {
		this.resaltarid_linea_categoriaDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaDisponiblesCostos() {
		return this.mostrarid_linea_categoriaDisponiblesCostos;
	}

	public void setMostrarid_linea_categoriaDisponiblesCostos(Boolean mostrarid_linea_categoriaDisponiblesCostos) {
		this.mostrarid_linea_categoriaDisponiblesCostos= mostrarid_linea_categoriaDisponiblesCostos;
	}

	public Boolean getActivarid_linea_categoriaDisponiblesCostos() {
		return this.activarid_linea_categoriaDisponiblesCostos;
	}

	public void setActivarid_linea_categoriaDisponiblesCostos(Boolean activarid_linea_categoriaDisponiblesCostos) {
		this.activarid_linea_categoriaDisponiblesCostos= activarid_linea_categoriaDisponiblesCostos;
	}

	public Boolean getCargarid_linea_categoriaDisponiblesCostos() {
		return this.cargarid_linea_categoriaDisponiblesCostos;
	}

	public void setCargarid_linea_categoriaDisponiblesCostos(Boolean cargarid_linea_categoriaDisponiblesCostos) {
		this.cargarid_linea_categoriaDisponiblesCostos= cargarid_linea_categoriaDisponiblesCostos;
	}

	public Border setResaltarid_linea_marcaDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaDisponiblesCostos() {
		return this.resaltarid_linea_marcaDisponiblesCostos;
	}

	public void setResaltarid_linea_marcaDisponiblesCostos(Border borderResaltar) {
		this.resaltarid_linea_marcaDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaDisponiblesCostos() {
		return this.mostrarid_linea_marcaDisponiblesCostos;
	}

	public void setMostrarid_linea_marcaDisponiblesCostos(Boolean mostrarid_linea_marcaDisponiblesCostos) {
		this.mostrarid_linea_marcaDisponiblesCostos= mostrarid_linea_marcaDisponiblesCostos;
	}

	public Boolean getActivarid_linea_marcaDisponiblesCostos() {
		return this.activarid_linea_marcaDisponiblesCostos;
	}

	public void setActivarid_linea_marcaDisponiblesCostos(Boolean activarid_linea_marcaDisponiblesCostos) {
		this.activarid_linea_marcaDisponiblesCostos= activarid_linea_marcaDisponiblesCostos;
	}

	public Boolean getCargarid_linea_marcaDisponiblesCostos() {
		return this.cargarid_linea_marcaDisponiblesCostos;
	}

	public void setCargarid_linea_marcaDisponiblesCostos(Boolean cargarid_linea_marcaDisponiblesCostos) {
		this.cargarid_linea_marcaDisponiblesCostos= cargarid_linea_marcaDisponiblesCostos;
	}

	public Border setResaltarfecha_emision_hastaDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaDisponiblesCostos() {
		return this.resaltarfecha_emision_hastaDisponiblesCostos;
	}

	public void setResaltarfecha_emision_hastaDisponiblesCostos(Border borderResaltar) {
		this.resaltarfecha_emision_hastaDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaDisponiblesCostos() {
		return this.mostrarfecha_emision_hastaDisponiblesCostos;
	}

	public void setMostrarfecha_emision_hastaDisponiblesCostos(Boolean mostrarfecha_emision_hastaDisponiblesCostos) {
		this.mostrarfecha_emision_hastaDisponiblesCostos= mostrarfecha_emision_hastaDisponiblesCostos;
	}

	public Boolean getActivarfecha_emision_hastaDisponiblesCostos() {
		return this.activarfecha_emision_hastaDisponiblesCostos;
	}

	public void setActivarfecha_emision_hastaDisponiblesCostos(Boolean activarfecha_emision_hastaDisponiblesCostos) {
		this.activarfecha_emision_hastaDisponiblesCostos= activarfecha_emision_hastaDisponiblesCostos;
	}

	public Border setResaltarnombre_sucursalDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltarnombre_sucursalDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sucursalDisponiblesCostos() {
		return this.resaltarnombre_sucursalDisponiblesCostos;
	}

	public void setResaltarnombre_sucursalDisponiblesCostos(Border borderResaltar) {
		this.resaltarnombre_sucursalDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostrarnombre_sucursalDisponiblesCostos() {
		return this.mostrarnombre_sucursalDisponiblesCostos;
	}

	public void setMostrarnombre_sucursalDisponiblesCostos(Boolean mostrarnombre_sucursalDisponiblesCostos) {
		this.mostrarnombre_sucursalDisponiblesCostos= mostrarnombre_sucursalDisponiblesCostos;
	}

	public Boolean getActivarnombre_sucursalDisponiblesCostos() {
		return this.activarnombre_sucursalDisponiblesCostos;
	}

	public void setActivarnombre_sucursalDisponiblesCostos(Boolean activarnombre_sucursalDisponiblesCostos) {
		this.activarnombre_sucursalDisponiblesCostos= activarnombre_sucursalDisponiblesCostos;
	}

	public Border setResaltarnombre_lineaDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltarnombre_lineaDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_lineaDisponiblesCostos() {
		return this.resaltarnombre_lineaDisponiblesCostos;
	}

	public void setResaltarnombre_lineaDisponiblesCostos(Border borderResaltar) {
		this.resaltarnombre_lineaDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostrarnombre_lineaDisponiblesCostos() {
		return this.mostrarnombre_lineaDisponiblesCostos;
	}

	public void setMostrarnombre_lineaDisponiblesCostos(Boolean mostrarnombre_lineaDisponiblesCostos) {
		this.mostrarnombre_lineaDisponiblesCostos= mostrarnombre_lineaDisponiblesCostos;
	}

	public Boolean getActivarnombre_lineaDisponiblesCostos() {
		return this.activarnombre_lineaDisponiblesCostos;
	}

	public void setActivarnombre_lineaDisponiblesCostos(Boolean activarnombre_lineaDisponiblesCostos) {
		this.activarnombre_lineaDisponiblesCostos= activarnombre_lineaDisponiblesCostos;
	}

	public Border setResaltarnombre_linea_grupoDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_grupoDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_grupoDisponiblesCostos() {
		return this.resaltarnombre_linea_grupoDisponiblesCostos;
	}

	public void setResaltarnombre_linea_grupoDisponiblesCostos(Border borderResaltar) {
		this.resaltarnombre_linea_grupoDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_grupoDisponiblesCostos() {
		return this.mostrarnombre_linea_grupoDisponiblesCostos;
	}

	public void setMostrarnombre_linea_grupoDisponiblesCostos(Boolean mostrarnombre_linea_grupoDisponiblesCostos) {
		this.mostrarnombre_linea_grupoDisponiblesCostos= mostrarnombre_linea_grupoDisponiblesCostos;
	}

	public Boolean getActivarnombre_linea_grupoDisponiblesCostos() {
		return this.activarnombre_linea_grupoDisponiblesCostos;
	}

	public void setActivarnombre_linea_grupoDisponiblesCostos(Boolean activarnombre_linea_grupoDisponiblesCostos) {
		this.activarnombre_linea_grupoDisponiblesCostos= activarnombre_linea_grupoDisponiblesCostos;
	}

	public Border setResaltarnombre_linea_categoriaDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_categoriaDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_categoriaDisponiblesCostos() {
		return this.resaltarnombre_linea_categoriaDisponiblesCostos;
	}

	public void setResaltarnombre_linea_categoriaDisponiblesCostos(Border borderResaltar) {
		this.resaltarnombre_linea_categoriaDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_categoriaDisponiblesCostos() {
		return this.mostrarnombre_linea_categoriaDisponiblesCostos;
	}

	public void setMostrarnombre_linea_categoriaDisponiblesCostos(Boolean mostrarnombre_linea_categoriaDisponiblesCostos) {
		this.mostrarnombre_linea_categoriaDisponiblesCostos= mostrarnombre_linea_categoriaDisponiblesCostos;
	}

	public Boolean getActivarnombre_linea_categoriaDisponiblesCostos() {
		return this.activarnombre_linea_categoriaDisponiblesCostos;
	}

	public void setActivarnombre_linea_categoriaDisponiblesCostos(Boolean activarnombre_linea_categoriaDisponiblesCostos) {
		this.activarnombre_linea_categoriaDisponiblesCostos= activarnombre_linea_categoriaDisponiblesCostos;
	}

	public Border setResaltarnombre_linea_marcaDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_marcaDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_marcaDisponiblesCostos() {
		return this.resaltarnombre_linea_marcaDisponiblesCostos;
	}

	public void setResaltarnombre_linea_marcaDisponiblesCostos(Border borderResaltar) {
		this.resaltarnombre_linea_marcaDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_marcaDisponiblesCostos() {
		return this.mostrarnombre_linea_marcaDisponiblesCostos;
	}

	public void setMostrarnombre_linea_marcaDisponiblesCostos(Boolean mostrarnombre_linea_marcaDisponiblesCostos) {
		this.mostrarnombre_linea_marcaDisponiblesCostos= mostrarnombre_linea_marcaDisponiblesCostos;
	}

	public Boolean getActivarnombre_linea_marcaDisponiblesCostos() {
		return this.activarnombre_linea_marcaDisponiblesCostos;
	}

	public void setActivarnombre_linea_marcaDisponiblesCostos(Boolean activarnombre_linea_marcaDisponiblesCostos) {
		this.activarnombre_linea_marcaDisponiblesCostos= activarnombre_linea_marcaDisponiblesCostos;
	}

	public Border setResaltarcodigoDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltarcodigoDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoDisponiblesCostos() {
		return this.resaltarcodigoDisponiblesCostos;
	}

	public void setResaltarcodigoDisponiblesCostos(Border borderResaltar) {
		this.resaltarcodigoDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostrarcodigoDisponiblesCostos() {
		return this.mostrarcodigoDisponiblesCostos;
	}

	public void setMostrarcodigoDisponiblesCostos(Boolean mostrarcodigoDisponiblesCostos) {
		this.mostrarcodigoDisponiblesCostos= mostrarcodigoDisponiblesCostos;
	}

	public Boolean getActivarcodigoDisponiblesCostos() {
		return this.activarcodigoDisponiblesCostos;
	}

	public void setActivarcodigoDisponiblesCostos(Boolean activarcodigoDisponiblesCostos) {
		this.activarcodigoDisponiblesCostos= activarcodigoDisponiblesCostos;
	}

	public Border setResaltarnombreDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltarnombreDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreDisponiblesCostos() {
		return this.resaltarnombreDisponiblesCostos;
	}

	public void setResaltarnombreDisponiblesCostos(Border borderResaltar) {
		this.resaltarnombreDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostrarnombreDisponiblesCostos() {
		return this.mostrarnombreDisponiblesCostos;
	}

	public void setMostrarnombreDisponiblesCostos(Boolean mostrarnombreDisponiblesCostos) {
		this.mostrarnombreDisponiblesCostos= mostrarnombreDisponiblesCostos;
	}

	public Boolean getActivarnombreDisponiblesCostos() {
		return this.activarnombreDisponiblesCostos;
	}

	public void setActivarnombreDisponiblesCostos(Boolean activarnombreDisponiblesCostos) {
		this.activarnombreDisponiblesCostos= activarnombreDisponiblesCostos;
	}

	public Border setResaltarnombre_bodegaDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltarnombre_bodegaDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bodegaDisponiblesCostos() {
		return this.resaltarnombre_bodegaDisponiblesCostos;
	}

	public void setResaltarnombre_bodegaDisponiblesCostos(Border borderResaltar) {
		this.resaltarnombre_bodegaDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostrarnombre_bodegaDisponiblesCostos() {
		return this.mostrarnombre_bodegaDisponiblesCostos;
	}

	public void setMostrarnombre_bodegaDisponiblesCostos(Boolean mostrarnombre_bodegaDisponiblesCostos) {
		this.mostrarnombre_bodegaDisponiblesCostos= mostrarnombre_bodegaDisponiblesCostos;
	}

	public Boolean getActivarnombre_bodegaDisponiblesCostos() {
		return this.activarnombre_bodegaDisponiblesCostos;
	}

	public void setActivarnombre_bodegaDisponiblesCostos(Boolean activarnombre_bodegaDisponiblesCostos) {
		this.activarnombre_bodegaDisponiblesCostos= activarnombre_bodegaDisponiblesCostos;
	}

	public Border setResaltarnombre_unidadDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltarnombre_unidadDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_unidadDisponiblesCostos() {
		return this.resaltarnombre_unidadDisponiblesCostos;
	}

	public void setResaltarnombre_unidadDisponiblesCostos(Border borderResaltar) {
		this.resaltarnombre_unidadDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostrarnombre_unidadDisponiblesCostos() {
		return this.mostrarnombre_unidadDisponiblesCostos;
	}

	public void setMostrarnombre_unidadDisponiblesCostos(Boolean mostrarnombre_unidadDisponiblesCostos) {
		this.mostrarnombre_unidadDisponiblesCostos= mostrarnombre_unidadDisponiblesCostos;
	}

	public Boolean getActivarnombre_unidadDisponiblesCostos() {
		return this.activarnombre_unidadDisponiblesCostos;
	}

	public void setActivarnombre_unidadDisponiblesCostos(Boolean activarnombre_unidadDisponiblesCostos) {
		this.activarnombre_unidadDisponiblesCostos= activarnombre_unidadDisponiblesCostos;
	}

	public Border setResaltaringresosDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltaringresosDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaringresosDisponiblesCostos() {
		return this.resaltaringresosDisponiblesCostos;
	}

	public void setResaltaringresosDisponiblesCostos(Border borderResaltar) {
		this.resaltaringresosDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostraringresosDisponiblesCostos() {
		return this.mostraringresosDisponiblesCostos;
	}

	public void setMostraringresosDisponiblesCostos(Boolean mostraringresosDisponiblesCostos) {
		this.mostraringresosDisponiblesCostos= mostraringresosDisponiblesCostos;
	}

	public Boolean getActivaringresosDisponiblesCostos() {
		return this.activaringresosDisponiblesCostos;
	}

	public void setActivaringresosDisponiblesCostos(Boolean activaringresosDisponiblesCostos) {
		this.activaringresosDisponiblesCostos= activaringresosDisponiblesCostos;
	}

	public Border setResaltaregresosDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltaregresosDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaregresosDisponiblesCostos() {
		return this.resaltaregresosDisponiblesCostos;
	}

	public void setResaltaregresosDisponiblesCostos(Border borderResaltar) {
		this.resaltaregresosDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostraregresosDisponiblesCostos() {
		return this.mostraregresosDisponiblesCostos;
	}

	public void setMostraregresosDisponiblesCostos(Boolean mostraregresosDisponiblesCostos) {
		this.mostraregresosDisponiblesCostos= mostraregresosDisponiblesCostos;
	}

	public Boolean getActivaregresosDisponiblesCostos() {
		return this.activaregresosDisponiblesCostos;
	}

	public void setActivaregresosDisponiblesCostos(Boolean activaregresosDisponiblesCostos) {
		this.activaregresosDisponiblesCostos= activaregresosDisponiblesCostos;
	}

	public Border setResaltardisponible_corteDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltardisponible_corteDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardisponible_corteDisponiblesCostos() {
		return this.resaltardisponible_corteDisponiblesCostos;
	}

	public void setResaltardisponible_corteDisponiblesCostos(Border borderResaltar) {
		this.resaltardisponible_corteDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostrardisponible_corteDisponiblesCostos() {
		return this.mostrardisponible_corteDisponiblesCostos;
	}

	public void setMostrardisponible_corteDisponiblesCostos(Boolean mostrardisponible_corteDisponiblesCostos) {
		this.mostrardisponible_corteDisponiblesCostos= mostrardisponible_corteDisponiblesCostos;
	}

	public Boolean getActivardisponible_corteDisponiblesCostos() {
		return this.activardisponible_corteDisponiblesCostos;
	}

	public void setActivardisponible_corteDisponiblesCostos(Boolean activardisponible_corteDisponiblesCostos) {
		this.activardisponible_corteDisponiblesCostos= activardisponible_corteDisponiblesCostos;
	}

	public Border setResaltarcostoDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltarcostoDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoDisponiblesCostos() {
		return this.resaltarcostoDisponiblesCostos;
	}

	public void setResaltarcostoDisponiblesCostos(Border borderResaltar) {
		this.resaltarcostoDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostrarcostoDisponiblesCostos() {
		return this.mostrarcostoDisponiblesCostos;
	}

	public void setMostrarcostoDisponiblesCostos(Boolean mostrarcostoDisponiblesCostos) {
		this.mostrarcostoDisponiblesCostos= mostrarcostoDisponiblesCostos;
	}

	public Boolean getActivarcostoDisponiblesCostos() {
		return this.activarcostoDisponiblesCostos;
	}

	public void setActivarcostoDisponiblesCostos(Boolean activarcostoDisponiblesCostos) {
		this.activarcostoDisponiblesCostos= activarcostoDisponiblesCostos;
	}

	public Border setResaltartotalDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//disponiblescostosBeanSwingJInternalFrame.jTtoolBarDisponiblesCostos.setBorder(borderResaltar);
		
		this.resaltartotalDisponiblesCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalDisponiblesCostos() {
		return this.resaltartotalDisponiblesCostos;
	}

	public void setResaltartotalDisponiblesCostos(Border borderResaltar) {
		this.resaltartotalDisponiblesCostos= borderResaltar;
	}

	public Boolean getMostrartotalDisponiblesCostos() {
		return this.mostrartotalDisponiblesCostos;
	}

	public void setMostrartotalDisponiblesCostos(Boolean mostrartotalDisponiblesCostos) {
		this.mostrartotalDisponiblesCostos= mostrartotalDisponiblesCostos;
	}

	public Boolean getActivartotalDisponiblesCostos() {
		return this.activartotalDisponiblesCostos;
	}

	public void setActivartotalDisponiblesCostos(Boolean activartotalDisponiblesCostos) {
		this.activartotalDisponiblesCostos= activartotalDisponiblesCostos;
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
		
		
		this.setMostraridDisponiblesCostos(esInicial);
		this.setMostrarid_bodegaDisponiblesCostos(esInicial);
		this.setMostrarid_productoDisponiblesCostos(esInicial);
		this.setMostrarid_empresaDisponiblesCostos(esInicial);
		this.setMostrarid_sucursalDisponiblesCostos(esInicial);
		this.setMostrarid_lineaDisponiblesCostos(esInicial);
		this.setMostrarid_linea_grupoDisponiblesCostos(esInicial);
		this.setMostrarid_linea_categoriaDisponiblesCostos(esInicial);
		this.setMostrarid_linea_marcaDisponiblesCostos(esInicial);
		this.setMostrarfecha_emision_hastaDisponiblesCostos(esInicial);
		this.setMostrarnombre_sucursalDisponiblesCostos(esInicial);
		this.setMostrarnombre_lineaDisponiblesCostos(esInicial);
		this.setMostrarnombre_linea_grupoDisponiblesCostos(esInicial);
		this.setMostrarnombre_linea_categoriaDisponiblesCostos(esInicial);
		this.setMostrarnombre_linea_marcaDisponiblesCostos(esInicial);
		this.setMostrarcodigoDisponiblesCostos(esInicial);
		this.setMostrarnombreDisponiblesCostos(esInicial);
		this.setMostrarnombre_bodegaDisponiblesCostos(esInicial);
		this.setMostrarnombre_unidadDisponiblesCostos(esInicial);
		this.setMostraringresosDisponiblesCostos(esInicial);
		this.setMostraregresosDisponiblesCostos(esInicial);
		this.setMostrardisponible_corteDisponiblesCostos(esInicial);
		this.setMostrarcostoDisponiblesCostos(esInicial);
		this.setMostrartotalDisponiblesCostos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.ID)) {
				this.setMostraridDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setMostrarnombre_sucursalDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBRELINEA)) {
				this.setMostrarnombre_lineaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setMostrarnombre_linea_grupoDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setMostrarnombre_linea_categoriaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setMostrarnombre_linea_marcaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBREBODEGA)) {
				this.setMostrarnombre_bodegaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBREUNIDAD)) {
				this.setMostrarnombre_unidadDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.INGRESOS)) {
				this.setMostraringresosDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.EGRESOS)) {
				this.setMostraregresosDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.DISPONIBLECORTE)) {
				this.setMostrardisponible_corteDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.COSTO)) {
				this.setMostrarcostoDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.TOTAL)) {
				this.setMostrartotalDisponiblesCostos(esAsigna);
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
		
		
		this.setActivaridDisponiblesCostos(esInicial);
		this.setActivarid_bodegaDisponiblesCostos(esInicial);
		this.setActivarid_productoDisponiblesCostos(esInicial);
		this.setActivarid_empresaDisponiblesCostos(esInicial);
		this.setActivarid_sucursalDisponiblesCostos(esInicial);
		this.setActivarid_lineaDisponiblesCostos(esInicial);
		this.setActivarid_linea_grupoDisponiblesCostos(esInicial);
		this.setActivarid_linea_categoriaDisponiblesCostos(esInicial);
		this.setActivarid_linea_marcaDisponiblesCostos(esInicial);
		this.setActivarfecha_emision_hastaDisponiblesCostos(esInicial);
		this.setActivarnombre_sucursalDisponiblesCostos(esInicial);
		this.setActivarnombre_lineaDisponiblesCostos(esInicial);
		this.setActivarnombre_linea_grupoDisponiblesCostos(esInicial);
		this.setActivarnombre_linea_categoriaDisponiblesCostos(esInicial);
		this.setActivarnombre_linea_marcaDisponiblesCostos(esInicial);
		this.setActivarcodigoDisponiblesCostos(esInicial);
		this.setActivarnombreDisponiblesCostos(esInicial);
		this.setActivarnombre_bodegaDisponiblesCostos(esInicial);
		this.setActivarnombre_unidadDisponiblesCostos(esInicial);
		this.setActivaringresosDisponiblesCostos(esInicial);
		this.setActivaregresosDisponiblesCostos(esInicial);
		this.setActivardisponible_corteDisponiblesCostos(esInicial);
		this.setActivarcostoDisponiblesCostos(esInicial);
		this.setActivartotalDisponiblesCostos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.ID)) {
				this.setActivaridDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setActivarnombre_sucursalDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBRELINEA)) {
				this.setActivarnombre_lineaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setActivarnombre_linea_grupoDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setActivarnombre_linea_categoriaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setActivarnombre_linea_marcaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBRE)) {
				this.setActivarnombreDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBREBODEGA)) {
				this.setActivarnombre_bodegaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBREUNIDAD)) {
				this.setActivarnombre_unidadDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.INGRESOS)) {
				this.setActivaringresosDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.EGRESOS)) {
				this.setActivaregresosDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.DISPONIBLECORTE)) {
				this.setActivardisponible_corteDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.COSTO)) {
				this.setActivarcostoDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.TOTAL)) {
				this.setActivartotalDisponiblesCostos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDisponiblesCostos(esInicial);
		this.setResaltarid_bodegaDisponiblesCostos(esInicial);
		this.setResaltarid_productoDisponiblesCostos(esInicial);
		this.setResaltarid_empresaDisponiblesCostos(esInicial);
		this.setResaltarid_sucursalDisponiblesCostos(esInicial);
		this.setResaltarid_lineaDisponiblesCostos(esInicial);
		this.setResaltarid_linea_grupoDisponiblesCostos(esInicial);
		this.setResaltarid_linea_categoriaDisponiblesCostos(esInicial);
		this.setResaltarid_linea_marcaDisponiblesCostos(esInicial);
		this.setResaltarfecha_emision_hastaDisponiblesCostos(esInicial);
		this.setResaltarnombre_sucursalDisponiblesCostos(esInicial);
		this.setResaltarnombre_lineaDisponiblesCostos(esInicial);
		this.setResaltarnombre_linea_grupoDisponiblesCostos(esInicial);
		this.setResaltarnombre_linea_categoriaDisponiblesCostos(esInicial);
		this.setResaltarnombre_linea_marcaDisponiblesCostos(esInicial);
		this.setResaltarcodigoDisponiblesCostos(esInicial);
		this.setResaltarnombreDisponiblesCostos(esInicial);
		this.setResaltarnombre_bodegaDisponiblesCostos(esInicial);
		this.setResaltarnombre_unidadDisponiblesCostos(esInicial);
		this.setResaltaringresosDisponiblesCostos(esInicial);
		this.setResaltaregresosDisponiblesCostos(esInicial);
		this.setResaltardisponible_corteDisponiblesCostos(esInicial);
		this.setResaltarcostoDisponiblesCostos(esInicial);
		this.setResaltartotalDisponiblesCostos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.ID)) {
				this.setResaltaridDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setResaltarnombre_sucursalDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBRELINEA)) {
				this.setResaltarnombre_lineaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setResaltarnombre_linea_grupoDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setResaltarnombre_linea_categoriaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setResaltarnombre_linea_marcaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBREBODEGA)) {
				this.setResaltarnombre_bodegaDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.NOMBREUNIDAD)) {
				this.setResaltarnombre_unidadDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.INGRESOS)) {
				this.setResaltaringresosDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.EGRESOS)) {
				this.setResaltaregresosDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.DISPONIBLECORTE)) {
				this.setResaltardisponible_corteDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.COSTO)) {
				this.setResaltarcostoDisponiblesCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DisponiblesCostosConstantesFunciones.TOTAL)) {
				this.setResaltartotalDisponiblesCostos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaDisponiblesCostosDisponiblesCostos=true;

	public Boolean getMostrarBusquedaDisponiblesCostosDisponiblesCostos() {
		return this.mostrarBusquedaDisponiblesCostosDisponiblesCostos;
	}

	public void setMostrarBusquedaDisponiblesCostosDisponiblesCostos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaDisponiblesCostosDisponiblesCostos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaDisponiblesCostosDisponiblesCostos=true;

	public Boolean getActivarBusquedaDisponiblesCostosDisponiblesCostos() {
		return this.activarBusquedaDisponiblesCostosDisponiblesCostos;
	}

	public void setActivarBusquedaDisponiblesCostosDisponiblesCostos(Boolean habilitarResaltar) {
		this.activarBusquedaDisponiblesCostosDisponiblesCostos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaDisponiblesCostosDisponiblesCostos=null;

	public Border getResaltarBusquedaDisponiblesCostosDisponiblesCostos() {
		return this.resaltarBusquedaDisponiblesCostosDisponiblesCostos;
	}

	public void setResaltarBusquedaDisponiblesCostosDisponiblesCostos(Border borderResaltar) {
		this.resaltarBusquedaDisponiblesCostosDisponiblesCostos= borderResaltar;
	}

	public void setResaltarBusquedaDisponiblesCostosDisponiblesCostos(ParametroGeneralUsuario parametroGeneralUsuario/*DisponiblesCostosBeanSwingJInternalFrame disponiblescostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaDisponiblesCostosDisponiblesCostos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}