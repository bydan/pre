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


import com.bydan.erp.inventario.util.report.ProductosBodegasConstantesFunciones;
import com.bydan.erp.inventario.util.report.ProductosBodegasParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ProductosBodegasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProductosBodegasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProductosBodegas";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductosBodegas"+ProductosBodegasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductosBodegasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductosBodegasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductosBodegasConstantesFunciones.SCHEMA+"_"+ProductosBodegasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductosBodegasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductosBodegasConstantesFunciones.SCHEMA+"_"+ProductosBodegasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductosBodegasConstantesFunciones.SCHEMA+"_"+ProductosBodegasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductosBodegasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductosBodegasConstantesFunciones.SCHEMA+"_"+ProductosBodegasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosBodegasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductosBodegasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosBodegasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosBodegasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductosBodegasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosBodegasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductosBodegasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductosBodegasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductosBodegasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductosBodegasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Productos Bodegases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Productos Bodegas";
	public static final String SCLASSWEBTITULO_LOWER="Productos Bodegas";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductosBodegas";
	public static final String OBJECTNAME="productosbodegas";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="productos_bodegas";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productosbodegas from "+ProductosBodegasConstantesFunciones.SPERSISTENCENAME+" productosbodegas";
	public static String QUERYSELECTNATIVE="select "+ProductosBodegasConstantesFunciones.SCHEMA+"."+ProductosBodegasConstantesFunciones.TABLENAME+".id,"+ProductosBodegasConstantesFunciones.SCHEMA+"."+ProductosBodegasConstantesFunciones.TABLENAME+".version_row,"+ProductosBodegasConstantesFunciones.SCHEMA+"."+ProductosBodegasConstantesFunciones.TABLENAME+".id_empresa,"+ProductosBodegasConstantesFunciones.SCHEMA+"."+ProductosBodegasConstantesFunciones.TABLENAME+".id_sucursal,"+ProductosBodegasConstantesFunciones.SCHEMA+"."+ProductosBodegasConstantesFunciones.TABLENAME+".id_bodega,"+ProductosBodegasConstantesFunciones.SCHEMA+"."+ProductosBodegasConstantesFunciones.TABLENAME+".id_linea,"+ProductosBodegasConstantesFunciones.SCHEMA+"."+ProductosBodegasConstantesFunciones.TABLENAME+".id_linea_grupo,"+ProductosBodegasConstantesFunciones.SCHEMA+"."+ProductosBodegasConstantesFunciones.TABLENAME+".id_linea_categoria,"+ProductosBodegasConstantesFunciones.SCHEMA+"."+ProductosBodegasConstantesFunciones.TABLENAME+".id_linea_marca,"+ProductosBodegasConstantesFunciones.SCHEMA+"."+ProductosBodegasConstantesFunciones.TABLENAME+".nombre_sucursal,"+ProductosBodegasConstantesFunciones.SCHEMA+"."+ProductosBodegasConstantesFunciones.TABLENAME+".nombre_linea,"+ProductosBodegasConstantesFunciones.SCHEMA+"."+ProductosBodegasConstantesFunciones.TABLENAME+".nombre_linea_grupo,"+ProductosBodegasConstantesFunciones.SCHEMA+"."+ProductosBodegasConstantesFunciones.TABLENAME+".nombre_linea_categoria,"+ProductosBodegasConstantesFunciones.SCHEMA+"."+ProductosBodegasConstantesFunciones.TABLENAME+".nombre_linea_marca,"+ProductosBodegasConstantesFunciones.SCHEMA+"."+ProductosBodegasConstantesFunciones.TABLENAME+".codigo,"+ProductosBodegasConstantesFunciones.SCHEMA+"."+ProductosBodegasConstantesFunciones.TABLENAME+".nombre,"+ProductosBodegasConstantesFunciones.SCHEMA+"."+ProductosBodegasConstantesFunciones.TABLENAME+".nombre_bodega from "+ProductosBodegasConstantesFunciones.SCHEMA+"."+ProductosBodegasConstantesFunciones.TABLENAME;//+" as "+ProductosBodegasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
    public static final String NOMBRESUCURSAL= "nombre_sucursal";
    public static final String NOMBRELINEA= "nombre_linea";
    public static final String NOMBRELINEAGRUPO= "nombre_linea_grupo";
    public static final String NOMBRELINEACATEGORIA= "nombre_linea_categoria";
    public static final String NOMBRELINEAMARCA= "nombre_linea_marca";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String NOMBREBODEGA= "nombre_bodega";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDLINEAGRUPO= "Linea Grupo";
		public static final String LABEL_IDLINEAGRUPO_LOWER= "Linea Grupo";
    	public static final String LABEL_IDLINEACATEGORIA= "Linea Categoria";
		public static final String LABEL_IDLINEACATEGORIA_LOWER= "Linea Categoria";
    	public static final String LABEL_IDLINEAMARCA= "Linea Marca";
		public static final String LABEL_IDLINEAMARCA_LOWER= "Linea Marca";
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
	
	public static String getProductosBodegasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductosBodegasConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProductosBodegasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProductosBodegasConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProductosBodegasConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProductosBodegasConstantesFunciones.IDBODEGA)) {sLabelColumna=ProductosBodegasConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ProductosBodegasConstantesFunciones.IDLINEA)) {sLabelColumna=ProductosBodegasConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ProductosBodegasConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=ProductosBodegasConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(ProductosBodegasConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=ProductosBodegasConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(ProductosBodegasConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=ProductosBodegasConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(ProductosBodegasConstantesFunciones.NOMBRESUCURSAL)) {sLabelColumna=ProductosBodegasConstantesFunciones.LABEL_NOMBRESUCURSAL;}
		if(sNombreColumna.equals(ProductosBodegasConstantesFunciones.NOMBRELINEA)) {sLabelColumna=ProductosBodegasConstantesFunciones.LABEL_NOMBRELINEA;}
		if(sNombreColumna.equals(ProductosBodegasConstantesFunciones.NOMBRELINEAGRUPO)) {sLabelColumna=ProductosBodegasConstantesFunciones.LABEL_NOMBRELINEAGRUPO;}
		if(sNombreColumna.equals(ProductosBodegasConstantesFunciones.NOMBRELINEACATEGORIA)) {sLabelColumna=ProductosBodegasConstantesFunciones.LABEL_NOMBRELINEACATEGORIA;}
		if(sNombreColumna.equals(ProductosBodegasConstantesFunciones.NOMBRELINEAMARCA)) {sLabelColumna=ProductosBodegasConstantesFunciones.LABEL_NOMBRELINEAMARCA;}
		if(sNombreColumna.equals(ProductosBodegasConstantesFunciones.CODIGO)) {sLabelColumna=ProductosBodegasConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ProductosBodegasConstantesFunciones.NOMBRE)) {sLabelColumna=ProductosBodegasConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ProductosBodegasConstantesFunciones.NOMBREBODEGA)) {sLabelColumna=ProductosBodegasConstantesFunciones.LABEL_NOMBREBODEGA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProductosBodegasDescripcion(ProductosBodegas productosbodegas) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productosbodegas !=null/* && productosbodegas.getId()!=0*/) {
			sDescripcion=productosbodegas.getcodigo();//productosbodegasproductosbodegas.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProductosBodegasDescripcionDetallado(ProductosBodegas productosbodegas) {
		String sDescripcion="";
			
		sDescripcion+=ProductosBodegasConstantesFunciones.ID+"=";
		sDescripcion+=productosbodegas.getId().toString()+",";
		sDescripcion+=ProductosBodegasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productosbodegas.getVersionRow().toString()+",";
		sDescripcion+=ProductosBodegasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=productosbodegas.getid_empresa().toString()+",";
		sDescripcion+=ProductosBodegasConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=productosbodegas.getid_sucursal().toString()+",";
		sDescripcion+=ProductosBodegasConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=productosbodegas.getid_bodega().toString()+",";
		sDescripcion+=ProductosBodegasConstantesFunciones.IDLINEA+"=";
		sDescripcion+=productosbodegas.getid_linea().toString()+",";
		sDescripcion+=ProductosBodegasConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=productosbodegas.getid_linea_grupo().toString()+",";
		sDescripcion+=ProductosBodegasConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=productosbodegas.getid_linea_categoria().toString()+",";
		sDescripcion+=ProductosBodegasConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=productosbodegas.getid_linea_marca().toString()+",";
		sDescripcion+=ProductosBodegasConstantesFunciones.NOMBRESUCURSAL+"=";
		sDescripcion+=productosbodegas.getnombre_sucursal()+",";
		sDescripcion+=ProductosBodegasConstantesFunciones.NOMBRELINEA+"=";
		sDescripcion+=productosbodegas.getnombre_linea()+",";
		sDescripcion+=ProductosBodegasConstantesFunciones.NOMBRELINEAGRUPO+"=";
		sDescripcion+=productosbodegas.getnombre_linea_grupo()+",";
		sDescripcion+=ProductosBodegasConstantesFunciones.NOMBRELINEACATEGORIA+"=";
		sDescripcion+=productosbodegas.getnombre_linea_categoria()+",";
		sDescripcion+=ProductosBodegasConstantesFunciones.NOMBRELINEAMARCA+"=";
		sDescripcion+=productosbodegas.getnombre_linea_marca()+",";
		sDescripcion+=ProductosBodegasConstantesFunciones.CODIGO+"=";
		sDescripcion+=productosbodegas.getcodigo()+",";
		sDescripcion+=ProductosBodegasConstantesFunciones.NOMBRE+"=";
		sDescripcion+=productosbodegas.getnombre()+",";
		sDescripcion+=ProductosBodegasConstantesFunciones.NOMBREBODEGA+"=";
		sDescripcion+=productosbodegas.getnombre_bodega()+",";
			
		return sDescripcion;
	}
	
	public static void setProductosBodegasDescripcion(ProductosBodegas productosbodegas,String sValor) throws Exception {			
		if(productosbodegas !=null) {
			productosbodegas.setcodigo(sValor);;//productosbodegasproductosbodegas.getcodigo().trim();
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

	public static String getBodegaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
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
		} else if(sNombreIndice.equals("BusquedaProductosBodegas")) {
			sNombreIndice="Tipo=  Por Bodega Por Linea Por Linea Grupo Por Linea Categoria Por Linea Marca";
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
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProductosBodegas(Long id_bodega,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();}
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

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProductosBodegas(ProductosBodegas productosbodegas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productosbodegas.setnombre_sucursal(productosbodegas.getnombre_sucursal().trim());
		productosbodegas.setnombre_linea(productosbodegas.getnombre_linea().trim());
		productosbodegas.setnombre_linea_grupo(productosbodegas.getnombre_linea_grupo().trim());
		productosbodegas.setnombre_linea_categoria(productosbodegas.getnombre_linea_categoria().trim());
		productosbodegas.setnombre_linea_marca(productosbodegas.getnombre_linea_marca().trim());
		productosbodegas.setcodigo(productosbodegas.getcodigo().trim());
		productosbodegas.setnombre(productosbodegas.getnombre().trim());
		productosbodegas.setnombre_bodega(productosbodegas.getnombre_bodega().trim());
	}
	
	public static void quitarEspaciosProductosBodegass(List<ProductosBodegas> productosbodegass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductosBodegas productosbodegas: productosbodegass) {
			productosbodegas.setnombre_sucursal(productosbodegas.getnombre_sucursal().trim());
			productosbodegas.setnombre_linea(productosbodegas.getnombre_linea().trim());
			productosbodegas.setnombre_linea_grupo(productosbodegas.getnombre_linea_grupo().trim());
			productosbodegas.setnombre_linea_categoria(productosbodegas.getnombre_linea_categoria().trim());
			productosbodegas.setnombre_linea_marca(productosbodegas.getnombre_linea_marca().trim());
			productosbodegas.setcodigo(productosbodegas.getcodigo().trim());
			productosbodegas.setnombre(productosbodegas.getnombre().trim());
			productosbodegas.setnombre_bodega(productosbodegas.getnombre_bodega().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductosBodegas(ProductosBodegas productosbodegas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productosbodegas.getConCambioAuxiliar()) {
			productosbodegas.setIsDeleted(productosbodegas.getIsDeletedAuxiliar());	
			productosbodegas.setIsNew(productosbodegas.getIsNewAuxiliar());	
			productosbodegas.setIsChanged(productosbodegas.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productosbodegas.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productosbodegas.setIsDeletedAuxiliar(false);	
			productosbodegas.setIsNewAuxiliar(false);	
			productosbodegas.setIsChangedAuxiliar(false);
			
			productosbodegas.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductosBodegass(List<ProductosBodegas> productosbodegass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductosBodegas productosbodegas : productosbodegass) {
			if(conAsignarBase && productosbodegas.getConCambioAuxiliar()) {
				productosbodegas.setIsDeleted(productosbodegas.getIsDeletedAuxiliar());	
				productosbodegas.setIsNew(productosbodegas.getIsNewAuxiliar());	
				productosbodegas.setIsChanged(productosbodegas.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productosbodegas.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productosbodegas.setIsDeletedAuxiliar(false);	
				productosbodegas.setIsNewAuxiliar(false);	
				productosbodegas.setIsChangedAuxiliar(false);
				
				productosbodegas.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductosBodegas(ProductosBodegas productosbodegas,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProductosBodegass(List<ProductosBodegas> productosbodegass,Boolean conEnteros) throws Exception  {
		
		for(ProductosBodegas productosbodegas: productosbodegass) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductosBodegas(List<ProductosBodegas> productosbodegass,ProductosBodegas productosbodegasAux) throws Exception  {
		ProductosBodegasConstantesFunciones.InicializarValoresProductosBodegas(productosbodegasAux,true);
		
		for(ProductosBodegas productosbodegas: productosbodegass) {
			if(productosbodegas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosBodegas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductosBodegasConstantesFunciones.getArrayColumnasGlobalesProductosBodegas(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosBodegas(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductosBodegasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductosBodegasConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductosBodegasConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductosBodegasConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductosBodegas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductosBodegas> productosbodegass,ProductosBodegas productosbodegas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductosBodegas productosbodegasAux: productosbodegass) {
			if(productosbodegasAux!=null && productosbodegas!=null) {
				if((productosbodegasAux.getId()==null && productosbodegas.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productosbodegasAux.getId()!=null && productosbodegas.getId()!=null){
					if(productosbodegasAux.getId().equals(productosbodegas.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductosBodegas(List<ProductosBodegas> productosbodegass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProductosBodegas productosbodegas: productosbodegass) {			
			if(productosbodegas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductosBodegas() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductosBodegasConstantesFunciones.LABEL_ID, ProductosBodegasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosBodegasConstantesFunciones.LABEL_VERSIONROW, ProductosBodegasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosBodegasConstantesFunciones.LABEL_NOMBRESUCURSAL, ProductosBodegasConstantesFunciones.NOMBRESUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosBodegasConstantesFunciones.LABEL_NOMBRELINEA, ProductosBodegasConstantesFunciones.NOMBRELINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosBodegasConstantesFunciones.LABEL_NOMBRELINEAGRUPO, ProductosBodegasConstantesFunciones.NOMBRELINEAGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosBodegasConstantesFunciones.LABEL_NOMBRELINEACATEGORIA, ProductosBodegasConstantesFunciones.NOMBRELINEACATEGORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosBodegasConstantesFunciones.LABEL_NOMBRELINEAMARCA, ProductosBodegasConstantesFunciones.NOMBRELINEAMARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosBodegasConstantesFunciones.LABEL_CODIGO, ProductosBodegasConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosBodegasConstantesFunciones.LABEL_NOMBRE, ProductosBodegasConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosBodegasConstantesFunciones.LABEL_NOMBREBODEGA, ProductosBodegasConstantesFunciones.NOMBREBODEGA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductosBodegas() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductosBodegasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosBodegasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosBodegasConstantesFunciones.NOMBRESUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosBodegasConstantesFunciones.NOMBRELINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosBodegasConstantesFunciones.NOMBRELINEAGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosBodegasConstantesFunciones.NOMBRELINEACATEGORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosBodegasConstantesFunciones.NOMBRELINEAMARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosBodegasConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosBodegasConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosBodegasConstantesFunciones.NOMBREBODEGA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosBodegas() throws Exception  {
		return ProductosBodegasConstantesFunciones.getTiposSeleccionarProductosBodegas(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosBodegas(Boolean conFk) throws Exception  {
		return ProductosBodegasConstantesFunciones.getTiposSeleccionarProductosBodegas(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosBodegas(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosBodegasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProductosBodegasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosBodegasConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProductosBodegasConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosBodegasConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ProductosBodegasConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosBodegasConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ProductosBodegasConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosBodegasConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(ProductosBodegasConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosBodegasConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(ProductosBodegasConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosBodegasConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(ProductosBodegasConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosBodegasConstantesFunciones.LABEL_NOMBRESUCURSAL);
			reporte.setsDescripcion(ProductosBodegasConstantesFunciones.LABEL_NOMBRESUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosBodegasConstantesFunciones.LABEL_NOMBRELINEA);
			reporte.setsDescripcion(ProductosBodegasConstantesFunciones.LABEL_NOMBRELINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosBodegasConstantesFunciones.LABEL_NOMBRELINEAGRUPO);
			reporte.setsDescripcion(ProductosBodegasConstantesFunciones.LABEL_NOMBRELINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosBodegasConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);
			reporte.setsDescripcion(ProductosBodegasConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosBodegasConstantesFunciones.LABEL_NOMBRELINEAMARCA);
			reporte.setsDescripcion(ProductosBodegasConstantesFunciones.LABEL_NOMBRELINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosBodegasConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ProductosBodegasConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosBodegasConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ProductosBodegasConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosBodegasConstantesFunciones.LABEL_NOMBREBODEGA);
			reporte.setsDescripcion(ProductosBodegasConstantesFunciones.LABEL_NOMBREBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductosBodegas(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductosBodegas(ProductosBodegas productosbodegasAux) throws Exception {
		
			productosbodegasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productosbodegasAux.getEmpresa()));
			productosbodegasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productosbodegasAux.getSucursal()));
			productosbodegasAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productosbodegasAux.getBodega()));
			productosbodegasAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosbodegasAux.getLinea()));
			productosbodegasAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosbodegasAux.getLineaGrupo()));
			productosbodegasAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosbodegasAux.getLineaCategoria()));
			productosbodegasAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosbodegasAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductosBodegas(List<ProductosBodegas> productosbodegassTemp) throws Exception {
		for(ProductosBodegas productosbodegasAux:productosbodegassTemp) {
			
			productosbodegasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productosbodegasAux.getEmpresa()));
			productosbodegasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productosbodegasAux.getSucursal()));
			productosbodegasAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productosbodegasAux.getBodega()));
			productosbodegasAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosbodegasAux.getLinea()));
			productosbodegasAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosbodegasAux.getLineaGrupo()));
			productosbodegasAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosbodegasAux.getLineaCategoria()));
			productosbodegasAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosbodegasAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductosBodegas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				
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

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductosBodegas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
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

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductosBodegas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductosBodegasConstantesFunciones.getClassesRelationshipsOfProductosBodegas(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductosBodegas(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductosBodegas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductosBodegasConstantesFunciones.getClassesRelationshipsFromStringsOfProductosBodegas(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductosBodegas(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductosBodegas productosbodegas,List<ProductosBodegas> productosbodegass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProductosBodegas productosbodegas,List<ProductosBodegas> productosbodegass) throws Exception {
		try	{			
			for(ProductosBodegas productosbodegasLocal:productosbodegass) {
				if(productosbodegasLocal.getId().equals(productosbodegas.getId())) {
					productosbodegasLocal.setIsSelected(productosbodegas.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductosBodegas(List<ProductosBodegas> productosbodegassAux) throws Exception {
		//this.productosbodegassAux=productosbodegassAux;
		
		for(ProductosBodegas productosbodegasAux:productosbodegassAux) {
			if(productosbodegasAux.getIsChanged()) {
				productosbodegasAux.setIsChanged(false);
			}		
			
			if(productosbodegasAux.getIsNew()) {
				productosbodegasAux.setIsNew(false);
			}	
			
			if(productosbodegasAux.getIsDeleted()) {
				productosbodegasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductosBodegas(ProductosBodegas productosbodegasAux) throws Exception {
		//this.productosbodegasAux=productosbodegasAux;
		
			if(productosbodegasAux.getIsChanged()) {
				productosbodegasAux.setIsChanged(false);
			}		
			
			if(productosbodegasAux.getIsNew()) {
				productosbodegasAux.setIsNew(false);
			}	
			
			if(productosbodegasAux.getIsDeleted()) {
				productosbodegasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductosBodegas productosbodegasAsignar,ProductosBodegas productosbodegas) throws Exception {
		productosbodegasAsignar.setId(productosbodegas.getId());	
		productosbodegasAsignar.setVersionRow(productosbodegas.getVersionRow());	
		productosbodegasAsignar.setnombre_sucursal(productosbodegas.getnombre_sucursal());	
		productosbodegasAsignar.setnombre_linea(productosbodegas.getnombre_linea());	
		productosbodegasAsignar.setnombre_linea_grupo(productosbodegas.getnombre_linea_grupo());	
		productosbodegasAsignar.setnombre_linea_categoria(productosbodegas.getnombre_linea_categoria());	
		productosbodegasAsignar.setnombre_linea_marca(productosbodegas.getnombre_linea_marca());	
		productosbodegasAsignar.setcodigo(productosbodegas.getcodigo());	
		productosbodegasAsignar.setnombre(productosbodegas.getnombre());	
		productosbodegasAsignar.setnombre_bodega(productosbodegas.getnombre_bodega());	
	}
	
	public static void inicializarProductosBodegas(ProductosBodegas productosbodegas) throws Exception {
		try {
				productosbodegas.setId(0L);	
					
				productosbodegas.setnombre_sucursal("");	
				productosbodegas.setnombre_linea("");	
				productosbodegas.setnombre_linea_grupo("");	
				productosbodegas.setnombre_linea_categoria("");	
				productosbodegas.setnombre_linea_marca("");	
				productosbodegas.setcodigo("");	
				productosbodegas.setnombre("");	
				productosbodegas.setnombre_bodega("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductosBodegas(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosBodegasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosBodegasConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosBodegasConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosBodegasConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosBodegasConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosBodegasConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosBodegasConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosBodegasConstantesFunciones.LABEL_NOMBRESUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosBodegasConstantesFunciones.LABEL_NOMBRELINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosBodegasConstantesFunciones.LABEL_NOMBRELINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosBodegasConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosBodegasConstantesFunciones.LABEL_NOMBRELINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosBodegasConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosBodegasConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosBodegasConstantesFunciones.LABEL_NOMBREBODEGA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductosBodegas(String sTipo,Row row,Workbook workbook,ProductosBodegas productosbodegas,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productosbodegas.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosbodegas.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosbodegas.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosbodegas.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosbodegas.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosbodegas.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosbodegas.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosbodegas.getnombre_sucursal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosbodegas.getnombre_linea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosbodegas.getnombre_linea_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosbodegas.getnombre_linea_categoria());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosbodegas.getnombre_linea_marca());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosbodegas.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosbodegas.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosbodegas.getnombre_bodega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductosBodegas="";
	
	public String getsFinalQueryProductosBodegas() {
		return this.sFinalQueryProductosBodegas;
	}
	
	public void setsFinalQueryProductosBodegas(String sFinalQueryProductosBodegas) {
		this.sFinalQueryProductosBodegas= sFinalQueryProductosBodegas;
	}
	
	public Border resaltarSeleccionarProductosBodegas=null;
	
	public Border setResaltarSeleccionarProductosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBodegasBeanSwingJInternalFrame productosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productosbodegasBeanSwingJInternalFrame.jTtoolBarProductosBodegas.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductosBodegas= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductosBodegas() {
		return this.resaltarSeleccionarProductosBodegas;
	}
	
	public void setResaltarSeleccionarProductosBodegas(Border borderResaltarSeleccionarProductosBodegas) {
		this.resaltarSeleccionarProductosBodegas= borderResaltarSeleccionarProductosBodegas;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductosBodegas=null;
	public Boolean mostraridProductosBodegas=true;
	public Boolean activaridProductosBodegas=true;

	public Border resaltarid_empresaProductosBodegas=null;
	public Boolean mostrarid_empresaProductosBodegas=true;
	public Boolean activarid_empresaProductosBodegas=true;
	public Boolean cargarid_empresaProductosBodegas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProductosBodegas=false;//ConEventDepend=true

	public Border resaltarid_sucursalProductosBodegas=null;
	public Boolean mostrarid_sucursalProductosBodegas=true;
	public Boolean activarid_sucursalProductosBodegas=true;
	public Boolean cargarid_sucursalProductosBodegas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProductosBodegas=false;//ConEventDepend=true

	public Border resaltarid_bodegaProductosBodegas=null;
	public Boolean mostrarid_bodegaProductosBodegas=true;
	public Boolean activarid_bodegaProductosBodegas=true;
	public Boolean cargarid_bodegaProductosBodegas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaProductosBodegas=false;//ConEventDepend=true

	public Border resaltarid_lineaProductosBodegas=null;
	public Boolean mostrarid_lineaProductosBodegas=true;
	public Boolean activarid_lineaProductosBodegas=true;
	public Boolean cargarid_lineaProductosBodegas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaProductosBodegas=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoProductosBodegas=null;
	public Boolean mostrarid_linea_grupoProductosBodegas=true;
	public Boolean activarid_linea_grupoProductosBodegas=true;
	public Boolean cargarid_linea_grupoProductosBodegas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoProductosBodegas=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaProductosBodegas=null;
	public Boolean mostrarid_linea_categoriaProductosBodegas=true;
	public Boolean activarid_linea_categoriaProductosBodegas=true;
	public Boolean cargarid_linea_categoriaProductosBodegas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaProductosBodegas=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaProductosBodegas=null;
	public Boolean mostrarid_linea_marcaProductosBodegas=true;
	public Boolean activarid_linea_marcaProductosBodegas=true;
	public Boolean cargarid_linea_marcaProductosBodegas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaProductosBodegas=false;//ConEventDepend=true

	public Border resaltarnombre_sucursalProductosBodegas=null;
	public Boolean mostrarnombre_sucursalProductosBodegas=true;
	public Boolean activarnombre_sucursalProductosBodegas=true;

	public Border resaltarnombre_lineaProductosBodegas=null;
	public Boolean mostrarnombre_lineaProductosBodegas=true;
	public Boolean activarnombre_lineaProductosBodegas=true;

	public Border resaltarnombre_linea_grupoProductosBodegas=null;
	public Boolean mostrarnombre_linea_grupoProductosBodegas=true;
	public Boolean activarnombre_linea_grupoProductosBodegas=true;

	public Border resaltarnombre_linea_categoriaProductosBodegas=null;
	public Boolean mostrarnombre_linea_categoriaProductosBodegas=true;
	public Boolean activarnombre_linea_categoriaProductosBodegas=true;

	public Border resaltarnombre_linea_marcaProductosBodegas=null;
	public Boolean mostrarnombre_linea_marcaProductosBodegas=true;
	public Boolean activarnombre_linea_marcaProductosBodegas=true;

	public Border resaltarcodigoProductosBodegas=null;
	public Boolean mostrarcodigoProductosBodegas=true;
	public Boolean activarcodigoProductosBodegas=true;

	public Border resaltarnombreProductosBodegas=null;
	public Boolean mostrarnombreProductosBodegas=true;
	public Boolean activarnombreProductosBodegas=true;

	public Border resaltarnombre_bodegaProductosBodegas=null;
	public Boolean mostrarnombre_bodegaProductosBodegas=true;
	public Boolean activarnombre_bodegaProductosBodegas=true;

	
	

	public Border setResaltaridProductosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBodegasBeanSwingJInternalFrame productosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosbodegasBeanSwingJInternalFrame.jTtoolBarProductosBodegas.setBorder(borderResaltar);
		
		this.resaltaridProductosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductosBodegas() {
		return this.resaltaridProductosBodegas;
	}

	public void setResaltaridProductosBodegas(Border borderResaltar) {
		this.resaltaridProductosBodegas= borderResaltar;
	}

	public Boolean getMostraridProductosBodegas() {
		return this.mostraridProductosBodegas;
	}

	public void setMostraridProductosBodegas(Boolean mostraridProductosBodegas) {
		this.mostraridProductosBodegas= mostraridProductosBodegas;
	}

	public Boolean getActivaridProductosBodegas() {
		return this.activaridProductosBodegas;
	}

	public void setActivaridProductosBodegas(Boolean activaridProductosBodegas) {
		this.activaridProductosBodegas= activaridProductosBodegas;
	}

	public Border setResaltarid_empresaProductosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBodegasBeanSwingJInternalFrame productosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosbodegasBeanSwingJInternalFrame.jTtoolBarProductosBodegas.setBorder(borderResaltar);
		
		this.resaltarid_empresaProductosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProductosBodegas() {
		return this.resaltarid_empresaProductosBodegas;
	}

	public void setResaltarid_empresaProductosBodegas(Border borderResaltar) {
		this.resaltarid_empresaProductosBodegas= borderResaltar;
	}

	public Boolean getMostrarid_empresaProductosBodegas() {
		return this.mostrarid_empresaProductosBodegas;
	}

	public void setMostrarid_empresaProductosBodegas(Boolean mostrarid_empresaProductosBodegas) {
		this.mostrarid_empresaProductosBodegas= mostrarid_empresaProductosBodegas;
	}

	public Boolean getActivarid_empresaProductosBodegas() {
		return this.activarid_empresaProductosBodegas;
	}

	public void setActivarid_empresaProductosBodegas(Boolean activarid_empresaProductosBodegas) {
		this.activarid_empresaProductosBodegas= activarid_empresaProductosBodegas;
	}

	public Boolean getCargarid_empresaProductosBodegas() {
		return this.cargarid_empresaProductosBodegas;
	}

	public void setCargarid_empresaProductosBodegas(Boolean cargarid_empresaProductosBodegas) {
		this.cargarid_empresaProductosBodegas= cargarid_empresaProductosBodegas;
	}

	public Border setResaltarid_sucursalProductosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBodegasBeanSwingJInternalFrame productosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosbodegasBeanSwingJInternalFrame.jTtoolBarProductosBodegas.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProductosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProductosBodegas() {
		return this.resaltarid_sucursalProductosBodegas;
	}

	public void setResaltarid_sucursalProductosBodegas(Border borderResaltar) {
		this.resaltarid_sucursalProductosBodegas= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProductosBodegas() {
		return this.mostrarid_sucursalProductosBodegas;
	}

	public void setMostrarid_sucursalProductosBodegas(Boolean mostrarid_sucursalProductosBodegas) {
		this.mostrarid_sucursalProductosBodegas= mostrarid_sucursalProductosBodegas;
	}

	public Boolean getActivarid_sucursalProductosBodegas() {
		return this.activarid_sucursalProductosBodegas;
	}

	public void setActivarid_sucursalProductosBodegas(Boolean activarid_sucursalProductosBodegas) {
		this.activarid_sucursalProductosBodegas= activarid_sucursalProductosBodegas;
	}

	public Boolean getCargarid_sucursalProductosBodegas() {
		return this.cargarid_sucursalProductosBodegas;
	}

	public void setCargarid_sucursalProductosBodegas(Boolean cargarid_sucursalProductosBodegas) {
		this.cargarid_sucursalProductosBodegas= cargarid_sucursalProductosBodegas;
	}

	public Border setResaltarid_bodegaProductosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBodegasBeanSwingJInternalFrame productosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosbodegasBeanSwingJInternalFrame.jTtoolBarProductosBodegas.setBorder(borderResaltar);
		
		this.resaltarid_bodegaProductosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaProductosBodegas() {
		return this.resaltarid_bodegaProductosBodegas;
	}

	public void setResaltarid_bodegaProductosBodegas(Border borderResaltar) {
		this.resaltarid_bodegaProductosBodegas= borderResaltar;
	}

	public Boolean getMostrarid_bodegaProductosBodegas() {
		return this.mostrarid_bodegaProductosBodegas;
	}

	public void setMostrarid_bodegaProductosBodegas(Boolean mostrarid_bodegaProductosBodegas) {
		this.mostrarid_bodegaProductosBodegas= mostrarid_bodegaProductosBodegas;
	}

	public Boolean getActivarid_bodegaProductosBodegas() {
		return this.activarid_bodegaProductosBodegas;
	}

	public void setActivarid_bodegaProductosBodegas(Boolean activarid_bodegaProductosBodegas) {
		this.activarid_bodegaProductosBodegas= activarid_bodegaProductosBodegas;
	}

	public Boolean getCargarid_bodegaProductosBodegas() {
		return this.cargarid_bodegaProductosBodegas;
	}

	public void setCargarid_bodegaProductosBodegas(Boolean cargarid_bodegaProductosBodegas) {
		this.cargarid_bodegaProductosBodegas= cargarid_bodegaProductosBodegas;
	}

	public Border setResaltarid_lineaProductosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBodegasBeanSwingJInternalFrame productosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosbodegasBeanSwingJInternalFrame.jTtoolBarProductosBodegas.setBorder(borderResaltar);
		
		this.resaltarid_lineaProductosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaProductosBodegas() {
		return this.resaltarid_lineaProductosBodegas;
	}

	public void setResaltarid_lineaProductosBodegas(Border borderResaltar) {
		this.resaltarid_lineaProductosBodegas= borderResaltar;
	}

	public Boolean getMostrarid_lineaProductosBodegas() {
		return this.mostrarid_lineaProductosBodegas;
	}

	public void setMostrarid_lineaProductosBodegas(Boolean mostrarid_lineaProductosBodegas) {
		this.mostrarid_lineaProductosBodegas= mostrarid_lineaProductosBodegas;
	}

	public Boolean getActivarid_lineaProductosBodegas() {
		return this.activarid_lineaProductosBodegas;
	}

	public void setActivarid_lineaProductosBodegas(Boolean activarid_lineaProductosBodegas) {
		this.activarid_lineaProductosBodegas= activarid_lineaProductosBodegas;
	}

	public Boolean getCargarid_lineaProductosBodegas() {
		return this.cargarid_lineaProductosBodegas;
	}

	public void setCargarid_lineaProductosBodegas(Boolean cargarid_lineaProductosBodegas) {
		this.cargarid_lineaProductosBodegas= cargarid_lineaProductosBodegas;
	}

	public Border setResaltarid_linea_grupoProductosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBodegasBeanSwingJInternalFrame productosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosbodegasBeanSwingJInternalFrame.jTtoolBarProductosBodegas.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoProductosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoProductosBodegas() {
		return this.resaltarid_linea_grupoProductosBodegas;
	}

	public void setResaltarid_linea_grupoProductosBodegas(Border borderResaltar) {
		this.resaltarid_linea_grupoProductosBodegas= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoProductosBodegas() {
		return this.mostrarid_linea_grupoProductosBodegas;
	}

	public void setMostrarid_linea_grupoProductosBodegas(Boolean mostrarid_linea_grupoProductosBodegas) {
		this.mostrarid_linea_grupoProductosBodegas= mostrarid_linea_grupoProductosBodegas;
	}

	public Boolean getActivarid_linea_grupoProductosBodegas() {
		return this.activarid_linea_grupoProductosBodegas;
	}

	public void setActivarid_linea_grupoProductosBodegas(Boolean activarid_linea_grupoProductosBodegas) {
		this.activarid_linea_grupoProductosBodegas= activarid_linea_grupoProductosBodegas;
	}

	public Boolean getCargarid_linea_grupoProductosBodegas() {
		return this.cargarid_linea_grupoProductosBodegas;
	}

	public void setCargarid_linea_grupoProductosBodegas(Boolean cargarid_linea_grupoProductosBodegas) {
		this.cargarid_linea_grupoProductosBodegas= cargarid_linea_grupoProductosBodegas;
	}

	public Border setResaltarid_linea_categoriaProductosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBodegasBeanSwingJInternalFrame productosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosbodegasBeanSwingJInternalFrame.jTtoolBarProductosBodegas.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaProductosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaProductosBodegas() {
		return this.resaltarid_linea_categoriaProductosBodegas;
	}

	public void setResaltarid_linea_categoriaProductosBodegas(Border borderResaltar) {
		this.resaltarid_linea_categoriaProductosBodegas= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaProductosBodegas() {
		return this.mostrarid_linea_categoriaProductosBodegas;
	}

	public void setMostrarid_linea_categoriaProductosBodegas(Boolean mostrarid_linea_categoriaProductosBodegas) {
		this.mostrarid_linea_categoriaProductosBodegas= mostrarid_linea_categoriaProductosBodegas;
	}

	public Boolean getActivarid_linea_categoriaProductosBodegas() {
		return this.activarid_linea_categoriaProductosBodegas;
	}

	public void setActivarid_linea_categoriaProductosBodegas(Boolean activarid_linea_categoriaProductosBodegas) {
		this.activarid_linea_categoriaProductosBodegas= activarid_linea_categoriaProductosBodegas;
	}

	public Boolean getCargarid_linea_categoriaProductosBodegas() {
		return this.cargarid_linea_categoriaProductosBodegas;
	}

	public void setCargarid_linea_categoriaProductosBodegas(Boolean cargarid_linea_categoriaProductosBodegas) {
		this.cargarid_linea_categoriaProductosBodegas= cargarid_linea_categoriaProductosBodegas;
	}

	public Border setResaltarid_linea_marcaProductosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBodegasBeanSwingJInternalFrame productosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosbodegasBeanSwingJInternalFrame.jTtoolBarProductosBodegas.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaProductosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaProductosBodegas() {
		return this.resaltarid_linea_marcaProductosBodegas;
	}

	public void setResaltarid_linea_marcaProductosBodegas(Border borderResaltar) {
		this.resaltarid_linea_marcaProductosBodegas= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaProductosBodegas() {
		return this.mostrarid_linea_marcaProductosBodegas;
	}

	public void setMostrarid_linea_marcaProductosBodegas(Boolean mostrarid_linea_marcaProductosBodegas) {
		this.mostrarid_linea_marcaProductosBodegas= mostrarid_linea_marcaProductosBodegas;
	}

	public Boolean getActivarid_linea_marcaProductosBodegas() {
		return this.activarid_linea_marcaProductosBodegas;
	}

	public void setActivarid_linea_marcaProductosBodegas(Boolean activarid_linea_marcaProductosBodegas) {
		this.activarid_linea_marcaProductosBodegas= activarid_linea_marcaProductosBodegas;
	}

	public Boolean getCargarid_linea_marcaProductosBodegas() {
		return this.cargarid_linea_marcaProductosBodegas;
	}

	public void setCargarid_linea_marcaProductosBodegas(Boolean cargarid_linea_marcaProductosBodegas) {
		this.cargarid_linea_marcaProductosBodegas= cargarid_linea_marcaProductosBodegas;
	}

	public Border setResaltarnombre_sucursalProductosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBodegasBeanSwingJInternalFrame productosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosbodegasBeanSwingJInternalFrame.jTtoolBarProductosBodegas.setBorder(borderResaltar);
		
		this.resaltarnombre_sucursalProductosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sucursalProductosBodegas() {
		return this.resaltarnombre_sucursalProductosBodegas;
	}

	public void setResaltarnombre_sucursalProductosBodegas(Border borderResaltar) {
		this.resaltarnombre_sucursalProductosBodegas= borderResaltar;
	}

	public Boolean getMostrarnombre_sucursalProductosBodegas() {
		return this.mostrarnombre_sucursalProductosBodegas;
	}

	public void setMostrarnombre_sucursalProductosBodegas(Boolean mostrarnombre_sucursalProductosBodegas) {
		this.mostrarnombre_sucursalProductosBodegas= mostrarnombre_sucursalProductosBodegas;
	}

	public Boolean getActivarnombre_sucursalProductosBodegas() {
		return this.activarnombre_sucursalProductosBodegas;
	}

	public void setActivarnombre_sucursalProductosBodegas(Boolean activarnombre_sucursalProductosBodegas) {
		this.activarnombre_sucursalProductosBodegas= activarnombre_sucursalProductosBodegas;
	}

	public Border setResaltarnombre_lineaProductosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBodegasBeanSwingJInternalFrame productosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosbodegasBeanSwingJInternalFrame.jTtoolBarProductosBodegas.setBorder(borderResaltar);
		
		this.resaltarnombre_lineaProductosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_lineaProductosBodegas() {
		return this.resaltarnombre_lineaProductosBodegas;
	}

	public void setResaltarnombre_lineaProductosBodegas(Border borderResaltar) {
		this.resaltarnombre_lineaProductosBodegas= borderResaltar;
	}

	public Boolean getMostrarnombre_lineaProductosBodegas() {
		return this.mostrarnombre_lineaProductosBodegas;
	}

	public void setMostrarnombre_lineaProductosBodegas(Boolean mostrarnombre_lineaProductosBodegas) {
		this.mostrarnombre_lineaProductosBodegas= mostrarnombre_lineaProductosBodegas;
	}

	public Boolean getActivarnombre_lineaProductosBodegas() {
		return this.activarnombre_lineaProductosBodegas;
	}

	public void setActivarnombre_lineaProductosBodegas(Boolean activarnombre_lineaProductosBodegas) {
		this.activarnombre_lineaProductosBodegas= activarnombre_lineaProductosBodegas;
	}

	public Border setResaltarnombre_linea_grupoProductosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBodegasBeanSwingJInternalFrame productosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosbodegasBeanSwingJInternalFrame.jTtoolBarProductosBodegas.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_grupoProductosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_grupoProductosBodegas() {
		return this.resaltarnombre_linea_grupoProductosBodegas;
	}

	public void setResaltarnombre_linea_grupoProductosBodegas(Border borderResaltar) {
		this.resaltarnombre_linea_grupoProductosBodegas= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_grupoProductosBodegas() {
		return this.mostrarnombre_linea_grupoProductosBodegas;
	}

	public void setMostrarnombre_linea_grupoProductosBodegas(Boolean mostrarnombre_linea_grupoProductosBodegas) {
		this.mostrarnombre_linea_grupoProductosBodegas= mostrarnombre_linea_grupoProductosBodegas;
	}

	public Boolean getActivarnombre_linea_grupoProductosBodegas() {
		return this.activarnombre_linea_grupoProductosBodegas;
	}

	public void setActivarnombre_linea_grupoProductosBodegas(Boolean activarnombre_linea_grupoProductosBodegas) {
		this.activarnombre_linea_grupoProductosBodegas= activarnombre_linea_grupoProductosBodegas;
	}

	public Border setResaltarnombre_linea_categoriaProductosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBodegasBeanSwingJInternalFrame productosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosbodegasBeanSwingJInternalFrame.jTtoolBarProductosBodegas.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_categoriaProductosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_categoriaProductosBodegas() {
		return this.resaltarnombre_linea_categoriaProductosBodegas;
	}

	public void setResaltarnombre_linea_categoriaProductosBodegas(Border borderResaltar) {
		this.resaltarnombre_linea_categoriaProductosBodegas= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_categoriaProductosBodegas() {
		return this.mostrarnombre_linea_categoriaProductosBodegas;
	}

	public void setMostrarnombre_linea_categoriaProductosBodegas(Boolean mostrarnombre_linea_categoriaProductosBodegas) {
		this.mostrarnombre_linea_categoriaProductosBodegas= mostrarnombre_linea_categoriaProductosBodegas;
	}

	public Boolean getActivarnombre_linea_categoriaProductosBodegas() {
		return this.activarnombre_linea_categoriaProductosBodegas;
	}

	public void setActivarnombre_linea_categoriaProductosBodegas(Boolean activarnombre_linea_categoriaProductosBodegas) {
		this.activarnombre_linea_categoriaProductosBodegas= activarnombre_linea_categoriaProductosBodegas;
	}

	public Border setResaltarnombre_linea_marcaProductosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBodegasBeanSwingJInternalFrame productosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosbodegasBeanSwingJInternalFrame.jTtoolBarProductosBodegas.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_marcaProductosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_marcaProductosBodegas() {
		return this.resaltarnombre_linea_marcaProductosBodegas;
	}

	public void setResaltarnombre_linea_marcaProductosBodegas(Border borderResaltar) {
		this.resaltarnombre_linea_marcaProductosBodegas= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_marcaProductosBodegas() {
		return this.mostrarnombre_linea_marcaProductosBodegas;
	}

	public void setMostrarnombre_linea_marcaProductosBodegas(Boolean mostrarnombre_linea_marcaProductosBodegas) {
		this.mostrarnombre_linea_marcaProductosBodegas= mostrarnombre_linea_marcaProductosBodegas;
	}

	public Boolean getActivarnombre_linea_marcaProductosBodegas() {
		return this.activarnombre_linea_marcaProductosBodegas;
	}

	public void setActivarnombre_linea_marcaProductosBodegas(Boolean activarnombre_linea_marcaProductosBodegas) {
		this.activarnombre_linea_marcaProductosBodegas= activarnombre_linea_marcaProductosBodegas;
	}

	public Border setResaltarcodigoProductosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBodegasBeanSwingJInternalFrame productosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosbodegasBeanSwingJInternalFrame.jTtoolBarProductosBodegas.setBorder(borderResaltar);
		
		this.resaltarcodigoProductosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoProductosBodegas() {
		return this.resaltarcodigoProductosBodegas;
	}

	public void setResaltarcodigoProductosBodegas(Border borderResaltar) {
		this.resaltarcodigoProductosBodegas= borderResaltar;
	}

	public Boolean getMostrarcodigoProductosBodegas() {
		return this.mostrarcodigoProductosBodegas;
	}

	public void setMostrarcodigoProductosBodegas(Boolean mostrarcodigoProductosBodegas) {
		this.mostrarcodigoProductosBodegas= mostrarcodigoProductosBodegas;
	}

	public Boolean getActivarcodigoProductosBodegas() {
		return this.activarcodigoProductosBodegas;
	}

	public void setActivarcodigoProductosBodegas(Boolean activarcodigoProductosBodegas) {
		this.activarcodigoProductosBodegas= activarcodigoProductosBodegas;
	}

	public Border setResaltarnombreProductosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBodegasBeanSwingJInternalFrame productosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosbodegasBeanSwingJInternalFrame.jTtoolBarProductosBodegas.setBorder(borderResaltar);
		
		this.resaltarnombreProductosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreProductosBodegas() {
		return this.resaltarnombreProductosBodegas;
	}

	public void setResaltarnombreProductosBodegas(Border borderResaltar) {
		this.resaltarnombreProductosBodegas= borderResaltar;
	}

	public Boolean getMostrarnombreProductosBodegas() {
		return this.mostrarnombreProductosBodegas;
	}

	public void setMostrarnombreProductosBodegas(Boolean mostrarnombreProductosBodegas) {
		this.mostrarnombreProductosBodegas= mostrarnombreProductosBodegas;
	}

	public Boolean getActivarnombreProductosBodegas() {
		return this.activarnombreProductosBodegas;
	}

	public void setActivarnombreProductosBodegas(Boolean activarnombreProductosBodegas) {
		this.activarnombreProductosBodegas= activarnombreProductosBodegas;
	}

	public Border setResaltarnombre_bodegaProductosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBodegasBeanSwingJInternalFrame productosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosbodegasBeanSwingJInternalFrame.jTtoolBarProductosBodegas.setBorder(borderResaltar);
		
		this.resaltarnombre_bodegaProductosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bodegaProductosBodegas() {
		return this.resaltarnombre_bodegaProductosBodegas;
	}

	public void setResaltarnombre_bodegaProductosBodegas(Border borderResaltar) {
		this.resaltarnombre_bodegaProductosBodegas= borderResaltar;
	}

	public Boolean getMostrarnombre_bodegaProductosBodegas() {
		return this.mostrarnombre_bodegaProductosBodegas;
	}

	public void setMostrarnombre_bodegaProductosBodegas(Boolean mostrarnombre_bodegaProductosBodegas) {
		this.mostrarnombre_bodegaProductosBodegas= mostrarnombre_bodegaProductosBodegas;
	}

	public Boolean getActivarnombre_bodegaProductosBodegas() {
		return this.activarnombre_bodegaProductosBodegas;
	}

	public void setActivarnombre_bodegaProductosBodegas(Boolean activarnombre_bodegaProductosBodegas) {
		this.activarnombre_bodegaProductosBodegas= activarnombre_bodegaProductosBodegas;
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
		
		
		this.setMostraridProductosBodegas(esInicial);
		this.setMostrarid_empresaProductosBodegas(esInicial);
		this.setMostrarid_sucursalProductosBodegas(esInicial);
		this.setMostrarid_bodegaProductosBodegas(esInicial);
		this.setMostrarid_lineaProductosBodegas(esInicial);
		this.setMostrarid_linea_grupoProductosBodegas(esInicial);
		this.setMostrarid_linea_categoriaProductosBodegas(esInicial);
		this.setMostrarid_linea_marcaProductosBodegas(esInicial);
		this.setMostrarnombre_sucursalProductosBodegas(esInicial);
		this.setMostrarnombre_lineaProductosBodegas(esInicial);
		this.setMostrarnombre_linea_grupoProductosBodegas(esInicial);
		this.setMostrarnombre_linea_categoriaProductosBodegas(esInicial);
		this.setMostrarnombre_linea_marcaProductosBodegas(esInicial);
		this.setMostrarcodigoProductosBodegas(esInicial);
		this.setMostrarnombreProductosBodegas(esInicial);
		this.setMostrarnombre_bodegaProductosBodegas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.ID)) {
				this.setMostraridProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.NOMBRESUCURSAL)) {
				this.setMostrarnombre_sucursalProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.NOMBRELINEA)) {
				this.setMostrarnombre_lineaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setMostrarnombre_linea_grupoProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setMostrarnombre_linea_categoriaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setMostrarnombre_linea_marcaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.NOMBREBODEGA)) {
				this.setMostrarnombre_bodegaProductosBodegas(esAsigna);
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
		
		
		this.setActivaridProductosBodegas(esInicial);
		this.setActivarid_empresaProductosBodegas(esInicial);
		this.setActivarid_sucursalProductosBodegas(esInicial);
		this.setActivarid_bodegaProductosBodegas(esInicial);
		this.setActivarid_lineaProductosBodegas(esInicial);
		this.setActivarid_linea_grupoProductosBodegas(esInicial);
		this.setActivarid_linea_categoriaProductosBodegas(esInicial);
		this.setActivarid_linea_marcaProductosBodegas(esInicial);
		this.setActivarnombre_sucursalProductosBodegas(esInicial);
		this.setActivarnombre_lineaProductosBodegas(esInicial);
		this.setActivarnombre_linea_grupoProductosBodegas(esInicial);
		this.setActivarnombre_linea_categoriaProductosBodegas(esInicial);
		this.setActivarnombre_linea_marcaProductosBodegas(esInicial);
		this.setActivarcodigoProductosBodegas(esInicial);
		this.setActivarnombreProductosBodegas(esInicial);
		this.setActivarnombre_bodegaProductosBodegas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.ID)) {
				this.setActivaridProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.NOMBRESUCURSAL)) {
				this.setActivarnombre_sucursalProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.NOMBRELINEA)) {
				this.setActivarnombre_lineaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setActivarnombre_linea_grupoProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setActivarnombre_linea_categoriaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setActivarnombre_linea_marcaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.CODIGO)) {
				this.setActivarcodigoProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.NOMBRE)) {
				this.setActivarnombreProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.NOMBREBODEGA)) {
				this.setActivarnombre_bodegaProductosBodegas(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductosBodegasBeanSwingJInternalFrame productosbodegasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductosBodegas(esInicial);
		this.setResaltarid_empresaProductosBodegas(esInicial);
		this.setResaltarid_sucursalProductosBodegas(esInicial);
		this.setResaltarid_bodegaProductosBodegas(esInicial);
		this.setResaltarid_lineaProductosBodegas(esInicial);
		this.setResaltarid_linea_grupoProductosBodegas(esInicial);
		this.setResaltarid_linea_categoriaProductosBodegas(esInicial);
		this.setResaltarid_linea_marcaProductosBodegas(esInicial);
		this.setResaltarnombre_sucursalProductosBodegas(esInicial);
		this.setResaltarnombre_lineaProductosBodegas(esInicial);
		this.setResaltarnombre_linea_grupoProductosBodegas(esInicial);
		this.setResaltarnombre_linea_categoriaProductosBodegas(esInicial);
		this.setResaltarnombre_linea_marcaProductosBodegas(esInicial);
		this.setResaltarcodigoProductosBodegas(esInicial);
		this.setResaltarnombreProductosBodegas(esInicial);
		this.setResaltarnombre_bodegaProductosBodegas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.ID)) {
				this.setResaltaridProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.NOMBRESUCURSAL)) {
				this.setResaltarnombre_sucursalProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.NOMBRELINEA)) {
				this.setResaltarnombre_lineaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setResaltarnombre_linea_grupoProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setResaltarnombre_linea_categoriaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setResaltarnombre_linea_marcaProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreProductosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosBodegasConstantesFunciones.NOMBREBODEGA)) {
				this.setResaltarnombre_bodegaProductosBodegas(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductosBodegasBeanSwingJInternalFrame productosbodegasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProductosBodegasProductosBodegas=true;

	public Boolean getMostrarBusquedaProductosBodegasProductosBodegas() {
		return this.mostrarBusquedaProductosBodegasProductosBodegas;
	}

	public void setMostrarBusquedaProductosBodegasProductosBodegas(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProductosBodegasProductosBodegas= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProductosBodegasProductosBodegas=true;

	public Boolean getActivarBusquedaProductosBodegasProductosBodegas() {
		return this.activarBusquedaProductosBodegasProductosBodegas;
	}

	public void setActivarBusquedaProductosBodegasProductosBodegas(Boolean habilitarResaltar) {
		this.activarBusquedaProductosBodegasProductosBodegas= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProductosBodegasProductosBodegas=null;

	public Border getResaltarBusquedaProductosBodegasProductosBodegas() {
		return this.resaltarBusquedaProductosBodegasProductosBodegas;
	}

	public void setResaltarBusquedaProductosBodegasProductosBodegas(Border borderResaltar) {
		this.resaltarBusquedaProductosBodegasProductosBodegas= borderResaltar;
	}

	public void setResaltarBusquedaProductosBodegasProductosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosBodegasBeanSwingJInternalFrame productosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProductosBodegasProductosBodegas= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}