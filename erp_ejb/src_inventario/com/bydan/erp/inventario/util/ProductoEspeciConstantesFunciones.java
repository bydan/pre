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


import com.bydan.erp.inventario.util.ProductoEspeciConstantesFunciones;
import com.bydan.erp.inventario.util.ProductoEspeciParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ProductoEspeciParameterGeneral;

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
final public class ProductoEspeciConstantesFunciones extends ProductoEspeciConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProductoEspeci";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductoEspeci"+ProductoEspeciConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductoEspeciHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductoEspeciHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductoEspeciConstantesFunciones.SCHEMA+"_"+ProductoEspeciConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductoEspeciHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductoEspeciConstantesFunciones.SCHEMA+"_"+ProductoEspeciConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductoEspeciConstantesFunciones.SCHEMA+"_"+ProductoEspeciConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductoEspeciHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductoEspeciConstantesFunciones.SCHEMA+"_"+ProductoEspeciConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoEspeciConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoEspeciHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoEspeciConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoEspeciConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoEspeciHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoEspeciConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductoEspeciConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductoEspeciConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductoEspeciConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductoEspeciConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Especificacions";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Especificacion";
	public static final String SCLASSWEBTITULO_LOWER="Producto Especi";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductoEspeci";
	public static final String OBJECTNAME="productoespeci";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="producto_especi";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productoespeci from "+ProductoEspeciConstantesFunciones.SPERSISTENCENAME+" productoespeci";
	public static String QUERYSELECTNATIVE="select "+ProductoEspeciConstantesFunciones.SCHEMA+"."+ProductoEspeciConstantesFunciones.TABLENAME+".id,"+ProductoEspeciConstantesFunciones.SCHEMA+"."+ProductoEspeciConstantesFunciones.TABLENAME+".version_row,"+ProductoEspeciConstantesFunciones.SCHEMA+"."+ProductoEspeciConstantesFunciones.TABLENAME+".id_empresa,"+ProductoEspeciConstantesFunciones.SCHEMA+"."+ProductoEspeciConstantesFunciones.TABLENAME+".id_sucursal,"+ProductoEspeciConstantesFunciones.SCHEMA+"."+ProductoEspeciConstantesFunciones.TABLENAME+".id_producto,"+ProductoEspeciConstantesFunciones.SCHEMA+"."+ProductoEspeciConstantesFunciones.TABLENAME+".especificacion from "+ProductoEspeciConstantesFunciones.SCHEMA+"."+ProductoEspeciConstantesFunciones.TABLENAME;//+" as "+ProductoEspeciConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProductoEspeciConstantesFuncionesAdditional productoespeciConstantesFuncionesAdditional=null;
	
	public ProductoEspeciConstantesFuncionesAdditional getProductoEspeciConstantesFuncionesAdditional() {
		return this.productoespeciConstantesFuncionesAdditional;
	}
	
	public void setProductoEspeciConstantesFuncionesAdditional(ProductoEspeciConstantesFuncionesAdditional productoespeciConstantesFuncionesAdditional) {
		try {
			this.productoespeciConstantesFuncionesAdditional=productoespeciConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDPRODUCTO= "id_producto";
    public static final String ESPECIFICACION= "especificacion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_ESPECIFICACION= "Especificacion";
		public static final String LABEL_ESPECIFICACION_LOWER= "Especificacion";
	
		
		
		
		
		
	public static final String SREGEXESPECIFICACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXESPECIFICACION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProductoEspeciLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductoEspeciConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProductoEspeciConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProductoEspeciConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProductoEspeciConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProductoEspeciConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProductoEspeciConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProductoEspeciConstantesFunciones.ESPECIFICACION)) {sLabelColumna=ProductoEspeciConstantesFunciones.LABEL_ESPECIFICACION;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getProductoEspeciDescripcion(ProductoEspeci productoespeci) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productoespeci !=null/* && productoespeci.getId()!=0*/) {
			if(productoespeci.getId()!=null) {
				sDescripcion=productoespeci.getId().toString();
			}//productoespeciproductoespeci.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductoEspeciDescripcionDetallado(ProductoEspeci productoespeci) {
		String sDescripcion="";
			
		sDescripcion+=ProductoEspeciConstantesFunciones.ID+"=";
		sDescripcion+=productoespeci.getId().toString()+",";
		sDescripcion+=ProductoEspeciConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productoespeci.getVersionRow().toString()+",";
		sDescripcion+=ProductoEspeciConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=productoespeci.getid_empresa().toString()+",";
		sDescripcion+=ProductoEspeciConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=productoespeci.getid_sucursal().toString()+",";
		sDescripcion+=ProductoEspeciConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=productoespeci.getid_producto().toString()+",";
		sDescripcion+=ProductoEspeciConstantesFunciones.ESPECIFICACION+"=";
		sDescripcion+=productoespeci.getespecificacion()+",";
			
		return sDescripcion;
	}
	
	public static void setProductoEspeciDescripcion(ProductoEspeci productoespeci,String sValor) throws Exception {			
		if(productoespeci !=null) {
			//productoespeciproductoespeci.getId().toString();
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

	public static String getProductoDescripcion(Producto producto) {
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
	
	
	
	
	
	
	public static void quitarEspaciosProductoEspeci(ProductoEspeci productoespeci,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productoespeci.setespecificacion(productoespeci.getespecificacion().trim());
	}
	
	public static void quitarEspaciosProductoEspecis(List<ProductoEspeci> productoespecis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoEspeci productoespeci: productoespecis) {
			productoespeci.setespecificacion(productoespeci.getespecificacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoEspeci(ProductoEspeci productoespeci,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productoespeci.getConCambioAuxiliar()) {
			productoespeci.setIsDeleted(productoespeci.getIsDeletedAuxiliar());	
			productoespeci.setIsNew(productoespeci.getIsNewAuxiliar());	
			productoespeci.setIsChanged(productoespeci.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productoespeci.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productoespeci.setIsDeletedAuxiliar(false);	
			productoespeci.setIsNewAuxiliar(false);	
			productoespeci.setIsChangedAuxiliar(false);
			
			productoespeci.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoEspecis(List<ProductoEspeci> productoespecis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductoEspeci productoespeci : productoespecis) {
			if(conAsignarBase && productoespeci.getConCambioAuxiliar()) {
				productoespeci.setIsDeleted(productoespeci.getIsDeletedAuxiliar());	
				productoespeci.setIsNew(productoespeci.getIsNewAuxiliar());	
				productoespeci.setIsChanged(productoespeci.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productoespeci.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productoespeci.setIsDeletedAuxiliar(false);	
				productoespeci.setIsNewAuxiliar(false);	
				productoespeci.setIsChangedAuxiliar(false);
				
				productoespeci.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductoEspeci(ProductoEspeci productoespeci,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProductoEspecis(List<ProductoEspeci> productoespecis,Boolean conEnteros) throws Exception  {
		
		for(ProductoEspeci productoespeci: productoespecis) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductoEspeci(List<ProductoEspeci> productoespecis,ProductoEspeci productoespeciAux) throws Exception  {
		ProductoEspeciConstantesFunciones.InicializarValoresProductoEspeci(productoespeciAux,true);
		
		for(ProductoEspeci productoespeci: productoespecis) {
			if(productoespeci.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoEspeci(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductoEspeciConstantesFunciones.getArrayColumnasGlobalesProductoEspeci(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoEspeci(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductoEspeciConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductoEspeciConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductoEspeciConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductoEspeciConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductoEspeci(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoEspeci> productoespecis,ProductoEspeci productoespeci,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoEspeci productoespeciAux: productoespecis) {
			if(productoespeciAux!=null && productoespeci!=null) {
				if((productoespeciAux.getId()==null && productoespeci.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productoespeciAux.getId()!=null && productoespeci.getId()!=null){
					if(productoespeciAux.getId().equals(productoespeci.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoEspeci(List<ProductoEspeci> productoespecis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProductoEspeci productoespeci: productoespecis) {			
			if(productoespeci.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductoEspeci() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductoEspeciConstantesFunciones.LABEL_ID, ProductoEspeciConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEspeciConstantesFunciones.LABEL_VERSIONROW, ProductoEspeciConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEspeciConstantesFunciones.LABEL_IDEMPRESA, ProductoEspeciConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEspeciConstantesFunciones.LABEL_IDSUCURSAL, ProductoEspeciConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEspeciConstantesFunciones.LABEL_IDPRODUCTO, ProductoEspeciConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEspeciConstantesFunciones.LABEL_ESPECIFICACION, ProductoEspeciConstantesFunciones.ESPECIFICACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductoEspeci() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductoEspeciConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEspeciConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEspeciConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEspeciConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEspeciConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEspeciConstantesFunciones.ESPECIFICACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoEspeci() throws Exception  {
		return ProductoEspeciConstantesFunciones.getTiposSeleccionarProductoEspeci(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoEspeci(Boolean conFk) throws Exception  {
		return ProductoEspeciConstantesFunciones.getTiposSeleccionarProductoEspeci(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoEspeci(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEspeciConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProductoEspeciConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEspeciConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProductoEspeciConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEspeciConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProductoEspeciConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEspeciConstantesFunciones.LABEL_ESPECIFICACION);
			reporte.setsDescripcion(ProductoEspeciConstantesFunciones.LABEL_ESPECIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductoEspeci(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductoEspeci(ProductoEspeci productoespeciAux) throws Exception {
		
			productoespeciAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productoespeciAux.getEmpresa()));
			productoespeciAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productoespeciAux.getSucursal()));
			productoespeciAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productoespeciAux.getProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductoEspeci(List<ProductoEspeci> productoespecisTemp) throws Exception {
		for(ProductoEspeci productoespeciAux:productoespecisTemp) {
			
			productoespeciAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productoespeciAux.getEmpresa()));
			productoespeciAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productoespeciAux.getSucursal()));
			productoespeciAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productoespeciAux.getProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductoEspeci(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductoEspeci(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoEspeci(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoEspeciConstantesFunciones.getClassesRelationshipsOfProductoEspeci(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoEspeci(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoEspeci(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoEspeciConstantesFunciones.getClassesRelationshipsFromStringsOfProductoEspeci(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoEspeci(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductoEspeci productoespeci,List<ProductoEspeci> productoespecis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProductoEspeci productoespeciEncontrado=null;
			
			for(ProductoEspeci productoespeciLocal:productoespecis) {
				if(productoespeciLocal.getId().equals(productoespeci.getId())) {
					productoespeciEncontrado=productoespeciLocal;
					
					productoespeciLocal.setIsChanged(productoespeci.getIsChanged());
					productoespeciLocal.setIsNew(productoespeci.getIsNew());
					productoespeciLocal.setIsDeleted(productoespeci.getIsDeleted());
					
					productoespeciLocal.setGeneralEntityOriginal(productoespeci.getGeneralEntityOriginal());
					
					productoespeciLocal.setId(productoespeci.getId());	
					productoespeciLocal.setVersionRow(productoespeci.getVersionRow());	
					productoespeciLocal.setid_empresa(productoespeci.getid_empresa());	
					productoespeciLocal.setid_sucursal(productoespeci.getid_sucursal());	
					productoespeciLocal.setid_producto(productoespeci.getid_producto());	
					productoespeciLocal.setespecificacion(productoespeci.getespecificacion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!productoespeci.getIsDeleted()) {
				if(!existe) {
					productoespecis.add(productoespeci);
				}
			} else {
				if(productoespeciEncontrado!=null && permiteQuitar)  {
					productoespecis.remove(productoespeciEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProductoEspeci productoespeci,List<ProductoEspeci> productoespecis) throws Exception {
		try	{			
			for(ProductoEspeci productoespeciLocal:productoespecis) {
				if(productoespeciLocal.getId().equals(productoespeci.getId())) {
					productoespeciLocal.setIsSelected(productoespeci.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductoEspeci(List<ProductoEspeci> productoespecisAux) throws Exception {
		//this.productoespecisAux=productoespecisAux;
		
		for(ProductoEspeci productoespeciAux:productoespecisAux) {
			if(productoespeciAux.getIsChanged()) {
				productoespeciAux.setIsChanged(false);
			}		
			
			if(productoespeciAux.getIsNew()) {
				productoespeciAux.setIsNew(false);
			}	
			
			if(productoespeciAux.getIsDeleted()) {
				productoespeciAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductoEspeci(ProductoEspeci productoespeciAux) throws Exception {
		//this.productoespeciAux=productoespeciAux;
		
			if(productoespeciAux.getIsChanged()) {
				productoespeciAux.setIsChanged(false);
			}		
			
			if(productoespeciAux.getIsNew()) {
				productoespeciAux.setIsNew(false);
			}	
			
			if(productoespeciAux.getIsDeleted()) {
				productoespeciAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductoEspeci productoespeciAsignar,ProductoEspeci productoespeci) throws Exception {
		productoespeciAsignar.setId(productoespeci.getId());	
		productoespeciAsignar.setVersionRow(productoespeci.getVersionRow());	
		productoespeciAsignar.setid_empresa(productoespeci.getid_empresa());
		productoespeciAsignar.setempresa_descripcion(productoespeci.getempresa_descripcion());	
		productoespeciAsignar.setid_sucursal(productoespeci.getid_sucursal());
		productoespeciAsignar.setsucursal_descripcion(productoespeci.getsucursal_descripcion());	
		productoespeciAsignar.setid_producto(productoespeci.getid_producto());
		productoespeciAsignar.setproducto_descripcion(productoespeci.getproducto_descripcion());	
		productoespeciAsignar.setespecificacion(productoespeci.getespecificacion());	
	}
	
	public static void inicializarProductoEspeci(ProductoEspeci productoespeci) throws Exception {
		try {
				productoespeci.setId(0L);	
					
				productoespeci.setid_empresa(-1L);	
				productoespeci.setid_sucursal(-1L);	
				productoespeci.setid_producto(-1L);	
				productoespeci.setespecificacion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductoEspeci(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEspeciConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEspeciConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEspeciConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEspeciConstantesFunciones.LABEL_ESPECIFICACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductoEspeci(String sTipo,Row row,Workbook workbook,ProductoEspeci productoespeci,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productoespeci.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoespeci.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoespeci.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoespeci.getespecificacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductoEspeci=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProductoEspeci() {
		return this.sFinalQueryProductoEspeci;
	}
	
	public void setsFinalQueryProductoEspeci(String sFinalQueryProductoEspeci) {
		this.sFinalQueryProductoEspeci= sFinalQueryProductoEspeci;
	}
	
	public Border resaltarSeleccionarProductoEspeci=null;
	
	public Border setResaltarSeleccionarProductoEspeci(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEspeciBeanSwingJInternalFrame productoespeciBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productoespeciBeanSwingJInternalFrame.jTtoolBarProductoEspeci.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductoEspeci= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductoEspeci() {
		return this.resaltarSeleccionarProductoEspeci;
	}
	
	public void setResaltarSeleccionarProductoEspeci(Border borderResaltarSeleccionarProductoEspeci) {
		this.resaltarSeleccionarProductoEspeci= borderResaltarSeleccionarProductoEspeci;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductoEspeci=null;
	public Boolean mostraridProductoEspeci=true;
	public Boolean activaridProductoEspeci=true;

	public Border resaltarid_empresaProductoEspeci=null;
	public Boolean mostrarid_empresaProductoEspeci=true;
	public Boolean activarid_empresaProductoEspeci=true;
	public Boolean cargarid_empresaProductoEspeci=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProductoEspeci=false;//ConEventDepend=true

	public Border resaltarid_sucursalProductoEspeci=null;
	public Boolean mostrarid_sucursalProductoEspeci=true;
	public Boolean activarid_sucursalProductoEspeci=true;
	public Boolean cargarid_sucursalProductoEspeci=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProductoEspeci=false;//ConEventDepend=true

	public Border resaltarid_productoProductoEspeci=null;
	public Boolean mostrarid_productoProductoEspeci=true;
	public Boolean activarid_productoProductoEspeci=true;
	public Boolean cargarid_productoProductoEspeci=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProductoEspeci=false;//ConEventDepend=true

	public Border resaltarespecificacionProductoEspeci=null;
	public Boolean mostrarespecificacionProductoEspeci=true;
	public Boolean activarespecificacionProductoEspeci=true;

	
	

	public Border setResaltaridProductoEspeci(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEspeciBeanSwingJInternalFrame productoespeciBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoespeciBeanSwingJInternalFrame.jTtoolBarProductoEspeci.setBorder(borderResaltar);
		
		this.resaltaridProductoEspeci= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductoEspeci() {
		return this.resaltaridProductoEspeci;
	}

	public void setResaltaridProductoEspeci(Border borderResaltar) {
		this.resaltaridProductoEspeci= borderResaltar;
	}

	public Boolean getMostraridProductoEspeci() {
		return this.mostraridProductoEspeci;
	}

	public void setMostraridProductoEspeci(Boolean mostraridProductoEspeci) {
		this.mostraridProductoEspeci= mostraridProductoEspeci;
	}

	public Boolean getActivaridProductoEspeci() {
		return this.activaridProductoEspeci;
	}

	public void setActivaridProductoEspeci(Boolean activaridProductoEspeci) {
		this.activaridProductoEspeci= activaridProductoEspeci;
	}

	public Border setResaltarid_empresaProductoEspeci(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEspeciBeanSwingJInternalFrame productoespeciBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoespeciBeanSwingJInternalFrame.jTtoolBarProductoEspeci.setBorder(borderResaltar);
		
		this.resaltarid_empresaProductoEspeci= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProductoEspeci() {
		return this.resaltarid_empresaProductoEspeci;
	}

	public void setResaltarid_empresaProductoEspeci(Border borderResaltar) {
		this.resaltarid_empresaProductoEspeci= borderResaltar;
	}

	public Boolean getMostrarid_empresaProductoEspeci() {
		return this.mostrarid_empresaProductoEspeci;
	}

	public void setMostrarid_empresaProductoEspeci(Boolean mostrarid_empresaProductoEspeci) {
		this.mostrarid_empresaProductoEspeci= mostrarid_empresaProductoEspeci;
	}

	public Boolean getActivarid_empresaProductoEspeci() {
		return this.activarid_empresaProductoEspeci;
	}

	public void setActivarid_empresaProductoEspeci(Boolean activarid_empresaProductoEspeci) {
		this.activarid_empresaProductoEspeci= activarid_empresaProductoEspeci;
	}

	public Boolean getCargarid_empresaProductoEspeci() {
		return this.cargarid_empresaProductoEspeci;
	}

	public void setCargarid_empresaProductoEspeci(Boolean cargarid_empresaProductoEspeci) {
		this.cargarid_empresaProductoEspeci= cargarid_empresaProductoEspeci;
	}

	public Border setResaltarid_sucursalProductoEspeci(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEspeciBeanSwingJInternalFrame productoespeciBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoespeciBeanSwingJInternalFrame.jTtoolBarProductoEspeci.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProductoEspeci= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProductoEspeci() {
		return this.resaltarid_sucursalProductoEspeci;
	}

	public void setResaltarid_sucursalProductoEspeci(Border borderResaltar) {
		this.resaltarid_sucursalProductoEspeci= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProductoEspeci() {
		return this.mostrarid_sucursalProductoEspeci;
	}

	public void setMostrarid_sucursalProductoEspeci(Boolean mostrarid_sucursalProductoEspeci) {
		this.mostrarid_sucursalProductoEspeci= mostrarid_sucursalProductoEspeci;
	}

	public Boolean getActivarid_sucursalProductoEspeci() {
		return this.activarid_sucursalProductoEspeci;
	}

	public void setActivarid_sucursalProductoEspeci(Boolean activarid_sucursalProductoEspeci) {
		this.activarid_sucursalProductoEspeci= activarid_sucursalProductoEspeci;
	}

	public Boolean getCargarid_sucursalProductoEspeci() {
		return this.cargarid_sucursalProductoEspeci;
	}

	public void setCargarid_sucursalProductoEspeci(Boolean cargarid_sucursalProductoEspeci) {
		this.cargarid_sucursalProductoEspeci= cargarid_sucursalProductoEspeci;
	}

	public Border setResaltarid_productoProductoEspeci(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEspeciBeanSwingJInternalFrame productoespeciBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoespeciBeanSwingJInternalFrame.jTtoolBarProductoEspeci.setBorder(borderResaltar);
		
		this.resaltarid_productoProductoEspeci= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProductoEspeci() {
		return this.resaltarid_productoProductoEspeci;
	}

	public void setResaltarid_productoProductoEspeci(Border borderResaltar) {
		this.resaltarid_productoProductoEspeci= borderResaltar;
	}

	public Boolean getMostrarid_productoProductoEspeci() {
		return this.mostrarid_productoProductoEspeci;
	}

	public void setMostrarid_productoProductoEspeci(Boolean mostrarid_productoProductoEspeci) {
		this.mostrarid_productoProductoEspeci= mostrarid_productoProductoEspeci;
	}

	public Boolean getActivarid_productoProductoEspeci() {
		return this.activarid_productoProductoEspeci;
	}

	public void setActivarid_productoProductoEspeci(Boolean activarid_productoProductoEspeci) {
		this.activarid_productoProductoEspeci= activarid_productoProductoEspeci;
	}

	public Boolean getCargarid_productoProductoEspeci() {
		return this.cargarid_productoProductoEspeci;
	}

	public void setCargarid_productoProductoEspeci(Boolean cargarid_productoProductoEspeci) {
		this.cargarid_productoProductoEspeci= cargarid_productoProductoEspeci;
	}

	public Border setResaltarespecificacionProductoEspeci(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEspeciBeanSwingJInternalFrame productoespeciBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoespeciBeanSwingJInternalFrame.jTtoolBarProductoEspeci.setBorder(borderResaltar);
		
		this.resaltarespecificacionProductoEspeci= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarespecificacionProductoEspeci() {
		return this.resaltarespecificacionProductoEspeci;
	}

	public void setResaltarespecificacionProductoEspeci(Border borderResaltar) {
		this.resaltarespecificacionProductoEspeci= borderResaltar;
	}

	public Boolean getMostrarespecificacionProductoEspeci() {
		return this.mostrarespecificacionProductoEspeci;
	}

	public void setMostrarespecificacionProductoEspeci(Boolean mostrarespecificacionProductoEspeci) {
		this.mostrarespecificacionProductoEspeci= mostrarespecificacionProductoEspeci;
	}

	public Boolean getActivarespecificacionProductoEspeci() {
		return this.activarespecificacionProductoEspeci;
	}

	public void setActivarespecificacionProductoEspeci(Boolean activarespecificacionProductoEspeci) {
		this.activarespecificacionProductoEspeci= activarespecificacionProductoEspeci;
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
		
		
		this.setMostraridProductoEspeci(esInicial);
		this.setMostrarid_empresaProductoEspeci(esInicial);
		this.setMostrarid_sucursalProductoEspeci(esInicial);
		this.setMostrarid_productoProductoEspeci(esInicial);
		this.setMostrarespecificacionProductoEspeci(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoEspeciConstantesFunciones.ID)) {
				this.setMostraridProductoEspeci(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEspeciConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProductoEspeci(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEspeciConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProductoEspeci(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEspeciConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProductoEspeci(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEspeciConstantesFunciones.ESPECIFICACION)) {
				this.setMostrarespecificacionProductoEspeci(esAsigna);
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
		
		
		this.setActivaridProductoEspeci(esInicial);
		this.setActivarid_empresaProductoEspeci(esInicial);
		this.setActivarid_sucursalProductoEspeci(esInicial);
		this.setActivarid_productoProductoEspeci(esInicial);
		this.setActivarespecificacionProductoEspeci(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoEspeciConstantesFunciones.ID)) {
				this.setActivaridProductoEspeci(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEspeciConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProductoEspeci(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEspeciConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProductoEspeci(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEspeciConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProductoEspeci(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEspeciConstantesFunciones.ESPECIFICACION)) {
				this.setActivarespecificacionProductoEspeci(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoEspeciBeanSwingJInternalFrame productoespeciBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductoEspeci(esInicial);
		this.setResaltarid_empresaProductoEspeci(esInicial);
		this.setResaltarid_sucursalProductoEspeci(esInicial);
		this.setResaltarid_productoProductoEspeci(esInicial);
		this.setResaltarespecificacionProductoEspeci(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoEspeciConstantesFunciones.ID)) {
				this.setResaltaridProductoEspeci(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEspeciConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProductoEspeci(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEspeciConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProductoEspeci(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEspeciConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProductoEspeci(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEspeciConstantesFunciones.ESPECIFICACION)) {
				this.setResaltarespecificacionProductoEspeci(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoEspeciBeanSwingJInternalFrame productoespeciBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaProductoEspeci=true;

	public Boolean getMostrarFK_IdEmpresaProductoEspeci() {
		return this.mostrarFK_IdEmpresaProductoEspeci;
	}

	public void setMostrarFK_IdEmpresaProductoEspeci(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaProductoEspeci= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoProductoEspeci=true;

	public Boolean getMostrarFK_IdProductoProductoEspeci() {
		return this.mostrarFK_IdProductoProductoEspeci;
	}

	public void setMostrarFK_IdProductoProductoEspeci(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoProductoEspeci= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalProductoEspeci=true;

	public Boolean getMostrarFK_IdSucursalProductoEspeci() {
		return this.mostrarFK_IdSucursalProductoEspeci;
	}

	public void setMostrarFK_IdSucursalProductoEspeci(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalProductoEspeci= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaProductoEspeci=true;

	public Boolean getActivarFK_IdEmpresaProductoEspeci() {
		return this.activarFK_IdEmpresaProductoEspeci;
	}

	public void setActivarFK_IdEmpresaProductoEspeci(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaProductoEspeci= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoProductoEspeci=true;

	public Boolean getActivarFK_IdProductoProductoEspeci() {
		return this.activarFK_IdProductoProductoEspeci;
	}

	public void setActivarFK_IdProductoProductoEspeci(Boolean habilitarResaltar) {
		this.activarFK_IdProductoProductoEspeci= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalProductoEspeci=true;

	public Boolean getActivarFK_IdSucursalProductoEspeci() {
		return this.activarFK_IdSucursalProductoEspeci;
	}

	public void setActivarFK_IdSucursalProductoEspeci(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalProductoEspeci= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaProductoEspeci=null;

	public Border getResaltarFK_IdEmpresaProductoEspeci() {
		return this.resaltarFK_IdEmpresaProductoEspeci;
	}

	public void setResaltarFK_IdEmpresaProductoEspeci(Border borderResaltar) {
		this.resaltarFK_IdEmpresaProductoEspeci= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaProductoEspeci(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEspeciBeanSwingJInternalFrame productoespeciBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaProductoEspeci= borderResaltar;
	}

	public Border resaltarFK_IdProductoProductoEspeci=null;

	public Border getResaltarFK_IdProductoProductoEspeci() {
		return this.resaltarFK_IdProductoProductoEspeci;
	}

	public void setResaltarFK_IdProductoProductoEspeci(Border borderResaltar) {
		this.resaltarFK_IdProductoProductoEspeci= borderResaltar;
	}

	public void setResaltarFK_IdProductoProductoEspeci(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEspeciBeanSwingJInternalFrame productoespeciBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoProductoEspeci= borderResaltar;
	}

	public Border resaltarFK_IdSucursalProductoEspeci=null;

	public Border getResaltarFK_IdSucursalProductoEspeci() {
		return this.resaltarFK_IdSucursalProductoEspeci;
	}

	public void setResaltarFK_IdSucursalProductoEspeci(Border borderResaltar) {
		this.resaltarFK_IdSucursalProductoEspeci= borderResaltar;
	}

	public void setResaltarFK_IdSucursalProductoEspeci(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEspeciBeanSwingJInternalFrame productoespeciBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalProductoEspeci= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}