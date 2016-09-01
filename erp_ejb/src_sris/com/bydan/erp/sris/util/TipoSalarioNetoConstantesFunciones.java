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
package com.bydan.erp.sris.util;

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


import com.bydan.erp.sris.util.TipoSalarioNetoConstantesFunciones;
import com.bydan.erp.sris.util.TipoSalarioNetoParameterReturnGeneral;
//import com.bydan.erp.sris.util.TipoSalarioNetoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.sris.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.sris.business.dataaccess.*;
//import com.bydan.erp.sris.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoSalarioNetoConstantesFunciones extends TipoSalarioNetoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoSalarioNeto";
	public static final String SPATHOPCION="Sris";	
	public static final String SPATHMODULO="sris/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoSalarioNeto"+TipoSalarioNetoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoSalarioNetoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoSalarioNetoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoSalarioNetoConstantesFunciones.SCHEMA+"_"+TipoSalarioNetoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoSalarioNetoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoSalarioNetoConstantesFunciones.SCHEMA+"_"+TipoSalarioNetoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoSalarioNetoConstantesFunciones.SCHEMA+"_"+TipoSalarioNetoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoSalarioNetoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoSalarioNetoConstantesFunciones.SCHEMA+"_"+TipoSalarioNetoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoSalarioNetoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoSalarioNetoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoSalarioNetoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoSalarioNetoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoSalarioNetoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoSalarioNetoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoSalarioNetoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoSalarioNetoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoSalarioNetoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoSalarioNetoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Salario Netos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Salario Neto";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Salario Neto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoSalarioNeto";
	public static final String OBJECTNAME="tiposalarioneto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SRIS;	
	public static final String TABLENAME="tipo_salario_neto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiposalarioneto from "+TipoSalarioNetoConstantesFunciones.SPERSISTENCENAME+" tiposalarioneto";
	public static String QUERYSELECTNATIVE="select "+TipoSalarioNetoConstantesFunciones.SCHEMA+"."+TipoSalarioNetoConstantesFunciones.TABLENAME+".id,"+TipoSalarioNetoConstantesFunciones.SCHEMA+"."+TipoSalarioNetoConstantesFunciones.TABLENAME+".version_row,"+TipoSalarioNetoConstantesFunciones.SCHEMA+"."+TipoSalarioNetoConstantesFunciones.TABLENAME+".nombre,"+TipoSalarioNetoConstantesFunciones.SCHEMA+"."+TipoSalarioNetoConstantesFunciones.TABLENAME+".descripcion from "+TipoSalarioNetoConstantesFunciones.SCHEMA+"."+TipoSalarioNetoConstantesFunciones.TABLENAME;//+" as "+TipoSalarioNetoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoSalarioNetoConstantesFuncionesAdditional tiposalarionetoConstantesFuncionesAdditional=null;
	
	public TipoSalarioNetoConstantesFuncionesAdditional getTipoSalarioNetoConstantesFuncionesAdditional() {
		return this.tiposalarionetoConstantesFuncionesAdditional;
	}
	
	public void setTipoSalarioNetoConstantesFuncionesAdditional(TipoSalarioNetoConstantesFuncionesAdditional tiposalarionetoConstantesFuncionesAdditional) {
		try {
			this.tiposalarionetoConstantesFuncionesAdditional=tiposalarionetoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoSalarioNetoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoSalarioNetoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoSalarioNetoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoSalarioNetoConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoSalarioNetoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoSalarioNetoDescripcion(TipoSalarioNeto tiposalarioneto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiposalarioneto !=null/* && tiposalarioneto.getId()!=0*/) {
			sDescripcion=tiposalarioneto.getnombre();//tiposalarionetotiposalarioneto.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoSalarioNetoDescripcionDetallado(TipoSalarioNeto tiposalarioneto) {
		String sDescripcion="";
			
		sDescripcion+=TipoSalarioNetoConstantesFunciones.ID+"=";
		sDescripcion+=tiposalarioneto.getId().toString()+",";
		sDescripcion+=TipoSalarioNetoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiposalarioneto.getVersionRow().toString()+",";
		sDescripcion+=TipoSalarioNetoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiposalarioneto.getnombre()+",";
		sDescripcion+=TipoSalarioNetoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tiposalarioneto.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoSalarioNetoDescripcion(TipoSalarioNeto tiposalarioneto,String sValor) throws Exception {			
		if(tiposalarioneto !=null) {
			tiposalarioneto.setnombre(sValor);;//tiposalarionetotiposalarioneto.getnombre().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoSalarioNeto(TipoSalarioNeto tiposalarioneto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiposalarioneto.setnombre(tiposalarioneto.getnombre().trim());
		tiposalarioneto.setdescripcion(tiposalarioneto.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoSalarioNetos(List<TipoSalarioNeto> tiposalarionetos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoSalarioNeto tiposalarioneto: tiposalarionetos) {
			tiposalarioneto.setnombre(tiposalarioneto.getnombre().trim());
			tiposalarioneto.setdescripcion(tiposalarioneto.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoSalarioNeto(TipoSalarioNeto tiposalarioneto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiposalarioneto.getConCambioAuxiliar()) {
			tiposalarioneto.setIsDeleted(tiposalarioneto.getIsDeletedAuxiliar());	
			tiposalarioneto.setIsNew(tiposalarioneto.getIsNewAuxiliar());	
			tiposalarioneto.setIsChanged(tiposalarioneto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiposalarioneto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiposalarioneto.setIsDeletedAuxiliar(false);	
			tiposalarioneto.setIsNewAuxiliar(false);	
			tiposalarioneto.setIsChangedAuxiliar(false);
			
			tiposalarioneto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoSalarioNetos(List<TipoSalarioNeto> tiposalarionetos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoSalarioNeto tiposalarioneto : tiposalarionetos) {
			if(conAsignarBase && tiposalarioneto.getConCambioAuxiliar()) {
				tiposalarioneto.setIsDeleted(tiposalarioneto.getIsDeletedAuxiliar());	
				tiposalarioneto.setIsNew(tiposalarioneto.getIsNewAuxiliar());	
				tiposalarioneto.setIsChanged(tiposalarioneto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiposalarioneto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiposalarioneto.setIsDeletedAuxiliar(false);	
				tiposalarioneto.setIsNewAuxiliar(false);	
				tiposalarioneto.setIsChangedAuxiliar(false);
				
				tiposalarioneto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoSalarioNeto(TipoSalarioNeto tiposalarioneto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoSalarioNetos(List<TipoSalarioNeto> tiposalarionetos,Boolean conEnteros) throws Exception  {
		
		for(TipoSalarioNeto tiposalarioneto: tiposalarionetos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoSalarioNeto(List<TipoSalarioNeto> tiposalarionetos,TipoSalarioNeto tiposalarionetoAux) throws Exception  {
		TipoSalarioNetoConstantesFunciones.InicializarValoresTipoSalarioNeto(tiposalarionetoAux,true);
		
		for(TipoSalarioNeto tiposalarioneto: tiposalarionetos) {
			if(tiposalarioneto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoSalarioNeto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoSalarioNetoConstantesFunciones.getArrayColumnasGlobalesTipoSalarioNeto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoSalarioNeto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoSalarioNeto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoSalarioNeto> tiposalarionetos,TipoSalarioNeto tiposalarioneto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoSalarioNeto tiposalarionetoAux: tiposalarionetos) {
			if(tiposalarionetoAux!=null && tiposalarioneto!=null) {
				if((tiposalarionetoAux.getId()==null && tiposalarioneto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiposalarionetoAux.getId()!=null && tiposalarioneto.getId()!=null){
					if(tiposalarionetoAux.getId().equals(tiposalarioneto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoSalarioNeto(List<TipoSalarioNeto> tiposalarionetos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoSalarioNeto tiposalarioneto: tiposalarionetos) {			
			if(tiposalarioneto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoSalarioNeto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoSalarioNetoConstantesFunciones.LABEL_ID, TipoSalarioNetoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoSalarioNetoConstantesFunciones.LABEL_VERSIONROW, TipoSalarioNetoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoSalarioNetoConstantesFunciones.LABEL_NOMBRE, TipoSalarioNetoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoSalarioNetoConstantesFunciones.LABEL_DESCRIPCION, TipoSalarioNetoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoSalarioNeto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoSalarioNetoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoSalarioNetoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoSalarioNetoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoSalarioNetoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoSalarioNeto() throws Exception  {
		return TipoSalarioNetoConstantesFunciones.getTiposSeleccionarTipoSalarioNeto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoSalarioNeto(Boolean conFk) throws Exception  {
		return TipoSalarioNetoConstantesFunciones.getTiposSeleccionarTipoSalarioNeto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoSalarioNeto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoSalarioNetoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoSalarioNetoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoSalarioNetoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoSalarioNetoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoSalarioNeto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoSalarioNeto(TipoSalarioNeto tiposalarionetoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoSalarioNeto(List<TipoSalarioNeto> tiposalarionetosTemp) throws Exception {
		for(TipoSalarioNeto tiposalarionetoAux:tiposalarionetosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoSalarioNeto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoSalarioNeto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoSalarioNeto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoSalarioNetoConstantesFunciones.getClassesRelationshipsOfTipoSalarioNeto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoSalarioNeto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoSalarioNeto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoSalarioNetoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoSalarioNeto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoSalarioNeto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoSalarioNeto tiposalarioneto,List<TipoSalarioNeto> tiposalarionetos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoSalarioNeto tiposalarionetoEncontrado=null;
			
			for(TipoSalarioNeto tiposalarionetoLocal:tiposalarionetos) {
				if(tiposalarionetoLocal.getId().equals(tiposalarioneto.getId())) {
					tiposalarionetoEncontrado=tiposalarionetoLocal;
					
					tiposalarionetoLocal.setIsChanged(tiposalarioneto.getIsChanged());
					tiposalarionetoLocal.setIsNew(tiposalarioneto.getIsNew());
					tiposalarionetoLocal.setIsDeleted(tiposalarioneto.getIsDeleted());
					
					tiposalarionetoLocal.setGeneralEntityOriginal(tiposalarioneto.getGeneralEntityOriginal());
					
					tiposalarionetoLocal.setId(tiposalarioneto.getId());	
					tiposalarionetoLocal.setVersionRow(tiposalarioneto.getVersionRow());	
					tiposalarionetoLocal.setnombre(tiposalarioneto.getnombre());	
					tiposalarionetoLocal.setdescripcion(tiposalarioneto.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tiposalarioneto.getIsDeleted()) {
				if(!existe) {
					tiposalarionetos.add(tiposalarioneto);
				}
			} else {
				if(tiposalarionetoEncontrado!=null && permiteQuitar)  {
					tiposalarionetos.remove(tiposalarionetoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoSalarioNeto tiposalarioneto,List<TipoSalarioNeto> tiposalarionetos) throws Exception {
		try	{			
			for(TipoSalarioNeto tiposalarionetoLocal:tiposalarionetos) {
				if(tiposalarionetoLocal.getId().equals(tiposalarioneto.getId())) {
					tiposalarionetoLocal.setIsSelected(tiposalarioneto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoSalarioNeto(List<TipoSalarioNeto> tiposalarionetosAux) throws Exception {
		//this.tiposalarionetosAux=tiposalarionetosAux;
		
		for(TipoSalarioNeto tiposalarionetoAux:tiposalarionetosAux) {
			if(tiposalarionetoAux.getIsChanged()) {
				tiposalarionetoAux.setIsChanged(false);
			}		
			
			if(tiposalarionetoAux.getIsNew()) {
				tiposalarionetoAux.setIsNew(false);
			}	
			
			if(tiposalarionetoAux.getIsDeleted()) {
				tiposalarionetoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoSalarioNeto(TipoSalarioNeto tiposalarionetoAux) throws Exception {
		//this.tiposalarionetoAux=tiposalarionetoAux;
		
			if(tiposalarionetoAux.getIsChanged()) {
				tiposalarionetoAux.setIsChanged(false);
			}		
			
			if(tiposalarionetoAux.getIsNew()) {
				tiposalarionetoAux.setIsNew(false);
			}	
			
			if(tiposalarionetoAux.getIsDeleted()) {
				tiposalarionetoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoSalarioNeto tiposalarionetoAsignar,TipoSalarioNeto tiposalarioneto) throws Exception {
		tiposalarionetoAsignar.setId(tiposalarioneto.getId());	
		tiposalarionetoAsignar.setVersionRow(tiposalarioneto.getVersionRow());	
		tiposalarionetoAsignar.setnombre(tiposalarioneto.getnombre());	
		tiposalarionetoAsignar.setdescripcion(tiposalarioneto.getdescripcion());	
	}
	
	public static void inicializarTipoSalarioNeto(TipoSalarioNeto tiposalarioneto) throws Exception {
		try {
				tiposalarioneto.setId(0L);	
					
				tiposalarioneto.setnombre("");	
				tiposalarioneto.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoSalarioNeto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoSalarioNetoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoSalarioNetoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoSalarioNeto(String sTipo,Row row,Workbook workbook,TipoSalarioNeto tiposalarioneto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiposalarioneto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiposalarioneto.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoSalarioNeto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoSalarioNeto() {
		return this.sFinalQueryTipoSalarioNeto;
	}
	
	public void setsFinalQueryTipoSalarioNeto(String sFinalQueryTipoSalarioNeto) {
		this.sFinalQueryTipoSalarioNeto= sFinalQueryTipoSalarioNeto;
	}
	
	public Border resaltarSeleccionarTipoSalarioNeto=null;
	
	public Border setResaltarSeleccionarTipoSalarioNeto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSalarioNetoBeanSwingJInternalFrame tiposalarionetoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiposalarionetoBeanSwingJInternalFrame.jTtoolBarTipoSalarioNeto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoSalarioNeto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoSalarioNeto() {
		return this.resaltarSeleccionarTipoSalarioNeto;
	}
	
	public void setResaltarSeleccionarTipoSalarioNeto(Border borderResaltarSeleccionarTipoSalarioNeto) {
		this.resaltarSeleccionarTipoSalarioNeto= borderResaltarSeleccionarTipoSalarioNeto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoSalarioNeto=null;
	public Boolean mostraridTipoSalarioNeto=true;
	public Boolean activaridTipoSalarioNeto=true;

	public Border resaltarnombreTipoSalarioNeto=null;
	public Boolean mostrarnombreTipoSalarioNeto=true;
	public Boolean activarnombreTipoSalarioNeto=true;

	public Border resaltardescripcionTipoSalarioNeto=null;
	public Boolean mostrardescripcionTipoSalarioNeto=true;
	public Boolean activardescripcionTipoSalarioNeto=true;

	
	

	public Border setResaltaridTipoSalarioNeto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSalarioNetoBeanSwingJInternalFrame tiposalarionetoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiposalarionetoBeanSwingJInternalFrame.jTtoolBarTipoSalarioNeto.setBorder(borderResaltar);
		
		this.resaltaridTipoSalarioNeto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoSalarioNeto() {
		return this.resaltaridTipoSalarioNeto;
	}

	public void setResaltaridTipoSalarioNeto(Border borderResaltar) {
		this.resaltaridTipoSalarioNeto= borderResaltar;
	}

	public Boolean getMostraridTipoSalarioNeto() {
		return this.mostraridTipoSalarioNeto;
	}

	public void setMostraridTipoSalarioNeto(Boolean mostraridTipoSalarioNeto) {
		this.mostraridTipoSalarioNeto= mostraridTipoSalarioNeto;
	}

	public Boolean getActivaridTipoSalarioNeto() {
		return this.activaridTipoSalarioNeto;
	}

	public void setActivaridTipoSalarioNeto(Boolean activaridTipoSalarioNeto) {
		this.activaridTipoSalarioNeto= activaridTipoSalarioNeto;
	}

	public Border setResaltarnombreTipoSalarioNeto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSalarioNetoBeanSwingJInternalFrame tiposalarionetoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiposalarionetoBeanSwingJInternalFrame.jTtoolBarTipoSalarioNeto.setBorder(borderResaltar);
		
		this.resaltarnombreTipoSalarioNeto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoSalarioNeto() {
		return this.resaltarnombreTipoSalarioNeto;
	}

	public void setResaltarnombreTipoSalarioNeto(Border borderResaltar) {
		this.resaltarnombreTipoSalarioNeto= borderResaltar;
	}

	public Boolean getMostrarnombreTipoSalarioNeto() {
		return this.mostrarnombreTipoSalarioNeto;
	}

	public void setMostrarnombreTipoSalarioNeto(Boolean mostrarnombreTipoSalarioNeto) {
		this.mostrarnombreTipoSalarioNeto= mostrarnombreTipoSalarioNeto;
	}

	public Boolean getActivarnombreTipoSalarioNeto() {
		return this.activarnombreTipoSalarioNeto;
	}

	public void setActivarnombreTipoSalarioNeto(Boolean activarnombreTipoSalarioNeto) {
		this.activarnombreTipoSalarioNeto= activarnombreTipoSalarioNeto;
	}

	public Border setResaltardescripcionTipoSalarioNeto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSalarioNetoBeanSwingJInternalFrame tiposalarionetoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiposalarionetoBeanSwingJInternalFrame.jTtoolBarTipoSalarioNeto.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoSalarioNeto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoSalarioNeto() {
		return this.resaltardescripcionTipoSalarioNeto;
	}

	public void setResaltardescripcionTipoSalarioNeto(Border borderResaltar) {
		this.resaltardescripcionTipoSalarioNeto= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoSalarioNeto() {
		return this.mostrardescripcionTipoSalarioNeto;
	}

	public void setMostrardescripcionTipoSalarioNeto(Boolean mostrardescripcionTipoSalarioNeto) {
		this.mostrardescripcionTipoSalarioNeto= mostrardescripcionTipoSalarioNeto;
	}

	public Boolean getActivardescripcionTipoSalarioNeto() {
		return this.activardescripcionTipoSalarioNeto;
	}

	public void setActivardescripcionTipoSalarioNeto(Boolean activardescripcionTipoSalarioNeto) {
		this.activardescripcionTipoSalarioNeto= activardescripcionTipoSalarioNeto;
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
		
		
		this.setMostraridTipoSalarioNeto(esInicial);
		this.setMostrarnombreTipoSalarioNeto(esInicial);
		this.setMostrardescripcionTipoSalarioNeto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoSalarioNetoConstantesFunciones.ID)) {
				this.setMostraridTipoSalarioNeto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSalarioNetoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoSalarioNeto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSalarioNetoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoSalarioNeto(esAsigna);
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
		
		
		this.setActivaridTipoSalarioNeto(esInicial);
		this.setActivarnombreTipoSalarioNeto(esInicial);
		this.setActivardescripcionTipoSalarioNeto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoSalarioNetoConstantesFunciones.ID)) {
				this.setActivaridTipoSalarioNeto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSalarioNetoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoSalarioNeto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSalarioNetoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoSalarioNeto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoSalarioNetoBeanSwingJInternalFrame tiposalarionetoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoSalarioNeto(esInicial);
		this.setResaltarnombreTipoSalarioNeto(esInicial);
		this.setResaltardescripcionTipoSalarioNeto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoSalarioNetoConstantesFunciones.ID)) {
				this.setResaltaridTipoSalarioNeto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSalarioNetoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoSalarioNeto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSalarioNetoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoSalarioNeto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoSalarioNetoBeanSwingJInternalFrame tiposalarionetoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	
	//CONTROL_FUNCION2
}