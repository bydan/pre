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


import com.bydan.erp.inventario.util.EfectoProductoConstantesFunciones;
import com.bydan.erp.inventario.util.EfectoProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EfectoProductoParameterGeneral;

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
final public class EfectoProductoConstantesFunciones extends EfectoProductoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EfectoProducto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EfectoProducto"+EfectoProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EfectoProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EfectoProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EfectoProductoConstantesFunciones.SCHEMA+"_"+EfectoProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EfectoProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EfectoProductoConstantesFunciones.SCHEMA+"_"+EfectoProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EfectoProductoConstantesFunciones.SCHEMA+"_"+EfectoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EfectoProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EfectoProductoConstantesFunciones.SCHEMA+"_"+EfectoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EfectoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EfectoProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EfectoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EfectoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EfectoProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EfectoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EfectoProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EfectoProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EfectoProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EfectoProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Efecto Productos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Efecto Producto";
	public static final String SCLASSWEBTITULO_LOWER="Efecto Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EfectoProducto";
	public static final String OBJECTNAME="efectoproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="efecto_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select efectoproducto from "+EfectoProductoConstantesFunciones.SPERSISTENCENAME+" efectoproducto";
	public static String QUERYSELECTNATIVE="select "+EfectoProductoConstantesFunciones.SCHEMA+"."+EfectoProductoConstantesFunciones.TABLENAME+".id,"+EfectoProductoConstantesFunciones.SCHEMA+"."+EfectoProductoConstantesFunciones.TABLENAME+".version_row,"+EfectoProductoConstantesFunciones.SCHEMA+"."+EfectoProductoConstantesFunciones.TABLENAME+".id_empresa,"+EfectoProductoConstantesFunciones.SCHEMA+"."+EfectoProductoConstantesFunciones.TABLENAME+".id_tipo_producto,"+EfectoProductoConstantesFunciones.SCHEMA+"."+EfectoProductoConstantesFunciones.TABLENAME+".codigo,"+EfectoProductoConstantesFunciones.SCHEMA+"."+EfectoProductoConstantesFunciones.TABLENAME+".nombre from "+EfectoProductoConstantesFunciones.SCHEMA+"."+EfectoProductoConstantesFunciones.TABLENAME;//+" as "+EfectoProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EfectoProductoConstantesFuncionesAdditional efectoproductoConstantesFuncionesAdditional=null;
	
	public EfectoProductoConstantesFuncionesAdditional getEfectoProductoConstantesFuncionesAdditional() {
		return this.efectoproductoConstantesFuncionesAdditional;
	}
	
	public void setEfectoProductoConstantesFuncionesAdditional(EfectoProductoConstantesFuncionesAdditional efectoproductoConstantesFuncionesAdditional) {
		try {
			this.efectoproductoConstantesFuncionesAdditional=efectoproductoConstantesFuncionesAdditional;
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
	
	public static String getEfectoProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EfectoProductoConstantesFunciones.IDEMPRESA)) {sLabelColumna=EfectoProductoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EfectoProductoConstantesFunciones.IDTIPOPRODUCTO)) {sLabelColumna=EfectoProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO;}
		if(sNombreColumna.equals(EfectoProductoConstantesFunciones.CODIGO)) {sLabelColumna=EfectoProductoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EfectoProductoConstantesFunciones.NOMBRE)) {sLabelColumna=EfectoProductoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getEfectoProductoDescripcion(EfectoProducto efectoproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(efectoproducto !=null/* && efectoproducto.getId()!=0*/) {
			sDescripcion=efectoproducto.getcodigo();//efectoproductoefectoproducto.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEfectoProductoDescripcionDetallado(EfectoProducto efectoproducto) {
		String sDescripcion="";
			
		sDescripcion+=EfectoProductoConstantesFunciones.ID+"=";
		sDescripcion+=efectoproducto.getId().toString()+",";
		sDescripcion+=EfectoProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=efectoproducto.getVersionRow().toString()+",";
		sDescripcion+=EfectoProductoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=efectoproducto.getid_empresa().toString()+",";
		sDescripcion+=EfectoProductoConstantesFunciones.IDTIPOPRODUCTO+"=";
		sDescripcion+=efectoproducto.getid_tipo_producto().toString()+",";
		sDescripcion+=EfectoProductoConstantesFunciones.CODIGO+"=";
		sDescripcion+=efectoproducto.getcodigo()+",";
		sDescripcion+=EfectoProductoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=efectoproducto.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEfectoProductoDescripcion(EfectoProducto efectoproducto,String sValor) throws Exception {			
		if(efectoproducto !=null) {
			efectoproducto.setcodigo(sValor);;//efectoproductoefectoproducto.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEfectoProducto(EfectoProducto efectoproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		efectoproducto.setcodigo(efectoproducto.getcodigo().trim());
		efectoproducto.setnombre(efectoproducto.getnombre().trim());
	}
	
	public static void quitarEspaciosEfectoProductos(List<EfectoProducto> efectoproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EfectoProducto efectoproducto: efectoproductos) {
			efectoproducto.setcodigo(efectoproducto.getcodigo().trim());
			efectoproducto.setnombre(efectoproducto.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEfectoProducto(EfectoProducto efectoproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && efectoproducto.getConCambioAuxiliar()) {
			efectoproducto.setIsDeleted(efectoproducto.getIsDeletedAuxiliar());	
			efectoproducto.setIsNew(efectoproducto.getIsNewAuxiliar());	
			efectoproducto.setIsChanged(efectoproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			efectoproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			efectoproducto.setIsDeletedAuxiliar(false);	
			efectoproducto.setIsNewAuxiliar(false);	
			efectoproducto.setIsChangedAuxiliar(false);
			
			efectoproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEfectoProductos(List<EfectoProducto> efectoproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EfectoProducto efectoproducto : efectoproductos) {
			if(conAsignarBase && efectoproducto.getConCambioAuxiliar()) {
				efectoproducto.setIsDeleted(efectoproducto.getIsDeletedAuxiliar());	
				efectoproducto.setIsNew(efectoproducto.getIsNewAuxiliar());	
				efectoproducto.setIsChanged(efectoproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				efectoproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				efectoproducto.setIsDeletedAuxiliar(false);	
				efectoproducto.setIsNewAuxiliar(false);	
				efectoproducto.setIsChangedAuxiliar(false);
				
				efectoproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEfectoProducto(EfectoProducto efectoproducto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEfectoProductos(List<EfectoProducto> efectoproductos,Boolean conEnteros) throws Exception  {
		
		for(EfectoProducto efectoproducto: efectoproductos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEfectoProducto(List<EfectoProducto> efectoproductos,EfectoProducto efectoproductoAux) throws Exception  {
		EfectoProductoConstantesFunciones.InicializarValoresEfectoProducto(efectoproductoAux,true);
		
		for(EfectoProducto efectoproducto: efectoproductos) {
			if(efectoproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEfectoProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EfectoProductoConstantesFunciones.getArrayColumnasGlobalesEfectoProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEfectoProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EfectoProductoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EfectoProductoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEfectoProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EfectoProducto> efectoproductos,EfectoProducto efectoproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EfectoProducto efectoproductoAux: efectoproductos) {
			if(efectoproductoAux!=null && efectoproducto!=null) {
				if((efectoproductoAux.getId()==null && efectoproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(efectoproductoAux.getId()!=null && efectoproducto.getId()!=null){
					if(efectoproductoAux.getId().equals(efectoproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEfectoProducto(List<EfectoProducto> efectoproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EfectoProducto efectoproducto: efectoproductos) {			
			if(efectoproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEfectoProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EfectoProductoConstantesFunciones.LABEL_ID, EfectoProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EfectoProductoConstantesFunciones.LABEL_VERSIONROW, EfectoProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EfectoProductoConstantesFunciones.LABEL_IDEMPRESA, EfectoProductoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EfectoProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO, EfectoProductoConstantesFunciones.IDTIPOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EfectoProductoConstantesFunciones.LABEL_CODIGO, EfectoProductoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EfectoProductoConstantesFunciones.LABEL_NOMBRE, EfectoProductoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEfectoProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EfectoProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EfectoProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EfectoProductoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EfectoProductoConstantesFunciones.IDTIPOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EfectoProductoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EfectoProductoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEfectoProducto() throws Exception  {
		return EfectoProductoConstantesFunciones.getTiposSeleccionarEfectoProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEfectoProducto(Boolean conFk) throws Exception  {
		return EfectoProductoConstantesFunciones.getTiposSeleccionarEfectoProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEfectoProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EfectoProductoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EfectoProductoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EfectoProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);
			reporte.setsDescripcion(EfectoProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EfectoProductoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EfectoProductoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EfectoProductoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EfectoProductoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEfectoProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEfectoProducto(EfectoProducto efectoproductoAux) throws Exception {
		
			efectoproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(efectoproductoAux.getEmpresa()));
			efectoproductoAux.settipoproducto_descripcion(TipoProductoConstantesFunciones.getTipoProductoDescripcion(efectoproductoAux.getTipoProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEfectoProducto(List<EfectoProducto> efectoproductosTemp) throws Exception {
		for(EfectoProducto efectoproductoAux:efectoproductosTemp) {
			
			efectoproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(efectoproductoAux.getEmpresa()));
			efectoproductoAux.settipoproducto_descripcion(TipoProductoConstantesFunciones.getTipoProductoDescripcion(efectoproductoAux.getTipoProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEfectoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEfectoProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEfectoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EfectoProductoConstantesFunciones.getClassesRelationshipsOfEfectoProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEfectoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEfectoProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EfectoProductoConstantesFunciones.getClassesRelationshipsFromStringsOfEfectoProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEfectoProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(EfectoProducto efectoproducto,List<EfectoProducto> efectoproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EfectoProducto efectoproductoEncontrado=null;
			
			for(EfectoProducto efectoproductoLocal:efectoproductos) {
				if(efectoproductoLocal.getId().equals(efectoproducto.getId())) {
					efectoproductoEncontrado=efectoproductoLocal;
					
					efectoproductoLocal.setIsChanged(efectoproducto.getIsChanged());
					efectoproductoLocal.setIsNew(efectoproducto.getIsNew());
					efectoproductoLocal.setIsDeleted(efectoproducto.getIsDeleted());
					
					efectoproductoLocal.setGeneralEntityOriginal(efectoproducto.getGeneralEntityOriginal());
					
					efectoproductoLocal.setId(efectoproducto.getId());	
					efectoproductoLocal.setVersionRow(efectoproducto.getVersionRow());	
					efectoproductoLocal.setid_empresa(efectoproducto.getid_empresa());	
					efectoproductoLocal.setid_tipo_producto(efectoproducto.getid_tipo_producto());	
					efectoproductoLocal.setcodigo(efectoproducto.getcodigo());	
					efectoproductoLocal.setnombre(efectoproducto.getnombre());	
					
					
					efectoproductoLocal.setProductos(efectoproducto.getProductos());
					efectoproductoLocal.setParametroInventarioDefectos(efectoproducto.getParametroInventarioDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!efectoproducto.getIsDeleted()) {
				if(!existe) {
					efectoproductos.add(efectoproducto);
				}
			} else {
				if(efectoproductoEncontrado!=null && permiteQuitar)  {
					efectoproductos.remove(efectoproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EfectoProducto efectoproducto,List<EfectoProducto> efectoproductos) throws Exception {
		try	{			
			for(EfectoProducto efectoproductoLocal:efectoproductos) {
				if(efectoproductoLocal.getId().equals(efectoproducto.getId())) {
					efectoproductoLocal.setIsSelected(efectoproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEfectoProducto(List<EfectoProducto> efectoproductosAux) throws Exception {
		//this.efectoproductosAux=efectoproductosAux;
		
		for(EfectoProducto efectoproductoAux:efectoproductosAux) {
			if(efectoproductoAux.getIsChanged()) {
				efectoproductoAux.setIsChanged(false);
			}		
			
			if(efectoproductoAux.getIsNew()) {
				efectoproductoAux.setIsNew(false);
			}	
			
			if(efectoproductoAux.getIsDeleted()) {
				efectoproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEfectoProducto(EfectoProducto efectoproductoAux) throws Exception {
		//this.efectoproductoAux=efectoproductoAux;
		
			if(efectoproductoAux.getIsChanged()) {
				efectoproductoAux.setIsChanged(false);
			}		
			
			if(efectoproductoAux.getIsNew()) {
				efectoproductoAux.setIsNew(false);
			}	
			
			if(efectoproductoAux.getIsDeleted()) {
				efectoproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EfectoProducto efectoproductoAsignar,EfectoProducto efectoproducto) throws Exception {
		efectoproductoAsignar.setId(efectoproducto.getId());	
		efectoproductoAsignar.setVersionRow(efectoproducto.getVersionRow());	
		efectoproductoAsignar.setid_empresa(efectoproducto.getid_empresa());
		efectoproductoAsignar.setempresa_descripcion(efectoproducto.getempresa_descripcion());	
		efectoproductoAsignar.setid_tipo_producto(efectoproducto.getid_tipo_producto());
		efectoproductoAsignar.settipoproducto_descripcion(efectoproducto.gettipoproducto_descripcion());	
		efectoproductoAsignar.setcodigo(efectoproducto.getcodigo());	
		efectoproductoAsignar.setnombre(efectoproducto.getnombre());	
	}
	
	public static void inicializarEfectoProducto(EfectoProducto efectoproducto) throws Exception {
		try {
				efectoproducto.setId(0L);	
					
				efectoproducto.setid_empresa(-1L);	
				efectoproducto.setid_tipo_producto(-1L);	
				efectoproducto.setcodigo("");	
				efectoproducto.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEfectoProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EfectoProductoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EfectoProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EfectoProductoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EfectoProductoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEfectoProducto(String sTipo,Row row,Workbook workbook,EfectoProducto efectoproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(efectoproducto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(efectoproducto.gettipoproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(efectoproducto.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(efectoproducto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEfectoProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEfectoProducto() {
		return this.sFinalQueryEfectoProducto;
	}
	
	public void setsFinalQueryEfectoProducto(String sFinalQueryEfectoProducto) {
		this.sFinalQueryEfectoProducto= sFinalQueryEfectoProducto;
	}
	
	public Border resaltarSeleccionarEfectoProducto=null;
	
	public Border setResaltarSeleccionarEfectoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*EfectoProductoBeanSwingJInternalFrame efectoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//efectoproductoBeanSwingJInternalFrame.jTtoolBarEfectoProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEfectoProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEfectoProducto() {
		return this.resaltarSeleccionarEfectoProducto;
	}
	
	public void setResaltarSeleccionarEfectoProducto(Border borderResaltarSeleccionarEfectoProducto) {
		this.resaltarSeleccionarEfectoProducto= borderResaltarSeleccionarEfectoProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEfectoProducto=null;
	public Boolean mostraridEfectoProducto=true;
	public Boolean activaridEfectoProducto=true;

	public Border resaltarid_empresaEfectoProducto=null;
	public Boolean mostrarid_empresaEfectoProducto=true;
	public Boolean activarid_empresaEfectoProducto=true;
	public Boolean cargarid_empresaEfectoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEfectoProducto=false;//ConEventDepend=true

	public Border resaltarid_tipo_productoEfectoProducto=null;
	public Boolean mostrarid_tipo_productoEfectoProducto=true;
	public Boolean activarid_tipo_productoEfectoProducto=true;
	public Boolean cargarid_tipo_productoEfectoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_productoEfectoProducto=false;//ConEventDepend=true

	public Border resaltarcodigoEfectoProducto=null;
	public Boolean mostrarcodigoEfectoProducto=true;
	public Boolean activarcodigoEfectoProducto=true;

	public Border resaltarnombreEfectoProducto=null;
	public Boolean mostrarnombreEfectoProducto=true;
	public Boolean activarnombreEfectoProducto=true;

	
	

	public Border setResaltaridEfectoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*EfectoProductoBeanSwingJInternalFrame efectoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//efectoproductoBeanSwingJInternalFrame.jTtoolBarEfectoProducto.setBorder(borderResaltar);
		
		this.resaltaridEfectoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEfectoProducto() {
		return this.resaltaridEfectoProducto;
	}

	public void setResaltaridEfectoProducto(Border borderResaltar) {
		this.resaltaridEfectoProducto= borderResaltar;
	}

	public Boolean getMostraridEfectoProducto() {
		return this.mostraridEfectoProducto;
	}

	public void setMostraridEfectoProducto(Boolean mostraridEfectoProducto) {
		this.mostraridEfectoProducto= mostraridEfectoProducto;
	}

	public Boolean getActivaridEfectoProducto() {
		return this.activaridEfectoProducto;
	}

	public void setActivaridEfectoProducto(Boolean activaridEfectoProducto) {
		this.activaridEfectoProducto= activaridEfectoProducto;
	}

	public Border setResaltarid_empresaEfectoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*EfectoProductoBeanSwingJInternalFrame efectoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//efectoproductoBeanSwingJInternalFrame.jTtoolBarEfectoProducto.setBorder(borderResaltar);
		
		this.resaltarid_empresaEfectoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEfectoProducto() {
		return this.resaltarid_empresaEfectoProducto;
	}

	public void setResaltarid_empresaEfectoProducto(Border borderResaltar) {
		this.resaltarid_empresaEfectoProducto= borderResaltar;
	}

	public Boolean getMostrarid_empresaEfectoProducto() {
		return this.mostrarid_empresaEfectoProducto;
	}

	public void setMostrarid_empresaEfectoProducto(Boolean mostrarid_empresaEfectoProducto) {
		this.mostrarid_empresaEfectoProducto= mostrarid_empresaEfectoProducto;
	}

	public Boolean getActivarid_empresaEfectoProducto() {
		return this.activarid_empresaEfectoProducto;
	}

	public void setActivarid_empresaEfectoProducto(Boolean activarid_empresaEfectoProducto) {
		this.activarid_empresaEfectoProducto= activarid_empresaEfectoProducto;
	}

	public Boolean getCargarid_empresaEfectoProducto() {
		return this.cargarid_empresaEfectoProducto;
	}

	public void setCargarid_empresaEfectoProducto(Boolean cargarid_empresaEfectoProducto) {
		this.cargarid_empresaEfectoProducto= cargarid_empresaEfectoProducto;
	}

	public Border setResaltarid_tipo_productoEfectoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*EfectoProductoBeanSwingJInternalFrame efectoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//efectoproductoBeanSwingJInternalFrame.jTtoolBarEfectoProducto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_productoEfectoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_productoEfectoProducto() {
		return this.resaltarid_tipo_productoEfectoProducto;
	}

	public void setResaltarid_tipo_productoEfectoProducto(Border borderResaltar) {
		this.resaltarid_tipo_productoEfectoProducto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_productoEfectoProducto() {
		return this.mostrarid_tipo_productoEfectoProducto;
	}

	public void setMostrarid_tipo_productoEfectoProducto(Boolean mostrarid_tipo_productoEfectoProducto) {
		this.mostrarid_tipo_productoEfectoProducto= mostrarid_tipo_productoEfectoProducto;
	}

	public Boolean getActivarid_tipo_productoEfectoProducto() {
		return this.activarid_tipo_productoEfectoProducto;
	}

	public void setActivarid_tipo_productoEfectoProducto(Boolean activarid_tipo_productoEfectoProducto) {
		this.activarid_tipo_productoEfectoProducto= activarid_tipo_productoEfectoProducto;
	}

	public Boolean getCargarid_tipo_productoEfectoProducto() {
		return this.cargarid_tipo_productoEfectoProducto;
	}

	public void setCargarid_tipo_productoEfectoProducto(Boolean cargarid_tipo_productoEfectoProducto) {
		this.cargarid_tipo_productoEfectoProducto= cargarid_tipo_productoEfectoProducto;
	}

	public Border setResaltarcodigoEfectoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*EfectoProductoBeanSwingJInternalFrame efectoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//efectoproductoBeanSwingJInternalFrame.jTtoolBarEfectoProducto.setBorder(borderResaltar);
		
		this.resaltarcodigoEfectoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEfectoProducto() {
		return this.resaltarcodigoEfectoProducto;
	}

	public void setResaltarcodigoEfectoProducto(Border borderResaltar) {
		this.resaltarcodigoEfectoProducto= borderResaltar;
	}

	public Boolean getMostrarcodigoEfectoProducto() {
		return this.mostrarcodigoEfectoProducto;
	}

	public void setMostrarcodigoEfectoProducto(Boolean mostrarcodigoEfectoProducto) {
		this.mostrarcodigoEfectoProducto= mostrarcodigoEfectoProducto;
	}

	public Boolean getActivarcodigoEfectoProducto() {
		return this.activarcodigoEfectoProducto;
	}

	public void setActivarcodigoEfectoProducto(Boolean activarcodigoEfectoProducto) {
		this.activarcodigoEfectoProducto= activarcodigoEfectoProducto;
	}

	public Border setResaltarnombreEfectoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*EfectoProductoBeanSwingJInternalFrame efectoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//efectoproductoBeanSwingJInternalFrame.jTtoolBarEfectoProducto.setBorder(borderResaltar);
		
		this.resaltarnombreEfectoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEfectoProducto() {
		return this.resaltarnombreEfectoProducto;
	}

	public void setResaltarnombreEfectoProducto(Border borderResaltar) {
		this.resaltarnombreEfectoProducto= borderResaltar;
	}

	public Boolean getMostrarnombreEfectoProducto() {
		return this.mostrarnombreEfectoProducto;
	}

	public void setMostrarnombreEfectoProducto(Boolean mostrarnombreEfectoProducto) {
		this.mostrarnombreEfectoProducto= mostrarnombreEfectoProducto;
	}

	public Boolean getActivarnombreEfectoProducto() {
		return this.activarnombreEfectoProducto;
	}

	public void setActivarnombreEfectoProducto(Boolean activarnombreEfectoProducto) {
		this.activarnombreEfectoProducto= activarnombreEfectoProducto;
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
		
		
		this.setMostraridEfectoProducto(esInicial);
		this.setMostrarid_empresaEfectoProducto(esInicial);
		this.setMostrarid_tipo_productoEfectoProducto(esInicial);
		this.setMostrarcodigoEfectoProducto(esInicial);
		this.setMostrarnombreEfectoProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EfectoProductoConstantesFunciones.ID)) {
				this.setMostraridEfectoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EfectoProductoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEfectoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EfectoProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setMostrarid_tipo_productoEfectoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EfectoProductoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEfectoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EfectoProductoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEfectoProducto(esAsigna);
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
		
		
		this.setActivaridEfectoProducto(esInicial);
		this.setActivarid_empresaEfectoProducto(esInicial);
		this.setActivarid_tipo_productoEfectoProducto(esInicial);
		this.setActivarcodigoEfectoProducto(esInicial);
		this.setActivarnombreEfectoProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EfectoProductoConstantesFunciones.ID)) {
				this.setActivaridEfectoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EfectoProductoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEfectoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EfectoProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setActivarid_tipo_productoEfectoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EfectoProductoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEfectoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EfectoProductoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEfectoProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EfectoProductoBeanSwingJInternalFrame efectoproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEfectoProducto(esInicial);
		this.setResaltarid_empresaEfectoProducto(esInicial);
		this.setResaltarid_tipo_productoEfectoProducto(esInicial);
		this.setResaltarcodigoEfectoProducto(esInicial);
		this.setResaltarnombreEfectoProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EfectoProductoConstantesFunciones.ID)) {
				this.setResaltaridEfectoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EfectoProductoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEfectoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EfectoProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setResaltarid_tipo_productoEfectoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EfectoProductoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEfectoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EfectoProductoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEfectoProducto(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarProductoEfectoProducto=null;

	public Border getResaltarProductoEfectoProducto() {
		return this.resaltarProductoEfectoProducto;
	}

	public void setResaltarProductoEfectoProducto(Border borderResaltarProducto) {
		if(borderResaltarProducto!=null) {
			this.resaltarProductoEfectoProducto= borderResaltarProducto;
		}
	}

	public Border setResaltarProductoEfectoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*EfectoProductoBeanSwingJInternalFrame efectoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//efectoproductoBeanSwingJInternalFrame.jTtoolBarEfectoProducto.setBorder(borderResaltarProducto);
			
		this.resaltarProductoEfectoProducto= borderResaltarProducto;

		 return borderResaltarProducto;
	}



	public Boolean mostrarProductoEfectoProducto=true;

	public Boolean getMostrarProductoEfectoProducto() {
		return this.mostrarProductoEfectoProducto;
	}

	public void setMostrarProductoEfectoProducto(Boolean visibilidadResaltarProducto) {
		this.mostrarProductoEfectoProducto= visibilidadResaltarProducto;
	}



	public Boolean activarProductoEfectoProducto=true;

	public Boolean gethabilitarResaltarProductoEfectoProducto() {
		return this.activarProductoEfectoProducto;
	}

	public void setActivarProductoEfectoProducto(Boolean habilitarResaltarProducto) {
		this.activarProductoEfectoProducto= habilitarResaltarProducto;
	}


	public Border resaltarParametroInventarioDefectoEfectoProducto=null;

	public Border getResaltarParametroInventarioDefectoEfectoProducto() {
		return this.resaltarParametroInventarioDefectoEfectoProducto;
	}

	public void setResaltarParametroInventarioDefectoEfectoProducto(Border borderResaltarParametroInventarioDefecto) {
		if(borderResaltarParametroInventarioDefecto!=null) {
			this.resaltarParametroInventarioDefectoEfectoProducto= borderResaltarParametroInventarioDefecto;
		}
	}

	public Border setResaltarParametroInventarioDefectoEfectoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*EfectoProductoBeanSwingJInternalFrame efectoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroInventarioDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//efectoproductoBeanSwingJInternalFrame.jTtoolBarEfectoProducto.setBorder(borderResaltarParametroInventarioDefecto);
			
		this.resaltarParametroInventarioDefectoEfectoProducto= borderResaltarParametroInventarioDefecto;

		 return borderResaltarParametroInventarioDefecto;
	}



	public Boolean mostrarParametroInventarioDefectoEfectoProducto=true;

	public Boolean getMostrarParametroInventarioDefectoEfectoProducto() {
		return this.mostrarParametroInventarioDefectoEfectoProducto;
	}

	public void setMostrarParametroInventarioDefectoEfectoProducto(Boolean visibilidadResaltarParametroInventarioDefecto) {
		this.mostrarParametroInventarioDefectoEfectoProducto= visibilidadResaltarParametroInventarioDefecto;
	}



	public Boolean activarParametroInventarioDefectoEfectoProducto=true;

	public Boolean gethabilitarResaltarParametroInventarioDefectoEfectoProducto() {
		return this.activarParametroInventarioDefectoEfectoProducto;
	}

	public void setActivarParametroInventarioDefectoEfectoProducto(Boolean habilitarResaltarParametroInventarioDefecto) {
		this.activarParametroInventarioDefectoEfectoProducto= habilitarResaltarParametroInventarioDefecto;
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

		this.setMostrarProductoEfectoProducto(esInicial);
		this.setMostrarParametroInventarioDefectoEfectoProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setMostrarProductoEfectoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setMostrarParametroInventarioDefectoEfectoProducto(esAsigna);
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

		this.setActivarProductoEfectoProducto(esInicial);
		this.setActivarParametroInventarioDefectoEfectoProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setActivarProductoEfectoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setActivarParametroInventarioDefectoEfectoProducto(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EfectoProductoBeanSwingJInternalFrame efectoproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarProductoEfectoProducto(esInicial);
		this.setResaltarParametroInventarioDefectoEfectoProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setResaltarProductoEfectoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setResaltarParametroInventarioDefectoEfectoProducto(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoEfectoProducto=true;

	public Boolean getMostrarBusquedaPorCodigoEfectoProducto() {
		return this.mostrarBusquedaPorCodigoEfectoProducto;
	}

	public void setMostrarBusquedaPorCodigoEfectoProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoEfectoProducto= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreEfectoProducto=true;

	public Boolean getMostrarBusquedaPorNombreEfectoProducto() {
		return this.mostrarBusquedaPorNombreEfectoProducto;
	}

	public void setMostrarBusquedaPorNombreEfectoProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreEfectoProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaEfectoProducto=true;

	public Boolean getMostrarFK_IdEmpresaEfectoProducto() {
		return this.mostrarFK_IdEmpresaEfectoProducto;
	}

	public void setMostrarFK_IdEmpresaEfectoProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEfectoProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProductoEfectoProducto=true;

	public Boolean getMostrarFK_IdTipoProductoEfectoProducto() {
		return this.mostrarFK_IdTipoProductoEfectoProducto;
	}

	public void setMostrarFK_IdTipoProductoEfectoProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProductoEfectoProducto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoEfectoProducto=true;

	public Boolean getActivarBusquedaPorCodigoEfectoProducto() {
		return this.activarBusquedaPorCodigoEfectoProducto;
	}

	public void setActivarBusquedaPorCodigoEfectoProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoEfectoProducto= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreEfectoProducto=true;

	public Boolean getActivarBusquedaPorNombreEfectoProducto() {
		return this.activarBusquedaPorNombreEfectoProducto;
	}

	public void setActivarBusquedaPorNombreEfectoProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreEfectoProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaEfectoProducto=true;

	public Boolean getActivarFK_IdEmpresaEfectoProducto() {
		return this.activarFK_IdEmpresaEfectoProducto;
	}

	public void setActivarFK_IdEmpresaEfectoProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEfectoProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProductoEfectoProducto=true;

	public Boolean getActivarFK_IdTipoProductoEfectoProducto() {
		return this.activarFK_IdTipoProductoEfectoProducto;
	}

	public void setActivarFK_IdTipoProductoEfectoProducto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProductoEfectoProducto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoEfectoProducto=null;

	public Border getResaltarBusquedaPorCodigoEfectoProducto() {
		return this.resaltarBusquedaPorCodigoEfectoProducto;
	}

	public void setResaltarBusquedaPorCodigoEfectoProducto(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoEfectoProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoEfectoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*EfectoProductoBeanSwingJInternalFrame efectoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoEfectoProducto= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreEfectoProducto=null;

	public Border getResaltarBusquedaPorNombreEfectoProducto() {
		return this.resaltarBusquedaPorNombreEfectoProducto;
	}

	public void setResaltarBusquedaPorNombreEfectoProducto(Border borderResaltar) {
		this.resaltarBusquedaPorNombreEfectoProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreEfectoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*EfectoProductoBeanSwingJInternalFrame efectoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreEfectoProducto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaEfectoProducto=null;

	public Border getResaltarFK_IdEmpresaEfectoProducto() {
		return this.resaltarFK_IdEmpresaEfectoProducto;
	}

	public void setResaltarFK_IdEmpresaEfectoProducto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEfectoProducto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEfectoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*EfectoProductoBeanSwingJInternalFrame efectoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEfectoProducto= borderResaltar;
	}

	public Border resaltarFK_IdTipoProductoEfectoProducto=null;

	public Border getResaltarFK_IdTipoProductoEfectoProducto() {
		return this.resaltarFK_IdTipoProductoEfectoProducto;
	}

	public void setResaltarFK_IdTipoProductoEfectoProducto(Border borderResaltar) {
		this.resaltarFK_IdTipoProductoEfectoProducto= borderResaltar;
	}

	public void setResaltarFK_IdTipoProductoEfectoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*EfectoProductoBeanSwingJInternalFrame efectoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProductoEfectoProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}