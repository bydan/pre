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


import com.bydan.erp.inventario.util.report.ProcesoPreciosFactorConstantesFunciones;
import com.bydan.erp.inventario.util.report.ProcesoPreciosFactorParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ProcesoPreciosFactorParameterGeneral;

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
final public class ProcesoPreciosFactorConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoPreciosFactor";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoPreciosFactor"+ProcesoPreciosFactorConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoPreciosFactorHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoPreciosFactorHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoPreciosFactorConstantesFunciones.SCHEMA+"_"+ProcesoPreciosFactorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoPreciosFactorHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoPreciosFactorConstantesFunciones.SCHEMA+"_"+ProcesoPreciosFactorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoPreciosFactorConstantesFunciones.SCHEMA+"_"+ProcesoPreciosFactorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoPreciosFactorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoPreciosFactorConstantesFunciones.SCHEMA+"_"+ProcesoPreciosFactorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoPreciosFactorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoPreciosFactorHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoPreciosFactorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoPreciosFactorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoPreciosFactorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoPreciosFactorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoPreciosFactorConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoPreciosFactorConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoPreciosFactorConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoPreciosFactorConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Precios Factores";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Precios Factor";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Precios Factor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoPreciosFactor";
	public static final String OBJECTNAME="procesopreciosfactor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="proceso_precios_factor";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesopreciosfactor from "+ProcesoPreciosFactorConstantesFunciones.SPERSISTENCENAME+" procesopreciosfactor";
	public static String QUERYSELECTNATIVE="select "+ProcesoPreciosFactorConstantesFunciones.SCHEMA+"."+ProcesoPreciosFactorConstantesFunciones.TABLENAME+".id,"+ProcesoPreciosFactorConstantesFunciones.SCHEMA+"."+ProcesoPreciosFactorConstantesFunciones.TABLENAME+".version_row,"+ProcesoPreciosFactorConstantesFunciones.SCHEMA+"."+ProcesoPreciosFactorConstantesFunciones.TABLENAME+".id_bodega,"+ProcesoPreciosFactorConstantesFunciones.SCHEMA+"."+ProcesoPreciosFactorConstantesFunciones.TABLENAME+".id_producto,"+ProcesoPreciosFactorConstantesFunciones.SCHEMA+"."+ProcesoPreciosFactorConstantesFunciones.TABLENAME+".id_empresa,"+ProcesoPreciosFactorConstantesFunciones.SCHEMA+"."+ProcesoPreciosFactorConstantesFunciones.TABLENAME+".id_sucursal,"+ProcesoPreciosFactorConstantesFunciones.SCHEMA+"."+ProcesoPreciosFactorConstantesFunciones.TABLENAME+".id_linea,"+ProcesoPreciosFactorConstantesFunciones.SCHEMA+"."+ProcesoPreciosFactorConstantesFunciones.TABLENAME+".id_linea_grupo,"+ProcesoPreciosFactorConstantesFunciones.SCHEMA+"."+ProcesoPreciosFactorConstantesFunciones.TABLENAME+".id_linea_categoria,"+ProcesoPreciosFactorConstantesFunciones.SCHEMA+"."+ProcesoPreciosFactorConstantesFunciones.TABLENAME+".id_linea_marca,"+ProcesoPreciosFactorConstantesFunciones.SCHEMA+"."+ProcesoPreciosFactorConstantesFunciones.TABLENAME+".codigo,"+ProcesoPreciosFactorConstantesFunciones.SCHEMA+"."+ProcesoPreciosFactorConstantesFunciones.TABLENAME+".nombre,"+ProcesoPreciosFactorConstantesFunciones.SCHEMA+"."+ProcesoPreciosFactorConstantesFunciones.TABLENAME+".codigo_producto,"+ProcesoPreciosFactorConstantesFunciones.SCHEMA+"."+ProcesoPreciosFactorConstantesFunciones.TABLENAME+".nombre_producto,"+ProcesoPreciosFactorConstantesFunciones.SCHEMA+"."+ProcesoPreciosFactorConstantesFunciones.TABLENAME+".precio,"+ProcesoPreciosFactorConstantesFunciones.SCHEMA+"."+ProcesoPreciosFactorConstantesFunciones.TABLENAME+".factor from "+ProcesoPreciosFactorConstantesFunciones.SCHEMA+"."+ProcesoPreciosFactorConstantesFunciones.TABLENAME;//+" as "+ProcesoPreciosFactorConstantesFunciones.TABLENAME;
	
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
    public static final String FACTOR= "factor";
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
    	public static final String LABEL_FACTOR= "Factor";
		public static final String LABEL_FACTOR_LOWER= "Factor";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getProcesoPreciosFactorLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoPreciosFactorConstantesFunciones.IDBODEGA)) {sLabelColumna=ProcesoPreciosFactorConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ProcesoPreciosFactorConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProcesoPreciosFactorConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProcesoPreciosFactorConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProcesoPreciosFactorConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProcesoPreciosFactorConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProcesoPreciosFactorConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProcesoPreciosFactorConstantesFunciones.IDLINEA)) {sLabelColumna=ProcesoPreciosFactorConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ProcesoPreciosFactorConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=ProcesoPreciosFactorConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(ProcesoPreciosFactorConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=ProcesoPreciosFactorConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(ProcesoPreciosFactorConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=ProcesoPreciosFactorConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(ProcesoPreciosFactorConstantesFunciones.CODIGO)) {sLabelColumna=ProcesoPreciosFactorConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ProcesoPreciosFactorConstantesFunciones.NOMBRE)) {sLabelColumna=ProcesoPreciosFactorConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ProcesoPreciosFactorConstantesFunciones.CODIGOPRODUCTO)) {sLabelColumna=ProcesoPreciosFactorConstantesFunciones.LABEL_CODIGOPRODUCTO;}
		if(sNombreColumna.equals(ProcesoPreciosFactorConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=ProcesoPreciosFactorConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(ProcesoPreciosFactorConstantesFunciones.PRECIO)) {sLabelColumna=ProcesoPreciosFactorConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(ProcesoPreciosFactorConstantesFunciones.FACTOR)) {sLabelColumna=ProcesoPreciosFactorConstantesFunciones.LABEL_FACTOR;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProcesoPreciosFactorDescripcion(ProcesoPreciosFactor procesopreciosfactor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesopreciosfactor !=null/* && procesopreciosfactor.getId()!=0*/) {
			sDescripcion=procesopreciosfactor.getcodigo();//procesopreciosfactorprocesopreciosfactor.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoPreciosFactorDescripcionDetallado(ProcesoPreciosFactor procesopreciosfactor) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoPreciosFactorConstantesFunciones.ID+"=";
		sDescripcion+=procesopreciosfactor.getId().toString()+",";
		sDescripcion+=ProcesoPreciosFactorConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesopreciosfactor.getVersionRow().toString()+",";
		sDescripcion+=ProcesoPreciosFactorConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=procesopreciosfactor.getid_bodega().toString()+",";
		sDescripcion+=ProcesoPreciosFactorConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=procesopreciosfactor.getid_producto().toString()+",";
		sDescripcion+=ProcesoPreciosFactorConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=procesopreciosfactor.getid_empresa().toString()+",";
		sDescripcion+=ProcesoPreciosFactorConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=procesopreciosfactor.getid_sucursal().toString()+",";
		sDescripcion+=ProcesoPreciosFactorConstantesFunciones.IDLINEA+"=";
		sDescripcion+=procesopreciosfactor.getid_linea().toString()+",";
		sDescripcion+=ProcesoPreciosFactorConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=procesopreciosfactor.getid_linea_grupo().toString()+",";
		sDescripcion+=ProcesoPreciosFactorConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=procesopreciosfactor.getid_linea_categoria().toString()+",";
		sDescripcion+=ProcesoPreciosFactorConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=procesopreciosfactor.getid_linea_marca().toString()+",";
		sDescripcion+=ProcesoPreciosFactorConstantesFunciones.CODIGO+"=";
		sDescripcion+=procesopreciosfactor.getcodigo()+",";
		sDescripcion+=ProcesoPreciosFactorConstantesFunciones.NOMBRE+"=";
		sDescripcion+=procesopreciosfactor.getnombre()+",";
		sDescripcion+=ProcesoPreciosFactorConstantesFunciones.CODIGOPRODUCTO+"=";
		sDescripcion+=procesopreciosfactor.getcodigo_producto()+",";
		sDescripcion+=ProcesoPreciosFactorConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=procesopreciosfactor.getnombre_producto()+",";
		sDescripcion+=ProcesoPreciosFactorConstantesFunciones.PRECIO+"=";
		sDescripcion+=procesopreciosfactor.getprecio().toString()+",";
		sDescripcion+=ProcesoPreciosFactorConstantesFunciones.FACTOR+"=";
		sDescripcion+=procesopreciosfactor.getfactor().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoPreciosFactorDescripcion(ProcesoPreciosFactor procesopreciosfactor,String sValor) throws Exception {			
		if(procesopreciosfactor !=null) {
			procesopreciosfactor.setcodigo(sValor);;//procesopreciosfactorprocesopreciosfactor.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaProcesoPreciosFactor")) {
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

	public static String getDetalleIndiceBusquedaProcesoPreciosFactor(Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca) {
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
	
	
	
	
	
	
	public static void quitarEspaciosProcesoPreciosFactor(ProcesoPreciosFactor procesopreciosfactor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		procesopreciosfactor.setcodigo(procesopreciosfactor.getcodigo().trim());
		procesopreciosfactor.setnombre(procesopreciosfactor.getnombre().trim());
		procesopreciosfactor.setcodigo_producto(procesopreciosfactor.getcodigo_producto().trim());
		procesopreciosfactor.setnombre_producto(procesopreciosfactor.getnombre_producto().trim());
	}
	
	public static void quitarEspaciosProcesoPreciosFactors(List<ProcesoPreciosFactor> procesopreciosfactors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoPreciosFactor procesopreciosfactor: procesopreciosfactors) {
			procesopreciosfactor.setcodigo(procesopreciosfactor.getcodigo().trim());
			procesopreciosfactor.setnombre(procesopreciosfactor.getnombre().trim());
			procesopreciosfactor.setcodigo_producto(procesopreciosfactor.getcodigo_producto().trim());
			procesopreciosfactor.setnombre_producto(procesopreciosfactor.getnombre_producto().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoPreciosFactor(ProcesoPreciosFactor procesopreciosfactor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesopreciosfactor.getConCambioAuxiliar()) {
			procesopreciosfactor.setIsDeleted(procesopreciosfactor.getIsDeletedAuxiliar());	
			procesopreciosfactor.setIsNew(procesopreciosfactor.getIsNewAuxiliar());	
			procesopreciosfactor.setIsChanged(procesopreciosfactor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesopreciosfactor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesopreciosfactor.setIsDeletedAuxiliar(false);	
			procesopreciosfactor.setIsNewAuxiliar(false);	
			procesopreciosfactor.setIsChangedAuxiliar(false);
			
			procesopreciosfactor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoPreciosFactors(List<ProcesoPreciosFactor> procesopreciosfactors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoPreciosFactor procesopreciosfactor : procesopreciosfactors) {
			if(conAsignarBase && procesopreciosfactor.getConCambioAuxiliar()) {
				procesopreciosfactor.setIsDeleted(procesopreciosfactor.getIsDeletedAuxiliar());	
				procesopreciosfactor.setIsNew(procesopreciosfactor.getIsNewAuxiliar());	
				procesopreciosfactor.setIsChanged(procesopreciosfactor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesopreciosfactor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesopreciosfactor.setIsDeletedAuxiliar(false);	
				procesopreciosfactor.setIsNewAuxiliar(false);	
				procesopreciosfactor.setIsChangedAuxiliar(false);
				
				procesopreciosfactor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoPreciosFactor(ProcesoPreciosFactor procesopreciosfactor,Boolean conEnteros) throws Exception  {
		procesopreciosfactor.setprecio(0.0);
		procesopreciosfactor.setfactor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoPreciosFactors(List<ProcesoPreciosFactor> procesopreciosfactors,Boolean conEnteros) throws Exception  {
		
		for(ProcesoPreciosFactor procesopreciosfactor: procesopreciosfactors) {
			procesopreciosfactor.setprecio(0.0);
			procesopreciosfactor.setfactor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoPreciosFactor(List<ProcesoPreciosFactor> procesopreciosfactors,ProcesoPreciosFactor procesopreciosfactorAux) throws Exception  {
		ProcesoPreciosFactorConstantesFunciones.InicializarValoresProcesoPreciosFactor(procesopreciosfactorAux,true);
		
		for(ProcesoPreciosFactor procesopreciosfactor: procesopreciosfactors) {
			if(procesopreciosfactor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			procesopreciosfactorAux.setprecio(procesopreciosfactorAux.getprecio()+procesopreciosfactor.getprecio());			
			procesopreciosfactorAux.setfactor(procesopreciosfactorAux.getfactor()+procesopreciosfactor.getfactor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoPreciosFactor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoPreciosFactorConstantesFunciones.getArrayColumnasGlobalesProcesoPreciosFactor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoPreciosFactor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoPreciosFactorConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoPreciosFactorConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoPreciosFactorConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoPreciosFactorConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoPreciosFactor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoPreciosFactor> procesopreciosfactors,ProcesoPreciosFactor procesopreciosfactor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoPreciosFactor procesopreciosfactorAux: procesopreciosfactors) {
			if(procesopreciosfactorAux!=null && procesopreciosfactor!=null) {
				if((procesopreciosfactorAux.getId()==null && procesopreciosfactor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesopreciosfactorAux.getId()!=null && procesopreciosfactor.getId()!=null){
					if(procesopreciosfactorAux.getId().equals(procesopreciosfactor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoPreciosFactor(List<ProcesoPreciosFactor> procesopreciosfactors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double factorTotal=0.0;
	
		for(ProcesoPreciosFactor procesopreciosfactor: procesopreciosfactors) {			
			if(procesopreciosfactor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=procesopreciosfactor.getprecio();
			factorTotal+=procesopreciosfactor.getfactor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProcesoPreciosFactorConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(ProcesoPreciosFactorConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProcesoPreciosFactorConstantesFunciones.FACTOR);
		datoGeneral.setsDescripcion(ProcesoPreciosFactorConstantesFunciones.LABEL_FACTOR);
		datoGeneral.setdValorDouble(factorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoPreciosFactor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProcesoPreciosFactorConstantesFunciones.LABEL_ID, ProcesoPreciosFactorConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPreciosFactorConstantesFunciones.LABEL_VERSIONROW, ProcesoPreciosFactorConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPreciosFactorConstantesFunciones.LABEL_CODIGO, ProcesoPreciosFactorConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPreciosFactorConstantesFunciones.LABEL_NOMBRE, ProcesoPreciosFactorConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPreciosFactorConstantesFunciones.LABEL_CODIGOPRODUCTO, ProcesoPreciosFactorConstantesFunciones.CODIGOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPreciosFactorConstantesFunciones.LABEL_NOMBREPRODUCTO, ProcesoPreciosFactorConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPreciosFactorConstantesFunciones.LABEL_PRECIO, ProcesoPreciosFactorConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPreciosFactorConstantesFunciones.LABEL_FACTOR, ProcesoPreciosFactorConstantesFunciones.FACTOR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoPreciosFactor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProcesoPreciosFactorConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPreciosFactorConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPreciosFactorConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPreciosFactorConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPreciosFactorConstantesFunciones.CODIGOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPreciosFactorConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPreciosFactorConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPreciosFactorConstantesFunciones.FACTOR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoPreciosFactor() throws Exception  {
		return ProcesoPreciosFactorConstantesFunciones.getTiposSeleccionarProcesoPreciosFactor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoPreciosFactor(Boolean conFk) throws Exception  {
		return ProcesoPreciosFactorConstantesFunciones.getTiposSeleccionarProcesoPreciosFactor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoPreciosFactor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosFactorConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ProcesoPreciosFactorConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosFactorConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProcesoPreciosFactorConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosFactorConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProcesoPreciosFactorConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosFactorConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProcesoPreciosFactorConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosFactorConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ProcesoPreciosFactorConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosFactorConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(ProcesoPreciosFactorConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosFactorConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(ProcesoPreciosFactorConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosFactorConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(ProcesoPreciosFactorConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosFactorConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ProcesoPreciosFactorConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosFactorConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ProcesoPreciosFactorConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosFactorConstantesFunciones.LABEL_CODIGOPRODUCTO);
			reporte.setsDescripcion(ProcesoPreciosFactorConstantesFunciones.LABEL_CODIGOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosFactorConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(ProcesoPreciosFactorConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosFactorConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(ProcesoPreciosFactorConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPreciosFactorConstantesFunciones.LABEL_FACTOR);
			reporte.setsDescripcion(ProcesoPreciosFactorConstantesFunciones.LABEL_FACTOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoPreciosFactor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoPreciosFactor(ProcesoPreciosFactor procesopreciosfactorAux) throws Exception {
		
			procesopreciosfactorAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(procesopreciosfactorAux.getBodega()));
			procesopreciosfactorAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(procesopreciosfactorAux.getProducto()));
			procesopreciosfactorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(procesopreciosfactorAux.getEmpresa()));
			procesopreciosfactorAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(procesopreciosfactorAux.getSucursal()));
			procesopreciosfactorAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesopreciosfactorAux.getLinea()));
			procesopreciosfactorAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesopreciosfactorAux.getLineaGrupo()));
			procesopreciosfactorAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesopreciosfactorAux.getLineaCategoria()));
			procesopreciosfactorAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesopreciosfactorAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoPreciosFactor(List<ProcesoPreciosFactor> procesopreciosfactorsTemp) throws Exception {
		for(ProcesoPreciosFactor procesopreciosfactorAux:procesopreciosfactorsTemp) {
			
			procesopreciosfactorAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(procesopreciosfactorAux.getBodega()));
			procesopreciosfactorAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(procesopreciosfactorAux.getProducto()));
			procesopreciosfactorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(procesopreciosfactorAux.getEmpresa()));
			procesopreciosfactorAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(procesopreciosfactorAux.getSucursal()));
			procesopreciosfactorAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesopreciosfactorAux.getLinea()));
			procesopreciosfactorAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesopreciosfactorAux.getLineaGrupo()));
			procesopreciosfactorAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesopreciosfactorAux.getLineaCategoria()));
			procesopreciosfactorAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesopreciosfactorAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoPreciosFactor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoPreciosFactor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoPreciosFactor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoPreciosFactorConstantesFunciones.getClassesRelationshipsOfProcesoPreciosFactor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoPreciosFactor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoPreciosFactor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoPreciosFactorConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoPreciosFactor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoPreciosFactor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoPreciosFactor procesopreciosfactor,List<ProcesoPreciosFactor> procesopreciosfactors,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoPreciosFactor procesopreciosfactor,List<ProcesoPreciosFactor> procesopreciosfactors) throws Exception {
		try	{			
			for(ProcesoPreciosFactor procesopreciosfactorLocal:procesopreciosfactors) {
				if(procesopreciosfactorLocal.getId().equals(procesopreciosfactor.getId())) {
					procesopreciosfactorLocal.setIsSelected(procesopreciosfactor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoPreciosFactor(List<ProcesoPreciosFactor> procesopreciosfactorsAux) throws Exception {
		//this.procesopreciosfactorsAux=procesopreciosfactorsAux;
		
		for(ProcesoPreciosFactor procesopreciosfactorAux:procesopreciosfactorsAux) {
			if(procesopreciosfactorAux.getIsChanged()) {
				procesopreciosfactorAux.setIsChanged(false);
			}		
			
			if(procesopreciosfactorAux.getIsNew()) {
				procesopreciosfactorAux.setIsNew(false);
			}	
			
			if(procesopreciosfactorAux.getIsDeleted()) {
				procesopreciosfactorAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoPreciosFactor(ProcesoPreciosFactor procesopreciosfactorAux) throws Exception {
		//this.procesopreciosfactorAux=procesopreciosfactorAux;
		
			if(procesopreciosfactorAux.getIsChanged()) {
				procesopreciosfactorAux.setIsChanged(false);
			}		
			
			if(procesopreciosfactorAux.getIsNew()) {
				procesopreciosfactorAux.setIsNew(false);
			}	
			
			if(procesopreciosfactorAux.getIsDeleted()) {
				procesopreciosfactorAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoPreciosFactor procesopreciosfactorAsignar,ProcesoPreciosFactor procesopreciosfactor) throws Exception {
		procesopreciosfactorAsignar.setId(procesopreciosfactor.getId());	
		procesopreciosfactorAsignar.setVersionRow(procesopreciosfactor.getVersionRow());	
		procesopreciosfactorAsignar.setcodigo(procesopreciosfactor.getcodigo());	
		procesopreciosfactorAsignar.setnombre(procesopreciosfactor.getnombre());	
		procesopreciosfactorAsignar.setcodigo_producto(procesopreciosfactor.getcodigo_producto());	
		procesopreciosfactorAsignar.setnombre_producto(procesopreciosfactor.getnombre_producto());	
		procesopreciosfactorAsignar.setprecio(procesopreciosfactor.getprecio());	
		procesopreciosfactorAsignar.setfactor(procesopreciosfactor.getfactor());	
	}
	
	public static void inicializarProcesoPreciosFactor(ProcesoPreciosFactor procesopreciosfactor) throws Exception {
		try {
				procesopreciosfactor.setId(0L);	
					
				procesopreciosfactor.setcodigo("");	
				procesopreciosfactor.setnombre("");	
				procesopreciosfactor.setcodigo_producto("");	
				procesopreciosfactor.setnombre_producto("");	
				procesopreciosfactor.setprecio(0.0);	
				procesopreciosfactor.setfactor(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoPreciosFactor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosFactorConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosFactorConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosFactorConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosFactorConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosFactorConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosFactorConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosFactorConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosFactorConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosFactorConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosFactorConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosFactorConstantesFunciones.LABEL_CODIGOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosFactorConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosFactorConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPreciosFactorConstantesFunciones.LABEL_FACTOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoPreciosFactor(String sTipo,Row row,Workbook workbook,ProcesoPreciosFactor procesopreciosfactor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosfactor.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosfactor.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosfactor.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosfactor.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosfactor.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosfactor.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosfactor.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosfactor.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosfactor.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosfactor.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosfactor.getcodigo_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosfactor.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosfactor.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopreciosfactor.getfactor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoPreciosFactor="";
	
	public String getsFinalQueryProcesoPreciosFactor() {
		return this.sFinalQueryProcesoPreciosFactor;
	}
	
	public void setsFinalQueryProcesoPreciosFactor(String sFinalQueryProcesoPreciosFactor) {
		this.sFinalQueryProcesoPreciosFactor= sFinalQueryProcesoPreciosFactor;
	}
	
	public Border resaltarSeleccionarProcesoPreciosFactor=null;
	
	public Border setResaltarSeleccionarProcesoPreciosFactor(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosFactorBeanSwingJInternalFrame procesopreciosfactorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesopreciosfactorBeanSwingJInternalFrame.jTtoolBarProcesoPreciosFactor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoPreciosFactor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoPreciosFactor() {
		return this.resaltarSeleccionarProcesoPreciosFactor;
	}
	
	public void setResaltarSeleccionarProcesoPreciosFactor(Border borderResaltarSeleccionarProcesoPreciosFactor) {
		this.resaltarSeleccionarProcesoPreciosFactor= borderResaltarSeleccionarProcesoPreciosFactor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoPreciosFactor=null;
	public Boolean mostraridProcesoPreciosFactor=true;
	public Boolean activaridProcesoPreciosFactor=true;

	public Border resaltarid_bodegaProcesoPreciosFactor=null;
	public Boolean mostrarid_bodegaProcesoPreciosFactor=true;
	public Boolean activarid_bodegaProcesoPreciosFactor=true;
	public Boolean cargarid_bodegaProcesoPreciosFactor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaProcesoPreciosFactor=false;//ConEventDepend=true

	public Border resaltarid_productoProcesoPreciosFactor=null;
	public Boolean mostrarid_productoProcesoPreciosFactor=true;
	public Boolean activarid_productoProcesoPreciosFactor=true;
	public Boolean cargarid_productoProcesoPreciosFactor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProcesoPreciosFactor=false;//ConEventDepend=true

	public Border resaltarid_empresaProcesoPreciosFactor=null;
	public Boolean mostrarid_empresaProcesoPreciosFactor=true;
	public Boolean activarid_empresaProcesoPreciosFactor=true;
	public Boolean cargarid_empresaProcesoPreciosFactor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProcesoPreciosFactor=false;//ConEventDepend=true

	public Border resaltarid_sucursalProcesoPreciosFactor=null;
	public Boolean mostrarid_sucursalProcesoPreciosFactor=true;
	public Boolean activarid_sucursalProcesoPreciosFactor=true;
	public Boolean cargarid_sucursalProcesoPreciosFactor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProcesoPreciosFactor=false;//ConEventDepend=true

	public Border resaltarid_lineaProcesoPreciosFactor=null;
	public Boolean mostrarid_lineaProcesoPreciosFactor=true;
	public Boolean activarid_lineaProcesoPreciosFactor=true;
	public Boolean cargarid_lineaProcesoPreciosFactor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaProcesoPreciosFactor=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoProcesoPreciosFactor=null;
	public Boolean mostrarid_linea_grupoProcesoPreciosFactor=true;
	public Boolean activarid_linea_grupoProcesoPreciosFactor=true;
	public Boolean cargarid_linea_grupoProcesoPreciosFactor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoProcesoPreciosFactor=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaProcesoPreciosFactor=null;
	public Boolean mostrarid_linea_categoriaProcesoPreciosFactor=true;
	public Boolean activarid_linea_categoriaProcesoPreciosFactor=true;
	public Boolean cargarid_linea_categoriaProcesoPreciosFactor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaProcesoPreciosFactor=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaProcesoPreciosFactor=null;
	public Boolean mostrarid_linea_marcaProcesoPreciosFactor=true;
	public Boolean activarid_linea_marcaProcesoPreciosFactor=true;
	public Boolean cargarid_linea_marcaProcesoPreciosFactor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaProcesoPreciosFactor=false;//ConEventDepend=true

	public Border resaltarcodigoProcesoPreciosFactor=null;
	public Boolean mostrarcodigoProcesoPreciosFactor=true;
	public Boolean activarcodigoProcesoPreciosFactor=true;

	public Border resaltarnombreProcesoPreciosFactor=null;
	public Boolean mostrarnombreProcesoPreciosFactor=true;
	public Boolean activarnombreProcesoPreciosFactor=true;

	public Border resaltarcodigo_productoProcesoPreciosFactor=null;
	public Boolean mostrarcodigo_productoProcesoPreciosFactor=true;
	public Boolean activarcodigo_productoProcesoPreciosFactor=true;

	public Border resaltarnombre_productoProcesoPreciosFactor=null;
	public Boolean mostrarnombre_productoProcesoPreciosFactor=true;
	public Boolean activarnombre_productoProcesoPreciosFactor=true;

	public Border resaltarprecioProcesoPreciosFactor=null;
	public Boolean mostrarprecioProcesoPreciosFactor=true;
	public Boolean activarprecioProcesoPreciosFactor=true;

	public Border resaltarfactorProcesoPreciosFactor=null;
	public Boolean mostrarfactorProcesoPreciosFactor=true;
	public Boolean activarfactorProcesoPreciosFactor=true;

	
	

	public Border setResaltaridProcesoPreciosFactor(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosFactorBeanSwingJInternalFrame procesopreciosfactorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosfactorBeanSwingJInternalFrame.jTtoolBarProcesoPreciosFactor.setBorder(borderResaltar);
		
		this.resaltaridProcesoPreciosFactor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoPreciosFactor() {
		return this.resaltaridProcesoPreciosFactor;
	}

	public void setResaltaridProcesoPreciosFactor(Border borderResaltar) {
		this.resaltaridProcesoPreciosFactor= borderResaltar;
	}

	public Boolean getMostraridProcesoPreciosFactor() {
		return this.mostraridProcesoPreciosFactor;
	}

	public void setMostraridProcesoPreciosFactor(Boolean mostraridProcesoPreciosFactor) {
		this.mostraridProcesoPreciosFactor= mostraridProcesoPreciosFactor;
	}

	public Boolean getActivaridProcesoPreciosFactor() {
		return this.activaridProcesoPreciosFactor;
	}

	public void setActivaridProcesoPreciosFactor(Boolean activaridProcesoPreciosFactor) {
		this.activaridProcesoPreciosFactor= activaridProcesoPreciosFactor;
	}

	public Border setResaltarid_bodegaProcesoPreciosFactor(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosFactorBeanSwingJInternalFrame procesopreciosfactorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosfactorBeanSwingJInternalFrame.jTtoolBarProcesoPreciosFactor.setBorder(borderResaltar);
		
		this.resaltarid_bodegaProcesoPreciosFactor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaProcesoPreciosFactor() {
		return this.resaltarid_bodegaProcesoPreciosFactor;
	}

	public void setResaltarid_bodegaProcesoPreciosFactor(Border borderResaltar) {
		this.resaltarid_bodegaProcesoPreciosFactor= borderResaltar;
	}

	public Boolean getMostrarid_bodegaProcesoPreciosFactor() {
		return this.mostrarid_bodegaProcesoPreciosFactor;
	}

	public void setMostrarid_bodegaProcesoPreciosFactor(Boolean mostrarid_bodegaProcesoPreciosFactor) {
		this.mostrarid_bodegaProcesoPreciosFactor= mostrarid_bodegaProcesoPreciosFactor;
	}

	public Boolean getActivarid_bodegaProcesoPreciosFactor() {
		return this.activarid_bodegaProcesoPreciosFactor;
	}

	public void setActivarid_bodegaProcesoPreciosFactor(Boolean activarid_bodegaProcesoPreciosFactor) {
		this.activarid_bodegaProcesoPreciosFactor= activarid_bodegaProcesoPreciosFactor;
	}

	public Boolean getCargarid_bodegaProcesoPreciosFactor() {
		return this.cargarid_bodegaProcesoPreciosFactor;
	}

	public void setCargarid_bodegaProcesoPreciosFactor(Boolean cargarid_bodegaProcesoPreciosFactor) {
		this.cargarid_bodegaProcesoPreciosFactor= cargarid_bodegaProcesoPreciosFactor;
	}

	public Border setResaltarid_productoProcesoPreciosFactor(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosFactorBeanSwingJInternalFrame procesopreciosfactorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosfactorBeanSwingJInternalFrame.jTtoolBarProcesoPreciosFactor.setBorder(borderResaltar);
		
		this.resaltarid_productoProcesoPreciosFactor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProcesoPreciosFactor() {
		return this.resaltarid_productoProcesoPreciosFactor;
	}

	public void setResaltarid_productoProcesoPreciosFactor(Border borderResaltar) {
		this.resaltarid_productoProcesoPreciosFactor= borderResaltar;
	}

	public Boolean getMostrarid_productoProcesoPreciosFactor() {
		return this.mostrarid_productoProcesoPreciosFactor;
	}

	public void setMostrarid_productoProcesoPreciosFactor(Boolean mostrarid_productoProcesoPreciosFactor) {
		this.mostrarid_productoProcesoPreciosFactor= mostrarid_productoProcesoPreciosFactor;
	}

	public Boolean getActivarid_productoProcesoPreciosFactor() {
		return this.activarid_productoProcesoPreciosFactor;
	}

	public void setActivarid_productoProcesoPreciosFactor(Boolean activarid_productoProcesoPreciosFactor) {
		this.activarid_productoProcesoPreciosFactor= activarid_productoProcesoPreciosFactor;
	}

	public Boolean getCargarid_productoProcesoPreciosFactor() {
		return this.cargarid_productoProcesoPreciosFactor;
	}

	public void setCargarid_productoProcesoPreciosFactor(Boolean cargarid_productoProcesoPreciosFactor) {
		this.cargarid_productoProcesoPreciosFactor= cargarid_productoProcesoPreciosFactor;
	}

	public Border setResaltarid_empresaProcesoPreciosFactor(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosFactorBeanSwingJInternalFrame procesopreciosfactorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosfactorBeanSwingJInternalFrame.jTtoolBarProcesoPreciosFactor.setBorder(borderResaltar);
		
		this.resaltarid_empresaProcesoPreciosFactor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProcesoPreciosFactor() {
		return this.resaltarid_empresaProcesoPreciosFactor;
	}

	public void setResaltarid_empresaProcesoPreciosFactor(Border borderResaltar) {
		this.resaltarid_empresaProcesoPreciosFactor= borderResaltar;
	}

	public Boolean getMostrarid_empresaProcesoPreciosFactor() {
		return this.mostrarid_empresaProcesoPreciosFactor;
	}

	public void setMostrarid_empresaProcesoPreciosFactor(Boolean mostrarid_empresaProcesoPreciosFactor) {
		this.mostrarid_empresaProcesoPreciosFactor= mostrarid_empresaProcesoPreciosFactor;
	}

	public Boolean getActivarid_empresaProcesoPreciosFactor() {
		return this.activarid_empresaProcesoPreciosFactor;
	}

	public void setActivarid_empresaProcesoPreciosFactor(Boolean activarid_empresaProcesoPreciosFactor) {
		this.activarid_empresaProcesoPreciosFactor= activarid_empresaProcesoPreciosFactor;
	}

	public Boolean getCargarid_empresaProcesoPreciosFactor() {
		return this.cargarid_empresaProcesoPreciosFactor;
	}

	public void setCargarid_empresaProcesoPreciosFactor(Boolean cargarid_empresaProcesoPreciosFactor) {
		this.cargarid_empresaProcesoPreciosFactor= cargarid_empresaProcesoPreciosFactor;
	}

	public Border setResaltarid_sucursalProcesoPreciosFactor(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosFactorBeanSwingJInternalFrame procesopreciosfactorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosfactorBeanSwingJInternalFrame.jTtoolBarProcesoPreciosFactor.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProcesoPreciosFactor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProcesoPreciosFactor() {
		return this.resaltarid_sucursalProcesoPreciosFactor;
	}

	public void setResaltarid_sucursalProcesoPreciosFactor(Border borderResaltar) {
		this.resaltarid_sucursalProcesoPreciosFactor= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProcesoPreciosFactor() {
		return this.mostrarid_sucursalProcesoPreciosFactor;
	}

	public void setMostrarid_sucursalProcesoPreciosFactor(Boolean mostrarid_sucursalProcesoPreciosFactor) {
		this.mostrarid_sucursalProcesoPreciosFactor= mostrarid_sucursalProcesoPreciosFactor;
	}

	public Boolean getActivarid_sucursalProcesoPreciosFactor() {
		return this.activarid_sucursalProcesoPreciosFactor;
	}

	public void setActivarid_sucursalProcesoPreciosFactor(Boolean activarid_sucursalProcesoPreciosFactor) {
		this.activarid_sucursalProcesoPreciosFactor= activarid_sucursalProcesoPreciosFactor;
	}

	public Boolean getCargarid_sucursalProcesoPreciosFactor() {
		return this.cargarid_sucursalProcesoPreciosFactor;
	}

	public void setCargarid_sucursalProcesoPreciosFactor(Boolean cargarid_sucursalProcesoPreciosFactor) {
		this.cargarid_sucursalProcesoPreciosFactor= cargarid_sucursalProcesoPreciosFactor;
	}

	public Border setResaltarid_lineaProcesoPreciosFactor(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosFactorBeanSwingJInternalFrame procesopreciosfactorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosfactorBeanSwingJInternalFrame.jTtoolBarProcesoPreciosFactor.setBorder(borderResaltar);
		
		this.resaltarid_lineaProcesoPreciosFactor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaProcesoPreciosFactor() {
		return this.resaltarid_lineaProcesoPreciosFactor;
	}

	public void setResaltarid_lineaProcesoPreciosFactor(Border borderResaltar) {
		this.resaltarid_lineaProcesoPreciosFactor= borderResaltar;
	}

	public Boolean getMostrarid_lineaProcesoPreciosFactor() {
		return this.mostrarid_lineaProcesoPreciosFactor;
	}

	public void setMostrarid_lineaProcesoPreciosFactor(Boolean mostrarid_lineaProcesoPreciosFactor) {
		this.mostrarid_lineaProcesoPreciosFactor= mostrarid_lineaProcesoPreciosFactor;
	}

	public Boolean getActivarid_lineaProcesoPreciosFactor() {
		return this.activarid_lineaProcesoPreciosFactor;
	}

	public void setActivarid_lineaProcesoPreciosFactor(Boolean activarid_lineaProcesoPreciosFactor) {
		this.activarid_lineaProcesoPreciosFactor= activarid_lineaProcesoPreciosFactor;
	}

	public Boolean getCargarid_lineaProcesoPreciosFactor() {
		return this.cargarid_lineaProcesoPreciosFactor;
	}

	public void setCargarid_lineaProcesoPreciosFactor(Boolean cargarid_lineaProcesoPreciosFactor) {
		this.cargarid_lineaProcesoPreciosFactor= cargarid_lineaProcesoPreciosFactor;
	}

	public Border setResaltarid_linea_grupoProcesoPreciosFactor(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosFactorBeanSwingJInternalFrame procesopreciosfactorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosfactorBeanSwingJInternalFrame.jTtoolBarProcesoPreciosFactor.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoProcesoPreciosFactor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoProcesoPreciosFactor() {
		return this.resaltarid_linea_grupoProcesoPreciosFactor;
	}

	public void setResaltarid_linea_grupoProcesoPreciosFactor(Border borderResaltar) {
		this.resaltarid_linea_grupoProcesoPreciosFactor= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoProcesoPreciosFactor() {
		return this.mostrarid_linea_grupoProcesoPreciosFactor;
	}

	public void setMostrarid_linea_grupoProcesoPreciosFactor(Boolean mostrarid_linea_grupoProcesoPreciosFactor) {
		this.mostrarid_linea_grupoProcesoPreciosFactor= mostrarid_linea_grupoProcesoPreciosFactor;
	}

	public Boolean getActivarid_linea_grupoProcesoPreciosFactor() {
		return this.activarid_linea_grupoProcesoPreciosFactor;
	}

	public void setActivarid_linea_grupoProcesoPreciosFactor(Boolean activarid_linea_grupoProcesoPreciosFactor) {
		this.activarid_linea_grupoProcesoPreciosFactor= activarid_linea_grupoProcesoPreciosFactor;
	}

	public Boolean getCargarid_linea_grupoProcesoPreciosFactor() {
		return this.cargarid_linea_grupoProcesoPreciosFactor;
	}

	public void setCargarid_linea_grupoProcesoPreciosFactor(Boolean cargarid_linea_grupoProcesoPreciosFactor) {
		this.cargarid_linea_grupoProcesoPreciosFactor= cargarid_linea_grupoProcesoPreciosFactor;
	}

	public Border setResaltarid_linea_categoriaProcesoPreciosFactor(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosFactorBeanSwingJInternalFrame procesopreciosfactorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosfactorBeanSwingJInternalFrame.jTtoolBarProcesoPreciosFactor.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaProcesoPreciosFactor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaProcesoPreciosFactor() {
		return this.resaltarid_linea_categoriaProcesoPreciosFactor;
	}

	public void setResaltarid_linea_categoriaProcesoPreciosFactor(Border borderResaltar) {
		this.resaltarid_linea_categoriaProcesoPreciosFactor= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaProcesoPreciosFactor() {
		return this.mostrarid_linea_categoriaProcesoPreciosFactor;
	}

	public void setMostrarid_linea_categoriaProcesoPreciosFactor(Boolean mostrarid_linea_categoriaProcesoPreciosFactor) {
		this.mostrarid_linea_categoriaProcesoPreciosFactor= mostrarid_linea_categoriaProcesoPreciosFactor;
	}

	public Boolean getActivarid_linea_categoriaProcesoPreciosFactor() {
		return this.activarid_linea_categoriaProcesoPreciosFactor;
	}

	public void setActivarid_linea_categoriaProcesoPreciosFactor(Boolean activarid_linea_categoriaProcesoPreciosFactor) {
		this.activarid_linea_categoriaProcesoPreciosFactor= activarid_linea_categoriaProcesoPreciosFactor;
	}

	public Boolean getCargarid_linea_categoriaProcesoPreciosFactor() {
		return this.cargarid_linea_categoriaProcesoPreciosFactor;
	}

	public void setCargarid_linea_categoriaProcesoPreciosFactor(Boolean cargarid_linea_categoriaProcesoPreciosFactor) {
		this.cargarid_linea_categoriaProcesoPreciosFactor= cargarid_linea_categoriaProcesoPreciosFactor;
	}

	public Border setResaltarid_linea_marcaProcesoPreciosFactor(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosFactorBeanSwingJInternalFrame procesopreciosfactorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosfactorBeanSwingJInternalFrame.jTtoolBarProcesoPreciosFactor.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaProcesoPreciosFactor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaProcesoPreciosFactor() {
		return this.resaltarid_linea_marcaProcesoPreciosFactor;
	}

	public void setResaltarid_linea_marcaProcesoPreciosFactor(Border borderResaltar) {
		this.resaltarid_linea_marcaProcesoPreciosFactor= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaProcesoPreciosFactor() {
		return this.mostrarid_linea_marcaProcesoPreciosFactor;
	}

	public void setMostrarid_linea_marcaProcesoPreciosFactor(Boolean mostrarid_linea_marcaProcesoPreciosFactor) {
		this.mostrarid_linea_marcaProcesoPreciosFactor= mostrarid_linea_marcaProcesoPreciosFactor;
	}

	public Boolean getActivarid_linea_marcaProcesoPreciosFactor() {
		return this.activarid_linea_marcaProcesoPreciosFactor;
	}

	public void setActivarid_linea_marcaProcesoPreciosFactor(Boolean activarid_linea_marcaProcesoPreciosFactor) {
		this.activarid_linea_marcaProcesoPreciosFactor= activarid_linea_marcaProcesoPreciosFactor;
	}

	public Boolean getCargarid_linea_marcaProcesoPreciosFactor() {
		return this.cargarid_linea_marcaProcesoPreciosFactor;
	}

	public void setCargarid_linea_marcaProcesoPreciosFactor(Boolean cargarid_linea_marcaProcesoPreciosFactor) {
		this.cargarid_linea_marcaProcesoPreciosFactor= cargarid_linea_marcaProcesoPreciosFactor;
	}

	public Border setResaltarcodigoProcesoPreciosFactor(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosFactorBeanSwingJInternalFrame procesopreciosfactorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosfactorBeanSwingJInternalFrame.jTtoolBarProcesoPreciosFactor.setBorder(borderResaltar);
		
		this.resaltarcodigoProcesoPreciosFactor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoProcesoPreciosFactor() {
		return this.resaltarcodigoProcesoPreciosFactor;
	}

	public void setResaltarcodigoProcesoPreciosFactor(Border borderResaltar) {
		this.resaltarcodigoProcesoPreciosFactor= borderResaltar;
	}

	public Boolean getMostrarcodigoProcesoPreciosFactor() {
		return this.mostrarcodigoProcesoPreciosFactor;
	}

	public void setMostrarcodigoProcesoPreciosFactor(Boolean mostrarcodigoProcesoPreciosFactor) {
		this.mostrarcodigoProcesoPreciosFactor= mostrarcodigoProcesoPreciosFactor;
	}

	public Boolean getActivarcodigoProcesoPreciosFactor() {
		return this.activarcodigoProcesoPreciosFactor;
	}

	public void setActivarcodigoProcesoPreciosFactor(Boolean activarcodigoProcesoPreciosFactor) {
		this.activarcodigoProcesoPreciosFactor= activarcodigoProcesoPreciosFactor;
	}

	public Border setResaltarnombreProcesoPreciosFactor(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosFactorBeanSwingJInternalFrame procesopreciosfactorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosfactorBeanSwingJInternalFrame.jTtoolBarProcesoPreciosFactor.setBorder(borderResaltar);
		
		this.resaltarnombreProcesoPreciosFactor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreProcesoPreciosFactor() {
		return this.resaltarnombreProcesoPreciosFactor;
	}

	public void setResaltarnombreProcesoPreciosFactor(Border borderResaltar) {
		this.resaltarnombreProcesoPreciosFactor= borderResaltar;
	}

	public Boolean getMostrarnombreProcesoPreciosFactor() {
		return this.mostrarnombreProcesoPreciosFactor;
	}

	public void setMostrarnombreProcesoPreciosFactor(Boolean mostrarnombreProcesoPreciosFactor) {
		this.mostrarnombreProcesoPreciosFactor= mostrarnombreProcesoPreciosFactor;
	}

	public Boolean getActivarnombreProcesoPreciosFactor() {
		return this.activarnombreProcesoPreciosFactor;
	}

	public void setActivarnombreProcesoPreciosFactor(Boolean activarnombreProcesoPreciosFactor) {
		this.activarnombreProcesoPreciosFactor= activarnombreProcesoPreciosFactor;
	}

	public Border setResaltarcodigo_productoProcesoPreciosFactor(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosFactorBeanSwingJInternalFrame procesopreciosfactorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosfactorBeanSwingJInternalFrame.jTtoolBarProcesoPreciosFactor.setBorder(borderResaltar);
		
		this.resaltarcodigo_productoProcesoPreciosFactor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_productoProcesoPreciosFactor() {
		return this.resaltarcodigo_productoProcesoPreciosFactor;
	}

	public void setResaltarcodigo_productoProcesoPreciosFactor(Border borderResaltar) {
		this.resaltarcodigo_productoProcesoPreciosFactor= borderResaltar;
	}

	public Boolean getMostrarcodigo_productoProcesoPreciosFactor() {
		return this.mostrarcodigo_productoProcesoPreciosFactor;
	}

	public void setMostrarcodigo_productoProcesoPreciosFactor(Boolean mostrarcodigo_productoProcesoPreciosFactor) {
		this.mostrarcodigo_productoProcesoPreciosFactor= mostrarcodigo_productoProcesoPreciosFactor;
	}

	public Boolean getActivarcodigo_productoProcesoPreciosFactor() {
		return this.activarcodigo_productoProcesoPreciosFactor;
	}

	public void setActivarcodigo_productoProcesoPreciosFactor(Boolean activarcodigo_productoProcesoPreciosFactor) {
		this.activarcodigo_productoProcesoPreciosFactor= activarcodigo_productoProcesoPreciosFactor;
	}

	public Border setResaltarnombre_productoProcesoPreciosFactor(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosFactorBeanSwingJInternalFrame procesopreciosfactorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosfactorBeanSwingJInternalFrame.jTtoolBarProcesoPreciosFactor.setBorder(borderResaltar);
		
		this.resaltarnombre_productoProcesoPreciosFactor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoProcesoPreciosFactor() {
		return this.resaltarnombre_productoProcesoPreciosFactor;
	}

	public void setResaltarnombre_productoProcesoPreciosFactor(Border borderResaltar) {
		this.resaltarnombre_productoProcesoPreciosFactor= borderResaltar;
	}

	public Boolean getMostrarnombre_productoProcesoPreciosFactor() {
		return this.mostrarnombre_productoProcesoPreciosFactor;
	}

	public void setMostrarnombre_productoProcesoPreciosFactor(Boolean mostrarnombre_productoProcesoPreciosFactor) {
		this.mostrarnombre_productoProcesoPreciosFactor= mostrarnombre_productoProcesoPreciosFactor;
	}

	public Boolean getActivarnombre_productoProcesoPreciosFactor() {
		return this.activarnombre_productoProcesoPreciosFactor;
	}

	public void setActivarnombre_productoProcesoPreciosFactor(Boolean activarnombre_productoProcesoPreciosFactor) {
		this.activarnombre_productoProcesoPreciosFactor= activarnombre_productoProcesoPreciosFactor;
	}

	public Border setResaltarprecioProcesoPreciosFactor(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosFactorBeanSwingJInternalFrame procesopreciosfactorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosfactorBeanSwingJInternalFrame.jTtoolBarProcesoPreciosFactor.setBorder(borderResaltar);
		
		this.resaltarprecioProcesoPreciosFactor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioProcesoPreciosFactor() {
		return this.resaltarprecioProcesoPreciosFactor;
	}

	public void setResaltarprecioProcesoPreciosFactor(Border borderResaltar) {
		this.resaltarprecioProcesoPreciosFactor= borderResaltar;
	}

	public Boolean getMostrarprecioProcesoPreciosFactor() {
		return this.mostrarprecioProcesoPreciosFactor;
	}

	public void setMostrarprecioProcesoPreciosFactor(Boolean mostrarprecioProcesoPreciosFactor) {
		this.mostrarprecioProcesoPreciosFactor= mostrarprecioProcesoPreciosFactor;
	}

	public Boolean getActivarprecioProcesoPreciosFactor() {
		return this.activarprecioProcesoPreciosFactor;
	}

	public void setActivarprecioProcesoPreciosFactor(Boolean activarprecioProcesoPreciosFactor) {
		this.activarprecioProcesoPreciosFactor= activarprecioProcesoPreciosFactor;
	}

	public Border setResaltarfactorProcesoPreciosFactor(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosFactorBeanSwingJInternalFrame procesopreciosfactorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopreciosfactorBeanSwingJInternalFrame.jTtoolBarProcesoPreciosFactor.setBorder(borderResaltar);
		
		this.resaltarfactorProcesoPreciosFactor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfactorProcesoPreciosFactor() {
		return this.resaltarfactorProcesoPreciosFactor;
	}

	public void setResaltarfactorProcesoPreciosFactor(Border borderResaltar) {
		this.resaltarfactorProcesoPreciosFactor= borderResaltar;
	}

	public Boolean getMostrarfactorProcesoPreciosFactor() {
		return this.mostrarfactorProcesoPreciosFactor;
	}

	public void setMostrarfactorProcesoPreciosFactor(Boolean mostrarfactorProcesoPreciosFactor) {
		this.mostrarfactorProcesoPreciosFactor= mostrarfactorProcesoPreciosFactor;
	}

	public Boolean getActivarfactorProcesoPreciosFactor() {
		return this.activarfactorProcesoPreciosFactor;
	}

	public void setActivarfactorProcesoPreciosFactor(Boolean activarfactorProcesoPreciosFactor) {
		this.activarfactorProcesoPreciosFactor= activarfactorProcesoPreciosFactor;
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
		
		
		this.setMostraridProcesoPreciosFactor(esInicial);
		this.setMostrarid_bodegaProcesoPreciosFactor(esInicial);
		this.setMostrarid_productoProcesoPreciosFactor(esInicial);
		this.setMostrarid_empresaProcesoPreciosFactor(esInicial);
		this.setMostrarid_sucursalProcesoPreciosFactor(esInicial);
		this.setMostrarid_lineaProcesoPreciosFactor(esInicial);
		this.setMostrarid_linea_grupoProcesoPreciosFactor(esInicial);
		this.setMostrarid_linea_categoriaProcesoPreciosFactor(esInicial);
		this.setMostrarid_linea_marcaProcesoPreciosFactor(esInicial);
		this.setMostrarcodigoProcesoPreciosFactor(esInicial);
		this.setMostrarnombreProcesoPreciosFactor(esInicial);
		this.setMostrarcodigo_productoProcesoPreciosFactor(esInicial);
		this.setMostrarnombre_productoProcesoPreciosFactor(esInicial);
		this.setMostrarprecioProcesoPreciosFactor(esInicial);
		this.setMostrarfactorProcesoPreciosFactor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.ID)) {
				this.setMostraridProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.CODIGOPRODUCTO)) {
				this.setMostrarcodigo_productoProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.PRECIO)) {
				this.setMostrarprecioProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.FACTOR)) {
				this.setMostrarfactorProcesoPreciosFactor(esAsigna);
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
		
		
		this.setActivaridProcesoPreciosFactor(esInicial);
		this.setActivarid_bodegaProcesoPreciosFactor(esInicial);
		this.setActivarid_productoProcesoPreciosFactor(esInicial);
		this.setActivarid_empresaProcesoPreciosFactor(esInicial);
		this.setActivarid_sucursalProcesoPreciosFactor(esInicial);
		this.setActivarid_lineaProcesoPreciosFactor(esInicial);
		this.setActivarid_linea_grupoProcesoPreciosFactor(esInicial);
		this.setActivarid_linea_categoriaProcesoPreciosFactor(esInicial);
		this.setActivarid_linea_marcaProcesoPreciosFactor(esInicial);
		this.setActivarcodigoProcesoPreciosFactor(esInicial);
		this.setActivarnombreProcesoPreciosFactor(esInicial);
		this.setActivarcodigo_productoProcesoPreciosFactor(esInicial);
		this.setActivarnombre_productoProcesoPreciosFactor(esInicial);
		this.setActivarprecioProcesoPreciosFactor(esInicial);
		this.setActivarfactorProcesoPreciosFactor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.ID)) {
				this.setActivaridProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.CODIGO)) {
				this.setActivarcodigoProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.NOMBRE)) {
				this.setActivarnombreProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.CODIGOPRODUCTO)) {
				this.setActivarcodigo_productoProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.PRECIO)) {
				this.setActivarprecioProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.FACTOR)) {
				this.setActivarfactorProcesoPreciosFactor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoPreciosFactorBeanSwingJInternalFrame procesopreciosfactorBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoPreciosFactor(esInicial);
		this.setResaltarid_bodegaProcesoPreciosFactor(esInicial);
		this.setResaltarid_productoProcesoPreciosFactor(esInicial);
		this.setResaltarid_empresaProcesoPreciosFactor(esInicial);
		this.setResaltarid_sucursalProcesoPreciosFactor(esInicial);
		this.setResaltarid_lineaProcesoPreciosFactor(esInicial);
		this.setResaltarid_linea_grupoProcesoPreciosFactor(esInicial);
		this.setResaltarid_linea_categoriaProcesoPreciosFactor(esInicial);
		this.setResaltarid_linea_marcaProcesoPreciosFactor(esInicial);
		this.setResaltarcodigoProcesoPreciosFactor(esInicial);
		this.setResaltarnombreProcesoPreciosFactor(esInicial);
		this.setResaltarcodigo_productoProcesoPreciosFactor(esInicial);
		this.setResaltarnombre_productoProcesoPreciosFactor(esInicial);
		this.setResaltarprecioProcesoPreciosFactor(esInicial);
		this.setResaltarfactorProcesoPreciosFactor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.ID)) {
				this.setResaltaridProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.CODIGOPRODUCTO)) {
				this.setResaltarcodigo_productoProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.PRECIO)) {
				this.setResaltarprecioProcesoPreciosFactor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPreciosFactorConstantesFunciones.FACTOR)) {
				this.setResaltarfactorProcesoPreciosFactor(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoPreciosFactorBeanSwingJInternalFrame procesopreciosfactorBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoPreciosFactorProcesoPreciosFactor=true;

	public Boolean getMostrarBusquedaProcesoPreciosFactorProcesoPreciosFactor() {
		return this.mostrarBusquedaProcesoPreciosFactorProcesoPreciosFactor;
	}

	public void setMostrarBusquedaProcesoPreciosFactorProcesoPreciosFactor(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoPreciosFactorProcesoPreciosFactor= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoPreciosFactorProcesoPreciosFactor=true;

	public Boolean getActivarBusquedaProcesoPreciosFactorProcesoPreciosFactor() {
		return this.activarBusquedaProcesoPreciosFactorProcesoPreciosFactor;
	}

	public void setActivarBusquedaProcesoPreciosFactorProcesoPreciosFactor(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoPreciosFactorProcesoPreciosFactor= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoPreciosFactorProcesoPreciosFactor=null;

	public Border getResaltarBusquedaProcesoPreciosFactorProcesoPreciosFactor() {
		return this.resaltarBusquedaProcesoPreciosFactorProcesoPreciosFactor;
	}

	public void setResaltarBusquedaProcesoPreciosFactorProcesoPreciosFactor(Border borderResaltar) {
		this.resaltarBusquedaProcesoPreciosFactorProcesoPreciosFactor= borderResaltar;
	}

	public void setResaltarBusquedaProcesoPreciosFactorProcesoPreciosFactor(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPreciosFactorBeanSwingJInternalFrame procesopreciosfactorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoPreciosFactorProcesoPreciosFactor= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}