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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.HobbyConstantesFunciones;
import com.bydan.erp.nomina.util.HobbyParameterReturnGeneral;
//import com.bydan.erp.nomina.util.HobbyParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class HobbyConstantesFunciones extends HobbyConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Hobby";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Hobby"+HobbyConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="HobbyHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="HobbyHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=HobbyConstantesFunciones.SCHEMA+"_"+HobbyConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/HobbyHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=HobbyConstantesFunciones.SCHEMA+"_"+HobbyConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=HobbyConstantesFunciones.SCHEMA+"_"+HobbyConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/HobbyHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=HobbyConstantesFunciones.SCHEMA+"_"+HobbyConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HobbyConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/HobbyHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HobbyConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HobbyConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/HobbyHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HobbyConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=HobbyConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+HobbyConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=HobbyConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+HobbyConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Hobbyes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Hobby";
	public static final String SCLASSWEBTITULO_LOWER="Hobby";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Hobby";
	public static final String OBJECTNAME="hobby";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="hobby";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select hobby from "+HobbyConstantesFunciones.SPERSISTENCENAME+" hobby";
	public static String QUERYSELECTNATIVE="select "+HobbyConstantesFunciones.SCHEMA+"."+HobbyConstantesFunciones.TABLENAME+".id,"+HobbyConstantesFunciones.SCHEMA+"."+HobbyConstantesFunciones.TABLENAME+".version_row,"+HobbyConstantesFunciones.SCHEMA+"."+HobbyConstantesFunciones.TABLENAME+".id_empresa,"+HobbyConstantesFunciones.SCHEMA+"."+HobbyConstantesFunciones.TABLENAME+".codigo,"+HobbyConstantesFunciones.SCHEMA+"."+HobbyConstantesFunciones.TABLENAME+".nombre,"+HobbyConstantesFunciones.SCHEMA+"."+HobbyConstantesFunciones.TABLENAME+".descripcion from "+HobbyConstantesFunciones.SCHEMA+"."+HobbyConstantesFunciones.TABLENAME;//+" as "+HobbyConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected HobbyConstantesFuncionesAdditional hobbyConstantesFuncionesAdditional=null;
	
	public HobbyConstantesFuncionesAdditional getHobbyConstantesFuncionesAdditional() {
		return this.hobbyConstantesFuncionesAdditional;
	}
	
	public void setHobbyConstantesFuncionesAdditional(HobbyConstantesFuncionesAdditional hobbyConstantesFuncionesAdditional) {
		try {
			this.hobbyConstantesFuncionesAdditional=hobbyConstantesFuncionesAdditional;
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
	
	public static String getHobbyLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(HobbyConstantesFunciones.IDEMPRESA)) {sLabelColumna=HobbyConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(HobbyConstantesFunciones.CODIGO)) {sLabelColumna=HobbyConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(HobbyConstantesFunciones.NOMBRE)) {sLabelColumna=HobbyConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(HobbyConstantesFunciones.DESCRIPCION)) {sLabelColumna=HobbyConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getHobbyDescripcion(Hobby hobby) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(hobby !=null/* && hobby.getId()!=0*/) {
			sDescripcion=hobby.getcodigo()+"-"+hobby.getnombre();//hobbyhobby.getcodigo().trim()+"-"+hobby.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getHobbyDescripcionDetallado(Hobby hobby) {
		String sDescripcion="";
			
		sDescripcion+=HobbyConstantesFunciones.ID+"=";
		sDescripcion+=hobby.getId().toString()+",";
		sDescripcion+=HobbyConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=hobby.getVersionRow().toString()+",";
		sDescripcion+=HobbyConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=hobby.getid_empresa().toString()+",";
		sDescripcion+=HobbyConstantesFunciones.CODIGO+"=";
		sDescripcion+=hobby.getcodigo()+",";
		sDescripcion+=HobbyConstantesFunciones.NOMBRE+"=";
		sDescripcion+=hobby.getnombre()+",";
		sDescripcion+=HobbyConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=hobby.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setHobbyDescripcion(Hobby hobby,String sValor) throws Exception {			
		if(hobby !=null) {
			hobby.setcodigo(sValor);
hobby.setnombre(sValor);;//hobbyhobby.getcodigo().trim()+"-"+hobby.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosHobby(Hobby hobby,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		hobby.setcodigo(hobby.getcodigo().trim());
		hobby.setnombre(hobby.getnombre().trim());
		hobby.setdescripcion(hobby.getdescripcion().trim());
	}
	
	public static void quitarEspaciosHobbys(List<Hobby> hobbys,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Hobby hobby: hobbys) {
			hobby.setcodigo(hobby.getcodigo().trim());
			hobby.setnombre(hobby.getnombre().trim());
			hobby.setdescripcion(hobby.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresHobby(Hobby hobby,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && hobby.getConCambioAuxiliar()) {
			hobby.setIsDeleted(hobby.getIsDeletedAuxiliar());	
			hobby.setIsNew(hobby.getIsNewAuxiliar());	
			hobby.setIsChanged(hobby.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			hobby.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			hobby.setIsDeletedAuxiliar(false);	
			hobby.setIsNewAuxiliar(false);	
			hobby.setIsChangedAuxiliar(false);
			
			hobby.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresHobbys(List<Hobby> hobbys,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Hobby hobby : hobbys) {
			if(conAsignarBase && hobby.getConCambioAuxiliar()) {
				hobby.setIsDeleted(hobby.getIsDeletedAuxiliar());	
				hobby.setIsNew(hobby.getIsNewAuxiliar());	
				hobby.setIsChanged(hobby.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				hobby.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				hobby.setIsDeletedAuxiliar(false);	
				hobby.setIsNewAuxiliar(false);	
				hobby.setIsChangedAuxiliar(false);
				
				hobby.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresHobby(Hobby hobby,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresHobbys(List<Hobby> hobbys,Boolean conEnteros) throws Exception  {
		
		for(Hobby hobby: hobbys) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaHobby(List<Hobby> hobbys,Hobby hobbyAux) throws Exception  {
		HobbyConstantesFunciones.InicializarValoresHobby(hobbyAux,true);
		
		for(Hobby hobby: hobbys) {
			if(hobby.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesHobby(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=HobbyConstantesFunciones.getArrayColumnasGlobalesHobby(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesHobby(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(HobbyConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(HobbyConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoHobby(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Hobby> hobbys,Hobby hobby,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Hobby hobbyAux: hobbys) {
			if(hobbyAux!=null && hobby!=null) {
				if((hobbyAux.getId()==null && hobby.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(hobbyAux.getId()!=null && hobby.getId()!=null){
					if(hobbyAux.getId().equals(hobby.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaHobby(List<Hobby> hobbys) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Hobby hobby: hobbys) {			
			if(hobby.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaHobby() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,HobbyConstantesFunciones.LABEL_ID, HobbyConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HobbyConstantesFunciones.LABEL_VERSIONROW, HobbyConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HobbyConstantesFunciones.LABEL_IDEMPRESA, HobbyConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HobbyConstantesFunciones.LABEL_CODIGO, HobbyConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HobbyConstantesFunciones.LABEL_NOMBRE, HobbyConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HobbyConstantesFunciones.LABEL_DESCRIPCION, HobbyConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasHobby() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=HobbyConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HobbyConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HobbyConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HobbyConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HobbyConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HobbyConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHobby() throws Exception  {
		return HobbyConstantesFunciones.getTiposSeleccionarHobby(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHobby(Boolean conFk) throws Exception  {
		return HobbyConstantesFunciones.getTiposSeleccionarHobby(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHobby(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HobbyConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(HobbyConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HobbyConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(HobbyConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HobbyConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(HobbyConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HobbyConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(HobbyConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesHobby(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesHobby(Hobby hobbyAux) throws Exception {
		
			hobbyAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(hobbyAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesHobby(List<Hobby> hobbysTemp) throws Exception {
		for(Hobby hobbyAux:hobbysTemp) {
			
			hobbyAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(hobbyAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfHobby(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfHobby(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfHobby(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return HobbyConstantesFunciones.getClassesRelationshipsOfHobby(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfHobby(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(EmpleadoHobby.class));
				classes.add(new Classe(HobbyCliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(EmpleadoHobby.class)) {
						classes.add(new Classe(EmpleadoHobby.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(HobbyCliente.class)) {
						classes.add(new Classe(HobbyCliente.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfHobby(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return HobbyConstantesFunciones.getClassesRelationshipsFromStringsOfHobby(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfHobby(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(EmpleadoHobby.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoHobby.class)); continue;
					}

					if(HobbyCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(HobbyCliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(EmpleadoHobby.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoHobby.class)); continue;
					}

					if(HobbyCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(HobbyCliente.class)); continue;
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
	public static void actualizarLista(Hobby hobby,List<Hobby> hobbys,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Hobby hobbyEncontrado=null;
			
			for(Hobby hobbyLocal:hobbys) {
				if(hobbyLocal.getId().equals(hobby.getId())) {
					hobbyEncontrado=hobbyLocal;
					
					hobbyLocal.setIsChanged(hobby.getIsChanged());
					hobbyLocal.setIsNew(hobby.getIsNew());
					hobbyLocal.setIsDeleted(hobby.getIsDeleted());
					
					hobbyLocal.setGeneralEntityOriginal(hobby.getGeneralEntityOriginal());
					
					hobbyLocal.setId(hobby.getId());	
					hobbyLocal.setVersionRow(hobby.getVersionRow());	
					hobbyLocal.setid_empresa(hobby.getid_empresa());	
					hobbyLocal.setcodigo(hobby.getcodigo());	
					hobbyLocal.setnombre(hobby.getnombre());	
					hobbyLocal.setdescripcion(hobby.getdescripcion());	
					
					
					hobbyLocal.setEmpleadoHobbys(hobby.getEmpleadoHobbys());
					hobbyLocal.setHobbyClientes(hobby.getHobbyClientes());
					
					existe=true;
					break;
				}
			}
			
			if(!hobby.getIsDeleted()) {
				if(!existe) {
					hobbys.add(hobby);
				}
			} else {
				if(hobbyEncontrado!=null && permiteQuitar)  {
					hobbys.remove(hobbyEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Hobby hobby,List<Hobby> hobbys) throws Exception {
		try	{			
			for(Hobby hobbyLocal:hobbys) {
				if(hobbyLocal.getId().equals(hobby.getId())) {
					hobbyLocal.setIsSelected(hobby.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesHobby(List<Hobby> hobbysAux) throws Exception {
		//this.hobbysAux=hobbysAux;
		
		for(Hobby hobbyAux:hobbysAux) {
			if(hobbyAux.getIsChanged()) {
				hobbyAux.setIsChanged(false);
			}		
			
			if(hobbyAux.getIsNew()) {
				hobbyAux.setIsNew(false);
			}	
			
			if(hobbyAux.getIsDeleted()) {
				hobbyAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesHobby(Hobby hobbyAux) throws Exception {
		//this.hobbyAux=hobbyAux;
		
			if(hobbyAux.getIsChanged()) {
				hobbyAux.setIsChanged(false);
			}		
			
			if(hobbyAux.getIsNew()) {
				hobbyAux.setIsNew(false);
			}	
			
			if(hobbyAux.getIsDeleted()) {
				hobbyAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Hobby hobbyAsignar,Hobby hobby) throws Exception {
		hobbyAsignar.setId(hobby.getId());	
		hobbyAsignar.setVersionRow(hobby.getVersionRow());	
		hobbyAsignar.setid_empresa(hobby.getid_empresa());
		hobbyAsignar.setempresa_descripcion(hobby.getempresa_descripcion());	
		hobbyAsignar.setcodigo(hobby.getcodigo());	
		hobbyAsignar.setnombre(hobby.getnombre());	
		hobbyAsignar.setdescripcion(hobby.getdescripcion());	
	}
	
	public static void inicializarHobby(Hobby hobby) throws Exception {
		try {
				hobby.setId(0L);	
					
				hobby.setid_empresa(-1L);	
				hobby.setcodigo("");	
				hobby.setnombre("");	
				hobby.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderHobby(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(HobbyConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HobbyConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HobbyConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HobbyConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataHobby(String sTipo,Row row,Workbook workbook,Hobby hobby,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(hobby.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(hobby.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(hobby.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(hobby.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryHobby=Constantes.SFINALQUERY;
	
	public String getsFinalQueryHobby() {
		return this.sFinalQueryHobby;
	}
	
	public void setsFinalQueryHobby(String sFinalQueryHobby) {
		this.sFinalQueryHobby= sFinalQueryHobby;
	}
	
	public Border resaltarSeleccionarHobby=null;
	
	public Border setResaltarSeleccionarHobby(ParametroGeneralUsuario parametroGeneralUsuario/*HobbyBeanSwingJInternalFrame hobbyBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//hobbyBeanSwingJInternalFrame.jTtoolBarHobby.setBorder(borderResaltar);
		
		this.resaltarSeleccionarHobby= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarHobby() {
		return this.resaltarSeleccionarHobby;
	}
	
	public void setResaltarSeleccionarHobby(Border borderResaltarSeleccionarHobby) {
		this.resaltarSeleccionarHobby= borderResaltarSeleccionarHobby;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridHobby=null;
	public Boolean mostraridHobby=true;
	public Boolean activaridHobby=true;

	public Border resaltarid_empresaHobby=null;
	public Boolean mostrarid_empresaHobby=true;
	public Boolean activarid_empresaHobby=true;
	public Boolean cargarid_empresaHobby=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaHobby=false;//ConEventDepend=true

	public Border resaltarcodigoHobby=null;
	public Boolean mostrarcodigoHobby=true;
	public Boolean activarcodigoHobby=true;

	public Border resaltarnombreHobby=null;
	public Boolean mostrarnombreHobby=true;
	public Boolean activarnombreHobby=true;

	public Border resaltardescripcionHobby=null;
	public Boolean mostrardescripcionHobby=true;
	public Boolean activardescripcionHobby=true;

	
	

	public Border setResaltaridHobby(ParametroGeneralUsuario parametroGeneralUsuario/*HobbyBeanSwingJInternalFrame hobbyBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//hobbyBeanSwingJInternalFrame.jTtoolBarHobby.setBorder(borderResaltar);
		
		this.resaltaridHobby= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridHobby() {
		return this.resaltaridHobby;
	}

	public void setResaltaridHobby(Border borderResaltar) {
		this.resaltaridHobby= borderResaltar;
	}

	public Boolean getMostraridHobby() {
		return this.mostraridHobby;
	}

	public void setMostraridHobby(Boolean mostraridHobby) {
		this.mostraridHobby= mostraridHobby;
	}

	public Boolean getActivaridHobby() {
		return this.activaridHobby;
	}

	public void setActivaridHobby(Boolean activaridHobby) {
		this.activaridHobby= activaridHobby;
	}

	public Border setResaltarid_empresaHobby(ParametroGeneralUsuario parametroGeneralUsuario/*HobbyBeanSwingJInternalFrame hobbyBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//hobbyBeanSwingJInternalFrame.jTtoolBarHobby.setBorder(borderResaltar);
		
		this.resaltarid_empresaHobby= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaHobby() {
		return this.resaltarid_empresaHobby;
	}

	public void setResaltarid_empresaHobby(Border borderResaltar) {
		this.resaltarid_empresaHobby= borderResaltar;
	}

	public Boolean getMostrarid_empresaHobby() {
		return this.mostrarid_empresaHobby;
	}

	public void setMostrarid_empresaHobby(Boolean mostrarid_empresaHobby) {
		this.mostrarid_empresaHobby= mostrarid_empresaHobby;
	}

	public Boolean getActivarid_empresaHobby() {
		return this.activarid_empresaHobby;
	}

	public void setActivarid_empresaHobby(Boolean activarid_empresaHobby) {
		this.activarid_empresaHobby= activarid_empresaHobby;
	}

	public Boolean getCargarid_empresaHobby() {
		return this.cargarid_empresaHobby;
	}

	public void setCargarid_empresaHobby(Boolean cargarid_empresaHobby) {
		this.cargarid_empresaHobby= cargarid_empresaHobby;
	}

	public Border setResaltarcodigoHobby(ParametroGeneralUsuario parametroGeneralUsuario/*HobbyBeanSwingJInternalFrame hobbyBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//hobbyBeanSwingJInternalFrame.jTtoolBarHobby.setBorder(borderResaltar);
		
		this.resaltarcodigoHobby= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoHobby() {
		return this.resaltarcodigoHobby;
	}

	public void setResaltarcodigoHobby(Border borderResaltar) {
		this.resaltarcodigoHobby= borderResaltar;
	}

	public Boolean getMostrarcodigoHobby() {
		return this.mostrarcodigoHobby;
	}

	public void setMostrarcodigoHobby(Boolean mostrarcodigoHobby) {
		this.mostrarcodigoHobby= mostrarcodigoHobby;
	}

	public Boolean getActivarcodigoHobby() {
		return this.activarcodigoHobby;
	}

	public void setActivarcodigoHobby(Boolean activarcodigoHobby) {
		this.activarcodigoHobby= activarcodigoHobby;
	}

	public Border setResaltarnombreHobby(ParametroGeneralUsuario parametroGeneralUsuario/*HobbyBeanSwingJInternalFrame hobbyBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//hobbyBeanSwingJInternalFrame.jTtoolBarHobby.setBorder(borderResaltar);
		
		this.resaltarnombreHobby= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreHobby() {
		return this.resaltarnombreHobby;
	}

	public void setResaltarnombreHobby(Border borderResaltar) {
		this.resaltarnombreHobby= borderResaltar;
	}

	public Boolean getMostrarnombreHobby() {
		return this.mostrarnombreHobby;
	}

	public void setMostrarnombreHobby(Boolean mostrarnombreHobby) {
		this.mostrarnombreHobby= mostrarnombreHobby;
	}

	public Boolean getActivarnombreHobby() {
		return this.activarnombreHobby;
	}

	public void setActivarnombreHobby(Boolean activarnombreHobby) {
		this.activarnombreHobby= activarnombreHobby;
	}

	public Border setResaltardescripcionHobby(ParametroGeneralUsuario parametroGeneralUsuario/*HobbyBeanSwingJInternalFrame hobbyBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//hobbyBeanSwingJInternalFrame.jTtoolBarHobby.setBorder(borderResaltar);
		
		this.resaltardescripcionHobby= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionHobby() {
		return this.resaltardescripcionHobby;
	}

	public void setResaltardescripcionHobby(Border borderResaltar) {
		this.resaltardescripcionHobby= borderResaltar;
	}

	public Boolean getMostrardescripcionHobby() {
		return this.mostrardescripcionHobby;
	}

	public void setMostrardescripcionHobby(Boolean mostrardescripcionHobby) {
		this.mostrardescripcionHobby= mostrardescripcionHobby;
	}

	public Boolean getActivardescripcionHobby() {
		return this.activardescripcionHobby;
	}

	public void setActivardescripcionHobby(Boolean activardescripcionHobby) {
		this.activardescripcionHobby= activardescripcionHobby;
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
		
		
		this.setMostraridHobby(esInicial);
		this.setMostrarid_empresaHobby(esInicial);
		this.setMostrarcodigoHobby(esInicial);
		this.setMostrarnombreHobby(esInicial);
		this.setMostrardescripcionHobby(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HobbyConstantesFunciones.ID)) {
				this.setMostraridHobby(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaHobby(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoHobby(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreHobby(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionHobby(esAsigna);
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
		
		
		this.setActivaridHobby(esInicial);
		this.setActivarid_empresaHobby(esInicial);
		this.setActivarcodigoHobby(esInicial);
		this.setActivarnombreHobby(esInicial);
		this.setActivardescripcionHobby(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HobbyConstantesFunciones.ID)) {
				this.setActivaridHobby(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaHobby(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyConstantesFunciones.CODIGO)) {
				this.setActivarcodigoHobby(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyConstantesFunciones.NOMBRE)) {
				this.setActivarnombreHobby(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionHobby(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,HobbyBeanSwingJInternalFrame hobbyBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridHobby(esInicial);
		this.setResaltarid_empresaHobby(esInicial);
		this.setResaltarcodigoHobby(esInicial);
		this.setResaltarnombreHobby(esInicial);
		this.setResaltardescripcionHobby(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HobbyConstantesFunciones.ID)) {
				this.setResaltaridHobby(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaHobby(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoHobby(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreHobby(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionHobby(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarEmpleadoHobbyHobby=null;

	public Border getResaltarEmpleadoHobbyHobby() {
		return this.resaltarEmpleadoHobbyHobby;
	}

	public void setResaltarEmpleadoHobbyHobby(Border borderResaltarEmpleadoHobby) {
		if(borderResaltarEmpleadoHobby!=null) {
			this.resaltarEmpleadoHobbyHobby= borderResaltarEmpleadoHobby;
		}
	}

	public Border setResaltarEmpleadoHobbyHobby(ParametroGeneralUsuario parametroGeneralUsuario/*HobbyBeanSwingJInternalFrame hobbyBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleadoHobby=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//hobbyBeanSwingJInternalFrame.jTtoolBarHobby.setBorder(borderResaltarEmpleadoHobby);
			
		this.resaltarEmpleadoHobbyHobby= borderResaltarEmpleadoHobby;

		 return borderResaltarEmpleadoHobby;
	}



	public Boolean mostrarEmpleadoHobbyHobby=true;

	public Boolean getMostrarEmpleadoHobbyHobby() {
		return this.mostrarEmpleadoHobbyHobby;
	}

	public void setMostrarEmpleadoHobbyHobby(Boolean visibilidadResaltarEmpleadoHobby) {
		this.mostrarEmpleadoHobbyHobby= visibilidadResaltarEmpleadoHobby;
	}



	public Boolean activarEmpleadoHobbyHobby=true;

	public Boolean gethabilitarResaltarEmpleadoHobbyHobby() {
		return this.activarEmpleadoHobbyHobby;
	}

	public void setActivarEmpleadoHobbyHobby(Boolean habilitarResaltarEmpleadoHobby) {
		this.activarEmpleadoHobbyHobby= habilitarResaltarEmpleadoHobby;
	}


	public Border resaltarHobbyClienteHobby=null;

	public Border getResaltarHobbyClienteHobby() {
		return this.resaltarHobbyClienteHobby;
	}

	public void setResaltarHobbyClienteHobby(Border borderResaltarHobbyCliente) {
		if(borderResaltarHobbyCliente!=null) {
			this.resaltarHobbyClienteHobby= borderResaltarHobbyCliente;
		}
	}

	public Border setResaltarHobbyClienteHobby(ParametroGeneralUsuario parametroGeneralUsuario/*HobbyBeanSwingJInternalFrame hobbyBeanSwingJInternalFrame*/) {
		Border borderResaltarHobbyCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//hobbyBeanSwingJInternalFrame.jTtoolBarHobby.setBorder(borderResaltarHobbyCliente);
			
		this.resaltarHobbyClienteHobby= borderResaltarHobbyCliente;

		 return borderResaltarHobbyCliente;
	}



	public Boolean mostrarHobbyClienteHobby=true;

	public Boolean getMostrarHobbyClienteHobby() {
		return this.mostrarHobbyClienteHobby;
	}

	public void setMostrarHobbyClienteHobby(Boolean visibilidadResaltarHobbyCliente) {
		this.mostrarHobbyClienteHobby= visibilidadResaltarHobbyCliente;
	}



	public Boolean activarHobbyClienteHobby=true;

	public Boolean gethabilitarResaltarHobbyClienteHobby() {
		return this.activarHobbyClienteHobby;
	}

	public void setActivarHobbyClienteHobby(Boolean habilitarResaltarHobbyCliente) {
		this.activarHobbyClienteHobby= habilitarResaltarHobbyCliente;
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

		this.setMostrarEmpleadoHobbyHobby(esInicial);
		this.setMostrarHobbyClienteHobby(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(EmpleadoHobby.class)) {
				this.setMostrarEmpleadoHobbyHobby(esAsigna);
				continue;
			}

			if(clase.clas.equals(HobbyCliente.class)) {
				this.setMostrarHobbyClienteHobby(esAsigna);
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

		this.setActivarEmpleadoHobbyHobby(esInicial);
		this.setActivarHobbyClienteHobby(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(EmpleadoHobby.class)) {
				this.setActivarEmpleadoHobbyHobby(esAsigna);
				continue;
			}

			if(clase.clas.equals(HobbyCliente.class)) {
				this.setActivarHobbyClienteHobby(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,HobbyBeanSwingJInternalFrame hobbyBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarEmpleadoHobbyHobby(esInicial);
		this.setResaltarHobbyClienteHobby(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(EmpleadoHobby.class)) {
				this.setResaltarEmpleadoHobbyHobby(esAsigna);
				continue;
			}

			if(clase.clas.equals(HobbyCliente.class)) {
				this.setResaltarHobbyClienteHobby(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoHobby=true;

	public Boolean getMostrarBusquedaPorCodigoHobby() {
		return this.mostrarBusquedaPorCodigoHobby;
	}

	public void setMostrarBusquedaPorCodigoHobby(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoHobby= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreHobby=true;

	public Boolean getMostrarBusquedaPorNombreHobby() {
		return this.mostrarBusquedaPorNombreHobby;
	}

	public void setMostrarBusquedaPorNombreHobby(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreHobby= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaHobby=true;

	public Boolean getMostrarFK_IdEmpresaHobby() {
		return this.mostrarFK_IdEmpresaHobby;
	}

	public void setMostrarFK_IdEmpresaHobby(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaHobby= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoHobby=true;

	public Boolean getActivarBusquedaPorCodigoHobby() {
		return this.activarBusquedaPorCodigoHobby;
	}

	public void setActivarBusquedaPorCodigoHobby(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoHobby= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreHobby=true;

	public Boolean getActivarBusquedaPorNombreHobby() {
		return this.activarBusquedaPorNombreHobby;
	}

	public void setActivarBusquedaPorNombreHobby(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreHobby= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaHobby=true;

	public Boolean getActivarFK_IdEmpresaHobby() {
		return this.activarFK_IdEmpresaHobby;
	}

	public void setActivarFK_IdEmpresaHobby(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaHobby= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoHobby=null;

	public Border getResaltarBusquedaPorCodigoHobby() {
		return this.resaltarBusquedaPorCodigoHobby;
	}

	public void setResaltarBusquedaPorCodigoHobby(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoHobby= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoHobby(ParametroGeneralUsuario parametroGeneralUsuario/*HobbyBeanSwingJInternalFrame hobbyBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoHobby= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreHobby=null;

	public Border getResaltarBusquedaPorNombreHobby() {
		return this.resaltarBusquedaPorNombreHobby;
	}

	public void setResaltarBusquedaPorNombreHobby(Border borderResaltar) {
		this.resaltarBusquedaPorNombreHobby= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreHobby(ParametroGeneralUsuario parametroGeneralUsuario/*HobbyBeanSwingJInternalFrame hobbyBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreHobby= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaHobby=null;

	public Border getResaltarFK_IdEmpresaHobby() {
		return this.resaltarFK_IdEmpresaHobby;
	}

	public void setResaltarFK_IdEmpresaHobby(Border borderResaltar) {
		this.resaltarFK_IdEmpresaHobby= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaHobby(ParametroGeneralUsuario parametroGeneralUsuario/*HobbyBeanSwingJInternalFrame hobbyBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaHobby= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}