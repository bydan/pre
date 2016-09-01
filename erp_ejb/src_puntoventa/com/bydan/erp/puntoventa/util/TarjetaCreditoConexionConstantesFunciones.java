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


import com.bydan.erp.puntoventa.util.TarjetaCreditoConexionConstantesFunciones;
import com.bydan.erp.puntoventa.util.TarjetaCreditoConexionParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.TarjetaCreditoConexionParameterGeneral;

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
final public class TarjetaCreditoConexionConstantesFunciones extends TarjetaCreditoConexionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TarjetaCreditoConexion";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TarjetaCreditoConexion"+TarjetaCreditoConexionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TarjetaCreditoConexionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TarjetaCreditoConexionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TarjetaCreditoConexionConstantesFunciones.SCHEMA+"_"+TarjetaCreditoConexionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TarjetaCreditoConexionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TarjetaCreditoConexionConstantesFunciones.SCHEMA+"_"+TarjetaCreditoConexionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TarjetaCreditoConexionConstantesFunciones.SCHEMA+"_"+TarjetaCreditoConexionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TarjetaCreditoConexionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TarjetaCreditoConexionConstantesFunciones.SCHEMA+"_"+TarjetaCreditoConexionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TarjetaCreditoConexionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TarjetaCreditoConexionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TarjetaCreditoConexionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TarjetaCreditoConexionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TarjetaCreditoConexionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TarjetaCreditoConexionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TarjetaCreditoConexionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TarjetaCreditoConexionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TarjetaCreditoConexionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TarjetaCreditoConexionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tarjeta Credito Conexiones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tarjeta Credito Conexion";
	public static final String SCLASSWEBTITULO_LOWER="Tarjeta Credito Conexion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TarjetaCreditoConexion";
	public static final String OBJECTNAME="tarjetacreditoconexion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="tarjeta_credito_conexion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tarjetacreditoconexion from "+TarjetaCreditoConexionConstantesFunciones.SPERSISTENCENAME+" tarjetacreditoconexion";
	public static String QUERYSELECTNATIVE="select "+TarjetaCreditoConexionConstantesFunciones.SCHEMA+"."+TarjetaCreditoConexionConstantesFunciones.TABLENAME+".id,"+TarjetaCreditoConexionConstantesFunciones.SCHEMA+"."+TarjetaCreditoConexionConstantesFunciones.TABLENAME+".version_row,"+TarjetaCreditoConexionConstantesFunciones.SCHEMA+"."+TarjetaCreditoConexionConstantesFunciones.TABLENAME+".id_empresa,"+TarjetaCreditoConexionConstantesFunciones.SCHEMA+"."+TarjetaCreditoConexionConstantesFunciones.TABLENAME+".id_sucursal,"+TarjetaCreditoConexionConstantesFunciones.SCHEMA+"."+TarjetaCreditoConexionConstantesFunciones.TABLENAME+".id_tarjeta_credito,"+TarjetaCreditoConexionConstantesFunciones.SCHEMA+"."+TarjetaCreditoConexionConstantesFunciones.TABLENAME+".id_conexion from "+TarjetaCreditoConexionConstantesFunciones.SCHEMA+"."+TarjetaCreditoConexionConstantesFunciones.TABLENAME;//+" as "+TarjetaCreditoConexionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TarjetaCreditoConexionConstantesFuncionesAdditional tarjetacreditoconexionConstantesFuncionesAdditional=null;
	
	public TarjetaCreditoConexionConstantesFuncionesAdditional getTarjetaCreditoConexionConstantesFuncionesAdditional() {
		return this.tarjetacreditoconexionConstantesFuncionesAdditional;
	}
	
	public void setTarjetaCreditoConexionConstantesFuncionesAdditional(TarjetaCreditoConexionConstantesFuncionesAdditional tarjetacreditoconexionConstantesFuncionesAdditional) {
		try {
			this.tarjetacreditoconexionConstantesFuncionesAdditional=tarjetacreditoconexionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDTARJETACREDITO= "id_tarjeta_credito";
    public static final String IDCONEXION= "id_conexion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDTARJETACREDITO= "Tarjeta Credito";
		public static final String LABEL_IDTARJETACREDITO_LOWER= "Tarjeta Credito";
    	public static final String LABEL_IDCONEXION= "Conexion";
		public static final String LABEL_IDCONEXION_LOWER= "Conexion";
	
		
		
		
		
		
		
	
	public static String getTarjetaCreditoConexionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TarjetaCreditoConexionConstantesFunciones.IDEMPRESA)) {sLabelColumna=TarjetaCreditoConexionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TarjetaCreditoConexionConstantesFunciones.IDSUCURSAL)) {sLabelColumna=TarjetaCreditoConexionConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(TarjetaCreditoConexionConstantesFunciones.IDTARJETACREDITO)) {sLabelColumna=TarjetaCreditoConexionConstantesFunciones.LABEL_IDTARJETACREDITO;}
		if(sNombreColumna.equals(TarjetaCreditoConexionConstantesFunciones.IDCONEXION)) {sLabelColumna=TarjetaCreditoConexionConstantesFunciones.LABEL_IDCONEXION;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getTarjetaCreditoConexionDescripcion(TarjetaCreditoConexion tarjetacreditoconexion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tarjetacreditoconexion !=null/* && tarjetacreditoconexion.getId()!=0*/) {
			if(tarjetacreditoconexion.getId()!=null) {
				sDescripcion=tarjetacreditoconexion.getId().toString();
			}//tarjetacreditoconexiontarjetacreditoconexion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTarjetaCreditoConexionDescripcionDetallado(TarjetaCreditoConexion tarjetacreditoconexion) {
		String sDescripcion="";
			
		sDescripcion+=TarjetaCreditoConexionConstantesFunciones.ID+"=";
		sDescripcion+=tarjetacreditoconexion.getId().toString()+",";
		sDescripcion+=TarjetaCreditoConexionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tarjetacreditoconexion.getVersionRow().toString()+",";
		sDescripcion+=TarjetaCreditoConexionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tarjetacreditoconexion.getid_empresa().toString()+",";
		sDescripcion+=TarjetaCreditoConexionConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=tarjetacreditoconexion.getid_sucursal().toString()+",";
		sDescripcion+=TarjetaCreditoConexionConstantesFunciones.IDTARJETACREDITO+"=";
		sDescripcion+=tarjetacreditoconexion.getid_tarjeta_credito().toString()+",";
		sDescripcion+=TarjetaCreditoConexionConstantesFunciones.IDCONEXION+"=";
		sDescripcion+=tarjetacreditoconexion.getid_conexion().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTarjetaCreditoConexionDescripcion(TarjetaCreditoConexion tarjetacreditoconexion,String sValor) throws Exception {			
		if(tarjetacreditoconexion !=null) {
			//tarjetacreditoconexiontarjetacreditoconexion.getId().toString();
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

	public static String getTarjetaCreditoDescripcion(TarjetaCredito tarjetacredito) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tarjetacredito!=null/*&&tarjetacredito.getId()>0*/) {
			sDescripcion=TarjetaCreditoConstantesFunciones.getTarjetaCreditoDescripcion(tarjetacredito);
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
		} else if(sNombreIndice.equals("FK_IdTarjetaCredito")) {
			sNombreIndice="Tipo=  Por Tarjeta Credito";
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

	public static String getDetalleIndiceFK_IdTarjetaCredito(Long id_tarjeta_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_tarjeta_credito!=null) {sDetalleIndice+=" Codigo Unico De Tarjeta Credito="+id_tarjeta_credito.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTarjetaCreditoConexion(TarjetaCreditoConexion tarjetacreditoconexion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosTarjetaCreditoConexions(List<TarjetaCreditoConexion> tarjetacreditoconexions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TarjetaCreditoConexion tarjetacreditoconexion: tarjetacreditoconexions) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTarjetaCreditoConexion(TarjetaCreditoConexion tarjetacreditoconexion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tarjetacreditoconexion.getConCambioAuxiliar()) {
			tarjetacreditoconexion.setIsDeleted(tarjetacreditoconexion.getIsDeletedAuxiliar());	
			tarjetacreditoconexion.setIsNew(tarjetacreditoconexion.getIsNewAuxiliar());	
			tarjetacreditoconexion.setIsChanged(tarjetacreditoconexion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tarjetacreditoconexion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tarjetacreditoconexion.setIsDeletedAuxiliar(false);	
			tarjetacreditoconexion.setIsNewAuxiliar(false);	
			tarjetacreditoconexion.setIsChangedAuxiliar(false);
			
			tarjetacreditoconexion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTarjetaCreditoConexions(List<TarjetaCreditoConexion> tarjetacreditoconexions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TarjetaCreditoConexion tarjetacreditoconexion : tarjetacreditoconexions) {
			if(conAsignarBase && tarjetacreditoconexion.getConCambioAuxiliar()) {
				tarjetacreditoconexion.setIsDeleted(tarjetacreditoconexion.getIsDeletedAuxiliar());	
				tarjetacreditoconexion.setIsNew(tarjetacreditoconexion.getIsNewAuxiliar());	
				tarjetacreditoconexion.setIsChanged(tarjetacreditoconexion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tarjetacreditoconexion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tarjetacreditoconexion.setIsDeletedAuxiliar(false);	
				tarjetacreditoconexion.setIsNewAuxiliar(false);	
				tarjetacreditoconexion.setIsChangedAuxiliar(false);
				
				tarjetacreditoconexion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTarjetaCreditoConexion(TarjetaCreditoConexion tarjetacreditoconexion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTarjetaCreditoConexions(List<TarjetaCreditoConexion> tarjetacreditoconexions,Boolean conEnteros) throws Exception  {
		
		for(TarjetaCreditoConexion tarjetacreditoconexion: tarjetacreditoconexions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTarjetaCreditoConexion(List<TarjetaCreditoConexion> tarjetacreditoconexions,TarjetaCreditoConexion tarjetacreditoconexionAux) throws Exception  {
		TarjetaCreditoConexionConstantesFunciones.InicializarValoresTarjetaCreditoConexion(tarjetacreditoconexionAux,true);
		
		for(TarjetaCreditoConexion tarjetacreditoconexion: tarjetacreditoconexions) {
			if(tarjetacreditoconexion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTarjetaCreditoConexion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TarjetaCreditoConexionConstantesFunciones.getArrayColumnasGlobalesTarjetaCreditoConexion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTarjetaCreditoConexion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TarjetaCreditoConexionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TarjetaCreditoConexionConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TarjetaCreditoConexionConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TarjetaCreditoConexionConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTarjetaCreditoConexion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TarjetaCreditoConexion> tarjetacreditoconexions,TarjetaCreditoConexion tarjetacreditoconexion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TarjetaCreditoConexion tarjetacreditoconexionAux: tarjetacreditoconexions) {
			if(tarjetacreditoconexionAux!=null && tarjetacreditoconexion!=null) {
				if((tarjetacreditoconexionAux.getId()==null && tarjetacreditoconexion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tarjetacreditoconexionAux.getId()!=null && tarjetacreditoconexion.getId()!=null){
					if(tarjetacreditoconexionAux.getId().equals(tarjetacreditoconexion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTarjetaCreditoConexion(List<TarjetaCreditoConexion> tarjetacreditoconexions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TarjetaCreditoConexion tarjetacreditoconexion: tarjetacreditoconexions) {			
			if(tarjetacreditoconexion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTarjetaCreditoConexion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TarjetaCreditoConexionConstantesFunciones.LABEL_ID, TarjetaCreditoConexionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConexionConstantesFunciones.LABEL_VERSIONROW, TarjetaCreditoConexionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConexionConstantesFunciones.LABEL_IDEMPRESA, TarjetaCreditoConexionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConexionConstantesFunciones.LABEL_IDSUCURSAL, TarjetaCreditoConexionConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConexionConstantesFunciones.LABEL_IDTARJETACREDITO, TarjetaCreditoConexionConstantesFunciones.IDTARJETACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConexionConstantesFunciones.LABEL_IDCONEXION, TarjetaCreditoConexionConstantesFunciones.IDCONEXION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTarjetaCreditoConexion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConexionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConexionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConexionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConexionConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConexionConstantesFunciones.IDTARJETACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConexionConstantesFunciones.IDCONEXION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTarjetaCreditoConexion() throws Exception  {
		return TarjetaCreditoConexionConstantesFunciones.getTiposSeleccionarTarjetaCreditoConexion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTarjetaCreditoConexion(Boolean conFk) throws Exception  {
		return TarjetaCreditoConexionConstantesFunciones.getTiposSeleccionarTarjetaCreditoConexion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTarjetaCreditoConexion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConexionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TarjetaCreditoConexionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConexionConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(TarjetaCreditoConexionConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConexionConstantesFunciones.LABEL_IDTARJETACREDITO);
			reporte.setsDescripcion(TarjetaCreditoConexionConstantesFunciones.LABEL_IDTARJETACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConexionConstantesFunciones.LABEL_IDCONEXION);
			reporte.setsDescripcion(TarjetaCreditoConexionConstantesFunciones.LABEL_IDCONEXION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTarjetaCreditoConexion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTarjetaCreditoConexion(TarjetaCreditoConexion tarjetacreditoconexionAux) throws Exception {
		
			tarjetacreditoconexionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tarjetacreditoconexionAux.getEmpresa()));
			tarjetacreditoconexionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(tarjetacreditoconexionAux.getSucursal()));
			tarjetacreditoconexionAux.settarjetacredito_descripcion(TarjetaCreditoConstantesFunciones.getTarjetaCreditoDescripcion(tarjetacreditoconexionAux.getTarjetaCredito()));
			tarjetacreditoconexionAux.setconexion_descripcion(ConexionConstantesFunciones.getConexionDescripcion(tarjetacreditoconexionAux.getConexion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTarjetaCreditoConexion(List<TarjetaCreditoConexion> tarjetacreditoconexionsTemp) throws Exception {
		for(TarjetaCreditoConexion tarjetacreditoconexionAux:tarjetacreditoconexionsTemp) {
			
			tarjetacreditoconexionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tarjetacreditoconexionAux.getEmpresa()));
			tarjetacreditoconexionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(tarjetacreditoconexionAux.getSucursal()));
			tarjetacreditoconexionAux.settarjetacredito_descripcion(TarjetaCreditoConstantesFunciones.getTarjetaCreditoDescripcion(tarjetacreditoconexionAux.getTarjetaCredito()));
			tarjetacreditoconexionAux.setconexion_descripcion(ConexionConstantesFunciones.getConexionDescripcion(tarjetacreditoconexionAux.getConexion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTarjetaCreditoConexion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(TarjetaCredito.class));
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
					if(clas.clas.equals(TarjetaCredito.class)) {
						classes.add(new Classe(TarjetaCredito.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTarjetaCreditoConexion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TarjetaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TarjetaCredito.class)); continue;
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

					if(TarjetaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TarjetaCredito.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTarjetaCreditoConexion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TarjetaCreditoConexionConstantesFunciones.getClassesRelationshipsOfTarjetaCreditoConexion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTarjetaCreditoConexion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTarjetaCreditoConexion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TarjetaCreditoConexionConstantesFunciones.getClassesRelationshipsFromStringsOfTarjetaCreditoConexion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTarjetaCreditoConexion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TarjetaCreditoConexion tarjetacreditoconexion,List<TarjetaCreditoConexion> tarjetacreditoconexions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TarjetaCreditoConexion tarjetacreditoconexionEncontrado=null;
			
			for(TarjetaCreditoConexion tarjetacreditoconexionLocal:tarjetacreditoconexions) {
				if(tarjetacreditoconexionLocal.getId().equals(tarjetacreditoconexion.getId())) {
					tarjetacreditoconexionEncontrado=tarjetacreditoconexionLocal;
					
					tarjetacreditoconexionLocal.setIsChanged(tarjetacreditoconexion.getIsChanged());
					tarjetacreditoconexionLocal.setIsNew(tarjetacreditoconexion.getIsNew());
					tarjetacreditoconexionLocal.setIsDeleted(tarjetacreditoconexion.getIsDeleted());
					
					tarjetacreditoconexionLocal.setGeneralEntityOriginal(tarjetacreditoconexion.getGeneralEntityOriginal());
					
					tarjetacreditoconexionLocal.setId(tarjetacreditoconexion.getId());	
					tarjetacreditoconexionLocal.setVersionRow(tarjetacreditoconexion.getVersionRow());	
					tarjetacreditoconexionLocal.setid_empresa(tarjetacreditoconexion.getid_empresa());	
					tarjetacreditoconexionLocal.setid_sucursal(tarjetacreditoconexion.getid_sucursal());	
					tarjetacreditoconexionLocal.setid_tarjeta_credito(tarjetacreditoconexion.getid_tarjeta_credito());	
					tarjetacreditoconexionLocal.setid_conexion(tarjetacreditoconexion.getid_conexion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tarjetacreditoconexion.getIsDeleted()) {
				if(!existe) {
					tarjetacreditoconexions.add(tarjetacreditoconexion);
				}
			} else {
				if(tarjetacreditoconexionEncontrado!=null && permiteQuitar)  {
					tarjetacreditoconexions.remove(tarjetacreditoconexionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TarjetaCreditoConexion tarjetacreditoconexion,List<TarjetaCreditoConexion> tarjetacreditoconexions) throws Exception {
		try	{			
			for(TarjetaCreditoConexion tarjetacreditoconexionLocal:tarjetacreditoconexions) {
				if(tarjetacreditoconexionLocal.getId().equals(tarjetacreditoconexion.getId())) {
					tarjetacreditoconexionLocal.setIsSelected(tarjetacreditoconexion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTarjetaCreditoConexion(List<TarjetaCreditoConexion> tarjetacreditoconexionsAux) throws Exception {
		//this.tarjetacreditoconexionsAux=tarjetacreditoconexionsAux;
		
		for(TarjetaCreditoConexion tarjetacreditoconexionAux:tarjetacreditoconexionsAux) {
			if(tarjetacreditoconexionAux.getIsChanged()) {
				tarjetacreditoconexionAux.setIsChanged(false);
			}		
			
			if(tarjetacreditoconexionAux.getIsNew()) {
				tarjetacreditoconexionAux.setIsNew(false);
			}	
			
			if(tarjetacreditoconexionAux.getIsDeleted()) {
				tarjetacreditoconexionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTarjetaCreditoConexion(TarjetaCreditoConexion tarjetacreditoconexionAux) throws Exception {
		//this.tarjetacreditoconexionAux=tarjetacreditoconexionAux;
		
			if(tarjetacreditoconexionAux.getIsChanged()) {
				tarjetacreditoconexionAux.setIsChanged(false);
			}		
			
			if(tarjetacreditoconexionAux.getIsNew()) {
				tarjetacreditoconexionAux.setIsNew(false);
			}	
			
			if(tarjetacreditoconexionAux.getIsDeleted()) {
				tarjetacreditoconexionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TarjetaCreditoConexion tarjetacreditoconexionAsignar,TarjetaCreditoConexion tarjetacreditoconexion) throws Exception {
		tarjetacreditoconexionAsignar.setId(tarjetacreditoconexion.getId());	
		tarjetacreditoconexionAsignar.setVersionRow(tarjetacreditoconexion.getVersionRow());	
		tarjetacreditoconexionAsignar.setid_empresa(tarjetacreditoconexion.getid_empresa());
		tarjetacreditoconexionAsignar.setempresa_descripcion(tarjetacreditoconexion.getempresa_descripcion());	
		tarjetacreditoconexionAsignar.setid_sucursal(tarjetacreditoconexion.getid_sucursal());
		tarjetacreditoconexionAsignar.setsucursal_descripcion(tarjetacreditoconexion.getsucursal_descripcion());	
		tarjetacreditoconexionAsignar.setid_tarjeta_credito(tarjetacreditoconexion.getid_tarjeta_credito());
		tarjetacreditoconexionAsignar.settarjetacredito_descripcion(tarjetacreditoconexion.gettarjetacredito_descripcion());	
		tarjetacreditoconexionAsignar.setid_conexion(tarjetacreditoconexion.getid_conexion());
		tarjetacreditoconexionAsignar.setconexion_descripcion(tarjetacreditoconexion.getconexion_descripcion());	
	}
	
	public static void inicializarTarjetaCreditoConexion(TarjetaCreditoConexion tarjetacreditoconexion) throws Exception {
		try {
				tarjetacreditoconexion.setId(0L);	
					
				tarjetacreditoconexion.setid_empresa(-1L);	
				tarjetacreditoconexion.setid_sucursal(-1L);	
				tarjetacreditoconexion.setid_tarjeta_credito(-1L);	
				tarjetacreditoconexion.setid_conexion(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTarjetaCreditoConexion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConexionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConexionConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConexionConstantesFunciones.LABEL_IDTARJETACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConexionConstantesFunciones.LABEL_IDCONEXION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTarjetaCreditoConexion(String sTipo,Row row,Workbook workbook,TarjetaCreditoConexion tarjetacreditoconexion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacreditoconexion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacreditoconexion.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacreditoconexion.gettarjetacredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacreditoconexion.getconexion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTarjetaCreditoConexion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTarjetaCreditoConexion() {
		return this.sFinalQueryTarjetaCreditoConexion;
	}
	
	public void setsFinalQueryTarjetaCreditoConexion(String sFinalQueryTarjetaCreditoConexion) {
		this.sFinalQueryTarjetaCreditoConexion= sFinalQueryTarjetaCreditoConexion;
	}
	
	public Border resaltarSeleccionarTarjetaCreditoConexion=null;
	
	public Border setResaltarSeleccionarTarjetaCreditoConexion(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoConexionBeanSwingJInternalFrame tarjetacreditoconexionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tarjetacreditoconexionBeanSwingJInternalFrame.jTtoolBarTarjetaCreditoConexion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTarjetaCreditoConexion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTarjetaCreditoConexion() {
		return this.resaltarSeleccionarTarjetaCreditoConexion;
	}
	
	public void setResaltarSeleccionarTarjetaCreditoConexion(Border borderResaltarSeleccionarTarjetaCreditoConexion) {
		this.resaltarSeleccionarTarjetaCreditoConexion= borderResaltarSeleccionarTarjetaCreditoConexion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTarjetaCreditoConexion=null;
	public Boolean mostraridTarjetaCreditoConexion=true;
	public Boolean activaridTarjetaCreditoConexion=true;

	public Border resaltarid_empresaTarjetaCreditoConexion=null;
	public Boolean mostrarid_empresaTarjetaCreditoConexion=true;
	public Boolean activarid_empresaTarjetaCreditoConexion=true;
	public Boolean cargarid_empresaTarjetaCreditoConexion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTarjetaCreditoConexion=false;//ConEventDepend=true

	public Border resaltarid_sucursalTarjetaCreditoConexion=null;
	public Boolean mostrarid_sucursalTarjetaCreditoConexion=true;
	public Boolean activarid_sucursalTarjetaCreditoConexion=true;
	public Boolean cargarid_sucursalTarjetaCreditoConexion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalTarjetaCreditoConexion=false;//ConEventDepend=true

	public Border resaltarid_tarjeta_creditoTarjetaCreditoConexion=null;
	public Boolean mostrarid_tarjeta_creditoTarjetaCreditoConexion=true;
	public Boolean activarid_tarjeta_creditoTarjetaCreditoConexion=true;
	public Boolean cargarid_tarjeta_creditoTarjetaCreditoConexion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tarjeta_creditoTarjetaCreditoConexion=false;//ConEventDepend=true

	public Border resaltarid_conexionTarjetaCreditoConexion=null;
	public Boolean mostrarid_conexionTarjetaCreditoConexion=true;
	public Boolean activarid_conexionTarjetaCreditoConexion=true;
	public Boolean cargarid_conexionTarjetaCreditoConexion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_conexionTarjetaCreditoConexion=false;//ConEventDepend=true

	
	

	public Border setResaltaridTarjetaCreditoConexion(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoConexionBeanSwingJInternalFrame tarjetacreditoconexionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoconexionBeanSwingJInternalFrame.jTtoolBarTarjetaCreditoConexion.setBorder(borderResaltar);
		
		this.resaltaridTarjetaCreditoConexion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTarjetaCreditoConexion() {
		return this.resaltaridTarjetaCreditoConexion;
	}

	public void setResaltaridTarjetaCreditoConexion(Border borderResaltar) {
		this.resaltaridTarjetaCreditoConexion= borderResaltar;
	}

	public Boolean getMostraridTarjetaCreditoConexion() {
		return this.mostraridTarjetaCreditoConexion;
	}

	public void setMostraridTarjetaCreditoConexion(Boolean mostraridTarjetaCreditoConexion) {
		this.mostraridTarjetaCreditoConexion= mostraridTarjetaCreditoConexion;
	}

	public Boolean getActivaridTarjetaCreditoConexion() {
		return this.activaridTarjetaCreditoConexion;
	}

	public void setActivaridTarjetaCreditoConexion(Boolean activaridTarjetaCreditoConexion) {
		this.activaridTarjetaCreditoConexion= activaridTarjetaCreditoConexion;
	}

	public Border setResaltarid_empresaTarjetaCreditoConexion(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoConexionBeanSwingJInternalFrame tarjetacreditoconexionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoconexionBeanSwingJInternalFrame.jTtoolBarTarjetaCreditoConexion.setBorder(borderResaltar);
		
		this.resaltarid_empresaTarjetaCreditoConexion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTarjetaCreditoConexion() {
		return this.resaltarid_empresaTarjetaCreditoConexion;
	}

	public void setResaltarid_empresaTarjetaCreditoConexion(Border borderResaltar) {
		this.resaltarid_empresaTarjetaCreditoConexion= borderResaltar;
	}

	public Boolean getMostrarid_empresaTarjetaCreditoConexion() {
		return this.mostrarid_empresaTarjetaCreditoConexion;
	}

	public void setMostrarid_empresaTarjetaCreditoConexion(Boolean mostrarid_empresaTarjetaCreditoConexion) {
		this.mostrarid_empresaTarjetaCreditoConexion= mostrarid_empresaTarjetaCreditoConexion;
	}

	public Boolean getActivarid_empresaTarjetaCreditoConexion() {
		return this.activarid_empresaTarjetaCreditoConexion;
	}

	public void setActivarid_empresaTarjetaCreditoConexion(Boolean activarid_empresaTarjetaCreditoConexion) {
		this.activarid_empresaTarjetaCreditoConexion= activarid_empresaTarjetaCreditoConexion;
	}

	public Boolean getCargarid_empresaTarjetaCreditoConexion() {
		return this.cargarid_empresaTarjetaCreditoConexion;
	}

	public void setCargarid_empresaTarjetaCreditoConexion(Boolean cargarid_empresaTarjetaCreditoConexion) {
		this.cargarid_empresaTarjetaCreditoConexion= cargarid_empresaTarjetaCreditoConexion;
	}

	public Border setResaltarid_sucursalTarjetaCreditoConexion(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoConexionBeanSwingJInternalFrame tarjetacreditoconexionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoconexionBeanSwingJInternalFrame.jTtoolBarTarjetaCreditoConexion.setBorder(borderResaltar);
		
		this.resaltarid_sucursalTarjetaCreditoConexion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalTarjetaCreditoConexion() {
		return this.resaltarid_sucursalTarjetaCreditoConexion;
	}

	public void setResaltarid_sucursalTarjetaCreditoConexion(Border borderResaltar) {
		this.resaltarid_sucursalTarjetaCreditoConexion= borderResaltar;
	}

	public Boolean getMostrarid_sucursalTarjetaCreditoConexion() {
		return this.mostrarid_sucursalTarjetaCreditoConexion;
	}

	public void setMostrarid_sucursalTarjetaCreditoConexion(Boolean mostrarid_sucursalTarjetaCreditoConexion) {
		this.mostrarid_sucursalTarjetaCreditoConexion= mostrarid_sucursalTarjetaCreditoConexion;
	}

	public Boolean getActivarid_sucursalTarjetaCreditoConexion() {
		return this.activarid_sucursalTarjetaCreditoConexion;
	}

	public void setActivarid_sucursalTarjetaCreditoConexion(Boolean activarid_sucursalTarjetaCreditoConexion) {
		this.activarid_sucursalTarjetaCreditoConexion= activarid_sucursalTarjetaCreditoConexion;
	}

	public Boolean getCargarid_sucursalTarjetaCreditoConexion() {
		return this.cargarid_sucursalTarjetaCreditoConexion;
	}

	public void setCargarid_sucursalTarjetaCreditoConexion(Boolean cargarid_sucursalTarjetaCreditoConexion) {
		this.cargarid_sucursalTarjetaCreditoConexion= cargarid_sucursalTarjetaCreditoConexion;
	}

	public Border setResaltarid_tarjeta_creditoTarjetaCreditoConexion(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoConexionBeanSwingJInternalFrame tarjetacreditoconexionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoconexionBeanSwingJInternalFrame.jTtoolBarTarjetaCreditoConexion.setBorder(borderResaltar);
		
		this.resaltarid_tarjeta_creditoTarjetaCreditoConexion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tarjeta_creditoTarjetaCreditoConexion() {
		return this.resaltarid_tarjeta_creditoTarjetaCreditoConexion;
	}

	public void setResaltarid_tarjeta_creditoTarjetaCreditoConexion(Border borderResaltar) {
		this.resaltarid_tarjeta_creditoTarjetaCreditoConexion= borderResaltar;
	}

	public Boolean getMostrarid_tarjeta_creditoTarjetaCreditoConexion() {
		return this.mostrarid_tarjeta_creditoTarjetaCreditoConexion;
	}

	public void setMostrarid_tarjeta_creditoTarjetaCreditoConexion(Boolean mostrarid_tarjeta_creditoTarjetaCreditoConexion) {
		this.mostrarid_tarjeta_creditoTarjetaCreditoConexion= mostrarid_tarjeta_creditoTarjetaCreditoConexion;
	}

	public Boolean getActivarid_tarjeta_creditoTarjetaCreditoConexion() {
		return this.activarid_tarjeta_creditoTarjetaCreditoConexion;
	}

	public void setActivarid_tarjeta_creditoTarjetaCreditoConexion(Boolean activarid_tarjeta_creditoTarjetaCreditoConexion) {
		this.activarid_tarjeta_creditoTarjetaCreditoConexion= activarid_tarjeta_creditoTarjetaCreditoConexion;
	}

	public Boolean getCargarid_tarjeta_creditoTarjetaCreditoConexion() {
		return this.cargarid_tarjeta_creditoTarjetaCreditoConexion;
	}

	public void setCargarid_tarjeta_creditoTarjetaCreditoConexion(Boolean cargarid_tarjeta_creditoTarjetaCreditoConexion) {
		this.cargarid_tarjeta_creditoTarjetaCreditoConexion= cargarid_tarjeta_creditoTarjetaCreditoConexion;
	}

	public Border setResaltarid_conexionTarjetaCreditoConexion(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoConexionBeanSwingJInternalFrame tarjetacreditoconexionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoconexionBeanSwingJInternalFrame.jTtoolBarTarjetaCreditoConexion.setBorder(borderResaltar);
		
		this.resaltarid_conexionTarjetaCreditoConexion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_conexionTarjetaCreditoConexion() {
		return this.resaltarid_conexionTarjetaCreditoConexion;
	}

	public void setResaltarid_conexionTarjetaCreditoConexion(Border borderResaltar) {
		this.resaltarid_conexionTarjetaCreditoConexion= borderResaltar;
	}

	public Boolean getMostrarid_conexionTarjetaCreditoConexion() {
		return this.mostrarid_conexionTarjetaCreditoConexion;
	}

	public void setMostrarid_conexionTarjetaCreditoConexion(Boolean mostrarid_conexionTarjetaCreditoConexion) {
		this.mostrarid_conexionTarjetaCreditoConexion= mostrarid_conexionTarjetaCreditoConexion;
	}

	public Boolean getActivarid_conexionTarjetaCreditoConexion() {
		return this.activarid_conexionTarjetaCreditoConexion;
	}

	public void setActivarid_conexionTarjetaCreditoConexion(Boolean activarid_conexionTarjetaCreditoConexion) {
		this.activarid_conexionTarjetaCreditoConexion= activarid_conexionTarjetaCreditoConexion;
	}

	public Boolean getCargarid_conexionTarjetaCreditoConexion() {
		return this.cargarid_conexionTarjetaCreditoConexion;
	}

	public void setCargarid_conexionTarjetaCreditoConexion(Boolean cargarid_conexionTarjetaCreditoConexion) {
		this.cargarid_conexionTarjetaCreditoConexion= cargarid_conexionTarjetaCreditoConexion;
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
		
		
		this.setMostraridTarjetaCreditoConexion(esInicial);
		this.setMostrarid_empresaTarjetaCreditoConexion(esInicial);
		this.setMostrarid_sucursalTarjetaCreditoConexion(esInicial);
		this.setMostrarid_tarjeta_creditoTarjetaCreditoConexion(esInicial);
		this.setMostrarid_conexionTarjetaCreditoConexion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TarjetaCreditoConexionConstantesFunciones.ID)) {
				this.setMostraridTarjetaCreditoConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConexionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTarjetaCreditoConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConexionConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalTarjetaCreditoConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConexionConstantesFunciones.IDTARJETACREDITO)) {
				this.setMostrarid_tarjeta_creditoTarjetaCreditoConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConexionConstantesFunciones.IDCONEXION)) {
				this.setMostrarid_conexionTarjetaCreditoConexion(esAsigna);
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
		
		
		this.setActivaridTarjetaCreditoConexion(esInicial);
		this.setActivarid_empresaTarjetaCreditoConexion(esInicial);
		this.setActivarid_sucursalTarjetaCreditoConexion(esInicial);
		this.setActivarid_tarjeta_creditoTarjetaCreditoConexion(esInicial);
		this.setActivarid_conexionTarjetaCreditoConexion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TarjetaCreditoConexionConstantesFunciones.ID)) {
				this.setActivaridTarjetaCreditoConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConexionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTarjetaCreditoConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConexionConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalTarjetaCreditoConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConexionConstantesFunciones.IDTARJETACREDITO)) {
				this.setActivarid_tarjeta_creditoTarjetaCreditoConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConexionConstantesFunciones.IDCONEXION)) {
				this.setActivarid_conexionTarjetaCreditoConexion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TarjetaCreditoConexionBeanSwingJInternalFrame tarjetacreditoconexionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTarjetaCreditoConexion(esInicial);
		this.setResaltarid_empresaTarjetaCreditoConexion(esInicial);
		this.setResaltarid_sucursalTarjetaCreditoConexion(esInicial);
		this.setResaltarid_tarjeta_creditoTarjetaCreditoConexion(esInicial);
		this.setResaltarid_conexionTarjetaCreditoConexion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TarjetaCreditoConexionConstantesFunciones.ID)) {
				this.setResaltaridTarjetaCreditoConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConexionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTarjetaCreditoConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConexionConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalTarjetaCreditoConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConexionConstantesFunciones.IDTARJETACREDITO)) {
				this.setResaltarid_tarjeta_creditoTarjetaCreditoConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConexionConstantesFunciones.IDCONEXION)) {
				this.setResaltarid_conexionTarjetaCreditoConexion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TarjetaCreditoConexionBeanSwingJInternalFrame tarjetacreditoconexionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdConexionTarjetaCreditoConexion=true;

	public Boolean getMostrarFK_IdConexionTarjetaCreditoConexion() {
		return this.mostrarFK_IdConexionTarjetaCreditoConexion;
	}

	public void setMostrarFK_IdConexionTarjetaCreditoConexion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdConexionTarjetaCreditoConexion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTarjetaCreditoConexion=true;

	public Boolean getMostrarFK_IdEmpresaTarjetaCreditoConexion() {
		return this.mostrarFK_IdEmpresaTarjetaCreditoConexion;
	}

	public void setMostrarFK_IdEmpresaTarjetaCreditoConexion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTarjetaCreditoConexion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalTarjetaCreditoConexion=true;

	public Boolean getMostrarFK_IdSucursalTarjetaCreditoConexion() {
		return this.mostrarFK_IdSucursalTarjetaCreditoConexion;
	}

	public void setMostrarFK_IdSucursalTarjetaCreditoConexion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalTarjetaCreditoConexion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTarjetaCreditoTarjetaCreditoConexion=true;

	public Boolean getMostrarFK_IdTarjetaCreditoTarjetaCreditoConexion() {
		return this.mostrarFK_IdTarjetaCreditoTarjetaCreditoConexion;
	}

	public void setMostrarFK_IdTarjetaCreditoTarjetaCreditoConexion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTarjetaCreditoTarjetaCreditoConexion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdConexionTarjetaCreditoConexion=true;

	public Boolean getActivarFK_IdConexionTarjetaCreditoConexion() {
		return this.activarFK_IdConexionTarjetaCreditoConexion;
	}

	public void setActivarFK_IdConexionTarjetaCreditoConexion(Boolean habilitarResaltar) {
		this.activarFK_IdConexionTarjetaCreditoConexion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTarjetaCreditoConexion=true;

	public Boolean getActivarFK_IdEmpresaTarjetaCreditoConexion() {
		return this.activarFK_IdEmpresaTarjetaCreditoConexion;
	}

	public void setActivarFK_IdEmpresaTarjetaCreditoConexion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTarjetaCreditoConexion= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalTarjetaCreditoConexion=true;

	public Boolean getActivarFK_IdSucursalTarjetaCreditoConexion() {
		return this.activarFK_IdSucursalTarjetaCreditoConexion;
	}

	public void setActivarFK_IdSucursalTarjetaCreditoConexion(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalTarjetaCreditoConexion= habilitarResaltar;
	}

	public Boolean activarFK_IdTarjetaCreditoTarjetaCreditoConexion=true;

	public Boolean getActivarFK_IdTarjetaCreditoTarjetaCreditoConexion() {
		return this.activarFK_IdTarjetaCreditoTarjetaCreditoConexion;
	}

	public void setActivarFK_IdTarjetaCreditoTarjetaCreditoConexion(Boolean habilitarResaltar) {
		this.activarFK_IdTarjetaCreditoTarjetaCreditoConexion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdConexionTarjetaCreditoConexion=null;

	public Border getResaltarFK_IdConexionTarjetaCreditoConexion() {
		return this.resaltarFK_IdConexionTarjetaCreditoConexion;
	}

	public void setResaltarFK_IdConexionTarjetaCreditoConexion(Border borderResaltar) {
		this.resaltarFK_IdConexionTarjetaCreditoConexion= borderResaltar;
	}

	public void setResaltarFK_IdConexionTarjetaCreditoConexion(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoConexionBeanSwingJInternalFrame tarjetacreditoconexionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdConexionTarjetaCreditoConexion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTarjetaCreditoConexion=null;

	public Border getResaltarFK_IdEmpresaTarjetaCreditoConexion() {
		return this.resaltarFK_IdEmpresaTarjetaCreditoConexion;
	}

	public void setResaltarFK_IdEmpresaTarjetaCreditoConexion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTarjetaCreditoConexion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTarjetaCreditoConexion(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoConexionBeanSwingJInternalFrame tarjetacreditoconexionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTarjetaCreditoConexion= borderResaltar;
	}

	public Border resaltarFK_IdSucursalTarjetaCreditoConexion=null;

	public Border getResaltarFK_IdSucursalTarjetaCreditoConexion() {
		return this.resaltarFK_IdSucursalTarjetaCreditoConexion;
	}

	public void setResaltarFK_IdSucursalTarjetaCreditoConexion(Border borderResaltar) {
		this.resaltarFK_IdSucursalTarjetaCreditoConexion= borderResaltar;
	}

	public void setResaltarFK_IdSucursalTarjetaCreditoConexion(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoConexionBeanSwingJInternalFrame tarjetacreditoconexionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalTarjetaCreditoConexion= borderResaltar;
	}

	public Border resaltarFK_IdTarjetaCreditoTarjetaCreditoConexion=null;

	public Border getResaltarFK_IdTarjetaCreditoTarjetaCreditoConexion() {
		return this.resaltarFK_IdTarjetaCreditoTarjetaCreditoConexion;
	}

	public void setResaltarFK_IdTarjetaCreditoTarjetaCreditoConexion(Border borderResaltar) {
		this.resaltarFK_IdTarjetaCreditoTarjetaCreditoConexion= borderResaltar;
	}

	public void setResaltarFK_IdTarjetaCreditoTarjetaCreditoConexion(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoConexionBeanSwingJInternalFrame tarjetacreditoconexionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTarjetaCreditoTarjetaCreditoConexion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}