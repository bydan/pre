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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.TipoTituloClienteConstantesFunciones;
import com.bydan.erp.cartera.util.TipoTituloClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoTituloClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoTituloClienteConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoTituloCliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoTituloCliente"+TipoTituloClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoTituloClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoTituloClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoTituloClienteConstantesFunciones.SCHEMA+"_"+TipoTituloClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoTituloClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoTituloClienteConstantesFunciones.SCHEMA+"_"+TipoTituloClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoTituloClienteConstantesFunciones.SCHEMA+"_"+TipoTituloClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoTituloClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoTituloClienteConstantesFunciones.SCHEMA+"_"+TipoTituloClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTituloClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoTituloClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTituloClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTituloClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoTituloClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTituloClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoTituloClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoTituloClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoTituloClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoTituloClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Titulo Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Titulo Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Titulo Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoTituloCliente";
	public static final String OBJECTNAME="tipotitulocliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_titulo_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipotitulocliente from "+TipoTituloClienteConstantesFunciones.SPERSISTENCENAME+" tipotitulocliente";
	public static String QUERYSELECTNATIVE="select "+TipoTituloClienteConstantesFunciones.SCHEMA+"."+TipoTituloClienteConstantesFunciones.TABLENAME+".id,"+TipoTituloClienteConstantesFunciones.SCHEMA+"."+TipoTituloClienteConstantesFunciones.TABLENAME+".version_row,"+TipoTituloClienteConstantesFunciones.SCHEMA+"."+TipoTituloClienteConstantesFunciones.TABLENAME+".id_pais,"+TipoTituloClienteConstantesFunciones.SCHEMA+"."+TipoTituloClienteConstantesFunciones.TABLENAME+".nombre,"+TipoTituloClienteConstantesFunciones.SCHEMA+"."+TipoTituloClienteConstantesFunciones.TABLENAME+".siglas from "+TipoTituloClienteConstantesFunciones.SCHEMA+"."+TipoTituloClienteConstantesFunciones.TABLENAME;//+" as "+TipoTituloClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPAIS= "id_pais";
    public static final String NOMBRE= "nombre";
    public static final String SIGLAS= "siglas";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_SIGLAS= "Siglas";
		public static final String LABEL_SIGLAS_LOWER= "Siglas";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSIGLAS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSIGLAS=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoTituloClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoTituloClienteConstantesFunciones.IDPAIS)) {sLabelColumna=TipoTituloClienteConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(TipoTituloClienteConstantesFunciones.NOMBRE)) {sLabelColumna=TipoTituloClienteConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoTituloClienteConstantesFunciones.SIGLAS)) {sLabelColumna=TipoTituloClienteConstantesFunciones.LABEL_SIGLAS;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoTituloClienteDescripcion(TipoTituloCliente tipotitulocliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipotitulocliente !=null/* && tipotitulocliente.getId()!=0*/) {
			sDescripcion=tipotitulocliente.getnombre();//tipotituloclientetipotitulocliente.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoTituloClienteDescripcionDetallado(TipoTituloCliente tipotitulocliente) {
		String sDescripcion="";
			
		sDescripcion+=TipoTituloClienteConstantesFunciones.ID+"=";
		sDescripcion+=tipotitulocliente.getId().toString()+",";
		sDescripcion+=TipoTituloClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipotitulocliente.getVersionRow().toString()+",";
		sDescripcion+=TipoTituloClienteConstantesFunciones.IDPAIS+"=";
		sDescripcion+=tipotitulocliente.getid_pais().toString()+",";
		sDescripcion+=TipoTituloClienteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipotitulocliente.getnombre()+",";
		sDescripcion+=TipoTituloClienteConstantesFunciones.SIGLAS+"=";
		sDescripcion+=tipotitulocliente.getsiglas()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoTituloClienteDescripcion(TipoTituloCliente tipotitulocliente,String sValor) throws Exception {			
		if(tipotitulocliente !=null) {
			tipotitulocliente.setnombre(sValor);//tipotituloclientetipotitulocliente.getId().toString();
		}		
	}
	
		

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorId")) {
			sNombreIndice="Tipo=  Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("BusquedaPorSiglas")) {
			sNombreIndice="Tipo=  Por Siglas";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("PorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorId(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorSiglas(String siglas) {
		String sDetalleIndice=" Parametros->";
		if(siglas!=null) {sDetalleIndice+=" Siglas="+siglas;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoTituloCliente(TipoTituloCliente tipotitulocliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipotitulocliente.setnombre(tipotitulocliente.getnombre().trim());
		tipotitulocliente.setsiglas(tipotitulocliente.getsiglas().trim());
	}
	
	public static void quitarEspaciosTipoTituloClientes(List<TipoTituloCliente> tipotituloclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoTituloCliente tipotitulocliente: tipotituloclientes) {
			tipotitulocliente.setnombre(tipotitulocliente.getnombre().trim());
			tipotitulocliente.setsiglas(tipotitulocliente.getsiglas().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoTituloCliente(TipoTituloCliente tipotitulocliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipotitulocliente.getConCambioAuxiliar()) {
			tipotitulocliente.setIsDeleted(tipotitulocliente.getIsDeletedAuxiliar());	
			tipotitulocliente.setIsNew(tipotitulocliente.getIsNewAuxiliar());	
			tipotitulocliente.setIsChanged(tipotitulocliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipotitulocliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipotitulocliente.setIsDeletedAuxiliar(false);	
			tipotitulocliente.setIsNewAuxiliar(false);	
			tipotitulocliente.setIsChangedAuxiliar(false);
			
			tipotitulocliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoTituloClientes(List<TipoTituloCliente> tipotituloclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoTituloCliente tipotitulocliente : tipotituloclientes) {
			if(conAsignarBase && tipotitulocliente.getConCambioAuxiliar()) {
				tipotitulocliente.setIsDeleted(tipotitulocliente.getIsDeletedAuxiliar());	
				tipotitulocliente.setIsNew(tipotitulocliente.getIsNewAuxiliar());	
				tipotitulocliente.setIsChanged(tipotitulocliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipotitulocliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipotitulocliente.setIsDeletedAuxiliar(false);	
				tipotitulocliente.setIsNewAuxiliar(false);	
				tipotitulocliente.setIsChangedAuxiliar(false);
				
				tipotitulocliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoTituloCliente(TipoTituloCliente tipotitulocliente,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoTituloClientes(List<TipoTituloCliente> tipotituloclientes,Boolean conEnteros) throws Exception  {
		
		for(TipoTituloCliente tipotitulocliente: tipotituloclientes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoTituloCliente(List<TipoTituloCliente> tipotituloclientes,TipoTituloCliente tipotituloclienteAux) throws Exception  {
		TipoTituloClienteConstantesFunciones.InicializarValoresTipoTituloCliente(tipotituloclienteAux,true);
		
		for(TipoTituloCliente tipotitulocliente: tipotituloclientes) {
			if(tipotitulocliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoTituloCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoTituloClienteConstantesFunciones.getArrayColumnasGlobalesTipoTituloCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoTituloCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoTituloCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoTituloCliente> tipotituloclientes,TipoTituloCliente tipotitulocliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoTituloCliente tipotituloclienteAux: tipotituloclientes) {
			if(tipotituloclienteAux!=null && tipotitulocliente!=null) {
				if((tipotituloclienteAux.getId()==null && tipotitulocliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipotituloclienteAux.getId()!=null && tipotitulocliente.getId()!=null){
					if(tipotituloclienteAux.getId().equals(tipotitulocliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoTituloCliente(List<TipoTituloCliente> tipotituloclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoTituloCliente tipotitulocliente: tipotituloclientes) {			
			if(tipotitulocliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoTituloCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoTituloClienteConstantesFunciones.LABEL_ID, TipoTituloClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTituloClienteConstantesFunciones.LABEL_VERSIONROW, TipoTituloClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTituloClienteConstantesFunciones.LABEL_IDPAIS, TipoTituloClienteConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTituloClienteConstantesFunciones.LABEL_NOMBRE, TipoTituloClienteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTituloClienteConstantesFunciones.LABEL_SIGLAS, TipoTituloClienteConstantesFunciones.SIGLAS,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoTituloCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoTituloClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTituloClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTituloClienteConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTituloClienteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTituloClienteConstantesFunciones.SIGLAS;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTituloCliente() throws Exception  {
		return TipoTituloClienteConstantesFunciones.getTiposSeleccionarTipoTituloCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTituloCliente(Boolean conFk) throws Exception  {
		return TipoTituloClienteConstantesFunciones.getTiposSeleccionarTipoTituloCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTituloCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoTituloClienteConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(TipoTituloClienteConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoTituloClienteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoTituloClienteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoTituloClienteConstantesFunciones.LABEL_SIGLAS);
			reporte.setsDescripcion(TipoTituloClienteConstantesFunciones.LABEL_SIGLAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoTituloCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoTituloCliente(TipoTituloCliente tipotituloclienteAux) throws Exception {
		
			tipotituloclienteAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipotituloclienteAux.getPais()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoTituloCliente(List<TipoTituloCliente> tipotituloclientesTemp) throws Exception {
		for(TipoTituloCliente tipotituloclienteAux:tipotituloclientesTemp) {
			
			tipotituloclienteAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipotituloclienteAux.getPais()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoTituloCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Pais.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoTituloCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoTituloCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoTituloClienteConstantesFunciones.getClassesRelationshipsOfTipoTituloCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoTituloCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoTituloCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoTituloClienteConstantesFunciones.getClassesRelationshipsFromStringsOfTipoTituloCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoTituloCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoTituloCliente tipotitulocliente,List<TipoTituloCliente> tipotituloclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoTituloCliente tipotituloclienteEncontrado=null;
			
			for(TipoTituloCliente tipotituloclienteLocal:tipotituloclientes) {
				if(tipotituloclienteLocal.getId().equals(tipotitulocliente.getId())) {
					tipotituloclienteEncontrado=tipotituloclienteLocal;
					
					tipotituloclienteLocal.setIsChanged(tipotitulocliente.getIsChanged());
					tipotituloclienteLocal.setIsNew(tipotitulocliente.getIsNew());
					tipotituloclienteLocal.setIsDeleted(tipotitulocliente.getIsDeleted());
					
					tipotituloclienteLocal.setGeneralEntityOriginal(tipotitulocliente.getGeneralEntityOriginal());
					
					tipotituloclienteLocal.setId(tipotitulocliente.getId());	
					tipotituloclienteLocal.setVersionRow(tipotitulocliente.getVersionRow());	
					tipotituloclienteLocal.setid_pais(tipotitulocliente.getid_pais());	
					tipotituloclienteLocal.setnombre(tipotitulocliente.getnombre());	
					tipotituloclienteLocal.setsiglas(tipotitulocliente.getsiglas());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipotitulocliente.getIsDeleted()) {
				if(!existe) {
					tipotituloclientes.add(tipotitulocliente);
				}
			} else {
				if(tipotituloclienteEncontrado!=null && permiteQuitar)  {
					tipotituloclientes.remove(tipotituloclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoTituloCliente tipotitulocliente,List<TipoTituloCliente> tipotituloclientes) throws Exception {
		try	{			
			for(TipoTituloCliente tipotituloclienteLocal:tipotituloclientes) {
				if(tipotituloclienteLocal.getId().equals(tipotitulocliente.getId())) {
					tipotituloclienteLocal.setIsSelected(tipotitulocliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoTituloCliente(List<TipoTituloCliente> tipotituloclientesAux) throws Exception {
		//this.tipotituloclientesAux=tipotituloclientesAux;
		
		for(TipoTituloCliente tipotituloclienteAux:tipotituloclientesAux) {
			if(tipotituloclienteAux.getIsChanged()) {
				tipotituloclienteAux.setIsChanged(false);
			}		
			
			if(tipotituloclienteAux.getIsNew()) {
				tipotituloclienteAux.setIsNew(false);
			}	
			
			if(tipotituloclienteAux.getIsDeleted()) {
				tipotituloclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoTituloCliente(TipoTituloCliente tipotituloclienteAux) throws Exception {
		//this.tipotituloclienteAux=tipotituloclienteAux;
		
			if(tipotituloclienteAux.getIsChanged()) {
				tipotituloclienteAux.setIsChanged(false);
			}		
			
			if(tipotituloclienteAux.getIsNew()) {
				tipotituloclienteAux.setIsNew(false);
			}	
			
			if(tipotituloclienteAux.getIsDeleted()) {
				tipotituloclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoTituloCliente tipotituloclienteAsignar,TipoTituloCliente tipotitulocliente) throws Exception {
		tipotituloclienteAsignar.setId(tipotitulocliente.getId());	
		tipotituloclienteAsignar.setVersionRow(tipotitulocliente.getVersionRow());	
		tipotituloclienteAsignar.setid_pais(tipotitulocliente.getid_pais());
		tipotituloclienteAsignar.setpais_descripcion(tipotitulocliente.getpais_descripcion());	
		tipotituloclienteAsignar.setnombre(tipotitulocliente.getnombre());	
		tipotituloclienteAsignar.setsiglas(tipotitulocliente.getsiglas());	
	}
	
	public static void inicializarTipoTituloCliente(TipoTituloCliente tipotitulocliente) throws Exception {
		try {
				tipotitulocliente.setId(0L);	
					
				tipotitulocliente.setid_pais(-1L);	
				tipotitulocliente.setnombre("");	
				tipotitulocliente.setsiglas("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoTituloCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoTituloClienteConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoTituloClienteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoTituloClienteConstantesFunciones.LABEL_SIGLAS);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoTituloCliente(String sTipo,Row row,Workbook workbook,TipoTituloCliente tipotitulocliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipotitulocliente.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipotitulocliente.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipotitulocliente.getsiglas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoTituloCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoTituloCliente() {
		return this.sFinalQueryTipoTituloCliente;
	}
	
	public void setsFinalQueryTipoTituloCliente(String sFinalQueryTipoTituloCliente) {
		this.sFinalQueryTipoTituloCliente= sFinalQueryTipoTituloCliente;
	}
	
	public Border resaltarSeleccionarTipoTituloCliente=null;
	
	public Border setResaltarSeleccionarTipoTituloCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTituloClienteBeanSwingJInternalFrame tipotituloclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipotituloclienteBeanSwingJInternalFrame.jTtoolBarTipoTituloCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoTituloCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoTituloCliente() {
		return this.resaltarSeleccionarTipoTituloCliente;
	}
	
	public void setResaltarSeleccionarTipoTituloCliente(Border borderResaltarSeleccionarTipoTituloCliente) {
		this.resaltarSeleccionarTipoTituloCliente= borderResaltarSeleccionarTipoTituloCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoTituloCliente=null;
	public Boolean mostraridTipoTituloCliente=true;
	public Boolean activaridTipoTituloCliente=true;

	public Border resaltarid_paisTipoTituloCliente=null;
	public Boolean mostrarid_paisTipoTituloCliente=true;
	public Boolean activarid_paisTipoTituloCliente=true;
	public Boolean cargarid_paisTipoTituloCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisTipoTituloCliente=false;//ConEventDepend=true

	public Border resaltarnombreTipoTituloCliente=null;
	public Boolean mostrarnombreTipoTituloCliente=true;
	public Boolean activarnombreTipoTituloCliente=true;

	public Border resaltarsiglasTipoTituloCliente=null;
	public Boolean mostrarsiglasTipoTituloCliente=true;
	public Boolean activarsiglasTipoTituloCliente=true;

	
	

	public Border setResaltaridTipoTituloCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTituloClienteBeanSwingJInternalFrame tipotituloclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipotituloclienteBeanSwingJInternalFrame.jTtoolBarTipoTituloCliente.setBorder(borderResaltar);
		
		this.resaltaridTipoTituloCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoTituloCliente() {
		return this.resaltaridTipoTituloCliente;
	}

	public void setResaltaridTipoTituloCliente(Border borderResaltar) {
		this.resaltaridTipoTituloCliente= borderResaltar;
	}

	public Boolean getMostraridTipoTituloCliente() {
		return this.mostraridTipoTituloCliente;
	}

	public void setMostraridTipoTituloCliente(Boolean mostraridTipoTituloCliente) {
		this.mostraridTipoTituloCliente= mostraridTipoTituloCliente;
	}

	public Boolean getActivaridTipoTituloCliente() {
		return this.activaridTipoTituloCliente;
	}

	public void setActivaridTipoTituloCliente(Boolean activaridTipoTituloCliente) {
		this.activaridTipoTituloCliente= activaridTipoTituloCliente;
	}

	public Border setResaltarid_paisTipoTituloCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTituloClienteBeanSwingJInternalFrame tipotituloclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipotituloclienteBeanSwingJInternalFrame.jTtoolBarTipoTituloCliente.setBorder(borderResaltar);
		
		this.resaltarid_paisTipoTituloCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisTipoTituloCliente() {
		return this.resaltarid_paisTipoTituloCliente;
	}

	public void setResaltarid_paisTipoTituloCliente(Border borderResaltar) {
		this.resaltarid_paisTipoTituloCliente= borderResaltar;
	}

	public Boolean getMostrarid_paisTipoTituloCliente() {
		return this.mostrarid_paisTipoTituloCliente;
	}

	public void setMostrarid_paisTipoTituloCliente(Boolean mostrarid_paisTipoTituloCliente) {
		this.mostrarid_paisTipoTituloCliente= mostrarid_paisTipoTituloCliente;
	}

	public Boolean getActivarid_paisTipoTituloCliente() {
		return this.activarid_paisTipoTituloCliente;
	}

	public void setActivarid_paisTipoTituloCliente(Boolean activarid_paisTipoTituloCliente) {
		this.activarid_paisTipoTituloCliente= activarid_paisTipoTituloCliente;
	}

	public Boolean getCargarid_paisTipoTituloCliente() {
		return this.cargarid_paisTipoTituloCliente;
	}

	public void setCargarid_paisTipoTituloCliente(Boolean cargarid_paisTipoTituloCliente) {
		this.cargarid_paisTipoTituloCliente= cargarid_paisTipoTituloCliente;
	}

	public Border setResaltarnombreTipoTituloCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTituloClienteBeanSwingJInternalFrame tipotituloclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipotituloclienteBeanSwingJInternalFrame.jTtoolBarTipoTituloCliente.setBorder(borderResaltar);
		
		this.resaltarnombreTipoTituloCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoTituloCliente() {
		return this.resaltarnombreTipoTituloCliente;
	}

	public void setResaltarnombreTipoTituloCliente(Border borderResaltar) {
		this.resaltarnombreTipoTituloCliente= borderResaltar;
	}

	public Boolean getMostrarnombreTipoTituloCliente() {
		return this.mostrarnombreTipoTituloCliente;
	}

	public void setMostrarnombreTipoTituloCliente(Boolean mostrarnombreTipoTituloCliente) {
		this.mostrarnombreTipoTituloCliente= mostrarnombreTipoTituloCliente;
	}

	public Boolean getActivarnombreTipoTituloCliente() {
		return this.activarnombreTipoTituloCliente;
	}

	public void setActivarnombreTipoTituloCliente(Boolean activarnombreTipoTituloCliente) {
		this.activarnombreTipoTituloCliente= activarnombreTipoTituloCliente;
	}

	public Border setResaltarsiglasTipoTituloCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTituloClienteBeanSwingJInternalFrame tipotituloclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipotituloclienteBeanSwingJInternalFrame.jTtoolBarTipoTituloCliente.setBorder(borderResaltar);
		
		this.resaltarsiglasTipoTituloCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsiglasTipoTituloCliente() {
		return this.resaltarsiglasTipoTituloCliente;
	}

	public void setResaltarsiglasTipoTituloCliente(Border borderResaltar) {
		this.resaltarsiglasTipoTituloCliente= borderResaltar;
	}

	public Boolean getMostrarsiglasTipoTituloCliente() {
		return this.mostrarsiglasTipoTituloCliente;
	}

	public void setMostrarsiglasTipoTituloCliente(Boolean mostrarsiglasTipoTituloCliente) {
		this.mostrarsiglasTipoTituloCliente= mostrarsiglasTipoTituloCliente;
	}

	public Boolean getActivarsiglasTipoTituloCliente() {
		return this.activarsiglasTipoTituloCliente;
	}

	public void setActivarsiglasTipoTituloCliente(Boolean activarsiglasTipoTituloCliente) {
		this.activarsiglasTipoTituloCliente= activarsiglasTipoTituloCliente;
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
		
		
		this.setMostraridTipoTituloCliente(esInicial);
		this.setMostrarid_paisTipoTituloCliente(esInicial);
		this.setMostrarnombreTipoTituloCliente(esInicial);
		this.setMostrarsiglasTipoTituloCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTituloClienteConstantesFunciones.ID)) {
				this.setMostraridTipoTituloCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTituloClienteConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisTipoTituloCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTituloClienteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoTituloCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTituloClienteConstantesFunciones.SIGLAS)) {
				this.setMostrarsiglasTipoTituloCliente(esAsigna);
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
		
		
		this.setActivaridTipoTituloCliente(esInicial);
		this.setActivarid_paisTipoTituloCliente(esInicial);
		this.setActivarnombreTipoTituloCliente(esInicial);
		this.setActivarsiglasTipoTituloCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTituloClienteConstantesFunciones.ID)) {
				this.setActivaridTipoTituloCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTituloClienteConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisTipoTituloCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTituloClienteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoTituloCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTituloClienteConstantesFunciones.SIGLAS)) {
				this.setActivarsiglasTipoTituloCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoTituloClienteBeanSwingJInternalFrame tipotituloclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoTituloCliente(esInicial);
		this.setResaltarid_paisTipoTituloCliente(esInicial);
		this.setResaltarnombreTipoTituloCliente(esInicial);
		this.setResaltarsiglasTipoTituloCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTituloClienteConstantesFunciones.ID)) {
				this.setResaltaridTipoTituloCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTituloClienteConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisTipoTituloCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTituloClienteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoTituloCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTituloClienteConstantesFunciones.SIGLAS)) {
				this.setResaltarsiglasTipoTituloCliente(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoTituloClienteBeanSwingJInternalFrame tipotituloclienteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorIdTipoTituloCliente=true;

	public Boolean getMostrarBusquedaPorIdTipoTituloCliente() {
		return this.mostrarBusquedaPorIdTipoTituloCliente;
	}

	public void setMostrarBusquedaPorIdTipoTituloCliente(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdTipoTituloCliente= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoTituloCliente=true;

	public Boolean getMostrarBusquedaPorNombreTipoTituloCliente() {
		return this.mostrarBusquedaPorNombreTipoTituloCliente;
	}

	public void setMostrarBusquedaPorNombreTipoTituloCliente(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoTituloCliente= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorSiglasTipoTituloCliente=true;

	public Boolean getMostrarBusquedaPorSiglasTipoTituloCliente() {
		return this.mostrarBusquedaPorSiglasTipoTituloCliente;
	}

	public void setMostrarBusquedaPorSiglasTipoTituloCliente(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorSiglasTipoTituloCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisTipoTituloCliente=true;

	public Boolean getMostrarFK_IdPaisTipoTituloCliente() {
		return this.mostrarFK_IdPaisTipoTituloCliente;
	}

	public void setMostrarFK_IdPaisTipoTituloCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisTipoTituloCliente= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdTipoTituloCliente=true;

	public Boolean getActivarBusquedaPorIdTipoTituloCliente() {
		return this.activarBusquedaPorIdTipoTituloCliente;
	}

	public void setActivarBusquedaPorIdTipoTituloCliente(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdTipoTituloCliente= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoTituloCliente=true;

	public Boolean getActivarBusquedaPorNombreTipoTituloCliente() {
		return this.activarBusquedaPorNombreTipoTituloCliente;
	}

	public void setActivarBusquedaPorNombreTipoTituloCliente(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoTituloCliente= habilitarResaltar;
	}

	public Boolean activarBusquedaPorSiglasTipoTituloCliente=true;

	public Boolean getActivarBusquedaPorSiglasTipoTituloCliente() {
		return this.activarBusquedaPorSiglasTipoTituloCliente;
	}

	public void setActivarBusquedaPorSiglasTipoTituloCliente(Boolean habilitarResaltar) {
		this.activarBusquedaPorSiglasTipoTituloCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisTipoTituloCliente=true;

	public Boolean getActivarFK_IdPaisTipoTituloCliente() {
		return this.activarFK_IdPaisTipoTituloCliente;
	}

	public void setActivarFK_IdPaisTipoTituloCliente(Boolean habilitarResaltar) {
		this.activarFK_IdPaisTipoTituloCliente= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdTipoTituloCliente=null;

	public Border getResaltarBusquedaPorIdTipoTituloCliente() {
		return this.resaltarBusquedaPorIdTipoTituloCliente;
	}

	public void setResaltarBusquedaPorIdTipoTituloCliente(Border borderResaltar) {
		this.resaltarBusquedaPorIdTipoTituloCliente= borderResaltar;
	}

	public void setResaltarBusquedaPorIdTipoTituloCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTituloClienteBeanSwingJInternalFrame tipotituloclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdTipoTituloCliente= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoTituloCliente=null;

	public Border getResaltarBusquedaPorNombreTipoTituloCliente() {
		return this.resaltarBusquedaPorNombreTipoTituloCliente;
	}

	public void setResaltarBusquedaPorNombreTipoTituloCliente(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoTituloCliente= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoTituloCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTituloClienteBeanSwingJInternalFrame tipotituloclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoTituloCliente= borderResaltar;
	}

	public Border resaltarBusquedaPorSiglasTipoTituloCliente=null;

	public Border getResaltarBusquedaPorSiglasTipoTituloCliente() {
		return this.resaltarBusquedaPorSiglasTipoTituloCliente;
	}

	public void setResaltarBusquedaPorSiglasTipoTituloCliente(Border borderResaltar) {
		this.resaltarBusquedaPorSiglasTipoTituloCliente= borderResaltar;
	}

	public void setResaltarBusquedaPorSiglasTipoTituloCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTituloClienteBeanSwingJInternalFrame tipotituloclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorSiglasTipoTituloCliente= borderResaltar;
	}

	public Border resaltarFK_IdPaisTipoTituloCliente=null;

	public Border getResaltarFK_IdPaisTipoTituloCliente() {
		return this.resaltarFK_IdPaisTipoTituloCliente;
	}

	public void setResaltarFK_IdPaisTipoTituloCliente(Border borderResaltar) {
		this.resaltarFK_IdPaisTipoTituloCliente= borderResaltar;
	}

	public void setResaltarFK_IdPaisTipoTituloCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTituloClienteBeanSwingJInternalFrame tipotituloclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisTipoTituloCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}