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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.ControlVehiculoConstantesFunciones;
import com.bydan.erp.inventario.util.ControlVehiculoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ControlVehiculoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ControlVehiculoConstantesFunciones extends ControlVehiculoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ControlVehiculo";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ControlVehiculo"+ControlVehiculoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ControlVehiculoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ControlVehiculoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ControlVehiculoConstantesFunciones.SCHEMA+"_"+ControlVehiculoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ControlVehiculoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ControlVehiculoConstantesFunciones.SCHEMA+"_"+ControlVehiculoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ControlVehiculoConstantesFunciones.SCHEMA+"_"+ControlVehiculoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ControlVehiculoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ControlVehiculoConstantesFunciones.SCHEMA+"_"+ControlVehiculoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ControlVehiculoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ControlVehiculoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ControlVehiculoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ControlVehiculoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ControlVehiculoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ControlVehiculoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ControlVehiculoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ControlVehiculoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ControlVehiculoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ControlVehiculoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Control Vehiculoes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Control Vehiculo";
	public static final String SCLASSWEBTITULO_LOWER="Control Vehiculo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ControlVehiculo";
	public static final String OBJECTNAME="controlvehiculo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="control_vehiculo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select controlvehiculo from "+ControlVehiculoConstantesFunciones.SPERSISTENCENAME+" controlvehiculo";
	public static String QUERYSELECTNATIVE="select "+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME+".id,"+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME+".version_row,"+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME+".id_empresa,"+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME+".nombre_conductor,"+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME+".numero_placa,"+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME+".fecha_entrada,"+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME+".fecha_salida from "+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME;//+" as "+ControlVehiculoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ControlVehiculoConstantesFuncionesAdditional controlvehiculoConstantesFuncionesAdditional=null;
	
	public ControlVehiculoConstantesFuncionesAdditional getControlVehiculoConstantesFuncionesAdditional() {
		return this.controlvehiculoConstantesFuncionesAdditional;
	}
	
	public void setControlVehiculoConstantesFuncionesAdditional(ControlVehiculoConstantesFuncionesAdditional controlvehiculoConstantesFuncionesAdditional) {
		try {
			this.controlvehiculoConstantesFuncionesAdditional=controlvehiculoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRECONDUCTOR= "nombre_conductor";
    public static final String NUMEROPLACA= "numero_placa";
    public static final String FECHAENTRADA= "fecha_entrada";
    public static final String FECHASALIDA= "fecha_salida";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRECONDUCTOR= "Nombre Conductor";
		public static final String LABEL_NOMBRECONDUCTOR_LOWER= "Nombre Conductor";
    	public static final String LABEL_NUMEROPLACA= "Numero_placa";
		public static final String LABEL_NUMEROPLACA_LOWER= "Numero Placa";
    	public static final String LABEL_FECHAENTRADA= "Fecha Entrada";
		public static final String LABEL_FECHAENTRADA_LOWER= "Fecha Entrada";
    	public static final String LABEL_FECHASALIDA= "Fecha Salida";
		public static final String LABEL_FECHASALIDA_LOWER= "Fecha Salida";
	
		
		
		
	public static final String SREGEXNOMBRE_CONDUCTOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CONDUCTOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_PLACA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PLACA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getControlVehiculoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ControlVehiculoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ControlVehiculoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ControlVehiculoConstantesFunciones.NOMBRECONDUCTOR)) {sLabelColumna=ControlVehiculoConstantesFunciones.LABEL_NOMBRECONDUCTOR;}
		if(sNombreColumna.equals(ControlVehiculoConstantesFunciones.NUMEROPLACA)) {sLabelColumna=ControlVehiculoConstantesFunciones.LABEL_NUMEROPLACA;}
		if(sNombreColumna.equals(ControlVehiculoConstantesFunciones.FECHAENTRADA)) {sLabelColumna=ControlVehiculoConstantesFunciones.LABEL_FECHAENTRADA;}
		if(sNombreColumna.equals(ControlVehiculoConstantesFunciones.FECHASALIDA)) {sLabelColumna=ControlVehiculoConstantesFunciones.LABEL_FECHASALIDA;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getControlVehiculoDescripcion(ControlVehiculo controlvehiculo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(controlvehiculo !=null/* && controlvehiculo.getId()!=0*/) {
			sDescripcion=controlvehiculo.getnumero_placa();//controlvehiculocontrolvehiculo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getControlVehiculoDescripcionDetallado(ControlVehiculo controlvehiculo) {
		String sDescripcion="";
			
		sDescripcion+=ControlVehiculoConstantesFunciones.ID+"=";
		sDescripcion+=controlvehiculo.getId().toString()+",";
		sDescripcion+=ControlVehiculoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=controlvehiculo.getVersionRow().toString()+",";
		sDescripcion+=ControlVehiculoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=controlvehiculo.getid_empresa().toString()+",";
		sDescripcion+=ControlVehiculoConstantesFunciones.NOMBRECONDUCTOR+"=";
		sDescripcion+=controlvehiculo.getnombre_conductor()+",";
		sDescripcion+=ControlVehiculoConstantesFunciones.NUMEROPLACA+"=";
		sDescripcion+=controlvehiculo.getnumero_placa()+",";
		sDescripcion+=ControlVehiculoConstantesFunciones.FECHAENTRADA+"=";
		sDescripcion+=controlvehiculo.getfecha_entrada().toString()+",";
		sDescripcion+=ControlVehiculoConstantesFunciones.FECHASALIDA+"=";
		sDescripcion+=controlvehiculo.getfecha_salida().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setControlVehiculoDescripcion(ControlVehiculo controlvehiculo,String sValor) throws Exception {			
		if(controlvehiculo !=null) {
			controlvehiculo.setnumero_placa(sValor);//controlvehiculocontrolvehiculo.getId().toString();
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
		} else if(sNombreIndice.equals("BusquedaPorFechaEntrada")) {
			sNombreIndice="Tipo=  Por Fecha Entrada";
		} else if(sNombreIndice.equals("BusquedaPorFechaSalida")) {
			sNombreIndice="Tipo=  Por Fecha Salida";
		} else if(sNombreIndice.equals("BusquedaPorNombreConductor")) {
			sNombreIndice="Tipo=  Por Nombre Conductor";
		} else if(sNombreIndice.equals("BusquedaPorNumeroPlaca")) {
			sNombreIndice="Tipo=  Por Numero_placa";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorFechaEntrada(Date fecha_entrada) {
		String sDetalleIndice=" Parametros->";
		if(fecha_entrada!=null) {sDetalleIndice+=" Fecha Entrada="+fecha_entrada.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorFechaSalida(Date fecha_salida) {
		String sDetalleIndice=" Parametros->";
		if(fecha_salida!=null) {sDetalleIndice+=" Fecha Salida="+fecha_salida.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombreConductor(String nombre_conductor) {
		String sDetalleIndice=" Parametros->";
		if(nombre_conductor!=null) {sDetalleIndice+=" Nombre Conductor="+nombre_conductor;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNumeroPlaca(String numero_placa) {
		String sDetalleIndice=" Parametros->";
		if(numero_placa!=null) {sDetalleIndice+=" Numero_placa="+numero_placa;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosControlVehiculo(ControlVehiculo controlvehiculo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		controlvehiculo.setnombre_conductor(controlvehiculo.getnombre_conductor().trim());
		controlvehiculo.setnumero_placa(controlvehiculo.getnumero_placa().trim());
	}
	
	public static void quitarEspaciosControlVehiculos(List<ControlVehiculo> controlvehiculos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ControlVehiculo controlvehiculo: controlvehiculos) {
			controlvehiculo.setnombre_conductor(controlvehiculo.getnombre_conductor().trim());
			controlvehiculo.setnumero_placa(controlvehiculo.getnumero_placa().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresControlVehiculo(ControlVehiculo controlvehiculo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && controlvehiculo.getConCambioAuxiliar()) {
			controlvehiculo.setIsDeleted(controlvehiculo.getIsDeletedAuxiliar());	
			controlvehiculo.setIsNew(controlvehiculo.getIsNewAuxiliar());	
			controlvehiculo.setIsChanged(controlvehiculo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			controlvehiculo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			controlvehiculo.setIsDeletedAuxiliar(false);	
			controlvehiculo.setIsNewAuxiliar(false);	
			controlvehiculo.setIsChangedAuxiliar(false);
			
			controlvehiculo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresControlVehiculos(List<ControlVehiculo> controlvehiculos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ControlVehiculo controlvehiculo : controlvehiculos) {
			if(conAsignarBase && controlvehiculo.getConCambioAuxiliar()) {
				controlvehiculo.setIsDeleted(controlvehiculo.getIsDeletedAuxiliar());	
				controlvehiculo.setIsNew(controlvehiculo.getIsNewAuxiliar());	
				controlvehiculo.setIsChanged(controlvehiculo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				controlvehiculo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				controlvehiculo.setIsDeletedAuxiliar(false);	
				controlvehiculo.setIsNewAuxiliar(false);	
				controlvehiculo.setIsChangedAuxiliar(false);
				
				controlvehiculo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresControlVehiculo(ControlVehiculo controlvehiculo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresControlVehiculos(List<ControlVehiculo> controlvehiculos,Boolean conEnteros) throws Exception  {
		
		for(ControlVehiculo controlvehiculo: controlvehiculos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaControlVehiculo(List<ControlVehiculo> controlvehiculos,ControlVehiculo controlvehiculoAux) throws Exception  {
		ControlVehiculoConstantesFunciones.InicializarValoresControlVehiculo(controlvehiculoAux,true);
		
		for(ControlVehiculo controlvehiculo: controlvehiculos) {
			if(controlvehiculo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesControlVehiculo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ControlVehiculoConstantesFunciones.getArrayColumnasGlobalesControlVehiculo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesControlVehiculo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ControlVehiculoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ControlVehiculoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoControlVehiculo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ControlVehiculo> controlvehiculos,ControlVehiculo controlvehiculo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ControlVehiculo controlvehiculoAux: controlvehiculos) {
			if(controlvehiculoAux!=null && controlvehiculo!=null) {
				if((controlvehiculoAux.getId()==null && controlvehiculo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(controlvehiculoAux.getId()!=null && controlvehiculo.getId()!=null){
					if(controlvehiculoAux.getId().equals(controlvehiculo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaControlVehiculo(List<ControlVehiculo> controlvehiculos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ControlVehiculo controlvehiculo: controlvehiculos) {			
			if(controlvehiculo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaControlVehiculo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ControlVehiculoConstantesFunciones.LABEL_ID, ControlVehiculoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ControlVehiculoConstantesFunciones.LABEL_VERSIONROW, ControlVehiculoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ControlVehiculoConstantesFunciones.LABEL_IDEMPRESA, ControlVehiculoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ControlVehiculoConstantesFunciones.LABEL_NOMBRECONDUCTOR, ControlVehiculoConstantesFunciones.NOMBRECONDUCTOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ControlVehiculoConstantesFunciones.LABEL_NUMEROPLACA, ControlVehiculoConstantesFunciones.NUMEROPLACA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ControlVehiculoConstantesFunciones.LABEL_FECHAENTRADA, ControlVehiculoConstantesFunciones.FECHAENTRADA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ControlVehiculoConstantesFunciones.LABEL_FECHASALIDA, ControlVehiculoConstantesFunciones.FECHASALIDA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasControlVehiculo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ControlVehiculoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ControlVehiculoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ControlVehiculoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ControlVehiculoConstantesFunciones.NOMBRECONDUCTOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ControlVehiculoConstantesFunciones.NUMEROPLACA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ControlVehiculoConstantesFunciones.FECHAENTRADA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ControlVehiculoConstantesFunciones.FECHASALIDA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarControlVehiculo() throws Exception  {
		return ControlVehiculoConstantesFunciones.getTiposSeleccionarControlVehiculo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarControlVehiculo(Boolean conFk) throws Exception  {
		return ControlVehiculoConstantesFunciones.getTiposSeleccionarControlVehiculo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarControlVehiculo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ControlVehiculoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ControlVehiculoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ControlVehiculoConstantesFunciones.LABEL_NOMBRECONDUCTOR);
			reporte.setsDescripcion(ControlVehiculoConstantesFunciones.LABEL_NOMBRECONDUCTOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ControlVehiculoConstantesFunciones.LABEL_NUMEROPLACA);
			reporte.setsDescripcion(ControlVehiculoConstantesFunciones.LABEL_NUMEROPLACA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ControlVehiculoConstantesFunciones.LABEL_FECHAENTRADA);
			reporte.setsDescripcion(ControlVehiculoConstantesFunciones.LABEL_FECHAENTRADA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ControlVehiculoConstantesFunciones.LABEL_FECHASALIDA);
			reporte.setsDescripcion(ControlVehiculoConstantesFunciones.LABEL_FECHASALIDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesControlVehiculo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesControlVehiculo(ControlVehiculo controlvehiculoAux) throws Exception {
		
			controlvehiculoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(controlvehiculoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesControlVehiculo(List<ControlVehiculo> controlvehiculosTemp) throws Exception {
		for(ControlVehiculo controlvehiculoAux:controlvehiculosTemp) {
			
			controlvehiculoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(controlvehiculoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfControlVehiculo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfControlVehiculo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfControlVehiculo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ControlVehiculoConstantesFunciones.getClassesRelationshipsOfControlVehiculo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfControlVehiculo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfControlVehiculo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ControlVehiculoConstantesFunciones.getClassesRelationshipsFromStringsOfControlVehiculo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfControlVehiculo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ControlVehiculo controlvehiculo,List<ControlVehiculo> controlvehiculos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ControlVehiculo controlvehiculoEncontrado=null;
			
			for(ControlVehiculo controlvehiculoLocal:controlvehiculos) {
				if(controlvehiculoLocal.getId().equals(controlvehiculo.getId())) {
					controlvehiculoEncontrado=controlvehiculoLocal;
					
					controlvehiculoLocal.setIsChanged(controlvehiculo.getIsChanged());
					controlvehiculoLocal.setIsNew(controlvehiculo.getIsNew());
					controlvehiculoLocal.setIsDeleted(controlvehiculo.getIsDeleted());
					
					controlvehiculoLocal.setGeneralEntityOriginal(controlvehiculo.getGeneralEntityOriginal());
					
					controlvehiculoLocal.setId(controlvehiculo.getId());	
					controlvehiculoLocal.setVersionRow(controlvehiculo.getVersionRow());	
					controlvehiculoLocal.setid_empresa(controlvehiculo.getid_empresa());	
					controlvehiculoLocal.setnombre_conductor(controlvehiculo.getnombre_conductor());	
					controlvehiculoLocal.setnumero_placa(controlvehiculo.getnumero_placa());	
					controlvehiculoLocal.setfecha_entrada(controlvehiculo.getfecha_entrada());	
					controlvehiculoLocal.setfecha_salida(controlvehiculo.getfecha_salida());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!controlvehiculo.getIsDeleted()) {
				if(!existe) {
					controlvehiculos.add(controlvehiculo);
				}
			} else {
				if(controlvehiculoEncontrado!=null && permiteQuitar)  {
					controlvehiculos.remove(controlvehiculoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ControlVehiculo controlvehiculo,List<ControlVehiculo> controlvehiculos) throws Exception {
		try	{			
			for(ControlVehiculo controlvehiculoLocal:controlvehiculos) {
				if(controlvehiculoLocal.getId().equals(controlvehiculo.getId())) {
					controlvehiculoLocal.setIsSelected(controlvehiculo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesControlVehiculo(List<ControlVehiculo> controlvehiculosAux) throws Exception {
		//this.controlvehiculosAux=controlvehiculosAux;
		
		for(ControlVehiculo controlvehiculoAux:controlvehiculosAux) {
			if(controlvehiculoAux.getIsChanged()) {
				controlvehiculoAux.setIsChanged(false);
			}		
			
			if(controlvehiculoAux.getIsNew()) {
				controlvehiculoAux.setIsNew(false);
			}	
			
			if(controlvehiculoAux.getIsDeleted()) {
				controlvehiculoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesControlVehiculo(ControlVehiculo controlvehiculoAux) throws Exception {
		//this.controlvehiculoAux=controlvehiculoAux;
		
			if(controlvehiculoAux.getIsChanged()) {
				controlvehiculoAux.setIsChanged(false);
			}		
			
			if(controlvehiculoAux.getIsNew()) {
				controlvehiculoAux.setIsNew(false);
			}	
			
			if(controlvehiculoAux.getIsDeleted()) {
				controlvehiculoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ControlVehiculo controlvehiculoAsignar,ControlVehiculo controlvehiculo) throws Exception {
		controlvehiculoAsignar.setId(controlvehiculo.getId());	
		controlvehiculoAsignar.setVersionRow(controlvehiculo.getVersionRow());	
		controlvehiculoAsignar.setid_empresa(controlvehiculo.getid_empresa());
		controlvehiculoAsignar.setempresa_descripcion(controlvehiculo.getempresa_descripcion());	
		controlvehiculoAsignar.setnombre_conductor(controlvehiculo.getnombre_conductor());	
		controlvehiculoAsignar.setnumero_placa(controlvehiculo.getnumero_placa());	
		controlvehiculoAsignar.setfecha_entrada(controlvehiculo.getfecha_entrada());	
		controlvehiculoAsignar.setfecha_salida(controlvehiculo.getfecha_salida());	
	}
	
	public static void inicializarControlVehiculo(ControlVehiculo controlvehiculo) throws Exception {
		try {
				controlvehiculo.setId(0L);	
					
				controlvehiculo.setid_empresa(-1L);	
				controlvehiculo.setnombre_conductor("");	
				controlvehiculo.setnumero_placa("");	
				controlvehiculo.setfecha_entrada(new Date());	
				controlvehiculo.setfecha_salida(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderControlVehiculo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ControlVehiculoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ControlVehiculoConstantesFunciones.LABEL_NOMBRECONDUCTOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ControlVehiculoConstantesFunciones.LABEL_NUMEROPLACA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ControlVehiculoConstantesFunciones.LABEL_FECHAENTRADA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ControlVehiculoConstantesFunciones.LABEL_FECHASALIDA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataControlVehiculo(String sTipo,Row row,Workbook workbook,ControlVehiculo controlvehiculo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(controlvehiculo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(controlvehiculo.getnombre_conductor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(controlvehiculo.getnumero_placa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(controlvehiculo.getfecha_entrada());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(controlvehiculo.getfecha_salida());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryControlVehiculo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryControlVehiculo() {
		return this.sFinalQueryControlVehiculo;
	}
	
	public void setsFinalQueryControlVehiculo(String sFinalQueryControlVehiculo) {
		this.sFinalQueryControlVehiculo= sFinalQueryControlVehiculo;
	}
	
	public Border resaltarSeleccionarControlVehiculo=null;
	
	public Border setResaltarSeleccionarControlVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*ControlVehiculoBeanSwingJInternalFrame controlvehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//controlvehiculoBeanSwingJInternalFrame.jTtoolBarControlVehiculo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarControlVehiculo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarControlVehiculo() {
		return this.resaltarSeleccionarControlVehiculo;
	}
	
	public void setResaltarSeleccionarControlVehiculo(Border borderResaltarSeleccionarControlVehiculo) {
		this.resaltarSeleccionarControlVehiculo= borderResaltarSeleccionarControlVehiculo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridControlVehiculo=null;
	public Boolean mostraridControlVehiculo=true;
	public Boolean activaridControlVehiculo=true;

	public Border resaltarid_empresaControlVehiculo=null;
	public Boolean mostrarid_empresaControlVehiculo=true;
	public Boolean activarid_empresaControlVehiculo=true;
	public Boolean cargarid_empresaControlVehiculo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaControlVehiculo=false;//ConEventDepend=true

	public Border resaltarnombre_conductorControlVehiculo=null;
	public Boolean mostrarnombre_conductorControlVehiculo=true;
	public Boolean activarnombre_conductorControlVehiculo=true;

	public Border resaltarnumero_placaControlVehiculo=null;
	public Boolean mostrarnumero_placaControlVehiculo=true;
	public Boolean activarnumero_placaControlVehiculo=true;

	public Border resaltarfecha_entradaControlVehiculo=null;
	public Boolean mostrarfecha_entradaControlVehiculo=true;
	public Boolean activarfecha_entradaControlVehiculo=true;

	public Border resaltarfecha_salidaControlVehiculo=null;
	public Boolean mostrarfecha_salidaControlVehiculo=true;
	public Boolean activarfecha_salidaControlVehiculo=true;

	
	

	public Border setResaltaridControlVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*ControlVehiculoBeanSwingJInternalFrame controlvehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlvehiculoBeanSwingJInternalFrame.jTtoolBarControlVehiculo.setBorder(borderResaltar);
		
		this.resaltaridControlVehiculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridControlVehiculo() {
		return this.resaltaridControlVehiculo;
	}

	public void setResaltaridControlVehiculo(Border borderResaltar) {
		this.resaltaridControlVehiculo= borderResaltar;
	}

	public Boolean getMostraridControlVehiculo() {
		return this.mostraridControlVehiculo;
	}

	public void setMostraridControlVehiculo(Boolean mostraridControlVehiculo) {
		this.mostraridControlVehiculo= mostraridControlVehiculo;
	}

	public Boolean getActivaridControlVehiculo() {
		return this.activaridControlVehiculo;
	}

	public void setActivaridControlVehiculo(Boolean activaridControlVehiculo) {
		this.activaridControlVehiculo= activaridControlVehiculo;
	}

	public Border setResaltarid_empresaControlVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*ControlVehiculoBeanSwingJInternalFrame controlvehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlvehiculoBeanSwingJInternalFrame.jTtoolBarControlVehiculo.setBorder(borderResaltar);
		
		this.resaltarid_empresaControlVehiculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaControlVehiculo() {
		return this.resaltarid_empresaControlVehiculo;
	}

	public void setResaltarid_empresaControlVehiculo(Border borderResaltar) {
		this.resaltarid_empresaControlVehiculo= borderResaltar;
	}

	public Boolean getMostrarid_empresaControlVehiculo() {
		return this.mostrarid_empresaControlVehiculo;
	}

	public void setMostrarid_empresaControlVehiculo(Boolean mostrarid_empresaControlVehiculo) {
		this.mostrarid_empresaControlVehiculo= mostrarid_empresaControlVehiculo;
	}

	public Boolean getActivarid_empresaControlVehiculo() {
		return this.activarid_empresaControlVehiculo;
	}

	public void setActivarid_empresaControlVehiculo(Boolean activarid_empresaControlVehiculo) {
		this.activarid_empresaControlVehiculo= activarid_empresaControlVehiculo;
	}

	public Boolean getCargarid_empresaControlVehiculo() {
		return this.cargarid_empresaControlVehiculo;
	}

	public void setCargarid_empresaControlVehiculo(Boolean cargarid_empresaControlVehiculo) {
		this.cargarid_empresaControlVehiculo= cargarid_empresaControlVehiculo;
	}

	public Border setResaltarnombre_conductorControlVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*ControlVehiculoBeanSwingJInternalFrame controlvehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlvehiculoBeanSwingJInternalFrame.jTtoolBarControlVehiculo.setBorder(borderResaltar);
		
		this.resaltarnombre_conductorControlVehiculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_conductorControlVehiculo() {
		return this.resaltarnombre_conductorControlVehiculo;
	}

	public void setResaltarnombre_conductorControlVehiculo(Border borderResaltar) {
		this.resaltarnombre_conductorControlVehiculo= borderResaltar;
	}

	public Boolean getMostrarnombre_conductorControlVehiculo() {
		return this.mostrarnombre_conductorControlVehiculo;
	}

	public void setMostrarnombre_conductorControlVehiculo(Boolean mostrarnombre_conductorControlVehiculo) {
		this.mostrarnombre_conductorControlVehiculo= mostrarnombre_conductorControlVehiculo;
	}

	public Boolean getActivarnombre_conductorControlVehiculo() {
		return this.activarnombre_conductorControlVehiculo;
	}

	public void setActivarnombre_conductorControlVehiculo(Boolean activarnombre_conductorControlVehiculo) {
		this.activarnombre_conductorControlVehiculo= activarnombre_conductorControlVehiculo;
	}

	public Border setResaltarnumero_placaControlVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*ControlVehiculoBeanSwingJInternalFrame controlvehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlvehiculoBeanSwingJInternalFrame.jTtoolBarControlVehiculo.setBorder(borderResaltar);
		
		this.resaltarnumero_placaControlVehiculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_placaControlVehiculo() {
		return this.resaltarnumero_placaControlVehiculo;
	}

	public void setResaltarnumero_placaControlVehiculo(Border borderResaltar) {
		this.resaltarnumero_placaControlVehiculo= borderResaltar;
	}

	public Boolean getMostrarnumero_placaControlVehiculo() {
		return this.mostrarnumero_placaControlVehiculo;
	}

	public void setMostrarnumero_placaControlVehiculo(Boolean mostrarnumero_placaControlVehiculo) {
		this.mostrarnumero_placaControlVehiculo= mostrarnumero_placaControlVehiculo;
	}

	public Boolean getActivarnumero_placaControlVehiculo() {
		return this.activarnumero_placaControlVehiculo;
	}

	public void setActivarnumero_placaControlVehiculo(Boolean activarnumero_placaControlVehiculo) {
		this.activarnumero_placaControlVehiculo= activarnumero_placaControlVehiculo;
	}

	public Border setResaltarfecha_entradaControlVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*ControlVehiculoBeanSwingJInternalFrame controlvehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlvehiculoBeanSwingJInternalFrame.jTtoolBarControlVehiculo.setBorder(borderResaltar);
		
		this.resaltarfecha_entradaControlVehiculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_entradaControlVehiculo() {
		return this.resaltarfecha_entradaControlVehiculo;
	}

	public void setResaltarfecha_entradaControlVehiculo(Border borderResaltar) {
		this.resaltarfecha_entradaControlVehiculo= borderResaltar;
	}

	public Boolean getMostrarfecha_entradaControlVehiculo() {
		return this.mostrarfecha_entradaControlVehiculo;
	}

	public void setMostrarfecha_entradaControlVehiculo(Boolean mostrarfecha_entradaControlVehiculo) {
		this.mostrarfecha_entradaControlVehiculo= mostrarfecha_entradaControlVehiculo;
	}

	public Boolean getActivarfecha_entradaControlVehiculo() {
		return this.activarfecha_entradaControlVehiculo;
	}

	public void setActivarfecha_entradaControlVehiculo(Boolean activarfecha_entradaControlVehiculo) {
		this.activarfecha_entradaControlVehiculo= activarfecha_entradaControlVehiculo;
	}

	public Border setResaltarfecha_salidaControlVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*ControlVehiculoBeanSwingJInternalFrame controlvehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlvehiculoBeanSwingJInternalFrame.jTtoolBarControlVehiculo.setBorder(borderResaltar);
		
		this.resaltarfecha_salidaControlVehiculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_salidaControlVehiculo() {
		return this.resaltarfecha_salidaControlVehiculo;
	}

	public void setResaltarfecha_salidaControlVehiculo(Border borderResaltar) {
		this.resaltarfecha_salidaControlVehiculo= borderResaltar;
	}

	public Boolean getMostrarfecha_salidaControlVehiculo() {
		return this.mostrarfecha_salidaControlVehiculo;
	}

	public void setMostrarfecha_salidaControlVehiculo(Boolean mostrarfecha_salidaControlVehiculo) {
		this.mostrarfecha_salidaControlVehiculo= mostrarfecha_salidaControlVehiculo;
	}

	public Boolean getActivarfecha_salidaControlVehiculo() {
		return this.activarfecha_salidaControlVehiculo;
	}

	public void setActivarfecha_salidaControlVehiculo(Boolean activarfecha_salidaControlVehiculo) {
		this.activarfecha_salidaControlVehiculo= activarfecha_salidaControlVehiculo;
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
		
		
		this.setMostraridControlVehiculo(esInicial);
		this.setMostrarid_empresaControlVehiculo(esInicial);
		this.setMostrarnombre_conductorControlVehiculo(esInicial);
		this.setMostrarnumero_placaControlVehiculo(esInicial);
		this.setMostrarfecha_entradaControlVehiculo(esInicial);
		this.setMostrarfecha_salidaControlVehiculo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ControlVehiculoConstantesFunciones.ID)) {
				this.setMostraridControlVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlVehiculoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaControlVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlVehiculoConstantesFunciones.NOMBRECONDUCTOR)) {
				this.setMostrarnombre_conductorControlVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlVehiculoConstantesFunciones.NUMEROPLACA)) {
				this.setMostrarnumero_placaControlVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlVehiculoConstantesFunciones.FECHAENTRADA)) {
				this.setMostrarfecha_entradaControlVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlVehiculoConstantesFunciones.FECHASALIDA)) {
				this.setMostrarfecha_salidaControlVehiculo(esAsigna);
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
		
		
		this.setActivaridControlVehiculo(esInicial);
		this.setActivarid_empresaControlVehiculo(esInicial);
		this.setActivarnombre_conductorControlVehiculo(esInicial);
		this.setActivarnumero_placaControlVehiculo(esInicial);
		this.setActivarfecha_entradaControlVehiculo(esInicial);
		this.setActivarfecha_salidaControlVehiculo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ControlVehiculoConstantesFunciones.ID)) {
				this.setActivaridControlVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlVehiculoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaControlVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlVehiculoConstantesFunciones.NOMBRECONDUCTOR)) {
				this.setActivarnombre_conductorControlVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlVehiculoConstantesFunciones.NUMEROPLACA)) {
				this.setActivarnumero_placaControlVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlVehiculoConstantesFunciones.FECHAENTRADA)) {
				this.setActivarfecha_entradaControlVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlVehiculoConstantesFunciones.FECHASALIDA)) {
				this.setActivarfecha_salidaControlVehiculo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ControlVehiculoBeanSwingJInternalFrame controlvehiculoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridControlVehiculo(esInicial);
		this.setResaltarid_empresaControlVehiculo(esInicial);
		this.setResaltarnombre_conductorControlVehiculo(esInicial);
		this.setResaltarnumero_placaControlVehiculo(esInicial);
		this.setResaltarfecha_entradaControlVehiculo(esInicial);
		this.setResaltarfecha_salidaControlVehiculo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ControlVehiculoConstantesFunciones.ID)) {
				this.setResaltaridControlVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlVehiculoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaControlVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlVehiculoConstantesFunciones.NOMBRECONDUCTOR)) {
				this.setResaltarnombre_conductorControlVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlVehiculoConstantesFunciones.NUMEROPLACA)) {
				this.setResaltarnumero_placaControlVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlVehiculoConstantesFunciones.FECHAENTRADA)) {
				this.setResaltarfecha_entradaControlVehiculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlVehiculoConstantesFunciones.FECHASALIDA)) {
				this.setResaltarfecha_salidaControlVehiculo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ControlVehiculoBeanSwingJInternalFrame controlvehiculoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorFechaEntradaControlVehiculo=true;

	public Boolean getMostrarBusquedaPorFechaEntradaControlVehiculo() {
		return this.mostrarBusquedaPorFechaEntradaControlVehiculo;
	}

	public void setMostrarBusquedaPorFechaEntradaControlVehiculo(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorFechaEntradaControlVehiculo= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorFechaSalidaControlVehiculo=true;

	public Boolean getMostrarBusquedaPorFechaSalidaControlVehiculo() {
		return this.mostrarBusquedaPorFechaSalidaControlVehiculo;
	}

	public void setMostrarBusquedaPorFechaSalidaControlVehiculo(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorFechaSalidaControlVehiculo= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreConductorControlVehiculo=true;

	public Boolean getMostrarBusquedaPorNombreConductorControlVehiculo() {
		return this.mostrarBusquedaPorNombreConductorControlVehiculo;
	}

	public void setMostrarBusquedaPorNombreConductorControlVehiculo(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreConductorControlVehiculo= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNumeroPlacaControlVehiculo=true;

	public Boolean getMostrarBusquedaPorNumeroPlacaControlVehiculo() {
		return this.mostrarBusquedaPorNumeroPlacaControlVehiculo;
	}

	public void setMostrarBusquedaPorNumeroPlacaControlVehiculo(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNumeroPlacaControlVehiculo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaControlVehiculo=true;

	public Boolean getMostrarFK_IdEmpresaControlVehiculo() {
		return this.mostrarFK_IdEmpresaControlVehiculo;
	}

	public void setMostrarFK_IdEmpresaControlVehiculo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaControlVehiculo= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorFechaEntradaControlVehiculo=true;

	public Boolean getActivarBusquedaPorFechaEntradaControlVehiculo() {
		return this.activarBusquedaPorFechaEntradaControlVehiculo;
	}

	public void setActivarBusquedaPorFechaEntradaControlVehiculo(Boolean habilitarResaltar) {
		this.activarBusquedaPorFechaEntradaControlVehiculo= habilitarResaltar;
	}

	public Boolean activarBusquedaPorFechaSalidaControlVehiculo=true;

	public Boolean getActivarBusquedaPorFechaSalidaControlVehiculo() {
		return this.activarBusquedaPorFechaSalidaControlVehiculo;
	}

	public void setActivarBusquedaPorFechaSalidaControlVehiculo(Boolean habilitarResaltar) {
		this.activarBusquedaPorFechaSalidaControlVehiculo= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreConductorControlVehiculo=true;

	public Boolean getActivarBusquedaPorNombreConductorControlVehiculo() {
		return this.activarBusquedaPorNombreConductorControlVehiculo;
	}

	public void setActivarBusquedaPorNombreConductorControlVehiculo(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreConductorControlVehiculo= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNumeroPlacaControlVehiculo=true;

	public Boolean getActivarBusquedaPorNumeroPlacaControlVehiculo() {
		return this.activarBusquedaPorNumeroPlacaControlVehiculo;
	}

	public void setActivarBusquedaPorNumeroPlacaControlVehiculo(Boolean habilitarResaltar) {
		this.activarBusquedaPorNumeroPlacaControlVehiculo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaControlVehiculo=true;

	public Boolean getActivarFK_IdEmpresaControlVehiculo() {
		return this.activarFK_IdEmpresaControlVehiculo;
	}

	public void setActivarFK_IdEmpresaControlVehiculo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaControlVehiculo= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorFechaEntradaControlVehiculo=null;

	public Border getResaltarBusquedaPorFechaEntradaControlVehiculo() {
		return this.resaltarBusquedaPorFechaEntradaControlVehiculo;
	}

	public void setResaltarBusquedaPorFechaEntradaControlVehiculo(Border borderResaltar) {
		this.resaltarBusquedaPorFechaEntradaControlVehiculo= borderResaltar;
	}

	public void setResaltarBusquedaPorFechaEntradaControlVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*ControlVehiculoBeanSwingJInternalFrame controlvehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorFechaEntradaControlVehiculo= borderResaltar;
	}

	public Border resaltarBusquedaPorFechaSalidaControlVehiculo=null;

	public Border getResaltarBusquedaPorFechaSalidaControlVehiculo() {
		return this.resaltarBusquedaPorFechaSalidaControlVehiculo;
	}

	public void setResaltarBusquedaPorFechaSalidaControlVehiculo(Border borderResaltar) {
		this.resaltarBusquedaPorFechaSalidaControlVehiculo= borderResaltar;
	}

	public void setResaltarBusquedaPorFechaSalidaControlVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*ControlVehiculoBeanSwingJInternalFrame controlvehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorFechaSalidaControlVehiculo= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreConductorControlVehiculo=null;

	public Border getResaltarBusquedaPorNombreConductorControlVehiculo() {
		return this.resaltarBusquedaPorNombreConductorControlVehiculo;
	}

	public void setResaltarBusquedaPorNombreConductorControlVehiculo(Border borderResaltar) {
		this.resaltarBusquedaPorNombreConductorControlVehiculo= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreConductorControlVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*ControlVehiculoBeanSwingJInternalFrame controlvehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreConductorControlVehiculo= borderResaltar;
	}

	public Border resaltarBusquedaPorNumeroPlacaControlVehiculo=null;

	public Border getResaltarBusquedaPorNumeroPlacaControlVehiculo() {
		return this.resaltarBusquedaPorNumeroPlacaControlVehiculo;
	}

	public void setResaltarBusquedaPorNumeroPlacaControlVehiculo(Border borderResaltar) {
		this.resaltarBusquedaPorNumeroPlacaControlVehiculo= borderResaltar;
	}

	public void setResaltarBusquedaPorNumeroPlacaControlVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*ControlVehiculoBeanSwingJInternalFrame controlvehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNumeroPlacaControlVehiculo= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaControlVehiculo=null;

	public Border getResaltarFK_IdEmpresaControlVehiculo() {
		return this.resaltarFK_IdEmpresaControlVehiculo;
	}

	public void setResaltarFK_IdEmpresaControlVehiculo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaControlVehiculo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaControlVehiculo(ParametroGeneralUsuario parametroGeneralUsuario/*ControlVehiculoBeanSwingJInternalFrame controlvehiculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaControlVehiculo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}