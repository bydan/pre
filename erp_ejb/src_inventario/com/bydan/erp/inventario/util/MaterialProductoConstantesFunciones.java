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


import com.bydan.erp.inventario.util.MaterialProductoConstantesFunciones;
import com.bydan.erp.inventario.util.MaterialProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.MaterialProductoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class MaterialProductoConstantesFunciones extends MaterialProductoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="MaterialProducto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="MaterialProducto"+MaterialProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="MaterialProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="MaterialProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=MaterialProductoConstantesFunciones.SCHEMA+"_"+MaterialProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/MaterialProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=MaterialProductoConstantesFunciones.SCHEMA+"_"+MaterialProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=MaterialProductoConstantesFunciones.SCHEMA+"_"+MaterialProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/MaterialProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=MaterialProductoConstantesFunciones.SCHEMA+"_"+MaterialProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MaterialProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MaterialProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MaterialProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MaterialProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MaterialProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MaterialProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=MaterialProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+MaterialProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=MaterialProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+MaterialProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Material Productos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Material Producto";
	public static final String SCLASSWEBTITULO_LOWER="Material Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="MaterialProducto";
	public static final String OBJECTNAME="materialproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="material_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select materialproducto from "+MaterialProductoConstantesFunciones.SPERSISTENCENAME+" materialproducto";
	public static String QUERYSELECTNATIVE="select "+MaterialProductoConstantesFunciones.SCHEMA+"."+MaterialProductoConstantesFunciones.TABLENAME+".id,"+MaterialProductoConstantesFunciones.SCHEMA+"."+MaterialProductoConstantesFunciones.TABLENAME+".version_row,"+MaterialProductoConstantesFunciones.SCHEMA+"."+MaterialProductoConstantesFunciones.TABLENAME+".id_empresa,"+MaterialProductoConstantesFunciones.SCHEMA+"."+MaterialProductoConstantesFunciones.TABLENAME+".id_tipo_producto,"+MaterialProductoConstantesFunciones.SCHEMA+"."+MaterialProductoConstantesFunciones.TABLENAME+".codigo,"+MaterialProductoConstantesFunciones.SCHEMA+"."+MaterialProductoConstantesFunciones.TABLENAME+".nombre from "+MaterialProductoConstantesFunciones.SCHEMA+"."+MaterialProductoConstantesFunciones.TABLENAME;//+" as "+MaterialProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected MaterialProductoConstantesFuncionesAdditional materialproductoConstantesFuncionesAdditional=null;
	
	public MaterialProductoConstantesFuncionesAdditional getMaterialProductoConstantesFuncionesAdditional() {
		return this.materialproductoConstantesFuncionesAdditional;
	}
	
	public void setMaterialProductoConstantesFuncionesAdditional(MaterialProductoConstantesFuncionesAdditional materialproductoConstantesFuncionesAdditional) {
		try {
			this.materialproductoConstantesFuncionesAdditional=materialproductoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTIPOPRODUCTO= "id_tipo_producto";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTIPOPRODUCTO= "Tipo Producto";
		public static final String LABEL_IDTIPOPRODUCTO_LOWER= "Tipo Producto";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getMaterialProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(MaterialProductoConstantesFunciones.IDEMPRESA)) {sLabelColumna=MaterialProductoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(MaterialProductoConstantesFunciones.IDTIPOPRODUCTO)) {sLabelColumna=MaterialProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO;}
		if(sNombreColumna.equals(MaterialProductoConstantesFunciones.CODIGO)) {sLabelColumna=MaterialProductoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(MaterialProductoConstantesFunciones.NOMBRE)) {sLabelColumna=MaterialProductoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getMaterialProductoDescripcion(MaterialProducto materialproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(materialproducto !=null/* && materialproducto.getId()!=0*/) {
			sDescripcion=materialproducto.getcodigo();//materialproductomaterialproducto.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getMaterialProductoDescripcionDetallado(MaterialProducto materialproducto) {
		String sDescripcion="";
			
		sDescripcion+=MaterialProductoConstantesFunciones.ID+"=";
		sDescripcion+=materialproducto.getId().toString()+",";
		sDescripcion+=MaterialProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=materialproducto.getVersionRow().toString()+",";
		sDescripcion+=MaterialProductoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=materialproducto.getid_empresa().toString()+",";
		sDescripcion+=MaterialProductoConstantesFunciones.IDTIPOPRODUCTO+"=";
		sDescripcion+=materialproducto.getid_tipo_producto().toString()+",";
		sDescripcion+=MaterialProductoConstantesFunciones.CODIGO+"=";
		sDescripcion+=materialproducto.getcodigo()+",";
		sDescripcion+=MaterialProductoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=materialproducto.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setMaterialProductoDescripcion(MaterialProducto materialproducto,String sValor) throws Exception {			
		if(materialproducto !=null) {
			materialproducto.setcodigo(sValor);;//materialproductomaterialproducto.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoProductoDescripcion(TipoProducto tipoproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoproducto!=null/*&&tipoproducto.getId()>0*/) {
			sDescripcion=TipoProductoConstantesFunciones.getTipoProductoDescripcion(tipoproducto);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoProducto")) {
			sNombreIndice="Tipo=  Por Tipo Producto";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoProducto(Long id_tipo_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_producto!=null) {sDetalleIndice+=" Codigo Unico De Tipo Producto="+id_tipo_producto.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosMaterialProducto(MaterialProducto materialproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		materialproducto.setcodigo(materialproducto.getcodigo().trim());
		materialproducto.setnombre(materialproducto.getnombre().trim());
	}
	
	public static void quitarEspaciosMaterialProductos(List<MaterialProducto> materialproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(MaterialProducto materialproducto: materialproductos) {
			materialproducto.setcodigo(materialproducto.getcodigo().trim());
			materialproducto.setnombre(materialproducto.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMaterialProducto(MaterialProducto materialproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && materialproducto.getConCambioAuxiliar()) {
			materialproducto.setIsDeleted(materialproducto.getIsDeletedAuxiliar());	
			materialproducto.setIsNew(materialproducto.getIsNewAuxiliar());	
			materialproducto.setIsChanged(materialproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			materialproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			materialproducto.setIsDeletedAuxiliar(false);	
			materialproducto.setIsNewAuxiliar(false);	
			materialproducto.setIsChangedAuxiliar(false);
			
			materialproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMaterialProductos(List<MaterialProducto> materialproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(MaterialProducto materialproducto : materialproductos) {
			if(conAsignarBase && materialproducto.getConCambioAuxiliar()) {
				materialproducto.setIsDeleted(materialproducto.getIsDeletedAuxiliar());	
				materialproducto.setIsNew(materialproducto.getIsNewAuxiliar());	
				materialproducto.setIsChanged(materialproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				materialproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				materialproducto.setIsDeletedAuxiliar(false);	
				materialproducto.setIsNewAuxiliar(false);	
				materialproducto.setIsChangedAuxiliar(false);
				
				materialproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresMaterialProducto(MaterialProducto materialproducto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresMaterialProductos(List<MaterialProducto> materialproductos,Boolean conEnteros) throws Exception  {
		
		for(MaterialProducto materialproducto: materialproductos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaMaterialProducto(List<MaterialProducto> materialproductos,MaterialProducto materialproductoAux) throws Exception  {
		MaterialProductoConstantesFunciones.InicializarValoresMaterialProducto(materialproductoAux,true);
		
		for(MaterialProducto materialproducto: materialproductos) {
			if(materialproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMaterialProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=MaterialProductoConstantesFunciones.getArrayColumnasGlobalesMaterialProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesMaterialProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MaterialProductoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MaterialProductoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoMaterialProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<MaterialProducto> materialproductos,MaterialProducto materialproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(MaterialProducto materialproductoAux: materialproductos) {
			if(materialproductoAux!=null && materialproducto!=null) {
				if((materialproductoAux.getId()==null && materialproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(materialproductoAux.getId()!=null && materialproducto.getId()!=null){
					if(materialproductoAux.getId().equals(materialproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMaterialProducto(List<MaterialProducto> materialproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(MaterialProducto materialproducto: materialproductos) {			
			if(materialproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaMaterialProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,MaterialProductoConstantesFunciones.LABEL_ID, MaterialProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MaterialProductoConstantesFunciones.LABEL_VERSIONROW, MaterialProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MaterialProductoConstantesFunciones.LABEL_IDEMPRESA, MaterialProductoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MaterialProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO, MaterialProductoConstantesFunciones.IDTIPOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MaterialProductoConstantesFunciones.LABEL_CODIGO, MaterialProductoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MaterialProductoConstantesFunciones.LABEL_NOMBRE, MaterialProductoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasMaterialProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=MaterialProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MaterialProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MaterialProductoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MaterialProductoConstantesFunciones.IDTIPOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MaterialProductoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MaterialProductoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMaterialProducto() throws Exception  {
		return MaterialProductoConstantesFunciones.getTiposSeleccionarMaterialProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMaterialProducto(Boolean conFk) throws Exception  {
		return MaterialProductoConstantesFunciones.getTiposSeleccionarMaterialProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMaterialProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MaterialProductoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(MaterialProductoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MaterialProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);
			reporte.setsDescripcion(MaterialProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MaterialProductoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(MaterialProductoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MaterialProductoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(MaterialProductoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesMaterialProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesMaterialProducto(MaterialProducto materialproductoAux) throws Exception {
		
			materialproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(materialproductoAux.getEmpresa()));
			materialproductoAux.settipoproducto_descripcion(TipoProductoConstantesFunciones.getTipoProductoDescripcion(materialproductoAux.getTipoProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesMaterialProducto(List<MaterialProducto> materialproductosTemp) throws Exception {
		for(MaterialProducto materialproductoAux:materialproductosTemp) {
			
			materialproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(materialproductoAux.getEmpresa()));
			materialproductoAux.settipoproducto_descripcion(TipoProductoConstantesFunciones.getTipoProductoDescripcion(materialproductoAux.getTipoProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfMaterialProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoProducto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoProducto.class)) {
						classes.add(new Classe(TipoProducto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfMaterialProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProducto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProducto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfMaterialProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return MaterialProductoConstantesFunciones.getClassesRelationshipsOfMaterialProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMaterialProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(ParametroInventarioDefecto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroInventarioDefecto.class)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMaterialProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return MaterialProductoConstantesFunciones.getClassesRelationshipsFromStringsOfMaterialProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMaterialProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(ParametroInventarioDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(ParametroInventarioDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(MaterialProducto materialproducto,List<MaterialProducto> materialproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			MaterialProducto materialproductoEncontrado=null;
			
			for(MaterialProducto materialproductoLocal:materialproductos) {
				if(materialproductoLocal.getId().equals(materialproducto.getId())) {
					materialproductoEncontrado=materialproductoLocal;
					
					materialproductoLocal.setIsChanged(materialproducto.getIsChanged());
					materialproductoLocal.setIsNew(materialproducto.getIsNew());
					materialproductoLocal.setIsDeleted(materialproducto.getIsDeleted());
					
					materialproductoLocal.setGeneralEntityOriginal(materialproducto.getGeneralEntityOriginal());
					
					materialproductoLocal.setId(materialproducto.getId());	
					materialproductoLocal.setVersionRow(materialproducto.getVersionRow());	
					materialproductoLocal.setid_empresa(materialproducto.getid_empresa());	
					materialproductoLocal.setid_tipo_producto(materialproducto.getid_tipo_producto());	
					materialproductoLocal.setcodigo(materialproducto.getcodigo());	
					materialproductoLocal.setnombre(materialproducto.getnombre());	
					
					
					materialproductoLocal.setProductos(materialproducto.getProductos());
					materialproductoLocal.setParametroInventarioDefectos(materialproducto.getParametroInventarioDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!materialproducto.getIsDeleted()) {
				if(!existe) {
					materialproductos.add(materialproducto);
				}
			} else {
				if(materialproductoEncontrado!=null && permiteQuitar)  {
					materialproductos.remove(materialproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(MaterialProducto materialproducto,List<MaterialProducto> materialproductos) throws Exception {
		try	{			
			for(MaterialProducto materialproductoLocal:materialproductos) {
				if(materialproductoLocal.getId().equals(materialproducto.getId())) {
					materialproductoLocal.setIsSelected(materialproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesMaterialProducto(List<MaterialProducto> materialproductosAux) throws Exception {
		//this.materialproductosAux=materialproductosAux;
		
		for(MaterialProducto materialproductoAux:materialproductosAux) {
			if(materialproductoAux.getIsChanged()) {
				materialproductoAux.setIsChanged(false);
			}		
			
			if(materialproductoAux.getIsNew()) {
				materialproductoAux.setIsNew(false);
			}	
			
			if(materialproductoAux.getIsDeleted()) {
				materialproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesMaterialProducto(MaterialProducto materialproductoAux) throws Exception {
		//this.materialproductoAux=materialproductoAux;
		
			if(materialproductoAux.getIsChanged()) {
				materialproductoAux.setIsChanged(false);
			}		
			
			if(materialproductoAux.getIsNew()) {
				materialproductoAux.setIsNew(false);
			}	
			
			if(materialproductoAux.getIsDeleted()) {
				materialproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(MaterialProducto materialproductoAsignar,MaterialProducto materialproducto) throws Exception {
		materialproductoAsignar.setId(materialproducto.getId());	
		materialproductoAsignar.setVersionRow(materialproducto.getVersionRow());	
		materialproductoAsignar.setid_empresa(materialproducto.getid_empresa());
		materialproductoAsignar.setempresa_descripcion(materialproducto.getempresa_descripcion());	
		materialproductoAsignar.setid_tipo_producto(materialproducto.getid_tipo_producto());
		materialproductoAsignar.settipoproducto_descripcion(materialproducto.gettipoproducto_descripcion());	
		materialproductoAsignar.setcodigo(materialproducto.getcodigo());	
		materialproductoAsignar.setnombre(materialproducto.getnombre());	
	}
	
	public static void inicializarMaterialProducto(MaterialProducto materialproducto) throws Exception {
		try {
				materialproducto.setId(0L);	
					
				materialproducto.setid_empresa(-1L);	
				materialproducto.setid_tipo_producto(-1L);	
				materialproducto.setcodigo("");	
				materialproducto.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderMaterialProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(MaterialProductoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MaterialProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MaterialProductoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MaterialProductoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataMaterialProducto(String sTipo,Row row,Workbook workbook,MaterialProducto materialproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(materialproducto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(materialproducto.gettipoproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(materialproducto.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(materialproducto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryMaterialProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryMaterialProducto() {
		return this.sFinalQueryMaterialProducto;
	}
	
	public void setsFinalQueryMaterialProducto(String sFinalQueryMaterialProducto) {
		this.sFinalQueryMaterialProducto= sFinalQueryMaterialProducto;
	}
	
	public Border resaltarSeleccionarMaterialProducto=null;
	
	public Border setResaltarSeleccionarMaterialProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MaterialProductoBeanSwingJInternalFrame materialproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//materialproductoBeanSwingJInternalFrame.jTtoolBarMaterialProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarMaterialProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarMaterialProducto() {
		return this.resaltarSeleccionarMaterialProducto;
	}
	
	public void setResaltarSeleccionarMaterialProducto(Border borderResaltarSeleccionarMaterialProducto) {
		this.resaltarSeleccionarMaterialProducto= borderResaltarSeleccionarMaterialProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridMaterialProducto=null;
	public Boolean mostraridMaterialProducto=true;
	public Boolean activaridMaterialProducto=true;

	public Border resaltarid_empresaMaterialProducto=null;
	public Boolean mostrarid_empresaMaterialProducto=true;
	public Boolean activarid_empresaMaterialProducto=true;
	public Boolean cargarid_empresaMaterialProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaMaterialProducto=false;//ConEventDepend=true

	public Border resaltarid_tipo_productoMaterialProducto=null;
	public Boolean mostrarid_tipo_productoMaterialProducto=true;
	public Boolean activarid_tipo_productoMaterialProducto=true;
	public Boolean cargarid_tipo_productoMaterialProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_productoMaterialProducto=false;//ConEventDepend=true

	public Border resaltarcodigoMaterialProducto=null;
	public Boolean mostrarcodigoMaterialProducto=true;
	public Boolean activarcodigoMaterialProducto=true;

	public Border resaltarnombreMaterialProducto=null;
	public Boolean mostrarnombreMaterialProducto=true;
	public Boolean activarnombreMaterialProducto=true;

	
	

	public Border setResaltaridMaterialProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MaterialProductoBeanSwingJInternalFrame materialproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//materialproductoBeanSwingJInternalFrame.jTtoolBarMaterialProducto.setBorder(borderResaltar);
		
		this.resaltaridMaterialProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridMaterialProducto() {
		return this.resaltaridMaterialProducto;
	}

	public void setResaltaridMaterialProducto(Border borderResaltar) {
		this.resaltaridMaterialProducto= borderResaltar;
	}

	public Boolean getMostraridMaterialProducto() {
		return this.mostraridMaterialProducto;
	}

	public void setMostraridMaterialProducto(Boolean mostraridMaterialProducto) {
		this.mostraridMaterialProducto= mostraridMaterialProducto;
	}

	public Boolean getActivaridMaterialProducto() {
		return this.activaridMaterialProducto;
	}

	public void setActivaridMaterialProducto(Boolean activaridMaterialProducto) {
		this.activaridMaterialProducto= activaridMaterialProducto;
	}

	public Border setResaltarid_empresaMaterialProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MaterialProductoBeanSwingJInternalFrame materialproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//materialproductoBeanSwingJInternalFrame.jTtoolBarMaterialProducto.setBorder(borderResaltar);
		
		this.resaltarid_empresaMaterialProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaMaterialProducto() {
		return this.resaltarid_empresaMaterialProducto;
	}

	public void setResaltarid_empresaMaterialProducto(Border borderResaltar) {
		this.resaltarid_empresaMaterialProducto= borderResaltar;
	}

	public Boolean getMostrarid_empresaMaterialProducto() {
		return this.mostrarid_empresaMaterialProducto;
	}

	public void setMostrarid_empresaMaterialProducto(Boolean mostrarid_empresaMaterialProducto) {
		this.mostrarid_empresaMaterialProducto= mostrarid_empresaMaterialProducto;
	}

	public Boolean getActivarid_empresaMaterialProducto() {
		return this.activarid_empresaMaterialProducto;
	}

	public void setActivarid_empresaMaterialProducto(Boolean activarid_empresaMaterialProducto) {
		this.activarid_empresaMaterialProducto= activarid_empresaMaterialProducto;
	}

	public Boolean getCargarid_empresaMaterialProducto() {
		return this.cargarid_empresaMaterialProducto;
	}

	public void setCargarid_empresaMaterialProducto(Boolean cargarid_empresaMaterialProducto) {
		this.cargarid_empresaMaterialProducto= cargarid_empresaMaterialProducto;
	}

	public Border setResaltarid_tipo_productoMaterialProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MaterialProductoBeanSwingJInternalFrame materialproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//materialproductoBeanSwingJInternalFrame.jTtoolBarMaterialProducto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_productoMaterialProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_productoMaterialProducto() {
		return this.resaltarid_tipo_productoMaterialProducto;
	}

	public void setResaltarid_tipo_productoMaterialProducto(Border borderResaltar) {
		this.resaltarid_tipo_productoMaterialProducto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_productoMaterialProducto() {
		return this.mostrarid_tipo_productoMaterialProducto;
	}

	public void setMostrarid_tipo_productoMaterialProducto(Boolean mostrarid_tipo_productoMaterialProducto) {
		this.mostrarid_tipo_productoMaterialProducto= mostrarid_tipo_productoMaterialProducto;
	}

	public Boolean getActivarid_tipo_productoMaterialProducto() {
		return this.activarid_tipo_productoMaterialProducto;
	}

	public void setActivarid_tipo_productoMaterialProducto(Boolean activarid_tipo_productoMaterialProducto) {
		this.activarid_tipo_productoMaterialProducto= activarid_tipo_productoMaterialProducto;
	}

	public Boolean getCargarid_tipo_productoMaterialProducto() {
		return this.cargarid_tipo_productoMaterialProducto;
	}

	public void setCargarid_tipo_productoMaterialProducto(Boolean cargarid_tipo_productoMaterialProducto) {
		this.cargarid_tipo_productoMaterialProducto= cargarid_tipo_productoMaterialProducto;
	}

	public Border setResaltarcodigoMaterialProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MaterialProductoBeanSwingJInternalFrame materialproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//materialproductoBeanSwingJInternalFrame.jTtoolBarMaterialProducto.setBorder(borderResaltar);
		
		this.resaltarcodigoMaterialProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoMaterialProducto() {
		return this.resaltarcodigoMaterialProducto;
	}

	public void setResaltarcodigoMaterialProducto(Border borderResaltar) {
		this.resaltarcodigoMaterialProducto= borderResaltar;
	}

	public Boolean getMostrarcodigoMaterialProducto() {
		return this.mostrarcodigoMaterialProducto;
	}

	public void setMostrarcodigoMaterialProducto(Boolean mostrarcodigoMaterialProducto) {
		this.mostrarcodigoMaterialProducto= mostrarcodigoMaterialProducto;
	}

	public Boolean getActivarcodigoMaterialProducto() {
		return this.activarcodigoMaterialProducto;
	}

	public void setActivarcodigoMaterialProducto(Boolean activarcodigoMaterialProducto) {
		this.activarcodigoMaterialProducto= activarcodigoMaterialProducto;
	}

	public Border setResaltarnombreMaterialProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MaterialProductoBeanSwingJInternalFrame materialproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//materialproductoBeanSwingJInternalFrame.jTtoolBarMaterialProducto.setBorder(borderResaltar);
		
		this.resaltarnombreMaterialProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreMaterialProducto() {
		return this.resaltarnombreMaterialProducto;
	}

	public void setResaltarnombreMaterialProducto(Border borderResaltar) {
		this.resaltarnombreMaterialProducto= borderResaltar;
	}

	public Boolean getMostrarnombreMaterialProducto() {
		return this.mostrarnombreMaterialProducto;
	}

	public void setMostrarnombreMaterialProducto(Boolean mostrarnombreMaterialProducto) {
		this.mostrarnombreMaterialProducto= mostrarnombreMaterialProducto;
	}

	public Boolean getActivarnombreMaterialProducto() {
		return this.activarnombreMaterialProducto;
	}

	public void setActivarnombreMaterialProducto(Boolean activarnombreMaterialProducto) {
		this.activarnombreMaterialProducto= activarnombreMaterialProducto;
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
		
		
		this.setMostraridMaterialProducto(esInicial);
		this.setMostrarid_empresaMaterialProducto(esInicial);
		this.setMostrarid_tipo_productoMaterialProducto(esInicial);
		this.setMostrarcodigoMaterialProducto(esInicial);
		this.setMostrarnombreMaterialProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MaterialProductoConstantesFunciones.ID)) {
				this.setMostraridMaterialProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MaterialProductoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaMaterialProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MaterialProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setMostrarid_tipo_productoMaterialProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MaterialProductoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoMaterialProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MaterialProductoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreMaterialProducto(esAsigna);
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
		
		
		this.setActivaridMaterialProducto(esInicial);
		this.setActivarid_empresaMaterialProducto(esInicial);
		this.setActivarid_tipo_productoMaterialProducto(esInicial);
		this.setActivarcodigoMaterialProducto(esInicial);
		this.setActivarnombreMaterialProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MaterialProductoConstantesFunciones.ID)) {
				this.setActivaridMaterialProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MaterialProductoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaMaterialProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MaterialProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setActivarid_tipo_productoMaterialProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MaterialProductoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoMaterialProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MaterialProductoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreMaterialProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,MaterialProductoBeanSwingJInternalFrame materialproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridMaterialProducto(esInicial);
		this.setResaltarid_empresaMaterialProducto(esInicial);
		this.setResaltarid_tipo_productoMaterialProducto(esInicial);
		this.setResaltarcodigoMaterialProducto(esInicial);
		this.setResaltarnombreMaterialProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MaterialProductoConstantesFunciones.ID)) {
				this.setResaltaridMaterialProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MaterialProductoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaMaterialProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MaterialProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setResaltarid_tipo_productoMaterialProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MaterialProductoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoMaterialProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MaterialProductoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreMaterialProducto(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarProductoMaterialProducto=null;

	public Border getResaltarProductoMaterialProducto() {
		return this.resaltarProductoMaterialProducto;
	}

	public void setResaltarProductoMaterialProducto(Border borderResaltarProducto) {
		if(borderResaltarProducto!=null) {
			this.resaltarProductoMaterialProducto= borderResaltarProducto;
		}
	}

	public Border setResaltarProductoMaterialProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MaterialProductoBeanSwingJInternalFrame materialproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//materialproductoBeanSwingJInternalFrame.jTtoolBarMaterialProducto.setBorder(borderResaltarProducto);
			
		this.resaltarProductoMaterialProducto= borderResaltarProducto;

		 return borderResaltarProducto;
	}



	public Boolean mostrarProductoMaterialProducto=true;

	public Boolean getMostrarProductoMaterialProducto() {
		return this.mostrarProductoMaterialProducto;
	}

	public void setMostrarProductoMaterialProducto(Boolean visibilidadResaltarProducto) {
		this.mostrarProductoMaterialProducto= visibilidadResaltarProducto;
	}



	public Boolean activarProductoMaterialProducto=true;

	public Boolean gethabilitarResaltarProductoMaterialProducto() {
		return this.activarProductoMaterialProducto;
	}

	public void setActivarProductoMaterialProducto(Boolean habilitarResaltarProducto) {
		this.activarProductoMaterialProducto= habilitarResaltarProducto;
	}


	public Border resaltarParametroInventarioDefectoMaterialProducto=null;

	public Border getResaltarParametroInventarioDefectoMaterialProducto() {
		return this.resaltarParametroInventarioDefectoMaterialProducto;
	}

	public void setResaltarParametroInventarioDefectoMaterialProducto(Border borderResaltarParametroInventarioDefecto) {
		if(borderResaltarParametroInventarioDefecto!=null) {
			this.resaltarParametroInventarioDefectoMaterialProducto= borderResaltarParametroInventarioDefecto;
		}
	}

	public Border setResaltarParametroInventarioDefectoMaterialProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MaterialProductoBeanSwingJInternalFrame materialproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroInventarioDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//materialproductoBeanSwingJInternalFrame.jTtoolBarMaterialProducto.setBorder(borderResaltarParametroInventarioDefecto);
			
		this.resaltarParametroInventarioDefectoMaterialProducto= borderResaltarParametroInventarioDefecto;

		 return borderResaltarParametroInventarioDefecto;
	}



	public Boolean mostrarParametroInventarioDefectoMaterialProducto=true;

	public Boolean getMostrarParametroInventarioDefectoMaterialProducto() {
		return this.mostrarParametroInventarioDefectoMaterialProducto;
	}

	public void setMostrarParametroInventarioDefectoMaterialProducto(Boolean visibilidadResaltarParametroInventarioDefecto) {
		this.mostrarParametroInventarioDefectoMaterialProducto= visibilidadResaltarParametroInventarioDefecto;
	}



	public Boolean activarParametroInventarioDefectoMaterialProducto=true;

	public Boolean gethabilitarResaltarParametroInventarioDefectoMaterialProducto() {
		return this.activarParametroInventarioDefectoMaterialProducto;
	}

	public void setActivarParametroInventarioDefectoMaterialProducto(Boolean habilitarResaltarParametroInventarioDefecto) {
		this.activarParametroInventarioDefectoMaterialProducto= habilitarResaltarParametroInventarioDefecto;
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

		this.setMostrarProductoMaterialProducto(esInicial);
		this.setMostrarParametroInventarioDefectoMaterialProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setMostrarProductoMaterialProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setMostrarParametroInventarioDefectoMaterialProducto(esAsigna);
				continue;
			}
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

		this.setActivarProductoMaterialProducto(esInicial);
		this.setActivarParametroInventarioDefectoMaterialProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setActivarProductoMaterialProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setActivarParametroInventarioDefectoMaterialProducto(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,MaterialProductoBeanSwingJInternalFrame materialproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarProductoMaterialProducto(esInicial);
		this.setResaltarParametroInventarioDefectoMaterialProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setResaltarProductoMaterialProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setResaltarParametroInventarioDefectoMaterialProducto(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoMaterialProducto=true;

	public Boolean getMostrarBusquedaPorCodigoMaterialProducto() {
		return this.mostrarBusquedaPorCodigoMaterialProducto;
	}

	public void setMostrarBusquedaPorCodigoMaterialProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoMaterialProducto= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreMaterialProducto=true;

	public Boolean getMostrarBusquedaPorNombreMaterialProducto() {
		return this.mostrarBusquedaPorNombreMaterialProducto;
	}

	public void setMostrarBusquedaPorNombreMaterialProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreMaterialProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaMaterialProducto=true;

	public Boolean getMostrarFK_IdEmpresaMaterialProducto() {
		return this.mostrarFK_IdEmpresaMaterialProducto;
	}

	public void setMostrarFK_IdEmpresaMaterialProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaMaterialProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProductoMaterialProducto=true;

	public Boolean getMostrarFK_IdTipoProductoMaterialProducto() {
		return this.mostrarFK_IdTipoProductoMaterialProducto;
	}

	public void setMostrarFK_IdTipoProductoMaterialProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProductoMaterialProducto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoMaterialProducto=true;

	public Boolean getActivarBusquedaPorCodigoMaterialProducto() {
		return this.activarBusquedaPorCodigoMaterialProducto;
	}

	public void setActivarBusquedaPorCodigoMaterialProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoMaterialProducto= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreMaterialProducto=true;

	public Boolean getActivarBusquedaPorNombreMaterialProducto() {
		return this.activarBusquedaPorNombreMaterialProducto;
	}

	public void setActivarBusquedaPorNombreMaterialProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreMaterialProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaMaterialProducto=true;

	public Boolean getActivarFK_IdEmpresaMaterialProducto() {
		return this.activarFK_IdEmpresaMaterialProducto;
	}

	public void setActivarFK_IdEmpresaMaterialProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaMaterialProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProductoMaterialProducto=true;

	public Boolean getActivarFK_IdTipoProductoMaterialProducto() {
		return this.activarFK_IdTipoProductoMaterialProducto;
	}

	public void setActivarFK_IdTipoProductoMaterialProducto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProductoMaterialProducto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoMaterialProducto=null;

	public Border getResaltarBusquedaPorCodigoMaterialProducto() {
		return this.resaltarBusquedaPorCodigoMaterialProducto;
	}

	public void setResaltarBusquedaPorCodigoMaterialProducto(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoMaterialProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoMaterialProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MaterialProductoBeanSwingJInternalFrame materialproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoMaterialProducto= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreMaterialProducto=null;

	public Border getResaltarBusquedaPorNombreMaterialProducto() {
		return this.resaltarBusquedaPorNombreMaterialProducto;
	}

	public void setResaltarBusquedaPorNombreMaterialProducto(Border borderResaltar) {
		this.resaltarBusquedaPorNombreMaterialProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreMaterialProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MaterialProductoBeanSwingJInternalFrame materialproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreMaterialProducto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaMaterialProducto=null;

	public Border getResaltarFK_IdEmpresaMaterialProducto() {
		return this.resaltarFK_IdEmpresaMaterialProducto;
	}

	public void setResaltarFK_IdEmpresaMaterialProducto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaMaterialProducto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaMaterialProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MaterialProductoBeanSwingJInternalFrame materialproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaMaterialProducto= borderResaltar;
	}

	public Border resaltarFK_IdTipoProductoMaterialProducto=null;

	public Border getResaltarFK_IdTipoProductoMaterialProducto() {
		return this.resaltarFK_IdTipoProductoMaterialProducto;
	}

	public void setResaltarFK_IdTipoProductoMaterialProducto(Border borderResaltar) {
		this.resaltarFK_IdTipoProductoMaterialProducto= borderResaltar;
	}

	public void setResaltarFK_IdTipoProductoMaterialProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MaterialProductoBeanSwingJInternalFrame materialproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProductoMaterialProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}