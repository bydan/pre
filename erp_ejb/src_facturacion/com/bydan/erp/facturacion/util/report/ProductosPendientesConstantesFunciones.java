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
package com.bydan.erp.facturacion.util.report;

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


import com.bydan.erp.facturacion.util.report.ProductosPendientesConstantesFunciones;
import com.bydan.erp.facturacion.util.report.ProductosPendientesParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.ProductosPendientesParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProductosPendientesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProductosPendientes";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductosPendientes"+ProductosPendientesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductosPendientesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductosPendientesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductosPendientesConstantesFunciones.SCHEMA+"_"+ProductosPendientesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductosPendientesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductosPendientesConstantesFunciones.SCHEMA+"_"+ProductosPendientesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductosPendientesConstantesFunciones.SCHEMA+"_"+ProductosPendientesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductosPendientesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductosPendientesConstantesFunciones.SCHEMA+"_"+ProductosPendientesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosPendientesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductosPendientesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosPendientesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosPendientesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductosPendientesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosPendientesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductosPendientesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductosPendientesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductosPendientesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductosPendientesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Productos Pendienteses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Productos Pendientes";
	public static final String SCLASSWEBTITULO_LOWER="Productos Pendientes";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductosPendientes";
	public static final String OBJECTNAME="productospendientes";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="productos_pendientes";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productospendientes from "+ProductosPendientesConstantesFunciones.SPERSISTENCENAME+" productospendientes";
	public static String QUERYSELECTNATIVE="select "+ProductosPendientesConstantesFunciones.SCHEMA+"."+ProductosPendientesConstantesFunciones.TABLENAME+".id,"+ProductosPendientesConstantesFunciones.SCHEMA+"."+ProductosPendientesConstantesFunciones.TABLENAME+".version_row,"+ProductosPendientesConstantesFunciones.SCHEMA+"."+ProductosPendientesConstantesFunciones.TABLENAME+".id_empresa,"+ProductosPendientesConstantesFunciones.SCHEMA+"."+ProductosPendientesConstantesFunciones.TABLENAME+".id_bodega,"+ProductosPendientesConstantesFunciones.SCHEMA+"."+ProductosPendientesConstantesFunciones.TABLENAME+".id_linea,"+ProductosPendientesConstantesFunciones.SCHEMA+"."+ProductosPendientesConstantesFunciones.TABLENAME+".id_linea_grupo,"+ProductosPendientesConstantesFunciones.SCHEMA+"."+ProductosPendientesConstantesFunciones.TABLENAME+".id_linea_categoria,"+ProductosPendientesConstantesFunciones.SCHEMA+"."+ProductosPendientesConstantesFunciones.TABLENAME+".id_linea_marca,"+ProductosPendientesConstantesFunciones.SCHEMA+"."+ProductosPendientesConstantesFunciones.TABLENAME+".fecha_emision_desde,"+ProductosPendientesConstantesFunciones.SCHEMA+"."+ProductosPendientesConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+ProductosPendientesConstantesFunciones.SCHEMA+"."+ProductosPendientesConstantesFunciones.TABLENAME+".nombre_empresa,"+ProductosPendientesConstantesFunciones.SCHEMA+"."+ProductosPendientesConstantesFunciones.TABLENAME+".ruc_empresa,"+ProductosPendientesConstantesFunciones.SCHEMA+"."+ProductosPendientesConstantesFunciones.TABLENAME+".nombre_producto,"+ProductosPendientesConstantesFunciones.SCHEMA+"."+ProductosPendientesConstantesFunciones.TABLENAME+".nombre_unidad,"+ProductosPendientesConstantesFunciones.SCHEMA+"."+ProductosPendientesConstantesFunciones.TABLENAME+".cantidad,"+ProductosPendientesConstantesFunciones.SCHEMA+"."+ProductosPendientesConstantesFunciones.TABLENAME+".precio,"+ProductosPendientesConstantesFunciones.SCHEMA+"."+ProductosPendientesConstantesFunciones.TABLENAME+".total,"+ProductosPendientesConstantesFunciones.SCHEMA+"."+ProductosPendientesConstantesFunciones.TABLENAME+".codigo_producto from "+ProductosPendientesConstantesFunciones.SCHEMA+"."+ProductosPendientesConstantesFunciones.TABLENAME;//+" as "+ProductosPendientesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBREEMPRESA= "nombre_empresa";
    public static final String RUCEMPRESA= "ruc_empresa";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String NOMBREUNIDAD= "nombre_unidad";
    public static final String CANTIDAD= "cantidad";
    public static final String PRECIO= "precio";
    public static final String TOTAL= "total";
    public static final String CODIGOPRODUCTO= "codigo_producto";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
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
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBREEMPRESA= "Nombre Empresa";
		public static final String LABEL_NOMBREEMPRESA_LOWER= "Nombre Empresa";
    	public static final String LABEL_RUCEMPRESA= "Ruc Empresa";
		public static final String LABEL_RUCEMPRESA_LOWER= "Ruc Empresa";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_NOMBREUNIDAD= "Nombre Unad";
		public static final String LABEL_NOMBREUNIDAD_LOWER= "Nombre Unidad";
    	public static final String LABEL_CANTIDAD= "Cantad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_CODIGOPRODUCTO= "Codigo Producto";
		public static final String LABEL_CODIGOPRODUCTO_LOWER= "Codigo Producto";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_EMPRESA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_EMPRESA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC_EMPRESA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC_EMPRESA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_UNIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_UNIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXCODIGO_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProductosPendientesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductosPendientesConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProductosPendientesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProductosPendientesConstantesFunciones.IDBODEGA)) {sLabelColumna=ProductosPendientesConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ProductosPendientesConstantesFunciones.IDLINEA)) {sLabelColumna=ProductosPendientesConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ProductosPendientesConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=ProductosPendientesConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(ProductosPendientesConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=ProductosPendientesConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(ProductosPendientesConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=ProductosPendientesConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(ProductosPendientesConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=ProductosPendientesConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(ProductosPendientesConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=ProductosPendientesConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(ProductosPendientesConstantesFunciones.NOMBREEMPRESA)) {sLabelColumna=ProductosPendientesConstantesFunciones.LABEL_NOMBREEMPRESA;}
		if(sNombreColumna.equals(ProductosPendientesConstantesFunciones.RUCEMPRESA)) {sLabelColumna=ProductosPendientesConstantesFunciones.LABEL_RUCEMPRESA;}
		if(sNombreColumna.equals(ProductosPendientesConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=ProductosPendientesConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(ProductosPendientesConstantesFunciones.NOMBREUNIDAD)) {sLabelColumna=ProductosPendientesConstantesFunciones.LABEL_NOMBREUNIDAD;}
		if(sNombreColumna.equals(ProductosPendientesConstantesFunciones.CANTIDAD)) {sLabelColumna=ProductosPendientesConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(ProductosPendientesConstantesFunciones.PRECIO)) {sLabelColumna=ProductosPendientesConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(ProductosPendientesConstantesFunciones.TOTAL)) {sLabelColumna=ProductosPendientesConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(ProductosPendientesConstantesFunciones.CODIGOPRODUCTO)) {sLabelColumna=ProductosPendientesConstantesFunciones.LABEL_CODIGOPRODUCTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProductosPendientesDescripcion(ProductosPendientes productospendientes) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productospendientes !=null/* && productospendientes.getId()!=0*/) {
			if(productospendientes.getId()!=null) {
				sDescripcion=productospendientes.getId().toString();
			}//productospendientesproductospendientes.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductosPendientesDescripcionDetallado(ProductosPendientes productospendientes) {
		String sDescripcion="";
			
		sDescripcion+=ProductosPendientesConstantesFunciones.ID+"=";
		sDescripcion+=productospendientes.getId().toString()+",";
		sDescripcion+=ProductosPendientesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productospendientes.getVersionRow().toString()+",";
		sDescripcion+=ProductosPendientesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=productospendientes.getid_empresa().toString()+",";
		sDescripcion+=ProductosPendientesConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=productospendientes.getid_bodega().toString()+",";
		sDescripcion+=ProductosPendientesConstantesFunciones.IDLINEA+"=";
		sDescripcion+=productospendientes.getid_linea().toString()+",";
		sDescripcion+=ProductosPendientesConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=productospendientes.getid_linea_grupo().toString()+",";
		sDescripcion+=ProductosPendientesConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=productospendientes.getid_linea_categoria().toString()+",";
		sDescripcion+=ProductosPendientesConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=productospendientes.getid_linea_marca().toString()+",";
		sDescripcion+=ProductosPendientesConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=productospendientes.getfecha_emision_desde().toString()+",";
		sDescripcion+=ProductosPendientesConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=productospendientes.getfecha_emision_hasta().toString()+",";
		sDescripcion+=ProductosPendientesConstantesFunciones.NOMBREEMPRESA+"=";
		sDescripcion+=productospendientes.getnombre_empresa()+",";
		sDescripcion+=ProductosPendientesConstantesFunciones.RUCEMPRESA+"=";
		sDescripcion+=productospendientes.getruc_empresa()+",";
		sDescripcion+=ProductosPendientesConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=productospendientes.getnombre_producto()+",";
		sDescripcion+=ProductosPendientesConstantesFunciones.NOMBREUNIDAD+"=";
		sDescripcion+=productospendientes.getnombre_unidad()+",";
		sDescripcion+=ProductosPendientesConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=productospendientes.getcantidad().toString()+",";
		sDescripcion+=ProductosPendientesConstantesFunciones.PRECIO+"=";
		sDescripcion+=productospendientes.getprecio().toString()+",";
		sDescripcion+=ProductosPendientesConstantesFunciones.TOTAL+"=";
		sDescripcion+=productospendientes.gettotal().toString()+",";
		sDescripcion+=ProductosPendientesConstantesFunciones.CODIGOPRODUCTO+"=";
		sDescripcion+=productospendientes.getcodigo_producto()+",";
			
		return sDescripcion;
	}
	
	public static void setProductosPendientesDescripcion(ProductosPendientes productospendientes,String sValor) throws Exception {			
		if(productospendientes !=null) {
			//productospendientesproductospendientes.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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
		} else if(sNombreIndice.equals("BusquedaProductosPendientes")) {
			sNombreIndice="Tipo=  Por Bodega Por Linea Por Linea Grupo Por Linea Categoria Por Linea Marca Por Fecha Emision Desde Por Fecha Emision Hasta";
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
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProductosPendientes(Long id_bodega,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();}
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();}
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();}
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();}
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
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
	
	
	
	
	
	
	public static void quitarEspaciosProductosPendientes(ProductosPendientes productospendientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productospendientes.setnombre_empresa(productospendientes.getnombre_empresa().trim());
		productospendientes.setruc_empresa(productospendientes.getruc_empresa().trim());
		productospendientes.setnombre_producto(productospendientes.getnombre_producto().trim());
		productospendientes.setnombre_unidad(productospendientes.getnombre_unidad().trim());
		productospendientes.setcodigo_producto(productospendientes.getcodigo_producto().trim());
	}
	
	public static void quitarEspaciosProductosPendientess(List<ProductosPendientes> productospendientess,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductosPendientes productospendientes: productospendientess) {
			productospendientes.setnombre_empresa(productospendientes.getnombre_empresa().trim());
			productospendientes.setruc_empresa(productospendientes.getruc_empresa().trim());
			productospendientes.setnombre_producto(productospendientes.getnombre_producto().trim());
			productospendientes.setnombre_unidad(productospendientes.getnombre_unidad().trim());
			productospendientes.setcodigo_producto(productospendientes.getcodigo_producto().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductosPendientes(ProductosPendientes productospendientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productospendientes.getConCambioAuxiliar()) {
			productospendientes.setIsDeleted(productospendientes.getIsDeletedAuxiliar());	
			productospendientes.setIsNew(productospendientes.getIsNewAuxiliar());	
			productospendientes.setIsChanged(productospendientes.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productospendientes.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productospendientes.setIsDeletedAuxiliar(false);	
			productospendientes.setIsNewAuxiliar(false);	
			productospendientes.setIsChangedAuxiliar(false);
			
			productospendientes.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductosPendientess(List<ProductosPendientes> productospendientess,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductosPendientes productospendientes : productospendientess) {
			if(conAsignarBase && productospendientes.getConCambioAuxiliar()) {
				productospendientes.setIsDeleted(productospendientes.getIsDeletedAuxiliar());	
				productospendientes.setIsNew(productospendientes.getIsNewAuxiliar());	
				productospendientes.setIsChanged(productospendientes.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productospendientes.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productospendientes.setIsDeletedAuxiliar(false);	
				productospendientes.setIsNewAuxiliar(false);	
				productospendientes.setIsChangedAuxiliar(false);
				
				productospendientes.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductosPendientes(ProductosPendientes productospendientes,Boolean conEnteros) throws Exception  {
		productospendientes.setprecio(0.0);
		productospendientes.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			productospendientes.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresProductosPendientess(List<ProductosPendientes> productospendientess,Boolean conEnteros) throws Exception  {
		
		for(ProductosPendientes productospendientes: productospendientess) {
			productospendientes.setprecio(0.0);
			productospendientes.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				productospendientes.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductosPendientes(List<ProductosPendientes> productospendientess,ProductosPendientes productospendientesAux) throws Exception  {
		ProductosPendientesConstantesFunciones.InicializarValoresProductosPendientes(productospendientesAux,true);
		
		for(ProductosPendientes productospendientes: productospendientess) {
			if(productospendientes.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productospendientesAux.setcantidad(productospendientesAux.getcantidad()+productospendientes.getcantidad());			
			productospendientesAux.setprecio(productospendientesAux.getprecio()+productospendientes.getprecio());			
			productospendientesAux.settotal(productospendientesAux.gettotal()+productospendientes.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosPendientes(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductosPendientesConstantesFunciones.getArrayColumnasGlobalesProductosPendientes(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosPendientes(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductosPendientesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductosPendientesConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductosPendientes(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductosPendientes> productospendientess,ProductosPendientes productospendientes,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductosPendientes productospendientesAux: productospendientess) {
			if(productospendientesAux!=null && productospendientes!=null) {
				if((productospendientesAux.getId()==null && productospendientes.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productospendientesAux.getId()!=null && productospendientes.getId()!=null){
					if(productospendientesAux.getId().equals(productospendientes.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductosPendientes(List<ProductosPendientes> productospendientess) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double totalTotal=0.0;
	
		for(ProductosPendientes productospendientes: productospendientess) {			
			if(productospendientes.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=productospendientes.getprecio();
			totalTotal+=productospendientes.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosPendientesConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(ProductosPendientesConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosPendientesConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(ProductosPendientesConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductosPendientes() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductosPendientesConstantesFunciones.LABEL_ID, ProductosPendientesConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosPendientesConstantesFunciones.LABEL_VERSIONROW, ProductosPendientesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosPendientesConstantesFunciones.LABEL_NOMBREEMPRESA, ProductosPendientesConstantesFunciones.NOMBREEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosPendientesConstantesFunciones.LABEL_RUCEMPRESA, ProductosPendientesConstantesFunciones.RUCEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosPendientesConstantesFunciones.LABEL_NOMBREPRODUCTO, ProductosPendientesConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosPendientesConstantesFunciones.LABEL_NOMBREUNIDAD, ProductosPendientesConstantesFunciones.NOMBREUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosPendientesConstantesFunciones.LABEL_CANTIDAD, ProductosPendientesConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosPendientesConstantesFunciones.LABEL_PRECIO, ProductosPendientesConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosPendientesConstantesFunciones.LABEL_TOTAL, ProductosPendientesConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosPendientesConstantesFunciones.LABEL_CODIGOPRODUCTO, ProductosPendientesConstantesFunciones.CODIGOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductosPendientes() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductosPendientesConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosPendientesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosPendientesConstantesFunciones.NOMBREEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosPendientesConstantesFunciones.RUCEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosPendientesConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosPendientesConstantesFunciones.NOMBREUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosPendientesConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosPendientesConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosPendientesConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosPendientesConstantesFunciones.CODIGOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosPendientes() throws Exception  {
		return ProductosPendientesConstantesFunciones.getTiposSeleccionarProductosPendientes(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosPendientes(Boolean conFk) throws Exception  {
		return ProductosPendientesConstantesFunciones.getTiposSeleccionarProductosPendientes(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosPendientes(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosPendientesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProductosPendientesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosPendientesConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ProductosPendientesConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosPendientesConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ProductosPendientesConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosPendientesConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(ProductosPendientesConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosPendientesConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(ProductosPendientesConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosPendientesConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(ProductosPendientesConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosPendientesConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(ProductosPendientesConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosPendientesConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(ProductosPendientesConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosPendientesConstantesFunciones.LABEL_NOMBREEMPRESA);
			reporte.setsDescripcion(ProductosPendientesConstantesFunciones.LABEL_NOMBREEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosPendientesConstantesFunciones.LABEL_RUCEMPRESA);
			reporte.setsDescripcion(ProductosPendientesConstantesFunciones.LABEL_RUCEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosPendientesConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(ProductosPendientesConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosPendientesConstantesFunciones.LABEL_NOMBREUNIDAD);
			reporte.setsDescripcion(ProductosPendientesConstantesFunciones.LABEL_NOMBREUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosPendientesConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(ProductosPendientesConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosPendientesConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(ProductosPendientesConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosPendientesConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(ProductosPendientesConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosPendientesConstantesFunciones.LABEL_CODIGOPRODUCTO);
			reporte.setsDescripcion(ProductosPendientesConstantesFunciones.LABEL_CODIGOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductosPendientes(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductosPendientes(ProductosPendientes productospendientesAux) throws Exception {
		
			productospendientesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productospendientesAux.getEmpresa()));
			productospendientesAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productospendientesAux.getBodega()));
			productospendientesAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(productospendientesAux.getLinea()));
			productospendientesAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(productospendientesAux.getLineaGrupo()));
			productospendientesAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(productospendientesAux.getLineaCategoria()));
			productospendientesAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(productospendientesAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductosPendientes(List<ProductosPendientes> productospendientessTemp) throws Exception {
		for(ProductosPendientes productospendientesAux:productospendientessTemp) {
			
			productospendientesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productospendientesAux.getEmpresa()));
			productospendientesAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productospendientesAux.getBodega()));
			productospendientesAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(productospendientesAux.getLinea()));
			productospendientesAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(productospendientesAux.getLineaGrupo()));
			productospendientesAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(productospendientesAux.getLineaCategoria()));
			productospendientesAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(productospendientesAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductosPendientes(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductosPendientes(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductosPendientes(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductosPendientesConstantesFunciones.getClassesRelationshipsOfProductosPendientes(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductosPendientes(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductosPendientes(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductosPendientesConstantesFunciones.getClassesRelationshipsFromStringsOfProductosPendientes(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductosPendientes(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductosPendientes productospendientes,List<ProductosPendientes> productospendientess,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProductosPendientes productospendientes,List<ProductosPendientes> productospendientess) throws Exception {
		try	{			
			for(ProductosPendientes productospendientesLocal:productospendientess) {
				if(productospendientesLocal.getId().equals(productospendientes.getId())) {
					productospendientesLocal.setIsSelected(productospendientes.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductosPendientes(List<ProductosPendientes> productospendientessAux) throws Exception {
		//this.productospendientessAux=productospendientessAux;
		
		for(ProductosPendientes productospendientesAux:productospendientessAux) {
			if(productospendientesAux.getIsChanged()) {
				productospendientesAux.setIsChanged(false);
			}		
			
			if(productospendientesAux.getIsNew()) {
				productospendientesAux.setIsNew(false);
			}	
			
			if(productospendientesAux.getIsDeleted()) {
				productospendientesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductosPendientes(ProductosPendientes productospendientesAux) throws Exception {
		//this.productospendientesAux=productospendientesAux;
		
			if(productospendientesAux.getIsChanged()) {
				productospendientesAux.setIsChanged(false);
			}		
			
			if(productospendientesAux.getIsNew()) {
				productospendientesAux.setIsNew(false);
			}	
			
			if(productospendientesAux.getIsDeleted()) {
				productospendientesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductosPendientes productospendientesAsignar,ProductosPendientes productospendientes) throws Exception {
		productospendientesAsignar.setId(productospendientes.getId());	
		productospendientesAsignar.setVersionRow(productospendientes.getVersionRow());	
		productospendientesAsignar.setnombre_empresa(productospendientes.getnombre_empresa());	
		productospendientesAsignar.setruc_empresa(productospendientes.getruc_empresa());	
		productospendientesAsignar.setnombre_producto(productospendientes.getnombre_producto());	
		productospendientesAsignar.setnombre_unidad(productospendientes.getnombre_unidad());	
		productospendientesAsignar.setcantidad(productospendientes.getcantidad());	
		productospendientesAsignar.setprecio(productospendientes.getprecio());	
		productospendientesAsignar.settotal(productospendientes.gettotal());	
		productospendientesAsignar.setcodigo_producto(productospendientes.getcodigo_producto());	
	}
	
	public static void inicializarProductosPendientes(ProductosPendientes productospendientes) throws Exception {
		try {
				productospendientes.setId(0L);	
					
				productospendientes.setnombre_empresa("");	
				productospendientes.setruc_empresa("");	
				productospendientes.setnombre_producto("");	
				productospendientes.setnombre_unidad("");	
				productospendientes.setcantidad(0);	
				productospendientes.setprecio(0.0);	
				productospendientes.settotal(0.0);	
				productospendientes.setcodigo_producto("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductosPendientes(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosPendientesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosPendientesConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosPendientesConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosPendientesConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosPendientesConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosPendientesConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosPendientesConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosPendientesConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosPendientesConstantesFunciones.LABEL_NOMBREEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosPendientesConstantesFunciones.LABEL_RUCEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosPendientesConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosPendientesConstantesFunciones.LABEL_NOMBREUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosPendientesConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosPendientesConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosPendientesConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosPendientesConstantesFunciones.LABEL_CODIGOPRODUCTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductosPendientes(String sTipo,Row row,Workbook workbook,ProductosPendientes productospendientes,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productospendientes.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productospendientes.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productospendientes.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productospendientes.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productospendientes.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productospendientes.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productospendientes.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productospendientes.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productospendientes.getnombre_empresa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productospendientes.getruc_empresa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productospendientes.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productospendientes.getnombre_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productospendientes.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productospendientes.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productospendientes.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productospendientes.getcodigo_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductosPendientes="";
	
	public String getsFinalQueryProductosPendientes() {
		return this.sFinalQueryProductosPendientes;
	}
	
	public void setsFinalQueryProductosPendientes(String sFinalQueryProductosPendientes) {
		this.sFinalQueryProductosPendientes= sFinalQueryProductosPendientes;
	}
	
	public Border resaltarSeleccionarProductosPendientes=null;
	
	public Border setResaltarSeleccionarProductosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosPendientesBeanSwingJInternalFrame productospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productospendientesBeanSwingJInternalFrame.jTtoolBarProductosPendientes.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductosPendientes= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductosPendientes() {
		return this.resaltarSeleccionarProductosPendientes;
	}
	
	public void setResaltarSeleccionarProductosPendientes(Border borderResaltarSeleccionarProductosPendientes) {
		this.resaltarSeleccionarProductosPendientes= borderResaltarSeleccionarProductosPendientes;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductosPendientes=null;
	public Boolean mostraridProductosPendientes=true;
	public Boolean activaridProductosPendientes=true;

	public Border resaltarid_empresaProductosPendientes=null;
	public Boolean mostrarid_empresaProductosPendientes=true;
	public Boolean activarid_empresaProductosPendientes=true;
	public Boolean cargarid_empresaProductosPendientes=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProductosPendientes=false;//ConEventDepend=true

	public Border resaltarid_bodegaProductosPendientes=null;
	public Boolean mostrarid_bodegaProductosPendientes=true;
	public Boolean activarid_bodegaProductosPendientes=true;
	public Boolean cargarid_bodegaProductosPendientes=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaProductosPendientes=false;//ConEventDepend=true

	public Border resaltarid_lineaProductosPendientes=null;
	public Boolean mostrarid_lineaProductosPendientes=true;
	public Boolean activarid_lineaProductosPendientes=true;
	public Boolean cargarid_lineaProductosPendientes=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaProductosPendientes=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoProductosPendientes=null;
	public Boolean mostrarid_linea_grupoProductosPendientes=true;
	public Boolean activarid_linea_grupoProductosPendientes=true;
	public Boolean cargarid_linea_grupoProductosPendientes=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoProductosPendientes=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaProductosPendientes=null;
	public Boolean mostrarid_linea_categoriaProductosPendientes=true;
	public Boolean activarid_linea_categoriaProductosPendientes=true;
	public Boolean cargarid_linea_categoriaProductosPendientes=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaProductosPendientes=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaProductosPendientes=null;
	public Boolean mostrarid_linea_marcaProductosPendientes=true;
	public Boolean activarid_linea_marcaProductosPendientes=true;
	public Boolean cargarid_linea_marcaProductosPendientes=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaProductosPendientes=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeProductosPendientes=null;
	public Boolean mostrarfecha_emision_desdeProductosPendientes=true;
	public Boolean activarfecha_emision_desdeProductosPendientes=true;

	public Border resaltarfecha_emision_hastaProductosPendientes=null;
	public Boolean mostrarfecha_emision_hastaProductosPendientes=true;
	public Boolean activarfecha_emision_hastaProductosPendientes=true;

	public Border resaltarnombre_empresaProductosPendientes=null;
	public Boolean mostrarnombre_empresaProductosPendientes=true;
	public Boolean activarnombre_empresaProductosPendientes=true;

	public Border resaltarruc_empresaProductosPendientes=null;
	public Boolean mostrarruc_empresaProductosPendientes=true;
	public Boolean activarruc_empresaProductosPendientes=true;

	public Border resaltarnombre_productoProductosPendientes=null;
	public Boolean mostrarnombre_productoProductosPendientes=true;
	public Boolean activarnombre_productoProductosPendientes=true;

	public Border resaltarnombre_unidadProductosPendientes=null;
	public Boolean mostrarnombre_unidadProductosPendientes=true;
	public Boolean activarnombre_unidadProductosPendientes=true;

	public Border resaltarcantidadProductosPendientes=null;
	public Boolean mostrarcantidadProductosPendientes=true;
	public Boolean activarcantidadProductosPendientes=true;

	public Border resaltarprecioProductosPendientes=null;
	public Boolean mostrarprecioProductosPendientes=true;
	public Boolean activarprecioProductosPendientes=true;

	public Border resaltartotalProductosPendientes=null;
	public Boolean mostrartotalProductosPendientes=true;
	public Boolean activartotalProductosPendientes=true;

	public Border resaltarcodigo_productoProductosPendientes=null;
	public Boolean mostrarcodigo_productoProductosPendientes=true;
	public Boolean activarcodigo_productoProductosPendientes=true;

	
	

	public Border setResaltaridProductosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosPendientesBeanSwingJInternalFrame productospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productospendientesBeanSwingJInternalFrame.jTtoolBarProductosPendientes.setBorder(borderResaltar);
		
		this.resaltaridProductosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductosPendientes() {
		return this.resaltaridProductosPendientes;
	}

	public void setResaltaridProductosPendientes(Border borderResaltar) {
		this.resaltaridProductosPendientes= borderResaltar;
	}

	public Boolean getMostraridProductosPendientes() {
		return this.mostraridProductosPendientes;
	}

	public void setMostraridProductosPendientes(Boolean mostraridProductosPendientes) {
		this.mostraridProductosPendientes= mostraridProductosPendientes;
	}

	public Boolean getActivaridProductosPendientes() {
		return this.activaridProductosPendientes;
	}

	public void setActivaridProductosPendientes(Boolean activaridProductosPendientes) {
		this.activaridProductosPendientes= activaridProductosPendientes;
	}

	public Border setResaltarid_empresaProductosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosPendientesBeanSwingJInternalFrame productospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productospendientesBeanSwingJInternalFrame.jTtoolBarProductosPendientes.setBorder(borderResaltar);
		
		this.resaltarid_empresaProductosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProductosPendientes() {
		return this.resaltarid_empresaProductosPendientes;
	}

	public void setResaltarid_empresaProductosPendientes(Border borderResaltar) {
		this.resaltarid_empresaProductosPendientes= borderResaltar;
	}

	public Boolean getMostrarid_empresaProductosPendientes() {
		return this.mostrarid_empresaProductosPendientes;
	}

	public void setMostrarid_empresaProductosPendientes(Boolean mostrarid_empresaProductosPendientes) {
		this.mostrarid_empresaProductosPendientes= mostrarid_empresaProductosPendientes;
	}

	public Boolean getActivarid_empresaProductosPendientes() {
		return this.activarid_empresaProductosPendientes;
	}

	public void setActivarid_empresaProductosPendientes(Boolean activarid_empresaProductosPendientes) {
		this.activarid_empresaProductosPendientes= activarid_empresaProductosPendientes;
	}

	public Boolean getCargarid_empresaProductosPendientes() {
		return this.cargarid_empresaProductosPendientes;
	}

	public void setCargarid_empresaProductosPendientes(Boolean cargarid_empresaProductosPendientes) {
		this.cargarid_empresaProductosPendientes= cargarid_empresaProductosPendientes;
	}

	public Border setResaltarid_bodegaProductosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosPendientesBeanSwingJInternalFrame productospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productospendientesBeanSwingJInternalFrame.jTtoolBarProductosPendientes.setBorder(borderResaltar);
		
		this.resaltarid_bodegaProductosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaProductosPendientes() {
		return this.resaltarid_bodegaProductosPendientes;
	}

	public void setResaltarid_bodegaProductosPendientes(Border borderResaltar) {
		this.resaltarid_bodegaProductosPendientes= borderResaltar;
	}

	public Boolean getMostrarid_bodegaProductosPendientes() {
		return this.mostrarid_bodegaProductosPendientes;
	}

	public void setMostrarid_bodegaProductosPendientes(Boolean mostrarid_bodegaProductosPendientes) {
		this.mostrarid_bodegaProductosPendientes= mostrarid_bodegaProductosPendientes;
	}

	public Boolean getActivarid_bodegaProductosPendientes() {
		return this.activarid_bodegaProductosPendientes;
	}

	public void setActivarid_bodegaProductosPendientes(Boolean activarid_bodegaProductosPendientes) {
		this.activarid_bodegaProductosPendientes= activarid_bodegaProductosPendientes;
	}

	public Boolean getCargarid_bodegaProductosPendientes() {
		return this.cargarid_bodegaProductosPendientes;
	}

	public void setCargarid_bodegaProductosPendientes(Boolean cargarid_bodegaProductosPendientes) {
		this.cargarid_bodegaProductosPendientes= cargarid_bodegaProductosPendientes;
	}

	public Border setResaltarid_lineaProductosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosPendientesBeanSwingJInternalFrame productospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productospendientesBeanSwingJInternalFrame.jTtoolBarProductosPendientes.setBorder(borderResaltar);
		
		this.resaltarid_lineaProductosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaProductosPendientes() {
		return this.resaltarid_lineaProductosPendientes;
	}

	public void setResaltarid_lineaProductosPendientes(Border borderResaltar) {
		this.resaltarid_lineaProductosPendientes= borderResaltar;
	}

	public Boolean getMostrarid_lineaProductosPendientes() {
		return this.mostrarid_lineaProductosPendientes;
	}

	public void setMostrarid_lineaProductosPendientes(Boolean mostrarid_lineaProductosPendientes) {
		this.mostrarid_lineaProductosPendientes= mostrarid_lineaProductosPendientes;
	}

	public Boolean getActivarid_lineaProductosPendientes() {
		return this.activarid_lineaProductosPendientes;
	}

	public void setActivarid_lineaProductosPendientes(Boolean activarid_lineaProductosPendientes) {
		this.activarid_lineaProductosPendientes= activarid_lineaProductosPendientes;
	}

	public Boolean getCargarid_lineaProductosPendientes() {
		return this.cargarid_lineaProductosPendientes;
	}

	public void setCargarid_lineaProductosPendientes(Boolean cargarid_lineaProductosPendientes) {
		this.cargarid_lineaProductosPendientes= cargarid_lineaProductosPendientes;
	}

	public Border setResaltarid_linea_grupoProductosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosPendientesBeanSwingJInternalFrame productospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productospendientesBeanSwingJInternalFrame.jTtoolBarProductosPendientes.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoProductosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoProductosPendientes() {
		return this.resaltarid_linea_grupoProductosPendientes;
	}

	public void setResaltarid_linea_grupoProductosPendientes(Border borderResaltar) {
		this.resaltarid_linea_grupoProductosPendientes= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoProductosPendientes() {
		return this.mostrarid_linea_grupoProductosPendientes;
	}

	public void setMostrarid_linea_grupoProductosPendientes(Boolean mostrarid_linea_grupoProductosPendientes) {
		this.mostrarid_linea_grupoProductosPendientes= mostrarid_linea_grupoProductosPendientes;
	}

	public Boolean getActivarid_linea_grupoProductosPendientes() {
		return this.activarid_linea_grupoProductosPendientes;
	}

	public void setActivarid_linea_grupoProductosPendientes(Boolean activarid_linea_grupoProductosPendientes) {
		this.activarid_linea_grupoProductosPendientes= activarid_linea_grupoProductosPendientes;
	}

	public Boolean getCargarid_linea_grupoProductosPendientes() {
		return this.cargarid_linea_grupoProductosPendientes;
	}

	public void setCargarid_linea_grupoProductosPendientes(Boolean cargarid_linea_grupoProductosPendientes) {
		this.cargarid_linea_grupoProductosPendientes= cargarid_linea_grupoProductosPendientes;
	}

	public Border setResaltarid_linea_categoriaProductosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosPendientesBeanSwingJInternalFrame productospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productospendientesBeanSwingJInternalFrame.jTtoolBarProductosPendientes.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaProductosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaProductosPendientes() {
		return this.resaltarid_linea_categoriaProductosPendientes;
	}

	public void setResaltarid_linea_categoriaProductosPendientes(Border borderResaltar) {
		this.resaltarid_linea_categoriaProductosPendientes= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaProductosPendientes() {
		return this.mostrarid_linea_categoriaProductosPendientes;
	}

	public void setMostrarid_linea_categoriaProductosPendientes(Boolean mostrarid_linea_categoriaProductosPendientes) {
		this.mostrarid_linea_categoriaProductosPendientes= mostrarid_linea_categoriaProductosPendientes;
	}

	public Boolean getActivarid_linea_categoriaProductosPendientes() {
		return this.activarid_linea_categoriaProductosPendientes;
	}

	public void setActivarid_linea_categoriaProductosPendientes(Boolean activarid_linea_categoriaProductosPendientes) {
		this.activarid_linea_categoriaProductosPendientes= activarid_linea_categoriaProductosPendientes;
	}

	public Boolean getCargarid_linea_categoriaProductosPendientes() {
		return this.cargarid_linea_categoriaProductosPendientes;
	}

	public void setCargarid_linea_categoriaProductosPendientes(Boolean cargarid_linea_categoriaProductosPendientes) {
		this.cargarid_linea_categoriaProductosPendientes= cargarid_linea_categoriaProductosPendientes;
	}

	public Border setResaltarid_linea_marcaProductosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosPendientesBeanSwingJInternalFrame productospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productospendientesBeanSwingJInternalFrame.jTtoolBarProductosPendientes.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaProductosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaProductosPendientes() {
		return this.resaltarid_linea_marcaProductosPendientes;
	}

	public void setResaltarid_linea_marcaProductosPendientes(Border borderResaltar) {
		this.resaltarid_linea_marcaProductosPendientes= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaProductosPendientes() {
		return this.mostrarid_linea_marcaProductosPendientes;
	}

	public void setMostrarid_linea_marcaProductosPendientes(Boolean mostrarid_linea_marcaProductosPendientes) {
		this.mostrarid_linea_marcaProductosPendientes= mostrarid_linea_marcaProductosPendientes;
	}

	public Boolean getActivarid_linea_marcaProductosPendientes() {
		return this.activarid_linea_marcaProductosPendientes;
	}

	public void setActivarid_linea_marcaProductosPendientes(Boolean activarid_linea_marcaProductosPendientes) {
		this.activarid_linea_marcaProductosPendientes= activarid_linea_marcaProductosPendientes;
	}

	public Boolean getCargarid_linea_marcaProductosPendientes() {
		return this.cargarid_linea_marcaProductosPendientes;
	}

	public void setCargarid_linea_marcaProductosPendientes(Boolean cargarid_linea_marcaProductosPendientes) {
		this.cargarid_linea_marcaProductosPendientes= cargarid_linea_marcaProductosPendientes;
	}

	public Border setResaltarfecha_emision_desdeProductosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosPendientesBeanSwingJInternalFrame productospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productospendientesBeanSwingJInternalFrame.jTtoolBarProductosPendientes.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeProductosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeProductosPendientes() {
		return this.resaltarfecha_emision_desdeProductosPendientes;
	}

	public void setResaltarfecha_emision_desdeProductosPendientes(Border borderResaltar) {
		this.resaltarfecha_emision_desdeProductosPendientes= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeProductosPendientes() {
		return this.mostrarfecha_emision_desdeProductosPendientes;
	}

	public void setMostrarfecha_emision_desdeProductosPendientes(Boolean mostrarfecha_emision_desdeProductosPendientes) {
		this.mostrarfecha_emision_desdeProductosPendientes= mostrarfecha_emision_desdeProductosPendientes;
	}

	public Boolean getActivarfecha_emision_desdeProductosPendientes() {
		return this.activarfecha_emision_desdeProductosPendientes;
	}

	public void setActivarfecha_emision_desdeProductosPendientes(Boolean activarfecha_emision_desdeProductosPendientes) {
		this.activarfecha_emision_desdeProductosPendientes= activarfecha_emision_desdeProductosPendientes;
	}

	public Border setResaltarfecha_emision_hastaProductosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosPendientesBeanSwingJInternalFrame productospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productospendientesBeanSwingJInternalFrame.jTtoolBarProductosPendientes.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaProductosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaProductosPendientes() {
		return this.resaltarfecha_emision_hastaProductosPendientes;
	}

	public void setResaltarfecha_emision_hastaProductosPendientes(Border borderResaltar) {
		this.resaltarfecha_emision_hastaProductosPendientes= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaProductosPendientes() {
		return this.mostrarfecha_emision_hastaProductosPendientes;
	}

	public void setMostrarfecha_emision_hastaProductosPendientes(Boolean mostrarfecha_emision_hastaProductosPendientes) {
		this.mostrarfecha_emision_hastaProductosPendientes= mostrarfecha_emision_hastaProductosPendientes;
	}

	public Boolean getActivarfecha_emision_hastaProductosPendientes() {
		return this.activarfecha_emision_hastaProductosPendientes;
	}

	public void setActivarfecha_emision_hastaProductosPendientes(Boolean activarfecha_emision_hastaProductosPendientes) {
		this.activarfecha_emision_hastaProductosPendientes= activarfecha_emision_hastaProductosPendientes;
	}

	public Border setResaltarnombre_empresaProductosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosPendientesBeanSwingJInternalFrame productospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productospendientesBeanSwingJInternalFrame.jTtoolBarProductosPendientes.setBorder(borderResaltar);
		
		this.resaltarnombre_empresaProductosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_empresaProductosPendientes() {
		return this.resaltarnombre_empresaProductosPendientes;
	}

	public void setResaltarnombre_empresaProductosPendientes(Border borderResaltar) {
		this.resaltarnombre_empresaProductosPendientes= borderResaltar;
	}

	public Boolean getMostrarnombre_empresaProductosPendientes() {
		return this.mostrarnombre_empresaProductosPendientes;
	}

	public void setMostrarnombre_empresaProductosPendientes(Boolean mostrarnombre_empresaProductosPendientes) {
		this.mostrarnombre_empresaProductosPendientes= mostrarnombre_empresaProductosPendientes;
	}

	public Boolean getActivarnombre_empresaProductosPendientes() {
		return this.activarnombre_empresaProductosPendientes;
	}

	public void setActivarnombre_empresaProductosPendientes(Boolean activarnombre_empresaProductosPendientes) {
		this.activarnombre_empresaProductosPendientes= activarnombre_empresaProductosPendientes;
	}

	public Border setResaltarruc_empresaProductosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosPendientesBeanSwingJInternalFrame productospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productospendientesBeanSwingJInternalFrame.jTtoolBarProductosPendientes.setBorder(borderResaltar);
		
		this.resaltarruc_empresaProductosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarruc_empresaProductosPendientes() {
		return this.resaltarruc_empresaProductosPendientes;
	}

	public void setResaltarruc_empresaProductosPendientes(Border borderResaltar) {
		this.resaltarruc_empresaProductosPendientes= borderResaltar;
	}

	public Boolean getMostrarruc_empresaProductosPendientes() {
		return this.mostrarruc_empresaProductosPendientes;
	}

	public void setMostrarruc_empresaProductosPendientes(Boolean mostrarruc_empresaProductosPendientes) {
		this.mostrarruc_empresaProductosPendientes= mostrarruc_empresaProductosPendientes;
	}

	public Boolean getActivarruc_empresaProductosPendientes() {
		return this.activarruc_empresaProductosPendientes;
	}

	public void setActivarruc_empresaProductosPendientes(Boolean activarruc_empresaProductosPendientes) {
		this.activarruc_empresaProductosPendientes= activarruc_empresaProductosPendientes;
	}

	public Border setResaltarnombre_productoProductosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosPendientesBeanSwingJInternalFrame productospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productospendientesBeanSwingJInternalFrame.jTtoolBarProductosPendientes.setBorder(borderResaltar);
		
		this.resaltarnombre_productoProductosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoProductosPendientes() {
		return this.resaltarnombre_productoProductosPendientes;
	}

	public void setResaltarnombre_productoProductosPendientes(Border borderResaltar) {
		this.resaltarnombre_productoProductosPendientes= borderResaltar;
	}

	public Boolean getMostrarnombre_productoProductosPendientes() {
		return this.mostrarnombre_productoProductosPendientes;
	}

	public void setMostrarnombre_productoProductosPendientes(Boolean mostrarnombre_productoProductosPendientes) {
		this.mostrarnombre_productoProductosPendientes= mostrarnombre_productoProductosPendientes;
	}

	public Boolean getActivarnombre_productoProductosPendientes() {
		return this.activarnombre_productoProductosPendientes;
	}

	public void setActivarnombre_productoProductosPendientes(Boolean activarnombre_productoProductosPendientes) {
		this.activarnombre_productoProductosPendientes= activarnombre_productoProductosPendientes;
	}

	public Border setResaltarnombre_unidadProductosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosPendientesBeanSwingJInternalFrame productospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productospendientesBeanSwingJInternalFrame.jTtoolBarProductosPendientes.setBorder(borderResaltar);
		
		this.resaltarnombre_unidadProductosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_unidadProductosPendientes() {
		return this.resaltarnombre_unidadProductosPendientes;
	}

	public void setResaltarnombre_unidadProductosPendientes(Border borderResaltar) {
		this.resaltarnombre_unidadProductosPendientes= borderResaltar;
	}

	public Boolean getMostrarnombre_unidadProductosPendientes() {
		return this.mostrarnombre_unidadProductosPendientes;
	}

	public void setMostrarnombre_unidadProductosPendientes(Boolean mostrarnombre_unidadProductosPendientes) {
		this.mostrarnombre_unidadProductosPendientes= mostrarnombre_unidadProductosPendientes;
	}

	public Boolean getActivarnombre_unidadProductosPendientes() {
		return this.activarnombre_unidadProductosPendientes;
	}

	public void setActivarnombre_unidadProductosPendientes(Boolean activarnombre_unidadProductosPendientes) {
		this.activarnombre_unidadProductosPendientes= activarnombre_unidadProductosPendientes;
	}

	public Border setResaltarcantidadProductosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosPendientesBeanSwingJInternalFrame productospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productospendientesBeanSwingJInternalFrame.jTtoolBarProductosPendientes.setBorder(borderResaltar);
		
		this.resaltarcantidadProductosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadProductosPendientes() {
		return this.resaltarcantidadProductosPendientes;
	}

	public void setResaltarcantidadProductosPendientes(Border borderResaltar) {
		this.resaltarcantidadProductosPendientes= borderResaltar;
	}

	public Boolean getMostrarcantidadProductosPendientes() {
		return this.mostrarcantidadProductosPendientes;
	}

	public void setMostrarcantidadProductosPendientes(Boolean mostrarcantidadProductosPendientes) {
		this.mostrarcantidadProductosPendientes= mostrarcantidadProductosPendientes;
	}

	public Boolean getActivarcantidadProductosPendientes() {
		return this.activarcantidadProductosPendientes;
	}

	public void setActivarcantidadProductosPendientes(Boolean activarcantidadProductosPendientes) {
		this.activarcantidadProductosPendientes= activarcantidadProductosPendientes;
	}

	public Border setResaltarprecioProductosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosPendientesBeanSwingJInternalFrame productospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productospendientesBeanSwingJInternalFrame.jTtoolBarProductosPendientes.setBorder(borderResaltar);
		
		this.resaltarprecioProductosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioProductosPendientes() {
		return this.resaltarprecioProductosPendientes;
	}

	public void setResaltarprecioProductosPendientes(Border borderResaltar) {
		this.resaltarprecioProductosPendientes= borderResaltar;
	}

	public Boolean getMostrarprecioProductosPendientes() {
		return this.mostrarprecioProductosPendientes;
	}

	public void setMostrarprecioProductosPendientes(Boolean mostrarprecioProductosPendientes) {
		this.mostrarprecioProductosPendientes= mostrarprecioProductosPendientes;
	}

	public Boolean getActivarprecioProductosPendientes() {
		return this.activarprecioProductosPendientes;
	}

	public void setActivarprecioProductosPendientes(Boolean activarprecioProductosPendientes) {
		this.activarprecioProductosPendientes= activarprecioProductosPendientes;
	}

	public Border setResaltartotalProductosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosPendientesBeanSwingJInternalFrame productospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productospendientesBeanSwingJInternalFrame.jTtoolBarProductosPendientes.setBorder(borderResaltar);
		
		this.resaltartotalProductosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalProductosPendientes() {
		return this.resaltartotalProductosPendientes;
	}

	public void setResaltartotalProductosPendientes(Border borderResaltar) {
		this.resaltartotalProductosPendientes= borderResaltar;
	}

	public Boolean getMostrartotalProductosPendientes() {
		return this.mostrartotalProductosPendientes;
	}

	public void setMostrartotalProductosPendientes(Boolean mostrartotalProductosPendientes) {
		this.mostrartotalProductosPendientes= mostrartotalProductosPendientes;
	}

	public Boolean getActivartotalProductosPendientes() {
		return this.activartotalProductosPendientes;
	}

	public void setActivartotalProductosPendientes(Boolean activartotalProductosPendientes) {
		this.activartotalProductosPendientes= activartotalProductosPendientes;
	}

	public Border setResaltarcodigo_productoProductosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosPendientesBeanSwingJInternalFrame productospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productospendientesBeanSwingJInternalFrame.jTtoolBarProductosPendientes.setBorder(borderResaltar);
		
		this.resaltarcodigo_productoProductosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_productoProductosPendientes() {
		return this.resaltarcodigo_productoProductosPendientes;
	}

	public void setResaltarcodigo_productoProductosPendientes(Border borderResaltar) {
		this.resaltarcodigo_productoProductosPendientes= borderResaltar;
	}

	public Boolean getMostrarcodigo_productoProductosPendientes() {
		return this.mostrarcodigo_productoProductosPendientes;
	}

	public void setMostrarcodigo_productoProductosPendientes(Boolean mostrarcodigo_productoProductosPendientes) {
		this.mostrarcodigo_productoProductosPendientes= mostrarcodigo_productoProductosPendientes;
	}

	public Boolean getActivarcodigo_productoProductosPendientes() {
		return this.activarcodigo_productoProductosPendientes;
	}

	public void setActivarcodigo_productoProductosPendientes(Boolean activarcodigo_productoProductosPendientes) {
		this.activarcodigo_productoProductosPendientes= activarcodigo_productoProductosPendientes;
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
		
		
		this.setMostraridProductosPendientes(esInicial);
		this.setMostrarid_empresaProductosPendientes(esInicial);
		this.setMostrarid_bodegaProductosPendientes(esInicial);
		this.setMostrarid_lineaProductosPendientes(esInicial);
		this.setMostrarid_linea_grupoProductosPendientes(esInicial);
		this.setMostrarid_linea_categoriaProductosPendientes(esInicial);
		this.setMostrarid_linea_marcaProductosPendientes(esInicial);
		this.setMostrarfecha_emision_desdeProductosPendientes(esInicial);
		this.setMostrarfecha_emision_hastaProductosPendientes(esInicial);
		this.setMostrarnombre_empresaProductosPendientes(esInicial);
		this.setMostrarruc_empresaProductosPendientes(esInicial);
		this.setMostrarnombre_productoProductosPendientes(esInicial);
		this.setMostrarnombre_unidadProductosPendientes(esInicial);
		this.setMostrarcantidadProductosPendientes(esInicial);
		this.setMostrarprecioProductosPendientes(esInicial);
		this.setMostrartotalProductosPendientes(esInicial);
		this.setMostrarcodigo_productoProductosPendientes(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.ID)) {
				this.setMostraridProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.NOMBREEMPRESA)) {
				this.setMostrarnombre_empresaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.RUCEMPRESA)) {
				this.setMostrarruc_empresaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.NOMBREUNIDAD)) {
				this.setMostrarnombre_unidadProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.PRECIO)) {
				this.setMostrarprecioProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.TOTAL)) {
				this.setMostrartotalProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.CODIGOPRODUCTO)) {
				this.setMostrarcodigo_productoProductosPendientes(esAsigna);
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
		
		
		this.setActivaridProductosPendientes(esInicial);
		this.setActivarid_empresaProductosPendientes(esInicial);
		this.setActivarid_bodegaProductosPendientes(esInicial);
		this.setActivarid_lineaProductosPendientes(esInicial);
		this.setActivarid_linea_grupoProductosPendientes(esInicial);
		this.setActivarid_linea_categoriaProductosPendientes(esInicial);
		this.setActivarid_linea_marcaProductosPendientes(esInicial);
		this.setActivarfecha_emision_desdeProductosPendientes(esInicial);
		this.setActivarfecha_emision_hastaProductosPendientes(esInicial);
		this.setActivarnombre_empresaProductosPendientes(esInicial);
		this.setActivarruc_empresaProductosPendientes(esInicial);
		this.setActivarnombre_productoProductosPendientes(esInicial);
		this.setActivarnombre_unidadProductosPendientes(esInicial);
		this.setActivarcantidadProductosPendientes(esInicial);
		this.setActivarprecioProductosPendientes(esInicial);
		this.setActivartotalProductosPendientes(esInicial);
		this.setActivarcodigo_productoProductosPendientes(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.ID)) {
				this.setActivaridProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.NOMBREEMPRESA)) {
				this.setActivarnombre_empresaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.RUCEMPRESA)) {
				this.setActivarruc_empresaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.NOMBREUNIDAD)) {
				this.setActivarnombre_unidadProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.PRECIO)) {
				this.setActivarprecioProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.TOTAL)) {
				this.setActivartotalProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.CODIGOPRODUCTO)) {
				this.setActivarcodigo_productoProductosPendientes(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductosPendientesBeanSwingJInternalFrame productospendientesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductosPendientes(esInicial);
		this.setResaltarid_empresaProductosPendientes(esInicial);
		this.setResaltarid_bodegaProductosPendientes(esInicial);
		this.setResaltarid_lineaProductosPendientes(esInicial);
		this.setResaltarid_linea_grupoProductosPendientes(esInicial);
		this.setResaltarid_linea_categoriaProductosPendientes(esInicial);
		this.setResaltarid_linea_marcaProductosPendientes(esInicial);
		this.setResaltarfecha_emision_desdeProductosPendientes(esInicial);
		this.setResaltarfecha_emision_hastaProductosPendientes(esInicial);
		this.setResaltarnombre_empresaProductosPendientes(esInicial);
		this.setResaltarruc_empresaProductosPendientes(esInicial);
		this.setResaltarnombre_productoProductosPendientes(esInicial);
		this.setResaltarnombre_unidadProductosPendientes(esInicial);
		this.setResaltarcantidadProductosPendientes(esInicial);
		this.setResaltarprecioProductosPendientes(esInicial);
		this.setResaltartotalProductosPendientes(esInicial);
		this.setResaltarcodigo_productoProductosPendientes(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.ID)) {
				this.setResaltaridProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.NOMBREEMPRESA)) {
				this.setResaltarnombre_empresaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.RUCEMPRESA)) {
				this.setResaltarruc_empresaProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.NOMBREUNIDAD)) {
				this.setResaltarnombre_unidadProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.PRECIO)) {
				this.setResaltarprecioProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.TOTAL)) {
				this.setResaltartotalProductosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosPendientesConstantesFunciones.CODIGOPRODUCTO)) {
				this.setResaltarcodigo_productoProductosPendientes(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductosPendientesBeanSwingJInternalFrame productospendientesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProductosPendientesProductosPendientes=true;

	public Boolean getMostrarBusquedaProductosPendientesProductosPendientes() {
		return this.mostrarBusquedaProductosPendientesProductosPendientes;
	}

	public void setMostrarBusquedaProductosPendientesProductosPendientes(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProductosPendientesProductosPendientes= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProductosPendientesProductosPendientes=true;

	public Boolean getActivarBusquedaProductosPendientesProductosPendientes() {
		return this.activarBusquedaProductosPendientesProductosPendientes;
	}

	public void setActivarBusquedaProductosPendientesProductosPendientes(Boolean habilitarResaltar) {
		this.activarBusquedaProductosPendientesProductosPendientes= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProductosPendientesProductosPendientes=null;

	public Border getResaltarBusquedaProductosPendientesProductosPendientes() {
		return this.resaltarBusquedaProductosPendientesProductosPendientes;
	}

	public void setResaltarBusquedaProductosPendientesProductosPendientes(Border borderResaltar) {
		this.resaltarBusquedaProductosPendientesProductosPendientes= borderResaltar;
	}

	public void setResaltarBusquedaProductosPendientesProductosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosPendientesBeanSwingJInternalFrame productospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProductosPendientesProductosPendientes= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}