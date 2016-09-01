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
package com.bydan.erp.puntoventa.util;

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


import com.bydan.erp.puntoventa.util.TipoRiesgoClienteConstantesFunciones;
import com.bydan.erp.puntoventa.util.TipoRiesgoClienteParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.TipoRiesgoClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoRiesgoClienteConstantesFunciones extends TipoRiesgoClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoRiesgoCliente";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoRiesgoCliente"+TipoRiesgoClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoRiesgoClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoRiesgoClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoRiesgoClienteConstantesFunciones.SCHEMA+"_"+TipoRiesgoClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoRiesgoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoRiesgoClienteConstantesFunciones.SCHEMA+"_"+TipoRiesgoClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoRiesgoClienteConstantesFunciones.SCHEMA+"_"+TipoRiesgoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoRiesgoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoRiesgoClienteConstantesFunciones.SCHEMA+"_"+TipoRiesgoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRiesgoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRiesgoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRiesgoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRiesgoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRiesgoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRiesgoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoRiesgoClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoRiesgoClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoRiesgoClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoRiesgoClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Riesgo Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Riesgo Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Riesgo Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoRiesgoCliente";
	public static final String OBJECTNAME="tiporiesgocliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="tipo_riesgo_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiporiesgocliente from "+TipoRiesgoClienteConstantesFunciones.SPERSISTENCENAME+" tiporiesgocliente";
	public static String QUERYSELECTNATIVE="select "+TipoRiesgoClienteConstantesFunciones.SCHEMA+"."+TipoRiesgoClienteConstantesFunciones.TABLENAME+".id,"+TipoRiesgoClienteConstantesFunciones.SCHEMA+"."+TipoRiesgoClienteConstantesFunciones.TABLENAME+".version_row,"+TipoRiesgoClienteConstantesFunciones.SCHEMA+"."+TipoRiesgoClienteConstantesFunciones.TABLENAME+".id_empresa,"+TipoRiesgoClienteConstantesFunciones.SCHEMA+"."+TipoRiesgoClienteConstantesFunciones.TABLENAME+".nombre from "+TipoRiesgoClienteConstantesFunciones.SCHEMA+"."+TipoRiesgoClienteConstantesFunciones.TABLENAME;//+" as "+TipoRiesgoClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoRiesgoClienteConstantesFuncionesAdditional tiporiesgoclienteConstantesFuncionesAdditional=null;
	
	public TipoRiesgoClienteConstantesFuncionesAdditional getTipoRiesgoClienteConstantesFuncionesAdditional() {
		return this.tiporiesgoclienteConstantesFuncionesAdditional;
	}
	
	public void setTipoRiesgoClienteConstantesFuncionesAdditional(TipoRiesgoClienteConstantesFuncionesAdditional tiporiesgoclienteConstantesFuncionesAdditional) {
		try {
			this.tiporiesgoclienteConstantesFuncionesAdditional=tiporiesgoclienteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoRiesgoClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoRiesgoClienteConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoRiesgoClienteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoRiesgoClienteConstantesFunciones.NOMBRE)) {sLabelColumna=TipoRiesgoClienteConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoRiesgoClienteDescripcion(TipoRiesgoCliente tiporiesgocliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiporiesgocliente !=null/* && tiporiesgocliente.getId()!=0*/) {
			sDescripcion=tiporiesgocliente.getnombre();//tiporiesgoclientetiporiesgocliente.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoRiesgoClienteDescripcionDetallado(TipoRiesgoCliente tiporiesgocliente) {
		String sDescripcion="";
			
		sDescripcion+=TipoRiesgoClienteConstantesFunciones.ID+"=";
		sDescripcion+=tiporiesgocliente.getId().toString()+",";
		sDescripcion+=TipoRiesgoClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiporiesgocliente.getVersionRow().toString()+",";
		sDescripcion+=TipoRiesgoClienteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tiporiesgocliente.getid_empresa().toString()+",";
		sDescripcion+=TipoRiesgoClienteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiporiesgocliente.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoRiesgoClienteDescripcion(TipoRiesgoCliente tiporiesgocliente,String sValor) throws Exception {			
		if(tiporiesgocliente !=null) {
			tiporiesgocliente.setnombre(sValor);;//tiporiesgoclientetiporiesgocliente.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoRiesgoCliente(TipoRiesgoCliente tiporiesgocliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiporiesgocliente.setnombre(tiporiesgocliente.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoRiesgoClientes(List<TipoRiesgoCliente> tiporiesgoclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoRiesgoCliente tiporiesgocliente: tiporiesgoclientes) {
			tiporiesgocliente.setnombre(tiporiesgocliente.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRiesgoCliente(TipoRiesgoCliente tiporiesgocliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiporiesgocliente.getConCambioAuxiliar()) {
			tiporiesgocliente.setIsDeleted(tiporiesgocliente.getIsDeletedAuxiliar());	
			tiporiesgocliente.setIsNew(tiporiesgocliente.getIsNewAuxiliar());	
			tiporiesgocliente.setIsChanged(tiporiesgocliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiporiesgocliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiporiesgocliente.setIsDeletedAuxiliar(false);	
			tiporiesgocliente.setIsNewAuxiliar(false);	
			tiporiesgocliente.setIsChangedAuxiliar(false);
			
			tiporiesgocliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRiesgoClientes(List<TipoRiesgoCliente> tiporiesgoclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoRiesgoCliente tiporiesgocliente : tiporiesgoclientes) {
			if(conAsignarBase && tiporiesgocliente.getConCambioAuxiliar()) {
				tiporiesgocliente.setIsDeleted(tiporiesgocliente.getIsDeletedAuxiliar());	
				tiporiesgocliente.setIsNew(tiporiesgocliente.getIsNewAuxiliar());	
				tiporiesgocliente.setIsChanged(tiporiesgocliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiporiesgocliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiporiesgocliente.setIsDeletedAuxiliar(false);	
				tiporiesgocliente.setIsNewAuxiliar(false);	
				tiporiesgocliente.setIsChangedAuxiliar(false);
				
				tiporiesgocliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoRiesgoCliente(TipoRiesgoCliente tiporiesgocliente,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoRiesgoClientes(List<TipoRiesgoCliente> tiporiesgoclientes,Boolean conEnteros) throws Exception  {
		
		for(TipoRiesgoCliente tiporiesgocliente: tiporiesgoclientes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoRiesgoCliente(List<TipoRiesgoCliente> tiporiesgoclientes,TipoRiesgoCliente tiporiesgoclienteAux) throws Exception  {
		TipoRiesgoClienteConstantesFunciones.InicializarValoresTipoRiesgoCliente(tiporiesgoclienteAux,true);
		
		for(TipoRiesgoCliente tiporiesgocliente: tiporiesgoclientes) {
			if(tiporiesgocliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRiesgoCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoRiesgoClienteConstantesFunciones.getArrayColumnasGlobalesTipoRiesgoCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRiesgoCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoRiesgoClienteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoRiesgoClienteConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoRiesgoCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoRiesgoCliente> tiporiesgoclientes,TipoRiesgoCliente tiporiesgocliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoRiesgoCliente tiporiesgoclienteAux: tiporiesgoclientes) {
			if(tiporiesgoclienteAux!=null && tiporiesgocliente!=null) {
				if((tiporiesgoclienteAux.getId()==null && tiporiesgocliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiporiesgoclienteAux.getId()!=null && tiporiesgocliente.getId()!=null){
					if(tiporiesgoclienteAux.getId().equals(tiporiesgocliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoRiesgoCliente(List<TipoRiesgoCliente> tiporiesgoclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoRiesgoCliente tiporiesgocliente: tiporiesgoclientes) {			
			if(tiporiesgocliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoRiesgoCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoRiesgoClienteConstantesFunciones.LABEL_ID, TipoRiesgoClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRiesgoClienteConstantesFunciones.LABEL_VERSIONROW, TipoRiesgoClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRiesgoClienteConstantesFunciones.LABEL_IDEMPRESA, TipoRiesgoClienteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRiesgoClienteConstantesFunciones.LABEL_NOMBRE, TipoRiesgoClienteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoRiesgoCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoRiesgoClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRiesgoClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRiesgoClienteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRiesgoClienteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRiesgoCliente() throws Exception  {
		return TipoRiesgoClienteConstantesFunciones.getTiposSeleccionarTipoRiesgoCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRiesgoCliente(Boolean conFk) throws Exception  {
		return TipoRiesgoClienteConstantesFunciones.getTiposSeleccionarTipoRiesgoCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRiesgoCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRiesgoClienteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoRiesgoClienteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRiesgoClienteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoRiesgoClienteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoRiesgoCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRiesgoCliente(TipoRiesgoCliente tiporiesgoclienteAux) throws Exception {
		
			tiporiesgoclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiporiesgoclienteAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRiesgoCliente(List<TipoRiesgoCliente> tiporiesgoclientesTemp) throws Exception {
		for(TipoRiesgoCliente tiporiesgoclienteAux:tiporiesgoclientesTemp) {
			
			tiporiesgoclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiporiesgoclienteAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRiesgoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoRiesgoCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRiesgoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRiesgoClienteConstantesFunciones.getClassesRelationshipsOfTipoRiesgoCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRiesgoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRiesgoCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRiesgoClienteConstantesFunciones.getClassesRelationshipsFromStringsOfTipoRiesgoCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRiesgoCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoRiesgoCliente tiporiesgocliente,List<TipoRiesgoCliente> tiporiesgoclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoRiesgoCliente tiporiesgoclienteEncontrado=null;
			
			for(TipoRiesgoCliente tiporiesgoclienteLocal:tiporiesgoclientes) {
				if(tiporiesgoclienteLocal.getId().equals(tiporiesgocliente.getId())) {
					tiporiesgoclienteEncontrado=tiporiesgoclienteLocal;
					
					tiporiesgoclienteLocal.setIsChanged(tiporiesgocliente.getIsChanged());
					tiporiesgoclienteLocal.setIsNew(tiporiesgocliente.getIsNew());
					tiporiesgoclienteLocal.setIsDeleted(tiporiesgocliente.getIsDeleted());
					
					tiporiesgoclienteLocal.setGeneralEntityOriginal(tiporiesgocliente.getGeneralEntityOriginal());
					
					tiporiesgoclienteLocal.setId(tiporiesgocliente.getId());	
					tiporiesgoclienteLocal.setVersionRow(tiporiesgocliente.getVersionRow());	
					tiporiesgoclienteLocal.setid_empresa(tiporiesgocliente.getid_empresa());	
					tiporiesgoclienteLocal.setnombre(tiporiesgocliente.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tiporiesgocliente.getIsDeleted()) {
				if(!existe) {
					tiporiesgoclientes.add(tiporiesgocliente);
				}
			} else {
				if(tiporiesgoclienteEncontrado!=null && permiteQuitar)  {
					tiporiesgoclientes.remove(tiporiesgoclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoRiesgoCliente tiporiesgocliente,List<TipoRiesgoCliente> tiporiesgoclientes) throws Exception {
		try	{			
			for(TipoRiesgoCliente tiporiesgoclienteLocal:tiporiesgoclientes) {
				if(tiporiesgoclienteLocal.getId().equals(tiporiesgocliente.getId())) {
					tiporiesgoclienteLocal.setIsSelected(tiporiesgocliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoRiesgoCliente(List<TipoRiesgoCliente> tiporiesgoclientesAux) throws Exception {
		//this.tiporiesgoclientesAux=tiporiesgoclientesAux;
		
		for(TipoRiesgoCliente tiporiesgoclienteAux:tiporiesgoclientesAux) {
			if(tiporiesgoclienteAux.getIsChanged()) {
				tiporiesgoclienteAux.setIsChanged(false);
			}		
			
			if(tiporiesgoclienteAux.getIsNew()) {
				tiporiesgoclienteAux.setIsNew(false);
			}	
			
			if(tiporiesgoclienteAux.getIsDeleted()) {
				tiporiesgoclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoRiesgoCliente(TipoRiesgoCliente tiporiesgoclienteAux) throws Exception {
		//this.tiporiesgoclienteAux=tiporiesgoclienteAux;
		
			if(tiporiesgoclienteAux.getIsChanged()) {
				tiporiesgoclienteAux.setIsChanged(false);
			}		
			
			if(tiporiesgoclienteAux.getIsNew()) {
				tiporiesgoclienteAux.setIsNew(false);
			}	
			
			if(tiporiesgoclienteAux.getIsDeleted()) {
				tiporiesgoclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoRiesgoCliente tiporiesgoclienteAsignar,TipoRiesgoCliente tiporiesgocliente) throws Exception {
		tiporiesgoclienteAsignar.setId(tiporiesgocliente.getId());	
		tiporiesgoclienteAsignar.setVersionRow(tiporiesgocliente.getVersionRow());	
		tiporiesgoclienteAsignar.setid_empresa(tiporiesgocliente.getid_empresa());
		tiporiesgoclienteAsignar.setempresa_descripcion(tiporiesgocliente.getempresa_descripcion());	
		tiporiesgoclienteAsignar.setnombre(tiporiesgocliente.getnombre());	
	}
	
	public static void inicializarTipoRiesgoCliente(TipoRiesgoCliente tiporiesgocliente) throws Exception {
		try {
				tiporiesgocliente.setId(0L);	
					
				tiporiesgocliente.setid_empresa(-1L);	
				tiporiesgocliente.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoRiesgoCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRiesgoClienteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRiesgoClienteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoRiesgoCliente(String sTipo,Row row,Workbook workbook,TipoRiesgoCliente tiporiesgocliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporiesgocliente.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporiesgocliente.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoRiesgoCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoRiesgoCliente() {
		return this.sFinalQueryTipoRiesgoCliente;
	}
	
	public void setsFinalQueryTipoRiesgoCliente(String sFinalQueryTipoRiesgoCliente) {
		this.sFinalQueryTipoRiesgoCliente= sFinalQueryTipoRiesgoCliente;
	}
	
	public Border resaltarSeleccionarTipoRiesgoCliente=null;
	
	public Border setResaltarSeleccionarTipoRiesgoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRiesgoClienteBeanSwingJInternalFrame tiporiesgoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiporiesgoclienteBeanSwingJInternalFrame.jTtoolBarTipoRiesgoCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoRiesgoCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoRiesgoCliente() {
		return this.resaltarSeleccionarTipoRiesgoCliente;
	}
	
	public void setResaltarSeleccionarTipoRiesgoCliente(Border borderResaltarSeleccionarTipoRiesgoCliente) {
		this.resaltarSeleccionarTipoRiesgoCliente= borderResaltarSeleccionarTipoRiesgoCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoRiesgoCliente=null;
	public Boolean mostraridTipoRiesgoCliente=true;
	public Boolean activaridTipoRiesgoCliente=true;

	public Border resaltarid_empresaTipoRiesgoCliente=null;
	public Boolean mostrarid_empresaTipoRiesgoCliente=true;
	public Boolean activarid_empresaTipoRiesgoCliente=true;
	public Boolean cargarid_empresaTipoRiesgoCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoRiesgoCliente=false;//ConEventDepend=true

	public Border resaltarnombreTipoRiesgoCliente=null;
	public Boolean mostrarnombreTipoRiesgoCliente=true;
	public Boolean activarnombreTipoRiesgoCliente=true;

	
	

	public Border setResaltaridTipoRiesgoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRiesgoClienteBeanSwingJInternalFrame tiporiesgoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporiesgoclienteBeanSwingJInternalFrame.jTtoolBarTipoRiesgoCliente.setBorder(borderResaltar);
		
		this.resaltaridTipoRiesgoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoRiesgoCliente() {
		return this.resaltaridTipoRiesgoCliente;
	}

	public void setResaltaridTipoRiesgoCliente(Border borderResaltar) {
		this.resaltaridTipoRiesgoCliente= borderResaltar;
	}

	public Boolean getMostraridTipoRiesgoCliente() {
		return this.mostraridTipoRiesgoCliente;
	}

	public void setMostraridTipoRiesgoCliente(Boolean mostraridTipoRiesgoCliente) {
		this.mostraridTipoRiesgoCliente= mostraridTipoRiesgoCliente;
	}

	public Boolean getActivaridTipoRiesgoCliente() {
		return this.activaridTipoRiesgoCliente;
	}

	public void setActivaridTipoRiesgoCliente(Boolean activaridTipoRiesgoCliente) {
		this.activaridTipoRiesgoCliente= activaridTipoRiesgoCliente;
	}

	public Border setResaltarid_empresaTipoRiesgoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRiesgoClienteBeanSwingJInternalFrame tiporiesgoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporiesgoclienteBeanSwingJInternalFrame.jTtoolBarTipoRiesgoCliente.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoRiesgoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoRiesgoCliente() {
		return this.resaltarid_empresaTipoRiesgoCliente;
	}

	public void setResaltarid_empresaTipoRiesgoCliente(Border borderResaltar) {
		this.resaltarid_empresaTipoRiesgoCliente= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoRiesgoCliente() {
		return this.mostrarid_empresaTipoRiesgoCliente;
	}

	public void setMostrarid_empresaTipoRiesgoCliente(Boolean mostrarid_empresaTipoRiesgoCliente) {
		this.mostrarid_empresaTipoRiesgoCliente= mostrarid_empresaTipoRiesgoCliente;
	}

	public Boolean getActivarid_empresaTipoRiesgoCliente() {
		return this.activarid_empresaTipoRiesgoCliente;
	}

	public void setActivarid_empresaTipoRiesgoCliente(Boolean activarid_empresaTipoRiesgoCliente) {
		this.activarid_empresaTipoRiesgoCliente= activarid_empresaTipoRiesgoCliente;
	}

	public Boolean getCargarid_empresaTipoRiesgoCliente() {
		return this.cargarid_empresaTipoRiesgoCliente;
	}

	public void setCargarid_empresaTipoRiesgoCliente(Boolean cargarid_empresaTipoRiesgoCliente) {
		this.cargarid_empresaTipoRiesgoCliente= cargarid_empresaTipoRiesgoCliente;
	}

	public Border setResaltarnombreTipoRiesgoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRiesgoClienteBeanSwingJInternalFrame tiporiesgoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporiesgoclienteBeanSwingJInternalFrame.jTtoolBarTipoRiesgoCliente.setBorder(borderResaltar);
		
		this.resaltarnombreTipoRiesgoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoRiesgoCliente() {
		return this.resaltarnombreTipoRiesgoCliente;
	}

	public void setResaltarnombreTipoRiesgoCliente(Border borderResaltar) {
		this.resaltarnombreTipoRiesgoCliente= borderResaltar;
	}

	public Boolean getMostrarnombreTipoRiesgoCliente() {
		return this.mostrarnombreTipoRiesgoCliente;
	}

	public void setMostrarnombreTipoRiesgoCliente(Boolean mostrarnombreTipoRiesgoCliente) {
		this.mostrarnombreTipoRiesgoCliente= mostrarnombreTipoRiesgoCliente;
	}

	public Boolean getActivarnombreTipoRiesgoCliente() {
		return this.activarnombreTipoRiesgoCliente;
	}

	public void setActivarnombreTipoRiesgoCliente(Boolean activarnombreTipoRiesgoCliente) {
		this.activarnombreTipoRiesgoCliente= activarnombreTipoRiesgoCliente;
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
		
		
		this.setMostraridTipoRiesgoCliente(esInicial);
		this.setMostrarid_empresaTipoRiesgoCliente(esInicial);
		this.setMostrarnombreTipoRiesgoCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRiesgoClienteConstantesFunciones.ID)) {
				this.setMostraridTipoRiesgoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRiesgoClienteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoRiesgoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRiesgoClienteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoRiesgoCliente(esAsigna);
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
		
		
		this.setActivaridTipoRiesgoCliente(esInicial);
		this.setActivarid_empresaTipoRiesgoCliente(esInicial);
		this.setActivarnombreTipoRiesgoCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRiesgoClienteConstantesFunciones.ID)) {
				this.setActivaridTipoRiesgoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRiesgoClienteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoRiesgoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRiesgoClienteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoRiesgoCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRiesgoClienteBeanSwingJInternalFrame tiporiesgoclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoRiesgoCliente(esInicial);
		this.setResaltarid_empresaTipoRiesgoCliente(esInicial);
		this.setResaltarnombreTipoRiesgoCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRiesgoClienteConstantesFunciones.ID)) {
				this.setResaltaridTipoRiesgoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRiesgoClienteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoRiesgoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRiesgoClienteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoRiesgoCliente(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRiesgoClienteBeanSwingJInternalFrame tiporiesgoclienteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTipoRiesgoCliente=true;

	public Boolean getMostrarFK_IdEmpresaTipoRiesgoCliente() {
		return this.mostrarFK_IdEmpresaTipoRiesgoCliente;
	}

	public void setMostrarFK_IdEmpresaTipoRiesgoCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoRiesgoCliente= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoRiesgoCliente=true;

	public Boolean getActivarFK_IdEmpresaTipoRiesgoCliente() {
		return this.activarFK_IdEmpresaTipoRiesgoCliente;
	}

	public void setActivarFK_IdEmpresaTipoRiesgoCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoRiesgoCliente= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoRiesgoCliente=null;

	public Border getResaltarFK_IdEmpresaTipoRiesgoCliente() {
		return this.resaltarFK_IdEmpresaTipoRiesgoCliente;
	}

	public void setResaltarFK_IdEmpresaTipoRiesgoCliente(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoRiesgoCliente= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoRiesgoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRiesgoClienteBeanSwingJInternalFrame tiporiesgoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoRiesgoCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}