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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.IngredienteConstantesFunciones;
import com.bydan.erp.inventario.util.IngredienteParameterReturnGeneral;
//import com.bydan.erp.inventario.util.IngredienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class IngredienteConstantesFunciones extends IngredienteConstantesFuncionesAdditional {		
	
	
	
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
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="Ingrediente";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Ingrediente"+IngredienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="IngredienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="IngredienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=IngredienteConstantesFunciones.SCHEMA+"_"+IngredienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/IngredienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=IngredienteConstantesFunciones.SCHEMA+"_"+IngredienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=IngredienteConstantesFunciones.SCHEMA+"_"+IngredienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/IngredienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=IngredienteConstantesFunciones.SCHEMA+"_"+IngredienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+IngredienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/IngredienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+IngredienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+IngredienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/IngredienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+IngredienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=IngredienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+IngredienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=IngredienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+IngredienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Ingredientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Ingrediente";
	public static final String SCLASSWEBTITULO_LOWER="Ingrediente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Ingrediente";
	public static final String OBJECTNAME="ingrediente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="ingrediente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select ingrediente from "+IngredienteConstantesFunciones.SPERSISTENCENAME+" ingrediente";
	public static String QUERYSELECTNATIVE="select "+IngredienteConstantesFunciones.SCHEMA+"."+IngredienteConstantesFunciones.TABLENAME+".id,"+IngredienteConstantesFunciones.SCHEMA+"."+IngredienteConstantesFunciones.TABLENAME+".version_row,"+IngredienteConstantesFunciones.SCHEMA+"."+IngredienteConstantesFunciones.TABLENAME+".id_empresa,"+IngredienteConstantesFunciones.SCHEMA+"."+IngredienteConstantesFunciones.TABLENAME+".id_sucursal,"+IngredienteConstantesFunciones.SCHEMA+"."+IngredienteConstantesFunciones.TABLENAME+".id_bodega,"+IngredienteConstantesFunciones.SCHEMA+"."+IngredienteConstantesFunciones.TABLENAME+".id_bodega_relacion,"+IngredienteConstantesFunciones.SCHEMA+"."+IngredienteConstantesFunciones.TABLENAME+".id_producto,"+IngredienteConstantesFunciones.SCHEMA+"."+IngredienteConstantesFunciones.TABLENAME+".id_producto_relacion,"+IngredienteConstantesFunciones.SCHEMA+"."+IngredienteConstantesFunciones.TABLENAME+".cantidad,"+IngredienteConstantesFunciones.SCHEMA+"."+IngredienteConstantesFunciones.TABLENAME+".precio from "+IngredienteConstantesFunciones.SCHEMA+"."+IngredienteConstantesFunciones.TABLENAME;//+" as "+IngredienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected IngredienteConstantesFuncionesAdditional ingredienteConstantesFuncionesAdditional=null;
	
	public IngredienteConstantesFuncionesAdditional getIngredienteConstantesFuncionesAdditional() {
		return this.ingredienteConstantesFuncionesAdditional;
	}
	
	public void setIngredienteConstantesFuncionesAdditional(IngredienteConstantesFuncionesAdditional ingredienteConstantesFuncionesAdditional) {
		try {
			this.ingredienteConstantesFuncionesAdditional=ingredienteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDBODEGARELACION= "id_bodega_relacion";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDPRODUCTORELACION= "id_producto_relacion";
    public static final String CANTIDAD= "cantidad";
    public static final String PRECIO= "precio";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDBODEGARELACION= "Bodega Relacion";
		public static final String LABEL_IDBODEGARELACION_LOWER= "Bodega Relacion";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDPRODUCTORELACION= "Producto Relacion";
		public static final String LABEL_IDPRODUCTORELACION_LOWER= "Producto Relacion";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
	
		
		
		
		
		
		
		
		
		
		
	
	public static String getIngredienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(IngredienteConstantesFunciones.IDEMPRESA)) {sLabelColumna=IngredienteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(IngredienteConstantesFunciones.IDSUCURSAL)) {sLabelColumna=IngredienteConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(IngredienteConstantesFunciones.IDBODEGA)) {sLabelColumna=IngredienteConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(IngredienteConstantesFunciones.IDBODEGARELACION)) {sLabelColumna=IngredienteConstantesFunciones.LABEL_IDBODEGARELACION;}
		if(sNombreColumna.equals(IngredienteConstantesFunciones.IDPRODUCTO)) {sLabelColumna=IngredienteConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(IngredienteConstantesFunciones.IDPRODUCTORELACION)) {sLabelColumna=IngredienteConstantesFunciones.LABEL_IDPRODUCTORELACION;}
		if(sNombreColumna.equals(IngredienteConstantesFunciones.CANTIDAD)) {sLabelColumna=IngredienteConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(IngredienteConstantesFunciones.PRECIO)) {sLabelColumna=IngredienteConstantesFunciones.LABEL_PRECIO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
	
	public static String getIngredienteDescripcion(Ingrediente ingrediente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(ingrediente !=null/* && ingrediente.getId()!=0*/) {
			if(ingrediente.getId()!=null) {
				sDescripcion=ingrediente.getId().toString();
			}//ingredienteingrediente.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getIngredienteDescripcionDetallado(Ingrediente ingrediente) {
		String sDescripcion="";
			
		sDescripcion+=IngredienteConstantesFunciones.ID+"=";
		sDescripcion+=ingrediente.getId().toString()+",";
		sDescripcion+=IngredienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=ingrediente.getVersionRow().toString()+",";
		sDescripcion+=IngredienteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=ingrediente.getid_empresa().toString()+",";
		sDescripcion+=IngredienteConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=ingrediente.getid_sucursal().toString()+",";
		sDescripcion+=IngredienteConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=ingrediente.getid_bodega().toString()+",";
		sDescripcion+=IngredienteConstantesFunciones.IDBODEGARELACION+"=";
		sDescripcion+=ingrediente.getid_bodega_relacion().toString()+",";
		sDescripcion+=IngredienteConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=ingrediente.getid_producto().toString()+",";
		sDescripcion+=IngredienteConstantesFunciones.IDPRODUCTORELACION+"=";
		sDescripcion+=ingrediente.getid_producto_relacion().toString()+",";
		sDescripcion+=IngredienteConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=ingrediente.getcantidad().toString()+",";
		sDescripcion+=IngredienteConstantesFunciones.PRECIO+"=";
		sDescripcion+=ingrediente.getprecio().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setIngredienteDescripcion(Ingrediente ingrediente,String sValor) throws Exception {			
		if(ingrediente !=null) {
			//ingredienteingrediente.getId().toString();
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

	public static String getBodegaRelacionDescripcion(Bodega bodega) {
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

	public static String getProductoRelacionDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdBodegaRelacion")) {
			sNombreIndice="Tipo=  Por Bodega Relacion";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdProductoRelacion")) {
			sNombreIndice="Tipo=  Por Producto Relacion";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodegaRelacion(Long id_bodega_relacion) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega_relacion!=null) {sDetalleIndice+=" Codigo Unico De Bodega Relacion="+id_bodega_relacion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProductoRelacion(Long id_producto_relacion) {
		String sDetalleIndice=" Parametros->";
		if(id_producto_relacion!=null) {sDetalleIndice+=" Codigo Unico De Producto Relacion="+id_producto_relacion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosIngrediente(Ingrediente ingrediente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosIngredientes(List<Ingrediente> ingredientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Ingrediente ingrediente: ingredientes) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresIngrediente(Ingrediente ingrediente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && ingrediente.getConCambioAuxiliar()) {
			ingrediente.setIsDeleted(ingrediente.getIsDeletedAuxiliar());	
			ingrediente.setIsNew(ingrediente.getIsNewAuxiliar());	
			ingrediente.setIsChanged(ingrediente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			ingrediente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			ingrediente.setIsDeletedAuxiliar(false);	
			ingrediente.setIsNewAuxiliar(false);	
			ingrediente.setIsChangedAuxiliar(false);
			
			ingrediente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresIngredientes(List<Ingrediente> ingredientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Ingrediente ingrediente : ingredientes) {
			if(conAsignarBase && ingrediente.getConCambioAuxiliar()) {
				ingrediente.setIsDeleted(ingrediente.getIsDeletedAuxiliar());	
				ingrediente.setIsNew(ingrediente.getIsNewAuxiliar());	
				ingrediente.setIsChanged(ingrediente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				ingrediente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				ingrediente.setIsDeletedAuxiliar(false);	
				ingrediente.setIsNewAuxiliar(false);	
				ingrediente.setIsChangedAuxiliar(false);
				
				ingrediente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresIngrediente(Ingrediente ingrediente,Boolean conEnteros) throws Exception  {
		ingrediente.setprecio(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			ingrediente.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresIngredientes(List<Ingrediente> ingredientes,Boolean conEnteros) throws Exception  {
		
		for(Ingrediente ingrediente: ingredientes) {
			ingrediente.setprecio(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				ingrediente.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaIngrediente(List<Ingrediente> ingredientes,Ingrediente ingredienteAux) throws Exception  {
		IngredienteConstantesFunciones.InicializarValoresIngrediente(ingredienteAux,true);
		
		for(Ingrediente ingrediente: ingredientes) {
			if(ingrediente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ingredienteAux.setcantidad(ingredienteAux.getcantidad()+ingrediente.getcantidad());			
			ingredienteAux.setprecio(ingredienteAux.getprecio()+ingrediente.getprecio());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesIngrediente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=IngredienteConstantesFunciones.getArrayColumnasGlobalesIngrediente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesIngrediente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(IngredienteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(IngredienteConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(IngredienteConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(IngredienteConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoIngrediente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Ingrediente> ingredientes,Ingrediente ingrediente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Ingrediente ingredienteAux: ingredientes) {
			if(ingredienteAux!=null && ingrediente!=null) {
				if((ingredienteAux.getId()==null && ingrediente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(ingredienteAux.getId()!=null && ingrediente.getId()!=null){
					if(ingredienteAux.getId().equals(ingrediente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaIngrediente(List<Ingrediente> ingredientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
	
		for(Ingrediente ingrediente: ingredientes) {			
			if(ingrediente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=ingrediente.getprecio();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(IngredienteConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(IngredienteConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaIngrediente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,IngredienteConstantesFunciones.LABEL_ID, IngredienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngredienteConstantesFunciones.LABEL_VERSIONROW, IngredienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngredienteConstantesFunciones.LABEL_IDEMPRESA, IngredienteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngredienteConstantesFunciones.LABEL_IDSUCURSAL, IngredienteConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngredienteConstantesFunciones.LABEL_IDBODEGA, IngredienteConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngredienteConstantesFunciones.LABEL_IDBODEGARELACION, IngredienteConstantesFunciones.IDBODEGARELACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngredienteConstantesFunciones.LABEL_IDPRODUCTO, IngredienteConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngredienteConstantesFunciones.LABEL_IDPRODUCTORELACION, IngredienteConstantesFunciones.IDPRODUCTORELACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngredienteConstantesFunciones.LABEL_CANTIDAD, IngredienteConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IngredienteConstantesFunciones.LABEL_PRECIO, IngredienteConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasIngrediente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=IngredienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngredienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngredienteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngredienteConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngredienteConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngredienteConstantesFunciones.IDBODEGARELACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngredienteConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngredienteConstantesFunciones.IDPRODUCTORELACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngredienteConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IngredienteConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarIngrediente() throws Exception  {
		return IngredienteConstantesFunciones.getTiposSeleccionarIngrediente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarIngrediente(Boolean conFk) throws Exception  {
		return IngredienteConstantesFunciones.getTiposSeleccionarIngrediente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarIngrediente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(IngredienteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(IngredienteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(IngredienteConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(IngredienteConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(IngredienteConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(IngredienteConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(IngredienteConstantesFunciones.LABEL_IDBODEGARELACION);
			reporte.setsDescripcion(IngredienteConstantesFunciones.LABEL_IDBODEGARELACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(IngredienteConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(IngredienteConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(IngredienteConstantesFunciones.LABEL_IDPRODUCTORELACION);
			reporte.setsDescripcion(IngredienteConstantesFunciones.LABEL_IDPRODUCTORELACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IngredienteConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(IngredienteConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IngredienteConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(IngredienteConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesIngrediente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesIngrediente(Ingrediente ingredienteAux) throws Exception {
		
			ingredienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ingredienteAux.getEmpresa()));
			ingredienteAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ingredienteAux.getSucursal()));
			ingredienteAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(ingredienteAux.getBodega()));
			ingredienteAux.setbodegarelacion_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(ingredienteAux.getBodegaRelacion()));
			ingredienteAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(ingredienteAux.getProducto()));
			ingredienteAux.setproductorelacion_descripcion(ProductoConstantesFunciones.getProductoDescripcion(ingredienteAux.getProductoRelacion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesIngrediente(List<Ingrediente> ingredientesTemp) throws Exception {
		for(Ingrediente ingredienteAux:ingredientesTemp) {
			
			ingredienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ingredienteAux.getEmpresa()));
			ingredienteAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ingredienteAux.getSucursal()));
			ingredienteAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(ingredienteAux.getBodega()));
			ingredienteAux.setbodegarelacion_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(ingredienteAux.getBodegaRelacion()));
			ingredienteAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(ingredienteAux.getProducto()));
			ingredienteAux.setproductorelacion_descripcion(ProductoConstantesFunciones.getProductoDescripcion(ingredienteAux.getProductoRelacion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfIngrediente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Producto.class));
				
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
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfIngrediente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfIngrediente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return IngredienteConstantesFunciones.getClassesRelationshipsOfIngrediente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfIngrediente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfIngrediente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return IngredienteConstantesFunciones.getClassesRelationshipsFromStringsOfIngrediente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfIngrediente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Ingrediente ingrediente,List<Ingrediente> ingredientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Ingrediente ingredienteEncontrado=null;
			
			for(Ingrediente ingredienteLocal:ingredientes) {
				if(ingredienteLocal.getId().equals(ingrediente.getId())) {
					ingredienteEncontrado=ingredienteLocal;
					
					ingredienteLocal.setIsChanged(ingrediente.getIsChanged());
					ingredienteLocal.setIsNew(ingrediente.getIsNew());
					ingredienteLocal.setIsDeleted(ingrediente.getIsDeleted());
					
					ingredienteLocal.setGeneralEntityOriginal(ingrediente.getGeneralEntityOriginal());
					
					ingredienteLocal.setId(ingrediente.getId());	
					ingredienteLocal.setVersionRow(ingrediente.getVersionRow());	
					ingredienteLocal.setid_empresa(ingrediente.getid_empresa());	
					ingredienteLocal.setid_sucursal(ingrediente.getid_sucursal());	
					ingredienteLocal.setid_bodega(ingrediente.getid_bodega());	
					ingredienteLocal.setid_bodega_relacion(ingrediente.getid_bodega_relacion());	
					ingredienteLocal.setid_producto(ingrediente.getid_producto());	
					ingredienteLocal.setid_producto_relacion(ingrediente.getid_producto_relacion());	
					ingredienteLocal.setcantidad(ingrediente.getcantidad());	
					ingredienteLocal.setprecio(ingrediente.getprecio());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!ingrediente.getIsDeleted()) {
				if(!existe) {
					ingredientes.add(ingrediente);
				}
			} else {
				if(ingredienteEncontrado!=null && permiteQuitar)  {
					ingredientes.remove(ingredienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Ingrediente ingrediente,List<Ingrediente> ingredientes) throws Exception {
		try	{			
			for(Ingrediente ingredienteLocal:ingredientes) {
				if(ingredienteLocal.getId().equals(ingrediente.getId())) {
					ingredienteLocal.setIsSelected(ingrediente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesIngrediente(List<Ingrediente> ingredientesAux) throws Exception {
		//this.ingredientesAux=ingredientesAux;
		
		for(Ingrediente ingredienteAux:ingredientesAux) {
			if(ingredienteAux.getIsChanged()) {
				ingredienteAux.setIsChanged(false);
			}		
			
			if(ingredienteAux.getIsNew()) {
				ingredienteAux.setIsNew(false);
			}	
			
			if(ingredienteAux.getIsDeleted()) {
				ingredienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesIngrediente(Ingrediente ingredienteAux) throws Exception {
		//this.ingredienteAux=ingredienteAux;
		
			if(ingredienteAux.getIsChanged()) {
				ingredienteAux.setIsChanged(false);
			}		
			
			if(ingredienteAux.getIsNew()) {
				ingredienteAux.setIsNew(false);
			}	
			
			if(ingredienteAux.getIsDeleted()) {
				ingredienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Ingrediente ingredienteAsignar,Ingrediente ingrediente) throws Exception {
		ingredienteAsignar.setId(ingrediente.getId());	
		ingredienteAsignar.setVersionRow(ingrediente.getVersionRow());	
		ingredienteAsignar.setid_empresa(ingrediente.getid_empresa());
		ingredienteAsignar.setempresa_descripcion(ingrediente.getempresa_descripcion());	
		ingredienteAsignar.setid_sucursal(ingrediente.getid_sucursal());
		ingredienteAsignar.setsucursal_descripcion(ingrediente.getsucursal_descripcion());	
		ingredienteAsignar.setid_bodega(ingrediente.getid_bodega());
		ingredienteAsignar.setbodega_descripcion(ingrediente.getbodega_descripcion());	
		ingredienteAsignar.setid_bodega_relacion(ingrediente.getid_bodega_relacion());
		ingredienteAsignar.setbodegarelacion_descripcion(ingrediente.getbodegarelacion_descripcion());	
		ingredienteAsignar.setid_producto(ingrediente.getid_producto());
		ingredienteAsignar.setproducto_descripcion(ingrediente.getproducto_descripcion());	
		ingredienteAsignar.setid_producto_relacion(ingrediente.getid_producto_relacion());
		ingredienteAsignar.setproductorelacion_descripcion(ingrediente.getproductorelacion_descripcion());	
		ingredienteAsignar.setcantidad(ingrediente.getcantidad());	
		ingredienteAsignar.setprecio(ingrediente.getprecio());	
	}
	
	public static void inicializarIngrediente(Ingrediente ingrediente) throws Exception {
		try {
				ingrediente.setId(0L);	
					
				ingrediente.setid_empresa(-1L);	
				ingrediente.setid_sucursal(-1L);	
				ingrediente.setid_bodega(-1L);	
				ingrediente.setid_bodega_relacion(-1L);	
				ingrediente.setid_producto(-1L);	
				ingrediente.setid_producto_relacion(-1L);	
				ingrediente.setcantidad(0);	
				ingrediente.setprecio(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderIngrediente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(IngredienteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngredienteConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngredienteConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngredienteConstantesFunciones.LABEL_IDBODEGARELACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngredienteConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngredienteConstantesFunciones.LABEL_IDPRODUCTORELACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngredienteConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IngredienteConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataIngrediente(String sTipo,Row row,Workbook workbook,Ingrediente ingrediente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(ingrediente.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingrediente.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingrediente.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingrediente.getbodegarelacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingrediente.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingrediente.getproductorelacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingrediente.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ingrediente.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryIngrediente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryIngrediente() {
		return this.sFinalQueryIngrediente;
	}
	
	public void setsFinalQueryIngrediente(String sFinalQueryIngrediente) {
		this.sFinalQueryIngrediente= sFinalQueryIngrediente;
	}
	
	public Border resaltarSeleccionarIngrediente=null;
	
	public Border setResaltarSeleccionarIngrediente(ParametroGeneralUsuario parametroGeneralUsuario/*IngredienteBeanSwingJInternalFrame ingredienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//ingredienteBeanSwingJInternalFrame.jTtoolBarIngrediente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarIngrediente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarIngrediente() {
		return this.resaltarSeleccionarIngrediente;
	}
	
	public void setResaltarSeleccionarIngrediente(Border borderResaltarSeleccionarIngrediente) {
		this.resaltarSeleccionarIngrediente= borderResaltarSeleccionarIngrediente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridIngrediente=null;
	public Boolean mostraridIngrediente=true;
	public Boolean activaridIngrediente=true;

	public Border resaltarid_empresaIngrediente=null;
	public Boolean mostrarid_empresaIngrediente=true;
	public Boolean activarid_empresaIngrediente=true;
	public Boolean cargarid_empresaIngrediente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaIngrediente=false;//ConEventDepend=true

	public Border resaltarid_sucursalIngrediente=null;
	public Boolean mostrarid_sucursalIngrediente=true;
	public Boolean activarid_sucursalIngrediente=true;
	public Boolean cargarid_sucursalIngrediente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalIngrediente=false;//ConEventDepend=true

	public Border resaltarid_bodegaIngrediente=null;
	public Boolean mostrarid_bodegaIngrediente=true;
	public Boolean activarid_bodegaIngrediente=true;
	public Boolean cargarid_bodegaIngrediente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaIngrediente=false;//ConEventDepend=true

	public Border resaltarid_bodega_relacionIngrediente=null;
	public Boolean mostrarid_bodega_relacionIngrediente=true;
	public Boolean activarid_bodega_relacionIngrediente=true;
	public Boolean cargarid_bodega_relacionIngrediente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodega_relacionIngrediente=false;//ConEventDepend=true

	public Border resaltarid_productoIngrediente=null;
	public Boolean mostrarid_productoIngrediente=true;
	public Boolean activarid_productoIngrediente=true;
	public Boolean cargarid_productoIngrediente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoIngrediente=false;//ConEventDepend=true

	public Border resaltarid_producto_relacionIngrediente=null;
	public Boolean mostrarid_producto_relacionIngrediente=true;
	public Boolean activarid_producto_relacionIngrediente=true;
	public Boolean cargarid_producto_relacionIngrediente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_producto_relacionIngrediente=false;//ConEventDepend=true

	public Border resaltarcantidadIngrediente=null;
	public Boolean mostrarcantidadIngrediente=true;
	public Boolean activarcantidadIngrediente=true;

	public Border resaltarprecioIngrediente=null;
	public Boolean mostrarprecioIngrediente=true;
	public Boolean activarprecioIngrediente=true;

	
	

	public Border setResaltaridIngrediente(ParametroGeneralUsuario parametroGeneralUsuario/*IngredienteBeanSwingJInternalFrame ingredienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingredienteBeanSwingJInternalFrame.jTtoolBarIngrediente.setBorder(borderResaltar);
		
		this.resaltaridIngrediente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridIngrediente() {
		return this.resaltaridIngrediente;
	}

	public void setResaltaridIngrediente(Border borderResaltar) {
		this.resaltaridIngrediente= borderResaltar;
	}

	public Boolean getMostraridIngrediente() {
		return this.mostraridIngrediente;
	}

	public void setMostraridIngrediente(Boolean mostraridIngrediente) {
		this.mostraridIngrediente= mostraridIngrediente;
	}

	public Boolean getActivaridIngrediente() {
		return this.activaridIngrediente;
	}

	public void setActivaridIngrediente(Boolean activaridIngrediente) {
		this.activaridIngrediente= activaridIngrediente;
	}

	public Border setResaltarid_empresaIngrediente(ParametroGeneralUsuario parametroGeneralUsuario/*IngredienteBeanSwingJInternalFrame ingredienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingredienteBeanSwingJInternalFrame.jTtoolBarIngrediente.setBorder(borderResaltar);
		
		this.resaltarid_empresaIngrediente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaIngrediente() {
		return this.resaltarid_empresaIngrediente;
	}

	public void setResaltarid_empresaIngrediente(Border borderResaltar) {
		this.resaltarid_empresaIngrediente= borderResaltar;
	}

	public Boolean getMostrarid_empresaIngrediente() {
		return this.mostrarid_empresaIngrediente;
	}

	public void setMostrarid_empresaIngrediente(Boolean mostrarid_empresaIngrediente) {
		this.mostrarid_empresaIngrediente= mostrarid_empresaIngrediente;
	}

	public Boolean getActivarid_empresaIngrediente() {
		return this.activarid_empresaIngrediente;
	}

	public void setActivarid_empresaIngrediente(Boolean activarid_empresaIngrediente) {
		this.activarid_empresaIngrediente= activarid_empresaIngrediente;
	}

	public Boolean getCargarid_empresaIngrediente() {
		return this.cargarid_empresaIngrediente;
	}

	public void setCargarid_empresaIngrediente(Boolean cargarid_empresaIngrediente) {
		this.cargarid_empresaIngrediente= cargarid_empresaIngrediente;
	}

	public Border setResaltarid_sucursalIngrediente(ParametroGeneralUsuario parametroGeneralUsuario/*IngredienteBeanSwingJInternalFrame ingredienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingredienteBeanSwingJInternalFrame.jTtoolBarIngrediente.setBorder(borderResaltar);
		
		this.resaltarid_sucursalIngrediente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalIngrediente() {
		return this.resaltarid_sucursalIngrediente;
	}

	public void setResaltarid_sucursalIngrediente(Border borderResaltar) {
		this.resaltarid_sucursalIngrediente= borderResaltar;
	}

	public Boolean getMostrarid_sucursalIngrediente() {
		return this.mostrarid_sucursalIngrediente;
	}

	public void setMostrarid_sucursalIngrediente(Boolean mostrarid_sucursalIngrediente) {
		this.mostrarid_sucursalIngrediente= mostrarid_sucursalIngrediente;
	}

	public Boolean getActivarid_sucursalIngrediente() {
		return this.activarid_sucursalIngrediente;
	}

	public void setActivarid_sucursalIngrediente(Boolean activarid_sucursalIngrediente) {
		this.activarid_sucursalIngrediente= activarid_sucursalIngrediente;
	}

	public Boolean getCargarid_sucursalIngrediente() {
		return this.cargarid_sucursalIngrediente;
	}

	public void setCargarid_sucursalIngrediente(Boolean cargarid_sucursalIngrediente) {
		this.cargarid_sucursalIngrediente= cargarid_sucursalIngrediente;
	}

	public Border setResaltarid_bodegaIngrediente(ParametroGeneralUsuario parametroGeneralUsuario/*IngredienteBeanSwingJInternalFrame ingredienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingredienteBeanSwingJInternalFrame.jTtoolBarIngrediente.setBorder(borderResaltar);
		
		this.resaltarid_bodegaIngrediente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaIngrediente() {
		return this.resaltarid_bodegaIngrediente;
	}

	public void setResaltarid_bodegaIngrediente(Border borderResaltar) {
		this.resaltarid_bodegaIngrediente= borderResaltar;
	}

	public Boolean getMostrarid_bodegaIngrediente() {
		return this.mostrarid_bodegaIngrediente;
	}

	public void setMostrarid_bodegaIngrediente(Boolean mostrarid_bodegaIngrediente) {
		this.mostrarid_bodegaIngrediente= mostrarid_bodegaIngrediente;
	}

	public Boolean getActivarid_bodegaIngrediente() {
		return this.activarid_bodegaIngrediente;
	}

	public void setActivarid_bodegaIngrediente(Boolean activarid_bodegaIngrediente) {
		this.activarid_bodegaIngrediente= activarid_bodegaIngrediente;
	}

	public Boolean getCargarid_bodegaIngrediente() {
		return this.cargarid_bodegaIngrediente;
	}

	public void setCargarid_bodegaIngrediente(Boolean cargarid_bodegaIngrediente) {
		this.cargarid_bodegaIngrediente= cargarid_bodegaIngrediente;
	}

	public Border setResaltarid_bodega_relacionIngrediente(ParametroGeneralUsuario parametroGeneralUsuario/*IngredienteBeanSwingJInternalFrame ingredienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingredienteBeanSwingJInternalFrame.jTtoolBarIngrediente.setBorder(borderResaltar);
		
		this.resaltarid_bodega_relacionIngrediente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodega_relacionIngrediente() {
		return this.resaltarid_bodega_relacionIngrediente;
	}

	public void setResaltarid_bodega_relacionIngrediente(Border borderResaltar) {
		this.resaltarid_bodega_relacionIngrediente= borderResaltar;
	}

	public Boolean getMostrarid_bodega_relacionIngrediente() {
		return this.mostrarid_bodega_relacionIngrediente;
	}

	public void setMostrarid_bodega_relacionIngrediente(Boolean mostrarid_bodega_relacionIngrediente) {
		this.mostrarid_bodega_relacionIngrediente= mostrarid_bodega_relacionIngrediente;
	}

	public Boolean getActivarid_bodega_relacionIngrediente() {
		return this.activarid_bodega_relacionIngrediente;
	}

	public void setActivarid_bodega_relacionIngrediente(Boolean activarid_bodega_relacionIngrediente) {
		this.activarid_bodega_relacionIngrediente= activarid_bodega_relacionIngrediente;
	}

	public Boolean getCargarid_bodega_relacionIngrediente() {
		return this.cargarid_bodega_relacionIngrediente;
	}

	public void setCargarid_bodega_relacionIngrediente(Boolean cargarid_bodega_relacionIngrediente) {
		this.cargarid_bodega_relacionIngrediente= cargarid_bodega_relacionIngrediente;
	}

	public Border setResaltarid_productoIngrediente(ParametroGeneralUsuario parametroGeneralUsuario/*IngredienteBeanSwingJInternalFrame ingredienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingredienteBeanSwingJInternalFrame.jTtoolBarIngrediente.setBorder(borderResaltar);
		
		this.resaltarid_productoIngrediente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoIngrediente() {
		return this.resaltarid_productoIngrediente;
	}

	public void setResaltarid_productoIngrediente(Border borderResaltar) {
		this.resaltarid_productoIngrediente= borderResaltar;
	}

	public Boolean getMostrarid_productoIngrediente() {
		return this.mostrarid_productoIngrediente;
	}

	public void setMostrarid_productoIngrediente(Boolean mostrarid_productoIngrediente) {
		this.mostrarid_productoIngrediente= mostrarid_productoIngrediente;
	}

	public Boolean getActivarid_productoIngrediente() {
		return this.activarid_productoIngrediente;
	}

	public void setActivarid_productoIngrediente(Boolean activarid_productoIngrediente) {
		this.activarid_productoIngrediente= activarid_productoIngrediente;
	}

	public Boolean getCargarid_productoIngrediente() {
		return this.cargarid_productoIngrediente;
	}

	public void setCargarid_productoIngrediente(Boolean cargarid_productoIngrediente) {
		this.cargarid_productoIngrediente= cargarid_productoIngrediente;
	}

	public Border setResaltarid_producto_relacionIngrediente(ParametroGeneralUsuario parametroGeneralUsuario/*IngredienteBeanSwingJInternalFrame ingredienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingredienteBeanSwingJInternalFrame.jTtoolBarIngrediente.setBorder(borderResaltar);
		
		this.resaltarid_producto_relacionIngrediente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_producto_relacionIngrediente() {
		return this.resaltarid_producto_relacionIngrediente;
	}

	public void setResaltarid_producto_relacionIngrediente(Border borderResaltar) {
		this.resaltarid_producto_relacionIngrediente= borderResaltar;
	}

	public Boolean getMostrarid_producto_relacionIngrediente() {
		return this.mostrarid_producto_relacionIngrediente;
	}

	public void setMostrarid_producto_relacionIngrediente(Boolean mostrarid_producto_relacionIngrediente) {
		this.mostrarid_producto_relacionIngrediente= mostrarid_producto_relacionIngrediente;
	}

	public Boolean getActivarid_producto_relacionIngrediente() {
		return this.activarid_producto_relacionIngrediente;
	}

	public void setActivarid_producto_relacionIngrediente(Boolean activarid_producto_relacionIngrediente) {
		this.activarid_producto_relacionIngrediente= activarid_producto_relacionIngrediente;
	}

	public Boolean getCargarid_producto_relacionIngrediente() {
		return this.cargarid_producto_relacionIngrediente;
	}

	public void setCargarid_producto_relacionIngrediente(Boolean cargarid_producto_relacionIngrediente) {
		this.cargarid_producto_relacionIngrediente= cargarid_producto_relacionIngrediente;
	}

	public Border setResaltarcantidadIngrediente(ParametroGeneralUsuario parametroGeneralUsuario/*IngredienteBeanSwingJInternalFrame ingredienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingredienteBeanSwingJInternalFrame.jTtoolBarIngrediente.setBorder(borderResaltar);
		
		this.resaltarcantidadIngrediente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadIngrediente() {
		return this.resaltarcantidadIngrediente;
	}

	public void setResaltarcantidadIngrediente(Border borderResaltar) {
		this.resaltarcantidadIngrediente= borderResaltar;
	}

	public Boolean getMostrarcantidadIngrediente() {
		return this.mostrarcantidadIngrediente;
	}

	public void setMostrarcantidadIngrediente(Boolean mostrarcantidadIngrediente) {
		this.mostrarcantidadIngrediente= mostrarcantidadIngrediente;
	}

	public Boolean getActivarcantidadIngrediente() {
		return this.activarcantidadIngrediente;
	}

	public void setActivarcantidadIngrediente(Boolean activarcantidadIngrediente) {
		this.activarcantidadIngrediente= activarcantidadIngrediente;
	}

	public Border setResaltarprecioIngrediente(ParametroGeneralUsuario parametroGeneralUsuario/*IngredienteBeanSwingJInternalFrame ingredienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ingredienteBeanSwingJInternalFrame.jTtoolBarIngrediente.setBorder(borderResaltar);
		
		this.resaltarprecioIngrediente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioIngrediente() {
		return this.resaltarprecioIngrediente;
	}

	public void setResaltarprecioIngrediente(Border borderResaltar) {
		this.resaltarprecioIngrediente= borderResaltar;
	}

	public Boolean getMostrarprecioIngrediente() {
		return this.mostrarprecioIngrediente;
	}

	public void setMostrarprecioIngrediente(Boolean mostrarprecioIngrediente) {
		this.mostrarprecioIngrediente= mostrarprecioIngrediente;
	}

	public Boolean getActivarprecioIngrediente() {
		return this.activarprecioIngrediente;
	}

	public void setActivarprecioIngrediente(Boolean activarprecioIngrediente) {
		this.activarprecioIngrediente= activarprecioIngrediente;
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
		
		
		this.setMostraridIngrediente(esInicial);
		this.setMostrarid_empresaIngrediente(esInicial);
		this.setMostrarid_sucursalIngrediente(esInicial);
		this.setMostrarid_bodegaIngrediente(esInicial);
		this.setMostrarid_bodega_relacionIngrediente(esInicial);
		this.setMostrarid_productoIngrediente(esInicial);
		this.setMostrarid_producto_relacionIngrediente(esInicial);
		this.setMostrarcantidadIngrediente(esInicial);
		this.setMostrarprecioIngrediente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(IngredienteConstantesFunciones.ID)) {
				this.setMostraridIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.IDBODEGARELACION)) {
				this.setMostrarid_bodega_relacionIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.IDPRODUCTORELACION)) {
				this.setMostrarid_producto_relacionIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.PRECIO)) {
				this.setMostrarprecioIngrediente(esAsigna);
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
		
		
		this.setActivaridIngrediente(esInicial);
		this.setActivarid_empresaIngrediente(esInicial);
		this.setActivarid_sucursalIngrediente(esInicial);
		this.setActivarid_bodegaIngrediente(esInicial);
		this.setActivarid_bodega_relacionIngrediente(esInicial);
		this.setActivarid_productoIngrediente(esInicial);
		this.setActivarid_producto_relacionIngrediente(esInicial);
		this.setActivarcantidadIngrediente(esInicial);
		this.setActivarprecioIngrediente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(IngredienteConstantesFunciones.ID)) {
				this.setActivaridIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.IDBODEGARELACION)) {
				this.setActivarid_bodega_relacionIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.IDPRODUCTORELACION)) {
				this.setActivarid_producto_relacionIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.PRECIO)) {
				this.setActivarprecioIngrediente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,IngredienteBeanSwingJInternalFrame ingredienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridIngrediente(esInicial);
		this.setResaltarid_empresaIngrediente(esInicial);
		this.setResaltarid_sucursalIngrediente(esInicial);
		this.setResaltarid_bodegaIngrediente(esInicial);
		this.setResaltarid_bodega_relacionIngrediente(esInicial);
		this.setResaltarid_productoIngrediente(esInicial);
		this.setResaltarid_producto_relacionIngrediente(esInicial);
		this.setResaltarcantidadIngrediente(esInicial);
		this.setResaltarprecioIngrediente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(IngredienteConstantesFunciones.ID)) {
				this.setResaltaridIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.IDBODEGARELACION)) {
				this.setResaltarid_bodega_relacionIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.IDPRODUCTORELACION)) {
				this.setResaltarid_producto_relacionIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadIngrediente(esAsigna);
				continue;
			}

			if(campo.clase.equals(IngredienteConstantesFunciones.PRECIO)) {
				this.setResaltarprecioIngrediente(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,IngredienteBeanSwingJInternalFrame ingredienteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaIngrediente=true;

	public Boolean getMostrarFK_IdBodegaIngrediente() {
		return this.mostrarFK_IdBodegaIngrediente;
	}

	public void setMostrarFK_IdBodegaIngrediente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaIngrediente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBodegaRelacionIngrediente=true;

	public Boolean getMostrarFK_IdBodegaRelacionIngrediente() {
		return this.mostrarFK_IdBodegaRelacionIngrediente;
	}

	public void setMostrarFK_IdBodegaRelacionIngrediente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaRelacionIngrediente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaIngrediente=true;

	public Boolean getMostrarFK_IdEmpresaIngrediente() {
		return this.mostrarFK_IdEmpresaIngrediente;
	}

	public void setMostrarFK_IdEmpresaIngrediente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaIngrediente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoIngrediente=true;

	public Boolean getMostrarFK_IdProductoIngrediente() {
		return this.mostrarFK_IdProductoIngrediente;
	}

	public void setMostrarFK_IdProductoIngrediente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoIngrediente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoRelacionIngrediente=true;

	public Boolean getMostrarFK_IdProductoRelacionIngrediente() {
		return this.mostrarFK_IdProductoRelacionIngrediente;
	}

	public void setMostrarFK_IdProductoRelacionIngrediente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoRelacionIngrediente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalIngrediente=true;

	public Boolean getMostrarFK_IdSucursalIngrediente() {
		return this.mostrarFK_IdSucursalIngrediente;
	}

	public void setMostrarFK_IdSucursalIngrediente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalIngrediente= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaIngrediente=true;

	public Boolean getActivarFK_IdBodegaIngrediente() {
		return this.activarFK_IdBodegaIngrediente;
	}

	public void setActivarFK_IdBodegaIngrediente(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaIngrediente= habilitarResaltar;
	}

	public Boolean activarFK_IdBodegaRelacionIngrediente=true;

	public Boolean getActivarFK_IdBodegaRelacionIngrediente() {
		return this.activarFK_IdBodegaRelacionIngrediente;
	}

	public void setActivarFK_IdBodegaRelacionIngrediente(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaRelacionIngrediente= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaIngrediente=true;

	public Boolean getActivarFK_IdEmpresaIngrediente() {
		return this.activarFK_IdEmpresaIngrediente;
	}

	public void setActivarFK_IdEmpresaIngrediente(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaIngrediente= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoIngrediente=true;

	public Boolean getActivarFK_IdProductoIngrediente() {
		return this.activarFK_IdProductoIngrediente;
	}

	public void setActivarFK_IdProductoIngrediente(Boolean habilitarResaltar) {
		this.activarFK_IdProductoIngrediente= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoRelacionIngrediente=true;

	public Boolean getActivarFK_IdProductoRelacionIngrediente() {
		return this.activarFK_IdProductoRelacionIngrediente;
	}

	public void setActivarFK_IdProductoRelacionIngrediente(Boolean habilitarResaltar) {
		this.activarFK_IdProductoRelacionIngrediente= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalIngrediente=true;

	public Boolean getActivarFK_IdSucursalIngrediente() {
		return this.activarFK_IdSucursalIngrediente;
	}

	public void setActivarFK_IdSucursalIngrediente(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalIngrediente= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaIngrediente=null;

	public Border getResaltarFK_IdBodegaIngrediente() {
		return this.resaltarFK_IdBodegaIngrediente;
	}

	public void setResaltarFK_IdBodegaIngrediente(Border borderResaltar) {
		this.resaltarFK_IdBodegaIngrediente= borderResaltar;
	}

	public void setResaltarFK_IdBodegaIngrediente(ParametroGeneralUsuario parametroGeneralUsuario/*IngredienteBeanSwingJInternalFrame ingredienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaIngrediente= borderResaltar;
	}

	public Border resaltarFK_IdBodegaRelacionIngrediente=null;

	public Border getResaltarFK_IdBodegaRelacionIngrediente() {
		return this.resaltarFK_IdBodegaRelacionIngrediente;
	}

	public void setResaltarFK_IdBodegaRelacionIngrediente(Border borderResaltar) {
		this.resaltarFK_IdBodegaRelacionIngrediente= borderResaltar;
	}

	public void setResaltarFK_IdBodegaRelacionIngrediente(ParametroGeneralUsuario parametroGeneralUsuario/*IngredienteBeanSwingJInternalFrame ingredienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaRelacionIngrediente= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaIngrediente=null;

	public Border getResaltarFK_IdEmpresaIngrediente() {
		return this.resaltarFK_IdEmpresaIngrediente;
	}

	public void setResaltarFK_IdEmpresaIngrediente(Border borderResaltar) {
		this.resaltarFK_IdEmpresaIngrediente= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaIngrediente(ParametroGeneralUsuario parametroGeneralUsuario/*IngredienteBeanSwingJInternalFrame ingredienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaIngrediente= borderResaltar;
	}

	public Border resaltarFK_IdProductoIngrediente=null;

	public Border getResaltarFK_IdProductoIngrediente() {
		return this.resaltarFK_IdProductoIngrediente;
	}

	public void setResaltarFK_IdProductoIngrediente(Border borderResaltar) {
		this.resaltarFK_IdProductoIngrediente= borderResaltar;
	}

	public void setResaltarFK_IdProductoIngrediente(ParametroGeneralUsuario parametroGeneralUsuario/*IngredienteBeanSwingJInternalFrame ingredienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoIngrediente= borderResaltar;
	}

	public Border resaltarFK_IdProductoRelacionIngrediente=null;

	public Border getResaltarFK_IdProductoRelacionIngrediente() {
		return this.resaltarFK_IdProductoRelacionIngrediente;
	}

	public void setResaltarFK_IdProductoRelacionIngrediente(Border borderResaltar) {
		this.resaltarFK_IdProductoRelacionIngrediente= borderResaltar;
	}

	public void setResaltarFK_IdProductoRelacionIngrediente(ParametroGeneralUsuario parametroGeneralUsuario/*IngredienteBeanSwingJInternalFrame ingredienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoRelacionIngrediente= borderResaltar;
	}

	public Border resaltarFK_IdSucursalIngrediente=null;

	public Border getResaltarFK_IdSucursalIngrediente() {
		return this.resaltarFK_IdSucursalIngrediente;
	}

	public void setResaltarFK_IdSucursalIngrediente(Border borderResaltar) {
		this.resaltarFK_IdSucursalIngrediente= borderResaltar;
	}

	public void setResaltarFK_IdSucursalIngrediente(ParametroGeneralUsuario parametroGeneralUsuario/*IngredienteBeanSwingJInternalFrame ingredienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalIngrediente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}