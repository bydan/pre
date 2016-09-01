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


import com.bydan.erp.inventario.util.TipoProductoConstantesFunciones;
import com.bydan.erp.inventario.util.TipoProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoProductoParameterGeneral;

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
final public class TipoProductoConstantesFunciones extends TipoProductoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoProducto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoProducto"+TipoProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoProductoConstantesFunciones.SCHEMA+"_"+TipoProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoProductoConstantesFunciones.SCHEMA+"_"+TipoProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoProductoConstantesFunciones.SCHEMA+"_"+TipoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoProductoConstantesFunciones.SCHEMA+"_"+TipoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Productos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Producto";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoProducto";
	public static final String OBJECTNAME="tipoproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="tipo_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoproducto from "+TipoProductoConstantesFunciones.SPERSISTENCENAME+" tipoproducto";
	public static String QUERYSELECTNATIVE="select "+TipoProductoConstantesFunciones.SCHEMA+"."+TipoProductoConstantesFunciones.TABLENAME+".id,"+TipoProductoConstantesFunciones.SCHEMA+"."+TipoProductoConstantesFunciones.TABLENAME+".version_row,"+TipoProductoConstantesFunciones.SCHEMA+"."+TipoProductoConstantesFunciones.TABLENAME+".id_empresa,"+TipoProductoConstantesFunciones.SCHEMA+"."+TipoProductoConstantesFunciones.TABLENAME+".codigo,"+TipoProductoConstantesFunciones.SCHEMA+"."+TipoProductoConstantesFunciones.TABLENAME+".nombre,"+TipoProductoConstantesFunciones.SCHEMA+"."+TipoProductoConstantesFunciones.TABLENAME+".descripcion from "+TipoProductoConstantesFunciones.SCHEMA+"."+TipoProductoConstantesFunciones.TABLENAME;//+" as "+TipoProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoProductoConstantesFuncionesAdditional tipoproductoConstantesFuncionesAdditional=null;
	
	public TipoProductoConstantesFuncionesAdditional getTipoProductoConstantesFuncionesAdditional() {
		return this.tipoproductoConstantesFuncionesAdditional;
	}
	
	public void setTipoProductoConstantesFuncionesAdditional(TipoProductoConstantesFuncionesAdditional tipoproductoConstantesFuncionesAdditional) {
		try {
			this.tipoproductoConstantesFuncionesAdditional=tipoproductoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoProductoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoProductoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoProductoConstantesFunciones.CODIGO)) {sLabelColumna=TipoProductoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoProductoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoProductoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoProductoConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoProductoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getTipoProductoDescripcion(TipoProducto tipoproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoproducto !=null/* && tipoproducto.getId()!=0*/) {
			sDescripcion=tipoproducto.getcodigo();//tipoproductotipoproducto.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoProductoDescripcionDetallado(TipoProducto tipoproducto) {
		String sDescripcion="";
			
		sDescripcion+=TipoProductoConstantesFunciones.ID+"=";
		sDescripcion+=tipoproducto.getId().toString()+",";
		sDescripcion+=TipoProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoproducto.getVersionRow().toString()+",";
		sDescripcion+=TipoProductoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoproducto.getid_empresa().toString()+",";
		sDescripcion+=TipoProductoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoproducto.getcodigo()+",";
		sDescripcion+=TipoProductoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoproducto.getnombre()+",";
		sDescripcion+=TipoProductoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tipoproducto.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoProductoDescripcion(TipoProducto tipoproducto,String sValor) throws Exception {			
		if(tipoproducto !=null) {
			tipoproducto.setcodigo(sValor);;//tipoproductotipoproducto.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoProducto(TipoProducto tipoproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoproducto.setcodigo(tipoproducto.getcodigo().trim());
		tipoproducto.setnombre(tipoproducto.getnombre().trim());
		tipoproducto.setdescripcion(tipoproducto.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoProductos(List<TipoProducto> tipoproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoProducto tipoproducto: tipoproductos) {
			tipoproducto.setcodigo(tipoproducto.getcodigo().trim());
			tipoproducto.setnombre(tipoproducto.getnombre().trim());
			tipoproducto.setdescripcion(tipoproducto.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoProducto(TipoProducto tipoproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoproducto.getConCambioAuxiliar()) {
			tipoproducto.setIsDeleted(tipoproducto.getIsDeletedAuxiliar());	
			tipoproducto.setIsNew(tipoproducto.getIsNewAuxiliar());	
			tipoproducto.setIsChanged(tipoproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoproducto.setIsDeletedAuxiliar(false);	
			tipoproducto.setIsNewAuxiliar(false);	
			tipoproducto.setIsChangedAuxiliar(false);
			
			tipoproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoProductos(List<TipoProducto> tipoproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoProducto tipoproducto : tipoproductos) {
			if(conAsignarBase && tipoproducto.getConCambioAuxiliar()) {
				tipoproducto.setIsDeleted(tipoproducto.getIsDeletedAuxiliar());	
				tipoproducto.setIsNew(tipoproducto.getIsNewAuxiliar());	
				tipoproducto.setIsChanged(tipoproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoproducto.setIsDeletedAuxiliar(false);	
				tipoproducto.setIsNewAuxiliar(false);	
				tipoproducto.setIsChangedAuxiliar(false);
				
				tipoproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoProducto(TipoProducto tipoproducto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoProductos(List<TipoProducto> tipoproductos,Boolean conEnteros) throws Exception  {
		
		for(TipoProducto tipoproducto: tipoproductos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoProducto(List<TipoProducto> tipoproductos,TipoProducto tipoproductoAux) throws Exception  {
		TipoProductoConstantesFunciones.InicializarValoresTipoProducto(tipoproductoAux,true);
		
		for(TipoProducto tipoproducto: tipoproductos) {
			if(tipoproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoProductoConstantesFunciones.getArrayColumnasGlobalesTipoProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoProductoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoProductoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoProducto> tipoproductos,TipoProducto tipoproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoProducto tipoproductoAux: tipoproductos) {
			if(tipoproductoAux!=null && tipoproducto!=null) {
				if((tipoproductoAux.getId()==null && tipoproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoproductoAux.getId()!=null && tipoproducto.getId()!=null){
					if(tipoproductoAux.getId().equals(tipoproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoProducto(List<TipoProducto> tipoproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoProducto tipoproducto: tipoproductos) {			
			if(tipoproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoProductoConstantesFunciones.LABEL_ID, TipoProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProductoConstantesFunciones.LABEL_VERSIONROW, TipoProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProductoConstantesFunciones.LABEL_IDEMPRESA, TipoProductoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProductoConstantesFunciones.LABEL_CODIGO, TipoProductoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProductoConstantesFunciones.LABEL_NOMBRE, TipoProductoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProductoConstantesFunciones.LABEL_DESCRIPCION, TipoProductoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProductoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProductoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProductoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProductoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProducto() throws Exception  {
		return TipoProductoConstantesFunciones.getTiposSeleccionarTipoProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProducto(Boolean conFk) throws Exception  {
		return TipoProductoConstantesFunciones.getTiposSeleccionarTipoProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProductoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoProductoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProductoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoProductoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProductoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoProductoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProductoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoProductoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoProducto(TipoProducto tipoproductoAux) throws Exception {
		
			tipoproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoproductoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoProducto(List<TipoProducto> tipoproductosTemp) throws Exception {
		for(TipoProducto tipoproductoAux:tipoproductosTemp) {
			
			tipoproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoproductoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoProductoConstantesFunciones.getClassesRelationshipsOfTipoProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ModeloProducto.class));
				classes.add(new Classe(MaterialProducto.class));
				classes.add(new Classe(MarcaProducto.class));
				classes.add(new Classe(SegmentoProducto.class));
				classes.add(new Classe(ColorProducto.class));
				classes.add(new Classe(EfectoProducto.class));
				classes.add(new Classe(TallaProducto.class));
				classes.add(new Classe(ParametroInventarioDefecto.class));
				classes.add(new Classe(ClaseProducto.class));
				classes.add(new Classe(Producto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ModeloProducto.class)) {
						classes.add(new Classe(ModeloProducto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(MaterialProducto.class)) {
						classes.add(new Classe(MaterialProducto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(MarcaProducto.class)) {
						classes.add(new Classe(MarcaProducto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SegmentoProducto.class)) {
						classes.add(new Classe(SegmentoProducto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ColorProducto.class)) {
						classes.add(new Classe(ColorProducto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EfectoProducto.class)) {
						classes.add(new Classe(EfectoProducto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TallaProducto.class)) {
						classes.add(new Classe(TallaProducto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroInventarioDefecto.class)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ClaseProducto.class)) {
						classes.add(new Classe(ClaseProducto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoProductoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ModeloProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ModeloProducto.class)); continue;
					}

					if(MaterialProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MaterialProducto.class)); continue;
					}

					if(MarcaProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MarcaProducto.class)); continue;
					}

					if(SegmentoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SegmentoProducto.class)); continue;
					}

					if(ColorProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ColorProducto.class)); continue;
					}

					if(EfectoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EfectoProducto.class)); continue;
					}

					if(TallaProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TallaProducto.class)); continue;
					}

					if(ParametroInventarioDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); continue;
					}

					if(ClaseProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ClaseProducto.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ModeloProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ModeloProducto.class)); continue;
					}

					if(MaterialProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MaterialProducto.class)); continue;
					}

					if(MarcaProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MarcaProducto.class)); continue;
					}

					if(SegmentoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SegmentoProducto.class)); continue;
					}

					if(ColorProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ColorProducto.class)); continue;
					}

					if(EfectoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EfectoProducto.class)); continue;
					}

					if(TallaProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TallaProducto.class)); continue;
					}

					if(ParametroInventarioDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); continue;
					}

					if(ClaseProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ClaseProducto.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(TipoProducto tipoproducto,List<TipoProducto> tipoproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoProducto tipoproductoEncontrado=null;
			
			for(TipoProducto tipoproductoLocal:tipoproductos) {
				if(tipoproductoLocal.getId().equals(tipoproducto.getId())) {
					tipoproductoEncontrado=tipoproductoLocal;
					
					tipoproductoLocal.setIsChanged(tipoproducto.getIsChanged());
					tipoproductoLocal.setIsNew(tipoproducto.getIsNew());
					tipoproductoLocal.setIsDeleted(tipoproducto.getIsDeleted());
					
					tipoproductoLocal.setGeneralEntityOriginal(tipoproducto.getGeneralEntityOriginal());
					
					tipoproductoLocal.setId(tipoproducto.getId());	
					tipoproductoLocal.setVersionRow(tipoproducto.getVersionRow());	
					tipoproductoLocal.setid_empresa(tipoproducto.getid_empresa());	
					tipoproductoLocal.setcodigo(tipoproducto.getcodigo());	
					tipoproductoLocal.setnombre(tipoproducto.getnombre());	
					tipoproductoLocal.setdescripcion(tipoproducto.getdescripcion());	
					
					
					tipoproductoLocal.setModeloProductos(tipoproducto.getModeloProductos());
					tipoproductoLocal.setMaterialProductos(tipoproducto.getMaterialProductos());
					tipoproductoLocal.setMarcaProductos(tipoproducto.getMarcaProductos());
					tipoproductoLocal.setSegmentoProductos(tipoproducto.getSegmentoProductos());
					tipoproductoLocal.setColorProductos(tipoproducto.getColorProductos());
					tipoproductoLocal.setEfectoProductos(tipoproducto.getEfectoProductos());
					tipoproductoLocal.setTallaProductos(tipoproducto.getTallaProductos());
					tipoproductoLocal.setParametroInventarioDefectos(tipoproducto.getParametroInventarioDefectos());
					tipoproductoLocal.setClaseProductos(tipoproducto.getClaseProductos());
					tipoproductoLocal.setProductos(tipoproducto.getProductos());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoproducto.getIsDeleted()) {
				if(!existe) {
					tipoproductos.add(tipoproducto);
				}
			} else {
				if(tipoproductoEncontrado!=null && permiteQuitar)  {
					tipoproductos.remove(tipoproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoProducto tipoproducto,List<TipoProducto> tipoproductos) throws Exception {
		try	{			
			for(TipoProducto tipoproductoLocal:tipoproductos) {
				if(tipoproductoLocal.getId().equals(tipoproducto.getId())) {
					tipoproductoLocal.setIsSelected(tipoproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoProducto(List<TipoProducto> tipoproductosAux) throws Exception {
		//this.tipoproductosAux=tipoproductosAux;
		
		for(TipoProducto tipoproductoAux:tipoproductosAux) {
			if(tipoproductoAux.getIsChanged()) {
				tipoproductoAux.setIsChanged(false);
			}		
			
			if(tipoproductoAux.getIsNew()) {
				tipoproductoAux.setIsNew(false);
			}	
			
			if(tipoproductoAux.getIsDeleted()) {
				tipoproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoProducto(TipoProducto tipoproductoAux) throws Exception {
		//this.tipoproductoAux=tipoproductoAux;
		
			if(tipoproductoAux.getIsChanged()) {
				tipoproductoAux.setIsChanged(false);
			}		
			
			if(tipoproductoAux.getIsNew()) {
				tipoproductoAux.setIsNew(false);
			}	
			
			if(tipoproductoAux.getIsDeleted()) {
				tipoproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoProducto tipoproductoAsignar,TipoProducto tipoproducto) throws Exception {
		tipoproductoAsignar.setId(tipoproducto.getId());	
		tipoproductoAsignar.setVersionRow(tipoproducto.getVersionRow());	
		tipoproductoAsignar.setid_empresa(tipoproducto.getid_empresa());
		tipoproductoAsignar.setempresa_descripcion(tipoproducto.getempresa_descripcion());	
		tipoproductoAsignar.setcodigo(tipoproducto.getcodigo());	
		tipoproductoAsignar.setnombre(tipoproducto.getnombre());	
		tipoproductoAsignar.setdescripcion(tipoproducto.getdescripcion());	
	}
	
	public static void inicializarTipoProducto(TipoProducto tipoproducto) throws Exception {
		try {
				tipoproducto.setId(0L);	
					
				tipoproducto.setid_empresa(-1L);	
				tipoproducto.setcodigo("");	
				tipoproducto.setnombre("");	
				tipoproducto.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProductoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProductoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProductoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProductoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoProducto(String sTipo,Row row,Workbook workbook,TipoProducto tipoproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoproducto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoproducto.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoproducto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoproducto.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoProducto() {
		return this.sFinalQueryTipoProducto;
	}
	
	public void setsFinalQueryTipoProducto(String sFinalQueryTipoProducto) {
		this.sFinalQueryTipoProducto= sFinalQueryTipoProducto;
	}
	
	public Border resaltarSeleccionarTipoProducto=null;
	
	public Border setResaltarSeleccionarTipoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoBeanSwingJInternalFrame tipoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoproductoBeanSwingJInternalFrame.jTtoolBarTipoProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoProducto() {
		return this.resaltarSeleccionarTipoProducto;
	}
	
	public void setResaltarSeleccionarTipoProducto(Border borderResaltarSeleccionarTipoProducto) {
		this.resaltarSeleccionarTipoProducto= borderResaltarSeleccionarTipoProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoProducto=null;
	public Boolean mostraridTipoProducto=true;
	public Boolean activaridTipoProducto=true;

	public Border resaltarid_empresaTipoProducto=null;
	public Boolean mostrarid_empresaTipoProducto=true;
	public Boolean activarid_empresaTipoProducto=true;
	public Boolean cargarid_empresaTipoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoProducto=false;//ConEventDepend=true

	public Border resaltarcodigoTipoProducto=null;
	public Boolean mostrarcodigoTipoProducto=true;
	public Boolean activarcodigoTipoProducto=true;

	public Border resaltarnombreTipoProducto=null;
	public Boolean mostrarnombreTipoProducto=true;
	public Boolean activarnombreTipoProducto=true;

	public Border resaltardescripcionTipoProducto=null;
	public Boolean mostrardescripcionTipoProducto=true;
	public Boolean activardescripcionTipoProducto=true;

	
	

	public Border setResaltaridTipoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoBeanSwingJInternalFrame tipoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoproductoBeanSwingJInternalFrame.jTtoolBarTipoProducto.setBorder(borderResaltar);
		
		this.resaltaridTipoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoProducto() {
		return this.resaltaridTipoProducto;
	}

	public void setResaltaridTipoProducto(Border borderResaltar) {
		this.resaltaridTipoProducto= borderResaltar;
	}

	public Boolean getMostraridTipoProducto() {
		return this.mostraridTipoProducto;
	}

	public void setMostraridTipoProducto(Boolean mostraridTipoProducto) {
		this.mostraridTipoProducto= mostraridTipoProducto;
	}

	public Boolean getActivaridTipoProducto() {
		return this.activaridTipoProducto;
	}

	public void setActivaridTipoProducto(Boolean activaridTipoProducto) {
		this.activaridTipoProducto= activaridTipoProducto;
	}

	public Border setResaltarid_empresaTipoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoBeanSwingJInternalFrame tipoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoproductoBeanSwingJInternalFrame.jTtoolBarTipoProducto.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoProducto() {
		return this.resaltarid_empresaTipoProducto;
	}

	public void setResaltarid_empresaTipoProducto(Border borderResaltar) {
		this.resaltarid_empresaTipoProducto= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoProducto() {
		return this.mostrarid_empresaTipoProducto;
	}

	public void setMostrarid_empresaTipoProducto(Boolean mostrarid_empresaTipoProducto) {
		this.mostrarid_empresaTipoProducto= mostrarid_empresaTipoProducto;
	}

	public Boolean getActivarid_empresaTipoProducto() {
		return this.activarid_empresaTipoProducto;
	}

	public void setActivarid_empresaTipoProducto(Boolean activarid_empresaTipoProducto) {
		this.activarid_empresaTipoProducto= activarid_empresaTipoProducto;
	}

	public Boolean getCargarid_empresaTipoProducto() {
		return this.cargarid_empresaTipoProducto;
	}

	public void setCargarid_empresaTipoProducto(Boolean cargarid_empresaTipoProducto) {
		this.cargarid_empresaTipoProducto= cargarid_empresaTipoProducto;
	}

	public Border setResaltarcodigoTipoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoBeanSwingJInternalFrame tipoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoproductoBeanSwingJInternalFrame.jTtoolBarTipoProducto.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoProducto() {
		return this.resaltarcodigoTipoProducto;
	}

	public void setResaltarcodigoTipoProducto(Border borderResaltar) {
		this.resaltarcodigoTipoProducto= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoProducto() {
		return this.mostrarcodigoTipoProducto;
	}

	public void setMostrarcodigoTipoProducto(Boolean mostrarcodigoTipoProducto) {
		this.mostrarcodigoTipoProducto= mostrarcodigoTipoProducto;
	}

	public Boolean getActivarcodigoTipoProducto() {
		return this.activarcodigoTipoProducto;
	}

	public void setActivarcodigoTipoProducto(Boolean activarcodigoTipoProducto) {
		this.activarcodigoTipoProducto= activarcodigoTipoProducto;
	}

	public Border setResaltarnombreTipoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoBeanSwingJInternalFrame tipoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoproductoBeanSwingJInternalFrame.jTtoolBarTipoProducto.setBorder(borderResaltar);
		
		this.resaltarnombreTipoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoProducto() {
		return this.resaltarnombreTipoProducto;
	}

	public void setResaltarnombreTipoProducto(Border borderResaltar) {
		this.resaltarnombreTipoProducto= borderResaltar;
	}

	public Boolean getMostrarnombreTipoProducto() {
		return this.mostrarnombreTipoProducto;
	}

	public void setMostrarnombreTipoProducto(Boolean mostrarnombreTipoProducto) {
		this.mostrarnombreTipoProducto= mostrarnombreTipoProducto;
	}

	public Boolean getActivarnombreTipoProducto() {
		return this.activarnombreTipoProducto;
	}

	public void setActivarnombreTipoProducto(Boolean activarnombreTipoProducto) {
		this.activarnombreTipoProducto= activarnombreTipoProducto;
	}

	public Border setResaltardescripcionTipoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoBeanSwingJInternalFrame tipoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoproductoBeanSwingJInternalFrame.jTtoolBarTipoProducto.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoProducto() {
		return this.resaltardescripcionTipoProducto;
	}

	public void setResaltardescripcionTipoProducto(Border borderResaltar) {
		this.resaltardescripcionTipoProducto= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoProducto() {
		return this.mostrardescripcionTipoProducto;
	}

	public void setMostrardescripcionTipoProducto(Boolean mostrardescripcionTipoProducto) {
		this.mostrardescripcionTipoProducto= mostrardescripcionTipoProducto;
	}

	public Boolean getActivardescripcionTipoProducto() {
		return this.activardescripcionTipoProducto;
	}

	public void setActivardescripcionTipoProducto(Boolean activardescripcionTipoProducto) {
		this.activardescripcionTipoProducto= activardescripcionTipoProducto;
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
		
		
		this.setMostraridTipoProducto(esInicial);
		this.setMostrarid_empresaTipoProducto(esInicial);
		this.setMostrarcodigoTipoProducto(esInicial);
		this.setMostrarnombreTipoProducto(esInicial);
		this.setMostrardescripcionTipoProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProductoConstantesFunciones.ID)) {
				this.setMostraridTipoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProductoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProductoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProductoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProductoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoProducto(esAsigna);
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
		
		
		this.setActivaridTipoProducto(esInicial);
		this.setActivarid_empresaTipoProducto(esInicial);
		this.setActivarcodigoTipoProducto(esInicial);
		this.setActivarnombreTipoProducto(esInicial);
		this.setActivardescripcionTipoProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProductoConstantesFunciones.ID)) {
				this.setActivaridTipoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProductoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProductoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProductoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProductoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoProductoBeanSwingJInternalFrame tipoproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoProducto(esInicial);
		this.setResaltarid_empresaTipoProducto(esInicial);
		this.setResaltarcodigoTipoProducto(esInicial);
		this.setResaltarnombreTipoProducto(esInicial);
		this.setResaltardescripcionTipoProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProductoConstantesFunciones.ID)) {
				this.setResaltaridTipoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProductoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProductoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProductoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProductoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoProducto(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarModeloProductoTipoProducto=null;

	public Border getResaltarModeloProductoTipoProducto() {
		return this.resaltarModeloProductoTipoProducto;
	}

	public void setResaltarModeloProductoTipoProducto(Border borderResaltarModeloProducto) {
		if(borderResaltarModeloProducto!=null) {
			this.resaltarModeloProductoTipoProducto= borderResaltarModeloProducto;
		}
	}

	public Border setResaltarModeloProductoTipoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoBeanSwingJInternalFrame tipoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarModeloProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoproductoBeanSwingJInternalFrame.jTtoolBarTipoProducto.setBorder(borderResaltarModeloProducto);
			
		this.resaltarModeloProductoTipoProducto= borderResaltarModeloProducto;

		 return borderResaltarModeloProducto;
	}



	public Boolean mostrarModeloProductoTipoProducto=true;

	public Boolean getMostrarModeloProductoTipoProducto() {
		return this.mostrarModeloProductoTipoProducto;
	}

	public void setMostrarModeloProductoTipoProducto(Boolean visibilidadResaltarModeloProducto) {
		this.mostrarModeloProductoTipoProducto= visibilidadResaltarModeloProducto;
	}



	public Boolean activarModeloProductoTipoProducto=true;

	public Boolean gethabilitarResaltarModeloProductoTipoProducto() {
		return this.activarModeloProductoTipoProducto;
	}

	public void setActivarModeloProductoTipoProducto(Boolean habilitarResaltarModeloProducto) {
		this.activarModeloProductoTipoProducto= habilitarResaltarModeloProducto;
	}


	public Border resaltarMaterialProductoTipoProducto=null;

	public Border getResaltarMaterialProductoTipoProducto() {
		return this.resaltarMaterialProductoTipoProducto;
	}

	public void setResaltarMaterialProductoTipoProducto(Border borderResaltarMaterialProducto) {
		if(borderResaltarMaterialProducto!=null) {
			this.resaltarMaterialProductoTipoProducto= borderResaltarMaterialProducto;
		}
	}

	public Border setResaltarMaterialProductoTipoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoBeanSwingJInternalFrame tipoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarMaterialProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoproductoBeanSwingJInternalFrame.jTtoolBarTipoProducto.setBorder(borderResaltarMaterialProducto);
			
		this.resaltarMaterialProductoTipoProducto= borderResaltarMaterialProducto;

		 return borderResaltarMaterialProducto;
	}



	public Boolean mostrarMaterialProductoTipoProducto=true;

	public Boolean getMostrarMaterialProductoTipoProducto() {
		return this.mostrarMaterialProductoTipoProducto;
	}

	public void setMostrarMaterialProductoTipoProducto(Boolean visibilidadResaltarMaterialProducto) {
		this.mostrarMaterialProductoTipoProducto= visibilidadResaltarMaterialProducto;
	}



	public Boolean activarMaterialProductoTipoProducto=true;

	public Boolean gethabilitarResaltarMaterialProductoTipoProducto() {
		return this.activarMaterialProductoTipoProducto;
	}

	public void setActivarMaterialProductoTipoProducto(Boolean habilitarResaltarMaterialProducto) {
		this.activarMaterialProductoTipoProducto= habilitarResaltarMaterialProducto;
	}


	public Border resaltarMarcaProductoTipoProducto=null;

	public Border getResaltarMarcaProductoTipoProducto() {
		return this.resaltarMarcaProductoTipoProducto;
	}

	public void setResaltarMarcaProductoTipoProducto(Border borderResaltarMarcaProducto) {
		if(borderResaltarMarcaProducto!=null) {
			this.resaltarMarcaProductoTipoProducto= borderResaltarMarcaProducto;
		}
	}

	public Border setResaltarMarcaProductoTipoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoBeanSwingJInternalFrame tipoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarMarcaProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoproductoBeanSwingJInternalFrame.jTtoolBarTipoProducto.setBorder(borderResaltarMarcaProducto);
			
		this.resaltarMarcaProductoTipoProducto= borderResaltarMarcaProducto;

		 return borderResaltarMarcaProducto;
	}



	public Boolean mostrarMarcaProductoTipoProducto=true;

	public Boolean getMostrarMarcaProductoTipoProducto() {
		return this.mostrarMarcaProductoTipoProducto;
	}

	public void setMostrarMarcaProductoTipoProducto(Boolean visibilidadResaltarMarcaProducto) {
		this.mostrarMarcaProductoTipoProducto= visibilidadResaltarMarcaProducto;
	}



	public Boolean activarMarcaProductoTipoProducto=true;

	public Boolean gethabilitarResaltarMarcaProductoTipoProducto() {
		return this.activarMarcaProductoTipoProducto;
	}

	public void setActivarMarcaProductoTipoProducto(Boolean habilitarResaltarMarcaProducto) {
		this.activarMarcaProductoTipoProducto= habilitarResaltarMarcaProducto;
	}


	public Border resaltarSegmentoProductoTipoProducto=null;

	public Border getResaltarSegmentoProductoTipoProducto() {
		return this.resaltarSegmentoProductoTipoProducto;
	}

	public void setResaltarSegmentoProductoTipoProducto(Border borderResaltarSegmentoProducto) {
		if(borderResaltarSegmentoProducto!=null) {
			this.resaltarSegmentoProductoTipoProducto= borderResaltarSegmentoProducto;
		}
	}

	public Border setResaltarSegmentoProductoTipoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoBeanSwingJInternalFrame tipoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarSegmentoProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoproductoBeanSwingJInternalFrame.jTtoolBarTipoProducto.setBorder(borderResaltarSegmentoProducto);
			
		this.resaltarSegmentoProductoTipoProducto= borderResaltarSegmentoProducto;

		 return borderResaltarSegmentoProducto;
	}



	public Boolean mostrarSegmentoProductoTipoProducto=true;

	public Boolean getMostrarSegmentoProductoTipoProducto() {
		return this.mostrarSegmentoProductoTipoProducto;
	}

	public void setMostrarSegmentoProductoTipoProducto(Boolean visibilidadResaltarSegmentoProducto) {
		this.mostrarSegmentoProductoTipoProducto= visibilidadResaltarSegmentoProducto;
	}



	public Boolean activarSegmentoProductoTipoProducto=true;

	public Boolean gethabilitarResaltarSegmentoProductoTipoProducto() {
		return this.activarSegmentoProductoTipoProducto;
	}

	public void setActivarSegmentoProductoTipoProducto(Boolean habilitarResaltarSegmentoProducto) {
		this.activarSegmentoProductoTipoProducto= habilitarResaltarSegmentoProducto;
	}


	public Border resaltarColorProductoTipoProducto=null;

	public Border getResaltarColorProductoTipoProducto() {
		return this.resaltarColorProductoTipoProducto;
	}

	public void setResaltarColorProductoTipoProducto(Border borderResaltarColorProducto) {
		if(borderResaltarColorProducto!=null) {
			this.resaltarColorProductoTipoProducto= borderResaltarColorProducto;
		}
	}

	public Border setResaltarColorProductoTipoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoBeanSwingJInternalFrame tipoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarColorProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoproductoBeanSwingJInternalFrame.jTtoolBarTipoProducto.setBorder(borderResaltarColorProducto);
			
		this.resaltarColorProductoTipoProducto= borderResaltarColorProducto;

		 return borderResaltarColorProducto;
	}



	public Boolean mostrarColorProductoTipoProducto=true;

	public Boolean getMostrarColorProductoTipoProducto() {
		return this.mostrarColorProductoTipoProducto;
	}

	public void setMostrarColorProductoTipoProducto(Boolean visibilidadResaltarColorProducto) {
		this.mostrarColorProductoTipoProducto= visibilidadResaltarColorProducto;
	}



	public Boolean activarColorProductoTipoProducto=true;

	public Boolean gethabilitarResaltarColorProductoTipoProducto() {
		return this.activarColorProductoTipoProducto;
	}

	public void setActivarColorProductoTipoProducto(Boolean habilitarResaltarColorProducto) {
		this.activarColorProductoTipoProducto= habilitarResaltarColorProducto;
	}


	public Border resaltarEfectoProductoTipoProducto=null;

	public Border getResaltarEfectoProductoTipoProducto() {
		return this.resaltarEfectoProductoTipoProducto;
	}

	public void setResaltarEfectoProductoTipoProducto(Border borderResaltarEfectoProducto) {
		if(borderResaltarEfectoProducto!=null) {
			this.resaltarEfectoProductoTipoProducto= borderResaltarEfectoProducto;
		}
	}

	public Border setResaltarEfectoProductoTipoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoBeanSwingJInternalFrame tipoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarEfectoProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoproductoBeanSwingJInternalFrame.jTtoolBarTipoProducto.setBorder(borderResaltarEfectoProducto);
			
		this.resaltarEfectoProductoTipoProducto= borderResaltarEfectoProducto;

		 return borderResaltarEfectoProducto;
	}



	public Boolean mostrarEfectoProductoTipoProducto=true;

	public Boolean getMostrarEfectoProductoTipoProducto() {
		return this.mostrarEfectoProductoTipoProducto;
	}

	public void setMostrarEfectoProductoTipoProducto(Boolean visibilidadResaltarEfectoProducto) {
		this.mostrarEfectoProductoTipoProducto= visibilidadResaltarEfectoProducto;
	}



	public Boolean activarEfectoProductoTipoProducto=true;

	public Boolean gethabilitarResaltarEfectoProductoTipoProducto() {
		return this.activarEfectoProductoTipoProducto;
	}

	public void setActivarEfectoProductoTipoProducto(Boolean habilitarResaltarEfectoProducto) {
		this.activarEfectoProductoTipoProducto= habilitarResaltarEfectoProducto;
	}


	public Border resaltarTallaProductoTipoProducto=null;

	public Border getResaltarTallaProductoTipoProducto() {
		return this.resaltarTallaProductoTipoProducto;
	}

	public void setResaltarTallaProductoTipoProducto(Border borderResaltarTallaProducto) {
		if(borderResaltarTallaProducto!=null) {
			this.resaltarTallaProductoTipoProducto= borderResaltarTallaProducto;
		}
	}

	public Border setResaltarTallaProductoTipoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoBeanSwingJInternalFrame tipoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarTallaProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoproductoBeanSwingJInternalFrame.jTtoolBarTipoProducto.setBorder(borderResaltarTallaProducto);
			
		this.resaltarTallaProductoTipoProducto= borderResaltarTallaProducto;

		 return borderResaltarTallaProducto;
	}



	public Boolean mostrarTallaProductoTipoProducto=true;

	public Boolean getMostrarTallaProductoTipoProducto() {
		return this.mostrarTallaProductoTipoProducto;
	}

	public void setMostrarTallaProductoTipoProducto(Boolean visibilidadResaltarTallaProducto) {
		this.mostrarTallaProductoTipoProducto= visibilidadResaltarTallaProducto;
	}



	public Boolean activarTallaProductoTipoProducto=true;

	public Boolean gethabilitarResaltarTallaProductoTipoProducto() {
		return this.activarTallaProductoTipoProducto;
	}

	public void setActivarTallaProductoTipoProducto(Boolean habilitarResaltarTallaProducto) {
		this.activarTallaProductoTipoProducto= habilitarResaltarTallaProducto;
	}


	public Border resaltarParametroInventarioDefectoTipoProducto=null;

	public Border getResaltarParametroInventarioDefectoTipoProducto() {
		return this.resaltarParametroInventarioDefectoTipoProducto;
	}

	public void setResaltarParametroInventarioDefectoTipoProducto(Border borderResaltarParametroInventarioDefecto) {
		if(borderResaltarParametroInventarioDefecto!=null) {
			this.resaltarParametroInventarioDefectoTipoProducto= borderResaltarParametroInventarioDefecto;
		}
	}

	public Border setResaltarParametroInventarioDefectoTipoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoBeanSwingJInternalFrame tipoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroInventarioDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoproductoBeanSwingJInternalFrame.jTtoolBarTipoProducto.setBorder(borderResaltarParametroInventarioDefecto);
			
		this.resaltarParametroInventarioDefectoTipoProducto= borderResaltarParametroInventarioDefecto;

		 return borderResaltarParametroInventarioDefecto;
	}



	public Boolean mostrarParametroInventarioDefectoTipoProducto=true;

	public Boolean getMostrarParametroInventarioDefectoTipoProducto() {
		return this.mostrarParametroInventarioDefectoTipoProducto;
	}

	public void setMostrarParametroInventarioDefectoTipoProducto(Boolean visibilidadResaltarParametroInventarioDefecto) {
		this.mostrarParametroInventarioDefectoTipoProducto= visibilidadResaltarParametroInventarioDefecto;
	}



	public Boolean activarParametroInventarioDefectoTipoProducto=true;

	public Boolean gethabilitarResaltarParametroInventarioDefectoTipoProducto() {
		return this.activarParametroInventarioDefectoTipoProducto;
	}

	public void setActivarParametroInventarioDefectoTipoProducto(Boolean habilitarResaltarParametroInventarioDefecto) {
		this.activarParametroInventarioDefectoTipoProducto= habilitarResaltarParametroInventarioDefecto;
	}


	public Border resaltarClaseProductoTipoProducto=null;

	public Border getResaltarClaseProductoTipoProducto() {
		return this.resaltarClaseProductoTipoProducto;
	}

	public void setResaltarClaseProductoTipoProducto(Border borderResaltarClaseProducto) {
		if(borderResaltarClaseProducto!=null) {
			this.resaltarClaseProductoTipoProducto= borderResaltarClaseProducto;
		}
	}

	public Border setResaltarClaseProductoTipoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoBeanSwingJInternalFrame tipoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarClaseProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoproductoBeanSwingJInternalFrame.jTtoolBarTipoProducto.setBorder(borderResaltarClaseProducto);
			
		this.resaltarClaseProductoTipoProducto= borderResaltarClaseProducto;

		 return borderResaltarClaseProducto;
	}



	public Boolean mostrarClaseProductoTipoProducto=true;

	public Boolean getMostrarClaseProductoTipoProducto() {
		return this.mostrarClaseProductoTipoProducto;
	}

	public void setMostrarClaseProductoTipoProducto(Boolean visibilidadResaltarClaseProducto) {
		this.mostrarClaseProductoTipoProducto= visibilidadResaltarClaseProducto;
	}



	public Boolean activarClaseProductoTipoProducto=true;

	public Boolean gethabilitarResaltarClaseProductoTipoProducto() {
		return this.activarClaseProductoTipoProducto;
	}

	public void setActivarClaseProductoTipoProducto(Boolean habilitarResaltarClaseProducto) {
		this.activarClaseProductoTipoProducto= habilitarResaltarClaseProducto;
	}


	public Border resaltarProductoTipoProducto=null;

	public Border getResaltarProductoTipoProducto() {
		return this.resaltarProductoTipoProducto;
	}

	public void setResaltarProductoTipoProducto(Border borderResaltarProducto) {
		if(borderResaltarProducto!=null) {
			this.resaltarProductoTipoProducto= borderResaltarProducto;
		}
	}

	public Border setResaltarProductoTipoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoBeanSwingJInternalFrame tipoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoproductoBeanSwingJInternalFrame.jTtoolBarTipoProducto.setBorder(borderResaltarProducto);
			
		this.resaltarProductoTipoProducto= borderResaltarProducto;

		 return borderResaltarProducto;
	}



	public Boolean mostrarProductoTipoProducto=true;

	public Boolean getMostrarProductoTipoProducto() {
		return this.mostrarProductoTipoProducto;
	}

	public void setMostrarProductoTipoProducto(Boolean visibilidadResaltarProducto) {
		this.mostrarProductoTipoProducto= visibilidadResaltarProducto;
	}



	public Boolean activarProductoTipoProducto=true;

	public Boolean gethabilitarResaltarProductoTipoProducto() {
		return this.activarProductoTipoProducto;
	}

	public void setActivarProductoTipoProducto(Boolean habilitarResaltarProducto) {
		this.activarProductoTipoProducto= habilitarResaltarProducto;
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

		this.setMostrarModeloProductoTipoProducto(esInicial);
		this.setMostrarMaterialProductoTipoProducto(esInicial);
		this.setMostrarMarcaProductoTipoProducto(esInicial);
		this.setMostrarSegmentoProductoTipoProducto(esInicial);
		this.setMostrarColorProductoTipoProducto(esInicial);
		this.setMostrarEfectoProductoTipoProducto(esInicial);
		this.setMostrarTallaProductoTipoProducto(esInicial);
		this.setMostrarParametroInventarioDefectoTipoProducto(esInicial);
		this.setMostrarClaseProductoTipoProducto(esInicial);
		this.setMostrarProductoTipoProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ModeloProducto.class)) {
				this.setMostrarModeloProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(MaterialProducto.class)) {
				this.setMostrarMaterialProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(MarcaProducto.class)) {
				this.setMostrarMarcaProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(SegmentoProducto.class)) {
				this.setMostrarSegmentoProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ColorProducto.class)) {
				this.setMostrarColorProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(EfectoProducto.class)) {
				this.setMostrarEfectoProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(TallaProducto.class)) {
				this.setMostrarTallaProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setMostrarParametroInventarioDefectoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ClaseProducto.class)) {
				this.setMostrarClaseProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(Producto.class)) {
				this.setMostrarProductoTipoProducto(esAsigna);
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

		this.setActivarModeloProductoTipoProducto(esInicial);
		this.setActivarMaterialProductoTipoProducto(esInicial);
		this.setActivarMarcaProductoTipoProducto(esInicial);
		this.setActivarSegmentoProductoTipoProducto(esInicial);
		this.setActivarColorProductoTipoProducto(esInicial);
		this.setActivarEfectoProductoTipoProducto(esInicial);
		this.setActivarTallaProductoTipoProducto(esInicial);
		this.setActivarParametroInventarioDefectoTipoProducto(esInicial);
		this.setActivarClaseProductoTipoProducto(esInicial);
		this.setActivarProductoTipoProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ModeloProducto.class)) {
				this.setActivarModeloProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(MaterialProducto.class)) {
				this.setActivarMaterialProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(MarcaProducto.class)) {
				this.setActivarMarcaProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(SegmentoProducto.class)) {
				this.setActivarSegmentoProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ColorProducto.class)) {
				this.setActivarColorProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(EfectoProducto.class)) {
				this.setActivarEfectoProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(TallaProducto.class)) {
				this.setActivarTallaProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setActivarParametroInventarioDefectoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ClaseProducto.class)) {
				this.setActivarClaseProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(Producto.class)) {
				this.setActivarProductoTipoProducto(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoProductoBeanSwingJInternalFrame tipoproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarModeloProductoTipoProducto(esInicial);
		this.setResaltarMaterialProductoTipoProducto(esInicial);
		this.setResaltarMarcaProductoTipoProducto(esInicial);
		this.setResaltarSegmentoProductoTipoProducto(esInicial);
		this.setResaltarColorProductoTipoProducto(esInicial);
		this.setResaltarEfectoProductoTipoProducto(esInicial);
		this.setResaltarTallaProductoTipoProducto(esInicial);
		this.setResaltarParametroInventarioDefectoTipoProducto(esInicial);
		this.setResaltarClaseProductoTipoProducto(esInicial);
		this.setResaltarProductoTipoProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ModeloProducto.class)) {
				this.setResaltarModeloProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(MaterialProducto.class)) {
				this.setResaltarMaterialProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(MarcaProducto.class)) {
				this.setResaltarMarcaProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(SegmentoProducto.class)) {
				this.setResaltarSegmentoProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ColorProducto.class)) {
				this.setResaltarColorProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(EfectoProducto.class)) {
				this.setResaltarEfectoProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(TallaProducto.class)) {
				this.setResaltarTallaProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setResaltarParametroInventarioDefectoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ClaseProducto.class)) {
				this.setResaltarClaseProductoTipoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(Producto.class)) {
				this.setResaltarProductoTipoProducto(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoTipoProducto=true;

	public Boolean getMostrarBusquedaPorCodigoTipoProducto() {
		return this.mostrarBusquedaPorCodigoTipoProducto;
	}

	public void setMostrarBusquedaPorCodigoTipoProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoProducto= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoProducto=true;

	public Boolean getMostrarBusquedaPorNombreTipoProducto() {
		return this.mostrarBusquedaPorNombreTipoProducto;
	}

	public void setMostrarBusquedaPorNombreTipoProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoProducto=true;

	public Boolean getMostrarFK_IdEmpresaTipoProducto() {
		return this.mostrarFK_IdEmpresaTipoProducto;
	}

	public void setMostrarFK_IdEmpresaTipoProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoProducto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoProducto=true;

	public Boolean getActivarBusquedaPorCodigoTipoProducto() {
		return this.activarBusquedaPorCodigoTipoProducto;
	}

	public void setActivarBusquedaPorCodigoTipoProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoProducto= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoProducto=true;

	public Boolean getActivarBusquedaPorNombreTipoProducto() {
		return this.activarBusquedaPorNombreTipoProducto;
	}

	public void setActivarBusquedaPorNombreTipoProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoProducto=true;

	public Boolean getActivarFK_IdEmpresaTipoProducto() {
		return this.activarFK_IdEmpresaTipoProducto;
	}

	public void setActivarFK_IdEmpresaTipoProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoProducto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoProducto=null;

	public Border getResaltarBusquedaPorCodigoTipoProducto() {
		return this.resaltarBusquedaPorCodigoTipoProducto;
	}

	public void setResaltarBusquedaPorCodigoTipoProducto(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoBeanSwingJInternalFrame tipoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoProducto= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoProducto=null;

	public Border getResaltarBusquedaPorNombreTipoProducto() {
		return this.resaltarBusquedaPorNombreTipoProducto;
	}

	public void setResaltarBusquedaPorNombreTipoProducto(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoBeanSwingJInternalFrame tipoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoProducto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoProducto=null;

	public Border getResaltarFK_IdEmpresaTipoProducto() {
		return this.resaltarFK_IdEmpresaTipoProducto;
	}

	public void setResaltarFK_IdEmpresaTipoProducto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoProducto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoBeanSwingJInternalFrame tipoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}