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


import com.bydan.erp.nomina.util.VestimentaConstantesFunciones;
import com.bydan.erp.nomina.util.VestimentaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.VestimentaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class VestimentaConstantesFunciones extends VestimentaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Vestimenta";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Vestimenta"+VestimentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="VestimentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="VestimentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=VestimentaConstantesFunciones.SCHEMA+"_"+VestimentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/VestimentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=VestimentaConstantesFunciones.SCHEMA+"_"+VestimentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=VestimentaConstantesFunciones.SCHEMA+"_"+VestimentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/VestimentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=VestimentaConstantesFunciones.SCHEMA+"_"+VestimentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VestimentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VestimentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VestimentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VestimentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VestimentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VestimentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=VestimentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+VestimentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=VestimentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+VestimentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Vestimentas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Vestimenta";
	public static final String SCLASSWEBTITULO_LOWER="Vestimenta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Vestimenta";
	public static final String OBJECTNAME="vestimenta";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="vestimenta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select vestimenta from "+VestimentaConstantesFunciones.SPERSISTENCENAME+" vestimenta";
	public static String QUERYSELECTNATIVE="select "+VestimentaConstantesFunciones.SCHEMA+"."+VestimentaConstantesFunciones.TABLENAME+".id,"+VestimentaConstantesFunciones.SCHEMA+"."+VestimentaConstantesFunciones.TABLENAME+".version_row,"+VestimentaConstantesFunciones.SCHEMA+"."+VestimentaConstantesFunciones.TABLENAME+".id_empresa,"+VestimentaConstantesFunciones.SCHEMA+"."+VestimentaConstantesFunciones.TABLENAME+".nombre from "+VestimentaConstantesFunciones.SCHEMA+"."+VestimentaConstantesFunciones.TABLENAME;//+" as "+VestimentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected VestimentaConstantesFuncionesAdditional vestimentaConstantesFuncionesAdditional=null;
	
	public VestimentaConstantesFuncionesAdditional getVestimentaConstantesFuncionesAdditional() {
		return this.vestimentaConstantesFuncionesAdditional;
	}
	
	public void setVestimentaConstantesFuncionesAdditional(VestimentaConstantesFuncionesAdditional vestimentaConstantesFuncionesAdditional) {
		try {
			this.vestimentaConstantesFuncionesAdditional=vestimentaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getVestimentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(VestimentaConstantesFunciones.IDEMPRESA)) {sLabelColumna=VestimentaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(VestimentaConstantesFunciones.NOMBRE)) {sLabelColumna=VestimentaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getVestimentaDescripcion(Vestimenta vestimenta) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(vestimenta !=null/* && vestimenta.getId()!=0*/) {
			sDescripcion=vestimenta.getnombre();//vestimentavestimenta.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getVestimentaDescripcionDetallado(Vestimenta vestimenta) {
		String sDescripcion="";
			
		sDescripcion+=VestimentaConstantesFunciones.ID+"=";
		sDescripcion+=vestimenta.getId().toString()+",";
		sDescripcion+=VestimentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=vestimenta.getVersionRow().toString()+",";
		sDescripcion+=VestimentaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=vestimenta.getid_empresa().toString()+",";
		sDescripcion+=VestimentaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=vestimenta.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setVestimentaDescripcion(Vestimenta vestimenta,String sValor) throws Exception {			
		if(vestimenta !=null) {
			vestimenta.setnombre(sValor);;//vestimentavestimenta.getnombre().trim();
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
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
	
	
	
	
	
	
	public static void quitarEspaciosVestimenta(Vestimenta vestimenta,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		vestimenta.setnombre(vestimenta.getnombre().trim());
	}
	
	public static void quitarEspaciosVestimentas(List<Vestimenta> vestimentas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Vestimenta vestimenta: vestimentas) {
			vestimenta.setnombre(vestimenta.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVestimenta(Vestimenta vestimenta,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && vestimenta.getConCambioAuxiliar()) {
			vestimenta.setIsDeleted(vestimenta.getIsDeletedAuxiliar());	
			vestimenta.setIsNew(vestimenta.getIsNewAuxiliar());	
			vestimenta.setIsChanged(vestimenta.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			vestimenta.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			vestimenta.setIsDeletedAuxiliar(false);	
			vestimenta.setIsNewAuxiliar(false);	
			vestimenta.setIsChangedAuxiliar(false);
			
			vestimenta.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVestimentas(List<Vestimenta> vestimentas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Vestimenta vestimenta : vestimentas) {
			if(conAsignarBase && vestimenta.getConCambioAuxiliar()) {
				vestimenta.setIsDeleted(vestimenta.getIsDeletedAuxiliar());	
				vestimenta.setIsNew(vestimenta.getIsNewAuxiliar());	
				vestimenta.setIsChanged(vestimenta.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				vestimenta.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				vestimenta.setIsDeletedAuxiliar(false);	
				vestimenta.setIsNewAuxiliar(false);	
				vestimenta.setIsChangedAuxiliar(false);
				
				vestimenta.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresVestimenta(Vestimenta vestimenta,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresVestimentas(List<Vestimenta> vestimentas,Boolean conEnteros) throws Exception  {
		
		for(Vestimenta vestimenta: vestimentas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaVestimenta(List<Vestimenta> vestimentas,Vestimenta vestimentaAux) throws Exception  {
		VestimentaConstantesFunciones.InicializarValoresVestimenta(vestimentaAux,true);
		
		for(Vestimenta vestimenta: vestimentas) {
			if(vestimenta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVestimenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=VestimentaConstantesFunciones.getArrayColumnasGlobalesVestimenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesVestimenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VestimentaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VestimentaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoVestimenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Vestimenta> vestimentas,Vestimenta vestimenta,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Vestimenta vestimentaAux: vestimentas) {
			if(vestimentaAux!=null && vestimenta!=null) {
				if((vestimentaAux.getId()==null && vestimenta.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(vestimentaAux.getId()!=null && vestimenta.getId()!=null){
					if(vestimentaAux.getId().equals(vestimenta.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVestimenta(List<Vestimenta> vestimentas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Vestimenta vestimenta: vestimentas) {			
			if(vestimenta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaVestimenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,VestimentaConstantesFunciones.LABEL_ID, VestimentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VestimentaConstantesFunciones.LABEL_VERSIONROW, VestimentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VestimentaConstantesFunciones.LABEL_IDEMPRESA, VestimentaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VestimentaConstantesFunciones.LABEL_NOMBRE, VestimentaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasVestimenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=VestimentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VestimentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VestimentaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VestimentaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVestimenta() throws Exception  {
		return VestimentaConstantesFunciones.getTiposSeleccionarVestimenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVestimenta(Boolean conFk) throws Exception  {
		return VestimentaConstantesFunciones.getTiposSeleccionarVestimenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVestimenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VestimentaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(VestimentaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VestimentaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(VestimentaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesVestimenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesVestimenta(Vestimenta vestimentaAux) throws Exception {
		
			vestimentaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(vestimentaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesVestimenta(List<Vestimenta> vestimentasTemp) throws Exception {
		for(Vestimenta vestimentaAux:vestimentasTemp) {
			
			vestimentaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(vestimentaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfVestimenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfVestimenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfVestimenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return VestimentaConstantesFunciones.getClassesRelationshipsOfVestimenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVestimenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TallaVestido.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(TallaVestido.class)) {
						classes.add(new Classe(TallaVestido.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVestimenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return VestimentaConstantesFunciones.getClassesRelationshipsFromStringsOfVestimenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVestimenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(TallaVestido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TallaVestido.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(TallaVestido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TallaVestido.class)); continue;
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
	public static void actualizarLista(Vestimenta vestimenta,List<Vestimenta> vestimentas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Vestimenta vestimentaEncontrado=null;
			
			for(Vestimenta vestimentaLocal:vestimentas) {
				if(vestimentaLocal.getId().equals(vestimenta.getId())) {
					vestimentaEncontrado=vestimentaLocal;
					
					vestimentaLocal.setIsChanged(vestimenta.getIsChanged());
					vestimentaLocal.setIsNew(vestimenta.getIsNew());
					vestimentaLocal.setIsDeleted(vestimenta.getIsDeleted());
					
					vestimentaLocal.setGeneralEntityOriginal(vestimenta.getGeneralEntityOriginal());
					
					vestimentaLocal.setId(vestimenta.getId());	
					vestimentaLocal.setVersionRow(vestimenta.getVersionRow());	
					vestimentaLocal.setid_empresa(vestimenta.getid_empresa());	
					vestimentaLocal.setnombre(vestimenta.getnombre());	
					
					
					vestimentaLocal.setTallaVestidos(vestimenta.getTallaVestidos());
					
					existe=true;
					break;
				}
			}
			
			if(!vestimenta.getIsDeleted()) {
				if(!existe) {
					vestimentas.add(vestimenta);
				}
			} else {
				if(vestimentaEncontrado!=null && permiteQuitar)  {
					vestimentas.remove(vestimentaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Vestimenta vestimenta,List<Vestimenta> vestimentas) throws Exception {
		try	{			
			for(Vestimenta vestimentaLocal:vestimentas) {
				if(vestimentaLocal.getId().equals(vestimenta.getId())) {
					vestimentaLocal.setIsSelected(vestimenta.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesVestimenta(List<Vestimenta> vestimentasAux) throws Exception {
		//this.vestimentasAux=vestimentasAux;
		
		for(Vestimenta vestimentaAux:vestimentasAux) {
			if(vestimentaAux.getIsChanged()) {
				vestimentaAux.setIsChanged(false);
			}		
			
			if(vestimentaAux.getIsNew()) {
				vestimentaAux.setIsNew(false);
			}	
			
			if(vestimentaAux.getIsDeleted()) {
				vestimentaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesVestimenta(Vestimenta vestimentaAux) throws Exception {
		//this.vestimentaAux=vestimentaAux;
		
			if(vestimentaAux.getIsChanged()) {
				vestimentaAux.setIsChanged(false);
			}		
			
			if(vestimentaAux.getIsNew()) {
				vestimentaAux.setIsNew(false);
			}	
			
			if(vestimentaAux.getIsDeleted()) {
				vestimentaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Vestimenta vestimentaAsignar,Vestimenta vestimenta) throws Exception {
		vestimentaAsignar.setId(vestimenta.getId());	
		vestimentaAsignar.setVersionRow(vestimenta.getVersionRow());	
		vestimentaAsignar.setid_empresa(vestimenta.getid_empresa());
		vestimentaAsignar.setempresa_descripcion(vestimenta.getempresa_descripcion());	
		vestimentaAsignar.setnombre(vestimenta.getnombre());	
	}
	
	public static void inicializarVestimenta(Vestimenta vestimenta) throws Exception {
		try {
				vestimenta.setId(0L);	
					
				vestimenta.setid_empresa(-1L);	
				vestimenta.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderVestimenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(VestimentaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VestimentaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataVestimenta(String sTipo,Row row,Workbook workbook,Vestimenta vestimenta,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(vestimenta.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vestimenta.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryVestimenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryVestimenta() {
		return this.sFinalQueryVestimenta;
	}
	
	public void setsFinalQueryVestimenta(String sFinalQueryVestimenta) {
		this.sFinalQueryVestimenta= sFinalQueryVestimenta;
	}
	
	public Border resaltarSeleccionarVestimenta=null;
	
	public Border setResaltarSeleccionarVestimenta(ParametroGeneralUsuario parametroGeneralUsuario/*VestimentaBeanSwingJInternalFrame vestimentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//vestimentaBeanSwingJInternalFrame.jTtoolBarVestimenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarVestimenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarVestimenta() {
		return this.resaltarSeleccionarVestimenta;
	}
	
	public void setResaltarSeleccionarVestimenta(Border borderResaltarSeleccionarVestimenta) {
		this.resaltarSeleccionarVestimenta= borderResaltarSeleccionarVestimenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridVestimenta=null;
	public Boolean mostraridVestimenta=true;
	public Boolean activaridVestimenta=true;

	public Border resaltarid_empresaVestimenta=null;
	public Boolean mostrarid_empresaVestimenta=true;
	public Boolean activarid_empresaVestimenta=true;
	public Boolean cargarid_empresaVestimenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaVestimenta=false;//ConEventDepend=true

	public Border resaltarnombreVestimenta=null;
	public Boolean mostrarnombreVestimenta=true;
	public Boolean activarnombreVestimenta=true;

	
	

	public Border setResaltaridVestimenta(ParametroGeneralUsuario parametroGeneralUsuario/*VestimentaBeanSwingJInternalFrame vestimentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vestimentaBeanSwingJInternalFrame.jTtoolBarVestimenta.setBorder(borderResaltar);
		
		this.resaltaridVestimenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridVestimenta() {
		return this.resaltaridVestimenta;
	}

	public void setResaltaridVestimenta(Border borderResaltar) {
		this.resaltaridVestimenta= borderResaltar;
	}

	public Boolean getMostraridVestimenta() {
		return this.mostraridVestimenta;
	}

	public void setMostraridVestimenta(Boolean mostraridVestimenta) {
		this.mostraridVestimenta= mostraridVestimenta;
	}

	public Boolean getActivaridVestimenta() {
		return this.activaridVestimenta;
	}

	public void setActivaridVestimenta(Boolean activaridVestimenta) {
		this.activaridVestimenta= activaridVestimenta;
	}

	public Border setResaltarid_empresaVestimenta(ParametroGeneralUsuario parametroGeneralUsuario/*VestimentaBeanSwingJInternalFrame vestimentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vestimentaBeanSwingJInternalFrame.jTtoolBarVestimenta.setBorder(borderResaltar);
		
		this.resaltarid_empresaVestimenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaVestimenta() {
		return this.resaltarid_empresaVestimenta;
	}

	public void setResaltarid_empresaVestimenta(Border borderResaltar) {
		this.resaltarid_empresaVestimenta= borderResaltar;
	}

	public Boolean getMostrarid_empresaVestimenta() {
		return this.mostrarid_empresaVestimenta;
	}

	public void setMostrarid_empresaVestimenta(Boolean mostrarid_empresaVestimenta) {
		this.mostrarid_empresaVestimenta= mostrarid_empresaVestimenta;
	}

	public Boolean getActivarid_empresaVestimenta() {
		return this.activarid_empresaVestimenta;
	}

	public void setActivarid_empresaVestimenta(Boolean activarid_empresaVestimenta) {
		this.activarid_empresaVestimenta= activarid_empresaVestimenta;
	}

	public Boolean getCargarid_empresaVestimenta() {
		return this.cargarid_empresaVestimenta;
	}

	public void setCargarid_empresaVestimenta(Boolean cargarid_empresaVestimenta) {
		this.cargarid_empresaVestimenta= cargarid_empresaVestimenta;
	}

	public Border setResaltarnombreVestimenta(ParametroGeneralUsuario parametroGeneralUsuario/*VestimentaBeanSwingJInternalFrame vestimentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vestimentaBeanSwingJInternalFrame.jTtoolBarVestimenta.setBorder(borderResaltar);
		
		this.resaltarnombreVestimenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreVestimenta() {
		return this.resaltarnombreVestimenta;
	}

	public void setResaltarnombreVestimenta(Border borderResaltar) {
		this.resaltarnombreVestimenta= borderResaltar;
	}

	public Boolean getMostrarnombreVestimenta() {
		return this.mostrarnombreVestimenta;
	}

	public void setMostrarnombreVestimenta(Boolean mostrarnombreVestimenta) {
		this.mostrarnombreVestimenta= mostrarnombreVestimenta;
	}

	public Boolean getActivarnombreVestimenta() {
		return this.activarnombreVestimenta;
	}

	public void setActivarnombreVestimenta(Boolean activarnombreVestimenta) {
		this.activarnombreVestimenta= activarnombreVestimenta;
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
		
		
		this.setMostraridVestimenta(esInicial);
		this.setMostrarid_empresaVestimenta(esInicial);
		this.setMostrarnombreVestimenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VestimentaConstantesFunciones.ID)) {
				this.setMostraridVestimenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(VestimentaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaVestimenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(VestimentaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreVestimenta(esAsigna);
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
		
		
		this.setActivaridVestimenta(esInicial);
		this.setActivarid_empresaVestimenta(esInicial);
		this.setActivarnombreVestimenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VestimentaConstantesFunciones.ID)) {
				this.setActivaridVestimenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(VestimentaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaVestimenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(VestimentaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreVestimenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,VestimentaBeanSwingJInternalFrame vestimentaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridVestimenta(esInicial);
		this.setResaltarid_empresaVestimenta(esInicial);
		this.setResaltarnombreVestimenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VestimentaConstantesFunciones.ID)) {
				this.setResaltaridVestimenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(VestimentaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaVestimenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(VestimentaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreVestimenta(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarTallaVestidoVestimenta=null;

	public Border getResaltarTallaVestidoVestimenta() {
		return this.resaltarTallaVestidoVestimenta;
	}

	public void setResaltarTallaVestidoVestimenta(Border borderResaltarTallaVestido) {
		if(borderResaltarTallaVestido!=null) {
			this.resaltarTallaVestidoVestimenta= borderResaltarTallaVestido;
		}
	}

	public Border setResaltarTallaVestidoVestimenta(ParametroGeneralUsuario parametroGeneralUsuario/*VestimentaBeanSwingJInternalFrame vestimentaBeanSwingJInternalFrame*/) {
		Border borderResaltarTallaVestido=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//vestimentaBeanSwingJInternalFrame.jTtoolBarVestimenta.setBorder(borderResaltarTallaVestido);
			
		this.resaltarTallaVestidoVestimenta= borderResaltarTallaVestido;

		 return borderResaltarTallaVestido;
	}



	public Boolean mostrarTallaVestidoVestimenta=true;

	public Boolean getMostrarTallaVestidoVestimenta() {
		return this.mostrarTallaVestidoVestimenta;
	}

	public void setMostrarTallaVestidoVestimenta(Boolean visibilidadResaltarTallaVestido) {
		this.mostrarTallaVestidoVestimenta= visibilidadResaltarTallaVestido;
	}



	public Boolean activarTallaVestidoVestimenta=true;

	public Boolean gethabilitarResaltarTallaVestidoVestimenta() {
		return this.activarTallaVestidoVestimenta;
	}

	public void setActivarTallaVestidoVestimenta(Boolean habilitarResaltarTallaVestido) {
		this.activarTallaVestidoVestimenta= habilitarResaltarTallaVestido;
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

		this.setMostrarTallaVestidoVestimenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TallaVestido.class)) {
				this.setMostrarTallaVestidoVestimenta(esAsigna);
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

		this.setActivarTallaVestidoVestimenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TallaVestido.class)) {
				this.setActivarTallaVestidoVestimenta(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,VestimentaBeanSwingJInternalFrame vestimentaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarTallaVestidoVestimenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TallaVestido.class)) {
				this.setResaltarTallaVestidoVestimenta(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaVestimenta=true;

	public Boolean getMostrarFK_IdEmpresaVestimenta() {
		return this.mostrarFK_IdEmpresaVestimenta;
	}

	public void setMostrarFK_IdEmpresaVestimenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaVestimenta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaVestimenta=true;

	public Boolean getActivarFK_IdEmpresaVestimenta() {
		return this.activarFK_IdEmpresaVestimenta;
	}

	public void setActivarFK_IdEmpresaVestimenta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaVestimenta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaVestimenta=null;

	public Border getResaltarFK_IdEmpresaVestimenta() {
		return this.resaltarFK_IdEmpresaVestimenta;
	}

	public void setResaltarFK_IdEmpresaVestimenta(Border borderResaltar) {
		this.resaltarFK_IdEmpresaVestimenta= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaVestimenta(ParametroGeneralUsuario parametroGeneralUsuario/*VestimentaBeanSwingJInternalFrame vestimentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaVestimenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}