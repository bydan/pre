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


import com.bydan.erp.cartera.util.VehiculoClienteConstantesFunciones;
import com.bydan.erp.cartera.util.VehiculoClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.VehiculoClienteParameterGeneral;

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
final public class VehiculoClienteConstantesFunciones extends VehiculoClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="VehiculoCliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="VehiculoCliente"+VehiculoClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="VehiculoClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="VehiculoClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=VehiculoClienteConstantesFunciones.SCHEMA+"_"+VehiculoClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/VehiculoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=VehiculoClienteConstantesFunciones.SCHEMA+"_"+VehiculoClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=VehiculoClienteConstantesFunciones.SCHEMA+"_"+VehiculoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/VehiculoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=VehiculoClienteConstantesFunciones.SCHEMA+"_"+VehiculoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VehiculoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VehiculoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VehiculoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VehiculoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VehiculoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VehiculoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=VehiculoClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+VehiculoClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=VehiculoClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+VehiculoClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Vehiculo Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Vehiculo Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Vehiculo Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="VehiculoCliente";
	public static final String OBJECTNAME="vehiculocliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="vehiculo_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select vehiculocliente from "+VehiculoClienteConstantesFunciones.SPERSISTENCENAME+" vehiculocliente";
	public static String QUERYSELECTNATIVE="select "+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".id,"+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".version_row,"+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".id_empresa,"+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".id_cliente,"+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".codigo,"+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".marca,"+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".modelo,"+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".placa,"+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".anio,"+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".es_prendado,"+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".valor_avaluo from "+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME;//+" as "+VehiculoClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected VehiculoClienteConstantesFuncionesAdditional vehiculoclienteConstantesFuncionesAdditional=null;
	
	public VehiculoClienteConstantesFuncionesAdditional getVehiculoClienteConstantesFuncionesAdditional() {
		return this.vehiculoclienteConstantesFuncionesAdditional;
	}
	
	public void setVehiculoClienteConstantesFuncionesAdditional(VehiculoClienteConstantesFuncionesAdditional vehiculoclienteConstantesFuncionesAdditional) {
		try {
			this.vehiculoclienteConstantesFuncionesAdditional=vehiculoclienteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCLIENTE= "id_cliente";
    public static final String CODIGO= "codigo";
    public static final String MARCA= "marca";
    public static final String MODELO= "modelo";
    public static final String PLACA= "placa";
    public static final String ANIO= "anio";
    public static final String ESPRENDADO= "es_prendado";
    public static final String VALORAVALUO= "valor_avaluo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_MARCA= "Marca";
		public static final String LABEL_MARCA_LOWER= "Marca";
    	public static final String LABEL_MODELO= "Modelo";
		public static final String LABEL_MODELO_LOWER= "Modelo";
    	public static final String LABEL_PLACA= "Placa";
		public static final String LABEL_PLACA_LOWER= "Placa";
    	public static final String LABEL_ANIO= "Anio";
		public static final String LABEL_ANIO_LOWER= "Anio";
    	public static final String LABEL_ESPRENDADO= "Es Prendado";
		public static final String LABEL_ESPRENDADO_LOWER= "Es Prendado";
    	public static final String LABEL_VALORAVALUO= "Valor Avaluo";
		public static final String LABEL_VALORAVALUO_LOWER= "Valor Avaluo";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXMARCA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXMARCA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXMODELO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXMODELO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXPLACA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPLACA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getVehiculoClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(VehiculoClienteConstantesFunciones.IDEMPRESA)) {sLabelColumna=VehiculoClienteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(VehiculoClienteConstantesFunciones.IDCLIENTE)) {sLabelColumna=VehiculoClienteConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(VehiculoClienteConstantesFunciones.CODIGO)) {sLabelColumna=VehiculoClienteConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(VehiculoClienteConstantesFunciones.MARCA)) {sLabelColumna=VehiculoClienteConstantesFunciones.LABEL_MARCA;}
		if(sNombreColumna.equals(VehiculoClienteConstantesFunciones.MODELO)) {sLabelColumna=VehiculoClienteConstantesFunciones.LABEL_MODELO;}
		if(sNombreColumna.equals(VehiculoClienteConstantesFunciones.PLACA)) {sLabelColumna=VehiculoClienteConstantesFunciones.LABEL_PLACA;}
		if(sNombreColumna.equals(VehiculoClienteConstantesFunciones.ANIO)) {sLabelColumna=VehiculoClienteConstantesFunciones.LABEL_ANIO;}
		if(sNombreColumna.equals(VehiculoClienteConstantesFunciones.ESPRENDADO)) {sLabelColumna=VehiculoClienteConstantesFunciones.LABEL_ESPRENDADO;}
		if(sNombreColumna.equals(VehiculoClienteConstantesFunciones.VALORAVALUO)) {sLabelColumna=VehiculoClienteConstantesFunciones.LABEL_VALORAVALUO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
		
	public static String getes_prendadoDescripcion(VehiculoCliente vehiculocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!vehiculocliente.getes_prendado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_prendadoHtmlDescripcion(VehiculoCliente vehiculocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(vehiculocliente.getId(),vehiculocliente.getes_prendado());

		return sDescripcion;
	}	
			
	
	public static String getVehiculoClienteDescripcion(VehiculoCliente vehiculocliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(vehiculocliente !=null/* && vehiculocliente.getId()!=0*/) {
			sDescripcion=vehiculocliente.getcodigo();//vehiculoclientevehiculocliente.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getVehiculoClienteDescripcionDetallado(VehiculoCliente vehiculocliente) {
		String sDescripcion="";
			
		sDescripcion+=VehiculoClienteConstantesFunciones.ID+"=";
		sDescripcion+=vehiculocliente.getId().toString()+",";
		sDescripcion+=VehiculoClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=vehiculocliente.getVersionRow().toString()+",";
		sDescripcion+=VehiculoClienteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=vehiculocliente.getid_empresa().toString()+",";
		sDescripcion+=VehiculoClienteConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=vehiculocliente.getid_cliente().toString()+",";
		sDescripcion+=VehiculoClienteConstantesFunciones.CODIGO+"=";
		sDescripcion+=vehiculocliente.getcodigo()+",";
		sDescripcion+=VehiculoClienteConstantesFunciones.MARCA+"=";
		sDescripcion+=vehiculocliente.getmarca()+",";
		sDescripcion+=VehiculoClienteConstantesFunciones.MODELO+"=";
		sDescripcion+=vehiculocliente.getmodelo()+",";
		sDescripcion+=VehiculoClienteConstantesFunciones.PLACA+"=";
		sDescripcion+=vehiculocliente.getplaca()+",";
		sDescripcion+=VehiculoClienteConstantesFunciones.ANIO+"=";
		sDescripcion+=vehiculocliente.getanio().toString()+",";
		sDescripcion+=VehiculoClienteConstantesFunciones.ESPRENDADO+"=";
		sDescripcion+=vehiculocliente.getes_prendado().toString()+",";
		sDescripcion+=VehiculoClienteConstantesFunciones.VALORAVALUO+"=";
		sDescripcion+=vehiculocliente.getvalor_avaluo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setVehiculoClienteDescripcion(VehiculoCliente vehiculocliente,String sValor) throws Exception {			
		if(vehiculocliente !=null) {
			vehiculocliente.setcodigo(sValor);;//vehiculoclientevehiculocliente.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosVehiculoCliente(VehiculoCliente vehiculocliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		vehiculocliente.setcodigo(vehiculocliente.getcodigo().trim());
		vehiculocliente.setmarca(vehiculocliente.getmarca().trim());
		vehiculocliente.setmodelo(vehiculocliente.getmodelo().trim());
		vehiculocliente.setplaca(vehiculocliente.getplaca().trim());
	}
	
	public static void quitarEspaciosVehiculoClientes(List<VehiculoCliente> vehiculoclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VehiculoCliente vehiculocliente: vehiculoclientes) {
			vehiculocliente.setcodigo(vehiculocliente.getcodigo().trim());
			vehiculocliente.setmarca(vehiculocliente.getmarca().trim());
			vehiculocliente.setmodelo(vehiculocliente.getmodelo().trim());
			vehiculocliente.setplaca(vehiculocliente.getplaca().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVehiculoCliente(VehiculoCliente vehiculocliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && vehiculocliente.getConCambioAuxiliar()) {
			vehiculocliente.setIsDeleted(vehiculocliente.getIsDeletedAuxiliar());	
			vehiculocliente.setIsNew(vehiculocliente.getIsNewAuxiliar());	
			vehiculocliente.setIsChanged(vehiculocliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			vehiculocliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			vehiculocliente.setIsDeletedAuxiliar(false);	
			vehiculocliente.setIsNewAuxiliar(false);	
			vehiculocliente.setIsChangedAuxiliar(false);
			
			vehiculocliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVehiculoClientes(List<VehiculoCliente> vehiculoclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(VehiculoCliente vehiculocliente : vehiculoclientes) {
			if(conAsignarBase && vehiculocliente.getConCambioAuxiliar()) {
				vehiculocliente.setIsDeleted(vehiculocliente.getIsDeletedAuxiliar());	
				vehiculocliente.setIsNew(vehiculocliente.getIsNewAuxiliar());	
				vehiculocliente.setIsChanged(vehiculocliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				vehiculocliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				vehiculocliente.setIsDeletedAuxiliar(false);	
				vehiculocliente.setIsNewAuxiliar(false);	
				vehiculocliente.setIsChangedAuxiliar(false);
				
				vehiculocliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresVehiculoCliente(VehiculoCliente vehiculocliente,Boolean conEnteros) throws Exception  {
		vehiculocliente.setvalor_avaluo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			vehiculocliente.setanio(0);
		}
	}		
	
	public static void InicializarValoresVehiculoClientes(List<VehiculoCliente> vehiculoclientes,Boolean conEnteros) throws Exception  {
		
		for(VehiculoCliente vehiculocliente: vehiculoclientes) {
			vehiculocliente.setvalor_avaluo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				vehiculocliente.setanio(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaVehiculoCliente(List<VehiculoCliente> vehiculoclientes,VehiculoCliente vehiculoclienteAux) throws Exception  {
		VehiculoClienteConstantesFunciones.InicializarValoresVehiculoCliente(vehiculoclienteAux,true);
		
		for(VehiculoCliente vehiculocliente: vehiculoclientes) {
			if(vehiculocliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			vehiculoclienteAux.setanio(vehiculoclienteAux.getanio()+vehiculocliente.getanio());			
			vehiculoclienteAux.setvalor_avaluo(vehiculoclienteAux.getvalor_avaluo()+vehiculocliente.getvalor_avaluo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVehiculoCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=VehiculoClienteConstantesFunciones.getArrayColumnasGlobalesVehiculoCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesVehiculoCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VehiculoClienteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VehiculoClienteConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoVehiculoCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VehiculoCliente> vehiculoclientes,VehiculoCliente vehiculocliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VehiculoCliente vehiculoclienteAux: vehiculoclientes) {
			if(vehiculoclienteAux!=null && vehiculocliente!=null) {
				if((vehiculoclienteAux.getId()==null && vehiculocliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(vehiculoclienteAux.getId()!=null && vehiculocliente.getId()!=null){
					if(vehiculoclienteAux.getId().equals(vehiculocliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVehiculoCliente(List<VehiculoCliente> vehiculoclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_avaluoTotal=0.0;
	
		for(VehiculoCliente vehiculocliente: vehiculoclientes) {			
			if(vehiculocliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_avaluoTotal+=vehiculocliente.getvalor_avaluo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VehiculoClienteConstantesFunciones.VALORAVALUO);
		datoGeneral.setsDescripcion(VehiculoClienteConstantesFunciones.LABEL_VALORAVALUO);
		datoGeneral.setdValorDouble(valor_avaluoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaVehiculoCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,VehiculoClienteConstantesFunciones.LABEL_ID, VehiculoClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoClienteConstantesFunciones.LABEL_VERSIONROW, VehiculoClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoClienteConstantesFunciones.LABEL_IDEMPRESA, VehiculoClienteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoClienteConstantesFunciones.LABEL_IDCLIENTE, VehiculoClienteConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoClienteConstantesFunciones.LABEL_CODIGO, VehiculoClienteConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoClienteConstantesFunciones.LABEL_MARCA, VehiculoClienteConstantesFunciones.MARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoClienteConstantesFunciones.LABEL_MODELO, VehiculoClienteConstantesFunciones.MODELO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoClienteConstantesFunciones.LABEL_PLACA, VehiculoClienteConstantesFunciones.PLACA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoClienteConstantesFunciones.LABEL_ANIO, VehiculoClienteConstantesFunciones.ANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoClienteConstantesFunciones.LABEL_ESPRENDADO, VehiculoClienteConstantesFunciones.ESPRENDADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VehiculoClienteConstantesFunciones.LABEL_VALORAVALUO, VehiculoClienteConstantesFunciones.VALORAVALUO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasVehiculoCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=VehiculoClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoClienteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoClienteConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoClienteConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoClienteConstantesFunciones.MARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoClienteConstantesFunciones.MODELO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoClienteConstantesFunciones.PLACA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoClienteConstantesFunciones.ANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoClienteConstantesFunciones.ESPRENDADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VehiculoClienteConstantesFunciones.VALORAVALUO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVehiculoCliente() throws Exception  {
		return VehiculoClienteConstantesFunciones.getTiposSeleccionarVehiculoCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVehiculoCliente(Boolean conFk) throws Exception  {
		return VehiculoClienteConstantesFunciones.getTiposSeleccionarVehiculoCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVehiculoCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoClienteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(VehiculoClienteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoClienteConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(VehiculoClienteConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoClienteConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(VehiculoClienteConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoClienteConstantesFunciones.LABEL_MARCA);
			reporte.setsDescripcion(VehiculoClienteConstantesFunciones.LABEL_MARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoClienteConstantesFunciones.LABEL_MODELO);
			reporte.setsDescripcion(VehiculoClienteConstantesFunciones.LABEL_MODELO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoClienteConstantesFunciones.LABEL_PLACA);
			reporte.setsDescripcion(VehiculoClienteConstantesFunciones.LABEL_PLACA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoClienteConstantesFunciones.LABEL_ANIO);
			reporte.setsDescripcion(VehiculoClienteConstantesFunciones.LABEL_ANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoClienteConstantesFunciones.LABEL_ESPRENDADO);
			reporte.setsDescripcion(VehiculoClienteConstantesFunciones.LABEL_ESPRENDADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VehiculoClienteConstantesFunciones.LABEL_VALORAVALUO);
			reporte.setsDescripcion(VehiculoClienteConstantesFunciones.LABEL_VALORAVALUO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesVehiculoCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesVehiculoCliente(VehiculoCliente vehiculoclienteAux) throws Exception {
		
			vehiculoclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(vehiculoclienteAux.getEmpresa()));
			vehiculoclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(vehiculoclienteAux.getCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesVehiculoCliente(List<VehiculoCliente> vehiculoclientesTemp) throws Exception {
		for(VehiculoCliente vehiculoclienteAux:vehiculoclientesTemp) {
			
			vehiculoclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(vehiculoclienteAux.getEmpresa()));
			vehiculoclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(vehiculoclienteAux.getCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfVehiculoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Cliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfVehiculoCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfVehiculoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return VehiculoClienteConstantesFunciones.getClassesRelationshipsOfVehiculoCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVehiculoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVehiculoCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return VehiculoClienteConstantesFunciones.getClassesRelationshipsFromStringsOfVehiculoCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVehiculoCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(VehiculoCliente vehiculocliente,List<VehiculoCliente> vehiculoclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			VehiculoCliente vehiculoclienteEncontrado=null;
			
			for(VehiculoCliente vehiculoclienteLocal:vehiculoclientes) {
				if(vehiculoclienteLocal.getId().equals(vehiculocliente.getId())) {
					vehiculoclienteEncontrado=vehiculoclienteLocal;
					
					vehiculoclienteLocal.setIsChanged(vehiculocliente.getIsChanged());
					vehiculoclienteLocal.setIsNew(vehiculocliente.getIsNew());
					vehiculoclienteLocal.setIsDeleted(vehiculocliente.getIsDeleted());
					
					vehiculoclienteLocal.setGeneralEntityOriginal(vehiculocliente.getGeneralEntityOriginal());
					
					vehiculoclienteLocal.setId(vehiculocliente.getId());	
					vehiculoclienteLocal.setVersionRow(vehiculocliente.getVersionRow());	
					vehiculoclienteLocal.setid_empresa(vehiculocliente.getid_empresa());	
					vehiculoclienteLocal.setid_cliente(vehiculocliente.getid_cliente());	
					vehiculoclienteLocal.setcodigo(vehiculocliente.getcodigo());	
					vehiculoclienteLocal.setmarca(vehiculocliente.getmarca());	
					vehiculoclienteLocal.setmodelo(vehiculocliente.getmodelo());	
					vehiculoclienteLocal.setplaca(vehiculocliente.getplaca());	
					vehiculoclienteLocal.setanio(vehiculocliente.getanio());	
					vehiculoclienteLocal.setes_prendado(vehiculocliente.getes_prendado());	
					vehiculoclienteLocal.setvalor_avaluo(vehiculocliente.getvalor_avaluo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!vehiculocliente.getIsDeleted()) {
				if(!existe) {
					vehiculoclientes.add(vehiculocliente);
				}
			} else {
				if(vehiculoclienteEncontrado!=null && permiteQuitar)  {
					vehiculoclientes.remove(vehiculoclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(VehiculoCliente vehiculocliente,List<VehiculoCliente> vehiculoclientes) throws Exception {
		try	{			
			for(VehiculoCliente vehiculoclienteLocal:vehiculoclientes) {
				if(vehiculoclienteLocal.getId().equals(vehiculocliente.getId())) {
					vehiculoclienteLocal.setIsSelected(vehiculocliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesVehiculoCliente(List<VehiculoCliente> vehiculoclientesAux) throws Exception {
		//this.vehiculoclientesAux=vehiculoclientesAux;
		
		for(VehiculoCliente vehiculoclienteAux:vehiculoclientesAux) {
			if(vehiculoclienteAux.getIsChanged()) {
				vehiculoclienteAux.setIsChanged(false);
			}		
			
			if(vehiculoclienteAux.getIsNew()) {
				vehiculoclienteAux.setIsNew(false);
			}	
			
			if(vehiculoclienteAux.getIsDeleted()) {
				vehiculoclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesVehiculoCliente(VehiculoCliente vehiculoclienteAux) throws Exception {
		//this.vehiculoclienteAux=vehiculoclienteAux;
		
			if(vehiculoclienteAux.getIsChanged()) {
				vehiculoclienteAux.setIsChanged(false);
			}		
			
			if(vehiculoclienteAux.getIsNew()) {
				vehiculoclienteAux.setIsNew(false);
			}	
			
			if(vehiculoclienteAux.getIsDeleted()) {
				vehiculoclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(VehiculoCliente vehiculoclienteAsignar,VehiculoCliente vehiculocliente) throws Exception {
		vehiculoclienteAsignar.setId(vehiculocliente.getId());	
		vehiculoclienteAsignar.setVersionRow(vehiculocliente.getVersionRow());	
		vehiculoclienteAsignar.setid_empresa(vehiculocliente.getid_empresa());
		vehiculoclienteAsignar.setempresa_descripcion(vehiculocliente.getempresa_descripcion());	
		vehiculoclienteAsignar.setid_cliente(vehiculocliente.getid_cliente());
		vehiculoclienteAsignar.setcliente_descripcion(vehiculocliente.getcliente_descripcion());	
		vehiculoclienteAsignar.setcodigo(vehiculocliente.getcodigo());	
		vehiculoclienteAsignar.setmarca(vehiculocliente.getmarca());	
		vehiculoclienteAsignar.setmodelo(vehiculocliente.getmodelo());	
		vehiculoclienteAsignar.setplaca(vehiculocliente.getplaca());	
		vehiculoclienteAsignar.setanio(vehiculocliente.getanio());	
		vehiculoclienteAsignar.setes_prendado(vehiculocliente.getes_prendado());	
		vehiculoclienteAsignar.setvalor_avaluo(vehiculocliente.getvalor_avaluo());	
	}
	
	public static void inicializarVehiculoCliente(VehiculoCliente vehiculocliente) throws Exception {
		try {
				vehiculocliente.setId(0L);	
					
				vehiculocliente.setid_empresa(-1L);	
				vehiculocliente.setid_cliente(-1L);	
				vehiculocliente.setcodigo("");	
				vehiculocliente.setmarca("");	
				vehiculocliente.setmodelo("");	
				vehiculocliente.setplaca("");	
				vehiculocliente.setanio(0);	
				vehiculocliente.setes_prendado(false);	
				vehiculocliente.setvalor_avaluo(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderVehiculoCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoClienteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoClienteConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoClienteConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoClienteConstantesFunciones.LABEL_MARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoClienteConstantesFunciones.LABEL_MODELO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoClienteConstantesFunciones.LABEL_PLACA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoClienteConstantesFunciones.LABEL_ANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoClienteConstantesFunciones.LABEL_ESPRENDADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VehiculoClienteConstantesFunciones.LABEL_VALORAVALUO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataVehiculoCliente(String sTipo,Row row,Workbook workbook,VehiculoCliente vehiculocliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculocliente.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculocliente.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculocliente.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculocliente.getmarca());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculocliente.getmodelo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculocliente.getplaca());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculocliente.getanio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(vehiculocliente.getes_prendado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vehiculocliente.getvalor_avaluo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryVehiculoCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryVehiculoCliente() {
		return this.sFinalQueryVehiculoCliente;
	}
	
	public void setsFinalQueryVehiculoCliente(String sFinalQueryVehiculoCliente) {
		this.sFinalQueryVehiculoCliente= sFinalQueryVehiculoCliente;
	}
	
	public Border resaltarSeleccionarVehiculoCliente=null;
	
	public Border setResaltarSeleccionarVehiculoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoClienteBeanSwingJInternalFrame vehiculoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//vehiculoclienteBeanSwingJInternalFrame.jTtoolBarVehiculoCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarVehiculoCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarVehiculoCliente() {
		return this.resaltarSeleccionarVehiculoCliente;
	}
	
	public void setResaltarSeleccionarVehiculoCliente(Border borderResaltarSeleccionarVehiculoCliente) {
		this.resaltarSeleccionarVehiculoCliente= borderResaltarSeleccionarVehiculoCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridVehiculoCliente=null;
	public Boolean mostraridVehiculoCliente=true;
	public Boolean activaridVehiculoCliente=true;

	public Border resaltarid_empresaVehiculoCliente=null;
	public Boolean mostrarid_empresaVehiculoCliente=true;
	public Boolean activarid_empresaVehiculoCliente=true;
	public Boolean cargarid_empresaVehiculoCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaVehiculoCliente=false;//ConEventDepend=true

	public Border resaltarid_clienteVehiculoCliente=null;
	public Boolean mostrarid_clienteVehiculoCliente=true;
	public Boolean activarid_clienteVehiculoCliente=true;
	public Boolean cargarid_clienteVehiculoCliente=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteVehiculoCliente=false;//ConEventDepend=true

	public Border resaltarcodigoVehiculoCliente=null;
	public Boolean mostrarcodigoVehiculoCliente=true;
	public Boolean activarcodigoVehiculoCliente=true;

	public Border resaltarmarcaVehiculoCliente=null;
	public Boolean mostrarmarcaVehiculoCliente=true;
	public Boolean activarmarcaVehiculoCliente=true;

	public Border resaltarmodeloVehiculoCliente=null;
	public Boolean mostrarmodeloVehiculoCliente=true;
	public Boolean activarmodeloVehiculoCliente=true;

	public Border resaltarplacaVehiculoCliente=null;
	public Boolean mostrarplacaVehiculoCliente=true;
	public Boolean activarplacaVehiculoCliente=true;

	public Border resaltaranioVehiculoCliente=null;
	public Boolean mostraranioVehiculoCliente=true;
	public Boolean activaranioVehiculoCliente=true;

	public Border resaltares_prendadoVehiculoCliente=null;
	public Boolean mostrares_prendadoVehiculoCliente=true;
	public Boolean activares_prendadoVehiculoCliente=true;

	public Border resaltarvalor_avaluoVehiculoCliente=null;
	public Boolean mostrarvalor_avaluoVehiculoCliente=true;
	public Boolean activarvalor_avaluoVehiculoCliente=true;

	
	

	public Border setResaltaridVehiculoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoClienteBeanSwingJInternalFrame vehiculoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoclienteBeanSwingJInternalFrame.jTtoolBarVehiculoCliente.setBorder(borderResaltar);
		
		this.resaltaridVehiculoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridVehiculoCliente() {
		return this.resaltaridVehiculoCliente;
	}

	public void setResaltaridVehiculoCliente(Border borderResaltar) {
		this.resaltaridVehiculoCliente= borderResaltar;
	}

	public Boolean getMostraridVehiculoCliente() {
		return this.mostraridVehiculoCliente;
	}

	public void setMostraridVehiculoCliente(Boolean mostraridVehiculoCliente) {
		this.mostraridVehiculoCliente= mostraridVehiculoCliente;
	}

	public Boolean getActivaridVehiculoCliente() {
		return this.activaridVehiculoCliente;
	}

	public void setActivaridVehiculoCliente(Boolean activaridVehiculoCliente) {
		this.activaridVehiculoCliente= activaridVehiculoCliente;
	}

	public Border setResaltarid_empresaVehiculoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoClienteBeanSwingJInternalFrame vehiculoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoclienteBeanSwingJInternalFrame.jTtoolBarVehiculoCliente.setBorder(borderResaltar);
		
		this.resaltarid_empresaVehiculoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaVehiculoCliente() {
		return this.resaltarid_empresaVehiculoCliente;
	}

	public void setResaltarid_empresaVehiculoCliente(Border borderResaltar) {
		this.resaltarid_empresaVehiculoCliente= borderResaltar;
	}

	public Boolean getMostrarid_empresaVehiculoCliente() {
		return this.mostrarid_empresaVehiculoCliente;
	}

	public void setMostrarid_empresaVehiculoCliente(Boolean mostrarid_empresaVehiculoCliente) {
		this.mostrarid_empresaVehiculoCliente= mostrarid_empresaVehiculoCliente;
	}

	public Boolean getActivarid_empresaVehiculoCliente() {
		return this.activarid_empresaVehiculoCliente;
	}

	public void setActivarid_empresaVehiculoCliente(Boolean activarid_empresaVehiculoCliente) {
		this.activarid_empresaVehiculoCliente= activarid_empresaVehiculoCliente;
	}

	public Boolean getCargarid_empresaVehiculoCliente() {
		return this.cargarid_empresaVehiculoCliente;
	}

	public void setCargarid_empresaVehiculoCliente(Boolean cargarid_empresaVehiculoCliente) {
		this.cargarid_empresaVehiculoCliente= cargarid_empresaVehiculoCliente;
	}

	public Border setResaltarid_clienteVehiculoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoClienteBeanSwingJInternalFrame vehiculoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoclienteBeanSwingJInternalFrame.jTtoolBarVehiculoCliente.setBorder(borderResaltar);
		
		this.resaltarid_clienteVehiculoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteVehiculoCliente() {
		return this.resaltarid_clienteVehiculoCliente;
	}

	public void setResaltarid_clienteVehiculoCliente(Border borderResaltar) {
		this.resaltarid_clienteVehiculoCliente= borderResaltar;
	}

	public Boolean getMostrarid_clienteVehiculoCliente() {
		return this.mostrarid_clienteVehiculoCliente;
	}

	public void setMostrarid_clienteVehiculoCliente(Boolean mostrarid_clienteVehiculoCliente) {
		this.mostrarid_clienteVehiculoCliente= mostrarid_clienteVehiculoCliente;
	}

	public Boolean getActivarid_clienteVehiculoCliente() {
		return this.activarid_clienteVehiculoCliente;
	}

	public void setActivarid_clienteVehiculoCliente(Boolean activarid_clienteVehiculoCliente) {
		this.activarid_clienteVehiculoCliente= activarid_clienteVehiculoCliente;
	}

	public Boolean getCargarid_clienteVehiculoCliente() {
		return this.cargarid_clienteVehiculoCliente;
	}

	public void setCargarid_clienteVehiculoCliente(Boolean cargarid_clienteVehiculoCliente) {
		this.cargarid_clienteVehiculoCliente= cargarid_clienteVehiculoCliente;
	}

	public Border setResaltarcodigoVehiculoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoClienteBeanSwingJInternalFrame vehiculoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoclienteBeanSwingJInternalFrame.jTtoolBarVehiculoCliente.setBorder(borderResaltar);
		
		this.resaltarcodigoVehiculoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoVehiculoCliente() {
		return this.resaltarcodigoVehiculoCliente;
	}

	public void setResaltarcodigoVehiculoCliente(Border borderResaltar) {
		this.resaltarcodigoVehiculoCliente= borderResaltar;
	}

	public Boolean getMostrarcodigoVehiculoCliente() {
		return this.mostrarcodigoVehiculoCliente;
	}

	public void setMostrarcodigoVehiculoCliente(Boolean mostrarcodigoVehiculoCliente) {
		this.mostrarcodigoVehiculoCliente= mostrarcodigoVehiculoCliente;
	}

	public Boolean getActivarcodigoVehiculoCliente() {
		return this.activarcodigoVehiculoCliente;
	}

	public void setActivarcodigoVehiculoCliente(Boolean activarcodigoVehiculoCliente) {
		this.activarcodigoVehiculoCliente= activarcodigoVehiculoCliente;
	}

	public Border setResaltarmarcaVehiculoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoClienteBeanSwingJInternalFrame vehiculoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoclienteBeanSwingJInternalFrame.jTtoolBarVehiculoCliente.setBorder(borderResaltar);
		
		this.resaltarmarcaVehiculoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmarcaVehiculoCliente() {
		return this.resaltarmarcaVehiculoCliente;
	}

	public void setResaltarmarcaVehiculoCliente(Border borderResaltar) {
		this.resaltarmarcaVehiculoCliente= borderResaltar;
	}

	public Boolean getMostrarmarcaVehiculoCliente() {
		return this.mostrarmarcaVehiculoCliente;
	}

	public void setMostrarmarcaVehiculoCliente(Boolean mostrarmarcaVehiculoCliente) {
		this.mostrarmarcaVehiculoCliente= mostrarmarcaVehiculoCliente;
	}

	public Boolean getActivarmarcaVehiculoCliente() {
		return this.activarmarcaVehiculoCliente;
	}

	public void setActivarmarcaVehiculoCliente(Boolean activarmarcaVehiculoCliente) {
		this.activarmarcaVehiculoCliente= activarmarcaVehiculoCliente;
	}

	public Border setResaltarmodeloVehiculoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoClienteBeanSwingJInternalFrame vehiculoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoclienteBeanSwingJInternalFrame.jTtoolBarVehiculoCliente.setBorder(borderResaltar);
		
		this.resaltarmodeloVehiculoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmodeloVehiculoCliente() {
		return this.resaltarmodeloVehiculoCliente;
	}

	public void setResaltarmodeloVehiculoCliente(Border borderResaltar) {
		this.resaltarmodeloVehiculoCliente= borderResaltar;
	}

	public Boolean getMostrarmodeloVehiculoCliente() {
		return this.mostrarmodeloVehiculoCliente;
	}

	public void setMostrarmodeloVehiculoCliente(Boolean mostrarmodeloVehiculoCliente) {
		this.mostrarmodeloVehiculoCliente= mostrarmodeloVehiculoCliente;
	}

	public Boolean getActivarmodeloVehiculoCliente() {
		return this.activarmodeloVehiculoCliente;
	}

	public void setActivarmodeloVehiculoCliente(Boolean activarmodeloVehiculoCliente) {
		this.activarmodeloVehiculoCliente= activarmodeloVehiculoCliente;
	}

	public Border setResaltarplacaVehiculoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoClienteBeanSwingJInternalFrame vehiculoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoclienteBeanSwingJInternalFrame.jTtoolBarVehiculoCliente.setBorder(borderResaltar);
		
		this.resaltarplacaVehiculoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarplacaVehiculoCliente() {
		return this.resaltarplacaVehiculoCliente;
	}

	public void setResaltarplacaVehiculoCliente(Border borderResaltar) {
		this.resaltarplacaVehiculoCliente= borderResaltar;
	}

	public Boolean getMostrarplacaVehiculoCliente() {
		return this.mostrarplacaVehiculoCliente;
	}

	public void setMostrarplacaVehiculoCliente(Boolean mostrarplacaVehiculoCliente) {
		this.mostrarplacaVehiculoCliente= mostrarplacaVehiculoCliente;
	}

	public Boolean getActivarplacaVehiculoCliente() {
		return this.activarplacaVehiculoCliente;
	}

	public void setActivarplacaVehiculoCliente(Boolean activarplacaVehiculoCliente) {
		this.activarplacaVehiculoCliente= activarplacaVehiculoCliente;
	}

	public Border setResaltaranioVehiculoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoClienteBeanSwingJInternalFrame vehiculoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoclienteBeanSwingJInternalFrame.jTtoolBarVehiculoCliente.setBorder(borderResaltar);
		
		this.resaltaranioVehiculoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaranioVehiculoCliente() {
		return this.resaltaranioVehiculoCliente;
	}

	public void setResaltaranioVehiculoCliente(Border borderResaltar) {
		this.resaltaranioVehiculoCliente= borderResaltar;
	}

	public Boolean getMostraranioVehiculoCliente() {
		return this.mostraranioVehiculoCliente;
	}

	public void setMostraranioVehiculoCliente(Boolean mostraranioVehiculoCliente) {
		this.mostraranioVehiculoCliente= mostraranioVehiculoCliente;
	}

	public Boolean getActivaranioVehiculoCliente() {
		return this.activaranioVehiculoCliente;
	}

	public void setActivaranioVehiculoCliente(Boolean activaranioVehiculoCliente) {
		this.activaranioVehiculoCliente= activaranioVehiculoCliente;
	}

	public Border setResaltares_prendadoVehiculoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoClienteBeanSwingJInternalFrame vehiculoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoclienteBeanSwingJInternalFrame.jTtoolBarVehiculoCliente.setBorder(borderResaltar);
		
		this.resaltares_prendadoVehiculoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_prendadoVehiculoCliente() {
		return this.resaltares_prendadoVehiculoCliente;
	}

	public void setResaltares_prendadoVehiculoCliente(Border borderResaltar) {
		this.resaltares_prendadoVehiculoCliente= borderResaltar;
	}

	public Boolean getMostrares_prendadoVehiculoCliente() {
		return this.mostrares_prendadoVehiculoCliente;
	}

	public void setMostrares_prendadoVehiculoCliente(Boolean mostrares_prendadoVehiculoCliente) {
		this.mostrares_prendadoVehiculoCliente= mostrares_prendadoVehiculoCliente;
	}

	public Boolean getActivares_prendadoVehiculoCliente() {
		return this.activares_prendadoVehiculoCliente;
	}

	public void setActivares_prendadoVehiculoCliente(Boolean activares_prendadoVehiculoCliente) {
		this.activares_prendadoVehiculoCliente= activares_prendadoVehiculoCliente;
	}

	public Border setResaltarvalor_avaluoVehiculoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoClienteBeanSwingJInternalFrame vehiculoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vehiculoclienteBeanSwingJInternalFrame.jTtoolBarVehiculoCliente.setBorder(borderResaltar);
		
		this.resaltarvalor_avaluoVehiculoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_avaluoVehiculoCliente() {
		return this.resaltarvalor_avaluoVehiculoCliente;
	}

	public void setResaltarvalor_avaluoVehiculoCliente(Border borderResaltar) {
		this.resaltarvalor_avaluoVehiculoCliente= borderResaltar;
	}

	public Boolean getMostrarvalor_avaluoVehiculoCliente() {
		return this.mostrarvalor_avaluoVehiculoCliente;
	}

	public void setMostrarvalor_avaluoVehiculoCliente(Boolean mostrarvalor_avaluoVehiculoCliente) {
		this.mostrarvalor_avaluoVehiculoCliente= mostrarvalor_avaluoVehiculoCliente;
	}

	public Boolean getActivarvalor_avaluoVehiculoCliente() {
		return this.activarvalor_avaluoVehiculoCliente;
	}

	public void setActivarvalor_avaluoVehiculoCliente(Boolean activarvalor_avaluoVehiculoCliente) {
		this.activarvalor_avaluoVehiculoCliente= activarvalor_avaluoVehiculoCliente;
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
		
		
		this.setMostraridVehiculoCliente(esInicial);
		this.setMostrarid_empresaVehiculoCliente(esInicial);
		this.setMostrarid_clienteVehiculoCliente(esInicial);
		this.setMostrarcodigoVehiculoCliente(esInicial);
		this.setMostrarmarcaVehiculoCliente(esInicial);
		this.setMostrarmodeloVehiculoCliente(esInicial);
		this.setMostrarplacaVehiculoCliente(esInicial);
		this.setMostraranioVehiculoCliente(esInicial);
		this.setMostrares_prendadoVehiculoCliente(esInicial);
		this.setMostrarvalor_avaluoVehiculoCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.ID)) {
				this.setMostraridVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.MARCA)) {
				this.setMostrarmarcaVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.MODELO)) {
				this.setMostrarmodeloVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.PLACA)) {
				this.setMostrarplacaVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.ANIO)) {
				this.setMostraranioVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.ESPRENDADO)) {
				this.setMostrares_prendadoVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.VALORAVALUO)) {
				this.setMostrarvalor_avaluoVehiculoCliente(esAsigna);
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
		
		
		this.setActivaridVehiculoCliente(esInicial);
		this.setActivarid_empresaVehiculoCliente(esInicial);
		this.setActivarid_clienteVehiculoCliente(esInicial);
		this.setActivarcodigoVehiculoCliente(esInicial);
		this.setActivarmarcaVehiculoCliente(esInicial);
		this.setActivarmodeloVehiculoCliente(esInicial);
		this.setActivarplacaVehiculoCliente(esInicial);
		this.setActivaranioVehiculoCliente(esInicial);
		this.setActivares_prendadoVehiculoCliente(esInicial);
		this.setActivarvalor_avaluoVehiculoCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.ID)) {
				this.setActivaridVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.CODIGO)) {
				this.setActivarcodigoVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.MARCA)) {
				this.setActivarmarcaVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.MODELO)) {
				this.setActivarmodeloVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.PLACA)) {
				this.setActivarplacaVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.ANIO)) {
				this.setActivaranioVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.ESPRENDADO)) {
				this.setActivares_prendadoVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.VALORAVALUO)) {
				this.setActivarvalor_avaluoVehiculoCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,VehiculoClienteBeanSwingJInternalFrame vehiculoclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridVehiculoCliente(esInicial);
		this.setResaltarid_empresaVehiculoCliente(esInicial);
		this.setResaltarid_clienteVehiculoCliente(esInicial);
		this.setResaltarcodigoVehiculoCliente(esInicial);
		this.setResaltarmarcaVehiculoCliente(esInicial);
		this.setResaltarmodeloVehiculoCliente(esInicial);
		this.setResaltarplacaVehiculoCliente(esInicial);
		this.setResaltaranioVehiculoCliente(esInicial);
		this.setResaltares_prendadoVehiculoCliente(esInicial);
		this.setResaltarvalor_avaluoVehiculoCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.ID)) {
				this.setResaltaridVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.MARCA)) {
				this.setResaltarmarcaVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.MODELO)) {
				this.setResaltarmodeloVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.PLACA)) {
				this.setResaltarplacaVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.ANIO)) {
				this.setResaltaranioVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.ESPRENDADO)) {
				this.setResaltares_prendadoVehiculoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(VehiculoClienteConstantesFunciones.VALORAVALUO)) {
				this.setResaltarvalor_avaluoVehiculoCliente(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,VehiculoClienteBeanSwingJInternalFrame vehiculoclienteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteVehiculoCliente=true;

	public Boolean getMostrarFK_IdClienteVehiculoCliente() {
		return this.mostrarFK_IdClienteVehiculoCliente;
	}

	public void setMostrarFK_IdClienteVehiculoCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteVehiculoCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaVehiculoCliente=true;

	public Boolean getMostrarFK_IdEmpresaVehiculoCliente() {
		return this.mostrarFK_IdEmpresaVehiculoCliente;
	}

	public void setMostrarFK_IdEmpresaVehiculoCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaVehiculoCliente= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteVehiculoCliente=true;

	public Boolean getActivarFK_IdClienteVehiculoCliente() {
		return this.activarFK_IdClienteVehiculoCliente;
	}

	public void setActivarFK_IdClienteVehiculoCliente(Boolean habilitarResaltar) {
		this.activarFK_IdClienteVehiculoCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaVehiculoCliente=true;

	public Boolean getActivarFK_IdEmpresaVehiculoCliente() {
		return this.activarFK_IdEmpresaVehiculoCliente;
	}

	public void setActivarFK_IdEmpresaVehiculoCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaVehiculoCliente= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteVehiculoCliente=null;

	public Border getResaltarFK_IdClienteVehiculoCliente() {
		return this.resaltarFK_IdClienteVehiculoCliente;
	}

	public void setResaltarFK_IdClienteVehiculoCliente(Border borderResaltar) {
		this.resaltarFK_IdClienteVehiculoCliente= borderResaltar;
	}

	public void setResaltarFK_IdClienteVehiculoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoClienteBeanSwingJInternalFrame vehiculoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteVehiculoCliente= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaVehiculoCliente=null;

	public Border getResaltarFK_IdEmpresaVehiculoCliente() {
		return this.resaltarFK_IdEmpresaVehiculoCliente;
	}

	public void setResaltarFK_IdEmpresaVehiculoCliente(Border borderResaltar) {
		this.resaltarFK_IdEmpresaVehiculoCliente= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaVehiculoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*VehiculoClienteBeanSwingJInternalFrame vehiculoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaVehiculoCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}