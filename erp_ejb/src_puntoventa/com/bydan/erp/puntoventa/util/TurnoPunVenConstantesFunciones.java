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


import com.bydan.erp.puntoventa.util.TurnoPunVenConstantesFunciones;
import com.bydan.erp.puntoventa.util.TurnoPunVenParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.TurnoPunVenParameterGeneral;

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
final public class TurnoPunVenConstantesFunciones extends TurnoPunVenConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TurnoPunVen";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TurnoPunVen"+TurnoPunVenConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TurnoPunVenHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TurnoPunVenHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TurnoPunVenConstantesFunciones.SCHEMA+"_"+TurnoPunVenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TurnoPunVenHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TurnoPunVenConstantesFunciones.SCHEMA+"_"+TurnoPunVenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TurnoPunVenConstantesFunciones.SCHEMA+"_"+TurnoPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TurnoPunVenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TurnoPunVenConstantesFunciones.SCHEMA+"_"+TurnoPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TurnoPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TurnoPunVenHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TurnoPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TurnoPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TurnoPunVenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TurnoPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TurnoPunVenConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TurnoPunVenConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TurnoPunVenConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TurnoPunVenConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Turno Pun Venes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Turno Pun Ven";
	public static final String SCLASSWEBTITULO_LOWER="Turno Pun Ven";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TurnoPunVen";
	public static final String OBJECTNAME="turnopunven";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="turno_pun_ven";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select turnopunven from "+TurnoPunVenConstantesFunciones.SPERSISTENCENAME+" turnopunven";
	public static String QUERYSELECTNATIVE="select "+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+".id,"+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+".version_row,"+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+".id_empresa,"+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+".id_sucursal,"+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+".id_usuario,"+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+".nombre,"+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+".hora_inicio,"+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+".hora_fin from "+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME;//+" as "+TurnoPunVenConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TurnoPunVenConstantesFuncionesAdditional turnopunvenConstantesFuncionesAdditional=null;
	
	public TurnoPunVenConstantesFuncionesAdditional getTurnoPunVenConstantesFuncionesAdditional() {
		return this.turnopunvenConstantesFuncionesAdditional;
	}
	
	public void setTurnoPunVenConstantesFuncionesAdditional(TurnoPunVenConstantesFuncionesAdditional turnopunvenConstantesFuncionesAdditional) {
		try {
			this.turnopunvenConstantesFuncionesAdditional=turnopunvenConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDUSUARIO= "id_usuario";
    public static final String NOMBRE= "nombre";
    public static final String HORAINICIO= "hora_inicio";
    public static final String HORAFIN= "hora_fin";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_HORAINICIO= "Hora Inicio";
		public static final String LABEL_HORAINICIO_LOWER= "Hora Inicio";
    	public static final String LABEL_HORAFIN= "Hora Fin";
		public static final String LABEL_HORAFIN_LOWER= "Hora Fin";
	
		
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getTurnoPunVenLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TurnoPunVenConstantesFunciones.IDEMPRESA)) {sLabelColumna=TurnoPunVenConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TurnoPunVenConstantesFunciones.IDSUCURSAL)) {sLabelColumna=TurnoPunVenConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(TurnoPunVenConstantesFunciones.IDUSUARIO)) {sLabelColumna=TurnoPunVenConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(TurnoPunVenConstantesFunciones.NOMBRE)) {sLabelColumna=TurnoPunVenConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TurnoPunVenConstantesFunciones.HORAINICIO)) {sLabelColumna=TurnoPunVenConstantesFunciones.LABEL_HORAINICIO;}
		if(sNombreColumna.equals(TurnoPunVenConstantesFunciones.HORAFIN)) {sLabelColumna=TurnoPunVenConstantesFunciones.LABEL_HORAFIN;}
		
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
	
	
	
			
			
			
			
			
			
			
			
	
	public static String getTurnoPunVenDescripcion(TurnoPunVen turnopunven) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(turnopunven !=null/* && turnopunven.getId()!=0*/) {
			sDescripcion=turnopunven.getnombre();//turnopunventurnopunven.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTurnoPunVenDescripcionDetallado(TurnoPunVen turnopunven) {
		String sDescripcion="";
			
		sDescripcion+=TurnoPunVenConstantesFunciones.ID+"=";
		sDescripcion+=turnopunven.getId().toString()+",";
		sDescripcion+=TurnoPunVenConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=turnopunven.getVersionRow().toString()+",";
		sDescripcion+=TurnoPunVenConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=turnopunven.getid_empresa().toString()+",";
		sDescripcion+=TurnoPunVenConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=turnopunven.getid_sucursal().toString()+",";
		sDescripcion+=TurnoPunVenConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=turnopunven.getid_usuario().toString()+",";
		sDescripcion+=TurnoPunVenConstantesFunciones.NOMBRE+"=";
		sDescripcion+=turnopunven.getnombre()+",";
		sDescripcion+=TurnoPunVenConstantesFunciones.HORAINICIO+"=";
		sDescripcion+=turnopunven.gethora_inicio().toString()+",";
		sDescripcion+=TurnoPunVenConstantesFunciones.HORAFIN+"=";
		sDescripcion+=turnopunven.gethora_fin().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTurnoPunVenDescripcion(TurnoPunVen turnopunven,String sValor) throws Exception {			
		if(turnopunven !=null) {
			turnopunven.setnombre(sValor);;//turnopunventurnopunven.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
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
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
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

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTurnoPunVen(TurnoPunVen turnopunven,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		turnopunven.setnombre(turnopunven.getnombre().trim());
	}
	
	public static void quitarEspaciosTurnoPunVens(List<TurnoPunVen> turnopunvens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TurnoPunVen turnopunven: turnopunvens) {
			turnopunven.setnombre(turnopunven.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTurnoPunVen(TurnoPunVen turnopunven,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && turnopunven.getConCambioAuxiliar()) {
			turnopunven.setIsDeleted(turnopunven.getIsDeletedAuxiliar());	
			turnopunven.setIsNew(turnopunven.getIsNewAuxiliar());	
			turnopunven.setIsChanged(turnopunven.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			turnopunven.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			turnopunven.setIsDeletedAuxiliar(false);	
			turnopunven.setIsNewAuxiliar(false);	
			turnopunven.setIsChangedAuxiliar(false);
			
			turnopunven.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTurnoPunVens(List<TurnoPunVen> turnopunvens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TurnoPunVen turnopunven : turnopunvens) {
			if(conAsignarBase && turnopunven.getConCambioAuxiliar()) {
				turnopunven.setIsDeleted(turnopunven.getIsDeletedAuxiliar());	
				turnopunven.setIsNew(turnopunven.getIsNewAuxiliar());	
				turnopunven.setIsChanged(turnopunven.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				turnopunven.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				turnopunven.setIsDeletedAuxiliar(false);	
				turnopunven.setIsNewAuxiliar(false);	
				turnopunven.setIsChangedAuxiliar(false);
				
				turnopunven.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTurnoPunVen(TurnoPunVen turnopunven,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTurnoPunVens(List<TurnoPunVen> turnopunvens,Boolean conEnteros) throws Exception  {
		
		for(TurnoPunVen turnopunven: turnopunvens) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTurnoPunVen(List<TurnoPunVen> turnopunvens,TurnoPunVen turnopunvenAux) throws Exception  {
		TurnoPunVenConstantesFunciones.InicializarValoresTurnoPunVen(turnopunvenAux,true);
		
		for(TurnoPunVen turnopunven: turnopunvens) {
			if(turnopunven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTurnoPunVen(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TurnoPunVenConstantesFunciones.getArrayColumnasGlobalesTurnoPunVen(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTurnoPunVen(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TurnoPunVenConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TurnoPunVenConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TurnoPunVenConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TurnoPunVenConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TurnoPunVenConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TurnoPunVenConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTurnoPunVen(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TurnoPunVen> turnopunvens,TurnoPunVen turnopunven,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TurnoPunVen turnopunvenAux: turnopunvens) {
			if(turnopunvenAux!=null && turnopunven!=null) {
				if((turnopunvenAux.getId()==null && turnopunven.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(turnopunvenAux.getId()!=null && turnopunven.getId()!=null){
					if(turnopunvenAux.getId().equals(turnopunven.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTurnoPunVen(List<TurnoPunVen> turnopunvens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TurnoPunVen turnopunven: turnopunvens) {			
			if(turnopunven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTurnoPunVen() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TurnoPunVenConstantesFunciones.LABEL_ID, TurnoPunVenConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoPunVenConstantesFunciones.LABEL_VERSIONROW, TurnoPunVenConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoPunVenConstantesFunciones.LABEL_IDEMPRESA, TurnoPunVenConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoPunVenConstantesFunciones.LABEL_IDSUCURSAL, TurnoPunVenConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoPunVenConstantesFunciones.LABEL_IDUSUARIO, TurnoPunVenConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoPunVenConstantesFunciones.LABEL_NOMBRE, TurnoPunVenConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoPunVenConstantesFunciones.LABEL_HORAINICIO, TurnoPunVenConstantesFunciones.HORAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoPunVenConstantesFunciones.LABEL_HORAFIN, TurnoPunVenConstantesFunciones.HORAFIN,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTurnoPunVen() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TurnoPunVenConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoPunVenConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoPunVenConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoPunVenConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoPunVenConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoPunVenConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoPunVenConstantesFunciones.HORAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoPunVenConstantesFunciones.HORAFIN;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTurnoPunVen() throws Exception  {
		return TurnoPunVenConstantesFunciones.getTiposSeleccionarTurnoPunVen(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTurnoPunVen(Boolean conFk) throws Exception  {
		return TurnoPunVenConstantesFunciones.getTiposSeleccionarTurnoPunVen(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTurnoPunVen(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TurnoPunVenConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TurnoPunVenConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TurnoPunVenConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(TurnoPunVenConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TurnoPunVenConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(TurnoPunVenConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TurnoPunVenConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TurnoPunVenConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(TurnoPunVenConstantesFunciones.LABEL_HORAINICIO);
		reporte.setsDescripcion(TurnoPunVenConstantesFunciones.LABEL_HORAINICIO);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(TurnoPunVenConstantesFunciones.LABEL_HORAFIN);
		reporte.setsDescripcion(TurnoPunVenConstantesFunciones.LABEL_HORAFIN);

		arrTiposSeleccionarTodos.add(reporte);
		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTurnoPunVen(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTurnoPunVen(TurnoPunVen turnopunvenAux) throws Exception {
		
			turnopunvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(turnopunvenAux.getEmpresa()));
			turnopunvenAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(turnopunvenAux.getSucursal()));
			turnopunvenAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(turnopunvenAux.getUsuario()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTurnoPunVen(List<TurnoPunVen> turnopunvensTemp) throws Exception {
		for(TurnoPunVen turnopunvenAux:turnopunvensTemp) {
			
			turnopunvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(turnopunvenAux.getEmpresa()));
			turnopunvenAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(turnopunvenAux.getSucursal()));
			turnopunvenAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(turnopunvenAux.getUsuario()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTurnoPunVen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Usuario.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTurnoPunVen(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTurnoPunVen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TurnoPunVenConstantesFunciones.getClassesRelationshipsOfTurnoPunVen(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTurnoPunVen(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(CajaIngreso.class));
				classes.add(new Classe(CajeroTurno.class));
				classes.add(new Classe(CajaEgreso.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(CajaIngreso.class)) {
						classes.add(new Classe(CajaIngreso.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CajeroTurno.class)) {
						classes.add(new Classe(CajeroTurno.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CajaEgreso.class)) {
						classes.add(new Classe(CajaEgreso.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTurnoPunVen(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TurnoPunVenConstantesFunciones.getClassesRelationshipsFromStringsOfTurnoPunVen(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTurnoPunVen(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(CajaIngreso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajaIngreso.class)); continue;
					}

					if(CajeroTurno.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajeroTurno.class)); continue;
					}

					if(CajaEgreso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajaEgreso.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(CajaIngreso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajaIngreso.class)); continue;
					}

					if(CajeroTurno.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajeroTurno.class)); continue;
					}

					if(CajaEgreso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajaEgreso.class)); continue;
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
	public static void actualizarLista(TurnoPunVen turnopunven,List<TurnoPunVen> turnopunvens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TurnoPunVen turnopunvenEncontrado=null;
			
			for(TurnoPunVen turnopunvenLocal:turnopunvens) {
				if(turnopunvenLocal.getId().equals(turnopunven.getId())) {
					turnopunvenEncontrado=turnopunvenLocal;
					
					turnopunvenLocal.setIsChanged(turnopunven.getIsChanged());
					turnopunvenLocal.setIsNew(turnopunven.getIsNew());
					turnopunvenLocal.setIsDeleted(turnopunven.getIsDeleted());
					
					turnopunvenLocal.setGeneralEntityOriginal(turnopunven.getGeneralEntityOriginal());
					
					turnopunvenLocal.setId(turnopunven.getId());	
					turnopunvenLocal.setVersionRow(turnopunven.getVersionRow());	
					turnopunvenLocal.setid_empresa(turnopunven.getid_empresa());	
					turnopunvenLocal.setid_sucursal(turnopunven.getid_sucursal());	
					turnopunvenLocal.setid_usuario(turnopunven.getid_usuario());	
					turnopunvenLocal.setnombre(turnopunven.getnombre());	
					turnopunvenLocal.sethora_inicio(turnopunven.gethora_inicio());	
					turnopunvenLocal.sethora_fin(turnopunven.gethora_fin());	
					
					
					turnopunvenLocal.setCajaIngresos(turnopunven.getCajaIngresos());
					turnopunvenLocal.setCajeroTurnos(turnopunven.getCajeroTurnos());
					turnopunvenLocal.setCajaEgresos(turnopunven.getCajaEgresos());
					
					existe=true;
					break;
				}
			}
			
			if(!turnopunven.getIsDeleted()) {
				if(!existe) {
					turnopunvens.add(turnopunven);
				}
			} else {
				if(turnopunvenEncontrado!=null && permiteQuitar)  {
					turnopunvens.remove(turnopunvenEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TurnoPunVen turnopunven,List<TurnoPunVen> turnopunvens) throws Exception {
		try	{			
			for(TurnoPunVen turnopunvenLocal:turnopunvens) {
				if(turnopunvenLocal.getId().equals(turnopunven.getId())) {
					turnopunvenLocal.setIsSelected(turnopunven.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTurnoPunVen(List<TurnoPunVen> turnopunvensAux) throws Exception {
		//this.turnopunvensAux=turnopunvensAux;
		
		for(TurnoPunVen turnopunvenAux:turnopunvensAux) {
			if(turnopunvenAux.getIsChanged()) {
				turnopunvenAux.setIsChanged(false);
			}		
			
			if(turnopunvenAux.getIsNew()) {
				turnopunvenAux.setIsNew(false);
			}	
			
			if(turnopunvenAux.getIsDeleted()) {
				turnopunvenAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTurnoPunVen(TurnoPunVen turnopunvenAux) throws Exception {
		//this.turnopunvenAux=turnopunvenAux;
		
			if(turnopunvenAux.getIsChanged()) {
				turnopunvenAux.setIsChanged(false);
			}		
			
			if(turnopunvenAux.getIsNew()) {
				turnopunvenAux.setIsNew(false);
			}	
			
			if(turnopunvenAux.getIsDeleted()) {
				turnopunvenAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TurnoPunVen turnopunvenAsignar,TurnoPunVen turnopunven) throws Exception {
		turnopunvenAsignar.setId(turnopunven.getId());	
		turnopunvenAsignar.setVersionRow(turnopunven.getVersionRow());	
		turnopunvenAsignar.setid_empresa(turnopunven.getid_empresa());
		turnopunvenAsignar.setempresa_descripcion(turnopunven.getempresa_descripcion());	
		turnopunvenAsignar.setid_sucursal(turnopunven.getid_sucursal());
		turnopunvenAsignar.setsucursal_descripcion(turnopunven.getsucursal_descripcion());	
		turnopunvenAsignar.setid_usuario(turnopunven.getid_usuario());
		turnopunvenAsignar.setusuario_descripcion(turnopunven.getusuario_descripcion());	
		turnopunvenAsignar.setnombre(turnopunven.getnombre());	
		turnopunvenAsignar.sethora_inicio(turnopunven.gethora_inicio());	
		turnopunvenAsignar.sethora_fin(turnopunven.gethora_fin());	
	}
	
	public static void inicializarTurnoPunVen(TurnoPunVen turnopunven) throws Exception {
		try {
				turnopunven.setId(0L);	
					
				turnopunven.setid_empresa(-1L);	
				turnopunven.setid_sucursal(-1L);	
				turnopunven.setid_usuario(-1L);	
				turnopunven.setnombre("");	
				turnopunven.sethora_inicio(new Time((new Date()).getTime()));	
				turnopunven.sethora_fin(new Time((new Date()).getTime()));	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTurnoPunVen(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoPunVenConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoPunVenConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoPunVenConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoPunVenConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoPunVenConstantesFunciones.LABEL_HORAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoPunVenConstantesFunciones.LABEL_HORAFIN);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTurnoPunVen(String sTipo,Row row,Workbook workbook,TurnoPunVen turnopunven,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(turnopunven.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(turnopunven.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(turnopunven.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(turnopunven.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(turnopunven.gethora_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(turnopunven.gethora_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTurnoPunVen=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTurnoPunVen() {
		return this.sFinalQueryTurnoPunVen;
	}
	
	public void setsFinalQueryTurnoPunVen(String sFinalQueryTurnoPunVen) {
		this.sFinalQueryTurnoPunVen= sFinalQueryTurnoPunVen;
	}
	
	public Border resaltarSeleccionarTurnoPunVen=null;
	
	public Border setResaltarSeleccionarTurnoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoPunVenBeanSwingJInternalFrame turnopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//turnopunvenBeanSwingJInternalFrame.jTtoolBarTurnoPunVen.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTurnoPunVen= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTurnoPunVen() {
		return this.resaltarSeleccionarTurnoPunVen;
	}
	
	public void setResaltarSeleccionarTurnoPunVen(Border borderResaltarSeleccionarTurnoPunVen) {
		this.resaltarSeleccionarTurnoPunVen= borderResaltarSeleccionarTurnoPunVen;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTurnoPunVen=null;
	public Boolean mostraridTurnoPunVen=true;
	public Boolean activaridTurnoPunVen=true;

	public Border resaltarid_empresaTurnoPunVen=null;
	public Boolean mostrarid_empresaTurnoPunVen=true;
	public Boolean activarid_empresaTurnoPunVen=true;
	public Boolean cargarid_empresaTurnoPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTurnoPunVen=false;//ConEventDepend=true

	public Border resaltarid_sucursalTurnoPunVen=null;
	public Boolean mostrarid_sucursalTurnoPunVen=true;
	public Boolean activarid_sucursalTurnoPunVen=true;
	public Boolean cargarid_sucursalTurnoPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalTurnoPunVen=false;//ConEventDepend=true

	public Border resaltarid_usuarioTurnoPunVen=null;
	public Boolean mostrarid_usuarioTurnoPunVen=true;
	public Boolean activarid_usuarioTurnoPunVen=true;
	public Boolean cargarid_usuarioTurnoPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioTurnoPunVen=false;//ConEventDepend=true

	public Border resaltarnombreTurnoPunVen=null;
	public Boolean mostrarnombreTurnoPunVen=true;
	public Boolean activarnombreTurnoPunVen=true;

	public Border resaltarhora_inicioTurnoPunVen=null;
	public Boolean mostrarhora_inicioTurnoPunVen=true;
	public Boolean activarhora_inicioTurnoPunVen=true;

	public Border resaltarhora_finTurnoPunVen=null;
	public Boolean mostrarhora_finTurnoPunVen=true;
	public Boolean activarhora_finTurnoPunVen=true;

	
	

	public Border setResaltaridTurnoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoPunVenBeanSwingJInternalFrame turnopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnopunvenBeanSwingJInternalFrame.jTtoolBarTurnoPunVen.setBorder(borderResaltar);
		
		this.resaltaridTurnoPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTurnoPunVen() {
		return this.resaltaridTurnoPunVen;
	}

	public void setResaltaridTurnoPunVen(Border borderResaltar) {
		this.resaltaridTurnoPunVen= borderResaltar;
	}

	public Boolean getMostraridTurnoPunVen() {
		return this.mostraridTurnoPunVen;
	}

	public void setMostraridTurnoPunVen(Boolean mostraridTurnoPunVen) {
		this.mostraridTurnoPunVen= mostraridTurnoPunVen;
	}

	public Boolean getActivaridTurnoPunVen() {
		return this.activaridTurnoPunVen;
	}

	public void setActivaridTurnoPunVen(Boolean activaridTurnoPunVen) {
		this.activaridTurnoPunVen= activaridTurnoPunVen;
	}

	public Border setResaltarid_empresaTurnoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoPunVenBeanSwingJInternalFrame turnopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnopunvenBeanSwingJInternalFrame.jTtoolBarTurnoPunVen.setBorder(borderResaltar);
		
		this.resaltarid_empresaTurnoPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTurnoPunVen() {
		return this.resaltarid_empresaTurnoPunVen;
	}

	public void setResaltarid_empresaTurnoPunVen(Border borderResaltar) {
		this.resaltarid_empresaTurnoPunVen= borderResaltar;
	}

	public Boolean getMostrarid_empresaTurnoPunVen() {
		return this.mostrarid_empresaTurnoPunVen;
	}

	public void setMostrarid_empresaTurnoPunVen(Boolean mostrarid_empresaTurnoPunVen) {
		this.mostrarid_empresaTurnoPunVen= mostrarid_empresaTurnoPunVen;
	}

	public Boolean getActivarid_empresaTurnoPunVen() {
		return this.activarid_empresaTurnoPunVen;
	}

	public void setActivarid_empresaTurnoPunVen(Boolean activarid_empresaTurnoPunVen) {
		this.activarid_empresaTurnoPunVen= activarid_empresaTurnoPunVen;
	}

	public Boolean getCargarid_empresaTurnoPunVen() {
		return this.cargarid_empresaTurnoPunVen;
	}

	public void setCargarid_empresaTurnoPunVen(Boolean cargarid_empresaTurnoPunVen) {
		this.cargarid_empresaTurnoPunVen= cargarid_empresaTurnoPunVen;
	}

	public Border setResaltarid_sucursalTurnoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoPunVenBeanSwingJInternalFrame turnopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnopunvenBeanSwingJInternalFrame.jTtoolBarTurnoPunVen.setBorder(borderResaltar);
		
		this.resaltarid_sucursalTurnoPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalTurnoPunVen() {
		return this.resaltarid_sucursalTurnoPunVen;
	}

	public void setResaltarid_sucursalTurnoPunVen(Border borderResaltar) {
		this.resaltarid_sucursalTurnoPunVen= borderResaltar;
	}

	public Boolean getMostrarid_sucursalTurnoPunVen() {
		return this.mostrarid_sucursalTurnoPunVen;
	}

	public void setMostrarid_sucursalTurnoPunVen(Boolean mostrarid_sucursalTurnoPunVen) {
		this.mostrarid_sucursalTurnoPunVen= mostrarid_sucursalTurnoPunVen;
	}

	public Boolean getActivarid_sucursalTurnoPunVen() {
		return this.activarid_sucursalTurnoPunVen;
	}

	public void setActivarid_sucursalTurnoPunVen(Boolean activarid_sucursalTurnoPunVen) {
		this.activarid_sucursalTurnoPunVen= activarid_sucursalTurnoPunVen;
	}

	public Boolean getCargarid_sucursalTurnoPunVen() {
		return this.cargarid_sucursalTurnoPunVen;
	}

	public void setCargarid_sucursalTurnoPunVen(Boolean cargarid_sucursalTurnoPunVen) {
		this.cargarid_sucursalTurnoPunVen= cargarid_sucursalTurnoPunVen;
	}

	public Border setResaltarid_usuarioTurnoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoPunVenBeanSwingJInternalFrame turnopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnopunvenBeanSwingJInternalFrame.jTtoolBarTurnoPunVen.setBorder(borderResaltar);
		
		this.resaltarid_usuarioTurnoPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioTurnoPunVen() {
		return this.resaltarid_usuarioTurnoPunVen;
	}

	public void setResaltarid_usuarioTurnoPunVen(Border borderResaltar) {
		this.resaltarid_usuarioTurnoPunVen= borderResaltar;
	}

	public Boolean getMostrarid_usuarioTurnoPunVen() {
		return this.mostrarid_usuarioTurnoPunVen;
	}

	public void setMostrarid_usuarioTurnoPunVen(Boolean mostrarid_usuarioTurnoPunVen) {
		this.mostrarid_usuarioTurnoPunVen= mostrarid_usuarioTurnoPunVen;
	}

	public Boolean getActivarid_usuarioTurnoPunVen() {
		return this.activarid_usuarioTurnoPunVen;
	}

	public void setActivarid_usuarioTurnoPunVen(Boolean activarid_usuarioTurnoPunVen) {
		this.activarid_usuarioTurnoPunVen= activarid_usuarioTurnoPunVen;
	}

	public Boolean getCargarid_usuarioTurnoPunVen() {
		return this.cargarid_usuarioTurnoPunVen;
	}

	public void setCargarid_usuarioTurnoPunVen(Boolean cargarid_usuarioTurnoPunVen) {
		this.cargarid_usuarioTurnoPunVen= cargarid_usuarioTurnoPunVen;
	}

	public Border setResaltarnombreTurnoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoPunVenBeanSwingJInternalFrame turnopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnopunvenBeanSwingJInternalFrame.jTtoolBarTurnoPunVen.setBorder(borderResaltar);
		
		this.resaltarnombreTurnoPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTurnoPunVen() {
		return this.resaltarnombreTurnoPunVen;
	}

	public void setResaltarnombreTurnoPunVen(Border borderResaltar) {
		this.resaltarnombreTurnoPunVen= borderResaltar;
	}

	public Boolean getMostrarnombreTurnoPunVen() {
		return this.mostrarnombreTurnoPunVen;
	}

	public void setMostrarnombreTurnoPunVen(Boolean mostrarnombreTurnoPunVen) {
		this.mostrarnombreTurnoPunVen= mostrarnombreTurnoPunVen;
	}

	public Boolean getActivarnombreTurnoPunVen() {
		return this.activarnombreTurnoPunVen;
	}

	public void setActivarnombreTurnoPunVen(Boolean activarnombreTurnoPunVen) {
		this.activarnombreTurnoPunVen= activarnombreTurnoPunVen;
	}

	public Border setResaltarhora_inicioTurnoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoPunVenBeanSwingJInternalFrame turnopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnopunvenBeanSwingJInternalFrame.jTtoolBarTurnoPunVen.setBorder(borderResaltar);
		
		this.resaltarhora_inicioTurnoPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_inicioTurnoPunVen() {
		return this.resaltarhora_inicioTurnoPunVen;
	}

	public void setResaltarhora_inicioTurnoPunVen(Border borderResaltar) {
		this.resaltarhora_inicioTurnoPunVen= borderResaltar;
	}

	public Boolean getMostrarhora_inicioTurnoPunVen() {
		return this.mostrarhora_inicioTurnoPunVen;
	}

	public void setMostrarhora_inicioTurnoPunVen(Boolean mostrarhora_inicioTurnoPunVen) {
		this.mostrarhora_inicioTurnoPunVen= mostrarhora_inicioTurnoPunVen;
	}

	public Boolean getActivarhora_inicioTurnoPunVen() {
		return this.activarhora_inicioTurnoPunVen;
	}

	public void setActivarhora_inicioTurnoPunVen(Boolean activarhora_inicioTurnoPunVen) {
		this.activarhora_inicioTurnoPunVen= activarhora_inicioTurnoPunVen;
	}

	public Border setResaltarhora_finTurnoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoPunVenBeanSwingJInternalFrame turnopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnopunvenBeanSwingJInternalFrame.jTtoolBarTurnoPunVen.setBorder(borderResaltar);
		
		this.resaltarhora_finTurnoPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_finTurnoPunVen() {
		return this.resaltarhora_finTurnoPunVen;
	}

	public void setResaltarhora_finTurnoPunVen(Border borderResaltar) {
		this.resaltarhora_finTurnoPunVen= borderResaltar;
	}

	public Boolean getMostrarhora_finTurnoPunVen() {
		return this.mostrarhora_finTurnoPunVen;
	}

	public void setMostrarhora_finTurnoPunVen(Boolean mostrarhora_finTurnoPunVen) {
		this.mostrarhora_finTurnoPunVen= mostrarhora_finTurnoPunVen;
	}

	public Boolean getActivarhora_finTurnoPunVen() {
		return this.activarhora_finTurnoPunVen;
	}

	public void setActivarhora_finTurnoPunVen(Boolean activarhora_finTurnoPunVen) {
		this.activarhora_finTurnoPunVen= activarhora_finTurnoPunVen;
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
		
		
		this.setMostraridTurnoPunVen(esInicial);
		this.setMostrarid_empresaTurnoPunVen(esInicial);
		this.setMostrarid_sucursalTurnoPunVen(esInicial);
		this.setMostrarid_usuarioTurnoPunVen(esInicial);
		this.setMostrarnombreTurnoPunVen(esInicial);
		this.setMostrarhora_inicioTurnoPunVen(esInicial);
		this.setMostrarhora_finTurnoPunVen(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TurnoPunVenConstantesFunciones.ID)) {
				this.setMostraridTurnoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoPunVenConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTurnoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoPunVenConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalTurnoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoPunVenConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioTurnoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoPunVenConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTurnoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoPunVenConstantesFunciones.HORAINICIO)) {
				this.setMostrarhora_inicioTurnoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoPunVenConstantesFunciones.HORAFIN)) {
				this.setMostrarhora_finTurnoPunVen(esAsigna);
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
		
		
		this.setActivaridTurnoPunVen(esInicial);
		this.setActivarid_empresaTurnoPunVen(esInicial);
		this.setActivarid_sucursalTurnoPunVen(esInicial);
		this.setActivarid_usuarioTurnoPunVen(esInicial);
		this.setActivarnombreTurnoPunVen(esInicial);
		this.setActivarhora_inicioTurnoPunVen(esInicial);
		this.setActivarhora_finTurnoPunVen(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TurnoPunVenConstantesFunciones.ID)) {
				this.setActivaridTurnoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoPunVenConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTurnoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoPunVenConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalTurnoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoPunVenConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioTurnoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoPunVenConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTurnoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoPunVenConstantesFunciones.HORAINICIO)) {
				this.setActivarhora_inicioTurnoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoPunVenConstantesFunciones.HORAFIN)) {
				this.setActivarhora_finTurnoPunVen(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TurnoPunVenBeanSwingJInternalFrame turnopunvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTurnoPunVen(esInicial);
		this.setResaltarid_empresaTurnoPunVen(esInicial);
		this.setResaltarid_sucursalTurnoPunVen(esInicial);
		this.setResaltarid_usuarioTurnoPunVen(esInicial);
		this.setResaltarnombreTurnoPunVen(esInicial);
		this.setResaltarhora_inicioTurnoPunVen(esInicial);
		this.setResaltarhora_finTurnoPunVen(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TurnoPunVenConstantesFunciones.ID)) {
				this.setResaltaridTurnoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoPunVenConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTurnoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoPunVenConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalTurnoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoPunVenConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioTurnoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoPunVenConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTurnoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoPunVenConstantesFunciones.HORAINICIO)) {
				this.setResaltarhora_inicioTurnoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoPunVenConstantesFunciones.HORAFIN)) {
				this.setResaltarhora_finTurnoPunVen(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarCajaIngresoTurnoPunVen=null;

	public Border getResaltarCajaIngresoTurnoPunVen() {
		return this.resaltarCajaIngresoTurnoPunVen;
	}

	public void setResaltarCajaIngresoTurnoPunVen(Border borderResaltarCajaIngreso) {
		if(borderResaltarCajaIngreso!=null) {
			this.resaltarCajaIngresoTurnoPunVen= borderResaltarCajaIngreso;
		}
	}

	public Border setResaltarCajaIngresoTurnoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoPunVenBeanSwingJInternalFrame turnopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltarCajaIngreso=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//turnopunvenBeanSwingJInternalFrame.jTtoolBarTurnoPunVen.setBorder(borderResaltarCajaIngreso);
			
		this.resaltarCajaIngresoTurnoPunVen= borderResaltarCajaIngreso;

		 return borderResaltarCajaIngreso;
	}



	public Boolean mostrarCajaIngresoTurnoPunVen=true;

	public Boolean getMostrarCajaIngresoTurnoPunVen() {
		return this.mostrarCajaIngresoTurnoPunVen;
	}

	public void setMostrarCajaIngresoTurnoPunVen(Boolean visibilidadResaltarCajaIngreso) {
		this.mostrarCajaIngresoTurnoPunVen= visibilidadResaltarCajaIngreso;
	}



	public Boolean activarCajaIngresoTurnoPunVen=true;

	public Boolean gethabilitarResaltarCajaIngresoTurnoPunVen() {
		return this.activarCajaIngresoTurnoPunVen;
	}

	public void setActivarCajaIngresoTurnoPunVen(Boolean habilitarResaltarCajaIngreso) {
		this.activarCajaIngresoTurnoPunVen= habilitarResaltarCajaIngreso;
	}


	public Border resaltarCajeroTurnoTurnoPunVen=null;

	public Border getResaltarCajeroTurnoTurnoPunVen() {
		return this.resaltarCajeroTurnoTurnoPunVen;
	}

	public void setResaltarCajeroTurnoTurnoPunVen(Border borderResaltarCajeroTurno) {
		if(borderResaltarCajeroTurno!=null) {
			this.resaltarCajeroTurnoTurnoPunVen= borderResaltarCajeroTurno;
		}
	}

	public Border setResaltarCajeroTurnoTurnoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoPunVenBeanSwingJInternalFrame turnopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltarCajeroTurno=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//turnopunvenBeanSwingJInternalFrame.jTtoolBarTurnoPunVen.setBorder(borderResaltarCajeroTurno);
			
		this.resaltarCajeroTurnoTurnoPunVen= borderResaltarCajeroTurno;

		 return borderResaltarCajeroTurno;
	}



	public Boolean mostrarCajeroTurnoTurnoPunVen=true;

	public Boolean getMostrarCajeroTurnoTurnoPunVen() {
		return this.mostrarCajeroTurnoTurnoPunVen;
	}

	public void setMostrarCajeroTurnoTurnoPunVen(Boolean visibilidadResaltarCajeroTurno) {
		this.mostrarCajeroTurnoTurnoPunVen= visibilidadResaltarCajeroTurno;
	}



	public Boolean activarCajeroTurnoTurnoPunVen=true;

	public Boolean gethabilitarResaltarCajeroTurnoTurnoPunVen() {
		return this.activarCajeroTurnoTurnoPunVen;
	}

	public void setActivarCajeroTurnoTurnoPunVen(Boolean habilitarResaltarCajeroTurno) {
		this.activarCajeroTurnoTurnoPunVen= habilitarResaltarCajeroTurno;
	}


	public Border resaltarCajaEgresoTurnoPunVen=null;

	public Border getResaltarCajaEgresoTurnoPunVen() {
		return this.resaltarCajaEgresoTurnoPunVen;
	}

	public void setResaltarCajaEgresoTurnoPunVen(Border borderResaltarCajaEgreso) {
		if(borderResaltarCajaEgreso!=null) {
			this.resaltarCajaEgresoTurnoPunVen= borderResaltarCajaEgreso;
		}
	}

	public Border setResaltarCajaEgresoTurnoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoPunVenBeanSwingJInternalFrame turnopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltarCajaEgreso=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//turnopunvenBeanSwingJInternalFrame.jTtoolBarTurnoPunVen.setBorder(borderResaltarCajaEgreso);
			
		this.resaltarCajaEgresoTurnoPunVen= borderResaltarCajaEgreso;

		 return borderResaltarCajaEgreso;
	}



	public Boolean mostrarCajaEgresoTurnoPunVen=true;

	public Boolean getMostrarCajaEgresoTurnoPunVen() {
		return this.mostrarCajaEgresoTurnoPunVen;
	}

	public void setMostrarCajaEgresoTurnoPunVen(Boolean visibilidadResaltarCajaEgreso) {
		this.mostrarCajaEgresoTurnoPunVen= visibilidadResaltarCajaEgreso;
	}



	public Boolean activarCajaEgresoTurnoPunVen=true;

	public Boolean gethabilitarResaltarCajaEgresoTurnoPunVen() {
		return this.activarCajaEgresoTurnoPunVen;
	}

	public void setActivarCajaEgresoTurnoPunVen(Boolean habilitarResaltarCajaEgreso) {
		this.activarCajaEgresoTurnoPunVen= habilitarResaltarCajaEgreso;
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

		this.setMostrarCajaIngresoTurnoPunVen(esInicial);
		this.setMostrarCajeroTurnoTurnoPunVen(esInicial);
		this.setMostrarCajaEgresoTurnoPunVen(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CajaIngreso.class)) {
				this.setMostrarCajaIngresoTurnoPunVen(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajeroTurno.class)) {
				this.setMostrarCajeroTurnoTurnoPunVen(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajaEgreso.class)) {
				this.setMostrarCajaEgresoTurnoPunVen(esAsigna);
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

		this.setActivarCajaIngresoTurnoPunVen(esInicial);
		this.setActivarCajeroTurnoTurnoPunVen(esInicial);
		this.setActivarCajaEgresoTurnoPunVen(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CajaIngreso.class)) {
				this.setActivarCajaIngresoTurnoPunVen(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajeroTurno.class)) {
				this.setActivarCajeroTurnoTurnoPunVen(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajaEgreso.class)) {
				this.setActivarCajaEgresoTurnoPunVen(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TurnoPunVenBeanSwingJInternalFrame turnopunvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarCajaIngresoTurnoPunVen(esInicial);
		this.setResaltarCajeroTurnoTurnoPunVen(esInicial);
		this.setResaltarCajaEgresoTurnoPunVen(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CajaIngreso.class)) {
				this.setResaltarCajaIngresoTurnoPunVen(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajeroTurno.class)) {
				this.setResaltarCajeroTurnoTurnoPunVen(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajaEgreso.class)) {
				this.setResaltarCajaEgresoTurnoPunVen(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTurnoPunVen=true;

	public Boolean getMostrarFK_IdEmpresaTurnoPunVen() {
		return this.mostrarFK_IdEmpresaTurnoPunVen;
	}

	public void setMostrarFK_IdEmpresaTurnoPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTurnoPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalTurnoPunVen=true;

	public Boolean getMostrarFK_IdSucursalTurnoPunVen() {
		return this.mostrarFK_IdSucursalTurnoPunVen;
	}

	public void setMostrarFK_IdSucursalTurnoPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalTurnoPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioTurnoPunVen=true;

	public Boolean getMostrarFK_IdUsuarioTurnoPunVen() {
		return this.mostrarFK_IdUsuarioTurnoPunVen;
	}

	public void setMostrarFK_IdUsuarioTurnoPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioTurnoPunVen= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTurnoPunVen=true;

	public Boolean getActivarFK_IdEmpresaTurnoPunVen() {
		return this.activarFK_IdEmpresaTurnoPunVen;
	}

	public void setActivarFK_IdEmpresaTurnoPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTurnoPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalTurnoPunVen=true;

	public Boolean getActivarFK_IdSucursalTurnoPunVen() {
		return this.activarFK_IdSucursalTurnoPunVen;
	}

	public void setActivarFK_IdSucursalTurnoPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalTurnoPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioTurnoPunVen=true;

	public Boolean getActivarFK_IdUsuarioTurnoPunVen() {
		return this.activarFK_IdUsuarioTurnoPunVen;
	}

	public void setActivarFK_IdUsuarioTurnoPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioTurnoPunVen= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTurnoPunVen=null;

	public Border getResaltarFK_IdEmpresaTurnoPunVen() {
		return this.resaltarFK_IdEmpresaTurnoPunVen;
	}

	public void setResaltarFK_IdEmpresaTurnoPunVen(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTurnoPunVen= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTurnoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoPunVenBeanSwingJInternalFrame turnopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTurnoPunVen= borderResaltar;
	}

	public Border resaltarFK_IdSucursalTurnoPunVen=null;

	public Border getResaltarFK_IdSucursalTurnoPunVen() {
		return this.resaltarFK_IdSucursalTurnoPunVen;
	}

	public void setResaltarFK_IdSucursalTurnoPunVen(Border borderResaltar) {
		this.resaltarFK_IdSucursalTurnoPunVen= borderResaltar;
	}

	public void setResaltarFK_IdSucursalTurnoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoPunVenBeanSwingJInternalFrame turnopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalTurnoPunVen= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioTurnoPunVen=null;

	public Border getResaltarFK_IdUsuarioTurnoPunVen() {
		return this.resaltarFK_IdUsuarioTurnoPunVen;
	}

	public void setResaltarFK_IdUsuarioTurnoPunVen(Border borderResaltar) {
		this.resaltarFK_IdUsuarioTurnoPunVen= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioTurnoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoPunVenBeanSwingJInternalFrame turnopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioTurnoPunVen= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}