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


import com.bydan.erp.facturacion.util.EspecialidadConstantesFunciones;
import com.bydan.erp.facturacion.util.EspecialidadParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.EspecialidadParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EspecialidadConstantesFunciones extends EspecialidadConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Especialidad";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Especialidad"+EspecialidadConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EspecialidadHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EspecialidadHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EspecialidadConstantesFunciones.SCHEMA+"_"+EspecialidadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EspecialidadHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EspecialidadConstantesFunciones.SCHEMA+"_"+EspecialidadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EspecialidadConstantesFunciones.SCHEMA+"_"+EspecialidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EspecialidadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EspecialidadConstantesFunciones.SCHEMA+"_"+EspecialidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EspecialidadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EspecialidadHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EspecialidadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EspecialidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EspecialidadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EspecialidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EspecialidadConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EspecialidadConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EspecialidadConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EspecialidadConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Especialidads";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Especialidad";
	public static final String SCLASSWEBTITULO_LOWER="Especialidad";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Especialidad";
	public static final String OBJECTNAME="especialidad";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="especialidad";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select especialidad from "+EspecialidadConstantesFunciones.SPERSISTENCENAME+" especialidad";
	public static String QUERYSELECTNATIVE="select "+EspecialidadConstantesFunciones.SCHEMA+"."+EspecialidadConstantesFunciones.TABLENAME+".id,"+EspecialidadConstantesFunciones.SCHEMA+"."+EspecialidadConstantesFunciones.TABLENAME+".version_row,"+EspecialidadConstantesFunciones.SCHEMA+"."+EspecialidadConstantesFunciones.TABLENAME+".id_empresa,"+EspecialidadConstantesFunciones.SCHEMA+"."+EspecialidadConstantesFunciones.TABLENAME+".codigo,"+EspecialidadConstantesFunciones.SCHEMA+"."+EspecialidadConstantesFunciones.TABLENAME+".nombre,"+EspecialidadConstantesFunciones.SCHEMA+"."+EspecialidadConstantesFunciones.TABLENAME+".descripcion from "+EspecialidadConstantesFunciones.SCHEMA+"."+EspecialidadConstantesFunciones.TABLENAME;//+" as "+EspecialidadConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EspecialidadConstantesFuncionesAdditional especialidadConstantesFuncionesAdditional=null;
	
	public EspecialidadConstantesFuncionesAdditional getEspecialidadConstantesFuncionesAdditional() {
		return this.especialidadConstantesFuncionesAdditional;
	}
	
	public void setEspecialidadConstantesFuncionesAdditional(EspecialidadConstantesFuncionesAdditional especialidadConstantesFuncionesAdditional) {
		try {
			this.especialidadConstantesFuncionesAdditional=especialidadConstantesFuncionesAdditional;
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
    	public static final String LABEL_VERSIONROW= "Versionrow";
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
	
	public static String getEspecialidadLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EspecialidadConstantesFunciones.IDEMPRESA)) {sLabelColumna=EspecialidadConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EspecialidadConstantesFunciones.CODIGO)) {sLabelColumna=EspecialidadConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EspecialidadConstantesFunciones.NOMBRE)) {sLabelColumna=EspecialidadConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(EspecialidadConstantesFunciones.DESCRIPCION)) {sLabelColumna=EspecialidadConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getEspecialidadDescripcion(Especialidad especialidad) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(especialidad !=null/* && especialidad.getId()!=0*/) {
			sDescripcion=especialidad.getcodigo();//especialidadespecialidad.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEspecialidadDescripcionDetallado(Especialidad especialidad) {
		String sDescripcion="";
			
		sDescripcion+=EspecialidadConstantesFunciones.ID+"=";
		sDescripcion+=especialidad.getId().toString()+",";
		sDescripcion+=EspecialidadConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=especialidad.getVersionRow().toString()+",";
		sDescripcion+=EspecialidadConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=especialidad.getid_empresa().toString()+",";
		sDescripcion+=EspecialidadConstantesFunciones.CODIGO+"=";
		sDescripcion+=especialidad.getcodigo()+",";
		sDescripcion+=EspecialidadConstantesFunciones.NOMBRE+"=";
		sDescripcion+=especialidad.getnombre()+",";
		sDescripcion+=EspecialidadConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=especialidad.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setEspecialidadDescripcion(Especialidad especialidad,String sValor) throws Exception {			
		if(especialidad !=null) {
			especialidad.setcodigo(sValor);;//especialidadespecialidad.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEspecialidad(Especialidad especialidad,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		especialidad.setcodigo(especialidad.getcodigo().trim());
		especialidad.setnombre(especialidad.getnombre().trim());
		especialidad.setdescripcion(especialidad.getdescripcion().trim());
	}
	
	public static void quitarEspaciosEspecialidads(List<Especialidad> especialidads,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Especialidad especialidad: especialidads) {
			especialidad.setcodigo(especialidad.getcodigo().trim());
			especialidad.setnombre(especialidad.getnombre().trim());
			especialidad.setdescripcion(especialidad.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEspecialidad(Especialidad especialidad,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && especialidad.getConCambioAuxiliar()) {
			especialidad.setIsDeleted(especialidad.getIsDeletedAuxiliar());	
			especialidad.setIsNew(especialidad.getIsNewAuxiliar());	
			especialidad.setIsChanged(especialidad.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			especialidad.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			especialidad.setIsDeletedAuxiliar(false);	
			especialidad.setIsNewAuxiliar(false);	
			especialidad.setIsChangedAuxiliar(false);
			
			especialidad.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEspecialidads(List<Especialidad> especialidads,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Especialidad especialidad : especialidads) {
			if(conAsignarBase && especialidad.getConCambioAuxiliar()) {
				especialidad.setIsDeleted(especialidad.getIsDeletedAuxiliar());	
				especialidad.setIsNew(especialidad.getIsNewAuxiliar());	
				especialidad.setIsChanged(especialidad.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				especialidad.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				especialidad.setIsDeletedAuxiliar(false);	
				especialidad.setIsNewAuxiliar(false);	
				especialidad.setIsChangedAuxiliar(false);
				
				especialidad.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEspecialidad(Especialidad especialidad,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEspecialidads(List<Especialidad> especialidads,Boolean conEnteros) throws Exception  {
		
		for(Especialidad especialidad: especialidads) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEspecialidad(List<Especialidad> especialidads,Especialidad especialidadAux) throws Exception  {
		EspecialidadConstantesFunciones.InicializarValoresEspecialidad(especialidadAux,true);
		
		for(Especialidad especialidad: especialidads) {
			if(especialidad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEspecialidad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EspecialidadConstantesFunciones.getArrayColumnasGlobalesEspecialidad(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEspecialidad(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EspecialidadConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EspecialidadConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEspecialidad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Especialidad> especialidads,Especialidad especialidad,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Especialidad especialidadAux: especialidads) {
			if(especialidadAux!=null && especialidad!=null) {
				if((especialidadAux.getId()==null && especialidad.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(especialidadAux.getId()!=null && especialidad.getId()!=null){
					if(especialidadAux.getId().equals(especialidad.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEspecialidad(List<Especialidad> especialidads) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Especialidad especialidad: especialidads) {			
			if(especialidad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEspecialidad() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EspecialidadConstantesFunciones.LABEL_ID, EspecialidadConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EspecialidadConstantesFunciones.LABEL_VERSIONROW, EspecialidadConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EspecialidadConstantesFunciones.LABEL_IDEMPRESA, EspecialidadConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EspecialidadConstantesFunciones.LABEL_CODIGO, EspecialidadConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EspecialidadConstantesFunciones.LABEL_NOMBRE, EspecialidadConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EspecialidadConstantesFunciones.LABEL_DESCRIPCION, EspecialidadConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEspecialidad() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EspecialidadConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EspecialidadConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EspecialidadConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EspecialidadConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EspecialidadConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EspecialidadConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEspecialidad() throws Exception  {
		return EspecialidadConstantesFunciones.getTiposSeleccionarEspecialidad(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEspecialidad(Boolean conFk) throws Exception  {
		return EspecialidadConstantesFunciones.getTiposSeleccionarEspecialidad(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEspecialidad(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EspecialidadConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EspecialidadConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EspecialidadConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EspecialidadConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EspecialidadConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EspecialidadConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EspecialidadConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(EspecialidadConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEspecialidad(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEspecialidad(Especialidad especialidadAux) throws Exception {
		
			especialidadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(especialidadAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEspecialidad(List<Especialidad> especialidadsTemp) throws Exception {
		for(Especialidad especialidadAux:especialidadsTemp) {
			
			especialidadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(especialidadAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEspecialidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEspecialidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEspecialidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EspecialidadConstantesFunciones.getClassesRelationshipsOfEspecialidad(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEspecialidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEspecialidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EspecialidadConstantesFunciones.getClassesRelationshipsFromStringsOfEspecialidad(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEspecialidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Especialidad especialidad,List<Especialidad> especialidads,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Especialidad especialidadEncontrado=null;
			
			for(Especialidad especialidadLocal:especialidads) {
				if(especialidadLocal.getId().equals(especialidad.getId())) {
					especialidadEncontrado=especialidadLocal;
					
					especialidadLocal.setIsChanged(especialidad.getIsChanged());
					especialidadLocal.setIsNew(especialidad.getIsNew());
					especialidadLocal.setIsDeleted(especialidad.getIsDeleted());
					
					especialidadLocal.setGeneralEntityOriginal(especialidad.getGeneralEntityOriginal());
					
					especialidadLocal.setId(especialidad.getId());	
					especialidadLocal.setVersionRow(especialidad.getVersionRow());	
					especialidadLocal.setid_empresa(especialidad.getid_empresa());	
					especialidadLocal.setcodigo(especialidad.getcodigo());	
					especialidadLocal.setnombre(especialidad.getnombre());	
					especialidadLocal.setdescripcion(especialidad.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!especialidad.getIsDeleted()) {
				if(!existe) {
					especialidads.add(especialidad);
				}
			} else {
				if(especialidadEncontrado!=null && permiteQuitar)  {
					especialidads.remove(especialidadEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Especialidad especialidad,List<Especialidad> especialidads) throws Exception {
		try	{			
			for(Especialidad especialidadLocal:especialidads) {
				if(especialidadLocal.getId().equals(especialidad.getId())) {
					especialidadLocal.setIsSelected(especialidad.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEspecialidad(List<Especialidad> especialidadsAux) throws Exception {
		//this.especialidadsAux=especialidadsAux;
		
		for(Especialidad especialidadAux:especialidadsAux) {
			if(especialidadAux.getIsChanged()) {
				especialidadAux.setIsChanged(false);
			}		
			
			if(especialidadAux.getIsNew()) {
				especialidadAux.setIsNew(false);
			}	
			
			if(especialidadAux.getIsDeleted()) {
				especialidadAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEspecialidad(Especialidad especialidadAux) throws Exception {
		//this.especialidadAux=especialidadAux;
		
			if(especialidadAux.getIsChanged()) {
				especialidadAux.setIsChanged(false);
			}		
			
			if(especialidadAux.getIsNew()) {
				especialidadAux.setIsNew(false);
			}	
			
			if(especialidadAux.getIsDeleted()) {
				especialidadAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Especialidad especialidadAsignar,Especialidad especialidad) throws Exception {
		especialidadAsignar.setId(especialidad.getId());	
		especialidadAsignar.setVersionRow(especialidad.getVersionRow());	
		especialidadAsignar.setid_empresa(especialidad.getid_empresa());
		especialidadAsignar.setempresa_descripcion(especialidad.getempresa_descripcion());	
		especialidadAsignar.setcodigo(especialidad.getcodigo());	
		especialidadAsignar.setnombre(especialidad.getnombre());	
		especialidadAsignar.setdescripcion(especialidad.getdescripcion());	
	}
	
	public static void inicializarEspecialidad(Especialidad especialidad) throws Exception {
		try {
				especialidad.setId(0L);	
					
				especialidad.setid_empresa(-1L);	
				especialidad.setcodigo("");	
				especialidad.setnombre("");	
				especialidad.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEspecialidad(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EspecialidadConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EspecialidadConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EspecialidadConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EspecialidadConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEspecialidad(String sTipo,Row row,Workbook workbook,Especialidad especialidad,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(especialidad.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(especialidad.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(especialidad.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(especialidad.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEspecialidad=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEspecialidad() {
		return this.sFinalQueryEspecialidad;
	}
	
	public void setsFinalQueryEspecialidad(String sFinalQueryEspecialidad) {
		this.sFinalQueryEspecialidad= sFinalQueryEspecialidad;
	}
	
	public Border resaltarSeleccionarEspecialidad=null;
	
	public Border setResaltarSeleccionarEspecialidad(ParametroGeneralUsuario parametroGeneralUsuario/*EspecialidadBeanSwingJInternalFrame especialidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//especialidadBeanSwingJInternalFrame.jTtoolBarEspecialidad.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEspecialidad= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEspecialidad() {
		return this.resaltarSeleccionarEspecialidad;
	}
	
	public void setResaltarSeleccionarEspecialidad(Border borderResaltarSeleccionarEspecialidad) {
		this.resaltarSeleccionarEspecialidad= borderResaltarSeleccionarEspecialidad;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEspecialidad=null;
	public Boolean mostraridEspecialidad=true;
	public Boolean activaridEspecialidad=true;

	public Border resaltarid_empresaEspecialidad=null;
	public Boolean mostrarid_empresaEspecialidad=true;
	public Boolean activarid_empresaEspecialidad=true;
	public Boolean cargarid_empresaEspecialidad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEspecialidad=false;//ConEventDepend=true

	public Border resaltarcodigoEspecialidad=null;
	public Boolean mostrarcodigoEspecialidad=true;
	public Boolean activarcodigoEspecialidad=true;

	public Border resaltarnombreEspecialidad=null;
	public Boolean mostrarnombreEspecialidad=true;
	public Boolean activarnombreEspecialidad=true;

	public Border resaltardescripcionEspecialidad=null;
	public Boolean mostrardescripcionEspecialidad=true;
	public Boolean activardescripcionEspecialidad=true;

	
	

	public Border setResaltaridEspecialidad(ParametroGeneralUsuario parametroGeneralUsuario/*EspecialidadBeanSwingJInternalFrame especialidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//especialidadBeanSwingJInternalFrame.jTtoolBarEspecialidad.setBorder(borderResaltar);
		
		this.resaltaridEspecialidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEspecialidad() {
		return this.resaltaridEspecialidad;
	}

	public void setResaltaridEspecialidad(Border borderResaltar) {
		this.resaltaridEspecialidad= borderResaltar;
	}

	public Boolean getMostraridEspecialidad() {
		return this.mostraridEspecialidad;
	}

	public void setMostraridEspecialidad(Boolean mostraridEspecialidad) {
		this.mostraridEspecialidad= mostraridEspecialidad;
	}

	public Boolean getActivaridEspecialidad() {
		return this.activaridEspecialidad;
	}

	public void setActivaridEspecialidad(Boolean activaridEspecialidad) {
		this.activaridEspecialidad= activaridEspecialidad;
	}

	public Border setResaltarid_empresaEspecialidad(ParametroGeneralUsuario parametroGeneralUsuario/*EspecialidadBeanSwingJInternalFrame especialidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//especialidadBeanSwingJInternalFrame.jTtoolBarEspecialidad.setBorder(borderResaltar);
		
		this.resaltarid_empresaEspecialidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEspecialidad() {
		return this.resaltarid_empresaEspecialidad;
	}

	public void setResaltarid_empresaEspecialidad(Border borderResaltar) {
		this.resaltarid_empresaEspecialidad= borderResaltar;
	}

	public Boolean getMostrarid_empresaEspecialidad() {
		return this.mostrarid_empresaEspecialidad;
	}

	public void setMostrarid_empresaEspecialidad(Boolean mostrarid_empresaEspecialidad) {
		this.mostrarid_empresaEspecialidad= mostrarid_empresaEspecialidad;
	}

	public Boolean getActivarid_empresaEspecialidad() {
		return this.activarid_empresaEspecialidad;
	}

	public void setActivarid_empresaEspecialidad(Boolean activarid_empresaEspecialidad) {
		this.activarid_empresaEspecialidad= activarid_empresaEspecialidad;
	}

	public Boolean getCargarid_empresaEspecialidad() {
		return this.cargarid_empresaEspecialidad;
	}

	public void setCargarid_empresaEspecialidad(Boolean cargarid_empresaEspecialidad) {
		this.cargarid_empresaEspecialidad= cargarid_empresaEspecialidad;
	}

	public Border setResaltarcodigoEspecialidad(ParametroGeneralUsuario parametroGeneralUsuario/*EspecialidadBeanSwingJInternalFrame especialidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//especialidadBeanSwingJInternalFrame.jTtoolBarEspecialidad.setBorder(borderResaltar);
		
		this.resaltarcodigoEspecialidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEspecialidad() {
		return this.resaltarcodigoEspecialidad;
	}

	public void setResaltarcodigoEspecialidad(Border borderResaltar) {
		this.resaltarcodigoEspecialidad= borderResaltar;
	}

	public Boolean getMostrarcodigoEspecialidad() {
		return this.mostrarcodigoEspecialidad;
	}

	public void setMostrarcodigoEspecialidad(Boolean mostrarcodigoEspecialidad) {
		this.mostrarcodigoEspecialidad= mostrarcodigoEspecialidad;
	}

	public Boolean getActivarcodigoEspecialidad() {
		return this.activarcodigoEspecialidad;
	}

	public void setActivarcodigoEspecialidad(Boolean activarcodigoEspecialidad) {
		this.activarcodigoEspecialidad= activarcodigoEspecialidad;
	}

	public Border setResaltarnombreEspecialidad(ParametroGeneralUsuario parametroGeneralUsuario/*EspecialidadBeanSwingJInternalFrame especialidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//especialidadBeanSwingJInternalFrame.jTtoolBarEspecialidad.setBorder(borderResaltar);
		
		this.resaltarnombreEspecialidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEspecialidad() {
		return this.resaltarnombreEspecialidad;
	}

	public void setResaltarnombreEspecialidad(Border borderResaltar) {
		this.resaltarnombreEspecialidad= borderResaltar;
	}

	public Boolean getMostrarnombreEspecialidad() {
		return this.mostrarnombreEspecialidad;
	}

	public void setMostrarnombreEspecialidad(Boolean mostrarnombreEspecialidad) {
		this.mostrarnombreEspecialidad= mostrarnombreEspecialidad;
	}

	public Boolean getActivarnombreEspecialidad() {
		return this.activarnombreEspecialidad;
	}

	public void setActivarnombreEspecialidad(Boolean activarnombreEspecialidad) {
		this.activarnombreEspecialidad= activarnombreEspecialidad;
	}

	public Border setResaltardescripcionEspecialidad(ParametroGeneralUsuario parametroGeneralUsuario/*EspecialidadBeanSwingJInternalFrame especialidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//especialidadBeanSwingJInternalFrame.jTtoolBarEspecialidad.setBorder(borderResaltar);
		
		this.resaltardescripcionEspecialidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionEspecialidad() {
		return this.resaltardescripcionEspecialidad;
	}

	public void setResaltardescripcionEspecialidad(Border borderResaltar) {
		this.resaltardescripcionEspecialidad= borderResaltar;
	}

	public Boolean getMostrardescripcionEspecialidad() {
		return this.mostrardescripcionEspecialidad;
	}

	public void setMostrardescripcionEspecialidad(Boolean mostrardescripcionEspecialidad) {
		this.mostrardescripcionEspecialidad= mostrardescripcionEspecialidad;
	}

	public Boolean getActivardescripcionEspecialidad() {
		return this.activardescripcionEspecialidad;
	}

	public void setActivardescripcionEspecialidad(Boolean activardescripcionEspecialidad) {
		this.activardescripcionEspecialidad= activardescripcionEspecialidad;
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
		
		
		this.setMostraridEspecialidad(esInicial);
		this.setMostrarid_empresaEspecialidad(esInicial);
		this.setMostrarcodigoEspecialidad(esInicial);
		this.setMostrarnombreEspecialidad(esInicial);
		this.setMostrardescripcionEspecialidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EspecialidadConstantesFunciones.ID)) {
				this.setMostraridEspecialidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EspecialidadConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEspecialidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EspecialidadConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEspecialidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EspecialidadConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEspecialidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EspecialidadConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionEspecialidad(esAsigna);
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
		
		
		this.setActivaridEspecialidad(esInicial);
		this.setActivarid_empresaEspecialidad(esInicial);
		this.setActivarcodigoEspecialidad(esInicial);
		this.setActivarnombreEspecialidad(esInicial);
		this.setActivardescripcionEspecialidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EspecialidadConstantesFunciones.ID)) {
				this.setActivaridEspecialidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EspecialidadConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEspecialidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EspecialidadConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEspecialidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EspecialidadConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEspecialidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EspecialidadConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionEspecialidad(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EspecialidadBeanSwingJInternalFrame especialidadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEspecialidad(esInicial);
		this.setResaltarid_empresaEspecialidad(esInicial);
		this.setResaltarcodigoEspecialidad(esInicial);
		this.setResaltarnombreEspecialidad(esInicial);
		this.setResaltardescripcionEspecialidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EspecialidadConstantesFunciones.ID)) {
				this.setResaltaridEspecialidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EspecialidadConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEspecialidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EspecialidadConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEspecialidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EspecialidadConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEspecialidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EspecialidadConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionEspecialidad(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EspecialidadBeanSwingJInternalFrame especialidadBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoEspecialidad=true;

	public Boolean getMostrarBusquedaPorCodigoEspecialidad() {
		return this.mostrarBusquedaPorCodigoEspecialidad;
	}

	public void setMostrarBusquedaPorCodigoEspecialidad(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoEspecialidad= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreEspecialidad=true;

	public Boolean getMostrarBusquedaPorNombreEspecialidad() {
		return this.mostrarBusquedaPorNombreEspecialidad;
	}

	public void setMostrarBusquedaPorNombreEspecialidad(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreEspecialidad= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaEspecialidad=true;

	public Boolean getMostrarFK_IdEmpresaEspecialidad() {
		return this.mostrarFK_IdEmpresaEspecialidad;
	}

	public void setMostrarFK_IdEmpresaEspecialidad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEspecialidad= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoEspecialidad=true;

	public Boolean getActivarBusquedaPorCodigoEspecialidad() {
		return this.activarBusquedaPorCodigoEspecialidad;
	}

	public void setActivarBusquedaPorCodigoEspecialidad(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoEspecialidad= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreEspecialidad=true;

	public Boolean getActivarBusquedaPorNombreEspecialidad() {
		return this.activarBusquedaPorNombreEspecialidad;
	}

	public void setActivarBusquedaPorNombreEspecialidad(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreEspecialidad= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaEspecialidad=true;

	public Boolean getActivarFK_IdEmpresaEspecialidad() {
		return this.activarFK_IdEmpresaEspecialidad;
	}

	public void setActivarFK_IdEmpresaEspecialidad(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEspecialidad= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoEspecialidad=null;

	public Border getResaltarBusquedaPorCodigoEspecialidad() {
		return this.resaltarBusquedaPorCodigoEspecialidad;
	}

	public void setResaltarBusquedaPorCodigoEspecialidad(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoEspecialidad= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoEspecialidad(ParametroGeneralUsuario parametroGeneralUsuario/*EspecialidadBeanSwingJInternalFrame especialidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoEspecialidad= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreEspecialidad=null;

	public Border getResaltarBusquedaPorNombreEspecialidad() {
		return this.resaltarBusquedaPorNombreEspecialidad;
	}

	public void setResaltarBusquedaPorNombreEspecialidad(Border borderResaltar) {
		this.resaltarBusquedaPorNombreEspecialidad= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreEspecialidad(ParametroGeneralUsuario parametroGeneralUsuario/*EspecialidadBeanSwingJInternalFrame especialidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreEspecialidad= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaEspecialidad=null;

	public Border getResaltarFK_IdEmpresaEspecialidad() {
		return this.resaltarFK_IdEmpresaEspecialidad;
	}

	public void setResaltarFK_IdEmpresaEspecialidad(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEspecialidad= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEspecialidad(ParametroGeneralUsuario parametroGeneralUsuario/*EspecialidadBeanSwingJInternalFrame especialidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEspecialidad= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}