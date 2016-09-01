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


import com.bydan.erp.nomina.util.TipoRasgoPersonalConstantesFunciones;
import com.bydan.erp.nomina.util.TipoRasgoPersonalParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoRasgoPersonalParameterGeneral;

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
final public class TipoRasgoPersonalConstantesFunciones extends TipoRasgoPersonalConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoRasgoPersonal";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoRasgoPersonal"+TipoRasgoPersonalConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoRasgoPersonalHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoRasgoPersonalHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoRasgoPersonalConstantesFunciones.SCHEMA+"_"+TipoRasgoPersonalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoRasgoPersonalHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoRasgoPersonalConstantesFunciones.SCHEMA+"_"+TipoRasgoPersonalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoRasgoPersonalConstantesFunciones.SCHEMA+"_"+TipoRasgoPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoRasgoPersonalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoRasgoPersonalConstantesFunciones.SCHEMA+"_"+TipoRasgoPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRasgoPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRasgoPersonalHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRasgoPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRasgoPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRasgoPersonalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRasgoPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoRasgoPersonalConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoRasgoPersonalConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoRasgoPersonalConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoRasgoPersonalConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Rasgo Personales";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Rasgo Personal";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Rasgo Personal";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoRasgoPersonal";
	public static final String OBJECTNAME="tiporasgopersonal";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_rasgo_personal";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiporasgopersonal from "+TipoRasgoPersonalConstantesFunciones.SPERSISTENCENAME+" tiporasgopersonal";
	public static String QUERYSELECTNATIVE="select "+TipoRasgoPersonalConstantesFunciones.SCHEMA+"."+TipoRasgoPersonalConstantesFunciones.TABLENAME+".id,"+TipoRasgoPersonalConstantesFunciones.SCHEMA+"."+TipoRasgoPersonalConstantesFunciones.TABLENAME+".version_row,"+TipoRasgoPersonalConstantesFunciones.SCHEMA+"."+TipoRasgoPersonalConstantesFunciones.TABLENAME+".id_empresa,"+TipoRasgoPersonalConstantesFunciones.SCHEMA+"."+TipoRasgoPersonalConstantesFunciones.TABLENAME+".codigo,"+TipoRasgoPersonalConstantesFunciones.SCHEMA+"."+TipoRasgoPersonalConstantesFunciones.TABLENAME+".nombre from "+TipoRasgoPersonalConstantesFunciones.SCHEMA+"."+TipoRasgoPersonalConstantesFunciones.TABLENAME;//+" as "+TipoRasgoPersonalConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoRasgoPersonalConstantesFuncionesAdditional tiporasgopersonalConstantesFuncionesAdditional=null;
	
	public TipoRasgoPersonalConstantesFuncionesAdditional getTipoRasgoPersonalConstantesFuncionesAdditional() {
		return this.tiporasgopersonalConstantesFuncionesAdditional;
	}
	
	public void setTipoRasgoPersonalConstantesFuncionesAdditional(TipoRasgoPersonalConstantesFuncionesAdditional tiporasgopersonalConstantesFuncionesAdditional) {
		try {
			this.tiporasgopersonalConstantesFuncionesAdditional=tiporasgopersonalConstantesFuncionesAdditional;
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
	
	public static String getTipoRasgoPersonalLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoRasgoPersonalConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoRasgoPersonalConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoRasgoPersonalConstantesFunciones.CODIGO)) {sLabelColumna=TipoRasgoPersonalConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoRasgoPersonalConstantesFunciones.NOMBRE)) {sLabelColumna=TipoRasgoPersonalConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoRasgoPersonalDescripcion(TipoRasgoPersonal tiporasgopersonal) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiporasgopersonal !=null/* && tiporasgopersonal.getId()!=0*/) {
			sDescripcion=tiporasgopersonal.getcodigo();//tiporasgopersonaltiporasgopersonal.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoRasgoPersonalDescripcionDetallado(TipoRasgoPersonal tiporasgopersonal) {
		String sDescripcion="";
			
		sDescripcion+=TipoRasgoPersonalConstantesFunciones.ID+"=";
		sDescripcion+=tiporasgopersonal.getId().toString()+",";
		sDescripcion+=TipoRasgoPersonalConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiporasgopersonal.getVersionRow().toString()+",";
		sDescripcion+=TipoRasgoPersonalConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tiporasgopersonal.getid_empresa().toString()+",";
		sDescripcion+=TipoRasgoPersonalConstantesFunciones.CODIGO+"=";
		sDescripcion+=tiporasgopersonal.getcodigo()+",";
		sDescripcion+=TipoRasgoPersonalConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiporasgopersonal.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoRasgoPersonalDescripcion(TipoRasgoPersonal tiporasgopersonal,String sValor) throws Exception {			
		if(tiporasgopersonal !=null) {
			tiporasgopersonal.setcodigo(sValor);;//tiporasgopersonaltiporasgopersonal.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoRasgoPersonal(TipoRasgoPersonal tiporasgopersonal,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiporasgopersonal.setcodigo(tiporasgopersonal.getcodigo().trim());
		tiporasgopersonal.setnombre(tiporasgopersonal.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoRasgoPersonals(List<TipoRasgoPersonal> tiporasgopersonals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoRasgoPersonal tiporasgopersonal: tiporasgopersonals) {
			tiporasgopersonal.setcodigo(tiporasgopersonal.getcodigo().trim());
			tiporasgopersonal.setnombre(tiporasgopersonal.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRasgoPersonal(TipoRasgoPersonal tiporasgopersonal,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiporasgopersonal.getConCambioAuxiliar()) {
			tiporasgopersonal.setIsDeleted(tiporasgopersonal.getIsDeletedAuxiliar());	
			tiporasgopersonal.setIsNew(tiporasgopersonal.getIsNewAuxiliar());	
			tiporasgopersonal.setIsChanged(tiporasgopersonal.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiporasgopersonal.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiporasgopersonal.setIsDeletedAuxiliar(false);	
			tiporasgopersonal.setIsNewAuxiliar(false);	
			tiporasgopersonal.setIsChangedAuxiliar(false);
			
			tiporasgopersonal.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRasgoPersonals(List<TipoRasgoPersonal> tiporasgopersonals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoRasgoPersonal tiporasgopersonal : tiporasgopersonals) {
			if(conAsignarBase && tiporasgopersonal.getConCambioAuxiliar()) {
				tiporasgopersonal.setIsDeleted(tiporasgopersonal.getIsDeletedAuxiliar());	
				tiporasgopersonal.setIsNew(tiporasgopersonal.getIsNewAuxiliar());	
				tiporasgopersonal.setIsChanged(tiporasgopersonal.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiporasgopersonal.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiporasgopersonal.setIsDeletedAuxiliar(false);	
				tiporasgopersonal.setIsNewAuxiliar(false);	
				tiporasgopersonal.setIsChangedAuxiliar(false);
				
				tiporasgopersonal.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoRasgoPersonal(TipoRasgoPersonal tiporasgopersonal,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoRasgoPersonals(List<TipoRasgoPersonal> tiporasgopersonals,Boolean conEnteros) throws Exception  {
		
		for(TipoRasgoPersonal tiporasgopersonal: tiporasgopersonals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoRasgoPersonal(List<TipoRasgoPersonal> tiporasgopersonals,TipoRasgoPersonal tiporasgopersonalAux) throws Exception  {
		TipoRasgoPersonalConstantesFunciones.InicializarValoresTipoRasgoPersonal(tiporasgopersonalAux,true);
		
		for(TipoRasgoPersonal tiporasgopersonal: tiporasgopersonals) {
			if(tiporasgopersonal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRasgoPersonal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoRasgoPersonalConstantesFunciones.getArrayColumnasGlobalesTipoRasgoPersonal(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRasgoPersonal(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoRasgoPersonalConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoRasgoPersonalConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoRasgoPersonal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoRasgoPersonal> tiporasgopersonals,TipoRasgoPersonal tiporasgopersonal,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoRasgoPersonal tiporasgopersonalAux: tiporasgopersonals) {
			if(tiporasgopersonalAux!=null && tiporasgopersonal!=null) {
				if((tiporasgopersonalAux.getId()==null && tiporasgopersonal.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiporasgopersonalAux.getId()!=null && tiporasgopersonal.getId()!=null){
					if(tiporasgopersonalAux.getId().equals(tiporasgopersonal.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoRasgoPersonal(List<TipoRasgoPersonal> tiporasgopersonals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoRasgoPersonal tiporasgopersonal: tiporasgopersonals) {			
			if(tiporasgopersonal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoRasgoPersonal() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoRasgoPersonalConstantesFunciones.LABEL_ID, TipoRasgoPersonalConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRasgoPersonalConstantesFunciones.LABEL_VERSIONROW, TipoRasgoPersonalConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRasgoPersonalConstantesFunciones.LABEL_IDEMPRESA, TipoRasgoPersonalConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRasgoPersonalConstantesFunciones.LABEL_CODIGO, TipoRasgoPersonalConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRasgoPersonalConstantesFunciones.LABEL_NOMBRE, TipoRasgoPersonalConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoRasgoPersonal() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoRasgoPersonalConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRasgoPersonalConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRasgoPersonalConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRasgoPersonalConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRasgoPersonalConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRasgoPersonal() throws Exception  {
		return TipoRasgoPersonalConstantesFunciones.getTiposSeleccionarTipoRasgoPersonal(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRasgoPersonal(Boolean conFk) throws Exception  {
		return TipoRasgoPersonalConstantesFunciones.getTiposSeleccionarTipoRasgoPersonal(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRasgoPersonal(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRasgoPersonalConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoRasgoPersonalConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRasgoPersonalConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoRasgoPersonalConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRasgoPersonalConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoRasgoPersonalConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoRasgoPersonal(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRasgoPersonal(TipoRasgoPersonal tiporasgopersonalAux) throws Exception {
		
			tiporasgopersonalAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiporasgopersonalAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRasgoPersonal(List<TipoRasgoPersonal> tiporasgopersonalsTemp) throws Exception {
		for(TipoRasgoPersonal tiporasgopersonalAux:tiporasgopersonalsTemp) {
			
			tiporasgopersonalAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiporasgopersonalAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRasgoPersonal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoRasgoPersonal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRasgoPersonal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRasgoPersonalConstantesFunciones.getClassesRelationshipsOfTipoRasgoPersonal(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRasgoPersonal(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(RasgoPersonal.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(RasgoPersonal.class)) {
						classes.add(new Classe(RasgoPersonal.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRasgoPersonal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRasgoPersonalConstantesFunciones.getClassesRelationshipsFromStringsOfTipoRasgoPersonal(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRasgoPersonal(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(RasgoPersonal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RasgoPersonal.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(RasgoPersonal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RasgoPersonal.class)); continue;
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
	public static void actualizarLista(TipoRasgoPersonal tiporasgopersonal,List<TipoRasgoPersonal> tiporasgopersonals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoRasgoPersonal tiporasgopersonalEncontrado=null;
			
			for(TipoRasgoPersonal tiporasgopersonalLocal:tiporasgopersonals) {
				if(tiporasgopersonalLocal.getId().equals(tiporasgopersonal.getId())) {
					tiporasgopersonalEncontrado=tiporasgopersonalLocal;
					
					tiporasgopersonalLocal.setIsChanged(tiporasgopersonal.getIsChanged());
					tiporasgopersonalLocal.setIsNew(tiporasgopersonal.getIsNew());
					tiporasgopersonalLocal.setIsDeleted(tiporasgopersonal.getIsDeleted());
					
					tiporasgopersonalLocal.setGeneralEntityOriginal(tiporasgopersonal.getGeneralEntityOriginal());
					
					tiporasgopersonalLocal.setId(tiporasgopersonal.getId());	
					tiporasgopersonalLocal.setVersionRow(tiporasgopersonal.getVersionRow());	
					tiporasgopersonalLocal.setid_empresa(tiporasgopersonal.getid_empresa());	
					tiporasgopersonalLocal.setcodigo(tiporasgopersonal.getcodigo());	
					tiporasgopersonalLocal.setnombre(tiporasgopersonal.getnombre());	
					
					
					tiporasgopersonalLocal.setRasgoPersonals(tiporasgopersonal.getRasgoPersonals());
					
					existe=true;
					break;
				}
			}
			
			if(!tiporasgopersonal.getIsDeleted()) {
				if(!existe) {
					tiporasgopersonals.add(tiporasgopersonal);
				}
			} else {
				if(tiporasgopersonalEncontrado!=null && permiteQuitar)  {
					tiporasgopersonals.remove(tiporasgopersonalEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoRasgoPersonal tiporasgopersonal,List<TipoRasgoPersonal> tiporasgopersonals) throws Exception {
		try	{			
			for(TipoRasgoPersonal tiporasgopersonalLocal:tiporasgopersonals) {
				if(tiporasgopersonalLocal.getId().equals(tiporasgopersonal.getId())) {
					tiporasgopersonalLocal.setIsSelected(tiporasgopersonal.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoRasgoPersonal(List<TipoRasgoPersonal> tiporasgopersonalsAux) throws Exception {
		//this.tiporasgopersonalsAux=tiporasgopersonalsAux;
		
		for(TipoRasgoPersonal tiporasgopersonalAux:tiporasgopersonalsAux) {
			if(tiporasgopersonalAux.getIsChanged()) {
				tiporasgopersonalAux.setIsChanged(false);
			}		
			
			if(tiporasgopersonalAux.getIsNew()) {
				tiporasgopersonalAux.setIsNew(false);
			}	
			
			if(tiporasgopersonalAux.getIsDeleted()) {
				tiporasgopersonalAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoRasgoPersonal(TipoRasgoPersonal tiporasgopersonalAux) throws Exception {
		//this.tiporasgopersonalAux=tiporasgopersonalAux;
		
			if(tiporasgopersonalAux.getIsChanged()) {
				tiporasgopersonalAux.setIsChanged(false);
			}		
			
			if(tiporasgopersonalAux.getIsNew()) {
				tiporasgopersonalAux.setIsNew(false);
			}	
			
			if(tiporasgopersonalAux.getIsDeleted()) {
				tiporasgopersonalAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoRasgoPersonal tiporasgopersonalAsignar,TipoRasgoPersonal tiporasgopersonal) throws Exception {
		tiporasgopersonalAsignar.setId(tiporasgopersonal.getId());	
		tiporasgopersonalAsignar.setVersionRow(tiporasgopersonal.getVersionRow());	
		tiporasgopersonalAsignar.setid_empresa(tiporasgopersonal.getid_empresa());
		tiporasgopersonalAsignar.setempresa_descripcion(tiporasgopersonal.getempresa_descripcion());	
		tiporasgopersonalAsignar.setcodigo(tiporasgopersonal.getcodigo());	
		tiporasgopersonalAsignar.setnombre(tiporasgopersonal.getnombre());	
	}
	
	public static void inicializarTipoRasgoPersonal(TipoRasgoPersonal tiporasgopersonal) throws Exception {
		try {
				tiporasgopersonal.setId(0L);	
					
				tiporasgopersonal.setid_empresa(-1L);	
				tiporasgopersonal.setcodigo("");	
				tiporasgopersonal.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoRasgoPersonal(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRasgoPersonalConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRasgoPersonalConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRasgoPersonalConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoRasgoPersonal(String sTipo,Row row,Workbook workbook,TipoRasgoPersonal tiporasgopersonal,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporasgopersonal.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporasgopersonal.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporasgopersonal.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoRasgoPersonal=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoRasgoPersonal() {
		return this.sFinalQueryTipoRasgoPersonal;
	}
	
	public void setsFinalQueryTipoRasgoPersonal(String sFinalQueryTipoRasgoPersonal) {
		this.sFinalQueryTipoRasgoPersonal= sFinalQueryTipoRasgoPersonal;
	}
	
	public Border resaltarSeleccionarTipoRasgoPersonal=null;
	
	public Border setResaltarSeleccionarTipoRasgoPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRasgoPersonalBeanSwingJInternalFrame tiporasgopersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiporasgopersonalBeanSwingJInternalFrame.jTtoolBarTipoRasgoPersonal.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoRasgoPersonal= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoRasgoPersonal() {
		return this.resaltarSeleccionarTipoRasgoPersonal;
	}
	
	public void setResaltarSeleccionarTipoRasgoPersonal(Border borderResaltarSeleccionarTipoRasgoPersonal) {
		this.resaltarSeleccionarTipoRasgoPersonal= borderResaltarSeleccionarTipoRasgoPersonal;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoRasgoPersonal=null;
	public Boolean mostraridTipoRasgoPersonal=true;
	public Boolean activaridTipoRasgoPersonal=true;

	public Border resaltarid_empresaTipoRasgoPersonal=null;
	public Boolean mostrarid_empresaTipoRasgoPersonal=true;
	public Boolean activarid_empresaTipoRasgoPersonal=true;
	public Boolean cargarid_empresaTipoRasgoPersonal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoRasgoPersonal=false;//ConEventDepend=true

	public Border resaltarcodigoTipoRasgoPersonal=null;
	public Boolean mostrarcodigoTipoRasgoPersonal=true;
	public Boolean activarcodigoTipoRasgoPersonal=true;

	public Border resaltarnombreTipoRasgoPersonal=null;
	public Boolean mostrarnombreTipoRasgoPersonal=true;
	public Boolean activarnombreTipoRasgoPersonal=true;

	
	

	public Border setResaltaridTipoRasgoPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRasgoPersonalBeanSwingJInternalFrame tiporasgopersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporasgopersonalBeanSwingJInternalFrame.jTtoolBarTipoRasgoPersonal.setBorder(borderResaltar);
		
		this.resaltaridTipoRasgoPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoRasgoPersonal() {
		return this.resaltaridTipoRasgoPersonal;
	}

	public void setResaltaridTipoRasgoPersonal(Border borderResaltar) {
		this.resaltaridTipoRasgoPersonal= borderResaltar;
	}

	public Boolean getMostraridTipoRasgoPersonal() {
		return this.mostraridTipoRasgoPersonal;
	}

	public void setMostraridTipoRasgoPersonal(Boolean mostraridTipoRasgoPersonal) {
		this.mostraridTipoRasgoPersonal= mostraridTipoRasgoPersonal;
	}

	public Boolean getActivaridTipoRasgoPersonal() {
		return this.activaridTipoRasgoPersonal;
	}

	public void setActivaridTipoRasgoPersonal(Boolean activaridTipoRasgoPersonal) {
		this.activaridTipoRasgoPersonal= activaridTipoRasgoPersonal;
	}

	public Border setResaltarid_empresaTipoRasgoPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRasgoPersonalBeanSwingJInternalFrame tiporasgopersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporasgopersonalBeanSwingJInternalFrame.jTtoolBarTipoRasgoPersonal.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoRasgoPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoRasgoPersonal() {
		return this.resaltarid_empresaTipoRasgoPersonal;
	}

	public void setResaltarid_empresaTipoRasgoPersonal(Border borderResaltar) {
		this.resaltarid_empresaTipoRasgoPersonal= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoRasgoPersonal() {
		return this.mostrarid_empresaTipoRasgoPersonal;
	}

	public void setMostrarid_empresaTipoRasgoPersonal(Boolean mostrarid_empresaTipoRasgoPersonal) {
		this.mostrarid_empresaTipoRasgoPersonal= mostrarid_empresaTipoRasgoPersonal;
	}

	public Boolean getActivarid_empresaTipoRasgoPersonal() {
		return this.activarid_empresaTipoRasgoPersonal;
	}

	public void setActivarid_empresaTipoRasgoPersonal(Boolean activarid_empresaTipoRasgoPersonal) {
		this.activarid_empresaTipoRasgoPersonal= activarid_empresaTipoRasgoPersonal;
	}

	public Boolean getCargarid_empresaTipoRasgoPersonal() {
		return this.cargarid_empresaTipoRasgoPersonal;
	}

	public void setCargarid_empresaTipoRasgoPersonal(Boolean cargarid_empresaTipoRasgoPersonal) {
		this.cargarid_empresaTipoRasgoPersonal= cargarid_empresaTipoRasgoPersonal;
	}

	public Border setResaltarcodigoTipoRasgoPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRasgoPersonalBeanSwingJInternalFrame tiporasgopersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporasgopersonalBeanSwingJInternalFrame.jTtoolBarTipoRasgoPersonal.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoRasgoPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoRasgoPersonal() {
		return this.resaltarcodigoTipoRasgoPersonal;
	}

	public void setResaltarcodigoTipoRasgoPersonal(Border borderResaltar) {
		this.resaltarcodigoTipoRasgoPersonal= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoRasgoPersonal() {
		return this.mostrarcodigoTipoRasgoPersonal;
	}

	public void setMostrarcodigoTipoRasgoPersonal(Boolean mostrarcodigoTipoRasgoPersonal) {
		this.mostrarcodigoTipoRasgoPersonal= mostrarcodigoTipoRasgoPersonal;
	}

	public Boolean getActivarcodigoTipoRasgoPersonal() {
		return this.activarcodigoTipoRasgoPersonal;
	}

	public void setActivarcodigoTipoRasgoPersonal(Boolean activarcodigoTipoRasgoPersonal) {
		this.activarcodigoTipoRasgoPersonal= activarcodigoTipoRasgoPersonal;
	}

	public Border setResaltarnombreTipoRasgoPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRasgoPersonalBeanSwingJInternalFrame tiporasgopersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporasgopersonalBeanSwingJInternalFrame.jTtoolBarTipoRasgoPersonal.setBorder(borderResaltar);
		
		this.resaltarnombreTipoRasgoPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoRasgoPersonal() {
		return this.resaltarnombreTipoRasgoPersonal;
	}

	public void setResaltarnombreTipoRasgoPersonal(Border borderResaltar) {
		this.resaltarnombreTipoRasgoPersonal= borderResaltar;
	}

	public Boolean getMostrarnombreTipoRasgoPersonal() {
		return this.mostrarnombreTipoRasgoPersonal;
	}

	public void setMostrarnombreTipoRasgoPersonal(Boolean mostrarnombreTipoRasgoPersonal) {
		this.mostrarnombreTipoRasgoPersonal= mostrarnombreTipoRasgoPersonal;
	}

	public Boolean getActivarnombreTipoRasgoPersonal() {
		return this.activarnombreTipoRasgoPersonal;
	}

	public void setActivarnombreTipoRasgoPersonal(Boolean activarnombreTipoRasgoPersonal) {
		this.activarnombreTipoRasgoPersonal= activarnombreTipoRasgoPersonal;
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
		
		
		this.setMostraridTipoRasgoPersonal(esInicial);
		this.setMostrarid_empresaTipoRasgoPersonal(esInicial);
		this.setMostrarcodigoTipoRasgoPersonal(esInicial);
		this.setMostrarnombreTipoRasgoPersonal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRasgoPersonalConstantesFunciones.ID)) {
				this.setMostraridTipoRasgoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRasgoPersonalConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoRasgoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRasgoPersonalConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoRasgoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRasgoPersonalConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoRasgoPersonal(esAsigna);
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
		
		
		this.setActivaridTipoRasgoPersonal(esInicial);
		this.setActivarid_empresaTipoRasgoPersonal(esInicial);
		this.setActivarcodigoTipoRasgoPersonal(esInicial);
		this.setActivarnombreTipoRasgoPersonal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRasgoPersonalConstantesFunciones.ID)) {
				this.setActivaridTipoRasgoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRasgoPersonalConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoRasgoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRasgoPersonalConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoRasgoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRasgoPersonalConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoRasgoPersonal(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRasgoPersonalBeanSwingJInternalFrame tiporasgopersonalBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoRasgoPersonal(esInicial);
		this.setResaltarid_empresaTipoRasgoPersonal(esInicial);
		this.setResaltarcodigoTipoRasgoPersonal(esInicial);
		this.setResaltarnombreTipoRasgoPersonal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRasgoPersonalConstantesFunciones.ID)) {
				this.setResaltaridTipoRasgoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRasgoPersonalConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoRasgoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRasgoPersonalConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoRasgoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRasgoPersonalConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoRasgoPersonal(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarRasgoPersonalTipoRasgoPersonal=null;

	public Border getResaltarRasgoPersonalTipoRasgoPersonal() {
		return this.resaltarRasgoPersonalTipoRasgoPersonal;
	}

	public void setResaltarRasgoPersonalTipoRasgoPersonal(Border borderResaltarRasgoPersonal) {
		if(borderResaltarRasgoPersonal!=null) {
			this.resaltarRasgoPersonalTipoRasgoPersonal= borderResaltarRasgoPersonal;
		}
	}

	public Border setResaltarRasgoPersonalTipoRasgoPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRasgoPersonalBeanSwingJInternalFrame tiporasgopersonalBeanSwingJInternalFrame*/) {
		Border borderResaltarRasgoPersonal=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tiporasgopersonalBeanSwingJInternalFrame.jTtoolBarTipoRasgoPersonal.setBorder(borderResaltarRasgoPersonal);
			
		this.resaltarRasgoPersonalTipoRasgoPersonal= borderResaltarRasgoPersonal;

		 return borderResaltarRasgoPersonal;
	}



	public Boolean mostrarRasgoPersonalTipoRasgoPersonal=true;

	public Boolean getMostrarRasgoPersonalTipoRasgoPersonal() {
		return this.mostrarRasgoPersonalTipoRasgoPersonal;
	}

	public void setMostrarRasgoPersonalTipoRasgoPersonal(Boolean visibilidadResaltarRasgoPersonal) {
		this.mostrarRasgoPersonalTipoRasgoPersonal= visibilidadResaltarRasgoPersonal;
	}



	public Boolean activarRasgoPersonalTipoRasgoPersonal=true;

	public Boolean gethabilitarResaltarRasgoPersonalTipoRasgoPersonal() {
		return this.activarRasgoPersonalTipoRasgoPersonal;
	}

	public void setActivarRasgoPersonalTipoRasgoPersonal(Boolean habilitarResaltarRasgoPersonal) {
		this.activarRasgoPersonalTipoRasgoPersonal= habilitarResaltarRasgoPersonal;
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

		this.setMostrarRasgoPersonalTipoRasgoPersonal(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RasgoPersonal.class)) {
				this.setMostrarRasgoPersonalTipoRasgoPersonal(esAsigna);
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

		this.setActivarRasgoPersonalTipoRasgoPersonal(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RasgoPersonal.class)) {
				this.setActivarRasgoPersonalTipoRasgoPersonal(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRasgoPersonalBeanSwingJInternalFrame tiporasgopersonalBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarRasgoPersonalTipoRasgoPersonal(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RasgoPersonal.class)) {
				this.setResaltarRasgoPersonalTipoRasgoPersonal(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoRasgoPersonal=true;

	public Boolean getMostrarFK_IdEmpresaTipoRasgoPersonal() {
		return this.mostrarFK_IdEmpresaTipoRasgoPersonal;
	}

	public void setMostrarFK_IdEmpresaTipoRasgoPersonal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoRasgoPersonal= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoRasgoPersonal=true;

	public Boolean getActivarFK_IdEmpresaTipoRasgoPersonal() {
		return this.activarFK_IdEmpresaTipoRasgoPersonal;
	}

	public void setActivarFK_IdEmpresaTipoRasgoPersonal(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoRasgoPersonal= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoRasgoPersonal=null;

	public Border getResaltarFK_IdEmpresaTipoRasgoPersonal() {
		return this.resaltarFK_IdEmpresaTipoRasgoPersonal;
	}

	public void setResaltarFK_IdEmpresaTipoRasgoPersonal(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoRasgoPersonal= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoRasgoPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRasgoPersonalBeanSwingJInternalFrame tiporasgopersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoRasgoPersonal= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}