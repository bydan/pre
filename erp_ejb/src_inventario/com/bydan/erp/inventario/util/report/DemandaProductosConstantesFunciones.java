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


import com.bydan.erp.inventario.util.report.DemandaProductosConstantesFunciones;
import com.bydan.erp.inventario.util.report.DemandaProductosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.DemandaProductosParameterGeneral;

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
final public class DemandaProductosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="DemandaProductos";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DemandaProductos"+DemandaProductosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DemandaProductosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DemandaProductosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DemandaProductosConstantesFunciones.SCHEMA+"_"+DemandaProductosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DemandaProductosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DemandaProductosConstantesFunciones.SCHEMA+"_"+DemandaProductosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DemandaProductosConstantesFunciones.SCHEMA+"_"+DemandaProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DemandaProductosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DemandaProductosConstantesFunciones.SCHEMA+"_"+DemandaProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DemandaProductosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DemandaProductosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DemandaProductosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DemandaProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DemandaProductosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DemandaProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DemandaProductosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DemandaProductosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DemandaProductosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DemandaProductosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Demanda Productoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Demanda Productos";
	public static final String SCLASSWEBTITULO_LOWER="Demanda Productos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DemandaProductos";
	public static final String OBJECTNAME="demandaproductos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="demanda_productos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select demandaproductos from "+DemandaProductosConstantesFunciones.SPERSISTENCENAME+" demandaproductos";
	public static String QUERYSELECTNATIVE="select "+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".id,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".version_row,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".id_bodega,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".id_producto,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".id_empresa,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".id_sucursal,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".id_linea,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".id_linea_grupo,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".id_linea_categoria,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".id_linea_marca,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".fecha_ultima_venta_hasta,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".codigo,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".nombre_unidad,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".cantidad_disponible,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".stock_minimo,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".codigo_producto,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".nombre,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".dem_tri,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".dem_bi,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".dem_men,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".ingresos,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".egresos,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".existencia,"+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME+".costo from "+DemandaProductosConstantesFunciones.SCHEMA+"."+DemandaProductosConstantesFunciones.TABLENAME;//+" as "+DemandaProductosConstantesFunciones.TABLENAME;
	
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
    public static final String FECHAULTIMAVENTAHASTA= "fecha_ultima_venta_hasta";
    public static final String CODIGO= "codigo";
    public static final String NOMBREUNIDAD= "nombre_unidad";
    public static final String CANTIDADDISPONIBLE= "cantidad_disponible";
    public static final String STOCKMINIMO= "stock_minimo";
    public static final String CODIGOPRODUCTO= "codigo_producto";
    public static final String NOMBRE= "nombre";
    public static final String DEMTRI= "dem_tri";
    public static final String DEMBI= "dem_bi";
    public static final String DEMMEN= "dem_men";
    public static final String INGRESOS= "ingresos";
    public static final String EGRESOS= "egresos";
    public static final String EXISTENCIA= "existencia";
    public static final String COSTO= "costo";
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
    	public static final String LABEL_FECHAULTIMAVENTAHASTA= "Fecha Ultima Venta Hasta";
		public static final String LABEL_FECHAULTIMAVENTAHASTA_LOWER= "Fecha Ultima Venta Hasta";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBREUNIDAD= "Nombre Unidad";
		public static final String LABEL_NOMBREUNIDAD_LOWER= "Nombre Unidad";
    	public static final String LABEL_CANTIDADDISPONIBLE= "Cantidad Disponible";
		public static final String LABEL_CANTIDADDISPONIBLE_LOWER= "Cantidad Disponible";
    	public static final String LABEL_STOCKMINIMO= "Stock Minimo";
		public static final String LABEL_STOCKMINIMO_LOWER= "Stock Minimo";
    	public static final String LABEL_CODIGOPRODUCTO= "Codigo Producto";
		public static final String LABEL_CODIGOPRODUCTO_LOWER= "Codigo Producto";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DEMTRI= "Dem Tri";
		public static final String LABEL_DEMTRI_LOWER= "Dem Tri";
    	public static final String LABEL_DEMBI= "Dem Bi";
		public static final String LABEL_DEMBI_LOWER= "Dem Bi";
    	public static final String LABEL_DEMMEN= "Dem Men";
		public static final String LABEL_DEMMEN_LOWER= "Dem Men";
    	public static final String LABEL_INGRESOS= "Ingresos";
		public static final String LABEL_INGRESOS_LOWER= "Ingresos";
    	public static final String LABEL_EGRESOS= "Egresos";
		public static final String LABEL_EGRESOS_LOWER= "Egresos";
    	public static final String LABEL_EXISTENCIA= "Existencia";
		public static final String LABEL_EXISTENCIA_LOWER= "Existencia";
    	public static final String LABEL_COSTO= "Costo";
		public static final String LABEL_COSTO_LOWER= "Costo";
	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_UNIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_UNIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXCODIGO_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	
	public static String getDemandaProductosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DemandaProductosConstantesFunciones.IDBODEGA)) {sLabelColumna=DemandaProductosConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DemandaProductosConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DemandaProductosConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DemandaProductosConstantesFunciones.IDEMPRESA)) {sLabelColumna=DemandaProductosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DemandaProductosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DemandaProductosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DemandaProductosConstantesFunciones.IDLINEA)) {sLabelColumna=DemandaProductosConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(DemandaProductosConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=DemandaProductosConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(DemandaProductosConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=DemandaProductosConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(DemandaProductosConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=DemandaProductosConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(DemandaProductosConstantesFunciones.FECHAULTIMAVENTAHASTA)) {sLabelColumna=DemandaProductosConstantesFunciones.LABEL_FECHAULTIMAVENTAHASTA;}
		if(sNombreColumna.equals(DemandaProductosConstantesFunciones.CODIGO)) {sLabelColumna=DemandaProductosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(DemandaProductosConstantesFunciones.NOMBREUNIDAD)) {sLabelColumna=DemandaProductosConstantesFunciones.LABEL_NOMBREUNIDAD;}
		if(sNombreColumna.equals(DemandaProductosConstantesFunciones.CANTIDADDISPONIBLE)) {sLabelColumna=DemandaProductosConstantesFunciones.LABEL_CANTIDADDISPONIBLE;}
		if(sNombreColumna.equals(DemandaProductosConstantesFunciones.STOCKMINIMO)) {sLabelColumna=DemandaProductosConstantesFunciones.LABEL_STOCKMINIMO;}
		if(sNombreColumna.equals(DemandaProductosConstantesFunciones.CODIGOPRODUCTO)) {sLabelColumna=DemandaProductosConstantesFunciones.LABEL_CODIGOPRODUCTO;}
		if(sNombreColumna.equals(DemandaProductosConstantesFunciones.NOMBRE)) {sLabelColumna=DemandaProductosConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(DemandaProductosConstantesFunciones.DEMTRI)) {sLabelColumna=DemandaProductosConstantesFunciones.LABEL_DEMTRI;}
		if(sNombreColumna.equals(DemandaProductosConstantesFunciones.DEMBI)) {sLabelColumna=DemandaProductosConstantesFunciones.LABEL_DEMBI;}
		if(sNombreColumna.equals(DemandaProductosConstantesFunciones.DEMMEN)) {sLabelColumna=DemandaProductosConstantesFunciones.LABEL_DEMMEN;}
		if(sNombreColumna.equals(DemandaProductosConstantesFunciones.INGRESOS)) {sLabelColumna=DemandaProductosConstantesFunciones.LABEL_INGRESOS;}
		if(sNombreColumna.equals(DemandaProductosConstantesFunciones.EGRESOS)) {sLabelColumna=DemandaProductosConstantesFunciones.LABEL_EGRESOS;}
		if(sNombreColumna.equals(DemandaProductosConstantesFunciones.EXISTENCIA)) {sLabelColumna=DemandaProductosConstantesFunciones.LABEL_EXISTENCIA;}
		if(sNombreColumna.equals(DemandaProductosConstantesFunciones.COSTO)) {sLabelColumna=DemandaProductosConstantesFunciones.LABEL_COSTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDemandaProductosDescripcion(DemandaProductos demandaproductos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(demandaproductos !=null/* && demandaproductos.getId()!=0*/) {
			sDescripcion=demandaproductos.getcodigo();//demandaproductosdemandaproductos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getDemandaProductosDescripcionDetallado(DemandaProductos demandaproductos) {
		String sDescripcion="";
			
		sDescripcion+=DemandaProductosConstantesFunciones.ID+"=";
		sDescripcion+=demandaproductos.getId().toString()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=demandaproductos.getVersionRow().toString()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=demandaproductos.getid_bodega().toString()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=demandaproductos.getid_producto().toString()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=demandaproductos.getid_empresa().toString()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=demandaproductos.getid_sucursal().toString()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.IDLINEA+"=";
		sDescripcion+=demandaproductos.getid_linea().toString()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=demandaproductos.getid_linea_grupo().toString()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=demandaproductos.getid_linea_categoria().toString()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=demandaproductos.getid_linea_marca().toString()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.FECHAULTIMAVENTAHASTA+"=";
		sDescripcion+=demandaproductos.getfecha_ultima_venta_hasta().toString()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.CODIGO+"=";
		sDescripcion+=demandaproductos.getcodigo()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.NOMBREUNIDAD+"=";
		sDescripcion+=demandaproductos.getnombre_unidad()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.CANTIDADDISPONIBLE+"=";
		sDescripcion+=demandaproductos.getcantidad_disponible().toString()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.STOCKMINIMO+"=";
		sDescripcion+=demandaproductos.getstock_minimo().toString()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.CODIGOPRODUCTO+"=";
		sDescripcion+=demandaproductos.getcodigo_producto()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.NOMBRE+"=";
		sDescripcion+=demandaproductos.getnombre()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.DEMTRI+"=";
		sDescripcion+=demandaproductos.getdem_tri().toString()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.DEMBI+"=";
		sDescripcion+=demandaproductos.getdem_bi().toString()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.DEMMEN+"=";
		sDescripcion+=demandaproductos.getdem_men().toString()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.INGRESOS+"=";
		sDescripcion+=demandaproductos.getingresos().toString()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.EGRESOS+"=";
		sDescripcion+=demandaproductos.getegresos().toString()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.EXISTENCIA+"=";
		sDescripcion+=demandaproductos.getexistencia().toString()+",";
		sDescripcion+=DemandaProductosConstantesFunciones.COSTO+"=";
		sDescripcion+=demandaproductos.getcosto().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDemandaProductosDescripcion(DemandaProductos demandaproductos,String sValor) throws Exception {			
		if(demandaproductos !=null) {
			demandaproductos.setcodigo(sValor);;//demandaproductosdemandaproductos.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaDemandaProductos")) {
			sNombreIndice="Tipo=  Por Bodega Por Producto Por Linea Por Linea Grupo Por Linea Categoria Por Linea Marca Por Fecha Ultima Venta Hasta";
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

	public static String getDetalleIndiceBusquedaDemandaProductos(Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_ultima_venta_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();}
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();}
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();}
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();}
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();}
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();}
		if(fecha_ultima_venta_hasta!=null) {sDetalleIndice+=" Fecha Ultima Venta Hasta="+fecha_ultima_venta_hasta.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosDemandaProductos(DemandaProductos demandaproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		demandaproductos.setcodigo(demandaproductos.getcodigo().trim());
		demandaproductos.setnombre_unidad(demandaproductos.getnombre_unidad().trim());
		demandaproductos.setcodigo_producto(demandaproductos.getcodigo_producto().trim());
		demandaproductos.setnombre(demandaproductos.getnombre().trim());
	}
	
	public static void quitarEspaciosDemandaProductoss(List<DemandaProductos> demandaproductoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DemandaProductos demandaproductos: demandaproductoss) {
			demandaproductos.setcodigo(demandaproductos.getcodigo().trim());
			demandaproductos.setnombre_unidad(demandaproductos.getnombre_unidad().trim());
			demandaproductos.setcodigo_producto(demandaproductos.getcodigo_producto().trim());
			demandaproductos.setnombre(demandaproductos.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDemandaProductos(DemandaProductos demandaproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && demandaproductos.getConCambioAuxiliar()) {
			demandaproductos.setIsDeleted(demandaproductos.getIsDeletedAuxiliar());	
			demandaproductos.setIsNew(demandaproductos.getIsNewAuxiliar());	
			demandaproductos.setIsChanged(demandaproductos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			demandaproductos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			demandaproductos.setIsDeletedAuxiliar(false);	
			demandaproductos.setIsNewAuxiliar(false);	
			demandaproductos.setIsChangedAuxiliar(false);
			
			demandaproductos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDemandaProductoss(List<DemandaProductos> demandaproductoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DemandaProductos demandaproductos : demandaproductoss) {
			if(conAsignarBase && demandaproductos.getConCambioAuxiliar()) {
				demandaproductos.setIsDeleted(demandaproductos.getIsDeletedAuxiliar());	
				demandaproductos.setIsNew(demandaproductos.getIsNewAuxiliar());	
				demandaproductos.setIsChanged(demandaproductos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				demandaproductos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				demandaproductos.setIsDeletedAuxiliar(false);	
				demandaproductos.setIsNewAuxiliar(false);	
				demandaproductos.setIsChangedAuxiliar(false);
				
				demandaproductos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDemandaProductos(DemandaProductos demandaproductos,Boolean conEnteros) throws Exception  {
		demandaproductos.setdem_tri(0.0);
		demandaproductos.setdem_bi(0.0);
		demandaproductos.setdem_men(0.0);
		demandaproductos.setingresos(0.0);
		demandaproductos.setegresos(0.0);
		demandaproductos.setexistencia(0.0);
		demandaproductos.setcosto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			demandaproductos.setcantidad_disponible(0);
			demandaproductos.setstock_minimo(0);
		}
	}		
	
	public static void InicializarValoresDemandaProductoss(List<DemandaProductos> demandaproductoss,Boolean conEnteros) throws Exception  {
		
		for(DemandaProductos demandaproductos: demandaproductoss) {
			demandaproductos.setdem_tri(0.0);
			demandaproductos.setdem_bi(0.0);
			demandaproductos.setdem_men(0.0);
			demandaproductos.setingresos(0.0);
			demandaproductos.setegresos(0.0);
			demandaproductos.setexistencia(0.0);
			demandaproductos.setcosto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				demandaproductos.setcantidad_disponible(0);
				demandaproductos.setstock_minimo(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDemandaProductos(List<DemandaProductos> demandaproductoss,DemandaProductos demandaproductosAux) throws Exception  {
		DemandaProductosConstantesFunciones.InicializarValoresDemandaProductos(demandaproductosAux,true);
		
		for(DemandaProductos demandaproductos: demandaproductoss) {
			if(demandaproductos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			demandaproductosAux.setcantidad_disponible(demandaproductosAux.getcantidad_disponible()+demandaproductos.getcantidad_disponible());			
			demandaproductosAux.setstock_minimo(demandaproductosAux.getstock_minimo()+demandaproductos.getstock_minimo());			
			demandaproductosAux.setdem_tri(demandaproductosAux.getdem_tri()+demandaproductos.getdem_tri());			
			demandaproductosAux.setdem_bi(demandaproductosAux.getdem_bi()+demandaproductos.getdem_bi());			
			demandaproductosAux.setdem_men(demandaproductosAux.getdem_men()+demandaproductos.getdem_men());			
			demandaproductosAux.setingresos(demandaproductosAux.getingresos()+demandaproductos.getingresos());			
			demandaproductosAux.setegresos(demandaproductosAux.getegresos()+demandaproductos.getegresos());			
			demandaproductosAux.setexistencia(demandaproductosAux.getexistencia()+demandaproductos.getexistencia());			
			demandaproductosAux.setcosto(demandaproductosAux.getcosto()+demandaproductos.getcosto());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDemandaProductos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DemandaProductosConstantesFunciones.getArrayColumnasGlobalesDemandaProductos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDemandaProductos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DemandaProductosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DemandaProductosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DemandaProductosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DemandaProductosConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDemandaProductos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DemandaProductos> demandaproductoss,DemandaProductos demandaproductos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DemandaProductos demandaproductosAux: demandaproductoss) {
			if(demandaproductosAux!=null && demandaproductos!=null) {
				if((demandaproductosAux.getId()==null && demandaproductos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(demandaproductosAux.getId()!=null && demandaproductos.getId()!=null){
					if(demandaproductosAux.getId().equals(demandaproductos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDemandaProductos(List<DemandaProductos> demandaproductoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double dem_triTotal=0.0;
		Double dem_biTotal=0.0;
		Double dem_menTotal=0.0;
		Double ingresosTotal=0.0;
		Double egresosTotal=0.0;
		Double existenciaTotal=0.0;
		Double costoTotal=0.0;
	
		for(DemandaProductos demandaproductos: demandaproductoss) {			
			if(demandaproductos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			dem_triTotal+=demandaproductos.getdem_tri();
			dem_biTotal+=demandaproductos.getdem_bi();
			dem_menTotal+=demandaproductos.getdem_men();
			ingresosTotal+=demandaproductos.getingresos();
			egresosTotal+=demandaproductos.getegresos();
			existenciaTotal+=demandaproductos.getexistencia();
			costoTotal+=demandaproductos.getcosto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DemandaProductosConstantesFunciones.DEMTRI);
		datoGeneral.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_DEMTRI);
		datoGeneral.setdValorDouble(dem_triTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DemandaProductosConstantesFunciones.DEMBI);
		datoGeneral.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_DEMBI);
		datoGeneral.setdValorDouble(dem_biTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DemandaProductosConstantesFunciones.DEMMEN);
		datoGeneral.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_DEMMEN);
		datoGeneral.setdValorDouble(dem_menTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DemandaProductosConstantesFunciones.INGRESOS);
		datoGeneral.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_INGRESOS);
		datoGeneral.setdValorDouble(ingresosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DemandaProductosConstantesFunciones.EGRESOS);
		datoGeneral.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_EGRESOS);
		datoGeneral.setdValorDouble(egresosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DemandaProductosConstantesFunciones.EXISTENCIA);
		datoGeneral.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_EXISTENCIA);
		datoGeneral.setdValorDouble(existenciaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DemandaProductosConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDemandaProductos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DemandaProductosConstantesFunciones.LABEL_ID, DemandaProductosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DemandaProductosConstantesFunciones.LABEL_VERSIONROW, DemandaProductosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DemandaProductosConstantesFunciones.LABEL_CODIGO, DemandaProductosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DemandaProductosConstantesFunciones.LABEL_NOMBREUNIDAD, DemandaProductosConstantesFunciones.NOMBREUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DemandaProductosConstantesFunciones.LABEL_CANTIDADDISPONIBLE, DemandaProductosConstantesFunciones.CANTIDADDISPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DemandaProductosConstantesFunciones.LABEL_STOCKMINIMO, DemandaProductosConstantesFunciones.STOCKMINIMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DemandaProductosConstantesFunciones.LABEL_CODIGOPRODUCTO, DemandaProductosConstantesFunciones.CODIGOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DemandaProductosConstantesFunciones.LABEL_NOMBRE, DemandaProductosConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DemandaProductosConstantesFunciones.LABEL_DEMTRI, DemandaProductosConstantesFunciones.DEMTRI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DemandaProductosConstantesFunciones.LABEL_DEMBI, DemandaProductosConstantesFunciones.DEMBI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DemandaProductosConstantesFunciones.LABEL_DEMMEN, DemandaProductosConstantesFunciones.DEMMEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DemandaProductosConstantesFunciones.LABEL_INGRESOS, DemandaProductosConstantesFunciones.INGRESOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DemandaProductosConstantesFunciones.LABEL_EGRESOS, DemandaProductosConstantesFunciones.EGRESOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DemandaProductosConstantesFunciones.LABEL_EXISTENCIA, DemandaProductosConstantesFunciones.EXISTENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DemandaProductosConstantesFunciones.LABEL_COSTO, DemandaProductosConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDemandaProductos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DemandaProductosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DemandaProductosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DemandaProductosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DemandaProductosConstantesFunciones.NOMBREUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DemandaProductosConstantesFunciones.CANTIDADDISPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DemandaProductosConstantesFunciones.STOCKMINIMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DemandaProductosConstantesFunciones.CODIGOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DemandaProductosConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DemandaProductosConstantesFunciones.DEMTRI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DemandaProductosConstantesFunciones.DEMBI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DemandaProductosConstantesFunciones.DEMMEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DemandaProductosConstantesFunciones.INGRESOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DemandaProductosConstantesFunciones.EGRESOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DemandaProductosConstantesFunciones.EXISTENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DemandaProductosConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDemandaProductos() throws Exception  {
		return DemandaProductosConstantesFunciones.getTiposSeleccionarDemandaProductos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDemandaProductos(Boolean conFk) throws Exception  {
		return DemandaProductosConstantesFunciones.getTiposSeleccionarDemandaProductos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDemandaProductos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DemandaProductosConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DemandaProductosConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DemandaProductosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DemandaProductosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DemandaProductosConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DemandaProductosConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DemandaProductosConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DemandaProductosConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DemandaProductosConstantesFunciones.LABEL_FECHAULTIMAVENTAHASTA);
			reporte.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_FECHAULTIMAVENTAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DemandaProductosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DemandaProductosConstantesFunciones.LABEL_NOMBREUNIDAD);
			reporte.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_NOMBREUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DemandaProductosConstantesFunciones.LABEL_CANTIDADDISPONIBLE);
			reporte.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_CANTIDADDISPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DemandaProductosConstantesFunciones.LABEL_STOCKMINIMO);
			reporte.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_STOCKMINIMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DemandaProductosConstantesFunciones.LABEL_CODIGOPRODUCTO);
			reporte.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_CODIGOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DemandaProductosConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DemandaProductosConstantesFunciones.LABEL_DEMTRI);
			reporte.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_DEMTRI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DemandaProductosConstantesFunciones.LABEL_DEMBI);
			reporte.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_DEMBI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DemandaProductosConstantesFunciones.LABEL_DEMMEN);
			reporte.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_DEMMEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DemandaProductosConstantesFunciones.LABEL_INGRESOS);
			reporte.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_INGRESOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DemandaProductosConstantesFunciones.LABEL_EGRESOS);
			reporte.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_EGRESOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DemandaProductosConstantesFunciones.LABEL_EXISTENCIA);
			reporte.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_EXISTENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DemandaProductosConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(DemandaProductosConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDemandaProductos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDemandaProductos(DemandaProductos demandaproductosAux) throws Exception {
		
			demandaproductosAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(demandaproductosAux.getBodega()));
			demandaproductosAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(demandaproductosAux.getProducto()));
			demandaproductosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(demandaproductosAux.getEmpresa()));
			demandaproductosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(demandaproductosAux.getSucursal()));
			demandaproductosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(demandaproductosAux.getLinea()));
			demandaproductosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(demandaproductosAux.getLineaGrupo()));
			demandaproductosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(demandaproductosAux.getLineaCategoria()));
			demandaproductosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(demandaproductosAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDemandaProductos(List<DemandaProductos> demandaproductossTemp) throws Exception {
		for(DemandaProductos demandaproductosAux:demandaproductossTemp) {
			
			demandaproductosAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(demandaproductosAux.getBodega()));
			demandaproductosAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(demandaproductosAux.getProducto()));
			demandaproductosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(demandaproductosAux.getEmpresa()));
			demandaproductosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(demandaproductosAux.getSucursal()));
			demandaproductosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(demandaproductosAux.getLinea()));
			demandaproductosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(demandaproductosAux.getLineaGrupo()));
			demandaproductosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(demandaproductosAux.getLineaCategoria()));
			demandaproductosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(demandaproductosAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDemandaProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDemandaProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDemandaProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DemandaProductosConstantesFunciones.getClassesRelationshipsOfDemandaProductos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDemandaProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDemandaProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DemandaProductosConstantesFunciones.getClassesRelationshipsFromStringsOfDemandaProductos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDemandaProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DemandaProductos demandaproductos,List<DemandaProductos> demandaproductoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(DemandaProductos demandaproductos,List<DemandaProductos> demandaproductoss) throws Exception {
		try	{			
			for(DemandaProductos demandaproductosLocal:demandaproductoss) {
				if(demandaproductosLocal.getId().equals(demandaproductos.getId())) {
					demandaproductosLocal.setIsSelected(demandaproductos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDemandaProductos(List<DemandaProductos> demandaproductossAux) throws Exception {
		//this.demandaproductossAux=demandaproductossAux;
		
		for(DemandaProductos demandaproductosAux:demandaproductossAux) {
			if(demandaproductosAux.getIsChanged()) {
				demandaproductosAux.setIsChanged(false);
			}		
			
			if(demandaproductosAux.getIsNew()) {
				demandaproductosAux.setIsNew(false);
			}	
			
			if(demandaproductosAux.getIsDeleted()) {
				demandaproductosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDemandaProductos(DemandaProductos demandaproductosAux) throws Exception {
		//this.demandaproductosAux=demandaproductosAux;
		
			if(demandaproductosAux.getIsChanged()) {
				demandaproductosAux.setIsChanged(false);
			}		
			
			if(demandaproductosAux.getIsNew()) {
				demandaproductosAux.setIsNew(false);
			}	
			
			if(demandaproductosAux.getIsDeleted()) {
				demandaproductosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DemandaProductos demandaproductosAsignar,DemandaProductos demandaproductos) throws Exception {
		demandaproductosAsignar.setId(demandaproductos.getId());	
		demandaproductosAsignar.setVersionRow(demandaproductos.getVersionRow());	
		demandaproductosAsignar.setcodigo(demandaproductos.getcodigo());	
		demandaproductosAsignar.setnombre_unidad(demandaproductos.getnombre_unidad());	
		demandaproductosAsignar.setcantidad_disponible(demandaproductos.getcantidad_disponible());	
		demandaproductosAsignar.setstock_minimo(demandaproductos.getstock_minimo());	
		demandaproductosAsignar.setcodigo_producto(demandaproductos.getcodigo_producto());	
		demandaproductosAsignar.setnombre(demandaproductos.getnombre());	
		demandaproductosAsignar.setdem_tri(demandaproductos.getdem_tri());	
		demandaproductosAsignar.setdem_bi(demandaproductos.getdem_bi());	
		demandaproductosAsignar.setdem_men(demandaproductos.getdem_men());	
		demandaproductosAsignar.setingresos(demandaproductos.getingresos());	
		demandaproductosAsignar.setegresos(demandaproductos.getegresos());	
		demandaproductosAsignar.setexistencia(demandaproductos.getexistencia());	
		demandaproductosAsignar.setcosto(demandaproductos.getcosto());	
	}
	
	public static void inicializarDemandaProductos(DemandaProductos demandaproductos) throws Exception {
		try {
				demandaproductos.setId(0L);	
					
				demandaproductos.setcodigo("");	
				demandaproductos.setnombre_unidad("");	
				demandaproductos.setcantidad_disponible(0);	
				demandaproductos.setstock_minimo(0);	
				demandaproductos.setcodigo_producto("");	
				demandaproductos.setnombre("");	
				demandaproductos.setdem_tri(0.0);	
				demandaproductos.setdem_bi(0.0);	
				demandaproductos.setdem_men(0.0);	
				demandaproductos.setingresos(0.0);	
				demandaproductos.setegresos(0.0);	
				demandaproductos.setexistencia(0.0);	
				demandaproductos.setcosto(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDemandaProductos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DemandaProductosConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DemandaProductosConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DemandaProductosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DemandaProductosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DemandaProductosConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DemandaProductosConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DemandaProductosConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DemandaProductosConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DemandaProductosConstantesFunciones.LABEL_FECHAULTIMAVENTAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DemandaProductosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DemandaProductosConstantesFunciones.LABEL_NOMBREUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DemandaProductosConstantesFunciones.LABEL_CANTIDADDISPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DemandaProductosConstantesFunciones.LABEL_STOCKMINIMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DemandaProductosConstantesFunciones.LABEL_CODIGOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DemandaProductosConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DemandaProductosConstantesFunciones.LABEL_DEMTRI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DemandaProductosConstantesFunciones.LABEL_DEMBI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DemandaProductosConstantesFunciones.LABEL_DEMMEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DemandaProductosConstantesFunciones.LABEL_INGRESOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DemandaProductosConstantesFunciones.LABEL_EGRESOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DemandaProductosConstantesFunciones.LABEL_EXISTENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DemandaProductosConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDemandaProductos(String sTipo,Row row,Workbook workbook,DemandaProductos demandaproductos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(demandaproductos.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(demandaproductos.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(demandaproductos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(demandaproductos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(demandaproductos.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(demandaproductos.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(demandaproductos.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(demandaproductos.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(demandaproductos.getfecha_ultima_venta_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(demandaproductos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(demandaproductos.getnombre_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(demandaproductos.getcantidad_disponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(demandaproductos.getstock_minimo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(demandaproductos.getcodigo_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(demandaproductos.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(demandaproductos.getdem_tri());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(demandaproductos.getdem_bi());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(demandaproductos.getdem_men());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(demandaproductos.getingresos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(demandaproductos.getegresos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(demandaproductos.getexistencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(demandaproductos.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDemandaProductos="";
	
	public String getsFinalQueryDemandaProductos() {
		return this.sFinalQueryDemandaProductos;
	}
	
	public void setsFinalQueryDemandaProductos(String sFinalQueryDemandaProductos) {
		this.sFinalQueryDemandaProductos= sFinalQueryDemandaProductos;
	}
	
	public Border resaltarSeleccionarDemandaProductos=null;
	
	public Border setResaltarSeleccionarDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDemandaProductos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDemandaProductos() {
		return this.resaltarSeleccionarDemandaProductos;
	}
	
	public void setResaltarSeleccionarDemandaProductos(Border borderResaltarSeleccionarDemandaProductos) {
		this.resaltarSeleccionarDemandaProductos= borderResaltarSeleccionarDemandaProductos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDemandaProductos=null;
	public Boolean mostraridDemandaProductos=true;
	public Boolean activaridDemandaProductos=true;

	public Border resaltarid_bodegaDemandaProductos=null;
	public Boolean mostrarid_bodegaDemandaProductos=true;
	public Boolean activarid_bodegaDemandaProductos=true;
	public Boolean cargarid_bodegaDemandaProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDemandaProductos=false;//ConEventDepend=true

	public Border resaltarid_productoDemandaProductos=null;
	public Boolean mostrarid_productoDemandaProductos=true;
	public Boolean activarid_productoDemandaProductos=true;
	public Boolean cargarid_productoDemandaProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDemandaProductos=false;//ConEventDepend=true

	public Border resaltarid_empresaDemandaProductos=null;
	public Boolean mostrarid_empresaDemandaProductos=true;
	public Boolean activarid_empresaDemandaProductos=true;
	public Boolean cargarid_empresaDemandaProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDemandaProductos=false;//ConEventDepend=true

	public Border resaltarid_sucursalDemandaProductos=null;
	public Boolean mostrarid_sucursalDemandaProductos=true;
	public Boolean activarid_sucursalDemandaProductos=true;
	public Boolean cargarid_sucursalDemandaProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDemandaProductos=false;//ConEventDepend=true

	public Border resaltarid_lineaDemandaProductos=null;
	public Boolean mostrarid_lineaDemandaProductos=true;
	public Boolean activarid_lineaDemandaProductos=true;
	public Boolean cargarid_lineaDemandaProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaDemandaProductos=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoDemandaProductos=null;
	public Boolean mostrarid_linea_grupoDemandaProductos=true;
	public Boolean activarid_linea_grupoDemandaProductos=true;
	public Boolean cargarid_linea_grupoDemandaProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoDemandaProductos=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaDemandaProductos=null;
	public Boolean mostrarid_linea_categoriaDemandaProductos=true;
	public Boolean activarid_linea_categoriaDemandaProductos=true;
	public Boolean cargarid_linea_categoriaDemandaProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaDemandaProductos=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaDemandaProductos=null;
	public Boolean mostrarid_linea_marcaDemandaProductos=true;
	public Boolean activarid_linea_marcaDemandaProductos=true;
	public Boolean cargarid_linea_marcaDemandaProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaDemandaProductos=false;//ConEventDepend=true

	public Border resaltarfecha_ultima_venta_hastaDemandaProductos=null;
	public Boolean mostrarfecha_ultima_venta_hastaDemandaProductos=true;
	public Boolean activarfecha_ultima_venta_hastaDemandaProductos=true;

	public Border resaltarcodigoDemandaProductos=null;
	public Boolean mostrarcodigoDemandaProductos=true;
	public Boolean activarcodigoDemandaProductos=true;

	public Border resaltarnombre_unidadDemandaProductos=null;
	public Boolean mostrarnombre_unidadDemandaProductos=true;
	public Boolean activarnombre_unidadDemandaProductos=true;

	public Border resaltarcantidad_disponibleDemandaProductos=null;
	public Boolean mostrarcantidad_disponibleDemandaProductos=true;
	public Boolean activarcantidad_disponibleDemandaProductos=true;

	public Border resaltarstock_minimoDemandaProductos=null;
	public Boolean mostrarstock_minimoDemandaProductos=true;
	public Boolean activarstock_minimoDemandaProductos=true;

	public Border resaltarcodigo_productoDemandaProductos=null;
	public Boolean mostrarcodigo_productoDemandaProductos=true;
	public Boolean activarcodigo_productoDemandaProductos=true;

	public Border resaltarnombreDemandaProductos=null;
	public Boolean mostrarnombreDemandaProductos=true;
	public Boolean activarnombreDemandaProductos=true;

	public Border resaltardem_triDemandaProductos=null;
	public Boolean mostrardem_triDemandaProductos=true;
	public Boolean activardem_triDemandaProductos=true;

	public Border resaltardem_biDemandaProductos=null;
	public Boolean mostrardem_biDemandaProductos=true;
	public Boolean activardem_biDemandaProductos=true;

	public Border resaltardem_menDemandaProductos=null;
	public Boolean mostrardem_menDemandaProductos=true;
	public Boolean activardem_menDemandaProductos=true;

	public Border resaltaringresosDemandaProductos=null;
	public Boolean mostraringresosDemandaProductos=true;
	public Boolean activaringresosDemandaProductos=true;

	public Border resaltaregresosDemandaProductos=null;
	public Boolean mostraregresosDemandaProductos=true;
	public Boolean activaregresosDemandaProductos=true;

	public Border resaltarexistenciaDemandaProductos=null;
	public Boolean mostrarexistenciaDemandaProductos=true;
	public Boolean activarexistenciaDemandaProductos=true;

	public Border resaltarcostoDemandaProductos=null;
	public Boolean mostrarcostoDemandaProductos=true;
	public Boolean activarcostoDemandaProductos=true;

	
	

	public Border setResaltaridDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltaridDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDemandaProductos() {
		return this.resaltaridDemandaProductos;
	}

	public void setResaltaridDemandaProductos(Border borderResaltar) {
		this.resaltaridDemandaProductos= borderResaltar;
	}

	public Boolean getMostraridDemandaProductos() {
		return this.mostraridDemandaProductos;
	}

	public void setMostraridDemandaProductos(Boolean mostraridDemandaProductos) {
		this.mostraridDemandaProductos= mostraridDemandaProductos;
	}

	public Boolean getActivaridDemandaProductos() {
		return this.activaridDemandaProductos;
	}

	public void setActivaridDemandaProductos(Boolean activaridDemandaProductos) {
		this.activaridDemandaProductos= activaridDemandaProductos;
	}

	public Border setResaltarid_bodegaDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDemandaProductos() {
		return this.resaltarid_bodegaDemandaProductos;
	}

	public void setResaltarid_bodegaDemandaProductos(Border borderResaltar) {
		this.resaltarid_bodegaDemandaProductos= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDemandaProductos() {
		return this.mostrarid_bodegaDemandaProductos;
	}

	public void setMostrarid_bodegaDemandaProductos(Boolean mostrarid_bodegaDemandaProductos) {
		this.mostrarid_bodegaDemandaProductos= mostrarid_bodegaDemandaProductos;
	}

	public Boolean getActivarid_bodegaDemandaProductos() {
		return this.activarid_bodegaDemandaProductos;
	}

	public void setActivarid_bodegaDemandaProductos(Boolean activarid_bodegaDemandaProductos) {
		this.activarid_bodegaDemandaProductos= activarid_bodegaDemandaProductos;
	}

	public Boolean getCargarid_bodegaDemandaProductos() {
		return this.cargarid_bodegaDemandaProductos;
	}

	public void setCargarid_bodegaDemandaProductos(Boolean cargarid_bodegaDemandaProductos) {
		this.cargarid_bodegaDemandaProductos= cargarid_bodegaDemandaProductos;
	}

	public Border setResaltarid_productoDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltarid_productoDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDemandaProductos() {
		return this.resaltarid_productoDemandaProductos;
	}

	public void setResaltarid_productoDemandaProductos(Border borderResaltar) {
		this.resaltarid_productoDemandaProductos= borderResaltar;
	}

	public Boolean getMostrarid_productoDemandaProductos() {
		return this.mostrarid_productoDemandaProductos;
	}

	public void setMostrarid_productoDemandaProductos(Boolean mostrarid_productoDemandaProductos) {
		this.mostrarid_productoDemandaProductos= mostrarid_productoDemandaProductos;
	}

	public Boolean getActivarid_productoDemandaProductos() {
		return this.activarid_productoDemandaProductos;
	}

	public void setActivarid_productoDemandaProductos(Boolean activarid_productoDemandaProductos) {
		this.activarid_productoDemandaProductos= activarid_productoDemandaProductos;
	}

	public Boolean getCargarid_productoDemandaProductos() {
		return this.cargarid_productoDemandaProductos;
	}

	public void setCargarid_productoDemandaProductos(Boolean cargarid_productoDemandaProductos) {
		this.cargarid_productoDemandaProductos= cargarid_productoDemandaProductos;
	}

	public Border setResaltarid_empresaDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltarid_empresaDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDemandaProductos() {
		return this.resaltarid_empresaDemandaProductos;
	}

	public void setResaltarid_empresaDemandaProductos(Border borderResaltar) {
		this.resaltarid_empresaDemandaProductos= borderResaltar;
	}

	public Boolean getMostrarid_empresaDemandaProductos() {
		return this.mostrarid_empresaDemandaProductos;
	}

	public void setMostrarid_empresaDemandaProductos(Boolean mostrarid_empresaDemandaProductos) {
		this.mostrarid_empresaDemandaProductos= mostrarid_empresaDemandaProductos;
	}

	public Boolean getActivarid_empresaDemandaProductos() {
		return this.activarid_empresaDemandaProductos;
	}

	public void setActivarid_empresaDemandaProductos(Boolean activarid_empresaDemandaProductos) {
		this.activarid_empresaDemandaProductos= activarid_empresaDemandaProductos;
	}

	public Boolean getCargarid_empresaDemandaProductos() {
		return this.cargarid_empresaDemandaProductos;
	}

	public void setCargarid_empresaDemandaProductos(Boolean cargarid_empresaDemandaProductos) {
		this.cargarid_empresaDemandaProductos= cargarid_empresaDemandaProductos;
	}

	public Border setResaltarid_sucursalDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDemandaProductos() {
		return this.resaltarid_sucursalDemandaProductos;
	}

	public void setResaltarid_sucursalDemandaProductos(Border borderResaltar) {
		this.resaltarid_sucursalDemandaProductos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDemandaProductos() {
		return this.mostrarid_sucursalDemandaProductos;
	}

	public void setMostrarid_sucursalDemandaProductos(Boolean mostrarid_sucursalDemandaProductos) {
		this.mostrarid_sucursalDemandaProductos= mostrarid_sucursalDemandaProductos;
	}

	public Boolean getActivarid_sucursalDemandaProductos() {
		return this.activarid_sucursalDemandaProductos;
	}

	public void setActivarid_sucursalDemandaProductos(Boolean activarid_sucursalDemandaProductos) {
		this.activarid_sucursalDemandaProductos= activarid_sucursalDemandaProductos;
	}

	public Boolean getCargarid_sucursalDemandaProductos() {
		return this.cargarid_sucursalDemandaProductos;
	}

	public void setCargarid_sucursalDemandaProductos(Boolean cargarid_sucursalDemandaProductos) {
		this.cargarid_sucursalDemandaProductos= cargarid_sucursalDemandaProductos;
	}

	public Border setResaltarid_lineaDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltarid_lineaDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaDemandaProductos() {
		return this.resaltarid_lineaDemandaProductos;
	}

	public void setResaltarid_lineaDemandaProductos(Border borderResaltar) {
		this.resaltarid_lineaDemandaProductos= borderResaltar;
	}

	public Boolean getMostrarid_lineaDemandaProductos() {
		return this.mostrarid_lineaDemandaProductos;
	}

	public void setMostrarid_lineaDemandaProductos(Boolean mostrarid_lineaDemandaProductos) {
		this.mostrarid_lineaDemandaProductos= mostrarid_lineaDemandaProductos;
	}

	public Boolean getActivarid_lineaDemandaProductos() {
		return this.activarid_lineaDemandaProductos;
	}

	public void setActivarid_lineaDemandaProductos(Boolean activarid_lineaDemandaProductos) {
		this.activarid_lineaDemandaProductos= activarid_lineaDemandaProductos;
	}

	public Boolean getCargarid_lineaDemandaProductos() {
		return this.cargarid_lineaDemandaProductos;
	}

	public void setCargarid_lineaDemandaProductos(Boolean cargarid_lineaDemandaProductos) {
		this.cargarid_lineaDemandaProductos= cargarid_lineaDemandaProductos;
	}

	public Border setResaltarid_linea_grupoDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoDemandaProductos() {
		return this.resaltarid_linea_grupoDemandaProductos;
	}

	public void setResaltarid_linea_grupoDemandaProductos(Border borderResaltar) {
		this.resaltarid_linea_grupoDemandaProductos= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoDemandaProductos() {
		return this.mostrarid_linea_grupoDemandaProductos;
	}

	public void setMostrarid_linea_grupoDemandaProductos(Boolean mostrarid_linea_grupoDemandaProductos) {
		this.mostrarid_linea_grupoDemandaProductos= mostrarid_linea_grupoDemandaProductos;
	}

	public Boolean getActivarid_linea_grupoDemandaProductos() {
		return this.activarid_linea_grupoDemandaProductos;
	}

	public void setActivarid_linea_grupoDemandaProductos(Boolean activarid_linea_grupoDemandaProductos) {
		this.activarid_linea_grupoDemandaProductos= activarid_linea_grupoDemandaProductos;
	}

	public Boolean getCargarid_linea_grupoDemandaProductos() {
		return this.cargarid_linea_grupoDemandaProductos;
	}

	public void setCargarid_linea_grupoDemandaProductos(Boolean cargarid_linea_grupoDemandaProductos) {
		this.cargarid_linea_grupoDemandaProductos= cargarid_linea_grupoDemandaProductos;
	}

	public Border setResaltarid_linea_categoriaDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaDemandaProductos() {
		return this.resaltarid_linea_categoriaDemandaProductos;
	}

	public void setResaltarid_linea_categoriaDemandaProductos(Border borderResaltar) {
		this.resaltarid_linea_categoriaDemandaProductos= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaDemandaProductos() {
		return this.mostrarid_linea_categoriaDemandaProductos;
	}

	public void setMostrarid_linea_categoriaDemandaProductos(Boolean mostrarid_linea_categoriaDemandaProductos) {
		this.mostrarid_linea_categoriaDemandaProductos= mostrarid_linea_categoriaDemandaProductos;
	}

	public Boolean getActivarid_linea_categoriaDemandaProductos() {
		return this.activarid_linea_categoriaDemandaProductos;
	}

	public void setActivarid_linea_categoriaDemandaProductos(Boolean activarid_linea_categoriaDemandaProductos) {
		this.activarid_linea_categoriaDemandaProductos= activarid_linea_categoriaDemandaProductos;
	}

	public Boolean getCargarid_linea_categoriaDemandaProductos() {
		return this.cargarid_linea_categoriaDemandaProductos;
	}

	public void setCargarid_linea_categoriaDemandaProductos(Boolean cargarid_linea_categoriaDemandaProductos) {
		this.cargarid_linea_categoriaDemandaProductos= cargarid_linea_categoriaDemandaProductos;
	}

	public Border setResaltarid_linea_marcaDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaDemandaProductos() {
		return this.resaltarid_linea_marcaDemandaProductos;
	}

	public void setResaltarid_linea_marcaDemandaProductos(Border borderResaltar) {
		this.resaltarid_linea_marcaDemandaProductos= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaDemandaProductos() {
		return this.mostrarid_linea_marcaDemandaProductos;
	}

	public void setMostrarid_linea_marcaDemandaProductos(Boolean mostrarid_linea_marcaDemandaProductos) {
		this.mostrarid_linea_marcaDemandaProductos= mostrarid_linea_marcaDemandaProductos;
	}

	public Boolean getActivarid_linea_marcaDemandaProductos() {
		return this.activarid_linea_marcaDemandaProductos;
	}

	public void setActivarid_linea_marcaDemandaProductos(Boolean activarid_linea_marcaDemandaProductos) {
		this.activarid_linea_marcaDemandaProductos= activarid_linea_marcaDemandaProductos;
	}

	public Boolean getCargarid_linea_marcaDemandaProductos() {
		return this.cargarid_linea_marcaDemandaProductos;
	}

	public void setCargarid_linea_marcaDemandaProductos(Boolean cargarid_linea_marcaDemandaProductos) {
		this.cargarid_linea_marcaDemandaProductos= cargarid_linea_marcaDemandaProductos;
	}

	public Border setResaltarfecha_ultima_venta_hastaDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltarfecha_ultima_venta_hastaDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultima_venta_hastaDemandaProductos() {
		return this.resaltarfecha_ultima_venta_hastaDemandaProductos;
	}

	public void setResaltarfecha_ultima_venta_hastaDemandaProductos(Border borderResaltar) {
		this.resaltarfecha_ultima_venta_hastaDemandaProductos= borderResaltar;
	}

	public Boolean getMostrarfecha_ultima_venta_hastaDemandaProductos() {
		return this.mostrarfecha_ultima_venta_hastaDemandaProductos;
	}

	public void setMostrarfecha_ultima_venta_hastaDemandaProductos(Boolean mostrarfecha_ultima_venta_hastaDemandaProductos) {
		this.mostrarfecha_ultima_venta_hastaDemandaProductos= mostrarfecha_ultima_venta_hastaDemandaProductos;
	}

	public Boolean getActivarfecha_ultima_venta_hastaDemandaProductos() {
		return this.activarfecha_ultima_venta_hastaDemandaProductos;
	}

	public void setActivarfecha_ultima_venta_hastaDemandaProductos(Boolean activarfecha_ultima_venta_hastaDemandaProductos) {
		this.activarfecha_ultima_venta_hastaDemandaProductos= activarfecha_ultima_venta_hastaDemandaProductos;
	}

	public Border setResaltarcodigoDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltarcodigoDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoDemandaProductos() {
		return this.resaltarcodigoDemandaProductos;
	}

	public void setResaltarcodigoDemandaProductos(Border borderResaltar) {
		this.resaltarcodigoDemandaProductos= borderResaltar;
	}

	public Boolean getMostrarcodigoDemandaProductos() {
		return this.mostrarcodigoDemandaProductos;
	}

	public void setMostrarcodigoDemandaProductos(Boolean mostrarcodigoDemandaProductos) {
		this.mostrarcodigoDemandaProductos= mostrarcodigoDemandaProductos;
	}

	public Boolean getActivarcodigoDemandaProductos() {
		return this.activarcodigoDemandaProductos;
	}

	public void setActivarcodigoDemandaProductos(Boolean activarcodigoDemandaProductos) {
		this.activarcodigoDemandaProductos= activarcodigoDemandaProductos;
	}

	public Border setResaltarnombre_unidadDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltarnombre_unidadDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_unidadDemandaProductos() {
		return this.resaltarnombre_unidadDemandaProductos;
	}

	public void setResaltarnombre_unidadDemandaProductos(Border borderResaltar) {
		this.resaltarnombre_unidadDemandaProductos= borderResaltar;
	}

	public Boolean getMostrarnombre_unidadDemandaProductos() {
		return this.mostrarnombre_unidadDemandaProductos;
	}

	public void setMostrarnombre_unidadDemandaProductos(Boolean mostrarnombre_unidadDemandaProductos) {
		this.mostrarnombre_unidadDemandaProductos= mostrarnombre_unidadDemandaProductos;
	}

	public Boolean getActivarnombre_unidadDemandaProductos() {
		return this.activarnombre_unidadDemandaProductos;
	}

	public void setActivarnombre_unidadDemandaProductos(Boolean activarnombre_unidadDemandaProductos) {
		this.activarnombre_unidadDemandaProductos= activarnombre_unidadDemandaProductos;
	}

	public Border setResaltarcantidad_disponibleDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltarcantidad_disponibleDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_disponibleDemandaProductos() {
		return this.resaltarcantidad_disponibleDemandaProductos;
	}

	public void setResaltarcantidad_disponibleDemandaProductos(Border borderResaltar) {
		this.resaltarcantidad_disponibleDemandaProductos= borderResaltar;
	}

	public Boolean getMostrarcantidad_disponibleDemandaProductos() {
		return this.mostrarcantidad_disponibleDemandaProductos;
	}

	public void setMostrarcantidad_disponibleDemandaProductos(Boolean mostrarcantidad_disponibleDemandaProductos) {
		this.mostrarcantidad_disponibleDemandaProductos= mostrarcantidad_disponibleDemandaProductos;
	}

	public Boolean getActivarcantidad_disponibleDemandaProductos() {
		return this.activarcantidad_disponibleDemandaProductos;
	}

	public void setActivarcantidad_disponibleDemandaProductos(Boolean activarcantidad_disponibleDemandaProductos) {
		this.activarcantidad_disponibleDemandaProductos= activarcantidad_disponibleDemandaProductos;
	}

	public Border setResaltarstock_minimoDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltarstock_minimoDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarstock_minimoDemandaProductos() {
		return this.resaltarstock_minimoDemandaProductos;
	}

	public void setResaltarstock_minimoDemandaProductos(Border borderResaltar) {
		this.resaltarstock_minimoDemandaProductos= borderResaltar;
	}

	public Boolean getMostrarstock_minimoDemandaProductos() {
		return this.mostrarstock_minimoDemandaProductos;
	}

	public void setMostrarstock_minimoDemandaProductos(Boolean mostrarstock_minimoDemandaProductos) {
		this.mostrarstock_minimoDemandaProductos= mostrarstock_minimoDemandaProductos;
	}

	public Boolean getActivarstock_minimoDemandaProductos() {
		return this.activarstock_minimoDemandaProductos;
	}

	public void setActivarstock_minimoDemandaProductos(Boolean activarstock_minimoDemandaProductos) {
		this.activarstock_minimoDemandaProductos= activarstock_minimoDemandaProductos;
	}

	public Border setResaltarcodigo_productoDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltarcodigo_productoDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_productoDemandaProductos() {
		return this.resaltarcodigo_productoDemandaProductos;
	}

	public void setResaltarcodigo_productoDemandaProductos(Border borderResaltar) {
		this.resaltarcodigo_productoDemandaProductos= borderResaltar;
	}

	public Boolean getMostrarcodigo_productoDemandaProductos() {
		return this.mostrarcodigo_productoDemandaProductos;
	}

	public void setMostrarcodigo_productoDemandaProductos(Boolean mostrarcodigo_productoDemandaProductos) {
		this.mostrarcodigo_productoDemandaProductos= mostrarcodigo_productoDemandaProductos;
	}

	public Boolean getActivarcodigo_productoDemandaProductos() {
		return this.activarcodigo_productoDemandaProductos;
	}

	public void setActivarcodigo_productoDemandaProductos(Boolean activarcodigo_productoDemandaProductos) {
		this.activarcodigo_productoDemandaProductos= activarcodigo_productoDemandaProductos;
	}

	public Border setResaltarnombreDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltarnombreDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreDemandaProductos() {
		return this.resaltarnombreDemandaProductos;
	}

	public void setResaltarnombreDemandaProductos(Border borderResaltar) {
		this.resaltarnombreDemandaProductos= borderResaltar;
	}

	public Boolean getMostrarnombreDemandaProductos() {
		return this.mostrarnombreDemandaProductos;
	}

	public void setMostrarnombreDemandaProductos(Boolean mostrarnombreDemandaProductos) {
		this.mostrarnombreDemandaProductos= mostrarnombreDemandaProductos;
	}

	public Boolean getActivarnombreDemandaProductos() {
		return this.activarnombreDemandaProductos;
	}

	public void setActivarnombreDemandaProductos(Boolean activarnombreDemandaProductos) {
		this.activarnombreDemandaProductos= activarnombreDemandaProductos;
	}

	public Border setResaltardem_triDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltardem_triDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardem_triDemandaProductos() {
		return this.resaltardem_triDemandaProductos;
	}

	public void setResaltardem_triDemandaProductos(Border borderResaltar) {
		this.resaltardem_triDemandaProductos= borderResaltar;
	}

	public Boolean getMostrardem_triDemandaProductos() {
		return this.mostrardem_triDemandaProductos;
	}

	public void setMostrardem_triDemandaProductos(Boolean mostrardem_triDemandaProductos) {
		this.mostrardem_triDemandaProductos= mostrardem_triDemandaProductos;
	}

	public Boolean getActivardem_triDemandaProductos() {
		return this.activardem_triDemandaProductos;
	}

	public void setActivardem_triDemandaProductos(Boolean activardem_triDemandaProductos) {
		this.activardem_triDemandaProductos= activardem_triDemandaProductos;
	}

	public Border setResaltardem_biDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltardem_biDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardem_biDemandaProductos() {
		return this.resaltardem_biDemandaProductos;
	}

	public void setResaltardem_biDemandaProductos(Border borderResaltar) {
		this.resaltardem_biDemandaProductos= borderResaltar;
	}

	public Boolean getMostrardem_biDemandaProductos() {
		return this.mostrardem_biDemandaProductos;
	}

	public void setMostrardem_biDemandaProductos(Boolean mostrardem_biDemandaProductos) {
		this.mostrardem_biDemandaProductos= mostrardem_biDemandaProductos;
	}

	public Boolean getActivardem_biDemandaProductos() {
		return this.activardem_biDemandaProductos;
	}

	public void setActivardem_biDemandaProductos(Boolean activardem_biDemandaProductos) {
		this.activardem_biDemandaProductos= activardem_biDemandaProductos;
	}

	public Border setResaltardem_menDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltardem_menDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardem_menDemandaProductos() {
		return this.resaltardem_menDemandaProductos;
	}

	public void setResaltardem_menDemandaProductos(Border borderResaltar) {
		this.resaltardem_menDemandaProductos= borderResaltar;
	}

	public Boolean getMostrardem_menDemandaProductos() {
		return this.mostrardem_menDemandaProductos;
	}

	public void setMostrardem_menDemandaProductos(Boolean mostrardem_menDemandaProductos) {
		this.mostrardem_menDemandaProductos= mostrardem_menDemandaProductos;
	}

	public Boolean getActivardem_menDemandaProductos() {
		return this.activardem_menDemandaProductos;
	}

	public void setActivardem_menDemandaProductos(Boolean activardem_menDemandaProductos) {
		this.activardem_menDemandaProductos= activardem_menDemandaProductos;
	}

	public Border setResaltaringresosDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltaringresosDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaringresosDemandaProductos() {
		return this.resaltaringresosDemandaProductos;
	}

	public void setResaltaringresosDemandaProductos(Border borderResaltar) {
		this.resaltaringresosDemandaProductos= borderResaltar;
	}

	public Boolean getMostraringresosDemandaProductos() {
		return this.mostraringresosDemandaProductos;
	}

	public void setMostraringresosDemandaProductos(Boolean mostraringresosDemandaProductos) {
		this.mostraringresosDemandaProductos= mostraringresosDemandaProductos;
	}

	public Boolean getActivaringresosDemandaProductos() {
		return this.activaringresosDemandaProductos;
	}

	public void setActivaringresosDemandaProductos(Boolean activaringresosDemandaProductos) {
		this.activaringresosDemandaProductos= activaringresosDemandaProductos;
	}

	public Border setResaltaregresosDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltaregresosDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaregresosDemandaProductos() {
		return this.resaltaregresosDemandaProductos;
	}

	public void setResaltaregresosDemandaProductos(Border borderResaltar) {
		this.resaltaregresosDemandaProductos= borderResaltar;
	}

	public Boolean getMostraregresosDemandaProductos() {
		return this.mostraregresosDemandaProductos;
	}

	public void setMostraregresosDemandaProductos(Boolean mostraregresosDemandaProductos) {
		this.mostraregresosDemandaProductos= mostraregresosDemandaProductos;
	}

	public Boolean getActivaregresosDemandaProductos() {
		return this.activaregresosDemandaProductos;
	}

	public void setActivaregresosDemandaProductos(Boolean activaregresosDemandaProductos) {
		this.activaregresosDemandaProductos= activaregresosDemandaProductos;
	}

	public Border setResaltarexistenciaDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltarexistenciaDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarexistenciaDemandaProductos() {
		return this.resaltarexistenciaDemandaProductos;
	}

	public void setResaltarexistenciaDemandaProductos(Border borderResaltar) {
		this.resaltarexistenciaDemandaProductos= borderResaltar;
	}

	public Boolean getMostrarexistenciaDemandaProductos() {
		return this.mostrarexistenciaDemandaProductos;
	}

	public void setMostrarexistenciaDemandaProductos(Boolean mostrarexistenciaDemandaProductos) {
		this.mostrarexistenciaDemandaProductos= mostrarexistenciaDemandaProductos;
	}

	public Boolean getActivarexistenciaDemandaProductos() {
		return this.activarexistenciaDemandaProductos;
	}

	public void setActivarexistenciaDemandaProductos(Boolean activarexistenciaDemandaProductos) {
		this.activarexistenciaDemandaProductos= activarexistenciaDemandaProductos;
	}

	public Border setResaltarcostoDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//demandaproductosBeanSwingJInternalFrame.jTtoolBarDemandaProductos.setBorder(borderResaltar);
		
		this.resaltarcostoDemandaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoDemandaProductos() {
		return this.resaltarcostoDemandaProductos;
	}

	public void setResaltarcostoDemandaProductos(Border borderResaltar) {
		this.resaltarcostoDemandaProductos= borderResaltar;
	}

	public Boolean getMostrarcostoDemandaProductos() {
		return this.mostrarcostoDemandaProductos;
	}

	public void setMostrarcostoDemandaProductos(Boolean mostrarcostoDemandaProductos) {
		this.mostrarcostoDemandaProductos= mostrarcostoDemandaProductos;
	}

	public Boolean getActivarcostoDemandaProductos() {
		return this.activarcostoDemandaProductos;
	}

	public void setActivarcostoDemandaProductos(Boolean activarcostoDemandaProductos) {
		this.activarcostoDemandaProductos= activarcostoDemandaProductos;
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
		
		
		this.setMostraridDemandaProductos(esInicial);
		this.setMostrarid_bodegaDemandaProductos(esInicial);
		this.setMostrarid_productoDemandaProductos(esInicial);
		this.setMostrarid_empresaDemandaProductos(esInicial);
		this.setMostrarid_sucursalDemandaProductos(esInicial);
		this.setMostrarid_lineaDemandaProductos(esInicial);
		this.setMostrarid_linea_grupoDemandaProductos(esInicial);
		this.setMostrarid_linea_categoriaDemandaProductos(esInicial);
		this.setMostrarid_linea_marcaDemandaProductos(esInicial);
		this.setMostrarfecha_ultima_venta_hastaDemandaProductos(esInicial);
		this.setMostrarcodigoDemandaProductos(esInicial);
		this.setMostrarnombre_unidadDemandaProductos(esInicial);
		this.setMostrarcantidad_disponibleDemandaProductos(esInicial);
		this.setMostrarstock_minimoDemandaProductos(esInicial);
		this.setMostrarcodigo_productoDemandaProductos(esInicial);
		this.setMostrarnombreDemandaProductos(esInicial);
		this.setMostrardem_triDemandaProductos(esInicial);
		this.setMostrardem_biDemandaProductos(esInicial);
		this.setMostrardem_menDemandaProductos(esInicial);
		this.setMostraringresosDemandaProductos(esInicial);
		this.setMostraregresosDemandaProductos(esInicial);
		this.setMostrarexistenciaDemandaProductos(esInicial);
		this.setMostrarcostoDemandaProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DemandaProductosConstantesFunciones.ID)) {
				this.setMostraridDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.FECHAULTIMAVENTAHASTA)) {
				this.setMostrarfecha_ultima_venta_hastaDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.NOMBREUNIDAD)) {
				this.setMostrarnombre_unidadDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setMostrarcantidad_disponibleDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.STOCKMINIMO)) {
				this.setMostrarstock_minimoDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setMostrarcodigo_productoDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.DEMTRI)) {
				this.setMostrardem_triDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.DEMBI)) {
				this.setMostrardem_biDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.DEMMEN)) {
				this.setMostrardem_menDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.INGRESOS)) {
				this.setMostraringresosDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.EGRESOS)) {
				this.setMostraregresosDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.EXISTENCIA)) {
				this.setMostrarexistenciaDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.COSTO)) {
				this.setMostrarcostoDemandaProductos(esAsigna);
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
		
		
		this.setActivaridDemandaProductos(esInicial);
		this.setActivarid_bodegaDemandaProductos(esInicial);
		this.setActivarid_productoDemandaProductos(esInicial);
		this.setActivarid_empresaDemandaProductos(esInicial);
		this.setActivarid_sucursalDemandaProductos(esInicial);
		this.setActivarid_lineaDemandaProductos(esInicial);
		this.setActivarid_linea_grupoDemandaProductos(esInicial);
		this.setActivarid_linea_categoriaDemandaProductos(esInicial);
		this.setActivarid_linea_marcaDemandaProductos(esInicial);
		this.setActivarfecha_ultima_venta_hastaDemandaProductos(esInicial);
		this.setActivarcodigoDemandaProductos(esInicial);
		this.setActivarnombre_unidadDemandaProductos(esInicial);
		this.setActivarcantidad_disponibleDemandaProductos(esInicial);
		this.setActivarstock_minimoDemandaProductos(esInicial);
		this.setActivarcodigo_productoDemandaProductos(esInicial);
		this.setActivarnombreDemandaProductos(esInicial);
		this.setActivardem_triDemandaProductos(esInicial);
		this.setActivardem_biDemandaProductos(esInicial);
		this.setActivardem_menDemandaProductos(esInicial);
		this.setActivaringresosDemandaProductos(esInicial);
		this.setActivaregresosDemandaProductos(esInicial);
		this.setActivarexistenciaDemandaProductos(esInicial);
		this.setActivarcostoDemandaProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DemandaProductosConstantesFunciones.ID)) {
				this.setActivaridDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.FECHAULTIMAVENTAHASTA)) {
				this.setActivarfecha_ultima_venta_hastaDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.NOMBREUNIDAD)) {
				this.setActivarnombre_unidadDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setActivarcantidad_disponibleDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.STOCKMINIMO)) {
				this.setActivarstock_minimoDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setActivarcodigo_productoDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.NOMBRE)) {
				this.setActivarnombreDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.DEMTRI)) {
				this.setActivardem_triDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.DEMBI)) {
				this.setActivardem_biDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.DEMMEN)) {
				this.setActivardem_menDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.INGRESOS)) {
				this.setActivaringresosDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.EGRESOS)) {
				this.setActivaregresosDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.EXISTENCIA)) {
				this.setActivarexistenciaDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.COSTO)) {
				this.setActivarcostoDemandaProductos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDemandaProductos(esInicial);
		this.setResaltarid_bodegaDemandaProductos(esInicial);
		this.setResaltarid_productoDemandaProductos(esInicial);
		this.setResaltarid_empresaDemandaProductos(esInicial);
		this.setResaltarid_sucursalDemandaProductos(esInicial);
		this.setResaltarid_lineaDemandaProductos(esInicial);
		this.setResaltarid_linea_grupoDemandaProductos(esInicial);
		this.setResaltarid_linea_categoriaDemandaProductos(esInicial);
		this.setResaltarid_linea_marcaDemandaProductos(esInicial);
		this.setResaltarfecha_ultima_venta_hastaDemandaProductos(esInicial);
		this.setResaltarcodigoDemandaProductos(esInicial);
		this.setResaltarnombre_unidadDemandaProductos(esInicial);
		this.setResaltarcantidad_disponibleDemandaProductos(esInicial);
		this.setResaltarstock_minimoDemandaProductos(esInicial);
		this.setResaltarcodigo_productoDemandaProductos(esInicial);
		this.setResaltarnombreDemandaProductos(esInicial);
		this.setResaltardem_triDemandaProductos(esInicial);
		this.setResaltardem_biDemandaProductos(esInicial);
		this.setResaltardem_menDemandaProductos(esInicial);
		this.setResaltaringresosDemandaProductos(esInicial);
		this.setResaltaregresosDemandaProductos(esInicial);
		this.setResaltarexistenciaDemandaProductos(esInicial);
		this.setResaltarcostoDemandaProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DemandaProductosConstantesFunciones.ID)) {
				this.setResaltaridDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.FECHAULTIMAVENTAHASTA)) {
				this.setResaltarfecha_ultima_venta_hastaDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.NOMBREUNIDAD)) {
				this.setResaltarnombre_unidadDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setResaltarcantidad_disponibleDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.STOCKMINIMO)) {
				this.setResaltarstock_minimoDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setResaltarcodigo_productoDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.DEMTRI)) {
				this.setResaltardem_triDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.DEMBI)) {
				this.setResaltardem_biDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.DEMMEN)) {
				this.setResaltardem_menDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.INGRESOS)) {
				this.setResaltaringresosDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.EGRESOS)) {
				this.setResaltaregresosDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.EXISTENCIA)) {
				this.setResaltarexistenciaDemandaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DemandaProductosConstantesFunciones.COSTO)) {
				this.setResaltarcostoDemandaProductos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaDemandaProductosDemandaProductos=true;

	public Boolean getMostrarBusquedaDemandaProductosDemandaProductos() {
		return this.mostrarBusquedaDemandaProductosDemandaProductos;
	}

	public void setMostrarBusquedaDemandaProductosDemandaProductos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaDemandaProductosDemandaProductos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaDemandaProductosDemandaProductos=true;

	public Boolean getActivarBusquedaDemandaProductosDemandaProductos() {
		return this.activarBusquedaDemandaProductosDemandaProductos;
	}

	public void setActivarBusquedaDemandaProductosDemandaProductos(Boolean habilitarResaltar) {
		this.activarBusquedaDemandaProductosDemandaProductos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaDemandaProductosDemandaProductos=null;

	public Border getResaltarBusquedaDemandaProductosDemandaProductos() {
		return this.resaltarBusquedaDemandaProductosDemandaProductos;
	}

	public void setResaltarBusquedaDemandaProductosDemandaProductos(Border borderResaltar) {
		this.resaltarBusquedaDemandaProductosDemandaProductos= borderResaltar;
	}

	public void setResaltarBusquedaDemandaProductosDemandaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DemandaProductosBeanSwingJInternalFrame demandaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaDemandaProductosDemandaProductos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}