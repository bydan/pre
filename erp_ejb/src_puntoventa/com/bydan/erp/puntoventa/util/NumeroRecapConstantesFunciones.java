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


import com.bydan.erp.puntoventa.util.NumeroRecapConstantesFunciones;
import com.bydan.erp.puntoventa.util.NumeroRecapParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.NumeroRecapParameterGeneral;

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
final public class NumeroRecapConstantesFunciones extends NumeroRecapConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="NumeroRecap";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="NumeroRecap"+NumeroRecapConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="NumeroRecapHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="NumeroRecapHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=NumeroRecapConstantesFunciones.SCHEMA+"_"+NumeroRecapConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/NumeroRecapHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=NumeroRecapConstantesFunciones.SCHEMA+"_"+NumeroRecapConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=NumeroRecapConstantesFunciones.SCHEMA+"_"+NumeroRecapConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/NumeroRecapHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=NumeroRecapConstantesFunciones.SCHEMA+"_"+NumeroRecapConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NumeroRecapConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NumeroRecapHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NumeroRecapConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NumeroRecapConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NumeroRecapHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NumeroRecapConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=NumeroRecapConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+NumeroRecapConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=NumeroRecapConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+NumeroRecapConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Numero Recapes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Numero Recap";
	public static final String SCLASSWEBTITULO_LOWER="Numero Recap";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="NumeroRecap";
	public static final String OBJECTNAME="numerorecap";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="numero_recap";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select numerorecap from "+NumeroRecapConstantesFunciones.SPERSISTENCENAME+" numerorecap";
	public static String QUERYSELECTNATIVE="select "+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME+".id,"+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME+".version_row,"+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME+".id_empresa,"+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME+".id_sucursal,"+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME+".id_conexion,"+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME+".numero_recap,"+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME+".fecha from "+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME;//+" as "+NumeroRecapConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected NumeroRecapConstantesFuncionesAdditional numerorecapConstantesFuncionesAdditional=null;
	
	public NumeroRecapConstantesFuncionesAdditional getNumeroRecapConstantesFuncionesAdditional() {
		return this.numerorecapConstantesFuncionesAdditional;
	}
	
	public void setNumeroRecapConstantesFuncionesAdditional(NumeroRecapConstantesFuncionesAdditional numerorecapConstantesFuncionesAdditional) {
		try {
			this.numerorecapConstantesFuncionesAdditional=numerorecapConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCONEXION= "id_conexion";
    public static final String NUMERORECAP= "numero_recap";
    public static final String FECHA= "fecha";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCONEXION= "Conexion";
		public static final String LABEL_IDCONEXION_LOWER= "Conexion";
    	public static final String LABEL_NUMERORECAP= "Numero Recap";
		public static final String LABEL_NUMERORECAP_LOWER= "Numero Recap";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
	
		
		
		
		
		
	public static final String SREGEXNUMERO_RECAP=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_RECAP=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getNumeroRecapLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(NumeroRecapConstantesFunciones.IDEMPRESA)) {sLabelColumna=NumeroRecapConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(NumeroRecapConstantesFunciones.IDSUCURSAL)) {sLabelColumna=NumeroRecapConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(NumeroRecapConstantesFunciones.IDCONEXION)) {sLabelColumna=NumeroRecapConstantesFunciones.LABEL_IDCONEXION;}
		if(sNombreColumna.equals(NumeroRecapConstantesFunciones.NUMERORECAP)) {sLabelColumna=NumeroRecapConstantesFunciones.LABEL_NUMERORECAP;}
		if(sNombreColumna.equals(NumeroRecapConstantesFunciones.FECHA)) {sLabelColumna=NumeroRecapConstantesFunciones.LABEL_FECHA;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getNumeroRecapDescripcion(NumeroRecap numerorecap) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(numerorecap !=null/* && numerorecap.getId()!=0*/) {
			if(numerorecap.getId()!=null) {
				sDescripcion=numerorecap.getId().toString();
			}//numerorecapnumerorecap.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getNumeroRecapDescripcionDetallado(NumeroRecap numerorecap) {
		String sDescripcion="";
			
		sDescripcion+=NumeroRecapConstantesFunciones.ID+"=";
		sDescripcion+=numerorecap.getId().toString()+",";
		sDescripcion+=NumeroRecapConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=numerorecap.getVersionRow().toString()+",";
		sDescripcion+=NumeroRecapConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=numerorecap.getid_empresa().toString()+",";
		sDescripcion+=NumeroRecapConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=numerorecap.getid_sucursal().toString()+",";
		sDescripcion+=NumeroRecapConstantesFunciones.IDCONEXION+"=";
		sDescripcion+=numerorecap.getid_conexion().toString()+",";
		sDescripcion+=NumeroRecapConstantesFunciones.NUMERORECAP+"=";
		sDescripcion+=numerorecap.getnumero_recap()+",";
		sDescripcion+=NumeroRecapConstantesFunciones.FECHA+"=";
		sDescripcion+=numerorecap.getfecha().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setNumeroRecapDescripcion(NumeroRecap numerorecap,String sValor) throws Exception {			
		if(numerorecap !=null) {
			//numerorecapnumerorecap.getId().toString();
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

	public static String getConexionDescripcion(Conexion conexion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(conexion!=null/*&&conexion.getId()>0*/) {
			sDescripcion=ConexionConstantesFunciones.getConexionDescripcion(conexion);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdConexion")) {
			sNombreIndice="Tipo=  Por Conexion";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdConexion(Long id_conexion) {
		String sDetalleIndice=" Parametros->";
		if(id_conexion!=null) {sDetalleIndice+=" Codigo Unico De Conexion="+id_conexion.toString();} 

		return sDetalleIndice;
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
	
	
	
	
	
	
	public static void quitarEspaciosNumeroRecap(NumeroRecap numerorecap,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		numerorecap.setnumero_recap(numerorecap.getnumero_recap().trim());
	}
	
	public static void quitarEspaciosNumeroRecaps(List<NumeroRecap> numerorecaps,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(NumeroRecap numerorecap: numerorecaps) {
			numerorecap.setnumero_recap(numerorecap.getnumero_recap().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNumeroRecap(NumeroRecap numerorecap,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && numerorecap.getConCambioAuxiliar()) {
			numerorecap.setIsDeleted(numerorecap.getIsDeletedAuxiliar());	
			numerorecap.setIsNew(numerorecap.getIsNewAuxiliar());	
			numerorecap.setIsChanged(numerorecap.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			numerorecap.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			numerorecap.setIsDeletedAuxiliar(false);	
			numerorecap.setIsNewAuxiliar(false);	
			numerorecap.setIsChangedAuxiliar(false);
			
			numerorecap.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNumeroRecaps(List<NumeroRecap> numerorecaps,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(NumeroRecap numerorecap : numerorecaps) {
			if(conAsignarBase && numerorecap.getConCambioAuxiliar()) {
				numerorecap.setIsDeleted(numerorecap.getIsDeletedAuxiliar());	
				numerorecap.setIsNew(numerorecap.getIsNewAuxiliar());	
				numerorecap.setIsChanged(numerorecap.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				numerorecap.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				numerorecap.setIsDeletedAuxiliar(false);	
				numerorecap.setIsNewAuxiliar(false);	
				numerorecap.setIsChangedAuxiliar(false);
				
				numerorecap.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresNumeroRecap(NumeroRecap numerorecap,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresNumeroRecaps(List<NumeroRecap> numerorecaps,Boolean conEnteros) throws Exception  {
		
		for(NumeroRecap numerorecap: numerorecaps) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaNumeroRecap(List<NumeroRecap> numerorecaps,NumeroRecap numerorecapAux) throws Exception  {
		NumeroRecapConstantesFunciones.InicializarValoresNumeroRecap(numerorecapAux,true);
		
		for(NumeroRecap numerorecap: numerorecaps) {
			if(numerorecap.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNumeroRecap(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=NumeroRecapConstantesFunciones.getArrayColumnasGlobalesNumeroRecap(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesNumeroRecap(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NumeroRecapConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NumeroRecapConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NumeroRecapConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NumeroRecapConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoNumeroRecap(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<NumeroRecap> numerorecaps,NumeroRecap numerorecap,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(NumeroRecap numerorecapAux: numerorecaps) {
			if(numerorecapAux!=null && numerorecap!=null) {
				if((numerorecapAux.getId()==null && numerorecap.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(numerorecapAux.getId()!=null && numerorecap.getId()!=null){
					if(numerorecapAux.getId().equals(numerorecap.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaNumeroRecap(List<NumeroRecap> numerorecaps) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(NumeroRecap numerorecap: numerorecaps) {			
			if(numerorecap.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaNumeroRecap() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,NumeroRecapConstantesFunciones.LABEL_ID, NumeroRecapConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NumeroRecapConstantesFunciones.LABEL_VERSIONROW, NumeroRecapConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NumeroRecapConstantesFunciones.LABEL_IDEMPRESA, NumeroRecapConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NumeroRecapConstantesFunciones.LABEL_IDSUCURSAL, NumeroRecapConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NumeroRecapConstantesFunciones.LABEL_IDCONEXION, NumeroRecapConstantesFunciones.IDCONEXION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NumeroRecapConstantesFunciones.LABEL_NUMERORECAP, NumeroRecapConstantesFunciones.NUMERORECAP,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NumeroRecapConstantesFunciones.LABEL_FECHA, NumeroRecapConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasNumeroRecap() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=NumeroRecapConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NumeroRecapConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NumeroRecapConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NumeroRecapConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NumeroRecapConstantesFunciones.IDCONEXION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NumeroRecapConstantesFunciones.NUMERORECAP;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NumeroRecapConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNumeroRecap() throws Exception  {
		return NumeroRecapConstantesFunciones.getTiposSeleccionarNumeroRecap(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNumeroRecap(Boolean conFk) throws Exception  {
		return NumeroRecapConstantesFunciones.getTiposSeleccionarNumeroRecap(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNumeroRecap(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NumeroRecapConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(NumeroRecapConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NumeroRecapConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(NumeroRecapConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NumeroRecapConstantesFunciones.LABEL_IDCONEXION);
			reporte.setsDescripcion(NumeroRecapConstantesFunciones.LABEL_IDCONEXION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NumeroRecapConstantesFunciones.LABEL_NUMERORECAP);
			reporte.setsDescripcion(NumeroRecapConstantesFunciones.LABEL_NUMERORECAP);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NumeroRecapConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(NumeroRecapConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesNumeroRecap(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesNumeroRecap(NumeroRecap numerorecapAux) throws Exception {
		
			numerorecapAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(numerorecapAux.getEmpresa()));
			numerorecapAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(numerorecapAux.getSucursal()));
			numerorecapAux.setconexion_descripcion(ConexionConstantesFunciones.getConexionDescripcion(numerorecapAux.getConexion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesNumeroRecap(List<NumeroRecap> numerorecapsTemp) throws Exception {
		for(NumeroRecap numerorecapAux:numerorecapsTemp) {
			
			numerorecapAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(numerorecapAux.getEmpresa()));
			numerorecapAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(numerorecapAux.getSucursal()));
			numerorecapAux.setconexion_descripcion(ConexionConstantesFunciones.getConexionDescripcion(numerorecapAux.getConexion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfNumeroRecap(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Conexion.class));
				
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
					if(clas.clas.equals(Conexion.class)) {
						classes.add(new Classe(Conexion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfNumeroRecap(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Conexion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Conexion.class)); continue;
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

					if(Conexion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Conexion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfNumeroRecap(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return NumeroRecapConstantesFunciones.getClassesRelationshipsOfNumeroRecap(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNumeroRecap(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNumeroRecap(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return NumeroRecapConstantesFunciones.getClassesRelationshipsFromStringsOfNumeroRecap(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNumeroRecap(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(NumeroRecap numerorecap,List<NumeroRecap> numerorecaps,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			NumeroRecap numerorecapEncontrado=null;
			
			for(NumeroRecap numerorecapLocal:numerorecaps) {
				if(numerorecapLocal.getId().equals(numerorecap.getId())) {
					numerorecapEncontrado=numerorecapLocal;
					
					numerorecapLocal.setIsChanged(numerorecap.getIsChanged());
					numerorecapLocal.setIsNew(numerorecap.getIsNew());
					numerorecapLocal.setIsDeleted(numerorecap.getIsDeleted());
					
					numerorecapLocal.setGeneralEntityOriginal(numerorecap.getGeneralEntityOriginal());
					
					numerorecapLocal.setId(numerorecap.getId());	
					numerorecapLocal.setVersionRow(numerorecap.getVersionRow());	
					numerorecapLocal.setid_empresa(numerorecap.getid_empresa());	
					numerorecapLocal.setid_sucursal(numerorecap.getid_sucursal());	
					numerorecapLocal.setid_conexion(numerorecap.getid_conexion());	
					numerorecapLocal.setnumero_recap(numerorecap.getnumero_recap());	
					numerorecapLocal.setfecha(numerorecap.getfecha());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!numerorecap.getIsDeleted()) {
				if(!existe) {
					numerorecaps.add(numerorecap);
				}
			} else {
				if(numerorecapEncontrado!=null && permiteQuitar)  {
					numerorecaps.remove(numerorecapEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(NumeroRecap numerorecap,List<NumeroRecap> numerorecaps) throws Exception {
		try	{			
			for(NumeroRecap numerorecapLocal:numerorecaps) {
				if(numerorecapLocal.getId().equals(numerorecap.getId())) {
					numerorecapLocal.setIsSelected(numerorecap.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesNumeroRecap(List<NumeroRecap> numerorecapsAux) throws Exception {
		//this.numerorecapsAux=numerorecapsAux;
		
		for(NumeroRecap numerorecapAux:numerorecapsAux) {
			if(numerorecapAux.getIsChanged()) {
				numerorecapAux.setIsChanged(false);
			}		
			
			if(numerorecapAux.getIsNew()) {
				numerorecapAux.setIsNew(false);
			}	
			
			if(numerorecapAux.getIsDeleted()) {
				numerorecapAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesNumeroRecap(NumeroRecap numerorecapAux) throws Exception {
		//this.numerorecapAux=numerorecapAux;
		
			if(numerorecapAux.getIsChanged()) {
				numerorecapAux.setIsChanged(false);
			}		
			
			if(numerorecapAux.getIsNew()) {
				numerorecapAux.setIsNew(false);
			}	
			
			if(numerorecapAux.getIsDeleted()) {
				numerorecapAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(NumeroRecap numerorecapAsignar,NumeroRecap numerorecap) throws Exception {
		numerorecapAsignar.setId(numerorecap.getId());	
		numerorecapAsignar.setVersionRow(numerorecap.getVersionRow());	
		numerorecapAsignar.setid_empresa(numerorecap.getid_empresa());
		numerorecapAsignar.setempresa_descripcion(numerorecap.getempresa_descripcion());	
		numerorecapAsignar.setid_sucursal(numerorecap.getid_sucursal());
		numerorecapAsignar.setsucursal_descripcion(numerorecap.getsucursal_descripcion());	
		numerorecapAsignar.setid_conexion(numerorecap.getid_conexion());
		numerorecapAsignar.setconexion_descripcion(numerorecap.getconexion_descripcion());	
		numerorecapAsignar.setnumero_recap(numerorecap.getnumero_recap());	
		numerorecapAsignar.setfecha(numerorecap.getfecha());	
	}
	
	public static void inicializarNumeroRecap(NumeroRecap numerorecap) throws Exception {
		try {
				numerorecap.setId(0L);	
					
				numerorecap.setid_empresa(-1L);	
				numerorecap.setid_sucursal(-1L);	
				numerorecap.setid_conexion(-1L);	
				numerorecap.setnumero_recap("");	
				numerorecap.setfecha(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderNumeroRecap(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(NumeroRecapConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NumeroRecapConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NumeroRecapConstantesFunciones.LABEL_IDCONEXION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NumeroRecapConstantesFunciones.LABEL_NUMERORECAP);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NumeroRecapConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataNumeroRecap(String sTipo,Row row,Workbook workbook,NumeroRecap numerorecap,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(numerorecap.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(numerorecap.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(numerorecap.getconexion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(numerorecap.getnumero_recap());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(numerorecap.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryNumeroRecap=Constantes.SFINALQUERY;
	
	public String getsFinalQueryNumeroRecap() {
		return this.sFinalQueryNumeroRecap;
	}
	
	public void setsFinalQueryNumeroRecap(String sFinalQueryNumeroRecap) {
		this.sFinalQueryNumeroRecap= sFinalQueryNumeroRecap;
	}
	
	public Border resaltarSeleccionarNumeroRecap=null;
	
	public Border setResaltarSeleccionarNumeroRecap(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroRecapBeanSwingJInternalFrame numerorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//numerorecapBeanSwingJInternalFrame.jTtoolBarNumeroRecap.setBorder(borderResaltar);
		
		this.resaltarSeleccionarNumeroRecap= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarNumeroRecap() {
		return this.resaltarSeleccionarNumeroRecap;
	}
	
	public void setResaltarSeleccionarNumeroRecap(Border borderResaltarSeleccionarNumeroRecap) {
		this.resaltarSeleccionarNumeroRecap= borderResaltarSeleccionarNumeroRecap;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridNumeroRecap=null;
	public Boolean mostraridNumeroRecap=true;
	public Boolean activaridNumeroRecap=true;

	public Border resaltarid_empresaNumeroRecap=null;
	public Boolean mostrarid_empresaNumeroRecap=true;
	public Boolean activarid_empresaNumeroRecap=true;
	public Boolean cargarid_empresaNumeroRecap=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaNumeroRecap=false;//ConEventDepend=true

	public Border resaltarid_sucursalNumeroRecap=null;
	public Boolean mostrarid_sucursalNumeroRecap=true;
	public Boolean activarid_sucursalNumeroRecap=true;
	public Boolean cargarid_sucursalNumeroRecap=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalNumeroRecap=false;//ConEventDepend=true

	public Border resaltarid_conexionNumeroRecap=null;
	public Boolean mostrarid_conexionNumeroRecap=true;
	public Boolean activarid_conexionNumeroRecap=true;
	public Boolean cargarid_conexionNumeroRecap=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_conexionNumeroRecap=false;//ConEventDepend=true

	public Border resaltarnumero_recapNumeroRecap=null;
	public Boolean mostrarnumero_recapNumeroRecap=true;
	public Boolean activarnumero_recapNumeroRecap=true;

	public Border resaltarfechaNumeroRecap=null;
	public Boolean mostrarfechaNumeroRecap=true;
	public Boolean activarfechaNumeroRecap=false;

	
	

	public Border setResaltaridNumeroRecap(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroRecapBeanSwingJInternalFrame numerorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//numerorecapBeanSwingJInternalFrame.jTtoolBarNumeroRecap.setBorder(borderResaltar);
		
		this.resaltaridNumeroRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridNumeroRecap() {
		return this.resaltaridNumeroRecap;
	}

	public void setResaltaridNumeroRecap(Border borderResaltar) {
		this.resaltaridNumeroRecap= borderResaltar;
	}

	public Boolean getMostraridNumeroRecap() {
		return this.mostraridNumeroRecap;
	}

	public void setMostraridNumeroRecap(Boolean mostraridNumeroRecap) {
		this.mostraridNumeroRecap= mostraridNumeroRecap;
	}

	public Boolean getActivaridNumeroRecap() {
		return this.activaridNumeroRecap;
	}

	public void setActivaridNumeroRecap(Boolean activaridNumeroRecap) {
		this.activaridNumeroRecap= activaridNumeroRecap;
	}

	public Border setResaltarid_empresaNumeroRecap(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroRecapBeanSwingJInternalFrame numerorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//numerorecapBeanSwingJInternalFrame.jTtoolBarNumeroRecap.setBorder(borderResaltar);
		
		this.resaltarid_empresaNumeroRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaNumeroRecap() {
		return this.resaltarid_empresaNumeroRecap;
	}

	public void setResaltarid_empresaNumeroRecap(Border borderResaltar) {
		this.resaltarid_empresaNumeroRecap= borderResaltar;
	}

	public Boolean getMostrarid_empresaNumeroRecap() {
		return this.mostrarid_empresaNumeroRecap;
	}

	public void setMostrarid_empresaNumeroRecap(Boolean mostrarid_empresaNumeroRecap) {
		this.mostrarid_empresaNumeroRecap= mostrarid_empresaNumeroRecap;
	}

	public Boolean getActivarid_empresaNumeroRecap() {
		return this.activarid_empresaNumeroRecap;
	}

	public void setActivarid_empresaNumeroRecap(Boolean activarid_empresaNumeroRecap) {
		this.activarid_empresaNumeroRecap= activarid_empresaNumeroRecap;
	}

	public Boolean getCargarid_empresaNumeroRecap() {
		return this.cargarid_empresaNumeroRecap;
	}

	public void setCargarid_empresaNumeroRecap(Boolean cargarid_empresaNumeroRecap) {
		this.cargarid_empresaNumeroRecap= cargarid_empresaNumeroRecap;
	}

	public Border setResaltarid_sucursalNumeroRecap(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroRecapBeanSwingJInternalFrame numerorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//numerorecapBeanSwingJInternalFrame.jTtoolBarNumeroRecap.setBorder(borderResaltar);
		
		this.resaltarid_sucursalNumeroRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalNumeroRecap() {
		return this.resaltarid_sucursalNumeroRecap;
	}

	public void setResaltarid_sucursalNumeroRecap(Border borderResaltar) {
		this.resaltarid_sucursalNumeroRecap= borderResaltar;
	}

	public Boolean getMostrarid_sucursalNumeroRecap() {
		return this.mostrarid_sucursalNumeroRecap;
	}

	public void setMostrarid_sucursalNumeroRecap(Boolean mostrarid_sucursalNumeroRecap) {
		this.mostrarid_sucursalNumeroRecap= mostrarid_sucursalNumeroRecap;
	}

	public Boolean getActivarid_sucursalNumeroRecap() {
		return this.activarid_sucursalNumeroRecap;
	}

	public void setActivarid_sucursalNumeroRecap(Boolean activarid_sucursalNumeroRecap) {
		this.activarid_sucursalNumeroRecap= activarid_sucursalNumeroRecap;
	}

	public Boolean getCargarid_sucursalNumeroRecap() {
		return this.cargarid_sucursalNumeroRecap;
	}

	public void setCargarid_sucursalNumeroRecap(Boolean cargarid_sucursalNumeroRecap) {
		this.cargarid_sucursalNumeroRecap= cargarid_sucursalNumeroRecap;
	}

	public Border setResaltarid_conexionNumeroRecap(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroRecapBeanSwingJInternalFrame numerorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//numerorecapBeanSwingJInternalFrame.jTtoolBarNumeroRecap.setBorder(borderResaltar);
		
		this.resaltarid_conexionNumeroRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_conexionNumeroRecap() {
		return this.resaltarid_conexionNumeroRecap;
	}

	public void setResaltarid_conexionNumeroRecap(Border borderResaltar) {
		this.resaltarid_conexionNumeroRecap= borderResaltar;
	}

	public Boolean getMostrarid_conexionNumeroRecap() {
		return this.mostrarid_conexionNumeroRecap;
	}

	public void setMostrarid_conexionNumeroRecap(Boolean mostrarid_conexionNumeroRecap) {
		this.mostrarid_conexionNumeroRecap= mostrarid_conexionNumeroRecap;
	}

	public Boolean getActivarid_conexionNumeroRecap() {
		return this.activarid_conexionNumeroRecap;
	}

	public void setActivarid_conexionNumeroRecap(Boolean activarid_conexionNumeroRecap) {
		this.activarid_conexionNumeroRecap= activarid_conexionNumeroRecap;
	}

	public Boolean getCargarid_conexionNumeroRecap() {
		return this.cargarid_conexionNumeroRecap;
	}

	public void setCargarid_conexionNumeroRecap(Boolean cargarid_conexionNumeroRecap) {
		this.cargarid_conexionNumeroRecap= cargarid_conexionNumeroRecap;
	}

	public Border setResaltarnumero_recapNumeroRecap(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroRecapBeanSwingJInternalFrame numerorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//numerorecapBeanSwingJInternalFrame.jTtoolBarNumeroRecap.setBorder(borderResaltar);
		
		this.resaltarnumero_recapNumeroRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_recapNumeroRecap() {
		return this.resaltarnumero_recapNumeroRecap;
	}

	public void setResaltarnumero_recapNumeroRecap(Border borderResaltar) {
		this.resaltarnumero_recapNumeroRecap= borderResaltar;
	}

	public Boolean getMostrarnumero_recapNumeroRecap() {
		return this.mostrarnumero_recapNumeroRecap;
	}

	public void setMostrarnumero_recapNumeroRecap(Boolean mostrarnumero_recapNumeroRecap) {
		this.mostrarnumero_recapNumeroRecap= mostrarnumero_recapNumeroRecap;
	}

	public Boolean getActivarnumero_recapNumeroRecap() {
		return this.activarnumero_recapNumeroRecap;
	}

	public void setActivarnumero_recapNumeroRecap(Boolean activarnumero_recapNumeroRecap) {
		this.activarnumero_recapNumeroRecap= activarnumero_recapNumeroRecap;
	}

	public Border setResaltarfechaNumeroRecap(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroRecapBeanSwingJInternalFrame numerorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//numerorecapBeanSwingJInternalFrame.jTtoolBarNumeroRecap.setBorder(borderResaltar);
		
		this.resaltarfechaNumeroRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaNumeroRecap() {
		return this.resaltarfechaNumeroRecap;
	}

	public void setResaltarfechaNumeroRecap(Border borderResaltar) {
		this.resaltarfechaNumeroRecap= borderResaltar;
	}

	public Boolean getMostrarfechaNumeroRecap() {
		return this.mostrarfechaNumeroRecap;
	}

	public void setMostrarfechaNumeroRecap(Boolean mostrarfechaNumeroRecap) {
		this.mostrarfechaNumeroRecap= mostrarfechaNumeroRecap;
	}

	public Boolean getActivarfechaNumeroRecap() {
		return this.activarfechaNumeroRecap;
	}

	public void setActivarfechaNumeroRecap(Boolean activarfechaNumeroRecap) {
		this.activarfechaNumeroRecap= activarfechaNumeroRecap;
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
		
		
		this.setMostraridNumeroRecap(esInicial);
		this.setMostrarid_empresaNumeroRecap(esInicial);
		this.setMostrarid_sucursalNumeroRecap(esInicial);
		this.setMostrarid_conexionNumeroRecap(esInicial);
		this.setMostrarnumero_recapNumeroRecap(esInicial);
		this.setMostrarfechaNumeroRecap(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NumeroRecapConstantesFunciones.ID)) {
				this.setMostraridNumeroRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroRecapConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaNumeroRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroRecapConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalNumeroRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroRecapConstantesFunciones.IDCONEXION)) {
				this.setMostrarid_conexionNumeroRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroRecapConstantesFunciones.NUMERORECAP)) {
				this.setMostrarnumero_recapNumeroRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroRecapConstantesFunciones.FECHA)) {
				this.setMostrarfechaNumeroRecap(esAsigna);
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
		
		
		this.setActivaridNumeroRecap(esInicial);
		this.setActivarid_empresaNumeroRecap(esInicial);
		this.setActivarid_sucursalNumeroRecap(esInicial);
		this.setActivarid_conexionNumeroRecap(esInicial);
		this.setActivarnumero_recapNumeroRecap(esInicial);
		this.setActivarfechaNumeroRecap(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NumeroRecapConstantesFunciones.ID)) {
				this.setActivaridNumeroRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroRecapConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaNumeroRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroRecapConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalNumeroRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroRecapConstantesFunciones.IDCONEXION)) {
				this.setActivarid_conexionNumeroRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroRecapConstantesFunciones.NUMERORECAP)) {
				this.setActivarnumero_recapNumeroRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroRecapConstantesFunciones.FECHA)) {
				this.setActivarfechaNumeroRecap(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,NumeroRecapBeanSwingJInternalFrame numerorecapBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridNumeroRecap(esInicial);
		this.setResaltarid_empresaNumeroRecap(esInicial);
		this.setResaltarid_sucursalNumeroRecap(esInicial);
		this.setResaltarid_conexionNumeroRecap(esInicial);
		this.setResaltarnumero_recapNumeroRecap(esInicial);
		this.setResaltarfechaNumeroRecap(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NumeroRecapConstantesFunciones.ID)) {
				this.setResaltaridNumeroRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroRecapConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaNumeroRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroRecapConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalNumeroRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroRecapConstantesFunciones.IDCONEXION)) {
				this.setResaltarid_conexionNumeroRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroRecapConstantesFunciones.NUMERORECAP)) {
				this.setResaltarnumero_recapNumeroRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroRecapConstantesFunciones.FECHA)) {
				this.setResaltarfechaNumeroRecap(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,NumeroRecapBeanSwingJInternalFrame numerorecapBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdConexionNumeroRecap=true;

	public Boolean getMostrarFK_IdConexionNumeroRecap() {
		return this.mostrarFK_IdConexionNumeroRecap;
	}

	public void setMostrarFK_IdConexionNumeroRecap(Boolean visibilidadResaltar) {
		this.mostrarFK_IdConexionNumeroRecap= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaNumeroRecap=true;

	public Boolean getMostrarFK_IdEmpresaNumeroRecap() {
		return this.mostrarFK_IdEmpresaNumeroRecap;
	}

	public void setMostrarFK_IdEmpresaNumeroRecap(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaNumeroRecap= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalNumeroRecap=true;

	public Boolean getMostrarFK_IdSucursalNumeroRecap() {
		return this.mostrarFK_IdSucursalNumeroRecap;
	}

	public void setMostrarFK_IdSucursalNumeroRecap(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalNumeroRecap= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdConexionNumeroRecap=true;

	public Boolean getActivarFK_IdConexionNumeroRecap() {
		return this.activarFK_IdConexionNumeroRecap;
	}

	public void setActivarFK_IdConexionNumeroRecap(Boolean habilitarResaltar) {
		this.activarFK_IdConexionNumeroRecap= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaNumeroRecap=true;

	public Boolean getActivarFK_IdEmpresaNumeroRecap() {
		return this.activarFK_IdEmpresaNumeroRecap;
	}

	public void setActivarFK_IdEmpresaNumeroRecap(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaNumeroRecap= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalNumeroRecap=true;

	public Boolean getActivarFK_IdSucursalNumeroRecap() {
		return this.activarFK_IdSucursalNumeroRecap;
	}

	public void setActivarFK_IdSucursalNumeroRecap(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalNumeroRecap= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdConexionNumeroRecap=null;

	public Border getResaltarFK_IdConexionNumeroRecap() {
		return this.resaltarFK_IdConexionNumeroRecap;
	}

	public void setResaltarFK_IdConexionNumeroRecap(Border borderResaltar) {
		this.resaltarFK_IdConexionNumeroRecap= borderResaltar;
	}

	public void setResaltarFK_IdConexionNumeroRecap(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroRecapBeanSwingJInternalFrame numerorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdConexionNumeroRecap= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaNumeroRecap=null;

	public Border getResaltarFK_IdEmpresaNumeroRecap() {
		return this.resaltarFK_IdEmpresaNumeroRecap;
	}

	public void setResaltarFK_IdEmpresaNumeroRecap(Border borderResaltar) {
		this.resaltarFK_IdEmpresaNumeroRecap= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaNumeroRecap(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroRecapBeanSwingJInternalFrame numerorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaNumeroRecap= borderResaltar;
	}

	public Border resaltarFK_IdSucursalNumeroRecap=null;

	public Border getResaltarFK_IdSucursalNumeroRecap() {
		return this.resaltarFK_IdSucursalNumeroRecap;
	}

	public void setResaltarFK_IdSucursalNumeroRecap(Border borderResaltar) {
		this.resaltarFK_IdSucursalNumeroRecap= borderResaltar;
	}

	public void setResaltarFK_IdSucursalNumeroRecap(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroRecapBeanSwingJInternalFrame numerorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalNumeroRecap= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}