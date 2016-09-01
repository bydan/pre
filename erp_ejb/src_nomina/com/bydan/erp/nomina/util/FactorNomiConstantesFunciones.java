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


import com.bydan.erp.nomina.util.FactorNomiConstantesFunciones;
import com.bydan.erp.nomina.util.FactorNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.FactorNomiParameterGeneral;

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
final public class FactorNomiConstantesFunciones extends FactorNomiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="FactorNomi";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FactorNomi"+FactorNomiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FactorNomiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FactorNomiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FactorNomiConstantesFunciones.SCHEMA+"_"+FactorNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FactorNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FactorNomiConstantesFunciones.SCHEMA+"_"+FactorNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FactorNomiConstantesFunciones.SCHEMA+"_"+FactorNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FactorNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FactorNomiConstantesFunciones.SCHEMA+"_"+FactorNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FactorNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FactorNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FactorNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FactorNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FactorNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FactorNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FactorNomiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FactorNomiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FactorNomiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FactorNomiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Factor Nomis";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Factor Nomi";
	public static final String SCLASSWEBTITULO_LOWER="Factor Nomi";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FactorNomi";
	public static final String OBJECTNAME="factornomi";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="factor_nomi";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select factornomi from "+FactorNomiConstantesFunciones.SPERSISTENCENAME+" factornomi";
	public static String QUERYSELECTNATIVE="select "+FactorNomiConstantesFunciones.SCHEMA+"."+FactorNomiConstantesFunciones.TABLENAME+".id,"+FactorNomiConstantesFunciones.SCHEMA+"."+FactorNomiConstantesFunciones.TABLENAME+".version_row,"+FactorNomiConstantesFunciones.SCHEMA+"."+FactorNomiConstantesFunciones.TABLENAME+".id_empresa,"+FactorNomiConstantesFunciones.SCHEMA+"."+FactorNomiConstantesFunciones.TABLENAME+".nombre from "+FactorNomiConstantesFunciones.SCHEMA+"."+FactorNomiConstantesFunciones.TABLENAME;//+" as "+FactorNomiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected FactorNomiConstantesFuncionesAdditional factornomiConstantesFuncionesAdditional=null;
	
	public FactorNomiConstantesFuncionesAdditional getFactorNomiConstantesFuncionesAdditional() {
		return this.factornomiConstantesFuncionesAdditional;
	}
	
	public void setFactorNomiConstantesFuncionesAdditional(FactorNomiConstantesFuncionesAdditional factornomiConstantesFuncionesAdditional) {
		try {
			this.factornomiConstantesFuncionesAdditional=factornomiConstantesFuncionesAdditional;
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
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getFactorNomiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FactorNomiConstantesFunciones.IDEMPRESA)) {sLabelColumna=FactorNomiConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FactorNomiConstantesFunciones.NOMBRE)) {sLabelColumna=FactorNomiConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getFactorNomiDescripcion(FactorNomi factornomi) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(factornomi !=null/* && factornomi.getId()!=0*/) {
			sDescripcion=factornomi.getnombre();//factornomifactornomi.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getFactorNomiDescripcionDetallado(FactorNomi factornomi) {
		String sDescripcion="";
			
		sDescripcion+=FactorNomiConstantesFunciones.ID+"=";
		sDescripcion+=factornomi.getId().toString()+",";
		sDescripcion+=FactorNomiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=factornomi.getVersionRow().toString()+",";
		sDescripcion+=FactorNomiConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=factornomi.getid_empresa().toString()+",";
		sDescripcion+=FactorNomiConstantesFunciones.NOMBRE+"=";
		sDescripcion+=factornomi.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setFactorNomiDescripcion(FactorNomi factornomi,String sValor) throws Exception {			
		if(factornomi !=null) {
			factornomi.setnombre(sValor);;//factornomifactornomi.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosFactorNomi(FactorNomi factornomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		factornomi.setnombre(factornomi.getnombre().trim());
	}
	
	public static void quitarEspaciosFactorNomis(List<FactorNomi> factornomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FactorNomi factornomi: factornomis) {
			factornomi.setnombre(factornomi.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFactorNomi(FactorNomi factornomi,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && factornomi.getConCambioAuxiliar()) {
			factornomi.setIsDeleted(factornomi.getIsDeletedAuxiliar());	
			factornomi.setIsNew(factornomi.getIsNewAuxiliar());	
			factornomi.setIsChanged(factornomi.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			factornomi.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			factornomi.setIsDeletedAuxiliar(false);	
			factornomi.setIsNewAuxiliar(false);	
			factornomi.setIsChangedAuxiliar(false);
			
			factornomi.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFactorNomis(List<FactorNomi> factornomis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FactorNomi factornomi : factornomis) {
			if(conAsignarBase && factornomi.getConCambioAuxiliar()) {
				factornomi.setIsDeleted(factornomi.getIsDeletedAuxiliar());	
				factornomi.setIsNew(factornomi.getIsNewAuxiliar());	
				factornomi.setIsChanged(factornomi.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				factornomi.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				factornomi.setIsDeletedAuxiliar(false);	
				factornomi.setIsNewAuxiliar(false);	
				factornomi.setIsChangedAuxiliar(false);
				
				factornomi.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFactorNomi(FactorNomi factornomi,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFactorNomis(List<FactorNomi> factornomis,Boolean conEnteros) throws Exception  {
		
		for(FactorNomi factornomi: factornomis) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFactorNomi(List<FactorNomi> factornomis,FactorNomi factornomiAux) throws Exception  {
		FactorNomiConstantesFunciones.InicializarValoresFactorNomi(factornomiAux,true);
		
		for(FactorNomi factornomi: factornomis) {
			if(factornomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFactorNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FactorNomiConstantesFunciones.getArrayColumnasGlobalesFactorNomi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFactorNomi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FactorNomiConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FactorNomiConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFactorNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FactorNomi> factornomis,FactorNomi factornomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FactorNomi factornomiAux: factornomis) {
			if(factornomiAux!=null && factornomi!=null) {
				if((factornomiAux.getId()==null && factornomi.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(factornomiAux.getId()!=null && factornomi.getId()!=null){
					if(factornomiAux.getId().equals(factornomi.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFactorNomi(List<FactorNomi> factornomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(FactorNomi factornomi: factornomis) {			
			if(factornomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFactorNomi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FactorNomiConstantesFunciones.LABEL_ID, FactorNomiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FactorNomiConstantesFunciones.LABEL_VERSIONROW, FactorNomiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FactorNomiConstantesFunciones.LABEL_IDEMPRESA, FactorNomiConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FactorNomiConstantesFunciones.LABEL_NOMBRE, FactorNomiConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFactorNomi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FactorNomiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FactorNomiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FactorNomiConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FactorNomiConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFactorNomi() throws Exception  {
		return FactorNomiConstantesFunciones.getTiposSeleccionarFactorNomi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFactorNomi(Boolean conFk) throws Exception  {
		return FactorNomiConstantesFunciones.getTiposSeleccionarFactorNomi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFactorNomi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FactorNomiConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FactorNomiConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FactorNomiConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(FactorNomiConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFactorNomi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFactorNomi(FactorNomi factornomiAux) throws Exception {
		
			factornomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(factornomiAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFactorNomi(List<FactorNomi> factornomisTemp) throws Exception {
		for(FactorNomi factornomiAux:factornomisTemp) {
			
			factornomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(factornomiAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFactorNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFactorNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFactorNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FactorNomiConstantesFunciones.getClassesRelationshipsOfFactorNomi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFactorNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(FormatoNomiFactorNomi.class));
				classes.add(new Classe(PreguntaNomi.class));
				classes.add(new Classe(FormatoNomiPreguntaNomi.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(FormatoNomiFactorNomi.class)) {
						classes.add(new Classe(FormatoNomiFactorNomi.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PreguntaNomi.class)) {
						classes.add(new Classe(PreguntaNomi.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FormatoNomiPreguntaNomi.class)) {
						classes.add(new Classe(FormatoNomiPreguntaNomi.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFactorNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FactorNomiConstantesFunciones.getClassesRelationshipsFromStringsOfFactorNomi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFactorNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(FormatoNomiFactorNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomiFactorNomi.class)); continue;
					}

					if(PreguntaNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PreguntaNomi.class)); continue;
					}

					if(FormatoNomiPreguntaNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomiPreguntaNomi.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(FormatoNomiFactorNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomiFactorNomi.class)); continue;
					}

					if(PreguntaNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PreguntaNomi.class)); continue;
					}

					if(FormatoNomiPreguntaNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomiPreguntaNomi.class)); continue;
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
	public static void actualizarLista(FactorNomi factornomi,List<FactorNomi> factornomis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			FactorNomi factornomiEncontrado=null;
			
			for(FactorNomi factornomiLocal:factornomis) {
				if(factornomiLocal.getId().equals(factornomi.getId())) {
					factornomiEncontrado=factornomiLocal;
					
					factornomiLocal.setIsChanged(factornomi.getIsChanged());
					factornomiLocal.setIsNew(factornomi.getIsNew());
					factornomiLocal.setIsDeleted(factornomi.getIsDeleted());
					
					factornomiLocal.setGeneralEntityOriginal(factornomi.getGeneralEntityOriginal());
					
					factornomiLocal.setId(factornomi.getId());	
					factornomiLocal.setVersionRow(factornomi.getVersionRow());	
					factornomiLocal.setid_empresa(factornomi.getid_empresa());	
					factornomiLocal.setnombre(factornomi.getnombre());	
					
					
					factornomiLocal.setFormatoNomiFactorNomis(factornomi.getFormatoNomiFactorNomis());
					factornomiLocal.setPreguntaNomis(factornomi.getPreguntaNomis());
					factornomiLocal.setFormatoNomiPreguntaNomis(factornomi.getFormatoNomiPreguntaNomis());
					
					existe=true;
					break;
				}
			}
			
			if(!factornomi.getIsDeleted()) {
				if(!existe) {
					factornomis.add(factornomi);
				}
			} else {
				if(factornomiEncontrado!=null && permiteQuitar)  {
					factornomis.remove(factornomiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(FactorNomi factornomi,List<FactorNomi> factornomis) throws Exception {
		try	{			
			for(FactorNomi factornomiLocal:factornomis) {
				if(factornomiLocal.getId().equals(factornomi.getId())) {
					factornomiLocal.setIsSelected(factornomi.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFactorNomi(List<FactorNomi> factornomisAux) throws Exception {
		//this.factornomisAux=factornomisAux;
		
		for(FactorNomi factornomiAux:factornomisAux) {
			if(factornomiAux.getIsChanged()) {
				factornomiAux.setIsChanged(false);
			}		
			
			if(factornomiAux.getIsNew()) {
				factornomiAux.setIsNew(false);
			}	
			
			if(factornomiAux.getIsDeleted()) {
				factornomiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFactorNomi(FactorNomi factornomiAux) throws Exception {
		//this.factornomiAux=factornomiAux;
		
			if(factornomiAux.getIsChanged()) {
				factornomiAux.setIsChanged(false);
			}		
			
			if(factornomiAux.getIsNew()) {
				factornomiAux.setIsNew(false);
			}	
			
			if(factornomiAux.getIsDeleted()) {
				factornomiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FactorNomi factornomiAsignar,FactorNomi factornomi) throws Exception {
		factornomiAsignar.setId(factornomi.getId());	
		factornomiAsignar.setVersionRow(factornomi.getVersionRow());	
		factornomiAsignar.setid_empresa(factornomi.getid_empresa());
		factornomiAsignar.setempresa_descripcion(factornomi.getempresa_descripcion());	
		factornomiAsignar.setnombre(factornomi.getnombre());	
	}
	
	public static void inicializarFactorNomi(FactorNomi factornomi) throws Exception {
		try {
				factornomi.setId(0L);	
					
				factornomi.setid_empresa(-1L);	
				factornomi.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFactorNomi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FactorNomiConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FactorNomiConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFactorNomi(String sTipo,Row row,Workbook workbook,FactorNomi factornomi,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(factornomi.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factornomi.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFactorNomi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFactorNomi() {
		return this.sFinalQueryFactorNomi;
	}
	
	public void setsFinalQueryFactorNomi(String sFinalQueryFactorNomi) {
		this.sFinalQueryFactorNomi= sFinalQueryFactorNomi;
	}
	
	public Border resaltarSeleccionarFactorNomi=null;
	
	public Border setResaltarSeleccionarFactorNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FactorNomiBeanSwingJInternalFrame factornomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//factornomiBeanSwingJInternalFrame.jTtoolBarFactorNomi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFactorNomi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFactorNomi() {
		return this.resaltarSeleccionarFactorNomi;
	}
	
	public void setResaltarSeleccionarFactorNomi(Border borderResaltarSeleccionarFactorNomi) {
		this.resaltarSeleccionarFactorNomi= borderResaltarSeleccionarFactorNomi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFactorNomi=null;
	public Boolean mostraridFactorNomi=true;
	public Boolean activaridFactorNomi=true;

	public Border resaltarid_empresaFactorNomi=null;
	public Boolean mostrarid_empresaFactorNomi=true;
	public Boolean activarid_empresaFactorNomi=true;
	public Boolean cargarid_empresaFactorNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFactorNomi=false;//ConEventDepend=true

	public Border resaltarnombreFactorNomi=null;
	public Boolean mostrarnombreFactorNomi=true;
	public Boolean activarnombreFactorNomi=true;

	
	

	public Border setResaltaridFactorNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FactorNomiBeanSwingJInternalFrame factornomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//factornomiBeanSwingJInternalFrame.jTtoolBarFactorNomi.setBorder(borderResaltar);
		
		this.resaltaridFactorNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFactorNomi() {
		return this.resaltaridFactorNomi;
	}

	public void setResaltaridFactorNomi(Border borderResaltar) {
		this.resaltaridFactorNomi= borderResaltar;
	}

	public Boolean getMostraridFactorNomi() {
		return this.mostraridFactorNomi;
	}

	public void setMostraridFactorNomi(Boolean mostraridFactorNomi) {
		this.mostraridFactorNomi= mostraridFactorNomi;
	}

	public Boolean getActivaridFactorNomi() {
		return this.activaridFactorNomi;
	}

	public void setActivaridFactorNomi(Boolean activaridFactorNomi) {
		this.activaridFactorNomi= activaridFactorNomi;
	}

	public Border setResaltarid_empresaFactorNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FactorNomiBeanSwingJInternalFrame factornomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//factornomiBeanSwingJInternalFrame.jTtoolBarFactorNomi.setBorder(borderResaltar);
		
		this.resaltarid_empresaFactorNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFactorNomi() {
		return this.resaltarid_empresaFactorNomi;
	}

	public void setResaltarid_empresaFactorNomi(Border borderResaltar) {
		this.resaltarid_empresaFactorNomi= borderResaltar;
	}

	public Boolean getMostrarid_empresaFactorNomi() {
		return this.mostrarid_empresaFactorNomi;
	}

	public void setMostrarid_empresaFactorNomi(Boolean mostrarid_empresaFactorNomi) {
		this.mostrarid_empresaFactorNomi= mostrarid_empresaFactorNomi;
	}

	public Boolean getActivarid_empresaFactorNomi() {
		return this.activarid_empresaFactorNomi;
	}

	public void setActivarid_empresaFactorNomi(Boolean activarid_empresaFactorNomi) {
		this.activarid_empresaFactorNomi= activarid_empresaFactorNomi;
	}

	public Boolean getCargarid_empresaFactorNomi() {
		return this.cargarid_empresaFactorNomi;
	}

	public void setCargarid_empresaFactorNomi(Boolean cargarid_empresaFactorNomi) {
		this.cargarid_empresaFactorNomi= cargarid_empresaFactorNomi;
	}

	public Border setResaltarnombreFactorNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FactorNomiBeanSwingJInternalFrame factornomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//factornomiBeanSwingJInternalFrame.jTtoolBarFactorNomi.setBorder(borderResaltar);
		
		this.resaltarnombreFactorNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreFactorNomi() {
		return this.resaltarnombreFactorNomi;
	}

	public void setResaltarnombreFactorNomi(Border borderResaltar) {
		this.resaltarnombreFactorNomi= borderResaltar;
	}

	public Boolean getMostrarnombreFactorNomi() {
		return this.mostrarnombreFactorNomi;
	}

	public void setMostrarnombreFactorNomi(Boolean mostrarnombreFactorNomi) {
		this.mostrarnombreFactorNomi= mostrarnombreFactorNomi;
	}

	public Boolean getActivarnombreFactorNomi() {
		return this.activarnombreFactorNomi;
	}

	public void setActivarnombreFactorNomi(Boolean activarnombreFactorNomi) {
		this.activarnombreFactorNomi= activarnombreFactorNomi;
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
		
		
		this.setMostraridFactorNomi(esInicial);
		this.setMostrarid_empresaFactorNomi(esInicial);
		this.setMostrarnombreFactorNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FactorNomiConstantesFunciones.ID)) {
				this.setMostraridFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FactorNomiConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FactorNomiConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreFactorNomi(esAsigna);
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
		
		
		this.setActivaridFactorNomi(esInicial);
		this.setActivarid_empresaFactorNomi(esInicial);
		this.setActivarnombreFactorNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FactorNomiConstantesFunciones.ID)) {
				this.setActivaridFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FactorNomiConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FactorNomiConstantesFunciones.NOMBRE)) {
				this.setActivarnombreFactorNomi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FactorNomiBeanSwingJInternalFrame factornomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFactorNomi(esInicial);
		this.setResaltarid_empresaFactorNomi(esInicial);
		this.setResaltarnombreFactorNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FactorNomiConstantesFunciones.ID)) {
				this.setResaltaridFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FactorNomiConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFactorNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(FactorNomiConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreFactorNomi(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFormatoNomiFactorNomiFactorNomi=null;

	public Border getResaltarFormatoNomiFactorNomiFactorNomi() {
		return this.resaltarFormatoNomiFactorNomiFactorNomi;
	}

	public void setResaltarFormatoNomiFactorNomiFactorNomi(Border borderResaltarFormatoNomiFactorNomi) {
		if(borderResaltarFormatoNomiFactorNomi!=null) {
			this.resaltarFormatoNomiFactorNomiFactorNomi= borderResaltarFormatoNomiFactorNomi;
		}
	}

	public Border setResaltarFormatoNomiFactorNomiFactorNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FactorNomiBeanSwingJInternalFrame factornomiBeanSwingJInternalFrame*/) {
		Border borderResaltarFormatoNomiFactorNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//factornomiBeanSwingJInternalFrame.jTtoolBarFactorNomi.setBorder(borderResaltarFormatoNomiFactorNomi);
			
		this.resaltarFormatoNomiFactorNomiFactorNomi= borderResaltarFormatoNomiFactorNomi;

		 return borderResaltarFormatoNomiFactorNomi;
	}



	public Boolean mostrarFormatoNomiFactorNomiFactorNomi=true;

	public Boolean getMostrarFormatoNomiFactorNomiFactorNomi() {
		return this.mostrarFormatoNomiFactorNomiFactorNomi;
	}

	public void setMostrarFormatoNomiFactorNomiFactorNomi(Boolean visibilidadResaltarFormatoNomiFactorNomi) {
		this.mostrarFormatoNomiFactorNomiFactorNomi= visibilidadResaltarFormatoNomiFactorNomi;
	}



	public Boolean activarFormatoNomiFactorNomiFactorNomi=true;

	public Boolean gethabilitarResaltarFormatoNomiFactorNomiFactorNomi() {
		return this.activarFormatoNomiFactorNomiFactorNomi;
	}

	public void setActivarFormatoNomiFactorNomiFactorNomi(Boolean habilitarResaltarFormatoNomiFactorNomi) {
		this.activarFormatoNomiFactorNomiFactorNomi= habilitarResaltarFormatoNomiFactorNomi;
	}


	public Border resaltarPreguntaNomiFactorNomi=null;

	public Border getResaltarPreguntaNomiFactorNomi() {
		return this.resaltarPreguntaNomiFactorNomi;
	}

	public void setResaltarPreguntaNomiFactorNomi(Border borderResaltarPreguntaNomi) {
		if(borderResaltarPreguntaNomi!=null) {
			this.resaltarPreguntaNomiFactorNomi= borderResaltarPreguntaNomi;
		}
	}

	public Border setResaltarPreguntaNomiFactorNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FactorNomiBeanSwingJInternalFrame factornomiBeanSwingJInternalFrame*/) {
		Border borderResaltarPreguntaNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//factornomiBeanSwingJInternalFrame.jTtoolBarFactorNomi.setBorder(borderResaltarPreguntaNomi);
			
		this.resaltarPreguntaNomiFactorNomi= borderResaltarPreguntaNomi;

		 return borderResaltarPreguntaNomi;
	}



	public Boolean mostrarPreguntaNomiFactorNomi=true;

	public Boolean getMostrarPreguntaNomiFactorNomi() {
		return this.mostrarPreguntaNomiFactorNomi;
	}

	public void setMostrarPreguntaNomiFactorNomi(Boolean visibilidadResaltarPreguntaNomi) {
		this.mostrarPreguntaNomiFactorNomi= visibilidadResaltarPreguntaNomi;
	}



	public Boolean activarPreguntaNomiFactorNomi=true;

	public Boolean gethabilitarResaltarPreguntaNomiFactorNomi() {
		return this.activarPreguntaNomiFactorNomi;
	}

	public void setActivarPreguntaNomiFactorNomi(Boolean habilitarResaltarPreguntaNomi) {
		this.activarPreguntaNomiFactorNomi= habilitarResaltarPreguntaNomi;
	}


	public Border resaltarFormatoNomiPreguntaNomiFactorNomi=null;

	public Border getResaltarFormatoNomiPreguntaNomiFactorNomi() {
		return this.resaltarFormatoNomiPreguntaNomiFactorNomi;
	}

	public void setResaltarFormatoNomiPreguntaNomiFactorNomi(Border borderResaltarFormatoNomiPreguntaNomi) {
		if(borderResaltarFormatoNomiPreguntaNomi!=null) {
			this.resaltarFormatoNomiPreguntaNomiFactorNomi= borderResaltarFormatoNomiPreguntaNomi;
		}
	}

	public Border setResaltarFormatoNomiPreguntaNomiFactorNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FactorNomiBeanSwingJInternalFrame factornomiBeanSwingJInternalFrame*/) {
		Border borderResaltarFormatoNomiPreguntaNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//factornomiBeanSwingJInternalFrame.jTtoolBarFactorNomi.setBorder(borderResaltarFormatoNomiPreguntaNomi);
			
		this.resaltarFormatoNomiPreguntaNomiFactorNomi= borderResaltarFormatoNomiPreguntaNomi;

		 return borderResaltarFormatoNomiPreguntaNomi;
	}



	public Boolean mostrarFormatoNomiPreguntaNomiFactorNomi=true;

	public Boolean getMostrarFormatoNomiPreguntaNomiFactorNomi() {
		return this.mostrarFormatoNomiPreguntaNomiFactorNomi;
	}

	public void setMostrarFormatoNomiPreguntaNomiFactorNomi(Boolean visibilidadResaltarFormatoNomiPreguntaNomi) {
		this.mostrarFormatoNomiPreguntaNomiFactorNomi= visibilidadResaltarFormatoNomiPreguntaNomi;
	}



	public Boolean activarFormatoNomiPreguntaNomiFactorNomi=true;

	public Boolean gethabilitarResaltarFormatoNomiPreguntaNomiFactorNomi() {
		return this.activarFormatoNomiPreguntaNomiFactorNomi;
	}

	public void setActivarFormatoNomiPreguntaNomiFactorNomi(Boolean habilitarResaltarFormatoNomiPreguntaNomi) {
		this.activarFormatoNomiPreguntaNomiFactorNomi= habilitarResaltarFormatoNomiPreguntaNomi;
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

		this.setMostrarFormatoNomiFactorNomiFactorNomi(esInicial);
		this.setMostrarPreguntaNomiFactorNomi(esInicial);
		this.setMostrarFormatoNomiPreguntaNomiFactorNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormatoNomiFactorNomi.class)) {
				this.setMostrarFormatoNomiFactorNomiFactorNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(PreguntaNomi.class)) {
				this.setMostrarPreguntaNomiFactorNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormatoNomiPreguntaNomi.class)) {
				this.setMostrarFormatoNomiPreguntaNomiFactorNomi(esAsigna);
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

		this.setActivarFormatoNomiFactorNomiFactorNomi(esInicial);
		this.setActivarPreguntaNomiFactorNomi(esInicial);
		this.setActivarFormatoNomiPreguntaNomiFactorNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormatoNomiFactorNomi.class)) {
				this.setActivarFormatoNomiFactorNomiFactorNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(PreguntaNomi.class)) {
				this.setActivarPreguntaNomiFactorNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormatoNomiPreguntaNomi.class)) {
				this.setActivarFormatoNomiPreguntaNomiFactorNomi(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FactorNomiBeanSwingJInternalFrame factornomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFormatoNomiFactorNomiFactorNomi(esInicial);
		this.setResaltarPreguntaNomiFactorNomi(esInicial);
		this.setResaltarFormatoNomiPreguntaNomiFactorNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormatoNomiFactorNomi.class)) {
				this.setResaltarFormatoNomiFactorNomiFactorNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(PreguntaNomi.class)) {
				this.setResaltarPreguntaNomiFactorNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormatoNomiPreguntaNomi.class)) {
				this.setResaltarFormatoNomiPreguntaNomiFactorNomi(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaFactorNomi=true;

	public Boolean getMostrarFK_IdEmpresaFactorNomi() {
		return this.mostrarFK_IdEmpresaFactorNomi;
	}

	public void setMostrarFK_IdEmpresaFactorNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFactorNomi= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaFactorNomi=true;

	public Boolean getActivarFK_IdEmpresaFactorNomi() {
		return this.activarFK_IdEmpresaFactorNomi;
	}

	public void setActivarFK_IdEmpresaFactorNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFactorNomi= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaFactorNomi=null;

	public Border getResaltarFK_IdEmpresaFactorNomi() {
		return this.resaltarFK_IdEmpresaFactorNomi;
	}

	public void setResaltarFK_IdEmpresaFactorNomi(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFactorNomi= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFactorNomi(ParametroGeneralUsuario parametroGeneralUsuario/*FactorNomiBeanSwingJInternalFrame factornomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFactorNomi= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}