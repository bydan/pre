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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.LibroContableConstantesFunciones;
import com.bydan.erp.facturacion.util.LibroContableParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.LibroContableParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class LibroContableConstantesFunciones extends LibroContableConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="LibroContable";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="LibroContable"+LibroContableConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="LibroContableHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="LibroContableHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=LibroContableConstantesFunciones.SCHEMA+"_"+LibroContableConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/LibroContableHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=LibroContableConstantesFunciones.SCHEMA+"_"+LibroContableConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=LibroContableConstantesFunciones.SCHEMA+"_"+LibroContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/LibroContableHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=LibroContableConstantesFunciones.SCHEMA+"_"+LibroContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LibroContableConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/LibroContableHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LibroContableConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LibroContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/LibroContableHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LibroContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=LibroContableConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+LibroContableConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=LibroContableConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+LibroContableConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Libro Contables";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Libro Contable";
	public static final String SCLASSWEBTITULO_LOWER="Libro Contable";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="LibroContable";
	public static final String OBJECTNAME="librocontable";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="libro_contable";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select librocontable from "+LibroContableConstantesFunciones.SPERSISTENCENAME+" librocontable";
	public static String QUERYSELECTNATIVE="select "+LibroContableConstantesFunciones.SCHEMA+"."+LibroContableConstantesFunciones.TABLENAME+".id,"+LibroContableConstantesFunciones.SCHEMA+"."+LibroContableConstantesFunciones.TABLENAME+".version_row,"+LibroContableConstantesFunciones.SCHEMA+"."+LibroContableConstantesFunciones.TABLENAME+".id_empresa,"+LibroContableConstantesFunciones.SCHEMA+"."+LibroContableConstantesFunciones.TABLENAME+".codigo,"+LibroContableConstantesFunciones.SCHEMA+"."+LibroContableConstantesFunciones.TABLENAME+".nombre from "+LibroContableConstantesFunciones.SCHEMA+"."+LibroContableConstantesFunciones.TABLENAME;//+" as "+LibroContableConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected LibroContableConstantesFuncionesAdditional librocontableConstantesFuncionesAdditional=null;
	
	public LibroContableConstantesFuncionesAdditional getLibroContableConstantesFuncionesAdditional() {
		return this.librocontableConstantesFuncionesAdditional;
	}
	
	public void setLibroContableConstantesFuncionesAdditional(LibroContableConstantesFuncionesAdditional librocontableConstantesFuncionesAdditional) {
		try {
			this.librocontableConstantesFuncionesAdditional=librocontableConstantesFuncionesAdditional;
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
	
	public static String getLibroContableLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(LibroContableConstantesFunciones.IDEMPRESA)) {sLabelColumna=LibroContableConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(LibroContableConstantesFunciones.CODIGO)) {sLabelColumna=LibroContableConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(LibroContableConstantesFunciones.NOMBRE)) {sLabelColumna=LibroContableConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getLibroContableDescripcion(LibroContable librocontable) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(librocontable !=null/* && librocontable.getId()!=0*/) {
			sDescripcion=librocontable.getcodigo();//librocontablelibrocontable.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getLibroContableDescripcionDetallado(LibroContable librocontable) {
		String sDescripcion="";
			
		sDescripcion+=LibroContableConstantesFunciones.ID+"=";
		sDescripcion+=librocontable.getId().toString()+",";
		sDescripcion+=LibroContableConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=librocontable.getVersionRow().toString()+",";
		sDescripcion+=LibroContableConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=librocontable.getid_empresa().toString()+",";
		sDescripcion+=LibroContableConstantesFunciones.CODIGO+"=";
		sDescripcion+=librocontable.getcodigo()+",";
		sDescripcion+=LibroContableConstantesFunciones.NOMBRE+"=";
		sDescripcion+=librocontable.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setLibroContableDescripcion(LibroContable librocontable,String sValor) throws Exception {			
		if(librocontable !=null) {
			librocontable.setcodigo(sValor);;//librocontablelibrocontable.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosLibroContable(LibroContable librocontable,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		librocontable.setcodigo(librocontable.getcodigo().trim());
		librocontable.setnombre(librocontable.getnombre().trim());
	}
	
	public static void quitarEspaciosLibroContables(List<LibroContable> librocontables,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(LibroContable librocontable: librocontables) {
			librocontable.setcodigo(librocontable.getcodigo().trim());
			librocontable.setnombre(librocontable.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresLibroContable(LibroContable librocontable,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && librocontable.getConCambioAuxiliar()) {
			librocontable.setIsDeleted(librocontable.getIsDeletedAuxiliar());	
			librocontable.setIsNew(librocontable.getIsNewAuxiliar());	
			librocontable.setIsChanged(librocontable.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			librocontable.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			librocontable.setIsDeletedAuxiliar(false);	
			librocontable.setIsNewAuxiliar(false);	
			librocontable.setIsChangedAuxiliar(false);
			
			librocontable.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresLibroContables(List<LibroContable> librocontables,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(LibroContable librocontable : librocontables) {
			if(conAsignarBase && librocontable.getConCambioAuxiliar()) {
				librocontable.setIsDeleted(librocontable.getIsDeletedAuxiliar());	
				librocontable.setIsNew(librocontable.getIsNewAuxiliar());	
				librocontable.setIsChanged(librocontable.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				librocontable.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				librocontable.setIsDeletedAuxiliar(false);	
				librocontable.setIsNewAuxiliar(false);	
				librocontable.setIsChangedAuxiliar(false);
				
				librocontable.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresLibroContable(LibroContable librocontable,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresLibroContables(List<LibroContable> librocontables,Boolean conEnteros) throws Exception  {
		
		for(LibroContable librocontable: librocontables) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaLibroContable(List<LibroContable> librocontables,LibroContable librocontableAux) throws Exception  {
		LibroContableConstantesFunciones.InicializarValoresLibroContable(librocontableAux,true);
		
		for(LibroContable librocontable: librocontables) {
			if(librocontable.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesLibroContable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=LibroContableConstantesFunciones.getArrayColumnasGlobalesLibroContable(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesLibroContable(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(LibroContableConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(LibroContableConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoLibroContable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<LibroContable> librocontables,LibroContable librocontable,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(LibroContable librocontableAux: librocontables) {
			if(librocontableAux!=null && librocontable!=null) {
				if((librocontableAux.getId()==null && librocontable.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(librocontableAux.getId()!=null && librocontable.getId()!=null){
					if(librocontableAux.getId().equals(librocontable.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaLibroContable(List<LibroContable> librocontables) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(LibroContable librocontable: librocontables) {			
			if(librocontable.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaLibroContable() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,LibroContableConstantesFunciones.LABEL_ID, LibroContableConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LibroContableConstantesFunciones.LABEL_VERSIONROW, LibroContableConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LibroContableConstantesFunciones.LABEL_IDEMPRESA, LibroContableConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LibroContableConstantesFunciones.LABEL_CODIGO, LibroContableConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LibroContableConstantesFunciones.LABEL_NOMBRE, LibroContableConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasLibroContable() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=LibroContableConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LibroContableConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LibroContableConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LibroContableConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LibroContableConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLibroContable() throws Exception  {
		return LibroContableConstantesFunciones.getTiposSeleccionarLibroContable(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLibroContable(Boolean conFk) throws Exception  {
		return LibroContableConstantesFunciones.getTiposSeleccionarLibroContable(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLibroContable(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LibroContableConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(LibroContableConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LibroContableConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(LibroContableConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LibroContableConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(LibroContableConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesLibroContable(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesLibroContable(LibroContable librocontableAux) throws Exception {
		
			librocontableAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(librocontableAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesLibroContable(List<LibroContable> librocontablesTemp) throws Exception {
		for(LibroContable librocontableAux:librocontablesTemp) {
			
			librocontableAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(librocontableAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfLibroContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfLibroContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfLibroContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return LibroContableConstantesFunciones.getClassesRelationshipsOfLibroContable(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfLibroContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ParametroFactuPrincipal.class));
				classes.add(new Classe(Definicion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroFactuPrincipal.class)) {
						classes.add(new Classe(ParametroFactuPrincipal.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Definicion.class)) {
						classes.add(new Classe(Definicion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfLibroContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return LibroContableConstantesFunciones.getClassesRelationshipsFromStringsOfLibroContable(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfLibroContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroFactuPrincipal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroFactuPrincipal.class)); continue;
					}

					if(Definicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Definicion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroFactuPrincipal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroFactuPrincipal.class)); continue;
					}

					if(Definicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Definicion.class)); continue;
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
	public static void actualizarLista(LibroContable librocontable,List<LibroContable> librocontables,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			LibroContable librocontableEncontrado=null;
			
			for(LibroContable librocontableLocal:librocontables) {
				if(librocontableLocal.getId().equals(librocontable.getId())) {
					librocontableEncontrado=librocontableLocal;
					
					librocontableLocal.setIsChanged(librocontable.getIsChanged());
					librocontableLocal.setIsNew(librocontable.getIsNew());
					librocontableLocal.setIsDeleted(librocontable.getIsDeleted());
					
					librocontableLocal.setGeneralEntityOriginal(librocontable.getGeneralEntityOriginal());
					
					librocontableLocal.setId(librocontable.getId());	
					librocontableLocal.setVersionRow(librocontable.getVersionRow());	
					librocontableLocal.setid_empresa(librocontable.getid_empresa());	
					librocontableLocal.setcodigo(librocontable.getcodigo());	
					librocontableLocal.setnombre(librocontable.getnombre());	
					
					
					librocontableLocal.setParametroFactuPrincipals(librocontable.getParametroFactuPrincipals());
					librocontableLocal.setDefinicions(librocontable.getDefinicions());
					
					existe=true;
					break;
				}
			}
			
			if(!librocontable.getIsDeleted()) {
				if(!existe) {
					librocontables.add(librocontable);
				}
			} else {
				if(librocontableEncontrado!=null && permiteQuitar)  {
					librocontables.remove(librocontableEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(LibroContable librocontable,List<LibroContable> librocontables) throws Exception {
		try	{			
			for(LibroContable librocontableLocal:librocontables) {
				if(librocontableLocal.getId().equals(librocontable.getId())) {
					librocontableLocal.setIsSelected(librocontable.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesLibroContable(List<LibroContable> librocontablesAux) throws Exception {
		//this.librocontablesAux=librocontablesAux;
		
		for(LibroContable librocontableAux:librocontablesAux) {
			if(librocontableAux.getIsChanged()) {
				librocontableAux.setIsChanged(false);
			}		
			
			if(librocontableAux.getIsNew()) {
				librocontableAux.setIsNew(false);
			}	
			
			if(librocontableAux.getIsDeleted()) {
				librocontableAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesLibroContable(LibroContable librocontableAux) throws Exception {
		//this.librocontableAux=librocontableAux;
		
			if(librocontableAux.getIsChanged()) {
				librocontableAux.setIsChanged(false);
			}		
			
			if(librocontableAux.getIsNew()) {
				librocontableAux.setIsNew(false);
			}	
			
			if(librocontableAux.getIsDeleted()) {
				librocontableAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(LibroContable librocontableAsignar,LibroContable librocontable) throws Exception {
		librocontableAsignar.setId(librocontable.getId());	
		librocontableAsignar.setVersionRow(librocontable.getVersionRow());	
		librocontableAsignar.setid_empresa(librocontable.getid_empresa());
		librocontableAsignar.setempresa_descripcion(librocontable.getempresa_descripcion());	
		librocontableAsignar.setcodigo(librocontable.getcodigo());	
		librocontableAsignar.setnombre(librocontable.getnombre());	
	}
	
	public static void inicializarLibroContable(LibroContable librocontable) throws Exception {
		try {
				librocontable.setId(0L);	
					
				librocontable.setid_empresa(-1L);	
				librocontable.setcodigo("");	
				librocontable.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderLibroContable(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(LibroContableConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LibroContableConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LibroContableConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataLibroContable(String sTipo,Row row,Workbook workbook,LibroContable librocontable,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(librocontable.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(librocontable.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(librocontable.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryLibroContable=Constantes.SFINALQUERY;
	
	public String getsFinalQueryLibroContable() {
		return this.sFinalQueryLibroContable;
	}
	
	public void setsFinalQueryLibroContable(String sFinalQueryLibroContable) {
		this.sFinalQueryLibroContable= sFinalQueryLibroContable;
	}
	
	public Border resaltarSeleccionarLibroContable=null;
	
	public Border setResaltarSeleccionarLibroContable(ParametroGeneralUsuario parametroGeneralUsuario/*LibroContableBeanSwingJInternalFrame librocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//librocontableBeanSwingJInternalFrame.jTtoolBarLibroContable.setBorder(borderResaltar);
		
		this.resaltarSeleccionarLibroContable= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarLibroContable() {
		return this.resaltarSeleccionarLibroContable;
	}
	
	public void setResaltarSeleccionarLibroContable(Border borderResaltarSeleccionarLibroContable) {
		this.resaltarSeleccionarLibroContable= borderResaltarSeleccionarLibroContable;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridLibroContable=null;
	public Boolean mostraridLibroContable=true;
	public Boolean activaridLibroContable=true;

	public Border resaltarid_empresaLibroContable=null;
	public Boolean mostrarid_empresaLibroContable=true;
	public Boolean activarid_empresaLibroContable=true;
	public Boolean cargarid_empresaLibroContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaLibroContable=false;//ConEventDepend=true

	public Border resaltarcodigoLibroContable=null;
	public Boolean mostrarcodigoLibroContable=true;
	public Boolean activarcodigoLibroContable=true;

	public Border resaltarnombreLibroContable=null;
	public Boolean mostrarnombreLibroContable=true;
	public Boolean activarnombreLibroContable=true;

	
	

	public Border setResaltaridLibroContable(ParametroGeneralUsuario parametroGeneralUsuario/*LibroContableBeanSwingJInternalFrame librocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//librocontableBeanSwingJInternalFrame.jTtoolBarLibroContable.setBorder(borderResaltar);
		
		this.resaltaridLibroContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridLibroContable() {
		return this.resaltaridLibroContable;
	}

	public void setResaltaridLibroContable(Border borderResaltar) {
		this.resaltaridLibroContable= borderResaltar;
	}

	public Boolean getMostraridLibroContable() {
		return this.mostraridLibroContable;
	}

	public void setMostraridLibroContable(Boolean mostraridLibroContable) {
		this.mostraridLibroContable= mostraridLibroContable;
	}

	public Boolean getActivaridLibroContable() {
		return this.activaridLibroContable;
	}

	public void setActivaridLibroContable(Boolean activaridLibroContable) {
		this.activaridLibroContable= activaridLibroContable;
	}

	public Border setResaltarid_empresaLibroContable(ParametroGeneralUsuario parametroGeneralUsuario/*LibroContableBeanSwingJInternalFrame librocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//librocontableBeanSwingJInternalFrame.jTtoolBarLibroContable.setBorder(borderResaltar);
		
		this.resaltarid_empresaLibroContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaLibroContable() {
		return this.resaltarid_empresaLibroContable;
	}

	public void setResaltarid_empresaLibroContable(Border borderResaltar) {
		this.resaltarid_empresaLibroContable= borderResaltar;
	}

	public Boolean getMostrarid_empresaLibroContable() {
		return this.mostrarid_empresaLibroContable;
	}

	public void setMostrarid_empresaLibroContable(Boolean mostrarid_empresaLibroContable) {
		this.mostrarid_empresaLibroContable= mostrarid_empresaLibroContable;
	}

	public Boolean getActivarid_empresaLibroContable() {
		return this.activarid_empresaLibroContable;
	}

	public void setActivarid_empresaLibroContable(Boolean activarid_empresaLibroContable) {
		this.activarid_empresaLibroContable= activarid_empresaLibroContable;
	}

	public Boolean getCargarid_empresaLibroContable() {
		return this.cargarid_empresaLibroContable;
	}

	public void setCargarid_empresaLibroContable(Boolean cargarid_empresaLibroContable) {
		this.cargarid_empresaLibroContable= cargarid_empresaLibroContable;
	}

	public Border setResaltarcodigoLibroContable(ParametroGeneralUsuario parametroGeneralUsuario/*LibroContableBeanSwingJInternalFrame librocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//librocontableBeanSwingJInternalFrame.jTtoolBarLibroContable.setBorder(borderResaltar);
		
		this.resaltarcodigoLibroContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoLibroContable() {
		return this.resaltarcodigoLibroContable;
	}

	public void setResaltarcodigoLibroContable(Border borderResaltar) {
		this.resaltarcodigoLibroContable= borderResaltar;
	}

	public Boolean getMostrarcodigoLibroContable() {
		return this.mostrarcodigoLibroContable;
	}

	public void setMostrarcodigoLibroContable(Boolean mostrarcodigoLibroContable) {
		this.mostrarcodigoLibroContable= mostrarcodigoLibroContable;
	}

	public Boolean getActivarcodigoLibroContable() {
		return this.activarcodigoLibroContable;
	}

	public void setActivarcodigoLibroContable(Boolean activarcodigoLibroContable) {
		this.activarcodigoLibroContable= activarcodigoLibroContable;
	}

	public Border setResaltarnombreLibroContable(ParametroGeneralUsuario parametroGeneralUsuario/*LibroContableBeanSwingJInternalFrame librocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//librocontableBeanSwingJInternalFrame.jTtoolBarLibroContable.setBorder(borderResaltar);
		
		this.resaltarnombreLibroContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreLibroContable() {
		return this.resaltarnombreLibroContable;
	}

	public void setResaltarnombreLibroContable(Border borderResaltar) {
		this.resaltarnombreLibroContable= borderResaltar;
	}

	public Boolean getMostrarnombreLibroContable() {
		return this.mostrarnombreLibroContable;
	}

	public void setMostrarnombreLibroContable(Boolean mostrarnombreLibroContable) {
		this.mostrarnombreLibroContable= mostrarnombreLibroContable;
	}

	public Boolean getActivarnombreLibroContable() {
		return this.activarnombreLibroContable;
	}

	public void setActivarnombreLibroContable(Boolean activarnombreLibroContable) {
		this.activarnombreLibroContable= activarnombreLibroContable;
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
		
		
		this.setMostraridLibroContable(esInicial);
		this.setMostrarid_empresaLibroContable(esInicial);
		this.setMostrarcodigoLibroContable(esInicial);
		this.setMostrarnombreLibroContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LibroContableConstantesFunciones.ID)) {
				this.setMostraridLibroContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(LibroContableConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaLibroContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(LibroContableConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoLibroContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(LibroContableConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreLibroContable(esAsigna);
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
		
		
		this.setActivaridLibroContable(esInicial);
		this.setActivarid_empresaLibroContable(esInicial);
		this.setActivarcodigoLibroContable(esInicial);
		this.setActivarnombreLibroContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LibroContableConstantesFunciones.ID)) {
				this.setActivaridLibroContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(LibroContableConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaLibroContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(LibroContableConstantesFunciones.CODIGO)) {
				this.setActivarcodigoLibroContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(LibroContableConstantesFunciones.NOMBRE)) {
				this.setActivarnombreLibroContable(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,LibroContableBeanSwingJInternalFrame librocontableBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridLibroContable(esInicial);
		this.setResaltarid_empresaLibroContable(esInicial);
		this.setResaltarcodigoLibroContable(esInicial);
		this.setResaltarnombreLibroContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LibroContableConstantesFunciones.ID)) {
				this.setResaltaridLibroContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(LibroContableConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaLibroContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(LibroContableConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoLibroContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(LibroContableConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreLibroContable(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarParametroFactuPrincipalLibroContable=null;

	public Border getResaltarParametroFactuPrincipalLibroContable() {
		return this.resaltarParametroFactuPrincipalLibroContable;
	}

	public void setResaltarParametroFactuPrincipalLibroContable(Border borderResaltarParametroFactuPrincipal) {
		if(borderResaltarParametroFactuPrincipal!=null) {
			this.resaltarParametroFactuPrincipalLibroContable= borderResaltarParametroFactuPrincipal;
		}
	}

	public Border setResaltarParametroFactuPrincipalLibroContable(ParametroGeneralUsuario parametroGeneralUsuario/*LibroContableBeanSwingJInternalFrame librocontableBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroFactuPrincipal=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//librocontableBeanSwingJInternalFrame.jTtoolBarLibroContable.setBorder(borderResaltarParametroFactuPrincipal);
			
		this.resaltarParametroFactuPrincipalLibroContable= borderResaltarParametroFactuPrincipal;

		 return borderResaltarParametroFactuPrincipal;
	}



	public Boolean mostrarParametroFactuPrincipalLibroContable=true;

	public Boolean getMostrarParametroFactuPrincipalLibroContable() {
		return this.mostrarParametroFactuPrincipalLibroContable;
	}

	public void setMostrarParametroFactuPrincipalLibroContable(Boolean visibilidadResaltarParametroFactuPrincipal) {
		this.mostrarParametroFactuPrincipalLibroContable= visibilidadResaltarParametroFactuPrincipal;
	}



	public Boolean activarParametroFactuPrincipalLibroContable=true;

	public Boolean gethabilitarResaltarParametroFactuPrincipalLibroContable() {
		return this.activarParametroFactuPrincipalLibroContable;
	}

	public void setActivarParametroFactuPrincipalLibroContable(Boolean habilitarResaltarParametroFactuPrincipal) {
		this.activarParametroFactuPrincipalLibroContable= habilitarResaltarParametroFactuPrincipal;
	}


	public Border resaltarDefinicionLibroContable=null;

	public Border getResaltarDefinicionLibroContable() {
		return this.resaltarDefinicionLibroContable;
	}

	public void setResaltarDefinicionLibroContable(Border borderResaltarDefinicion) {
		if(borderResaltarDefinicion!=null) {
			this.resaltarDefinicionLibroContable= borderResaltarDefinicion;
		}
	}

	public Border setResaltarDefinicionLibroContable(ParametroGeneralUsuario parametroGeneralUsuario/*LibroContableBeanSwingJInternalFrame librocontableBeanSwingJInternalFrame*/) {
		Border borderResaltarDefinicion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//librocontableBeanSwingJInternalFrame.jTtoolBarLibroContable.setBorder(borderResaltarDefinicion);
			
		this.resaltarDefinicionLibroContable= borderResaltarDefinicion;

		 return borderResaltarDefinicion;
	}



	public Boolean mostrarDefinicionLibroContable=true;

	public Boolean getMostrarDefinicionLibroContable() {
		return this.mostrarDefinicionLibroContable;
	}

	public void setMostrarDefinicionLibroContable(Boolean visibilidadResaltarDefinicion) {
		this.mostrarDefinicionLibroContable= visibilidadResaltarDefinicion;
	}



	public Boolean activarDefinicionLibroContable=true;

	public Boolean gethabilitarResaltarDefinicionLibroContable() {
		return this.activarDefinicionLibroContable;
	}

	public void setActivarDefinicionLibroContable(Boolean habilitarResaltarDefinicion) {
		this.activarDefinicionLibroContable= habilitarResaltarDefinicion;
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

		this.setMostrarParametroFactuPrincipalLibroContable(esInicial);
		this.setMostrarDefinicionLibroContable(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroFactuPrincipal.class)) {
				this.setMostrarParametroFactuPrincipalLibroContable(esAsigna);
				continue;
			}

			if(clase.clas.equals(Definicion.class)) {
				this.setMostrarDefinicionLibroContable(esAsigna);
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

		this.setActivarParametroFactuPrincipalLibroContable(esInicial);
		this.setActivarDefinicionLibroContable(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroFactuPrincipal.class)) {
				this.setActivarParametroFactuPrincipalLibroContable(esAsigna);
				continue;
			}

			if(clase.clas.equals(Definicion.class)) {
				this.setActivarDefinicionLibroContable(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,LibroContableBeanSwingJInternalFrame librocontableBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarParametroFactuPrincipalLibroContable(esInicial);
		this.setResaltarDefinicionLibroContable(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroFactuPrincipal.class)) {
				this.setResaltarParametroFactuPrincipalLibroContable(esAsigna);
				continue;
			}

			if(clase.clas.equals(Definicion.class)) {
				this.setResaltarDefinicionLibroContable(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoLibroContable=true;

	public Boolean getMostrarBusquedaPorCodigoLibroContable() {
		return this.mostrarBusquedaPorCodigoLibroContable;
	}

	public void setMostrarBusquedaPorCodigoLibroContable(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoLibroContable= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreLibroContable=true;

	public Boolean getMostrarBusquedaPorNombreLibroContable() {
		return this.mostrarBusquedaPorNombreLibroContable;
	}

	public void setMostrarBusquedaPorNombreLibroContable(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreLibroContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaLibroContable=true;

	public Boolean getMostrarFK_IdEmpresaLibroContable() {
		return this.mostrarFK_IdEmpresaLibroContable;
	}

	public void setMostrarFK_IdEmpresaLibroContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaLibroContable= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoLibroContable=true;

	public Boolean getActivarBusquedaPorCodigoLibroContable() {
		return this.activarBusquedaPorCodigoLibroContable;
	}

	public void setActivarBusquedaPorCodigoLibroContable(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoLibroContable= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreLibroContable=true;

	public Boolean getActivarBusquedaPorNombreLibroContable() {
		return this.activarBusquedaPorNombreLibroContable;
	}

	public void setActivarBusquedaPorNombreLibroContable(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreLibroContable= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaLibroContable=true;

	public Boolean getActivarFK_IdEmpresaLibroContable() {
		return this.activarFK_IdEmpresaLibroContable;
	}

	public void setActivarFK_IdEmpresaLibroContable(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaLibroContable= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoLibroContable=null;

	public Border getResaltarBusquedaPorCodigoLibroContable() {
		return this.resaltarBusquedaPorCodigoLibroContable;
	}

	public void setResaltarBusquedaPorCodigoLibroContable(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoLibroContable= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoLibroContable(ParametroGeneralUsuario parametroGeneralUsuario/*LibroContableBeanSwingJInternalFrame librocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoLibroContable= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreLibroContable=null;

	public Border getResaltarBusquedaPorNombreLibroContable() {
		return this.resaltarBusquedaPorNombreLibroContable;
	}

	public void setResaltarBusquedaPorNombreLibroContable(Border borderResaltar) {
		this.resaltarBusquedaPorNombreLibroContable= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreLibroContable(ParametroGeneralUsuario parametroGeneralUsuario/*LibroContableBeanSwingJInternalFrame librocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreLibroContable= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaLibroContable=null;

	public Border getResaltarFK_IdEmpresaLibroContable() {
		return this.resaltarFK_IdEmpresaLibroContable;
	}

	public void setResaltarFK_IdEmpresaLibroContable(Border borderResaltar) {
		this.resaltarFK_IdEmpresaLibroContable= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaLibroContable(ParametroGeneralUsuario parametroGeneralUsuario/*LibroContableBeanSwingJInternalFrame librocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaLibroContable= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}