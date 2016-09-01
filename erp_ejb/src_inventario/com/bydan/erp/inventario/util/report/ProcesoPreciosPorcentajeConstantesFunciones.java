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


import com.bydan.erp.inventario.util.report.ProcesoPreciosPorcentajeConstantesFunciones;
import com.bydan.erp.inventario.util.report.ProcesoPreciosPorcentajeParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ProcesoPreciosPorcentajeParameterGeneral;

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
final public class ProcesoPreciosPorcentajeConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoPreciosPorcentaje";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoPreciosPorcentaje"+ProcesoPreciosPorcentajeConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoPreciosPorcentajeHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoPreciosPorcentajeHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoPreciosPorcentajeConstantesFunciones.SCHEMA+"_"+ProcesoPreciosPorcentajeConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoPreciosPorcentajeHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoPreciosPorcentajeConstantesFunciones.SCHEMA+"_"+ProcesoPreciosPorcentajeConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoPreciosPorcentajeConstantesFunciones.SCHEMA+"_"+ProcesoPreciosPorcentajeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoPreciosPorcentajeHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoPreciosPorcentajeConstantesFunciones.SCHEMA+"_"+ProcesoPreciosPorcentajeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoPreciosPorcentajeConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoPreciosPorcentajeHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoPreciosPorcentajeConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoPreciosPorcentajeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoPreciosPorcentajeHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoPreciosPorcentajeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoPreciosPorcentajeConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoPreciosPorcentajeConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoPreciosPorcentajeConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoPreciosPorcentajeConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Precios Porcentajes";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Proceso Precios Porcentaje";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Precios Porcentaje";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoPreciosPorcentaje";
	public static final String OBJECTNAME="procesopreciosporcentaje";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="proceso_precios_porcentaje";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesopreciosporcentaje from "+ProcesoPreciosPorcentajeConstantesFunciones.SPERSISTENCENAME+" procesopreciosporcentaje";
	public static String QUERYSELECTNATIVE="select "+ProcesoPreciosPorcentajeConstantesFunciones.SCHEMA+"."+ProcesoPreciosPorcentajeConstantesFunciones.TABLENAME+".id,"+ProcesoPreciosPorcentajeConstantesFunciones.SCHEMA+"."+ProcesoPreciosPorcentajeConstantesFunciones.TABLENAME+".version_row,"+ProcesoPreciosPorcentajeConstantesFunciones.SCHEMA+"."+ProcesoPreciosPorcentajeConstantesFunciones.TABLENAME+".id_bodega,"+ProcesoPreciosPorcentajeConstantesFunciones.SCHEMA+"."+ProcesoPreciosPorcentajeConstantesFunciones.TABLENAME+".id_producto,"+ProcesoPreciosPorcentajeConstantesFunciones.SCHEMA+"."+ProcesoPreciosPorcentajeConstantesFunciones.TABLENAME+".id_empresa,"+ProcesoPreciosPorcentajeConstantesFunciones.SCHEMA+"."+ProcesoPreciosPorcentajeConstantesFunciones.TABLENAME+".id_sucursal,"+ProcesoPreciosPorcentajeConstantesFunciones.SCHEMA+"."+ProcesoPreciosPorcentajeConstantesFunciones.TABLENAME+".id_linea,"+ProcesoPreciosPorcentajeConstantesFunciones.SCHEMA+"."+ProcesoPreciosPorcentajeConstantesFunciones.TABLENAME+".id_linea_grupo,"+ProcesoPreciosPorcentajeConstantesFunciones.SCHEMA+"."+ProcesoPreciosPorcentajeConstantesFunciones.TABLENAME+".id_linea_categoria,"+ProcesoPreciosPorcentajeConstantesFunciones.SCHEMA+"."+ProcesoPreciosPorcentajeConstantesFunciones.TABLENAME+".id_linea_marca,"+ProcesoPreciosPorcentajeConstantesFunciones.SCHEMA+"."+ProcesoPreciosPorcentajeConstantesFunciones.TABLENAME+".codigo,"+ProcesoPreciosPorcentajeConstantesFunciones.SCHEMA+"."+ProcesoPreciosPorcentajeConstantesFunciones.TABLENAME+".nombre,"+ProcesoPreciosPorcentajeConstantesFunciones.SCHEMA+"."+ProcesoPreciosPorcentajeConstantesFunciones.TABLENAME+".codigo_producto,"+ProcesoPreciosPorcentajeConstantesFunciones.SCHEMA+"."+ProcesoPreciosPorcentajeConstantesFunciones.TABLENAME+".nombre_producto,"+ProcesoPreciosPorcentajeConstantesFunciones.SCHEMA+"."+ProcesoPreciosPorcentajeConstantesFunciones.TABLENAME+".precio,"+ProcesoPreciosPorcentajeConstantesFunciones.SCHEMA+"."+ProcesoPreciosPorcentajeConstantesFunciones.TABLENAME+".porcentaje from "+ProcesoPreciosPorcentajeConstantesFunciones.SCHEMA+"."+ProcesoPreciosPorcentajeConstantesFunciones.TABLENAME;//+" as "+ProcesoPreciosPorcentajeConstantesFunciones.TABLENAME;
	
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
    public static final String CODIGOPRODUCTO= "codigo_producto";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String PRECIO= "precio";
    public static final String PORCENTAJE= "porcentaje";
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
    	public static final String LABEL_CODIGOPRODUCTO= "Codigo Producto";
		public static final String LABEL_CODIGOPRODUCTO_LOWER= "Codigo Producto";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getProcesoPreciosPorcentajeLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDBODEGA)) {sLabelColumna=ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDLINEA)) {sLabelColumna=ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(ProcesoPreciosPorcentajeConstantesFunciones.CODIGO)) {sLabelColumna=ProcesoPreciosPorcentajeConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ProcesoPreciosPorcentajeConstantesFunciones.NOMBRE)) {sLabelColumna=ProcesoPreciosPorcentajeConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ProcesoPreciosPorcentajeConstantesFunciones.CODIGOPRODUCTO)) {sLabelColumna=ProcesoPreciosPorcentajeConstantesFunciones.LABEL_CODIGOPRODUCTO;}
		if(sNombreColumna.equals(ProcesoPreciosPorcentajeConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=ProcesoPreciosPorcentajeConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(ProcesoPreciosPorcentajeConstantesFunciones.PRECIO)) {sLabelColumna=ProcesoPreciosPorcentajeConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(ProcesoPreciosPorcentajeConstantesFunciones.PORCENTAJE)) {sLabelColumna=ProcesoPreciosPorcentajeConstantesFunciones.LABEL_PORCENTAJE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProcesoPreciosPorcentajeDescripcion(ProcesoPreciosPorcentaje procesopreciosporcentaje) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesopreciosporcentaje !=null/* && procesopreciosporcentaje.getId()!=0*/) {
			sDescripcion=procesopreciosporcentaje.getcodigo();//procesopreciosporcentajeprocesopreciosporcentaje.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoPreciosPorcentajeDescripcionDetallado(ProcesoPreciosPorcentaje procesopreciosporcentaje) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoPreciosPorcentajeConstantesFunciones.ID+"=";
		sDescripcion+=procesopreciosporcentaje.getId().toString()+",";
		sDescripcion+=ProcesoPreciosPorcentajeConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesopreciosporcentaje.getVersionRow().toString()+",";
		sDescripcion+=ProcesoPreciosPorcentajeConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=procesopreciosporcentaje.getid_bodega().toString()+",";
		sDescripcion+=ProcesoPreciosPorcentajeConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=procesopreciosporcentaje.getid_producto().toString()+",";
		sDescripcion+=ProcesoPreciosPorcentajeConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=procesopreciosporcentaje.getid_empresa().toString()+",";
		sDescripcion+=ProcesoPreciosPorcentajeConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=procesopreciosporcentaje.getid_sucursal().toString()+",";
		sDescripcion+=ProcesoPreciosPorcentajeConstantesFunciones.IDLINEA+"=";
		sDescripcion+=procesopreciosporcentaje.getid_linea().toString()+",";
		sDescripcion+=ProcesoPreciosPorcentajeConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=procesopreciosporcentaje.getid_linea_grupo().toString()+",";
		sDescripcion+=ProcesoPreciosPorcentajeConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=procesopreciosporcentaje.getid_linea_categoria().toString()+",";
		sDescripcion+=ProcesoPreciosPorcentajeConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=procesopreciosporcentaje.getid_linea_marca().toString()+",";
		sDescripcion+=ProcesoPreciosPorcentajeConstantesFunciones.CODIGO+"=";
		sDescripcion+=procesopreciosporcentaje.getcodigo()+",";
		sDescripcion+=ProcesoPreciosPorcentajeConstantesFunciones.NOMBRE+"=";
		sDescripcion+=procesopreciosporcentaje.getnombre()+",";
		sDescripcion+=ProcesoPreciosPorcentajeConstantesFunciones.CODIGOPRODUCTO+"=";
		sDescripcion+=procesopreciosporcentaje.getcodigo_producto()+",";
		sDescripcion+=ProcesoPreciosPorcentajeConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=procesopreciosporcentaje.getnombre_producto()+",";
		sDescripcion+=ProcesoPreciosPorcentajeConstantesFunciones.PRECIO+"=";
		sDescripcion+=procesopreciosporcentaje.getprecio().toString()+",";
		sDescripcion+=ProcesoPreciosPorcentajeConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=procesopreciosporcentaje.getporcentaje().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoPreciosPorcentajeDescripcion(ProcesoPreciosPorcentaje procesopreciosporcentaje,String sValor) throws Exception {			
		if(procesopreciosporcentaje !=null) {
			procesopreciosporcentaje.setcodigo(sValor);;//procesopreciosporcentajeprocesopreciosporcentaje.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaProcesoPreciosPorcentaje")) {
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

	public static String getDetalleIndiceBusquedaProcesoPreciosPorcentaje(Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca) {
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
	
	
	
	
	
	
	public static void quitarEspaciosProcesoPreciosPorcentaje(ProcesoPreciosPorcentaje procesopreciosporcentaje,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		procesopreciosporcentaje.setcodigo(procesopreciosporcentaje.getcodigo().trim());
		procesopreciosporcentaje.setnombre(procesopreciosporcentaje.getnombre().trim());
		procesopreciosporcentaje.setcodigo_producto(procesopreciosporcentaje.getcodigo_producto().trim());
		procesopreciosporcentaje.setnombre_producto(procesopreciosporcentaje.getnombre_producto().trim());
	}
	
	public static void quitarEspaciosProcesoPreciosPorcentajes(List<ProcesoPreciosPorcentaje> procesopreciosporcentajes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoPreciosPorcentaje procesopreciosporcentaje: procesopreciosporcentajes) {
			procesopreciosporcentaje.setcodigo(procesopreciosporcentaje.getcodigo().trim());
			procesopreciosporcentaje.setnombre(procesopreciosporcentaje.getnombre().trim());
			procesopreciosporcentaje.setcodigo_producto(procesopreciosporcentaje.getcodigo_producto().trim());
			procesopreciosporcentaje.setnombre_producto(procesopreciosporcentaje.getnombre_producto().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoPreciosPorcentaje(ProcesoPreciosPorcentaje procesopreciosporcentaje,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesopreciosporcentaje.getConCambioAuxiliar()) {
			procesopreciosporcentaje.setIsDeleted(procesopreciosporcentaje.getIsDeletedAuxiliar());	
			procesopreciosporcentaje.setIsNew(procesopreciosporcentaje.getIsNewAuxiliar());	
			procesopreciosporcentaje.setIsChanged(procesopreciosporcentaje.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesopreciosporcentaje.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesopreciosporcentaje.setIsDeletedAuxiliar(false);	
			procesopreciosporcentaje.setIsNewAuxiliar(false);	
			procesopreciosporcentaje.setIsChangedAuxiliar(false);
			
			procesopreciosporcentaje.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoPreciosPorcentajes(List<ProcesoPreciosPorcentaje> procesopreciosporcentajes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoPreciosPorcentaje procesopreciosporcentaje : procesopreciosporcentajes) {
			if(conAsignarBase && procesopreciosporcentaje.getConCambioAuxiliar()) {
				procesopreciosporcentaje.setIsDeleted(procesopreciosporcentaje.getIsDeletedAuxiliar());	
				procesopreciosporcentaje.setIsNew(procesopreciosporcentaje.getIsNewAuxiliar());	
				procesopreciosporcentaje.setIsChanged(procesopreciosporcentaje.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesopreciosporcentaje.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesopreciosporcentaje.setIsDeletedAuxiliar(false);	
				procesopreciosporcentaje.setIsNewAuxiliar(false);	
				procesopreciosporcentaje.setIsChangedAuxiliar(false);
				
				procesopreciosporcentaje.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoPreciosPorcentaje(ProcesoPreciosPorcentaje procesopreciosporcentaje,Boolean conEnteros) throws Exception  {
		procesopreciosporcentaje.setprecio(0.0);
		procesopreciosporcentaje.setporcentaje(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoPreciosPorcentajes(List<ProcesoPreciosPorcentaje> procesopreciosporcentajes,Boolean conEnteros) throws Exception  {
		
		for(ProcesoPreciosPorcentaje procesopreciosporcentaje: procesopreciosporcentajes) {
			procesopreciosporcentaje.setprecio(0.0);
			procesopreciosporcentaje.setporcentaje(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoPreciosPorcentaje(List<ProcesoPreciosPorcentaje> procesopreciosporcentajes,ProcesoPreciosPorcentaje procesopreciosporcentajeAux) throws Exception  {
		ProcesoPreciosPorcentajeConstantesFunciones.InicializarValoresProcesoPreciosPorcentaje(procesopreciosporcentajeAux,true);
		
		for(ProcesoPreciosPorcentaje procesopreciosporcentaje: procesopreciosporcentajes) {
			if(procesopreciosporcentaje.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			procesopreciosporcentajeAux.setprecio(procesopreciosporcentajeAux.getprecio()+procesopreciosporcentaje.getprecio());			
			procesopreciosporcentajeAux.setporcentaje(procesopreciosporcentajeAux.getporcentaje()+procesopreciosporcentaje.getporcentaje());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoPreciosPorcentaje(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoPreciosPorcentajeConstantesFunciones.getArrayColumnasGlobalesProcesoPreciosPorcentaje(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoPreciosPorcentaje(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoPreciosPorcentajeConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoPreciosPorcentajeConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoPreciosPorcentaje(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoPreciosPorcentaje> procesopreciosporcentajes,ProcesoPreciosPorcentaje procesopreciosporcentaje,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoPreciosPorcentaje procesopreciosporcentajeAux: procesopreciosporcentajes) {
			if(procesopreciosporcentajeAux!=null && procesopreciosporcentaje!=null) {
				if((procesopreciosporcentajeAux.getId()==null && procesopreciosporcentaje.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesopreciosporcentajeAux.getId()!=null && procesopreciosporcentaje.getId()!=null){
					if(procesopreciosporcentajeAux.getId().equals(procesopreciosporcentaje.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoPreciosPorcentaje(List<ProcesoPreciosPorcentaje> procesopreciosporcentajes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double porcentajeTotal=0.0;
	
		for(ProcesoPreciosPorcentaje procesopreciosporcentaje: procesopreciosporcentajes) {			
			if(procesopreciosporcentaje.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=procesopreciosporcentaje.getprecio();
			porcentajeTotal+=procesopreciosporcentaje.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProcesoPreciosPorcentajeConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProcesoPreciosPorcentajeConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoPreciosPorcentaje() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProcesoPreciosPorcentajeConstantesFunciones.LABEL_ID, ProcesoPreciosPorcentajeConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPreciosPorcentajeConstantesFunciones.LABEL_VERSIONROW, ProcesoPreciosPorcentajeConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPreciosPorcentajeConstantesFunciones.LABEL_CODIGO, ProcesoPreciosPorcentajeConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPreciosPorcentajeConstantesFunciones.LABEL_NOMBRE, ProcesoPreciosPorcentajeConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPreciosPorcentajeConstantesFunciones.LABEL_CODIGOPRODUCTO, ProcesoPreciosPorcentajeConstantesFunciones.CODIGOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPreciosPorcentajeConstantesFunciones.LABEL_NOMBREPRODUCTO, ProcesoPreciosPorcentajeConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPreciosPorcentajeConstantesFunciones.LABEL_PRECIO, ProcesoPreciosPorcentajeConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPreciosPorcentajeConstantesFunciones.LABEL_PORCENTAJE, ProcesoPreciosPorcentajeConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoPreciosPorcentaje() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProcesoPreciosPorcentajeConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPreciosPorcentajeConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPreciosPorcentajeConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPreciosPorcentajeConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPreciosPorcentajeConstantesFunciones.CODIGOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPreciosPorcentajeConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPreciosPorcentajeConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPreciosPorcentajeConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoPreciosPorcentaje() throws Exception  {
		return ProcesoPreciosPorcentajeConstantesFunciones.getTiposSeleccionarProcesoPreciosPorcentaje(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoPreciosPorcentaje(Boolean conFk) throws Exception  {
		return ProcesoPreciosPorcentajeConstantesFunciones.getTiposSeleccionarProcesoPreciosPorcentaje(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoPreciosPorcentaje(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_CODIGOPRODUCTO);
			reporte.setsDescripcion(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_CODIGOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoPreciosPorcentaje(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoPreciosPorcentaje(ProcesoPreciosPorcentaje procesopreciosporcentajeAux) throws Exception {
		
			procesopreciosporcentajeAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(procesopreciosporcentajeAux.getBodega()));
			procesopreciosporcentajeAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(procesopreciosporcentajeAux.getProducto()));
			procesopreciosporcentajeAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(procesopreciosporcentajeAux.getEmpresa()));
			procesopreciosporcentajeAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(procesopreciosporcentajeAux.getSucursal()));
			procesopreciosporcentajeAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesopreciosporcentajeAux.getLinea()));
			procesopreciosporcentajeAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesopreciosporcentajeAux.getLineaGrupo()));
			procesopreciosporcentajeAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesopreciosporcentajeAux.getLineaCategoria()));
			procesopreciosporcentajeAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesopreciosporcentajeAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoPreciosPorcentaje(List<ProcesoPreciosPorcentaje> procesopreciosporcentajesTemp) throws Exception {
		for(ProcesoPreciosPorcentaje procesopreciosporcentajeAux:procesopreciosporcentajesTemp) {
			
			procesopreciosporcentajeAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(procesopreciosporcentajeAux.getBodega()));
			procesopreciosporcentajeAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(procesopreciosporcentajeAux.getProducto()));
			procesopreciosporcentajeAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(procesopreciosporcentajeAux.getEmpresa()));
			procesopreciosporcentajeAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(procesopreciosporcentajeAux.getSucursal()));
			procesopreciosporcentajeAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesopreciosporcentajeAux.getLinea()));
			procesopreciosporcentajeAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesopreciosporcentajeAux.getLineaGrupo()));
			procesopreciosporcentajeAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesopreciosporcentajeAux.getLineaCategoria()));
			procesopreciosporcentajeAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesopreciosporcentajeAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoPreciosPorcentaje(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoPreciosPorcentaje(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoPreciosPorcentaje(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoPreciosPorcentajeConstantesFunciones.getClassesRelationshipsOfProcesoPreciosPorcentaje(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoPreciosPorcentaje(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoPreciosPorcentaje(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoPreciosPorcentajeConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoPreciosPorcentaje(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoPreciosPorcentaje(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoPreciosPorcentaje procesopreciosporcentaje,List<ProcesoPreciosPorcentaje> procesopreciosporcentajes,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoPreciosPorcentaje procesopreciosporcentaje,List<ProcesoPreciosPorcentaje> procesopreciosporcentajes) throws Exception {
		try	{			
			for(ProcesoPreciosPorcentaje procesopreciosporcentajeLocal:procesopreciosporcentajes) {
				if(procesopreciosporcentajeLocal.getId().equals(procesopreciosporcentaje.getId())) {
					procesopreciosporcentajeLocal.setIsSelected(procesopreciosporcentaje.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoPreciosPorcentaje(List<ProcesoPreciosPorcentaje> procesopreciosporcentajesAux) throws Exception {
		//this.procesopreciosporcentajesAux=procesopreciosporcentajesAux;
		
		for(ProcesoPreciosPorcentaje procesopreciosporcentajeAux:procesopreciosporcentajesAux) {
			if(procesopreciosporcentajeAux.getIsChanged()) {
				procesopreciosporcentajeAux.setIsChanged(false);
			}		
			
			if(procesopreciosporcentajeAux.getIsNew()) {
				procesopreciosporcentajeAux.setIsNew(false);
			}	
			
			if(procesopreciosporcentajeAux.getIsDeleted()) {
				procesopreciosporcentajeAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoPreciosPorcentaje(ProcesoPreciosPorcentaje procesopreciosporcentajeAux) throws Exception {
		//this.procesopreciosporcentajeAux=procesopreciosporcentajeAux;
		
			if(procesopreciosporcentajeAux.getIsChanged()) {
				procesopreciosporcentajeAux.setIsChanged(false);
			}		
			
			if(procesopreciosporcentajeAux.getIsNew()) {
				procesopreciosporcentajeAux.setIsNew(false);
			}	
			
			if(procesopreciosporcentajeAux.getIsDeleted()) {
				procesopreciosporcentajeAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoPreciosPorcentaje procesopreciosporcentajeAsignar,ProcesoPreciosPorcentaje procesopreciosporcentaje) throws Exception {
		procesopreciosporcentajeAsignar.setId(procesopreciosporcentaje.getId());	
		procesopreciosporcentajeAsignar.setVersionRow(procesopreciosporcentaje.getVersionRow());	
		procesopreciosporcentajeAsignar.setcodigo(procesopreciosporcentaje.getcodigo());	
		procesopreciosporcentajeAsignar.setnombre(procesopreciosporcentaje.getnombre());	
		procesopreciosporcentajeAsignar.setcodigo_producto(procesopreciosporcentaje.getcodigo_producto());	
		procesopreciosporcentajeAsignar.setnombre_producto(procesopreciosporcentaje.getnombre_producto());	
		procesopreciosporcentajeAsignar.setprecio(procesopreciosporcentaje.getprecio());	
		procesopreciosporcentajeAsignar.setporcentaje(procesopreciosporcentaje.getporcentaje());	
	}
	
	public static void inicializarProcesoPreciosPorcentaje(ProcesoPreciosPorcentaje procesopreciosporcentaje) throws Exception {
		try {
				procesopreciosporcentaje.setId(0L);	
					
				procesopreciosporcentaje.setcodigo("");	
				procesopreciosporcentaje.setnombre("");	
				procesopreciosporcentaje.setcodigo_producto("");	
				procesopreciosporcentaje.setnombre_producto("");	
				procesopreciosporcentaje.setprecio(0.0);	
				procesopreciosporcentaje.setporcentaje(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoPreciosPorcentaje(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_CODIGOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosPorcentajeConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoPreciosPorcentaje(String sTipo,Row row,Workbook workbook,ProcesoPreciosPorcentaje procesopreciosporcentaje,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosporcentaje.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosporcentaje.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosporcentaje.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosporcentaje.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosporcentaje.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosporcentaje.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosporcentaje.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosporcentaje.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosporcentaje.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosporcentaje.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosporcentaje.getcodigo_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosporcentaje.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosporcentaje.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosporcentaje.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoPreciosPorcentaje="";
	
	public String getsFinalQueryProcesoPreciosPorcentaje() {
		return this.sFinalQueryProcesoPreciosPorcentaje;
	}
	
	public void setsFinalQueryProcesoPreciosPorcentaje(String sFinalQueryProcesoPreciosPorcentaje) {
		this.sFinalQueryProcesoPreciosPorcentaje= sFinalQueryProcesoPreciosPorcentaje;
	}
	
	public Border resaltarSeleccionarProcesoPreciosPorcentaje=null;
	
	public Border setResaltarSeleccionarProcesoPreciosPorcentaje(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosPorcentajeBeanSwingJInternalFrame procesopreciosporcentajeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesopreciosporcentajeBeanSwingJInternalFrame.jTtoolBarProcesoPreciosPorcentaje.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoPreciosPorcentaje= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoPreciosPorcentaje() {
		return this.resaltarSeleccionarProcesoPreciosPorcentaje;
	}
	
	public void setResaltarSeleccionarProcesoPreciosPorcentaje(Border borderResaltarSeleccionarProcesoPreciosPorcentaje) {
		this.resaltarSeleccionarProcesoPreciosPorcentaje= borderResaltarSeleccionarProcesoPreciosPorcentaje;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoPreciosPorcentaje=null;
	public Boolean mostraridProcesoPreciosPorcentaje=true;
	public Boolean activaridProcesoPreciosPorcentaje=true;

	public Border resaltarid_bodegaProcesoPreciosPorcentaje=null;
	public Boolean mostrarid_bodegaProcesoPreciosPorcentaje=true;
	public Boolean activarid_bodegaProcesoPreciosPorcentaje=true;
	public Boolean cargarid_bodegaProcesoPreciosPorcentaje=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaProcesoPreciosPorcentaje=false;//ConEventDepend=true

	public Border resaltarid_productoProcesoPreciosPorcentaje=null;
	public Boolean mostrarid_productoProcesoPreciosPorcentaje=true;
	public Boolean activarid_productoProcesoPreciosPorcentaje=true;
	public Boolean cargarid_productoProcesoPreciosPorcentaje=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProcesoPreciosPorcentaje=false;//ConEventDepend=true

	public Border resaltarid_empresaProcesoPreciosPorcentaje=null;
	public Boolean mostrarid_empresaProcesoPreciosPorcentaje=true;
	public Boolean activarid_empresaProcesoPreciosPorcentaje=true;
	public Boolean cargarid_empresaProcesoPreciosPorcentaje=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProcesoPreciosPorcentaje=false;//ConEventDepend=true

	public Border resaltarid_sucursalProcesoPreciosPorcentaje=null;
	public Boolean mostrarid_sucursalProcesoPreciosPorcentaje=true;
	public Boolean activarid_sucursalProcesoPreciosPorcentaje=true;
	public Boolean cargarid_sucursalProcesoPreciosPorcentaje=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProcesoPreciosPorcentaje=false;//ConEventDepend=true

	public Border resaltarid_lineaProcesoPreciosPorcentaje=null;
	public Boolean mostrarid_lineaProcesoPreciosPorcentaje=true;
	public Boolean activarid_lineaProcesoPreciosPorcentaje=true;
	public Boolean cargarid_lineaProcesoPreciosPorcentaje=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaProcesoPreciosPorcentaje=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoProcesoPreciosPorcentaje=null;
	public Boolean mostrarid_linea_grupoProcesoPreciosPorcentaje=true;
	public Boolean activarid_linea_grupoProcesoPreciosPorcentaje=true;
	public Boolean cargarid_linea_grupoProcesoPreciosPorcentaje=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoProcesoPreciosPorcentaje=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaProcesoPreciosPorcentaje=null;
	public Boolean mostrarid_linea_categoriaProcesoPreciosPorcentaje=true;
	public Boolean activarid_linea_categoriaProcesoPreciosPorcentaje=true;
	public Boolean cargarid_linea_categoriaProcesoPreciosPorcentaje=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaProcesoPreciosPorcentaje=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaProcesoPreciosPorcentaje=null;
	public Boolean mostrarid_linea_marcaProcesoPreciosPorcentaje=true;
	public Boolean activarid_linea_marcaProcesoPreciosPorcentaje=true;
	public Boolean cargarid_linea_marcaProcesoPreciosPorcentaje=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaProcesoPreciosPorcentaje=false;//ConEventDepend=true

	public Border resaltarcodigoProcesoPreciosPorcentaje=null;
	public Boolean mostrarcodigoProcesoPreciosPorcentaje=true;
	public Boolean activarcodigoProcesoPreciosPorcentaje=true;

	public Border resaltarnombreProcesoPreciosPorcentaje=null;
	public Boolean mostrarnombreProcesoPreciosPorcentaje=true;
	public Boolean activarnombreProcesoPreciosPorcentaje=true;

	public Border resaltarcodigo_productoProcesoPreciosPorcentaje=null;
	public Boolean mostrarcodigo_productoProcesoPreciosPorcentaje=true;
	public Boolean activarcodigo_productoProcesoPreciosPorcentaje=true;

	public Border resaltarnombre_productoProcesoPreciosPorcentaje=null;
	public Boolean mostrarnombre_productoProcesoPreciosPorcentaje=true;
	public Boolean activarnombre_productoProcesoPreciosPorcentaje=true;

	public Border resaltarprecioProcesoPreciosPorcentaje=null;
	public Boolean mostrarprecioProcesoPreciosPorcentaje=true;
	public Boolean activarprecioProcesoPreciosPorcentaje=true;

	public Border resaltarporcentajeProcesoPreciosPorcentaje=null;
	public Boolean mostrarporcentajeProcesoPreciosPorcentaje=true;
	public Boolean activarporcentajeProcesoPreciosPorcentaje=true;

	
	

	public Border setResaltaridProcesoPreciosPorcentaje(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosPorcentajeBeanSwingJInternalFrame procesopreciosporcentajeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosporcentajeBeanSwingJInternalFrame.jTtoolBarProcesoPreciosPorcentaje.setBorder(borderResaltar);
		
		this.resaltaridProcesoPreciosPorcentaje= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoPreciosPorcentaje() {
		return this.resaltaridProcesoPreciosPorcentaje;
	}

	public void setResaltaridProcesoPreciosPorcentaje(Border borderResaltar) {
		this.resaltaridProcesoPreciosPorcentaje= borderResaltar;
	}

	public Boolean getMostraridProcesoPreciosPorcentaje() {
		return this.mostraridProcesoPreciosPorcentaje;
	}

	public void setMostraridProcesoPreciosPorcentaje(Boolean mostraridProcesoPreciosPorcentaje) {
		this.mostraridProcesoPreciosPorcentaje= mostraridProcesoPreciosPorcentaje;
	}

	public Boolean getActivaridProcesoPreciosPorcentaje() {
		return this.activaridProcesoPreciosPorcentaje;
	}

	public void setActivaridProcesoPreciosPorcentaje(Boolean activaridProcesoPreciosPorcentaje) {
		this.activaridProcesoPreciosPorcentaje= activaridProcesoPreciosPorcentaje;
	}

	public Border setResaltarid_bodegaProcesoPreciosPorcentaje(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosPorcentajeBeanSwingJInternalFrame procesopreciosporcentajeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosporcentajeBeanSwingJInternalFrame.jTtoolBarProcesoPreciosPorcentaje.setBorder(borderResaltar);
		
		this.resaltarid_bodegaProcesoPreciosPorcentaje= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaProcesoPreciosPorcentaje() {
		return this.resaltarid_bodegaProcesoPreciosPorcentaje;
	}

	public void setResaltarid_bodegaProcesoPreciosPorcentaje(Border borderResaltar) {
		this.resaltarid_bodegaProcesoPreciosPorcentaje= borderResaltar;
	}

	public Boolean getMostrarid_bodegaProcesoPreciosPorcentaje() {
		return this.mostrarid_bodegaProcesoPreciosPorcentaje;
	}

	public void setMostrarid_bodegaProcesoPreciosPorcentaje(Boolean mostrarid_bodegaProcesoPreciosPorcentaje) {
		this.mostrarid_bodegaProcesoPreciosPorcentaje= mostrarid_bodegaProcesoPreciosPorcentaje;
	}

	public Boolean getActivarid_bodegaProcesoPreciosPorcentaje() {
		return this.activarid_bodegaProcesoPreciosPorcentaje;
	}

	public void setActivarid_bodegaProcesoPreciosPorcentaje(Boolean activarid_bodegaProcesoPreciosPorcentaje) {
		this.activarid_bodegaProcesoPreciosPorcentaje= activarid_bodegaProcesoPreciosPorcentaje;
	}

	public Boolean getCargarid_bodegaProcesoPreciosPorcentaje() {
		return this.cargarid_bodegaProcesoPreciosPorcentaje;
	}

	public void setCargarid_bodegaProcesoPreciosPorcentaje(Boolean cargarid_bodegaProcesoPreciosPorcentaje) {
		this.cargarid_bodegaProcesoPreciosPorcentaje= cargarid_bodegaProcesoPreciosPorcentaje;
	}

	public Border setResaltarid_productoProcesoPreciosPorcentaje(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosPorcentajeBeanSwingJInternalFrame procesopreciosporcentajeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosporcentajeBeanSwingJInternalFrame.jTtoolBarProcesoPreciosPorcentaje.setBorder(borderResaltar);
		
		this.resaltarid_productoProcesoPreciosPorcentaje= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProcesoPreciosPorcentaje() {
		return this.resaltarid_productoProcesoPreciosPorcentaje;
	}

	public void setResaltarid_productoProcesoPreciosPorcentaje(Border borderResaltar) {
		this.resaltarid_productoProcesoPreciosPorcentaje= borderResaltar;
	}

	public Boolean getMostrarid_productoProcesoPreciosPorcentaje() {
		return this.mostrarid_productoProcesoPreciosPorcentaje;
	}

	public void setMostrarid_productoProcesoPreciosPorcentaje(Boolean mostrarid_productoProcesoPreciosPorcentaje) {
		this.mostrarid_productoProcesoPreciosPorcentaje= mostrarid_productoProcesoPreciosPorcentaje;
	}

	public Boolean getActivarid_productoProcesoPreciosPorcentaje() {
		return this.activarid_productoProcesoPreciosPorcentaje;
	}

	public void setActivarid_productoProcesoPreciosPorcentaje(Boolean activarid_productoProcesoPreciosPorcentaje) {
		this.activarid_productoProcesoPreciosPorcentaje= activarid_productoProcesoPreciosPorcentaje;
	}

	public Boolean getCargarid_productoProcesoPreciosPorcentaje() {
		return this.cargarid_productoProcesoPreciosPorcentaje;
	}

	public void setCargarid_productoProcesoPreciosPorcentaje(Boolean cargarid_productoProcesoPreciosPorcentaje) {
		this.cargarid_productoProcesoPreciosPorcentaje= cargarid_productoProcesoPreciosPorcentaje;
	}

	public Border setResaltarid_empresaProcesoPreciosPorcentaje(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosPorcentajeBeanSwingJInternalFrame procesopreciosporcentajeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosporcentajeBeanSwingJInternalFrame.jTtoolBarProcesoPreciosPorcentaje.setBorder(borderResaltar);
		
		this.resaltarid_empresaProcesoPreciosPorcentaje= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProcesoPreciosPorcentaje() {
		return this.resaltarid_empresaProcesoPreciosPorcentaje;
	}

	public void setResaltarid_empresaProcesoPreciosPorcentaje(Border borderResaltar) {
		this.resaltarid_empresaProcesoPreciosPorcentaje= borderResaltar;
	}

	public Boolean getMostrarid_empresaProcesoPreciosPorcentaje() {
		return this.mostrarid_empresaProcesoPreciosPorcentaje;
	}

	public void setMostrarid_empresaProcesoPreciosPorcentaje(Boolean mostrarid_empresaProcesoPreciosPorcentaje) {
		this.mostrarid_empresaProcesoPreciosPorcentaje= mostrarid_empresaProcesoPreciosPorcentaje;
	}

	public Boolean getActivarid_empresaProcesoPreciosPorcentaje() {
		return this.activarid_empresaProcesoPreciosPorcentaje;
	}

	public void setActivarid_empresaProcesoPreciosPorcentaje(Boolean activarid_empresaProcesoPreciosPorcentaje) {
		this.activarid_empresaProcesoPreciosPorcentaje= activarid_empresaProcesoPreciosPorcentaje;
	}

	public Boolean getCargarid_empresaProcesoPreciosPorcentaje() {
		return this.cargarid_empresaProcesoPreciosPorcentaje;
	}

	public void setCargarid_empresaProcesoPreciosPorcentaje(Boolean cargarid_empresaProcesoPreciosPorcentaje) {
		this.cargarid_empresaProcesoPreciosPorcentaje= cargarid_empresaProcesoPreciosPorcentaje;
	}

	public Border setResaltarid_sucursalProcesoPreciosPorcentaje(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosPorcentajeBeanSwingJInternalFrame procesopreciosporcentajeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosporcentajeBeanSwingJInternalFrame.jTtoolBarProcesoPreciosPorcentaje.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProcesoPreciosPorcentaje= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProcesoPreciosPorcentaje() {
		return this.resaltarid_sucursalProcesoPreciosPorcentaje;
	}

	public void setResaltarid_sucursalProcesoPreciosPorcentaje(Border borderResaltar) {
		this.resaltarid_sucursalProcesoPreciosPorcentaje= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProcesoPreciosPorcentaje() {
		return this.mostrarid_sucursalProcesoPreciosPorcentaje;
	}

	public void setMostrarid_sucursalProcesoPreciosPorcentaje(Boolean mostrarid_sucursalProcesoPreciosPorcentaje) {
		this.mostrarid_sucursalProcesoPreciosPorcentaje= mostrarid_sucursalProcesoPreciosPorcentaje;
	}

	public Boolean getActivarid_sucursalProcesoPreciosPorcentaje() {
		return this.activarid_sucursalProcesoPreciosPorcentaje;
	}

	public void setActivarid_sucursalProcesoPreciosPorcentaje(Boolean activarid_sucursalProcesoPreciosPorcentaje) {
		this.activarid_sucursalProcesoPreciosPorcentaje= activarid_sucursalProcesoPreciosPorcentaje;
	}

	public Boolean getCargarid_sucursalProcesoPreciosPorcentaje() {
		return this.cargarid_sucursalProcesoPreciosPorcentaje;
	}

	public void setCargarid_sucursalProcesoPreciosPorcentaje(Boolean cargarid_sucursalProcesoPreciosPorcentaje) {
		this.cargarid_sucursalProcesoPreciosPorcentaje= cargarid_sucursalProcesoPreciosPorcentaje;
	}

	public Border setResaltarid_lineaProcesoPreciosPorcentaje(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosPorcentajeBeanSwingJInternalFrame procesopreciosporcentajeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosporcentajeBeanSwingJInternalFrame.jTtoolBarProcesoPreciosPorcentaje.setBorder(borderResaltar);
		
		this.resaltarid_lineaProcesoPreciosPorcentaje= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaProcesoPreciosPorcentaje() {
		return this.resaltarid_lineaProcesoPreciosPorcentaje;
	}

	public void setResaltarid_lineaProcesoPreciosPorcentaje(Border borderResaltar) {
		this.resaltarid_lineaProcesoPreciosPorcentaje= borderResaltar;
	}

	public Boolean getMostrarid_lineaProcesoPreciosPorcentaje() {
		return this.mostrarid_lineaProcesoPreciosPorcentaje;
	}

	public void setMostrarid_lineaProcesoPreciosPorcentaje(Boolean mostrarid_lineaProcesoPreciosPorcentaje) {
		this.mostrarid_lineaProcesoPreciosPorcentaje= mostrarid_lineaProcesoPreciosPorcentaje;
	}

	public Boolean getActivarid_lineaProcesoPreciosPorcentaje() {
		return this.activarid_lineaProcesoPreciosPorcentaje;
	}

	public void setActivarid_lineaProcesoPreciosPorcentaje(Boolean activarid_lineaProcesoPreciosPorcentaje) {
		this.activarid_lineaProcesoPreciosPorcentaje= activarid_lineaProcesoPreciosPorcentaje;
	}

	public Boolean getCargarid_lineaProcesoPreciosPorcentaje() {
		return this.cargarid_lineaProcesoPreciosPorcentaje;
	}

	public void setCargarid_lineaProcesoPreciosPorcentaje(Boolean cargarid_lineaProcesoPreciosPorcentaje) {
		this.cargarid_lineaProcesoPreciosPorcentaje= cargarid_lineaProcesoPreciosPorcentaje;
	}

	public Border setResaltarid_linea_grupoProcesoPreciosPorcentaje(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosPorcentajeBeanSwingJInternalFrame procesopreciosporcentajeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosporcentajeBeanSwingJInternalFrame.jTtoolBarProcesoPreciosPorcentaje.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoProcesoPreciosPorcentaje= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoProcesoPreciosPorcentaje() {
		return this.resaltarid_linea_grupoProcesoPreciosPorcentaje;
	}

	public void setResaltarid_linea_grupoProcesoPreciosPorcentaje(Border borderResaltar) {
		this.resaltarid_linea_grupoProcesoPreciosPorcentaje= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoProcesoPreciosPorcentaje() {
		return this.mostrarid_linea_grupoProcesoPreciosPorcentaje;
	}

	public void setMostrarid_linea_grupoProcesoPreciosPorcentaje(Boolean mostrarid_linea_grupoProcesoPreciosPorcentaje) {
		this.mostrarid_linea_grupoProcesoPreciosPorcentaje= mostrarid_linea_grupoProcesoPreciosPorcentaje;
	}

	public Boolean getActivarid_linea_grupoProcesoPreciosPorcentaje() {
		return this.activarid_linea_grupoProcesoPreciosPorcentaje;
	}

	public void setActivarid_linea_grupoProcesoPreciosPorcentaje(Boolean activarid_linea_grupoProcesoPreciosPorcentaje) {
		this.activarid_linea_grupoProcesoPreciosPorcentaje= activarid_linea_grupoProcesoPreciosPorcentaje;
	}

	public Boolean getCargarid_linea_grupoProcesoPreciosPorcentaje() {
		return this.cargarid_linea_grupoProcesoPreciosPorcentaje;
	}

	public void setCargarid_linea_grupoProcesoPreciosPorcentaje(Boolean cargarid_linea_grupoProcesoPreciosPorcentaje) {
		this.cargarid_linea_grupoProcesoPreciosPorcentaje= cargarid_linea_grupoProcesoPreciosPorcentaje;
	}

	public Border setResaltarid_linea_categoriaProcesoPreciosPorcentaje(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosPorcentajeBeanSwingJInternalFrame procesopreciosporcentajeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosporcentajeBeanSwingJInternalFrame.jTtoolBarProcesoPreciosPorcentaje.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaProcesoPreciosPorcentaje= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaProcesoPreciosPorcentaje() {
		return this.resaltarid_linea_categoriaProcesoPreciosPorcentaje;
	}

	public void setResaltarid_linea_categoriaProcesoPreciosPorcentaje(Border borderResaltar) {
		this.resaltarid_linea_categoriaProcesoPreciosPorcentaje= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaProcesoPreciosPorcentaje() {
		return this.mostrarid_linea_categoriaProcesoPreciosPorcentaje;
	}

	public void setMostrarid_linea_categoriaProcesoPreciosPorcentaje(Boolean mostrarid_linea_categoriaProcesoPreciosPorcentaje) {
		this.mostrarid_linea_categoriaProcesoPreciosPorcentaje= mostrarid_linea_categoriaProcesoPreciosPorcentaje;
	}

	public Boolean getActivarid_linea_categoriaProcesoPreciosPorcentaje() {
		return this.activarid_linea_categoriaProcesoPreciosPorcentaje;
	}

	public void setActivarid_linea_categoriaProcesoPreciosPorcentaje(Boolean activarid_linea_categoriaProcesoPreciosPorcentaje) {
		this.activarid_linea_categoriaProcesoPreciosPorcentaje= activarid_linea_categoriaProcesoPreciosPorcentaje;
	}

	public Boolean getCargarid_linea_categoriaProcesoPreciosPorcentaje() {
		return this.cargarid_linea_categoriaProcesoPreciosPorcentaje;
	}

	public void setCargarid_linea_categoriaProcesoPreciosPorcentaje(Boolean cargarid_linea_categoriaProcesoPreciosPorcentaje) {
		this.cargarid_linea_categoriaProcesoPreciosPorcentaje= cargarid_linea_categoriaProcesoPreciosPorcentaje;
	}

	public Border setResaltarid_linea_marcaProcesoPreciosPorcentaje(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosPorcentajeBeanSwingJInternalFrame procesopreciosporcentajeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosporcentajeBeanSwingJInternalFrame.jTtoolBarProcesoPreciosPorcentaje.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaProcesoPreciosPorcentaje= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaProcesoPreciosPorcentaje() {
		return this.resaltarid_linea_marcaProcesoPreciosPorcentaje;
	}

	public void setResaltarid_linea_marcaProcesoPreciosPorcentaje(Border borderResaltar) {
		this.resaltarid_linea_marcaProcesoPreciosPorcentaje= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaProcesoPreciosPorcentaje() {
		return this.mostrarid_linea_marcaProcesoPreciosPorcentaje;
	}

	public void setMostrarid_linea_marcaProcesoPreciosPorcentaje(Boolean mostrarid_linea_marcaProcesoPreciosPorcentaje) {
		this.mostrarid_linea_marcaProcesoPreciosPorcentaje= mostrarid_linea_marcaProcesoPreciosPorcentaje;
	}

	public Boolean getActivarid_linea_marcaProcesoPreciosPorcentaje() {
		return this.activarid_linea_marcaProcesoPreciosPorcentaje;
	}

	public void setActivarid_linea_marcaProcesoPreciosPorcentaje(Boolean activarid_linea_marcaProcesoPreciosPorcentaje) {
		this.activarid_linea_marcaProcesoPreciosPorcentaje= activarid_linea_marcaProcesoPreciosPorcentaje;
	}

	public Boolean getCargarid_linea_marcaProcesoPreciosPorcentaje() {
		return this.cargarid_linea_marcaProcesoPreciosPorcentaje;
	}

	public void setCargarid_linea_marcaProcesoPreciosPorcentaje(Boolean cargarid_linea_marcaProcesoPreciosPorcentaje) {
		this.cargarid_linea_marcaProcesoPreciosPorcentaje= cargarid_linea_marcaProcesoPreciosPorcentaje;
	}

	public Border setResaltarcodigoProcesoPreciosPorcentaje(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosPorcentajeBeanSwingJInternalFrame procesopreciosporcentajeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosporcentajeBeanSwingJInternalFrame.jTtoolBarProcesoPreciosPorcentaje.setBorder(borderResaltar);
		
		this.resaltarcodigoProcesoPreciosPorcentaje= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoProcesoPreciosPorcentaje() {
		return this.resaltarcodigoProcesoPreciosPorcentaje;
	}

	public void setResaltarcodigoProcesoPreciosPorcentaje(Border borderResaltar) {
		this.resaltarcodigoProcesoPreciosPorcentaje= borderResaltar;
	}

	public Boolean getMostrarcodigoProcesoPreciosPorcentaje() {
		return this.mostrarcodigoProcesoPreciosPorcentaje;
	}

	public void setMostrarcodigoProcesoPreciosPorcentaje(Boolean mostrarcodigoProcesoPreciosPorcentaje) {
		this.mostrarcodigoProcesoPreciosPorcentaje= mostrarcodigoProcesoPreciosPorcentaje;
	}

	public Boolean getActivarcodigoProcesoPreciosPorcentaje() {
		return this.activarcodigoProcesoPreciosPorcentaje;
	}

	public void setActivarcodigoProcesoPreciosPorcentaje(Boolean activarcodigoProcesoPreciosPorcentaje) {
		this.activarcodigoProcesoPreciosPorcentaje= activarcodigoProcesoPreciosPorcentaje;
	}

	public Border setResaltarnombreProcesoPreciosPorcentaje(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosPorcentajeBeanSwingJInternalFrame procesopreciosporcentajeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosporcentajeBeanSwingJInternalFrame.jTtoolBarProcesoPreciosPorcentaje.setBorder(borderResaltar);
		
		this.resaltarnombreProcesoPreciosPorcentaje= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreProcesoPreciosPorcentaje() {
		return this.resaltarnombreProcesoPreciosPorcentaje;
	}

	public void setResaltarnombreProcesoPreciosPorcentaje(Border borderResaltar) {
		this.resaltarnombreProcesoPreciosPorcentaje= borderResaltar;
	}

	public Boolean getMostrarnombreProcesoPreciosPorcentaje() {
		return this.mostrarnombreProcesoPreciosPorcentaje;
	}

	public void setMostrarnombreProcesoPreciosPorcentaje(Boolean mostrarnombreProcesoPreciosPorcentaje) {
		this.mostrarnombreProcesoPreciosPorcentaje= mostrarnombreProcesoPreciosPorcentaje;
	}

	public Boolean getActivarnombreProcesoPreciosPorcentaje() {
		return this.activarnombreProcesoPreciosPorcentaje;
	}

	public void setActivarnombreProcesoPreciosPorcentaje(Boolean activarnombreProcesoPreciosPorcentaje) {
		this.activarnombreProcesoPreciosPorcentaje= activarnombreProcesoPreciosPorcentaje;
	}

	public Border setResaltarcodigo_productoProcesoPreciosPorcentaje(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosPorcentajeBeanSwingJInternalFrame procesopreciosporcentajeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosporcentajeBeanSwingJInternalFrame.jTtoolBarProcesoPreciosPorcentaje.setBorder(borderResaltar);
		
		this.resaltarcodigo_productoProcesoPreciosPorcentaje= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_productoProcesoPreciosPorcentaje() {
		return this.resaltarcodigo_productoProcesoPreciosPorcentaje;
	}

	public void setResaltarcodigo_productoProcesoPreciosPorcentaje(Border borderResaltar) {
		this.resaltarcodigo_productoProcesoPreciosPorcentaje= borderResaltar;
	}

	public Boolean getMostrarcodigo_productoProcesoPreciosPorcentaje() {
		return this.mostrarcodigo_productoProcesoPreciosPorcentaje;
	}

	public void setMostrarcodigo_productoProcesoPreciosPorcentaje(Boolean mostrarcodigo_productoProcesoPreciosPorcentaje) {
		this.mostrarcodigo_productoProcesoPreciosPorcentaje= mostrarcodigo_productoProcesoPreciosPorcentaje;
	}

	public Boolean getActivarcodigo_productoProcesoPreciosPorcentaje() {
		return this.activarcodigo_productoProcesoPreciosPorcentaje;
	}

	public void setActivarcodigo_productoProcesoPreciosPorcentaje(Boolean activarcodigo_productoProcesoPreciosPorcentaje) {
		this.activarcodigo_productoProcesoPreciosPorcentaje= activarcodigo_productoProcesoPreciosPorcentaje;
	}

	public Border setResaltarnombre_productoProcesoPreciosPorcentaje(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosPorcentajeBeanSwingJInternalFrame procesopreciosporcentajeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosporcentajeBeanSwingJInternalFrame.jTtoolBarProcesoPreciosPorcentaje.setBorder(borderResaltar);
		
		this.resaltarnombre_productoProcesoPreciosPorcentaje= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoProcesoPreciosPorcentaje() {
		return this.resaltarnombre_productoProcesoPreciosPorcentaje;
	}

	public void setResaltarnombre_productoProcesoPreciosPorcentaje(Border borderResaltar) {
		this.resaltarnombre_productoProcesoPreciosPorcentaje= borderResaltar;
	}

	public Boolean getMostrarnombre_productoProcesoPreciosPorcentaje() {
		return this.mostrarnombre_productoProcesoPreciosPorcentaje;
	}

	public void setMostrarnombre_productoProcesoPreciosPorcentaje(Boolean mostrarnombre_productoProcesoPreciosPorcentaje) {
		this.mostrarnombre_productoProcesoPreciosPorcentaje= mostrarnombre_productoProcesoPreciosPorcentaje;
	}

	public Boolean getActivarnombre_productoProcesoPreciosPorcentaje() {
		return this.activarnombre_productoProcesoPreciosPorcentaje;
	}

	public void setActivarnombre_productoProcesoPreciosPorcentaje(Boolean activarnombre_productoProcesoPreciosPorcentaje) {
		this.activarnombre_productoProcesoPreciosPorcentaje= activarnombre_productoProcesoPreciosPorcentaje;
	}

	public Border setResaltarprecioProcesoPreciosPorcentaje(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosPorcentajeBeanSwingJInternalFrame procesopreciosporcentajeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosporcentajeBeanSwingJInternalFrame.jTtoolBarProcesoPreciosPorcentaje.setBorder(borderResaltar);
		
		this.resaltarprecioProcesoPreciosPorcentaje= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioProcesoPreciosPorcentaje() {
		return this.resaltarprecioProcesoPreciosPorcentaje;
	}

	public void setResaltarprecioProcesoPreciosPorcentaje(Border borderResaltar) {
		this.resaltarprecioProcesoPreciosPorcentaje= borderResaltar;
	}

	public Boolean getMostrarprecioProcesoPreciosPorcentaje() {
		return this.mostrarprecioProcesoPreciosPorcentaje;
	}

	public void setMostrarprecioProcesoPreciosPorcentaje(Boolean mostrarprecioProcesoPreciosPorcentaje) {
		this.mostrarprecioProcesoPreciosPorcentaje= mostrarprecioProcesoPreciosPorcentaje;
	}

	public Boolean getActivarprecioProcesoPreciosPorcentaje() {
		return this.activarprecioProcesoPreciosPorcentaje;
	}

	public void setActivarprecioProcesoPreciosPorcentaje(Boolean activarprecioProcesoPreciosPorcentaje) {
		this.activarprecioProcesoPreciosPorcentaje= activarprecioProcesoPreciosPorcentaje;
	}

	public Border setResaltarporcentajeProcesoPreciosPorcentaje(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosPorcentajeBeanSwingJInternalFrame procesopreciosporcentajeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosporcentajeBeanSwingJInternalFrame.jTtoolBarProcesoPreciosPorcentaje.setBorder(borderResaltar);
		
		this.resaltarporcentajeProcesoPreciosPorcentaje= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeProcesoPreciosPorcentaje() {
		return this.resaltarporcentajeProcesoPreciosPorcentaje;
	}

	public void setResaltarporcentajeProcesoPreciosPorcentaje(Border borderResaltar) {
		this.resaltarporcentajeProcesoPreciosPorcentaje= borderResaltar;
	}

	public Boolean getMostrarporcentajeProcesoPreciosPorcentaje() {
		return this.mostrarporcentajeProcesoPreciosPorcentaje;
	}

	public void setMostrarporcentajeProcesoPreciosPorcentaje(Boolean mostrarporcentajeProcesoPreciosPorcentaje) {
		this.mostrarporcentajeProcesoPreciosPorcentaje= mostrarporcentajeProcesoPreciosPorcentaje;
	}

	public Boolean getActivarporcentajeProcesoPreciosPorcentaje() {
		return this.activarporcentajeProcesoPreciosPorcentaje;
	}

	public void setActivarporcentajeProcesoPreciosPorcentaje(Boolean activarporcentajeProcesoPreciosPorcentaje) {
		this.activarporcentajeProcesoPreciosPorcentaje= activarporcentajeProcesoPreciosPorcentaje;
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
		
		
		this.setMostraridProcesoPreciosPorcentaje(esInicial);
		this.setMostrarid_bodegaProcesoPreciosPorcentaje(esInicial);
		this.setMostrarid_productoProcesoPreciosPorcentaje(esInicial);
		this.setMostrarid_empresaProcesoPreciosPorcentaje(esInicial);
		this.setMostrarid_sucursalProcesoPreciosPorcentaje(esInicial);
		this.setMostrarid_lineaProcesoPreciosPorcentaje(esInicial);
		this.setMostrarid_linea_grupoProcesoPreciosPorcentaje(esInicial);
		this.setMostrarid_linea_categoriaProcesoPreciosPorcentaje(esInicial);
		this.setMostrarid_linea_marcaProcesoPreciosPorcentaje(esInicial);
		this.setMostrarcodigoProcesoPreciosPorcentaje(esInicial);
		this.setMostrarnombreProcesoPreciosPorcentaje(esInicial);
		this.setMostrarcodigo_productoProcesoPreciosPorcentaje(esInicial);
		this.setMostrarnombre_productoProcesoPreciosPorcentaje(esInicial);
		this.setMostrarprecioProcesoPreciosPorcentaje(esInicial);
		this.setMostrarporcentajeProcesoPreciosPorcentaje(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.ID)) {
				this.setMostraridProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.CODIGOPRODUCTO)) {
				this.setMostrarcodigo_productoProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.PRECIO)) {
				this.setMostrarprecioProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeProcesoPreciosPorcentaje(esAsigna);
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
		
		
		this.setActivaridProcesoPreciosPorcentaje(esInicial);
		this.setActivarid_bodegaProcesoPreciosPorcentaje(esInicial);
		this.setActivarid_productoProcesoPreciosPorcentaje(esInicial);
		this.setActivarid_empresaProcesoPreciosPorcentaje(esInicial);
		this.setActivarid_sucursalProcesoPreciosPorcentaje(esInicial);
		this.setActivarid_lineaProcesoPreciosPorcentaje(esInicial);
		this.setActivarid_linea_grupoProcesoPreciosPorcentaje(esInicial);
		this.setActivarid_linea_categoriaProcesoPreciosPorcentaje(esInicial);
		this.setActivarid_linea_marcaProcesoPreciosPorcentaje(esInicial);
		this.setActivarcodigoProcesoPreciosPorcentaje(esInicial);
		this.setActivarnombreProcesoPreciosPorcentaje(esInicial);
		this.setActivarcodigo_productoProcesoPreciosPorcentaje(esInicial);
		this.setActivarnombre_productoProcesoPreciosPorcentaje(esInicial);
		this.setActivarprecioProcesoPreciosPorcentaje(esInicial);
		this.setActivarporcentajeProcesoPreciosPorcentaje(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.ID)) {
				this.setActivaridProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.CODIGO)) {
				this.setActivarcodigoProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.NOMBRE)) {
				this.setActivarnombreProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.CODIGOPRODUCTO)) {
				this.setActivarcodigo_productoProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.PRECIO)) {
				this.setActivarprecioProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeProcesoPreciosPorcentaje(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoPreciosPorcentajeBeanSwingJInternalFrame procesopreciosporcentajeBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoPreciosPorcentaje(esInicial);
		this.setResaltarid_bodegaProcesoPreciosPorcentaje(esInicial);
		this.setResaltarid_productoProcesoPreciosPorcentaje(esInicial);
		this.setResaltarid_empresaProcesoPreciosPorcentaje(esInicial);
		this.setResaltarid_sucursalProcesoPreciosPorcentaje(esInicial);
		this.setResaltarid_lineaProcesoPreciosPorcentaje(esInicial);
		this.setResaltarid_linea_grupoProcesoPreciosPorcentaje(esInicial);
		this.setResaltarid_linea_categoriaProcesoPreciosPorcentaje(esInicial);
		this.setResaltarid_linea_marcaProcesoPreciosPorcentaje(esInicial);
		this.setResaltarcodigoProcesoPreciosPorcentaje(esInicial);
		this.setResaltarnombreProcesoPreciosPorcentaje(esInicial);
		this.setResaltarcodigo_productoProcesoPreciosPorcentaje(esInicial);
		this.setResaltarnombre_productoProcesoPreciosPorcentaje(esInicial);
		this.setResaltarprecioProcesoPreciosPorcentaje(esInicial);
		this.setResaltarporcentajeProcesoPreciosPorcentaje(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.ID)) {
				this.setResaltaridProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.CODIGOPRODUCTO)) {
				this.setResaltarcodigo_productoProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.PRECIO)) {
				this.setResaltarprecioProcesoPreciosPorcentaje(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosPorcentajeConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeProcesoPreciosPorcentaje(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoPreciosPorcentajeBeanSwingJInternalFrame procesopreciosporcentajeBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoPreciosPorcentajeProcesoPreciosPorcentaje=true;

	public Boolean getMostrarBusquedaProcesoPreciosPorcentajeProcesoPreciosPorcentaje() {
		return this.mostrarBusquedaProcesoPreciosPorcentajeProcesoPreciosPorcentaje;
	}

	public void setMostrarBusquedaProcesoPreciosPorcentajeProcesoPreciosPorcentaje(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoPreciosPorcentajeProcesoPreciosPorcentaje= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoPreciosPorcentajeProcesoPreciosPorcentaje=true;

	public Boolean getActivarBusquedaProcesoPreciosPorcentajeProcesoPreciosPorcentaje() {
		return this.activarBusquedaProcesoPreciosPorcentajeProcesoPreciosPorcentaje;
	}

	public void setActivarBusquedaProcesoPreciosPorcentajeProcesoPreciosPorcentaje(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoPreciosPorcentajeProcesoPreciosPorcentaje= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoPreciosPorcentajeProcesoPreciosPorcentaje=null;

	public Border getResaltarBusquedaProcesoPreciosPorcentajeProcesoPreciosPorcentaje() {
		return this.resaltarBusquedaProcesoPreciosPorcentajeProcesoPreciosPorcentaje;
	}

	public void setResaltarBusquedaProcesoPreciosPorcentajeProcesoPreciosPorcentaje(Border borderResaltar) {
		this.resaltarBusquedaProcesoPreciosPorcentajeProcesoPreciosPorcentaje= borderResaltar;
	}

	public void setResaltarBusquedaProcesoPreciosPorcentajeProcesoPreciosPorcentaje(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosPorcentajeBeanSwingJInternalFrame procesopreciosporcentajeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoPreciosPorcentajeProcesoPreciosPorcentaje= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}