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


import com.bydan.erp.inventario.util.ModeloProductoConstantesFunciones;
import com.bydan.erp.inventario.util.ModeloProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ModeloProductoParameterGeneral;

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
final public class ModeloProductoConstantesFunciones extends ModeloProductoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ModeloProducto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ModeloProducto"+ModeloProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ModeloProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ModeloProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ModeloProductoConstantesFunciones.SCHEMA+"_"+ModeloProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ModeloProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ModeloProductoConstantesFunciones.SCHEMA+"_"+ModeloProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ModeloProductoConstantesFunciones.SCHEMA+"_"+ModeloProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ModeloProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ModeloProductoConstantesFunciones.SCHEMA+"_"+ModeloProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ModeloProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ModeloProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ModeloProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ModeloProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ModeloProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ModeloProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ModeloProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ModeloProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ModeloProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ModeloProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Modelo Productos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Modelo Producto";
	public static final String SCLASSWEBTITULO_LOWER="Modelo Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ModeloProducto";
	public static final String OBJECTNAME="modeloproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="modelo_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select modeloproducto from "+ModeloProductoConstantesFunciones.SPERSISTENCENAME+" modeloproducto";
	public static String QUERYSELECTNATIVE="select "+ModeloProductoConstantesFunciones.SCHEMA+"."+ModeloProductoConstantesFunciones.TABLENAME+".id,"+ModeloProductoConstantesFunciones.SCHEMA+"."+ModeloProductoConstantesFunciones.TABLENAME+".version_row,"+ModeloProductoConstantesFunciones.SCHEMA+"."+ModeloProductoConstantesFunciones.TABLENAME+".id_empresa,"+ModeloProductoConstantesFunciones.SCHEMA+"."+ModeloProductoConstantesFunciones.TABLENAME+".id_tipo_producto,"+ModeloProductoConstantesFunciones.SCHEMA+"."+ModeloProductoConstantesFunciones.TABLENAME+".codigo,"+ModeloProductoConstantesFunciones.SCHEMA+"."+ModeloProductoConstantesFunciones.TABLENAME+".nombre from "+ModeloProductoConstantesFunciones.SCHEMA+"."+ModeloProductoConstantesFunciones.TABLENAME;//+" as "+ModeloProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ModeloProductoConstantesFuncionesAdditional modeloproductoConstantesFuncionesAdditional=null;
	
	public ModeloProductoConstantesFuncionesAdditional getModeloProductoConstantesFuncionesAdditional() {
		return this.modeloproductoConstantesFuncionesAdditional;
	}
	
	public void setModeloProductoConstantesFuncionesAdditional(ModeloProductoConstantesFuncionesAdditional modeloproductoConstantesFuncionesAdditional) {
		try {
			this.modeloproductoConstantesFuncionesAdditional=modeloproductoConstantesFuncionesAdditional;
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
	
	public static String getModeloProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ModeloProductoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ModeloProductoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ModeloProductoConstantesFunciones.IDTIPOPRODUCTO)) {sLabelColumna=ModeloProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO;}
		if(sNombreColumna.equals(ModeloProductoConstantesFunciones.CODIGO)) {sLabelColumna=ModeloProductoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ModeloProductoConstantesFunciones.NOMBRE)) {sLabelColumna=ModeloProductoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getModeloProductoDescripcion(ModeloProducto modeloproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(modeloproducto !=null/* && modeloproducto.getId()!=0*/) {
			sDescripcion=modeloproducto.getcodigo();//modeloproductomodeloproducto.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getModeloProductoDescripcionDetallado(ModeloProducto modeloproducto) {
		String sDescripcion="";
			
		sDescripcion+=ModeloProductoConstantesFunciones.ID+"=";
		sDescripcion+=modeloproducto.getId().toString()+",";
		sDescripcion+=ModeloProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=modeloproducto.getVersionRow().toString()+",";
		sDescripcion+=ModeloProductoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=modeloproducto.getid_empresa().toString()+",";
		sDescripcion+=ModeloProductoConstantesFunciones.IDTIPOPRODUCTO+"=";
		sDescripcion+=modeloproducto.getid_tipo_producto().toString()+",";
		sDescripcion+=ModeloProductoConstantesFunciones.CODIGO+"=";
		sDescripcion+=modeloproducto.getcodigo()+",";
		sDescripcion+=ModeloProductoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=modeloproducto.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setModeloProductoDescripcion(ModeloProducto modeloproducto,String sValor) throws Exception {			
		if(modeloproducto !=null) {
			modeloproducto.setcodigo(sValor);;//modeloproductomodeloproducto.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosModeloProducto(ModeloProducto modeloproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		modeloproducto.setcodigo(modeloproducto.getcodigo().trim());
		modeloproducto.setnombre(modeloproducto.getnombre().trim());
	}
	
	public static void quitarEspaciosModeloProductos(List<ModeloProducto> modeloproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ModeloProducto modeloproducto: modeloproductos) {
			modeloproducto.setcodigo(modeloproducto.getcodigo().trim());
			modeloproducto.setnombre(modeloproducto.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresModeloProducto(ModeloProducto modeloproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && modeloproducto.getConCambioAuxiliar()) {
			modeloproducto.setIsDeleted(modeloproducto.getIsDeletedAuxiliar());	
			modeloproducto.setIsNew(modeloproducto.getIsNewAuxiliar());	
			modeloproducto.setIsChanged(modeloproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			modeloproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			modeloproducto.setIsDeletedAuxiliar(false);	
			modeloproducto.setIsNewAuxiliar(false);	
			modeloproducto.setIsChangedAuxiliar(false);
			
			modeloproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresModeloProductos(List<ModeloProducto> modeloproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ModeloProducto modeloproducto : modeloproductos) {
			if(conAsignarBase && modeloproducto.getConCambioAuxiliar()) {
				modeloproducto.setIsDeleted(modeloproducto.getIsDeletedAuxiliar());	
				modeloproducto.setIsNew(modeloproducto.getIsNewAuxiliar());	
				modeloproducto.setIsChanged(modeloproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				modeloproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				modeloproducto.setIsDeletedAuxiliar(false);	
				modeloproducto.setIsNewAuxiliar(false);	
				modeloproducto.setIsChangedAuxiliar(false);
				
				modeloproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresModeloProducto(ModeloProducto modeloproducto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresModeloProductos(List<ModeloProducto> modeloproductos,Boolean conEnteros) throws Exception  {
		
		for(ModeloProducto modeloproducto: modeloproductos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaModeloProducto(List<ModeloProducto> modeloproductos,ModeloProducto modeloproductoAux) throws Exception  {
		ModeloProductoConstantesFunciones.InicializarValoresModeloProducto(modeloproductoAux,true);
		
		for(ModeloProducto modeloproducto: modeloproductos) {
			if(modeloproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesModeloProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ModeloProductoConstantesFunciones.getArrayColumnasGlobalesModeloProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesModeloProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ModeloProductoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ModeloProductoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoModeloProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ModeloProducto> modeloproductos,ModeloProducto modeloproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ModeloProducto modeloproductoAux: modeloproductos) {
			if(modeloproductoAux!=null && modeloproducto!=null) {
				if((modeloproductoAux.getId()==null && modeloproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(modeloproductoAux.getId()!=null && modeloproducto.getId()!=null){
					if(modeloproductoAux.getId().equals(modeloproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaModeloProducto(List<ModeloProducto> modeloproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ModeloProducto modeloproducto: modeloproductos) {			
			if(modeloproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaModeloProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ModeloProductoConstantesFunciones.LABEL_ID, ModeloProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ModeloProductoConstantesFunciones.LABEL_VERSIONROW, ModeloProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ModeloProductoConstantesFunciones.LABEL_IDEMPRESA, ModeloProductoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ModeloProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO, ModeloProductoConstantesFunciones.IDTIPOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ModeloProductoConstantesFunciones.LABEL_CODIGO, ModeloProductoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ModeloProductoConstantesFunciones.LABEL_NOMBRE, ModeloProductoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasModeloProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ModeloProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ModeloProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ModeloProductoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ModeloProductoConstantesFunciones.IDTIPOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ModeloProductoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ModeloProductoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarModeloProducto() throws Exception  {
		return ModeloProductoConstantesFunciones.getTiposSeleccionarModeloProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarModeloProducto(Boolean conFk) throws Exception  {
		return ModeloProductoConstantesFunciones.getTiposSeleccionarModeloProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarModeloProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ModeloProductoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ModeloProductoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ModeloProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);
			reporte.setsDescripcion(ModeloProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ModeloProductoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ModeloProductoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ModeloProductoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ModeloProductoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesModeloProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesModeloProducto(ModeloProducto modeloproductoAux) throws Exception {
		
			modeloproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(modeloproductoAux.getEmpresa()));
			modeloproductoAux.settipoproducto_descripcion(TipoProductoConstantesFunciones.getTipoProductoDescripcion(modeloproductoAux.getTipoProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesModeloProducto(List<ModeloProducto> modeloproductosTemp) throws Exception {
		for(ModeloProducto modeloproductoAux:modeloproductosTemp) {
			
			modeloproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(modeloproductoAux.getEmpresa()));
			modeloproductoAux.settipoproducto_descripcion(TipoProductoConstantesFunciones.getTipoProductoDescripcion(modeloproductoAux.getTipoProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfModeloProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfModeloProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfModeloProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ModeloProductoConstantesFunciones.getClassesRelationshipsOfModeloProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfModeloProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfModeloProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ModeloProductoConstantesFunciones.getClassesRelationshipsFromStringsOfModeloProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfModeloProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ModeloProducto modeloproducto,List<ModeloProducto> modeloproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ModeloProducto modeloproductoEncontrado=null;
			
			for(ModeloProducto modeloproductoLocal:modeloproductos) {
				if(modeloproductoLocal.getId().equals(modeloproducto.getId())) {
					modeloproductoEncontrado=modeloproductoLocal;
					
					modeloproductoLocal.setIsChanged(modeloproducto.getIsChanged());
					modeloproductoLocal.setIsNew(modeloproducto.getIsNew());
					modeloproductoLocal.setIsDeleted(modeloproducto.getIsDeleted());
					
					modeloproductoLocal.setGeneralEntityOriginal(modeloproducto.getGeneralEntityOriginal());
					
					modeloproductoLocal.setId(modeloproducto.getId());	
					modeloproductoLocal.setVersionRow(modeloproducto.getVersionRow());	
					modeloproductoLocal.setid_empresa(modeloproducto.getid_empresa());	
					modeloproductoLocal.setid_tipo_producto(modeloproducto.getid_tipo_producto());	
					modeloproductoLocal.setcodigo(modeloproducto.getcodigo());	
					modeloproductoLocal.setnombre(modeloproducto.getnombre());	
					
					
					modeloproductoLocal.setProductos(modeloproducto.getProductos());
					modeloproductoLocal.setParametroInventarioDefectos(modeloproducto.getParametroInventarioDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!modeloproducto.getIsDeleted()) {
				if(!existe) {
					modeloproductos.add(modeloproducto);
				}
			} else {
				if(modeloproductoEncontrado!=null && permiteQuitar)  {
					modeloproductos.remove(modeloproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ModeloProducto modeloproducto,List<ModeloProducto> modeloproductos) throws Exception {
		try	{			
			for(ModeloProducto modeloproductoLocal:modeloproductos) {
				if(modeloproductoLocal.getId().equals(modeloproducto.getId())) {
					modeloproductoLocal.setIsSelected(modeloproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesModeloProducto(List<ModeloProducto> modeloproductosAux) throws Exception {
		//this.modeloproductosAux=modeloproductosAux;
		
		for(ModeloProducto modeloproductoAux:modeloproductosAux) {
			if(modeloproductoAux.getIsChanged()) {
				modeloproductoAux.setIsChanged(false);
			}		
			
			if(modeloproductoAux.getIsNew()) {
				modeloproductoAux.setIsNew(false);
			}	
			
			if(modeloproductoAux.getIsDeleted()) {
				modeloproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesModeloProducto(ModeloProducto modeloproductoAux) throws Exception {
		//this.modeloproductoAux=modeloproductoAux;
		
			if(modeloproductoAux.getIsChanged()) {
				modeloproductoAux.setIsChanged(false);
			}		
			
			if(modeloproductoAux.getIsNew()) {
				modeloproductoAux.setIsNew(false);
			}	
			
			if(modeloproductoAux.getIsDeleted()) {
				modeloproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ModeloProducto modeloproductoAsignar,ModeloProducto modeloproducto) throws Exception {
		modeloproductoAsignar.setId(modeloproducto.getId());	
		modeloproductoAsignar.setVersionRow(modeloproducto.getVersionRow());	
		modeloproductoAsignar.setid_empresa(modeloproducto.getid_empresa());
		modeloproductoAsignar.setempresa_descripcion(modeloproducto.getempresa_descripcion());	
		modeloproductoAsignar.setid_tipo_producto(modeloproducto.getid_tipo_producto());
		modeloproductoAsignar.settipoproducto_descripcion(modeloproducto.gettipoproducto_descripcion());	
		modeloproductoAsignar.setcodigo(modeloproducto.getcodigo());	
		modeloproductoAsignar.setnombre(modeloproducto.getnombre());	
	}
	
	public static void inicializarModeloProducto(ModeloProducto modeloproducto) throws Exception {
		try {
				modeloproducto.setId(0L);	
					
				modeloproducto.setid_empresa(-1L);	
				modeloproducto.setid_tipo_producto(-1L);	
				modeloproducto.setcodigo("");	
				modeloproducto.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderModeloProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ModeloProductoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ModeloProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ModeloProductoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ModeloProductoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataModeloProducto(String sTipo,Row row,Workbook workbook,ModeloProducto modeloproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(modeloproducto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(modeloproducto.gettipoproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(modeloproducto.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(modeloproducto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryModeloProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryModeloProducto() {
		return this.sFinalQueryModeloProducto;
	}
	
	public void setsFinalQueryModeloProducto(String sFinalQueryModeloProducto) {
		this.sFinalQueryModeloProducto= sFinalQueryModeloProducto;
	}
	
	public Border resaltarSeleccionarModeloProducto=null;
	
	public Border setResaltarSeleccionarModeloProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ModeloProductoBeanSwingJInternalFrame modeloproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//modeloproductoBeanSwingJInternalFrame.jTtoolBarModeloProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarModeloProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarModeloProducto() {
		return this.resaltarSeleccionarModeloProducto;
	}
	
	public void setResaltarSeleccionarModeloProducto(Border borderResaltarSeleccionarModeloProducto) {
		this.resaltarSeleccionarModeloProducto= borderResaltarSeleccionarModeloProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridModeloProducto=null;
	public Boolean mostraridModeloProducto=true;
	public Boolean activaridModeloProducto=true;

	public Border resaltarid_empresaModeloProducto=null;
	public Boolean mostrarid_empresaModeloProducto=true;
	public Boolean activarid_empresaModeloProducto=true;
	public Boolean cargarid_empresaModeloProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaModeloProducto=false;//ConEventDepend=true

	public Border resaltarid_tipo_productoModeloProducto=null;
	public Boolean mostrarid_tipo_productoModeloProducto=true;
	public Boolean activarid_tipo_productoModeloProducto=true;
	public Boolean cargarid_tipo_productoModeloProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_productoModeloProducto=false;//ConEventDepend=true

	public Border resaltarcodigoModeloProducto=null;
	public Boolean mostrarcodigoModeloProducto=true;
	public Boolean activarcodigoModeloProducto=true;

	public Border resaltarnombreModeloProducto=null;
	public Boolean mostrarnombreModeloProducto=true;
	public Boolean activarnombreModeloProducto=true;

	
	

	public Border setResaltaridModeloProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ModeloProductoBeanSwingJInternalFrame modeloproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//modeloproductoBeanSwingJInternalFrame.jTtoolBarModeloProducto.setBorder(borderResaltar);
		
		this.resaltaridModeloProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridModeloProducto() {
		return this.resaltaridModeloProducto;
	}

	public void setResaltaridModeloProducto(Border borderResaltar) {
		this.resaltaridModeloProducto= borderResaltar;
	}

	public Boolean getMostraridModeloProducto() {
		return this.mostraridModeloProducto;
	}

	public void setMostraridModeloProducto(Boolean mostraridModeloProducto) {
		this.mostraridModeloProducto= mostraridModeloProducto;
	}

	public Boolean getActivaridModeloProducto() {
		return this.activaridModeloProducto;
	}

	public void setActivaridModeloProducto(Boolean activaridModeloProducto) {
		this.activaridModeloProducto= activaridModeloProducto;
	}

	public Border setResaltarid_empresaModeloProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ModeloProductoBeanSwingJInternalFrame modeloproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//modeloproductoBeanSwingJInternalFrame.jTtoolBarModeloProducto.setBorder(borderResaltar);
		
		this.resaltarid_empresaModeloProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaModeloProducto() {
		return this.resaltarid_empresaModeloProducto;
	}

	public void setResaltarid_empresaModeloProducto(Border borderResaltar) {
		this.resaltarid_empresaModeloProducto= borderResaltar;
	}

	public Boolean getMostrarid_empresaModeloProducto() {
		return this.mostrarid_empresaModeloProducto;
	}

	public void setMostrarid_empresaModeloProducto(Boolean mostrarid_empresaModeloProducto) {
		this.mostrarid_empresaModeloProducto= mostrarid_empresaModeloProducto;
	}

	public Boolean getActivarid_empresaModeloProducto() {
		return this.activarid_empresaModeloProducto;
	}

	public void setActivarid_empresaModeloProducto(Boolean activarid_empresaModeloProducto) {
		this.activarid_empresaModeloProducto= activarid_empresaModeloProducto;
	}

	public Boolean getCargarid_empresaModeloProducto() {
		return this.cargarid_empresaModeloProducto;
	}

	public void setCargarid_empresaModeloProducto(Boolean cargarid_empresaModeloProducto) {
		this.cargarid_empresaModeloProducto= cargarid_empresaModeloProducto;
	}

	public Border setResaltarid_tipo_productoModeloProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ModeloProductoBeanSwingJInternalFrame modeloproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//modeloproductoBeanSwingJInternalFrame.jTtoolBarModeloProducto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_productoModeloProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_productoModeloProducto() {
		return this.resaltarid_tipo_productoModeloProducto;
	}

	public void setResaltarid_tipo_productoModeloProducto(Border borderResaltar) {
		this.resaltarid_tipo_productoModeloProducto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_productoModeloProducto() {
		return this.mostrarid_tipo_productoModeloProducto;
	}

	public void setMostrarid_tipo_productoModeloProducto(Boolean mostrarid_tipo_productoModeloProducto) {
		this.mostrarid_tipo_productoModeloProducto= mostrarid_tipo_productoModeloProducto;
	}

	public Boolean getActivarid_tipo_productoModeloProducto() {
		return this.activarid_tipo_productoModeloProducto;
	}

	public void setActivarid_tipo_productoModeloProducto(Boolean activarid_tipo_productoModeloProducto) {
		this.activarid_tipo_productoModeloProducto= activarid_tipo_productoModeloProducto;
	}

	public Boolean getCargarid_tipo_productoModeloProducto() {
		return this.cargarid_tipo_productoModeloProducto;
	}

	public void setCargarid_tipo_productoModeloProducto(Boolean cargarid_tipo_productoModeloProducto) {
		this.cargarid_tipo_productoModeloProducto= cargarid_tipo_productoModeloProducto;
	}

	public Border setResaltarcodigoModeloProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ModeloProductoBeanSwingJInternalFrame modeloproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//modeloproductoBeanSwingJInternalFrame.jTtoolBarModeloProducto.setBorder(borderResaltar);
		
		this.resaltarcodigoModeloProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoModeloProducto() {
		return this.resaltarcodigoModeloProducto;
	}

	public void setResaltarcodigoModeloProducto(Border borderResaltar) {
		this.resaltarcodigoModeloProducto= borderResaltar;
	}

	public Boolean getMostrarcodigoModeloProducto() {
		return this.mostrarcodigoModeloProducto;
	}

	public void setMostrarcodigoModeloProducto(Boolean mostrarcodigoModeloProducto) {
		this.mostrarcodigoModeloProducto= mostrarcodigoModeloProducto;
	}

	public Boolean getActivarcodigoModeloProducto() {
		return this.activarcodigoModeloProducto;
	}

	public void setActivarcodigoModeloProducto(Boolean activarcodigoModeloProducto) {
		this.activarcodigoModeloProducto= activarcodigoModeloProducto;
	}

	public Border setResaltarnombreModeloProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ModeloProductoBeanSwingJInternalFrame modeloproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//modeloproductoBeanSwingJInternalFrame.jTtoolBarModeloProducto.setBorder(borderResaltar);
		
		this.resaltarnombreModeloProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreModeloProducto() {
		return this.resaltarnombreModeloProducto;
	}

	public void setResaltarnombreModeloProducto(Border borderResaltar) {
		this.resaltarnombreModeloProducto= borderResaltar;
	}

	public Boolean getMostrarnombreModeloProducto() {
		return this.mostrarnombreModeloProducto;
	}

	public void setMostrarnombreModeloProducto(Boolean mostrarnombreModeloProducto) {
		this.mostrarnombreModeloProducto= mostrarnombreModeloProducto;
	}

	public Boolean getActivarnombreModeloProducto() {
		return this.activarnombreModeloProducto;
	}

	public void setActivarnombreModeloProducto(Boolean activarnombreModeloProducto) {
		this.activarnombreModeloProducto= activarnombreModeloProducto;
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
		
		
		this.setMostraridModeloProducto(esInicial);
		this.setMostrarid_empresaModeloProducto(esInicial);
		this.setMostrarid_tipo_productoModeloProducto(esInicial);
		this.setMostrarcodigoModeloProducto(esInicial);
		this.setMostrarnombreModeloProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ModeloProductoConstantesFunciones.ID)) {
				this.setMostraridModeloProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModeloProductoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaModeloProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModeloProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setMostrarid_tipo_productoModeloProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModeloProductoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoModeloProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModeloProductoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreModeloProducto(esAsigna);
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
		
		
		this.setActivaridModeloProducto(esInicial);
		this.setActivarid_empresaModeloProducto(esInicial);
		this.setActivarid_tipo_productoModeloProducto(esInicial);
		this.setActivarcodigoModeloProducto(esInicial);
		this.setActivarnombreModeloProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ModeloProductoConstantesFunciones.ID)) {
				this.setActivaridModeloProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModeloProductoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaModeloProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModeloProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setActivarid_tipo_productoModeloProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModeloProductoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoModeloProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModeloProductoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreModeloProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ModeloProductoBeanSwingJInternalFrame modeloproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridModeloProducto(esInicial);
		this.setResaltarid_empresaModeloProducto(esInicial);
		this.setResaltarid_tipo_productoModeloProducto(esInicial);
		this.setResaltarcodigoModeloProducto(esInicial);
		this.setResaltarnombreModeloProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ModeloProductoConstantesFunciones.ID)) {
				this.setResaltaridModeloProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModeloProductoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaModeloProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModeloProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setResaltarid_tipo_productoModeloProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModeloProductoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoModeloProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModeloProductoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreModeloProducto(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarProductoModeloProducto=null;

	public Border getResaltarProductoModeloProducto() {
		return this.resaltarProductoModeloProducto;
	}

	public void setResaltarProductoModeloProducto(Border borderResaltarProducto) {
		if(borderResaltarProducto!=null) {
			this.resaltarProductoModeloProducto= borderResaltarProducto;
		}
	}

	public Border setResaltarProductoModeloProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ModeloProductoBeanSwingJInternalFrame modeloproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//modeloproductoBeanSwingJInternalFrame.jTtoolBarModeloProducto.setBorder(borderResaltarProducto);
			
		this.resaltarProductoModeloProducto= borderResaltarProducto;

		 return borderResaltarProducto;
	}



	public Boolean mostrarProductoModeloProducto=true;

	public Boolean getMostrarProductoModeloProducto() {
		return this.mostrarProductoModeloProducto;
	}

	public void setMostrarProductoModeloProducto(Boolean visibilidadResaltarProducto) {
		this.mostrarProductoModeloProducto= visibilidadResaltarProducto;
	}



	public Boolean activarProductoModeloProducto=true;

	public Boolean gethabilitarResaltarProductoModeloProducto() {
		return this.activarProductoModeloProducto;
	}

	public void setActivarProductoModeloProducto(Boolean habilitarResaltarProducto) {
		this.activarProductoModeloProducto= habilitarResaltarProducto;
	}


	public Border resaltarParametroInventarioDefectoModeloProducto=null;

	public Border getResaltarParametroInventarioDefectoModeloProducto() {
		return this.resaltarParametroInventarioDefectoModeloProducto;
	}

	public void setResaltarParametroInventarioDefectoModeloProducto(Border borderResaltarParametroInventarioDefecto) {
		if(borderResaltarParametroInventarioDefecto!=null) {
			this.resaltarParametroInventarioDefectoModeloProducto= borderResaltarParametroInventarioDefecto;
		}
	}

	public Border setResaltarParametroInventarioDefectoModeloProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ModeloProductoBeanSwingJInternalFrame modeloproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroInventarioDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//modeloproductoBeanSwingJInternalFrame.jTtoolBarModeloProducto.setBorder(borderResaltarParametroInventarioDefecto);
			
		this.resaltarParametroInventarioDefectoModeloProducto= borderResaltarParametroInventarioDefecto;

		 return borderResaltarParametroInventarioDefecto;
	}



	public Boolean mostrarParametroInventarioDefectoModeloProducto=true;

	public Boolean getMostrarParametroInventarioDefectoModeloProducto() {
		return this.mostrarParametroInventarioDefectoModeloProducto;
	}

	public void setMostrarParametroInventarioDefectoModeloProducto(Boolean visibilidadResaltarParametroInventarioDefecto) {
		this.mostrarParametroInventarioDefectoModeloProducto= visibilidadResaltarParametroInventarioDefecto;
	}



	public Boolean activarParametroInventarioDefectoModeloProducto=true;

	public Boolean gethabilitarResaltarParametroInventarioDefectoModeloProducto() {
		return this.activarParametroInventarioDefectoModeloProducto;
	}

	public void setActivarParametroInventarioDefectoModeloProducto(Boolean habilitarResaltarParametroInventarioDefecto) {
		this.activarParametroInventarioDefectoModeloProducto= habilitarResaltarParametroInventarioDefecto;
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

		this.setMostrarProductoModeloProducto(esInicial);
		this.setMostrarParametroInventarioDefectoModeloProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setMostrarProductoModeloProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setMostrarParametroInventarioDefectoModeloProducto(esAsigna);
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

		this.setActivarProductoModeloProducto(esInicial);
		this.setActivarParametroInventarioDefectoModeloProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setActivarProductoModeloProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setActivarParametroInventarioDefectoModeloProducto(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ModeloProductoBeanSwingJInternalFrame modeloproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarProductoModeloProducto(esInicial);
		this.setResaltarParametroInventarioDefectoModeloProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setResaltarProductoModeloProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setResaltarParametroInventarioDefectoModeloProducto(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoModeloProducto=true;

	public Boolean getMostrarBusquedaPorCodigoModeloProducto() {
		return this.mostrarBusquedaPorCodigoModeloProducto;
	}

	public void setMostrarBusquedaPorCodigoModeloProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoModeloProducto= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreModeloProducto=true;

	public Boolean getMostrarBusquedaPorNombreModeloProducto() {
		return this.mostrarBusquedaPorNombreModeloProducto;
	}

	public void setMostrarBusquedaPorNombreModeloProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreModeloProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaModeloProducto=true;

	public Boolean getMostrarFK_IdEmpresaModeloProducto() {
		return this.mostrarFK_IdEmpresaModeloProducto;
	}

	public void setMostrarFK_IdEmpresaModeloProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaModeloProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProductoModeloProducto=true;

	public Boolean getMostrarFK_IdTipoProductoModeloProducto() {
		return this.mostrarFK_IdTipoProductoModeloProducto;
	}

	public void setMostrarFK_IdTipoProductoModeloProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProductoModeloProducto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoModeloProducto=true;

	public Boolean getActivarBusquedaPorCodigoModeloProducto() {
		return this.activarBusquedaPorCodigoModeloProducto;
	}

	public void setActivarBusquedaPorCodigoModeloProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoModeloProducto= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreModeloProducto=true;

	public Boolean getActivarBusquedaPorNombreModeloProducto() {
		return this.activarBusquedaPorNombreModeloProducto;
	}

	public void setActivarBusquedaPorNombreModeloProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreModeloProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaModeloProducto=true;

	public Boolean getActivarFK_IdEmpresaModeloProducto() {
		return this.activarFK_IdEmpresaModeloProducto;
	}

	public void setActivarFK_IdEmpresaModeloProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaModeloProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProductoModeloProducto=true;

	public Boolean getActivarFK_IdTipoProductoModeloProducto() {
		return this.activarFK_IdTipoProductoModeloProducto;
	}

	public void setActivarFK_IdTipoProductoModeloProducto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProductoModeloProducto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoModeloProducto=null;

	public Border getResaltarBusquedaPorCodigoModeloProducto() {
		return this.resaltarBusquedaPorCodigoModeloProducto;
	}

	public void setResaltarBusquedaPorCodigoModeloProducto(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoModeloProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoModeloProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ModeloProductoBeanSwingJInternalFrame modeloproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoModeloProducto= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreModeloProducto=null;

	public Border getResaltarBusquedaPorNombreModeloProducto() {
		return this.resaltarBusquedaPorNombreModeloProducto;
	}

	public void setResaltarBusquedaPorNombreModeloProducto(Border borderResaltar) {
		this.resaltarBusquedaPorNombreModeloProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreModeloProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ModeloProductoBeanSwingJInternalFrame modeloproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreModeloProducto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaModeloProducto=null;

	public Border getResaltarFK_IdEmpresaModeloProducto() {
		return this.resaltarFK_IdEmpresaModeloProducto;
	}

	public void setResaltarFK_IdEmpresaModeloProducto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaModeloProducto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaModeloProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ModeloProductoBeanSwingJInternalFrame modeloproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaModeloProducto= borderResaltar;
	}

	public Border resaltarFK_IdTipoProductoModeloProducto=null;

	public Border getResaltarFK_IdTipoProductoModeloProducto() {
		return this.resaltarFK_IdTipoProductoModeloProducto;
	}

	public void setResaltarFK_IdTipoProductoModeloProducto(Border borderResaltar) {
		this.resaltarFK_IdTipoProductoModeloProducto= borderResaltar;
	}

	public void setResaltarFK_IdTipoProductoModeloProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ModeloProductoBeanSwingJInternalFrame modeloproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProductoModeloProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}