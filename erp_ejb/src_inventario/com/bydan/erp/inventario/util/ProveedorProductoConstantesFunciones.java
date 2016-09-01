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


import com.bydan.erp.inventario.util.ProveedorProductoConstantesFunciones;
import com.bydan.erp.inventario.util.ProveedorProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ProveedorProductoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProveedorProductoConstantesFunciones extends ProveedorProductoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProveedorProducto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProveedorProducto"+ProveedorProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProveedorProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProveedorProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProveedorProductoConstantesFunciones.SCHEMA+"_"+ProveedorProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProveedorProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProveedorProductoConstantesFunciones.SCHEMA+"_"+ProveedorProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProveedorProductoConstantesFunciones.SCHEMA+"_"+ProveedorProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProveedorProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProveedorProductoConstantesFunciones.SCHEMA+"_"+ProveedorProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProveedorProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProveedorProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProveedorProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProveedorProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProveedorProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProveedorProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProveedorProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProveedorProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProveedorProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProveedorProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Producto Proveedors";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Producto Proveedor";
	public static final String SCLASSWEBTITULO_LOWER="Proveedor Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProveedorProducto";
	public static final String OBJECTNAME="proveedorproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="proveedor_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select proveedorproducto from "+ProveedorProductoConstantesFunciones.SPERSISTENCENAME+" proveedorproducto";
	public static String QUERYSELECTNATIVE="select "+ProveedorProductoConstantesFunciones.SCHEMA+"."+ProveedorProductoConstantesFunciones.TABLENAME+".id,"+ProveedorProductoConstantesFunciones.SCHEMA+"."+ProveedorProductoConstantesFunciones.TABLENAME+".version_row,"+ProveedorProductoConstantesFunciones.SCHEMA+"."+ProveedorProductoConstantesFunciones.TABLENAME+".id_empresa,"+ProveedorProductoConstantesFunciones.SCHEMA+"."+ProveedorProductoConstantesFunciones.TABLENAME+".id_sucursal,"+ProveedorProductoConstantesFunciones.SCHEMA+"."+ProveedorProductoConstantesFunciones.TABLENAME+".id_bodega,"+ProveedorProductoConstantesFunciones.SCHEMA+"."+ProveedorProductoConstantesFunciones.TABLENAME+".id_producto,"+ProveedorProductoConstantesFunciones.SCHEMA+"."+ProveedorProductoConstantesFunciones.TABLENAME+".id_cliente,"+ProveedorProductoConstantesFunciones.SCHEMA+"."+ProveedorProductoConstantesFunciones.TABLENAME+".ultimo_precio,"+ProveedorProductoConstantesFunciones.SCHEMA+"."+ProveedorProductoConstantesFunciones.TABLENAME+".precio_pactado,"+ProveedorProductoConstantesFunciones.SCHEMA+"."+ProveedorProductoConstantesFunciones.TABLENAME+".dias_entrega,"+ProveedorProductoConstantesFunciones.SCHEMA+"."+ProveedorProductoConstantesFunciones.TABLENAME+".descripcion from "+ProveedorProductoConstantesFunciones.SCHEMA+"."+ProveedorProductoConstantesFunciones.TABLENAME;//+" as "+ProveedorProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProveedorProductoConstantesFuncionesAdditional proveedorproductoConstantesFuncionesAdditional=null;
	
	public ProveedorProductoConstantesFuncionesAdditional getProveedorProductoConstantesFuncionesAdditional() {
		return this.proveedorproductoConstantesFuncionesAdditional;
	}
	
	public void setProveedorProductoConstantesFuncionesAdditional(ProveedorProductoConstantesFuncionesAdditional proveedorproductoConstantesFuncionesAdditional) {
		try {
			this.proveedorproductoConstantesFuncionesAdditional=proveedorproductoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDCLIENTE= "id_cliente";
    public static final String ULTIMOPRECIO= "ultimo_precio";
    public static final String PRECIOPACTADO= "precio_pactado";
    public static final String DIASENTREGA= "dias_entrega";
    public static final String DESCRIPCION= "descripcion";
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
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_ULTIMOPRECIO= "Ultimo Precio";
		public static final String LABEL_ULTIMOPRECIO_LOWER= "Ultimo Precio";
    	public static final String LABEL_PRECIOPACTADO= "Precio Pactado";
		public static final String LABEL_PRECIOPACTADO_LOWER= "Precio Pactado";
    	public static final String LABEL_DIASENTREGA= "Dias Entrega";
		public static final String LABEL_DIASENTREGA_LOWER= "Dias Entrega";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProveedorProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProveedorProductoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProveedorProductoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProveedorProductoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProveedorProductoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProveedorProductoConstantesFunciones.IDBODEGA)) {sLabelColumna=ProveedorProductoConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ProveedorProductoConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProveedorProductoConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProveedorProductoConstantesFunciones.IDCLIENTE)) {sLabelColumna=ProveedorProductoConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ProveedorProductoConstantesFunciones.ULTIMOPRECIO)) {sLabelColumna=ProveedorProductoConstantesFunciones.LABEL_ULTIMOPRECIO;}
		if(sNombreColumna.equals(ProveedorProductoConstantesFunciones.PRECIOPACTADO)) {sLabelColumna=ProveedorProductoConstantesFunciones.LABEL_PRECIOPACTADO;}
		if(sNombreColumna.equals(ProveedorProductoConstantesFunciones.DIASENTREGA)) {sLabelColumna=ProveedorProductoConstantesFunciones.LABEL_DIASENTREGA;}
		if(sNombreColumna.equals(ProveedorProductoConstantesFunciones.DESCRIPCION)) {sLabelColumna=ProveedorProductoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProveedorProductoDescripcion(ProveedorProducto proveedorproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(proveedorproducto !=null/* && proveedorproducto.getId()!=0*/) {
			if(proveedorproducto.getId()!=null) {
				sDescripcion=proveedorproducto.getId().toString();
			}//proveedorproductoproveedorproducto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProveedorProductoDescripcionDetallado(ProveedorProducto proveedorproducto) {
		String sDescripcion="";
			
		sDescripcion+=ProveedorProductoConstantesFunciones.ID+"=";
		sDescripcion+=proveedorproducto.getId().toString()+",";
		sDescripcion+=ProveedorProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=proveedorproducto.getVersionRow().toString()+",";
		sDescripcion+=ProveedorProductoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=proveedorproducto.getid_empresa().toString()+",";
		sDescripcion+=ProveedorProductoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=proveedorproducto.getid_sucursal().toString()+",";
		sDescripcion+=ProveedorProductoConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=proveedorproducto.getid_bodega().toString()+",";
		sDescripcion+=ProveedorProductoConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=proveedorproducto.getid_producto().toString()+",";
		sDescripcion+=ProveedorProductoConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=proveedorproducto.getid_cliente().toString()+",";
		sDescripcion+=ProveedorProductoConstantesFunciones.ULTIMOPRECIO+"=";
		sDescripcion+=proveedorproducto.getultimo_precio().toString()+",";
		sDescripcion+=ProveedorProductoConstantesFunciones.PRECIOPACTADO+"=";
		sDescripcion+=proveedorproducto.getprecio_pactado().toString()+",";
		sDescripcion+=ProveedorProductoConstantesFunciones.DIASENTREGA+"=";
		sDescripcion+=proveedorproducto.getdias_entrega().toString()+",";
		sDescripcion+=ProveedorProductoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=proveedorproducto.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setProveedorProductoDescripcion(ProveedorProducto proveedorproducto,String sValor) throws Exception {			
		if(proveedorproducto !=null) {
			//proveedorproductoproveedorproducto.getId().toString();
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

	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
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
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
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

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

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

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProveedorProducto(ProveedorProducto proveedorproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		proveedorproducto.setdescripcion(proveedorproducto.getdescripcion().trim());
	}
	
	public static void quitarEspaciosProveedorProductos(List<ProveedorProducto> proveedorproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProveedorProducto proveedorproducto: proveedorproductos) {
			proveedorproducto.setdescripcion(proveedorproducto.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProveedorProducto(ProveedorProducto proveedorproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && proveedorproducto.getConCambioAuxiliar()) {
			proveedorproducto.setIsDeleted(proveedorproducto.getIsDeletedAuxiliar());	
			proveedorproducto.setIsNew(proveedorproducto.getIsNewAuxiliar());	
			proveedorproducto.setIsChanged(proveedorproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			proveedorproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			proveedorproducto.setIsDeletedAuxiliar(false);	
			proveedorproducto.setIsNewAuxiliar(false);	
			proveedorproducto.setIsChangedAuxiliar(false);
			
			proveedorproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProveedorProductos(List<ProveedorProducto> proveedorproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProveedorProducto proveedorproducto : proveedorproductos) {
			if(conAsignarBase && proveedorproducto.getConCambioAuxiliar()) {
				proveedorproducto.setIsDeleted(proveedorproducto.getIsDeletedAuxiliar());	
				proveedorproducto.setIsNew(proveedorproducto.getIsNewAuxiliar());	
				proveedorproducto.setIsChanged(proveedorproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				proveedorproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				proveedorproducto.setIsDeletedAuxiliar(false);	
				proveedorproducto.setIsNewAuxiliar(false);	
				proveedorproducto.setIsChangedAuxiliar(false);
				
				proveedorproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProveedorProducto(ProveedorProducto proveedorproducto,Boolean conEnteros) throws Exception  {
		proveedorproducto.setultimo_precio(0.0);
		proveedorproducto.setprecio_pactado(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			proveedorproducto.setdias_entrega(0);
		}
	}		
	
	public static void InicializarValoresProveedorProductos(List<ProveedorProducto> proveedorproductos,Boolean conEnteros) throws Exception  {
		
		for(ProveedorProducto proveedorproducto: proveedorproductos) {
			proveedorproducto.setultimo_precio(0.0);
			proveedorproducto.setprecio_pactado(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				proveedorproducto.setdias_entrega(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProveedorProducto(List<ProveedorProducto> proveedorproductos,ProveedorProducto proveedorproductoAux) throws Exception  {
		ProveedorProductoConstantesFunciones.InicializarValoresProveedorProducto(proveedorproductoAux,true);
		
		for(ProveedorProducto proveedorproducto: proveedorproductos) {
			if(proveedorproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			proveedorproductoAux.setultimo_precio(proveedorproductoAux.getultimo_precio()+proveedorproducto.getultimo_precio());			
			proveedorproductoAux.setprecio_pactado(proveedorproductoAux.getprecio_pactado()+proveedorproducto.getprecio_pactado());			
			proveedorproductoAux.setdias_entrega(proveedorproductoAux.getdias_entrega()+proveedorproducto.getdias_entrega());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProveedorProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProveedorProductoConstantesFunciones.getArrayColumnasGlobalesProveedorProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProveedorProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProveedorProductoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProveedorProductoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProveedorProductoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProveedorProductoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProveedorProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProveedorProducto> proveedorproductos,ProveedorProducto proveedorproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProveedorProducto proveedorproductoAux: proveedorproductos) {
			if(proveedorproductoAux!=null && proveedorproducto!=null) {
				if((proveedorproductoAux.getId()==null && proveedorproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(proveedorproductoAux.getId()!=null && proveedorproducto.getId()!=null){
					if(proveedorproductoAux.getId().equals(proveedorproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProveedorProducto(List<ProveedorProducto> proveedorproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double ultimo_precioTotal=0.0;
		Double precio_pactadoTotal=0.0;
	
		for(ProveedorProducto proveedorproducto: proveedorproductos) {			
			if(proveedorproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ultimo_precioTotal+=proveedorproducto.getultimo_precio();
			precio_pactadoTotal+=proveedorproducto.getprecio_pactado();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProveedorProductoConstantesFunciones.ULTIMOPRECIO);
		datoGeneral.setsDescripcion(ProveedorProductoConstantesFunciones.LABEL_ULTIMOPRECIO);
		datoGeneral.setdValorDouble(ultimo_precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProveedorProductoConstantesFunciones.PRECIOPACTADO);
		datoGeneral.setsDescripcion(ProveedorProductoConstantesFunciones.LABEL_PRECIOPACTADO);
		datoGeneral.setdValorDouble(precio_pactadoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProveedorProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProveedorProductoConstantesFunciones.LABEL_ID, ProveedorProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProveedorProductoConstantesFunciones.LABEL_VERSIONROW, ProveedorProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProveedorProductoConstantesFunciones.LABEL_IDEMPRESA, ProveedorProductoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProveedorProductoConstantesFunciones.LABEL_IDSUCURSAL, ProveedorProductoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProveedorProductoConstantesFunciones.LABEL_IDBODEGA, ProveedorProductoConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProveedorProductoConstantesFunciones.LABEL_IDPRODUCTO, ProveedorProductoConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProveedorProductoConstantesFunciones.LABEL_IDCLIENTE, ProveedorProductoConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProveedorProductoConstantesFunciones.LABEL_ULTIMOPRECIO, ProveedorProductoConstantesFunciones.ULTIMOPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProveedorProductoConstantesFunciones.LABEL_PRECIOPACTADO, ProveedorProductoConstantesFunciones.PRECIOPACTADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProveedorProductoConstantesFunciones.LABEL_DIASENTREGA, ProveedorProductoConstantesFunciones.DIASENTREGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProveedorProductoConstantesFunciones.LABEL_DESCRIPCION, ProveedorProductoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProveedorProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProveedorProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProveedorProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProveedorProductoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProveedorProductoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProveedorProductoConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProveedorProductoConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProveedorProductoConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProveedorProductoConstantesFunciones.ULTIMOPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProveedorProductoConstantesFunciones.PRECIOPACTADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProveedorProductoConstantesFunciones.DIASENTREGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProveedorProductoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProveedorProducto() throws Exception  {
		return ProveedorProductoConstantesFunciones.getTiposSeleccionarProveedorProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProveedorProducto(Boolean conFk) throws Exception  {
		return ProveedorProductoConstantesFunciones.getTiposSeleccionarProveedorProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProveedorProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProveedorProductoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProveedorProductoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProveedorProductoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProveedorProductoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProveedorProductoConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ProveedorProductoConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProveedorProductoConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProveedorProductoConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProveedorProductoConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ProveedorProductoConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProveedorProductoConstantesFunciones.LABEL_ULTIMOPRECIO);
			reporte.setsDescripcion(ProveedorProductoConstantesFunciones.LABEL_ULTIMOPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProveedorProductoConstantesFunciones.LABEL_PRECIOPACTADO);
			reporte.setsDescripcion(ProveedorProductoConstantesFunciones.LABEL_PRECIOPACTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProveedorProductoConstantesFunciones.LABEL_DIASENTREGA);
			reporte.setsDescripcion(ProveedorProductoConstantesFunciones.LABEL_DIASENTREGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProveedorProductoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ProveedorProductoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProveedorProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProveedorProducto(ProveedorProducto proveedorproductoAux) throws Exception {
		
			proveedorproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(proveedorproductoAux.getEmpresa()));
			proveedorproductoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(proveedorproductoAux.getSucursal()));
			proveedorproductoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(proveedorproductoAux.getBodega()));
			proveedorproductoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(proveedorproductoAux.getProducto()));
			proveedorproductoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(proveedorproductoAux.getCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProveedorProducto(List<ProveedorProducto> proveedorproductosTemp) throws Exception {
		for(ProveedorProducto proveedorproductoAux:proveedorproductosTemp) {
			
			proveedorproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(proveedorproductoAux.getEmpresa()));
			proveedorproductoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(proveedorproductoAux.getSucursal()));
			proveedorproductoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(proveedorproductoAux.getBodega()));
			proveedorproductoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(proveedorproductoAux.getProducto()));
			proveedorproductoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(proveedorproductoAux.getCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProveedorProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Cliente.class));
				
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
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProveedorProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProveedorProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProveedorProductoConstantesFunciones.getClassesRelationshipsOfProveedorProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProveedorProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProveedorProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProveedorProductoConstantesFunciones.getClassesRelationshipsFromStringsOfProveedorProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProveedorProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProveedorProducto proveedorproducto,List<ProveedorProducto> proveedorproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProveedorProducto proveedorproductoEncontrado=null;
			
			for(ProveedorProducto proveedorproductoLocal:proveedorproductos) {
				if(proveedorproductoLocal.getId().equals(proveedorproducto.getId())) {
					proveedorproductoEncontrado=proveedorproductoLocal;
					
					proveedorproductoLocal.setIsChanged(proveedorproducto.getIsChanged());
					proveedorproductoLocal.setIsNew(proveedorproducto.getIsNew());
					proveedorproductoLocal.setIsDeleted(proveedorproducto.getIsDeleted());
					
					proveedorproductoLocal.setGeneralEntityOriginal(proveedorproducto.getGeneralEntityOriginal());
					
					proveedorproductoLocal.setId(proveedorproducto.getId());	
					proveedorproductoLocal.setVersionRow(proveedorproducto.getVersionRow());	
					proveedorproductoLocal.setid_empresa(proveedorproducto.getid_empresa());	
					proveedorproductoLocal.setid_sucursal(proveedorproducto.getid_sucursal());	
					proveedorproductoLocal.setid_bodega(proveedorproducto.getid_bodega());	
					proveedorproductoLocal.setid_producto(proveedorproducto.getid_producto());	
					proveedorproductoLocal.setid_cliente(proveedorproducto.getid_cliente());	
					proveedorproductoLocal.setultimo_precio(proveedorproducto.getultimo_precio());	
					proveedorproductoLocal.setprecio_pactado(proveedorproducto.getprecio_pactado());	
					proveedorproductoLocal.setdias_entrega(proveedorproducto.getdias_entrega());	
					proveedorproductoLocal.setdescripcion(proveedorproducto.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!proveedorproducto.getIsDeleted()) {
				if(!existe) {
					proveedorproductos.add(proveedorproducto);
				}
			} else {
				if(proveedorproductoEncontrado!=null && permiteQuitar)  {
					proveedorproductos.remove(proveedorproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProveedorProducto proveedorproducto,List<ProveedorProducto> proveedorproductos) throws Exception {
		try	{			
			for(ProveedorProducto proveedorproductoLocal:proveedorproductos) {
				if(proveedorproductoLocal.getId().equals(proveedorproducto.getId())) {
					proveedorproductoLocal.setIsSelected(proveedorproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProveedorProducto(List<ProveedorProducto> proveedorproductosAux) throws Exception {
		//this.proveedorproductosAux=proveedorproductosAux;
		
		for(ProveedorProducto proveedorproductoAux:proveedorproductosAux) {
			if(proveedorproductoAux.getIsChanged()) {
				proveedorproductoAux.setIsChanged(false);
			}		
			
			if(proveedorproductoAux.getIsNew()) {
				proveedorproductoAux.setIsNew(false);
			}	
			
			if(proveedorproductoAux.getIsDeleted()) {
				proveedorproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProveedorProducto(ProveedorProducto proveedorproductoAux) throws Exception {
		//this.proveedorproductoAux=proveedorproductoAux;
		
			if(proveedorproductoAux.getIsChanged()) {
				proveedorproductoAux.setIsChanged(false);
			}		
			
			if(proveedorproductoAux.getIsNew()) {
				proveedorproductoAux.setIsNew(false);
			}	
			
			if(proveedorproductoAux.getIsDeleted()) {
				proveedorproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProveedorProducto proveedorproductoAsignar,ProveedorProducto proveedorproducto) throws Exception {
		proveedorproductoAsignar.setId(proveedorproducto.getId());	
		proveedorproductoAsignar.setVersionRow(proveedorproducto.getVersionRow());	
		proveedorproductoAsignar.setid_empresa(proveedorproducto.getid_empresa());
		proveedorproductoAsignar.setempresa_descripcion(proveedorproducto.getempresa_descripcion());	
		proveedorproductoAsignar.setid_sucursal(proveedorproducto.getid_sucursal());
		proveedorproductoAsignar.setsucursal_descripcion(proveedorproducto.getsucursal_descripcion());	
		proveedorproductoAsignar.setid_bodega(proveedorproducto.getid_bodega());
		proveedorproductoAsignar.setbodega_descripcion(proveedorproducto.getbodega_descripcion());	
		proveedorproductoAsignar.setid_producto(proveedorproducto.getid_producto());
		proveedorproductoAsignar.setproducto_descripcion(proveedorproducto.getproducto_descripcion());	
		proveedorproductoAsignar.setid_cliente(proveedorproducto.getid_cliente());
		proveedorproductoAsignar.setcliente_descripcion(proveedorproducto.getcliente_descripcion());	
		proveedorproductoAsignar.setultimo_precio(proveedorproducto.getultimo_precio());	
		proveedorproductoAsignar.setprecio_pactado(proveedorproducto.getprecio_pactado());	
		proveedorproductoAsignar.setdias_entrega(proveedorproducto.getdias_entrega());	
		proveedorproductoAsignar.setdescripcion(proveedorproducto.getdescripcion());	
	}
	
	public static void inicializarProveedorProducto(ProveedorProducto proveedorproducto) throws Exception {
		try {
				proveedorproducto.setId(0L);	
					
				proveedorproducto.setid_empresa(-1L);	
				proveedorproducto.setid_sucursal(-1L);	
				proveedorproducto.setid_bodega(-1L);	
				proveedorproducto.setid_producto(-1L);	
				proveedorproducto.setid_cliente(-1L);	
				proveedorproducto.setultimo_precio(0.0);	
				proveedorproducto.setprecio_pactado(0.0);	
				proveedorproducto.setdias_entrega(0);	
				proveedorproducto.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProveedorProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProveedorProductoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProveedorProductoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProveedorProductoConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProveedorProductoConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProveedorProductoConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProveedorProductoConstantesFunciones.LABEL_ULTIMOPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProveedorProductoConstantesFunciones.LABEL_PRECIOPACTADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProveedorProductoConstantesFunciones.LABEL_DIASENTREGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProveedorProductoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProveedorProducto(String sTipo,Row row,Workbook workbook,ProveedorProducto proveedorproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(proveedorproducto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proveedorproducto.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proveedorproducto.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proveedorproducto.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proveedorproducto.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proveedorproducto.getultimo_precio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proveedorproducto.getprecio_pactado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proveedorproducto.getdias_entrega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(proveedorproducto.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProveedorProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProveedorProducto() {
		return this.sFinalQueryProveedorProducto;
	}
	
	public void setsFinalQueryProveedorProducto(String sFinalQueryProveedorProducto) {
		this.sFinalQueryProveedorProducto= sFinalQueryProveedorProducto;
	}
	
	public Border resaltarSeleccionarProveedorProducto=null;
	
	public Border setResaltarSeleccionarProveedorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProveedorProductoBeanSwingJInternalFrame proveedorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//proveedorproductoBeanSwingJInternalFrame.jTtoolBarProveedorProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProveedorProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProveedorProducto() {
		return this.resaltarSeleccionarProveedorProducto;
	}
	
	public void setResaltarSeleccionarProveedorProducto(Border borderResaltarSeleccionarProveedorProducto) {
		this.resaltarSeleccionarProveedorProducto= borderResaltarSeleccionarProveedorProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProveedorProducto=null;
	public Boolean mostraridProveedorProducto=true;
	public Boolean activaridProveedorProducto=true;

	public Border resaltarid_empresaProveedorProducto=null;
	public Boolean mostrarid_empresaProveedorProducto=true;
	public Boolean activarid_empresaProveedorProducto=true;
	public Boolean cargarid_empresaProveedorProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProveedorProducto=false;//ConEventDepend=true

	public Border resaltarid_sucursalProveedorProducto=null;
	public Boolean mostrarid_sucursalProveedorProducto=true;
	public Boolean activarid_sucursalProveedorProducto=true;
	public Boolean cargarid_sucursalProveedorProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProveedorProducto=false;//ConEventDepend=true

	public Border resaltarid_bodegaProveedorProducto=null;
	public Boolean mostrarid_bodegaProveedorProducto=true;
	public Boolean activarid_bodegaProveedorProducto=true;
	public Boolean cargarid_bodegaProveedorProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaProveedorProducto=false;//ConEventDepend=true

	public Border resaltarid_productoProveedorProducto=null;
	public Boolean mostrarid_productoProveedorProducto=true;
	public Boolean activarid_productoProveedorProducto=true;
	public Boolean cargarid_productoProveedorProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProveedorProducto=false;//ConEventDepend=true

	public Border resaltarid_clienteProveedorProducto=null;
	public Boolean mostrarid_clienteProveedorProducto=true;
	public Boolean activarid_clienteProveedorProducto=true;
	public Boolean cargarid_clienteProveedorProducto=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteProveedorProducto=false;//ConEventDepend=true

	public Border resaltarultimo_precioProveedorProducto=null;
	public Boolean mostrarultimo_precioProveedorProducto=true;
	public Boolean activarultimo_precioProveedorProducto=true;

	public Border resaltarprecio_pactadoProveedorProducto=null;
	public Boolean mostrarprecio_pactadoProveedorProducto=true;
	public Boolean activarprecio_pactadoProveedorProducto=true;

	public Border resaltardias_entregaProveedorProducto=null;
	public Boolean mostrardias_entregaProveedorProducto=true;
	public Boolean activardias_entregaProveedorProducto=true;

	public Border resaltardescripcionProveedorProducto=null;
	public Boolean mostrardescripcionProveedorProducto=true;
	public Boolean activardescripcionProveedorProducto=true;

	
	

	public Border setResaltaridProveedorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProveedorProductoBeanSwingJInternalFrame proveedorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proveedorproductoBeanSwingJInternalFrame.jTtoolBarProveedorProducto.setBorder(borderResaltar);
		
		this.resaltaridProveedorProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProveedorProducto() {
		return this.resaltaridProveedorProducto;
	}

	public void setResaltaridProveedorProducto(Border borderResaltar) {
		this.resaltaridProveedorProducto= borderResaltar;
	}

	public Boolean getMostraridProveedorProducto() {
		return this.mostraridProveedorProducto;
	}

	public void setMostraridProveedorProducto(Boolean mostraridProveedorProducto) {
		this.mostraridProveedorProducto= mostraridProveedorProducto;
	}

	public Boolean getActivaridProveedorProducto() {
		return this.activaridProveedorProducto;
	}

	public void setActivaridProveedorProducto(Boolean activaridProveedorProducto) {
		this.activaridProveedorProducto= activaridProveedorProducto;
	}

	public Border setResaltarid_empresaProveedorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProveedorProductoBeanSwingJInternalFrame proveedorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proveedorproductoBeanSwingJInternalFrame.jTtoolBarProveedorProducto.setBorder(borderResaltar);
		
		this.resaltarid_empresaProveedorProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProveedorProducto() {
		return this.resaltarid_empresaProveedorProducto;
	}

	public void setResaltarid_empresaProveedorProducto(Border borderResaltar) {
		this.resaltarid_empresaProveedorProducto= borderResaltar;
	}

	public Boolean getMostrarid_empresaProveedorProducto() {
		return this.mostrarid_empresaProveedorProducto;
	}

	public void setMostrarid_empresaProveedorProducto(Boolean mostrarid_empresaProveedorProducto) {
		this.mostrarid_empresaProveedorProducto= mostrarid_empresaProveedorProducto;
	}

	public Boolean getActivarid_empresaProveedorProducto() {
		return this.activarid_empresaProveedorProducto;
	}

	public void setActivarid_empresaProveedorProducto(Boolean activarid_empresaProveedorProducto) {
		this.activarid_empresaProveedorProducto= activarid_empresaProveedorProducto;
	}

	public Boolean getCargarid_empresaProveedorProducto() {
		return this.cargarid_empresaProveedorProducto;
	}

	public void setCargarid_empresaProveedorProducto(Boolean cargarid_empresaProveedorProducto) {
		this.cargarid_empresaProveedorProducto= cargarid_empresaProveedorProducto;
	}

	public Border setResaltarid_sucursalProveedorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProveedorProductoBeanSwingJInternalFrame proveedorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proveedorproductoBeanSwingJInternalFrame.jTtoolBarProveedorProducto.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProveedorProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProveedorProducto() {
		return this.resaltarid_sucursalProveedorProducto;
	}

	public void setResaltarid_sucursalProveedorProducto(Border borderResaltar) {
		this.resaltarid_sucursalProveedorProducto= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProveedorProducto() {
		return this.mostrarid_sucursalProveedorProducto;
	}

	public void setMostrarid_sucursalProveedorProducto(Boolean mostrarid_sucursalProveedorProducto) {
		this.mostrarid_sucursalProveedorProducto= mostrarid_sucursalProveedorProducto;
	}

	public Boolean getActivarid_sucursalProveedorProducto() {
		return this.activarid_sucursalProveedorProducto;
	}

	public void setActivarid_sucursalProveedorProducto(Boolean activarid_sucursalProveedorProducto) {
		this.activarid_sucursalProveedorProducto= activarid_sucursalProveedorProducto;
	}

	public Boolean getCargarid_sucursalProveedorProducto() {
		return this.cargarid_sucursalProveedorProducto;
	}

	public void setCargarid_sucursalProveedorProducto(Boolean cargarid_sucursalProveedorProducto) {
		this.cargarid_sucursalProveedorProducto= cargarid_sucursalProveedorProducto;
	}

	public Border setResaltarid_bodegaProveedorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProveedorProductoBeanSwingJInternalFrame proveedorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proveedorproductoBeanSwingJInternalFrame.jTtoolBarProveedorProducto.setBorder(borderResaltar);
		
		this.resaltarid_bodegaProveedorProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaProveedorProducto() {
		return this.resaltarid_bodegaProveedorProducto;
	}

	public void setResaltarid_bodegaProveedorProducto(Border borderResaltar) {
		this.resaltarid_bodegaProveedorProducto= borderResaltar;
	}

	public Boolean getMostrarid_bodegaProveedorProducto() {
		return this.mostrarid_bodegaProveedorProducto;
	}

	public void setMostrarid_bodegaProveedorProducto(Boolean mostrarid_bodegaProveedorProducto) {
		this.mostrarid_bodegaProveedorProducto= mostrarid_bodegaProveedorProducto;
	}

	public Boolean getActivarid_bodegaProveedorProducto() {
		return this.activarid_bodegaProveedorProducto;
	}

	public void setActivarid_bodegaProveedorProducto(Boolean activarid_bodegaProveedorProducto) {
		this.activarid_bodegaProveedorProducto= activarid_bodegaProveedorProducto;
	}

	public Boolean getCargarid_bodegaProveedorProducto() {
		return this.cargarid_bodegaProveedorProducto;
	}

	public void setCargarid_bodegaProveedorProducto(Boolean cargarid_bodegaProveedorProducto) {
		this.cargarid_bodegaProveedorProducto= cargarid_bodegaProveedorProducto;
	}

	public Border setResaltarid_productoProveedorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProveedorProductoBeanSwingJInternalFrame proveedorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proveedorproductoBeanSwingJInternalFrame.jTtoolBarProveedorProducto.setBorder(borderResaltar);
		
		this.resaltarid_productoProveedorProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProveedorProducto() {
		return this.resaltarid_productoProveedorProducto;
	}

	public void setResaltarid_productoProveedorProducto(Border borderResaltar) {
		this.resaltarid_productoProveedorProducto= borderResaltar;
	}

	public Boolean getMostrarid_productoProveedorProducto() {
		return this.mostrarid_productoProveedorProducto;
	}

	public void setMostrarid_productoProveedorProducto(Boolean mostrarid_productoProveedorProducto) {
		this.mostrarid_productoProveedorProducto= mostrarid_productoProveedorProducto;
	}

	public Boolean getActivarid_productoProveedorProducto() {
		return this.activarid_productoProveedorProducto;
	}

	public void setActivarid_productoProveedorProducto(Boolean activarid_productoProveedorProducto) {
		this.activarid_productoProveedorProducto= activarid_productoProveedorProducto;
	}

	public Boolean getCargarid_productoProveedorProducto() {
		return this.cargarid_productoProveedorProducto;
	}

	public void setCargarid_productoProveedorProducto(Boolean cargarid_productoProveedorProducto) {
		this.cargarid_productoProveedorProducto= cargarid_productoProveedorProducto;
	}

	public Border setResaltarid_clienteProveedorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProveedorProductoBeanSwingJInternalFrame proveedorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proveedorproductoBeanSwingJInternalFrame.jTtoolBarProveedorProducto.setBorder(borderResaltar);
		
		this.resaltarid_clienteProveedorProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteProveedorProducto() {
		return this.resaltarid_clienteProveedorProducto;
	}

	public void setResaltarid_clienteProveedorProducto(Border borderResaltar) {
		this.resaltarid_clienteProveedorProducto= borderResaltar;
	}

	public Boolean getMostrarid_clienteProveedorProducto() {
		return this.mostrarid_clienteProveedorProducto;
	}

	public void setMostrarid_clienteProveedorProducto(Boolean mostrarid_clienteProveedorProducto) {
		this.mostrarid_clienteProveedorProducto= mostrarid_clienteProveedorProducto;
	}

	public Boolean getActivarid_clienteProveedorProducto() {
		return this.activarid_clienteProveedorProducto;
	}

	public void setActivarid_clienteProveedorProducto(Boolean activarid_clienteProveedorProducto) {
		this.activarid_clienteProveedorProducto= activarid_clienteProveedorProducto;
	}

	public Boolean getCargarid_clienteProveedorProducto() {
		return this.cargarid_clienteProveedorProducto;
	}

	public void setCargarid_clienteProveedorProducto(Boolean cargarid_clienteProveedorProducto) {
		this.cargarid_clienteProveedorProducto= cargarid_clienteProveedorProducto;
	}

	public Border setResaltarultimo_precioProveedorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProveedorProductoBeanSwingJInternalFrame proveedorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proveedorproductoBeanSwingJInternalFrame.jTtoolBarProveedorProducto.setBorder(borderResaltar);
		
		this.resaltarultimo_precioProveedorProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarultimo_precioProveedorProducto() {
		return this.resaltarultimo_precioProveedorProducto;
	}

	public void setResaltarultimo_precioProveedorProducto(Border borderResaltar) {
		this.resaltarultimo_precioProveedorProducto= borderResaltar;
	}

	public Boolean getMostrarultimo_precioProveedorProducto() {
		return this.mostrarultimo_precioProveedorProducto;
	}

	public void setMostrarultimo_precioProveedorProducto(Boolean mostrarultimo_precioProveedorProducto) {
		this.mostrarultimo_precioProveedorProducto= mostrarultimo_precioProveedorProducto;
	}

	public Boolean getActivarultimo_precioProveedorProducto() {
		return this.activarultimo_precioProveedorProducto;
	}

	public void setActivarultimo_precioProveedorProducto(Boolean activarultimo_precioProveedorProducto) {
		this.activarultimo_precioProveedorProducto= activarultimo_precioProveedorProducto;
	}

	public Border setResaltarprecio_pactadoProveedorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProveedorProductoBeanSwingJInternalFrame proveedorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proveedorproductoBeanSwingJInternalFrame.jTtoolBarProveedorProducto.setBorder(borderResaltar);
		
		this.resaltarprecio_pactadoProveedorProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecio_pactadoProveedorProducto() {
		return this.resaltarprecio_pactadoProveedorProducto;
	}

	public void setResaltarprecio_pactadoProveedorProducto(Border borderResaltar) {
		this.resaltarprecio_pactadoProveedorProducto= borderResaltar;
	}

	public Boolean getMostrarprecio_pactadoProveedorProducto() {
		return this.mostrarprecio_pactadoProveedorProducto;
	}

	public void setMostrarprecio_pactadoProveedorProducto(Boolean mostrarprecio_pactadoProveedorProducto) {
		this.mostrarprecio_pactadoProveedorProducto= mostrarprecio_pactadoProveedorProducto;
	}

	public Boolean getActivarprecio_pactadoProveedorProducto() {
		return this.activarprecio_pactadoProveedorProducto;
	}

	public void setActivarprecio_pactadoProveedorProducto(Boolean activarprecio_pactadoProveedorProducto) {
		this.activarprecio_pactadoProveedorProducto= activarprecio_pactadoProveedorProducto;
	}

	public Border setResaltardias_entregaProveedorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProveedorProductoBeanSwingJInternalFrame proveedorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proveedorproductoBeanSwingJInternalFrame.jTtoolBarProveedorProducto.setBorder(borderResaltar);
		
		this.resaltardias_entregaProveedorProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardias_entregaProveedorProducto() {
		return this.resaltardias_entregaProveedorProducto;
	}

	public void setResaltardias_entregaProveedorProducto(Border borderResaltar) {
		this.resaltardias_entregaProveedorProducto= borderResaltar;
	}

	public Boolean getMostrardias_entregaProveedorProducto() {
		return this.mostrardias_entregaProveedorProducto;
	}

	public void setMostrardias_entregaProveedorProducto(Boolean mostrardias_entregaProveedorProducto) {
		this.mostrardias_entregaProveedorProducto= mostrardias_entregaProveedorProducto;
	}

	public Boolean getActivardias_entregaProveedorProducto() {
		return this.activardias_entregaProveedorProducto;
	}

	public void setActivardias_entregaProveedorProducto(Boolean activardias_entregaProveedorProducto) {
		this.activardias_entregaProveedorProducto= activardias_entregaProveedorProducto;
	}

	public Border setResaltardescripcionProveedorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProveedorProductoBeanSwingJInternalFrame proveedorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//proveedorproductoBeanSwingJInternalFrame.jTtoolBarProveedorProducto.setBorder(borderResaltar);
		
		this.resaltardescripcionProveedorProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionProveedorProducto() {
		return this.resaltardescripcionProveedorProducto;
	}

	public void setResaltardescripcionProveedorProducto(Border borderResaltar) {
		this.resaltardescripcionProveedorProducto= borderResaltar;
	}

	public Boolean getMostrardescripcionProveedorProducto() {
		return this.mostrardescripcionProveedorProducto;
	}

	public void setMostrardescripcionProveedorProducto(Boolean mostrardescripcionProveedorProducto) {
		this.mostrardescripcionProveedorProducto= mostrardescripcionProveedorProducto;
	}

	public Boolean getActivardescripcionProveedorProducto() {
		return this.activardescripcionProveedorProducto;
	}

	public void setActivardescripcionProveedorProducto(Boolean activardescripcionProveedorProducto) {
		this.activardescripcionProveedorProducto= activardescripcionProveedorProducto;
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
		
		
		this.setMostraridProveedorProducto(esInicial);
		this.setMostrarid_empresaProveedorProducto(esInicial);
		this.setMostrarid_sucursalProveedorProducto(esInicial);
		this.setMostrarid_bodegaProveedorProducto(esInicial);
		this.setMostrarid_productoProveedorProducto(esInicial);
		this.setMostrarid_clienteProveedorProducto(esInicial);
		this.setMostrarultimo_precioProveedorProducto(esInicial);
		this.setMostrarprecio_pactadoProveedorProducto(esInicial);
		this.setMostrardias_entregaProveedorProducto(esInicial);
		this.setMostrardescripcionProveedorProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.ID)) {
				this.setMostraridProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.ULTIMOPRECIO)) {
				this.setMostrarultimo_precioProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.PRECIOPACTADO)) {
				this.setMostrarprecio_pactadoProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.DIASENTREGA)) {
				this.setMostrardias_entregaProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionProveedorProducto(esAsigna);
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
		
		
		this.setActivaridProveedorProducto(esInicial);
		this.setActivarid_empresaProveedorProducto(esInicial);
		this.setActivarid_sucursalProveedorProducto(esInicial);
		this.setActivarid_bodegaProveedorProducto(esInicial);
		this.setActivarid_productoProveedorProducto(esInicial);
		this.setActivarid_clienteProveedorProducto(esInicial);
		this.setActivarultimo_precioProveedorProducto(esInicial);
		this.setActivarprecio_pactadoProveedorProducto(esInicial);
		this.setActivardias_entregaProveedorProducto(esInicial);
		this.setActivardescripcionProveedorProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.ID)) {
				this.setActivaridProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.ULTIMOPRECIO)) {
				this.setActivarultimo_precioProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.PRECIOPACTADO)) {
				this.setActivarprecio_pactadoProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.DIASENTREGA)) {
				this.setActivardias_entregaProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionProveedorProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProveedorProductoBeanSwingJInternalFrame proveedorproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProveedorProducto(esInicial);
		this.setResaltarid_empresaProveedorProducto(esInicial);
		this.setResaltarid_sucursalProveedorProducto(esInicial);
		this.setResaltarid_bodegaProveedorProducto(esInicial);
		this.setResaltarid_productoProveedorProducto(esInicial);
		this.setResaltarid_clienteProveedorProducto(esInicial);
		this.setResaltarultimo_precioProveedorProducto(esInicial);
		this.setResaltarprecio_pactadoProveedorProducto(esInicial);
		this.setResaltardias_entregaProveedorProducto(esInicial);
		this.setResaltardescripcionProveedorProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.ID)) {
				this.setResaltaridProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.ULTIMOPRECIO)) {
				this.setResaltarultimo_precioProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.PRECIOPACTADO)) {
				this.setResaltarprecio_pactadoProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.DIASENTREGA)) {
				this.setResaltardias_entregaProveedorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProveedorProductoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionProveedorProducto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProveedorProductoBeanSwingJInternalFrame proveedorproductoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaProveedorProducto=true;

	public Boolean getMostrarFK_IdBodegaProveedorProducto() {
		return this.mostrarFK_IdBodegaProveedorProducto;
	}

	public void setMostrarFK_IdBodegaProveedorProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaProveedorProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteProveedorProducto=true;

	public Boolean getMostrarFK_IdClienteProveedorProducto() {
		return this.mostrarFK_IdClienteProveedorProducto;
	}

	public void setMostrarFK_IdClienteProveedorProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteProveedorProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaProveedorProducto=true;

	public Boolean getMostrarFK_IdEmpresaProveedorProducto() {
		return this.mostrarFK_IdEmpresaProveedorProducto;
	}

	public void setMostrarFK_IdEmpresaProveedorProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaProveedorProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoProveedorProducto=true;

	public Boolean getMostrarFK_IdProductoProveedorProducto() {
		return this.mostrarFK_IdProductoProveedorProducto;
	}

	public void setMostrarFK_IdProductoProveedorProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoProveedorProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalProveedorProducto=true;

	public Boolean getMostrarFK_IdSucursalProveedorProducto() {
		return this.mostrarFK_IdSucursalProveedorProducto;
	}

	public void setMostrarFK_IdSucursalProveedorProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalProveedorProducto= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaProveedorProducto=true;

	public Boolean getActivarFK_IdBodegaProveedorProducto() {
		return this.activarFK_IdBodegaProveedorProducto;
	}

	public void setActivarFK_IdBodegaProveedorProducto(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaProveedorProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteProveedorProducto=true;

	public Boolean getActivarFK_IdClienteProveedorProducto() {
		return this.activarFK_IdClienteProveedorProducto;
	}

	public void setActivarFK_IdClienteProveedorProducto(Boolean habilitarResaltar) {
		this.activarFK_IdClienteProveedorProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaProveedorProducto=true;

	public Boolean getActivarFK_IdEmpresaProveedorProducto() {
		return this.activarFK_IdEmpresaProveedorProducto;
	}

	public void setActivarFK_IdEmpresaProveedorProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaProveedorProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoProveedorProducto=true;

	public Boolean getActivarFK_IdProductoProveedorProducto() {
		return this.activarFK_IdProductoProveedorProducto;
	}

	public void setActivarFK_IdProductoProveedorProducto(Boolean habilitarResaltar) {
		this.activarFK_IdProductoProveedorProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalProveedorProducto=true;

	public Boolean getActivarFK_IdSucursalProveedorProducto() {
		return this.activarFK_IdSucursalProveedorProducto;
	}

	public void setActivarFK_IdSucursalProveedorProducto(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalProveedorProducto= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaProveedorProducto=null;

	public Border getResaltarFK_IdBodegaProveedorProducto() {
		return this.resaltarFK_IdBodegaProveedorProducto;
	}

	public void setResaltarFK_IdBodegaProveedorProducto(Border borderResaltar) {
		this.resaltarFK_IdBodegaProveedorProducto= borderResaltar;
	}

	public void setResaltarFK_IdBodegaProveedorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProveedorProductoBeanSwingJInternalFrame proveedorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaProveedorProducto= borderResaltar;
	}

	public Border resaltarFK_IdClienteProveedorProducto=null;

	public Border getResaltarFK_IdClienteProveedorProducto() {
		return this.resaltarFK_IdClienteProveedorProducto;
	}

	public void setResaltarFK_IdClienteProveedorProducto(Border borderResaltar) {
		this.resaltarFK_IdClienteProveedorProducto= borderResaltar;
	}

	public void setResaltarFK_IdClienteProveedorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProveedorProductoBeanSwingJInternalFrame proveedorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteProveedorProducto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaProveedorProducto=null;

	public Border getResaltarFK_IdEmpresaProveedorProducto() {
		return this.resaltarFK_IdEmpresaProveedorProducto;
	}

	public void setResaltarFK_IdEmpresaProveedorProducto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaProveedorProducto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaProveedorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProveedorProductoBeanSwingJInternalFrame proveedorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaProveedorProducto= borderResaltar;
	}

	public Border resaltarFK_IdProductoProveedorProducto=null;

	public Border getResaltarFK_IdProductoProveedorProducto() {
		return this.resaltarFK_IdProductoProveedorProducto;
	}

	public void setResaltarFK_IdProductoProveedorProducto(Border borderResaltar) {
		this.resaltarFK_IdProductoProveedorProducto= borderResaltar;
	}

	public void setResaltarFK_IdProductoProveedorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProveedorProductoBeanSwingJInternalFrame proveedorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoProveedorProducto= borderResaltar;
	}

	public Border resaltarFK_IdSucursalProveedorProducto=null;

	public Border getResaltarFK_IdSucursalProveedorProducto() {
		return this.resaltarFK_IdSucursalProveedorProducto;
	}

	public void setResaltarFK_IdSucursalProveedorProducto(Border borderResaltar) {
		this.resaltarFK_IdSucursalProveedorProducto= borderResaltar;
	}

	public void setResaltarFK_IdSucursalProveedorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProveedorProductoBeanSwingJInternalFrame proveedorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalProveedorProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}