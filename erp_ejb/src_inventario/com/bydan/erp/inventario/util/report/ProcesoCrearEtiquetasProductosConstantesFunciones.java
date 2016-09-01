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


import com.bydan.erp.inventario.util.report.ProcesoCrearEtiquetasProductosConstantesFunciones;
import com.bydan.erp.inventario.util.report.ProcesoCrearEtiquetasProductosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ProcesoCrearEtiquetasProductosParameterGeneral;

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
final public class ProcesoCrearEtiquetasProductosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoCrearEtiquetasProductos";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoCrearEtiquetasProductos"+ProcesoCrearEtiquetasProductosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoCrearEtiquetasProductosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoCrearEtiquetasProductosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoCrearEtiquetasProductosConstantesFunciones.SCHEMA+"_"+ProcesoCrearEtiquetasProductosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoCrearEtiquetasProductosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoCrearEtiquetasProductosConstantesFunciones.SCHEMA+"_"+ProcesoCrearEtiquetasProductosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoCrearEtiquetasProductosConstantesFunciones.SCHEMA+"_"+ProcesoCrearEtiquetasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoCrearEtiquetasProductosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoCrearEtiquetasProductosConstantesFunciones.SCHEMA+"_"+ProcesoCrearEtiquetasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCrearEtiquetasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoCrearEtiquetasProductosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCrearEtiquetasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCrearEtiquetasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoCrearEtiquetasProductosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCrearEtiquetasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoCrearEtiquetasProductosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoCrearEtiquetasProductosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoCrearEtiquetasProductosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoCrearEtiquetasProductosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Crear Etiquetas Productoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Crear Etiquetas Productos";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Crear Etiquetas Productos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoCrearEtiquetasProductos";
	public static final String OBJECTNAME="procesocrearetiquetasproductos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="proceso_crear_etiquetas_productos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesocrearetiquetasproductos from "+ProcesoCrearEtiquetasProductosConstantesFunciones.SPERSISTENCENAME+" procesocrearetiquetasproductos";
	public static String QUERYSELECTNATIVE="select "+ProcesoCrearEtiquetasProductosConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasProductosConstantesFunciones.TABLENAME+".id,"+ProcesoCrearEtiquetasProductosConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasProductosConstantesFunciones.TABLENAME+".version_row,"+ProcesoCrearEtiquetasProductosConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasProductosConstantesFunciones.TABLENAME+".id_bodega,"+ProcesoCrearEtiquetasProductosConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasProductosConstantesFunciones.TABLENAME+".id_producto,"+ProcesoCrearEtiquetasProductosConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasProductosConstantesFunciones.TABLENAME+".id_empresa,"+ProcesoCrearEtiquetasProductosConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasProductosConstantesFunciones.TABLENAME+".id_sucursal,"+ProcesoCrearEtiquetasProductosConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasProductosConstantesFunciones.TABLENAME+".id_linea,"+ProcesoCrearEtiquetasProductosConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasProductosConstantesFunciones.TABLENAME+".id_linea_grupo,"+ProcesoCrearEtiquetasProductosConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasProductosConstantesFunciones.TABLENAME+".id_linea_categoria,"+ProcesoCrearEtiquetasProductosConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasProductosConstantesFunciones.TABLENAME+".id_linea_marca,"+ProcesoCrearEtiquetasProductosConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasProductosConstantesFunciones.TABLENAME+".codigo,"+ProcesoCrearEtiquetasProductosConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasProductosConstantesFunciones.TABLENAME+".nombre,"+ProcesoCrearEtiquetasProductosConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasProductosConstantesFunciones.TABLENAME+".precio1,"+ProcesoCrearEtiquetasProductosConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasProductosConstantesFunciones.TABLENAME+".precio2,"+ProcesoCrearEtiquetasProductosConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasProductosConstantesFunciones.TABLENAME+".precio3,"+ProcesoCrearEtiquetasProductosConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasProductosConstantesFunciones.TABLENAME+".precio4,"+ProcesoCrearEtiquetasProductosConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasProductosConstantesFunciones.TABLENAME+".precio5 from "+ProcesoCrearEtiquetasProductosConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasProductosConstantesFunciones.TABLENAME;//+" as "+ProcesoCrearEtiquetasProductosConstantesFunciones.TABLENAME;
	
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
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String PRECIO1= "precio1";
    public static final String PRECIO2= "precio2";
    public static final String PRECIO3= "precio3";
    public static final String PRECIO4= "precio4";
    public static final String PRECIO5= "precio5";
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
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_PRECIO1= "Precio1";
		public static final String LABEL_PRECIO1_LOWER= "Precio1";
    	public static final String LABEL_PRECIO2= "Precio2";
		public static final String LABEL_PRECIO2_LOWER= "Precio2";
    	public static final String LABEL_PRECIO3= "Precio3";
		public static final String LABEL_PRECIO3_LOWER= "Precio3";
    	public static final String LABEL_PRECIO4= "Precio4";
		public static final String LABEL_PRECIO4_LOWER= "Precio4";
    	public static final String LABEL_PRECIO5= "Precio5";
		public static final String LABEL_PRECIO5_LOWER= "Precio5";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getProcesoCrearEtiquetasProductosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDBODEGA)) {sLabelColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDLINEA)) {sLabelColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.CODIGO)) {sLabelColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.NOMBRE)) {sLabelColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO1)) {sLabelColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO1;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO2)) {sLabelColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO2;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO3)) {sLabelColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO3;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO4)) {sLabelColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO4;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO5)) {sLabelColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO5;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProcesoCrearEtiquetasProductosDescripcion(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesocrearetiquetasproductos !=null/* && procesocrearetiquetasproductos.getId()!=0*/) {
			sDescripcion=procesocrearetiquetasproductos.getcodigo();//procesocrearetiquetasproductosprocesocrearetiquetasproductos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoCrearEtiquetasProductosDescripcionDetallado(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductos) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoCrearEtiquetasProductosConstantesFunciones.ID+"=";
		sDescripcion+=procesocrearetiquetasproductos.getId().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasProductosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesocrearetiquetasproductos.getVersionRow().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasProductosConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=procesocrearetiquetasproductos.getid_bodega().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasProductosConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=procesocrearetiquetasproductos.getid_producto().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasProductosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=procesocrearetiquetasproductos.getid_empresa().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasProductosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=procesocrearetiquetasproductos.getid_sucursal().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasProductosConstantesFunciones.IDLINEA+"=";
		sDescripcion+=procesocrearetiquetasproductos.getid_linea().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasProductosConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=procesocrearetiquetasproductos.getid_linea_grupo().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasProductosConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=procesocrearetiquetasproductos.getid_linea_categoria().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasProductosConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=procesocrearetiquetasproductos.getid_linea_marca().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasProductosConstantesFunciones.CODIGO+"=";
		sDescripcion+=procesocrearetiquetasproductos.getcodigo()+",";
		sDescripcion+=ProcesoCrearEtiquetasProductosConstantesFunciones.NOMBRE+"=";
		sDescripcion+=procesocrearetiquetasproductos.getnombre()+",";
		sDescripcion+=ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO1+"=";
		sDescripcion+=procesocrearetiquetasproductos.getprecio1().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO2+"=";
		sDescripcion+=procesocrearetiquetasproductos.getprecio2().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO3+"=";
		sDescripcion+=procesocrearetiquetasproductos.getprecio3().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO4+"=";
		sDescripcion+=procesocrearetiquetasproductos.getprecio4().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO5+"=";
		sDescripcion+=procesocrearetiquetasproductos.getprecio5().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoCrearEtiquetasProductosDescripcion(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductos,String sValor) throws Exception {			
		if(procesocrearetiquetasproductos !=null) {
			procesocrearetiquetasproductos.setcodigo(sValor);;//procesocrearetiquetasproductosprocesocrearetiquetasproductos.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaProcesoCrearEtiquetasProductos")) {
			sNombreIndice="Tipo=  Por Bodega Por Producto Por Linea Por Linea Grupo Por Linea Categoria Por Linea Marca";
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

	public static String getDetalleIndiceBusquedaProcesoCrearEtiquetasProductos(Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();}
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();}
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();}
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();}
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();}
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosProcesoCrearEtiquetasProductos(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		procesocrearetiquetasproductos.setcodigo(procesocrearetiquetasproductos.getcodigo().trim());
		procesocrearetiquetasproductos.setnombre(procesocrearetiquetasproductos.getnombre().trim());
	}
	
	public static void quitarEspaciosProcesoCrearEtiquetasProductoss(List<ProcesoCrearEtiquetasProductos> procesocrearetiquetasproductoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductos: procesocrearetiquetasproductoss) {
			procesocrearetiquetasproductos.setcodigo(procesocrearetiquetasproductos.getcodigo().trim());
			procesocrearetiquetasproductos.setnombre(procesocrearetiquetasproductos.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoCrearEtiquetasProductos(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesocrearetiquetasproductos.getConCambioAuxiliar()) {
			procesocrearetiquetasproductos.setIsDeleted(procesocrearetiquetasproductos.getIsDeletedAuxiliar());	
			procesocrearetiquetasproductos.setIsNew(procesocrearetiquetasproductos.getIsNewAuxiliar());	
			procesocrearetiquetasproductos.setIsChanged(procesocrearetiquetasproductos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesocrearetiquetasproductos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesocrearetiquetasproductos.setIsDeletedAuxiliar(false);	
			procesocrearetiquetasproductos.setIsNewAuxiliar(false);	
			procesocrearetiquetasproductos.setIsChangedAuxiliar(false);
			
			procesocrearetiquetasproductos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoCrearEtiquetasProductoss(List<ProcesoCrearEtiquetasProductos> procesocrearetiquetasproductoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductos : procesocrearetiquetasproductoss) {
			if(conAsignarBase && procesocrearetiquetasproductos.getConCambioAuxiliar()) {
				procesocrearetiquetasproductos.setIsDeleted(procesocrearetiquetasproductos.getIsDeletedAuxiliar());	
				procesocrearetiquetasproductos.setIsNew(procesocrearetiquetasproductos.getIsNewAuxiliar());	
				procesocrearetiquetasproductos.setIsChanged(procesocrearetiquetasproductos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesocrearetiquetasproductos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesocrearetiquetasproductos.setIsDeletedAuxiliar(false);	
				procesocrearetiquetasproductos.setIsNewAuxiliar(false);	
				procesocrearetiquetasproductos.setIsChangedAuxiliar(false);
				
				procesocrearetiquetasproductos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoCrearEtiquetasProductos(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductos,Boolean conEnteros) throws Exception  {
		procesocrearetiquetasproductos.setprecio1(0.0);
		procesocrearetiquetasproductos.setprecio2(0.0);
		procesocrearetiquetasproductos.setprecio3(0.0);
		procesocrearetiquetasproductos.setprecio4(0.0);
		procesocrearetiquetasproductos.setprecio5(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoCrearEtiquetasProductoss(List<ProcesoCrearEtiquetasProductos> procesocrearetiquetasproductoss,Boolean conEnteros) throws Exception  {
		
		for(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductos: procesocrearetiquetasproductoss) {
			procesocrearetiquetasproductos.setprecio1(0.0);
			procesocrearetiquetasproductos.setprecio2(0.0);
			procesocrearetiquetasproductos.setprecio3(0.0);
			procesocrearetiquetasproductos.setprecio4(0.0);
			procesocrearetiquetasproductos.setprecio5(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoCrearEtiquetasProductos(List<ProcesoCrearEtiquetasProductos> procesocrearetiquetasproductoss,ProcesoCrearEtiquetasProductos procesocrearetiquetasproductosAux) throws Exception  {
		ProcesoCrearEtiquetasProductosConstantesFunciones.InicializarValoresProcesoCrearEtiquetasProductos(procesocrearetiquetasproductosAux,true);
		
		for(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductos: procesocrearetiquetasproductoss) {
			if(procesocrearetiquetasproductos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			procesocrearetiquetasproductosAux.setprecio1(procesocrearetiquetasproductosAux.getprecio1()+procesocrearetiquetasproductos.getprecio1());			
			procesocrearetiquetasproductosAux.setprecio2(procesocrearetiquetasproductosAux.getprecio2()+procesocrearetiquetasproductos.getprecio2());			
			procesocrearetiquetasproductosAux.setprecio3(procesocrearetiquetasproductosAux.getprecio3()+procesocrearetiquetasproductos.getprecio3());			
			procesocrearetiquetasproductosAux.setprecio4(procesocrearetiquetasproductosAux.getprecio4()+procesocrearetiquetasproductos.getprecio4());			
			procesocrearetiquetasproductosAux.setprecio5(procesocrearetiquetasproductosAux.getprecio5()+procesocrearetiquetasproductos.getprecio5());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCrearEtiquetasProductos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoCrearEtiquetasProductosConstantesFunciones.getArrayColumnasGlobalesProcesoCrearEtiquetasProductos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCrearEtiquetasProductos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoCrearEtiquetasProductosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoCrearEtiquetasProductosConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoCrearEtiquetasProductos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoCrearEtiquetasProductos> procesocrearetiquetasproductoss,ProcesoCrearEtiquetasProductos procesocrearetiquetasproductos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductosAux: procesocrearetiquetasproductoss) {
			if(procesocrearetiquetasproductosAux!=null && procesocrearetiquetasproductos!=null) {
				if((procesocrearetiquetasproductosAux.getId()==null && procesocrearetiquetasproductos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesocrearetiquetasproductosAux.getId()!=null && procesocrearetiquetasproductos.getId()!=null){
					if(procesocrearetiquetasproductosAux.getId().equals(procesocrearetiquetasproductos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoCrearEtiquetasProductos(List<ProcesoCrearEtiquetasProductos> procesocrearetiquetasproductoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precio1Total=0.0;
		Double precio2Total=0.0;
		Double precio3Total=0.0;
		Double precio4Total=0.0;
		Double precio5Total=0.0;
	
		for(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductos: procesocrearetiquetasproductoss) {			
			if(procesocrearetiquetasproductos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precio1Total+=procesocrearetiquetasproductos.getprecio1();
			precio2Total+=procesocrearetiquetasproductos.getprecio2();
			precio3Total+=procesocrearetiquetasproductos.getprecio3();
			precio4Total+=procesocrearetiquetasproductos.getprecio4();
			precio5Total+=procesocrearetiquetasproductos.getprecio5();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO1);
		datoGeneral.setsDescripcion(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO1);
		datoGeneral.setdValorDouble(precio1Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO2);
		datoGeneral.setsDescripcion(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO2);
		datoGeneral.setdValorDouble(precio2Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO3);
		datoGeneral.setsDescripcion(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO3);
		datoGeneral.setdValorDouble(precio3Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO4);
		datoGeneral.setsDescripcion(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO4);
		datoGeneral.setdValorDouble(precio4Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO5);
		datoGeneral.setsDescripcion(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO5);
		datoGeneral.setdValorDouble(precio5Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoCrearEtiquetasProductos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_ID, ProcesoCrearEtiquetasProductosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_VERSIONROW, ProcesoCrearEtiquetasProductosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_CODIGO, ProcesoCrearEtiquetasProductosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_NOMBRE, ProcesoCrearEtiquetasProductosConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO1, ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO2, ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO3, ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO3,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO4, ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO4,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO5, ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO5,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoCrearEtiquetasProductos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO3;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO4;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO5;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCrearEtiquetasProductos() throws Exception  {
		return ProcesoCrearEtiquetasProductosConstantesFunciones.getTiposSeleccionarProcesoCrearEtiquetasProductos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCrearEtiquetasProductos(Boolean conFk) throws Exception  {
		return ProcesoCrearEtiquetasProductosConstantesFunciones.getTiposSeleccionarProcesoCrearEtiquetasProductos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCrearEtiquetasProductos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO1);
			reporte.setsDescripcion(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO2);
			reporte.setsDescripcion(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO3);
			reporte.setsDescripcion(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO3);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO4);
			reporte.setsDescripcion(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO4);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO5);
			reporte.setsDescripcion(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO5);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoCrearEtiquetasProductos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoCrearEtiquetasProductos(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductosAux) throws Exception {
		
			procesocrearetiquetasproductosAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(procesocrearetiquetasproductosAux.getBodega()));
			procesocrearetiquetasproductosAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(procesocrearetiquetasproductosAux.getProducto()));
			procesocrearetiquetasproductosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(procesocrearetiquetasproductosAux.getEmpresa()));
			procesocrearetiquetasproductosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(procesocrearetiquetasproductosAux.getSucursal()));
			procesocrearetiquetasproductosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocrearetiquetasproductosAux.getLinea()));
			procesocrearetiquetasproductosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocrearetiquetasproductosAux.getLineaGrupo()));
			procesocrearetiquetasproductosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocrearetiquetasproductosAux.getLineaCategoria()));
			procesocrearetiquetasproductosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocrearetiquetasproductosAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoCrearEtiquetasProductos(List<ProcesoCrearEtiquetasProductos> procesocrearetiquetasproductossTemp) throws Exception {
		for(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductosAux:procesocrearetiquetasproductossTemp) {
			
			procesocrearetiquetasproductosAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(procesocrearetiquetasproductosAux.getBodega()));
			procesocrearetiquetasproductosAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(procesocrearetiquetasproductosAux.getProducto()));
			procesocrearetiquetasproductosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(procesocrearetiquetasproductosAux.getEmpresa()));
			procesocrearetiquetasproductosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(procesocrearetiquetasproductosAux.getSucursal()));
			procesocrearetiquetasproductosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocrearetiquetasproductosAux.getLinea()));
			procesocrearetiquetasproductosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocrearetiquetasproductosAux.getLineaGrupo()));
			procesocrearetiquetasproductosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocrearetiquetasproductosAux.getLineaCategoria()));
			procesocrearetiquetasproductosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocrearetiquetasproductosAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoCrearEtiquetasProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoCrearEtiquetasProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoCrearEtiquetasProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoCrearEtiquetasProductosConstantesFunciones.getClassesRelationshipsOfProcesoCrearEtiquetasProductos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoCrearEtiquetasProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoCrearEtiquetasProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoCrearEtiquetasProductosConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoCrearEtiquetasProductos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoCrearEtiquetasProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductos,List<ProcesoCrearEtiquetasProductos> procesocrearetiquetasproductoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductos,List<ProcesoCrearEtiquetasProductos> procesocrearetiquetasproductoss) throws Exception {
		try	{			
			for(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductosLocal:procesocrearetiquetasproductoss) {
				if(procesocrearetiquetasproductosLocal.getId().equals(procesocrearetiquetasproductos.getId())) {
					procesocrearetiquetasproductosLocal.setIsSelected(procesocrearetiquetasproductos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoCrearEtiquetasProductos(List<ProcesoCrearEtiquetasProductos> procesocrearetiquetasproductossAux) throws Exception {
		//this.procesocrearetiquetasproductossAux=procesocrearetiquetasproductossAux;
		
		for(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductosAux:procesocrearetiquetasproductossAux) {
			if(procesocrearetiquetasproductosAux.getIsChanged()) {
				procesocrearetiquetasproductosAux.setIsChanged(false);
			}		
			
			if(procesocrearetiquetasproductosAux.getIsNew()) {
				procesocrearetiquetasproductosAux.setIsNew(false);
			}	
			
			if(procesocrearetiquetasproductosAux.getIsDeleted()) {
				procesocrearetiquetasproductosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoCrearEtiquetasProductos(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductosAux) throws Exception {
		//this.procesocrearetiquetasproductosAux=procesocrearetiquetasproductosAux;
		
			if(procesocrearetiquetasproductosAux.getIsChanged()) {
				procesocrearetiquetasproductosAux.setIsChanged(false);
			}		
			
			if(procesocrearetiquetasproductosAux.getIsNew()) {
				procesocrearetiquetasproductosAux.setIsNew(false);
			}	
			
			if(procesocrearetiquetasproductosAux.getIsDeleted()) {
				procesocrearetiquetasproductosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductosAsignar,ProcesoCrearEtiquetasProductos procesocrearetiquetasproductos) throws Exception {
		procesocrearetiquetasproductosAsignar.setId(procesocrearetiquetasproductos.getId());	
		procesocrearetiquetasproductosAsignar.setVersionRow(procesocrearetiquetasproductos.getVersionRow());	
		procesocrearetiquetasproductosAsignar.setcodigo(procesocrearetiquetasproductos.getcodigo());	
		procesocrearetiquetasproductosAsignar.setnombre(procesocrearetiquetasproductos.getnombre());	
		procesocrearetiquetasproductosAsignar.setprecio1(procesocrearetiquetasproductos.getprecio1());	
		procesocrearetiquetasproductosAsignar.setprecio2(procesocrearetiquetasproductos.getprecio2());	
		procesocrearetiquetasproductosAsignar.setprecio3(procesocrearetiquetasproductos.getprecio3());	
		procesocrearetiquetasproductosAsignar.setprecio4(procesocrearetiquetasproductos.getprecio4());	
		procesocrearetiquetasproductosAsignar.setprecio5(procesocrearetiquetasproductos.getprecio5());	
	}
	
	public static void inicializarProcesoCrearEtiquetasProductos(ProcesoCrearEtiquetasProductos procesocrearetiquetasproductos) throws Exception {
		try {
				procesocrearetiquetasproductos.setId(0L);	
					
				procesocrearetiquetasproductos.setcodigo("");	
				procesocrearetiquetasproductos.setnombre("");	
				procesocrearetiquetasproductos.setprecio1(0.0);	
				procesocrearetiquetasproductos.setprecio2(0.0);	
				procesocrearetiquetasproductos.setprecio3(0.0);	
				procesocrearetiquetasproductos.setprecio4(0.0);	
				procesocrearetiquetasproductos.setprecio5(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoCrearEtiquetasProductos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO3);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO4);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasProductosConstantesFunciones.LABEL_PRECIO5);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoCrearEtiquetasProductos(String sTipo,Row row,Workbook workbook,ProcesoCrearEtiquetasProductos procesocrearetiquetasproductos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetasproductos.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetasproductos.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetasproductos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetasproductos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetasproductos.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetasproductos.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetasproductos.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetasproductos.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetasproductos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetasproductos.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetasproductos.getprecio1());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetasproductos.getprecio2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetasproductos.getprecio3());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetasproductos.getprecio4());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetasproductos.getprecio5());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoCrearEtiquetasProductos="";
	
	public String getsFinalQueryProcesoCrearEtiquetasProductos() {
		return this.sFinalQueryProcesoCrearEtiquetasProductos;
	}
	
	public void setsFinalQueryProcesoCrearEtiquetasProductos(String sFinalQueryProcesoCrearEtiquetasProductos) {
		this.sFinalQueryProcesoCrearEtiquetasProductos= sFinalQueryProcesoCrearEtiquetasProductos;
	}
	
	public Border resaltarSeleccionarProcesoCrearEtiquetasProductos=null;
	
	public Border setResaltarSeleccionarProcesoCrearEtiquetasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasProductosBeanSwingJInternalFrame procesocrearetiquetasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesocrearetiquetasproductosBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasProductos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoCrearEtiquetasProductos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoCrearEtiquetasProductos() {
		return this.resaltarSeleccionarProcesoCrearEtiquetasProductos;
	}
	
	public void setResaltarSeleccionarProcesoCrearEtiquetasProductos(Border borderResaltarSeleccionarProcesoCrearEtiquetasProductos) {
		this.resaltarSeleccionarProcesoCrearEtiquetasProductos= borderResaltarSeleccionarProcesoCrearEtiquetasProductos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoCrearEtiquetasProductos=null;
	public Boolean mostraridProcesoCrearEtiquetasProductos=true;
	public Boolean activaridProcesoCrearEtiquetasProductos=true;

	public Border resaltarid_bodegaProcesoCrearEtiquetasProductos=null;
	public Boolean mostrarid_bodegaProcesoCrearEtiquetasProductos=true;
	public Boolean activarid_bodegaProcesoCrearEtiquetasProductos=true;
	public Boolean cargarid_bodegaProcesoCrearEtiquetasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaProcesoCrearEtiquetasProductos=false;//ConEventDepend=true

	public Border resaltarid_productoProcesoCrearEtiquetasProductos=null;
	public Boolean mostrarid_productoProcesoCrearEtiquetasProductos=true;
	public Boolean activarid_productoProcesoCrearEtiquetasProductos=true;
	public Boolean cargarid_productoProcesoCrearEtiquetasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProcesoCrearEtiquetasProductos=false;//ConEventDepend=true

	public Border resaltarid_empresaProcesoCrearEtiquetasProductos=null;
	public Boolean mostrarid_empresaProcesoCrearEtiquetasProductos=true;
	public Boolean activarid_empresaProcesoCrearEtiquetasProductos=true;
	public Boolean cargarid_empresaProcesoCrearEtiquetasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProcesoCrearEtiquetasProductos=false;//ConEventDepend=true

	public Border resaltarid_sucursalProcesoCrearEtiquetasProductos=null;
	public Boolean mostrarid_sucursalProcesoCrearEtiquetasProductos=true;
	public Boolean activarid_sucursalProcesoCrearEtiquetasProductos=true;
	public Boolean cargarid_sucursalProcesoCrearEtiquetasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProcesoCrearEtiquetasProductos=false;//ConEventDepend=true

	public Border resaltarid_lineaProcesoCrearEtiquetasProductos=null;
	public Boolean mostrarid_lineaProcesoCrearEtiquetasProductos=true;
	public Boolean activarid_lineaProcesoCrearEtiquetasProductos=true;
	public Boolean cargarid_lineaProcesoCrearEtiquetasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaProcesoCrearEtiquetasProductos=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoProcesoCrearEtiquetasProductos=null;
	public Boolean mostrarid_linea_grupoProcesoCrearEtiquetasProductos=true;
	public Boolean activarid_linea_grupoProcesoCrearEtiquetasProductos=true;
	public Boolean cargarid_linea_grupoProcesoCrearEtiquetasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoProcesoCrearEtiquetasProductos=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaProcesoCrearEtiquetasProductos=null;
	public Boolean mostrarid_linea_categoriaProcesoCrearEtiquetasProductos=true;
	public Boolean activarid_linea_categoriaProcesoCrearEtiquetasProductos=true;
	public Boolean cargarid_linea_categoriaProcesoCrearEtiquetasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaProcesoCrearEtiquetasProductos=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaProcesoCrearEtiquetasProductos=null;
	public Boolean mostrarid_linea_marcaProcesoCrearEtiquetasProductos=true;
	public Boolean activarid_linea_marcaProcesoCrearEtiquetasProductos=true;
	public Boolean cargarid_linea_marcaProcesoCrearEtiquetasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaProcesoCrearEtiquetasProductos=false;//ConEventDepend=true

	public Border resaltarcodigoProcesoCrearEtiquetasProductos=null;
	public Boolean mostrarcodigoProcesoCrearEtiquetasProductos=true;
	public Boolean activarcodigoProcesoCrearEtiquetasProductos=true;

	public Border resaltarnombreProcesoCrearEtiquetasProductos=null;
	public Boolean mostrarnombreProcesoCrearEtiquetasProductos=true;
	public Boolean activarnombreProcesoCrearEtiquetasProductos=true;

	public Border resaltarprecio1ProcesoCrearEtiquetasProductos=null;
	public Boolean mostrarprecio1ProcesoCrearEtiquetasProductos=true;
	public Boolean activarprecio1ProcesoCrearEtiquetasProductos=true;

	public Border resaltarprecio2ProcesoCrearEtiquetasProductos=null;
	public Boolean mostrarprecio2ProcesoCrearEtiquetasProductos=true;
	public Boolean activarprecio2ProcesoCrearEtiquetasProductos=true;

	public Border resaltarprecio3ProcesoCrearEtiquetasProductos=null;
	public Boolean mostrarprecio3ProcesoCrearEtiquetasProductos=true;
	public Boolean activarprecio3ProcesoCrearEtiquetasProductos=true;

	public Border resaltarprecio4ProcesoCrearEtiquetasProductos=null;
	public Boolean mostrarprecio4ProcesoCrearEtiquetasProductos=true;
	public Boolean activarprecio4ProcesoCrearEtiquetasProductos=true;

	public Border resaltarprecio5ProcesoCrearEtiquetasProductos=null;
	public Boolean mostrarprecio5ProcesoCrearEtiquetasProductos=true;
	public Boolean activarprecio5ProcesoCrearEtiquetasProductos=true;

	
	

	public Border setResaltaridProcesoCrearEtiquetasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasProductosBeanSwingJInternalFrame procesocrearetiquetasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetasproductosBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasProductos.setBorder(borderResaltar);
		
		this.resaltaridProcesoCrearEtiquetasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoCrearEtiquetasProductos() {
		return this.resaltaridProcesoCrearEtiquetasProductos;
	}

	public void setResaltaridProcesoCrearEtiquetasProductos(Border borderResaltar) {
		this.resaltaridProcesoCrearEtiquetasProductos= borderResaltar;
	}

	public Boolean getMostraridProcesoCrearEtiquetasProductos() {
		return this.mostraridProcesoCrearEtiquetasProductos;
	}

	public void setMostraridProcesoCrearEtiquetasProductos(Boolean mostraridProcesoCrearEtiquetasProductos) {
		this.mostraridProcesoCrearEtiquetasProductos= mostraridProcesoCrearEtiquetasProductos;
	}

	public Boolean getActivaridProcesoCrearEtiquetasProductos() {
		return this.activaridProcesoCrearEtiquetasProductos;
	}

	public void setActivaridProcesoCrearEtiquetasProductos(Boolean activaridProcesoCrearEtiquetasProductos) {
		this.activaridProcesoCrearEtiquetasProductos= activaridProcesoCrearEtiquetasProductos;
	}

	public Border setResaltarid_bodegaProcesoCrearEtiquetasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasProductosBeanSwingJInternalFrame procesocrearetiquetasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetasproductosBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasProductos.setBorder(borderResaltar);
		
		this.resaltarid_bodegaProcesoCrearEtiquetasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaProcesoCrearEtiquetasProductos() {
		return this.resaltarid_bodegaProcesoCrearEtiquetasProductos;
	}

	public void setResaltarid_bodegaProcesoCrearEtiquetasProductos(Border borderResaltar) {
		this.resaltarid_bodegaProcesoCrearEtiquetasProductos= borderResaltar;
	}

	public Boolean getMostrarid_bodegaProcesoCrearEtiquetasProductos() {
		return this.mostrarid_bodegaProcesoCrearEtiquetasProductos;
	}

	public void setMostrarid_bodegaProcesoCrearEtiquetasProductos(Boolean mostrarid_bodegaProcesoCrearEtiquetasProductos) {
		this.mostrarid_bodegaProcesoCrearEtiquetasProductos= mostrarid_bodegaProcesoCrearEtiquetasProductos;
	}

	public Boolean getActivarid_bodegaProcesoCrearEtiquetasProductos() {
		return this.activarid_bodegaProcesoCrearEtiquetasProductos;
	}

	public void setActivarid_bodegaProcesoCrearEtiquetasProductos(Boolean activarid_bodegaProcesoCrearEtiquetasProductos) {
		this.activarid_bodegaProcesoCrearEtiquetasProductos= activarid_bodegaProcesoCrearEtiquetasProductos;
	}

	public Boolean getCargarid_bodegaProcesoCrearEtiquetasProductos() {
		return this.cargarid_bodegaProcesoCrearEtiquetasProductos;
	}

	public void setCargarid_bodegaProcesoCrearEtiquetasProductos(Boolean cargarid_bodegaProcesoCrearEtiquetasProductos) {
		this.cargarid_bodegaProcesoCrearEtiquetasProductos= cargarid_bodegaProcesoCrearEtiquetasProductos;
	}

	public Border setResaltarid_productoProcesoCrearEtiquetasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasProductosBeanSwingJInternalFrame procesocrearetiquetasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetasproductosBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasProductos.setBorder(borderResaltar);
		
		this.resaltarid_productoProcesoCrearEtiquetasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProcesoCrearEtiquetasProductos() {
		return this.resaltarid_productoProcesoCrearEtiquetasProductos;
	}

	public void setResaltarid_productoProcesoCrearEtiquetasProductos(Border borderResaltar) {
		this.resaltarid_productoProcesoCrearEtiquetasProductos= borderResaltar;
	}

	public Boolean getMostrarid_productoProcesoCrearEtiquetasProductos() {
		return this.mostrarid_productoProcesoCrearEtiquetasProductos;
	}

	public void setMostrarid_productoProcesoCrearEtiquetasProductos(Boolean mostrarid_productoProcesoCrearEtiquetasProductos) {
		this.mostrarid_productoProcesoCrearEtiquetasProductos= mostrarid_productoProcesoCrearEtiquetasProductos;
	}

	public Boolean getActivarid_productoProcesoCrearEtiquetasProductos() {
		return this.activarid_productoProcesoCrearEtiquetasProductos;
	}

	public void setActivarid_productoProcesoCrearEtiquetasProductos(Boolean activarid_productoProcesoCrearEtiquetasProductos) {
		this.activarid_productoProcesoCrearEtiquetasProductos= activarid_productoProcesoCrearEtiquetasProductos;
	}

	public Boolean getCargarid_productoProcesoCrearEtiquetasProductos() {
		return this.cargarid_productoProcesoCrearEtiquetasProductos;
	}

	public void setCargarid_productoProcesoCrearEtiquetasProductos(Boolean cargarid_productoProcesoCrearEtiquetasProductos) {
		this.cargarid_productoProcesoCrearEtiquetasProductos= cargarid_productoProcesoCrearEtiquetasProductos;
	}

	public Border setResaltarid_empresaProcesoCrearEtiquetasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasProductosBeanSwingJInternalFrame procesocrearetiquetasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetasproductosBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasProductos.setBorder(borderResaltar);
		
		this.resaltarid_empresaProcesoCrearEtiquetasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProcesoCrearEtiquetasProductos() {
		return this.resaltarid_empresaProcesoCrearEtiquetasProductos;
	}

	public void setResaltarid_empresaProcesoCrearEtiquetasProductos(Border borderResaltar) {
		this.resaltarid_empresaProcesoCrearEtiquetasProductos= borderResaltar;
	}

	public Boolean getMostrarid_empresaProcesoCrearEtiquetasProductos() {
		return this.mostrarid_empresaProcesoCrearEtiquetasProductos;
	}

	public void setMostrarid_empresaProcesoCrearEtiquetasProductos(Boolean mostrarid_empresaProcesoCrearEtiquetasProductos) {
		this.mostrarid_empresaProcesoCrearEtiquetasProductos= mostrarid_empresaProcesoCrearEtiquetasProductos;
	}

	public Boolean getActivarid_empresaProcesoCrearEtiquetasProductos() {
		return this.activarid_empresaProcesoCrearEtiquetasProductos;
	}

	public void setActivarid_empresaProcesoCrearEtiquetasProductos(Boolean activarid_empresaProcesoCrearEtiquetasProductos) {
		this.activarid_empresaProcesoCrearEtiquetasProductos= activarid_empresaProcesoCrearEtiquetasProductos;
	}

	public Boolean getCargarid_empresaProcesoCrearEtiquetasProductos() {
		return this.cargarid_empresaProcesoCrearEtiquetasProductos;
	}

	public void setCargarid_empresaProcesoCrearEtiquetasProductos(Boolean cargarid_empresaProcesoCrearEtiquetasProductos) {
		this.cargarid_empresaProcesoCrearEtiquetasProductos= cargarid_empresaProcesoCrearEtiquetasProductos;
	}

	public Border setResaltarid_sucursalProcesoCrearEtiquetasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasProductosBeanSwingJInternalFrame procesocrearetiquetasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetasproductosBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasProductos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProcesoCrearEtiquetasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProcesoCrearEtiquetasProductos() {
		return this.resaltarid_sucursalProcesoCrearEtiquetasProductos;
	}

	public void setResaltarid_sucursalProcesoCrearEtiquetasProductos(Border borderResaltar) {
		this.resaltarid_sucursalProcesoCrearEtiquetasProductos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProcesoCrearEtiquetasProductos() {
		return this.mostrarid_sucursalProcesoCrearEtiquetasProductos;
	}

	public void setMostrarid_sucursalProcesoCrearEtiquetasProductos(Boolean mostrarid_sucursalProcesoCrearEtiquetasProductos) {
		this.mostrarid_sucursalProcesoCrearEtiquetasProductos= mostrarid_sucursalProcesoCrearEtiquetasProductos;
	}

	public Boolean getActivarid_sucursalProcesoCrearEtiquetasProductos() {
		return this.activarid_sucursalProcesoCrearEtiquetasProductos;
	}

	public void setActivarid_sucursalProcesoCrearEtiquetasProductos(Boolean activarid_sucursalProcesoCrearEtiquetasProductos) {
		this.activarid_sucursalProcesoCrearEtiquetasProductos= activarid_sucursalProcesoCrearEtiquetasProductos;
	}

	public Boolean getCargarid_sucursalProcesoCrearEtiquetasProductos() {
		return this.cargarid_sucursalProcesoCrearEtiquetasProductos;
	}

	public void setCargarid_sucursalProcesoCrearEtiquetasProductos(Boolean cargarid_sucursalProcesoCrearEtiquetasProductos) {
		this.cargarid_sucursalProcesoCrearEtiquetasProductos= cargarid_sucursalProcesoCrearEtiquetasProductos;
	}

	public Border setResaltarid_lineaProcesoCrearEtiquetasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasProductosBeanSwingJInternalFrame procesocrearetiquetasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetasproductosBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasProductos.setBorder(borderResaltar);
		
		this.resaltarid_lineaProcesoCrearEtiquetasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaProcesoCrearEtiquetasProductos() {
		return this.resaltarid_lineaProcesoCrearEtiquetasProductos;
	}

	public void setResaltarid_lineaProcesoCrearEtiquetasProductos(Border borderResaltar) {
		this.resaltarid_lineaProcesoCrearEtiquetasProductos= borderResaltar;
	}

	public Boolean getMostrarid_lineaProcesoCrearEtiquetasProductos() {
		return this.mostrarid_lineaProcesoCrearEtiquetasProductos;
	}

	public void setMostrarid_lineaProcesoCrearEtiquetasProductos(Boolean mostrarid_lineaProcesoCrearEtiquetasProductos) {
		this.mostrarid_lineaProcesoCrearEtiquetasProductos= mostrarid_lineaProcesoCrearEtiquetasProductos;
	}

	public Boolean getActivarid_lineaProcesoCrearEtiquetasProductos() {
		return this.activarid_lineaProcesoCrearEtiquetasProductos;
	}

	public void setActivarid_lineaProcesoCrearEtiquetasProductos(Boolean activarid_lineaProcesoCrearEtiquetasProductos) {
		this.activarid_lineaProcesoCrearEtiquetasProductos= activarid_lineaProcesoCrearEtiquetasProductos;
	}

	public Boolean getCargarid_lineaProcesoCrearEtiquetasProductos() {
		return this.cargarid_lineaProcesoCrearEtiquetasProductos;
	}

	public void setCargarid_lineaProcesoCrearEtiquetasProductos(Boolean cargarid_lineaProcesoCrearEtiquetasProductos) {
		this.cargarid_lineaProcesoCrearEtiquetasProductos= cargarid_lineaProcesoCrearEtiquetasProductos;
	}

	public Border setResaltarid_linea_grupoProcesoCrearEtiquetasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasProductosBeanSwingJInternalFrame procesocrearetiquetasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetasproductosBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasProductos.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoProcesoCrearEtiquetasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoProcesoCrearEtiquetasProductos() {
		return this.resaltarid_linea_grupoProcesoCrearEtiquetasProductos;
	}

	public void setResaltarid_linea_grupoProcesoCrearEtiquetasProductos(Border borderResaltar) {
		this.resaltarid_linea_grupoProcesoCrearEtiquetasProductos= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoProcesoCrearEtiquetasProductos() {
		return this.mostrarid_linea_grupoProcesoCrearEtiquetasProductos;
	}

	public void setMostrarid_linea_grupoProcesoCrearEtiquetasProductos(Boolean mostrarid_linea_grupoProcesoCrearEtiquetasProductos) {
		this.mostrarid_linea_grupoProcesoCrearEtiquetasProductos= mostrarid_linea_grupoProcesoCrearEtiquetasProductos;
	}

	public Boolean getActivarid_linea_grupoProcesoCrearEtiquetasProductos() {
		return this.activarid_linea_grupoProcesoCrearEtiquetasProductos;
	}

	public void setActivarid_linea_grupoProcesoCrearEtiquetasProductos(Boolean activarid_linea_grupoProcesoCrearEtiquetasProductos) {
		this.activarid_linea_grupoProcesoCrearEtiquetasProductos= activarid_linea_grupoProcesoCrearEtiquetasProductos;
	}

	public Boolean getCargarid_linea_grupoProcesoCrearEtiquetasProductos() {
		return this.cargarid_linea_grupoProcesoCrearEtiquetasProductos;
	}

	public void setCargarid_linea_grupoProcesoCrearEtiquetasProductos(Boolean cargarid_linea_grupoProcesoCrearEtiquetasProductos) {
		this.cargarid_linea_grupoProcesoCrearEtiquetasProductos= cargarid_linea_grupoProcesoCrearEtiquetasProductos;
	}

	public Border setResaltarid_linea_categoriaProcesoCrearEtiquetasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasProductosBeanSwingJInternalFrame procesocrearetiquetasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetasproductosBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasProductos.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaProcesoCrearEtiquetasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaProcesoCrearEtiquetasProductos() {
		return this.resaltarid_linea_categoriaProcesoCrearEtiquetasProductos;
	}

	public void setResaltarid_linea_categoriaProcesoCrearEtiquetasProductos(Border borderResaltar) {
		this.resaltarid_linea_categoriaProcesoCrearEtiquetasProductos= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaProcesoCrearEtiquetasProductos() {
		return this.mostrarid_linea_categoriaProcesoCrearEtiquetasProductos;
	}

	public void setMostrarid_linea_categoriaProcesoCrearEtiquetasProductos(Boolean mostrarid_linea_categoriaProcesoCrearEtiquetasProductos) {
		this.mostrarid_linea_categoriaProcesoCrearEtiquetasProductos= mostrarid_linea_categoriaProcesoCrearEtiquetasProductos;
	}

	public Boolean getActivarid_linea_categoriaProcesoCrearEtiquetasProductos() {
		return this.activarid_linea_categoriaProcesoCrearEtiquetasProductos;
	}

	public void setActivarid_linea_categoriaProcesoCrearEtiquetasProductos(Boolean activarid_linea_categoriaProcesoCrearEtiquetasProductos) {
		this.activarid_linea_categoriaProcesoCrearEtiquetasProductos= activarid_linea_categoriaProcesoCrearEtiquetasProductos;
	}

	public Boolean getCargarid_linea_categoriaProcesoCrearEtiquetasProductos() {
		return this.cargarid_linea_categoriaProcesoCrearEtiquetasProductos;
	}

	public void setCargarid_linea_categoriaProcesoCrearEtiquetasProductos(Boolean cargarid_linea_categoriaProcesoCrearEtiquetasProductos) {
		this.cargarid_linea_categoriaProcesoCrearEtiquetasProductos= cargarid_linea_categoriaProcesoCrearEtiquetasProductos;
	}

	public Border setResaltarid_linea_marcaProcesoCrearEtiquetasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasProductosBeanSwingJInternalFrame procesocrearetiquetasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetasproductosBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasProductos.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaProcesoCrearEtiquetasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaProcesoCrearEtiquetasProductos() {
		return this.resaltarid_linea_marcaProcesoCrearEtiquetasProductos;
	}

	public void setResaltarid_linea_marcaProcesoCrearEtiquetasProductos(Border borderResaltar) {
		this.resaltarid_linea_marcaProcesoCrearEtiquetasProductos= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaProcesoCrearEtiquetasProductos() {
		return this.mostrarid_linea_marcaProcesoCrearEtiquetasProductos;
	}

	public void setMostrarid_linea_marcaProcesoCrearEtiquetasProductos(Boolean mostrarid_linea_marcaProcesoCrearEtiquetasProductos) {
		this.mostrarid_linea_marcaProcesoCrearEtiquetasProductos= mostrarid_linea_marcaProcesoCrearEtiquetasProductos;
	}

	public Boolean getActivarid_linea_marcaProcesoCrearEtiquetasProductos() {
		return this.activarid_linea_marcaProcesoCrearEtiquetasProductos;
	}

	public void setActivarid_linea_marcaProcesoCrearEtiquetasProductos(Boolean activarid_linea_marcaProcesoCrearEtiquetasProductos) {
		this.activarid_linea_marcaProcesoCrearEtiquetasProductos= activarid_linea_marcaProcesoCrearEtiquetasProductos;
	}

	public Boolean getCargarid_linea_marcaProcesoCrearEtiquetasProductos() {
		return this.cargarid_linea_marcaProcesoCrearEtiquetasProductos;
	}

	public void setCargarid_linea_marcaProcesoCrearEtiquetasProductos(Boolean cargarid_linea_marcaProcesoCrearEtiquetasProductos) {
		this.cargarid_linea_marcaProcesoCrearEtiquetasProductos= cargarid_linea_marcaProcesoCrearEtiquetasProductos;
	}

	public Border setResaltarcodigoProcesoCrearEtiquetasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasProductosBeanSwingJInternalFrame procesocrearetiquetasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetasproductosBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasProductos.setBorder(borderResaltar);
		
		this.resaltarcodigoProcesoCrearEtiquetasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoProcesoCrearEtiquetasProductos() {
		return this.resaltarcodigoProcesoCrearEtiquetasProductos;
	}

	public void setResaltarcodigoProcesoCrearEtiquetasProductos(Border borderResaltar) {
		this.resaltarcodigoProcesoCrearEtiquetasProductos= borderResaltar;
	}

	public Boolean getMostrarcodigoProcesoCrearEtiquetasProductos() {
		return this.mostrarcodigoProcesoCrearEtiquetasProductos;
	}

	public void setMostrarcodigoProcesoCrearEtiquetasProductos(Boolean mostrarcodigoProcesoCrearEtiquetasProductos) {
		this.mostrarcodigoProcesoCrearEtiquetasProductos= mostrarcodigoProcesoCrearEtiquetasProductos;
	}

	public Boolean getActivarcodigoProcesoCrearEtiquetasProductos() {
		return this.activarcodigoProcesoCrearEtiquetasProductos;
	}

	public void setActivarcodigoProcesoCrearEtiquetasProductos(Boolean activarcodigoProcesoCrearEtiquetasProductos) {
		this.activarcodigoProcesoCrearEtiquetasProductos= activarcodigoProcesoCrearEtiquetasProductos;
	}

	public Border setResaltarnombreProcesoCrearEtiquetasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasProductosBeanSwingJInternalFrame procesocrearetiquetasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetasproductosBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasProductos.setBorder(borderResaltar);
		
		this.resaltarnombreProcesoCrearEtiquetasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreProcesoCrearEtiquetasProductos() {
		return this.resaltarnombreProcesoCrearEtiquetasProductos;
	}

	public void setResaltarnombreProcesoCrearEtiquetasProductos(Border borderResaltar) {
		this.resaltarnombreProcesoCrearEtiquetasProductos= borderResaltar;
	}

	public Boolean getMostrarnombreProcesoCrearEtiquetasProductos() {
		return this.mostrarnombreProcesoCrearEtiquetasProductos;
	}

	public void setMostrarnombreProcesoCrearEtiquetasProductos(Boolean mostrarnombreProcesoCrearEtiquetasProductos) {
		this.mostrarnombreProcesoCrearEtiquetasProductos= mostrarnombreProcesoCrearEtiquetasProductos;
	}

	public Boolean getActivarnombreProcesoCrearEtiquetasProductos() {
		return this.activarnombreProcesoCrearEtiquetasProductos;
	}

	public void setActivarnombreProcesoCrearEtiquetasProductos(Boolean activarnombreProcesoCrearEtiquetasProductos) {
		this.activarnombreProcesoCrearEtiquetasProductos= activarnombreProcesoCrearEtiquetasProductos;
	}

	public Border setResaltarprecio1ProcesoCrearEtiquetasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasProductosBeanSwingJInternalFrame procesocrearetiquetasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetasproductosBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasProductos.setBorder(borderResaltar);
		
		this.resaltarprecio1ProcesoCrearEtiquetasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecio1ProcesoCrearEtiquetasProductos() {
		return this.resaltarprecio1ProcesoCrearEtiquetasProductos;
	}

	public void setResaltarprecio1ProcesoCrearEtiquetasProductos(Border borderResaltar) {
		this.resaltarprecio1ProcesoCrearEtiquetasProductos= borderResaltar;
	}

	public Boolean getMostrarprecio1ProcesoCrearEtiquetasProductos() {
		return this.mostrarprecio1ProcesoCrearEtiquetasProductos;
	}

	public void setMostrarprecio1ProcesoCrearEtiquetasProductos(Boolean mostrarprecio1ProcesoCrearEtiquetasProductos) {
		this.mostrarprecio1ProcesoCrearEtiquetasProductos= mostrarprecio1ProcesoCrearEtiquetasProductos;
	}

	public Boolean getActivarprecio1ProcesoCrearEtiquetasProductos() {
		return this.activarprecio1ProcesoCrearEtiquetasProductos;
	}

	public void setActivarprecio1ProcesoCrearEtiquetasProductos(Boolean activarprecio1ProcesoCrearEtiquetasProductos) {
		this.activarprecio1ProcesoCrearEtiquetasProductos= activarprecio1ProcesoCrearEtiquetasProductos;
	}

	public Border setResaltarprecio2ProcesoCrearEtiquetasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasProductosBeanSwingJInternalFrame procesocrearetiquetasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetasproductosBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasProductos.setBorder(borderResaltar);
		
		this.resaltarprecio2ProcesoCrearEtiquetasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecio2ProcesoCrearEtiquetasProductos() {
		return this.resaltarprecio2ProcesoCrearEtiquetasProductos;
	}

	public void setResaltarprecio2ProcesoCrearEtiquetasProductos(Border borderResaltar) {
		this.resaltarprecio2ProcesoCrearEtiquetasProductos= borderResaltar;
	}

	public Boolean getMostrarprecio2ProcesoCrearEtiquetasProductos() {
		return this.mostrarprecio2ProcesoCrearEtiquetasProductos;
	}

	public void setMostrarprecio2ProcesoCrearEtiquetasProductos(Boolean mostrarprecio2ProcesoCrearEtiquetasProductos) {
		this.mostrarprecio2ProcesoCrearEtiquetasProductos= mostrarprecio2ProcesoCrearEtiquetasProductos;
	}

	public Boolean getActivarprecio2ProcesoCrearEtiquetasProductos() {
		return this.activarprecio2ProcesoCrearEtiquetasProductos;
	}

	public void setActivarprecio2ProcesoCrearEtiquetasProductos(Boolean activarprecio2ProcesoCrearEtiquetasProductos) {
		this.activarprecio2ProcesoCrearEtiquetasProductos= activarprecio2ProcesoCrearEtiquetasProductos;
	}

	public Border setResaltarprecio3ProcesoCrearEtiquetasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasProductosBeanSwingJInternalFrame procesocrearetiquetasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetasproductosBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasProductos.setBorder(borderResaltar);
		
		this.resaltarprecio3ProcesoCrearEtiquetasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecio3ProcesoCrearEtiquetasProductos() {
		return this.resaltarprecio3ProcesoCrearEtiquetasProductos;
	}

	public void setResaltarprecio3ProcesoCrearEtiquetasProductos(Border borderResaltar) {
		this.resaltarprecio3ProcesoCrearEtiquetasProductos= borderResaltar;
	}

	public Boolean getMostrarprecio3ProcesoCrearEtiquetasProductos() {
		return this.mostrarprecio3ProcesoCrearEtiquetasProductos;
	}

	public void setMostrarprecio3ProcesoCrearEtiquetasProductos(Boolean mostrarprecio3ProcesoCrearEtiquetasProductos) {
		this.mostrarprecio3ProcesoCrearEtiquetasProductos= mostrarprecio3ProcesoCrearEtiquetasProductos;
	}

	public Boolean getActivarprecio3ProcesoCrearEtiquetasProductos() {
		return this.activarprecio3ProcesoCrearEtiquetasProductos;
	}

	public void setActivarprecio3ProcesoCrearEtiquetasProductos(Boolean activarprecio3ProcesoCrearEtiquetasProductos) {
		this.activarprecio3ProcesoCrearEtiquetasProductos= activarprecio3ProcesoCrearEtiquetasProductos;
	}

	public Border setResaltarprecio4ProcesoCrearEtiquetasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasProductosBeanSwingJInternalFrame procesocrearetiquetasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetasproductosBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasProductos.setBorder(borderResaltar);
		
		this.resaltarprecio4ProcesoCrearEtiquetasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecio4ProcesoCrearEtiquetasProductos() {
		return this.resaltarprecio4ProcesoCrearEtiquetasProductos;
	}

	public void setResaltarprecio4ProcesoCrearEtiquetasProductos(Border borderResaltar) {
		this.resaltarprecio4ProcesoCrearEtiquetasProductos= borderResaltar;
	}

	public Boolean getMostrarprecio4ProcesoCrearEtiquetasProductos() {
		return this.mostrarprecio4ProcesoCrearEtiquetasProductos;
	}

	public void setMostrarprecio4ProcesoCrearEtiquetasProductos(Boolean mostrarprecio4ProcesoCrearEtiquetasProductos) {
		this.mostrarprecio4ProcesoCrearEtiquetasProductos= mostrarprecio4ProcesoCrearEtiquetasProductos;
	}

	public Boolean getActivarprecio4ProcesoCrearEtiquetasProductos() {
		return this.activarprecio4ProcesoCrearEtiquetasProductos;
	}

	public void setActivarprecio4ProcesoCrearEtiquetasProductos(Boolean activarprecio4ProcesoCrearEtiquetasProductos) {
		this.activarprecio4ProcesoCrearEtiquetasProductos= activarprecio4ProcesoCrearEtiquetasProductos;
	}

	public Border setResaltarprecio5ProcesoCrearEtiquetasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasProductosBeanSwingJInternalFrame procesocrearetiquetasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetasproductosBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasProductos.setBorder(borderResaltar);
		
		this.resaltarprecio5ProcesoCrearEtiquetasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecio5ProcesoCrearEtiquetasProductos() {
		return this.resaltarprecio5ProcesoCrearEtiquetasProductos;
	}

	public void setResaltarprecio5ProcesoCrearEtiquetasProductos(Border borderResaltar) {
		this.resaltarprecio5ProcesoCrearEtiquetasProductos= borderResaltar;
	}

	public Boolean getMostrarprecio5ProcesoCrearEtiquetasProductos() {
		return this.mostrarprecio5ProcesoCrearEtiquetasProductos;
	}

	public void setMostrarprecio5ProcesoCrearEtiquetasProductos(Boolean mostrarprecio5ProcesoCrearEtiquetasProductos) {
		this.mostrarprecio5ProcesoCrearEtiquetasProductos= mostrarprecio5ProcesoCrearEtiquetasProductos;
	}

	public Boolean getActivarprecio5ProcesoCrearEtiquetasProductos() {
		return this.activarprecio5ProcesoCrearEtiquetasProductos;
	}

	public void setActivarprecio5ProcesoCrearEtiquetasProductos(Boolean activarprecio5ProcesoCrearEtiquetasProductos) {
		this.activarprecio5ProcesoCrearEtiquetasProductos= activarprecio5ProcesoCrearEtiquetasProductos;
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
		
		
		this.setMostraridProcesoCrearEtiquetasProductos(esInicial);
		this.setMostrarid_bodegaProcesoCrearEtiquetasProductos(esInicial);
		this.setMostrarid_productoProcesoCrearEtiquetasProductos(esInicial);
		this.setMostrarid_empresaProcesoCrearEtiquetasProductos(esInicial);
		this.setMostrarid_sucursalProcesoCrearEtiquetasProductos(esInicial);
		this.setMostrarid_lineaProcesoCrearEtiquetasProductos(esInicial);
		this.setMostrarid_linea_grupoProcesoCrearEtiquetasProductos(esInicial);
		this.setMostrarid_linea_categoriaProcesoCrearEtiquetasProductos(esInicial);
		this.setMostrarid_linea_marcaProcesoCrearEtiquetasProductos(esInicial);
		this.setMostrarcodigoProcesoCrearEtiquetasProductos(esInicial);
		this.setMostrarnombreProcesoCrearEtiquetasProductos(esInicial);
		this.setMostrarprecio1ProcesoCrearEtiquetasProductos(esInicial);
		this.setMostrarprecio2ProcesoCrearEtiquetasProductos(esInicial);
		this.setMostrarprecio3ProcesoCrearEtiquetasProductos(esInicial);
		this.setMostrarprecio4ProcesoCrearEtiquetasProductos(esInicial);
		this.setMostrarprecio5ProcesoCrearEtiquetasProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.ID)) {
				this.setMostraridProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO1)) {
				this.setMostrarprecio1ProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO2)) {
				this.setMostrarprecio2ProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO3)) {
				this.setMostrarprecio3ProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO4)) {
				this.setMostrarprecio4ProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO5)) {
				this.setMostrarprecio5ProcesoCrearEtiquetasProductos(esAsigna);
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
		
		
		this.setActivaridProcesoCrearEtiquetasProductos(esInicial);
		this.setActivarid_bodegaProcesoCrearEtiquetasProductos(esInicial);
		this.setActivarid_productoProcesoCrearEtiquetasProductos(esInicial);
		this.setActivarid_empresaProcesoCrearEtiquetasProductos(esInicial);
		this.setActivarid_sucursalProcesoCrearEtiquetasProductos(esInicial);
		this.setActivarid_lineaProcesoCrearEtiquetasProductos(esInicial);
		this.setActivarid_linea_grupoProcesoCrearEtiquetasProductos(esInicial);
		this.setActivarid_linea_categoriaProcesoCrearEtiquetasProductos(esInicial);
		this.setActivarid_linea_marcaProcesoCrearEtiquetasProductos(esInicial);
		this.setActivarcodigoProcesoCrearEtiquetasProductos(esInicial);
		this.setActivarnombreProcesoCrearEtiquetasProductos(esInicial);
		this.setActivarprecio1ProcesoCrearEtiquetasProductos(esInicial);
		this.setActivarprecio2ProcesoCrearEtiquetasProductos(esInicial);
		this.setActivarprecio3ProcesoCrearEtiquetasProductos(esInicial);
		this.setActivarprecio4ProcesoCrearEtiquetasProductos(esInicial);
		this.setActivarprecio5ProcesoCrearEtiquetasProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.ID)) {
				this.setActivaridProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.NOMBRE)) {
				this.setActivarnombreProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO1)) {
				this.setActivarprecio1ProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO2)) {
				this.setActivarprecio2ProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO3)) {
				this.setActivarprecio3ProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO4)) {
				this.setActivarprecio4ProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO5)) {
				this.setActivarprecio5ProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoCrearEtiquetasProductosBeanSwingJInternalFrame procesocrearetiquetasproductosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoCrearEtiquetasProductos(esInicial);
		this.setResaltarid_bodegaProcesoCrearEtiquetasProductos(esInicial);
		this.setResaltarid_productoProcesoCrearEtiquetasProductos(esInicial);
		this.setResaltarid_empresaProcesoCrearEtiquetasProductos(esInicial);
		this.setResaltarid_sucursalProcesoCrearEtiquetasProductos(esInicial);
		this.setResaltarid_lineaProcesoCrearEtiquetasProductos(esInicial);
		this.setResaltarid_linea_grupoProcesoCrearEtiquetasProductos(esInicial);
		this.setResaltarid_linea_categoriaProcesoCrearEtiquetasProductos(esInicial);
		this.setResaltarid_linea_marcaProcesoCrearEtiquetasProductos(esInicial);
		this.setResaltarcodigoProcesoCrearEtiquetasProductos(esInicial);
		this.setResaltarnombreProcesoCrearEtiquetasProductos(esInicial);
		this.setResaltarprecio1ProcesoCrearEtiquetasProductos(esInicial);
		this.setResaltarprecio2ProcesoCrearEtiquetasProductos(esInicial);
		this.setResaltarprecio3ProcesoCrearEtiquetasProductos(esInicial);
		this.setResaltarprecio4ProcesoCrearEtiquetasProductos(esInicial);
		this.setResaltarprecio5ProcesoCrearEtiquetasProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.ID)) {
				this.setResaltaridProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO1)) {
				this.setResaltarprecio1ProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO2)) {
				this.setResaltarprecio2ProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO3)) {
				this.setResaltarprecio3ProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO4)) {
				this.setResaltarprecio4ProcesoCrearEtiquetasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasProductosConstantesFunciones.PRECIO5)) {
				this.setResaltarprecio5ProcesoCrearEtiquetasProductos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoCrearEtiquetasProductosBeanSwingJInternalFrame procesocrearetiquetasproductosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoCrearEtiquetasProductosProcesoCrearEtiquetasProductos=true;

	public Boolean getMostrarBusquedaProcesoCrearEtiquetasProductosProcesoCrearEtiquetasProductos() {
		return this.mostrarBusquedaProcesoCrearEtiquetasProductosProcesoCrearEtiquetasProductos;
	}

	public void setMostrarBusquedaProcesoCrearEtiquetasProductosProcesoCrearEtiquetasProductos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoCrearEtiquetasProductosProcesoCrearEtiquetasProductos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoCrearEtiquetasProductosProcesoCrearEtiquetasProductos=true;

	public Boolean getActivarBusquedaProcesoCrearEtiquetasProductosProcesoCrearEtiquetasProductos() {
		return this.activarBusquedaProcesoCrearEtiquetasProductosProcesoCrearEtiquetasProductos;
	}

	public void setActivarBusquedaProcesoCrearEtiquetasProductosProcesoCrearEtiquetasProductos(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoCrearEtiquetasProductosProcesoCrearEtiquetasProductos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoCrearEtiquetasProductosProcesoCrearEtiquetasProductos=null;

	public Border getResaltarBusquedaProcesoCrearEtiquetasProductosProcesoCrearEtiquetasProductos() {
		return this.resaltarBusquedaProcesoCrearEtiquetasProductosProcesoCrearEtiquetasProductos;
	}

	public void setResaltarBusquedaProcesoCrearEtiquetasProductosProcesoCrearEtiquetasProductos(Border borderResaltar) {
		this.resaltarBusquedaProcesoCrearEtiquetasProductosProcesoCrearEtiquetasProductos= borderResaltar;
	}

	public void setResaltarBusquedaProcesoCrearEtiquetasProductosProcesoCrearEtiquetasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasProductosBeanSwingJInternalFrame procesocrearetiquetasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoCrearEtiquetasProductosProcesoCrearEtiquetasProductos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}