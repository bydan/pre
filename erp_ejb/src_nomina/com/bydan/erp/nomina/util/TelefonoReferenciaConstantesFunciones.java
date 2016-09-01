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


import com.bydan.erp.nomina.util.TelefonoReferenciaConstantesFunciones;
import com.bydan.erp.nomina.util.TelefonoReferenciaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TelefonoReferenciaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TelefonoReferenciaConstantesFunciones extends TelefonoReferenciaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TelefonoReferencia";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TelefonoReferencia"+TelefonoReferenciaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TelefonoReferenciaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TelefonoReferenciaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TelefonoReferenciaConstantesFunciones.SCHEMA+"_"+TelefonoReferenciaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TelefonoReferenciaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TelefonoReferenciaConstantesFunciones.SCHEMA+"_"+TelefonoReferenciaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TelefonoReferenciaConstantesFunciones.SCHEMA+"_"+TelefonoReferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TelefonoReferenciaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TelefonoReferenciaConstantesFunciones.SCHEMA+"_"+TelefonoReferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TelefonoReferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TelefonoReferenciaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TelefonoReferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TelefonoReferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TelefonoReferenciaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TelefonoReferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TelefonoReferenciaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TelefonoReferenciaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TelefonoReferenciaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TelefonoReferenciaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Telefono Referencias";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Telefono Referencia";
	public static final String SCLASSWEBTITULO_LOWER="Telefono Referencia";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TelefonoReferencia";
	public static final String OBJECTNAME="telefonoreferencia";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="telefono_referencia";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select telefonoreferencia from "+TelefonoReferenciaConstantesFunciones.SPERSISTENCENAME+" telefonoreferencia";
	public static String QUERYSELECTNATIVE="select "+TelefonoReferenciaConstantesFunciones.SCHEMA+"."+TelefonoReferenciaConstantesFunciones.TABLENAME+".id,"+TelefonoReferenciaConstantesFunciones.SCHEMA+"."+TelefonoReferenciaConstantesFunciones.TABLENAME+".version_row,"+TelefonoReferenciaConstantesFunciones.SCHEMA+"."+TelefonoReferenciaConstantesFunciones.TABLENAME+".id_referencia,"+TelefonoReferenciaConstantesFunciones.SCHEMA+"."+TelefonoReferenciaConstantesFunciones.TABLENAME+".numero from "+TelefonoReferenciaConstantesFunciones.SCHEMA+"."+TelefonoReferenciaConstantesFunciones.TABLENAME;//+" as "+TelefonoReferenciaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TelefonoReferenciaConstantesFuncionesAdditional telefonoreferenciaConstantesFuncionesAdditional=null;
	
	public TelefonoReferenciaConstantesFuncionesAdditional getTelefonoReferenciaConstantesFuncionesAdditional() {
		return this.telefonoreferenciaConstantesFuncionesAdditional;
	}
	
	public void setTelefonoReferenciaConstantesFuncionesAdditional(TelefonoReferenciaConstantesFuncionesAdditional telefonoreferenciaConstantesFuncionesAdditional) {
		try {
			this.telefonoreferenciaConstantesFuncionesAdditional=telefonoreferenciaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDREFERENCIA= "id_referencia";
    public static final String NUMERO= "numero";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDREFERENCIA= "Referencia";
		public static final String LABEL_IDREFERENCIA_LOWER= "Referencia";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
	
		
		
		
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTelefonoReferenciaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TelefonoReferenciaConstantesFunciones.IDREFERENCIA)) {sLabelColumna=TelefonoReferenciaConstantesFunciones.LABEL_IDREFERENCIA;}
		if(sNombreColumna.equals(TelefonoReferenciaConstantesFunciones.NUMERO)) {sLabelColumna=TelefonoReferenciaConstantesFunciones.LABEL_NUMERO;}
		
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
	
	
	
			
			
			
			
	
	public static String getTelefonoReferenciaDescripcion(TelefonoReferencia telefonoreferencia) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(telefonoreferencia !=null/* && telefonoreferencia.getId()!=0*/) {
			sDescripcion=telefonoreferencia.getnumero();//telefonoreferenciatelefonoreferencia.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTelefonoReferenciaDescripcionDetallado(TelefonoReferencia telefonoreferencia) {
		String sDescripcion="";
			
		sDescripcion+=TelefonoReferenciaConstantesFunciones.ID+"=";
		sDescripcion+=telefonoreferencia.getId().toString()+",";
		sDescripcion+=TelefonoReferenciaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=telefonoreferencia.getVersionRow().toString()+",";
		sDescripcion+=TelefonoReferenciaConstantesFunciones.IDREFERENCIA+"=";
		sDescripcion+=telefonoreferencia.getid_referencia().toString()+",";
		sDescripcion+=TelefonoReferenciaConstantesFunciones.NUMERO+"=";
		sDescripcion+=telefonoreferencia.getnumero()+",";
			
		return sDescripcion;
	}
	
	public static void setTelefonoReferenciaDescripcion(TelefonoReferencia telefonoreferencia,String sValor) throws Exception {			
		if(telefonoreferencia !=null) {
			telefonoreferencia.setnumero(sValor);//telefonoreferenciatelefonoreferencia.getId().toString();
		}		
	}
	
		

	public static String getReferenciaDescripcion(Referencia referencia) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(referencia!=null/*&&referencia.getId()>0*/) {
			sDescripcion=ReferenciaConstantesFunciones.getReferenciaDescripcion(referencia);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdReferencia")) {
			sNombreIndice="Tipo=  Por Referencia";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdReferencia(Long id_referencia) {
		String sDetalleIndice=" Parametros->";
		if(id_referencia!=null) {sDetalleIndice+=" Codigo Unico De Referencia="+id_referencia.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTelefonoReferencia(TelefonoReferencia telefonoreferencia,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		telefonoreferencia.setnumero(telefonoreferencia.getnumero().trim());
	}
	
	public static void quitarEspaciosTelefonoReferencias(List<TelefonoReferencia> telefonoreferencias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TelefonoReferencia telefonoreferencia: telefonoreferencias) {
			telefonoreferencia.setnumero(telefonoreferencia.getnumero().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTelefonoReferencia(TelefonoReferencia telefonoreferencia,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && telefonoreferencia.getConCambioAuxiliar()) {
			telefonoreferencia.setIsDeleted(telefonoreferencia.getIsDeletedAuxiliar());	
			telefonoreferencia.setIsNew(telefonoreferencia.getIsNewAuxiliar());	
			telefonoreferencia.setIsChanged(telefonoreferencia.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			telefonoreferencia.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			telefonoreferencia.setIsDeletedAuxiliar(false);	
			telefonoreferencia.setIsNewAuxiliar(false);	
			telefonoreferencia.setIsChangedAuxiliar(false);
			
			telefonoreferencia.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTelefonoReferencias(List<TelefonoReferencia> telefonoreferencias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TelefonoReferencia telefonoreferencia : telefonoreferencias) {
			if(conAsignarBase && telefonoreferencia.getConCambioAuxiliar()) {
				telefonoreferencia.setIsDeleted(telefonoreferencia.getIsDeletedAuxiliar());	
				telefonoreferencia.setIsNew(telefonoreferencia.getIsNewAuxiliar());	
				telefonoreferencia.setIsChanged(telefonoreferencia.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				telefonoreferencia.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				telefonoreferencia.setIsDeletedAuxiliar(false);	
				telefonoreferencia.setIsNewAuxiliar(false);	
				telefonoreferencia.setIsChangedAuxiliar(false);
				
				telefonoreferencia.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTelefonoReferencia(TelefonoReferencia telefonoreferencia,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTelefonoReferencias(List<TelefonoReferencia> telefonoreferencias,Boolean conEnteros) throws Exception  {
		
		for(TelefonoReferencia telefonoreferencia: telefonoreferencias) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTelefonoReferencia(List<TelefonoReferencia> telefonoreferencias,TelefonoReferencia telefonoreferenciaAux) throws Exception  {
		TelefonoReferenciaConstantesFunciones.InicializarValoresTelefonoReferencia(telefonoreferenciaAux,true);
		
		for(TelefonoReferencia telefonoreferencia: telefonoreferencias) {
			if(telefonoreferencia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTelefonoReferencia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TelefonoReferenciaConstantesFunciones.getArrayColumnasGlobalesTelefonoReferencia(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTelefonoReferencia(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTelefonoReferencia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TelefonoReferencia> telefonoreferencias,TelefonoReferencia telefonoreferencia,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TelefonoReferencia telefonoreferenciaAux: telefonoreferencias) {
			if(telefonoreferenciaAux!=null && telefonoreferencia!=null) {
				if((telefonoreferenciaAux.getId()==null && telefonoreferencia.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(telefonoreferenciaAux.getId()!=null && telefonoreferencia.getId()!=null){
					if(telefonoreferenciaAux.getId().equals(telefonoreferencia.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTelefonoReferencia(List<TelefonoReferencia> telefonoreferencias) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TelefonoReferencia telefonoreferencia: telefonoreferencias) {			
			if(telefonoreferencia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTelefonoReferencia() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TelefonoReferenciaConstantesFunciones.LABEL_ID, TelefonoReferenciaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TelefonoReferenciaConstantesFunciones.LABEL_VERSIONROW, TelefonoReferenciaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TelefonoReferenciaConstantesFunciones.LABEL_IDREFERENCIA, TelefonoReferenciaConstantesFunciones.IDREFERENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TelefonoReferenciaConstantesFunciones.LABEL_NUMERO, TelefonoReferenciaConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTelefonoReferencia() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TelefonoReferenciaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TelefonoReferenciaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TelefonoReferenciaConstantesFunciones.IDREFERENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TelefonoReferenciaConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTelefonoReferencia() throws Exception  {
		return TelefonoReferenciaConstantesFunciones.getTiposSeleccionarTelefonoReferencia(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTelefonoReferencia(Boolean conFk) throws Exception  {
		return TelefonoReferenciaConstantesFunciones.getTiposSeleccionarTelefonoReferencia(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTelefonoReferencia(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TelefonoReferenciaConstantesFunciones.LABEL_IDREFERENCIA);
			reporte.setsDescripcion(TelefonoReferenciaConstantesFunciones.LABEL_IDREFERENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TelefonoReferenciaConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(TelefonoReferenciaConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTelefonoReferencia(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTelefonoReferencia(TelefonoReferencia telefonoreferenciaAux) throws Exception {
		
			telefonoreferenciaAux.setreferencia_descripcion(ReferenciaConstantesFunciones.getReferenciaDescripcion(telefonoreferenciaAux.getReferencia()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTelefonoReferencia(List<TelefonoReferencia> telefonoreferenciasTemp) throws Exception {
		for(TelefonoReferencia telefonoreferenciaAux:telefonoreferenciasTemp) {
			
			telefonoreferenciaAux.setreferencia_descripcion(ReferenciaConstantesFunciones.getReferenciaDescripcion(telefonoreferenciaAux.getReferencia()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTelefonoReferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Referencia.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Referencia.class)) {
						classes.add(new Classe(Referencia.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTelefonoReferencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Referencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Referencia.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Referencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Referencia.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTelefonoReferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TelefonoReferenciaConstantesFunciones.getClassesRelationshipsOfTelefonoReferencia(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTelefonoReferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTelefonoReferencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TelefonoReferenciaConstantesFunciones.getClassesRelationshipsFromStringsOfTelefonoReferencia(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTelefonoReferencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TelefonoReferencia telefonoreferencia,List<TelefonoReferencia> telefonoreferencias,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TelefonoReferencia telefonoreferenciaEncontrado=null;
			
			for(TelefonoReferencia telefonoreferenciaLocal:telefonoreferencias) {
				if(telefonoreferenciaLocal.getId().equals(telefonoreferencia.getId())) {
					telefonoreferenciaEncontrado=telefonoreferenciaLocal;
					
					telefonoreferenciaLocal.setIsChanged(telefonoreferencia.getIsChanged());
					telefonoreferenciaLocal.setIsNew(telefonoreferencia.getIsNew());
					telefonoreferenciaLocal.setIsDeleted(telefonoreferencia.getIsDeleted());
					
					telefonoreferenciaLocal.setGeneralEntityOriginal(telefonoreferencia.getGeneralEntityOriginal());
					
					telefonoreferenciaLocal.setId(telefonoreferencia.getId());	
					telefonoreferenciaLocal.setVersionRow(telefonoreferencia.getVersionRow());	
					telefonoreferenciaLocal.setid_referencia(telefonoreferencia.getid_referencia());	
					telefonoreferenciaLocal.setnumero(telefonoreferencia.getnumero());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!telefonoreferencia.getIsDeleted()) {
				if(!existe) {
					telefonoreferencias.add(telefonoreferencia);
				}
			} else {
				if(telefonoreferenciaEncontrado!=null && permiteQuitar)  {
					telefonoreferencias.remove(telefonoreferenciaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TelefonoReferencia telefonoreferencia,List<TelefonoReferencia> telefonoreferencias) throws Exception {
		try	{			
			for(TelefonoReferencia telefonoreferenciaLocal:telefonoreferencias) {
				if(telefonoreferenciaLocal.getId().equals(telefonoreferencia.getId())) {
					telefonoreferenciaLocal.setIsSelected(telefonoreferencia.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTelefonoReferencia(List<TelefonoReferencia> telefonoreferenciasAux) throws Exception {
		//this.telefonoreferenciasAux=telefonoreferenciasAux;
		
		for(TelefonoReferencia telefonoreferenciaAux:telefonoreferenciasAux) {
			if(telefonoreferenciaAux.getIsChanged()) {
				telefonoreferenciaAux.setIsChanged(false);
			}		
			
			if(telefonoreferenciaAux.getIsNew()) {
				telefonoreferenciaAux.setIsNew(false);
			}	
			
			if(telefonoreferenciaAux.getIsDeleted()) {
				telefonoreferenciaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTelefonoReferencia(TelefonoReferencia telefonoreferenciaAux) throws Exception {
		//this.telefonoreferenciaAux=telefonoreferenciaAux;
		
			if(telefonoreferenciaAux.getIsChanged()) {
				telefonoreferenciaAux.setIsChanged(false);
			}		
			
			if(telefonoreferenciaAux.getIsNew()) {
				telefonoreferenciaAux.setIsNew(false);
			}	
			
			if(telefonoreferenciaAux.getIsDeleted()) {
				telefonoreferenciaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TelefonoReferencia telefonoreferenciaAsignar,TelefonoReferencia telefonoreferencia) throws Exception {
		telefonoreferenciaAsignar.setId(telefonoreferencia.getId());	
		telefonoreferenciaAsignar.setVersionRow(telefonoreferencia.getVersionRow());	
		telefonoreferenciaAsignar.setid_referencia(telefonoreferencia.getid_referencia());
		telefonoreferenciaAsignar.setreferencia_descripcion(telefonoreferencia.getreferencia_descripcion());	
		telefonoreferenciaAsignar.setnumero(telefonoreferencia.getnumero());	
	}
	
	public static void inicializarTelefonoReferencia(TelefonoReferencia telefonoreferencia) throws Exception {
		try {
				telefonoreferencia.setId(0L);	
					
				telefonoreferencia.setid_referencia(-1L);	
				telefonoreferencia.setnumero("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTelefonoReferencia(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TelefonoReferenciaConstantesFunciones.LABEL_IDREFERENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TelefonoReferenciaConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTelefonoReferencia(String sTipo,Row row,Workbook workbook,TelefonoReferencia telefonoreferencia,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(telefonoreferencia.getreferencia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(telefonoreferencia.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTelefonoReferencia=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTelefonoReferencia() {
		return this.sFinalQueryTelefonoReferencia;
	}
	
	public void setsFinalQueryTelefonoReferencia(String sFinalQueryTelefonoReferencia) {
		this.sFinalQueryTelefonoReferencia= sFinalQueryTelefonoReferencia;
	}
	
	public Border resaltarSeleccionarTelefonoReferencia=null;
	
	public Border setResaltarSeleccionarTelefonoReferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TelefonoReferenciaBeanSwingJInternalFrame telefonoreferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//telefonoreferenciaBeanSwingJInternalFrame.jTtoolBarTelefonoReferencia.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTelefonoReferencia= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTelefonoReferencia() {
		return this.resaltarSeleccionarTelefonoReferencia;
	}
	
	public void setResaltarSeleccionarTelefonoReferencia(Border borderResaltarSeleccionarTelefonoReferencia) {
		this.resaltarSeleccionarTelefonoReferencia= borderResaltarSeleccionarTelefonoReferencia;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTelefonoReferencia=null;
	public Boolean mostraridTelefonoReferencia=true;
	public Boolean activaridTelefonoReferencia=true;

	public Border resaltarid_referenciaTelefonoReferencia=null;
	public Boolean mostrarid_referenciaTelefonoReferencia=true;
	public Boolean activarid_referenciaTelefonoReferencia=true;
	public Boolean cargarid_referenciaTelefonoReferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_referenciaTelefonoReferencia=false;//ConEventDepend=true

	public Border resaltarnumeroTelefonoReferencia=null;
	public Boolean mostrarnumeroTelefonoReferencia=true;
	public Boolean activarnumeroTelefonoReferencia=true;

	
	

	public Border setResaltaridTelefonoReferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TelefonoReferenciaBeanSwingJInternalFrame telefonoreferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//telefonoreferenciaBeanSwingJInternalFrame.jTtoolBarTelefonoReferencia.setBorder(borderResaltar);
		
		this.resaltaridTelefonoReferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTelefonoReferencia() {
		return this.resaltaridTelefonoReferencia;
	}

	public void setResaltaridTelefonoReferencia(Border borderResaltar) {
		this.resaltaridTelefonoReferencia= borderResaltar;
	}

	public Boolean getMostraridTelefonoReferencia() {
		return this.mostraridTelefonoReferencia;
	}

	public void setMostraridTelefonoReferencia(Boolean mostraridTelefonoReferencia) {
		this.mostraridTelefonoReferencia= mostraridTelefonoReferencia;
	}

	public Boolean getActivaridTelefonoReferencia() {
		return this.activaridTelefonoReferencia;
	}

	public void setActivaridTelefonoReferencia(Boolean activaridTelefonoReferencia) {
		this.activaridTelefonoReferencia= activaridTelefonoReferencia;
	}

	public Border setResaltarid_referenciaTelefonoReferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TelefonoReferenciaBeanSwingJInternalFrame telefonoreferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//telefonoreferenciaBeanSwingJInternalFrame.jTtoolBarTelefonoReferencia.setBorder(borderResaltar);
		
		this.resaltarid_referenciaTelefonoReferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_referenciaTelefonoReferencia() {
		return this.resaltarid_referenciaTelefonoReferencia;
	}

	public void setResaltarid_referenciaTelefonoReferencia(Border borderResaltar) {
		this.resaltarid_referenciaTelefonoReferencia= borderResaltar;
	}

	public Boolean getMostrarid_referenciaTelefonoReferencia() {
		return this.mostrarid_referenciaTelefonoReferencia;
	}

	public void setMostrarid_referenciaTelefonoReferencia(Boolean mostrarid_referenciaTelefonoReferencia) {
		this.mostrarid_referenciaTelefonoReferencia= mostrarid_referenciaTelefonoReferencia;
	}

	public Boolean getActivarid_referenciaTelefonoReferencia() {
		return this.activarid_referenciaTelefonoReferencia;
	}

	public void setActivarid_referenciaTelefonoReferencia(Boolean activarid_referenciaTelefonoReferencia) {
		this.activarid_referenciaTelefonoReferencia= activarid_referenciaTelefonoReferencia;
	}

	public Boolean getCargarid_referenciaTelefonoReferencia() {
		return this.cargarid_referenciaTelefonoReferencia;
	}

	public void setCargarid_referenciaTelefonoReferencia(Boolean cargarid_referenciaTelefonoReferencia) {
		this.cargarid_referenciaTelefonoReferencia= cargarid_referenciaTelefonoReferencia;
	}

	public Border setResaltarnumeroTelefonoReferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TelefonoReferenciaBeanSwingJInternalFrame telefonoreferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//telefonoreferenciaBeanSwingJInternalFrame.jTtoolBarTelefonoReferencia.setBorder(borderResaltar);
		
		this.resaltarnumeroTelefonoReferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroTelefonoReferencia() {
		return this.resaltarnumeroTelefonoReferencia;
	}

	public void setResaltarnumeroTelefonoReferencia(Border borderResaltar) {
		this.resaltarnumeroTelefonoReferencia= borderResaltar;
	}

	public Boolean getMostrarnumeroTelefonoReferencia() {
		return this.mostrarnumeroTelefonoReferencia;
	}

	public void setMostrarnumeroTelefonoReferencia(Boolean mostrarnumeroTelefonoReferencia) {
		this.mostrarnumeroTelefonoReferencia= mostrarnumeroTelefonoReferencia;
	}

	public Boolean getActivarnumeroTelefonoReferencia() {
		return this.activarnumeroTelefonoReferencia;
	}

	public void setActivarnumeroTelefonoReferencia(Boolean activarnumeroTelefonoReferencia) {
		this.activarnumeroTelefonoReferencia= activarnumeroTelefonoReferencia;
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
		
		
		this.setMostraridTelefonoReferencia(esInicial);
		this.setMostrarid_referenciaTelefonoReferencia(esInicial);
		this.setMostrarnumeroTelefonoReferencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TelefonoReferenciaConstantesFunciones.ID)) {
				this.setMostraridTelefonoReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoReferenciaConstantesFunciones.IDREFERENCIA)) {
				this.setMostrarid_referenciaTelefonoReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoReferenciaConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroTelefonoReferencia(esAsigna);
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
		
		
		this.setActivaridTelefonoReferencia(esInicial);
		this.setActivarid_referenciaTelefonoReferencia(esInicial);
		this.setActivarnumeroTelefonoReferencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TelefonoReferenciaConstantesFunciones.ID)) {
				this.setActivaridTelefonoReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoReferenciaConstantesFunciones.IDREFERENCIA)) {
				this.setActivarid_referenciaTelefonoReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoReferenciaConstantesFunciones.NUMERO)) {
				this.setActivarnumeroTelefonoReferencia(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TelefonoReferenciaBeanSwingJInternalFrame telefonoreferenciaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTelefonoReferencia(esInicial);
		this.setResaltarid_referenciaTelefonoReferencia(esInicial);
		this.setResaltarnumeroTelefonoReferencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TelefonoReferenciaConstantesFunciones.ID)) {
				this.setResaltaridTelefonoReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoReferenciaConstantesFunciones.IDREFERENCIA)) {
				this.setResaltarid_referenciaTelefonoReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoReferenciaConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroTelefonoReferencia(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TelefonoReferenciaBeanSwingJInternalFrame telefonoreferenciaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdReferenciaTelefonoReferencia=true;

	public Boolean getMostrarFK_IdReferenciaTelefonoReferencia() {
		return this.mostrarFK_IdReferenciaTelefonoReferencia;
	}

	public void setMostrarFK_IdReferenciaTelefonoReferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdReferenciaTelefonoReferencia= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdReferenciaTelefonoReferencia=true;

	public Boolean getActivarFK_IdReferenciaTelefonoReferencia() {
		return this.activarFK_IdReferenciaTelefonoReferencia;
	}

	public void setActivarFK_IdReferenciaTelefonoReferencia(Boolean habilitarResaltar) {
		this.activarFK_IdReferenciaTelefonoReferencia= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdReferenciaTelefonoReferencia=null;

	public Border getResaltarFK_IdReferenciaTelefonoReferencia() {
		return this.resaltarFK_IdReferenciaTelefonoReferencia;
	}

	public void setResaltarFK_IdReferenciaTelefonoReferencia(Border borderResaltar) {
		this.resaltarFK_IdReferenciaTelefonoReferencia= borderResaltar;
	}

	public void setResaltarFK_IdReferenciaTelefonoReferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TelefonoReferenciaBeanSwingJInternalFrame telefonoreferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdReferenciaTelefonoReferencia= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}