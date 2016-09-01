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


import com.bydan.erp.inventario.util.report.ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones;
import com.bydan.erp.inventario.util.report.ProcesoCrearEtiquetasCodigoBarrasParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ProcesoCrearEtiquetasCodigoBarrasParameterGeneral;

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
final public class ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoCrearEtiquetasCodigoBarras";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoCrearEtiquetasCodigoBarras"+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoCrearEtiquetasCodigoBarrasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoCrearEtiquetasCodigoBarrasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SCHEMA+"_"+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoCrearEtiquetasCodigoBarrasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SCHEMA+"_"+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SCHEMA+"_"+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoCrearEtiquetasCodigoBarrasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SCHEMA+"_"+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoCrearEtiquetasCodigoBarrasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoCrearEtiquetasCodigoBarrasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Crear Etiquetas Codigo Barrases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Crear Etiquetas Codigo Barras";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Crear Etiquetas Codigo Barras";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoCrearEtiquetasCodigoBarras";
	public static final String OBJECTNAME="procesocrearetiquetascodigobarras";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="proceso_crear_etiquetas_codigo_barras";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesocrearetiquetascodigobarras from "+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SPERSISTENCENAME+" procesocrearetiquetascodigobarras";
	public static String QUERYSELECTNATIVE="select "+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TABLENAME+".id,"+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TABLENAME+".version_row,"+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TABLENAME+".id_bodega,"+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TABLENAME+".id_producto,"+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TABLENAME+".id_empresa,"+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TABLENAME+".id_sucursal,"+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TABLENAME+".id_linea,"+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TABLENAME+".id_linea_grupo,"+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TABLENAME+".id_linea_categoria,"+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TABLENAME+".id_linea_marca,"+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TABLENAME+".codigo,"+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TABLENAME+".nombre,"+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TABLENAME+".precio,"+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TABLENAME+".numero,"+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TABLENAME+".talla from "+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.SCHEMA+"."+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TABLENAME;//+" as "+ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TABLENAME;
	
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
    public static final String PRECIO= "precio";
    public static final String NUMERO= "numero";
    public static final String TALLA= "talla";
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
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_TALLA= "Talla";
		public static final String LABEL_TALLA_LOWER= "Talla";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXTALLA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTALLA=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProcesoCrearEtiquetasCodigoBarrasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDBODEGA)) {sLabelColumna=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDLINEA)) {sLabelColumna=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.CODIGO)) {sLabelColumna=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.NOMBRE)) {sLabelColumna=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.PRECIO)) {sLabelColumna=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.NUMERO)) {sLabelColumna=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TALLA)) {sLabelColumna=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_TALLA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProcesoCrearEtiquetasCodigoBarrasDescripcion(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarras) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesocrearetiquetascodigobarras !=null/* && procesocrearetiquetascodigobarras.getId()!=0*/) {
			sDescripcion=procesocrearetiquetascodigobarras.getcodigo();//procesocrearetiquetascodigobarrasprocesocrearetiquetascodigobarras.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoCrearEtiquetasCodigoBarrasDescripcionDetallado(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarras) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.ID+"=";
		sDescripcion+=procesocrearetiquetascodigobarras.getId().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesocrearetiquetascodigobarras.getVersionRow().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=procesocrearetiquetascodigobarras.getid_bodega().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=procesocrearetiquetascodigobarras.getid_producto().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=procesocrearetiquetascodigobarras.getid_empresa().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=procesocrearetiquetascodigobarras.getid_sucursal().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDLINEA+"=";
		sDescripcion+=procesocrearetiquetascodigobarras.getid_linea().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=procesocrearetiquetascodigobarras.getid_linea_grupo().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=procesocrearetiquetascodigobarras.getid_linea_categoria().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=procesocrearetiquetascodigobarras.getid_linea_marca().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.CODIGO+"=";
		sDescripcion+=procesocrearetiquetascodigobarras.getcodigo()+",";
		sDescripcion+=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.NOMBRE+"=";
		sDescripcion+=procesocrearetiquetascodigobarras.getnombre()+",";
		sDescripcion+=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.PRECIO+"=";
		sDescripcion+=procesocrearetiquetascodigobarras.getprecio().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.NUMERO+"=";
		sDescripcion+=procesocrearetiquetascodigobarras.getnumero().toString()+",";
		sDescripcion+=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TALLA+"=";
		sDescripcion+=procesocrearetiquetascodigobarras.gettalla()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoCrearEtiquetasCodigoBarrasDescripcion(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarras,String sValor) throws Exception {			
		if(procesocrearetiquetascodigobarras !=null) {
			procesocrearetiquetascodigobarras.setcodigo(sValor);;//procesocrearetiquetascodigobarrasprocesocrearetiquetascodigobarras.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaProcesoCrearEtiquetasCodigoBarras")) {
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

	public static String getDetalleIndiceBusquedaProcesoCrearEtiquetasCodigoBarras(Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca) {
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
	
	
	
	
	
	
	public static void quitarEspaciosProcesoCrearEtiquetasCodigoBarras(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		procesocrearetiquetascodigobarras.setcodigo(procesocrearetiquetascodigobarras.getcodigo().trim());
		procesocrearetiquetascodigobarras.setnombre(procesocrearetiquetascodigobarras.getnombre().trim());
		procesocrearetiquetascodigobarras.settalla(procesocrearetiquetascodigobarras.gettalla().trim());
	}
	
	public static void quitarEspaciosProcesoCrearEtiquetasCodigoBarrass(List<ProcesoCrearEtiquetasCodigoBarras> procesocrearetiquetascodigobarrass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarras: procesocrearetiquetascodigobarrass) {
			procesocrearetiquetascodigobarras.setcodigo(procesocrearetiquetascodigobarras.getcodigo().trim());
			procesocrearetiquetascodigobarras.setnombre(procesocrearetiquetascodigobarras.getnombre().trim());
			procesocrearetiquetascodigobarras.settalla(procesocrearetiquetascodigobarras.gettalla().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoCrearEtiquetasCodigoBarras(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesocrearetiquetascodigobarras.getConCambioAuxiliar()) {
			procesocrearetiquetascodigobarras.setIsDeleted(procesocrearetiquetascodigobarras.getIsDeletedAuxiliar());	
			procesocrearetiquetascodigobarras.setIsNew(procesocrearetiquetascodigobarras.getIsNewAuxiliar());	
			procesocrearetiquetascodigobarras.setIsChanged(procesocrearetiquetascodigobarras.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesocrearetiquetascodigobarras.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesocrearetiquetascodigobarras.setIsDeletedAuxiliar(false);	
			procesocrearetiquetascodigobarras.setIsNewAuxiliar(false);	
			procesocrearetiquetascodigobarras.setIsChangedAuxiliar(false);
			
			procesocrearetiquetascodigobarras.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoCrearEtiquetasCodigoBarrass(List<ProcesoCrearEtiquetasCodigoBarras> procesocrearetiquetascodigobarrass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarras : procesocrearetiquetascodigobarrass) {
			if(conAsignarBase && procesocrearetiquetascodigobarras.getConCambioAuxiliar()) {
				procesocrearetiquetascodigobarras.setIsDeleted(procesocrearetiquetascodigobarras.getIsDeletedAuxiliar());	
				procesocrearetiquetascodigobarras.setIsNew(procesocrearetiquetascodigobarras.getIsNewAuxiliar());	
				procesocrearetiquetascodigobarras.setIsChanged(procesocrearetiquetascodigobarras.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesocrearetiquetascodigobarras.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesocrearetiquetascodigobarras.setIsDeletedAuxiliar(false);	
				procesocrearetiquetascodigobarras.setIsNewAuxiliar(false);	
				procesocrearetiquetascodigobarras.setIsChangedAuxiliar(false);
				
				procesocrearetiquetascodigobarras.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoCrearEtiquetasCodigoBarras(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarras,Boolean conEnteros) throws Exception  {
		procesocrearetiquetascodigobarras.setprecio(0.0);
		procesocrearetiquetascodigobarras.setnumero(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoCrearEtiquetasCodigoBarrass(List<ProcesoCrearEtiquetasCodigoBarras> procesocrearetiquetascodigobarrass,Boolean conEnteros) throws Exception  {
		
		for(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarras: procesocrearetiquetascodigobarrass) {
			procesocrearetiquetascodigobarras.setprecio(0.0);
			procesocrearetiquetascodigobarras.setnumero(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoCrearEtiquetasCodigoBarras(List<ProcesoCrearEtiquetasCodigoBarras> procesocrearetiquetascodigobarrass,ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarrasAux) throws Exception  {
		ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.InicializarValoresProcesoCrearEtiquetasCodigoBarras(procesocrearetiquetascodigobarrasAux,true);
		
		for(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarras: procesocrearetiquetascodigobarrass) {
			if(procesocrearetiquetascodigobarras.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			procesocrearetiquetascodigobarrasAux.setprecio(procesocrearetiquetascodigobarrasAux.getprecio()+procesocrearetiquetascodigobarras.getprecio());			
			procesocrearetiquetascodigobarrasAux.setnumero(procesocrearetiquetascodigobarrasAux.getnumero()+procesocrearetiquetascodigobarras.getnumero());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCrearEtiquetasCodigoBarras(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.getArrayColumnasGlobalesProcesoCrearEtiquetasCodigoBarras(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCrearEtiquetasCodigoBarras(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoCrearEtiquetasCodigoBarras(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoCrearEtiquetasCodigoBarras> procesocrearetiquetascodigobarrass,ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarras,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarrasAux: procesocrearetiquetascodigobarrass) {
			if(procesocrearetiquetascodigobarrasAux!=null && procesocrearetiquetascodigobarras!=null) {
				if((procesocrearetiquetascodigobarrasAux.getId()==null && procesocrearetiquetascodigobarras.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesocrearetiquetascodigobarrasAux.getId()!=null && procesocrearetiquetascodigobarras.getId()!=null){
					if(procesocrearetiquetascodigobarrasAux.getId().equals(procesocrearetiquetascodigobarras.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoCrearEtiquetasCodigoBarras(List<ProcesoCrearEtiquetasCodigoBarras> procesocrearetiquetascodigobarrass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double numeroTotal=0.0;
	
		for(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarras: procesocrearetiquetascodigobarrass) {			
			if(procesocrearetiquetascodigobarras.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=procesocrearetiquetascodigobarras.getprecio();
			numeroTotal+=procesocrearetiquetascodigobarras.getnumero();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.NUMERO);
		datoGeneral.setsDescripcion(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_NUMERO);
		datoGeneral.setdValorDouble(numeroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoCrearEtiquetasCodigoBarras() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_ID, ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_VERSIONROW, ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_CODIGO, ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_NOMBRE, ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_PRECIO, ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_NUMERO, ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_TALLA, ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TALLA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoCrearEtiquetasCodigoBarras() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TALLA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCrearEtiquetasCodigoBarras() throws Exception  {
		return ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.getTiposSeleccionarProcesoCrearEtiquetasCodigoBarras(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCrearEtiquetasCodigoBarras(Boolean conFk) throws Exception  {
		return ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.getTiposSeleccionarProcesoCrearEtiquetasCodigoBarras(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCrearEtiquetasCodigoBarras(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_TALLA);
			reporte.setsDescripcion(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_TALLA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoCrearEtiquetasCodigoBarras(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoCrearEtiquetasCodigoBarras(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarrasAux) throws Exception {
		
			procesocrearetiquetascodigobarrasAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(procesocrearetiquetascodigobarrasAux.getBodega()));
			procesocrearetiquetascodigobarrasAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(procesocrearetiquetascodigobarrasAux.getProducto()));
			procesocrearetiquetascodigobarrasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(procesocrearetiquetascodigobarrasAux.getEmpresa()));
			procesocrearetiquetascodigobarrasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(procesocrearetiquetascodigobarrasAux.getSucursal()));
			procesocrearetiquetascodigobarrasAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocrearetiquetascodigobarrasAux.getLinea()));
			procesocrearetiquetascodigobarrasAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocrearetiquetascodigobarrasAux.getLineaGrupo()));
			procesocrearetiquetascodigobarrasAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocrearetiquetascodigobarrasAux.getLineaCategoria()));
			procesocrearetiquetascodigobarrasAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocrearetiquetascodigobarrasAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoCrearEtiquetasCodigoBarras(List<ProcesoCrearEtiquetasCodigoBarras> procesocrearetiquetascodigobarrassTemp) throws Exception {
		for(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarrasAux:procesocrearetiquetascodigobarrassTemp) {
			
			procesocrearetiquetascodigobarrasAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(procesocrearetiquetascodigobarrasAux.getBodega()));
			procesocrearetiquetascodigobarrasAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(procesocrearetiquetascodigobarrasAux.getProducto()));
			procesocrearetiquetascodigobarrasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(procesocrearetiquetascodigobarrasAux.getEmpresa()));
			procesocrearetiquetascodigobarrasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(procesocrearetiquetascodigobarrasAux.getSucursal()));
			procesocrearetiquetascodigobarrasAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocrearetiquetascodigobarrasAux.getLinea()));
			procesocrearetiquetascodigobarrasAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocrearetiquetascodigobarrasAux.getLineaGrupo()));
			procesocrearetiquetascodigobarrasAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocrearetiquetascodigobarrasAux.getLineaCategoria()));
			procesocrearetiquetascodigobarrasAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocrearetiquetascodigobarrasAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoCrearEtiquetasCodigoBarras(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoCrearEtiquetasCodigoBarras(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoCrearEtiquetasCodigoBarras(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.getClassesRelationshipsOfProcesoCrearEtiquetasCodigoBarras(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoCrearEtiquetasCodigoBarras(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoCrearEtiquetasCodigoBarras(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoCrearEtiquetasCodigoBarras(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoCrearEtiquetasCodigoBarras(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarras,List<ProcesoCrearEtiquetasCodigoBarras> procesocrearetiquetascodigobarrass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarras,List<ProcesoCrearEtiquetasCodigoBarras> procesocrearetiquetascodigobarrass) throws Exception {
		try	{			
			for(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarrasLocal:procesocrearetiquetascodigobarrass) {
				if(procesocrearetiquetascodigobarrasLocal.getId().equals(procesocrearetiquetascodigobarras.getId())) {
					procesocrearetiquetascodigobarrasLocal.setIsSelected(procesocrearetiquetascodigobarras.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoCrearEtiquetasCodigoBarras(List<ProcesoCrearEtiquetasCodigoBarras> procesocrearetiquetascodigobarrassAux) throws Exception {
		//this.procesocrearetiquetascodigobarrassAux=procesocrearetiquetascodigobarrassAux;
		
		for(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarrasAux:procesocrearetiquetascodigobarrassAux) {
			if(procesocrearetiquetascodigobarrasAux.getIsChanged()) {
				procesocrearetiquetascodigobarrasAux.setIsChanged(false);
			}		
			
			if(procesocrearetiquetascodigobarrasAux.getIsNew()) {
				procesocrearetiquetascodigobarrasAux.setIsNew(false);
			}	
			
			if(procesocrearetiquetascodigobarrasAux.getIsDeleted()) {
				procesocrearetiquetascodigobarrasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoCrearEtiquetasCodigoBarras(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarrasAux) throws Exception {
		//this.procesocrearetiquetascodigobarrasAux=procesocrearetiquetascodigobarrasAux;
		
			if(procesocrearetiquetascodigobarrasAux.getIsChanged()) {
				procesocrearetiquetascodigobarrasAux.setIsChanged(false);
			}		
			
			if(procesocrearetiquetascodigobarrasAux.getIsNew()) {
				procesocrearetiquetascodigobarrasAux.setIsNew(false);
			}	
			
			if(procesocrearetiquetascodigobarrasAux.getIsDeleted()) {
				procesocrearetiquetascodigobarrasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarrasAsignar,ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarras) throws Exception {
		procesocrearetiquetascodigobarrasAsignar.setId(procesocrearetiquetascodigobarras.getId());	
		procesocrearetiquetascodigobarrasAsignar.setVersionRow(procesocrearetiquetascodigobarras.getVersionRow());	
		procesocrearetiquetascodigobarrasAsignar.setcodigo(procesocrearetiquetascodigobarras.getcodigo());	
		procesocrearetiquetascodigobarrasAsignar.setnombre(procesocrearetiquetascodigobarras.getnombre());	
		procesocrearetiquetascodigobarrasAsignar.setprecio(procesocrearetiquetascodigobarras.getprecio());	
		procesocrearetiquetascodigobarrasAsignar.setnumero(procesocrearetiquetascodigobarras.getnumero());	
		procesocrearetiquetascodigobarrasAsignar.settalla(procesocrearetiquetascodigobarras.gettalla());	
	}
	
	public static void inicializarProcesoCrearEtiquetasCodigoBarras(ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarras) throws Exception {
		try {
				procesocrearetiquetascodigobarras.setId(0L);	
					
				procesocrearetiquetascodigobarras.setcodigo("");	
				procesocrearetiquetascodigobarras.setnombre("");	
				procesocrearetiquetascodigobarras.setprecio(0.0);	
				procesocrearetiquetascodigobarras.setnumero(0.0);	
				procesocrearetiquetascodigobarras.settalla("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoCrearEtiquetasCodigoBarras(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.LABEL_TALLA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoCrearEtiquetasCodigoBarras(String sTipo,Row row,Workbook workbook,ProcesoCrearEtiquetasCodigoBarras procesocrearetiquetascodigobarras,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetascodigobarras.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetascodigobarras.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetascodigobarras.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetascodigobarras.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetascodigobarras.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetascodigobarras.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetascodigobarras.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetascodigobarras.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetascodigobarras.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetascodigobarras.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetascodigobarras.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetascodigobarras.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocrearetiquetascodigobarras.gettalla());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoCrearEtiquetasCodigoBarras="";
	
	public String getsFinalQueryProcesoCrearEtiquetasCodigoBarras() {
		return this.sFinalQueryProcesoCrearEtiquetasCodigoBarras;
	}
	
	public void setsFinalQueryProcesoCrearEtiquetasCodigoBarras(String sFinalQueryProcesoCrearEtiquetasCodigoBarras) {
		this.sFinalQueryProcesoCrearEtiquetasCodigoBarras= sFinalQueryProcesoCrearEtiquetasCodigoBarras;
	}
	
	public Border resaltarSeleccionarProcesoCrearEtiquetasCodigoBarras=null;
	
	public Border setResaltarSeleccionarProcesoCrearEtiquetasCodigoBarras(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasCodigoBarrasBeanSwingJInternalFrame procesocrearetiquetascodigobarrasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesocrearetiquetascodigobarrasBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasCodigoBarras.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoCrearEtiquetasCodigoBarras= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoCrearEtiquetasCodigoBarras() {
		return this.resaltarSeleccionarProcesoCrearEtiquetasCodigoBarras;
	}
	
	public void setResaltarSeleccionarProcesoCrearEtiquetasCodigoBarras(Border borderResaltarSeleccionarProcesoCrearEtiquetasCodigoBarras) {
		this.resaltarSeleccionarProcesoCrearEtiquetasCodigoBarras= borderResaltarSeleccionarProcesoCrearEtiquetasCodigoBarras;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoCrearEtiquetasCodigoBarras=null;
	public Boolean mostraridProcesoCrearEtiquetasCodigoBarras=true;
	public Boolean activaridProcesoCrearEtiquetasCodigoBarras=true;

	public Border resaltarid_bodegaProcesoCrearEtiquetasCodigoBarras=null;
	public Boolean mostrarid_bodegaProcesoCrearEtiquetasCodigoBarras=true;
	public Boolean activarid_bodegaProcesoCrearEtiquetasCodigoBarras=true;
	public Boolean cargarid_bodegaProcesoCrearEtiquetasCodigoBarras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaProcesoCrearEtiquetasCodigoBarras=false;//ConEventDepend=true

	public Border resaltarid_productoProcesoCrearEtiquetasCodigoBarras=null;
	public Boolean mostrarid_productoProcesoCrearEtiquetasCodigoBarras=true;
	public Boolean activarid_productoProcesoCrearEtiquetasCodigoBarras=true;
	public Boolean cargarid_productoProcesoCrearEtiquetasCodigoBarras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProcesoCrearEtiquetasCodigoBarras=false;//ConEventDepend=true

	public Border resaltarid_empresaProcesoCrearEtiquetasCodigoBarras=null;
	public Boolean mostrarid_empresaProcesoCrearEtiquetasCodigoBarras=true;
	public Boolean activarid_empresaProcesoCrearEtiquetasCodigoBarras=true;
	public Boolean cargarid_empresaProcesoCrearEtiquetasCodigoBarras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProcesoCrearEtiquetasCodigoBarras=false;//ConEventDepend=true

	public Border resaltarid_sucursalProcesoCrearEtiquetasCodigoBarras=null;
	public Boolean mostrarid_sucursalProcesoCrearEtiquetasCodigoBarras=true;
	public Boolean activarid_sucursalProcesoCrearEtiquetasCodigoBarras=true;
	public Boolean cargarid_sucursalProcesoCrearEtiquetasCodigoBarras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProcesoCrearEtiquetasCodigoBarras=false;//ConEventDepend=true

	public Border resaltarid_lineaProcesoCrearEtiquetasCodigoBarras=null;
	public Boolean mostrarid_lineaProcesoCrearEtiquetasCodigoBarras=true;
	public Boolean activarid_lineaProcesoCrearEtiquetasCodigoBarras=true;
	public Boolean cargarid_lineaProcesoCrearEtiquetasCodigoBarras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaProcesoCrearEtiquetasCodigoBarras=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoProcesoCrearEtiquetasCodigoBarras=null;
	public Boolean mostrarid_linea_grupoProcesoCrearEtiquetasCodigoBarras=true;
	public Boolean activarid_linea_grupoProcesoCrearEtiquetasCodigoBarras=true;
	public Boolean cargarid_linea_grupoProcesoCrearEtiquetasCodigoBarras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoProcesoCrearEtiquetasCodigoBarras=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras=null;
	public Boolean mostrarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras=true;
	public Boolean activarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras=true;
	public Boolean cargarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaProcesoCrearEtiquetasCodigoBarras=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaProcesoCrearEtiquetasCodigoBarras=null;
	public Boolean mostrarid_linea_marcaProcesoCrearEtiquetasCodigoBarras=true;
	public Boolean activarid_linea_marcaProcesoCrearEtiquetasCodigoBarras=true;
	public Boolean cargarid_linea_marcaProcesoCrearEtiquetasCodigoBarras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaProcesoCrearEtiquetasCodigoBarras=false;//ConEventDepend=true

	public Border resaltarcodigoProcesoCrearEtiquetasCodigoBarras=null;
	public Boolean mostrarcodigoProcesoCrearEtiquetasCodigoBarras=true;
	public Boolean activarcodigoProcesoCrearEtiquetasCodigoBarras=true;

	public Border resaltarnombreProcesoCrearEtiquetasCodigoBarras=null;
	public Boolean mostrarnombreProcesoCrearEtiquetasCodigoBarras=true;
	public Boolean activarnombreProcesoCrearEtiquetasCodigoBarras=true;

	public Border resaltarprecioProcesoCrearEtiquetasCodigoBarras=null;
	public Boolean mostrarprecioProcesoCrearEtiquetasCodigoBarras=true;
	public Boolean activarprecioProcesoCrearEtiquetasCodigoBarras=true;

	public Border resaltarnumeroProcesoCrearEtiquetasCodigoBarras=null;
	public Boolean mostrarnumeroProcesoCrearEtiquetasCodigoBarras=true;
	public Boolean activarnumeroProcesoCrearEtiquetasCodigoBarras=true;

	public Border resaltartallaProcesoCrearEtiquetasCodigoBarras=null;
	public Boolean mostrartallaProcesoCrearEtiquetasCodigoBarras=true;
	public Boolean activartallaProcesoCrearEtiquetasCodigoBarras=true;

	
	

	public Border setResaltaridProcesoCrearEtiquetasCodigoBarras(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasCodigoBarrasBeanSwingJInternalFrame procesocrearetiquetascodigobarrasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetascodigobarrasBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasCodigoBarras.setBorder(borderResaltar);
		
		this.resaltaridProcesoCrearEtiquetasCodigoBarras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoCrearEtiquetasCodigoBarras() {
		return this.resaltaridProcesoCrearEtiquetasCodigoBarras;
	}

	public void setResaltaridProcesoCrearEtiquetasCodigoBarras(Border borderResaltar) {
		this.resaltaridProcesoCrearEtiquetasCodigoBarras= borderResaltar;
	}

	public Boolean getMostraridProcesoCrearEtiquetasCodigoBarras() {
		return this.mostraridProcesoCrearEtiquetasCodigoBarras;
	}

	public void setMostraridProcesoCrearEtiquetasCodigoBarras(Boolean mostraridProcesoCrearEtiquetasCodigoBarras) {
		this.mostraridProcesoCrearEtiquetasCodigoBarras= mostraridProcesoCrearEtiquetasCodigoBarras;
	}

	public Boolean getActivaridProcesoCrearEtiquetasCodigoBarras() {
		return this.activaridProcesoCrearEtiquetasCodigoBarras;
	}

	public void setActivaridProcesoCrearEtiquetasCodigoBarras(Boolean activaridProcesoCrearEtiquetasCodigoBarras) {
		this.activaridProcesoCrearEtiquetasCodigoBarras= activaridProcesoCrearEtiquetasCodigoBarras;
	}

	public Border setResaltarid_bodegaProcesoCrearEtiquetasCodigoBarras(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasCodigoBarrasBeanSwingJInternalFrame procesocrearetiquetascodigobarrasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetascodigobarrasBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasCodigoBarras.setBorder(borderResaltar);
		
		this.resaltarid_bodegaProcesoCrearEtiquetasCodigoBarras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaProcesoCrearEtiquetasCodigoBarras() {
		return this.resaltarid_bodegaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setResaltarid_bodegaProcesoCrearEtiquetasCodigoBarras(Border borderResaltar) {
		this.resaltarid_bodegaProcesoCrearEtiquetasCodigoBarras= borderResaltar;
	}

	public Boolean getMostrarid_bodegaProcesoCrearEtiquetasCodigoBarras() {
		return this.mostrarid_bodegaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setMostrarid_bodegaProcesoCrearEtiquetasCodigoBarras(Boolean mostrarid_bodegaProcesoCrearEtiquetasCodigoBarras) {
		this.mostrarid_bodegaProcesoCrearEtiquetasCodigoBarras= mostrarid_bodegaProcesoCrearEtiquetasCodigoBarras;
	}

	public Boolean getActivarid_bodegaProcesoCrearEtiquetasCodigoBarras() {
		return this.activarid_bodegaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setActivarid_bodegaProcesoCrearEtiquetasCodigoBarras(Boolean activarid_bodegaProcesoCrearEtiquetasCodigoBarras) {
		this.activarid_bodegaProcesoCrearEtiquetasCodigoBarras= activarid_bodegaProcesoCrearEtiquetasCodigoBarras;
	}

	public Boolean getCargarid_bodegaProcesoCrearEtiquetasCodigoBarras() {
		return this.cargarid_bodegaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setCargarid_bodegaProcesoCrearEtiquetasCodigoBarras(Boolean cargarid_bodegaProcesoCrearEtiquetasCodigoBarras) {
		this.cargarid_bodegaProcesoCrearEtiquetasCodigoBarras= cargarid_bodegaProcesoCrearEtiquetasCodigoBarras;
	}

	public Border setResaltarid_productoProcesoCrearEtiquetasCodigoBarras(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasCodigoBarrasBeanSwingJInternalFrame procesocrearetiquetascodigobarrasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetascodigobarrasBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasCodigoBarras.setBorder(borderResaltar);
		
		this.resaltarid_productoProcesoCrearEtiquetasCodigoBarras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProcesoCrearEtiquetasCodigoBarras() {
		return this.resaltarid_productoProcesoCrearEtiquetasCodigoBarras;
	}

	public void setResaltarid_productoProcesoCrearEtiquetasCodigoBarras(Border borderResaltar) {
		this.resaltarid_productoProcesoCrearEtiquetasCodigoBarras= borderResaltar;
	}

	public Boolean getMostrarid_productoProcesoCrearEtiquetasCodigoBarras() {
		return this.mostrarid_productoProcesoCrearEtiquetasCodigoBarras;
	}

	public void setMostrarid_productoProcesoCrearEtiquetasCodigoBarras(Boolean mostrarid_productoProcesoCrearEtiquetasCodigoBarras) {
		this.mostrarid_productoProcesoCrearEtiquetasCodigoBarras= mostrarid_productoProcesoCrearEtiquetasCodigoBarras;
	}

	public Boolean getActivarid_productoProcesoCrearEtiquetasCodigoBarras() {
		return this.activarid_productoProcesoCrearEtiquetasCodigoBarras;
	}

	public void setActivarid_productoProcesoCrearEtiquetasCodigoBarras(Boolean activarid_productoProcesoCrearEtiquetasCodigoBarras) {
		this.activarid_productoProcesoCrearEtiquetasCodigoBarras= activarid_productoProcesoCrearEtiquetasCodigoBarras;
	}

	public Boolean getCargarid_productoProcesoCrearEtiquetasCodigoBarras() {
		return this.cargarid_productoProcesoCrearEtiquetasCodigoBarras;
	}

	public void setCargarid_productoProcesoCrearEtiquetasCodigoBarras(Boolean cargarid_productoProcesoCrearEtiquetasCodigoBarras) {
		this.cargarid_productoProcesoCrearEtiquetasCodigoBarras= cargarid_productoProcesoCrearEtiquetasCodigoBarras;
	}

	public Border setResaltarid_empresaProcesoCrearEtiquetasCodigoBarras(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasCodigoBarrasBeanSwingJInternalFrame procesocrearetiquetascodigobarrasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetascodigobarrasBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasCodigoBarras.setBorder(borderResaltar);
		
		this.resaltarid_empresaProcesoCrearEtiquetasCodigoBarras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProcesoCrearEtiquetasCodigoBarras() {
		return this.resaltarid_empresaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setResaltarid_empresaProcesoCrearEtiquetasCodigoBarras(Border borderResaltar) {
		this.resaltarid_empresaProcesoCrearEtiquetasCodigoBarras= borderResaltar;
	}

	public Boolean getMostrarid_empresaProcesoCrearEtiquetasCodigoBarras() {
		return this.mostrarid_empresaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setMostrarid_empresaProcesoCrearEtiquetasCodigoBarras(Boolean mostrarid_empresaProcesoCrearEtiquetasCodigoBarras) {
		this.mostrarid_empresaProcesoCrearEtiquetasCodigoBarras= mostrarid_empresaProcesoCrearEtiquetasCodigoBarras;
	}

	public Boolean getActivarid_empresaProcesoCrearEtiquetasCodigoBarras() {
		return this.activarid_empresaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setActivarid_empresaProcesoCrearEtiquetasCodigoBarras(Boolean activarid_empresaProcesoCrearEtiquetasCodigoBarras) {
		this.activarid_empresaProcesoCrearEtiquetasCodigoBarras= activarid_empresaProcesoCrearEtiquetasCodigoBarras;
	}

	public Boolean getCargarid_empresaProcesoCrearEtiquetasCodigoBarras() {
		return this.cargarid_empresaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setCargarid_empresaProcesoCrearEtiquetasCodigoBarras(Boolean cargarid_empresaProcesoCrearEtiquetasCodigoBarras) {
		this.cargarid_empresaProcesoCrearEtiquetasCodigoBarras= cargarid_empresaProcesoCrearEtiquetasCodigoBarras;
	}

	public Border setResaltarid_sucursalProcesoCrearEtiquetasCodigoBarras(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasCodigoBarrasBeanSwingJInternalFrame procesocrearetiquetascodigobarrasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetascodigobarrasBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasCodigoBarras.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProcesoCrearEtiquetasCodigoBarras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProcesoCrearEtiquetasCodigoBarras() {
		return this.resaltarid_sucursalProcesoCrearEtiquetasCodigoBarras;
	}

	public void setResaltarid_sucursalProcesoCrearEtiquetasCodigoBarras(Border borderResaltar) {
		this.resaltarid_sucursalProcesoCrearEtiquetasCodigoBarras= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProcesoCrearEtiquetasCodigoBarras() {
		return this.mostrarid_sucursalProcesoCrearEtiquetasCodigoBarras;
	}

	public void setMostrarid_sucursalProcesoCrearEtiquetasCodigoBarras(Boolean mostrarid_sucursalProcesoCrearEtiquetasCodigoBarras) {
		this.mostrarid_sucursalProcesoCrearEtiquetasCodigoBarras= mostrarid_sucursalProcesoCrearEtiquetasCodigoBarras;
	}

	public Boolean getActivarid_sucursalProcesoCrearEtiquetasCodigoBarras() {
		return this.activarid_sucursalProcesoCrearEtiquetasCodigoBarras;
	}

	public void setActivarid_sucursalProcesoCrearEtiquetasCodigoBarras(Boolean activarid_sucursalProcesoCrearEtiquetasCodigoBarras) {
		this.activarid_sucursalProcesoCrearEtiquetasCodigoBarras= activarid_sucursalProcesoCrearEtiquetasCodigoBarras;
	}

	public Boolean getCargarid_sucursalProcesoCrearEtiquetasCodigoBarras() {
		return this.cargarid_sucursalProcesoCrearEtiquetasCodigoBarras;
	}

	public void setCargarid_sucursalProcesoCrearEtiquetasCodigoBarras(Boolean cargarid_sucursalProcesoCrearEtiquetasCodigoBarras) {
		this.cargarid_sucursalProcesoCrearEtiquetasCodigoBarras= cargarid_sucursalProcesoCrearEtiquetasCodigoBarras;
	}

	public Border setResaltarid_lineaProcesoCrearEtiquetasCodigoBarras(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasCodigoBarrasBeanSwingJInternalFrame procesocrearetiquetascodigobarrasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetascodigobarrasBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasCodigoBarras.setBorder(borderResaltar);
		
		this.resaltarid_lineaProcesoCrearEtiquetasCodigoBarras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaProcesoCrearEtiquetasCodigoBarras() {
		return this.resaltarid_lineaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setResaltarid_lineaProcesoCrearEtiquetasCodigoBarras(Border borderResaltar) {
		this.resaltarid_lineaProcesoCrearEtiquetasCodigoBarras= borderResaltar;
	}

	public Boolean getMostrarid_lineaProcesoCrearEtiquetasCodigoBarras() {
		return this.mostrarid_lineaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setMostrarid_lineaProcesoCrearEtiquetasCodigoBarras(Boolean mostrarid_lineaProcesoCrearEtiquetasCodigoBarras) {
		this.mostrarid_lineaProcesoCrearEtiquetasCodigoBarras= mostrarid_lineaProcesoCrearEtiquetasCodigoBarras;
	}

	public Boolean getActivarid_lineaProcesoCrearEtiquetasCodigoBarras() {
		return this.activarid_lineaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setActivarid_lineaProcesoCrearEtiquetasCodigoBarras(Boolean activarid_lineaProcesoCrearEtiquetasCodigoBarras) {
		this.activarid_lineaProcesoCrearEtiquetasCodigoBarras= activarid_lineaProcesoCrearEtiquetasCodigoBarras;
	}

	public Boolean getCargarid_lineaProcesoCrearEtiquetasCodigoBarras() {
		return this.cargarid_lineaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setCargarid_lineaProcesoCrearEtiquetasCodigoBarras(Boolean cargarid_lineaProcesoCrearEtiquetasCodigoBarras) {
		this.cargarid_lineaProcesoCrearEtiquetasCodigoBarras= cargarid_lineaProcesoCrearEtiquetasCodigoBarras;
	}

	public Border setResaltarid_linea_grupoProcesoCrearEtiquetasCodigoBarras(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasCodigoBarrasBeanSwingJInternalFrame procesocrearetiquetascodigobarrasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetascodigobarrasBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasCodigoBarras.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoProcesoCrearEtiquetasCodigoBarras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoProcesoCrearEtiquetasCodigoBarras() {
		return this.resaltarid_linea_grupoProcesoCrearEtiquetasCodigoBarras;
	}

	public void setResaltarid_linea_grupoProcesoCrearEtiquetasCodigoBarras(Border borderResaltar) {
		this.resaltarid_linea_grupoProcesoCrearEtiquetasCodigoBarras= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoProcesoCrearEtiquetasCodigoBarras() {
		return this.mostrarid_linea_grupoProcesoCrearEtiquetasCodigoBarras;
	}

	public void setMostrarid_linea_grupoProcesoCrearEtiquetasCodigoBarras(Boolean mostrarid_linea_grupoProcesoCrearEtiquetasCodigoBarras) {
		this.mostrarid_linea_grupoProcesoCrearEtiquetasCodigoBarras= mostrarid_linea_grupoProcesoCrearEtiquetasCodigoBarras;
	}

	public Boolean getActivarid_linea_grupoProcesoCrearEtiquetasCodigoBarras() {
		return this.activarid_linea_grupoProcesoCrearEtiquetasCodigoBarras;
	}

	public void setActivarid_linea_grupoProcesoCrearEtiquetasCodigoBarras(Boolean activarid_linea_grupoProcesoCrearEtiquetasCodigoBarras) {
		this.activarid_linea_grupoProcesoCrearEtiquetasCodigoBarras= activarid_linea_grupoProcesoCrearEtiquetasCodigoBarras;
	}

	public Boolean getCargarid_linea_grupoProcesoCrearEtiquetasCodigoBarras() {
		return this.cargarid_linea_grupoProcesoCrearEtiquetasCodigoBarras;
	}

	public void setCargarid_linea_grupoProcesoCrearEtiquetasCodigoBarras(Boolean cargarid_linea_grupoProcesoCrearEtiquetasCodigoBarras) {
		this.cargarid_linea_grupoProcesoCrearEtiquetasCodigoBarras= cargarid_linea_grupoProcesoCrearEtiquetasCodigoBarras;
	}

	public Border setResaltarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasCodigoBarrasBeanSwingJInternalFrame procesocrearetiquetascodigobarrasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetascodigobarrasBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasCodigoBarras.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras() {
		return this.resaltarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setResaltarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras(Border borderResaltar) {
		this.resaltarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras() {
		return this.mostrarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setMostrarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras(Boolean mostrarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras) {
		this.mostrarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras= mostrarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras;
	}

	public Boolean getActivarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras() {
		return this.activarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setActivarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras(Boolean activarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras) {
		this.activarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras= activarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras;
	}

	public Boolean getCargarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras() {
		return this.cargarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setCargarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras(Boolean cargarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras) {
		this.cargarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras= cargarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras;
	}

	public Border setResaltarid_linea_marcaProcesoCrearEtiquetasCodigoBarras(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasCodigoBarrasBeanSwingJInternalFrame procesocrearetiquetascodigobarrasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetascodigobarrasBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasCodigoBarras.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaProcesoCrearEtiquetasCodigoBarras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaProcesoCrearEtiquetasCodigoBarras() {
		return this.resaltarid_linea_marcaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setResaltarid_linea_marcaProcesoCrearEtiquetasCodigoBarras(Border borderResaltar) {
		this.resaltarid_linea_marcaProcesoCrearEtiquetasCodigoBarras= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaProcesoCrearEtiquetasCodigoBarras() {
		return this.mostrarid_linea_marcaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setMostrarid_linea_marcaProcesoCrearEtiquetasCodigoBarras(Boolean mostrarid_linea_marcaProcesoCrearEtiquetasCodigoBarras) {
		this.mostrarid_linea_marcaProcesoCrearEtiquetasCodigoBarras= mostrarid_linea_marcaProcesoCrearEtiquetasCodigoBarras;
	}

	public Boolean getActivarid_linea_marcaProcesoCrearEtiquetasCodigoBarras() {
		return this.activarid_linea_marcaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setActivarid_linea_marcaProcesoCrearEtiquetasCodigoBarras(Boolean activarid_linea_marcaProcesoCrearEtiquetasCodigoBarras) {
		this.activarid_linea_marcaProcesoCrearEtiquetasCodigoBarras= activarid_linea_marcaProcesoCrearEtiquetasCodigoBarras;
	}

	public Boolean getCargarid_linea_marcaProcesoCrearEtiquetasCodigoBarras() {
		return this.cargarid_linea_marcaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setCargarid_linea_marcaProcesoCrearEtiquetasCodigoBarras(Boolean cargarid_linea_marcaProcesoCrearEtiquetasCodigoBarras) {
		this.cargarid_linea_marcaProcesoCrearEtiquetasCodigoBarras= cargarid_linea_marcaProcesoCrearEtiquetasCodigoBarras;
	}

	public Border setResaltarcodigoProcesoCrearEtiquetasCodigoBarras(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasCodigoBarrasBeanSwingJInternalFrame procesocrearetiquetascodigobarrasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetascodigobarrasBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasCodigoBarras.setBorder(borderResaltar);
		
		this.resaltarcodigoProcesoCrearEtiquetasCodigoBarras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoProcesoCrearEtiquetasCodigoBarras() {
		return this.resaltarcodigoProcesoCrearEtiquetasCodigoBarras;
	}

	public void setResaltarcodigoProcesoCrearEtiquetasCodigoBarras(Border borderResaltar) {
		this.resaltarcodigoProcesoCrearEtiquetasCodigoBarras= borderResaltar;
	}

	public Boolean getMostrarcodigoProcesoCrearEtiquetasCodigoBarras() {
		return this.mostrarcodigoProcesoCrearEtiquetasCodigoBarras;
	}

	public void setMostrarcodigoProcesoCrearEtiquetasCodigoBarras(Boolean mostrarcodigoProcesoCrearEtiquetasCodigoBarras) {
		this.mostrarcodigoProcesoCrearEtiquetasCodigoBarras= mostrarcodigoProcesoCrearEtiquetasCodigoBarras;
	}

	public Boolean getActivarcodigoProcesoCrearEtiquetasCodigoBarras() {
		return this.activarcodigoProcesoCrearEtiquetasCodigoBarras;
	}

	public void setActivarcodigoProcesoCrearEtiquetasCodigoBarras(Boolean activarcodigoProcesoCrearEtiquetasCodigoBarras) {
		this.activarcodigoProcesoCrearEtiquetasCodigoBarras= activarcodigoProcesoCrearEtiquetasCodigoBarras;
	}

	public Border setResaltarnombreProcesoCrearEtiquetasCodigoBarras(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasCodigoBarrasBeanSwingJInternalFrame procesocrearetiquetascodigobarrasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetascodigobarrasBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasCodigoBarras.setBorder(borderResaltar);
		
		this.resaltarnombreProcesoCrearEtiquetasCodigoBarras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreProcesoCrearEtiquetasCodigoBarras() {
		return this.resaltarnombreProcesoCrearEtiquetasCodigoBarras;
	}

	public void setResaltarnombreProcesoCrearEtiquetasCodigoBarras(Border borderResaltar) {
		this.resaltarnombreProcesoCrearEtiquetasCodigoBarras= borderResaltar;
	}

	public Boolean getMostrarnombreProcesoCrearEtiquetasCodigoBarras() {
		return this.mostrarnombreProcesoCrearEtiquetasCodigoBarras;
	}

	public void setMostrarnombreProcesoCrearEtiquetasCodigoBarras(Boolean mostrarnombreProcesoCrearEtiquetasCodigoBarras) {
		this.mostrarnombreProcesoCrearEtiquetasCodigoBarras= mostrarnombreProcesoCrearEtiquetasCodigoBarras;
	}

	public Boolean getActivarnombreProcesoCrearEtiquetasCodigoBarras() {
		return this.activarnombreProcesoCrearEtiquetasCodigoBarras;
	}

	public void setActivarnombreProcesoCrearEtiquetasCodigoBarras(Boolean activarnombreProcesoCrearEtiquetasCodigoBarras) {
		this.activarnombreProcesoCrearEtiquetasCodigoBarras= activarnombreProcesoCrearEtiquetasCodigoBarras;
	}

	public Border setResaltarprecioProcesoCrearEtiquetasCodigoBarras(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasCodigoBarrasBeanSwingJInternalFrame procesocrearetiquetascodigobarrasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetascodigobarrasBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasCodigoBarras.setBorder(borderResaltar);
		
		this.resaltarprecioProcesoCrearEtiquetasCodigoBarras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioProcesoCrearEtiquetasCodigoBarras() {
		return this.resaltarprecioProcesoCrearEtiquetasCodigoBarras;
	}

	public void setResaltarprecioProcesoCrearEtiquetasCodigoBarras(Border borderResaltar) {
		this.resaltarprecioProcesoCrearEtiquetasCodigoBarras= borderResaltar;
	}

	public Boolean getMostrarprecioProcesoCrearEtiquetasCodigoBarras() {
		return this.mostrarprecioProcesoCrearEtiquetasCodigoBarras;
	}

	public void setMostrarprecioProcesoCrearEtiquetasCodigoBarras(Boolean mostrarprecioProcesoCrearEtiquetasCodigoBarras) {
		this.mostrarprecioProcesoCrearEtiquetasCodigoBarras= mostrarprecioProcesoCrearEtiquetasCodigoBarras;
	}

	public Boolean getActivarprecioProcesoCrearEtiquetasCodigoBarras() {
		return this.activarprecioProcesoCrearEtiquetasCodigoBarras;
	}

	public void setActivarprecioProcesoCrearEtiquetasCodigoBarras(Boolean activarprecioProcesoCrearEtiquetasCodigoBarras) {
		this.activarprecioProcesoCrearEtiquetasCodigoBarras= activarprecioProcesoCrearEtiquetasCodigoBarras;
	}

	public Border setResaltarnumeroProcesoCrearEtiquetasCodigoBarras(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasCodigoBarrasBeanSwingJInternalFrame procesocrearetiquetascodigobarrasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetascodigobarrasBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasCodigoBarras.setBorder(borderResaltar);
		
		this.resaltarnumeroProcesoCrearEtiquetasCodigoBarras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroProcesoCrearEtiquetasCodigoBarras() {
		return this.resaltarnumeroProcesoCrearEtiquetasCodigoBarras;
	}

	public void setResaltarnumeroProcesoCrearEtiquetasCodigoBarras(Border borderResaltar) {
		this.resaltarnumeroProcesoCrearEtiquetasCodigoBarras= borderResaltar;
	}

	public Boolean getMostrarnumeroProcesoCrearEtiquetasCodigoBarras() {
		return this.mostrarnumeroProcesoCrearEtiquetasCodigoBarras;
	}

	public void setMostrarnumeroProcesoCrearEtiquetasCodigoBarras(Boolean mostrarnumeroProcesoCrearEtiquetasCodigoBarras) {
		this.mostrarnumeroProcesoCrearEtiquetasCodigoBarras= mostrarnumeroProcesoCrearEtiquetasCodigoBarras;
	}

	public Boolean getActivarnumeroProcesoCrearEtiquetasCodigoBarras() {
		return this.activarnumeroProcesoCrearEtiquetasCodigoBarras;
	}

	public void setActivarnumeroProcesoCrearEtiquetasCodigoBarras(Boolean activarnumeroProcesoCrearEtiquetasCodigoBarras) {
		this.activarnumeroProcesoCrearEtiquetasCodigoBarras= activarnumeroProcesoCrearEtiquetasCodigoBarras;
	}

	public Border setResaltartallaProcesoCrearEtiquetasCodigoBarras(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasCodigoBarrasBeanSwingJInternalFrame procesocrearetiquetascodigobarrasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocrearetiquetascodigobarrasBeanSwingJInternalFrame.jTtoolBarProcesoCrearEtiquetasCodigoBarras.setBorder(borderResaltar);
		
		this.resaltartallaProcesoCrearEtiquetasCodigoBarras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartallaProcesoCrearEtiquetasCodigoBarras() {
		return this.resaltartallaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setResaltartallaProcesoCrearEtiquetasCodigoBarras(Border borderResaltar) {
		this.resaltartallaProcesoCrearEtiquetasCodigoBarras= borderResaltar;
	}

	public Boolean getMostrartallaProcesoCrearEtiquetasCodigoBarras() {
		return this.mostrartallaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setMostrartallaProcesoCrearEtiquetasCodigoBarras(Boolean mostrartallaProcesoCrearEtiquetasCodigoBarras) {
		this.mostrartallaProcesoCrearEtiquetasCodigoBarras= mostrartallaProcesoCrearEtiquetasCodigoBarras;
	}

	public Boolean getActivartallaProcesoCrearEtiquetasCodigoBarras() {
		return this.activartallaProcesoCrearEtiquetasCodigoBarras;
	}

	public void setActivartallaProcesoCrearEtiquetasCodigoBarras(Boolean activartallaProcesoCrearEtiquetasCodigoBarras) {
		this.activartallaProcesoCrearEtiquetasCodigoBarras= activartallaProcesoCrearEtiquetasCodigoBarras;
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
		
		
		this.setMostraridProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setMostrarid_bodegaProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setMostrarid_productoProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setMostrarid_empresaProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setMostrarid_sucursalProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setMostrarid_lineaProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setMostrarid_linea_grupoProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setMostrarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setMostrarid_linea_marcaProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setMostrarcodigoProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setMostrarnombreProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setMostrarprecioProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setMostrarnumeroProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setMostrartallaProcesoCrearEtiquetasCodigoBarras(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.ID)) {
				this.setMostraridProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.PRECIO)) {
				this.setMostrarprecioProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TALLA)) {
				this.setMostrartallaProcesoCrearEtiquetasCodigoBarras(esAsigna);
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
		
		
		this.setActivaridProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setActivarid_bodegaProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setActivarid_productoProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setActivarid_empresaProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setActivarid_sucursalProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setActivarid_lineaProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setActivarid_linea_grupoProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setActivarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setActivarid_linea_marcaProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setActivarcodigoProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setActivarnombreProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setActivarprecioProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setActivarnumeroProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setActivartallaProcesoCrearEtiquetasCodigoBarras(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.ID)) {
				this.setActivaridProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.CODIGO)) {
				this.setActivarcodigoProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.NOMBRE)) {
				this.setActivarnombreProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.PRECIO)) {
				this.setActivarprecioProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.NUMERO)) {
				this.setActivarnumeroProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TALLA)) {
				this.setActivartallaProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoCrearEtiquetasCodigoBarrasBeanSwingJInternalFrame procesocrearetiquetascodigobarrasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setResaltarid_bodegaProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setResaltarid_productoProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setResaltarid_empresaProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setResaltarid_sucursalProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setResaltarid_lineaProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setResaltarid_linea_grupoProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setResaltarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setResaltarid_linea_marcaProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setResaltarcodigoProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setResaltarnombreProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setResaltarprecioProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setResaltarnumeroProcesoCrearEtiquetasCodigoBarras(esInicial);
		this.setResaltartallaProcesoCrearEtiquetasCodigoBarras(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.ID)) {
				this.setResaltaridProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.PRECIO)) {
				this.setResaltarprecioProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroProcesoCrearEtiquetasCodigoBarras(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCrearEtiquetasCodigoBarrasConstantesFunciones.TALLA)) {
				this.setResaltartallaProcesoCrearEtiquetasCodigoBarras(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoCrearEtiquetasCodigoBarrasBeanSwingJInternalFrame procesocrearetiquetascodigobarrasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoCrearEtiquetasCodigoBarrasProcesoCrearEtiquetasCodigoBarras=true;

	public Boolean getMostrarBusquedaProcesoCrearEtiquetasCodigoBarrasProcesoCrearEtiquetasCodigoBarras() {
		return this.mostrarBusquedaProcesoCrearEtiquetasCodigoBarrasProcesoCrearEtiquetasCodigoBarras;
	}

	public void setMostrarBusquedaProcesoCrearEtiquetasCodigoBarrasProcesoCrearEtiquetasCodigoBarras(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoCrearEtiquetasCodigoBarrasProcesoCrearEtiquetasCodigoBarras= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoCrearEtiquetasCodigoBarrasProcesoCrearEtiquetasCodigoBarras=true;

	public Boolean getActivarBusquedaProcesoCrearEtiquetasCodigoBarrasProcesoCrearEtiquetasCodigoBarras() {
		return this.activarBusquedaProcesoCrearEtiquetasCodigoBarrasProcesoCrearEtiquetasCodigoBarras;
	}

	public void setActivarBusquedaProcesoCrearEtiquetasCodigoBarrasProcesoCrearEtiquetasCodigoBarras(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoCrearEtiquetasCodigoBarrasProcesoCrearEtiquetasCodigoBarras= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoCrearEtiquetasCodigoBarrasProcesoCrearEtiquetasCodigoBarras=null;

	public Border getResaltarBusquedaProcesoCrearEtiquetasCodigoBarrasProcesoCrearEtiquetasCodigoBarras() {
		return this.resaltarBusquedaProcesoCrearEtiquetasCodigoBarrasProcesoCrearEtiquetasCodigoBarras;
	}

	public void setResaltarBusquedaProcesoCrearEtiquetasCodigoBarrasProcesoCrearEtiquetasCodigoBarras(Border borderResaltar) {
		this.resaltarBusquedaProcesoCrearEtiquetasCodigoBarrasProcesoCrearEtiquetasCodigoBarras= borderResaltar;
	}

	public void setResaltarBusquedaProcesoCrearEtiquetasCodigoBarrasProcesoCrearEtiquetasCodigoBarras(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCrearEtiquetasCodigoBarrasBeanSwingJInternalFrame procesocrearetiquetascodigobarrasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoCrearEtiquetasCodigoBarrasProcesoCrearEtiquetasCodigoBarras= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}