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


import com.bydan.erp.inventario.util.NovedadProductoConstantesFunciones;
import com.bydan.erp.inventario.util.NovedadProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.NovedadProductoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class NovedadProductoConstantesFunciones extends NovedadProductoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="NovedadProducto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="NovedadProducto"+NovedadProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="NovedadProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="NovedadProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=NovedadProductoConstantesFunciones.SCHEMA+"_"+NovedadProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/NovedadProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=NovedadProductoConstantesFunciones.SCHEMA+"_"+NovedadProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=NovedadProductoConstantesFunciones.SCHEMA+"_"+NovedadProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/NovedadProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=NovedadProductoConstantesFunciones.SCHEMA+"_"+NovedadProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NovedadProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NovedadProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NovedadProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NovedadProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NovedadProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NovedadProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=NovedadProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+NovedadProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=NovedadProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+NovedadProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Novedad Productoes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Novedad Producto";
	public static final String SCLASSWEBTITULO_LOWER="Novedad Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="NovedadProducto";
	public static final String OBJECTNAME="novedadproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="novedad_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select novedadproducto from "+NovedadProductoConstantesFunciones.SPERSISTENCENAME+" novedadproducto";
	public static String QUERYSELECTNATIVE="select "+NovedadProductoConstantesFunciones.SCHEMA+"."+NovedadProductoConstantesFunciones.TABLENAME+".id,"+NovedadProductoConstantesFunciones.SCHEMA+"."+NovedadProductoConstantesFunciones.TABLENAME+".version_row,"+NovedadProductoConstantesFunciones.SCHEMA+"."+NovedadProductoConstantesFunciones.TABLENAME+".id_empresa,"+NovedadProductoConstantesFunciones.SCHEMA+"."+NovedadProductoConstantesFunciones.TABLENAME+".codigo,"+NovedadProductoConstantesFunciones.SCHEMA+"."+NovedadProductoConstantesFunciones.TABLENAME+".nombre from "+NovedadProductoConstantesFunciones.SCHEMA+"."+NovedadProductoConstantesFunciones.TABLENAME;//+" as "+NovedadProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected NovedadProductoConstantesFuncionesAdditional novedadproductoConstantesFuncionesAdditional=null;
	
	public NovedadProductoConstantesFuncionesAdditional getNovedadProductoConstantesFuncionesAdditional() {
		return this.novedadproductoConstantesFuncionesAdditional;
	}
	
	public void setNovedadProductoConstantesFuncionesAdditional(NovedadProductoConstantesFuncionesAdditional novedadproductoConstantesFuncionesAdditional) {
		try {
			this.novedadproductoConstantesFuncionesAdditional=novedadproductoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getNovedadProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(NovedadProductoConstantesFunciones.IDEMPRESA)) {sLabelColumna=NovedadProductoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(NovedadProductoConstantesFunciones.CODIGO)) {sLabelColumna=NovedadProductoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(NovedadProductoConstantesFunciones.NOMBRE)) {sLabelColumna=NovedadProductoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getNovedadProductoDescripcion(NovedadProducto novedadproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(novedadproducto !=null/* && novedadproducto.getId()!=0*/) {
			sDescripcion=novedadproducto.getcodigo();//novedadproductonovedadproducto.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getNovedadProductoDescripcionDetallado(NovedadProducto novedadproducto) {
		String sDescripcion="";
			
		sDescripcion+=NovedadProductoConstantesFunciones.ID+"=";
		sDescripcion+=novedadproducto.getId().toString()+",";
		sDescripcion+=NovedadProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=novedadproducto.getVersionRow().toString()+",";
		sDescripcion+=NovedadProductoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=novedadproducto.getid_empresa().toString()+",";
		sDescripcion+=NovedadProductoConstantesFunciones.CODIGO+"=";
		sDescripcion+=novedadproducto.getcodigo()+",";
		sDescripcion+=NovedadProductoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=novedadproducto.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setNovedadProductoDescripcion(NovedadProducto novedadproducto,String sValor) throws Exception {			
		if(novedadproducto !=null) {
			novedadproducto.setcodigo(sValor);;//novedadproductonovedadproducto.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosNovedadProducto(NovedadProducto novedadproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		novedadproducto.setcodigo(novedadproducto.getcodigo().trim());
		novedadproducto.setnombre(novedadproducto.getnombre().trim());
	}
	
	public static void quitarEspaciosNovedadProductos(List<NovedadProducto> novedadproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(NovedadProducto novedadproducto: novedadproductos) {
			novedadproducto.setcodigo(novedadproducto.getcodigo().trim());
			novedadproducto.setnombre(novedadproducto.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNovedadProducto(NovedadProducto novedadproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && novedadproducto.getConCambioAuxiliar()) {
			novedadproducto.setIsDeleted(novedadproducto.getIsDeletedAuxiliar());	
			novedadproducto.setIsNew(novedadproducto.getIsNewAuxiliar());	
			novedadproducto.setIsChanged(novedadproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			novedadproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			novedadproducto.setIsDeletedAuxiliar(false);	
			novedadproducto.setIsNewAuxiliar(false);	
			novedadproducto.setIsChangedAuxiliar(false);
			
			novedadproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNovedadProductos(List<NovedadProducto> novedadproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(NovedadProducto novedadproducto : novedadproductos) {
			if(conAsignarBase && novedadproducto.getConCambioAuxiliar()) {
				novedadproducto.setIsDeleted(novedadproducto.getIsDeletedAuxiliar());	
				novedadproducto.setIsNew(novedadproducto.getIsNewAuxiliar());	
				novedadproducto.setIsChanged(novedadproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				novedadproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				novedadproducto.setIsDeletedAuxiliar(false);	
				novedadproducto.setIsNewAuxiliar(false);	
				novedadproducto.setIsChangedAuxiliar(false);
				
				novedadproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresNovedadProducto(NovedadProducto novedadproducto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresNovedadProductos(List<NovedadProducto> novedadproductos,Boolean conEnteros) throws Exception  {
		
		for(NovedadProducto novedadproducto: novedadproductos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaNovedadProducto(List<NovedadProducto> novedadproductos,NovedadProducto novedadproductoAux) throws Exception  {
		NovedadProductoConstantesFunciones.InicializarValoresNovedadProducto(novedadproductoAux,true);
		
		for(NovedadProducto novedadproducto: novedadproductos) {
			if(novedadproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNovedadProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=NovedadProductoConstantesFunciones.getArrayColumnasGlobalesNovedadProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesNovedadProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NovedadProductoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NovedadProductoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoNovedadProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<NovedadProducto> novedadproductos,NovedadProducto novedadproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(NovedadProducto novedadproductoAux: novedadproductos) {
			if(novedadproductoAux!=null && novedadproducto!=null) {
				if((novedadproductoAux.getId()==null && novedadproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(novedadproductoAux.getId()!=null && novedadproducto.getId()!=null){
					if(novedadproductoAux.getId().equals(novedadproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaNovedadProducto(List<NovedadProducto> novedadproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(NovedadProducto novedadproducto: novedadproductos) {			
			if(novedadproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaNovedadProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,NovedadProductoConstantesFunciones.LABEL_ID, NovedadProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadProductoConstantesFunciones.LABEL_VERSIONROW, NovedadProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadProductoConstantesFunciones.LABEL_IDEMPRESA, NovedadProductoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadProductoConstantesFunciones.LABEL_CODIGO, NovedadProductoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadProductoConstantesFunciones.LABEL_NOMBRE, NovedadProductoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasNovedadProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=NovedadProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadProductoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadProductoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadProductoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNovedadProducto() throws Exception  {
		return NovedadProductoConstantesFunciones.getTiposSeleccionarNovedadProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNovedadProducto(Boolean conFk) throws Exception  {
		return NovedadProductoConstantesFunciones.getTiposSeleccionarNovedadProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNovedadProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadProductoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(NovedadProductoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadProductoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(NovedadProductoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadProductoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(NovedadProductoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesNovedadProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesNovedadProducto(NovedadProducto novedadproductoAux) throws Exception {
		
			novedadproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(novedadproductoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesNovedadProducto(List<NovedadProducto> novedadproductosTemp) throws Exception {
		for(NovedadProducto novedadproductoAux:novedadproductosTemp) {
			
			novedadproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(novedadproductoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfNovedadProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfNovedadProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfNovedadProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return NovedadProductoConstantesFunciones.getClassesRelationshipsOfNovedadProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNovedadProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleFacturaProveedor.class));
				classes.add(new Classe(NovedadSeguimiento.class));
				classes.add(new Classe(DetalleCompra.class));
				classes.add(new Classe(DetalleTransferencia.class));
				classes.add(new Classe(DetalleMovimientoInventario.class));
				classes.add(new Classe(DetalleOrdenCompra.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleFacturaProveedor.class)) {
						classes.add(new Classe(DetalleFacturaProveedor.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NovedadSeguimiento.class)) {
						classes.add(new Classe(NovedadSeguimiento.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleCompra.class)) {
						classes.add(new Classe(DetalleCompra.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleTransferencia.class)) {
						classes.add(new Classe(DetalleTransferencia.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleMovimientoInventario.class)) {
						classes.add(new Classe(DetalleMovimientoInventario.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleOrdenCompra.class)) {
						classes.add(new Classe(DetalleOrdenCompra.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNovedadProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return NovedadProductoConstantesFunciones.getClassesRelationshipsFromStringsOfNovedadProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNovedadProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleFacturaProveedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleFacturaProveedor.class)); continue;
					}

					if(NovedadSeguimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NovedadSeguimiento.class)); continue;
					}

					if(DetalleCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleCompra.class)); continue;
					}

					if(DetalleTransferencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleTransferencia.class)); continue;
					}

					if(DetalleMovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleMovimientoInventario.class)); continue;
					}

					if(DetalleOrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleOrdenCompra.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleFacturaProveedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleFacturaProveedor.class)); continue;
					}

					if(NovedadSeguimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NovedadSeguimiento.class)); continue;
					}

					if(DetalleCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleCompra.class)); continue;
					}

					if(DetalleTransferencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleTransferencia.class)); continue;
					}

					if(DetalleMovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleMovimientoInventario.class)); continue;
					}

					if(DetalleOrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleOrdenCompra.class)); continue;
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
	public static void actualizarLista(NovedadProducto novedadproducto,List<NovedadProducto> novedadproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			NovedadProducto novedadproductoEncontrado=null;
			
			for(NovedadProducto novedadproductoLocal:novedadproductos) {
				if(novedadproductoLocal.getId().equals(novedadproducto.getId())) {
					novedadproductoEncontrado=novedadproductoLocal;
					
					novedadproductoLocal.setIsChanged(novedadproducto.getIsChanged());
					novedadproductoLocal.setIsNew(novedadproducto.getIsNew());
					novedadproductoLocal.setIsDeleted(novedadproducto.getIsDeleted());
					
					novedadproductoLocal.setGeneralEntityOriginal(novedadproducto.getGeneralEntityOriginal());
					
					novedadproductoLocal.setId(novedadproducto.getId());	
					novedadproductoLocal.setVersionRow(novedadproducto.getVersionRow());	
					novedadproductoLocal.setid_empresa(novedadproducto.getid_empresa());	
					novedadproductoLocal.setcodigo(novedadproducto.getcodigo());	
					novedadproductoLocal.setnombre(novedadproducto.getnombre());	
					
					
					novedadproductoLocal.setDetalleFacturaProveedors(novedadproducto.getDetalleFacturaProveedors());
					novedadproductoLocal.setNovedadSeguimientos(novedadproducto.getNovedadSeguimientos());
					novedadproductoLocal.setDetalleTransferencias(novedadproducto.getDetalleTransferencias());
					novedadproductoLocal.setDetalleMovimientoInventarios(novedadproducto.getDetalleMovimientoInventarios());
					novedadproductoLocal.setDetalleOrdenCompras(novedadproducto.getDetalleOrdenCompras());
					
					existe=true;
					break;
				}
			}
			
			if(!novedadproducto.getIsDeleted()) {
				if(!existe) {
					novedadproductos.add(novedadproducto);
				}
			} else {
				if(novedadproductoEncontrado!=null && permiteQuitar)  {
					novedadproductos.remove(novedadproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(NovedadProducto novedadproducto,List<NovedadProducto> novedadproductos) throws Exception {
		try	{			
			for(NovedadProducto novedadproductoLocal:novedadproductos) {
				if(novedadproductoLocal.getId().equals(novedadproducto.getId())) {
					novedadproductoLocal.setIsSelected(novedadproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesNovedadProducto(List<NovedadProducto> novedadproductosAux) throws Exception {
		//this.novedadproductosAux=novedadproductosAux;
		
		for(NovedadProducto novedadproductoAux:novedadproductosAux) {
			if(novedadproductoAux.getIsChanged()) {
				novedadproductoAux.setIsChanged(false);
			}		
			
			if(novedadproductoAux.getIsNew()) {
				novedadproductoAux.setIsNew(false);
			}	
			
			if(novedadproductoAux.getIsDeleted()) {
				novedadproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesNovedadProducto(NovedadProducto novedadproductoAux) throws Exception {
		//this.novedadproductoAux=novedadproductoAux;
		
			if(novedadproductoAux.getIsChanged()) {
				novedadproductoAux.setIsChanged(false);
			}		
			
			if(novedadproductoAux.getIsNew()) {
				novedadproductoAux.setIsNew(false);
			}	
			
			if(novedadproductoAux.getIsDeleted()) {
				novedadproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(NovedadProducto novedadproductoAsignar,NovedadProducto novedadproducto) throws Exception {
		novedadproductoAsignar.setId(novedadproducto.getId());	
		novedadproductoAsignar.setVersionRow(novedadproducto.getVersionRow());	
		novedadproductoAsignar.setid_empresa(novedadproducto.getid_empresa());
		novedadproductoAsignar.setempresa_descripcion(novedadproducto.getempresa_descripcion());	
		novedadproductoAsignar.setcodigo(novedadproducto.getcodigo());	
		novedadproductoAsignar.setnombre(novedadproducto.getnombre());	
	}
	
	public static void inicializarNovedadProducto(NovedadProducto novedadproducto) throws Exception {
		try {
				novedadproducto.setId(0L);	
					
				novedadproducto.setid_empresa(-1L);	
				novedadproducto.setcodigo("");	
				novedadproducto.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderNovedadProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadProductoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadProductoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadProductoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataNovedadProducto(String sTipo,Row row,Workbook workbook,NovedadProducto novedadproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadproducto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadproducto.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadproducto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryNovedadProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryNovedadProducto() {
		return this.sFinalQueryNovedadProducto;
	}
	
	public void setsFinalQueryNovedadProducto(String sFinalQueryNovedadProducto) {
		this.sFinalQueryNovedadProducto= sFinalQueryNovedadProducto;
	}
	
	public Border resaltarSeleccionarNovedadProducto=null;
	
	public Border setResaltarSeleccionarNovedadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadProductoBeanSwingJInternalFrame novedadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//novedadproductoBeanSwingJInternalFrame.jTtoolBarNovedadProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarNovedadProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarNovedadProducto() {
		return this.resaltarSeleccionarNovedadProducto;
	}
	
	public void setResaltarSeleccionarNovedadProducto(Border borderResaltarSeleccionarNovedadProducto) {
		this.resaltarSeleccionarNovedadProducto= borderResaltarSeleccionarNovedadProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridNovedadProducto=null;
	public Boolean mostraridNovedadProducto=true;
	public Boolean activaridNovedadProducto=true;

	public Border resaltarid_empresaNovedadProducto=null;
	public Boolean mostrarid_empresaNovedadProducto=true;
	public Boolean activarid_empresaNovedadProducto=true;
	public Boolean cargarid_empresaNovedadProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaNovedadProducto=false;//ConEventDepend=true

	public Border resaltarcodigoNovedadProducto=null;
	public Boolean mostrarcodigoNovedadProducto=true;
	public Boolean activarcodigoNovedadProducto=true;

	public Border resaltarnombreNovedadProducto=null;
	public Boolean mostrarnombreNovedadProducto=true;
	public Boolean activarnombreNovedadProducto=true;

	
	

	public Border setResaltaridNovedadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadProductoBeanSwingJInternalFrame novedadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadproductoBeanSwingJInternalFrame.jTtoolBarNovedadProducto.setBorder(borderResaltar);
		
		this.resaltaridNovedadProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridNovedadProducto() {
		return this.resaltaridNovedadProducto;
	}

	public void setResaltaridNovedadProducto(Border borderResaltar) {
		this.resaltaridNovedadProducto= borderResaltar;
	}

	public Boolean getMostraridNovedadProducto() {
		return this.mostraridNovedadProducto;
	}

	public void setMostraridNovedadProducto(Boolean mostraridNovedadProducto) {
		this.mostraridNovedadProducto= mostraridNovedadProducto;
	}

	public Boolean getActivaridNovedadProducto() {
		return this.activaridNovedadProducto;
	}

	public void setActivaridNovedadProducto(Boolean activaridNovedadProducto) {
		this.activaridNovedadProducto= activaridNovedadProducto;
	}

	public Border setResaltarid_empresaNovedadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadProductoBeanSwingJInternalFrame novedadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadproductoBeanSwingJInternalFrame.jTtoolBarNovedadProducto.setBorder(borderResaltar);
		
		this.resaltarid_empresaNovedadProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaNovedadProducto() {
		return this.resaltarid_empresaNovedadProducto;
	}

	public void setResaltarid_empresaNovedadProducto(Border borderResaltar) {
		this.resaltarid_empresaNovedadProducto= borderResaltar;
	}

	public Boolean getMostrarid_empresaNovedadProducto() {
		return this.mostrarid_empresaNovedadProducto;
	}

	public void setMostrarid_empresaNovedadProducto(Boolean mostrarid_empresaNovedadProducto) {
		this.mostrarid_empresaNovedadProducto= mostrarid_empresaNovedadProducto;
	}

	public Boolean getActivarid_empresaNovedadProducto() {
		return this.activarid_empresaNovedadProducto;
	}

	public void setActivarid_empresaNovedadProducto(Boolean activarid_empresaNovedadProducto) {
		this.activarid_empresaNovedadProducto= activarid_empresaNovedadProducto;
	}

	public Boolean getCargarid_empresaNovedadProducto() {
		return this.cargarid_empresaNovedadProducto;
	}

	public void setCargarid_empresaNovedadProducto(Boolean cargarid_empresaNovedadProducto) {
		this.cargarid_empresaNovedadProducto= cargarid_empresaNovedadProducto;
	}

	public Border setResaltarcodigoNovedadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadProductoBeanSwingJInternalFrame novedadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadproductoBeanSwingJInternalFrame.jTtoolBarNovedadProducto.setBorder(borderResaltar);
		
		this.resaltarcodigoNovedadProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoNovedadProducto() {
		return this.resaltarcodigoNovedadProducto;
	}

	public void setResaltarcodigoNovedadProducto(Border borderResaltar) {
		this.resaltarcodigoNovedadProducto= borderResaltar;
	}

	public Boolean getMostrarcodigoNovedadProducto() {
		return this.mostrarcodigoNovedadProducto;
	}

	public void setMostrarcodigoNovedadProducto(Boolean mostrarcodigoNovedadProducto) {
		this.mostrarcodigoNovedadProducto= mostrarcodigoNovedadProducto;
	}

	public Boolean getActivarcodigoNovedadProducto() {
		return this.activarcodigoNovedadProducto;
	}

	public void setActivarcodigoNovedadProducto(Boolean activarcodigoNovedadProducto) {
		this.activarcodigoNovedadProducto= activarcodigoNovedadProducto;
	}

	public Border setResaltarnombreNovedadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadProductoBeanSwingJInternalFrame novedadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadproductoBeanSwingJInternalFrame.jTtoolBarNovedadProducto.setBorder(borderResaltar);
		
		this.resaltarnombreNovedadProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreNovedadProducto() {
		return this.resaltarnombreNovedadProducto;
	}

	public void setResaltarnombreNovedadProducto(Border borderResaltar) {
		this.resaltarnombreNovedadProducto= borderResaltar;
	}

	public Boolean getMostrarnombreNovedadProducto() {
		return this.mostrarnombreNovedadProducto;
	}

	public void setMostrarnombreNovedadProducto(Boolean mostrarnombreNovedadProducto) {
		this.mostrarnombreNovedadProducto= mostrarnombreNovedadProducto;
	}

	public Boolean getActivarnombreNovedadProducto() {
		return this.activarnombreNovedadProducto;
	}

	public void setActivarnombreNovedadProducto(Boolean activarnombreNovedadProducto) {
		this.activarnombreNovedadProducto= activarnombreNovedadProducto;
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
		
		
		this.setMostraridNovedadProducto(esInicial);
		this.setMostrarid_empresaNovedadProducto(esInicial);
		this.setMostrarcodigoNovedadProducto(esInicial);
		this.setMostrarnombreNovedadProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NovedadProductoConstantesFunciones.ID)) {
				this.setMostraridNovedadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadProductoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaNovedadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadProductoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoNovedadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadProductoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreNovedadProducto(esAsigna);
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
		
		
		this.setActivaridNovedadProducto(esInicial);
		this.setActivarid_empresaNovedadProducto(esInicial);
		this.setActivarcodigoNovedadProducto(esInicial);
		this.setActivarnombreNovedadProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NovedadProductoConstantesFunciones.ID)) {
				this.setActivaridNovedadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadProductoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaNovedadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadProductoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoNovedadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadProductoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreNovedadProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,NovedadProductoBeanSwingJInternalFrame novedadproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridNovedadProducto(esInicial);
		this.setResaltarid_empresaNovedadProducto(esInicial);
		this.setResaltarcodigoNovedadProducto(esInicial);
		this.setResaltarnombreNovedadProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NovedadProductoConstantesFunciones.ID)) {
				this.setResaltaridNovedadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadProductoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaNovedadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadProductoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoNovedadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadProductoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreNovedadProducto(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleFacturaProveedorNovedadProducto=null;

	public Border getResaltarDetalleFacturaProveedorNovedadProducto() {
		return this.resaltarDetalleFacturaProveedorNovedadProducto;
	}

	public void setResaltarDetalleFacturaProveedorNovedadProducto(Border borderResaltarDetalleFacturaProveedor) {
		if(borderResaltarDetalleFacturaProveedor!=null) {
			this.resaltarDetalleFacturaProveedorNovedadProducto= borderResaltarDetalleFacturaProveedor;
		}
	}

	public Border setResaltarDetalleFacturaProveedorNovedadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadProductoBeanSwingJInternalFrame novedadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleFacturaProveedor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//novedadproductoBeanSwingJInternalFrame.jTtoolBarNovedadProducto.setBorder(borderResaltarDetalleFacturaProveedor);
			
		this.resaltarDetalleFacturaProveedorNovedadProducto= borderResaltarDetalleFacturaProveedor;

		 return borderResaltarDetalleFacturaProveedor;
	}



	public Boolean mostrarDetalleFacturaProveedorNovedadProducto=true;

	public Boolean getMostrarDetalleFacturaProveedorNovedadProducto() {
		return this.mostrarDetalleFacturaProveedorNovedadProducto;
	}

	public void setMostrarDetalleFacturaProveedorNovedadProducto(Boolean visibilidadResaltarDetalleFacturaProveedor) {
		this.mostrarDetalleFacturaProveedorNovedadProducto= visibilidadResaltarDetalleFacturaProveedor;
	}



	public Boolean activarDetalleFacturaProveedorNovedadProducto=true;

	public Boolean gethabilitarResaltarDetalleFacturaProveedorNovedadProducto() {
		return this.activarDetalleFacturaProveedorNovedadProducto;
	}

	public void setActivarDetalleFacturaProveedorNovedadProducto(Boolean habilitarResaltarDetalleFacturaProveedor) {
		this.activarDetalleFacturaProveedorNovedadProducto= habilitarResaltarDetalleFacturaProveedor;
	}


	public Border resaltarNovedadSeguimientoNovedadProducto=null;

	public Border getResaltarNovedadSeguimientoNovedadProducto() {
		return this.resaltarNovedadSeguimientoNovedadProducto;
	}

	public void setResaltarNovedadSeguimientoNovedadProducto(Border borderResaltarNovedadSeguimiento) {
		if(borderResaltarNovedadSeguimiento!=null) {
			this.resaltarNovedadSeguimientoNovedadProducto= borderResaltarNovedadSeguimiento;
		}
	}

	public Border setResaltarNovedadSeguimientoNovedadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadProductoBeanSwingJInternalFrame novedadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarNovedadSeguimiento=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//novedadproductoBeanSwingJInternalFrame.jTtoolBarNovedadProducto.setBorder(borderResaltarNovedadSeguimiento);
			
		this.resaltarNovedadSeguimientoNovedadProducto= borderResaltarNovedadSeguimiento;

		 return borderResaltarNovedadSeguimiento;
	}



	public Boolean mostrarNovedadSeguimientoNovedadProducto=true;

	public Boolean getMostrarNovedadSeguimientoNovedadProducto() {
		return this.mostrarNovedadSeguimientoNovedadProducto;
	}

	public void setMostrarNovedadSeguimientoNovedadProducto(Boolean visibilidadResaltarNovedadSeguimiento) {
		this.mostrarNovedadSeguimientoNovedadProducto= visibilidadResaltarNovedadSeguimiento;
	}



	public Boolean activarNovedadSeguimientoNovedadProducto=true;

	public Boolean gethabilitarResaltarNovedadSeguimientoNovedadProducto() {
		return this.activarNovedadSeguimientoNovedadProducto;
	}

	public void setActivarNovedadSeguimientoNovedadProducto(Boolean habilitarResaltarNovedadSeguimiento) {
		this.activarNovedadSeguimientoNovedadProducto= habilitarResaltarNovedadSeguimiento;
	}


	public Border resaltarDetalleTransferenciaNovedadProducto=null;

	public Border getResaltarDetalleTransferenciaNovedadProducto() {
		return this.resaltarDetalleTransferenciaNovedadProducto;
	}

	public void setResaltarDetalleTransferenciaNovedadProducto(Border borderResaltarDetalleTransferencia) {
		if(borderResaltarDetalleTransferencia!=null) {
			this.resaltarDetalleTransferenciaNovedadProducto= borderResaltarDetalleTransferencia;
		}
	}

	public Border setResaltarDetalleTransferenciaNovedadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadProductoBeanSwingJInternalFrame novedadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleTransferencia=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//novedadproductoBeanSwingJInternalFrame.jTtoolBarNovedadProducto.setBorder(borderResaltarDetalleTransferencia);
			
		this.resaltarDetalleTransferenciaNovedadProducto= borderResaltarDetalleTransferencia;

		 return borderResaltarDetalleTransferencia;
	}



	public Boolean mostrarDetalleTransferenciaNovedadProducto=true;

	public Boolean getMostrarDetalleTransferenciaNovedadProducto() {
		return this.mostrarDetalleTransferenciaNovedadProducto;
	}

	public void setMostrarDetalleTransferenciaNovedadProducto(Boolean visibilidadResaltarDetalleTransferencia) {
		this.mostrarDetalleTransferenciaNovedadProducto= visibilidadResaltarDetalleTransferencia;
	}



	public Boolean activarDetalleTransferenciaNovedadProducto=true;

	public Boolean gethabilitarResaltarDetalleTransferenciaNovedadProducto() {
		return this.activarDetalleTransferenciaNovedadProducto;
	}

	public void setActivarDetalleTransferenciaNovedadProducto(Boolean habilitarResaltarDetalleTransferencia) {
		this.activarDetalleTransferenciaNovedadProducto= habilitarResaltarDetalleTransferencia;
	}


	public Border resaltarDetalleMovimientoInventarioNovedadProducto=null;

	public Border getResaltarDetalleMovimientoInventarioNovedadProducto() {
		return this.resaltarDetalleMovimientoInventarioNovedadProducto;
	}

	public void setResaltarDetalleMovimientoInventarioNovedadProducto(Border borderResaltarDetalleMovimientoInventario) {
		if(borderResaltarDetalleMovimientoInventario!=null) {
			this.resaltarDetalleMovimientoInventarioNovedadProducto= borderResaltarDetalleMovimientoInventario;
		}
	}

	public Border setResaltarDetalleMovimientoInventarioNovedadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadProductoBeanSwingJInternalFrame novedadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleMovimientoInventario=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//novedadproductoBeanSwingJInternalFrame.jTtoolBarNovedadProducto.setBorder(borderResaltarDetalleMovimientoInventario);
			
		this.resaltarDetalleMovimientoInventarioNovedadProducto= borderResaltarDetalleMovimientoInventario;

		 return borderResaltarDetalleMovimientoInventario;
	}



	public Boolean mostrarDetalleMovimientoInventarioNovedadProducto=true;

	public Boolean getMostrarDetalleMovimientoInventarioNovedadProducto() {
		return this.mostrarDetalleMovimientoInventarioNovedadProducto;
	}

	public void setMostrarDetalleMovimientoInventarioNovedadProducto(Boolean visibilidadResaltarDetalleMovimientoInventario) {
		this.mostrarDetalleMovimientoInventarioNovedadProducto= visibilidadResaltarDetalleMovimientoInventario;
	}



	public Boolean activarDetalleMovimientoInventarioNovedadProducto=true;

	public Boolean gethabilitarResaltarDetalleMovimientoInventarioNovedadProducto() {
		return this.activarDetalleMovimientoInventarioNovedadProducto;
	}

	public void setActivarDetalleMovimientoInventarioNovedadProducto(Boolean habilitarResaltarDetalleMovimientoInventario) {
		this.activarDetalleMovimientoInventarioNovedadProducto= habilitarResaltarDetalleMovimientoInventario;
	}


	public Border resaltarDetalleOrdenCompraNovedadProducto=null;

	public Border getResaltarDetalleOrdenCompraNovedadProducto() {
		return this.resaltarDetalleOrdenCompraNovedadProducto;
	}

	public void setResaltarDetalleOrdenCompraNovedadProducto(Border borderResaltarDetalleOrdenCompra) {
		if(borderResaltarDetalleOrdenCompra!=null) {
			this.resaltarDetalleOrdenCompraNovedadProducto= borderResaltarDetalleOrdenCompra;
		}
	}

	public Border setResaltarDetalleOrdenCompraNovedadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadProductoBeanSwingJInternalFrame novedadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleOrdenCompra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//novedadproductoBeanSwingJInternalFrame.jTtoolBarNovedadProducto.setBorder(borderResaltarDetalleOrdenCompra);
			
		this.resaltarDetalleOrdenCompraNovedadProducto= borderResaltarDetalleOrdenCompra;

		 return borderResaltarDetalleOrdenCompra;
	}



	public Boolean mostrarDetalleOrdenCompraNovedadProducto=true;

	public Boolean getMostrarDetalleOrdenCompraNovedadProducto() {
		return this.mostrarDetalleOrdenCompraNovedadProducto;
	}

	public void setMostrarDetalleOrdenCompraNovedadProducto(Boolean visibilidadResaltarDetalleOrdenCompra) {
		this.mostrarDetalleOrdenCompraNovedadProducto= visibilidadResaltarDetalleOrdenCompra;
	}



	public Boolean activarDetalleOrdenCompraNovedadProducto=true;

	public Boolean gethabilitarResaltarDetalleOrdenCompraNovedadProducto() {
		return this.activarDetalleOrdenCompraNovedadProducto;
	}

	public void setActivarDetalleOrdenCompraNovedadProducto(Boolean habilitarResaltarDetalleOrdenCompra) {
		this.activarDetalleOrdenCompraNovedadProducto= habilitarResaltarDetalleOrdenCompra;
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

		this.setMostrarDetalleFacturaProveedorNovedadProducto(esInicial);
		this.setMostrarNovedadSeguimientoNovedadProducto(esInicial);
		this.setMostrarDetalleTransferenciaNovedadProducto(esInicial);
		this.setMostrarDetalleMovimientoInventarioNovedadProducto(esInicial);
		this.setMostrarDetalleOrdenCompraNovedadProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleFacturaProveedor.class)) {
				this.setMostrarDetalleFacturaProveedorNovedadProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(NovedadSeguimiento.class)) {
				this.setMostrarNovedadSeguimientoNovedadProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleTransferencia.class)) {
				this.setMostrarDetalleTransferenciaNovedadProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleMovimientoInventario.class)) {
				this.setMostrarDetalleMovimientoInventarioNovedadProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleOrdenCompra.class)) {
				this.setMostrarDetalleOrdenCompraNovedadProducto(esAsigna);
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

		this.setActivarDetalleFacturaProveedorNovedadProducto(esInicial);
		this.setActivarNovedadSeguimientoNovedadProducto(esInicial);
		this.setActivarDetalleTransferenciaNovedadProducto(esInicial);
		this.setActivarDetalleMovimientoInventarioNovedadProducto(esInicial);
		this.setActivarDetalleOrdenCompraNovedadProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleFacturaProveedor.class)) {
				this.setActivarDetalleFacturaProveedorNovedadProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(NovedadSeguimiento.class)) {
				this.setActivarNovedadSeguimientoNovedadProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleTransferencia.class)) {
				this.setActivarDetalleTransferenciaNovedadProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleMovimientoInventario.class)) {
				this.setActivarDetalleMovimientoInventarioNovedadProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleOrdenCompra.class)) {
				this.setActivarDetalleOrdenCompraNovedadProducto(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,NovedadProductoBeanSwingJInternalFrame novedadproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleFacturaProveedorNovedadProducto(esInicial);
		this.setResaltarNovedadSeguimientoNovedadProducto(esInicial);
		this.setResaltarDetalleTransferenciaNovedadProducto(esInicial);
		this.setResaltarDetalleMovimientoInventarioNovedadProducto(esInicial);
		this.setResaltarDetalleOrdenCompraNovedadProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleFacturaProveedor.class)) {
				this.setResaltarDetalleFacturaProveedorNovedadProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(NovedadSeguimiento.class)) {
				this.setResaltarNovedadSeguimientoNovedadProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleTransferencia.class)) {
				this.setResaltarDetalleTransferenciaNovedadProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleMovimientoInventario.class)) {
				this.setResaltarDetalleMovimientoInventarioNovedadProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleOrdenCompra.class)) {
				this.setResaltarDetalleOrdenCompraNovedadProducto(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoNovedadProducto=true;

	public Boolean getMostrarBusquedaPorCodigoNovedadProducto() {
		return this.mostrarBusquedaPorCodigoNovedadProducto;
	}

	public void setMostrarBusquedaPorCodigoNovedadProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoNovedadProducto= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreNovedadProducto=true;

	public Boolean getMostrarBusquedaPorNombreNovedadProducto() {
		return this.mostrarBusquedaPorNombreNovedadProducto;
	}

	public void setMostrarBusquedaPorNombreNovedadProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreNovedadProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaNovedadProducto=true;

	public Boolean getMostrarFK_IdEmpresaNovedadProducto() {
		return this.mostrarFK_IdEmpresaNovedadProducto;
	}

	public void setMostrarFK_IdEmpresaNovedadProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaNovedadProducto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoNovedadProducto=true;

	public Boolean getActivarBusquedaPorCodigoNovedadProducto() {
		return this.activarBusquedaPorCodigoNovedadProducto;
	}

	public void setActivarBusquedaPorCodigoNovedadProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoNovedadProducto= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreNovedadProducto=true;

	public Boolean getActivarBusquedaPorNombreNovedadProducto() {
		return this.activarBusquedaPorNombreNovedadProducto;
	}

	public void setActivarBusquedaPorNombreNovedadProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreNovedadProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaNovedadProducto=true;

	public Boolean getActivarFK_IdEmpresaNovedadProducto() {
		return this.activarFK_IdEmpresaNovedadProducto;
	}

	public void setActivarFK_IdEmpresaNovedadProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaNovedadProducto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoNovedadProducto=null;

	public Border getResaltarBusquedaPorCodigoNovedadProducto() {
		return this.resaltarBusquedaPorCodigoNovedadProducto;
	}

	public void setResaltarBusquedaPorCodigoNovedadProducto(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoNovedadProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoNovedadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadProductoBeanSwingJInternalFrame novedadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoNovedadProducto= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreNovedadProducto=null;

	public Border getResaltarBusquedaPorNombreNovedadProducto() {
		return this.resaltarBusquedaPorNombreNovedadProducto;
	}

	public void setResaltarBusquedaPorNombreNovedadProducto(Border borderResaltar) {
		this.resaltarBusquedaPorNombreNovedadProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreNovedadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadProductoBeanSwingJInternalFrame novedadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreNovedadProducto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaNovedadProducto=null;

	public Border getResaltarFK_IdEmpresaNovedadProducto() {
		return this.resaltarFK_IdEmpresaNovedadProducto;
	}

	public void setResaltarFK_IdEmpresaNovedadProducto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaNovedadProducto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaNovedadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadProductoBeanSwingJInternalFrame novedadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaNovedadProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}