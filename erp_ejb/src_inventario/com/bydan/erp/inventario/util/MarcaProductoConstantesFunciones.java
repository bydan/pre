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


import com.bydan.erp.inventario.util.MarcaProductoConstantesFunciones;
import com.bydan.erp.inventario.util.MarcaProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.MarcaProductoParameterGeneral;

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
final public class MarcaProductoConstantesFunciones extends MarcaProductoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="MarcaProducto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="MarcaProducto"+MarcaProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="MarcaProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="MarcaProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=MarcaProductoConstantesFunciones.SCHEMA+"_"+MarcaProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/MarcaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=MarcaProductoConstantesFunciones.SCHEMA+"_"+MarcaProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=MarcaProductoConstantesFunciones.SCHEMA+"_"+MarcaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/MarcaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=MarcaProductoConstantesFunciones.SCHEMA+"_"+MarcaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MarcaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MarcaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MarcaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MarcaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MarcaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MarcaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=MarcaProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+MarcaProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=MarcaProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+MarcaProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Marca Productos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Marca Producto";
	public static final String SCLASSWEBTITULO_LOWER="Marca Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="MarcaProducto";
	public static final String OBJECTNAME="marcaproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="marca_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select marcaproducto from "+MarcaProductoConstantesFunciones.SPERSISTENCENAME+" marcaproducto";
	public static String QUERYSELECTNATIVE="select "+MarcaProductoConstantesFunciones.SCHEMA+"."+MarcaProductoConstantesFunciones.TABLENAME+".id,"+MarcaProductoConstantesFunciones.SCHEMA+"."+MarcaProductoConstantesFunciones.TABLENAME+".version_row,"+MarcaProductoConstantesFunciones.SCHEMA+"."+MarcaProductoConstantesFunciones.TABLENAME+".id_empresa,"+MarcaProductoConstantesFunciones.SCHEMA+"."+MarcaProductoConstantesFunciones.TABLENAME+".id_tipo_producto,"+MarcaProductoConstantesFunciones.SCHEMA+"."+MarcaProductoConstantesFunciones.TABLENAME+".codigo,"+MarcaProductoConstantesFunciones.SCHEMA+"."+MarcaProductoConstantesFunciones.TABLENAME+".nombre from "+MarcaProductoConstantesFunciones.SCHEMA+"."+MarcaProductoConstantesFunciones.TABLENAME;//+" as "+MarcaProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected MarcaProductoConstantesFuncionesAdditional marcaproductoConstantesFuncionesAdditional=null;
	
	public MarcaProductoConstantesFuncionesAdditional getMarcaProductoConstantesFuncionesAdditional() {
		return this.marcaproductoConstantesFuncionesAdditional;
	}
	
	public void setMarcaProductoConstantesFuncionesAdditional(MarcaProductoConstantesFuncionesAdditional marcaproductoConstantesFuncionesAdditional) {
		try {
			this.marcaproductoConstantesFuncionesAdditional=marcaproductoConstantesFuncionesAdditional;
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
	
	public static String getMarcaProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(MarcaProductoConstantesFunciones.IDEMPRESA)) {sLabelColumna=MarcaProductoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(MarcaProductoConstantesFunciones.IDTIPOPRODUCTO)) {sLabelColumna=MarcaProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO;}
		if(sNombreColumna.equals(MarcaProductoConstantesFunciones.CODIGO)) {sLabelColumna=MarcaProductoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(MarcaProductoConstantesFunciones.NOMBRE)) {sLabelColumna=MarcaProductoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getMarcaProductoDescripcion(MarcaProducto marcaproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(marcaproducto !=null/* && marcaproducto.getId()!=0*/) {
			sDescripcion=marcaproducto.getcodigo();//marcaproductomarcaproducto.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getMarcaProductoDescripcionDetallado(MarcaProducto marcaproducto) {
		String sDescripcion="";
			
		sDescripcion+=MarcaProductoConstantesFunciones.ID+"=";
		sDescripcion+=marcaproducto.getId().toString()+",";
		sDescripcion+=MarcaProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=marcaproducto.getVersionRow().toString()+",";
		sDescripcion+=MarcaProductoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=marcaproducto.getid_empresa().toString()+",";
		sDescripcion+=MarcaProductoConstantesFunciones.IDTIPOPRODUCTO+"=";
		sDescripcion+=marcaproducto.getid_tipo_producto().toString()+",";
		sDescripcion+=MarcaProductoConstantesFunciones.CODIGO+"=";
		sDescripcion+=marcaproducto.getcodigo()+",";
		sDescripcion+=MarcaProductoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=marcaproducto.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setMarcaProductoDescripcion(MarcaProducto marcaproducto,String sValor) throws Exception {			
		if(marcaproducto !=null) {
			marcaproducto.setcodigo(sValor);;//marcaproductomarcaproducto.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosMarcaProducto(MarcaProducto marcaproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		marcaproducto.setcodigo(marcaproducto.getcodigo().trim());
		marcaproducto.setnombre(marcaproducto.getnombre().trim());
	}
	
	public static void quitarEspaciosMarcaProductos(List<MarcaProducto> marcaproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(MarcaProducto marcaproducto: marcaproductos) {
			marcaproducto.setcodigo(marcaproducto.getcodigo().trim());
			marcaproducto.setnombre(marcaproducto.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMarcaProducto(MarcaProducto marcaproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && marcaproducto.getConCambioAuxiliar()) {
			marcaproducto.setIsDeleted(marcaproducto.getIsDeletedAuxiliar());	
			marcaproducto.setIsNew(marcaproducto.getIsNewAuxiliar());	
			marcaproducto.setIsChanged(marcaproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			marcaproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			marcaproducto.setIsDeletedAuxiliar(false);	
			marcaproducto.setIsNewAuxiliar(false);	
			marcaproducto.setIsChangedAuxiliar(false);
			
			marcaproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMarcaProductos(List<MarcaProducto> marcaproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(MarcaProducto marcaproducto : marcaproductos) {
			if(conAsignarBase && marcaproducto.getConCambioAuxiliar()) {
				marcaproducto.setIsDeleted(marcaproducto.getIsDeletedAuxiliar());	
				marcaproducto.setIsNew(marcaproducto.getIsNewAuxiliar());	
				marcaproducto.setIsChanged(marcaproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				marcaproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				marcaproducto.setIsDeletedAuxiliar(false);	
				marcaproducto.setIsNewAuxiliar(false);	
				marcaproducto.setIsChangedAuxiliar(false);
				
				marcaproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresMarcaProducto(MarcaProducto marcaproducto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresMarcaProductos(List<MarcaProducto> marcaproductos,Boolean conEnteros) throws Exception  {
		
		for(MarcaProducto marcaproducto: marcaproductos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaMarcaProducto(List<MarcaProducto> marcaproductos,MarcaProducto marcaproductoAux) throws Exception  {
		MarcaProductoConstantesFunciones.InicializarValoresMarcaProducto(marcaproductoAux,true);
		
		for(MarcaProducto marcaproducto: marcaproductos) {
			if(marcaproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMarcaProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=MarcaProductoConstantesFunciones.getArrayColumnasGlobalesMarcaProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesMarcaProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MarcaProductoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MarcaProductoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoMarcaProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<MarcaProducto> marcaproductos,MarcaProducto marcaproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(MarcaProducto marcaproductoAux: marcaproductos) {
			if(marcaproductoAux!=null && marcaproducto!=null) {
				if((marcaproductoAux.getId()==null && marcaproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(marcaproductoAux.getId()!=null && marcaproducto.getId()!=null){
					if(marcaproductoAux.getId().equals(marcaproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMarcaProducto(List<MarcaProducto> marcaproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(MarcaProducto marcaproducto: marcaproductos) {			
			if(marcaproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaMarcaProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,MarcaProductoConstantesFunciones.LABEL_ID, MarcaProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MarcaProductoConstantesFunciones.LABEL_VERSIONROW, MarcaProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MarcaProductoConstantesFunciones.LABEL_IDEMPRESA, MarcaProductoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MarcaProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO, MarcaProductoConstantesFunciones.IDTIPOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MarcaProductoConstantesFunciones.LABEL_CODIGO, MarcaProductoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MarcaProductoConstantesFunciones.LABEL_NOMBRE, MarcaProductoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasMarcaProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=MarcaProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MarcaProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MarcaProductoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MarcaProductoConstantesFunciones.IDTIPOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MarcaProductoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MarcaProductoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMarcaProducto() throws Exception  {
		return MarcaProductoConstantesFunciones.getTiposSeleccionarMarcaProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMarcaProducto(Boolean conFk) throws Exception  {
		return MarcaProductoConstantesFunciones.getTiposSeleccionarMarcaProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMarcaProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MarcaProductoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(MarcaProductoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MarcaProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);
			reporte.setsDescripcion(MarcaProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MarcaProductoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(MarcaProductoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MarcaProductoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(MarcaProductoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesMarcaProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesMarcaProducto(MarcaProducto marcaproductoAux) throws Exception {
		
			marcaproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(marcaproductoAux.getEmpresa()));
			marcaproductoAux.settipoproducto_descripcion(TipoProductoConstantesFunciones.getTipoProductoDescripcion(marcaproductoAux.getTipoProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesMarcaProducto(List<MarcaProducto> marcaproductosTemp) throws Exception {
		for(MarcaProducto marcaproductoAux:marcaproductosTemp) {
			
			marcaproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(marcaproductoAux.getEmpresa()));
			marcaproductoAux.settipoproducto_descripcion(TipoProductoConstantesFunciones.getTipoProductoDescripcion(marcaproductoAux.getTipoProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfMarcaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfMarcaProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfMarcaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return MarcaProductoConstantesFunciones.getClassesRelationshipsOfMarcaProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMarcaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMarcaProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return MarcaProductoConstantesFunciones.getClassesRelationshipsFromStringsOfMarcaProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMarcaProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(MarcaProducto marcaproducto,List<MarcaProducto> marcaproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			MarcaProducto marcaproductoEncontrado=null;
			
			for(MarcaProducto marcaproductoLocal:marcaproductos) {
				if(marcaproductoLocal.getId().equals(marcaproducto.getId())) {
					marcaproductoEncontrado=marcaproductoLocal;
					
					marcaproductoLocal.setIsChanged(marcaproducto.getIsChanged());
					marcaproductoLocal.setIsNew(marcaproducto.getIsNew());
					marcaproductoLocal.setIsDeleted(marcaproducto.getIsDeleted());
					
					marcaproductoLocal.setGeneralEntityOriginal(marcaproducto.getGeneralEntityOriginal());
					
					marcaproductoLocal.setId(marcaproducto.getId());	
					marcaproductoLocal.setVersionRow(marcaproducto.getVersionRow());	
					marcaproductoLocal.setid_empresa(marcaproducto.getid_empresa());	
					marcaproductoLocal.setid_tipo_producto(marcaproducto.getid_tipo_producto());	
					marcaproductoLocal.setcodigo(marcaproducto.getcodigo());	
					marcaproductoLocal.setnombre(marcaproducto.getnombre());	
					
					
					marcaproductoLocal.setProductos(marcaproducto.getProductos());
					marcaproductoLocal.setParametroInventarioDefectos(marcaproducto.getParametroInventarioDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!marcaproducto.getIsDeleted()) {
				if(!existe) {
					marcaproductos.add(marcaproducto);
				}
			} else {
				if(marcaproductoEncontrado!=null && permiteQuitar)  {
					marcaproductos.remove(marcaproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(MarcaProducto marcaproducto,List<MarcaProducto> marcaproductos) throws Exception {
		try	{			
			for(MarcaProducto marcaproductoLocal:marcaproductos) {
				if(marcaproductoLocal.getId().equals(marcaproducto.getId())) {
					marcaproductoLocal.setIsSelected(marcaproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesMarcaProducto(List<MarcaProducto> marcaproductosAux) throws Exception {
		//this.marcaproductosAux=marcaproductosAux;
		
		for(MarcaProducto marcaproductoAux:marcaproductosAux) {
			if(marcaproductoAux.getIsChanged()) {
				marcaproductoAux.setIsChanged(false);
			}		
			
			if(marcaproductoAux.getIsNew()) {
				marcaproductoAux.setIsNew(false);
			}	
			
			if(marcaproductoAux.getIsDeleted()) {
				marcaproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesMarcaProducto(MarcaProducto marcaproductoAux) throws Exception {
		//this.marcaproductoAux=marcaproductoAux;
		
			if(marcaproductoAux.getIsChanged()) {
				marcaproductoAux.setIsChanged(false);
			}		
			
			if(marcaproductoAux.getIsNew()) {
				marcaproductoAux.setIsNew(false);
			}	
			
			if(marcaproductoAux.getIsDeleted()) {
				marcaproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(MarcaProducto marcaproductoAsignar,MarcaProducto marcaproducto) throws Exception {
		marcaproductoAsignar.setId(marcaproducto.getId());	
		marcaproductoAsignar.setVersionRow(marcaproducto.getVersionRow());	
		marcaproductoAsignar.setid_empresa(marcaproducto.getid_empresa());
		marcaproductoAsignar.setempresa_descripcion(marcaproducto.getempresa_descripcion());	
		marcaproductoAsignar.setid_tipo_producto(marcaproducto.getid_tipo_producto());
		marcaproductoAsignar.settipoproducto_descripcion(marcaproducto.gettipoproducto_descripcion());	
		marcaproductoAsignar.setcodigo(marcaproducto.getcodigo());	
		marcaproductoAsignar.setnombre(marcaproducto.getnombre());	
	}
	
	public static void inicializarMarcaProducto(MarcaProducto marcaproducto) throws Exception {
		try {
				marcaproducto.setId(0L);	
					
				marcaproducto.setid_empresa(-1L);	
				marcaproducto.setid_tipo_producto(-1L);	
				marcaproducto.setcodigo("");	
				marcaproducto.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderMarcaProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(MarcaProductoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MarcaProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MarcaProductoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MarcaProductoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataMarcaProducto(String sTipo,Row row,Workbook workbook,MarcaProducto marcaproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(marcaproducto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(marcaproducto.gettipoproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(marcaproducto.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(marcaproducto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryMarcaProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryMarcaProducto() {
		return this.sFinalQueryMarcaProducto;
	}
	
	public void setsFinalQueryMarcaProducto(String sFinalQueryMarcaProducto) {
		this.sFinalQueryMarcaProducto= sFinalQueryMarcaProducto;
	}
	
	public Border resaltarSeleccionarMarcaProducto=null;
	
	public Border setResaltarSeleccionarMarcaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MarcaProductoBeanSwingJInternalFrame marcaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//marcaproductoBeanSwingJInternalFrame.jTtoolBarMarcaProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarMarcaProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarMarcaProducto() {
		return this.resaltarSeleccionarMarcaProducto;
	}
	
	public void setResaltarSeleccionarMarcaProducto(Border borderResaltarSeleccionarMarcaProducto) {
		this.resaltarSeleccionarMarcaProducto= borderResaltarSeleccionarMarcaProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridMarcaProducto=null;
	public Boolean mostraridMarcaProducto=true;
	public Boolean activaridMarcaProducto=true;

	public Border resaltarid_empresaMarcaProducto=null;
	public Boolean mostrarid_empresaMarcaProducto=true;
	public Boolean activarid_empresaMarcaProducto=true;
	public Boolean cargarid_empresaMarcaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaMarcaProducto=false;//ConEventDepend=true

	public Border resaltarid_tipo_productoMarcaProducto=null;
	public Boolean mostrarid_tipo_productoMarcaProducto=true;
	public Boolean activarid_tipo_productoMarcaProducto=true;
	public Boolean cargarid_tipo_productoMarcaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_productoMarcaProducto=false;//ConEventDepend=true

	public Border resaltarcodigoMarcaProducto=null;
	public Boolean mostrarcodigoMarcaProducto=true;
	public Boolean activarcodigoMarcaProducto=true;

	public Border resaltarnombreMarcaProducto=null;
	public Boolean mostrarnombreMarcaProducto=true;
	public Boolean activarnombreMarcaProducto=true;

	
	

	public Border setResaltaridMarcaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MarcaProductoBeanSwingJInternalFrame marcaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//marcaproductoBeanSwingJInternalFrame.jTtoolBarMarcaProducto.setBorder(borderResaltar);
		
		this.resaltaridMarcaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridMarcaProducto() {
		return this.resaltaridMarcaProducto;
	}

	public void setResaltaridMarcaProducto(Border borderResaltar) {
		this.resaltaridMarcaProducto= borderResaltar;
	}

	public Boolean getMostraridMarcaProducto() {
		return this.mostraridMarcaProducto;
	}

	public void setMostraridMarcaProducto(Boolean mostraridMarcaProducto) {
		this.mostraridMarcaProducto= mostraridMarcaProducto;
	}

	public Boolean getActivaridMarcaProducto() {
		return this.activaridMarcaProducto;
	}

	public void setActivaridMarcaProducto(Boolean activaridMarcaProducto) {
		this.activaridMarcaProducto= activaridMarcaProducto;
	}

	public Border setResaltarid_empresaMarcaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MarcaProductoBeanSwingJInternalFrame marcaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//marcaproductoBeanSwingJInternalFrame.jTtoolBarMarcaProducto.setBorder(borderResaltar);
		
		this.resaltarid_empresaMarcaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaMarcaProducto() {
		return this.resaltarid_empresaMarcaProducto;
	}

	public void setResaltarid_empresaMarcaProducto(Border borderResaltar) {
		this.resaltarid_empresaMarcaProducto= borderResaltar;
	}

	public Boolean getMostrarid_empresaMarcaProducto() {
		return this.mostrarid_empresaMarcaProducto;
	}

	public void setMostrarid_empresaMarcaProducto(Boolean mostrarid_empresaMarcaProducto) {
		this.mostrarid_empresaMarcaProducto= mostrarid_empresaMarcaProducto;
	}

	public Boolean getActivarid_empresaMarcaProducto() {
		return this.activarid_empresaMarcaProducto;
	}

	public void setActivarid_empresaMarcaProducto(Boolean activarid_empresaMarcaProducto) {
		this.activarid_empresaMarcaProducto= activarid_empresaMarcaProducto;
	}

	public Boolean getCargarid_empresaMarcaProducto() {
		return this.cargarid_empresaMarcaProducto;
	}

	public void setCargarid_empresaMarcaProducto(Boolean cargarid_empresaMarcaProducto) {
		this.cargarid_empresaMarcaProducto= cargarid_empresaMarcaProducto;
	}

	public Border setResaltarid_tipo_productoMarcaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MarcaProductoBeanSwingJInternalFrame marcaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//marcaproductoBeanSwingJInternalFrame.jTtoolBarMarcaProducto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_productoMarcaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_productoMarcaProducto() {
		return this.resaltarid_tipo_productoMarcaProducto;
	}

	public void setResaltarid_tipo_productoMarcaProducto(Border borderResaltar) {
		this.resaltarid_tipo_productoMarcaProducto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_productoMarcaProducto() {
		return this.mostrarid_tipo_productoMarcaProducto;
	}

	public void setMostrarid_tipo_productoMarcaProducto(Boolean mostrarid_tipo_productoMarcaProducto) {
		this.mostrarid_tipo_productoMarcaProducto= mostrarid_tipo_productoMarcaProducto;
	}

	public Boolean getActivarid_tipo_productoMarcaProducto() {
		return this.activarid_tipo_productoMarcaProducto;
	}

	public void setActivarid_tipo_productoMarcaProducto(Boolean activarid_tipo_productoMarcaProducto) {
		this.activarid_tipo_productoMarcaProducto= activarid_tipo_productoMarcaProducto;
	}

	public Boolean getCargarid_tipo_productoMarcaProducto() {
		return this.cargarid_tipo_productoMarcaProducto;
	}

	public void setCargarid_tipo_productoMarcaProducto(Boolean cargarid_tipo_productoMarcaProducto) {
		this.cargarid_tipo_productoMarcaProducto= cargarid_tipo_productoMarcaProducto;
	}

	public Border setResaltarcodigoMarcaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MarcaProductoBeanSwingJInternalFrame marcaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//marcaproductoBeanSwingJInternalFrame.jTtoolBarMarcaProducto.setBorder(borderResaltar);
		
		this.resaltarcodigoMarcaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoMarcaProducto() {
		return this.resaltarcodigoMarcaProducto;
	}

	public void setResaltarcodigoMarcaProducto(Border borderResaltar) {
		this.resaltarcodigoMarcaProducto= borderResaltar;
	}

	public Boolean getMostrarcodigoMarcaProducto() {
		return this.mostrarcodigoMarcaProducto;
	}

	public void setMostrarcodigoMarcaProducto(Boolean mostrarcodigoMarcaProducto) {
		this.mostrarcodigoMarcaProducto= mostrarcodigoMarcaProducto;
	}

	public Boolean getActivarcodigoMarcaProducto() {
		return this.activarcodigoMarcaProducto;
	}

	public void setActivarcodigoMarcaProducto(Boolean activarcodigoMarcaProducto) {
		this.activarcodigoMarcaProducto= activarcodigoMarcaProducto;
	}

	public Border setResaltarnombreMarcaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MarcaProductoBeanSwingJInternalFrame marcaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//marcaproductoBeanSwingJInternalFrame.jTtoolBarMarcaProducto.setBorder(borderResaltar);
		
		this.resaltarnombreMarcaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreMarcaProducto() {
		return this.resaltarnombreMarcaProducto;
	}

	public void setResaltarnombreMarcaProducto(Border borderResaltar) {
		this.resaltarnombreMarcaProducto= borderResaltar;
	}

	public Boolean getMostrarnombreMarcaProducto() {
		return this.mostrarnombreMarcaProducto;
	}

	public void setMostrarnombreMarcaProducto(Boolean mostrarnombreMarcaProducto) {
		this.mostrarnombreMarcaProducto= mostrarnombreMarcaProducto;
	}

	public Boolean getActivarnombreMarcaProducto() {
		return this.activarnombreMarcaProducto;
	}

	public void setActivarnombreMarcaProducto(Boolean activarnombreMarcaProducto) {
		this.activarnombreMarcaProducto= activarnombreMarcaProducto;
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
		
		
		this.setMostraridMarcaProducto(esInicial);
		this.setMostrarid_empresaMarcaProducto(esInicial);
		this.setMostrarid_tipo_productoMarcaProducto(esInicial);
		this.setMostrarcodigoMarcaProducto(esInicial);
		this.setMostrarnombreMarcaProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MarcaProductoConstantesFunciones.ID)) {
				this.setMostraridMarcaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MarcaProductoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaMarcaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MarcaProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setMostrarid_tipo_productoMarcaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MarcaProductoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoMarcaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MarcaProductoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreMarcaProducto(esAsigna);
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
		
		
		this.setActivaridMarcaProducto(esInicial);
		this.setActivarid_empresaMarcaProducto(esInicial);
		this.setActivarid_tipo_productoMarcaProducto(esInicial);
		this.setActivarcodigoMarcaProducto(esInicial);
		this.setActivarnombreMarcaProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MarcaProductoConstantesFunciones.ID)) {
				this.setActivaridMarcaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MarcaProductoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaMarcaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MarcaProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setActivarid_tipo_productoMarcaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MarcaProductoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoMarcaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MarcaProductoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreMarcaProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,MarcaProductoBeanSwingJInternalFrame marcaproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridMarcaProducto(esInicial);
		this.setResaltarid_empresaMarcaProducto(esInicial);
		this.setResaltarid_tipo_productoMarcaProducto(esInicial);
		this.setResaltarcodigoMarcaProducto(esInicial);
		this.setResaltarnombreMarcaProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MarcaProductoConstantesFunciones.ID)) {
				this.setResaltaridMarcaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MarcaProductoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaMarcaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MarcaProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setResaltarid_tipo_productoMarcaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MarcaProductoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoMarcaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MarcaProductoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreMarcaProducto(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarProductoMarcaProducto=null;

	public Border getResaltarProductoMarcaProducto() {
		return this.resaltarProductoMarcaProducto;
	}

	public void setResaltarProductoMarcaProducto(Border borderResaltarProducto) {
		if(borderResaltarProducto!=null) {
			this.resaltarProductoMarcaProducto= borderResaltarProducto;
		}
	}

	public Border setResaltarProductoMarcaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MarcaProductoBeanSwingJInternalFrame marcaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//marcaproductoBeanSwingJInternalFrame.jTtoolBarMarcaProducto.setBorder(borderResaltarProducto);
			
		this.resaltarProductoMarcaProducto= borderResaltarProducto;

		 return borderResaltarProducto;
	}



	public Boolean mostrarProductoMarcaProducto=true;

	public Boolean getMostrarProductoMarcaProducto() {
		return this.mostrarProductoMarcaProducto;
	}

	public void setMostrarProductoMarcaProducto(Boolean visibilidadResaltarProducto) {
		this.mostrarProductoMarcaProducto= visibilidadResaltarProducto;
	}



	public Boolean activarProductoMarcaProducto=true;

	public Boolean gethabilitarResaltarProductoMarcaProducto() {
		return this.activarProductoMarcaProducto;
	}

	public void setActivarProductoMarcaProducto(Boolean habilitarResaltarProducto) {
		this.activarProductoMarcaProducto= habilitarResaltarProducto;
	}


	public Border resaltarParametroInventarioDefectoMarcaProducto=null;

	public Border getResaltarParametroInventarioDefectoMarcaProducto() {
		return this.resaltarParametroInventarioDefectoMarcaProducto;
	}

	public void setResaltarParametroInventarioDefectoMarcaProducto(Border borderResaltarParametroInventarioDefecto) {
		if(borderResaltarParametroInventarioDefecto!=null) {
			this.resaltarParametroInventarioDefectoMarcaProducto= borderResaltarParametroInventarioDefecto;
		}
	}

	public Border setResaltarParametroInventarioDefectoMarcaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MarcaProductoBeanSwingJInternalFrame marcaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroInventarioDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//marcaproductoBeanSwingJInternalFrame.jTtoolBarMarcaProducto.setBorder(borderResaltarParametroInventarioDefecto);
			
		this.resaltarParametroInventarioDefectoMarcaProducto= borderResaltarParametroInventarioDefecto;

		 return borderResaltarParametroInventarioDefecto;
	}



	public Boolean mostrarParametroInventarioDefectoMarcaProducto=true;

	public Boolean getMostrarParametroInventarioDefectoMarcaProducto() {
		return this.mostrarParametroInventarioDefectoMarcaProducto;
	}

	public void setMostrarParametroInventarioDefectoMarcaProducto(Boolean visibilidadResaltarParametroInventarioDefecto) {
		this.mostrarParametroInventarioDefectoMarcaProducto= visibilidadResaltarParametroInventarioDefecto;
	}



	public Boolean activarParametroInventarioDefectoMarcaProducto=true;

	public Boolean gethabilitarResaltarParametroInventarioDefectoMarcaProducto() {
		return this.activarParametroInventarioDefectoMarcaProducto;
	}

	public void setActivarParametroInventarioDefectoMarcaProducto(Boolean habilitarResaltarParametroInventarioDefecto) {
		this.activarParametroInventarioDefectoMarcaProducto= habilitarResaltarParametroInventarioDefecto;
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

		this.setMostrarProductoMarcaProducto(esInicial);
		this.setMostrarParametroInventarioDefectoMarcaProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setMostrarProductoMarcaProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setMostrarParametroInventarioDefectoMarcaProducto(esAsigna);
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

		this.setActivarProductoMarcaProducto(esInicial);
		this.setActivarParametroInventarioDefectoMarcaProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setActivarProductoMarcaProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setActivarParametroInventarioDefectoMarcaProducto(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,MarcaProductoBeanSwingJInternalFrame marcaproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarProductoMarcaProducto(esInicial);
		this.setResaltarParametroInventarioDefectoMarcaProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setResaltarProductoMarcaProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setResaltarParametroInventarioDefectoMarcaProducto(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoMarcaProducto=true;

	public Boolean getMostrarBusquedaPorCodigoMarcaProducto() {
		return this.mostrarBusquedaPorCodigoMarcaProducto;
	}

	public void setMostrarBusquedaPorCodigoMarcaProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoMarcaProducto= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreMarcaProducto=true;

	public Boolean getMostrarBusquedaPorNombreMarcaProducto() {
		return this.mostrarBusquedaPorNombreMarcaProducto;
	}

	public void setMostrarBusquedaPorNombreMarcaProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreMarcaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaMarcaProducto=true;

	public Boolean getMostrarFK_IdEmpresaMarcaProducto() {
		return this.mostrarFK_IdEmpresaMarcaProducto;
	}

	public void setMostrarFK_IdEmpresaMarcaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaMarcaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProductoMarcaProducto=true;

	public Boolean getMostrarFK_IdTipoProductoMarcaProducto() {
		return this.mostrarFK_IdTipoProductoMarcaProducto;
	}

	public void setMostrarFK_IdTipoProductoMarcaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProductoMarcaProducto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoMarcaProducto=true;

	public Boolean getActivarBusquedaPorCodigoMarcaProducto() {
		return this.activarBusquedaPorCodigoMarcaProducto;
	}

	public void setActivarBusquedaPorCodigoMarcaProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoMarcaProducto= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreMarcaProducto=true;

	public Boolean getActivarBusquedaPorNombreMarcaProducto() {
		return this.activarBusquedaPorNombreMarcaProducto;
	}

	public void setActivarBusquedaPorNombreMarcaProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreMarcaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaMarcaProducto=true;

	public Boolean getActivarFK_IdEmpresaMarcaProducto() {
		return this.activarFK_IdEmpresaMarcaProducto;
	}

	public void setActivarFK_IdEmpresaMarcaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaMarcaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProductoMarcaProducto=true;

	public Boolean getActivarFK_IdTipoProductoMarcaProducto() {
		return this.activarFK_IdTipoProductoMarcaProducto;
	}

	public void setActivarFK_IdTipoProductoMarcaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProductoMarcaProducto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoMarcaProducto=null;

	public Border getResaltarBusquedaPorCodigoMarcaProducto() {
		return this.resaltarBusquedaPorCodigoMarcaProducto;
	}

	public void setResaltarBusquedaPorCodigoMarcaProducto(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoMarcaProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoMarcaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MarcaProductoBeanSwingJInternalFrame marcaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoMarcaProducto= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreMarcaProducto=null;

	public Border getResaltarBusquedaPorNombreMarcaProducto() {
		return this.resaltarBusquedaPorNombreMarcaProducto;
	}

	public void setResaltarBusquedaPorNombreMarcaProducto(Border borderResaltar) {
		this.resaltarBusquedaPorNombreMarcaProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreMarcaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MarcaProductoBeanSwingJInternalFrame marcaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreMarcaProducto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaMarcaProducto=null;

	public Border getResaltarFK_IdEmpresaMarcaProducto() {
		return this.resaltarFK_IdEmpresaMarcaProducto;
	}

	public void setResaltarFK_IdEmpresaMarcaProducto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaMarcaProducto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaMarcaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MarcaProductoBeanSwingJInternalFrame marcaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaMarcaProducto= borderResaltar;
	}

	public Border resaltarFK_IdTipoProductoMarcaProducto=null;

	public Border getResaltarFK_IdTipoProductoMarcaProducto() {
		return this.resaltarFK_IdTipoProductoMarcaProducto;
	}

	public void setResaltarFK_IdTipoProductoMarcaProducto(Border borderResaltar) {
		this.resaltarFK_IdTipoProductoMarcaProducto= borderResaltar;
	}

	public void setResaltarFK_IdTipoProductoMarcaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*MarcaProductoBeanSwingJInternalFrame marcaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProductoMarcaProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}