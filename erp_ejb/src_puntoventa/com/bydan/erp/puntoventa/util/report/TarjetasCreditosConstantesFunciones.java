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
package com.bydan.erp.puntoventa.util.report;

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


import com.bydan.erp.puntoventa.util.report.TarjetasCreditosConstantesFunciones;
import com.bydan.erp.puntoventa.util.report.TarjetasCreditosParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.TarjetasCreditosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.puntoventa.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TarjetasCreditosConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="TarjetasCreditos";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TarjetasCreditos"+TarjetasCreditosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TarjetasCreditosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TarjetasCreditosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TarjetasCreditosConstantesFunciones.SCHEMA+"_"+TarjetasCreditosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TarjetasCreditosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TarjetasCreditosConstantesFunciones.SCHEMA+"_"+TarjetasCreditosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TarjetasCreditosConstantesFunciones.SCHEMA+"_"+TarjetasCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TarjetasCreditosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TarjetasCreditosConstantesFunciones.SCHEMA+"_"+TarjetasCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TarjetasCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TarjetasCreditosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TarjetasCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TarjetasCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TarjetasCreditosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TarjetasCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TarjetasCreditosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TarjetasCreditosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TarjetasCreditosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TarjetasCreditosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tarjeta Creditos";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tarjeta Credito";
	public static final String SCLASSWEBTITULO_LOWER="Tarjetas Creditos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TarjetasCreditos";
	public static final String OBJECTNAME="tarjetascreditos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="tarjeta_credito";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tarjetascreditos from "+TarjetasCreditosConstantesFunciones.SPERSISTENCENAME+" tarjetascreditos";
	public static String QUERYSELECTNATIVE="select "+TarjetasCreditosConstantesFunciones.SCHEMA+"."+TarjetasCreditosConstantesFunciones.TABLENAME+".id,"+TarjetasCreditosConstantesFunciones.SCHEMA+"."+TarjetasCreditosConstantesFunciones.TABLENAME+".version_row,"+TarjetasCreditosConstantesFunciones.SCHEMA+"."+TarjetasCreditosConstantesFunciones.TABLENAME+".id_empresa,"+TarjetasCreditosConstantesFunciones.SCHEMA+"."+TarjetasCreditosConstantesFunciones.TABLENAME+".id_sucursal,"+TarjetasCreditosConstantesFunciones.SCHEMA+"."+TarjetasCreditosConstantesFunciones.TABLENAME+".id_tarjeta_credito,"+TarjetasCreditosConstantesFunciones.SCHEMA+"."+TarjetasCreditosConstantesFunciones.TABLENAME+".fecha_inicio,"+TarjetasCreditosConstantesFunciones.SCHEMA+"."+TarjetasCreditosConstantesFunciones.TABLENAME+".fecha_fin,"+TarjetasCreditosConstantesFunciones.SCHEMA+"."+TarjetasCreditosConstantesFunciones.TABLENAME+".nombre_tarjeta,"+TarjetasCreditosConstantesFunciones.SCHEMA+"."+TarjetasCreditosConstantesFunciones.TABLENAME+".lote,"+TarjetasCreditosConstantesFunciones.SCHEMA+"."+TarjetasCreditosConstantesFunciones.TABLENAME+".fecha,"+TarjetasCreditosConstantesFunciones.SCHEMA+"."+TarjetasCreditosConstantesFunciones.TABLENAME+".total from "+TarjetasCreditosConstantesFunciones.SCHEMA+"."+TarjetasCreditosConstantesFunciones.TABLENAME;//+" as "+TarjetasCreditosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDTARJETACREDITO= "id_tarjeta_credito";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String NOMBRETARJETA= "nombre_tarjeta";
    public static final String LOTE= "lote";
    public static final String FECHA= "fecha";
    public static final String TOTAL= "total";
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
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_NOMBRETARJETA= "Nombre Tarjeta";
		public static final String LABEL_NOMBRETARJETA_LOWER= "Nombre Tarjeta";
    	public static final String LABEL_LOTE= "Lote";
		public static final String LABEL_LOTE_LOWER= "Lote";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
	
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_TARJETA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TARJETA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXLOTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLOTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getTarjetasCreditosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TarjetasCreditosConstantesFunciones.IDEMPRESA)) {sLabelColumna=TarjetasCreditosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TarjetasCreditosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=TarjetasCreditosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(TarjetasCreditosConstantesFunciones.IDTARJETACREDITO)) {sLabelColumna=TarjetasCreditosConstantesFunciones.LABEL_IDTARJETACREDITO;}
		if(sNombreColumna.equals(TarjetasCreditosConstantesFunciones.FECHAINICIO)) {sLabelColumna=TarjetasCreditosConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(TarjetasCreditosConstantesFunciones.FECHAFIN)) {sLabelColumna=TarjetasCreditosConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(TarjetasCreditosConstantesFunciones.NOMBRETARJETA)) {sLabelColumna=TarjetasCreditosConstantesFunciones.LABEL_NOMBRETARJETA;}
		if(sNombreColumna.equals(TarjetasCreditosConstantesFunciones.LOTE)) {sLabelColumna=TarjetasCreditosConstantesFunciones.LABEL_LOTE;}
		if(sNombreColumna.equals(TarjetasCreditosConstantesFunciones.FECHA)) {sLabelColumna=TarjetasCreditosConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(TarjetasCreditosConstantesFunciones.TOTAL)) {sLabelColumna=TarjetasCreditosConstantesFunciones.LABEL_TOTAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getTarjetasCreditosDescripcion(TarjetasCreditos tarjetascreditos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tarjetascreditos !=null/* && tarjetascreditos.getId()!=0*/) {
			if(tarjetascreditos.getId()!=null) {
				sDescripcion=tarjetascreditos.getId().toString();
			}//tarjetascreditostarjetascreditos.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTarjetasCreditosDescripcionDetallado(TarjetasCreditos tarjetascreditos) {
		String sDescripcion="";
			
		sDescripcion+=TarjetasCreditosConstantesFunciones.ID+"=";
		sDescripcion+=tarjetascreditos.getId().toString()+",";
		sDescripcion+=TarjetasCreditosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tarjetascreditos.getVersionRow().toString()+",";
		sDescripcion+=TarjetasCreditosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tarjetascreditos.getid_empresa().toString()+",";
		sDescripcion+=TarjetasCreditosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=tarjetascreditos.getid_sucursal().toString()+",";
		sDescripcion+=TarjetasCreditosConstantesFunciones.IDTARJETACREDITO+"=";
		sDescripcion+=tarjetascreditos.getid_tarjeta_credito().toString()+",";
		sDescripcion+=TarjetasCreditosConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=tarjetascreditos.getfecha_inicio().toString()+",";
		sDescripcion+=TarjetasCreditosConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=tarjetascreditos.getfecha_fin().toString()+",";
		sDescripcion+=TarjetasCreditosConstantesFunciones.NOMBRETARJETA+"=";
		sDescripcion+=tarjetascreditos.getnombre_tarjeta()+",";
		sDescripcion+=TarjetasCreditosConstantesFunciones.LOTE+"=";
		sDescripcion+=tarjetascreditos.getlote()+",";
		sDescripcion+=TarjetasCreditosConstantesFunciones.FECHA+"=";
		sDescripcion+=tarjetascreditos.getfecha().toString()+",";
		sDescripcion+=TarjetasCreditosConstantesFunciones.TOTAL+"=";
		sDescripcion+=tarjetascreditos.gettotal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTarjetasCreditosDescripcion(TarjetasCreditos tarjetascreditos,String sValor) throws Exception {			
		if(tarjetascreditos !=null) {
			//tarjetascreditostarjetascreditos.getId().toString();
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaTarjetaCredito")) {
			sNombreIndice="Tipo=  Por Fecha Inicio Por Fecha Fin";
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

	public static String getDetalleIndiceBusquedaTarjetaCredito(Date fecha_inicio,Date fecha_fin) {
		String sDetalleIndice=" Parametros->";
		if(fecha_inicio!=null) {sDetalleIndice+=" Fecha Inicio="+fecha_inicio.toString();}
		if(fecha_fin!=null) {sDetalleIndice+=" Fecha Fin="+fecha_fin.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosTarjetasCreditos(TarjetasCreditos tarjetascreditos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tarjetascreditos.setnombre_tarjeta(tarjetascreditos.getnombre_tarjeta().trim());
		tarjetascreditos.setlote(tarjetascreditos.getlote().trim());
	}
	
	public static void quitarEspaciosTarjetasCreditoss(List<TarjetasCreditos> tarjetascreditoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TarjetasCreditos tarjetascreditos: tarjetascreditoss) {
			tarjetascreditos.setnombre_tarjeta(tarjetascreditos.getnombre_tarjeta().trim());
			tarjetascreditos.setlote(tarjetascreditos.getlote().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTarjetasCreditos(TarjetasCreditos tarjetascreditos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tarjetascreditos.getConCambioAuxiliar()) {
			tarjetascreditos.setIsDeleted(tarjetascreditos.getIsDeletedAuxiliar());	
			tarjetascreditos.setIsNew(tarjetascreditos.getIsNewAuxiliar());	
			tarjetascreditos.setIsChanged(tarjetascreditos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tarjetascreditos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tarjetascreditos.setIsDeletedAuxiliar(false);	
			tarjetascreditos.setIsNewAuxiliar(false);	
			tarjetascreditos.setIsChangedAuxiliar(false);
			
			tarjetascreditos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTarjetasCreditoss(List<TarjetasCreditos> tarjetascreditoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TarjetasCreditos tarjetascreditos : tarjetascreditoss) {
			if(conAsignarBase && tarjetascreditos.getConCambioAuxiliar()) {
				tarjetascreditos.setIsDeleted(tarjetascreditos.getIsDeletedAuxiliar());	
				tarjetascreditos.setIsNew(tarjetascreditos.getIsNewAuxiliar());	
				tarjetascreditos.setIsChanged(tarjetascreditos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tarjetascreditos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tarjetascreditos.setIsDeletedAuxiliar(false);	
				tarjetascreditos.setIsNewAuxiliar(false);	
				tarjetascreditos.setIsChangedAuxiliar(false);
				
				tarjetascreditos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTarjetasCreditos(TarjetasCreditos tarjetascreditos,Boolean conEnteros) throws Exception  {
		tarjetascreditos.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTarjetasCreditoss(List<TarjetasCreditos> tarjetascreditoss,Boolean conEnteros) throws Exception  {
		
		for(TarjetasCreditos tarjetascreditos: tarjetascreditoss) {
			tarjetascreditos.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTarjetasCreditos(List<TarjetasCreditos> tarjetascreditoss,TarjetasCreditos tarjetascreditosAux) throws Exception  {
		TarjetasCreditosConstantesFunciones.InicializarValoresTarjetasCreditos(tarjetascreditosAux,true);
		
		for(TarjetasCreditos tarjetascreditos: tarjetascreditoss) {
			if(tarjetascreditos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			tarjetascreditosAux.settotal(tarjetascreditosAux.gettotal()+tarjetascreditos.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTarjetasCreditos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TarjetasCreditosConstantesFunciones.getArrayColumnasGlobalesTarjetasCreditos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTarjetasCreditos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TarjetasCreditosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TarjetasCreditosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TarjetasCreditosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TarjetasCreditosConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTarjetasCreditos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TarjetasCreditos> tarjetascreditoss,TarjetasCreditos tarjetascreditos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TarjetasCreditos tarjetascreditosAux: tarjetascreditoss) {
			if(tarjetascreditosAux!=null && tarjetascreditos!=null) {
				if((tarjetascreditosAux.getId()==null && tarjetascreditos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tarjetascreditosAux.getId()!=null && tarjetascreditos.getId()!=null){
					if(tarjetascreditosAux.getId().equals(tarjetascreditos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTarjetasCreditos(List<TarjetasCreditos> tarjetascreditoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double totalTotal=0.0;
	
		for(TarjetasCreditos tarjetascreditos: tarjetascreditoss) {			
			if(tarjetascreditos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			totalTotal+=tarjetascreditos.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TarjetasCreditosConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(TarjetasCreditosConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTarjetasCreditos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TarjetasCreditosConstantesFunciones.LABEL_ID, TarjetasCreditosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetasCreditosConstantesFunciones.LABEL_VERSIONROW, TarjetasCreditosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetasCreditosConstantesFunciones.LABEL_IDTARJETACREDITO, TarjetasCreditosConstantesFunciones.IDTARJETACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetasCreditosConstantesFunciones.LABEL_NOMBRETARJETA, TarjetasCreditosConstantesFunciones.NOMBRETARJETA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetasCreditosConstantesFunciones.LABEL_LOTE, TarjetasCreditosConstantesFunciones.LOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetasCreditosConstantesFunciones.LABEL_FECHA, TarjetasCreditosConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetasCreditosConstantesFunciones.LABEL_TOTAL, TarjetasCreditosConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTarjetasCreditos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TarjetasCreditosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetasCreditosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetasCreditosConstantesFunciones.IDTARJETACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetasCreditosConstantesFunciones.NOMBRETARJETA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetasCreditosConstantesFunciones.LOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetasCreditosConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetasCreditosConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTarjetasCreditos() throws Exception  {
		return TarjetasCreditosConstantesFunciones.getTiposSeleccionarTarjetasCreditos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTarjetasCreditos(Boolean conFk) throws Exception  {
		return TarjetasCreditosConstantesFunciones.getTiposSeleccionarTarjetasCreditos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTarjetasCreditos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetasCreditosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TarjetasCreditosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetasCreditosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(TarjetasCreditosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetasCreditosConstantesFunciones.LABEL_IDTARJETACREDITO);
			reporte.setsDescripcion(TarjetasCreditosConstantesFunciones.LABEL_IDTARJETACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetasCreditosConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(TarjetasCreditosConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetasCreditosConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(TarjetasCreditosConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetasCreditosConstantesFunciones.LABEL_NOMBRETARJETA);
			reporte.setsDescripcion(TarjetasCreditosConstantesFunciones.LABEL_NOMBRETARJETA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetasCreditosConstantesFunciones.LABEL_LOTE);
			reporte.setsDescripcion(TarjetasCreditosConstantesFunciones.LABEL_LOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetasCreditosConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(TarjetasCreditosConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetasCreditosConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(TarjetasCreditosConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTarjetasCreditos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTarjetasCreditos(TarjetasCreditos tarjetascreditosAux) throws Exception {
		
			tarjetascreditosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tarjetascreditosAux.getEmpresa()));
			tarjetascreditosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(tarjetascreditosAux.getSucursal()));
			tarjetascreditosAux.settarjetacredito_descripcion(TarjetaCreditoConstantesFunciones.getTarjetaCreditoDescripcion(tarjetascreditosAux.getTarjetaCredito()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTarjetasCreditos(List<TarjetasCreditos> tarjetascreditossTemp) throws Exception {
		for(TarjetasCreditos tarjetascreditosAux:tarjetascreditossTemp) {
			
			tarjetascreditosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tarjetascreditosAux.getEmpresa()));
			tarjetascreditosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(tarjetascreditosAux.getSucursal()));
			tarjetascreditosAux.settarjetacredito_descripcion(TarjetaCreditoConstantesFunciones.getTarjetaCreditoDescripcion(tarjetascreditosAux.getTarjetaCredito()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTarjetasCreditos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(TarjetaCredito.class));
				
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTarjetasCreditos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTarjetasCreditos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TarjetasCreditosConstantesFunciones.getClassesRelationshipsOfTarjetasCreditos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTarjetasCreditos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTarjetasCreditos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TarjetasCreditosConstantesFunciones.getClassesRelationshipsFromStringsOfTarjetasCreditos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTarjetasCreditos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TarjetasCreditos tarjetascreditos,List<TarjetasCreditos> tarjetascreditoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(TarjetasCreditos tarjetascreditos,List<TarjetasCreditos> tarjetascreditoss) throws Exception {
		try	{			
			for(TarjetasCreditos tarjetascreditosLocal:tarjetascreditoss) {
				if(tarjetascreditosLocal.getId().equals(tarjetascreditos.getId())) {
					tarjetascreditosLocal.setIsSelected(tarjetascreditos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTarjetasCreditos(List<TarjetasCreditos> tarjetascreditossAux) throws Exception {
		//this.tarjetascreditossAux=tarjetascreditossAux;
		
		for(TarjetasCreditos tarjetascreditosAux:tarjetascreditossAux) {
			if(tarjetascreditosAux.getIsChanged()) {
				tarjetascreditosAux.setIsChanged(false);
			}		
			
			if(tarjetascreditosAux.getIsNew()) {
				tarjetascreditosAux.setIsNew(false);
			}	
			
			if(tarjetascreditosAux.getIsDeleted()) {
				tarjetascreditosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTarjetasCreditos(TarjetasCreditos tarjetascreditosAux) throws Exception {
		//this.tarjetascreditosAux=tarjetascreditosAux;
		
			if(tarjetascreditosAux.getIsChanged()) {
				tarjetascreditosAux.setIsChanged(false);
			}		
			
			if(tarjetascreditosAux.getIsNew()) {
				tarjetascreditosAux.setIsNew(false);
			}	
			
			if(tarjetascreditosAux.getIsDeleted()) {
				tarjetascreditosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TarjetasCreditos tarjetascreditosAsignar,TarjetasCreditos tarjetascreditos) throws Exception {
		tarjetascreditosAsignar.setId(tarjetascreditos.getId());	
		tarjetascreditosAsignar.setVersionRow(tarjetascreditos.getVersionRow());	
		tarjetascreditosAsignar.setid_tarjeta_credito(tarjetascreditos.getid_tarjeta_credito());
		tarjetascreditosAsignar.settarjetacredito_descripcion(tarjetascreditos.gettarjetacredito_descripcion());	
		tarjetascreditosAsignar.setnombre_tarjeta(tarjetascreditos.getnombre_tarjeta());	
		tarjetascreditosAsignar.setlote(tarjetascreditos.getlote());	
		tarjetascreditosAsignar.setfecha(tarjetascreditos.getfecha());	
		tarjetascreditosAsignar.settotal(tarjetascreditos.gettotal());	
	}
	
	public static void inicializarTarjetasCreditos(TarjetasCreditos tarjetascreditos) throws Exception {
		try {
				tarjetascreditos.setId(0L);	
					
				tarjetascreditos.setid_tarjeta_credito(-1L);	
				tarjetascreditos.setnombre_tarjeta("");	
				tarjetascreditos.setlote("");	
				tarjetascreditos.setfecha(new Date());	
				tarjetascreditos.settotal(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTarjetasCreditos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetasCreditosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetasCreditosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetasCreditosConstantesFunciones.LABEL_IDTARJETACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetasCreditosConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetasCreditosConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetasCreditosConstantesFunciones.LABEL_NOMBRETARJETA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetasCreditosConstantesFunciones.LABEL_LOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetasCreditosConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetasCreditosConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTarjetasCreditos(String sTipo,Row row,Workbook workbook,TarjetasCreditos tarjetascreditos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetascreditos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetascreditos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetascreditos.gettarjetacredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetascreditos.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetascreditos.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetascreditos.getnombre_tarjeta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetascreditos.getlote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetascreditos.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetascreditos.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTarjetasCreditos="";
	
	public String getsFinalQueryTarjetasCreditos() {
		return this.sFinalQueryTarjetasCreditos;
	}
	
	public void setsFinalQueryTarjetasCreditos(String sFinalQueryTarjetasCreditos) {
		this.sFinalQueryTarjetasCreditos= sFinalQueryTarjetasCreditos;
	}
	
	public Border resaltarSeleccionarTarjetasCreditos=null;
	
	public Border setResaltarSeleccionarTarjetasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetasCreditosBeanSwingJInternalFrame tarjetascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tarjetascreditosBeanSwingJInternalFrame.jTtoolBarTarjetasCreditos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTarjetasCreditos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTarjetasCreditos() {
		return this.resaltarSeleccionarTarjetasCreditos;
	}
	
	public void setResaltarSeleccionarTarjetasCreditos(Border borderResaltarSeleccionarTarjetasCreditos) {
		this.resaltarSeleccionarTarjetasCreditos= borderResaltarSeleccionarTarjetasCreditos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTarjetasCreditos=null;
	public Boolean mostraridTarjetasCreditos=true;
	public Boolean activaridTarjetasCreditos=true;

	public Border resaltarid_empresaTarjetasCreditos=null;
	public Boolean mostrarid_empresaTarjetasCreditos=true;
	public Boolean activarid_empresaTarjetasCreditos=true;
	public Boolean cargarid_empresaTarjetasCreditos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTarjetasCreditos=false;//ConEventDepend=true

	public Border resaltarid_sucursalTarjetasCreditos=null;
	public Boolean mostrarid_sucursalTarjetasCreditos=true;
	public Boolean activarid_sucursalTarjetasCreditos=true;
	public Boolean cargarid_sucursalTarjetasCreditos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalTarjetasCreditos=false;//ConEventDepend=true

	public Border resaltarid_tarjeta_creditoTarjetasCreditos=null;
	public Boolean mostrarid_tarjeta_creditoTarjetasCreditos=true;
	public Boolean activarid_tarjeta_creditoTarjetasCreditos=false;
	public Boolean cargarid_tarjeta_creditoTarjetasCreditos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tarjeta_creditoTarjetasCreditos=false;//ConEventDepend=true

	public Border resaltarfecha_inicioTarjetasCreditos=null;
	public Boolean mostrarfecha_inicioTarjetasCreditos=true;
	public Boolean activarfecha_inicioTarjetasCreditos=true;

	public Border resaltarfecha_finTarjetasCreditos=null;
	public Boolean mostrarfecha_finTarjetasCreditos=true;
	public Boolean activarfecha_finTarjetasCreditos=true;

	public Border resaltarnombre_tarjetaTarjetasCreditos=null;
	public Boolean mostrarnombre_tarjetaTarjetasCreditos=true;
	public Boolean activarnombre_tarjetaTarjetasCreditos=true;

	public Border resaltarloteTarjetasCreditos=null;
	public Boolean mostrarloteTarjetasCreditos=true;
	public Boolean activarloteTarjetasCreditos=true;

	public Border resaltarfechaTarjetasCreditos=null;
	public Boolean mostrarfechaTarjetasCreditos=true;
	public Boolean activarfechaTarjetasCreditos=true;

	public Border resaltartotalTarjetasCreditos=null;
	public Boolean mostrartotalTarjetasCreditos=true;
	public Boolean activartotalTarjetasCreditos=true;

	
	

	public Border setResaltaridTarjetasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetasCreditosBeanSwingJInternalFrame tarjetascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetascreditosBeanSwingJInternalFrame.jTtoolBarTarjetasCreditos.setBorder(borderResaltar);
		
		this.resaltaridTarjetasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTarjetasCreditos() {
		return this.resaltaridTarjetasCreditos;
	}

	public void setResaltaridTarjetasCreditos(Border borderResaltar) {
		this.resaltaridTarjetasCreditos= borderResaltar;
	}

	public Boolean getMostraridTarjetasCreditos() {
		return this.mostraridTarjetasCreditos;
	}

	public void setMostraridTarjetasCreditos(Boolean mostraridTarjetasCreditos) {
		this.mostraridTarjetasCreditos= mostraridTarjetasCreditos;
	}

	public Boolean getActivaridTarjetasCreditos() {
		return this.activaridTarjetasCreditos;
	}

	public void setActivaridTarjetasCreditos(Boolean activaridTarjetasCreditos) {
		this.activaridTarjetasCreditos= activaridTarjetasCreditos;
	}

	public Border setResaltarid_empresaTarjetasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetasCreditosBeanSwingJInternalFrame tarjetascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetascreditosBeanSwingJInternalFrame.jTtoolBarTarjetasCreditos.setBorder(borderResaltar);
		
		this.resaltarid_empresaTarjetasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTarjetasCreditos() {
		return this.resaltarid_empresaTarjetasCreditos;
	}

	public void setResaltarid_empresaTarjetasCreditos(Border borderResaltar) {
		this.resaltarid_empresaTarjetasCreditos= borderResaltar;
	}

	public Boolean getMostrarid_empresaTarjetasCreditos() {
		return this.mostrarid_empresaTarjetasCreditos;
	}

	public void setMostrarid_empresaTarjetasCreditos(Boolean mostrarid_empresaTarjetasCreditos) {
		this.mostrarid_empresaTarjetasCreditos= mostrarid_empresaTarjetasCreditos;
	}

	public Boolean getActivarid_empresaTarjetasCreditos() {
		return this.activarid_empresaTarjetasCreditos;
	}

	public void setActivarid_empresaTarjetasCreditos(Boolean activarid_empresaTarjetasCreditos) {
		this.activarid_empresaTarjetasCreditos= activarid_empresaTarjetasCreditos;
	}

	public Boolean getCargarid_empresaTarjetasCreditos() {
		return this.cargarid_empresaTarjetasCreditos;
	}

	public void setCargarid_empresaTarjetasCreditos(Boolean cargarid_empresaTarjetasCreditos) {
		this.cargarid_empresaTarjetasCreditos= cargarid_empresaTarjetasCreditos;
	}

	public Border setResaltarid_sucursalTarjetasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetasCreditosBeanSwingJInternalFrame tarjetascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetascreditosBeanSwingJInternalFrame.jTtoolBarTarjetasCreditos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalTarjetasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalTarjetasCreditos() {
		return this.resaltarid_sucursalTarjetasCreditos;
	}

	public void setResaltarid_sucursalTarjetasCreditos(Border borderResaltar) {
		this.resaltarid_sucursalTarjetasCreditos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalTarjetasCreditos() {
		return this.mostrarid_sucursalTarjetasCreditos;
	}

	public void setMostrarid_sucursalTarjetasCreditos(Boolean mostrarid_sucursalTarjetasCreditos) {
		this.mostrarid_sucursalTarjetasCreditos= mostrarid_sucursalTarjetasCreditos;
	}

	public Boolean getActivarid_sucursalTarjetasCreditos() {
		return this.activarid_sucursalTarjetasCreditos;
	}

	public void setActivarid_sucursalTarjetasCreditos(Boolean activarid_sucursalTarjetasCreditos) {
		this.activarid_sucursalTarjetasCreditos= activarid_sucursalTarjetasCreditos;
	}

	public Boolean getCargarid_sucursalTarjetasCreditos() {
		return this.cargarid_sucursalTarjetasCreditos;
	}

	public void setCargarid_sucursalTarjetasCreditos(Boolean cargarid_sucursalTarjetasCreditos) {
		this.cargarid_sucursalTarjetasCreditos= cargarid_sucursalTarjetasCreditos;
	}

	public Border setResaltarid_tarjeta_creditoTarjetasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetasCreditosBeanSwingJInternalFrame tarjetascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetascreditosBeanSwingJInternalFrame.jTtoolBarTarjetasCreditos.setBorder(borderResaltar);
		
		this.resaltarid_tarjeta_creditoTarjetasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tarjeta_creditoTarjetasCreditos() {
		return this.resaltarid_tarjeta_creditoTarjetasCreditos;
	}

	public void setResaltarid_tarjeta_creditoTarjetasCreditos(Border borderResaltar) {
		this.resaltarid_tarjeta_creditoTarjetasCreditos= borderResaltar;
	}

	public Boolean getMostrarid_tarjeta_creditoTarjetasCreditos() {
		return this.mostrarid_tarjeta_creditoTarjetasCreditos;
	}

	public void setMostrarid_tarjeta_creditoTarjetasCreditos(Boolean mostrarid_tarjeta_creditoTarjetasCreditos) {
		this.mostrarid_tarjeta_creditoTarjetasCreditos= mostrarid_tarjeta_creditoTarjetasCreditos;
	}

	public Boolean getActivarid_tarjeta_creditoTarjetasCreditos() {
		return this.activarid_tarjeta_creditoTarjetasCreditos;
	}

	public void setActivarid_tarjeta_creditoTarjetasCreditos(Boolean activarid_tarjeta_creditoTarjetasCreditos) {
		this.activarid_tarjeta_creditoTarjetasCreditos= activarid_tarjeta_creditoTarjetasCreditos;
	}

	public Boolean getCargarid_tarjeta_creditoTarjetasCreditos() {
		return this.cargarid_tarjeta_creditoTarjetasCreditos;
	}

	public void setCargarid_tarjeta_creditoTarjetasCreditos(Boolean cargarid_tarjeta_creditoTarjetasCreditos) {
		this.cargarid_tarjeta_creditoTarjetasCreditos= cargarid_tarjeta_creditoTarjetasCreditos;
	}

	public Border setResaltarfecha_inicioTarjetasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetasCreditosBeanSwingJInternalFrame tarjetascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetascreditosBeanSwingJInternalFrame.jTtoolBarTarjetasCreditos.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioTarjetasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioTarjetasCreditos() {
		return this.resaltarfecha_inicioTarjetasCreditos;
	}

	public void setResaltarfecha_inicioTarjetasCreditos(Border borderResaltar) {
		this.resaltarfecha_inicioTarjetasCreditos= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioTarjetasCreditos() {
		return this.mostrarfecha_inicioTarjetasCreditos;
	}

	public void setMostrarfecha_inicioTarjetasCreditos(Boolean mostrarfecha_inicioTarjetasCreditos) {
		this.mostrarfecha_inicioTarjetasCreditos= mostrarfecha_inicioTarjetasCreditos;
	}

	public Boolean getActivarfecha_inicioTarjetasCreditos() {
		return this.activarfecha_inicioTarjetasCreditos;
	}

	public void setActivarfecha_inicioTarjetasCreditos(Boolean activarfecha_inicioTarjetasCreditos) {
		this.activarfecha_inicioTarjetasCreditos= activarfecha_inicioTarjetasCreditos;
	}

	public Border setResaltarfecha_finTarjetasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetasCreditosBeanSwingJInternalFrame tarjetascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetascreditosBeanSwingJInternalFrame.jTtoolBarTarjetasCreditos.setBorder(borderResaltar);
		
		this.resaltarfecha_finTarjetasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finTarjetasCreditos() {
		return this.resaltarfecha_finTarjetasCreditos;
	}

	public void setResaltarfecha_finTarjetasCreditos(Border borderResaltar) {
		this.resaltarfecha_finTarjetasCreditos= borderResaltar;
	}

	public Boolean getMostrarfecha_finTarjetasCreditos() {
		return this.mostrarfecha_finTarjetasCreditos;
	}

	public void setMostrarfecha_finTarjetasCreditos(Boolean mostrarfecha_finTarjetasCreditos) {
		this.mostrarfecha_finTarjetasCreditos= mostrarfecha_finTarjetasCreditos;
	}

	public Boolean getActivarfecha_finTarjetasCreditos() {
		return this.activarfecha_finTarjetasCreditos;
	}

	public void setActivarfecha_finTarjetasCreditos(Boolean activarfecha_finTarjetasCreditos) {
		this.activarfecha_finTarjetasCreditos= activarfecha_finTarjetasCreditos;
	}

	public Border setResaltarnombre_tarjetaTarjetasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetasCreditosBeanSwingJInternalFrame tarjetascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetascreditosBeanSwingJInternalFrame.jTtoolBarTarjetasCreditos.setBorder(borderResaltar);
		
		this.resaltarnombre_tarjetaTarjetasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tarjetaTarjetasCreditos() {
		return this.resaltarnombre_tarjetaTarjetasCreditos;
	}

	public void setResaltarnombre_tarjetaTarjetasCreditos(Border borderResaltar) {
		this.resaltarnombre_tarjetaTarjetasCreditos= borderResaltar;
	}

	public Boolean getMostrarnombre_tarjetaTarjetasCreditos() {
		return this.mostrarnombre_tarjetaTarjetasCreditos;
	}

	public void setMostrarnombre_tarjetaTarjetasCreditos(Boolean mostrarnombre_tarjetaTarjetasCreditos) {
		this.mostrarnombre_tarjetaTarjetasCreditos= mostrarnombre_tarjetaTarjetasCreditos;
	}

	public Boolean getActivarnombre_tarjetaTarjetasCreditos() {
		return this.activarnombre_tarjetaTarjetasCreditos;
	}

	public void setActivarnombre_tarjetaTarjetasCreditos(Boolean activarnombre_tarjetaTarjetasCreditos) {
		this.activarnombre_tarjetaTarjetasCreditos= activarnombre_tarjetaTarjetasCreditos;
	}

	public Border setResaltarloteTarjetasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetasCreditosBeanSwingJInternalFrame tarjetascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetascreditosBeanSwingJInternalFrame.jTtoolBarTarjetasCreditos.setBorder(borderResaltar);
		
		this.resaltarloteTarjetasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarloteTarjetasCreditos() {
		return this.resaltarloteTarjetasCreditos;
	}

	public void setResaltarloteTarjetasCreditos(Border borderResaltar) {
		this.resaltarloteTarjetasCreditos= borderResaltar;
	}

	public Boolean getMostrarloteTarjetasCreditos() {
		return this.mostrarloteTarjetasCreditos;
	}

	public void setMostrarloteTarjetasCreditos(Boolean mostrarloteTarjetasCreditos) {
		this.mostrarloteTarjetasCreditos= mostrarloteTarjetasCreditos;
	}

	public Boolean getActivarloteTarjetasCreditos() {
		return this.activarloteTarjetasCreditos;
	}

	public void setActivarloteTarjetasCreditos(Boolean activarloteTarjetasCreditos) {
		this.activarloteTarjetasCreditos= activarloteTarjetasCreditos;
	}

	public Border setResaltarfechaTarjetasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetasCreditosBeanSwingJInternalFrame tarjetascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetascreditosBeanSwingJInternalFrame.jTtoolBarTarjetasCreditos.setBorder(borderResaltar);
		
		this.resaltarfechaTarjetasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaTarjetasCreditos() {
		return this.resaltarfechaTarjetasCreditos;
	}

	public void setResaltarfechaTarjetasCreditos(Border borderResaltar) {
		this.resaltarfechaTarjetasCreditos= borderResaltar;
	}

	public Boolean getMostrarfechaTarjetasCreditos() {
		return this.mostrarfechaTarjetasCreditos;
	}

	public void setMostrarfechaTarjetasCreditos(Boolean mostrarfechaTarjetasCreditos) {
		this.mostrarfechaTarjetasCreditos= mostrarfechaTarjetasCreditos;
	}

	public Boolean getActivarfechaTarjetasCreditos() {
		return this.activarfechaTarjetasCreditos;
	}

	public void setActivarfechaTarjetasCreditos(Boolean activarfechaTarjetasCreditos) {
		this.activarfechaTarjetasCreditos= activarfechaTarjetasCreditos;
	}

	public Border setResaltartotalTarjetasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetasCreditosBeanSwingJInternalFrame tarjetascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetascreditosBeanSwingJInternalFrame.jTtoolBarTarjetasCreditos.setBorder(borderResaltar);
		
		this.resaltartotalTarjetasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalTarjetasCreditos() {
		return this.resaltartotalTarjetasCreditos;
	}

	public void setResaltartotalTarjetasCreditos(Border borderResaltar) {
		this.resaltartotalTarjetasCreditos= borderResaltar;
	}

	public Boolean getMostrartotalTarjetasCreditos() {
		return this.mostrartotalTarjetasCreditos;
	}

	public void setMostrartotalTarjetasCreditos(Boolean mostrartotalTarjetasCreditos) {
		this.mostrartotalTarjetasCreditos= mostrartotalTarjetasCreditos;
	}

	public Boolean getActivartotalTarjetasCreditos() {
		return this.activartotalTarjetasCreditos;
	}

	public void setActivartotalTarjetasCreditos(Boolean activartotalTarjetasCreditos) {
		this.activartotalTarjetasCreditos= activartotalTarjetasCreditos;
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
		
		
		this.setMostraridTarjetasCreditos(esInicial);
		this.setMostrarid_empresaTarjetasCreditos(esInicial);
		this.setMostrarid_sucursalTarjetasCreditos(esInicial);
		this.setMostrarid_tarjeta_creditoTarjetasCreditos(esInicial);
		this.setMostrarfecha_inicioTarjetasCreditos(esInicial);
		this.setMostrarfecha_finTarjetasCreditos(esInicial);
		this.setMostrarnombre_tarjetaTarjetasCreditos(esInicial);
		this.setMostrarloteTarjetasCreditos(esInicial);
		this.setMostrarfechaTarjetasCreditos(esInicial);
		this.setMostrartotalTarjetasCreditos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.ID)) {
				this.setMostraridTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.IDTARJETACREDITO)) {
				this.setMostrarid_tarjeta_creditoTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.NOMBRETARJETA)) {
				this.setMostrarnombre_tarjetaTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.LOTE)) {
				this.setMostrarloteTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.FECHA)) {
				this.setMostrarfechaTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.TOTAL)) {
				this.setMostrartotalTarjetasCreditos(esAsigna);
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
		
		
		this.setActivaridTarjetasCreditos(esInicial);
		this.setActivarid_empresaTarjetasCreditos(esInicial);
		this.setActivarid_sucursalTarjetasCreditos(esInicial);
		this.setActivarid_tarjeta_creditoTarjetasCreditos(esInicial);
		this.setActivarfecha_inicioTarjetasCreditos(esInicial);
		this.setActivarfecha_finTarjetasCreditos(esInicial);
		this.setActivarnombre_tarjetaTarjetasCreditos(esInicial);
		this.setActivarloteTarjetasCreditos(esInicial);
		this.setActivarfechaTarjetasCreditos(esInicial);
		this.setActivartotalTarjetasCreditos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.ID)) {
				this.setActivaridTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.IDTARJETACREDITO)) {
				this.setActivarid_tarjeta_creditoTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.NOMBRETARJETA)) {
				this.setActivarnombre_tarjetaTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.LOTE)) {
				this.setActivarloteTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.FECHA)) {
				this.setActivarfechaTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.TOTAL)) {
				this.setActivartotalTarjetasCreditos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TarjetasCreditosBeanSwingJInternalFrame tarjetascreditosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTarjetasCreditos(esInicial);
		this.setResaltarid_empresaTarjetasCreditos(esInicial);
		this.setResaltarid_sucursalTarjetasCreditos(esInicial);
		this.setResaltarid_tarjeta_creditoTarjetasCreditos(esInicial);
		this.setResaltarfecha_inicioTarjetasCreditos(esInicial);
		this.setResaltarfecha_finTarjetasCreditos(esInicial);
		this.setResaltarnombre_tarjetaTarjetasCreditos(esInicial);
		this.setResaltarloteTarjetasCreditos(esInicial);
		this.setResaltarfechaTarjetasCreditos(esInicial);
		this.setResaltartotalTarjetasCreditos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.ID)) {
				this.setResaltaridTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.IDTARJETACREDITO)) {
				this.setResaltarid_tarjeta_creditoTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.NOMBRETARJETA)) {
				this.setResaltarnombre_tarjetaTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.LOTE)) {
				this.setResaltarloteTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.FECHA)) {
				this.setResaltarfechaTarjetasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetasCreditosConstantesFunciones.TOTAL)) {
				this.setResaltartotalTarjetasCreditos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TarjetasCreditosBeanSwingJInternalFrame tarjetascreditosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaTarjetaCreditoTarjetasCreditos=true;

	public Boolean getMostrarBusquedaTarjetaCreditoTarjetasCreditos() {
		return this.mostrarBusquedaTarjetaCreditoTarjetasCreditos;
	}

	public void setMostrarBusquedaTarjetaCreditoTarjetasCreditos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaTarjetaCreditoTarjetasCreditos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaTarjetaCreditoTarjetasCreditos=true;

	public Boolean getActivarBusquedaTarjetaCreditoTarjetasCreditos() {
		return this.activarBusquedaTarjetaCreditoTarjetasCreditos;
	}

	public void setActivarBusquedaTarjetaCreditoTarjetasCreditos(Boolean habilitarResaltar) {
		this.activarBusquedaTarjetaCreditoTarjetasCreditos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaTarjetaCreditoTarjetasCreditos=null;

	public Border getResaltarBusquedaTarjetaCreditoTarjetasCreditos() {
		return this.resaltarBusquedaTarjetaCreditoTarjetasCreditos;
	}

	public void setResaltarBusquedaTarjetaCreditoTarjetasCreditos(Border borderResaltar) {
		this.resaltarBusquedaTarjetaCreditoTarjetasCreditos= borderResaltar;
	}

	public void setResaltarBusquedaTarjetaCreditoTarjetasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetasCreditosBeanSwingJInternalFrame tarjetascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaTarjetaCreditoTarjetasCreditos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}